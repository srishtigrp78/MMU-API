package com.iemr.mmu.data.labModule;

import java.util.List;

public class WrapperLabResultEntry {

	private Long beneficiaryRegID;
	private Long visitID;
	private Integer providerServiceMapID;
	private String createdBy;
	private List<LabResultEntry> labTestResults;
	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}
	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}
	
	public Long getVisitID() {
		return visitID;
	}
	public void setVisitID(Long visitID) {
		this.visitID = visitID;
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
	public List<LabResultEntry> getLabTestResults() {
		return labTestResults;
	}
	public void setLabTestResults(List<LabResultEntry> labTestResults) {
		this.labTestResults = labTestResults;
	}
	
	
}
