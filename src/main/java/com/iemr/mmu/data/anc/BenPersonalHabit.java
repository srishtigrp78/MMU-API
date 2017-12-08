package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_BenPersonalHabit")
public class BenPersonalHabit {
	
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "BenPersonalHabitID")
	private Integer benPersonalHabitID;

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
	@Column(name = "DietaryType")
	private String dietaryType;
	
	@Expose
	@Column(name = "PhysicalActivityType")
	private String physicalActivityType;
	
	@Expose
	@Column(name = "TobaccoUseStatus")
	private String tobaccoUseStatus;
	
	@Expose
	@Column(name = "TobaccoUseType")
	private String tobaccoUseType;
	
	@Expose
	@Column(name = "NumberperDay")
	private Short numberperDay;
	
	@Expose
	@Column(name = "TobaccoUseDuration")
	private String tobaccoUseDuration;
	
	@Expose
	@Column(name = "AlcoholIntakeStatus")
	private String alcoholIntakeStatus;
	
	@Expose
	@Column(name = "AlcoholType")
	private String alcoholType;
	
	@Expose
	@Column(name = "AlcoholIntakeFrequency")
	private String alcoholIntakeFrequency;
	
	@Expose
	@Column(name = "AvgAlcoholConsumption")
	private String avgAlcoholConsumption;
	
	@Expose
	@Column(name = "AlcoholDuration")
	private String alcoholDuration;
	
	@Expose
	@Column(name = "RiskySexualPracticesStatus")
	private Character riskySexualPracticesStatus;
	
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
