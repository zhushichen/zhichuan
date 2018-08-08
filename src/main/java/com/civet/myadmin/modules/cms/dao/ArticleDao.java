/**
 * Copyright &copy; 2012-2016 Civet All rights reserved.
 */
package com.civet.myadmin.modules.cms.dao;

import java.util.List;

import com.civet.myadmin.common.persistence.annotation.MyBatisDao;
import com.civet.myadmin.modules.cms.entity.Article;
import com.civet.myadmin.modules.cms.entity.Category;
import com.civet.myadmin.common.persistence.CrudDao;

/**
 * 文章DAO接口
 * @author PlamCivet
 * @version 2013-8-23
 */
@MyBatisDao
public interface ArticleDao extends CrudDao<Article> {
	
	public List<Article> findByIdIn(String[] ids);
//	{
//		return find("from Article where id in (:p1)", new Parameter(new Object[]{ids}));
//	}
	
	public int updateHitsAddOne(Integer id);
//	{
//		return update("update Article set hits=hits+1 where id = :p1", new Parameter(id));
//	}
	
	public int updateExpiredWeight(Article article);
	
	public List<Category> findStats(Category category);
//	{
//		return update("update Article set weight=0 where weight > 0 and weightDate < current_timestamp()");
//	}
	
}
