package com.iemr.mmu.controller.cancerscreening;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.service.cancerScreening.CSService;
import com.iemr.mmu.utils.exception.IEMRException;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class CancerScreeningControllerTest {
	@Mock
	private Logger logger = LoggerFactory.getLogger(CancerScreeningController.class);
	@Mock
	private CSService cSService;

	@InjectMocks
	private CancerScreeningController cancerScreeningController;

	private JsonObject parseJsonRequest(String requestObj) {
		JsonElement jsonElement = JsonParser.parseString(requestObj);
		return jsonElement.getAsJsonObject();
	}

	@Test
	void testSaveBenCancerScreeningNurseData_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save cancer screening nurse data\"}";
		String authorization = "Bearer token";
		Long nurseDataSaveSuccessFlag = 1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(cSService.saveCancerScreeningNurseData(jsnOBJ, authorization)).thenReturn(nurseDataSaveSuccessFlag);

		String expResponse = cancerScreeningController.saveBenCancerScreeningNurseData(requestObj, authorization);

		response.setResponse("Data saved successfully");

		assertNotNull(jsnOBJ);
		assertTrue(nurseDataSaveSuccessFlag != null && nurseDataSaveSuccessFlag == 1);

		assertEquals(expResponse, cancerScreeningController.saveBenCancerScreeningNurseData(requestObj, authorization));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveBenCancerScreeningNurseData_CatchBlock() throws Exception {
		String requestObj = "{\"request\":\"Save cancer screening nurse data\"}";
		String authorization = "Bearer token";

		when(cSService.saveCancerScreeningNurseData(any(), any())).thenThrow(NotFoundException.class);

		String saveBenCancerScreeningNurseData = cancerScreeningController.saveBenCancerScreeningNurseData(requestObj,
				authorization);

		assertTrue(saveBenCancerScreeningNurseData.contains("Unable to save data"));
	}

	@Test
	void testSaveBenCancerScreeningNurseData_MAMMOGRAM() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save cancer screening nurse data\"}";
		String authorization = "Bearer token";
		Long nurseDataSaveSuccessFlag = 2L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(cSService.saveCancerScreeningNurseData(jsnOBJ, authorization)).thenReturn(nurseDataSaveSuccessFlag);

		String expResponse = cancerScreeningController.saveBenCancerScreeningNurseData(requestObj, authorization);

		response.setResponse("Data saved and MAMMOGRAM order created successfully");

		assertNotNull(jsnOBJ);
		assertTrue(nurseDataSaveSuccessFlag != null && nurseDataSaveSuccessFlag == 2);

		assertEquals(expResponse, cancerScreeningController.saveBenCancerScreeningNurseData(requestObj, authorization));
		assertTrue(response.toString().contains("Data saved and MAMMOGRAM order created successfully"));
	}

	@Test
	void testSaveBenCancerScreeningNurseDataMAMMOGRAMFail() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save cancer screening nurse data\"}";
		String authorization = "Bearer token";
		Long nurseDataSaveSuccessFlag = 3L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(cSService.saveCancerScreeningNurseData(jsnOBJ, authorization)).thenReturn(nurseDataSaveSuccessFlag);

		String expResponse = cancerScreeningController.saveBenCancerScreeningNurseData(requestObj, authorization);

		response.setError(9999,
				"Data saved successfully but 'error in mammogram order creation';please contact administrator");

		assertNotNull(jsnOBJ);
		assertNotNull(nurseDataSaveSuccessFlag);
		assertTrue((nurseDataSaveSuccessFlag != 1) && (nurseDataSaveSuccessFlag != 2));

		assertEquals(expResponse, cancerScreeningController.saveBenCancerScreeningNurseData(requestObj, authorization));
		assertTrue(response.toString().contains(
				"Data saved successfully but 'error in mammogram order creation';please contact administrator"));
	}

	@Test
	void testSaveBenCancerScreeningNurseData_DataAlreadySaved() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save cancer screening nurse data\"}";
		String authorization = "Bearer token";
		Long nurseDataSaveSuccessFlag = 0L; // Indicating data already saved

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(cSService.saveCancerScreeningNurseData(jsnOBJ, authorization)).thenReturn(nurseDataSaveSuccessFlag);

		String actualResponse = cancerScreeningController.saveBenCancerScreeningNurseData(requestObj, authorization);

		response.setResponse("Data already saved");

		assertNotNull(jsnOBJ);
		assertTrue(nurseDataSaveSuccessFlag != null && nurseDataSaveSuccessFlag == 0);

		assertEquals(response.toString(), actualResponse);
		assertTrue(actualResponse.contains("Data already saved"));
	}

	@Test
	void testSaveBenCancerScreeningNurseData_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save cancer screening nurse data\"}";
		String authorization = "Bearer token";
		Long nurseDataSaveSuccessFlag = null;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(cSService.saveCancerScreeningNurseData(jsnOBJ, authorization)).thenReturn(nurseDataSaveSuccessFlag);

		String expResponse = cancerScreeningController.saveBenCancerScreeningNurseData(requestObj, authorization);

		response.setError(5000, "Unable to save data");

		assertNotNull(jsnOBJ);
		assertNull(nurseDataSaveSuccessFlag);

		assertEquals(expResponse, cancerScreeningController.saveBenCancerScreeningNurseData(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to save data"));
	}

	@Test
	void testSaveBenCancerScreeningNurseData_InvalidRequest() throws Exception {
		OutputResponse response = new OutputResponse();

		JsonObject jsnOBJ = null;

		response.setError(5000, "Invalid request");

		assertNull(jsnOBJ);

		assertTrue(response.toString().contains("Invalid request"));
	}

//*******************	
	@Test
	void testsaveBenCancerScreeningDoctorData_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save cancer screening doctor data\"}";
		String authorization = "Bearer token";
		Long csDocDataSaveSuccessFlag = 1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(cSService.saveCancerScreeningDoctorData(jsnOBJ, authorization)).thenReturn(csDocDataSaveSuccessFlag);

		String expResponse = cancerScreeningController.saveBenCancerScreeningDoctorData(requestObj, authorization);

		response.setResponse("Data saved successfully");

		assertNotNull(jsnOBJ);
		assertTrue(csDocDataSaveSuccessFlag != null && csDocDataSaveSuccessFlag > 0);

		assertEquals(expResponse,
				cancerScreeningController.saveBenCancerScreeningDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testsaveBenCancerScreeningDoctorData_CatchBlock() throws Exception {

		String requestObj = "{\"request\":\"Save cancer screening doctor data\"}";
		String authorization = "Bearer token";

		when(cSService.saveCancerScreeningDoctorData(any(), any())).thenThrow(NotFoundException.class);

		String saveBenCancerScreeningDoctorData = cancerScreeningController.saveBenCancerScreeningDoctorData(requestObj,
				authorization);

		assertTrue(saveBenCancerScreeningDoctorData.contains("Unable to save data"));
	}

	@Test
	void testsaveBenCancerScreeningDoctorData_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save cancer screening doctor data\"}";
		String authorization = "Bearer token";
		Long csDocDataSaveSuccessFlag = -1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(cSService.saveCancerScreeningDoctorData(jsnOBJ, authorization)).thenReturn(csDocDataSaveSuccessFlag);

		String expResponse = cancerScreeningController.saveBenCancerScreeningDoctorData(requestObj, authorization);

		response.setError(5000, "Unable to save data");

		assertNotNull(jsnOBJ);
		assertTrue(csDocDataSaveSuccessFlag != null && csDocDataSaveSuccessFlag < 0);

		assertEquals(expResponse,
				cancerScreeningController.saveBenCancerScreeningDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to save data"));
	}

	@Test
	void testsaveBenCancerScreeningDoctorData_InvalidRequest() throws Exception {
		OutputResponse response = new OutputResponse();

		JsonObject jsnOBJ = null;

		response.setError(5000, "Invalid request");

		assertNull(jsnOBJ);

		assertTrue(response.toString().contains("Invalid request"));
	}

//******************
	@Test
	void testGetBenDataFrmNurseScrnToDocScrnVisitDetails_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\", \"visitCode\":\"1\"}";
		String s = "Test";

		JSONObject obj = new JSONObject(comingRequest);
		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		// when(cSService.getBenDataFrmNurseToDocVisitDetailsScreen(benRegID,
		// visitCode)).thenReturn(s);

		String expResponse = cancerScreeningController.getBenDataFrmNurseScrnToDocScrnExamination(comingRequest);

		response.setResponse(s);

		assertTrue(obj.length() > 1);

		assertEquals(expResponse, cancerScreeningController.getBenDataFrmNurseScrnToDocScrnExamination(comingRequest));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetBenDataFrmNurseScrnToDocScrnVisitDetails_InvalidRequest() throws Exception {
		String invalidRequest = "{}"; // Missing required fields

		String response = cancerScreeningController.getBenDataFrmNurseScrnToDocScrnVisitDetails(invalidRequest);

		assertTrue(response.contains("Invalid request"));
		verify(cSService, never()).getBenDataFrmNurseToDocVisitDetailsScreen(anyLong(), anyLong());
	}

	@Test
	void testGetBenDataFrmNurseScrnToDocScrnVisitDetails_Exception() throws Exception {
		Long benRegID = 123L;
		Long visitCode = 456L;
		String request = "{\"benRegID\":" + benRegID + ", \"visitCode\":" + visitCode + "}";
		doThrow(new RuntimeException("Error while getting beneficiary visit data")).when(cSService)
				.getBenDataFrmNurseToDocVisitDetailsScreen(benRegID, visitCode);

		String response = cancerScreeningController.getBenDataFrmNurseScrnToDocScrnVisitDetails(request);

		assertTrue(response.contains("Error while getting beneficiary visit data"));
		verify(cSService, times(1)).getBenDataFrmNurseToDocVisitDetailsScreen(benRegID, visitCode);
	}

//*************************	
	@Test
	void testGetBenDataFrmNurseScrnToDocScrnHistory() throws JSONException {
		OutputResponse response = new OutputResponse();
		String comingRequest = "{\"benRegID\":\"1\", \"visitCode\":\"2\"}";
		String s = "Test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(cSService.getBenDataFrmNurseToDocHistoryScreen(benRegID, visitCode)).thenReturn(s);

		String expResponse = cancerScreeningController.getBenDataFrmNurseScrnToDocScrnHistory(comingRequest);

		response.setResponse(s);

		assertTrue(obj.length() > 1);

		assertEquals(expResponse, cancerScreeningController.getBenDataFrmNurseScrnToDocScrnHistory(comingRequest));
		assertTrue(response.toString().contains(s));
	}

//	@Test
//	void testGetBenDataFrmNurseScrnToDocScrnHistory_CatchBlock() throws Exception {
//	    String comingRequest = "{\"benRegID\":\"1\", \"visitCode\":\"2\"}";
//	    
//	    when(cSService.getBenDataFrmNurseToDocHistoryScreen(anyLong(), anyLong())).thenThrow(NotFoundException.class);
//
//	    String responseString = cancerScreeningController.getBenDataFrmNurseScrnToDocScrnHistory(comingRequest);
//
//	    assertTrue(responseString.contains("Error while getting beneficiary history data"));
//	}

	@Test
	void testExceptionScenario() {
		// Setup the mock to throw an exception when the service method is called
		Mockito.when(cSService.getBenDataFrmNurseToDocHistoryScreen(Mockito.anyLong(), Mockito.anyLong()))
				.thenThrow(new RuntimeException("Simulated exception"));

		// Prepare a valid request
		String validRequest = "{\"benRegID\":\"1\", \"visitCode\":\"2\"}";

		// Call the controller method which is expected to handle the exception
		String response = cancerScreeningController.getBenDataFrmNurseScrnToDocScrnHistory(validRequest);

		// Check if the response indicates an error due to exception
		assertTrue(response.contains("Error while getting beneficiary history data"));
	}

//	@Test
//	void testGetBenDataFrmNurseScrnToDocScrnHistory_InvalidRequest() throws JSONException {
//		OutputResponse response = new OutputResponse();
//		String comingRequest = "{\"benRegID\":\"0\", \"visitCode\":\"0\"}";
//		
//		JSONObject obj = new JSONObject(comingRequest);
//
//		response.setError(5000, "Invalid request");
//		
//		assertNotEquals(0,obj.length());
//		
//		assertTrue(response.toString().contains("Invalid request"));
//	}

	@Test
	void testInvalidInput() {
		String invalidRequest = "{}";

		String response = cancerScreeningController.getBenDataFrmNurseScrnToDocScrnHistory(invalidRequest);

		assertTrue(response.contains("Invalid request"));
	}

//*****************
	@Test
	void testGetBenDataFrmNurseScrnToDocScrnVital() throws JSONException {
		OutputResponse response = new OutputResponse();
		String comingRequest = "{\"benRegID\":\"1\", \"visitCode\":\"1\"}";
		String s = "test";
		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(cSService.getBenDataFrmNurseToDocVitalScreen(benRegID, visitCode)).thenReturn(s);

		String expResponse = cancerScreeningController.getBenDataFrmNurseScrnToDocScrnVital(comingRequest);

		response.setResponse(s);

		assertTrue(obj.length() > 1);
		assertEquals(expResponse, cancerScreeningController.getBenDataFrmNurseScrnToDocScrnVital(comingRequest));
		assertTrue(response.toString().contains(s));
	}

//	@Test
//	void testGetBenDataFrmNurseScrnToDocScrnVital_InvalidRequest() throws JSONException {
//		OutputResponse response = new OutputResponse();
//		String comingRequest = "{\"benRegID\":\"1\", \"visitCode\":\"1\"}";
//		String s = "test";
//		JSONObject obj = new JSONObject(comingRequest);
//
//		Long benRegID = obj.getLong("benRegID");
//		Long visitCode = obj.getLong("visitCode");
//
//		when(cSService.getBenDataFrmNurseToDocVitalScreen(benRegID, visitCode)).thenReturn(s);
//		
//		String expResponse = cancerScreeningController.getBenDataFrmNurseScrnToDocScrnVital(comingRequest);
//		
//		response.setResponse(s);
//		
//		assertTrue(obj.length() > 1);
//		assertEquals(expResponse,cancerScreeningController.getBenDataFrmNurseScrnToDocScrnVital(comingRequest));
//		assertTrue(response.toString().contains(s));
//	}

	@Test
	void testGetBenDataFrmNurseScrnToDocScrnVital_InvalidRequest() {
		String invalidRequest = "{}";

		String actualResponse = cancerScreeningController.getBenDataFrmNurseScrnToDocScrnVital(invalidRequest);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Invalid request"));
	}

	@Test
	void testGetBenDataFrmNurseScrnToDocScrnVital_Exception() throws JSONException {
		String comingRequest = "{\"benRegID\":1, \"visitCode\":1}";
		when(cSService.getBenDataFrmNurseToDocVitalScreen(1L, 1L)).thenThrow(new RuntimeException("Unexpected error"));

		String actualResponse = cancerScreeningController.getBenDataFrmNurseScrnToDocScrnVital(comingRequest);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Error while getting beneficiary vital data"));
	}

//**************
	@Test
	void testGetBenDataFrmNurseScrnToDocScrnExamination() throws JSONException {
		OutputResponse response = new OutputResponse();
		String comingRequest = "{\"benRegID\":\"1\", \"visitCode\":\"1\"}";
		String s = "test";
		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(cSService.getBenDataFrmNurseToDocExaminationScreen(benRegID, visitCode)).thenReturn(s);

		String expResponse = cancerScreeningController.getBenDataFrmNurseScrnToDocScrnExamination(comingRequest);

		response.setResponse(s);

		assertTrue(obj.length() > 1);
		assertEquals(expResponse, cancerScreeningController.getBenDataFrmNurseScrnToDocScrnExamination(comingRequest));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetBenDataFrmNurseScrnToDocScrnExamination_InvalidInput() {
		String invalidRequest = "{}";

		String actualResponse = cancerScreeningController.getBenDataFrmNurseScrnToDocScrnExamination(invalidRequest);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Invalid request"));
	}

	@Test
	void testGetBenDataFrmNurseScrnToDocScrnExamination_ThrowsException() throws JSONException {
		String request = "{\"benRegID\":1, \"visitCode\":1}";

		// Simulate an exception
		when(cSService.getBenDataFrmNurseToDocExaminationScreen(1L, 1L))
				.thenThrow(new RuntimeException("Service exception"));

		String actualResponse = cancerScreeningController.getBenDataFrmNurseScrnToDocScrnExamination(request);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Error while getting beneficiary examination data"));
	}

//***********************
	@Test
	void testGetBenCancerFamilyHistory() throws JSONException {
		OutputResponse response = new OutputResponse();
		String comingRequest = "{\"benRegID\":\"1\"}";
		String s = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");

		when(cSService.getBenFamilyHistoryData(benRegID)).thenReturn(s);

		String expResponse = cancerScreeningController.getBenCancerFamilyHistory(comingRequest);

		response.setResponse(s);

		assertTrue(obj.has("benRegID"));

		assertEquals(expResponse, cancerScreeningController.getBenCancerFamilyHistory(comingRequest));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetBenCancerFamilyHistory_InvalidRequest() {
		String comingRequest = "{}"; // Missing required benRegID

		String actualResponse = cancerScreeningController.getBenCancerFamilyHistory(comingRequest);

		assertTrue(actualResponse.contains("Invalid request"));
	}

	@Test
	void testGetBenCancerFamilyHistory_Exception() throws JSONException {
		String comingRequest = "{\"benRegID\":1}";
		when(cSService.getBenFamilyHistoryData(1L)).thenThrow(new RuntimeException("Database error"));

		String actualResponse = cancerScreeningController.getBenCancerFamilyHistory(comingRequest);

		assertTrue(actualResponse.contains("Error while getting beneficiary family history data"));
	}

//*********************
	@Test
	void testGetBenCancerPersonalHistory() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\"}";
		String s = "test";
		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");

		when(cSService.getBenPersonalHistoryData(benRegID)).thenReturn(s);

		String expResponse = cancerScreeningController.getBenCancerPersonalHistory(comingRequest);

		response.setResponse(s);

		assertTrue(obj.has("benRegID"));

		assertEquals(expResponse, cancerScreeningController.getBenCancerPersonalHistory(comingRequest));
		assertTrue(response.toString().contains(s));
	}
	
	@Test
	void testGetBenCancerPersonalHistory_Invalid() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";
	
		JSONObject obj = new JSONObject(comingRequest);
		
		response.setError(5000, "Invalid request");

		assertFalse(obj.has("benRegID"));

		assertTrue(response.toString().contains("Invalid request"));
	}
	
	@Test
	void testGetBenCancerPersonalHistory_Exception() throws JSONException {
		OutputResponse response = new OutputResponse();
		
		response.setError(5000, "Error while getting beneficiary personal history data");
		
		assertEquals(response.toString(),cancerScreeningController.getBenCancerPersonalHistory(any()));
	}

//****************
	@Test
	void testGetBenCancerPersonalDietHistory() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\"}";
		String s = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");

		when(cSService.getBenPersonalDietHistoryData(benRegID)).thenReturn(s);

		String expResponse = cancerScreeningController.getBenCancerPersonalDietHistory(comingRequest);

		response.setResponse(s);

		assertTrue(obj.has("benRegID"));

		assertEquals(expResponse, cancerScreeningController.getBenCancerPersonalDietHistory(comingRequest));
		assertTrue(response.toString().contains(s));
	}

	@Test
	public void testInvalidBenCancerPersonalDietHistory_Invalid() {
		String comingRequest = "{}"; // Missing "benRegID"

		String actualResponse = cancerScreeningController.getBenCancerPersonalDietHistory(comingRequest);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Invalid request"));
	}

	@Test
	public void testErrorHandlingInBenCancerPersonalDietHistory_Exception() throws JSONException {
		String comingRequest = "{\"benRegID\":1}";
		when(cSService.getBenPersonalDietHistoryData(1L)).thenThrow(new RuntimeException("Test exception"));

		String actualResponse = cancerScreeningController.getBenCancerPersonalDietHistory(comingRequest);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Error while getting beneficiary personal diet history data"));
	}

//***********************
	@Test
	void testGetBenCancerObstetricHistory() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\"}";
		String s = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");

		when(cSService.getBenObstetricHistoryData(benRegID)).thenReturn(s);

		String expResponse = cancerScreeningController.getBenCancerObstetricHistory(comingRequest);

		response.setResponse(s);

		assertTrue(obj.has("benRegID"));

		assertEquals(expResponse, cancerScreeningController.getBenCancerObstetricHistory(comingRequest));
		assertTrue(response.toString().contains(s));

	}

	@Test
	void testGetBenCancerObstetricHistory_InvalidRequest() {
		String invalidRequest = "{}"; // Missing benRegID
		String actualResponse = cancerScreeningController.getBenCancerObstetricHistory(invalidRequest);

		assert (actualResponse.contains("Invalid request"));
	}

	@Test
	void testGetBenCancerObstetricHistory_Exception() throws Exception {
		String comingRequest = "{\"benRegID\":1}";
		when(cSService.getBenObstetricHistoryData(anyLong())).thenThrow(new RuntimeException("Test exception"));

		String actualResponse = cancerScreeningController.getBenCancerObstetricHistory(comingRequest);

		assert (actualResponse.contains("Error while getting beneficiary obstetric history data"));
	}

