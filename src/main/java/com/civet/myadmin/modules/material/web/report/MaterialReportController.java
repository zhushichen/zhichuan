/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.web.report;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.civet.myadmin.modules.material.entity.detail.MaterialDetail;
import com.civet.myadmin.modules.material.entity.road.MaterialRoad;
import com.civet.myadmin.modules.material.entity.type.MaterialType;
import com.civet.myadmin.modules.material.service.detail.MaterialDetailService;
import com.civet.myadmin.modules.material.service.road.MaterialRoadService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.civet.myadmin.common.config.Global;
import com.civet.myadmin.common.persistence.Page;
import com.civet.myadmin.common.web.BaseController;
import com.civet.myadmin.common.utils.StringUtils;
import com.civet.myadmin.modules.material.entity.report.MaterialReport;
import com.civet.myadmin.modules.material.service.report.MaterialReportService;

import java.util.HashMap;
import java.util.List;

/**
 * 台账Controller
 * @author likai
 * @version 2018-08-21
 */
@Controller
@RequestMapping(value = "${adminPath}/material/report/materialReport")
public class MaterialReportController extends BaseController {

	@Autowired
	private MaterialReportService materialReportService;

    @Autowired
    private MaterialRoadService materialRoadService;

    @Autowired
    private MaterialDetailService materialDetailService;
	
	@RequiresPermissions("material:report:materialReport:view")
	@RequestMapping(value = {"list", ""})
	public String list(MaterialReport materialReport, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MaterialReport> page = materialReportService.findPage(new Page<MaterialReport>(request, response), materialReport);

		 /*
        将roadId转为road名字,typeId转为type名字
         */
        HashMap<Integer,String> roadMap = new HashMap<>();
        List<MaterialRoad> materialRoads = materialRoadService.findList(new MaterialRoad());
        for(MaterialRoad materialRoad : materialRoads){
            roadMap.put(materialRoad.getId(), materialRoad.getName());
        }

        List<MaterialReport> materialReports = page.getList();
        for(MaterialReport m : materialReports){
            String roadName = roadMap.get(m.getRoadid());
            m.setRoadName(roadName);
        }
		model.addAttribute("page", page);
		return "modules/material/report/materialReportList";
	}

	@RequiresPermissions("material:report:materialReport:view")
	@RequestMapping(value = "form")
	public String form(MaterialReport materialReport, Model model) {
	    if (materialReport.getId() != null){
            materialReport = materialReportService.get(materialReport.getId());
        }

        List<MaterialRoad> materialRoads = materialRoadService.findList(new MaterialRoad());
        HashMap<Integer,String> roadMap = new HashMap<>();
        for(MaterialRoad materialRoad: materialRoads){
            roadMap.put(materialRoad.getId(),materialRoad.getName());
        }

        HashMap<Integer,String> pointMap = new HashMap<>();
        List<MaterialDetail> materialDetails = materialDetailService.findList(new MaterialDetail());
        for(MaterialDetail materialDetail: materialDetails){
            pointMap.put(materialDetail.getId(), materialDetail.getName());
        }
        model.addAttribute("roadMap", roadMap);
        model.addAttribute("pointMap", pointMap);
		model.addAttribute("materialReport", materialReport);
		return "modules/material/report/materialReportForm";
	}

	@RequiresPermissions("material:report:materialReport:edit")
	@RequestMapping(value = "save")
	public String save(MaterialReport materialReport, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, materialReport)){
			return form(materialReport, model);
		}
        /**
         * 台账去重，保证一个坐标只有一个台账
         */
        MaterialReport mp = materialReportService.getReportByPointId(materialReport.getPointid());
        if(mp != null){
            addMessage(redirectAttributes, "保存台账失败, 该坐标已有台账");
        }else{
            materialReportService.save(materialReport);
            addMessage(redirectAttributes, "保存台账成功");
        }

		return "redirect:"+Global.getAdminPath()+"/material/report/materialReport/?repage";
	}
	
	@RequiresPermissions("material:report:materialReport:edit")
	@RequestMapping(value = "delete")
	public String delete(MaterialReport materialReport, RedirectAttributes redirectAttributes) {
		materialReportService.delete(materialReport);
		addMessage(redirectAttributes, "删除台账成功");
		return "redirect:"+Global.getAdminPath()+"/material/report/materialReport/?repage";
	}

    @RequestMapping(value = "getPointByRoad")
    @ResponseBody
    public List<MaterialDetail> getPointByRoad(int roadId) {

        List<MaterialDetail> materialDetails =  materialDetailService.getPointByRoad(roadId);

       return materialDetails;
    }

    @RequestMapping(value = "getRoadId")
    @ResponseBody
    public MaterialRoad getRoadId(int roadId) {

        MaterialRoad materialRoad =  materialRoadService.get(roadId);

        return materialRoad;
    }
}