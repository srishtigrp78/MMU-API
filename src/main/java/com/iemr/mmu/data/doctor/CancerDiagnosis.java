package com.iemr.mmu.data.doctor;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.registrar.BeneficiaryData;

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
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "BeneficiaryRegID")
	private BeneficiaryData beneficiaryData;
	
	@Expose
	@Column(name = "BenVisitID")
	private Long benVisitID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "BenVisitID")
	private BeneficiaryVisitDetail beneficiaryVisitDetail;
	
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
	
	@Expose
	@Column(name = "RefrredToAdditionalService")
	private String refrredToAdditionalService;
	
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

	public CancerDiagnosis(Long ID, Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			String provisionalDiagnosisPrimaryDoctor, String provisionalDiagnosisOncologist, String remarks,
			Integer referredToInstituteID, String refrredToAdditionalService, Boolean deleted) {
		super();
		this.ID = ID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.provisionalDiagnosisPrimaryDoctor = provisionalDiagnosisPrimaryDoctor;
		this.provisionalDiagnosisOncologist = provisionalDiagnosisOncologist;
		this.remarks = remarks;
		this.referredToInstituteID = referredToInstituteID;
		this.refrredToAdditionalService = refrredToAdditionalService;
		this.deleted = deleted;
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public BeneficiaryData getBeneficiaryData() {
		return beneficiaryData;
	}

	public void setBeneficiaryData(BeneficiaryData beneficiaryData) {
		this.beneficiaryData = beneficiaryData;
	}

	public Long getBenVisitID() {
		return benVisitID;
	}

	public void setBenVisitID(Long benVisitID) {
		this.benVisitID = benVisitID;
	}

	public BeneficiaryVisitDetail getBeneficiaryVisitDetail() {
		return beneficiaryVisitDetail;
	}

	public void setBeneficiaryVisitDetail(BeneficiaryVisitDetail beneficiaryVisitDetail) {
		this.beneficiaryVisitDetail = beneficiaryVisitDetail;
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

	public Long getID() {
		return ID;
	}
	
	
}
