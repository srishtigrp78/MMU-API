package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
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
@Table(name = "t_BenAllergyHistory")
public class BenAllergyHistory {
	
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ID")
	private Long ID;

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
	@Column(name = "allergyStatus")
	private String allergyStatus;
	
	@Expose
	@Column(name = "allergyType")
	private String allergyType;
	
	@Expose
	@Column(name = "allergenName")
	private String allergenName;
	
	@Expose
	@Column(name = "allergicReactionType")
	private String allergicReactionType;
	
	@Transient
	@Expose
	private List<String> typeOfAllergicReactions;
	
	@Expose
	@Column(name = "Remarks")
	private String remarks;
	
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
	private List<Map<String, Object>> allergicList;

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

	public String getAllergyStatus() {
		return allergyStatus;
	}

	public void setAllergyStatus(String allergyStatus) {
		this.allergyStatus = allergyStatus;
	}

	public String getAllergyType() {
		return allergyType;
	}

	public void setAllergyType(String allergyType) {
		this.allergyType = allergyType;
	}

	public String getAllergenName() {
		return allergenName;
	}

	public void setAllergenName(String allergenName) {
		this.allergenName = allergenName;
	}

	public String getAllergicReactionType() {
		return allergicReactionType;
	}

	public void setAllergicReactionType(String allergicReactionType) {
		this.allergicReactionType = allergicReactionType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public List<Map<String, Object>> getAllergicList() {
		return allergicList;
	}

	public void setAllergicList(List<Map<String, Object>> allergicList) {
		this.allergicList = allergicList;
	}

	public Long getID() {
		return ID;
	}
	
	public List<String> getTypeOfAllergicReactions() {
		return typeOfAllergicReactions;
	}

	public void setTypeOfAllergicReactions(List<String> typeOfAllergicReactions) {
		this.typeOfAllergicReactions = typeOfAllergicReactions;
	}
	
//	{ "allergyType": null, "allergyName": null, "typeOfAllergicReaction": null, "otherTypeOfAllergicReaction": null }
	public ArrayList<BenAllergyHistory> getBenAllergicHistory(){
		ArrayList<BenAllergyHistory> benAllergyHistoryList=new ArrayList<BenAllergyHistory>();
		for(Map<String,Object> allergic:allergicList){
			BenAllergyHistory benAllergyHistory = new BenAllergyHistory();

			if(null != allergic.get("allergyName")){
				benAllergyHistory.setAllergenName(allergic.get("allergyName").toString());
			}
			if(null != allergic.get("allergyType")){
				benAllergyHistory.setAllergyType(allergic.get("allergyType").toString());
			}
			
			benAllergyHistory.setBeneficiaryRegID(beneficiaryRegID);
			benAllergyHistory.setBenVisitID(benVisitID);
			benAllergyHistory.setProviderServiceMapID(providerServiceMapID);
			benAllergyHistory.setAllergyStatus(allergyStatus);
			benAllergyHistory.setCreatedBy(createdBy);
			
			List<String> reactionTypesList= (List<String>) allergic.get("typeOfAllergicReactions");
			String reactionTypes = "";
			if(null != reactionTypesList){
				for(String reactionType:reactionTypesList){
					reactionTypes += reactionType + ",";
				}
			}
			
			if(null !=  allergic.get("otherTypeOfAllergicReaction")){
				String otherTypeOfAllergicReaction = allergic.get("otherTypeOfAllergicReaction").toString();
				benAllergyHistory.setAllergicReactionType(reactionTypes+"-"+otherTypeOfAllergicReaction);
			}else{
				benAllergyHistory.setAllergicReactionType(reactionTypes);
			}
			
			benAllergyHistoryList.add(benAllergyHistory);
		}
		return benAllergyHistoryList;
	}
}
