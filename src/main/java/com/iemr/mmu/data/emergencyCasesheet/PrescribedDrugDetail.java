package com.iemr.mmu.data.emergencyCasesheet;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String duration;
	
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
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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
	
	
	
}
