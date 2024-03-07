package com.iemr.mmu.controller.pnc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import com.iemr.mmu.service.pnc.PNCServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class PostnatalCareControllerTest {

	@Mock
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Mock
	private PNCServiceImpl pncServiceImpl;

	@InjectMocks
	private PostnatalCareController postnatalCareController;

	private JsonObject parseJsonRequest(String requestObj) {
		JsonElement jsonElement = JsonParser.parseString(requestObj);
		return jsonElement.getAsJsonObject();
	}

	@Test
	void testSaveBenPNCNurseData_Success() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"SaveBenPNCNurseData\"}";
		Long ancRes = 123L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(pncServiceImpl.savePNCNurseData(jsnOBJ)).thenReturn(ancRes);

		String expResponse = postnatalCareController.saveBenPNCNurseData(requestObj);

		response.setResponse("Data saved successfully");

		assertNotNull(jsnOBJ);
		assertTrue(ancRes > 0);

		assertEquals(expResponse, postnatalCareController.saveBenPNCNurseData(requestObj));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveBenPNCNurseData_Already() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"SaveBenPNCNurseData\"}";
		Long ancRes = 0L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(pncServiceImpl.savePNCNurseData(jsnOBJ)).thenReturn(ancRes);

		String expResponse = postnatalCareController.saveBenPNCNurseData(requestObj);

		response.setResponse("Data already saved");

		assertNotNull(jsnOBJ);

		assertTrue(null != ancRes && ancRes == 0);

		assertEquals(expResponse, postnatalCareController.saveBenPNCNurseData(requestObj));
		assertTrue(response.toString().contains("Data already saved"));
	}

	@Test
	void testSaveBenPNCNurseData_Unable() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"SaveBenPNCNurseData\"}";
		Long ancRes = null;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(pncServiceImpl.savePNCNurseData(jsnOBJ)).thenReturn(ancRes);

		String expResponse = postnatalCareController.saveBenPNCNurseData(requestObj);

		response.setResponse("Unable to save data");

		assertNotNull(jsnOBJ);

		assertTrue(ancRes == null || ancRes < 0);

		assertEquals(expResponse, postnatalCareController.saveBenPNCNurseData(requestObj));
		assertTrue(response.toString().contains("Unable to save data"));
	}

//	@Test
//	void testSaveBenPNCNurseData_InvalidRequest() throws Exception {
//		OutputResponse response = new OutputResponse();
//
//		JsonObject jsnOBJ = null;
//
//		response.setResponse("Invalid request");
//
//		assertNull(jsnOBJ);
//
//		assertTrue(response.toString().contains("Invalid request"));
//	}

	@Test
    void testSaveBenPNCNurseData_InvalidRequest() {
        String invalidRequest = "This is not a valid JSON";;

        String response = postnatalCareController.saveBenPNCNurseData(invalidRequest);

        assertTrue(response.toString().contains("Invalid request"));
    }
//*********
	@Test
	void testSaveBenPNCDoctorData_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBenPNCDoctorDataSuccess\"}";
		String authorization = "Test";
		Long r = 123L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(pncServiceImpl.savePNCDoctorData(jsnOBJ, authorization)).thenReturn(r);

		String expResopnse = postnatalCareController.saveBenPNCDoctorData(requestObj, authorization);

		response.setResponse("Data saved successfully");

		assertNotNull(jsnOBJ);
		assertTrue(r > 0);

		assertEquals(expResopnse, postnatalCareController.saveBenPNCDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Data saved successfully"));

	}

	@Test
	void testSaveBenPNCDoctorData_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBenPNCDoctorDataSuccess\"}";
		String authorization = "Test";
		Long r = (long) 0;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(pncServiceImpl.savePNCDoctorData(jsnOBJ, authorization)).thenReturn(r);

		String expResopnse = postnatalCareController.saveBenPNCDoctorData(requestObj, authorization);

		response.setResponse("Unable to save data");

		assertNotNull(jsnOBJ);
		assertEquals(0, r);

		assertEquals(expResopnse, postnatalCareController.saveBenPNCDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to save data"));
	}

	@Test
	void testSaveBenPNCDoctorData_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = null;

		JsonObject jsnOBJ = null;

		String expResponse = postnatalCareController.saveBenPNCNurseData(requestObj);

		response.setResponse("Invalid request");

		assertNull(jsnOBJ);

		assertEquals(expResponse, postnatalCareController.saveBenPNCNurseData(requestObj));
		assertTrue(response.toString().contains("Invalid request"));
	}
