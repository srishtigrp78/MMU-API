package com.iemr.mmu.data.reports;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;

public class Report_ChildrenCases {
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
	private String BenFatherName;
	@Expose
	private BigInteger Age;
	@Expose
	private Timestamp DateOfRegistration;
	@Expose
	private String DateOfBirth;
	@Expose
	private String ContactNo;
	@Expose
	private String VisitCategory;
	@Expose
	private String Visit_or_revisit;
	@Expose
	private Short VisitNo;

	public Report_ChildrenCases() {
	}

	public Report_ChildrenCases(Timestamp visit_Date, String district, String village, String service_Point,
			String mMU_Number, BigInteger ben_ID, String benName, String gender, String ben_Father_Name, BigInteger age,
			Timestamp date_of_Registration, Date date_of_Birth, String contact_no, String visit_Category,
			String visit_revisit, Short visitNo) {
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
		BenFatherName = ben_Father_Name;
		Age = age;
		DateOfRegistration = date_of_Registration;
		if (date_of_Birth != null)
			DateOfBirth = date_of_Birth.toString();
		ContactNo = contact_no;
		VisitCategory = visit_Category;
		Visit_or_revisit = visit_revisit;
		VisitNo = visitNo;
	}

	public static ArrayList<Report_ChildrenCases> getReport_ChildrenCasesReport(ArrayList<Object[]> objArr) {
		Report_ChildrenCases piOBJ;
		String visit_revisit;
		Short visit_No;
		ArrayList<Report_ChildrenCases> piList = new ArrayList<>();
		for (Object[] arr : objArr) {
			visit_No = (Short) arr[17];
			if (visit_No != null && visit_No > 1)
				visit_revisit = "Revisit";
			else
				visit_revisit = "Visit";
			piOBJ = new Report_ChildrenCases((Timestamp) arr[2], (String) arr[6], (String) arr[8], (String) arr[9],
					(String) arr[21], (BigInteger) arr[4], (String) arr[5], (String) arr[10], (String) arr[15],
					(BigInteger) arr[12], (Timestamp) arr[13], (Date) arr[11], (String) arr[14], (String) arr[16],
					visit_revisit, (Short) arr[17]);

			piList.add(piOBJ);
		}
		return piList;
	}
}
