package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;
import com.iemr.mmu.service.anc.Utility;

public class WrapperComorbidCondDetails {
	
	private Long beneficiaryRegID;
	private Long benVisitID;
	private Integer providerServiceMapID;
	private String createdBy;
	
	private ArrayList<BencomrbidityCondDetails> comorbidityConcurrentConditionsList;

	
	public ArrayList<BencomrbidityCondDetails> getComorbidityConcurrentConditionsList() {
		return comorbidityConcurrentConditionsList;
	}

	public void setComorbidityConcurrentConditionsList(
			ArrayList<BencomrbidityCondDetails> comorbidityConcurrentConditionsList) {
		this.comorbidityConcurrentConditionsList = comorbidityConcurrentConditionsList;
	}

	public ArrayList<BencomrbidityCondDetails> getComrbidityConds(){
		for(BencomrbidityCondDetails comrbidityCond:comorbidityConcurrentConditionsList){
			String timePeriodUnit = comrbidityCond.getTimePeriodUnit();
			Integer timePeriodAgo =  comrbidityCond.getTimePeriodAgo();
					
			comrbidityCond.setBeneficiaryRegID(beneficiaryRegID);
			comrbidityCond.setBenVisitID(benVisitID);
			comrbidityCond.setProviderServiceMapID(providerServiceMapID);
			comrbidityCond.setCreatedBy(createdBy);
			comrbidityCond.setYear(Utility.convertToDateFormat(timePeriodUnit, timePeriodAgo));
		}
		return comorbidityConcurrentConditionsList;
	}
	
}
