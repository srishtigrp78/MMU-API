package com.iemr.mmu.controller.reports;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.mmu.controller.registrar.main.RegistrarController;
import com.iemr.mmu.service.reports.ReportCheckPostImpl;
import com.iemr.mmu.service.reports.ReportCheckPostImplNew;

@ExtendWith(MockitoExtension.class)
class ReportGatewayTest {

	@Mock
	private Logger logger = LoggerFactory.getLogger(RegistrarController.class);
	@Mock
	private ReportCheckPostImpl reportCheckPostImpl;
	@Mock
	private ReportCheckPostImplNew reportCheckPostImplNew;
	@InjectMocks
	ReportGateway reportGateway;

	@Test
	void testGetReportByReportID_Success() throws Exception {
		String validRequestObj = "{\"reportId\":\"123\"}";
		String expectedResponse = "{\"data\":\"Some report data\"}";

		when(reportCheckPostImpl.reportHandler(anyString())).thenReturn(expectedResponse);

		String result = reportGateway.getReportByReportID(validRequestObj);

		assertNotNull(result);
		assertTrue(result.contains("Some report data")); // Assert based on your actual success response structure
	}

	@Test
	void testGetReportByReportID_NullRequest() {
		String validRequestObj = "{\"reportId\":\"123\"}";
		String expectedResponse = "{\"data\":\"Some report data\"}";
		String result = reportGateway.getReportByReportID(null);

		assertNotNull(result);
		assertTrue(result.contains("Invalid request"));
	}

	@Test
	void testGetReportByReportID_ExceptionScenario() throws Exception {
		String validRequestObj = "{\"reportId\":\"123\"}";
		String expectedResponse = "{\"data\":\"Some report data\"}";

		when(reportCheckPostImpl.reportHandler(anyString())).thenThrow(new RuntimeException("Unexpected error"));

		String result = reportGateway.getReportByReportID(validRequestObj);

		assertNotNull(result);
		assertTrue(result.contains("Error occurred while fetching report"));
	}

	@Test
	void getReportByReportID1() throws Exception {
		String requestOBJ = "{\"reportId\":\"123\"}";
		String expectedResponse = "{\"response\":\"Success\"}";
		when(reportCheckPostImplNew.reportHandler(anyString())).thenReturn(expectedResponse);

		String actualResponse = reportGateway.getReportByReportID1(requestOBJ);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Success"));
	}

	@Test
	void getReportByReportID1_Invalid() {
		String actualResponse = reportGateway.getReportByReportID1(null);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Invalid request"));
	}

	@Test
	void getReportByReportID1_Exception() throws Exception {
		String requestOBJ = "{\"reportId\":\"123\"}";
		when(reportCheckPostImplNew.reportHandler(anyString())).thenThrow(new RuntimeException("Database down"));

		String actualResponse = reportGateway.getReportByReportID1(requestOBJ);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Error occurred while fetching report"));
	}

	@Test
	void testGetReportMaster_Success() throws Exception {
		Integer serviceID = 1;
		String expectedReport = "Some report data";
		when(reportCheckPostImpl.getReportMaster(serviceID)).thenReturn(expectedReport);

		String result = reportGateway.getReportMaster(serviceID);

		assertTrue(result.contains(expectedReport));
	}

	@Test
	void testGetReportMaster_NoReportFound() throws Exception {
		Integer serviceID = 1;
		when(reportCheckPostImpl.getReportMaster(serviceID)).thenReturn(null);

		String result = reportGateway.getReportMaster(serviceID);

		assertTrue(result.contains("Error while fetching report master data"));
	}

	@Test
	void testGetReportMaster_InvalidRequest() {
		String result = reportGateway.getReportMaster(null);

		assertTrue(result.contains("invalid request"));
	}

	@Test
	void testGetReportMaster_ExceptionThrown() throws Exception {
		Integer serviceID = 1;
		when(reportCheckPostImpl.getReportMaster(serviceID))
				.thenThrow(new RuntimeException("Error while fetching report master data is :"));

		String result = reportGateway.getReportMaster(serviceID);

		assertTrue(result.contains("Error while fetching report master data is :"));
	}

}
