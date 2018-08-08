/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.entity.detail;

import org.hibernate.validator.constraints.Length;

import com.civet.myadmin.common.persistence.DataEntity;

/**
 * 物料类型Entity
 * @author likai
 * @version 2018-08-08
 */
public class MaterialDetail extends DataEntity<MaterialDetail> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 物料名字
	private String road;		// 线路标识
	private String materialTypeCode;		// 物料类型code
	private String longitude;		// 经度
	private String latitude;		// 纬度
	private String picturePath;		// 图片路径
	
	public MaterialDetail() {
		super();
	}

	public MaterialDetail(Integer id){
		super(id);
	}

	@Length(min=0, max=255, message="物料名字长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=255, message="线路标识长度必须介于 1 和 255 之间")
	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}
	
	@Length(min=0, max=3, message="物料类型code长度必须介于 0 和 3 之间")
	public String getMaterialTypeCode() {
		return materialTypeCode;
	}

	public void setMaterialTypeCode(String materialTypeCode) {
		this.materialTypeCode = materialTypeCode;
	}
	
	@Length(min=0, max=255, message="经度长度必须介于 0 和 255 之间")
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Length(min=0, max=255, message="纬度长度必须介于 0 和 255 之间")
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	@Length(min=0, max=255, message="图片路径长度必须介于 0 和 255 之间")
	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	
}