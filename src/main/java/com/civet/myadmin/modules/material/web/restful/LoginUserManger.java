package com.civet.myadmin.modules.material.web.restful;

import com.civet.myadmin.modules.material.web.restful.req.LoginReq;
import com.civet.myadmin.modules.material.web.restful.res.BaseRes;
import com.civet.myadmin.modules.material.web.restful.res.LoginRes;
import com.civet.myadmin.modules.sys.entity.User;
import com.civet.myadmin.modules.sys.security.SystemAuthorizingRealm;
import com.civet.myadmin.modules.sys.security.UsernamePasswordToken;
import com.civet.myadmin.modules.sys.service.SystemService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

@Service
public class LoginUserManger {

    @Autowired
    private SystemService systemService;

    private  HashMap<String, LoginUser> tokenMap = new HashMap<>();
    private  HashMap<Integer, LoginUser> idMap = new HashMap<>();


    public  String generateToken(){
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] =  md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public  BaseRes login(LoginReq loginReq){
        LoginRes loginRes = new LoginRes();
        try {
            String username = loginReq.getName();
            String password = loginReq.getPassword();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray(), false,  "", "", false);
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.login(token);
            if(currentUser.isAuthenticated()){
                SystemAuthorizingRealm.Principal principal = (SystemAuthorizingRealm.Principal) currentUser.getPrincipal();
                int userId = principal.getId();
                /**
                 * 如果已经登录了，踢掉已登录的
                 */
                LoginUser loginUser = null;
                synchronized (idMap){
                    loginUser = idMap.remove(userId);
                }
                if(loginUser != null){
                    synchronized(tokenMap){
                        tokenMap.remove(loginUser.getToken());
                    }
                }
                LoginUser newLoginUser = new LoginUser();
                newLoginUser.setId(userId);

                String app_token = generateToken();
                newLoginUser.setToken(app_token);

                Date loginDate = new Date();
                newLoginUser.setLoginDate(loginDate);
                newLoginUser.setActiveTime(loginDate);

                User user = systemService.getUserByLoginName(username);
                newLoginUser.setPhoto(user.getPhoto());
                newLoginUser.setUserName(principal.getLoginName());
                synchronized(tokenMap){
                    tokenMap.put(app_token, newLoginUser);
                }

                synchronized (idMap){
                    idMap.put(userId, newLoginUser);
                }

                loginRes.setLoginUser(newLoginUser);
                loginRes.setRetCode(0);
                loginRes.setRetMsg("");
            }else{
                token.clear();
                loginRes.setRetCode(901);
                loginRes.setRetMsg("用户不允许登录");
            }
        }catch (Exception e){
            loginRes.setRetMsg("登录失败");
            loginRes.setRetCode(999);
        }
        return loginRes;
    }


    /**
     * 获取在线的用户
     * @param token
     * @return
     */
    public LoginUser getOnlineUser(String token) {
        LoginUser loginUser = tokenMap.get(token);
        if (loginUser != null) {
            loginUser.setActiveTime(new Date());
        }
        return loginUser;
    }

    public BaseRes loginOut(String token) {
        /**
         * -1 避免误删
         */
        LoginUser user = tokenMap.get(token);
        if(user == null){
            BaseRes baseRes = new BaseRes(990, "token失效");
            return baseRes;
        }else{
            synchronized (tokenMap) {
                tokenMap.remove(token);
            }
            synchronized (idMap) {
                idMap.remove(user.getId());
            }
            BaseRes baseRes = new BaseRes(0, "");
            return baseRes;
        }
    }

    public LoginUser getUser(String token){
        return tokenMap.get(token);
    }
}
