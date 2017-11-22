package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_Sys_Respiratory")
public class SysRespiratoryExamination {

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
	@Column(name = "Trachea")
	private String trachea;

	@Expose
	@Column(name = "Inspection")
	private String inspection;

	@Expose
	@Column(name = "SignsOfRespiratoryDistress")
	private String signsOfRespiratoryDistress;

	@Expose
	@Column(name = "Palpation")
	private String palpation;

	@Expose
	@Column(name = "Auscultation")
	private String auscultation;

	@Expose
	@Column(name = "Auscultation_Stridor")
	private String auscultation_Stridor;

	@Expose
	@Column(name = "Auscultation_BreathSounds")
	private String auscultation_BreathSounds;

	@Expose
	@Column(name = "Auscultation_Crepitations")
	private String auscultation_Crepitations;

	@Expose
	@Column(name = "Auscultation_Wheezing")
	private String auscultation_Wheezing;

	@Expose
	@Column(name = "Auscultation_PleuralRub")
	private String auscultation_PleuralRub;

	@Expose
	@Column(name = "Auscultation_ConductedSounds")
	private String auscultation_ConductedSounds;

	@Expose
	@Column(name = "Percussion")
	private String percussion;
	
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
