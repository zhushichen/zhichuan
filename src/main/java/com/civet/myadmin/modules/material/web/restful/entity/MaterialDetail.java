/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.web.restful.entity;

import java.util.Date;

/**
 * 物料详细信息Entity
 * @author likai
 * @version 2018-08-14
 */
public class MaterialDetail{

    private static final long serialVersionUID = 1L;
    private String name;		// 物料名字,如H1，H2此类
    private Long road;		// 线路唯一标识
    private Long materialTypeId;		// 物料类型code
    private String longitude;		// 经度
    private String latitude;		// 纬度
    private String picturePath;		// 图片路径

    protected String remarks;	// 备注
    protected Date createDate;	// 创建日期
    protected Date updateDate;	// 更新日期
    protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）

    /**
     * 实体编号（唯一标识）
     */
    protected Integer id;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRoad() {
        return road;
    }

    public void setRoad(Long road) {
        this.road = road;
    }

    public Long getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Long materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }


    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

}