//*****************	
	@Test
	void testGetBenVisitDetailsFrmNursePNC() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";
		
		JSONObject obj = new JSONObject(comingRequest);
		
		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(pncServiceImpl.getBenVisitDetailsFrmNursePNC(benRegID, visitCode)).thenReturn(res);
		
		String expResponse = postnatalCareController.getBenVisitDetailsFrmNursePNC(comingRequest);
		
		response.setResponse(res);

		assertTrue(obj.length() > 1);
		
		assertEquals(expResponse,postnatalCareController.getBenVisitDetailsFrmNursePNC(comingRequest));
		assertTrue(response.toString().contains(res));
	}
	
	@Test
	void testGetBenVisitDetailsFrmNursePNC_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		
		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(obj.length() > 1);
		
		assertTrue(response.toString().contains("Invalid request"));
	}

//*******************
	@Test
	void testGetBenPNCDetailsFrmNursePNC() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";
		
		JSONObject obj = new JSONObject(comingRequest);
		
		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(pncServiceImpl.getBenPNCDetailsFrmNursePNC(benRegID, visitCode)).thenReturn(res);
		
		String expResponse = postnatalCareController.getBenPNCDetailsFrmNursePNC(comingRequest);
		
		response.setResponse(res);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));
		
		assertEquals(expResponse,postnatalCareController.getBenPNCDetailsFrmNursePNC(comingRequest));
		assertTrue(response.toString().contains(res));
	}
	
	@Test
	void testGetBenPNCDetailsFrmNursePNC_Invalid() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";
		
		JSONObject obj = new JSONObject(comingRequest);
		
		response.setError(5000, "Invalid request");

		assertTrue(!obj.has("benRegID") || !obj.has("visitCode"));
		
		assertTrue(response.toString().contains("Invalid request"));
	}
	
//***********************
	@Test
	void testGetBenHistoryDetails() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String s = "test";
		
		JSONObject obj = new JSONObject(comingRequest);
		
		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(pncServiceImpl.getBenHistoryDetails(benRegID, visitCode)).thenReturn(s);
		
		String expResponse = postnatalCareController.getBenHistoryDetails(comingRequest);
		response.setResponse(s);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));
		
		assertEquals(expResponse,postnatalCareController.getBenHistoryDetails(comingRequest));
		assertTrue(response.toString().contains(s));
	}
	
	@Test
	void testGetBenHistoryDetails_Invalid() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";
		
		JSONObject obj = new JSONObject(comingRequest);
		
		response.setError(5000, "Invalid request");

		assertTrue(!obj.has("benRegID") || !obj.has("visitCode"));
		
		assertTrue(response.toString().contains("Invalid request"));
	}
	
//**********************
	@Test
	void testGetBenVitalDetailsFrmNurse() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";
		
		JSONObject obj = new JSONObject(comingRequest);
		
		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(pncServiceImpl.getBeneficiaryVitalDetails(benRegID, visitCode)).thenReturn(res);
		
		String expResponse = postnatalCareController.getBenVitalDetailsFrmNurse(comingRequest);
		response.setResponse(res);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));
		
		assertEquals(expResponse,postnatalCareController.getBenVitalDetailsFrmNurse(comingRequest));
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
	
//***************
	@Test
	void testGetBenExaminationDetailsPNC() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String s = "test";
		
		JSONObject obj = new JSONObject(comingRequest);
		
		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(pncServiceImpl.getPNCExaminationDetailsData(benRegID, visitCode)).thenReturn(s);
		
		String expResponse = postnatalCareController.getBenExaminationDetailsPNC(comingRequest);
		
		response.setResponse(s);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));
		
		assertEquals(expResponse,postnatalCareController.getBenExaminationDetailsPNC(comingRequest));
		assertTrue(response.toString().contains(s));
	}
	
	@Test
	void testGetBenExaminationDetailsPNC_Invalid() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";
		
		JSONObject obj = new JSONObject(comingRequest);
		
		response.setError(5000, "Invalid request");

		assertTrue(!obj.has("benRegID") || !obj.has("visitCode"));
		
		assertTrue(response.toString().contains("Invalid request"));
	}
	
//********************
	@Test
	void testGetBenCaseRecordFromDoctorPNC() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";
		
		JSONObject obj = new JSONObject(comingRequest);
		
		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(pncServiceImpl.getBenCaseRecordFromDoctorPNC(benRegID, visitCode)).thenReturn(res);
		
		String expResponse = postnatalCareController.getBenCaseRecordFromDoctorPNC(comingRequest);
		
		response.setResponse(res);

		assertTrue(obj.length() > 1 && obj.has("benRegID") && obj.has("visitCode"));
		
		assertEquals(expResponse,postnatalCareController.getBenCaseRecordFromDoctorPNC(comingRequest));
		assertTrue(response.toString().contains(res));
	}
	
	@Test
	void testGetBenCaseRecordFromDoctorPNC_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";
		
		JSONObject obj = new JSONObject(comingRequest);
		
		response.setError(5000, "Invalid request");

		assertTrue(obj.length() < 1 || !obj.has("benRegID") && !obj.has("visitCode"));
		
		assertTrue(response.toString().contains("Invalid request"));
	}
	
