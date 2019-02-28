package com.iemr.mmu.data.reports;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "db_reporting.m_report", schema = "db_reporting")
public class ReportMaster {
	@Id
	@GeneratedValue
	@Column(name = "ReportID")
	private Integer reportID;

	@Column(name = "ReportName")
	private String reportName;

	@Column(name = "Deleted")
	private Boolean deleted;

	@Column(name = "ServiceID")
	private Integer serviceID;

	public Integer getReportID() {
		return reportID;
	}

	public void setReportID(Integer reportID) {
		this.reportID = reportID;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Integer getServiceID() {
		return serviceID;
	}

	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}

}
