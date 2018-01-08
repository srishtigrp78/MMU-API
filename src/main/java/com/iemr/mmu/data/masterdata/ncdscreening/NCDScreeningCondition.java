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
@Table(name = "m_ncdscreeningcondition")
public class NCDScreeningCondition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "ncdScreeningConditionID")
	private int ncdScreeningConditionID; 
	
	@Expose
	@Column(name = "ncdScreeningCondition")
	private String ncdScreeningCondition;
	
	@Expose
	@Column(name = "ncdScreeningConditionDesc")
	private String ncdScreeningConditionDesc;
	
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
