/**
 * Copyright &copy; 2012-2016 Civet All rights reserved.
 */
package com.civet.myadmin.modules.gen.dao;

import java.util.List;

import com.civet.myadmin.common.persistence.annotation.MyBatisDao;
import com.civet.myadmin.modules.gen.entity.GenTable;
import com.civet.myadmin.modules.gen.entity.GenTableColumn;
import com.civet.myadmin.common.persistence.CrudDao;

/**
 * 业务表字段DAO接口
 * @author PlamCivet
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenDataBaseDictDao extends CrudDao<GenTableColumn> {

	/**
	 * 查询表列表
	 * @param genTable
	 * @return
	 */
	List<GenTable> findTableList(GenTable genTable);

	/**
	 * 获取数据表字段
	 * @param genTable
	 * @return
	 */
	List<GenTableColumn> findTableColumnList(GenTable genTable);
	
	/**
	 * 获取数据表主键
	 * @param genTable
	 * @return
	 */
	List<String> findTablePK(GenTable genTable);
	
}
