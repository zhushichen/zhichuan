package com.civet.myadmin.modules.material.web.restful.req;

public class CoordinatesDetailReq extends BaseReq {
    private int id;

    public CoordinatesDetailReq(){
        super.setMsgCode("CoordinatesDetail");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
