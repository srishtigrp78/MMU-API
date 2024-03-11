package com.iemr.mmu.service.tele_consultation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

//import java.security.Timestamp;
import java.sql.Timestamp;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.data.tele_consultation.TCRequestModel;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.tc_consultation.TCRequestModelRepo;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;

@ExtendWith(MockitoExtension.class)
class TeleConsultationServiceImplTest {

	@Mock
	private TCRequestModelRepo tCRequestModelRepo;
	@Mock
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
	@Mock
	private CommonDoctorServiceImpl commonDoctorServiceImpl;
	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	TeleConsultationServiceImpl teleConsultationServiceImpl;

	@Test
	void testCreateTCRequest_Success() {
		TCRequestModel mockRequestModel = new TCRequestModel();
		mockRequestModel.settMRequestID(1L);

		when(tCRequestModelRepo.save(any(TCRequestModel.class))).thenReturn(mockRequestModel);

		int result = teleConsultationServiceImpl.createTCRequest(new TCRequestModel());

		assertEquals(1, result);
	}

	@Test
	void testCreateTCRequest_Failure() {
		TCRequestModel mockRequestModel = new TCRequestModel();
		mockRequestModel.settMRequestID(0L);

		when(tCRequestModelRepo.save(any(TCRequestModel.class))).thenReturn(mockRequestModel);

		int result = teleConsultationServiceImpl.createTCRequest(new TCRequestModel());

		assertEquals(0, result);
	}

	// **********
	@Test
	public void testUpdateBeneficiaryArrivalStatus_Success() throws Exception {
		when(beneficiaryFlowStatusRepo.updateBeneficiaryArrivalStatus(anyLong(), anyLong(), anyLong(), anyBoolean(),
				anyString(), anyInt())).thenReturn(1);
		when(tCRequestModelRepo.updateBeneficiaryStatus(anyLong(), anyLong(), eq("A"), anyString(), anyInt(),
				eq(false))).thenReturn(1);

		String requestOBJ = "{" + "\"benflowID\":1," + "\"benRegID\":2," + "\"visitCode\":3," + "\"status\":true,"
				+ "\"modifiedBy\":\"user\"," + "\"userID\":4" + "}";

		int result = teleConsultationServiceImpl.updateBeneficiaryArrivalStatus(requestOBJ);

		assertEquals(1, result);
	}

	@Test
	public void testUpdateBeneficiaryArrivalStatus_UpdateFailed() {
		when(beneficiaryFlowStatusRepo.updateBeneficiaryArrivalStatus(anyLong(), anyLong(), anyLong(), anyBoolean(),
				anyString(), anyInt())).thenReturn(0);

		String requestOBJ = "{\"benflowID\":1,\"benRegID\":2,\"visitCode\":3,\"status\":true,\"modifiedBy\":\"user\",\"userID\":4}";

		Exception exception = assertThrows(RuntimeException.class, () -> {
			teleConsultationServiceImpl.updateBeneficiaryArrivalStatus(requestOBJ);
		});

		assertTrue(exception.getMessage().contains("Beneficiary arrival status update failed"));
	}

	@Test
	public void testUpdateBeneficiaryStatus_UpdateFailed() {
		when(beneficiaryFlowStatusRepo.updateBeneficiaryArrivalStatus(anyLong(), anyLong(), anyLong(), anyBoolean(),
				anyString(), anyInt())).thenReturn(1);
		when(tCRequestModelRepo.updateBeneficiaryStatus(anyLong(), anyLong(), eq("A"), anyString(), anyInt(),
				eq(false))).thenReturn(0);

		String requestOBJ = "{\"benflowID\":1,\"benRegID\":2,\"visitCode\":3,\"status\":true,\"modifiedBy\":\"user\",\"userID\":4}";

		Exception exception = assertThrows(RuntimeException.class, () -> {
			teleConsultationServiceImpl.updateBeneficiaryArrivalStatus(requestOBJ);
		});

		assertTrue(exception.getMessage().contains("Beneficiary arrival status update failed"));
	}

