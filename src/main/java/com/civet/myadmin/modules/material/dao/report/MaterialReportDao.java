/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.dao.report;

import com.civet.myadmin.common.persistence.CrudDao;
import com.civet.myadmin.common.persistence.annotation.MyBatisDao;
import com.civet.myadmin.modules.material.entity.report.MaterialReport;

/**
 * 台账DAO接口
 * @author likai
 * @version 2018-08-20
 */
@MyBatisDao
public interface MaterialReportDao extends CrudDao<MaterialReport> {
	
}