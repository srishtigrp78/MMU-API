package com.iemr.mmu.data.masterdata.ncdscreening;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_ncdscreeningreason")
public class NCDScreeningReason {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "ncdScreeningReasonID")
	private int ncdScreeningReasonID; 
	
	@Expose
	@Column(name = "ncdScreeningReason")
	private String ncdScreeningReason; 
	
	@Expose
	@Column(name = "ncdScreeningReasonDesc")
	private String ncdScreeningReasonDesc; 
	
	@Expose
	@Column(name = "ncdScreeningConditionID")
	private int ncdScreeningConditionID; 
	
	@Expose
	@Column(name = "deleted")
	private boolean deleted; 
	
	@Expose
	@Column(name = "processed")
	private String processed; 
	
	@Expose
	@Column(name = "createdBy")
	private String createdBy; 
	
	@Expose
	@Column(name = "createdDate")
	private Date createdDate; 
	
	@Expose
	@Column(name = "modifiedBy")
	private String modifiedBy; 
	
	@Expose
	@Column(name = "lastModDate")
	private Date lastModDate;

	public int getNcdScreeningReasonID() {
		return ncdScreeningReasonID;
	}

	public void setNcdScreeningReasonID(int ncdScreeningReasonID) {
		this.ncdScreeningReasonID = ncdScreeningReasonID;
	}

	public String getNcdScreeningReason() {
		return ncdScreeningReason;
	}

	public void setNcdScreeningReason(String ncdScreeningReason) {
		this.ncdScreeningReason = ncdScreeningReason;
	}

	public String getNcdScreeningReasonDesc() {
		return ncdScreeningReasonDesc;
	}

	public void setNcdScreeningReasonDesc(String ncdScreeningReasonDesc) {
		this.ncdScreeningReasonDesc = ncdScreeningReasonDesc;
	}

	public int getNcdScreeningConditionID() {
		return ncdScreeningConditionID;
	}

	public void setNcdScreeningConditionID(int ncdScreeningConditionID) {
		this.ncdScreeningConditionID = ncdScreeningConditionID;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
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
