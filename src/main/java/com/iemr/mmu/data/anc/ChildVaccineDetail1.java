package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_ChildVaccineDetail1")
public class ChildVaccineDetail1 {
	
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ID")
	private Long ID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "DefaultReceivingAge")
	private String defaultReceivingAge;

	@Expose
	@Column(name = "VaccineName")
	private String vaccineName;

	@Expose
	@Column(name = "ActualReceivingAge")
	private String actualReceivingAge;

	@Expose
	@Column(name = "Status")
	private String status;

	@Expose
	@Column(name = "ReceivedDate")
	private Timestamp receivedDate;

	@Expose
	@Column(name = "ReceivedFacilityName")
	private String receivedFacilityName;
	
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
