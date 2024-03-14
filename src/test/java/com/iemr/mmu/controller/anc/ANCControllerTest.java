package com.iemr.mmu.controller.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.io.StringReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.iemr.mmu.service.anc.ANCService;
import com.iemr.mmu.utils.response.OutputResponse;

import javassist.NotFoundException;

@ExtendWith(MockitoExtension.class)
class ANCControllerTest {

	@InjectMocks
	private ANCController ancController;

	@Mock
	private ANCService ancService;

	@Mock
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

//	private JsonObject parseJsonRequest(String requestObj) {
//		JsonElement jsonElement = JsonParser.parseString(requestObj);
//		return jsonElement.getAsJsonObject();
//	}

	private JsonObject parseJsonRequest(String requestObj) {
		JsonObject jsnObj = null;
		try {
			JsonElement jsonElement = JsonParser.parseString(requestObj);
			jsnObj = jsonElement.getAsJsonObject();
		} catch (JsonSyntaxException e) {
			// Handle the exception if needed
			e.printStackTrace();
		}
		return jsnObj;
	}

	@Test
	void testSaveBenANCNurseData_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save ANC nurse data\"}";
		Long ancRes = 123L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.saveANCNurseData(jsnOBJ)).thenReturn(ancRes);

		String expResponse = ancController.saveBenANCNurseData(requestObj);

		response.setResponse("Data saved successfully");

		assertNotNull(jsnOBJ);
		assertNotNull(ancRes);
		assertEquals(expResponse, ancController.saveBenANCNurseData(requestObj));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveBenANCNurseData_AlreadySaved() throws Exception {
		String requestObj = "{\"request\":\"Check already saved data\"}";
		Long ancRes = 0L; // Indicating already saved

		JsonObject jsnOBJ = parseJsonRequest(requestObj);
		when(ancService.saveANCNurseData(jsnOBJ)).thenReturn(ancRes);

		String actResponse = ancController.saveBenANCNurseData(requestObj);

		OutputResponse response = new OutputResponse();
		response.setResponse("Data already saved");

		assertEquals(response.toString(), actResponse);
		assertTrue(actResponse.contains("Data already saved"));
	}

	@Test
	void testSaveBenANCNurseData_UnableToSaveData() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Some data that causes failure\"}";
		Long ancRes = -1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.saveANCNurseData(jsnOBJ)).thenReturn(ancRes);

		String actResponse = ancController.saveBenANCNurseData(requestObj);

		response.setError(5000, "Unable to save data");

		assertNotNull(jsnOBJ);
		assertNotNull(ancRes);
		assertEquals(response.toString(), actResponse);
		assertTrue(actResponse.contains("Unable to save data"));
	}

	@Test
	void testSaveBenANCNurseData_InvalidRequest() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "Invalid request";

		//when(ancService.saveANCNurseData(any(JsonObject.class))).thenReturn(null);

		String expResponse = ancController.saveBenANCNurseData(requestObj);

		response.setError(5000, "Invalid request");

		assertNull(parseJsonRequest(requestObj));
		//assertNull(ancService.saveANCNurseData(any(JsonObject.class)));
		assertEquals(expResponse, ancController.saveBenANCNurseData(requestObj));
		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testSaveBenANCNurseData_Exception() throws Exception {
		String requestObj = "{\"request\":\"Save ANC nurse data\"}";

		when(ancService.saveANCNurseData(any())).thenThrow(NotFoundException.class);

		String SaveBenANCNurseData = ancController.saveBenANCNurseData(requestObj);

		assertTrue(SaveBenANCNurseData.contains("Unable to save data"));
	}

	@Test
	void testSaveBenANCDoctorData_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save ANC doctor data\"}";
		String authorization = "Test";
		Long r = 123L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.saveANCDoctorData(jsnOBJ, authorization)).thenReturn(r);

		String expResponse = ancController.saveBenANCDoctorData(requestObj, authorization);

		response.setResponse("Data saved successfully");

		assertNotNull(jsnOBJ);
		assertNotEquals(0, r);

		assertEquals(expResponse, ancController.saveBenANCDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveBenANCDoctorData_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Attempt to save ANC doctor data\"}";
		String authorization = "TestAuth";
		Long r = 0L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.saveANCDoctorData(jsnOBJ, authorization)).thenReturn(r);

		String actualResponse = ancController.saveBenANCDoctorData(requestObj, authorization);

		response.setError(5000, "Unable to save data");

		assertNotNull(jsnOBJ);
		assertEquals(0, r.longValue());

		assertTrue(actualResponse.contains("Unable to save data"));
	}

	@Test
	void testSaveBenANCDoctorData_InvalidRequest() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{}";
		String authorization = "TestAuth";

		String actualResponse = ancController.saveBenANCDoctorData(requestObj, authorization);

		response.setError(5000, "Invalid request");

		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testSaveBenANCDoctorData_Exception() throws Exception {
		String requestObj = "{\"request\":\"Save ANC doctor data\"}";
		String authorization = "Test";

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.saveANCDoctorData(jsnOBJ, authorization))
				.thenThrow(new RuntimeException("Unable to save data. Test exception"));

		OutputResponse expectedResponse = new OutputResponse();
		expectedResponse.setError(5000, "Unable to save data. Test exception");

		String actualResponse = ancController.saveBenANCDoctorData(requestObj, authorization);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Unable to save data. Test exception"));
	}

	@Test
	void testGetBenVisitDetailsFrmNurseANC_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\", \"visitCode\":\"1\"}";
		String res = "Test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ancService.getBenVisitDetailsFrmNurseANC(benRegID, visitCode)).thenReturn(res);

		String expResponse = ancController.getBenVisitDetailsFrmNurseANC(comingRequest);

		response.setResponse(res);

		assertTrue(obj.length() > 1);

		assertEquals(expResponse, ancController.getBenVisitDetailsFrmNurseANC(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenVisitDetailsFrmNurseANC_InvalidRequest() throws Exception {
		OutputResponse expectedResponse = new OutputResponse();
		expectedResponse.setError(5000, "Invalid request");

		String invalidRequest = "{}";

		String actualResponse = ancController.getBenVisitDetailsFrmNurseANC(invalidRequest);

		assertTrue(actualResponse.contains("Invalid request"));
	}

	@Test
	void testGetBenVisitDetailsFrmNurseANC_Exception() throws Exception {
		OutputResponse expectedResponse = new OutputResponse();
		expectedResponse.setError(5000, "Error while getting beneficiary visit data");

		String request = "{\"benRegID\":\"1\", \"visitCode\":\"1\"}";

		when(ancService.getBenVisitDetailsFrmNurseANC(anyLong(), anyLong()))
				.thenThrow(new RuntimeException("Error while getting beneficiary visit data"));

		String actualResponse = ancController.getBenVisitDetailsFrmNurseANC(request);

		assertTrue(actualResponse.contains("Error while getting beneficiary visit data"));
	}

	@Test
	void testGetBenANCDetailsFrmNurseANC_Success() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\", \"visitCode\":\"2\"}";
		String res = "Test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ancService.getBenANCDetailsFrmNurseANC(benRegID, visitCode)).thenReturn(res);

		String expResponse = ancController.getBenANCDetailsFrmNurseANC(comingRequest);

		response.setResponse(res);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, ancController.getBenANCDetailsFrmNurseANC(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenANCDetailsFrmNurseANC_InvalidRequest() {
		String invalidRequest = "{}";

		String response = ancController.getBenANCDetailsFrmNurseANC(invalidRequest);

		assertTrue(response.contains("Invalid request"));
	}

	@Test
	void testGetBenANCDetailsFrmNurseANC_Exception() throws JSONException {
		String comingRequest = "{\"benRegID\":\"1\", \"visitCode\":\"2\"}";
		JSONObject obj = new JSONObject(comingRequest);
		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ancService.getBenANCDetailsFrmNurseANC(benRegID, visitCode))
				.thenThrow(new RuntimeException("Error while getting beneficiary ANC care data"));

		String responseStr = ancController.getBenANCDetailsFrmNurseANC(comingRequest);

		OutputResponse response = new Gson().fromJson(responseStr, OutputResponse.class);

		assertNotNull(response);
		assertTrue(responseStr.contains("Error while getting beneficiary ANC care data"));
	}

	@Test
	void testGetBenANCHistoryDetails_Success() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\", \"visitCode\":\"1\"}";
		String s = "Test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ancService.getBenANCHistoryDetails(benRegID, visitCode)).thenReturn(s);
		response.setResponse(s);

		String expResponse = ancController.getBenANCHistoryDetails(comingRequest);

		response.setResponse(s);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, ancController.getBenANCHistoryDetails(comingRequest));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetBenANCHistoryDetails_InvalidRequest() throws JSONException {

		String invalidRequest = "{}";

		OutputResponse expectedResponse = new OutputResponse();
		expectedResponse.setError(5000, "Invalid request");

		String actualResponse = ancController.getBenANCHistoryDetails(invalidRequest);

		assertTrue(actualResponse.contains("Invalid request"));

		assertTrue(actualResponse.contains("Invalid request"));
	}

	@Test
	void testGetBenANCHistoryDetails_CatchBlock() throws JSONException {

		String comingRequest = "{\"benRegID\":\"1\", \"visitCode\":\"1\"}";
		OutputResponse expectedResponse = new OutputResponse();
		expectedResponse.setError(5000, "Error while getting beneficiary history data");

		when(ancService.getBenANCHistoryDetails(1L, 1L)).thenThrow(new RuntimeException("Test exception"));

		String actualResponse = ancController.getBenANCHistoryDetails(comingRequest);

		assertTrue(actualResponse.contains("Error while getting beneficiary history data"));
	}

	@Test
	void testGetBenANCVitalDetailsFrmNurseANC_Success() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "Test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ancService.getBeneficiaryVitalDetails(benRegID, visitCode)).thenReturn(res);

		String expResponse = ancController.getBenANCVitalDetailsFrmNurseANC(comingRequest);

		response.setResponse(res);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, ancController.getBenANCVitalDetailsFrmNurseANC(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenANCVitalDetailsFrmNurseANC_InvalidRequest() {

		String comingRequest = "{\"benRegID\":\"1\"}";

		String response = ancController.getBenANCVitalDetailsFrmNurseANC(comingRequest);

		assertTrue(response.contains("Invalid request"));
	}

	@Test
	void testGetBenANCVitalDetailsFrmNurseANC_Exception() {
		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";

		when(ancService.getBeneficiaryVitalDetails(anyLong(), anyLong()))
				.thenThrow(new RuntimeException("Error while getting beneficiary vital data"));

		String result = ancController.getBenANCVitalDetailsFrmNurseANC(comingRequest);

		assertTrue(result.contains("Error while getting beneficiary vital data"));
	}

	@Test
	void testGetBenExaminationDetailsANC_Success() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String s = "Test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ancService.getANCExaminationDetailsData(benRegID, visitCode)).thenReturn(s);

		String expResponse = ancController.getBenExaminationDetailsANC(comingRequest);

		response.setResponse(s);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, ancController.getBenExaminationDetailsANC(comingRequest));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetBenExaminationDetailsANC_InvalidRequest() {
		OutputResponse expectedResponse = new OutputResponse();
		expectedResponse.setError(5000, "Invalid request");

		String invalidRequest = "{\"benRegID\":\"1\"}";

		String actualResponse = ancController.getBenExaminationDetailsANC(invalidRequest);

		String expectedResponseString = expectedResponse.toString();

		assertTrue(actualResponse.contains("Invalid request"));
		assertTrue(actualResponse.contains("5000"));
	}

	@Test
	void testGetBenExaminationDetailsANC_Exception() throws Exception {
		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";

		when(ancService.getANCExaminationDetailsData(anyLong(), anyLong()))
				.thenThrow(new RuntimeException("Error while getting beneficiary examination data"));

		String response = ancController.getBenExaminationDetailsANC(comingRequest);

		assertTrue(response.contains("Error while getting beneficiary examination data"));
		assertTrue(response.contains("5000"));
	}

	@Test
	void testGetBenCaseRecordFromDoctorANC_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"2\"}";
		String res = "Test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ancService.getBenCaseRecordFromDoctorANC(benRegID, visitCode)).thenReturn(res);

		String expResponse = ancController.getBenCaseRecordFromDoctorANC(comingRequest);

		response.setResponse(res);

		assertTrue(obj.length() > 1 && obj.has("benRegID") && obj.has("visitCode"));
		assertEquals(expResponse, ancController.getBenCaseRecordFromDoctorANC(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenCaseRecordFromDoctorANC_InvalidRequest() throws Exception {
		String comingRequest = "{\"benRegID\":\"1\"}";
		String expectedError = "Invalid request";

		OutputResponse expectedResponse = new OutputResponse();
		expectedResponse.setError(5000, expectedError);

		String actualResponse = ancController.getBenCaseRecordFromDoctorANC(comingRequest);

		assertTrue(actualResponse.contains(expectedError));
		assertEquals(expectedResponse.toString(), actualResponse);
	}

	@Test
	void testGetBenCaseRecordFromDoctorANC_Exception() throws Exception {
		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"2\"}";
		String expectedError = "Error while getting beneficiary doctor data";

		when(ancService.getBenCaseRecordFromDoctorANC(anyLong(), anyLong()))
				.thenThrow(new RuntimeException("Error while getting beneficiary doctor data"));

		OutputResponse expectedResponse = new OutputResponse();
		expectedResponse.setError(5000, expectedError);

		String actualResponse = ancController.getBenCaseRecordFromDoctorANC(comingRequest);

		assertTrue(actualResponse.contains(expectedError));
		assertEquals(expectedResponse.toString(), actualResponse);
	}

	@Test
	void testGetHRPStatus_success() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "Test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ancService.getHRPStatus(benRegID, visitCode)).thenReturn(res);

		String expResponse = ancController.getHRPStatus(comingRequest);

		response.setResponse(res);

		assertTrue(obj.length() > 1 && obj.has("benRegID") && obj.has("visitCode"));
		assertNotNull(res);

		assertEquals(expResponse, ancController.getHRPStatus(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetHRPStatus_Error() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = null;

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ancService.getHRPStatus(benRegID, visitCode)).thenReturn(res);

		String expResponse = ancController.getHRPStatus(comingRequest);

		response.setError(5000, "error in getting HRP status");

		assertTrue(obj.length() > 1 && obj.has("benRegID") && obj.has("visitCode"));
		assertNull(res);

		assertEquals(expResponse, ancController.getHRPStatus(comingRequest));
		assertTrue(response.toString().contains("error in getting HRP status"));
	}

	@Test
	void testGetHRPStatus_InvalidRequest() throws Exception {

		String comingRequest = "{\"benRegID\":\"1\"}";

		OutputResponse expectedResponse = new OutputResponse();
		expectedResponse.setError(5000, "Invalid request");

		String actualResponse = ancController.getHRPStatus(comingRequest);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Invalid request"));

		assertTrue(actualResponse.contains(expectedResponse.getErrorMessage()));
	}

	@Test
	void testGetHRPStatus_CatchBlock() throws Exception {
		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";

		when(ancService.getHRPStatus(anyLong(), anyLong()))
				.thenThrow(new RuntimeException("error in getting HRP status"));

		OutputResponse expectedResponse = new OutputResponse();
		expectedResponse.setError(5000, "error in getting HRP status");

		String actualResponse = ancController.getHRPStatus(comingRequest);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("error in getting HRP status"));

		assertTrue(actualResponse.contains(expectedResponse.getErrorMessage()));
	}

	@Test
	void testUpdateANCCareNurse_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update ANC care data in doctor screen\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.updateBenANCDetails(jsnOBJ)).thenReturn(result);

		String expResponse = ancController.updateANCCareNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, ancController.updateANCCareNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateANCCareNurse_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update ANC care data in doctor screen\"}";
		int result = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.updateBenANCDetails(jsnOBJ)).thenReturn(result);

		String expResponse = ancController.updateANCCareNurse(requestObj);

		response.setError(500, "Unable to modify data");

		assertTrue(result < 0);

		assertEquals(expResponse, ancController.updateANCCareNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateANCCareNurse_Exception() throws Exception {
		String requestObj = "{\"request\":\"Simulate failure\"}";
		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.updateBenANCDetails(jsnOBJ)).thenThrow(new RuntimeException("Unable to modify data"));

		String expResponse = ancController.updateANCCareNurse(requestObj);

		assertTrue(expResponse.contains("Unable to modify data"));

		assertTrue(expResponse.contains("5000"));
	}

	@Test
	void testUpdateANCHistoryNurse_Success() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"Update ANC history data in doctor screen\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.updateBenANCHistoryDetails(jsnOBJ)).thenReturn(result);

		String expResponse = ancController.updateANCHistoryNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, ancController.updateANCHistoryNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateANCHistoryNurse_Exception() throws Exception {
		String requestObj = "{\"request\":\"Update ANC history data in doctor screen\"}";
		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.updateBenANCHistoryDetails(jsnOBJ)).thenThrow(new RuntimeException("Unable to modify data"));

		String expResponse = ancController.updateANCHistoryNurse(requestObj);

		OutputResponse expectedErrorResponse = new OutputResponse();
		expectedErrorResponse.setError(5000, "Unable to modify data");
		String expectedErrorResponseStr = expectedErrorResponse.toString();

		assertEquals(expectedErrorResponseStr, expResponse);
	}

	@Test
	void testUpdateANCHistoryNurse_Unable() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"Update ANC history data in doctor screen\"}";
		int result = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.updateBenANCHistoryDetails(jsnOBJ)).thenReturn(result);

		String expResponse = ancController.updateANCHistoryNurse(requestObj);

		response.setError(500, "Unable to modify data");

		assertTrue(result < 0);

		assertEquals(expResponse, ancController.updateANCHistoryNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateANCVitalNurse_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update ANC vital data in doctor screen\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.updateBenANCVitalDetails(jsnOBJ)).thenReturn(result);

		String expResponse = ancController.updateANCVitalNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, ancController.updateANCVitalNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateANCVitalNurse_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update ANC vital data in doctor screen\"}";
		int result = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.updateBenANCVitalDetails(jsnOBJ)).thenReturn(result);

		String expResponse = ancController.updateANCVitalNurse(requestObj);

		response.setError(500, "Unable to modify data");

		assertFalse(result > 0);

		assertEquals(expResponse, ancController.updateANCVitalNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateANCVitalNurse_Exception() throws Exception {
		OutputResponse expectedResponse = new OutputResponse();
		expectedResponse.setError(5000, "Unable to modify data");

		String requestObj = "{\"request\":\"Update failure due to exception\"}";

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.updateBenANCVitalDetails(jsnOBJ)).thenThrow(new RuntimeException("Unable to modify data"));

		String actualResponse = ancController.updateANCVitalNurse(requestObj);

		assertTrue(actualResponse.contains("Unable to modify data"));
		assertTrue(actualResponse.contains("5000"));
	}

	@Test
	void testUpdateANCExaminationNurse_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update ANC examination data in doctor screen\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.updateBenANCExaminationDetails(jsnOBJ)).thenReturn(result);

		String expResponse = ancController.updateANCExaminationNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, ancController.updateANCExaminationNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateANCExaminationNurse_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update ANC examination data in doctor screen\"}";
		int result = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.updateBenANCExaminationDetails(jsnOBJ)).thenReturn(result);

		String expResponse = ancController.updateANCExaminationNurse(requestObj);

		response.setError(500, "Unable to modify data");

		assertTrue(result < 0);

		assertEquals(expResponse, ancController.updateANCExaminationNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateANCExaminationNurse_Exception() throws Exception {
		String requestObj = "{\"request\":\"Trigger exception\"}";
		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		doThrow(new RuntimeException("Unable to modify data")).when(ancService).updateBenANCExaminationDetails(jsnOBJ);

		String expResponse = ancController.updateANCExaminationNurse(requestObj);

		assertTrue(expResponse.contains("Unable to modify data"));
		assertTrue(expResponse.contains("5000"));

	}

	@Test
	void testUpdateANCDoctorData_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update ANC doctor data\"}";
		String authorization = "Test";
		Long result = 1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.updateANCDoctorData(jsnOBJ, authorization)).thenReturn(result);

		String expResponse = ancController.updateANCDoctorData(requestObj, authorization);

		response.setResponse("Data updated successfully");

		assertTrue(null != result && result > 0);

		assertEquals(expResponse, ancController.updateANCDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateANCDoctorData_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update ANC doctor data\"}";
		String authorization = "Test";
		Long result = -1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ancService.updateANCDoctorData(jsnOBJ, authorization)).thenReturn(result);

		String expResponse = ancController.updateANCDoctorData(requestObj, authorization);

		response.setError(500, "Unable to modify data");

		assertTrue(null != result && result < 0);

		assertEquals(expResponse, ancController.updateANCDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateANCDoctorData_Exception() throws Exception {
		String requestObj = "{\"request\":\"Update ANC doctor data\"}";
		String authorization = "Test";
		Exception mockException = new Exception("Unable to modify data. ");

		when(ancService.updateANCDoctorData(any(JsonObject.class), eq(authorization))).thenThrow(mockException);

		String response = ancController.updateANCDoctorData(requestObj, authorization);

		assertTrue(response.contains("Unable to modify data. "));
	}

}
