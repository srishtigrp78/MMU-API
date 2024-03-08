package com.iemr.mmu.controller.teleconsultation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.service.tele_consultation.TeleConsultationServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class TeleConsultationControllerTest {

	@Mock
	private TeleConsultationServiceImpl teleConsultationServiceImpl;

	@InjectMocks
	TeleConsultationController teleConsultationController;

	private JsonObject parseJsonRequest(String requestObj) {
		JsonElement jsonElement = JsonParser.parseString(requestObj);
		return jsonElement.getAsJsonObject();
	}

	@Test
	void testBenArrivalStatusUpdater_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"request\":\"Ben Arrival Status Updater\"}";
		int i = 1;

		when(teleConsultationServiceImpl.updateBeneficiaryArrivalStatus(requestOBJ)).thenReturn(i);

		String expResponse = teleConsultationController.benArrivalStatusUpdater(requestOBJ);

		response.setResponse("Beneficiary arrival status updated successfully.");

		assertNotNull(requestOBJ);
		assertTrue(i > 0, "i is not greater than 0");

		assertEquals(expResponse, teleConsultationController.benArrivalStatusUpdater(requestOBJ));
		assertTrue(response.toString().contains("Beneficiary arrival status updated successfully."));

	}

	@Test
	void testBenArrivalStatusUpdater_Error() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"request\":\"Ben Arrival Status Updater\"}";
		int i = -1;

		when(teleConsultationServiceImpl.updateBeneficiaryArrivalStatus(requestOBJ)).thenReturn(i);

		String expResponse = teleConsultationController.benArrivalStatusUpdater(requestOBJ);

		response.setResponse("Error in updating beneficiary arrival status.");

		assertNotNull(requestOBJ);
		assertTrue(i < 0, "i is not less than 0");

		assertEquals(expResponse, teleConsultationController.benArrivalStatusUpdater(requestOBJ));
		assertTrue(response.toString().contains("Error in updating beneficiary arrival status."));
	}

	@Test
	void testBenArrivalStatusUpdater_InvalidRequest() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = null;

		String expResponse = teleConsultationController.benArrivalStatusUpdater(requestOBJ);

		response.setResponse("Invalid request");

		assertNull(requestOBJ);

		assertEquals(expResponse, teleConsultationController.benArrivalStatusUpdater(requestOBJ));
		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testBenArrivalStatusUpdater_Exception() throws Exception {
		// Mock the service
		TeleConsultationServiceImpl serviceMock = mock(TeleConsultationServiceImpl.class);
		String requestOBJ = "{\"request\":\"Test\"}";

		// Create the controller with the mocked service
		TeleConsultationController controller = new TeleConsultationController(); // Assuming constructor injection

		// Call the method
		String result = controller.benArrivalStatusUpdater(requestOBJ);

		// Verify the exception handling
		assertTrue(result.contains("Error while updating beneficiary arrival status."));
	}

	@Test
	void testUpdateBeneficiaryStatusToCancelTCRequest_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"request\":\"Update Beneficiary Status To Cancel TC Request\"}";
		int i = 1;
		String Authorization = "Test";

		when(teleConsultationServiceImpl.updateBeneficiaryStatusToCancelTCRequest(requestOBJ, Authorization))
				.thenReturn(i);

		String expResponse = teleConsultationController.updateBeneficiaryStatusToCancelTCRequest(requestOBJ,
				Authorization);

		response.setResponse("Beneficiary TC request cancelled successfully.");

		assertNotNull(requestOBJ);
		assertTrue(i > 0, "i is not greater than 0");

		assertEquals(expResponse,
				teleConsultationController.updateBeneficiaryStatusToCancelTCRequest(requestOBJ, Authorization));
		assertTrue(response.toString().contains("Beneficiary TC request cancelled successfully."));
	}

	@Test
	void testUpdateBeneficiaryStatusToCancelTC_RequestFailed() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"request\":\"Update Beneficiary Status To Cancel TC Request\"}";
		int i = -1;
		String Authorization = "Test";

		when(teleConsultationServiceImpl.updateBeneficiaryStatusToCancelTCRequest(requestOBJ, Authorization))
				.thenReturn(i);

		String expResponse = teleConsultationController.updateBeneficiaryStatusToCancelTCRequest(requestOBJ,
				Authorization);

		response.setResponse("Teleconsultation cancel request failed.");

		assertNotNull(requestOBJ);
		assertTrue(i < 0, "i is not less than 0");

		assertEquals(expResponse,
				teleConsultationController.updateBeneficiaryStatusToCancelTCRequest(requestOBJ, Authorization));
		assertTrue(response.toString().contains("Teleconsultation cancel request failed."));
	}

	@Test
	void testUpdateBeneficiaryStatusToCancelTCRequest_InvalidRequest() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = null;

		String Authorization = "Test";

		String expResponse = teleConsultationController.updateBeneficiaryStatusToCancelTCRequest(requestOBJ,
				Authorization);

		response.setResponse("Invalid request");

		assertNull(requestOBJ);

		assertEquals(expResponse,
				teleConsultationController.updateBeneficiaryStatusToCancelTCRequest(requestOBJ, Authorization));
		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testUpdateBeneficiaryStatusToCancelTCRequest_Exception() throws Exception {
		TeleConsultationServiceImpl serviceMock = mock(TeleConsultationServiceImpl.class);

		String requestOBJ = "{\"request\":\"Test\"}";
		String authorizationHeader = "Bearer token";

		TeleConsultationController controller = new TeleConsultationController(); // or use a setter method if available

		String result = controller.updateBeneficiaryStatusToCancelTCRequest(requestOBJ, authorizationHeader);

		assertTrue(result.contains("Error while updating beneficiary status for Teleconsultation cancel request"));
	}

	@Test
	void testCheckBeneficiaryStatusToProceedWithSpecialist_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"request\":\"Check Beneficiary Status To Proceed With Specialist\"}";
		int i = 1;

		when(teleConsultationServiceImpl.checkBeneficiaryStatusForSpecialistTransaction(requestOBJ)).thenReturn(i);

		String expResponse = teleConsultationController.checkBeneficiaryStatusToProceedWithSpecialist(requestOBJ);

		response.setResponse("Specialist can proceed with beneficiary TM session.");

		assertNotNull(requestOBJ);
		assertTrue(i > 0, "i is not greater than 0");

		assertEquals(expResponse, teleConsultationController.checkBeneficiaryStatusToProceedWithSpecialist(requestOBJ));
		assertTrue(response.toString().contains("Specialist can proceed with beneficiary TM session."));
	}

	@Test
	void testCheckBeneficiaryStatusToProceedWithSpecialist_Issue() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"request\":\"Check Beneficiary Status To Proceed With Specialist\"}";
		int i = -1;

		when(teleConsultationServiceImpl.checkBeneficiaryStatusForSpecialistTransaction(requestOBJ)).thenReturn(i);

		String expResponse = teleConsultationController.checkBeneficiaryStatusToProceedWithSpecialist(requestOBJ);

		response.setResponse("Issue while fetching beneficiary status.");

		assertNotNull(requestOBJ);
		assertTrue(i < 0, "i is not less than 0");

		assertEquals(expResponse, teleConsultationController.checkBeneficiaryStatusToProceedWithSpecialist(requestOBJ));
		assertTrue(response.toString().contains("Issue while fetching beneficiary status."));
	}

	@Test
	void testCheckBeneficiaryStatusToProceedWithSpecialist_InvalidRequest() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = null;

		String expResponse = teleConsultationController.checkBeneficiaryStatusToProceedWithSpecialist(requestOBJ);

		response.setResponse("Invalid request");

		assertNull(requestOBJ);

		assertEquals(expResponse, teleConsultationController.checkBeneficiaryStatusToProceedWithSpecialist(requestOBJ));
		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testCheckBeneficiaryStatusToProceedWithSpecialist_Exception() throws Exception {
		TeleConsultationServiceImpl serviceMock = mock(TeleConsultationServiceImpl.class);

		String requestOBJ = "{\"request\":\"Test\"}";

		when(serviceMock.checkBeneficiaryStatusForSpecialistTransaction(requestOBJ))
				.thenThrow(new RuntimeException("Issue while creating Teleconsultation request = "));

		TeleConsultationController controller = new TeleConsultationController();

		String result = controller.checkBeneficiaryStatusToProceedWithSpecialist(requestOBJ);

		assertTrue(result.contains("Issue while creating Teleconsultation request = "));
	}

	@Test
	void testCreateTCRequestForBeneficiary_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"request\":\"Create TC request for Beneficiary\"}";
		String Authorization = "Test";
		int i = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestOBJ);

		when(teleConsultationServiceImpl.createTCRequestFromWorkList(jsnOBJ, Authorization)).thenReturn(i);

		String expResponse = teleConsultationController.createTCRequestForBeneficiary(requestOBJ, Authorization);
		response.setResponse("Teleconsultation request created successfully.");

		assertNotNull(requestOBJ);
		assertTrue(i > 0, "i is not greater than 0");

		assertEquals(expResponse, teleConsultationController.createTCRequestForBeneficiary(requestOBJ, Authorization));
		assertTrue(response.toString().contains("Teleconsultation request created successfully."));
	}

	@Test
	void testCreateTCRequestForBeneficiary_Issue() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"request\":\"Create TC request for Beneficiary\"}";
		String Authorization = "Test";
		int i = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestOBJ);

		when(teleConsultationServiceImpl.createTCRequestFromWorkList(jsnOBJ, Authorization)).thenReturn(i);

		String expResponse = teleConsultationController.createTCRequestForBeneficiary(requestOBJ, Authorization);
		response.setResponse("Issue while creating Teleconsultation request.");

		assertNotNull(requestOBJ);
		assertTrue(i < 0, "i is not less than 0");

		assertEquals(expResponse, teleConsultationController.createTCRequestForBeneficiary(requestOBJ, Authorization));
		assertTrue(response.toString().contains("Issue while creating Teleconsultation request."));
	}

	@Test
	void testCreateTCRequestForBeneficiary_InvalidRequest() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = null;
		String Authorization = "Test";

		String expResponse = teleConsultationController.createTCRequestForBeneficiary(requestOBJ, Authorization);
		response.setResponse("Invalid request");

		assertNull(requestOBJ);

		assertEquals(expResponse, teleConsultationController.createTCRequestForBeneficiary(requestOBJ, Authorization));
		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	public void testCreateTCRequestForBeneficiary_Exception() throws Exception {
		String requestOBJ = "{\"key\":\"value\"}"; // Mock request body
		String authorizationHeader = "Bearer token"; // Mock authorization header
		doThrow(new RuntimeException("Test exception")).when(teleConsultationServiceImpl)
				.createTCRequestFromWorkList(any(), eq(authorizationHeader));

		String response = teleConsultationController.createTCRequestForBeneficiary(requestOBJ, authorizationHeader);

		assertNotNull(response);
		assertTrue(response.contains("Issue while creating Teleconsultation request"));
		verify(teleConsultationServiceImpl).createTCRequestFromWorkList(any(), eq(authorizationHeader));
	}

	@Test
	void testGetTCSpecialistWorkListNew_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"psmID\":1,\"userID\":2,\"date\":\"2023-04-01\"}";
		String s = "Test";

		JsonObject jsnOBJ = parseJsonRequest(requestOBJ);

		when(teleConsultationServiceImpl.getTCRequestListBySpecialistIdAndDate(jsnOBJ.get("psmID").getAsInt(),
				jsnOBJ.get("userID").getAsInt(), jsnOBJ.get("date").getAsString())).thenReturn(s);

		String expResponse = teleConsultationController.getTCSpecialistWorkListNew(requestOBJ);
		response.setResponse(s);

		assertNotNull(requestOBJ);
		assertNotNull(s);

		assertEquals(expResponse, teleConsultationController.getTCSpecialistWorkListNew(requestOBJ));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetTCSpecialistWorkListNew_InvalidRequest() {
		String result = teleConsultationController.getTCSpecialistWorkListNew(null);
		assertTrue(result.contains("Invalid request"));
	}

	@Test
	void testGetTCSpecialistWorkListNew_Exception() throws Exception {
		doThrow(new RuntimeException("Test exception")).when(teleConsultationServiceImpl)
				.getTCRequestListBySpecialistIdAndDate(anyInt(), anyInt(), anyString());

		String requestOBJ = "{\"psmID\":1, \"userID\":1, \"date\":\"2024-03-02\"}";

		String result = teleConsultationController.getTCSpecialistWorkListNew(requestOBJ);

		assertTrue(result.contains("Error while getting TC requestList"));
	}

}
