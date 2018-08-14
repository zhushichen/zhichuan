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
 * @version 2018-08-14
 */
public class MaterialDetail extends DataEntity<MaterialDetail> {

    private static final long serialVersionUID = 1L;
    private String name;		// 物料名字,如H1，H2此类
    private Long road;		// 线路唯一标识
    private Long materialTypeId;		// 物料类型code
    private String longitude;		// 经度
    private String latitude;		// 纬度
    private String picturePath;		// 图片路径

    public MaterialDetail() {
        super();
    }

    public MaterialDetail(Integer id){
        super(id);
    }

    @Length(min=0, max=255, message="物料名字,如H1，H2此类长度必须介于 0 和 255 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message="线路唯一标识不能为空")
    public Long getRoad() {
        return road;
    }

    public void setRoad(Long road) {
        this.road = road;
    }

    @NotNull(message="物料类型code不能为空")
    public Long getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Long materialTypeId) {
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

}