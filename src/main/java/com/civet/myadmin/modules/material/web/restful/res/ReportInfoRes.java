package com.civet.myadmin.modules.material.web.restful.res;

import com.civet.myadmin.modules.material.entity.report.MaterialReport;

public class ReportInfoRes extends BaseRes{
    private MaterialReport materialReport;

    public MaterialReport getMaterialReport() {
        return materialReport;
    }

    public void setMaterialReport(MaterialReport materialReport) {
        this.materialReport = materialReport;
    }
}
