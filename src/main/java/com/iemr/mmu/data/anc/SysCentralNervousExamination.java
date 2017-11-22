package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_Sys_CentralNervous")
public class SysCentralNervousExamination {

	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ID")
	private Long ID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "BenVisitID")
	private Long benVisitID;

	@Expose
	@Column(name = "Handedness")
	private String handedness;

	@Expose
	@Column(name = "CranialNervesExamination")
	private String cranialNervesExamination;

	@Expose
	@Column(name = "MotorSystem")
	private String motorSystem;

	@Expose
	@Column(name = "SensorySystem")
	private String sensorySystem;

	@Expose
	@Column(name = "AutonomicSystem")
	private String autonomicSystem;
	
	@Expose
	@Column(name = "CerebellarSigns")
	private String cerebellarSigns;

	@Expose
	@Column(name = "SignsOfMeningealIrritation")
	private String signsOfMeningealIrritation;

	@Expose
	@Column(name = "Skull")
	private String skull;
	
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
