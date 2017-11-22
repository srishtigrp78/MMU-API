package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_Sys_Obstetric")
public class SysObstetricExamination {

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
	@Column(name = "FundalHeight")
	private String fundalHeight;

	@Expose
	@Column(name = "FHAndPOA_Status")
	private String fHAndPOA_Status;

	@Expose
	@Column(name = "FHAndPOA_Interpretation")
	private String fHAndPOA_Interpretation;

	@Expose
	@Column(name = "FetalMovements")
	private String fetalMovements;

	@Expose
	@Column(name = "FetalHeartSounds")
	private String fetalHeartSounds;

	@Expose
	@Column(name = "FetalHeartRate_BeatsPerMinute")
	private String fetalHeartRate_BeatsPerMinute;

	@Expose
	@Column(name = "FetalPositionOrLie")
	private String fetalPositionOrLie;

	@Expose
	@Column(name = "FetalPresentation")
	private String fetalPresentation;

	@Expose
	@Column(name = "AbdominalScars")
	private String abdominalScars;
	
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
