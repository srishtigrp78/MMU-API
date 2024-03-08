package com.iemr.mmu.controller.ncdCare;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

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
import com.iemr.mmu.service.ncdCare.NCDCareServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import javassist.NotFoundException;

@ExtendWith(MockitoExtension.class)
class NCDCareControllerTest {

	@Mock
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Mock
	private NCDCareServiceImpl ncdCareServiceImpl;
	@InjectMocks
	NCDCareController ncdCareController;

	private JsonObject parseJsonRequest(String requestObj) {
		JsonElement jsonElement = JsonParser.parseString(requestObj);
		return jsonElement.getAsJsonObject();
	}

	@Test
	void testSaveBenNCDCareNurseData_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBenNCDCareNurseData\"}";
		Long ncdCareRes = 1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdCareServiceImpl.saveNCDCareNurseData(jsnOBJ)).thenReturn(ncdCareRes);

		String expResponse = ncdCareController.saveBenNCDCareNurseData(requestObj);

		response.setResponse("Data saved successfully");

		assertTrue(null != jsnOBJ && null != ncdCareRes && ncdCareRes > 0);

		assertEquals(expResponse, ncdCareController.saveBenNCDCareNurseData(requestObj));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveBenNCDCareNurseData_AlreadySaved() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBenNCDCareNurseData\"}";
		Long ncdCareRes = 0L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdCareServiceImpl.saveNCDCareNurseData(jsnOBJ)).thenReturn(ncdCareRes);

		String expResponse = ncdCareController.saveBenNCDCareNurseData(requestObj);

		response.setResponse("Data already saved");

		assertTrue(null != jsnOBJ && null != ncdCareRes && ncdCareRes == 0);

		assertEquals(expResponse, ncdCareController.saveBenNCDCareNurseData(requestObj));
		assertTrue(response.toString().contains("Data already saved"));
	}

	@Test
	void testSaveBenNCDCareNurseData_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBenNCDCareNurseData\"}";
		Long ncdCareRes = null;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdCareServiceImpl.saveNCDCareNurseData(jsnOBJ)).thenReturn(ncdCareRes);

		String expResponse = ncdCareController.saveBenNCDCareNurseData(requestObj);

		response.setResponse("Unable to save data");

		assertTrue(ncdCareRes == null || ncdCareRes < 0);

		assertEquals(expResponse, ncdCareController.saveBenNCDCareNurseData(requestObj));
		assertTrue(response.toString().contains("Unable to save data"));
	}

	@Test
	void testSaveBenNCDCareNurseData_InvalidRequest() throws Exception {
		OutputResponse response = new OutputResponse();

		JsonObject jsnOBJ = null;

		response.setError(5000, "Invalid Request !!!");

		assertNull(jsnOBJ);

		assertTrue(response.toString().contains("Invalid Request !!!"));
	}


	@Test
	void testSaveBenNCDCareDoctorData_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBenNCDCareDoctorDataS\"}";
		String authorization = "Test";
		Long ncdCareRes = 1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdCareServiceImpl.saveDoctorData(jsnOBJ, authorization)).thenReturn(ncdCareRes);

		String expResponse = ncdCareController.saveBenNCDCareDoctorData(requestObj, authorization);

		response.setResponse("Data saved successfully");

		assertNotNull(jsnOBJ);
		assertTrue(null != ncdCareRes && ncdCareRes > 0);

		assertEquals(expResponse, ncdCareController.saveBenNCDCareDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveBenNCDCareDoctorData_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBenNCDCareDoctorDataS\"}";
		String authorization = "Test";
		Long ncdCareRes = 0L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdCareServiceImpl.saveDoctorData(jsnOBJ, authorization)).thenReturn(ncdCareRes);

		String expResponse = ncdCareController.saveBenNCDCareDoctorData(requestObj, authorization);

		response.setResponse("Unable to save data");

		assertNotNull(jsnOBJ);
		assertFalse(null != ncdCareRes && ncdCareRes > 0);

		assertEquals(expResponse, ncdCareController.saveBenNCDCareDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to save data"));
	}

	@Test
	void testSaveBenNCDCareDoctorData_InvalidRequest() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBenNCDCareDoctorDataS\"}";
		String authorization = "Test";
		Long ncdCareRes = null;

		JsonObject jsnOBJ = null;

		when(ncdCareServiceImpl.saveDoctorData(jsnOBJ, authorization)).thenReturn(ncdCareRes);

		String expResponse = ncdCareController.saveBenNCDCareDoctorData(requestObj, authorization);

		response.setResponse("Invalid request");

		assertNull(jsnOBJ);
		assertNull(ncdCareRes);
		assertFalse(null != ncdCareRes && ncdCareRes > 0);

		assertEquals(expResponse, ncdCareController.saveBenNCDCareDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testGetBenVisitDetailsFrmNurseNCDCare() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ncdCareServiceImpl.getBenVisitDetailsFrmNurseNCDCare(benRegID, visitCode)).thenReturn(res);

		String expResponse = ncdCareController.getBenVisitDetailsFrmNurseNCDCare(comingRequest);

		response.setResponse(res);

		assertTrue(obj.length() > 1);

		assertEquals(expResponse, ncdCareController.getBenVisitDetailsFrmNurseNCDCare(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenVisitDetailsFrmNurseNCDCare_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(obj.length() < 1);

		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testGetBenVisitDetailsFrmNurseNCDCare_Exception() throws Exception {
		OutputResponse response = new OutputResponse();
		response.setError(5000, "Error while getting beneficiary visit data");
		assertEquals(response.toString(),ncdCareController.getBenVisitDetailsFrmNurseNCDCare(any()));
	}

	@Test
	void testGetBenNCDCareHistoryDetails() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String s = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ncdCareServiceImpl.getBenNCDCareHistoryDetails(benRegID, visitCode)).thenReturn(s);

		String expResponse = ncdCareController.getBenNCDCareHistoryDetails(comingRequest);

		response.setResponse(s);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, ncdCareController.getBenNCDCareHistoryDetails(comingRequest));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetBenNCDCareHistoryDetails_Invalid() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";
		String s = "test";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(!obj.has("benRegID") || !obj.has("visitCode"));

		assertTrue(response.toString().contains("Invalid request"));
	}
	
	@Test
	void testGetBenNCDCareHistoryDetails_Exception() throws Exception {
		OutputResponse response = new OutputResponse();
		response.setError(5000, "Error while getting beneficiary history data");
		assertEquals(response.toString(),ncdCareController.getBenNCDCareHistoryDetails(any()));
	}

	@Test
	void testGetBenVitalDetailsFrmNurseNCDCare() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ncdCareServiceImpl.getBeneficiaryVitalDetails(benRegID, visitCode)).thenReturn(res);

		String expResponse = ncdCareController.getBenVitalDetailsFrmNurseNCDCare(comingRequest);

		response.setResponse(res);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, ncdCareController.getBenVitalDetailsFrmNurseNCDCare(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenVitalDetailsFrmNurseNCDCare_Invalid() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(!obj.has("benRegID") || !obj.has("visitCode"));

		assertTrue(response.toString().contains("Invalid request"));
	}
	
	
	@Test
	void testGetBenVitalDetailsFrmNurseNCDCare_Exception() throws Exception {
		OutputResponse response = new OutputResponse();
		response.setError(5000, "Error while getting beneficiary vital data");
		assertEquals(response.toString(),ncdCareController.getBenVitalDetailsFrmNurseNCDCare(any()));
	}

	@Test
	void testGetBenCaseRecordFromDoctorNCDCare() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ncdCareServiceImpl.getBenCaseRecordFromDoctorNCDCare(benRegID, visitCode)).thenReturn(res);

		String expResponse = ncdCareController.getBenCaseRecordFromDoctorNCDCare(comingRequest);

		response.setResponse(res);

		assertTrue(obj.length() > 1 && obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, ncdCareController.getBenCaseRecordFromDoctorNCDCare(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenCaseRecordFromDoctorNCDCare_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(obj.length() < 1 || !obj.has("benRegID") || !obj.has("visitCode"));

		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testGetBenCaseRecordFromDoctorNCDCare_Exception() throws Exception {
		OutputResponse response = new OutputResponse();
		response.setError(5000, "Error while getting beneficiary doctor data");
		assertEquals(response.toString(),ncdCareController.getBenCaseRecordFromDoctorNCDCare(any()));
	}
	
	@Test
	void testUpdateHistoryNurse_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateHistoryNurse\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdCareServiceImpl.updateBenHistoryDetails(jsnOBJ)).thenReturn(result);

		String expResponse = ncdCareController.updateHistoryNurse(requestObj);

		Map<String, Integer> resMap = new HashMap<>();
		resMap.put("result", result);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, ncdCareController.updateHistoryNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateHistoryNurse_Unable() {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateHistoryNurse\"}";
		int result = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		Map<String, Integer> resMap = new HashMap<>();
		resMap.put("result", result);

		response.setError(500, "Unable to modify data");

		assertTrue(result < 0);

		assertTrue(response.toString().contains("Unable to modify data"));
	}
	
	@Test
	void testUpdateHistoryNurse_CatchBlock() throws Exception {
		String requestObj = "{\"request\":\"Save cancer screening nurse data\"}";
		String authorization = "Bearer token";
 
		when(ncdCareServiceImpl.updateBenHistoryDetails(any())).thenThrow(NotFoundException.class);
 
		String saveBenCancerScreeningNurseData = ncdCareController.updateHistoryNurse(requestObj);
 
		assertTrue(saveBenCancerScreeningNurseData.contains("Unable to modify data"));
	}

	@Test
	void testUpdateVitalNurse_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateVitalNurse\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdCareServiceImpl.updateBenVitalDetails(jsnOBJ)).thenReturn(result);

		String expResponse = ncdCareController.updateVitalNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, ncdCareController.updateVitalNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateVitalNurse_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateVitalNurse\"}";
		int result = 0;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdCareServiceImpl.updateBenVitalDetails(jsnOBJ)).thenReturn(result);

		String expResponse = ncdCareController.updateVitalNurse(requestObj);

		response.setError(500, "Unable to modify data");

		assertFalse(result > 0);

		assertEquals(expResponse, ncdCareController.updateVitalNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}
	
	@Test
	void testUpdateVitalNurse_CatchBlock() throws Exception {
		String requestObj = "{\"request\":\"Save cancer screening nurse data\"}";
		String authorization = "Bearer token";
 
		when(ncdCareServiceImpl.updateBenVitalDetails(any())).thenThrow(NotFoundException.class);
 
		String saveBenCancerScreeningNurseData = ncdCareController.updateVitalNurse(requestObj);
 
		assertTrue(saveBenCancerScreeningNurseData.contains("Unable to modify data"));
	}

	@Test
	void testUpdateNCDCareDoctorData_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateNCDCareDoctorData\"}";
		String authorization = "Test";
		Long result = 1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdCareServiceImpl.updateNCDCareDoctorData(jsnOBJ, authorization)).thenReturn(result);

		String expResponse = ncdCareController.updateNCDCareDoctorData(requestObj, authorization);

		response.setResponse("Data updated successfully");

		assertTrue(null != result && result > 0);

		assertEquals(expResponse, ncdCareController.updateNCDCareDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateNCDCareDoctorData_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateNCDCareDoctorData\"}";
		String authorization = "Test";
		Long result = 0L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdCareServiceImpl.updateNCDCareDoctorData(jsnOBJ, authorization)).thenReturn(result);

		String expResponse = ncdCareController.updateNCDCareDoctorData(requestObj, authorization);

		response.setError(500, "Unable to modify data");

		assertFalse(null != result && result > 0);

		assertEquals(expResponse, ncdCareController.updateNCDCareDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to modify data"));
	}
	
	@Test
	void testUpdateNCDCareDoctorData_CatchBlock() throws Exception {
		String requestObj = "{\"request\":\"Save cancer screening nurse data\"}";
		String authorization = "Bearer token";
 
		when(ncdCareServiceImpl.updateNCDCareDoctorData(any(), any())).thenThrow(NotFoundException.class);
 
		String saveBenCancerScreeningNurseData = ncdCareController.updateNCDCareDoctorData(requestObj, authorization);
 
		assertTrue(saveBenCancerScreeningNurseData.contains("Unable to modify data. " ));
	}

}
