/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mmu.data.reports;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;

public class Report_PatientInfo {
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

	public Report_PatientInfo() {
	}

	public Report_PatientInfo(Timestamp visit_Date, String district, String village, String service_Point,
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

	public static ArrayList<Report_PatientInfo> getReport_PatientInfoReport(ArrayList<Object[]> objArr) {
		Report_PatientInfo piOBJ;
		String visit_revisit;
		Short visit_No;
		ArrayList<Report_PatientInfo> piList = new ArrayList<>();
		for (Object[] arr : objArr) {
			visit_No = (Short) arr[17];
			if (visit_No != null && visit_No > 1)
				visit_revisit = "Revisit";
			else
				visit_revisit = "Visit";
			piOBJ = new Report_PatientInfo((Timestamp) arr[2], (String) arr[6], (String) arr[8], (String) arr[9],
					(String) arr[21], (BigInteger) arr[4], (String) arr[5], (String) arr[10], (String) arr[15],
					(BigInteger) arr[12], (Timestamp) arr[13], (Date) arr[11], (String) arr[14], (String) arr[16],
					visit_revisit, (Short) arr[17]);

			piList.add(piOBJ);
		}
		return piList;
	}
}
