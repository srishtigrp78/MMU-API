package com.iemr.mmu.service.anc;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
	
	public static Map<String,Object> convertTimeToWords(Timestamp yearOfIllness, Timestamp createdDate) {
		Integer timePeriodAgo = 0;
		String timePeriodUnit = "";
		Map<String,Object> timePeriod = new HashMap<String,Object>();
		if(null != yearOfIllness && null != createdDate){
			Calendar CD = Calendar.getInstance();
			CD.setTime(createdDate);
			Calendar YOI = Calendar.getInstance();
			YOI.setTime(yearOfIllness);
			
			int year = CD.get(Calendar.YEAR) - YOI.get(Calendar.YEAR);
			int month =  CD.get(Calendar.MONTH) - YOI.get(Calendar.MONTH);
			int day =  CD.get(Calendar.DATE) - YOI.get(Calendar.DATE);
			if((year!=0 || month !=0) && ( month !=0 || day != 0) && (year!=0 || day !=0)){
				timePeriodUnit = "Weeks";
				int days = year*365 + month*30 +day;
				int weeks = days/7;
				timePeriodAgo = weeks;
			}else{
				if(year!=0 ){
					timePeriodUnit = "Years";
					timePeriodAgo = year;
				}else if(month !=0){
					timePeriodUnit = "Months";
					timePeriodAgo = month;
				}else if(day != 0){
					timePeriodUnit = "Days";
					timePeriodAgo = day;
				}
			}
			timePeriod.put("timePeriodAgo", timePeriodAgo);
			timePeriod.put("timePeriodUnit", timePeriodUnit);
		}
		return timePeriod;
	}
}
