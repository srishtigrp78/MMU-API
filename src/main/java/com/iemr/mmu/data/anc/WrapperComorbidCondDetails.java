package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;

public class WrapperComorbidCondDetails {
	
	private ArrayList<BencomrbidityCondDetails> comrbidityCondDetails;

	public ArrayList<BencomrbidityCondDetails> getComrbidityCondDetails() {
		return comrbidityCondDetails;
	}

	public void setComrbidityCondDetails(ArrayList<BencomrbidityCondDetails> comrbidityCondDetails) {
		this.comrbidityCondDetails = comrbidityCondDetails;
	}
	
	public ArrayList<BencomrbidityCondDetails> getComrbidityConds(){
		for(BencomrbidityCondDetails comrbidityCond:comrbidityCondDetails){
			String timePeriodUnit = comrbidityCond.getTimePeriodUnit();
			Integer timePeriodAgo =  comrbidityCond.getTimePeriodAgo();
					
			
			comrbidityCond.setYear(convertToDateFormat(timePeriodUnit, timePeriodAgo));
		}
		return comrbidityCondDetails;
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
