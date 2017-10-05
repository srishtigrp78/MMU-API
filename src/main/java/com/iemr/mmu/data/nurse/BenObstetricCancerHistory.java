package com.iemr.mmu.data.nurse;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Table(name = "t_CancerObstetricHistory")
public class BenObstetricCancerHistory {
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
	@Column(name = "PregnancyStatus")
	private String pregnancyStatus;
	@Expose
	@Column(name = "IsUrinePregTest")
	private Boolean isUrinePregTest;
	@Expose
	@Column(name = "Pregnant_No")
	private String pregnant_No;
	@Expose
	@Column(name = "NoOfLivingChild")
	private Integer noOfLivingChild;
	@Expose
	@Column(name = "IsAbortion")
	private Boolean isAbortion;
	@Expose
	@Column(name = "IsOralContraceptiveUsed")
	private Boolean isOralContraceptiveUsed;
	@Expose
	@Column(name = "IsHormoneReplacementTherapy")
	private Boolean isHormoneReplacementTherapy;
	@Expose
	@Column(name = "Menarche_Age")
	private Integer menarche_Age;
	@Expose
	@Column(name = "IsMenstrualCycleRegular")
	private Boolean isMenstrualCycleRegular;
	@Expose
	@Column(name = "MenstrualCycleLength")
	private Integer menstrualCycleLength;
	@Expose
	@Column(name = "MenstrualFlowDuration")
	private Integer menstrualFlowDuration;
	@Expose
	@Column(name = "MenstrualFlowType")
	private String menstrualFlowType;
	@Expose
	@Column(name = "IsDysmenorrhea")
	private Boolean isDysmenorrhea;
	@Expose
	@Column(name = "IsInterMenstrualBleeding")
	private Boolean isInterMenstrualBleeding;
	@Expose
	@Column(name = "MenopauseAge")
	private Integer menopauseAge;
	@Expose
	@Column(name = "IsPostMenopauseBleeding")
	private Boolean isPostMenopauseBleeding;
	@Expose
	@Column(name = "IsFoulSmellingDischarge")
	private Boolean IsFoulSmellingDischarge;
	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;
	@Expose
	@Column(name = "Processed")
	private Character processed;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate")
	private Timestamp createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate")
	private Timestamp lastModDate;

