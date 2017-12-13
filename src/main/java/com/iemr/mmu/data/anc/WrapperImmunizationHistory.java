package com.iemr.mmu.data.anc;

import java.util.ArrayList;
import java.util.List;

public class WrapperImmunizationHistory {
	private Long beneficiaryRegID;
	private Long benVisitID;
	private Integer providerServiceMapID;
	private String createdBy;
	
	private ArrayList<ChildVaccineDetail1> immunizationList;

	public ArrayList<ChildVaccineDetail1> getImmunizationList() {
		return immunizationList;
	}

	public void setImmunizationList(ArrayList<ChildVaccineDetail1> immunizationList) {
		this.immunizationList = immunizationList;
	}
	
	public ArrayList<ChildVaccineDetail1> getBenChildVaccineDetailDetails(){
		for(ChildVaccineDetail1 childVaccineDetail:immunizationList){
				
			childVaccineDetail.setBeneficiaryRegID(beneficiaryRegID);
			childVaccineDetail.setBenVisitID(benVisitID);
			childVaccineDetail.setProviderServiceMapID(providerServiceMapID);
			childVaccineDetail.setCreatedBy(createdBy);
			
			List<String> vaccineNamesList = childVaccineDetail.getVaccineNameList();
			String vaccineNames = "";
			for(String vaccineName:vaccineNamesList){
				vaccineNames += vaccineName+",";
			}
			childVaccineDetail.setVaccineName(vaccineNames);
		}
		return immunizationList;
	}
}
