/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.entity.detail;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.civet.myadmin.common.persistence.DataEntity;

/**
 * 物料详细信息Entity
 * @author likai
 * @version 2018-08-21
 */
public class MaterialDetail extends DataEntity<MaterialDetail> {
	
	private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    private String name;		// 物料名字,如H1，H2此类
	private Integer road;		// 线路唯一标识
	private Integer materialTypeId;		// 物料类型code
	private String longitude;		// 经度
	private String latitude;		// 纬度
	private String picturePath;		// 图片路径
	private Integer pointorder;		// 序号

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    private String typeName;

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    private String roadName;

	public MaterialDetail() {
		super();
	}

	public MaterialDetail(Integer id){
		super(id);
	}

    public String getRoadName() {
        return roadName;
    }

	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull(message="线路唯一标识不能为空")
	public Integer getRoad() {
		return road;
	}

	public void setRoad(Integer road) {
		this.road = road;
	}
	
	@NotNull(message="物料类型code不能为空")
	public Integer getMaterialTypeId() {
		return materialTypeId;
	}

    public String getStringMaterialTypeId() {
        return String.valueOf(materialTypeId);
    }

	public void setMaterialTypeId(Integer materialTypeId) {
		this.materialTypeId = materialTypeId;
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
	
	public Integer getPointorder() {
		return pointorder;
	}

	public void setPointorder(Integer pointorder) {
		this.pointorder = pointorder;
	}
	
}