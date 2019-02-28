package com.iemr.mmu.service.reports;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.reports.Report_LabTestsResult;
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

			case 8:
				reportData = report_LabTestResult(request.getFromDate(), request.getToDate(), request.getVanID(),
						request.getProviderServiceMapID());
				break;

			case 6:
				reportData = report_Patientinfo(request.getFromDate(), request.getToDate(), request.getVanID(),
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
}
