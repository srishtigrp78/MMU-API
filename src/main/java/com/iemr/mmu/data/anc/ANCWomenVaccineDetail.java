package com.iemr.mmu.data.anc;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_ancwomenvaccinedetail")
public class ANCWomenVaccineDetail {
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
	@Column(name = "VaccineName")
	private String vaccineName;

	@Expose
	@Column(name = "Status")
	private String status;

	@Expose
	@Column(name = "ReceivedDate")
	private Date receivedDate;

	@Expose
	@Column(name = "ReceivedFacilityName")
	private String receivedFacilityName;

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

	public ANCWomenVaccineDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ANCWomenVaccineDetail(Long iD, Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			String vaccineName, String status, Date receivedDate, String receivedFacilityName) {
		super();
		ID = iD;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.vaccineName = vaccineName;
		this.status = status;
		this.receivedDate = receivedDate;
		this.receivedFacilityName = receivedFacilityName;
	}

	public static ArrayList<ANCWomenVaccineDetail> getANCWomenVaccineDetails(ArrayList<Object[]> resList) {
		ArrayList<ANCWomenVaccineDetail> resArray = new ArrayList<ANCWomenVaccineDetail>();
		for (Object[] obj : resList) {
			ANCWomenVaccineDetail cOBJ = new ANCWomenVaccineDetail((Long)obj[0], (Long)obj[1], (Long)obj[2], (Integer)obj[3] , (String)obj[4], 
					(String)obj[5], (Date)obj[6], (String)obj[7]);
			resArray.add(cOBJ);
		}
		return resArray;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
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

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getReceivedFacilityName() {
		return receivedFacilityName;
	}

	public void setReceivedFacilityName(String receivedFacilityName) {
		this.receivedFacilityName = receivedFacilityName;
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

}
