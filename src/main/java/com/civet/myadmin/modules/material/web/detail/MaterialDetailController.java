/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.web.detail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.civet.myadmin.modules.material.entity.type.MaterialType;
import com.civet.myadmin.modules.material.service.type.MaterialTypeService;
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
import com.civet.myadmin.modules.material.entity.detail.MaterialDetail;
import com.civet.myadmin.modules.material.service.detail.MaterialDetailService;

import java.util.HashMap;
import java.util.List;

/**
 * 物料类型Controller
 * @author likai
 * @version 2018-08-08
 */
@Controller
@RequestMapping(value = "${adminPath}/material/detail/materialDetail")
public class MaterialDetailController extends BaseController {

	@Autowired
	private MaterialDetailService materialDetailService;

	@Autowired
	private MaterialTypeService materialTypeService;

	@RequiresPermissions("material:detail:materialDetail:view")
	@RequestMapping(value = {"list", ""})
	public String list(MaterialDetail materialDetail, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MaterialDetail> page = materialDetailService.findPage(new Page<MaterialDetail>(request, response), materialDetail); 
		model.addAttribute("page", page);
		return "modules/material/detail/materialDetailList";
	}

	@RequiresPermissions("material:detail:materialDetail:view")
	@RequestMapping(value = "form")
	public String form(MaterialDetail materialDetail, Model model) {
	    if (materialDetail.getId() != null){
            materialDetail = materialDetailService.get(materialDetail.getId());
        }

		List<MaterialType> materialTypes = materialTypeService.findList(null);
		HashMap<String,String> typeMap = new HashMap<>();
		for(MaterialType materialType:materialTypes){
			typeMap.put(materialType.getCode(),materialType.getDetail());
		}
		model.addAttribute("materialTypeMap", typeMap);
		model.addAttribute("materialDetail", materialDetail);
		return "modules/material/detail/materialDetailForm";
	}

	@RequiresPermissions("material:detail:materialDetail:edit")
	@RequestMapping(value = "save")
	public String save(MaterialDetail materialDetail, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, materialDetail)){
			return form(materialDetail, model);
		}
		materialDetailService.save(materialDetail);
		addMessage(redirectAttributes, "保存物料信息成功");
		return "redirect:"+Global.getAdminPath()+"/material/detail/materialDetail/?repage";
	}
	
	@RequiresPermissions("material:detail:materialDetail:edit")
	@RequestMapping(value = "delete")
	public String delete(MaterialDetail materialDetail, RedirectAttributes redirectAttributes) {
		materialDetailService.delete(materialDetail);
		addMessage(redirectAttributes, "删除物料信息成功");
		return "redirect:"+Global.getAdminPath()+"/material/detail/materialDetail/?repage";
	}

}