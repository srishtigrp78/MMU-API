package com.iemr.mmu.data.masterdata.ncdscreening;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.mmu.data.doctor.LabTestMaster;

@Entity
@Table(name = "m_bpanddiabeticstatus")
public class BPAndDiabeticStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "BPAndDiabeticStatusID")
	private Short bpAndDiabeticStatusID; 
	
	@Expose
	@Column(name = "BPAndDiabeticStatus")
	private String bpAndDiabeticStatus;
	
	@Expose
	@Column(name = "BPAndDiabeticStatusDesc")
	private String bpAndDiabeticStatusDesc;
	
	@Expose
	@Column(name = "IsBPStatus")
	private Boolean isBPStatus;
	
	@Expose(serialize = false)
	@Column(name = "deleted")
	private Boolean deleted; 
	
	@Expose(serialize = false)
	@Column(name = "processed")
	private String processed; 
	
	@Expose(serialize = false)
	@Column(name = "createdBy")
	private String createdBy; 
	
	@Expose(serialize = false)
	@Column(name = "createdDate")
	private Date createdDate; 
	
	@Expose(serialize = false)
	@Column(name = "modifiedBy")
	private String modifiedBy; 
	
	@Expose(serialize = false)
	@Column(name = "lastModDate")
	private Date lastModDate;

	public BPAndDiabeticStatus() {
		super();
	}
	
	
	public BPAndDiabeticStatus(Short bpAndDiabeticStatusID, String bpAndDiabeticStatus) {
		super();
		this.bpAndDiabeticStatusID = bpAndDiabeticStatusID;
		this.bpAndDiabeticStatus = bpAndDiabeticStatus;
	}


	public static ArrayList<BPAndDiabeticStatus> getBPAndDiabeticStatus(ArrayList<Object[]> resList) {
		ArrayList<BPAndDiabeticStatus> resArray = new ArrayList<BPAndDiabeticStatus>();
		for (Object[] obj : resList) {
			BPAndDiabeticStatus cOBJ = new BPAndDiabeticStatus((Short)obj[0], (String)obj[1]);
			resArray.add(cOBJ);
		}
		return resArray;
	}

	public Short getBpAndDiabeticStatusID() {
		return bpAndDiabeticStatusID;
	}

	public void setBpAndDiabeticStatusID(Short bpAndDiabeticStatusID) {
		this.bpAndDiabeticStatusID = bpAndDiabeticStatusID;
	}

	public String getBpAndDiabeticStatus() {
		return bpAndDiabeticStatus;
	}

	public void setBpAndDiabeticStatus(String bpAndDiabeticStatus) {
		this.bpAndDiabeticStatus = bpAndDiabeticStatus;
	}

	public String getBpAndDiabeticStatusDesc() {
		return bpAndDiabeticStatusDesc;
	}

	public void setBpAndDiabeticStatusDesc(String bpAndDiabeticStatusDesc) {
		this.bpAndDiabeticStatusDesc = bpAndDiabeticStatusDesc;
	}

	public Boolean getIsBPStatus() {
		return isBPStatus;
	}

	public void setIsBPStatus(Boolean isBPStatus) {
		this.isBPStatus = isBPStatus;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}

	
	
	
}
