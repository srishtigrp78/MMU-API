package com.iemr.mmu.data.anc;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.mmu.service.anc.Utility;

@Entity
@Table(name = "t_BenMedHistory")
public class BenMedHistory {

	@Id
	@GeneratedValue
	@Expose
	@Column(name = "BenMedHistoryID")
	private Long benMedHistoryID;

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
	@Column(name = "YearofIllness")
	private Timestamp yearofIllness;

	@Expose
	@Column(name = "IllnessTypeID")
	private Integer illnessTypeID;

	@Expose
	@Column(name = "IllnessType")
	private String illnessType;

	@Expose
	@Column(name = "OtherIllnessType")
	private String otherIllnessType;

	@Expose
	@Column(name = "SurgeryID")
	private Integer surgeryID;

	@Expose
	@Column(name = "SurgeryType")
	private String surgeryType;

	@Expose
	@Column(name = "YearofSurgery")
	private Timestamp yearofSurgery;

	@Expose
	@Column(name = "OtherSurgeryType")
	private String otherSurgeryType;

	@Expose
	@Column(name = "DrugComplianceID")
	private Short drugComplianceID;

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

	public BenMedHistory() {
	}

	@Transient
	private Date yearOfIllnessTmp;
	@Transient
	private Date yearOfSurgeryTmp;

	public BenMedHistory(String illnessType, String otherIllnessType, Date yearOfIllnessTmp, String surgeryType,
			String otherSurgeryType, Date yearOfSurgeryTmp) {
		this.illnessType = illnessType;
		this.otherIllnessType = otherIllnessType;
		this.yearOfIllnessTmp = yearOfIllnessTmp;
		this.surgeryType = surgeryType;
		this.otherSurgeryType = otherSurgeryType;
		this.yearOfSurgeryTmp = yearOfSurgeryTmp;

	}

