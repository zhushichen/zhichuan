/**
 * Copyright &copy; 2012-2016 Civet All rights reserved.
 */
package com.civet.myadmin.modules.cms.entity;

import com.civet.myadmin.common.persistence.DataEntity;
import com.civet.myadmin.modules.sys.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

/**
 * 站点Entity
 * @author PlamCivet
 * @version 2013-05-15
 */
public class Site extends DataEntity<Site> {
	
	private static final long serialVersionUID = 1L;
	private String name;	// 站点名称
	private String title;	// 站点标题
	private String logo;	// 站点logo
	private String description;// 描述，填写有助于搜索引擎优化
	private String keywords;// 关键字，填写有助于搜索引擎优化
	private String theme;	// 主题
	private String copyright;// 版权信息
	private String customIndexView;// 自定义首页视图文件
	private String domain;

	public Site() {
		super();
	}
	
	public Site(Integer id){
		this();
		this.id = id;
	}

	@Length(min=1, max=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Length(min=1, max=100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Length(min=0, max=255)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Length(min=0, max=255)
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Length(min=1, max=255)
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getCustomIndexView() {
		return customIndexView;
	}

	public void setCustomIndexView(String customIndexView) {
		this.customIndexView = customIndexView;
	}

	/**
	 * 获取默认站点ID
	 */
	public static Integer defaultSiteId(){
		return 1;
	}
	
	/**
	 * 判断是否为默认（主站）站点
	 */
	public static boolean isDefault(Integer id){
		return id != null && id == defaultSiteId();
	}
	
	/**
	 * 获取当前编辑的站点编号
	 */
	public static Integer getCurrentSiteId(){
        Integer siteId = (Integer) UserUtils.getCache("siteId");
		return siteId != null?siteId:defaultSiteId();
	}

    /**
   	 * 模板路径
   	 */
   	public static final String TPL_BASE = "/WEB-INF/views/modules/cms/front/themes";

    /**
   	 * 获得模板方案路径。如：/WEB-INF/views/modules/cms/front/themes/jeesite
   	 *
   	 * @return
   	 */
   	public String getSolutionPath() {
   		return TPL_BASE + "/" + getTheme();
   	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
}