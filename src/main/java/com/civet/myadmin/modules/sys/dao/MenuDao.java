/**
 * Copyright &copy; 2012-2016 Civet All rights reserved.
 */
package com.civet.myadmin.modules.sys.dao;

import java.util.List;

import com.civet.myadmin.common.persistence.CrudDao;
import com.civet.myadmin.common.persistence.annotation.MyBatisDao;
import com.civet.myadmin.modules.sys.entity.Menu;

/**
 * 菜单DAO接口
 * @author PlamCivet
 * @version 2014-05-16
 */
@MyBatisDao
public interface MenuDao extends CrudDao<Menu> {

	public List<Menu> findByParentIdsLike(Menu menu);

	public List<Menu> findByUserId(Menu menu);
	
	public int updateParentIds(Menu menu);
	
	public int updateSort(Menu menu);
	
}
