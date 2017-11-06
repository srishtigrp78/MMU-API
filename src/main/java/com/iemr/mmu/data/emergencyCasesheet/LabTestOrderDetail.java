package com.iemr.mmu.data.emergencyCasesheet;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_lab_testorder")
public class LabTestOrderDetail {
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ID")
	private Long labTestOrderID;
	
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
	@Column(name = "PrescriptionID")
	private Long prescriptionID;
	
	@Expose
	@Column(name = "TestID")
	private Integer testID;
	
	@Expose
	@Column(name = "OrderedTestName")
	private String orderedTestName;
	
	@Expose
	@Column(name = "TestingRequirements")
	private String testingRequirements;
	
	@Expose
	@Column(name = "IsRadiologyImaging")
	private Boolean isRadiologyImaging;
	
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

	public LabTestOrderDetail() {
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

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Long getPrescriptionID() {
		return prescriptionID;
	}

	public void setPrescriptionID(Long prescriptionID) {
		this.prescriptionID = prescriptionID;
	}

	public Integer getTestID() {
		return testID;
	}

	public void setTestID(Integer testID) {
		this.testID = testID;
	}

	public String getOrderedTestName() {
		return orderedTestName;
	}

	public void setOrderedTestName(String orderedTestName) {
		this.orderedTestName = orderedTestName;
	}

	public String getTestingRequirements() {
		return testingRequirements;
	}

	public void setTestingRequirements(String testingRequirements) {
		this.testingRequirements = testingRequirements;
	}

	public Boolean getIsRadiologyImaging() {
		return isRadiologyImaging;
	}

	public void setIsRadiologyImaging(Boolean isRadiologyImaging) {
		this.isRadiologyImaging = isRadiologyImaging;
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

	public Long getLabTestOrderID() {
		return labTestOrderID;
	}
	
}
