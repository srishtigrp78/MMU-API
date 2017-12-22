package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_bencomorbiditycondition")
public class BencomrbidityCondDetails {
	
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
	@Column(name = "ComorbidConditionID")
	private Short comorbidConditionID;
	
	@Expose
	@Column(name = "ComorbidCondition")
	private String comorbidCondition;
	
	@Expose
	@Column(name = "Year")
	private Timestamp year;
	
	@Expose
	@Column(name = "OtherComorbidCondition")
	private String otherComorbidCondition;
	
	@Expose
	@Column(name = "IsForHistory")
	private Boolean isForHistory;
	
	@Transient
	@Expose 
	private Integer timePeriodAgo;
	
	@Transient
	@Expose
	private String timePeriodUnit;
	
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


	public Short getComorbidConditionID() {
		return comorbidConditionID;
	}


	public void setComorbidConditionID(Short comorbidConditionID) {
		this.comorbidConditionID = comorbidConditionID;
	}


	public String getComorbidCondition() {
		return comorbidCondition;
	}


	public void setComorbidCondition(String comorbidCondition) {
		this.comorbidCondition = comorbidCondition;
	}


	public Timestamp getYear() {
		return year;
	}


	public void setYear(Timestamp year) {
		this.year = year;
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
	
	public Integer getTimePeriodAgo() {
		return timePeriodAgo;
	}


	public void setTimePeriodAgo(Integer timePeriodAgo) {
		this.timePeriodAgo = timePeriodAgo;
	}


	public String getTimePeriodUnit() {
		return timePeriodUnit;
	}


	public void setTimePeriodUnit(String timePeriodUnit) {
		this.timePeriodUnit = timePeriodUnit;
	}


	public String getOtherComorbidCondition() {
		return otherComorbidCondition;
	}


	public void setOtherComorbidCondition(String otherComorbidCondition) {
		this.otherComorbidCondition = otherComorbidCondition;
	}

	public Boolean getIsForHistory() {
		return isForHistory;
	}

	public void setIsForHistory(Boolean isForHistory) {
		this.isForHistory = isForHistory;
	}

	public BencomrbidityCondDetails(String comorbidCondition,String otherComorbidCondition, Timestamp year) {
		super();
		
		this.comorbidCondition = comorbidCondition;
		this.otherComorbidCondition = otherComorbidCondition;
		this.year = year;
		
	}
	
}
