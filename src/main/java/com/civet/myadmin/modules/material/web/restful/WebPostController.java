/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.web.restful;

import com.alibaba.fastjson.JSONObject;
import com.civet.myadmin.common.web.BaseController;
import com.civet.myadmin.modules.material.service.detail.MaterialDetailService;
import com.civet.myadmin.modules.material.service.road.MaterialRoadService;
import com.civet.myadmin.modules.material.service.type.MaterialTypeService;
import com.civet.myadmin.modules.material.web.restful.req.CoordinateReq;
import com.civet.myadmin.modules.material.web.restful.req.CoordinatesPerRoadReq;
import com.civet.myadmin.modules.material.web.restful.res.BaseRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Console;

/**
 * 物料类型Controller
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

	@RequestMapping(value = "")
	@ResponseBody
	public BaseRes dispatch(String data) {
        JSONObject jsonObject = MsgEncodeUtil.msgObjDecode(data);
        logger.info("请求消息：" + jsonObject.toJSONString());
        String msgCode = jsonObject.getString("msgCode");
		if("roadList".equals(msgCode)){
			return materialRoadService.roadList();
		}else if("CoordinatesPerRoad".equals(msgCode)){
            CoordinatesPerRoadReq coordinatesPerRoadReq = JSONObject.toJavaObject(jsonObject, CoordinatesPerRoadReq.class);
		    return materialDetailService.CoordinatesPerRoad(coordinatesPerRoadReq.getRoadId());
        }else if("Coordinate".equals(msgCode)){
            CoordinateReq coordinateReq = JSONObject.toJavaObject(jsonObject, CoordinateReq.class);
            return materialDetailService.saveCoordinate(coordinateReq);
        }
		return null;
	}
}