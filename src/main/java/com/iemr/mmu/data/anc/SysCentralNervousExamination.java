package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_Sys_CentralNervous")
public class SysCentralNervousExamination {

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
	@Column(name = "Handedness")
	private String handedness;

	@Expose
	@Column(name = "CranialNervesExamination")
	private String cranialNervesExamination;

	@Expose
	@Column(name = "MotorSystem")
	private String motorSystem;

	@Expose
	@Column(name = "SensorySystem")
	private String sensorySystem;

	@Expose
	@Column(name = "AutonomicSystem")
	private String autonomicSystem;
	
	@Expose
	@Column(name = "CerebellarSigns")
	private String cerebellarSigns;

	@Expose
	@Column(name = "SignsOfMeningealIrritation")
	private String signsOfMeningealIrritation;

	@Expose
	@Column(name = "Skull")
	private String skull;
	
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

	public String getHandedness() {
		return handedness;
	}

	public void setHandedness(String handedness) {
		this.handedness = handedness;
	}

	public String getCranialNervesExamination() {
		return cranialNervesExamination;
	}

	public void setCranialNervesExamination(String cranialNervesExamination) {
		this.cranialNervesExamination = cranialNervesExamination;
	}

	public String getMotorSystem() {
		return motorSystem;
	}

	public void setMotorSystem(String motorSystem) {
		this.motorSystem = motorSystem;
	}

	public String getSensorySystem() {
		return sensorySystem;
	}

	public void setSensorySystem(String sensorySystem) {
		this.sensorySystem = sensorySystem;
	}

	public String getAutonomicSystem() {
		return autonomicSystem;
	}

	public void setAutonomicSystem(String autonomicSystem) {
		this.autonomicSystem = autonomicSystem;
	}

	public String getCerebellarSigns() {
		return cerebellarSigns;
	}

	public void setCerebellarSigns(String cerebellarSigns) {
		this.cerebellarSigns = cerebellarSigns;
	}

	public String getSignsOfMeningealIrritation() {
		return signsOfMeningealIrritation;
	}

	public void setSignsOfMeningealIrritation(String signsOfMeningealIrritation) {
		this.signsOfMeningealIrritation = signsOfMeningealIrritation;
	}

	public String getSkull() {
		return skull;
	}

	public void setSkull(String skull) {
		this.skull = skull;
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
