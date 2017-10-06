package com.iemr.mmu.data.doctor;

import java.sql.Blob;
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
@Table(name = "t_canceroralexamination")
public class CancerOralExamination {
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ID")
	private Long iD;
	
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
	@Column(name = "LimitedMouthOpening")
	private String limitedMouthOpening;
	
	@Expose
	@Column(name = "PremalignantLesions")
	private Boolean premalignantLesions;
	
	@Expose
	@Column(name = "PreMalignantLesionType")
	private String preMalignantLesionType;
	
	@Expose
	@Column(name = "ProlongedIrritation")
	private Boolean prolongedIrritation;
	
	@Expose
	@Column(name = "ChronicBurningSensation")
	private Boolean chronicBurningSensation;
	
	@Expose
	@Column(name = "Observation")
	private String observation;
	
	@Expose
	@Column(name = "Image")
	private Blob image;
	
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

	public CancerOralExamination() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CancerOralExamination(Long iD, Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			String limitedMouthOpening, Boolean premalignantLesions, String preMalignantLesionType,
			Boolean prolongedIrritation, Boolean chronicBurningSensation, String observation, Blob image,
			Boolean deleted) {
		super();
		this.iD = iD;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.limitedMouthOpening = limitedMouthOpening;
		this.premalignantLesions = premalignantLesions;
		this.preMalignantLesionType = preMalignantLesionType;
		this.prolongedIrritation = prolongedIrritation;
		this.chronicBurningSensation = chronicBurningSensation;
		this.observation = observation;
		this.image = image;
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

	public String getLimitedMouthOpening() {
		return limitedMouthOpening;
	}

	public void setLimitedMouthOpening(String limitedMouthOpening) {
		this.limitedMouthOpening = limitedMouthOpening;
	}

	public Boolean getPremalignantLesions() {
		return premalignantLesions;
	}

	public void setPremalignantLesions(Boolean premalignantLesions) {
		this.premalignantLesions = premalignantLesions;
	}

	public String getPreMalignantLesionType() {
		return preMalignantLesionType;
	}

	public void setPreMalignantLesionType(String preMalignantLesionType) {
		this.preMalignantLesionType = preMalignantLesionType;
	}

	public Boolean getProlongedIrritation() {
		return prolongedIrritation;
	}

	public void setProlongedIrritation(Boolean prolongedIrritation) {
		this.prolongedIrritation = prolongedIrritation;
	}

	public Boolean getChronicBurningSensation() {
		return chronicBurningSensation;
	}

	public void setChronicBurningSensation(Boolean chronicBurningSensation) {
		this.chronicBurningSensation = chronicBurningSensation;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
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

	public Long getiD() {
		return iD;
	}
	
	
}
