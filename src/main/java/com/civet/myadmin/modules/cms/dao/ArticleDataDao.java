/**
 * Copyright &copy; 2012-2016 Civet All rights reserved.
 */
package com.civet.myadmin.modules.cms.dao;

import com.civet.myadmin.common.persistence.annotation.MyBatisDao;
import com.civet.myadmin.modules.cms.entity.ArticleData;
import com.civet.myadmin.common.persistence.CrudDao;

/**
 * 文章DAO接口
 * @author PlamCivet
 * @version 2013-8-23
 */
@MyBatisDao
public interface ArticleDataDao extends CrudDao<ArticleData> {
	
}
