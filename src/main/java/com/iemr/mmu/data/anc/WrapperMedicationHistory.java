package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

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
	
	public static WrapperMedicationHistory getMedicationHistoryDetails(ArrayList<Object[]> medicationHistoryDetails){
		WrapperMedicationHistory WMH = new WrapperMedicationHistory();
		WMH.medicationHistoryList = new ArrayList<BenMedicationHistory>();
		
		if(null != medicationHistoryDetails && medicationHistoryDetails.size()>0){
			Object[] obj1 = medicationHistoryDetails.get(0);
			WMH.beneficiaryRegID = (Long)obj1[0];
			WMH.benVisitID = (Long)obj1[1];
			WMH.providerServiceMapID = (Integer)obj1[2];
			
			for(Object[] obj: medicationHistoryDetails){
				
				Map<String, Object> timePeriod = Utility.convertTimeToWords((Timestamp)obj[4], (Timestamp)obj[5]);
				
				Integer timePeriodAgo = Integer.parseInt(timePeriod.get("timePeriodAgo").toString());
				BenMedicationHistory medicationHistory= new BenMedicationHistory((String)obj[3], timePeriodAgo, timePeriod.get("timePeriodUnit").toString());
				
				WMH.medicationHistoryList.add(medicationHistory);
			}
		}
		return WMH;
	}
	
	
}
