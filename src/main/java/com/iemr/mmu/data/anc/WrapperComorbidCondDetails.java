package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;

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
					
			if(null != comrbidityCond.getOtherComorbidConditions()){
				comrbidityCond.setComorbidCondition(comrbidityCond.getComorbidCondition()+"-"+comrbidityCond.getOtherComorbidConditions());
			}
			comrbidityCond.setBeneficiaryRegID(beneficiaryRegID);
			comrbidityCond.setBenVisitID(benVisitID);
			comrbidityCond.setProviderServiceMapID(providerServiceMapID);
			comrbidityCond.setCreatedBy(createdBy);
			comrbidityCond.setYear(convertToDateFormat(timePeriodUnit, timePeriodAgo));
		}
		return comorbidityConcurrentConditionsList;
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
