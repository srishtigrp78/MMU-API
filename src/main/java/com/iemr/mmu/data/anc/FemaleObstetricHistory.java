package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_FemaleObstetricHistory")
public class FemaleObstetricHistory {
	
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ObstetricHistoryID")
	private Long obstetricHistoryID;

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
	@Column(name = "PregOrder")
	private String pregOrder;

	@Expose
	@Column(name = "PregComplicationID")
	private Integer pregComplicationID;

	@Expose
	@Column(name = "PregComplicationType")
	private String pregComplicationType;

	@Expose
	@Column(name = "PregDurationID")
	private Short pregDurationID;

	@Expose
	@Column(name = "DurationType")
	private String durationType;

	@Expose
	@Column(name = "DeliveryTypeID")
	private Short deliveryTypeID;

	@Expose
	@Column(name = "DeliveryType")
	private String deliveryType;
	
	@Expose
	@Column(name = "DeliveryPlaceID")
	private Short deliveryPlaceID;
	
	@Expose
	@Column(name = "DeliveryPlace")
	private String deliveryPlace;

	@Expose
	@Column(name = "DeliveryComplicationID")
	private Short deliveryComplicationID;

	@Expose
	@Column(name = "DeliveryComplicationType")
	private String deliveryComplicationType;

	@Expose
	@Column(name = "PregOutcomeID")
	private Short pregOutcomeID;

	@Expose
	@Column(name = "PregOutcome")
	private String pregOutcome;

	@Expose
	@Column(name = "PostpartumComplicationID")
	private Short postpartumComplicationID;

	@Expose
	@Column(name = "PostpartumComplicationType")
	private String postpartumComplicationType;
	
	@Expose
	@Column(name = "PostNatalComplicationID")
	private Short postNatalComplicationID;

	@Expose
	@Column(name = "PostNatalComplication")
	private String postNatalComplication;

	@Expose
	@Column(name = "CongenitalAnomalies")
	private String congenitalAnomalies;

	@Expose
	@Column(name = "NewBornComplication")
	private String newBornComplication;
	
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

	@Expose
	@Transient
	private String otherPregComplicationType;
	
	@Expose
	@Transient
	private String otherDeliveryPlace;
	
	@Expose
	@Transient
	private String otherDeliveryComplicationType;
	
	@Expose
	@Transient
	private String otherPostpartumComplicationType;
	
	@Expose
	@Transient
	private String otherPostNatalComplication;
	
	@Expose
	@Transient
	private String otherNewBornComplication;
	
	
	public String getOtherPregComplicationType() {
		return otherPregComplicationType;
	}

	public void setOtherPregComplicationType(String otherPregComplicationType) {
		this.otherPregComplicationType = otherPregComplicationType;
	}

	public String getOtherDeliveryPlace() {
		return otherDeliveryPlace;
	}

	public void setOtherDeliveryPlace(String otherDeliveryPlace) {
		this.otherDeliveryPlace = otherDeliveryPlace;
	}

	public String getOtherDeliveryComplicationType() {
		return otherDeliveryComplicationType;
	}

	public void setOtherDeliveryComplicationType(String otherDeliveryComplicationType) {
		this.otherDeliveryComplicationType = otherDeliveryComplicationType;
	}

	public String getOtherPostpartumComplicationType() {
		return otherPostpartumComplicationType;
	}

	public void setOtherPostpartumComplicationType(String otherPostpartumComplicationType) {
		this.otherPostpartumComplicationType = otherPostpartumComplicationType;
	}

	public String getOtherPostNatalComplication() {
		return otherPostNatalComplication;
	}

	public void setOtherPostNatalComplication(String otherPostNatalComplication) {
		this.otherPostNatalComplication = otherPostNatalComplication;
	}

	public String getOtherNewBornComplication() {
		return otherNewBornComplication;
	}

	public void setOtherNewBornComplication(String otherNewBornComplication) {
		this.otherNewBornComplication = otherNewBornComplication;
	}

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

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public String getPregOrder() {
		return pregOrder;
	}

	public void setPregOrder(String pregOrder) {
		this.pregOrder = pregOrder;
	}

	public Integer getPregComplicationID() {
		return pregComplicationID;
	}

	public void setPregComplicationID(Integer pregComplicationID) {
		this.pregComplicationID = pregComplicationID;
	}

	public String getPregComplicationType() {
		return pregComplicationType;
	}

	public void setPregComplicationType(String pregComplicationType) {
		this.pregComplicationType = pregComplicationType;
	}

	public Short getPregDurationID() {
		return pregDurationID;
	}

	public void setPregDurationID(Short pregDurationID) {
		this.pregDurationID = pregDurationID;
	}

	public String getDurationType() {
		return durationType;
	}

	public void setDurationType(String durationType) {
		this.durationType = durationType;
	}

	public Short getDeliveryTypeID() {
		return deliveryTypeID;
	}

	public void setDeliveryTypeID(Short deliveryTypeID) {
		this.deliveryTypeID = deliveryTypeID;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Short getDeliveryPlaceID() {
		return deliveryPlaceID;
	}

	public void setDeliveryPlaceID(Short deliveryPlaceID) {
		this.deliveryPlaceID = deliveryPlaceID;
	}

	public String getDeliveryPlace() {
		return deliveryPlace;
	}

	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}

	public Short getDeliveryComplicationID() {
		return deliveryComplicationID;
	}

	public void setDeliveryComplicationID(Short deliveryComplicationID) {
		this.deliveryComplicationID = deliveryComplicationID;
	}

	public String getDeliveryComplicationType() {
		return deliveryComplicationType;
	}

	public void setDeliveryComplicationType(String deliveryComplicationType) {
		this.deliveryComplicationType = deliveryComplicationType;
	}

	public Short getPregOutcomeID() {
		return pregOutcomeID;
	}

	public void setPregOutcomeID(Short pregOutcomeID) {
		this.pregOutcomeID = pregOutcomeID;
	}

	public String getPregOutcome() {
		return pregOutcome;
	}

	public void setPregOutcome(String pregOutcome) {
		this.pregOutcome = pregOutcome;
	}

	public Short getPostpartumComplicationID() {
		return postpartumComplicationID;
	}

	public void setPostpartumComplicationID(Short postpartumComplicationID) {
		this.postpartumComplicationID = postpartumComplicationID;
	}

	public String getPostpartumComplicationType() {
		return postpartumComplicationType;
	}

	public void setPostpartumComplicationType(String postpartumComplicationType) {
		this.postpartumComplicationType = postpartumComplicationType;
	}

	public Short getPostNatalComplicationID() {
		return postNatalComplicationID;
	}

	public void setPostNatalComplicationID(Short postNatalComplicationID) {
		this.postNatalComplicationID = postNatalComplicationID;
	}

	public String getPostNatalComplication() {
		return postNatalComplication;
	}

	public void setPostNatalComplication(String postNatalComplication) {
		this.postNatalComplication = postNatalComplication;
	}

	public String getCongenitalAnomalies() {
		return congenitalAnomalies;
	}

	public void setCongenitalAnomalies(String congenitalAnomalies) {
		this.congenitalAnomalies = congenitalAnomalies;
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

	public Long getObstetricHistoryID() {
		return obstetricHistoryID;
	}
	
	public String getNewBornComplication() {
		return newBornComplication;
	}

	public void setNewBornComplication(String newBornComplication) {
		this.newBornComplication = newBornComplication;
	}
	
}
