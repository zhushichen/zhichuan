/**
 * Copyright &copy; 2012-2016 Civet All rights reserved.
 */
package com.civet.myadmin.modules.cms.service;

import com.civet.myadmin.modules.cms.entity.ArticleData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.civet.myadmin.common.service.CrudService;
import com.civet.myadmin.modules.cms.dao.ArticleDataDao;

/**
 * 站点Service
 * @author PlamCivet
 * @version 2013-01-15
 */
@Service
@Transactional(readOnly = true)
public class ArticleDataService extends CrudService<ArticleDataDao, ArticleData> {

}