	@Test
	public void testUpdateBeneficiaryArrivalStatus_InvalidRequest() {
		String requestOBJ = "{}";

		Exception exception = assertThrows(RuntimeException.class, () -> {
			teleConsultationServiceImpl.updateBeneficiaryArrivalStatus(requestOBJ);
		});

		assertTrue(exception.getMessage().contains("Invalid request"));
	}

//*****
	@Test
	public void testUpdateBeneficiaryStatusToCancelTCRequest_Success() throws Exception {
		String validRequestOBJ = "{\"benflowID\":1,\"benRegID\":2,\"visitCode\":3,\"modifiedBy\":\"user\",\"userID\":4}";
		String Authorization = "Bearer validToken";

		when(beneficiaryFlowStatusRepo.updateBeneficiaryStatusToCancelRequest(anyLong(), anyLong(), anyLong(),
				anyString(), anyInt())).thenReturn(1);
		when(tCRequestModelRepo.updateBeneficiaryStatus(anyLong(), anyLong(), eq("C"), anyString(), anyInt(), eq(true)))
				.thenReturn(1);

		int result = teleConsultationServiceImpl.updateBeneficiaryStatusToCancelTCRequest(validRequestOBJ,
				Authorization);

		assertEquals(1, result);
	}

	@Test
	public void testUpdateBeneficiaryStatusToCancelTCRequest_InvalidRequest() {
		String invalidRequestOBJ = "{}";
		String Authorization = "Bearer validToken";
		Exception exception = assertThrows(RuntimeException.class, () -> {
			teleConsultationServiceImpl.updateBeneficiaryStatusToCancelTCRequest(invalidRequestOBJ, Authorization);
		});

		assertTrue(exception.getMessage().contains("Invalid request"));
	}

//**********
	@Test
	void cancelSlotForTCCancel() {
		fail("Not yet implemented");
	}

	@Test
	void testCancelSlotForTCCancel_WithEmptyResultSetList() throws Exception {
		when(tCRequestModelRepo.getTcDetailsList(anyLong(), anyLong(), anyInt(), anySet()))
				.thenReturn(new ArrayList<>());
		int result = teleConsultationServiceImpl.cancelSlotForTCCancel(1, 1L, 1L, "Authorization");
		assertEquals(1, result);
	}

//**********
//	private String calculateToDate(String fromTime, Long duration) {
//		String toTime = "";
//
//		if (fromTime != null && duration != null) {
//			LocalTime fTime = LocalTime.parse(fromTime);
//			LocalTime tTime = fTime.plusMinutes(duration);
//
//			toTime = tTime.toString();
//		}
//
//		return toTime;
//	}
//
//	@Test
//	public void testCalculateToDate_WithValidInputs() {
//		// Setup
//		String fromTime = "10:00";
//		Long duration = 90L; // 1 hour and 30 minutes
//
//		// Execute
//		String result = calculateToDate(fromTime, duration);
//
//		// Verify
//		assertEquals("11:30", result, "The calculated toTime should be 11:30.");
//	}
//
//	@Test
//	public void testCalculateToDate_WithNullFromTime() {
//		// Setup
//		String fromTime = null;
//		Long duration = 90L; // Duration is valid
//
//		// Execute
//		String result = calculateToDate(fromTime, duration);
//
//		// Verify
//		assertTrue(result.isEmpty(), "The result should be an empty string when fromTime is null.");
//	}
//
//	@Test
//	public void testCalculateToDate_WithNullDuration() {
//		// Setup
//		String fromTime = "10:00";
//		Long duration = null; // Duration is null
//
//		// Execute
//		String result = calculateToDate(fromTime, duration);
//
//		// Verify
//		assertTrue(result.isEmpty(), "The result should be an empty string when duration is null.");
//	}
//
//	@Test
//	public void testCalculateToDate_WithBothInputsNull() {
//		// Setup
//		String fromTime = null;
//		Long duration = null; // Both inputs are null
//
//		// Execute
//		String result = calculateToDate(fromTime, duration);
//
//		// Verify
//		assertTrue(result.isEmpty(), "The result should be an empty string when both inputs are null.");
//	}

//*****	
	@Test
	public void testCheckBeneficiaryStatusForSpecialistTransaction_ValidRequestWithActiveTeleconsultationSession()
			throws Exception {
		// Mock the data returned by the repositories
		ArrayList<BeneficiaryFlowStatus> beneficiaryFlowStatuses = new ArrayList<>();
		BeneficiaryFlowStatus status = new BeneficiaryFlowStatus();
		status.setBenArrivedFlag(true); // Simulate that the beneficiary has arrived
		beneficiaryFlowStatuses.add(status);
		when(beneficiaryFlowStatusRepo.checkBeneficiaryArrivalStatus(anyLong(), anyLong(), anyLong(), anyInt()))
				.thenReturn(beneficiaryFlowStatuses);

		ArrayList<TCRequestModel> tcRequestModels = new ArrayList<>();
		tcRequestModels.add(new TCRequestModel()); // Simulate an active session
		when(tCRequestModelRepo.checkBenTcStatus(anyLong(), anyLong(), anyInt())).thenReturn(tcRequestModels);

		// Construct a valid request JSON
		String requestOBJ = "{\"benflowID\":1, \"benRegID\":1, \"visitCode\":1, \"userID\":1}";

		// Execute the test method
		int result = teleConsultationServiceImpl.checkBeneficiaryStatusForSpecialistTransaction(requestOBJ);

		// Verify and Assert
		assertEquals(1, result, "Expected to return 1 for valid request with active session");
	}

