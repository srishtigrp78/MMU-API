package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_BenMenstrualDetails")
public class BenMenstrualDetails {
	
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "BenMenstrualID")
	private Long benMenstrualID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "MenstrualCycleStatusID")
	private Long menstrualCycleStatusID;

	@Expose
	@Column(name = "Regularity")
	private Long regularity;

	@Expose
	@Column(name = "MenstrualCyclelengthID")
	private Long menstrualCyclelengthID;

	@Expose
	@Column(name = "CycleLength")
	private Long cycleLength;

	@Expose
	@Column(name = "MenstrualFlowDurationID")
	private Long menstrualFlowDurationID;

	@Expose
	@Column(name = "BloodFlowDuration")
	private Long bloodFlowDuration;

	@Expose
	@Column(name = "MenstrualProblemID")
	private Long menstrualProblemID;

	@Expose
	@Column(name = "ProblemName")
	private Long problemName;
	
	@Expose
	@Column(name = "LMPDate")
	private Long lMPDate;
	
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	
}
