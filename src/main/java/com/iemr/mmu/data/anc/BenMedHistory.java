package com.iemr.mmu.data.anc;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

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
	@Column(name = "SurgeryID")
	private Integer surgeryID;
	
	@Expose
	@Column(name = "SurgeryType")
	private String surgeryType;
	
	@Expose
	@Column(name = "YearofSurgery")
	private Timestamp yearofSurgery;
	
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
	
	@Transient
	@Expose
	private ArrayList<Map<String,Object>> pastIllness;
	@Transient
	@Expose
	private ArrayList<Map<String,Object>> pastSurgery;

	public ArrayList<BenMedHistory> getBenPastHistory() {
		int maxMedHistorySize =0;
		if(pastIllness.size()>pastSurgery.size()){
			maxMedHistorySize = pastIllness.size();
		}else{
			maxMedHistorySize = pastSurgery.size();
		}
		ArrayList<BenMedHistory> medHistoryList=new ArrayList<BenMedHistory>();
		for(int i=0;i<maxMedHistorySize ; i++){
			BenMedHistory benMedHistory = new BenMedHistory();
				benMedHistory.setBeneficiaryRegID(beneficiaryRegID);
				benMedHistory.setBenVisitID(benVisitID);
				benMedHistory.setProviderServiceMapID(providerServiceMapID);
				benMedHistory.setCreatedBy(createdBy);
				Map<String,Object> illness=(Map<String, Object>) pastIllness.get(i).get("illnessType");
			if(null != illness){
				if(null != illness.get("illnessID")){
					benMedHistory.setIllnessTypeID(Integer.parseInt(illness.get("illnessID").toString()));
				}
				String otherIllnessType = (String) pastIllness.get(i).get("otherIllnessType");
				if(null != illness.get("illnessType")){
					if(null != otherIllnessType){
						benMedHistory.setIllnessType(illness.get("illnessType")+" - "+otherIllnessType);
					}else{
						benMedHistory.setIllnessType(illness.get("illnessType").toString());
					}
				}
			}
			
			String timePeriodUnit = (String) pastIllness.get(i).get("timePeriodUnit");
			Integer timePeriodAgo = 0;
			if(null != pastIllness.get(i).get("timePeriodAgo")){
				timePeriodAgo =  Integer.parseInt(pastIllness.get(i).get("timePeriodAgo").toString());
			}
			benMedHistory.setYearofIllness(convertToDateFormat(timePeriodUnit, timePeriodAgo));
			
			Map<String,Object> surgery=(Map<String, Object>) pastSurgery.get(i).get("surgeryType");
			if(null != surgery){
				if(null != surgery.get("surgeryID")){
					benMedHistory.setSurgeryID(Integer.parseInt(surgery.get("surgeryID").toString()));
				}
				String otherSurgeryType = (String) pastSurgery.get(i).get("otherSurgeryType");
				if(null != surgery.get("surgeryType")){
					if(null != otherSurgeryType){
						benMedHistory.setSurgeryType(surgery.get("surgeryType").toString()+" - "+otherSurgeryType);
					}else{
						benMedHistory.setSurgeryType(surgery.get("surgeryType").toString());
					}
				}
			}
			
			String surgeryTimePeriodUnit = (String) pastSurgery.get(i).get("timePeriodUnit");
			Integer surgeryTimePeriodAgo = 0;
			if(null != pastSurgery.get(i).get("timePeriodAgo")){
				surgeryTimePeriodAgo =  Integer.parseInt(pastSurgery.get(i).get("timePeriodAgo").toString());
			}
			benMedHistory.setYearofSurgery(convertToDateFormat(surgeryTimePeriodUnit, surgeryTimePeriodAgo));
			
			medHistoryList.add(benMedHistory);
		}

		return medHistoryList;
	}
	
	public Timestamp convertToDateFormat(String timePeriodUnit, Integer timePeriodAgo){
		
		Calendar cal = Calendar.getInstance();
		if(timePeriodUnit.equals("Years")){
			cal.add(Calendar.YEAR, -timePeriodAgo);
		}else if(timePeriodUnit.equals("Months")){
			cal.add(Calendar.MONTH, -timePeriodAgo);
		}else if(timePeriodUnit.equals("Weeks")){
			cal.add(Calendar.DATE, -(7*timePeriodAgo));
		}else if(timePeriodUnit.equals("Days")){
			cal.add(Calendar.DATE, -timePeriodAgo);
		}
		
		return new Timestamp(cal.getTimeInMillis());
	}
	
}
