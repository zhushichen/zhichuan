/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.service.report;

import java.util.List;

import com.civet.myadmin.modules.material.web.restful.req.ReportInfoReq;
import com.civet.myadmin.modules.material.web.restful.res.BaseRes;
import com.civet.myadmin.modules.material.web.restful.res.ReportInfoRes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.civet.myadmin.common.persistence.Page;
import com.civet.myadmin.common.service.CrudService;
import com.civet.myadmin.modules.material.entity.report.MaterialReport;
import com.civet.myadmin.modules.material.dao.report.MaterialReportDao;

/**
 * 台账Service
 * @author likai
 * @version 2018-08-20
 */
@Service
@Transactional(readOnly = true)
public class MaterialReportService extends CrudService<MaterialReportDao, MaterialReport> {

	public MaterialReport get(Integer id) {
		return super.get(id);
	}
	
	public List<MaterialReport> findList(MaterialReport materialReport) {
		return super.findList(materialReport);
	}
	
	public Page<MaterialReport> findPage(Page<MaterialReport> page, MaterialReport materialReport) {
		return super.findPage(page, materialReport);
	}
	
	@Transactional(readOnly = false)
	public void save(MaterialReport materialReport) {
		super.save(materialReport);
	}
	
	@Transactional(readOnly = false)
	public void delete(MaterialReport materialReport) {
		super.delete(materialReport);
	}

    public BaseRes getByPointId(ReportInfoReq reportInfoReq) {
        ReportInfoRes reportInfoRes = new ReportInfoRes();
        int pointId = reportInfoReq.getPointId();
        try{
            MaterialReport materialReport = dao.getReportByPointId(pointId);
            reportInfoRes.setMaterialReport(materialReport);
            reportInfoRes.setRetCode(0);
            reportInfoRes.setRetMsg("");
        }catch (Exception e){
            reportInfoRes.setRetCode(999);
            reportInfoRes.setRetMsg(e.getMessage());
        }
        return reportInfoRes;
    }
}