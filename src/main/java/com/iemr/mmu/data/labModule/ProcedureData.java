package com.iemr.mmu.data.labModule;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.mmu.data.masterdata.pnc.NewbornHealthStatus;

@Entity
@Table(name = "m_procedure")
public class ProcedureData
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ProcedureID")
	@Expose
	private Integer procedureID;

	@Column(name = "ProcedureName")
	@Expose
	private String procedureName;
	
	@Column(name = "ProcedureDesc")
	@Expose
	private String procedureDesc;
	
	@Column(name = "ProcedureType")
	@Expose
	private String procedureType;
	
	@Column(name = "Gender")
	@Expose
	private String gender;
	
	@Column(name = "ProviderServiceMapID")
	@Expose
	private Integer providerServiceMapID;
	
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

	public ProcedureData(Integer procedureID, String procedureName, String procedureDesc, String gender, Integer providerServiceMapID)
	{
		super();
		this.procedureID = procedureID;
		this.procedureName = procedureName;
		this.procedureDesc = procedureDesc;
		this.gender = gender;
		this.providerServiceMapID = providerServiceMapID;
	}
	
	public static ArrayList<ProcedureData> getProcedures(ArrayList<Object[]> resList) {
		ArrayList<ProcedureData> resArray = new ArrayList<ProcedureData>();
		for (Object[] obj : resList) {
			ProcedureData cOBJ = new ProcedureData((Integer)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (Integer)obj[4]);
			resArray.add(cOBJ);
		}
		return resArray;
	}
}
