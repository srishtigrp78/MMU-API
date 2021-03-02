package com.iemr.mmu.data.syncActivity_syncLayer;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_downloadedCaseSheet")
public class DownloadedCaseSheet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "cid")
	private Integer cid;
	
	@Expose
	@Column(name = "tmVisitCode")
	private Long tmVisitCode;
	
	@Expose
	@Column(name = "mmuVisitCode")
	private Long mmuVisitCode;
	
	@Expose
	@Column(name = "TmCaseSheetResponse")
	private String TmCaseSheetResponse;
	
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;
	@Expose
	@Column(name = "Processed")
	private String processed = "P";
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate" ,insertable = false, updatable = false)
	private Timestamp createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate",insertable = false, updatable = false)
	private Timestamp lastModDate;

	public Long getTmVisitCode() {
		return tmVisitCode;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
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

	public void setTmVisitCode(Long tmVisitCode) {
		this.tmVisitCode = tmVisitCode;
	}

	public Long getMmuVisitCode() {
		return mmuVisitCode;
	}

	public void setMmuVisitCode(Long mmuVisitCode) {
		this.mmuVisitCode = mmuVisitCode;
	}

	public String getTmCaseSheetResponse() {
		return TmCaseSheetResponse;
	}

	public void setTmCaseSheetResponse(String tmCaseSheetResponse) {
		TmCaseSheetResponse = tmCaseSheetResponse;
	}
}
