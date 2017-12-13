package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_BenPersonalHabit")
public class BenPersonalHabit {
	
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "BenPersonalHabitID")
	private Integer benPersonalHabitID;

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
	@Column(name = "DietaryType")
	private String dietaryType;
	
	@Expose
	@Column(name = "PhysicalActivityType")
	private String physicalActivityType;
	
	@Expose
	@Column(name = "TobaccoUseStatus")
	private String tobaccoUseStatus;
	
	@Expose
	@Column(name = "TobaccoUseType")
	private String tobaccoUseType;
	
	@Expose
	@Column(name = "NumberperDay")
	private Short numberperDay;
	
	@Expose
	@Column(name = "TobaccoUseDuration")
	private Timestamp tobaccoUseDuration;
	
	@Expose
	@Column(name = "AlcoholIntakeStatus")
	private String alcoholIntakeStatus;
	
	@Expose
	@Column(name = "AlcoholType")
	private String alcoholType;
	
	@Expose
	@Column(name = "AlcoholIntakeFrequency")
	private String alcoholIntakeFrequency;
	
	@Expose
	@Column(name = "AvgAlcoholConsumption")
	private String avgAlcoholConsumption;
	
	@Expose
	@Column(name = "AlcoholDuration")
	private Timestamp alcoholDuration;

	@Expose
	@Column(name = "RiskySexualPracticesStatus")
	private Character riskySexualPracticesStatus;
	
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

	@Transient
	@Expose
	private List<Map<String, String>> tobaccoList;
	
	@Transient
	@Expose
	private List<Map<String, String>> alcoholList;

	public Integer getBenPersonalHabitID() {
		return benPersonalHabitID;
	}

	public void setBenPersonalHabitID(Integer benPersonalHabitID) {
		this.benPersonalHabitID = benPersonalHabitID;
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

	public String getDietaryType() {
		return dietaryType;
	}

	public void setDietaryType(String dietaryType) {
		this.dietaryType = dietaryType;
	}

	public String getPhysicalActivityType() {
		return physicalActivityType;
	}

	public void setPhysicalActivityType(String physicalActivityType) {
		this.physicalActivityType = physicalActivityType;
	}

	public String getTobaccoUseStatus() {
		return tobaccoUseStatus;
	}

	public void setTobaccoUseStatus(String tobaccoUseStatus) {
		this.tobaccoUseStatus = tobaccoUseStatus;
	}

	public String getTobaccoUseType() {
		return tobaccoUseType;
	}

	public void setTobaccoUseType(String tobaccoUseType) {
		this.tobaccoUseType = tobaccoUseType;
	}

	public Short getNumberperDay() {
		return numberperDay;
	}

	public void setNumberperDay(Short numberperDay) {
		this.numberperDay = numberperDay;
	}

	public Timestamp getTobaccoUseDuration() {
		return tobaccoUseDuration;
	}

	public void setTobaccoUseDuration(Timestamp tobaccoUseDuration) {
		this.tobaccoUseDuration = tobaccoUseDuration;
	}

	public String getAlcoholIntakeStatus() {
		return alcoholIntakeStatus;
	}

	public void setAlcoholIntakeStatus(String alcoholIntakeStatus) {
		this.alcoholIntakeStatus = alcoholIntakeStatus;
	}

	public String getAlcoholType() {
		return alcoholType;
	}

	public void setAlcoholType(String alcoholType) {
		this.alcoholType = alcoholType;
	}

	public String getAlcoholIntakeFrequency() {
		return alcoholIntakeFrequency;
	}

	public void setAlcoholIntakeFrequency(String alcoholIntakeFrequency) {
		this.alcoholIntakeFrequency = alcoholIntakeFrequency;
	}

	public String getAvgAlcoholConsumption() {
		return avgAlcoholConsumption;
	}

	public void setAvgAlcoholConsumption(String avgAlcoholConsumption) {
		this.avgAlcoholConsumption = avgAlcoholConsumption;
	}

	public Timestamp getAlcoholDuration() {
		return alcoholDuration;
	}

	public void setAlcoholDuration(Timestamp alcoholDuration) {
		this.alcoholDuration = alcoholDuration;
	}

	public Character getRiskySexualPracticesStatus() {
		return riskySexualPracticesStatus;
	}

	public void setRiskySexualPracticesStatus(Character riskySexualPracticesStatus) {
		this.riskySexualPracticesStatus = riskySexualPracticesStatus;
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

	public List<Map<String, String>> getTobaccoList() {
		return tobaccoList;
	}

	public void setTobaccoList(List<Map<String, String>> tobaccoList) {
		this.tobaccoList = tobaccoList;
	}

	public List<Map<String, String>> getAlcoholList() {
		return alcoholList;
	}

	public void setAlcoholList(List<Map<String, String>> alcoholList) {
		this.alcoholList = alcoholList;
	}
	
	public ArrayList<BenPersonalHabit> getPersonalHistory(){
		int maxPersonalHistorySize =0;
		if(tobaccoList.size()>alcoholList.size()){
			maxPersonalHistorySize = tobaccoList.size();
		}else{
			maxPersonalHistorySize = alcoholList.size();
		}
		ArrayList<BenPersonalHabit> personalHabitList=new ArrayList<BenPersonalHabit>();
		for(int i=0;i<maxPersonalHistorySize ; i++){
			BenPersonalHabit benPersonalHabit = new BenPersonalHabit();
			
			benPersonalHabit.setBeneficiaryRegID(beneficiaryRegID);
			benPersonalHabit.setBenVisitID(benVisitID);
			benPersonalHabit.setProviderServiceMapID(providerServiceMapID);
			benPersonalHabit.setCreatedBy(createdBy);
			benPersonalHabit.setDietaryType(dietaryType);
			benPersonalHabit.setPhysicalActivityType(physicalActivityType);
			benPersonalHabit.setRiskySexualPracticesStatus(riskySexualPracticesStatus);
			benPersonalHabit.setTobaccoUseStatus(tobaccoUseStatus);
			benPersonalHabit.setAlcoholIntakeStatus(alcoholIntakeStatus);
			
			
//			 [ { "typeOfTobacco": null, "otherTypeOfTobacco": null, "quantityPerDay": null, "duration": null, "durationUnit": null } 
			Map<String, String> tobaccoInfo=(Map<String, String>) tobaccoList.get(i);
			String otherTypeOfTobacco=tobaccoInfo.get("otherTypeOfTobacco");
			if(null != otherTypeOfTobacco){
				benPersonalHabit.setTobaccoUseType(tobaccoInfo.get("tobaccoUseType") +"-"+otherTypeOfTobacco);
			}else{
				benPersonalHabit.setTobaccoUseType(tobaccoInfo.get("tobaccoUseType"));
			}
			benPersonalHabit.setNumberperDay(new Short(tobaccoInfo.get("quantityPerDay")));
			
			String timePeriodUnit = (String) tobaccoInfo.get("durationUnit");
			Integer timePeriodAgo = 0;
			if(null != tobaccoInfo.get("duration")){
				timePeriodAgo =  Integer.parseInt(tobaccoInfo.get("duration").toString());
			}
			benPersonalHabit.setTobaccoUseDuration(convertToDateFormat(timePeriodUnit, timePeriodAgo));
			
//			[ { "typeOfAlcohol": null, "otherTypeOfAlcohol": null, "frequencyOfAlcoholIntake": null, "averageQuantityOfAlcoholConsumption": null, "duration": null, "durationUnit": null } ],
			
			Map<String, String> alcoholInfo=(Map<String, String>) alcoholList.get(i);
			String otherTypeOfAlcohol=alcoholInfo.get("otherTypeOfAlcohol");
			if(null != otherTypeOfAlcohol){
				benPersonalHabit.setAlcoholType(alcoholInfo.get("typeOfAlcohol")+"-"+otherTypeOfAlcohol);
			}else{
				benPersonalHabit.setAlcoholType(alcoholInfo.get("typeOfAlcohol"));
			}
			benPersonalHabit.setAlcoholIntakeFrequency(alcoholInfo.get("frequencyOfAlcoholIntake"));
			benPersonalHabit.setAvgAlcoholConsumption(alcoholInfo.get("averageQuantityOfAlcoholConsumption"));
			
			String durationUnit = (String) alcoholInfo.get("durationUnit");
			Integer duration = 0;
			if(null != alcoholInfo.get("duration")){
				duration =  Integer.parseInt(alcoholInfo.get("duration").toString());
			}
			benPersonalHabit.setAlcoholDuration(convertToDateFormat(timePeriodUnit, timePeriodAgo));
			
			personalHabitList.add(benPersonalHabit);
		}
		return personalHabitList;
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
