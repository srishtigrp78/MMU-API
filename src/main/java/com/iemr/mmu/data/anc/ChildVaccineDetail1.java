package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_ChildVaccineDetail1")
public class ChildVaccineDetail1 {
	
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
	@Column(name = "VisitCode")
	private Long visitCode;
	
	@Expose
	@Column(name = "DefaultReceivingAge")
	private String defaultReceivingAge;

	@Expose
	@Column(name = "VaccineName")
	private String vaccineName;

	@Expose
	@Column(name = "ActualReceivingAge")
	private String actualReceivingAge;

	@Expose
	@Column(name = "Status")
	private Boolean status;

	@Transient
	@Expose
	private List vaccines;
	
	@Expose
	@Column(name = "ReceivedDate")
	private Timestamp receivedDate;

	@Expose
	@Column(name = "ReceivedFacilityName")
	private String receivedFacilityName;
	
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

	@Transient
	@Expose
	private List<String> vaccineNameList;
	
	public List<String> getVaccineNameList() {
		return vaccineNameList;
	}

	public void setVaccineNameList(List<String> vaccineNameList) {
		this.vaccineNameList = vaccineNameList;
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

	public Long getVisitCode() {
		return visitCode;
	}

	public void setVisitCode(Long visitCode) {
		this.visitCode = visitCode;
	}

	public String getDefaultReceivingAge() {
		return defaultReceivingAge;
	}

	public void setDefaultReceivingAge(String defaultReceivingAge) {
		this.defaultReceivingAge = defaultReceivingAge;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getActualReceivingAge() {
		return actualReceivingAge;
	}

	public void setActualReceivingAge(String actualReceivingAge) {
		this.actualReceivingAge = actualReceivingAge;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Timestamp getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Timestamp receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getReceivedFacilityName() {
		return receivedFacilityName;
	}

	public void setReceivedFacilityName(String receivedFacilityName) {
		this.receivedFacilityName = receivedFacilityName;
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
	
	public List getVaccines() {
		return vaccines;
	}

	public void setVaccines(List vaccines) {
		this.vaccines = vaccines;
	}

	public ChildVaccineDetail1(String defaultReceivingAge, String vaccineName, Boolean status) {
		super();
		this.defaultReceivingAge = defaultReceivingAge;
		this.vaccineName = vaccineName;
		this.status = status;
	}
	
	public ChildVaccineDetail1(String defaultReceivingAge) {
		super();
		this.defaultReceivingAge = defaultReceivingAge;
	}
}
