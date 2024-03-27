package com.iemr.mmu.controller.labtechnician;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

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
import com.iemr.mmu.service.labtechnician.LabTechnicianServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import javassist.NotFoundException;

@ExtendWith(MockitoExtension.class)
class LabTechnicianControllerTest {

	@Mock
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Mock
	private LabTechnicianServiceImpl labTechnicianServiceImpl;

	@InjectMocks
	LabTechnicianController labTechnicianController;

	private static final String BENEFICIARY_REG_ID = "beneficiaryRegID";
	private static final String VISIT_CODE = "visitCode";

	private JsonObject parseJsonRequest(String requestObj) {
		JsonElement jsonElement = JsonParser.parseString(requestObj);
		return jsonElement.getAsJsonObject();
	}

	@Test
	void testSaveLabTestResult_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save Lab Test Result\"}";
		Integer labResultSaveRes = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(labTechnicianServiceImpl.saveLabTestResult(jsnOBJ)).thenReturn(labResultSaveRes);

		String expResponse = labTechnicianController.saveLabTestResult(requestObj);

		response.setResponse("Data saved successfully");

		assertNotNull(jsnOBJ);
		assertTrue(null != labResultSaveRes && labResultSaveRes > 0);

		assertEquals(expResponse, labTechnicianController.saveLabTestResult(requestObj));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveLabTestResult_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"request\":\"Save Lab Test Result\"}";
		Integer labResultSaveRes = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(labTechnicianServiceImpl.saveLabTestResult(jsnOBJ)).thenReturn(labResultSaveRes);

		String expResponse = labTechnicianController.saveLabTestResult(requestObj);

		response.setResponse("Unable to save data");

		assertNotNull(jsnOBJ);
		assertTrue(null != labResultSaveRes && labResultSaveRes < 0);

