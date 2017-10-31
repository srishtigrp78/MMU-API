package com.iemr.mmu.data.location;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.iemr.utils.mapper.OutputMapper;

@Entity
@Table(name = "m_district")
public class Districts
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DistrictID")
	@Expose
	private Integer districtID;
	@Column(name = "StateID")
	@Expose
	private Integer stateID;
	@Column(name = "DistrictName")
	@Expose
	private String districtName;
	// @Column(name = "Zone")
	// @Expose
	// private String zone;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true, insertable = false, name = "StateID", updatable = false)
	@JsonIgnore
	private States states;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	public Districts()
	{
	}

	public Districts(Integer DistrictID, String DistrictName)
	{
		this.districtID = DistrictID;
		this.districtName = DistrictName;
	}

	public Districts(Integer DistrictID, String DistrictName, Integer stateId, String stateName)
	{
		this.states = new States(stateId.intValue(), stateName);
		this.districtID = DistrictID;
		this.districtName = DistrictName;
	}

	public int getDistrictID()
	{
		return this.districtID.intValue();
	}

	public void setDistrictID(int districtID)
	{
		this.districtID = Integer.valueOf(districtID);
	}

	public String getDistrictName()
	{
		return this.districtName;
	}

	public void setDistrictName(String districtName)
	{
		this.districtName = districtName;
	}

	// public String getZone() {
	// return this.zone;
	// }
	//
	// public void setZone(String zone) {
	// this.zone = zone;
	// }

	public boolean isDeleted()
	{
		return this.deleted.booleanValue();
	}

	public void setDeleted(boolean deleted)
	{
		this.deleted = Boolean.valueOf(deleted);
	}

	public String getCreatedBy()
	{
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate()
	{
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getModifiedBy()
	{
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return this.lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate)
	{
		this.lastModDate = lastModDate;
	}

	public States getStates()
	{
		return this.states;
	}

	public void setStates(States states)
	{
		this.states = states;
	}

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
}
