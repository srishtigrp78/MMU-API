package com.iemr.mmu.data.anc;

import java.util.ArrayList;
import java.util.Map;

public class WrapperAncFindings {
	private Long beneficiaryRegID;
	private Long benVisitID;
	private Integer providerServiceMapID;
	private String createdBy;
	private String clinicalObservation;
	private String otherSymptoms;
	private String significantFindings;
	private ArrayList<Map<String, Object>> complaints;

	public WrapperAncFindings(Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID, String createdBy,
			String clinicalObservation, String otherSymptoms, String significantFindings,
			ArrayList<Map<String, Object>> complaints) {
		super();
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.createdBy = createdBy;
		this.clinicalObservation = clinicalObservation;
		this.otherSymptoms = otherSymptoms;
		this.significantFindings = significantFindings;
		this.complaints = complaints;
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

	public String getClinicalObservation() {
		return clinicalObservation;
	}

	public void setClinicalObservation(String clinicalObservation) {
		this.clinicalObservation = clinicalObservation;
	}

	public String getOtherSymptoms() {
		return otherSymptoms;
	}

	public void setOtherSymptoms(String otherSymptoms) {
		this.otherSymptoms = otherSymptoms;
	}

	public String getSignificantFindings() {
		return significantFindings;
	}

	public void setSignificantFindings(String significantFindings) {
		this.significantFindings = significantFindings;
	}

	public ArrayList<Map<String, Object>> getComplaints() {
		return complaints;
	}

	public void setComplaints(ArrayList<Map<String, Object>> complaints) {
		this.complaints = complaints;
	}

}
