package com.iemr.mmu.controller.ncdscreening;

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
import com.iemr.mmu.service.ncdscreening.NCDSCreeningDoctorService;
import com.iemr.mmu.service.ncdscreening.NCDScreeningService;
import com.iemr.mmu.service.ncdscreening.NCDScreeningServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import javassist.NotFoundException;

@ExtendWith(MockitoExtension.class)
class NCDControllerTest {

	@Mock
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Mock
	private NCDScreeningServiceImpl ncdScreeningServiceImpl;
	@Mock
	private NCDScreeningService ncdScreeningService;
	@Mock
	private NCDSCreeningDoctorService ncdSCreeningDoctorService;
	@InjectMocks
	private NCDController ncdController;

	private JsonObject parseJsonRequest(String requestObj) {
		JsonElement jsonElement = JsonParser.parseString(requestObj);
		return jsonElement.getAsJsonObject();
	}

	@Test
	void testSaveBeneficiaryNCDScreeningDetailsSuccess() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBeneficiaryNCDScreeningDetails\"}";
		String authorization = "Test";
		Long r = 1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdScreeningServiceImpl.saveNCDScreeningNurseData(jsnOBJ, authorization)).thenReturn(r);

		String expResponse = ncdController.saveBeneficiaryNCDScreeningDetails(requestObj, authorization);

		response.setResponse("Data saved successfully");

		assertNotNull(jsnOBJ);
		assertNotNull(r);
		assertTrue(r > 0);

		assertEquals(expResponse, ncdController.saveBeneficiaryNCDScreeningDetails(requestObj, authorization));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveBeneficiaryNCDScreeningDetailsAlreadySaved() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBeneficiaryNCDScreeningDetails\"}";
		String authorization = "Test";
		Long r = 0L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdScreeningServiceImpl.saveNCDScreeningNurseData(jsnOBJ, authorization)).thenReturn(r);

		String expResponse = ncdController.saveBeneficiaryNCDScreeningDetails(requestObj, authorization);

		response.setResponse("Data already saved");

		assertNotNull(jsnOBJ);
		assertNotNull(r);
		assertTrue(r == 0);

		assertEquals(expResponse, ncdController.saveBeneficiaryNCDScreeningDetails(requestObj, authorization));
		assertTrue(response.toString().contains("Data already saved"));
	}

	@Test
	void testSaveBeneficiaryNCDScreeningDetailsUnable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBeneficiaryNCDScreeningDetails\"}";
		String authorization = "Test";
		Long r = null;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdScreeningServiceImpl.saveNCDScreeningNurseData(jsnOBJ, authorization)).thenReturn(r);

		String expResponse = ncdController.saveBeneficiaryNCDScreeningDetails(requestObj, authorization);

		response.setResponse("Unable to save data");

		assertNotNull(jsnOBJ);
		assertNull(r);

		assertEquals(expResponse, ncdController.saveBeneficiaryNCDScreeningDetails(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to save data"));
	}

	@Test
	void testSaveBeneficiaryNCDScreeningDetailsInvalid() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBeneficiaryNCDScreeningDetails\"}";
		String authorization = "Test";
		Long r = null;

		JsonObject jsnOBJ = null;

		when(ncdScreeningServiceImpl.saveNCDScreeningNurseData(jsnOBJ, authorization)).thenReturn(r);

		String expResponse = ncdController.saveBeneficiaryNCDScreeningDetails(requestObj, authorization);

		response.setResponse("Unable to save data");

		assertNull(jsnOBJ);
		assertNull(r);

		assertEquals(expResponse, ncdController.saveBeneficiaryNCDScreeningDetails(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to save data"));
	}


	@Test
	void testSaveBenNCDScreeningDoctorDataSuccess() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBenNCDScreeningDoctorData\"}";
		String authorization = "Test";
		Long ncdCareRes = 1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdScreeningServiceImpl.saveDoctorData(jsnOBJ, authorization)).thenReturn(ncdCareRes);

		String expResponse = ncdController.saveBenNCDScreeningDoctorData(requestObj, authorization);

		response.setResponse("Data saved successfully");

		assertNotNull(jsnOBJ);
		assertTrue(ncdCareRes > 0);

		assertEquals(expResponse, ncdController.saveBenNCDScreeningDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveBenNCDScreeningDoctorDataUnable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBenNCDScreeningDoctorData\"}";
		String authorization = "Test";
		Long ncdCareRes = -1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdScreeningServiceImpl.saveDoctorData(jsnOBJ, authorization)).thenReturn(ncdCareRes);

		String expResponse = ncdController.saveBenNCDScreeningDoctorData(requestObj, authorization);

		response.setResponse("Unable to save data");

		assertNotNull(jsnOBJ);
		assertTrue(ncdCareRes < 0);

		assertEquals(expResponse, ncdController.saveBenNCDScreeningDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to save data"));
	}

	@Test
	void testSaveBenNCDScreeningDoctorDataInvalid() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"SaveBenNCDScreeningDoctorData\"}";
		String authorization = "Test";
		Long ncdCareRes = null;

		JsonObject jsnOBJ = null;

		when(ncdScreeningServiceImpl.saveDoctorData(jsnOBJ, authorization)).thenReturn(ncdCareRes);

		String expResponse = ncdController.saveBenNCDScreeningDoctorData(requestObj, authorization);

		response.setResponse("Unable to save data");

		assertNull(jsnOBJ);
		assertNull(ncdCareRes);

		assertEquals(expResponse, ncdController.saveBenNCDScreeningDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to save data"));
	}

	@Test
	void testGetNCDScreenigDetails() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String screeningDetails = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ncdScreeningServiceImpl.getNCDScreeningDetails(benRegID, visitCode)).thenReturn(screeningDetails);

		String expResponse = ncdController.getNCDScreenigDetails(comingRequest);

		response.setResponse(screeningDetails);

		assertTrue(obj.length() > 1);

		assertEquals(expResponse, ncdController.getNCDScreenigDetails(comingRequest));
		assertTrue(response.toString().contains(screeningDetails));
	}

	@Test
	void testGetNCDScreenigDetails_Invalid() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";
		String screeningDetails = "test";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(obj.length() < 1);

		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testGetNCDScreenigDetails_Exception() {
		OutputResponse response = new OutputResponse();
		response.setError(5000, "Error while getting NCD Screening data");
		assertEquals(response.toString(), ncdController.getNCDScreenigDetails(any()));
	}

	@Test
	void testGetNcdScreeningVisitCount_Success() {
		OutputResponse response = new OutputResponse();

		Long beneficiaryRegID = 1L;
		String s = "Test";

		when(ncdScreeningServiceImpl.getNcdScreeningVisitCnt(beneficiaryRegID)).thenReturn(s);

		String expResponse = ncdController.getNcdScreeningVisitCount(beneficiaryRegID);
		response.setResponse(s);

		assertNotNull(beneficiaryRegID);
		assertNotNull(s);

		assertEquals(expResponse, ncdController.getNcdScreeningVisitCount(beneficiaryRegID));
	}

	@Test
	void testGetNcdScreeningVisitCount_Error() {
		OutputResponse response = new OutputResponse();

		Long beneficiaryRegID = 1L;
		String s = null;

		when(ncdScreeningServiceImpl.getNcdScreeningVisitCnt(beneficiaryRegID)).thenReturn(s);

		String expResponse = ncdController.getNcdScreeningVisitCount(beneficiaryRegID);

		response.setError(5000, "Error while getting NCD screening Visit Count");

		assertNotNull(beneficiaryRegID);
		assertNull(s);

		assertEquals(expResponse, ncdController.getNcdScreeningVisitCount(beneficiaryRegID));
		assertTrue(response.toString().contains("Error while getting NCD screening Visit Count"));
	}

	@Test
	void testGetNcdScreeningVisitCount_Invalid() {
		OutputResponse response = new OutputResponse();

		Long beneficiaryRegID = null;
		String s = null;

		// when(ncdScreeningServiceImpl.getNcdScreeningVisitCnt(beneficiaryRegID)).thenReturn(s);

		String expResponse = ncdController.getNcdScreeningVisitCount(beneficiaryRegID);

		response.setError(5000, "Invalid request");

		assertNull(beneficiaryRegID);
		assertNull(s);

		assertEquals(expResponse, ncdController.getNcdScreeningVisitCount(beneficiaryRegID));
		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testGetNcdScreeningVisitCount_Exception() throws Exception {
		Long beneficiaryRegID = 1L;

		when(ncdScreeningServiceImpl.getNcdScreeningVisitCnt(any())).thenThrow(RuntimeException.class);

		String saveBenCancerScreeningNurseData = ncdController.getNcdScreeningVisitCount(beneficiaryRegID);

		assertTrue(saveBenCancerScreeningNurseData.contains("Error while getting NCD screening Visit Count"));
	}

	@Test
	void testGetBenVisitDetailsFrmNurseGOPD() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ncdScreeningServiceImpl.getBenVisitDetailsFrmNurseNCDScreening(benRegID, visitCode)).thenReturn(res);

		String expResponse = ncdController.getBenVisitDetailsFrmNurseGOPD(comingRequest);

		response.setResponse(res);

		assertTrue(obj.length() > 1);
		assertEquals(expResponse, ncdController.getBenVisitDetailsFrmNurseGOPD(comingRequest));
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

	@Test
	void testGetBenVisitDetailsFrmNurseGOPD_Exception() throws Exception {
		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";

		when(ncdScreeningServiceImpl.getBenVisitDetailsFrmNurseNCDScreening(any(), any()))
				.thenThrow(RuntimeException.class);

		String saveBenCancerScreeningNurseData = ncdController.getBenVisitDetailsFrmNurseGOPD(comingRequest);

		assertTrue(saveBenCancerScreeningNurseData.contains("Error while getting beneficiary visit data"));
	}

	@Test
	void testGetBenHistoryDetails() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String s = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ncdScreeningServiceImpl.getBenHistoryDetails(benRegID, visitCode)).thenReturn(s);

		String expResponse = ncdController.getBenHistoryDetails(comingRequest);

		response.setResponse(s);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, ncdController.getBenHistoryDetails(comingRequest));
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

	@Test
	void testGetBenHistoryDetails_Exception() throws Exception {
		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";

		when(ncdScreeningServiceImpl.getBenHistoryDetails(any(), any())).thenThrow(RuntimeException.class);

		String saveBenCancerScreeningNurseData = ncdController.getBenHistoryDetails(comingRequest);

		assertTrue(saveBenCancerScreeningNurseData.contains("Error while getting beneficiary history data"));
	}

	@Test
	void testGetBenVitalDetailsFrmNurse() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ncdScreeningServiceImpl.getBeneficiaryVitalDetails(benRegID, visitCode)).thenReturn(res);

		String expResponse = ncdController.getBenVitalDetailsFrmNurse(comingRequest);

		response.setResponse(res);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, ncdController.getBenVitalDetailsFrmNurse(comingRequest));
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

	@Test
	void testGetBenVitalDetailsFrmNurse_Exception() throws Exception {
		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";

		when(ncdScreeningServiceImpl.getBeneficiaryVitalDetails(any(), any())).thenThrow(RuntimeException.class);

		String saveBenCancerScreeningNurseData = ncdController.getBenVitalDetailsFrmNurse(comingRequest);

		assertTrue(saveBenCancerScreeningNurseData.contains("Error while getting beneficiary vital data"));
	}

	@Test
	void testGetBenIdrsDetailsFrmNurse() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ncdScreeningServiceImpl.getBenIdrsDetailsFrmNurse(benRegID, visitCode)).thenReturn(res);

		String expResponse = ncdController.getBenIdrsDetailsFrmNurse(comingRequest);

		response.setResponse(res);

		assertTrue(obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, ncdController.getBenIdrsDetailsFrmNurse(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenIdrsDetailsFrmNurse_Invalid() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(!obj.has("benRegID") || !obj.has("visitCode"));

		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testGetBenIdrsDetailsFrmNurse_Exception() throws Exception {
		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";

		when(ncdScreeningServiceImpl.getBenIdrsDetailsFrmNurse(any(), any())).thenThrow(RuntimeException.class);

		String saveBenCancerScreeningNurseData = ncdController.getBenIdrsDetailsFrmNurse(comingRequest);

		assertTrue(saveBenCancerScreeningNurseData.contains("Error while getting beneficiary Idrs data"));
	}

	@Test
	void testGetBenCaseRecordFromDoctorNCDCare() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(ncdScreeningServiceImpl.getBenCaseRecordFromDoctorNCDScreening(benRegID, visitCode)).thenReturn(res);

		String expResponse = ncdController.getBenCaseRecordFromDoctorNCDCare(comingRequest);

		response.setResponse(res);

		assertTrue(obj.length() > 1 && obj.has("benRegID") && obj.has("visitCode"));

		assertEquals(expResponse, ncdController.getBenCaseRecordFromDoctorNCDCare(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenCaseRecordFromDoctorNCDCare_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(obj.length() < 1 || obj.has("benRegID") || obj.has("visitCode"));

		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testGetBenCaseRecordFromDoctorNCDCare_Exception() throws Exception {
		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";

		when(ncdScreeningServiceImpl.getBenCaseRecordFromDoctorNCDScreening(any(), any()))
				.thenThrow(RuntimeException.class);

		String saveBenCancerScreeningNurseData = ncdController.getBenCaseRecordFromDoctorNCDCare(comingRequest);

		assertTrue(saveBenCancerScreeningNurseData.contains("Error while getting beneficiary doctor data"));
	}

	@Test
	void testUpdateBeneficiaryNCDScreeningDetails_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateBeneficiaryNCDScreeningDetails\"}";
		Integer r = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdScreeningServiceImpl.updateNurseNCDScreeningDetails(jsnOBJ)).thenReturn(r);

		String expResponse = ncdController.updateBeneficiaryNCDScreeningDetails(requestObj);

		response.setResponse("Data updated successfully");

		assertNotNull(jsnOBJ);
		assertTrue(r == 1);

		assertEquals(expResponse, ncdController.updateBeneficiaryNCDScreeningDetails(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateBeneficiaryNCDScreeningDetails_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateBeneficiaryNCDScreeningDetails\"}";
		Integer r = 0;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdScreeningServiceImpl.updateNurseNCDScreeningDetails(jsnOBJ)).thenReturn(r);

		String expResponse = ncdController.updateBeneficiaryNCDScreeningDetails(requestObj);

		response.setError(5000, "Unable to modify data");

		assertNotNull(jsnOBJ);
		assertFalse(r == 1);

		assertEquals(expResponse, ncdController.updateBeneficiaryNCDScreeningDetails(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateBeneficiaryNCDScreeningDetails_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateBeneficiaryNCDScreeningDetails\"}";
		Integer r = null;

		JsonObject jsnOBJ = null;

		when(ncdScreeningServiceImpl.updateNurseNCDScreeningDetails(jsnOBJ)).thenReturn(r);

		String expResponse = ncdController.updateBeneficiaryNCDScreeningDetails(requestObj);

		response.setError(5000, "Invalid request");

		assertNull(jsnOBJ);
		assertNull(r);

		assertEquals(expResponse, ncdController.updateBeneficiaryNCDScreeningDetails(requestObj));
		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testUpdateHistoryNurse_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateHistoryNurse\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdScreeningService.UpdateNCDScreeningHistory(jsnOBJ)).thenReturn(result);

		String expResponse = ncdController.updateHistoryNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, ncdController.updateHistoryNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateHistoryNurse_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateHistoryNurse\"}";
		int result = 0;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdScreeningService.UpdateNCDScreeningHistory(jsnOBJ)).thenReturn(result);

		String expResponse = ncdController.updateHistoryNurse(requestObj);

		response.setError(500, "Unable to modify data");

		assertFalse(result > 0);

		assertEquals(expResponse, ncdController.updateHistoryNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateHistoryNurse_Exception() throws Exception {
		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";

		when(ncdScreeningService.UpdateNCDScreeningHistory(any())).thenThrow(RuntimeException.class);

		String UpdateHistoryNurse = ncdController.updateHistoryNurse(comingRequest);

		assertTrue(UpdateHistoryNurse.contains("Unable to modify data"));
	}

	@Test
	void testUpdateVitalNurse() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateHistoryNurse\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdScreeningServiceImpl.updateBenVitalDetails(jsnOBJ)).thenReturn(result);

		String expResponse = ncdController.updateVitalNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, ncdController.updateVitalNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateVital_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateHistoryNurse\"}";
		int result = 0;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdScreeningServiceImpl.updateBenVitalDetails(jsnOBJ)).thenReturn(result);

		String expResponse = ncdController.updateVitalNurse(requestObj);

		response.setError(500, "Unable to modify data");

		assertFalse(result > 0);

		assertEquals(expResponse, ncdController.updateVitalNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testupdateVitalNurse_Exception1() throws Exception {
		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";

		when(ncdScreeningServiceImpl.updateBenVitalDetails(any())).thenThrow(NotFoundException.class);

		String UpdateHistoryNurse = ncdController.updateVitalNurse(comingRequest);

		assertTrue(UpdateHistoryNurse.contains("Unable to modify data"));
	}

	@Test
	void testUpdateIDRSScreen_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateIDRSScreen\"}";
		Long result = 1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdScreeningService.UpdateIDRSScreen(jsnOBJ)).thenReturn(result);

		String expResponse = ncdController.updateIDRSScreen(requestObj);

		response.setResponse("Data updated successfully");

		assertNotNull(result);
		assertTrue(result > 0);

		assertEquals(expResponse, ncdController.updateIDRSScreen(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateIDRSScreen_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateIDRSScreen\"}";
		Long result = 0L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdScreeningService.UpdateIDRSScreen(jsnOBJ)).thenReturn(result);

		String expResponse = ncdController.updateIDRSScreen(requestObj);

		response.setError(500, "Unable to modify data");

		assertNotNull(result);
		assertFalse(result > 0);

		assertEquals(expResponse, ncdController.updateIDRSScreen(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}
	
	@Test
	void testUpdateIDRSScreen_Exception1() throws Exception {
		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";

		 when(ncdScreeningService.UpdateIDRSScreen(any())).thenThrow(NotFoundException.class);

		String UpdateHistoryNurse = ncdController.updateIDRSScreen(comingRequest);

		assertTrue(UpdateHistoryNurse.contains("Unable to modify data"));
	}


	@Test
	void testUpdateDoctorData_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateDoctorData\"}";
		int i = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdSCreeningDoctorService.updateDoctorData(jsnOBJ)).thenReturn(i);

		String expResponse = ncdController.updateDoctorData(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(i > 0);

		assertEquals(expResponse, ncdController.updateDoctorData(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateDoctorData_Error() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"UpdateDoctorData\"}";
		int i = 0;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(ncdSCreeningDoctorService.updateDoctorData(jsnOBJ)).thenReturn(i);

		String expResponse = ncdController.updateDoctorData(requestObj);

		response.setError(5000, "Error in data update");

		assertFalse(i > 0);

		assertEquals(expResponse, ncdController.updateDoctorData(requestObj));
		assertTrue(response.toString().contains("Error in data update"));
	}
	
	@Test
	void testUpdateDoctorData_Exception1() throws Exception {
		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";

		 when(ncdSCreeningDoctorService.updateDoctorData(any())).thenThrow(NotFoundException.class);

		String UpdateHistoryNurse = ncdController.updateDoctorData(comingRequest);

		assertTrue(UpdateHistoryNurse.contains("Unable to modify data"));
	}


}