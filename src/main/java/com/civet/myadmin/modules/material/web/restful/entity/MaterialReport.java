/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.web.restful.entity;

import com.civet.myadmin.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 台账Entity
 * @author likai
 * @version 2018-08-21
 */
public class MaterialReport{
	
	private static final long serialVersionUID = 1L;
	private Integer roadid;		// 线路id
	private Integer pointid;		// 点id
	private Integer jointwellnumber;		// 借口井编号
	private String cabletype;		// 电缆型号
	private String cablemanufacturer;		// 电缆厂家
	private String cablelength;		// 电缆长度
	private String attachmenttype;		// 附件类型
	private String attachmentmanufacturer;		// 附件厂家
	private String groundingmode;		// 接地方式
    private String roadName;		// 线路名字

    protected String remarks;	// 备注
    protected Date createDate;	// 创建日期
    protected Date updateDate;	// 更新日期

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

    protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）


	public Integer getRoadid() {
		return roadid;
	}

	public void setRoadid(Integer roadid) {
		this.roadid = roadid;
	}
	
	public Integer getPointid() {
		return pointid;
	}

	public void setPointid(Integer pointid) {
		this.pointid = pointid;
	}
	
	public Integer getJointwellnumber() {
		return jointwellnumber;
	}

	public void setJointwellnumber(Integer jointwellnumber) {
		this.jointwellnumber = jointwellnumber;
	}
	
	public String getCabletype() {
		return cabletype;
	}

	public void setCabletype(String cabletype) {
		this.cabletype = cabletype;
	}
	
	public String getCablemanufacturer() {
		return cablemanufacturer;
	}

	public void setCablemanufacturer(String cablemanufacturer) {
		this.cablemanufacturer = cablemanufacturer;
	}
	
	public String getCablelength() {
		return cablelength;
	}

	public void setCablelength(String cablelength) {
		this.cablelength = cablelength;
	}
	
	public String getAttachmenttype() {
		return attachmenttype;
	}

	public void setAttachmenttype(String attachmenttype) {
		this.attachmenttype = attachmenttype;
	}
	
	public String getAttachmentmanufacturer() {
		return attachmentmanufacturer;
	}

	public void setAttachmentmanufacturer(String attachmentmanufacturer) {
		this.attachmentmanufacturer = attachmentmanufacturer;
	}
	
	public String getGroundingmode() {
		return groundingmode;
	}

	public void setGroundingmode(String groundingmode) {
		this.groundingmode = groundingmode;
	}

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getRoadName() {
        return roadName;
    }
}