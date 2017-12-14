package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import com.iemr.mmu.service.anc.Utility;

public class WrapperMedicationHistory {
	
	private Long beneficiaryRegID;
	private Long benVisitID;
	private Integer providerServiceMapID;
	private String createdBy;
	
	private ArrayList<BenMedicationHistory> medicationHistoryList;
	
	public ArrayList<BenMedicationHistory> getMedicationHistoryList() {
		return medicationHistoryList;
	}

	public void setMedicationHistoryList(ArrayList<BenMedicationHistory> medicationHistoryList) {
		this.medicationHistoryList = medicationHistoryList;
	}

	public ArrayList<BenMedicationHistory> getBenMedicationHistoryDetails(){
		for(BenMedicationHistory medicationHistory:medicationHistoryList){
			String timePeriodUnit = medicationHistory.getTimePeriodUnit();
			Integer timePeriodAgo =  medicationHistory.getTimePeriodAgo();
			
			medicationHistory.setBeneficiaryRegID(beneficiaryRegID);
			medicationHistory.setBenVisitID(benVisitID);
			medicationHistory.setProviderServiceMapID(providerServiceMapID);
			medicationHistory.setCreatedBy(createdBy);
			
			medicationHistory.setYear(Utility.convertToDateFormat(timePeriodUnit, timePeriodAgo));
		}
		return medicationHistoryList;
	}
	
}
