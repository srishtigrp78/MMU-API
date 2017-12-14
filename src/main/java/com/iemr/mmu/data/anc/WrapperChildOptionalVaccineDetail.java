package com.iemr.mmu.data.anc;

import java.util.ArrayList;

public class WrapperChildOptionalVaccineDetail {
	
	private Long beneficiaryRegID;
	private Long benVisitID;
	private Integer providerServiceMapID;
	private String createdBy;

	private ArrayList<ChildOptionalVaccineDetail> childOptionalVaccineList;

	public ArrayList<ChildOptionalVaccineDetail> getChildOptionalVaccineList() {
		return childOptionalVaccineList;
	}

	public void setChildOptionalVaccineList(ArrayList<ChildOptionalVaccineDetail> childOptionalVaccineList) {
		this.childOptionalVaccineList = childOptionalVaccineList;
	}
	
	public ArrayList<ChildOptionalVaccineDetail> getChildOptionalVaccineDetails(){
		for(ChildOptionalVaccineDetail childOptionalVaccine:childOptionalVaccineList){
			
			childOptionalVaccine.setBeneficiaryRegID(beneficiaryRegID);
			childOptionalVaccine.setBenVisitID(benVisitID);
			childOptionalVaccine.setProviderServiceMapID(providerServiceMapID);
			childOptionalVaccine.setCreatedBy(createdBy);
		}
		return childOptionalVaccineList;
	}
	
	
	
}
