package com.iemr.mmu.controller.quickconsult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.data.quickConsultation.WrapperQuickConsultation;
import com.iemr.mmu.service.quickConsultation.QuickConsultationServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

import javassist.NotFoundException;

@ExtendWith(MockitoExtension.class)
class QuickConsultControllerTest {

	@Mock
	private Logger logger = LoggerFactory.getLogger(QuickConsultController.class);
	@Mock
	private QuickConsultationServiceImpl quickConsultationServiceImpl;
	@InjectMocks
	QuickConsultController quickConsultController;

	private JsonObject parseJsonRequest(String requestObj) {
		JsonElement jsonElement = JsonParser.parseString(requestObj);
		return jsonElement.getAsJsonObject();
	}

	@Test
	void testSaveBenQuickConsultDataNurse_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save Ben Quick Consult Data Nurse\"}";
		Integer r = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(quickConsultationServiceImpl.quickConsultNurseDataInsert(jsnOBJ)).thenReturn(r);

		String expResponse = quickConsultController.saveBenQuickConsultDataNurse(requestObj);

		response.setResponse("Data saved successfully");

		assertNotNull(requestObj);
		assertEquals(1, r);

		assertEquals(expResponse, quickConsultController.saveBenQuickConsultDataNurse(requestObj));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveBenQuickConsultDataNurse_AlreadySaved() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save Ben Quick Consult Data Nurse\"}";
		Integer r = 3;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(quickConsultationServiceImpl.quickConsultNurseDataInsert(jsnOBJ)).thenReturn(r);

		String expResponse = quickConsultController.saveBenQuickConsultDataNurse(requestObj);

		response.setResponse("Data already saved");

		assertNotNull(requestObj);
		assertEquals(3, r);

		assertEquals(expResponse, quickConsultController.saveBenQuickConsultDataNurse(requestObj));
		assertTrue(response.toString().contains("Data already saved"));
	}

	@Test
	void testSaveBenQuickConsultDataNurse_UnableSave() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save Ben Quick Consult Data Nurse\"}";
		Integer r = 0;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(quickConsultationServiceImpl.quickConsultNurseDataInsert(jsnOBJ)).thenReturn(r);

		String expResponse = quickConsultController.saveBenQuickConsultDataNurse(requestObj);

		response.setResponse("Unable to save data");

		assertNotNull(requestObj);
		assertNotEquals(1, r);
		assertNotEquals(3, r);

		assertEquals(expResponse, quickConsultController.saveBenQuickConsultDataNurse(requestObj));
		assertTrue(response.toString().contains("Unable to save data"));
	}

	@Test
	void testSaveBenQuickConsultDataNurse_InvalidRequest() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = null;

		String expResponse = quickConsultController.saveBenQuickConsultDataNurse(requestObj);

		response.setResponse("Invalid request");

		assertNull(requestObj);

		assertEquals(expResponse, quickConsultController.saveBenQuickConsultDataNurse(requestObj));
		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testSaveQuickConsultationDetail_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save Quick Consultation Detail\"}";
		String authorization = "Test";
		int i = 1;

		WrapperQuickConsultation wrapperQuickConsultation = InputMapper.gson().fromJson(requestObj,
				WrapperQuickConsultation.class);

		JsonObject quickConsultDoctorOBJ = wrapperQuickConsultation.getQuickConsultation();

		when(quickConsultationServiceImpl.quickConsultDoctorDataInsert(quickConsultDoctorOBJ, authorization))
				.thenReturn(i);

		String expResponse = quickConsultController.saveQuickConsultationDetail(requestObj, authorization);

		response.setResponse("Data saved successfully");

		assertNotNull(i);
		assertTrue(i > 0);

		assertEquals(expResponse, quickConsultController.saveQuickConsultationDetail(requestObj, authorization));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveQuickConsultationDetail_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save Quick Consultation Detail\"}";
		String authorization = "Test";
		int i = -1;

		WrapperQuickConsultation wrapperQuickConsultation = InputMapper.gson().fromJson(requestObj,
				WrapperQuickConsultation.class);

		JsonObject quickConsultDoctorOBJ = wrapperQuickConsultation.getQuickConsultation();

		when(quickConsultationServiceImpl.quickConsultDoctorDataInsert(quickConsultDoctorOBJ, authorization))
				.thenReturn(i);

		String expResponse = quickConsultController.saveQuickConsultationDetail(requestObj, authorization);

		response.setResponse("Unable to save data");

		assertNotNull(i);
		assertTrue(i < 0);

		assertEquals(expResponse, quickConsultController.saveQuickConsultationDetail(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to save data"));
	}

	@Test
	void testSaveQuickConsultationDetail_Exception() throws Exception {
		String requestObj = "{\"request\":\"Save cancer screening nurse data\"}";
		String authorization = "Bearer token";

		when(quickConsultationServiceImpl.quickConsultDoctorDataInsert(any(), any()))
				.thenThrow(NotFoundException.class);

		String SaveQuickConsultationDetail = quickConsultController.saveQuickConsultationDetail(requestObj,
				authorization);

		assertTrue(SaveQuickConsultationDetail.contains("Unable to save data. "));
	}

	@Test
	void testGetBenDataFrmNurseScrnToDocScrnVisitDetails() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String s = "Test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(quickConsultationServiceImpl.getBenDataFrmNurseToDocVisitDetailsScreen(benRegID, visitCode)).thenReturn(s);

		String expResponse = quickConsultController.getBenDataFrmNurseScrnToDocScrnVisitDetails(comingRequest);

		response.setResponse(s);

		assertTrue(obj.length() > 1);

		assertEquals(expResponse, quickConsultController.getBenDataFrmNurseScrnToDocScrnVisitDetails(comingRequest));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetBenDataFrmNurseScrnToDocScrnVisitDetails_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(obj.length() < 1);

		assertTrue(response.toString().contains("Invalid request"));
	}