	public BenObstetricCancerHistory(Long iD, Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			String pregnancyStatus, Boolean isUrinePregTest, String pregnant_No, Integer noOfLivingChild,
			Boolean isAbortion, Boolean isOralContraceptiveUsed, Boolean isHormoneReplacementTherapy,
			Integer menarche_Age, Boolean isMenstrualCycleRegular, Integer menstrualCycleLength,
			Integer menstrualFlowDuration, String menstrualFlowType, Boolean isDysmenorrhea,
			Boolean isInterMenstrualBleeding, Integer menopauseAge, Boolean isPostMenopauseBleeding,
			Boolean isFoulSmellingDischarge, Boolean deleted, Character processed, String createdBy,
			Timestamp createdDate, String modifiedBy, Timestamp lastModDate) {
		super();
		ID = iD;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.pregnancyStatus = pregnancyStatus;
		this.isUrinePregTest = isUrinePregTest;
		this.pregnant_No = pregnant_No;
		this.noOfLivingChild = noOfLivingChild;
		this.isAbortion = isAbortion;
		this.isOralContraceptiveUsed = isOralContraceptiveUsed;
		this.isHormoneReplacementTherapy = isHormoneReplacementTherapy;
		this.menarche_Age = menarche_Age;
		this.isMenstrualCycleRegular = isMenstrualCycleRegular;
		this.menstrualCycleLength = menstrualCycleLength;
		this.menstrualFlowDuration = menstrualFlowDuration;
		this.menstrualFlowType = menstrualFlowType;
		this.isDysmenorrhea = isDysmenorrhea;
		this.isInterMenstrualBleeding = isInterMenstrualBleeding;
		this.menopauseAge = menopauseAge;
		this.isPostMenopauseBleeding = isPostMenopauseBleeding;
		IsFoulSmellingDischarge = isFoulSmellingDischarge;
		this.deleted = deleted;
		this.processed = processed;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
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

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public String getPregnancyStatus() {
		return pregnancyStatus;
	}

	public void setPregnancyStatus(String pregnancyStatus) {
		this.pregnancyStatus = pregnancyStatus;
	}

	public Boolean getIsUrinePregTest() {
		return isUrinePregTest;
	}

	public void setIsUrinePregTest(Boolean isUrinePregTest) {
		this.isUrinePregTest = isUrinePregTest;
	}

	public String getPregnant_No() {
		return pregnant_No;
	}

	public void setPregnant_No(String pregnant_No) {
		this.pregnant_No = pregnant_No;
	}

	public Integer getNoOfLivingChild() {
		return noOfLivingChild;
	}

	public void setNoOfLivingChild(Integer noOfLivingChild) {
		this.noOfLivingChild = noOfLivingChild;
	}

	public Boolean getIsAbortion() {
		return isAbortion;
	}

	public void setIsAbortion(Boolean isAbortion) {
		this.isAbortion = isAbortion;
	}

	public Boolean getIsOralContraceptiveUsed() {
		return isOralContraceptiveUsed;
	}

	public void setIsOralContraceptiveUsed(Boolean isOralContraceptiveUsed) {
		this.isOralContraceptiveUsed = isOralContraceptiveUsed;
	}

	public Boolean getIsHormoneReplacementTherapy() {
		return isHormoneReplacementTherapy;
	}

	public void setIsHormoneReplacementTherapy(Boolean isHormoneReplacementTherapy) {
		this.isHormoneReplacementTherapy = isHormoneReplacementTherapy;
	}

	public Integer getMenarche_Age() {
		return menarche_Age;
	}

	public void setMenarche_Age(Integer menarche_Age) {
		this.menarche_Age = menarche_Age;
	}

	public Boolean getIsMenstrualCycleRegular() {
		return isMenstrualCycleRegular;
	}

	public void setIsMenstrualCycleRegular(Boolean isMenstrualCycleRegular) {
		this.isMenstrualCycleRegular = isMenstrualCycleRegular;
	}

	public Integer getMenstrualCycleLength() {
		return menstrualCycleLength;
	}

	public void setMenstrualCycleLength(Integer menstrualCycleLength) {
		this.menstrualCycleLength = menstrualCycleLength;
	}

	public Integer getMenstrualFlowDuration() {
		return menstrualFlowDuration;
	}

	public void setMenstrualFlowDuration(Integer menstrualFlowDuration) {
		this.menstrualFlowDuration = menstrualFlowDuration;
	}

	public String getMenstrualFlowType() {
		return menstrualFlowType;
	}

	public void setMenstrualFlowType(String menstrualFlowType) {
		this.menstrualFlowType = menstrualFlowType;
	}

	public Boolean getIsDysmenorrhea() {
		return isDysmenorrhea;
	}

	public void setIsDysmenorrhea(Boolean isDysmenorrhea) {
		this.isDysmenorrhea = isDysmenorrhea;
	}

	public Boolean getIsInterMenstrualBleeding() {
		return isInterMenstrualBleeding;
	}

	public void setIsInterMenstrualBleeding(Boolean isInterMenstrualBleeding) {
		this.isInterMenstrualBleeding = isInterMenstrualBleeding;
	}

	public Integer getMenopauseAge() {
		return menopauseAge;
	}

	public void setMenopauseAge(Integer menopauseAge) {
		this.menopauseAge = menopauseAge;
	}

	public Boolean getIsPostMenopauseBleeding() {
		return isPostMenopauseBleeding;
	}

	public void setIsPostMenopauseBleeding(Boolean isPostMenopauseBleeding) {
		this.isPostMenopauseBleeding = isPostMenopauseBleeding;
	}

	public Boolean getIsFoulSmellingDischarge() {
		return IsFoulSmellingDischarge;
	}

	public void setIsFoulSmellingDischarge(Boolean isFoulSmellingDischarge) {
		IsFoulSmellingDischarge = isFoulSmellingDischarge;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Character getProcessed() {
		return processed;
	}

	public void setProcessed(Character processed) {
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

}