	@Test
	public void testCheckBeneficiaryStatusForSpecialistTransaction_BeneficiaryNotArrived() throws Exception {
		// Mock the repository to simulate the beneficiary has not arrived
		ArrayList<BeneficiaryFlowStatus> beneficiaryFlowStatuses = new ArrayList<>();
		BeneficiaryFlowStatus status = new BeneficiaryFlowStatus();
		status.setBenArrivedFlag(false); // Beneficiary has not arrived
		beneficiaryFlowStatuses.add(status);
		when(beneficiaryFlowStatusRepo.checkBeneficiaryArrivalStatus(anyLong(), anyLong(), anyLong(), anyInt()))
				.thenReturn(beneficiaryFlowStatuses);

		// Construct a request JSON
		String requestOBJ = "{\"benflowID\":1, \"benRegID\":1, \"visitCode\":1, \"userID\":1}";

		// Execute and assert the expected exception
		Exception exception = assertThrows(RuntimeException.class, () -> {
			teleConsultationServiceImpl.checkBeneficiaryStatusForSpecialistTransaction(requestOBJ);
		});

		assertTrue(exception.getMessage().contains("Sorry, Beneficiary has not arrived at TM spoke/center"));
	}

	@Test
	public void testCheckBeneficiaryStatusForSpecialistTransaction_NoActiveTeleconsultationSession() throws Exception {
		// Mock the beneficiaryFlowStatusRepo to simulate the beneficiary has arrived
		ArrayList<BeneficiaryFlowStatus> beneficiaryFlowStatuses = new ArrayList<>();
		BeneficiaryFlowStatus status = new BeneficiaryFlowStatus();
		status.setBenArrivedFlag(true); // Simulates that the beneficiary has arrived
		beneficiaryFlowStatuses.add(status);

		when(beneficiaryFlowStatusRepo.checkBeneficiaryArrivalStatus(anyLong(), anyLong(), anyLong(), anyInt()))
				.thenReturn(beneficiaryFlowStatuses);

		// Mock the tCRequestModelRepo to simulate there are no active teleconsultation
		// sessions
		when(tCRequestModelRepo.checkBenTcStatus(anyLong(), anyLong(), anyInt())).thenReturn(new ArrayList<>()); // Empty

		// Construct a request JSON
		String requestOBJ = "{\"benflowID\":1, \"benRegID\":1, \"visitCode\":1, \"userID\":1}";

		// Execute the test method and assert the expected exception
		Exception exception = assertThrows(RuntimeException.class, () -> {
			teleConsultationServiceImpl.checkBeneficiaryStatusForSpecialistTransaction(requestOBJ);
		});

		// Verify that the correct message is thrown
		assertTrue(exception.getMessage().contains("Sorry, Beneficiary has not any active Teleconsultation session."));
	}

