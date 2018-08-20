/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.web.restful;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.civet.myadmin.common.web.BaseController;
import com.civet.myadmin.modules.material.service.detail.MaterialDetailService;
import com.civet.myadmin.modules.material.service.road.MaterialRoadService;
import com.civet.myadmin.modules.material.service.type.MaterialTypeService;
import com.civet.myadmin.modules.material.web.restful.req.*;
import com.civet.myadmin.modules.material.web.restful.res.BaseRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 接口Controller
 *
 * @author likai
 * @version 2018-08-08
 */
@Controller
@RequestMapping(value = "/wp/json")
public class WebPostController extends BaseController {

    @Autowired
    private MaterialRoadService materialRoadService;

    @Autowired
    private MaterialDetailService materialDetailService;

    @Autowired
    private MaterialTypeService materialTypeService;

    @Autowired
    private LoginUserManger loginUserManger;

    @RequestMapping(value = "/material")
    @ResponseBody
    public BaseRes dispatch(String data) {
        JSONObject jsonObject;
        /**
         * app用，base64解密
         */

        /**
         * 本地测试用
         */

        try{
//            jsonObject = MsgEncodeUtil.msgObjDecode(data);
            jsonObject = JSONObject.parseObject(data);
        }catch (JSONException e){
            BaseRes res = new BaseRes(806, "参数不符合Json格式");
            return res;
        }
        logger.info("请求消息：" + jsonObject.toJSONString());

        /**
         * 没有msgCode
         */
        String msgCode = jsonObject.getString("msgCode");
        if (msgCode == null || "".equals(msgCode)) {
            BaseRes baseRes = new BaseRes(803, "缺少msgCode参数");
            return baseRes;
        }

        String token = jsonObject.getString("token");
        if (StringUtils.isBlank(token)) {
            /**
             * 无token情况下，只允许login与loginOut
             */
            if ("Login".equals(msgCode)) {
                LoginReq loginReq = JSONObject.toJavaObject(jsonObject, LoginReq.class);
                return loginUserManger.login(loginReq);
            } else{
                BaseRes baseRes = new BaseRes(805, "该接口需要token");
                return baseRes;
            }
        } else {
            /**
             * 校验token的有效性
             */
            LoginUser user = loginUserManger.getUser(token);
            if(user == null){
                BaseRes res = new BaseRes(901, "token失效");
                return res;
            }

            if ("roadList".equals(msgCode)) {
                return materialRoadService.roadList();
            } else if ("roadAdd".equals(msgCode)) {
                RoadAddReq roadAddReq = JSONObject.toJavaObject(jsonObject, RoadAddReq.class);
                return materialRoadService.roadSave(roadAddReq);
            } else if ("typeList".equals(msgCode)) {
                return materialTypeService.typeList();
            } else if ("CoordinatesPerRoad".equals(msgCode)) {
                CoordinatesPerRoadReq coordinatesPerRoadReq = JSONObject.toJavaObject(jsonObject, CoordinatesPerRoadReq.class);
                return materialDetailService.CoordinatesPerRoad(coordinatesPerRoadReq.getRoadId());
            } else if ("CoordinatesSave".equals(msgCode)) {
                CoordinateReq coordinateReq = JSONObject.toJavaObject(jsonObject, CoordinateReq.class);
                return materialDetailService.saveCoordinate(coordinateReq);
            } else if ("CoordinatesDelete".equals(msgCode)) {
                CoordinatesDeleteReq coordinateReq = JSONObject.toJavaObject(jsonObject, CoordinatesDeleteReq.class);
                return materialDetailService.deleteCoordinate(coordinateReq);
            } else if ("CoordinatesDetail".equals(msgCode)) {
                CoordinatesDetailReq coordinateReq = JSONObject.toJavaObject(jsonObject, CoordinatesDetailReq.class);
                return materialDetailService.getCoordinate(coordinateReq);
            } else if ("LoginOut".equals(msgCode)) {
                return loginUserManger.loginOut(token);
            } else if ("typeInfo".equals(msgCode)) {
                TypeInfoReq typeInfoReq = JSONObject.toJavaObject(jsonObject, TypeInfoReq.class);
                return materialTypeService.getTypeInfo(typeInfoReq);
            } else {
                BaseRes baseRes = new BaseRes(802, "该接口不存在");
                return baseRes;
            }

        }

    }
}