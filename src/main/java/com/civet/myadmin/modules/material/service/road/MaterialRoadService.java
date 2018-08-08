/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.service.road;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.civet.myadmin.common.persistence.Page;
import com.civet.myadmin.common.service.CrudService;
import com.civet.myadmin.modules.material.entity.road.MaterialRoad;
import com.civet.myadmin.modules.material.dao.road.MaterialRoadDao;

/**
 * 路线Service
 * @author likai
 * @version 2018-08-08
 */
@Service
@Transactional(readOnly = true)
public class MaterialRoadService extends CrudService<MaterialRoadDao, MaterialRoad> {

	public MaterialRoad get(Integer id) {
		return super.get(id);
	}
	
	public List<MaterialRoad> findList(MaterialRoad materialRoad) {
		return super.findList(materialRoad);
	}
	
	public Page<MaterialRoad> findPage(Page<MaterialRoad> page, MaterialRoad materialRoad) {
		return super.findPage(page, materialRoad);
	}
	
	@Transactional(readOnly = false)
	public void save(MaterialRoad materialRoad) {
		super.save(materialRoad);
	}
	
	@Transactional(readOnly = false)
	public void delete(MaterialRoad materialRoad) {
		super.delete(materialRoad);
	}
	
}