/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.entity.road;

import org.hibernate.validator.constraints.Length;

import com.civet.myadmin.common.persistence.DataEntity;

/**
 * 路线Entity
 * @author likai
 * @version 2018-08-08
 */
public class MaterialRoad extends DataEntity<MaterialRoad> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 线路名字
	private String remark;		// 备注
	
	public MaterialRoad() {
		super();
	}

	public MaterialRoad(Integer id){
		super(id);
	}

	@Length(min=1, max=255, message="线路名字长度必须介于 1 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=1000, message="备注长度必须介于 0 和 1000 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}