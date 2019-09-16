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
@Table(name = "t_itemstockentry")
public class ItemStockEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "ItemStockEntryID", insertable = false, updatable = false)
	private Long itemStockEntryID;

	@Expose
	@Column(name = "VanSerialNo")
	private Long vanSerialNo;

	@Expose
	@Column(name = "FacilityID")
	private Integer facilityID;

	@Expose
	@Column(name = "SyncFacilityID")
	private Integer syncFacilityID;

	@Expose
	@Column(name = "ItemID")
	private Integer itemID;

	@Expose
	@Column(name = "Quantity")
	private Integer quantity;

	@Expose
	@Column(name = "QuantityInHand")
	private Integer quantityInHand;

	@Expose
	@Column(name = "UnitCostPrice")
	private Double totalCostPrice;

	@Expose
	@Column(name = "BatchNo")
	private String batchNo;

	@Expose
	@Column(name = "ExpiryDate")
	private Date expiryDate;

	@Expose
	@Column(name = "EntryTypeID")
	private Long entryTypeID;

	@Expose
	@Column(name = "EntryType")
	private String entryType;

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
	private Date createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate")
	private Date lastModDate;

	@Expose
	@Column(name = "VanID")
	private Long vanID;

	@Expose
	@Column(name = "ParkingPlaceID")
	private Long parkingPlaceID;

	public Long getItemStockEntryID() {
		return itemStockEntryID;
	}

	public void setItemStockEntryID(Long itemStockEntryID) {
		this.itemStockEntryID = itemStockEntryID;
	}

	public Long getVanSerialNo() {
		return vanSerialNo;
	}

	public void setVanSerialNo(Long vanSerialNo) {
		this.vanSerialNo = vanSerialNo;
	}

	public Integer getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(Integer facilityID) {
		this.facilityID = facilityID;
	}

	public Integer getSyncFacilityID() {
		return syncFacilityID;
	}

	public void setSyncFacilityID(Integer syncFacilityID) {
		this.syncFacilityID = syncFacilityID;
	}

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantityInHand() {
		return quantityInHand;
	}

	public void setQuantityInHand(Integer quantityInHand) {
		this.quantityInHand = quantityInHand;
	}

	public Double getTotalCostPrice() {
		return totalCostPrice;
	}

	public void setTotalCostPrice(Double totalCostPrice) {
		this.totalCostPrice = totalCostPrice;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Long getEntryTypeID() {
		return entryTypeID;
	}

	public void setEntryTypeID(Long entryTypeID) {
		this.entryTypeID = entryTypeID;
	}

	public String getEntryType() {
		return entryType;
	}

	public void setEntryType(String entryType) {
		this.entryType = entryType;
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

	public Long getVanID() {
		return vanID;
	}

	public void setVanID(Long vanID) {
		this.vanID = vanID;
	}

	public Long getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Long parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
	}

}
