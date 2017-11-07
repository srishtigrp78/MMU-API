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
@Table(name = "t_prescribeddrug")
public class PrescribedDrugDetail {
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "PrescribedDrugID")
	private Long prescribedDrugID;
	
	@Expose
	@Column(name = "PrescriptionID")
	private Long prescriptionID;
	
	@Expose
	@Column(name = "DrugForm")
	private String drugForm;
	
	@Expose
	@Column(name = "DrugTradeOrBrandName")
	private String drugTradeOrBrandName;
	
	@Expose
	@Column(name = "GenericDrugName")
	private String genericDrugName;
	
	@Expose
	@Column(name = "DrugStrength")
	private String drugStrength;
	
	@Expose
	@Column(name = "Dose")
	private String dose;
	
	@Expose
	@Column(name = "Route")
	private String route;
	
	@Expose
	@Column(name = "Frequency")
	private String frequency;
	
	@Expose
	@Column(name = "Duration")
	private String drugDuration;
	
	@Expose
	@Column(name = "RelationToFood")
	private String relationToFood;
	
	@Expose
	@Column(name = "SpecialInstruction")
	private String specialInstruction;
	
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
	
	public PrescribedDrugDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getPrescriptionID() {
		return prescriptionID;
	}

	public void setPrescriptionID(Long prescriptionID) {
		this.prescriptionID = prescriptionID;
	}

	public String getDrugForm() {
		return drugForm;
	}

	public void setDrugForm(String drugForm) {
		this.drugForm = drugForm;
	}

	public String getDrugTradeOrBrandName() {
		return drugTradeOrBrandName;
	}

	public void setDrugTradeOrBrandName(String drugTradeOrBrandName) {
		this.drugTradeOrBrandName = drugTradeOrBrandName;
	}

	public String getGenericDrugName() {
		return genericDrugName;
	}

	public void setGenericDrugName(String genericDrugName) {
		this.genericDrugName = genericDrugName;
	}

	public String getDrugStrength() {
		return drugStrength;
	}

	public void setDrugStrength(String drugStrength) {
		this.drugStrength = drugStrength;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getDuration() {
		return drugDuration;
	}

	public void setDuration(String duration) {
		this.drugDuration = duration;
	}

	public String getRelationToFood() {
		return relationToFood;
	}

	public void setRelationToFood(String relationToFood) {
		this.relationToFood = relationToFood;
	}

	public String getSpecialInstruction() {
		return specialInstruction;
	}

	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
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

	public Long getPrescribedDrugID() {
		return prescribedDrugID;
	}
	
	public static ArrayList<PrescribedDrugDetail> getBenPrescribedDrugDetailList(JsonObject emrgCasesheet, Long prescriptionID) {
		ArrayList<PrescribedDrugDetail> resArray = new ArrayList<PrescribedDrugDetail>();
		PrescribedDrugDetail prescribedDrugDetail = null;
		
		for (JsonElement csobj : emrgCasesheet.getAsJsonArray("prescribedDrugs")) {
			prescribedDrugDetail = new PrescribedDrugDetail();
		
			prescribedDrugDetail.setPrescriptionID(prescriptionID);
			
			JsonObject obj = csobj.getAsJsonObject();
			
			if (obj.has("drugForm") && !obj.get("drugForm").isJsonNull())
				prescribedDrugDetail.setDrugForm(obj.get("drugForm").getAsString());
			
			if (obj.has("drugTradeOrBrandName") && !obj.get("drugTradeOrBrandName").isJsonNull())
				prescribedDrugDetail.setDrugTradeOrBrandName(obj.get("drugTradeOrBrandName").getAsString());
			
			if (obj.has("genericDrugName") && !obj.get("genericDrugName").isJsonNull())
				prescribedDrugDetail.setGenericDrugName(obj.get("genericDrugName").getAsString());
			
			if (obj.has("drugStrength") && !obj.get("drugStrength").isJsonNull())
				prescribedDrugDetail.setDrugStrength(obj.get("drugStrength").getAsString());
			
			if (obj.has("dose") && !obj.get("dose").isJsonNull())
				prescribedDrugDetail.setDose(obj.get("dose").getAsString());
			
			if (obj.has("route") && !obj.get("route").isJsonNull())
				prescribedDrugDetail.setRoute(obj.get("route").getAsString());
			
			if (obj.has("frequency") && !obj.get("frequency").isJsonNull())
				prescribedDrugDetail.setFrequency(obj.get("frequency").getAsString());
			
			if (obj.has("drugDuration") && !obj.get("drugDuration").isJsonNull())
				prescribedDrugDetail.setDuration(obj.get("drugDuration").getAsString());
			
			if (obj.has("relationToFood") && !obj.get("relationToFood").isJsonNull())
				prescribedDrugDetail.setRelationToFood(obj.get("relationToFood").getAsString());
			
			if (obj.has("specialInstruction") && !obj.get("specialInstruction").isJsonNull())
				prescribedDrugDetail.setSpecialInstruction(obj.get("specialInstruction").getAsString());
			
			if (emrgCasesheet.has("createdBy") && !emrgCasesheet.get("createdBy").isJsonNull())
				prescribedDrugDetail.setCreatedBy(emrgCasesheet.get("createdBy").getAsString());
			
			resArray.add(prescribedDrugDetail);
		}

		return resArray;
	}
}
