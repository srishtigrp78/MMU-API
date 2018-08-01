package com.iemr.mmu.data.quickConsultation;

import java.sql.Timestamp;
import java.util.ArrayList;

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
	@Column(name = "PrescribedDrugID", insertable = false, updatable = false)
	private Long id;

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
	@Column(name = "PrescriptionID")
	private Long prescriptionID;

	@Expose
	@Column(name = "DrugForm")
	private String formName;

	@Expose
	@Column(name = "DrugTradeOrBrandName")
	private String drugTradeOrBrandName;

	@Expose
	@Column(name = "DrugID")
	private Integer drugID;

	@Expose
	@Column(name = "GenericDrugName")
	private String drugName;

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
	@Column(name = "DuartionUnit")
	private String unit;

	@Expose
	@Column(name = "RelationToFood")
	private String relationToFood;

	@Expose
	@Column(name = "SpecialInstruction")
	private String instructions;

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

	public PrescribedDrugDetail() {
	}

	public PrescribedDrugDetail(Long prescribedDrugID, Long prescriptionID, String drugForm,
			String drugTradeOrBrandName, Integer drugID, String genericDrugName, String drugStrength, String dose,
			String route, String frequency, String drugDuration, String drugDurationUnit, String relationToFood,
			String specialInstruction) {
		super();
		this.id = prescribedDrugID;
		this.prescriptionID = prescriptionID;
		this.formName = drugForm;
		this.drugTradeOrBrandName = drugTradeOrBrandName;
		this.drugID = drugID;
		this.drugName = genericDrugName;
		this.drugStrength = drugStrength;
		this.dose = dose;
		this.route = route;
		this.frequency = frequency;
		this.duration = drugDuration;
		this.unit = drugDurationUnit;
		this.relationToFood = relationToFood;
		this.instructions = specialInstruction;
	}

	public static ArrayList<PrescribedDrugDetail> getprescribedDrugs(ArrayList<Object[]> resList) {
		ArrayList<PrescribedDrugDetail> resArray = new ArrayList<PrescribedDrugDetail>();
		PrescribedDrugDetail cOBJ = null;
		if (resList != null && resList.size() > 0) {
			for (Object[] obj : resList) {
				cOBJ = new PrescribedDrugDetail((Long) obj[0], (Long) obj[1], (String) obj[2], (String) obj[3],
						(Integer) obj[4], (String) obj[5], (String) obj[6], (String) obj[7], (String) obj[8],
						(String) obj[9], (String) obj[10], (String) obj[11], (String) obj[12], (String) obj[13]);
				resArray.add(cOBJ);
			}
		}
		return resArray;
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

	public Long getPrescriptionID() {
		return prescriptionID;
	}

	public void setPrescriptionID(Long prescriptionID) {
		this.prescriptionID = prescriptionID;
	}

}
