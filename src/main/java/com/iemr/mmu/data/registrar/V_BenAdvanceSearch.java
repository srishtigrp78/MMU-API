package com.iemr.mmu.data.registrar;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "v_benadvancesearch")
public class V_BenAdvanceSearch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;
	@Expose
	@Column(name = "BeneficiaryID")
	private String beneficiaryID;
	@Expose
	@Column(name = "FirstName")
	private String firstName;
	@Expose
	@Column(name = "LastName")
	private String lastName;
	@Expose
	@Column(name = "GenderID")
	private Short genderID;
	@Expose
	@Column(name = "GenderName")
	private String genderName;
	@Expose
	@Column(name = "dob")
	private Timestamp dob;
	@Expose
	@Column(name = "FatherName")
	private String fatherName;
	@Expose
	@Column(name = "AadharNo")
	private String aadharNo;

	@Expose
	@Column(name = "DistrictID")
	private Integer districtID;
	@Expose
	@Column(name = "districtName")
	private String districtName;
	@Expose
	@Column(name = "DistrictBranchID")
	private Integer districtBranchID;
	@Expose
	@Column(name = "villageName")
	private String villageName;
	@Expose
	@Column(name = "PhoneNo")
	private String phoneNo;
	@Expose
	@Column(name = "GovtIdentityNo")
	private String govtIdentityNo;

	@Expose
	@Column(name = "FlowStatusFlag")
	private Character flowStatusFlag;

	public V_BenAdvanceSearch() {
	}

	public V_BenAdvanceSearch(Long ID, Long beneficiaryRegID, String beneficiaryID, String firstName, String lastName,
			Short genderID, String genderName, Timestamp dob, String fatherName, String aadharNo, Integer districtID,
			String districtName, Integer districtBranchID, String villageName, String phoneNo, String govtIdentityNo,
			Character flowStatusFlag) {
		super();
		this.beneficiaryRegID = beneficiaryRegID;
		this.beneficiaryID = beneficiaryID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.genderID = genderID;
		this.genderName = genderName;
		this.dob = dob;
		this.fatherName = fatherName;
		this.aadharNo = aadharNo;
		this.districtID = districtID;
		this.districtName = districtName;
		this.districtBranchID = districtBranchID;
		this.villageName = villageName;
		this.phoneNo = phoneNo;
		this.govtIdentityNo = govtIdentityNo;
		this.flowStatusFlag = flowStatusFlag;
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public String getBeneficiaryID() {
		return beneficiaryID;
	}

	public void setBeneficiaryID(String beneficiaryID) {
		this.beneficiaryID = beneficiaryID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Short getGenderID() {
		return genderID;
	}

	public void setGenderID(Short genderID) {
		this.genderID = genderID;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public Timestamp getDob() {
		return dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public Integer getDistrictID() {
		return districtID;
	}

	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public Integer getDistrictBranchID() {
		return districtBranchID;
	}

	public void setDistrictBranchID(Integer districtBranchID) {
		this.districtBranchID = districtBranchID;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getGovtIdentityNo() {
		return govtIdentityNo;
	}

	public void setGovtIdentityNo(String govtIdentityNo) {
		this.govtIdentityNo = govtIdentityNo;
	}

	public Character getFlowStatusFlag() {
		return flowStatusFlag;
	}

	public void setFlowStatusFlag(Character flowStatusFlag) {
		this.flowStatusFlag = flowStatusFlag;
	}

}
