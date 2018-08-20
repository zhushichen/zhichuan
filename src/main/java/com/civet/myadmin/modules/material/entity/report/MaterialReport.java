/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.entity.report;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.civet.myadmin.common.persistence.DataEntity;

/**
 * 台账Entity
 * @author likai
 * @version 2018-08-20
 */
public class MaterialReport extends DataEntity<MaterialReport> {
	
	private static final long serialVersionUID = 1L;
	private Long roadid;		// 线路id
	private Long pointid;		// 点id
	private Long jointwellnumber;		// 借口井编号
	private String cabletype;		// 电缆型号
	private String cablemanufacturer;		// 电缆厂家
	private String cablelength;		// 电缆长度
	private String attachmenttype;		// 附件类型
	private String attachmentmanufacturer;		// 附件厂家
	private String groundingmode;		// 接地方式
	
	public MaterialReport() {
		super();
	}

	public MaterialReport(Integer id){
		super(id);
	}

	@NotNull(message="线路id不能为空")
	public Long getRoadid() {
		return roadid;
	}

	public void setRoadid(Long roadid) {
		this.roadid = roadid;
	}
	
	@NotNull(message="点id不能为空")
	public Long getPointid() {
		return pointid;
	}

	public void setPointid(Long pointid) {
		this.pointid = pointid;
	}
	
	public Long getJointwellnumber() {
		return jointwellnumber;
	}

	public void setJointwellnumber(Long jointwellnumber) {
		this.jointwellnumber = jointwellnumber;
	}
	
	@Length(min=1, max=1000, message="电缆型号长度必须介于 1 和 1000 之间")
	public String getCabletype() {
		return cabletype;
	}

	public void setCabletype(String cabletype) {
		this.cabletype = cabletype;
	}
	
	@Length(min=1, max=1000, message="电缆厂家长度必须介于 1 和 1000 之间")
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
	
	@Length(min=0, max=1000, message="附件类型长度必须介于 0 和 1000 之间")
	public String getAttachmenttype() {
		return attachmenttype;
	}

	public void setAttachmenttype(String attachmenttype) {
		this.attachmenttype = attachmenttype;
	}
	
	@Length(min=0, max=1000, message="附件厂家长度必须介于 0 和 1000 之间")
	public String getAttachmentmanufacturer() {
		return attachmentmanufacturer;
	}

	public void setAttachmentmanufacturer(String attachmentmanufacturer) {
		this.attachmentmanufacturer = attachmentmanufacturer;
	}
	
	@Length(min=0, max=1000, message="接地方式长度必须介于 0 和 1000 之间")
	public String getGroundingmode() {
		return groundingmode;
	}

	public void setGroundingmode(String groundingmode) {
		this.groundingmode = groundingmode;
	}
	
}