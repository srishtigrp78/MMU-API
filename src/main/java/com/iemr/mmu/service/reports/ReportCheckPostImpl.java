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
package com.iemr.mmu.service.reports;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.reports.Report_ANC;
import com.iemr.mmu.data.reports.Report_ANCHighRisk;
import com.iemr.mmu.data.reports.Report_ChildrenCases;
import com.iemr.mmu.data.reports.Report_LabTestsResult;
import com.iemr.mmu.data.reports.Report_ModifiedAnc;
import com.iemr.mmu.data.reports.Report_PatientAttended;
import com.iemr.mmu.data.reports.Report_PatientInfo;
import com.iemr.mmu.data.reports.Report_TestConducted;
import com.iemr.mmu.data.reports.ReportsRequestDigester;
import com.iemr.mmu.repo.reports.ReportMasterRepo;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.mapper.OutputMapper;

@Service
public class ReportCheckPostImpl implements ReportCheckPost {

	@Autowired
	private ReportMasterRepo reportMasterRepo;

	public String getReportMaster(Integer serviceID) throws Exception {
		return new Gson().toJson(reportMasterRepo.findByServiceIDAndDeletedOrderByReportNameAsc(serviceID, false));
	}

	public String reportHandler(String requestOBJ) throws Exception {
		String reportData = "";
		ReportsRequestDigester request = InputMapper.gson().fromJson(requestOBJ, ReportsRequestDigester.class);
		if (request != null && request.getReportID() != null) {
			switch (request.getReportID()) {
			case 1:
				reportData = report_PatientAttended(request.getFromDate(), request.getToDate(), request.getVanID(),
						request.getProviderServiceMapID());
				break;

			case 2:
				reportData = report_TestConducted(request.getFromDate(), request.getToDate(), request.getVanID(),
						request.getProviderServiceMapID());
				break;

			case 5:
				reportData = report_ANC(request.getFromDate(), request.getToDate(), request.getVanID(),
						request.getProviderServiceMapID());
				break;

			case 6:
				reportData = report_Patientinfo(request.getFromDate(), request.getToDate(), request.getVanID(),
						request.getProviderServiceMapID());
				break;

			case 7:
				reportData = report_ChildrenCases(request.getFromDate(), request.getToDate(), request.getVanID(),
						request.getProviderServiceMapID());
				break;

			case 8:
				reportData = report_LabTestResult(request.getFromDate(), request.getToDate(), request.getVanID(),
						request.getProviderServiceMapID());
				break;

			case 9:
				reportData = report_ANCHighRisk(request.getFromDate(), request.getToDate(), request.getVanID(),
						request.getProviderServiceMapID());
				break;

			

			default:// default statement
			}
		} else
			throw new Exception("Invalid/NULL report ID");
		return reportData;
	}

	private String report_PatientAttended(Timestamp fromDate, Timestamp toDate, Integer vanID, Integer psmID)
			throws Exception {
		ArrayList<Report_PatientAttended> report_PA = new ArrayList<>();

		// Gson gson = new GsonBuilder().serializeNulls().create();

		if (fromDate == null || toDate == null || vanID == null || psmID == null)
			throw new Exception("Some parameter/parameters is/are missing.");
		else {
			if (vanID == 0)
				vanID = null;
			ArrayList<Object[]> RS = reportMasterRepo.get_report_PatientAttended(fromDate, toDate, psmID, vanID);
			if (RS != null && RS.size() > 0)
				report_PA = Report_PatientAttended.getPatientAttendedReport(RS);
		}
		return OutputMapper.gson().toJson(report_PA);
	}

	private String report_TestConducted(Timestamp fromDate, Timestamp toDate, Integer vanID, Integer psmID)
			throws Exception {
		ArrayList<Report_TestConducted> report_TC = new ArrayList<>();

		// Gson gson = new GsonBuilder().serializeNulls().create();

		if (fromDate == null || toDate == null || vanID == null || psmID == null)
			throw new Exception("Some parameter/parameters is/are missing.");
		else {
			if (vanID == 0)
				vanID = null;
			ArrayList<Object[]> RS = reportMasterRepo.get_report_TestConducted(fromDate, toDate, psmID, vanID);
			if (RS != null && RS.size() > 0)
				report_TC = Report_TestConducted.getTestConductedReport(RS);
		}
		return OutputMapper.gson().toJson(report_TC);
	}