		assertEquals(expResponse, labTechnicianController.saveLabTestResult(requestObj));
		assertTrue(response.toString().contains("Unable to save data"));
	}

	@Test
	void testSaveLabTestResult_InvalidJson() {
		// Given an invalid JSON string
		String invalidRequestObj = "{\"invalidKey1\":\"value1\",\"invalidKey2\":\"value2\"}";

		// When saveLabTestResult is called
		String response = labTechnicianController.saveLabTestResult(invalidRequestObj);
		
//		System.out.println(response);

		// Then verify the response indicates an invalid request
		assertTrue(response.contains("Unable to save data"));
	}

	@Test
	void testSaveLabTestResult_Exception() throws Exception {

		OutputResponse response = new OutputResponse();
		response.setError(5000, "Unable to save data");
		assertEquals(response.toString(), labTechnicianController.saveLabTestResult(any()));

	}

	@Test
	void testGetBeneficiaryPrescribedProcedure() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"beneficiaryRegID\":\"1\",\"visitCode\":\"1\"}";

		String s = "Test";

		JsonObject jsnOBJ = parseJsonRequest(requestOBJ);

		when(labTechnicianServiceImpl.getBenePrescribedProcedureDetails(jsnOBJ.get(BENEFICIARY_REG_ID).getAsLong(),
				jsnOBJ.get(VISIT_CODE).getAsLong())).thenReturn(s);

		String expResponse = labTechnicianController.getBeneficiaryPrescribedProcedure(requestOBJ);

		response.setResponse(s);

		assertTrue(jsnOBJ != null && !jsnOBJ.isJsonNull() && jsnOBJ.has(BENEFICIARY_REG_ID) && jsnOBJ.has(VISIT_CODE));
		assertNotNull(s);
		assertEquals(expResponse, labTechnicianController.getBeneficiaryPrescribedProcedure(requestOBJ));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetBeneficiaryPrescribedProcedure_Error() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"beneficiaryRegID\":\"1\",\"visitCode\":\"1\"}";

		String s = null;

		JsonObject jsnOBJ = parseJsonRequest(requestOBJ);

		when(labTechnicianServiceImpl.getBenePrescribedProcedureDetails(jsnOBJ.get(BENEFICIARY_REG_ID).getAsLong(),
				jsnOBJ.get(VISIT_CODE).getAsLong())).thenReturn(s);

		String expResponse = labTechnicianController.getBeneficiaryPrescribedProcedure(requestOBJ);

		response.setError(5000, "Error in prescribed procedure details");

		assertTrue(
				jsnOBJ != null || !jsnOBJ.isJsonNull() || !jsnOBJ.has(BENEFICIARY_REG_ID) || !jsnOBJ.has(VISIT_CODE));
		assertNull(s);
		assertEquals(expResponse, labTechnicianController.getBeneficiaryPrescribedProcedure(requestOBJ));
		assertTrue(response.toString().contains("Error in prescribed procedure details"));
	}

	@Test
	void testGetBeneficiaryPrescribedProcedure_Invalid() throws Exception {
		String requestOBJ = "{\"invalidKey1\":\"value1\",\"invalidKey2\":\"value2\"}"; // Missing required keys

		String expResponse = labTechnicianController.getBeneficiaryPrescribedProcedure(requestOBJ);

		assertTrue(expResponse.contains("Invalid request"));
	}

	@Test
	void testGetBeneficiaryPrescribedProcedure_Exception() throws Exception {

		OutputResponse response = new OutputResponse();
		response.setError(5000, "Error while getting prescribed procedure data");
		assertEquals(response.toString(), labTechnicianController.getBeneficiaryPrescribedProcedure(any()));

	}

	@Test
	void testGetLabResultForVisitCode_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"beneficiaryRegID\":\"1\",\"visitCode\":\"1\"}";
		String s = "test";
		JsonObject jsnOBJ = parseJsonRequest(requestOBJ);

		when(labTechnicianServiceImpl.getLabResultForVisitcode(jsnOBJ.get(BENEFICIARY_REG_ID).getAsLong(),
				jsnOBJ.get(VISIT_CODE).getAsLong())).thenReturn(s);

		String expResponse = labTechnicianController.getLabResultForVisitCode(requestOBJ);

		response.setResponse(s);

		assertTrue(jsnOBJ != null && !jsnOBJ.isJsonNull() && jsnOBJ.has(BENEFICIARY_REG_ID) && jsnOBJ.has(VISIT_CODE));
		assertNotNull(s);
		assertEquals(expResponse, labTechnicianController.getLabResultForVisitCode(requestOBJ));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetLabResultForVisitCode_Error() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"beneficiaryRegID\":\"1\",\"visitCode\":\"1\"}";
		String s = null;
		JsonObject jsnOBJ = parseJsonRequest(requestOBJ);

		when(labTechnicianServiceImpl.getLabResultForVisitcode(jsnOBJ.get(BENEFICIARY_REG_ID).getAsLong(),
				jsnOBJ.get(VISIT_CODE).getAsLong())).thenReturn(s);

		String expResponse = labTechnicianController.getLabResultForVisitCode(requestOBJ);

		response.setError(5000, "Error while getting lab report");
		assertTrue(jsnOBJ != null && !jsnOBJ.isJsonNull() && jsnOBJ.has(BENEFICIARY_REG_ID) && jsnOBJ.has(VISIT_CODE));
		assertNull(s);
		assertEquals(expResponse, labTechnicianController.getLabResultForVisitCode(requestOBJ));
		assertTrue(response.toString().contains("Error while getting lab report"));
	}

	@Test
	void testGetLabResultForVisitCode_Invalid() {
		// Given an invalid JSON string
		String invalidRequestObj = "{\"invalidKey1\":\"value1\",\"invalidKey2\":\"value2\"}";

		// When saveLabTestResult is called
		String response = labTechnicianController.getLabResultForVisitCode(invalidRequestObj);

		// Then verify the response indicates an invalid request
		assertTrue(response.contains("Invalid request"));
	}

	@Test
	void testGetLabResultForVisitCode_Exception() throws Exception {

		String requestOBJ = "{\"beneficiaryRegID\":\"1\",\"visitCode\":\"1\"}";

		when(labTechnicianServiceImpl.getLabResultForVisitcode(any(), any())).thenThrow((NotFoundException.class));

		String saveBenCancerScreeningNurseData = labTechnicianController.getLabResultForVisitCode(requestOBJ);

		assertTrue(saveBenCancerScreeningNurseData.contains("Error while getting lab report"));

	}

}
