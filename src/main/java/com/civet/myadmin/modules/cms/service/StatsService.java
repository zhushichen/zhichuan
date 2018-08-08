/**
 * Copyright &copy; 2012-2016 Civet All rights reserved.
 */
package com.civet.myadmin.modules.cms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.civet.myadmin.common.utils.DateUtils;
import com.civet.myadmin.modules.cms.dao.ArticleDao;
import com.civet.myadmin.modules.cms.entity.Category;
import com.civet.myadmin.modules.cms.entity.Site;
import com.civet.myadmin.modules.sys.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.civet.myadmin.common.service.BaseService;

/**
 * 统计Service
 * @author PlamCivet
 * @version 2013-05-21
 */
@Service
@Transactional(readOnly = true)
public class StatsService extends BaseService {

	@Autowired
	private ArticleDao articleDao;
	
	public List<Category> article(Map<String, Object> paramMap) {
		Category category = new Category();
		
		Site site = new Site();
		site.setId(Site.getCurrentSiteId());
		category.setSite(site);
		
		Date beginDate = DateUtils.parseDate(paramMap.get("beginDate"));
		if (beginDate == null){
			beginDate = DateUtils.setDays(new Date(), 1);
			paramMap.put("beginDate", DateUtils.formatDate(beginDate, "yyyy-MM-dd"));
		}
		category.setBeginDate(beginDate);
		Date endDate = DateUtils.parseDate(paramMap.get("endDate"));
		if (endDate == null){
			endDate = DateUtils.addDays(DateUtils.addMonths(beginDate, 1), -1);
			paramMap.put("endDate", DateUtils.formatDate(endDate, "yyyy-MM-dd"));
		}
		category.setEndDate(endDate);

        Integer categoryId = (Integer)paramMap.get("categoryId");
		if (categoryId != null && !("".equals(categoryId))){
			category.setId(categoryId);
			category.setParentIds(""+categoryId);
		}

        Integer officeId = (Integer)(paramMap.get("officeId"));
		Office office = new Office();
		if (officeId != null && officeId > 0){
			office.setId(officeId);
		}else{
		}
		
		List<Category> list = articleDao.findStats(category);
		return list;
	}

}
