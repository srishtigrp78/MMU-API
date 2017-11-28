package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_ChildFeedingDetails")
public class ChildFeedingDetails {
	
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
	@Column(name = "VisitCode")
	private Long visitCode;
	
	@Expose
	@Column(name = "ChildID")
	private Long childID;

	@Expose
	@Column(name = "BenMotherID")
	private Long benMotherID;

	@Expose
	@Column(name = "BreastFeeds")
	private Character breastFeeds;

	@Expose
	@Column(name = "TopFeeds")
	private Character topFeeds;

	@Expose
	@Column(name = "BreastFeedsandTopFeeds")
	private Character breastFeedsandTopFeeds;

	@Expose
	@Column(name = "CompFeedStartAge")
	private String compFeedStartAge;
	
	@Expose
	@Column(name = "NoOfCompFeedPerDay")
	private Character noOfCompFeedPerDay;

	@Expose
	@Column(name = "FoodIntoleranceStatus")
	private Character foodIntoleranceStatus;

	@Expose
	@Column(name = "TypeofFoodIntolerance")
	private String typeofFoodIntolerance;

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
