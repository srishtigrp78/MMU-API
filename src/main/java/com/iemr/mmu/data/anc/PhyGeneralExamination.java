package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_Phy_GeneralExam")
public class PhyGeneralExamination {
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
	@Column(name = "Consciousness")
	private String consciousness;

	@Expose
	@Column(name = "Coherence")
	private String coherence;

	@Expose
	@Column(name = "Cooperation")
	private String cooperation;

	@Expose
	@Column(name = "Comfortness")
	private String comfortness;

	@Expose
	@Column(name = "BuiltAndAppearance")
	private String builtAndAppearance;

	@Expose
	@Column(name = "Gait")
	private String gait;

	@Expose
	@Column(name = "DangerSigns")
	private String dangerSigns;

	@Expose
	@Column(name = "TypeOfDangerSign")
	private String typeOfDangerSign;

	@Expose
	@Column(name = "Pallor")
	private String pallor;

	@Expose
	@Column(name = "Jaundice")
	private String jaundice;

	@Expose
	@Column(name = "Cyanosis")
	private String cyanosis;

	@Expose
	@Column(name = "Clubbing")
	private String clubbing;

	@Expose
	@Column(name = "Lymphadenopathy")
	private String lymphadenopathy;

	@Expose
	@Column(name = "LymphnodesInvolved")
	private String lymphnodesInvolved;

	@Expose
	@Column(name = "TypeOfLymphadenopathy")
	private String typeOfLymphadenopathy;

	@Expose
	@Column(name = "Edema")
	private String edema;

	@Expose
	@Column(name = "ExtentOfEdema")
	private String extentOfEdema;

	@Expose
	@Column(name = "EdemaType")
	private String edemaType;
	
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
