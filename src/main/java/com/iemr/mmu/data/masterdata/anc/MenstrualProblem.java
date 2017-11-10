package com.iemr.mmu.data.masterdata.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_menstrualproblem")
public class MenstrualProblem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "MenstrualProblemID")
	private Short menstrualProblemID;
	
	@Expose
	@Column(name = "Name")
	private String name;
	
	@Expose
	@Column(name = "MenstrualProblemDesc")
	private String menstrualProblemDesc;
	
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

	public MenstrualProblem(Short menstrualProblemID, String name, String menstrualProblemDesc) {
		super();
		this.menstrualProblemID = menstrualProblemID;
		this.name = name;
		this.menstrualProblemDesc = menstrualProblemDesc;
	}
	
}
