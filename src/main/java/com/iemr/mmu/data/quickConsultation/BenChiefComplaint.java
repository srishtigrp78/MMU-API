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
import com.iemr.mmu.data.registrar.BenGovIdMapping;

@Entity
@Table(name = "t_benchiefcomplaint")
public class BenChiefComplaint {
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ID")
	private Long benChiefComplaintID;

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
	@Column(name = "ChiefComplaintID")
	private Integer chiefComplaintID;
	@Expose
	@Column(name = "ChiefComplaint")
	private String chiefComplaint;
	@Expose
	@Column(name = "Duration")
	private Integer duration;
	@Expose
	@Column(name = "UnitOfDuration")
	private String unitOfDuration;
	@Expose
	@Column(name = "Description")
	private String description;
	
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

	public BenChiefComplaint() {
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

	public Integer getChiefComplaintID() {
		return chiefComplaintID;
	}

	public void setChiefComplaintID(Integer chiefComplaintID) {
		this.chiefComplaintID = chiefComplaintID;
	}

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getUnitOfDuration() {
		return unitOfDuration;
	}

	public void setUnitOfDuration(String unitOfDuration) {
		this.unitOfDuration = unitOfDuration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Long getBenChiefComplaintID() {
		return benChiefComplaintID;
	}
	
	
	public static ArrayList<BenChiefComplaint> getBenChiefComplaintList(JsonObject emrgCasesheet) {
		ArrayList<BenChiefComplaint> resArray = new ArrayList<>();
		BenChiefComplaint benChiefComplaint = null;
		System.out.println("ello");
		for (JsonElement csobj : emrgCasesheet.getAsJsonArray("benChiefComplaint")) {
			benChiefComplaint = new BenChiefComplaint();
			
			if (emrgCasesheet.has("benVisitID") && !emrgCasesheet.get("benVisitID").isJsonNull())
				benChiefComplaint.setBenVisitID(emrgCasesheet.get("benVisitID").getAsLong());
			
			if (emrgCasesheet.has("beneficiaryRegID") && !emrgCasesheet.get("beneficiaryRegID").isJsonNull())
				benChiefComplaint.setBeneficiaryRegID(emrgCasesheet.get("beneficiaryRegID").getAsLong());
			
			if (emrgCasesheet.has("providerServiceMapID") && !emrgCasesheet.get("providerServiceMapID").isJsonNull())
				benChiefComplaint.setProviderServiceMapID(emrgCasesheet.get("providerServiceMapID").getAsInt());
			
			JsonObject obj = csobj.getAsJsonObject();
			
			if (obj.has("chiefComplaintID") && !obj.get("chiefComplaintID").isJsonNull())
				benChiefComplaint.setChiefComplaintID(obj.get("chiefComplaintID").getAsInt());
			
			if (obj.has("chiefComplaint") && !obj.get("chiefComplaint").isJsonNull())
				benChiefComplaint.setChiefComplaint(obj.get("chiefComplaint").getAsString());
			
			if (obj.has("duration") && !obj.get("duration").isJsonNull())
				benChiefComplaint.setDuration(obj.get("duration").getAsInt());
			
			if (obj.has("unitOfDuration") && !obj.get("unitOfDuration").isJsonNull())
				benChiefComplaint.setUnitOfDuration(obj.get("unitOfDuration").getAsString());
			
			if (emrgCasesheet.has("description") && !emrgCasesheet.get("description").isJsonNull())
				benChiefComplaint.setDescription(emrgCasesheet.get("description").getAsString());
			
			if (emrgCasesheet.has("createdBy") && !emrgCasesheet.get("createdBy").isJsonNull())
				benChiefComplaint.setCreatedBy(emrgCasesheet.get("createdBy").getAsString());
			
			resArray.add(benChiefComplaint);
		}

		return resArray;
	}
	
}
