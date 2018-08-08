/**
 * Copyright &copy; 2012-2013 Civet All rights reserved.
 */
package com.civet.myadmin.modules.sys.service;

import com.civet.myadmin.common.utils.DateUtils;
import com.civet.myadmin.modules.sys.dao.LogDao;
import com.civet.myadmin.modules.sys.entity.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.civet.myadmin.common.persistence.Page;
import com.civet.myadmin.common.service.CrudService;

/**
 * 日志Service
 * @author PlamCivet
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class LogService extends CrudService<LogDao, Log> {

	public Page<Log> findPage(Page<Log> page, Log log) {
		
		// 设置默认时间范围，默认当前月
		if (log.getBeginDate() == null){
			log.setBeginDate(DateUtils.setDays(DateUtils.parseDate(DateUtils.getDate()), 1));
		}
		if (log.getEndDate() == null){
			log.setEndDate(DateUtils.addMonths(log.getBeginDate(), 1));
		}
		
		return super.findPage(page, log);
		
	}
	
}