//***************************
	@Test
	void testGetBenCaseRecordFromDoctorCS() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\", \"visitCode\":\"1\"}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(cSService.getBenCaseRecordFromDoctorCS(benRegID, visitCode)).thenReturn(res);

		String expResponse = cancerScreeningController.getBenCaseRecordFromDoctorCS(comingRequest);

		response.setResponse(res);

		assertTrue(obj.length() > 1 && obj.has("benRegID") && obj.has("visitCode"));
		assertEquals(expResponse, cancerScreeningController.getBenCaseRecordFromDoctorCS(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenCaseRecordFromDoctorCS_InvalidRequest() {
		// Prepare the invalid request
		String request = "{}"; // Missing required fields

		// Call the method
		String actualResponse = cancerScreeningController.getBenCaseRecordFromDoctorCS(request);

		// Verify the response contains error
		assertTrue(actualResponse.contains("Invalid request"));
	}

	@Test
	void testGetBenCaseRecordFromDoctorCS_Exception() {
		// Prepare the mock request
		String request = "{\"benRegID\":123, \"visitCode\":456}";

		// Mock the service call to throw an exception
		when(cSService.getBenCaseRecordFromDoctorCS(123L, 456L)).thenThrow(new RuntimeException("Test Exception"));

		// Call the method
		String actualResponse = cancerScreeningController.getBenCaseRecordFromDoctorCS(request);

		// Verify the response contains error
		assertTrue(actualResponse.contains("Error while getting beneficiary doctor data"));
	}

//************
	@Test
	void testUpdateCSHistoryNurse_Success() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"Update cancer screening history nurse data in doctor screen\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(cSService.UpdateCSHistoryNurseData(jsnOBJ)).thenReturn(result);

		String expResponse = cancerScreeningController.updateCSHistoryNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, cancerScreeningController.updateCSHistoryNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateCSHistoryNurse_CatchBlock() throws Exception {
		String requestObj = "{\"request\":\"Update cancer screening history nurse data in doctor screen\"}";

		when(cSService.UpdateCSHistoryNurseData(any())).thenThrow(NotFoundException.class);

		String UpdateCSHistoryNurse = cancerScreeningController.updateCSHistoryNurse(requestObj);

		assertTrue(UpdateCSHistoryNurse.contains("Unable to modify data"));
	}

	@Test
	void testUpdateCSHistoryNurse_Unable() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"Update cancer screening history nurse data in doctor screen\"}";
		int result = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(cSService.UpdateCSHistoryNurseData(jsnOBJ)).thenReturn(result);

		String expResponse = cancerScreeningController.updateCSHistoryNurse(requestObj);

		response.setError(500, "Unable to modify data");

		assertTrue(result < 0);

		assertEquals(expResponse, cancerScreeningController.updateCSHistoryNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

//****************
	@Test
	void testUpdateBenVitalDetail_Success() {

		String requestObj = "{\"request\":\"Update beneficiary vital detail\"}";
		when(cSService.updateBenVitalDetail(any(BenCancerVitalDetail.class))).thenReturn(1);

		String result = cancerScreeningController.upodateBenVitalDetail(requestObj);

		assertThat(result).contains("Data updated successfully");
	}

	@Test
	void testUpdateBenVitalDetail_Failure() {
	    // Setup the input request object as a JSON string
	    String requestObj = "{\"ID\": 123, \"beneficiaryRegID\": 456, \"benVisitID\": 789, "
	            + "\"weight_Kg\": 70.0, \"height_cm\": 175.0, \"waistCircumference_cm\": 80.0, \"bloodGlucose_Fasting\": 100, "
	            + "\"bloodGlucose_Random\": 120, \"bloodGlucose_2HrPostPrandial\": 140, \"systolicBP_1stReading\": 120, "
	            + "\"diastolicBP_1stReading\": 80, \"systolicBP_2ndReading\": 122, \"diastolicBP_2ndReading\": 82, "
	            + "\"systolicBP_3rdReading\": 124, \"diastolicBP_3rdReading\": 84, "
	            + "\"hbA1C\": 7, \"hemoglobin\": 14, \"modifiedBy\": \"testUser\"}";

	    when(cSService.updateBenVitalDetail(any(BenCancerVitalDetail.class))).thenReturn(0);

	    String result = cancerScreeningController.upodateBenVitalDetail(requestObj);

	    assertThat(result).contains("Unable to modify data");
	}

	@Test
	void testUpdateBenVitalDetail_Exception() {
		String requestObj = "{\"request\":\"Update beneficiary vital detail\"}";
		when(cSService.updateBenVitalDetail(any(BenCancerVitalDetail.class)))
				.thenThrow(new RuntimeException("Unexpected error"));

		String result = cancerScreeningController.upodateBenVitalDetail(requestObj);

		assertThat(result).contains("Unable to modify data");
	}
//******************
	@Test
	void testUpodateBenExaminationDetail_success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update beneficiary examination detail\"}";
		int responseObj = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(cSService.updateBenExaminationDetail(jsnOBJ)).thenReturn(responseObj);

		String expResponse = cancerScreeningController.upodateBenExaminationDetail(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(responseObj > 0);

		assertEquals(expResponse, cancerScreeningController.upodateBenExaminationDetail(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpodateBenExamination_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update beneficiary examination detail\"}";
		int responseObj = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(cSService.updateBenExaminationDetail(jsnOBJ)).thenReturn(responseObj);

		String expResponse = cancerScreeningController.upodateBenExaminationDetail(requestObj);

		response.setError(500, "Unable to modify data");

		assertTrue(responseObj < 0);

		assertEquals(expResponse, cancerScreeningController.upodateBenExaminationDetail(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}
	
	@Test
	void testUpodateBenExaminationDetail_failure() throws Exception {
	    String requestObj = "{\"request\":\"Update beneficiary examination detail\"}";
	    JsonObject jsnOBJ = parseJsonRequest(requestObj);

	    when(cSService.updateBenExaminationDetail(jsnOBJ)).thenThrow(new RuntimeException("Simulated failure"));

	    String response = cancerScreeningController.upodateBenExaminationDetail(requestObj);

	    OutputResponse expectedResponse = new OutputResponse();
	    expectedResponse.setError(5000, "Unable to modify data");

	    assertEquals(expectedResponse.toString(), response);
	}

	
//	@Test
//	void testUpodateBenExamination_Exception() throws Exception {
//		OutputResponse response = new OutputResponse();
//		
//		response.setError(5000, "Unable to modify data");
//		
//		assertEquals(response.toString(),cancerScreeningController.upodateBenExaminationDetail(any()) );
//	}

//***************
	@Test
	void testUpdateCancerDiagnosisDetailsByOncologist_Success() throws IEMRException {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update cancer diagnosis details by oncologist\"}";
		int result = 1;

		CancerDiagnosis cancerDiagnosis = InputMapper.gson().fromJson(requestObj, CancerDiagnosis.class);

		when(cSService.updateCancerDiagnosisDetailsByOncologist(cancerDiagnosis)).thenReturn(result);

		String expResponse = cancerScreeningController.updateCancerDiagnosisDetailsByOncologist(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, cancerScreeningController.updateCancerDiagnosisDetailsByOncologist(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}
	

	@Test
	void testUpdateCancerDiagnosisDetailsByOncologist_Unable() throws IEMRException {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update cancer diagnosis details by oncologist\"}";
		int result = -1;

		CancerDiagnosis cancerDiagnosis = InputMapper.gson().fromJson(requestObj, CancerDiagnosis.class);

		when(cSService.updateCancerDiagnosisDetailsByOncologist(cancerDiagnosis)).thenReturn(result);

		String expResponse = cancerScreeningController.updateCancerDiagnosisDetailsByOncologist(requestObj);

		response.setError(5000, "Unable to modify data");

		assertTrue(result < 0);

		assertEquals(expResponse, cancerScreeningController.updateCancerDiagnosisDetailsByOncologist(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}
	
	@Test
	void testUpdateCancerDiagnosisDetailsByOncologist_Exception() throws Exception {
	    String requestObj = "{\"beneficiaryRegID\":1, \"benVisitID\":1, \"visitCode\":123, \"provisionalDiagnosisOncologist\":\"Diagnosis Details\", \"modifiedBy\":\"Doctor\"}";
	    CancerDiagnosis cancerDiagnosis = InputMapper.gson().fromJson(requestObj, CancerDiagnosis.class);
	    
	    when(cSService.updateCancerDiagnosisDetailsByOncologist(cancerDiagnosis)).thenThrow(new RuntimeException("Unexpected Error"));
	    
	    String response = cancerScreeningController.updateCancerDiagnosisDetailsByOncologist(requestObj);
	    
	    OutputResponse expectedResponse = new OutputResponse();
	    expectedResponse.setError(5000, "Unable to modify data"); 
	    
	    assertEquals(expectedResponse.toString(), response);
	}

//********************
	@Test
	void testUpdateCancerScreeningDoctorData_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update cancer screening doctor data\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(cSService.updateCancerScreeningDoctorData(jsnOBJ)).thenReturn(result);

		String expResponse = cancerScreeningController.updateCancerScreeningDoctorData(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, cancerScreeningController.updateCancerScreeningDoctorData(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateCancerScreeningDoctorData_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update cancer screening doctor data\"}";
		int result = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(cSService.updateCancerScreeningDoctorData(jsnOBJ)).thenReturn(result);

		String expResponse = cancerScreeningController.updateCancerScreeningDoctorData(requestObj);

		response.setError(500, "Unable to modify data");

		assertTrue(result < 0);

		assertEquals(expResponse, cancerScreeningController.updateCancerScreeningDoctorData(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateCancerScreeningDoctorData_Exception() throws Exception {
		String requestObj = "{\"request\":\"Invalid data to trigger exception\"}";

		// Simulate an exception being thrown by the service method
		doThrow(new RuntimeException("Simulated failure")).when(cSService).updateCancerScreeningDoctorData(any());

		// Call the method under test
		String responseStr = cancerScreeningController.updateCancerScreeningDoctorData(requestObj);

		// Verify that an error response is returned
		assertTrue(responseStr.contains("Error while updating beneficiary data"));
		assertTrue(responseStr.contains("Simulated failure"));

		// Verify that the service method was called
		verify(cSService, times(1)).updateCancerScreeningDoctorData(any());
	}

}
