/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.web.restful;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.civet.myadmin.common.config.Global;
import com.civet.myadmin.common.persistence.Page;
import com.civet.myadmin.common.web.BaseController;
import com.civet.myadmin.modules.material.entity.detail.MaterialDetail;
import com.civet.myadmin.modules.material.entity.road.MaterialRoad;
import com.civet.myadmin.modules.material.entity.type.MaterialType;
import com.civet.myadmin.modules.material.service.detail.MaterialDetailService;
import com.civet.myadmin.modules.material.service.road.MaterialRoadService;
import com.civet.myadmin.modules.material.service.type.MaterialTypeService;
import com.civet.myadmin.modules.material.web.restful.req.BaseReq;
import com.civet.myadmin.modules.material.web.restful.req.RoadListReq;
import com.civet.myadmin.modules.material.web.restful.res.BaseRes;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public BaseRes dispatch(@RequestBody BaseReq req) {
		String msgCode = req.getMsgCode();
		if("roadList".equals(msgCode)){
			RoadListReq roadListReq = JSON.parseObject(req.getObject(), RoadListReq.class);
			return materialRoadService.roadList(roadListReq);
		}
		return null;
	}

//	@RequestMapping(value = "rest_list")
//	@ResponseBody
//	public Map<String, Object> rest_list(@RequestParam("Req") String req) {
//		Map<String, Object> map = JSON.parseObject(req, new TypeReference<Map<String, Object>>(){});
//		int pageNo = (int) map.get("pageNo");
//		int pageSize = (int) map.get("pageSize");
//		Page<MaterialRoad> page = materialRoadService.findPage(new Page<MaterialRoad>(pageNo, pageSize), new MaterialRoad());
//		Map<String, Object> result = new HashMap<>();
//		result.put("retCode", 0);
//		result.put("retMsg", "");
//		result.put("list",page.getList());
//		return result;
//	}
}