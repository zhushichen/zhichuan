/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.web.type;

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
import com.civet.myadmin.modules.material.entity.type.MaterialType;
import com.civet.myadmin.modules.material.service.type.MaterialTypeService;

/**
 * 物料类型Controller
 * @author likai
 * @version 2018-08-08
 */
@Controller
@RequestMapping(value = "${adminPath}/material/type/materialType")
public class MaterialTypeController extends BaseController {

	@Autowired
	private MaterialTypeService materialTypeService;
	
	@RequiresPermissions("material:type:materialType:view")
	@RequestMapping(value = {"list", ""})
	public String list(MaterialType materialType, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MaterialType> page = materialTypeService.findPage(new Page<MaterialType>(request, response), materialType); 
		model.addAttribute("page", page);
		return "modules/material/type/materialTypeList";
	}

	@RequiresPermissions("material:type:materialType:view")
	@RequestMapping(value = "form")
	public String form(MaterialType materialType, Model model) {
	    if (materialType.getId() != null){
            materialType = materialTypeService.get(materialType.getId());
        }
		model.addAttribute("materialType", materialType);
		return "modules/material/type/materialTypeForm";
	}

	@RequiresPermissions("material:type:materialType:edit")
	@RequestMapping(value = "save")
	public String save(MaterialType materialType, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, materialType)){
			return form(materialType, model);
		}
		materialTypeService.save(materialType);
		addMessage(redirectAttributes, "保存物料类型成功");
		return "redirect:"+Global.getAdminPath()+"/material/type/materialType/?repage";
	}
	
	@RequiresPermissions("material:type:materialType:edit")
	@RequestMapping(value = "delete")
	public String delete(MaterialType materialType, RedirectAttributes redirectAttributes) {
		materialTypeService.delete(materialType);
		addMessage(redirectAttributes, "删除物料类型成功");
		return "redirect:"+Global.getAdminPath()+"/material/type/materialType/?repage";
	}

}