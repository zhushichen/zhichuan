/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.dao.type;

import com.civet.myadmin.common.persistence.CrudDao;
import com.civet.myadmin.common.persistence.annotation.MyBatisDao;
import com.civet.myadmin.modules.material.entity.type.MaterialType;

/**
 * 物料类型DAO接口
 * @author likai
 * @version 2018-08-08
 */
@MyBatisDao
public interface MaterialTypeDao extends CrudDao<MaterialType> {
	
}