	@Test
	public void testCheckBeneficiaryStatusForSpecialistTransaction_NoRecordOrMultipleRecordsFound() throws Exception {
		// Scenario 1: Simulate no record found by returning an empty list
		when(beneficiaryFlowStatusRepo.checkBeneficiaryArrivalStatus(anyLong(), anyLong(), anyLong(), anyInt()))
				.thenReturn(new ArrayList<>());

		String requestOBJ = "{\"benflowID\":1, \"benRegID\":1, \"visitCode\":1, \"userID\":1}";

		Exception exceptionNoRecord = assertThrows(RuntimeException.class, () -> {
			teleConsultationServiceImpl.checkBeneficiaryStatusForSpecialistTransaction(requestOBJ);
		});

		assertTrue(exceptionNoRecord.getMessage()
				.contains("No record or multiple record found in DB. Kindly contact the administrator"));

		// Scenario 2: Simulate multiple records found by returning a list with more
		// than one item
		ArrayList<BeneficiaryFlowStatus> multipleRecords = new ArrayList<>();
		multipleRecords.add(new BeneficiaryFlowStatus());
		multipleRecords.add(new BeneficiaryFlowStatus()); // Add more than one item to simulate multiple records found
		when(beneficiaryFlowStatusRepo.checkBeneficiaryArrivalStatus(anyLong(), anyLong(), anyLong(), anyInt()))
				.thenReturn(multipleRecords);

		Exception exceptionMultipleRecords = assertThrows(RuntimeException.class, () -> {
			teleConsultationServiceImpl.checkBeneficiaryStatusForSpecialistTransaction(requestOBJ);
		});

		assertTrue(exceptionMultipleRecords.getMessage()
				.contains("No record or multiple record found in DB. Kindly contact the administrator"));
	}

	@Test
	public void testCheckBeneficiaryStatusForSpecialistTransaction_InvalidRequestMissingParameters() {
		String requestOBJ = "{}"; // Empty JSON object

		Exception exception = assertThrows(RuntimeException.class, () -> {
			teleConsultationServiceImpl.checkBeneficiaryStatusForSpecialistTransaction(requestOBJ);
		});

		assertTrue(exception.getMessage().contains("Invalid request"));
	}

//********
	@Test
	void testCreateTCRequestFromWorkList() {
		fail("Not yet implemented");
	}

//**********
	@Test
	public void testGetTCRequestListBySpecialistIdAndDate_WithValidInputs() throws Exception {
		// Setup
		Integer providerServiceMapID = 1;
		Integer userID = 1;
		String reqDate = "2023-01-01T00:00:00";

		ArrayList<BeneficiaryFlowStatus> mockList = new ArrayList<>();
		mockList.add(new BeneficiaryFlowStatus()); // Add mock data as needed

		when(beneficiaryFlowStatusRepo.getTCRequestList(eq(providerServiceMapID), eq(userID), any(Timestamp.class)))
				.thenReturn(mockList);

		// Execute
		String result = teleConsultationServiceImpl.getTCRequestListBySpecialistIdAndDate(providerServiceMapID, userID,
				reqDate);

		// Verify
		assertEquals(new Gson().toJson(mockList), result);
	}

	@Test
	public void testGetTCRequestListBySpecialistIdAndDate_WithInvalidDateFormat() {
		// Setup invalid date format
		Integer providerServiceMapID = 1;
		Integer userID = 1;
		String reqDate = "invalid-date-format";

		// Execute and assert the expected exception
		Exception exception = assertThrows(Exception.class, () -> {
			teleConsultationServiceImpl.getTCRequestListBySpecialistIdAndDate(providerServiceMapID, userID, reqDate);
		});

		// Verify the exception message or type, depending on what you expect to fail
		// (parsing date in this case)
		assertTrue(exception instanceof Exception); // You can be more specific about the exception type if needed
	}

	@Test
	public void testGetTCRequestListBySpecialistIdAndDate_WithNullInputs() {
		// Setting up null inputs to test method's response to null arguments
		Integer providerServiceMapID = null;
		Integer userID = null;
		String reqDate = null;

		// This case depends on how your method and the called repository method handle
		// null inputs.
		// If they throw a NullPointerException or any other exception, you should catch
		// that.
		// For this example, let's assume it results in an Exception.

		Exception exception = assertThrows(Exception.class, () -> {
			teleConsultationServiceImpl.getTCRequestListBySpecialistIdAndDate(providerServiceMapID, userID, reqDate);
		});

		// Verify the exception message or type
		assertTrue(exception instanceof Exception); // Adjust based on the actual exception expected
	}

}
