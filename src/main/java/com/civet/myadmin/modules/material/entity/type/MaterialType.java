/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.entity.type;

import org.hibernate.validator.constraints.Length;

import com.civet.myadmin.common.persistence.DataEntity;

/**
 * 物料类型Entity
 * @author likai
 * @version 2018-08-08
 */
public class MaterialType extends DataEntity<MaterialType> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// 代码
	private String detail;		// 描述
	private String origin;		// 厂家
	private String remark;		// 备注
	
	public MaterialType() {
		super();
	}

	public MaterialType(Integer id){
		super(id);
	}

	@Length(min=1, max=3, message="代码长度必须介于 1 和 3 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=1, max=255, message="描述长度必须介于 1 和 255 之间")
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@Length(min=0, max=255, message="厂家长度必须介于 0 和 255 之间")
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	@Length(min=0, max=1000, message="备注长度必须介于 0 和 1000 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}