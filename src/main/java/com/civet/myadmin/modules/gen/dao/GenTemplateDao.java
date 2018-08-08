/**
 * Copyright &copy; 2012-2016 Civet All rights reserved.
 */
package com.civet.myadmin.modules.gen.dao;

import com.civet.myadmin.common.persistence.annotation.MyBatisDao;
import com.civet.myadmin.modules.gen.entity.GenTemplate;
import com.civet.myadmin.common.persistence.CrudDao;

/**
 * 代码模板DAO接口
 * @author PlamCivet
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenTemplateDao extends CrudDao<GenTemplate> {
	
}
