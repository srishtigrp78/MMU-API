package com.iemr.mmu.service.reports;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.Gson;
import com.iemr.mmu.data.reports.ReportMaster;
import com.iemr.mmu.repo.reports.ReportMasterRepo;

@ExtendWith(MockitoExtension.class)
class ReportCheckPostImplTest {

	@Mock
	private ReportMasterRepo reportMasterRepo;
	@InjectMocks
	ReportCheckPostImpl reportCheckPost;
	
	private final Timestamp fromDate = Timestamp.valueOf("2023-01-01 00:00:00");
    private final Timestamp toDate = Timestamp.valueOf("2023-01-31 23:59:59");
    private final Integer vanID = 1;
    private final Integer psmID = 1;
    private final String requestTemplate = "{\"reportID\":%d,\"fromDate\":\"%s\",\"toDate\":\"%s\",\"vanID\":%d,\"providerServiceMapID\":%d}";


	@Test
	void testGetReportMaster() throws Exception {
		// Arrange
		Integer serviceID = 1;
		List<ReportMaster> mockResponse = new ArrayList<>();

		ReportMaster report1 = new ReportMaster();
		report1.setReportName("Report1");
		report1.setServiceID(serviceID);
		report1.setDeleted(false);

		ReportMaster report2 = new ReportMaster();
		report2.setReportName("Report2");
		report2.setServiceID(serviceID);
		report2.setDeleted(false);

		mockResponse.add(report1);
		mockResponse.add(report2);

		when(reportMasterRepo.findByServiceIDAndDeletedOrderByReportNameAsc(serviceID, false))
				.thenReturn((ArrayList<ReportMaster>) mockResponse);

		// Act
		String actualJson = reportCheckPost.getReportMaster(serviceID);

		// Assert
		Gson gson = new Gson();
		String expectedJson = gson.toJson(mockResponse);
		assertEquals(expectedJson, actualJson, "The returned JSON does not match the expected JSON.");
	}

	@Test
	void testReportHandler() {
		fail("Not yet implemented");
	}

	
}
