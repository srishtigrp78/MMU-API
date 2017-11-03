package com.iemr.mmu.data.nurse;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_phy_vitals")
public class BenPhysicalVitalDetail {

	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ID")
	private Long ID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;
	
	@Expose
	@Column(name = "BenVisitID")
	private Long benVisitID;
	
	@Expose
	@Column(name = "Temperature")
	private Double temperature;
	@Expose
	@Column(name = "PulseRate")
	private Short pulseRate;
	@Expose
	@Column(name = "RespiratoryRate")
	private Short respiratoryRate;
	@Expose
	@Column(name = "SystolicBP")
	private Short systolicBP;
	@Expose
	@Column(name = "DiastolicBP")
	private Short diastolicBP;
	@Expose
	@Column(name = "CapillaryRefillTime")
	private String capillaryRefillTime;
	
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
	
	public BenPhysicalVitalDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Short getPulseRate() {
		return pulseRate;
	}

	public void setPulseRate(Short pulseRate) {
		this.pulseRate = pulseRate;
	}

	public Short getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(Short respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public Short getSystolicBP() {
		return systolicBP;
	}

	public void setSystolicBP(Short systolicBP) {
		this.systolicBP = systolicBP;
	}

	public Short getDiastolicBP() {
		return diastolicBP;
	}

	public void setDiastolicBP(Short diastolicBP) {
		this.diastolicBP = diastolicBP;
	}

	public String getCapillaryRefillTime() {
		return capillaryRefillTime;
	}

	public void setCapillaryRefillTime(String capillaryRefillTime) {
		this.capillaryRefillTime = capillaryRefillTime;
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

	public Long getID() {
		return ID;
	}
	
	
}
