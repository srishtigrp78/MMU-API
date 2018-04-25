package com.iemr.mmu.data.quickConsultation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.iemr.mmu.data.anc.WrapperBenInvestigationANC;

@Entity
@Table(name = "t_prescribeddrug")
public class PrescribedDrugDetail {
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "PrescribedDrugID")
	private Long prescribedDrugID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;
	
	@Expose
	@Column(name = "BenVisitID")
	private Long benVisitID;
	
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
	@Column(name = "DrugID")
	private Integer drugID;

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

	@Expose
	@Column(name = "VanSerialNo")
	private Long vanSerialNo;
	
	@Expose
	@Column(name = "VehicalNo")
	private String vehicalNo;
	
	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceID;
	
	@Expose
	@Column(name = "SyncedBy")
	private String syncedBy;
	
	@Expose
	@Column(name = "SyncedDate")
	private Timestamp syncedDate;
	
	@Expose
	@Column(name = "ReservedForChange")
	private String reservedForChange;
	
	@Transient
	private Map<String, String> drug;
	
	public Map<String, String> getDrug() {
		return drug;
	}

	public void setDrug(Map<String, String> drug) {
		this.drug = drug;
	}

	public PrescribedDrugDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDrugID() {
		return drugID;
	}

	public void setDrugID(Integer drugID) {
		this.drugID = drugID;
	}

	public String getDrugDuration() {
		return drugDuration;
	}

	public void setDrugDuration(String drugDuration) {
		this.drugDuration = drugDuration;
	}

	public void setPrescribedDrugID(Long prescribedDrugID) {
		this.prescribedDrugID = prescribedDrugID;
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

	public Long getVanSerialNo() {
		return vanSerialNo;
	}

	public void setVanSerialNo(Long vanSerialNo) {
		this.vanSerialNo = vanSerialNo;
	}

	public String getVehicalNo() {
		return vehicalNo;
	}

	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
	}

	public Integer getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Integer parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
	}

	public String getSyncedBy() {
		return syncedBy;
	}

	public void setSyncedBy(String syncedBy) {
		this.syncedBy = syncedBy;
	}

	public Timestamp getSyncedDate() {
		return syncedDate;
	}

	public void setSyncedDate(Timestamp syncedDate) {
		this.syncedDate = syncedDate;
	}

	public String getReservedForChange() {
		return reservedForChange;
	}

	public void setReservedForChange(String reservedForChange) {
		this.reservedForChange = reservedForChange;
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

	public static ArrayList<PrescribedDrugDetail> getBenPrescribedDrugDetailList(JsonObject emrgCasesheet,
			Long prescriptionID) {
		ArrayList<PrescribedDrugDetail> resArray = new ArrayList<PrescribedDrugDetail>();
		PrescribedDrugDetail prescribedDrugDetail = null;
		if (emrgCasesheet.has("prescribedDrugs") && !emrgCasesheet.get("prescribedDrugs").isJsonNull()
				&& emrgCasesheet.get("prescribedDrugs").isJsonArray()) {
			for (JsonElement csobj : emrgCasesheet.getAsJsonArray("prescribedDrugs")) {
				prescribedDrugDetail = new PrescribedDrugDetail();

				prescribedDrugDetail.setPrescriptionID(prescriptionID);

				JsonObject obj = csobj.getAsJsonObject();

				if (obj.has("drugForm") && !obj.get("drugForm").isJsonNull())
					prescribedDrugDetail.setDrugForm(obj.get("drugForm").getAsString());

				if (obj.has("drugTradeOrBrandName") && !obj.get("drugTradeOrBrandName").isJsonNull())
					prescribedDrugDetail.setDrugTradeOrBrandName(obj.get("drugTradeOrBrandName").getAsString());

				// if (obj.has("genericDrugName") &&
				// !obj.get("genericDrugName").isJsonNull())
				// prescribedDrugDetail.setGenericDrugName(obj.get("genericDrugName").getAsString());

				if (obj.has("drug") && !obj.get("drug").isJsonNull() && obj.size() > 0) {
					JsonObject tmpDugDeailsOBJ = obj.getAsJsonObject("drug");
					if (tmpDugDeailsOBJ.has("drugID") && !tmpDugDeailsOBJ.get("drugID").isJsonNull()
							&& tmpDugDeailsOBJ.has("drugDisplayName")
							&& !tmpDugDeailsOBJ.get("drugDisplayName").isJsonNull()) {
						prescribedDrugDetail.setDrugID(tmpDugDeailsOBJ.get("drugID").getAsInt());
						prescribedDrugDetail.setGenericDrugName(tmpDugDeailsOBJ.get("drugDisplayName").getAsString());
					}

				}

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
				
				if (emrgCasesheet.has("beneficiaryRegID") && !emrgCasesheet.get("beneficiaryRegID").isJsonNull())
					prescribedDrugDetail.setBeneficiaryRegID(emrgCasesheet.get("beneficiaryRegID").getAsLong());
				
				if (emrgCasesheet.has("benVisitID") && !emrgCasesheet.get("benVisitID").isJsonNull())
					prescribedDrugDetail.setBenVisitID(emrgCasesheet.get("benVisitID").getAsLong());

				resArray.add(prescribedDrugDetail);
			}
		}

		return resArray;
	}
	
	public PrescribedDrugDetail(Long prescribedDrugID, Long prescriptionID, String drugForm,
			String drugTradeOrBrandName, Integer drugID, String genericDrugName, String drugStrength, String dose,
			String route, String frequency, String drugDuration, String relationToFood, String specialInstruction) {
		super();
		this.prescribedDrugID = prescribedDrugID;
		this.prescriptionID = prescriptionID;
		this.drugForm = drugForm;
		this.drugTradeOrBrandName = drugTradeOrBrandName;
		this.drugID = drugID;
		this.genericDrugName = genericDrugName;
		this.drugStrength = drugStrength;
		this.dose = dose;
		this.route = route;
		this.frequency = frequency;
		this.drugDuration = drugDuration;
		this.relationToFood = relationToFood;
		this.specialInstruction = specialInstruction;
	}

	public static ArrayList<PrescribedDrugDetail> getprescribedDrugs(ArrayList<Object[]> resList) {
		ArrayList<PrescribedDrugDetail> resArray = new ArrayList<PrescribedDrugDetail>();
		PrescribedDrugDetail cOBJ=null;
		if (resList != null && resList.size() > 0) {
			
			for (Object[] obj : resList) {
				
				cOBJ = new PrescribedDrugDetail((Long)obj[0], (Long)obj[1], (String)obj[2], (String)obj[3], (Integer)obj[4], (String)obj[5], 
						(String)obj[6], (String)obj[7], (String)obj[8], (String)obj[9], (String)obj[10], (String)obj[11], (String)obj[12]);
				resArray.add(cOBJ);
			}
		}
		return resArray;
	}
}
