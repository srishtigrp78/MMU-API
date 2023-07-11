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
import java.sql.Timestamp;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;

public class Report_LabTestsResult {
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
	private String Ben_ID;
	@Expose
	private String BenName;
	@Expose
	private String Gender;
	@Expose
	private BigInteger Age;
	@Expose
	private String TestName;
	@Expose
	private String TestComponentName;
	@Expose
	private String TestResult;

	public Report_LabTestsResult() {
	}

	public Report_LabTestsResult(Timestamp visit_Date, String district, String village, String service_Point,
			String mMU_Number, BigInteger ben_ID, String benName, String gender, BigInteger age, String test_Name,
			String test_Component_Name, String test_Result) {
		super();
		VisitDate = visit_Date;
		District = district;
		Village = village;
		ServicePoint = service_Point;
		MmuNumber = mMU_Number;
		if(ben_ID != null)
		Ben_ID = ben_ID.toString();
		BenName = benName;
		Gender = gender;
		Age = age;
		TestName = test_Name;
		TestComponentName = test_Component_Name;
		TestResult = test_Result;
	}

	public static ArrayList<Report_LabTestsResult> getLabTestResultReport(ArrayList<Object[]> objArr) {
		Report_LabTestsResult lrOBJ;

		ArrayList<Report_LabTestsResult> paList = new ArrayList<>();
		for (Object[] arr : objArr) {
			lrOBJ = new Report_LabTestsResult((Timestamp) arr[4], (String) arr[5], (String) arr[7], (String) arr[8],
					(String) arr[21], (BigInteger) arr[9], (String) arr[10], (String) arr[11], (BigInteger) arr[13],
					(String) arr[15], (String) arr[17], (String) arr[18]);

			paList.add(lrOBJ);
		}
		return paList;
	}

}