	public BenMedHistory(Long benMedHistoryID, Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			Timestamp yearofIllness, Integer illnessTypeID, String illnessType, String otherIllnessType,
			Integer surgeryID, String surgeryType, Timestamp yearofSurgery, String otrherSurgeryType,
			Short drugComplianceID, Boolean deleted, String processed, String createdBy, Timestamp createdDate,
			String modifiedBy, Timestamp lastModDate, ArrayList<Map<String, Object>> pastIllness,
			ArrayList<Map<String, Object>> pastSurgery) {
		super();
		this.benMedHistoryID = benMedHistoryID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.yearofIllness = yearofIllness;
		this.illnessTypeID = illnessTypeID;
		this.illnessType = illnessType;
		this.otherIllnessType = otherIllnessType;
		this.surgeryID = surgeryID;
		this.surgeryType = surgeryType;
		this.yearofSurgery = yearofSurgery;
		this.otherSurgeryType = otrherSurgeryType;
		this.drugComplianceID = drugComplianceID;
		this.deleted = deleted;
		this.processed = processed;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
		this.pastIllness = pastIllness;
		this.pastSurgery = pastSurgery;
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

	public Timestamp getYearofIllness() {
		return yearofIllness;
	}

	public void setYearofIllness(Timestamp yearofIllness) {
		this.yearofIllness = yearofIllness;
	}

	public Integer getIllnessTypeID() {
		return illnessTypeID;
	}

	public void setIllnessTypeID(Integer illnessTypeID) {
		this.illnessTypeID = illnessTypeID;
	}

	public String getIllnessType() {
		return illnessType;
	}

	public void setIllnessType(String illnessType) {
		this.illnessType = illnessType;
	}

	public Integer getSurgeryID() {
		return surgeryID;
	}

	public void setSurgeryID(Integer surgeryID) {
		this.surgeryID = surgeryID;
	}

	public String getSurgeryType() {
		return surgeryType;
	}

	public void setSurgeryType(String surgeryType) {
		this.surgeryType = surgeryType;
	}

	public Timestamp getYearofSurgery() {
		return yearofSurgery;
	}

	public void setYearofSurgery(Timestamp yearofSurgery) {
		this.yearofSurgery = yearofSurgery;
	}

	public Short getDrugComplianceID() {
		return drugComplianceID;
	}

	public void setDrugComplianceID(Short drugComplianceID) {
		this.drugComplianceID = drugComplianceID;
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

	public Long getBenMedHistoryID() {
		return benMedHistoryID;
	}

	public String getOtherIllnessType() {
		return otherIllnessType;
	}

	public void setOtherIllnessType(String otherIllnessType) {
		this.otherIllnessType = otherIllnessType;
	}

	public String getOtrherSurgeryType() {
		return otherSurgeryType;
	}

	public void setOtrherSurgeryType(String otrherSurgeryType) {
		this.otherSurgeryType = otrherSurgeryType;
	}

	@Transient
	@Expose
	private ArrayList<Map<String, Object>> pastIllness;
	@Transient
	@Expose
	private ArrayList<Map<String, Object>> pastSurgery;

	public ArrayList<BenMedHistory> getBenPastHistory() {
		int maxMedHistorySize = 0;
		if (pastIllness.size() > pastSurgery.size()) {
			maxMedHistorySize = pastIllness.size();
		} else {
			maxMedHistorySize = pastSurgery.size();
		}
		ArrayList<BenMedHistory> medHistoryList = new ArrayList<BenMedHistory>();
		for (int i = 0; i < maxMedHistorySize; i++) {
			BenMedHistory benMedHistory = new BenMedHistory();
			benMedHistory.setBeneficiaryRegID(beneficiaryRegID);
			benMedHistory.setBenVisitID(benVisitID);
			benMedHistory.setProviderServiceMapID(providerServiceMapID);
			benMedHistory.setCreatedBy(createdBy);
			Map<String, Object> illness = (Map<String, Object>) pastIllness.get(i);

			if (null != illness) {
				if (null != illness.get("illnessID")) {
					benMedHistory.setIllnessTypeID(Integer.parseInt(illness.get("illnessID").toString()));
				}
				if (null != illness.get("illnessType")) {
					benMedHistory.setIllnessType(illness.get("illnessType").toString());
				}
				if (null != illness.get("otherIllnessType")) {
					benMedHistory.setOtherIllnessType(illness.get("otherIllnessType").toString());
				}
			}

			String timePeriodUnit = (String) illness.get("timePeriodUnit");
			Integer timePeriodAgo = 0;
			if (null != illness.get("timePeriodAgo")) {
				timePeriodAgo = Integer.parseInt(illness.get("timePeriodAgo").toString());
			}
			benMedHistory.setYearofIllness(Utility.convertToDateFormat(timePeriodUnit, timePeriodAgo));

			Map<String, Object> surgery = (Map<String, Object>) pastSurgery.get(i);
			if (null != surgery) {
				if (null != surgery.get("surgeryID")) {
					benMedHistory.setSurgeryID(Integer.parseInt(surgery.get("surgeryID").toString()));
				}
				if (null != surgery.get("surgeryType")) {
					benMedHistory.setSurgeryType(surgery.get("surgeryType").toString());
				}
				if (null != surgery.get("otherSurgeryType")) {
					benMedHistory.setOtrherSurgeryType(surgery.get("otherSurgeryType").toString());
				}
			}

			String surgeryTimePeriodUnit = (String) surgery.get("timePeriodUnit");
			Integer surgeryTimePeriodAgo = 0;
			if (null != surgery.get("timePeriodAgo")) {
				surgeryTimePeriodAgo = Integer.parseInt(surgery.get("timePeriodAgo").toString());
			}
			benMedHistory.setYearofSurgery(Utility.convertToDateFormat(surgeryTimePeriodUnit, surgeryTimePeriodAgo));

			medHistoryList.add(benMedHistory);
		}

		return medHistoryList;
	}

}
