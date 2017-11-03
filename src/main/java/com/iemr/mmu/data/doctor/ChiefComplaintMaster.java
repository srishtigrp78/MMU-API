package com.iemr.mmu.data.doctor;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_chiefcomplaint")
public class ChiefComplaintMaster {
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ChiefComplaintID")
	private Integer chiefComplaintID;
	@Expose
	@Column(name = "ChiefComplaint")
	private String chiefComplaint;
	@Expose
	@Column(name = "ChiefComplaintDesc")
	private String chiefComplaintDesc;
	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;
	@Expose
	@Column(name = "Processed")
	private Character processed;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate")
	private Timestamp createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate")
	private Timestamp lastModDate;

	public ChiefComplaintMaster() {
	}

	public ChiefComplaintMaster(Integer chiefComplaintID, String chiefComplaint, String chiefComplaintDesc,
			Boolean deleted, Character processed, String createdBy, Timestamp createdDate, String modifiedBy,
			Timestamp lastModDate) {
		super();
		this.chiefComplaintID = chiefComplaintID;
		this.chiefComplaint = chiefComplaint;
		this.chiefComplaintDesc = chiefComplaintDesc;
		this.deleted = deleted;
		this.processed = processed;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
	}

	public Integer getChiefComplaintID() {
		return chiefComplaintID;
	}

	public void setChiefComplaintID(Integer chiefComplaintID) {
		this.chiefComplaintID = chiefComplaintID;
	}

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public String getChiefComplaintDesc() {
		return chiefComplaintDesc;
	}

	public void setChiefComplaintDesc(String chiefComplaintDesc) {
		this.chiefComplaintDesc = chiefComplaintDesc;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Character getProcessed() {
		return processed;
	}

	public void setProcessed(Character processed) {
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
