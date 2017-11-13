package com.iemr.mmu.data.doctor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.mmu.data.institution.Institute;
import com.iemr.mmu.data.masterdata.nurse.CancerDiseaseType;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.registrar.BeneficiaryData;
import com.iemr.mmu.data.registrar.BeneficiaryDemographicData;

@Entity
@Table(name = "t_cancerdiagnosis")
public class CancerDiagnosis {
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
	@Column(name = "ProvisionalDiagnosisPrimaryDoctor")
	private String provisionalDiagnosisPrimaryDoctor;
	
	@Expose
	@Column(name = "ProvisionalDiagnosisOncologist")
	private String provisionalDiagnosisOncologist;
	
	@Expose
	@Column(name = "Remarks")
	private String remarks;
	
	@Expose
	@Column(name = "ReferredToInstituteID")
	private Integer referredToInstituteID;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "referredToInstituteID", referencedColumnName = "institutionID", insertable = false, updatable = false)
	private Institute institute;
	
	@Transient
	@Expose
	private String referredToInstituteName;
	
	@Expose
	@Column(name = "RefrredToAdditionalService")
	private String refrredToAdditionalService;
	
	@JsonIgnore
	@Transient
	private List<String> refrredToAdditionalServiceList;

	@Expose
	@Column(name = "Deleted",insertable = false, updatable = true)
	private Boolean deleted; 
	
	@Expose
	@Column(name = "Processed",insertable = false, updatable = true)
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

	public CancerDiagnosis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CancerDiagnosis(Long iD, Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			String provisionalDiagnosisPrimaryDoctor, String provisionalDiagnosisOncologist, String remarks,
			Integer referredToInstituteID, String referredToInstituteName, String refrredToAdditionalService) {
		super();
		ID = iD;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.provisionalDiagnosisPrimaryDoctor = provisionalDiagnosisPrimaryDoctor;
		this.provisionalDiagnosisOncologist = provisionalDiagnosisOncologist;
		this.remarks = remarks;
		this.referredToInstituteID = referredToInstituteID;
		this.referredToInstituteName = referredToInstituteName;
		this.refrredToAdditionalService = refrredToAdditionalService;
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

	public String getProvisionalDiagnosisPrimaryDoctor() {
		return provisionalDiagnosisPrimaryDoctor;
	}

	public void setProvisionalDiagnosisPrimaryDoctor(String provisionalDiagnosisPrimaryDoctor) {
		this.provisionalDiagnosisPrimaryDoctor = provisionalDiagnosisPrimaryDoctor;
	}

	public String getProvisionalDiagnosisOncologist() {
		return provisionalDiagnosisOncologist;
	}

	public void setProvisionalDiagnosisOncologist(String provisionalDiagnosisOncologist) {
		this.provisionalDiagnosisOncologist = provisionalDiagnosisOncologist;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getReferredToInstituteID() {
		return referredToInstituteID;
	}

	public void setReferredToInstituteID(Integer referredToInstituteID) {
		this.referredToInstituteID = referredToInstituteID;
	}

	public String getRefrredToAdditionalService() {
		return refrredToAdditionalService;
	}

	public void setRefrredToAdditionalService(String refrredToAdditionalService) {
		this.refrredToAdditionalService = refrredToAdditionalService;
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
	
	public String getReferredToInstituteName() {
		return referredToInstituteName;
	}

	public void setReferredToInstituteName(String referredToInstituteName) {
		this.referredToInstituteName = referredToInstituteName;
	}
	
	public List<String> getRefrredToAdditionalServiceList() {
		return refrredToAdditionalServiceList;
	}

	public void setRefrredToAdditionalServiceList(List<String> refrredToAdditionalServiceList) {
		this.refrredToAdditionalServiceList = refrredToAdditionalServiceList;
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	
}
