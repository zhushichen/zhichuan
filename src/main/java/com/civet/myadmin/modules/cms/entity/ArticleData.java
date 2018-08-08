/**
 * Copyright &copy; 2012-2016 Civet All rights reserved.
 */
package com.civet.myadmin.modules.cms.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.civet.myadmin.common.config.Global;
import com.civet.myadmin.common.persistence.DataEntity;

/**
 * 文章Entity
 * @author PlamCivet
 * @version 2013-01-15
 */
public class ArticleData extends DataEntity<ArticleData> {

	private static final long serialVersionUID = 1L;

	private String content;	// 内容
	private String copyfrom;// 来源
	private String relation;// 相关文章
	private String allowComment;// 是否允许评论

	private Article article;
	
	public ArticleData() {
		super();
		this.allowComment = Global.YES;
	}
	
	public ArticleData(Integer id){
		this();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotBlank
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Length(min=0, max=255)
	public String getCopyfrom() {
		return copyfrom;
	}

	public void setCopyfrom(String copyfrom) {
		this.copyfrom = copyfrom;
	}

	@Length(min=0, max=255)
	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Length(min=1, max=1)
	public String getAllowComment() {
		return allowComment;
	}

	public void setAllowComment(String allowComment) {
		this.allowComment = allowComment;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}