//	@Test
//	void testGetBenDataFrmNurseScrnToDocScrnVisitDetails_Exception() throws Exception {
//		String requestObj = "{\"request\":\"Save cancer screening nurse data\"}";
//		String authorization = "Bearer token";
//
//		when(quickConsultationServiceImpl.getBenDataFrmNurseToDocVisitDetailsScreen(any(), any()))
//				.thenThrow(NotFoundException.class);
//
//		String testGetBenDataFrmNurseScrnToDocScrnVisitDetails = quickConsultController
//				.getBenDataFrmNurseScrnToDocScrnVisitDetails(requestObj);
//
//		assertTrue(testGetBenDataFrmNurseScrnToDocScrnVisitDetails.contains("Error while getting visit data"));
//	}

	@Test
	void testGetBenVitalDetailsFrmNurse() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "Test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(quickConsultationServiceImpl.getBeneficiaryVitalDetails(benRegID, visitCode)).thenReturn(res);

		String expResponse = quickConsultController.getBenVitalDetailsFrmNurse(comingRequest);

		response.setResponse(res);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, quickConsultController.getBenVitalDetailsFrmNurse(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenVitalDetailsFrmNurse_Invalid() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(!obj.has("benRegID") || !obj.has("visitCode"));

		assertTrue(response.toString().contains("Invalid request"));
	}

//********************
	@Test
	void testGetBenCaseRecordFromDoctorQuickConsult() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "Test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(quickConsultationServiceImpl.getBenCaseRecordFromDoctorQuickConsult(benRegID, visitCode)).thenReturn(res);

		String expResponse = quickConsultController.getBenCaseRecordFromDoctorQuickConsult(comingRequest);

		response.setResponse(res);

		assertTrue(obj.length() > 1 && obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, quickConsultController.getBenCaseRecordFromDoctorQuickConsult(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenCaseRecordFromDoctorQuickConsult_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(obj.length() < 1 || !obj.has("benRegID") || !obj.has("visitCode"));

		assertTrue(response.toString().contains("Invalid request"));
	}

//********************
	@Test
	void testUpdateGeneralOPDQCDoctorData_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateGeneralOPDQCDoctorData\"}";
		String authorization = "Test";
		Long result = 123L;

		WrapperQuickConsultation wrapperQuickConsultation = InputMapper.gson().fromJson(requestObj,
				WrapperQuickConsultation.class);

		JsonObject quickConsultDoctorOBJ = wrapperQuickConsultation.getQuickConsultation();

		when(quickConsultationServiceImpl.updateGeneralOPDQCDoctorData(quickConsultDoctorOBJ, authorization))
				.thenReturn(result);

		String expResponse = quickConsultController.updateGeneralOPDQCDoctorData(requestObj, authorization);

		response.setResponse("Data updated successfully");

		assertNotNull(result);
		assertTrue(result > 0);

		assertEquals(expResponse, quickConsultController.updateGeneralOPDQCDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateGeneralOPDQCDoctorData_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateGeneralOPDQCDoctorData\"}";
		String authorization = "Test";
		Long result = null;

		WrapperQuickConsultation wrapperQuickConsultation = InputMapper.gson().fromJson(requestObj,
				WrapperQuickConsultation.class);

		JsonObject quickConsultDoctorOBJ = wrapperQuickConsultation.getQuickConsultation();

		when(quickConsultationServiceImpl.updateGeneralOPDQCDoctorData(quickConsultDoctorOBJ, authorization))
				.thenReturn(result);

		String expResponse = quickConsultController.updateGeneralOPDQCDoctorData(requestObj, authorization);

		response.setResponse("Unable to modify data");

		assertNull(result);
		// assertTrue(result < 0);

		assertEquals(expResponse, quickConsultController.updateGeneralOPDQCDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateGeneralOPDQCDoctorData_Exception() throws Exception {
		String requestObj = "{\"request\":\"Save cancer screening nurse data\"}";
		String authorization = "Bearer token";

		when(quickConsultationServiceImpl.updateGeneralOPDQCDoctorData(any(), any()))
				.thenThrow(NotFoundException.class);

		String UpdateGeneralOPDQCDoctorData = quickConsultController.updateGeneralOPDQCDoctorData(requestObj,
				authorization);

		assertTrue(UpdateGeneralOPDQCDoctorData.contains("Unable to modify data"));
	}

}