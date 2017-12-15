package com.iemr.mmu.data.masterdata.anc;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_complication")
public class ComplicationTypes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "ComplicationID")
	private Short complicationID;
	
	@Expose
	@Column(name = "ComplicationType")
	private String complicationType;
	
	@Expose
	@Column(name = "ComplicationValue")
	private String complicationValue;
	
	@Expose
	@Column(name = "ComplicationDesc")
	private String complicationDesc;
	
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

	
	
	public ComplicationTypes(Short complicationID, String complicationType, String complicationValue) {
		super();
		this.complicationID = complicationID;
		this.complicationType = complicationType;
		this.complicationValue = complicationValue;
	}



	public static ArrayList<ComplicationTypes> getComplicationTypes(ArrayList<Object[]> resList) {
		ArrayList<ComplicationTypes> resArray = new ArrayList<ComplicationTypes>();
		for (Object[] obj : resList) {
			ComplicationTypes cOBJ = new ComplicationTypes((Short)obj[0], (String)obj[1], (String)obj[2]);
			resArray.add(cOBJ);
		}
		return resArray;
	}
}
