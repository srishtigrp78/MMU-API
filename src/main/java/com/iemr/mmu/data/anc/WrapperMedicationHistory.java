package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

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
			
			medicationHistory.setYear(convertToDateFormat(timePeriodUnit, timePeriodAgo));
		}
		return medicationHistoryList;
	}
	
	public Timestamp convertToDateFormat(String timePeriodUnit, Integer timePeriodAgo){
		
		Calendar cal = Calendar.getInstance();
		if(null != timePeriodUnit && null != timePeriodAgo){
			if(timePeriodUnit.equals("Years")){
				cal.add(Calendar.YEAR, -timePeriodAgo);
			}else if(timePeriodUnit.equals("Months")){
				cal.add(Calendar.MONTH, -timePeriodAgo);
			}else if(timePeriodUnit.equals("Weeks")){
				cal.add(Calendar.DATE, -(7*timePeriodAgo));
			}else if(timePeriodUnit.equals("Days")){
				cal.add(Calendar.DATE, -timePeriodAgo);
			}
		}
		
		return new Timestamp(cal.getTimeInMillis());
	}
	
}
