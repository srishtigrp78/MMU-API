package com.iemr.mmu.data.benFlowStatus;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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

	private transient String firstName;

	private transient String lastName;

	@Expose
	@Column(name = "ben_age")
	private String ben_age;

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
	private String ben_gender;

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
	private String district;

	@Expose
	@Column(name = "village")
	private String village;

	private transient Address permanentAddress; 

	public BeneficiaryFlowStatus() {
	}


}
