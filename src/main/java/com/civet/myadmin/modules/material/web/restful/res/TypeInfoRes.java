package com.civet.myadmin.modules.material.web.restful.res;

import com.civet.myadmin.modules.material.entity.type.MaterialType;

public class TypeInfoRes extends BaseRes{
  private MaterialType materialType;

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }
}
