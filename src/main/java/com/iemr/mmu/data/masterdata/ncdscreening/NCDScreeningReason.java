package com.iemr.mmu.data.masterdata.ncdscreening;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_ncdscreeningreason")
public class NCDScreeningReason {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "ncdScreeningReasonID")
	private int ncdScreeningReasonID; 
	
	@Expose
	@Column(name = "ncdScreeningReason")
	private String ncdScreeningReason; 
	
	@Expose
	@Column(name = "ncdScreeningReasonDesc")
	private String ncdScreeningReasonDesc; 
	
	@Expose
	@Column(name = "ncdScreeningConditionID")
	private int ncdScreeningConditionID; 
	
	@Expose
	@Column(name = "deleted")
	private boolean deleted; 
	
	@Expose
	@Column(name = "processed")
	private String processed; 
	
	@Expose
	@Column(name = "createdBy")
	private String createdBy; 
	
	@Expose
	@Column(name = "createdDate")
	private Date createdDate; 
	
	@Expose
	@Column(name = "modifiedBy")
	private String modifiedBy; 
	
	@Expose
	@Column(name = "lastModDate")
	private Date lastModDate;
	
	
}
