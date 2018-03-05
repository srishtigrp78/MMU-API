package com.iemr.mmu.data.benFlowStatus;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Long ben_flow_id;
	@Expose
	@Column(name = "beneficiary_reg_id")
	private Long beneficiary_reg_id;
	@Expose
	@Column(name = "beneficiary_visit_id")
	private Long beneficiary_visit_id;
	@Expose
	@Column(name = "beneficiary_visit_code")
	private Long beneficiary_visit_code;
	@Expose
	@Column(name = "visit_reason")
	private String visit_reason;
	@Expose
	@Column(name = "visit_category")
	private String visit_category;
	@Expose
	@Column(name = "visit_no")
	private Short visit_no;
	@Expose
	@Column(name = "nurse_flag")
	private Short nurse_flag;
	@Expose
	@Column(name = "doctor_flag")
	private Short doctor_flag;
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
	private String created_by;
	@Expose
	@Column(name = "created_date")
	private Timestamp created_date;
	@Expose
	@Column(name = "modified_by")
	private String modified_by;
	@Expose
	@Column(name = "modified_date", insertable = false)
	private Timestamp modified_date;

	@Expose
	@Column(name = "ben_name")
	private String ben_name;
	@Expose
	@Column(name = "ben_age")
	private String ben_age;
	@Expose
	@Column(name = "ben_dob")
	private Timestamp ben_dob;
	@Expose
	@Column(name = "ben_gender")
	private String ben_gender;
	@Expose
	@Column(name = "ben_phone_no")
	private String ben_phone_no;
	@Expose
	@Column(name = "ben_age_val")
	private Integer ben_age_val;
	@Expose
	@Column(name = "father_name")
	private String father_name;
	@Expose
	@Column(name = "spouse_name")
	private String spouse_name;
	@Expose
	@Column(name = "ben_gender_val")
	private Short ben_gender_val;

	public BeneficiaryFlowStatus() {
	}

	public BeneficiaryFlowStatus(Long ben_flow_id, Long beneficiary_reg_id, Long beneficiary_visit_id,
			Long beneficiary_visit_code, String visit_reason, String visit_category, Short visit_no, Short nurse_flag,
			Short doctor_flag, Short pharmacist_flag, Short lab_technician_flag, Short radiologist_flag,
			Short oncologist_flag, Short specialist_flag, String created_by, Timestamp created_date, String modified_by,
			Timestamp modified_date, String ben_name, String ben_age, Timestamp ben_dob, String ben_gender,
			String ben_phone_no, Integer ben_age_val, String father_name, String spouse_name, Short ben_gender_val) {
		super();
		this.ben_flow_id = ben_flow_id;
		this.beneficiary_reg_id = beneficiary_reg_id;
		this.beneficiary_visit_id = beneficiary_visit_id;
		this.beneficiary_visit_code = beneficiary_visit_code;
		this.visit_reason = visit_reason;
		this.visit_category = visit_category;
		this.visit_no = visit_no;
		this.nurse_flag = nurse_flag;
		this.doctor_flag = doctor_flag;
		this.pharmacist_flag = pharmacist_flag;
		this.lab_technician_flag = lab_technician_flag;
		this.radiologist_flag = radiologist_flag;
		this.oncologist_flag = oncologist_flag;
		this.specialist_flag = specialist_flag;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
		this.ben_name = ben_name;
		this.ben_age = ben_age;
		this.ben_dob = ben_dob;
		this.ben_gender = ben_gender;
		this.ben_phone_no = ben_phone_no;
		this.ben_age_val = ben_age_val;
		this.father_name = father_name;
		this.spouse_name = spouse_name;
		this.ben_gender_val = ben_gender_val;
	}

	public Short getBen_gender_val() {
		return ben_gender_val;
	}

	public void setBen_gender_val(Short ben_gender_val) {
		this.ben_gender_val = ben_gender_val;
	}

	public Long getBen_flow_id() {
		return ben_flow_id;
	}

	public void setBen_flow_id(Long ben_flow_id) {
		this.ben_flow_id = ben_flow_id;
	}

	public Long getBeneficiary_reg_id() {
		return beneficiary_reg_id;
	}

	public void setBeneficiary_reg_id(Long beneficiary_reg_id) {
		this.beneficiary_reg_id = beneficiary_reg_id;
	}

	public Long getBeneficiary_visit_id() {
		return beneficiary_visit_id;
	}

	public void setBeneficiary_visit_id(Long beneficiary_visit_id) {
		this.beneficiary_visit_id = beneficiary_visit_id;
	}

	public Long getBeneficiary_visit_code() {
		return beneficiary_visit_code;
	}

	public void setBeneficiary_visit_code(Long beneficiary_visit_code) {
		this.beneficiary_visit_code = beneficiary_visit_code;
	}

	public String getVisit_reason() {
		return visit_reason;
	}

	public void setVisit_reason(String visit_reason) {
		this.visit_reason = visit_reason;
	}

	public String getVisit_category() {
		return visit_category;
	}

	public void setVisit_category(String visit_category) {
		this.visit_category = visit_category;
	}

	public Short getVisit_no() {
		return visit_no;
	}

	public void setVisit_no(Short visit_no) {
		this.visit_no = visit_no;
	}

	public Short getNurse_flag() {
		return nurse_flag;
	}

	public void setNurse_flag(Short nurse_flag) {
		this.nurse_flag = nurse_flag;
	}

	public Short getDoctor_flag() {
		return doctor_flag;
	}

	public void setDoctor_flag(Short doctor_flag) {
		this.doctor_flag = doctor_flag;
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

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Timestamp getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
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

	public String getBen_name() {
		return ben_name;
	}

	public void setBen_name(String ben_name) {
		this.ben_name = ben_name;
	}

	public String getBen_age() {
		return ben_age;
	}

	public void setBen_age(String ben_age) {
		this.ben_age = ben_age;
	}

	public Timestamp getBen_dob() {
		return ben_dob;
	}

	public void setBen_dob(Timestamp ben_dob) {
		this.ben_dob = ben_dob;
	}

	public String getBen_gender() {
		return ben_gender;
	}

	public void setBen_gender(String ben_gender) {
		this.ben_gender = ben_gender;
	}

	public String getBen_phone_no() {
		return ben_phone_no;
	}

	public void setBen_phone_no(String ben_phone_no) {
		this.ben_phone_no = ben_phone_no;
	}

	public Integer getBen_age_val() {
		return ben_age_val;
	}

	public void setBen_age_val(Integer ben_age_val) {
		this.ben_age_val = ben_age_val;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getSpouse_name() {
		return spouse_name;
	}

	public void setSpouse_name(String spouse_name) {
		this.spouse_name = spouse_name;
	}

}
