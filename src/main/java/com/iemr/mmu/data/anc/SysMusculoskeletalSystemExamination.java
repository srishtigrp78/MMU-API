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
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
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

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Long getBenVisitID() {
		return benVisitID;
	}

	public void setBenVisitID(Long benVisitID) {
		this.benVisitID = benVisitID;
	}

	public Long getJoint_TypeOfJoint() {
		return joint_TypeOfJoint;
	}

	public void setJoint_TypeOfJoint(Long joint_TypeOfJoint) {
		this.joint_TypeOfJoint = joint_TypeOfJoint;
	}

	public Long getJoint_Laterality() {
		return joint_Laterality;
	}

	public void setJoint_Laterality(Long joint_Laterality) {
		this.joint_Laterality = joint_Laterality;
	}

	public Long getJoint_Abnormality() {
		return joint_Abnormality;
	}

	public void setJoint_Abnormality(Long joint_Abnormality) {
		this.joint_Abnormality = joint_Abnormality;
	}

	public Long getUpperLimb_Laterality() {
		return upperLimb_Laterality;
	}

	public void setUpperLimb_Laterality(Long upperLimb_Laterality) {
		this.upperLimb_Laterality = upperLimb_Laterality;
	}

	public Long getUpperLimb_Abnormality() {
		return upperLimb_Abnormality;
	}

	public void setUpperLimb_Abnormality(Long upperLimb_Abnormality) {
		this.upperLimb_Abnormality = upperLimb_Abnormality;
	}

	public Long getLowerLimb_Laterality() {
		return lowerLimb_Laterality;
	}

	public void setLowerLimb_Laterality(Long lowerLimb_Laterality) {
		this.lowerLimb_Laterality = lowerLimb_Laterality;
	}

	public Long getLowerLimb_Abnormality() {
		return lowerLimb_Abnormality;
	}

	public void setLowerLimb_Abnormality(Long lowerLimb_Abnormality) {
		this.lowerLimb_Abnormality = lowerLimb_Abnormality;
	}

	public Long getChestWall() {
		return chestWall;
	}

	public void setChestWall(Long chestWall) {
		this.chestWall = chestWall;
	}

	public Long getSpine() {
		return spine;
	}

	public void setSpine(Long spine) {
		this.spine = spine;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Long getID() {
		return ID;
	}
}
