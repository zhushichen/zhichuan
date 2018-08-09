package com.civet.myadmin.modules.material.web.restful.res;

import com.civet.myadmin.modules.material.entity.detail.MaterialDetail;

import java.util.List;

public class CoordinatesPerRoadRes extends BaseRes {
    public List<MaterialDetail> getList() {
        return list;
    }

    public void setList(List<MaterialDetail> list) {
        this.list = list;
    }

    private List<MaterialDetail> list;

}
