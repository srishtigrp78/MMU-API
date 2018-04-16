package com.iemr.mmu.data.anc;

import java.util.ArrayList;
import java.util.Map;

import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.BenClinicalObservations;

public class WrapperAncFindings {
	private Long beneficiaryRegID;
	private Long benVisitID;
	private Integer providerServiceMapID;
	private String createdBy;
	private String clinicalObservation;
	private String otherSymptoms;
	private String significantFindings;
	private ArrayList<Map<String, Object>> complaints;
	private ArrayList<BenChiefComplaint> chiefComplaints;
	private Boolean isForHistory;

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

	public ArrayList<BenChiefComplaint> getChiefComplaints() {
		return chiefComplaints;
	}

	public void setChiefComplaints(ArrayList<BenChiefComplaint> chiefComplaints) {
		this.chiefComplaints = chiefComplaints;
	}

	public Boolean getIsForHistory() {
		return isForHistory;
	}

	public void setIsForHistory(Boolean isForHistory) {
		this.isForHistory = isForHistory;
	}

	public WrapperAncFindings(Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			String clinicalObservation, String otherSymptoms, String significantFindings,
			ArrayList<BenChiefComplaint> chiefComplaints, Boolean isForHistory) {
		super();
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.clinicalObservation = clinicalObservation;
		this.otherSymptoms = otherSymptoms;
		this.significantFindings = significantFindings;
		this.chiefComplaints = chiefComplaints;
		this.isForHistory = isForHistory;
	}

	public static WrapperAncFindings getFindingsData(ArrayList<Object[]> clinicalObservationsList, ArrayList<Object[]> chiefComplaintsList) {
		WrapperAncFindings cOBJ = null;
		
		ArrayList<BenChiefComplaint>  chiefcmplts = BenChiefComplaint.getBenChiefComplaints(chiefComplaintsList);
		if(null != clinicalObservationsList && clinicalObservationsList.size()>0){
			for (Object[] obj : clinicalObservationsList) {
				cOBJ = new WrapperAncFindings((Long)obj[0], (Long)obj[1], (Integer)obj[2], (String)obj[3], 
						(String)obj[4], (String)obj[5], chiefcmplts, (Boolean)obj[6]);
						
			}
		}
		return cOBJ;
	}
}
