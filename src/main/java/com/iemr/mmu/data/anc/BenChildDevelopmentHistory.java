package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_DevelopmentHistory")
public class BenChildDevelopmentHistory {
	
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
	@Column(name = "GrossMotorMilestone")
	private String grossMotorMilestone;
	
	@Expose
	@Column(name = "IsGMMAttained")
	private Boolean isGMMAttained;
	
	@Expose
	@Column(name = "FineMotorMilestone")
	private String fineMotorMilestone;
	
	@Expose
	@Column(name = "IsFMMAttained")
	private Boolean isFMMAttained;
	
	@Expose
	@Column(name = "SocialMilestone")
	private String socialMilestone;
	
	@Expose
	@Column(name = "IsSMAttained")
	private Boolean isSMAttained;
	
	@Expose
	@Column(name = "LanguageMilestone")
	private String languageMilestone;
	
	@Expose
	@Column(name = "IsLMAttained")
	private Boolean isLMAttained;
	
	@Expose
	@Column(name = "DevelopmentProblem")
	private String developmentProblem;
	
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

	public String getGrossMotorMilestone() {
		return grossMotorMilestone;
	}

	public void setGrossMotorMilestone(String grossMotorMilestone) {
		this.grossMotorMilestone = grossMotorMilestone;
	}

	public Boolean getIsGMMAttained() {
		return isGMMAttained;
	}

	public void setIsGMMAttained(Boolean isGMMAttained) {
		this.isGMMAttained = isGMMAttained;
	}

	public String getFineMotorMilestone() {
		return fineMotorMilestone;
	}

	public void setFineMotorMilestone(String fineMotorMilestone) {
		this.fineMotorMilestone = fineMotorMilestone;
	}

	public Boolean getIsFMMAttained() {
		return isFMMAttained;
	}

	public void setIsFMMAttained(Boolean isFMMAttained) {
		this.isFMMAttained = isFMMAttained;
	}

	public String getSocialMilestone() {
		return socialMilestone;
	}

	public void setSocialMilestone(String socialMilestone) {
		this.socialMilestone = socialMilestone;
	}

	public Boolean getIsSMAttained() {
		return isSMAttained;
	}

	public void setIsSMAttained(Boolean isSMAttained) {
		this.isSMAttained = isSMAttained;
	}

	public String getLanguageMilestone() {
		return languageMilestone;
	}

	public void setLanguageMilestone(String languageMilestone) {
		this.languageMilestone = languageMilestone;
	}

	public Boolean getIsLMAttained() {
		return isLMAttained;
	}

	public void setIsLMAttained(Boolean isLMAttained) {
		this.isLMAttained = isLMAttained;
	}

	public String getDevelopmentProblem() {
		return developmentProblem;
	}

	public void setDevelopmentProblem(String developmentProblem) {
		this.developmentProblem = developmentProblem;
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
