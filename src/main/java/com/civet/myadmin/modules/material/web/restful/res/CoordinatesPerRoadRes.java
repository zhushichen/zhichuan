package com.civet.myadmin.modules.material.web.restful.res;

import com.civet.myadmin.modules.material.entity.detail.MaterialDetail;

import java.util.List;
import java.util.Map;

public class CoordinatesPerRoadRes extends BaseRes {


    private Map<String, List<MaterialDetail>> result;

    public Map<String, List<MaterialDetail>> getResult() {
        return result;
    }

    public void setResult(Map<String, List<MaterialDetail>> result) {
        this.result = result;
    }
}
