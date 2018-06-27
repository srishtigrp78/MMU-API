package com.iemr.mmu.data.snomedct;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.mmu.utils.mapper.OutputMapper;

@Entity
@Table(name = "sct_description")
public class SCTDescription {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "sctDesID")
	private Long sctDesID; 
	
	/*
	@Expose
	@Column(name = "sctCode")
	private String sctCode; */
	
	@Expose
	@Column(name = "Active")
	private String active;
	
	@Expose
	@Column(name = "ConceptID")
	private String conceptID;
	
	@Expose
	@Column(name = "Term")
	private String term;
	
	@Expose
	@Column(name = "CaseSignificanceID")
	private String caseSignificanceID;	
	

	public SCTDescription() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SCTDescription(String conceptID,String term) {
		super();
		this.conceptID = conceptID;
		this.term = term;
	}

	public String getTerm() {
		return term;
	}

	private void setTerm(String term) {
		this.term = term;
	}
	
	public String getCaseSignificanceID() {
		return caseSignificanceID;
	}

	public void setCaseSignificanceID(String caseSignificanceID) {
		this.caseSignificanceID = caseSignificanceID;
	}
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}

}
