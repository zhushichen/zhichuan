package com.civet.myadmin.modules.material.web.restful.req;

import com.civet.myadmin.modules.material.entity.detail.MaterialDetail;

public class CoordinateReq extends BaseReq{
    private MaterialDetail materialDetail;

    public CoordinateReq() {
        super.setMsgCode("CoordinatesSave");
    }

    public MaterialDetail getMaterialDetail() {
        return materialDetail;
    }

    public void setMaterialDetail(MaterialDetail materialDetail) {
        this.materialDetail = materialDetail;
    }
}
