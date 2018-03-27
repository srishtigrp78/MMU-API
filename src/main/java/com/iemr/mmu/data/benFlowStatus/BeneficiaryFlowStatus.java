package com.iemr.mmu.data.benFlowStatus;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

/***
 * 
 * @author NE298657
 *
 */
@Entity
@Table(name = "i_ben_flow_outreach")
public class BeneficiaryFlowStatus {

	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ben_flow_id")
	private Long benFlowID;

	@Expose
	@Column(name = "beneficiary_reg_id")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "beneficiary_visit_id")
	private Long benVisitID;

	@Expose
	@Column(name = "beneficiary_visit_code")
	private Long benVisitCode;

	@Expose
	@Column(name = "visit_reason")
	private String VisitReason;

	@Expose
	@Column(name = "visit_category")
	private String VisitCategory;

	@Expose
	@Column(name = "visit_no")
	private Short benVisitNo;

	@Expose
	@Column(name = "nurse_flag")
	private Short nurseFlag;

	@Expose
	@Column(name = "doctor_flag")
	private Short doctorFlag;

	@Expose
	@Column(name = "pharmacist_flag")
	private Short pharmacist_flag;

	@Expose
	@Column(name = "lab_technician_flag")
	private Short lab_technician_flag;

	@Expose
	@Column(name = "radiologist_flag")
	private Short radiologist_flag;

	@Expose
	@Column(name = "oncologist_flag")
	private Short oncologist_flag;

	@Expose
	@Column(name = "specialist_flag")
	private Short specialist_flag;

	@Expose
	@Column(name = "created_by")
	private String agentId;

	@Expose
	@Column(name = "created_date", insertable = false, updatable = false)
	private Timestamp visitDate;

	@Expose
	@Column(name = "modified_by")
	private String modified_by;

	@Expose
	@Column(name = "modified_date", insertable = false)
	private Timestamp modified_date;

	@Expose
	@Column(name = "ben_name")
	private String benName;

	@Expose
	@Column(name = "deleted", insertable = false)
	private Boolean deleted;

	@Transient
	private String firstName;
	@Transient
	private String lastName;

	@Expose
	@Column(name = "ben_age")
	private String age;

	@Expose
	@Column(name = "ben_age_val")
	private Integer ben_age_val;

	@Expose
	@Column(name = "ben_dob")
	private Timestamp dob;

	@Expose
	@Column(name = "ben_gender_val")
	private Short gender;

	@Expose
	@Column(name = "ben_gender")
	private String genderName;

	@Expose
	@Column(name = "ben_phone_no")
	private String preferredPhoneNum;

	@Expose
	@Column(name = "father_name")
	private String fatherName;

	@Expose
	@Column(name = "spouse_name")
	private String spouseName;

	@Expose
	@Column(name = "district")
	private String districtName;

	@Expose
	@Column(name = "village")
	private String villageName;
	@Expose
	@Column(name = "beneficiary_id")
	private Long beneficiaryID;
	@Transient
	private Address permanentAddress;

	public Long getBenFlowID() {
		return benFlowID;
	}

	public void setBenFlowID(Long benFlowID) {
		this.benFlowID = benFlowID;
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Long getBenVisitID() {
		return benVisitID;
	}

	public void setBenVisitID(Long benVisitID) {
		this.benVisitID = benVisitID;
	}

	public Long getBenVisitCode() {
		return benVisitCode;
	}

	public void setBenVisitCode(Long benVisitCode) {
		this.benVisitCode = benVisitCode;
	}

	public String getVisitReason() {
		return VisitReason;
	}

	public void setVisitReason(String visitReason) {
		VisitReason = visitReason;
	}

	public String getVisitCategory() {
		return VisitCategory;
	}

	public void setVisitCategory(String visitCategory) {
		VisitCategory = visitCategory;
	}

	public Short getBenVisitNo() {
		return benVisitNo;
	}

	public void setBenVisitNo(Short benVisitNo) {
		this.benVisitNo = benVisitNo;
	}

	public Short getNurseFlag() {
		return nurseFlag;
	}

	public void setNurseFlag(Short nurseFlag) {
		this.nurseFlag = nurseFlag;
	}

	public Short getDoctorFlag() {
		return doctorFlag;
	}

	public void setDoctorFlag(Short doctorFlag) {
		this.doctorFlag = doctorFlag;
	}

	public Short getPharmacist_flag() {
		return pharmacist_flag;
	}

	public void setPharmacist_flag(Short pharmacist_flag) {
		this.pharmacist_flag = pharmacist_flag;
	}

	public Short getLab_technician_flag() {
		return lab_technician_flag;
	}

	public void setLab_technician_flag(Short lab_technician_flag) {
		this.lab_technician_flag = lab_technician_flag;
	}

	public Short getRadiologist_flag() {
		return radiologist_flag;
	}

	public void setRadiologist_flag(Short radiologist_flag) {
		this.radiologist_flag = radiologist_flag;
	}

	public Short getOncologist_flag() {
		return oncologist_flag;
	}

	public void setOncologist_flag(Short oncologist_flag) {
		this.oncologist_flag = oncologist_flag;
	}

	public Short getSpecialist_flag() {
		return specialist_flag;
	}

	public void setSpecialist_flag(Short specialist_flag) {
		this.specialist_flag = specialist_flag;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public Timestamp getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Timestamp visitDate) {
		this.visitDate = visitDate;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public Timestamp getModified_date() {
		return modified_date;
	}

	public void setModified_date(Timestamp modified_date) {
		this.modified_date = modified_date;
	}

	public String getBenName() {
		return benName;
	}

	public void setBenName(String benName) {
		this.benName = benName;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getBen_age_val() {
		return ben_age_val;
	}

	public void setBen_age_val(Integer ben_age_val) {
		this.ben_age_val = ben_age_val;
	}

	public Timestamp getDob() {
		return dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}

	public Short getGenderID() {
		return gender;
	}

	public void setGenderID(Short genderID) {
		this.gender = genderID;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public String getPhoneNo() {
		return preferredPhoneNum;
	}

	public void setPhoneNo(String phoneNo) {
		this.preferredPhoneNum = phoneNo;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public Long getBeneficiaryID() {
		return beneficiaryID;
	}

	public void setBeneficiaryID(Long beneficiaryID) {
		this.beneficiaryID = beneficiaryID;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

}
