package com.iemr.mmu.data.tele_consultation;

import java.sql.Timestamp;

import com.google.gson.annotations.Expose;

public class TcSpecialistSlotBookingRequestOBJ {
	@Expose
	private Integer userID;
	@Expose
	private Timestamp date;
	@Expose
	private String fromTime;
	@Expose
	private String toTime;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

}
