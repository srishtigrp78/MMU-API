package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_Sys_MusculoskeletalSystem")
public class SysMusculoskeletalSystemExamination {

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
	@Column(name = "Joint_TypeOfJoint")
	private Long joint_TypeOfJoint;

	@Expose
	@Column(name = "Joint_Laterality")
	private Long joint_Laterality;

	@Expose
	@Column(name = "Joint_Abnormality")
	private Long joint_Abnormality;

	@Expose
	@Column(name = "UpperLimb_Laterality")
	private Long upperLimb_Laterality;
	
	@Expose
	@Column(name = "UpperLimb_Abnormality")
	private Long upperLimb_Abnormality;

	@Expose
	@Column(name = "LowerLimb_Laterality")
	private Long lowerLimb_Laterality;

	@Expose
	@Column(name = "LowerLimb_Abnormality")
	private Long lowerLimb_Abnormality;

	@Expose
	@Column(name = "ChestWall")
	private Long chestWall;
	
	@Expose
	@Column(name = "Spine")
	private Long spine;
	
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
