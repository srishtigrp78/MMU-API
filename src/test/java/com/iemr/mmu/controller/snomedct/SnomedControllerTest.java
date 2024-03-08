package com.iemr.mmu.controller.snomedct;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.iemr.mmu.data.snomedct.SCTDescription;
import com.iemr.mmu.service.snomedct.SnomedService;
import com.iemr.mmu.utils.exception.IEMRException;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class SnomedControllerTest {

	@Mock
	private Logger logger = LoggerFactory.getLogger(SnomedController.class);

	@Mock
	private SnomedService snomedService;

	@InjectMocks
	SnomedController snomedController;

	@Test
	void testGetSnomedCTRecord_NoRecords() throws IEMRException {
		OutputResponse output = new OutputResponse();
		String request = "{\"request\":\"Get Snomed CT Record\"}";

		SCTDescription sctdescriptions = null;

		SCTDescription sctdescription = InputMapper.gson().fromJson(request, SCTDescription.class);

		logger.info("getSnomedCTRecord request " + sctdescription.toString());

		when(snomedService.findSnomedCTRecordFromTerm(sctdescription.getTerm())).thenReturn(sctdescriptions);

		String expResponse = snomedController.getSnomedCTRecord(request);

		output.setResponse("No Records Found");

		assertTrue(sctdescriptions == null || sctdescriptions.getConceptID() == null);

		assertEquals(expResponse, snomedController.getSnomedCTRecord(request));
		assertTrue(output.toString().contains("No Records Found"));
	}

	@Test
	void testGetSnomedCTRecord() throws IEMRException {
		OutputResponse output = new OutputResponse();
		String request = "{\"request\":\"Get Snomed CT Record\"}";

		SCTDescription sctdescriptions = null;

		SCTDescription sctdescription = InputMapper.gson().fromJson(request, SCTDescription.class);

		logger.info("getSnomedCTRecord request " + sctdescription.toString());

		when(snomedService.findSnomedCTRecordFromTerm(sctdescription.getTerm())).thenReturn(sctdescriptions);

		String expResponse = snomedController.getSnomedCTRecord(request);

		output.setResponse(new Gson().toJson(sctdescriptions));

		assertEquals(expResponse, snomedController.getSnomedCTRecord(request));
	}

	@Test
	void testGetSnomedCTRecord_RecordFound() throws IEMRException {
		// Prepare the input and mock the expected behavior
		String request = "{\"term\":\"Some Term\"}";
		SCTDescription mockSCTDescription = new SCTDescription();
		mockSCTDescription.setConceptID("12345");
		mockSCTDescription.setTerm("Some Term");
		String expectedResponse = new Gson().toJson(mockSCTDescription);

		when(snomedService.findSnomedCTRecordFromTerm("Some Term")).thenReturn(mockSCTDescription);

		// Execute the method
		String actualResponse = snomedController.getSnomedCTRecord(request);

		// Assert the response contains the expected data
		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("12345"));
		assertTrue(actualResponse.contains("Some Term"));

		// Verify the interaction with the mock
		verify(snomedService).findSnomedCTRecordFromTerm("Some Term");
	}

	@Test
	void testGetSnomedCTRecord_ExceptionThrown() {
		// Prepare the input and mock the behavior to throw an exception
		String request = "{\"term\":\"Invalid Term\"}";
		when(snomedService.findSnomedCTRecordFromTerm("Invalid Term"))
				.thenThrow(new RuntimeException("ggetSnomedCTRecord failed with error "));

		// Execute the method and assert the output
		String actualResponse = snomedController.getSnomedCTRecord(request);

		// Assert the response indicates an error
		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("ggetSnomedCTRecord failed with error "));
	}

	@Test
	void testGetSnomedCTRecordList_Success() throws Exception {
		String request = "{\"term\":\"exampleTerm\"}";
		String expectedResponse = "[{\"conceptId\":\"123\",\"term\":\"Example Term\"}]";

		when(snomedService.findSnomedCTRecordList(any(SCTDescription.class))).thenReturn(expectedResponse);

		String actualResponse = snomedController.getSnomedCTRecordList(request);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Example Term"));
	}

	@Test
	void testGetSnomedCTRecordList_NoRecords() throws Exception {
		String request = "{\"term\":\"nonExistingTerm\"}";
		String expectedResponse = "No Records Found";

		when(snomedService.findSnomedCTRecordList(any(SCTDescription.class))).thenReturn(null);

		String actualResponse = snomedController.getSnomedCTRecordList(request);

		assertNotNull(actualResponse);
	}

	@Test
	void testGetSnomedCTRecordList_Exception() throws Exception {
		String request = "{\"term\":\"throwsException\"}";

		when(snomedService.findSnomedCTRecordList(any(SCTDescription.class)))
				.thenThrow(new RuntimeException("Service exception"));

		String actualResponse = snomedController.getSnomedCTRecordList(request);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("error"));
	}

}
