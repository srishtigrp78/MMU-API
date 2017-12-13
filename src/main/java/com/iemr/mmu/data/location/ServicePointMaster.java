package com.iemr.mmu.data.location;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_servicepoint")
public class ServicePointMaster {

	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ServicePointID")
	private Integer servicePointID;
	@Expose
	@Column(name = "ServicePointName")
	private String servicePointName;
	@Expose
	@Column(name = "ServicePointDesc")
	private String servicePointDesc;
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
	@Column(name = "ServicePointHQAddress")
	private String servicePointHQAddress;
	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceID;
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

	public ServicePointMaster() {
	}

	public ServicePointMaster(Integer servicePointID, String servicePointName, String servicePointDesc,
			Integer providerServiceMapID, Integer countryID, Integer stateID, Integer districtID,
			Integer districtBlockID, Integer districtBranchID, String servicePointHQAddress, Integer parkingPlaceID,
			Boolean deleted, String processed, String createdBy, Timestamp createdDate, String modifiedBy,
			Timestamp lastModDate) {
		super();
		this.servicePointID = servicePointID;
		this.servicePointName = servicePointName;
		this.servicePointDesc = servicePointDesc;
		this.providerServiceMapID = providerServiceMapID;
		this.countryID = countryID;
		this.stateID = stateID;
		this.districtID = districtID;
		this.districtBlockID = districtBlockID;
		this.districtBranchID = districtBranchID;
		this.servicePointHQAddress = servicePointHQAddress;
		this.parkingPlaceID = parkingPlaceID;
		this.deleted = deleted;
		this.processed = processed;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
	}

	public Integer getServicePointID() {
		return servicePointID;
	}

	public void setServicePointID(Integer servicePointID) {
		this.servicePointID = servicePointID;
	}

	public String getServicePointName() {
		return servicePointName;
	}

	public void setServicePointName(String servicePointName) {
		this.servicePointName = servicePointName;
	}

	public String getServicePointDesc() {
		return servicePointDesc;
	}

	public void setServicePointDesc(String servicePointDesc) {
		this.servicePointDesc = servicePointDesc;
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

	public String getServicePointHQAddress() {
		return servicePointHQAddress;
	}

	public void setServicePointHQAddress(String servicePointHQAddress) {
		this.servicePointHQAddress = servicePointHQAddress;
	}

	public Integer getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Integer parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
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
