package com.iemr.mmu.data.anc;

import java.util.ArrayList;

import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;

public class WrapperBenInvestigationANC {
	private Long beneficiaryRegID;
	private Long benVisitID;
	private Integer providerServiceMapID;
	private Long prescriptionID;
	private String externalInvestigations;
	private String createdBy;

	private ArrayList<LabTestOrderDetail> laboratoryList;

	public WrapperBenInvestigationANC() {
	}

	public WrapperBenInvestigationANC(Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			Long prescriptionID, String createdBy, ArrayList<LabTestOrderDetail> laboratoryList) {
		super();
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.prescriptionID = prescriptionID;
		this.createdBy = createdBy;
		this.laboratoryList = laboratoryList;
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

	public Long getPrescriptionID() {
		return prescriptionID;
	}

	public void setPrescriptionID(Long prescriptionID) {
		this.prescriptionID = prescriptionID;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public ArrayList<LabTestOrderDetail> getLaboratoryList() {
		return laboratoryList;
	}

	public void setLaboratoryList(ArrayList<LabTestOrderDetail> laboratoryList) {
		this.laboratoryList = laboratoryList;
	}

	public String getExternalInvestigations() {
		return externalInvestigations;
	}

	public void setExternalInvestigations(String externalInvestigations) {
		this.externalInvestigations = externalInvestigations;
	}
	
	/*public static WrapperBenInvestigationANC getInvestigations(ArrayList<Object[]> investigationList) {
		WrapperBenInvestigationANC cOBJ = null;
		
		WrapperBenInvestigationANC  labTestOrdersList = LabTestOrderDetail.getLabTestOrderDetails(investigationList);
		if(null != labTestOrdersList && labTestOrdersList.size()>0){
			for (LabTestOrderDetail order : labTestOrdersList) {
				
						
			}
		}
		return cOBJ;
	}*/

}
