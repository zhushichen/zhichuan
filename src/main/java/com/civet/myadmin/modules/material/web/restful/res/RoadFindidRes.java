package com.civet.myadmin.modules.material.web.restful.res;
import com.civet.myadmin.modules.material.entity.road.MaterialRoad;

public class RoadFindidRes extends BaseRes{
    private MaterialRoad materialRoad;

    public MaterialRoad getMaterialRoad() {
        return materialRoad;
    }

    public void setMaterialRoad(MaterialRoad materialRoad) {
        this.materialRoad = materialRoad;
    }
}
