package com.iemr.mmu.service.anc;

import java.sql.Timestamp;
import java.util.Calendar;

public class Utility {

	public static Timestamp convertToDateFormat(String timePeriodUnit, Integer timePeriodAgo){
		if(null != timePeriodUnit && null != timePeriodAgo){
			Calendar cal = Calendar.getInstance();
			if(timePeriodUnit.equals("Years")){
				cal.add(Calendar.YEAR, -timePeriodAgo);
			}else if(timePeriodUnit.equals("Months")){
				cal.add(Calendar.MONTH, -timePeriodAgo);
			}else if(timePeriodUnit.equals("Weeks")){
				cal.add(Calendar.DATE, -(7*timePeriodAgo));
			}else if(timePeriodUnit.equals("Days")){
				cal.add(Calendar.DATE, -timePeriodAgo);
			}
			return new Timestamp(cal.getTimeInMillis());
		}
		
		return null;
	}
}
