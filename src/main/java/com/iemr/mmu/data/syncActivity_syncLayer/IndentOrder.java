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

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_indentorder")
public class IndentOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "IndentOrderID", insertable = false, updatable = false)
	private Long indentOrderID;

	@Expose
	@Column(name = "IndentID")
	private Long indentID;

	@Expose
	@Column(name = "ItemID")
	private Long itemID;

	@Expose
	@Column(name = "itemName")
	private String itemName;

	@Expose
	@Column(name = "QOH")
	private Long qOH;

	@Expose
	@Column(name = "RequiredQty")
	private Long requiredQty;

	@Expose
	@Column(name = "Remarks")
	private String remarks;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;

	@Expose
	@Column(name = "VanID")
	private Long vanID;

	@Expose
	@Column(name = "Status")
	private String status;

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
	@Column(name = "CreatedDate")
	private Timestamp createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate")
	private Timestamp lastModDate;

	@Expose
	@Column(name = "ParkingPlaceID")
	private Long parkingPlaceID;

	@Expose
	@Column(name = "VanSerialNo")
	private Long vanSerialNo;

	@Expose
	@Column(name = "FromFacilityID")
	private Integer fromFacilityID;

	@Expose
	@Column(name = "SyncFacilityID")
	private Integer syncFacilityID;

	public Long getIndentOrderID() {
		return indentOrderID;
	}

	public void setIndentOrderID(Long indentOrderID) {
		this.indentOrderID = indentOrderID;
	}

	public Long getIndentID() {
		return indentID;
	}

	public void setIndentID(Long indentID) {
		this.indentID = indentID;
	}

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getqOH() {
		return qOH;
	}

	public void setqOH(Long qOH) {
		this.qOH = qOH;
	}

	public Long getRequiredQty() {
		return requiredQty;
	}

	public void setRequiredQty(Long requiredQty) {
		this.requiredQty = requiredQty;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Long getVanID() {
		return vanID;
	}

	public void setVanID(Long vanID) {
		this.vanID = vanID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Long getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Long parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
	}

	public Long getVanSerialNo() {
		return vanSerialNo;
	}

	public void setVanSerialNo(Long vanSerialNo) {
		this.vanSerialNo = vanSerialNo;
	}

	public Integer getFromFacilityID() {
		return fromFacilityID;
	}

	public void setFromFacilityID(Integer fromFacilityID) {
		this.fromFacilityID = fromFacilityID;
	}

	public Integer getSyncFacilityID() {
		return syncFacilityID;
	}

	public void setSyncFacilityID(Integer syncFacilityID) {
		this.syncFacilityID = syncFacilityID;
	}

}
