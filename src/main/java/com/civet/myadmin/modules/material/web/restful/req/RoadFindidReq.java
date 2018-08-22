package com.civet.myadmin.modules.material.web.restful.req;

public class RoadFindidReq extends BaseReq{
    private int RoId;

    public RoadFindidReq() {
        super.setMsgCode("reportInfo");
    }

    public int getRoId() {
        return RoId;
    }

    public void setRoId(int roId) {
        RoId = roId;
    }
}
