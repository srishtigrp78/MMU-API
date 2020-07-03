package com.iemr.mmu.data.covid19;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_covidcontacthistory")
public class CovidContactHistoryMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "CovidcontacthistoryID", insertable = false, updatable = false)
	private Integer covidcontacthistoryID;
	public Integer getCovidcontacthistoryID() {
		return covidcontacthistoryID;
	}
	public void setCovidcontacthistoryID(Integer covidcontacthistoryID) {
		this.covidcontacthistoryID = covidcontacthistoryID;
	}
	public String getContactHistory() {
		return contactHistory;
	}
	public void setContactHistory(String contactHistory) {
		this.contactHistory = contactHistory;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	@Expose
	@Column(name = "ContactHistory")
	private String contactHistory;
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = false)
	private Boolean deleted;

}

