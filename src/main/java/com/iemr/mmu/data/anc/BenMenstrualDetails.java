package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_BenMenstrualDetails")
public class BenMenstrualDetails {
	
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "BenMenstrualID")
	private Integer benMenstrualID;

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
	@Column(name = "MenstrualCycleStatusID")
	private Short menstrualCycleStatusID;

	@Expose
	@Column(name = "Regularity")
	private String regularity;

	@Expose
	@Column(name = "MenstrualCyclelengthID")
	private Short menstrualCyclelengthID;

	@Expose
	@Column(name = "CycleLength")
	private String cycleLength;

	@Expose
	@Column(name = "MenstrualFlowDurationID")
	private Short menstrualFlowDurationID;

	@Expose
	@Column(name = "BloodFlowDuration")
	private String bloodFlowDuration;

	@Expose
	@Column(name = "MenstrualProblemID")
	private Short menstrualProblemID;

	@Expose
	@Column(name = "ProblemName")
	private String problemName;
	
	@Expose
	@Column(name = "LMPDate")
	private Timestamp lMPDate;
	
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
	
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

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

	public Short getMenstrualCycleStatusID() {
		return menstrualCycleStatusID;
	}

	public void setMenstrualCycleStatusID(Short menstrualCycleStatusID) {
		this.menstrualCycleStatusID = menstrualCycleStatusID;
	}

	public String getRegularity() {
		return regularity;
	}

	public void setRegularity(String regularity) {
		this.regularity = regularity;
	}

	public Short getMenstrualCyclelengthID() {
		return menstrualCyclelengthID;
	}

	public void setMenstrualCyclelengthID(Short menstrualCyclelengthID) {
		this.menstrualCyclelengthID = menstrualCyclelengthID;
	}

	public String getCycleLength() {
		return cycleLength;
	}

	public void setCycleLength(String cycleLength) {
		this.cycleLength = cycleLength;
	}

	public Short getMenstrualFlowDurationID() {
		return menstrualFlowDurationID;
	}

	public void setMenstrualFlowDurationID(Short menstrualFlowDurationID) {
		this.menstrualFlowDurationID = menstrualFlowDurationID;
	}

	public String getBloodFlowDuration() {
		return bloodFlowDuration;
	}

	public void setBloodFlowDuration(String bloodFlowDuration) {
		this.bloodFlowDuration = bloodFlowDuration;
	}

	public Short getMenstrualProblemID() {
		return menstrualProblemID;
	}

	public void setMenstrualProblemID(Short menstrualProblemID) {
		this.menstrualProblemID = menstrualProblemID;
	}

	public String getProblemName() {
		return problemName;
	}

	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}

	public Timestamp getlMPDate() {
		return lMPDate;
	}

	public void setlMPDate(Timestamp lMPDate) {
		this.lMPDate = lMPDate;
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

	public Integer getBenMenstrualID() {
		return benMenstrualID;
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

	public void setBenMenstrualID(Integer benMenstrualID) {
		this.benMenstrualID = benMenstrualID;
	}

	public BenMenstrualDetails(Short menstrualCycleStatusID, String regularity, Short menstrualCyclelengthID,
			String cycleLength, Short menstrualFlowDurationID, String bloodFlowDuration, Short menstrualProblemID,
			String problemName, Timestamp lMPDate) {
		super();
		this.menstrualCycleStatusID = menstrualCycleStatusID;
		this.regularity = regularity;
		this.menstrualCyclelengthID = menstrualCyclelengthID;
		this.cycleLength = cycleLength;
		this.menstrualFlowDurationID = menstrualFlowDurationID;
		this.bloodFlowDuration = bloodFlowDuration;
		this.menstrualProblemID = menstrualProblemID;
		this.problemName = problemName;
		this.lMPDate = lMPDate;
	}

	public BenMenstrualDetails(Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			Short menstrualCycleStatusID, String regularity, Short menstrualCyclelengthID, String cycleLength,
			Short menstrualFlowDurationID, String bloodFlowDuration, Short menstrualProblemID, String problemName,
			Timestamp lMPDate) {
		super();
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.menstrualCycleStatusID = menstrualCycleStatusID;
		this.regularity = regularity;
		this.menstrualCyclelengthID = menstrualCyclelengthID;
		this.cycleLength = cycleLength;
		this.menstrualFlowDurationID = menstrualFlowDurationID;
		this.bloodFlowDuration = bloodFlowDuration;
		this.menstrualProblemID = menstrualProblemID;
		this.problemName = problemName;
		this.lMPDate = lMPDate;
	}
	
	public static BenMenstrualDetails getBenMenstrualDetails(ArrayList<Object[]> menstrualHistoryDetails){
		BenMenstrualDetails menstrualDetails = null;
		if(null != menstrualHistoryDetails && menstrualHistoryDetails.size()>0){
			for(Object[] obj:menstrualHistoryDetails){
				menstrualDetails = new BenMenstrualDetails((Long)obj[0], (Long)obj[1], (Integer)obj[2], 
						(Short)obj[3], (String)obj[4], (Short)obj[5], (String)obj[6], (Short)obj[7], (String)obj[8], (Short)obj[9], 
						(String)obj[10], (Timestamp)obj[11]);
			}
		}
		return menstrualDetails;
	}
	
}
