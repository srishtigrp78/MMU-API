package com.iemr.mmu.data.registrar;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.joda.time.Years;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

public class WrapperRegWorklist {
	@Expose
	private Long beneficiaryRegID;
	@Expose
	private String beneficiaryID;
	@Expose
	private String benName;
	@Expose
	private Date dob;
	@Expose
	private Short genderID;
	@Expose
	private String genderName;
	@Expose
	private String fatherName;
	@Expose
	private Integer districtID;
	@Expose
	private String districtName;
	@Expose
	private Integer villageID;
	@Expose
	private String villageName;
	@Expose
	private String phoneNo;
	@Expose
	private String age;

	public static String getRegistrarWorkList(List<Object[]> resList) {
		// GsonBuilder gsonBuilder = new GsonBuilder();
		// gsonBuilder.serializeNulls();
		// Gson gson = gsonBuilder.create();

		ArrayList<WrapperRegWorklist> resArray = new ArrayList<>();
		for (Object[] obj : resList) {
			WrapperRegWorklist wrapperRegWorklist = new WrapperRegWorklist();
			wrapperRegWorklist.beneficiaryRegID = (Long) obj[0];
			wrapperRegWorklist.beneficiaryID = (String) obj[1];
			wrapperRegWorklist.benName = (String) obj[2];
			wrapperRegWorklist.dob = (Date) obj[3];
			if (obj[3] != null) {
				Date date = (Date) obj[3];
				Calendar cal = Calendar.getInstance();
				Calendar calNow = Calendar.getInstance();

				cal.setTime(date);
				calNow.setTime(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DAY_OF_MONTH);

				int yearNow = calNow.get(Calendar.YEAR);
				int monthNow = calNow.get(Calendar.MONTH);
				int dayNow = calNow.get(Calendar.DAY_OF_MONTH);

				/*LocalDate birthday = new LocalDate(year, month, day);
				LocalDate now = new LocalDate(yearNow, monthNow, dayNow);
				Years ageYear = Years.yearsBetween(birthday, now);
				Months ageMnth = Months.monthsBetween(birthday, now);
				Days ageDay = Days.daysBetween(birthday, now);
				*/

				if (yearNow - year > 0) {
					wrapperRegWorklist.age = (yearNow - year) + " years - " + (monthNow - month) + " months";
				} else {
					wrapperRegWorklist.age = (monthNow - month) + " months - " + (dayNow - day) + " days";

				}

				// wrapperRegWorklist.age = ageYear.getYears() + " Y-" +
				// ageMnth.getMonths() + " M-" + ageDay.getDays()
				// + " D";

				System.out.println("helloo");
			}
			wrapperRegWorklist.genderID = (Short) obj[4];
			wrapperRegWorklist.genderName = (String) obj[5];
			wrapperRegWorklist.fatherName = (String) obj[6];
			wrapperRegWorklist.districtID = (Integer) obj[7];
			wrapperRegWorklist.districtName = (String) obj[8];
			wrapperRegWorklist.villageID = (Integer) obj[9];
			wrapperRegWorklist.villageName = (String) obj[10];
			wrapperRegWorklist.phoneNo = (String) obj[11];
			resArray.add(wrapperRegWorklist);
			System.out.println("helloooo");
		}

		return new Gson().toJson(resArray);
	}
}