//****************
	@Test
	void testUpdatePNCCareNurse() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"UpdatePNCCareNurse\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(pncServiceImpl.updateBenPNCDetails(jsnOBJ)).thenReturn(result);

		String expResponse = postnatalCareController.updatePNCCareNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, postnatalCareController.updatePNCCareNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdatePNCCareNurse_Unable() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestObj = "{\"request\":\"UpdatePNCCareNurse\"}";
		int result = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(pncServiceImpl.updateBenPNCDetails(jsnOBJ)).thenReturn(result);

		String expResponse = postnatalCareController.updatePNCCareNurse(requestObj);

		response.setResponse("Unable to modify data");

		assertTrue(result < 0);

		assertEquals(expResponse, postnatalCareController.updatePNCCareNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

//***********
	@Test
	void testUpdateHistoryNurse_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateHistoryNurse\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(pncServiceImpl.updateBenHistoryDetails(jsnOBJ)).thenReturn(result);

		String expResponse = postnatalCareController.updateHistoryNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, postnatalCareController.updateHistoryNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateHistoryNurse_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateHistoryNurse\"}";
		int result = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(pncServiceImpl.updateBenHistoryDetails(jsnOBJ)).thenReturn(result);

		String expResponse = postnatalCareController.updateHistoryNurse(requestObj);

		response.setResponse("Unable to modify data");

		assertTrue(result < 0);

		assertEquals(expResponse, postnatalCareController.updateHistoryNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

//**************
	@Test
	void testUpdateVitalNurse_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateVitalNurse\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(pncServiceImpl.updateBenVitalDetails(jsnOBJ)).thenReturn(result);

		String expResponse = postnatalCareController.updateVitalNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, postnatalCareController.updateVitalNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateVitalNurse_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateVitalNurse\"}";
		int result = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(pncServiceImpl.updateBenVitalDetails(jsnOBJ)).thenReturn(result);

		String expResponse = postnatalCareController.updateVitalNurse(requestObj);

		response.setResponse("Unable to modify data");

		assertTrue(result < 0);

		assertEquals(expResponse, postnatalCareController.updateVitalNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

//**************
	@Test
	void testUpdateGeneralOPDExaminationNurse_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateGeneralOPDExaminationNurse\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		// when(pncServiceImpl.updateBenExaminationDetails(jsnOBJ)).thenReturn(result);

		String expResponse = postnatalCareController.updateVitalNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, postnatalCareController.updateVitalNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateGeneralOPDExaminationNurse_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateGeneralOPDExaminationNurse\"}";
		int result = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		// when(pncServiceImpl.updateBenExaminationDetails(jsnOBJ)).thenReturn(result);

		String expResponse = postnatalCareController.updateVitalNurse(requestObj);

		response.setResponse("Unable to modify data");

		assertTrue(result < 0);

		assertEquals(expResponse, postnatalCareController.updateVitalNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

//***************
	@Test
	void testUpdatePNCDoctorData_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateGeneralOPDExaminationNurse\"}";
		String authorization = "Test";
		Long result = 1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(pncServiceImpl.updatePNCDoctorData(jsnOBJ, authorization)).thenReturn(result);

		String expResponse = postnatalCareController.updatePNCDoctorData(requestObj, authorization);

		response.setResponse("Data updated successfully");

		assertNotNull(result);
		assertTrue(result > 0);

		assertEquals(expResponse, postnatalCareController.updatePNCDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdatePNCDoctorData_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateGeneralOPDExaminationNurse\"}";
		String authorization = "Test";
		Long result = -1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(pncServiceImpl.updatePNCDoctorData(jsnOBJ, authorization)).thenReturn(result);

		String expResponse = postnatalCareController.updatePNCDoctorData(requestObj, authorization);

		response.setResponse("Unable to modify data");

		assertNotNull(result);
		assertTrue(result < 0);

		assertEquals(expResponse, postnatalCareController.updatePNCDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to modify data"));
	}
}
//*****
//void testSaveBenPNCNurseData() -done 
//void testSaveBenPNCDoctorData() -done 
//void testGetBenVisitDetailsFrmNursePNC() -done 
//void testGetBenPNCDetailsFrmNursePNC() -done 
//void testGetBenHistoryDetails() -done 
//void testGetBenVitalDetailsFrmNurse() -done 
//void testGetBenExaminationDetailsPNC() -done 
//void testGetBenCaseRecordFromDoctorPNC()-done 
//void testUpdatePNCCareNurse() -done
//void testUpdateHistoryNurse() -done
//void testUpdateVitalNurse() -done
//void testUpdateGeneralOPDExaminationNurse()-done
//void testUpdatePNCDoctorData() -done
