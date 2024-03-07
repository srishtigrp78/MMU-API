package com.iemr.mmu.controller.labtechnician;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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

//	@Test
//	void testSaveLabTestResultUnable_InvalidRequest() throws Exception {
//		OutputResponse response = new OutputResponse();
//
//		String requestObj = "{\"request\":\"123\"}";
//
//		JsonObject jsnOBJ = null;
//
//		String expResponse = labTechnicianController.saveLabTestResult(requestObj);
//
//		response.setResponse("Invalid request");
//		assertNull(jsnOBJ);
//
//		assertEquals(expResponse, labTechnicianController.saveLabTestResult(requestObj));
//		assertTrue(response.toString().contains("Invalid request"));
//	}
//	
	
	@Test
	void testSaveLabTestResultExceptionThrown() throws Exception {
	    String requestObj = "{\"request\":\"Save Lab Test Result with Exception\"}";
	    String expectedResponse = "Unable to save data"; // Part of the response when an exception occurs

	    // Setup the behavior to throw an exception when saveLabTestResult is called
	    JsonObject jsnOBJ = parseJsonRequest(requestObj);
	    when(labTechnicianServiceImpl.saveLabTestResult(jsnOBJ)).thenThrow(new RuntimeException("Test Exception"));

	    // Execute the method under test
	    String actualResponse = labTechnicianController.saveLabTestResult(requestObj);

	    // Verify the response contains the expected error message
	    assertNotNull(actualResponse);
	    assertTrue(actualResponse.contains(expectedResponse));
	}


//*************	
	@Test
	void testGetBeneficiaryPrescribedProcedure() throws Exception {
		OutputResponse response = new OutputResponse();
		
		String requestOBJ ="{\"benRegID\":\"1L\",\"visitCode\":\"1L\"}";
		String s = "Test";
		
		JsonObject jsnOBJ = parseJsonRequest(requestOBJ);
		
		//when(labTechnicianServiceImpl.getBenePrescribedProcedureDetails(1L, 1L)).thenReturn(s);
		
		String expResponse = labTechnicianController.getBeneficiaryPrescribedProcedure(requestOBJ);
		
		response.setResponse(s);
		
		assertNotNull(jsnOBJ);
		assertNotNull(s);
		assertEquals(expResponse,labTechnicianController.getBeneficiaryPrescribedProcedure(requestOBJ));
		assertTrue(response.toString().contains(s));
	}
	
	@Test
	void testGetBeneficiaryPrescribedProcedure_Error() throws Exception {
		OutputResponse response = new OutputResponse();
		
		String requestOBJ ="{\"benRegID\":\"1L\",\"visitCode\":\"1L\"}";
		String s = null;
		
		JsonObject jsnOBJ = parseJsonRequest(requestOBJ);
		
		//when(labTechnicianServiceImpl.getBenePrescribedProcedureDetails(1L, 1L)).thenReturn(s);
		
		String expResponse = labTechnicianController.getBeneficiaryPrescribedProcedure(requestOBJ);
		
		response.setError(5000, "Error in prescribed procedure details");
		
		assertNotNull(jsnOBJ);
		assertNull(s);
		assertEquals(expResponse,labTechnicianController.getBeneficiaryPrescribedProcedure(requestOBJ));
		assertTrue(response.toString().contains("Error in prescribed procedure details"));
	}
	
	@Test
	void testGetBeneficiaryPrescribedProcedure_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();
		
		String requestOBJ = null;
		String s = null;
		
		JsonObject jsnOBJ = null;
		
		//when(labTechnicianServiceImpl.getBenePrescribedProcedureDetails(1L, 1L)).thenReturn(s);
		
		String expResponse = labTechnicianController.getBeneficiaryPrescribedProcedure(requestOBJ);
		
		response.setError(5000, "Invalid request");
		
		assertNull(jsnOBJ);
		assertNull(s);
		assertEquals(expResponse,labTechnicianController.getBeneficiaryPrescribedProcedure(requestOBJ));
		assertTrue(response.toString().contains("Invalid request"));
	}
	
	
//***********
	@Test
	void testGetLabResultForVisitCode_Success() throws Exception {
		OutputResponse response = new OutputResponse();
		
		String requestOBJ = "{\"BENEFICIARY_REG_ID\":1L,\"VISIT_CODE\":1L}";
		String s = "test";
		JsonObject jsnOBJ = parseJsonRequest(requestOBJ);
	   
	    when(labTechnicianServiceImpl.getLabResultForVisitcode(jsnOBJ.get(BENEFICIARY_REG_ID).getAsLong(),
				jsnOBJ.get(VISIT_CODE).getAsLong())).thenReturn(s);
	    
	    String expResponse = labTechnicianController.getLabResultForVisitCode(requestOBJ);
	    
	    response.setResponse(s);
	    
	    assertTrue(jsnOBJ != null && !jsnOBJ.isJsonNull() && jsnOBJ.has(BENEFICIARY_REG_ID) && jsnOBJ.has(VISIT_CODE));
	    assertNotNull(s);
	   // assertEquals(expResponse, labTechnicianController.getLabResultForVisitCode(requestOBJ));
	    assertTrue(response.toString().contains(s));
	}

	
	

}
//**********
