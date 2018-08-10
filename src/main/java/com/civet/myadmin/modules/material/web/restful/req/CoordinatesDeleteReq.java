package com.civet.myadmin.modules.material.web.restful.req;

public class CoordinatesDeleteReq extends BaseReq {
    private int id;

    public CoordinatesDeleteReq(){
        super.setMsgCode("CoordinatesDelete");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
