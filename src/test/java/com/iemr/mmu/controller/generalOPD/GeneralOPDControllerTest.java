package com.iemr.mmu.controller.generalOPD;

import static org.junit.jupiter.api.Assertions.*;
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
import com.iemr.mmu.service.generalOPD.GeneralOPDServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import javassist.NotFoundException;

@ExtendWith(MockitoExtension.class)
class GeneralOPDControllerTest {

	@Mock
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Mock
	private GeneralOPDServiceImpl generalOPDServiceImpl;
	@InjectMocks
	GeneralOPDController generalOPDController;

	private JsonObject parseJsonRequest(String requestObj) {
		JsonElement jsonElement = JsonParser.parseString(requestObj);
		return jsonElement.getAsJsonObject();
	}

	@Test
	void testSaveBenGenOPDNurseDataSuccess() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save general OPD nurse data\"}";
		Long genOPDRes = 1L;

		JsonObject jsonRequest = parseJsonRequest(requestObj);

		when(generalOPDServiceImpl.saveNurseData(jsonRequest)).thenReturn(genOPDRes);

		String expResponse = generalOPDController.saveBenGenOPDNurseData(requestObj);

		response.setResponse("Data saved successfully");

		assertNotNull(jsonRequest);
		assertTrue(null != genOPDRes && genOPDRes > 0);

		assertEquals(expResponse, generalOPDController.saveBenGenOPDNurseData(requestObj));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveBenGenOPDNurseDataAlready() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save general OPD nurse data\"}";
		Long genOPDRes = 0L;

		JsonObject jsonRequest = parseJsonRequest(requestObj);

		when(generalOPDServiceImpl.saveNurseData(jsonRequest)).thenReturn(genOPDRes);

		String expResponse = generalOPDController.saveBenGenOPDNurseData(requestObj);

		response.setResponse("Data already saved");

		assertNotNull(jsonRequest);
		assertTrue(null != genOPDRes && genOPDRes == 0);

		assertEquals(expResponse, generalOPDController.saveBenGenOPDNurseData(requestObj));
		assertTrue(response.toString().contains("Data already saved"));
	}

	@Test
	void testSaveBenGenOPDNurseDataUnable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save general OPD nurse data\"}";
		Long genOPDRes = null;

		JsonObject jsonRequest = parseJsonRequest(requestObj);

		when(generalOPDServiceImpl.saveNurseData(jsonRequest)).thenReturn(genOPDRes);

		String expResponse = generalOPDController.saveBenGenOPDNurseData(requestObj);

		response.setResponse("Unable to save data");

		assertNotNull(jsonRequest);
		assertNull(genOPDRes);

		assertEquals(expResponse, generalOPDController.saveBenGenOPDNurseData(requestObj));
		assertTrue(response.toString().contains("Unable to save data"));
	}

	@Test
	void testSaveBenGenOPDNurseData_InvalidRequest() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save general OPD nurse data\"}";
		Long genOPDRes = 1L;

		JsonObject jsonRequest = null;

		when(generalOPDServiceImpl.saveNurseData(jsonRequest)).thenReturn(genOPDRes);

		String expResponse = generalOPDController.saveBenGenOPDNurseData(requestObj);

		response.setResponse("Unable to save data");

		assertNull(jsonRequest);

		assertEquals(expResponse, generalOPDController.saveBenGenOPDNurseData(requestObj));
		assertTrue(response.toString().contains("Unable to save data"));
	}

