package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_BenMenstrualDetails")
public class BenMenstrualDetails {
	
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "BenMenstrualID")
	private Integer benMenstrualID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "BenVisitID")
	private Long benVisitID;
	
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name = "MenstrualCycleStatusID")
	private Short menstrualCycleStatusID;

	@Expose
	@Column(name = "Regularity")
	private String regularity;

	@Expose
	@Column(name = "MenstrualCyclelengthID")
	private Short menstrualCyclelengthID;

	@Expose
	@Column(name = "CycleLength")
	private String cycleLength;

	@Expose
	@Column(name = "MenstrualFlowDurationID")
	private Short menstrualFlowDurationID;

	@Expose
	@Column(name = "BloodFlowDuration")
	private String bloodFlowDuration;

	@Expose
	@Column(name = "MenstrualProblemID")
	private Short menstrualProblemID;

	@Expose
	@Column(name = "ProblemName")
	private String problemName;
	
	@Expose
	@Column(name = "LMPDate")
	private Timestamp lMPDate;
	
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

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Long getBenVisitID() {
		return benVisitID;
	}

	public void setBenVisitID(Long benVisitID) {
		this.benVisitID = benVisitID;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Short getMenstrualCycleStatusID() {
		return menstrualCycleStatusID;
	}

	public void setMenstrualCycleStatusID(Short menstrualCycleStatusID) {
		this.menstrualCycleStatusID = menstrualCycleStatusID;
	}

	public String getRegularity() {
		return regularity;
	}

	public void setRegularity(String regularity) {
		this.regularity = regularity;
	}

	public Short getMenstrualCyclelengthID() {
		return menstrualCyclelengthID;
	}

	public void setMenstrualCyclelengthID(Short menstrualCyclelengthID) {
		this.menstrualCyclelengthID = menstrualCyclelengthID;
	}

	public String getCycleLength() {
		return cycleLength;
	}

	public void setCycleLength(String cycleLength) {
		this.cycleLength = cycleLength;
	}

	public Short getMenstrualFlowDurationID() {
		return menstrualFlowDurationID;
	}

	public void setMenstrualFlowDurationID(Short menstrualFlowDurationID) {
		this.menstrualFlowDurationID = menstrualFlowDurationID;
	}

	public String getBloodFlowDuration() {
		return bloodFlowDuration;
	}

	public void setBloodFlowDuration(String bloodFlowDuration) {
		this.bloodFlowDuration = bloodFlowDuration;
	}

	public Short getMenstrualProblemID() {
		return menstrualProblemID;
	}

	public void setMenstrualProblemID(Short menstrualProblemID) {
		this.menstrualProblemID = menstrualProblemID;
	}

	public String getProblemName() {
		return problemName;
	}

	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}

	public Timestamp getlMPDate() {
		return lMPDate;
	}

	public void setlMPDate(Timestamp lMPDate) {
		this.lMPDate = lMPDate;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Integer getBenMenstrualID() {
		return benMenstrualID;
	}

	public BenMenstrualDetails(Short menstrualCycleStatusID, String regularity, Short menstrualCyclelengthID,
			String cycleLength, Short menstrualFlowDurationID, String bloodFlowDuration, Short menstrualProblemID,
			String problemName, Timestamp lMPDate) {
		super();
		this.menstrualCycleStatusID = menstrualCycleStatusID;
		this.regularity = regularity;
		this.menstrualCyclelengthID = menstrualCyclelengthID;
		this.cycleLength = cycleLength;
		this.menstrualFlowDurationID = menstrualFlowDurationID;
		this.bloodFlowDuration = bloodFlowDuration;
		this.menstrualProblemID = menstrualProblemID;
		this.problemName = problemName;
		this.lMPDate = lMPDate;
	}

	
}
