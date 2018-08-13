package com.civet.myadmin.modules.material.web.restful.req;

import com.civet.myadmin.modules.material.entity.road.MaterialRoad;

public class RoadAddReq extends BaseReq{
    private MaterialRoad materialRoad;

    public RoadAddReq() {
        super.setMsgCode("roadAdd");
    }

    public MaterialRoad getMaterialRoad() {
        return materialRoad;
    }

    public void setMaterialRoad(MaterialRoad materialRoad) {
        this.materialRoad = materialRoad;
    }
}
