package com.civet.myadmin.modules.material.web.restful.req;

public class CoordinatesPerRoadReq extends BaseReq {
    private int roadId;

    public CoordinatesPerRoadReq(){
        super.setMsgCode("CoordinatesPerRoad");
    }
    public int getRoadId() {
        return roadId;
    }

    public void setRoadId(int roadId) {
        this.roadId = roadId;
    }
}
