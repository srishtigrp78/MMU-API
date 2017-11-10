package com.iemr.mmu.data.masterdata.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_illness")
public class IllnessTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "IllnessID")
	private Integer illnessID;
	
	@Expose
	@Column(name = "IllnessType")
	private String illnessType;
	
	@Expose
	@Column(name = "isAcute")
	private Boolean isAcute;
	
	@Expose
	@Column(name = "isChronic")
	private Boolean isChronic;
	
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	public IllnessTypes(Integer illnessID, String illnessType, Boolean isAcute, Boolean isChronic) {
		super();
		this.illnessID = illnessID;
		this.illnessType = illnessType;
		this.isAcute = isAcute;
		this.isChronic = isChronic;
	}
	
}
