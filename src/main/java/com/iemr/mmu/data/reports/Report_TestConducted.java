package com.iemr.mmu.data.reports;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;

public class Report_TestConducted {
	@Expose
	private Timestamp VisitDate;
	@Expose
	private String District;
	@Expose
	private String Village;
	@Expose
	private String ServicePoint;
	@Expose
	private String MmuNumber;
	@Expose
	private String BenId;
	@Expose
	private String BenName;
	@Expose
	private String Gender;
	@Expose
	private BigInteger Age;
	@Expose
	private String TestName;
	@Expose
	private String Category;

	public Report_TestConducted() {
	}

	public Report_TestConducted(Timestamp visit_Date, String district, String village, String service_Point,
			String mMU_Number, BigInteger ben_ID, String benName, String gender, BigInteger age, String test_Name,
			String category) {
		super();
		VisitDate = visit_Date;
		District = district;
		Village = village;
		ServicePoint = service_Point;
		MmuNumber = mMU_Number;
		if (ben_ID != null)
			BenId = ben_ID.toString();
		BenName = benName;
		Gender = gender;
		Age = age;
		TestName = test_Name;
		Category = category;
	}

	public static ArrayList<Report_TestConducted> getTestConductedReport(ArrayList<Object[]> objArr) {
		Report_TestConducted tcOBJ;
		ArrayList<Report_TestConducted> paList = new ArrayList<>();
		for (Object[] arr : objArr) {
			tcOBJ = new Report_TestConducted((Timestamp) arr[3], (String) arr[4], (String) arr[6], (String) arr[7],
					(String) arr[18], (BigInteger) arr[8], (String) arr[9], (String) arr[10], (BigInteger) arr[12],
					(String) arr[14], (String) arr[13]);

			paList.add(tcOBJ);
		}
		return paList;
	}

}
