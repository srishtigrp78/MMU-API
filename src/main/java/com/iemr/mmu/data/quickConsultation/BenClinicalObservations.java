package com.iemr.mmu.data.quickConsultation;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_benclinicalobservation")
public class BenClinicalObservations {
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ClinicalObservationID")
	private Long clinicalObservationID;

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
	@Column(name = "ClinicalObservation")
	private String clinicalObservation;
	
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

	public BenClinicalObservations() {
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

	public String getClinicalObservation() {
		return clinicalObservation;
	}

	public void setClinicalObservation(String clinicalObservation) {
		this.clinicalObservation = clinicalObservation;
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

	public Long getClinicalObservationID() {
		return clinicalObservationID;
	}
	
//	public static BenClinicalObservations getBenClinicalObservationsList(JsonObject emrgCasesheet) {
//		ArrayList<BenClinicalObservations> resArray = new ArrayList<>();
//		BenClinicalObservations benClinicalObservations = null;
//
//			benClinicalObservations = new BenClinicalObservations();
//			
//			if (emrgCasesheet.has("benVisitID") && !emrgCasesheet.get("benVisitID").isJsonNull())
//				benChiefComplaint.setBenVisitID(new Long(emrgCasesheet.get("benVisitID").toString()));
//			
//			if (emrgCasesheet.has("beneficiaryRegID") && !emrgCasesheet.get("beneficiaryRegID").isJsonNull())
//				benChiefComplaint.setBeneficiaryRegID(new Long(emrgCasesheet.get("beneficiaryRegID").toString()));
//			
//			if (emrgCasesheet.has("providerServiceMapID") && !emrgCasesheet.get("providerServiceMapID").isJsonNull())
//				benChiefComplaint.setProviderServiceMapID(new Integer(emrgCasesheet.get("providerServiceMapID").toString()));
//			
//			JsonObject obj = csobj.getAsJsonObject();
//			
//			if (obj.has("chiefComplaintID") && !obj.get("chiefComplaintID").isJsonNull())
//				benChiefComplaint.setChiefComplaintID(new Integer(obj.get("chiefComplaintID").toString()));
//			
//			if (obj.has("chiefComplaint") && !obj.get("chiefComplaint").isJsonNull())
//				benChiefComplaint.setChiefComplaint(obj.get("chiefComplaint").toString());
//			
//			if (obj.has("duration") && !obj.get("duration").isJsonNull())
//				benChiefComplaint.setDuration(new Integer(obj.get("providerServiceMapID").toString()));
//			
//			if (obj.has("unitOfDuration") && !obj.get("unitOfDuration").isJsonNull())
//				benChiefComplaint.setUnitOfDuration(obj.get("unitOfDuration").toString());
//			
//			if (obj.has("description") && !obj.get("description").isJsonNull())
//				benChiefComplaint.setDescription(obj.get("description").toString());
//			
//			if (emrgCasesheet.has("createdBy") && !emrgCasesheet.get("createdBy").isJsonNull())
//				benChiefComplaint.setCreatedBy(emrgCasesheet.get("createdBy").toString());
//			
//			resArray.add(benChiefComplaint);
//		}
//
//		return resArray;
//	}
	
}

