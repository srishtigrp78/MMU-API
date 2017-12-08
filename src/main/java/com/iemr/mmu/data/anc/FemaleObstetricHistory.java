package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
