package com.iemr.mmu.data.location;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_parkingplace")
public class ParkingPlaceMaster {
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceID;
	@Expose
	@Column(name = "ParkingPlaceName")
	private String parkingPlaceName;
	@Expose
	@Column(name = "ParkingPlaceDesc")
	private String parkingPlaceDesc;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name = "CountryID")
	private Integer countryID;
	@Expose
	@Column(name = "StateID")
	private Integer stateID;
	@Expose
	@Column(name = "DistrictID")
	private Integer districtID;
	@Expose
	@Column(name = "DistrictBlockID")
	private Integer districtBlockID;
	@Expose
	@Column(name = "DistrictBranchID")
	private Integer districtBranchID;
	@Expose
	@Column(name = "AreaHQAddress")
	private String areaHQAddress;
	@Expose
	@Column(name = "Deleted")
	private String deleted;
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

	public ParkingPlaceMaster() {
	}

	public ParkingPlaceMaster(Integer parkingPlaceID, String parkingPlaceName, String parkingPlaceDesc,
			Integer providerServiceMapID, Integer countryID, Integer stateID, Integer districtID,
			Integer districtBlockID, Integer districtBranchID, String areaHQAddress, String deleted, String processed,
			String createdBy, Timestamp createdDate, String modifiedBy, Timestamp lastModDate) {
		super();
		this.parkingPlaceID = parkingPlaceID;
		this.parkingPlaceName = parkingPlaceName;
		this.parkingPlaceDesc = parkingPlaceDesc;
		this.providerServiceMapID = providerServiceMapID;
		this.countryID = countryID;
		this.stateID = stateID;
		this.districtID = districtID;
		this.districtBlockID = districtBlockID;
		this.districtBranchID = districtBranchID;
		this.areaHQAddress = areaHQAddress;
		this.deleted = deleted;
		this.processed = processed;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
	}

	public Integer getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Integer parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
	}

	public String getParkingPlaceName() {
		return parkingPlaceName;
	}

	public void setParkingPlaceName(String parkingPlaceName) {
		this.parkingPlaceName = parkingPlaceName;
	}

	public String getParkingPlaceDesc() {
		return parkingPlaceDesc;
	}

	public void setParkingPlaceDesc(String parkingPlaceDesc) {
		this.parkingPlaceDesc = parkingPlaceDesc;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Integer getCountryID() {
		return countryID;
	}

	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
	}

	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

	public Integer getDistrictID() {
		return districtID;
	}

	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}

	public Integer getDistrictBlockID() {
		return districtBlockID;
	}

	public void setDistrictBlockID(Integer districtBlockID) {
		this.districtBlockID = districtBlockID;
	}

	public Integer getDistrictBranchID() {
		return districtBranchID;
	}

	public void setDistrictBranchID(Integer districtBranchID) {
		this.districtBranchID = districtBranchID;
	}

	public String getAreaHQAddress() {
		return areaHQAddress;
	}

	public void setAreaHQAddress(String areaHQAddress) {
		this.areaHQAddress = areaHQAddress;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
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
