/**
 * Copyright &copy; 2012-2016 Civet All rights reserved.
 */
package com.civet.myadmin.modules.cms.dao;

import com.civet.myadmin.common.persistence.CrudDao;
import com.civet.myadmin.common.persistence.annotation.MyBatisDao;
import com.civet.myadmin.modules.cms.entity.Site;

/**
 * 站点DAO接口
 * @author PlamCivet
 * @version 2013-8-23
 */
@MyBatisDao
public interface SiteDao extends CrudDao<Site> {

}
