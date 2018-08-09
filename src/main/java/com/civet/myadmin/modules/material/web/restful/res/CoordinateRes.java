package com.civet.myadmin.modules.material.web.restful.res;

import com.civet.myadmin.modules.material.entity.detail.MaterialDetail;

public class CoordinateRes extends BaseRes{
    private MaterialDetail materialDetail;

    public MaterialDetail getMaterialDetail() {
        return materialDetail;
    }

    public void setMaterialDetail(MaterialDetail materialDetail) {
        this.materialDetail = materialDetail;
    }
}
