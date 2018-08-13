package com.civet.myadmin.modules.material.web.restful.res;

import com.civet.myadmin.modules.material.web.restful.LoginUser;

public class LoginRes extends BaseRes{
    private LoginUser loginUser;

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }
}
