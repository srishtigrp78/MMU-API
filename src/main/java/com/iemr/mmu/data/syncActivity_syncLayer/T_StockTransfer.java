/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mmu.data.syncActivity_syncLayer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_stocktransfer")
public class T_StockTransfer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "StockTransferID", insertable = false, updatable = false)
	private Long stockTransferID;

	@Expose
	@Column(name = "VanSerialNo")
	private Long vanSerialNo;

	@Expose
	@Column(name = "TransferFromFacilityID")
	private Integer transferFromFacilityID;;

	@Expose
	@Column(name = "SyncFacilityID")
	private Integer syncFacilityID;

	@Expose
	@Column(name = "TransferToFacilityID")
	private Integer transferToFacilityID;

	@Expose
	@Column(name = "RefNo")
	private String refNo;

	@Expose
	@Column(name = "IssueType")
	private String issueType;

	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;

	@Expose
	@Column(name = "Processed")
	private String processed;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "VanID")
	private Long vanID;

	@Expose
	@Column(name = "ToVanID")
	private Long toVanID;

	@Expose
	@Column(name = "CreatedDate")
	private Date createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate")
	private Date lastModDate;

	public Long getStockTransferID() {
		return stockTransferID;
	}

	public void setStockTransferID(Long stockTransferID) {
		this.stockTransferID = stockTransferID;
	}

	public Long getVanSerialNo() {
		return vanSerialNo;
	}

	public void setVanSerialNo(Long vanSerialNo) {
		this.vanSerialNo = vanSerialNo;
	}

	public Integer getTransferFromFacilityID() {
		return transferFromFacilityID;
	}

	public void setTransferFromFacilityID(Integer transferFromFacilityID) {
		this.transferFromFacilityID = transferFromFacilityID;
	}

	public Integer getSyncFacilityID() {
		return syncFacilityID;
	}

	public void setSyncFacilityID(Integer syncFacilityID) {
		this.syncFacilityID = syncFacilityID;
	}

	public Integer getTransferToFacilityID() {
		return transferToFacilityID;
	}

	public void setTransferToFacilityID(Integer transferToFacilityID) {
		this.transferToFacilityID = transferToFacilityID;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
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

	public Long getVanID() {
		return vanID;
	}

	public void setVanID(Long vanID) {
		this.vanID = vanID;
	}

	public Long getToVanID() {
		return toVanID;
	}

	public void setToVanID(Long toVanID) {
		this.toVanID = toVanID;
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
