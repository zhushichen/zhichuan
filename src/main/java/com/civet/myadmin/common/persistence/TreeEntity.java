/**
 * Copyright &copy; 2012-2016 Civet All rights reserved.
 */
package com.civet.myadmin.common.persistence;

import javax.validation.constraints.NotNull;

import com.alibaba.fastjson.annotation.JSONField;
import com.civet.myadmin.common.utils.Reflections;
import com.civet.myadmin.common.utils.StringUtils;
import org.hibernate.validator.constraints.Length;

/**
 * 数据Entity类
 * @author PlamCivet
 * @version 2014-05-16
 */
public abstract class TreeEntity<T> extends DataEntity<T> {

	private static final long serialVersionUID = 1L;

	protected T parent;	// 父级编号
	protected String parentIds; // 所有父级编号
	protected String name; 	// 机构名称
	protected Integer sort;		// 排序
	
	public TreeEntity() {
		super();
		this.sort = 30;
	}
	
	public TreeEntity(Integer id) {
		super(id);
	}
	
	/**
	 * 父对象，只能通过子类实现，父类实现mybatis无法读取
	 * @return
	 */
    @JSONField(serialize=false)
	@NotNull
	public abstract T getParent();

	/**
	 * 父对象，只能通过子类实现，父类实现mybatis无法读取
	 * @return
	 */
	public abstract void setParent(T parent);

	@Length(min=1, max=2000)
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	@Length(min=1, max=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public Integer getParentId() {
        Integer id = null;
		if (parent != null){
			id = (Integer) Reflections.getFieldValue(parent, "id");
		}
		return id != null ? id : 0;
	}
	
}
