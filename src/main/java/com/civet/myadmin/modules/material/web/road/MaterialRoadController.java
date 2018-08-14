/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.web.road;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.civet.myadmin.common.config.Global;
import com.civet.myadmin.common.persistence.Page;
import com.civet.myadmin.common.web.BaseController;
import com.civet.myadmin.common.utils.StringUtils;
import com.civet.myadmin.modules.material.entity.road.MaterialRoad;
import com.civet.myadmin.modules.material.service.road.MaterialRoadService;

/**
 * 路线Controller
 * @author likai
 * @version 2018-08-14
 */
@Controller
@RequestMapping(value = "${adminPath}/material/road/materialRoad")
public class MaterialRoadController extends BaseController {

	@Autowired
	private MaterialRoadService materialRoadService;
	
	@RequiresPermissions("material:road:materialRoad:view")
	@RequestMapping(value = {"list", ""})
	public String list(MaterialRoad materialRoad, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MaterialRoad> page = materialRoadService.findPage(new Page<MaterialRoad>(request, response), materialRoad); 
		model.addAttribute("page", page);
		return "modules/material/road/materialRoadList";
	}

	@RequiresPermissions("material:road:materialRoad:view")
	@RequestMapping(value = "form")
	public String form(MaterialRoad materialRoad, Model model) {
	    if (materialRoad.getId() != null){
            materialRoad = materialRoadService.get(materialRoad.getId());
        }
		model.addAttribute("materialRoad", materialRoad);
		return "modules/material/road/materialRoadForm";
	}

	@RequiresPermissions("material:road:materialRoad:edit")
	@RequestMapping(value = "save")
	public String save(MaterialRoad materialRoad, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, materialRoad)){
			return form(materialRoad, model);
		}
		materialRoadService.save(materialRoad);
		addMessage(redirectAttributes, "保存路线成功");
		return "redirect:"+Global.getAdminPath()+"/material/road/materialRoad/?repage";
	}
	
	@RequiresPermissions("material:road:materialRoad:edit")
	@RequestMapping(value = "delete")
	public String delete(MaterialRoad materialRoad, RedirectAttributes redirectAttributes) {
		materialRoadService.delete(materialRoad);
		addMessage(redirectAttributes, "删除路线成功");
		return "redirect:"+Global.getAdminPath()+"/material/road/materialRoad/?repage";
	}

}