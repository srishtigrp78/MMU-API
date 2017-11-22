package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_Phy_HeadToToe")
public class PhyHeadToToeExamination {
	
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
	@Column(name = "HeadtoToeExam")
	private String headtoToeExam;

	@Expose
	@Column(name = "Head")
	private String head;

	@Expose
	@Column(name = "Eyes")
	private String eyes;

	@Expose
	@Column(name = "Ears")
	private String ears;

	@Expose
	@Column(name = "Nose")
	private String nose;

	@Expose
	@Column(name = "OralCavity")
	private String oralCavity;

	@Expose
	@Column(name = "Throat")
	private String throat;

	@Expose
	@Column(name = "BreastAndNipples")
	private String breastAndNipples;

	@Expose
	@Column(name = "Trunk")
	private String trunk;

	@Expose
	@Column(name = "UpperLimbs")
	private String upperLimbs;

	@Expose
	@Column(name = "LowerLimbs")
	private String lowerLimbs;

	@Expose
	@Column(name = "Skin")
	private String skin;

	@Expose
	@Column(name = "Hair")
	private String hair;

	@Expose
	@Column(name = "Nails")
	private String nails;
	
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
