package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_Sys_Gastrointestinal")
public class SysGastrointestinalExamination {

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
	@Column(name = "Inspection")
	private String inspection;

	@Expose
	@Column(name = "Palpation")
	private String palpation;

	@Expose
	@Column(name = "Palpation_AbdomenTexture")
	private String palpation_AbdomenTexture;

	@Expose
	@Column(name = "Palpation_Liver")
	private String palpation_Liver;

	@Expose
	@Column(name = "Palpation_Spleen")
	private String palpation_Spleen;

	@Expose
	@Column(name = "Palpation_Tenderness")
	private String palpation_Tenderness;

	@Expose
	@Column(name = "Palpation_LocationOfTenderness")
	private String palpation_LocationOfTenderness;

	@Expose
	@Column(name = "Percussion")
	private String percussion;

	@Expose
	@Column(name = "Auscultation")
	private String auscultation;

	@Expose
	@Column(name = "AnalRegion")
	private String analRegion;
	
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
