package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_Sys_Cardiovascular")
public class SysCardiovascularExamination {
	
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
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name = "JugularVenousPulse_JVP")
	private String jugularVenousPulse_JVP;
	
	@Expose
	@Column(name = "ApexbeatLocation")
	private String apexbeatLocation;
	
	@Expose
	@Column(name = "ApexbeatType")
	private String apexbeatType;

	@Expose
	@Column(name = "FirstHeartSound_S1")
	private String firstHeartSound_S1;

	@Expose
	@Column(name = "SecondHeartSound_S2")
	private String secondHeartSound_S2;

	@Expose
	@Column(name = "AdditionalHeartSounds")
	private String additionalHeartSounds;

	@Expose
	@Column(name = "Murmurs")
	private String murmurs;

	@Expose
	@Column(name = "PericardialRub")
	private String pericardialRub;
	
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

	public String getJugularVenousPulse_JVP() {
		return jugularVenousPulse_JVP;
	}

	public void setJugularVenousPulse_JVP(String jugularVenousPulse_JVP) {
		this.jugularVenousPulse_JVP = jugularVenousPulse_JVP;
	}

	public String getApexbeatLocation() {
		return apexbeatLocation;
	}

	public void setApexbeatLocation(String apexbeatLocation) {
		this.apexbeatLocation = apexbeatLocation;
	}

	public String getApexbeatType() {
		return apexbeatType;
	}

	public void setApexbeatType(String apexbeatType) {
		this.apexbeatType = apexbeatType;
	}

	public String getFirstHeartSound_S1() {
		return firstHeartSound_S1;
	}

	public void setFirstHeartSound_S1(String firstHeartSound_S1) {
		this.firstHeartSound_S1 = firstHeartSound_S1;
	}

	public String getSecondHeartSound_S2() {
		return secondHeartSound_S2;
	}

	public void setSecondHeartSound_S2(String secondHeartSound_S2) {
		this.secondHeartSound_S2 = secondHeartSound_S2;
	}

	public String getAdditionalHeartSounds() {
		return additionalHeartSounds;
	}

	public void setAdditionalHeartSounds(String additionalHeartSounds) {
		this.additionalHeartSounds = additionalHeartSounds;
	}

	public String getMurmurs() {
		return murmurs;
	}

	public void setMurmurs(String murmurs) {
		this.murmurs = murmurs;
	}

	public String getPericardialRub() {
		return pericardialRub;
	}

	public void setPericardialRub(String pericardialRub) {
		this.pericardialRub = pericardialRub;
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
