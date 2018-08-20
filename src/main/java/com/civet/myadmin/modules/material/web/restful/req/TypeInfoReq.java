package com.civet.myadmin.modules.material.web.restful.req;

public class TypeInfoReq extends BaseReq{
    private int id;

    public TypeInfoReq() {
        super.setMsgCode("typeInfo");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
