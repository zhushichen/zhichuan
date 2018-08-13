package com.civet.myadmin.modules.material.web.restful.res;

import com.civet.myadmin.modules.material.entity.type.MaterialType;

import java.util.List;

public class TypeListRes extends BaseRes{
  private List<MaterialType> list;

    public List<MaterialType> getList() {
        return list;
    }

    public void setList(List<MaterialType> list) {
        this.list = list;
    }
}
