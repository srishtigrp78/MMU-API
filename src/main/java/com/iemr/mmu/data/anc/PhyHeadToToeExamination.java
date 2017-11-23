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

	public String getHeadtoToeExam() {
		return headtoToeExam;
	}

	public void setHeadtoToeExam(String headtoToeExam) {
		this.headtoToeExam = headtoToeExam;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getEyes() {
		return eyes;
	}

	public void setEyes(String eyes) {
		this.eyes = eyes;
	}

	public String getEars() {
		return ears;
	}

	public void setEars(String ears) {
		this.ears = ears;
	}

	public String getNose() {
		return nose;
	}

	public void setNose(String nose) {
		this.nose = nose;
	}

	public String getOralCavity() {
		return oralCavity;
	}

	public void setOralCavity(String oralCavity) {
		this.oralCavity = oralCavity;
	}

	public String getThroat() {
		return throat;
	}

	public void setThroat(String throat) {
		this.throat = throat;
	}

	public String getBreastAndNipples() {
		return breastAndNipples;
	}

	public void setBreastAndNipples(String breastAndNipples) {
		this.breastAndNipples = breastAndNipples;
	}

	public String getTrunk() {
		return trunk;
	}

	public void setTrunk(String trunk) {
		this.trunk = trunk;
	}

	public String getUpperLimbs() {
		return upperLimbs;
	}

	public void setUpperLimbs(String upperLimbs) {
		this.upperLimbs = upperLimbs;
	}

	public String getLowerLimbs() {
		return lowerLimbs;
	}

	public void setLowerLimbs(String lowerLimbs) {
		this.lowerLimbs = lowerLimbs;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public String getHair() {
		return hair;
	}

	public void setHair(String hair) {
		this.hair = hair;
	}

	public String getNails() {
		return nails;
	}

	public void setNails(String nails) {
		this.nails = nails;
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
