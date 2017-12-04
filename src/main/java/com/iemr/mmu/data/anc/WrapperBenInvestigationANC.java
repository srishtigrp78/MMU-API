package com.iemr.mmu.data.anc;

import java.util.ArrayList;
import java.util.Map;

import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;

public class WrapperBenInvestigationANC {
	private Long beneficiaryRegID;
	private Long benVisitID;
	private Integer providerServiceMapID;
	private String createdBy;

	private ArrayList<LabTestOrderDetail> laboratoryList;

	public WrapperBenInvestigationANC() {
	}

	public WrapperBenInvestigationANC(Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			String createdBy, ArrayList<LabTestOrderDetail> laboratoryList) {
		super();
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
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

}
