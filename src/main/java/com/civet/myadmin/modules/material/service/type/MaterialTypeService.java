/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.service.type;

import java.util.List;

import com.civet.myadmin.modules.material.web.restful.req.TypeInfoReq;
import com.civet.myadmin.modules.material.web.restful.res.BaseRes;
import com.civet.myadmin.modules.material.web.restful.res.TypeInfoRes;
import com.civet.myadmin.modules.material.web.restful.res.TypeListRes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.civet.myadmin.common.persistence.Page;
import com.civet.myadmin.common.service.CrudService;
import com.civet.myadmin.modules.material.entity.type.MaterialType;
import com.civet.myadmin.modules.material.dao.type.MaterialTypeDao;

/**
 * 物料类型Service
 * @author likai
 * @version 2018-08-14
 */
@Service
@Transactional(readOnly = true)
public class MaterialTypeService extends CrudService<MaterialTypeDao, MaterialType> {

	public MaterialType get(Integer id) {
		return super.get(id);
	}
	
	public List<MaterialType> findList(MaterialType materialType) {
		return super.findList(materialType);
	}
	
	public Page<MaterialType> findPage(Page<MaterialType> page, MaterialType materialType) {
		return super.findPage(page, materialType);
	}
	
	@Transactional(readOnly = false)
	public void save(MaterialType materialType) {
		super.save(materialType);
	}
	
	@Transactional(readOnly = false)
	public void delete(MaterialType materialType) {
		super.delete(materialType);
	}
	
	public BaseRes typeList() {
        List<MaterialType> list = this.findList(new MaterialType());
        TypeListRes typeListRes = new TypeListRes();
        typeListRes.setRetCode(0);
        typeListRes.setRetMsg("");
        typeListRes.setList(list);
        return typeListRes;
    }

    public BaseRes getTypeInfo(TypeInfoReq typeInfoReq) {
            int id = typeInfoReq.getId();
            TypeInfoRes typeInfoRes = new TypeInfoRes();
            typeInfoRes.setRetCode(0);
            typeInfoRes.setRetMsg("");
            MaterialType materialType = this.get(id);
            typeInfoRes.setMaterialType(materialType);
            return typeInfoRes;
    }
}