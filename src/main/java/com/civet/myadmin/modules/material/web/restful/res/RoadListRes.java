package com.civet.myadmin.modules.material.web.restful.res;

import com.civet.myadmin.modules.material.entity.road.MaterialRoad;

import java.util.List;

public class RoadListRes extends BaseRes{
    public List<MaterialRoad> getRoad() {
        return road;
    }

    public void setRoad(List<MaterialRoad> road) {
        this.road = road;
    }

    private List<MaterialRoad> road;
}