	private String report_LabTestResult(Timestamp fromDate, Timestamp toDate, Integer vanID, Integer psmID)
			throws Exception {
		ArrayList<Report_LabTestsResult> report_LTR = new ArrayList<>();

		// Gson gson = new GsonBuilder().serializeNulls().create();

		if (fromDate == null || toDate == null || vanID == null || psmID == null)
			throw new Exception("Some parameter/parameters is/are missing.");
		else {
			if (vanID == 0)
				vanID = null;
			ArrayList<Object[]> RS = reportMasterRepo.get_report_LabTestResult(fromDate, toDate, psmID, vanID);
			if (RS != null && RS.size() > 0)
				report_LTR = Report_LabTestsResult.getLabTestResultReport(RS);
		}
		return OutputMapper.gson().toJson(report_LTR);
	}

	private String report_Patientinfo(Timestamp fromDate, Timestamp toDate, Integer vanID, Integer psmID)
			throws Exception {
		ArrayList<Report_PatientInfo> report_PI = new ArrayList<>();

		// Gson gson = new GsonBuilder().serializeNulls().create();

		if (fromDate == null || toDate == null || vanID == null || psmID == null)
			throw new Exception("Some parameter/parameters is/are missing.");
		else {
			if (vanID == 0)
				vanID = null;
			ArrayList<Object[]> RS = reportMasterRepo.get_report_PatientInfo(fromDate, toDate, psmID, vanID);
			if (RS != null && RS.size() > 0)
				report_PI = Report_PatientInfo.getReport_PatientInfoReport(RS);
		}
		return OutputMapper.gson().toJson(report_PI);
	}

	private String report_ChildrenCases(Timestamp fromDate, Timestamp toDate, Integer vanID, Integer psmID)
			throws Exception {
		ArrayList<Report_ChildrenCases> report_PI = new ArrayList<>();

		// Gson gson = new GsonBuilder().serializeNulls().create();

		if (fromDate == null || toDate == null || vanID == null || psmID == null)
			throw new Exception("Some parameter/parameters is/are missing.");
		else {
			if (vanID == 0)
				vanID = null;
			ArrayList<Object[]> RS = reportMasterRepo.get_report_SP_ChildrenCases(fromDate, toDate, psmID, vanID);
			if (RS != null && RS.size() > 0)
				report_PI = Report_ChildrenCases.getReport_ChildrenCasesReport(RS);
		}
		return OutputMapper.gson().toJson(report_PI);
	}

	private String report_ANC(Timestamp fromDate, Timestamp toDate, Integer vanID, Integer psmID) throws Exception {
		ArrayList<Report_ANC> report_ANC = new ArrayList<>();

		// Gson gson = new GsonBuilder().serializeNulls().create();

		if (fromDate == null || toDate == null || vanID == null || psmID == null)
			throw new Exception("Some parameter/parameters is/are missing.");
		else {
			if (vanID == 0)
				vanID = null;
			ArrayList<Object[]> RS = reportMasterRepo.get_report_SP_ANC(fromDate, toDate, psmID, vanID);
			if (RS != null && RS.size() > 0)
				report_ANC = Report_ANC.getReport_ANC(RS);
		}
		return OutputMapper.gson().toJson(report_ANC);
	}

	private String report_ANCHighRisk(Timestamp fromDate, Timestamp toDate, Integer vanID, Integer psmID)
			throws Exception {
		ArrayList<Report_ANCHighRisk> report_ANCHighRisk = new ArrayList<>();

		// Gson gson = new GsonBuilder().serializeNulls().create();

		if (fromDate == null || toDate == null || vanID == null || psmID == null)
			throw new Exception("Some parameter/parameters is/are missing.");
		else {
			if (vanID == 0)
				vanID = null;
			ArrayList<Object[]> RS = reportMasterRepo.get_report_SP_ANCHighRisk(fromDate, toDate, psmID, vanID);
			if (RS != null && RS.size() > 0)
				report_ANCHighRisk = Report_ANCHighRisk.getReport_ANChighRisk(RS);
		}
		return OutputMapper.gson().toJson(report_ANCHighRisk);
	}

	
	
}