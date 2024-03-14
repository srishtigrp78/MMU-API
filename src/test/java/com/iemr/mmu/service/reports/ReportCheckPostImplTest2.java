package com.iemr.mmu.service.reports;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.mmu.repo.reports.ReportMasterRepo;
@ExtendWith(MockitoExtension.class)
class ReportCheckPostImplTest2 {

	@InjectMocks
	private ReportCheckPostImpl reportCheckPostImpl;

	@Mock
	private ReportMasterRepo reportMasterRepo;

	@Test
	void testGetReportMaster() {
		fail("Not yet implemented");
	}

	@Test
	void testReportHandler() {
		fail("Not yet implemented");
	}

	@Test
	void testReportHandlerForPatientAttended() throws Exception {
		// Given
		String requestOBJ = "{\"reportID\":1,\"fromDate\":\"2021-01-01T00:00:00\",\"toDate\":\"2021-01-31T23:59:59\",\"vanID\":1,\"providerServiceMapID\":1}";
		Timestamp fromDate = Timestamp.valueOf("2021-01-01 00:00:00");
		Timestamp toDate = Timestamp.valueOf("2021-01-31 23:59:59");
		Integer vanID = 1;
		Integer psmID = 1;

		ArrayList<Object[]> mockResponse = new ArrayList<>();
		// Assuming the structure of the objects in the list matches what
		// Report_PatientAttended expects
		// This needs to be adjusted according to the actual structure.
		mockResponse.add(new Object[] { "SampleData1", "SampleData2" });

		when(reportMasterRepo.get_report_PatientAttended(any(), any(), anyInt(), any())).thenReturn(mockResponse);

		// When
		String result = reportCheckPostImpl.reportHandler(requestOBJ);

		// Then
		// Verify that the repository method was called with the correct parameters
		verify(reportMasterRepo, times(1)).get_report_PatientAttended(eq(fromDate), eq(toDate), eq(psmID), eq(vanID));

		// Assert that the result is as expected
		// The assertion here depends on the format of the output JSON, which is not
		// detailed in the provided code.
		// This is just a placeholder assertion to illustrate the concept.
		// Please adjust the expected JSON string according to your actual output
		// format.
		String expectedJson = "[{\"data1\":\"SampleData1\",\"data2\":\"SampleData2\"}]";
		assertEquals(expectedJson, result);
	}

}