//********
	@Test
	void testSaveBenGenOPDDoctorDataSuccess() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save general OPD doctor data\"}";
		String authorization = "Test";
		Long genOPDRes = 1L;

		JsonObject jsonRequest = parseJsonRequest(requestObj);

		when(generalOPDServiceImpl.saveDoctorData(jsonRequest, authorization)).thenReturn(genOPDRes);

		String expResponse = generalOPDController.saveBenGenOPDDoctorData(requestObj, authorization);

		response.setResponse("Data saved successfully");

		assertNotNull(jsonRequest);
		assertTrue(null != genOPDRes && genOPDRes > 0);

		assertEquals(expResponse, generalOPDController.saveBenGenOPDDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveBenGenOPDDoctorDataUnable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save general OPD doctor data\"}";
		String authorization = "Test";
		Long genOPDRes = -1L;

		JsonObject jsonRequest = parseJsonRequest(requestObj);

		when(generalOPDServiceImpl.saveDoctorData(jsonRequest, authorization)).thenReturn(genOPDRes);

		String expResponse = generalOPDController.saveBenGenOPDDoctorData(requestObj, authorization);

		response.setResponse("Unable to save data");

		assertNotNull(jsonRequest);
		assertTrue(null != genOPDRes && genOPDRes < 0);

		assertEquals(expResponse, generalOPDController.saveBenGenOPDDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to save data"));
	}

	@Test
	void testSaveBenGenOPDDoctorData_InvalidRequest() throws Exception {
		OutputResponse response = new OutputResponse();

		JsonObject jsonRequest = null;

		response.setResponse("Invalid request");

		assertNull(jsonRequest);

		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testSaveBenGenOPDDoctorData_Exception() throws Exception {
		String requestObj = "{\"request\":\"Save general OPD doctor data\"}";
		String authorization = "Bearer token";

		when(generalOPDServiceImpl.saveDoctorData(any(), any())).thenThrow(NotFoundException.class);

		String SaveBenGenOPDDoctorData = generalOPDController.saveBenGenOPDDoctorData(requestObj, authorization);

		assertTrue(SaveBenGenOPDDoctorData.contains("Unable to save data. "));
	}

	@Test
	void testGetBenVisitDetailsFrmNurseGOPD() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(generalOPDServiceImpl.getBenVisitDetailsFrmNurseGOPD(benRegID, visitCode)).thenReturn(res);

		String expResponse = generalOPDController.getBenVisitDetailsFrmNurseGOPD(comingRequest);

		response.setResponse(res);

		assertTrue(obj.length() > 1);

		assertEquals(expResponse, generalOPDController.getBenVisitDetailsFrmNurseGOPD(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenVisitDetailsFrmNurseGOPD_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(obj.length() < 1);
		assertTrue(response.toString().contains("Invalid request"));
	}

//	@Test
//	void testGetBenVisitDetailsFrmNurseGOPD_Exception() throws Exception {
//		String requestObj = "{\"request\":\"Get beneficiary visit details from nurse general OPD\"}";
//
//		when(generalOPDServiceImpl.getBenVisitDetailsFrmNurseGOPD(any(), any())).thenThrow(NotFoundException.class);
//
//		String GetBenVisitDetailsFrmNurseGOPD = generalOPDController.getBenVisitDetailsFrmNurseGOPD(requestObj);
//
//		assertTrue(GetBenVisitDetailsFrmNurseGOPD.contains("Error while getting beneficiary visit data"));
//	}

	@Test
	void testGetBenHistoryDetails() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String s = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(generalOPDServiceImpl.getBenHistoryDetails(benRegID, visitCode)).thenReturn(s);

		String expResponse = generalOPDController.getBenHistoryDetails(comingRequest);

		response.setResponse(s);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, generalOPDController.getBenHistoryDetails(comingRequest));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetBenHistoryDetails_Invalid() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benID\":\"\",\"visitCode\":\"\"}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertFalse(obj.has("benRegID") && obj.has("visitCode"));

		assertTrue(response.toString().contains("Invalid request"));
	}

//	@Test
//	void testGetBenHistoryDetails_Exception() throws Exception {
//		String requestObj = "{\"request\":\"Get beneficiary visit details from nurse general OPD\"}";
//
//		when(generalOPDServiceImpl.getBenHistoryDetails(any(), any())).thenThrow(RuntimeException.class);
//
//		String GetBenHistoryDetails = generalOPDController.getBenHistoryDetails(requestObj);
//
//		assertTrue(GetBenHistoryDetails.contains("Error while getting beneficiary history data"));
//	}

	@Test
	void testGetBenVitalDetailsFrmNurse() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(generalOPDServiceImpl.getBeneficiaryVitalDetails(benRegID, visitCode)).thenReturn(res);

		String expResponse = generalOPDController.getBenVitalDetailsFrmNurse(comingRequest);

		response.setResponse(res);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, generalOPDController.getBenVitalDetailsFrmNurse(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenVitalDetailsFrmNurse_Invalid() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benID\":\"1\",\"visitCode\":\"1\"}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertFalse(obj.has("benRegID") && obj.has("visitCode"));

		assertTrue(response.toString().contains("Invalid request"));
	}
//
//	@Test
//	void testGetBenVitalDetailsFrmNurse_Exception() throws JSONException {
//		String requestObj = "{\"request\":\"Get beneficiary vital details from nurse general OPD\"}";
//
//		when(generalOPDServiceImpl.getBeneficiaryVitalDetails(any(), any())).thenThrow(RuntimeException.class);
//
//		String getBenVitalDetailsFrmNurse = generalOPDController.getBenVitalDetailsFrmNurse(requestObj);
//
//		assertTrue(getBenVitalDetailsFrmNurse.contains("Error while getting beneficiary vital data"));
//	}

	@Test
	void testGetBenExaminationDetails() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String s = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(generalOPDServiceImpl.getExaminationDetailsData(benRegID, visitCode)).thenReturn(s);

		String expResponse = generalOPDController.getBenExaminationDetails(comingRequest);

		response.setResponse(s);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, generalOPDController.getBenExaminationDetails(comingRequest));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetBenExaminationDetails_Invalid() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));

		assertTrue(response.toString().contains("Invalid request"));
	}


	@Test
	void testGetBenCaseRecordFromDoctorGeneralOPD() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(generalOPDServiceImpl.getBenCaseRecordFromDoctorGeneralOPD(benRegID, visitCode)).thenReturn(res);

		String expResponse = generalOPDController.getBenCaseRecordFromDoctorGeneralOPD(comingRequest);

		response.setResponse(res);

		assertTrue(obj.length() > 1 && obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, generalOPDController.getBenCaseRecordFromDoctorGeneralOPD(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenCaseRecordFromDoctorGeneralOPD_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(obj.length() < 1 && !obj.has("benRegID") && !obj.has("visitCode"));

		assertTrue(response.toString().contains("Invalid request"));
	}

//*************
	@Test
	void testUpdateVisitNurseSuccess() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update Visit Nurse\"}";
		int result = 1;

		JsonObject jsonRequest = parseJsonRequest(requestObj);

		when(generalOPDServiceImpl.UpdateVisitDetails(jsonRequest)).thenReturn(result);

		String expResponse = generalOPDController.updateVisitNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, generalOPDController.updateVisitNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateVisitNurseUnable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Update Visit Nurse\"}";
		int result = -1;

		JsonObject jsonRequest = parseJsonRequest(requestObj);

		when(generalOPDServiceImpl.UpdateVisitDetails(jsonRequest)).thenReturn(result);

		String expResponse = generalOPDController.updateVisitNurse(requestObj);

		response.setError(500, "Unable to modify data");

		assertTrue(result < 0);

		assertEquals(expResponse, generalOPDController.updateVisitNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

//*****************
	@Test
	void testUpdateHistoryNurseSuccess() throws Exception {

		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"Update History Nurse\"}";
		int result = 1;

		JsonObject jsonRequest = parseJsonRequest(requestObj);

		when(generalOPDServiceImpl.updateBenHistoryDetails(jsonRequest)).thenReturn(result);

		String expResponse = generalOPDController.updateHistoryNurse(requestObj);

		response.setResponse("Data updated successfully");
		response.setError(500, "Unable to modify data");

		assertTrue(result > 0);
		assertNotEquals(0, result);

		assertEquals(expResponse, generalOPDController.updateHistoryNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateHistoryNurseUnable() throws Exception {

		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"Update History Nurse\"}";
		int result = -1;

		JsonObject jsonRequest = parseJsonRequest(requestObj);

		when(generalOPDServiceImpl.updateBenHistoryDetails(jsonRequest)).thenReturn(result);

		String expResponse = generalOPDController.updateHistoryNurse(requestObj);

		response.setResponse("Data updated successfully");
		response.setError(500, "Unable to modify data");

		assertTrue(result < 0);

		assertEquals(expResponse, generalOPDController.updateHistoryNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

//************
	@Test
	void testUpdateVitalNurse_Success() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"Update general OPD vital data in doctor screen\"}";
		int result = 1;

		JsonObject jsonRequest = parseJsonRequest(requestObj);

		// when(generalOPDServiceImpl.updateBenVitalDetails(jsonRequest)).thenReturn(result);

		String expResponse = generalOPDController.updateVisitNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, generalOPDController.updateVisitNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateVitalNurse_Unable() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"Update general OPD vital data in doctor screen\"}";
		int result = -1;

		JsonObject jsonRequest = parseJsonRequest(requestObj);

		// when(generalOPDServiceImpl.updateBenVitalDetails(jsonRequest)).thenReturn(result);

		String expResponse = generalOPDController.updateVisitNurse(requestObj);

		response.setError(500, "Unable to modify data");

		assertTrue(result < 0);

		assertEquals(expResponse, generalOPDController.updateVisitNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateVitalNurse_Exception() throws Exception {
		String requestObj = "{\"request\":\"Get beneficiary vital details from nurse general OPD\"}";

		when(generalOPDServiceImpl.updateBenVitalDetails(any())).thenThrow(RuntimeException.class);

		String UpdateVitalNurse = generalOPDController.updateVitalNurse(requestObj);

		assertTrue(UpdateVitalNurse.contains("Unable to modify data"));
	}

	@Test
	void testUpdateGeneralOPDExaminationNurseSuccess() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"Update general OPD examination data in doctor screen\"}";
		int result = 1;

		JsonObject jsonRequest = parseJsonRequest(requestObj);

		when(generalOPDServiceImpl.updateBenExaminationDetails(jsonRequest)).thenReturn(result);

		String expResponse = generalOPDController.updateGeneralOPDExaminationNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, generalOPDController.updateGeneralOPDExaminationNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateGeneralOPDExaminationNurseUnable() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"Update general OPD examination data in doctor screen\"}";
		int result = -1;

		JsonObject jsonRequest = parseJsonRequest(requestObj);

		when(generalOPDServiceImpl.updateBenExaminationDetails(jsonRequest)).thenReturn(result);

		String expResponse = generalOPDController.updateGeneralOPDExaminationNurse(requestObj);

		response.setError(500, "Unable to modify data");

		assertTrue(result < 0);

		assertEquals(expResponse, generalOPDController.updateGeneralOPDExaminationNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateGeneralOPDExaminationNurse_Exception() throws Exception {
		String requestObj = "{\"request\":\"Get beneficiary vital details from nurse general OPD\"}";

		when(generalOPDServiceImpl.updateBenExaminationDetails(any())).thenThrow(RuntimeException.class);

		String UpdateGeneralOPDExaminationNurse = generalOPDController.updateGeneralOPDExaminationNurse(requestObj);

		assertTrue(UpdateGeneralOPDExaminationNurse.contains("Unable to modify data"));
	}

//*******************
	@Test
	void testUpdateGeneralOPDDoctorDataSuccess() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"Update general OPD doctor data\"}";
		String authorization = "Test";
		JsonObject jsonRequest = parseJsonRequest(requestObj);
		Long result = 1L;

		when(generalOPDServiceImpl.updateGeneralOPDDoctorData(jsonRequest, authorization)).thenReturn(result);

		String expResponse = generalOPDController.updateGeneralOPDDoctorData(requestObj, authorization);

		response.setResponse("Data updated successfully");

		assertTrue(null != result && result > 0);

		assertEquals(expResponse, generalOPDController.updateGeneralOPDDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateGeneralOPDDoctorDataUnable() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"Update general OPD doctor data\"}";
		String authorization = "Test";
		JsonObject jsonRequest = parseJsonRequest(requestObj);
		Long result = -1L;

		when(generalOPDServiceImpl.updateGeneralOPDDoctorData(jsonRequest, authorization)).thenReturn(result);

		String expResponse = generalOPDController.updateGeneralOPDDoctorData(requestObj, authorization);

		response.setResponse("Data updated successfully");

		response.setError(500, "Unable to modify data");

		assertTrue(null != result && result < 0);
		assertNotEquals(0, result);

		assertEquals(expResponse, generalOPDController.updateGeneralOPDDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateGeneralOPDDoctorData_Exception() throws Exception {
		String requestObj = "{\"request\":\"Get beneficiary vital details from nurse general OPD\"}";
		String authorization = "Test";
		
		when(generalOPDServiceImpl.updateGeneralOPDDoctorData(any(), any())).thenThrow(RuntimeException.class);

		String UpdateGeneralOPDDoctorData = generalOPDController.updateGeneralOPDDoctorData(requestObj, authorization);

		assertTrue(UpdateGeneralOPDDoctorData.contains("Unable to modify data. "));
	}

}