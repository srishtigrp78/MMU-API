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
@Table(name = "t_benFamilyHistory")
public class BenFamilyHistory {
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
	@Column(name = "FamilyMember")
	private String familyMember;
	
	@Expose
	@Column(name = "DiseaseType")
	private String diseaseType;
	
	@Expose
	@Column(name = "IsGeneticDisorder")
	private Boolean isGeneticDisorder;
	
	@Expose
	@Column(name = "GeneticDisorder")
	private String geneticDisorder;
	
	@Expose
	@Column(name = "IsConsanguineousMarrige")
	private Boolean isConsanguineousMarrige;

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
	private List<Map<String,Object>> familyDiseaseList;

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

	public String getFamilyMember() {
		return familyMember;
	}

	public void setFamilyMember(String familyMember) {
		this.familyMember = familyMember;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public Boolean getIsGeneticDisorder() {
		return isGeneticDisorder;
	}

	public void setIsGeneticDisorder(Boolean isGeneticDisorder) {
		this.isGeneticDisorder = isGeneticDisorder;
	}

	public String getGeneticDisorder() {
		return geneticDisorder;
	}

	public void setGeneticDisorder(String geneticDisorder) {
		this.geneticDisorder = geneticDisorder;
	}

	public Boolean getIsConsanguineousMarrige() {
		return isConsanguineousMarrige;
	}

	public void setIsConsanguineousMarrige(Boolean isConsanguineousMarrige) {
		this.isConsanguineousMarrige = isConsanguineousMarrige;
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

	public List<Map<String,Object>> getFamilyDiseaseList() {
		return familyDiseaseList;
	}

	public void setFamilyDiseaseList(List<Map<String,Object>> familyDiseaseList) {
		this.familyDiseaseList = familyDiseaseList;
	}

	public Long getID() {
		return ID;
	}
	
	public ArrayList<BenFamilyHistory> getBenFamilyHistory(){
		
			ArrayList<BenFamilyHistory> benFamilyHistoryList=new ArrayList<BenFamilyHistory>();
			if(null != familyDiseaseList){
				for(Map<String,Object> disease: familyDiseaseList){
					BenFamilyHistory benFamilyHistory = new BenFamilyHistory();
					benFamilyHistory.setBeneficiaryRegID(beneficiaryRegID);
					benFamilyHistory.setBenVisitID(benVisitID);
					benFamilyHistory.setProviderServiceMapID(providerServiceMapID);
					benFamilyHistory.setCreatedBy(createdBy);
								
					benFamilyHistory.setGeneticDisorder(geneticDisorder);
					benFamilyHistory.setIsGeneticDisorder(isGeneticDisorder);
					benFamilyHistory.setIsConsanguineousMarrige(isConsanguineousMarrige);
					
					if(null != disease.get("diseaseType")){
						if(null !=  disease.get("otherDiseaseType")){
							benFamilyHistory.setDiseaseType(disease.get("diseaseType") +"-"+disease.get("otherDiseaseType"));
						}else{
							benFamilyHistory.setDiseaseType(disease.get("diseaseType").toString());
						}
					}
					
					List<String> familyMemberList = (List<String>) disease.get("familyMembers");
					
					String familyMembers = "";
					for(String familyMember: familyMemberList){
						familyMembers += familyMember +",";
					}	
					benFamilyHistory.setFamilyMember(familyMembers);
					benFamilyHistoryList.add(benFamilyHistory);
				}
			}
			return benFamilyHistoryList;
	}
}
