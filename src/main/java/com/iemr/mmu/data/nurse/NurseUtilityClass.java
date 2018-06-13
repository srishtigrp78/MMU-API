package com.iemr.mmu.data.nurse;

public class NurseUtilityClass {
	private Long benFlowID;
	private Long beneficiaryID;
	private Integer sessionID;
	private Integer parkingPlaceID;
	private Integer vanID;
	
	// private Long beneficiaryRegID;
	// private Integer providerServiceMapID;
	// private Long benVisitID;
	// private Long visitCode;

	public Long getBenFlowID() {
		return benFlowID;
	}

	public void setBenFlowID(Long benFlowID) {
		this.benFlowID = benFlowID;
	}

	public Long getBeneficiaryID() {
		return beneficiaryID;
	}

	public void setBeneficiaryID(Long beneficiaryID) {
		this.beneficiaryID = beneficiaryID;
	}

	public Integer getSessionID() {
		return sessionID;
	}

	public void setSessionID(Integer sessionID) {
		this.sessionID = sessionID;
	}

	public Integer getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Integer parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
	}

	public Integer getVanID() {
		return vanID;
	}

	public void setVanID(Integer vanID) {
		this.vanID = vanID;
	}

}
