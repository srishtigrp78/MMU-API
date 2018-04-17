package com.iemr.mmu.data.pnc;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.mmu.data.anc.ANCDiagnosis;

@Entity
@Table(name = "t_pncdiagnosis")
public class PNCDiagnosis {
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
	@Column(name = "VisitCode")
	private Long visitCode;
	
	@Expose
	@Column(name = "PrescriptionID")
	private Long prescriptionID;
	
	@Expose
	@Column(name = "ProvisionalDiagnosis")
	private String provisionalDiagnosis;
	
	@Expose
	@Column(name = "ConfirmatoryDiagnosis")
	private String confirmatoryDiagnosis;
	
	@Expose
	@Column(name = "IsMaternalDeath")
	private Boolean isMaternalDeath;
	
	@Expose
	@Column(name = "PlaceOfDeath")
	private String placeOfDeath;
	
	@Expose
	@Column(name = "DateOfDeath")
	private Date dateOfDeath;
	
	@Expose
	@Column(name = "CauseOfDeath")
	private String causeOfDeath;

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

	public String getProvisionalDiagnosis() {
		return provisionalDiagnosis;
	}

	public void setProvisionalDiagnosis(String provisionalDiagnosis) {
		this.provisionalDiagnosis = provisionalDiagnosis;
	}

	public String getConfirmatoryDiagnosis() {
		return confirmatoryDiagnosis;
	}

	public void setConfirmatoryDiagnosis(String confirmatoryDiagnosis) {
		this.confirmatoryDiagnosis = confirmatoryDiagnosis;
	}

	public Boolean getIsMaternalDeath() {
		return isMaternalDeath;
	}

	public void setIsMaternalDeath(Boolean isMaternalDeath) {
		this.isMaternalDeath = isMaternalDeath;
	}

	public String getPlaceOfDeath() {
		return placeOfDeath;
	}

	public void setPlaceOfDeath(String placeOfDeath) {
		this.placeOfDeath = placeOfDeath;
	}

	public Date getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public String getCauseOfDeath() {
		return causeOfDeath;
	}

	public void setCauseOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
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

	public PNCDiagnosis(Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID, Long prescriptionID,
			String provisionalDiagnosis, String confirmatoryDiagnosis, Boolean isMaternalDeath, String placeOfDeath,
			Date dateOfDeath, String causeOfDeath) {
		super();
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.prescriptionID = prescriptionID;
		this.provisionalDiagnosis = provisionalDiagnosis;
		this.confirmatoryDiagnosis = confirmatoryDiagnosis;
		this.isMaternalDeath = isMaternalDeath;
		this.placeOfDeath = placeOfDeath;
		this.dateOfDeath = dateOfDeath;
		this.causeOfDeath = causeOfDeath;
	}
	
	public static PNCDiagnosis getPNCDiagnosisDetails(ArrayList<Object[]> resList) {
		ArrayList<PNCDiagnosis> resArray = new ArrayList<PNCDiagnosis>();
		PNCDiagnosis cOBJ = null;
		if(null != resList && resList.size()>0){
			for (Object[] obj : resList) {
				cOBJ = new PNCDiagnosis((Long)obj[0], (Long)obj[1], (Integer)obj[2], (Long)obj[3], (String)obj[4], 
						(String)obj[5], (Boolean)obj[6], (String)obj[7], (Date)obj[8], (String)obj[9]);
				
			}
		}
		return cOBJ;
	}
	
}
