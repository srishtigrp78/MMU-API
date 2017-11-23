package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

public class WrapperAncImmunization {
	private Long beneficiaryRegID;
	private Long benVisitID;
	private Integer providerServiceMapID;
	private String createdBy;
	private String tT_1Status;
	private Timestamp dateReceivedForTT_1;
	private String facilityNameOfTT_1;
	private String tT_2Status;
	private Timestamp dateReceivedForTT_2;
	private String facilityNameOfTT_2;
	private String tT_3Status;
	private Timestamp dateReceivedForTT_3;
	private String facilityNameOfTT_3;

	public WrapperAncImmunization() {
	}

	public WrapperAncImmunization(Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			String createdBy, String tT_1Status, Timestamp dateReceivedForTT_1, String facilityNameOfTT_1,
			String tT_2Status, Timestamp dateReceivedForTT_2, String facilityNameOfTT_2, String tT_3Status,
			Timestamp dateReceivedForTT_3, String facilityNameOfTT_3) {
		super();
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.createdBy = createdBy;
		this.tT_1Status = tT_1Status;
		this.dateReceivedForTT_1 = dateReceivedForTT_1;
		this.facilityNameOfTT_1 = facilityNameOfTT_1;
		this.tT_2Status = tT_2Status;
		this.dateReceivedForTT_2 = dateReceivedForTT_2;
		this.facilityNameOfTT_2 = facilityNameOfTT_2;
		this.tT_3Status = tT_3Status;
		this.dateReceivedForTT_3 = dateReceivedForTT_3;
		this.facilityNameOfTT_3 = facilityNameOfTT_3;
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Long getBenVisitID() {
		return benVisitID;
	}

	public void setBenVisitID(Long benVisitID) {
		this.benVisitID = benVisitID;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String gettT_1Status() {
		return tT_1Status;
	}

	public void settT_1Status(String tT_1Status) {
		this.tT_1Status = tT_1Status;
	}

	public Timestamp getDateReceivedForTT_1() {
		return dateReceivedForTT_1;
	}

	public void setDateReceivedForTT_1(Timestamp dateReceivedForTT_1) {
		this.dateReceivedForTT_1 = dateReceivedForTT_1;
	}

	public String getFacilityNameOfTT_1() {
		return facilityNameOfTT_1;
	}

	public void setFacilityNameOfTT_1(String facilityNameOfTT_1) {
		this.facilityNameOfTT_1 = facilityNameOfTT_1;
	}

	public String gettT_2Status() {
		return tT_2Status;
	}

	public void settT_2Status(String tT_2Status) {
		this.tT_2Status = tT_2Status;
	}

	public Timestamp getDateReceivedForTT_2() {
		return dateReceivedForTT_2;
	}

	public void setDateReceivedForTT_2(Timestamp dateReceivedForTT_2) {
		this.dateReceivedForTT_2 = dateReceivedForTT_2;
	}

	public String getFacilityNameOfTT_2() {
		return facilityNameOfTT_2;
	}

	public void setFacilityNameOfTT_2(String facilityNameOfTT_2) {
		this.facilityNameOfTT_2 = facilityNameOfTT_2;
	}

	public String gettT_3Status() {
		return tT_3Status;
	}

	public void settT_3Status(String tT_3Status) {
		this.tT_3Status = tT_3Status;
	}

	public Timestamp getDateReceivedForTT_3() {
		return dateReceivedForTT_3;
	}

	public void setDateReceivedForTT_3(Timestamp dateReceivedForTT_3) {
		this.dateReceivedForTT_3 = dateReceivedForTT_3;
	}

	public String getFacilityNameOfTT_3() {
		return facilityNameOfTT_3;
	}

	public void setFacilityNameOfTT_3(String facilityNameOfTT_3) {
		this.facilityNameOfTT_3 = facilityNameOfTT_3;
	}

}
