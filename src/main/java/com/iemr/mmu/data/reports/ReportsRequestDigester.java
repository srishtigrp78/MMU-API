package com.iemr.mmu.data.reports;

import java.sql.Timestamp;

public class ReportsRequestDigester {
	private Integer reportID;
	private Timestamp fromDate;
	private Timestamp toDate;
	private Integer providerServiceMapID;
	private Integer vanID;

	public Integer getReportID() {
		return reportID;
	}

	public void setReportID(Integer reportID) {
		this.reportID = reportID;
	}

	public Timestamp getFromDate() {
		return fromDate;
	}

	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}

	public Timestamp getToDate() {
		return toDate;
	}

	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Integer getVanID() {
		return vanID;
	}

	public void setVanID(Integer vanID) {
		this.vanID = vanID;
	}

}
