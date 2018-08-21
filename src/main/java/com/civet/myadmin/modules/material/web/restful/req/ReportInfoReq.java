package com.civet.myadmin.modules.material.web.restful.req;

public class ReportInfoReq extends BaseReq{
    private int PointId;

    public ReportInfoReq() {
        super.setMsgCode("reportInfo");
    }

    public int getPointId() {
        return PointId;
    }

    public void setPointId(int pointId) {
        PointId = pointId;
    }
}
