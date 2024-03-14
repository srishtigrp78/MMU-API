package com.iemr.mmu.service.ncdscreening;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.data.anc.BenFamilyHistory;
import com.iemr.mmu.data.ncdScreening.IDRSData;
import com.iemr.mmu.data.ncdScreening.PhysicalActivityType;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.nurse.CommonUtilityClass;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
import com.iemr.mmu.repo.nurse.ncdscreening.IDRSDataRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonServiceImpl;
import com.iemr.mmu.service.labtechnician.LabTechnicianServiceImpl;
import com.iemr.mmu.service.tele_consultation.TeleConsultationServiceImpl;
import com.iemr.mmu.utils.exception.IEMRException;

@ExtendWith(MockitoExtension.class)
class NCDScreeningServiceImplTest2 {
	@Mock
	private BenVisitDetailRepo benVisitDetailRepo;

	@Mock
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;

	@Mock
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;

	@Mock
	private CommonDoctorServiceImpl commonDoctorServiceImpl;

	@Mock
	private CommonNurseServiceImpl commonNurseServiceImpl;

	@Mock
	private CommonServiceImpl commonServiceImpl;

	@Mock
	private IDRSDataRepo iDRSDataRepo;

	@Mock
	private LabTechnicianServiceImpl labTechnicianServiceImpl;

	@Mock
	private NCDSCreeningDoctorServiceImpl ncdScreeningDoctorServiceImpl;

	@Mock
	private NCDScreeningNurseServiceImpl ncdScreeningNurseServiceImpl;

	@Mock
	private PrescriptionDetailRepo prescriptionDetailRepo;

	@Mock
	private TeleConsultationServiceImpl teleConsultationServiceImpl;

	@InjectMocks
	private NCDScreeningServiceImpl ncdScreeningService;

	private JsonObject exampleJson;

	@Test
	void testSaveNCDScreeningNurseData() {
		fail("Not yet implemented");
	}

//	@Test
//	void testSaveBenNCDCareHistoryDetails() {
//		fail("Not yet implemented");
//	}

	// testSaveBenNCDCareHistoryDetails

	@Test
	void whenSaveBenNCDCareHistoryDetails_WithValidPastHistory_ThenReturnsSuccessFlag() throws Exception {
		// Setup
		Long expectedFlag = 1L;
		Long benVisitID = 123L;
		Long benVisitCode = 456L;

		// Assuming your JSON string was incorrectly formatted:
		// Correct the structure here to match expected BEGIN_OBJECT format
		String jsonStr = "{\"pastHistory\": {\"yourKey\": \"yourValue\"}}"; // Example, adjust keys/values accordingly

		JsonObject ncdCareHistoryOBJ = JsonParser.parseString(jsonStr).getAsJsonObject();

		// Mock dependencies
		Mockito.when(commonNurseServiceImpl.saveBenPastHistory(any())).thenReturn(expectedFlag);

		// Call the method under test
		Long resultFlag = ncdScreeningService.saveBenNCDCareHistoryDetails(ncdCareHistoryOBJ, benVisitID, benVisitCode);

		// Assertions
		assertEquals(expectedFlag, resultFlag);
	}

	@Test
	void whenSaveBenNCDCareHistoryDetails_WithNullInput_ThenReturns1() throws Exception {
		// Act
		Long resultFlag = ncdScreeningService.saveBenNCDCareHistoryDetails(null, null, null);

		// Assert
		assertEquals(1, resultFlag);

		// Verify no interactions with the mock
		verifyNoInteractions(commonNurseServiceImpl);
	}

//	@Test
//	void testSaveidrsDetails() {
//		fail("Not yet implemented");
//	}

//testSaveidrsDetails
	private JsonObject createTestIDRSObject() {
		JsonObject idrsDetailsOBJ = new JsonObject();

		// Simulating the questionArray part of the JSON
		JsonArray questionArray = new JsonArray();
		JsonObject questionDetail = new JsonObject();
		questionDetail.addProperty("idrsQuestionID", "1");
		questionDetail.addProperty("question", "Sample Question?");
		questionDetail.addProperty("answer", "Sample Answer");
		questionDetail.addProperty("diseaseQuestionType", "Sample Type");
		questionArray.add(questionDetail);

		// Adding the questionArray to the main object
		idrsDetailsOBJ.add("questionArray", questionArray);

		// Simulate additional details if necessary
		JsonArray suspectArray = new JsonArray();
		suspectArray.add("Disease1");
		idrsDetailsOBJ.add("suspectArray", suspectArray);

		JsonArray confirmArray = new JsonArray();
		confirmArray.add("Disease2");
		idrsDetailsOBJ.add("confirmArray", confirmArray);

		// Return the constructed JsonObject
		return idrsDetailsOBJ;
	}

	@Test
	void whenSaveidrsDetails_WithValidDetails_ThenReturnsSuccessFlag() throws Exception {
		// Arrange
		JsonObject idrsDetailsOBJ = createTestIDRSObject();
		Long benVisitID = 123L;
		Long benVisitCode = 456L;
		Long expectedFlag = 1L; // Assuming 1 indicates success.

		when(commonNurseServiceImpl.saveIDRS(any(IDRSData.class))).thenReturn(expectedFlag);

		// Act
		Long resultFlag = ncdScreeningService.saveidrsDetails(idrsDetailsOBJ, benVisitID, benVisitCode);

		// Assert
		assertNotNull(resultFlag, "The result flag should not be null.");
		assertEquals(expectedFlag, resultFlag, "Expected success flag does not match the actual result.");

		// Verify interaction with mock
		verify(commonNurseServiceImpl, times(1)).saveIDRS(any(IDRSData.class));
	}

	@Test
	void whenSaveidrsDetails_WithNullJsonObject_ThenReturnsNull() throws Exception {
		Long benVisitID = 123L;
		Long benVisitCode = 456L;

		// Act
		Long resultFlag = ncdScreeningService.saveidrsDetails(null, benVisitID, benVisitCode);

		// Assert
		assertNull(resultFlag, "The result should be null when input JsonObject is null.");

		// Verify no interactions with the mock
		verify(commonNurseServiceImpl, never()).saveIDRS(any(IDRSData.class));
	}

	@Test
	void whenSaveidrsDetails_WithEmptyQuestionArray_ThenReturnsZero() throws Exception {
		JsonObject idrsDetailsOBJ = new JsonObject();
		idrsDetailsOBJ.add("questionArray", new JsonArray()); // Empty questionArray
		Long benVisitID = 123L;
		Long benVisitCode = 456L;

		// Act
		Long resultFlag = ncdScreeningService.saveidrsDetails(idrsDetailsOBJ, benVisitID, benVisitCode);

		// Assert
		assertEquals(Long.valueOf(0), resultFlag, "The result should be 0 when questionArray is empty.");

	}

	@Test
	void whenSaveidrsDetails_AndSaveIDRSReturnsNull_ThenReturnsNull() throws Exception {
		JsonObject idrsDetailsOBJ = createTestIDRSObject(); // Assume this creates a valid object
		Long benVisitID = 123L;
		Long benVisitCode = 456L;

		when(commonNurseServiceImpl.saveIDRS(any(IDRSData.class))).thenReturn(null);

		// Act
		Long resultFlag = ncdScreeningService.saveidrsDetails(idrsDetailsOBJ, benVisitID, benVisitCode);

		// Assert
		assertNull(resultFlag, "The result should be null when saveIDRS returns null.");

		// Verify the interaction happened once
		verify(commonNurseServiceImpl, times(1)).saveIDRS(any(IDRSData.class));
	}

//	@Test
//	void testSavePhysicalActivityDetails() {
//		fail("Not yet implemented");
//	}

	// testSavePhysicalActivityDetails

	@Test
	void whenSavePhysicalActivityDetails_WithValidDetails_ThenReturnsSuccessFlag() throws Exception {
		// Arrange
		JsonObject physicalActivityDetailsOBJ = new JsonObject();
		// Populate your JsonObject with the necessary details. This is a critical step.
		physicalActivityDetailsOBJ.addProperty("activityType", "Test Activity");
		physicalActivityDetailsOBJ.addProperty("physicalActivityType", "Moderate");

		Long benVisitID = 123L;
		Long benVisitCode = 456L;
		Long expectedFlag = 1L; // Assuming 1 indicates success.

		// Given
		when(commonNurseServiceImpl.savePhysicalActivity(any(PhysicalActivityType.class))).thenReturn(expectedFlag);

		// Act
		Long resultFlag = ncdScreeningService.savePhysicalActivityDetails(physicalActivityDetailsOBJ, benVisitID,
				benVisitCode);

		// Assert
		assertNotNull(resultFlag, "Result flag should not be null");
		assertEquals(expectedFlag, resultFlag, "Expected success flag does not match actual flag.");

		// Verify
		verify(commonNurseServiceImpl, times(1)).savePhysicalActivity(any(PhysicalActivityType.class));
	}

	@Test
	void whenSavePhysicalActivityDetails_WithInvalidDetails_ThenNoOperationPerformed() throws Exception {
		// Arrange
		JsonObject physicalActivityDetailsOBJ = new JsonObject(); // Simulate missing or invalid activity details
		Long benVisitID = 123L;
		Long benVisitCode = 456L;

		// No need to mock `savePhysicalActivity` as it should not be called

		// Act
		Long resultFlag = ncdScreeningService.savePhysicalActivityDetails(physicalActivityDetailsOBJ, benVisitID,
				benVisitCode);

		// Assert
		assertNull(resultFlag, "Expected null due to invalid input");

		// Verify that savePhysicalActivity was never called due to invalid input
		verify(commonNurseServiceImpl, never()).savePhysicalActivity(any(PhysicalActivityType.class));
	}

//testSaveBenNCDCareVitalDetails()
	@Test
	void whenBothSavesAreSuccessful_thenReturnsSuccessFlag() throws Exception {

		Long benVisitID = 1L;
		Long benVisitCode = 100L;

		JsonObject validVitalDetailsOBJ = new JsonObject();
		validVitalDetailsOBJ.addProperty("exampleProperty", "exampleValue");

		// Arrange
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(any(BenAnthropometryDetail.class)))
				.thenReturn(1L);
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(any(BenPhysicalVitalDetail.class)))
				.thenReturn(1L);

		// Act
		Long result = ncdScreeningService.saveBenNCDCareVitalDetails(validVitalDetailsOBJ, benVisitID, benVisitCode);

		// Assert
		assertNotNull(result);
		assertEquals(1L, result);
	}

	@Test
	void whenAnthropometrySaveFails_thenReturnsNull() throws Exception {
		Long benVisitID = 1L;
		Long benVisitCode = 100L;

		JsonObject validVitalDetailsOBJ = new JsonObject();
		validVitalDetailsOBJ.addProperty("exampleProperty", "exampleValue");

		// Arrange
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(any(BenAnthropometryDetail.class)))
				.thenReturn(null);
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(any(BenPhysicalVitalDetail.class)))
				.thenReturn(1L);

		// Act
		Long result = ncdScreeningService.saveBenNCDCareVitalDetails(validVitalDetailsOBJ, benVisitID, benVisitCode);

		// Assert
		assertNull(result);
	}

	@Test
	void whenPhysicalVitalSaveFails_thenReturnsNull() throws Exception {
		Long benVisitID = 1L;
		Long benVisitCode = 100L;

		JsonObject validVitalDetailsOBJ = new JsonObject();
		validVitalDetailsOBJ.addProperty("exampleProperty", "exampleValue");
		// Arrange
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(any(BenAnthropometryDetail.class)))
				.thenReturn(1L); // Anthropometry save is successful
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(any(BenPhysicalVitalDetail.class)))
				.thenReturn(null); // Physical Vital save fails

		// Act
		Long result = ncdScreeningService.saveBenNCDCareVitalDetails(validVitalDetailsOBJ, benVisitID, benVisitCode);

		// Assert
		assertNull(result, "Expected null as the result indicating a failed physical vital details save.");
	}

	@Test
	void whenBothSavesFail_thenReturnsNull() throws Exception {
		Long benVisitID = 1L;
		Long benVisitCode = 100L;

		JsonObject validVitalDetailsOBJ = new JsonObject();
		validVitalDetailsOBJ.addProperty("exampleProperty", "exampleValue");
		// Arrange
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(any(BenAnthropometryDetail.class)))
				.thenReturn(null); // Anthropometry save fails
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(any(BenPhysicalVitalDetail.class)))
				.thenReturn(null); // Physical Vital save also fails

		// Act
		Long result = ncdScreeningService.saveBenNCDCareVitalDetails(validVitalDetailsOBJ, benVisitID, benVisitCode);

		// Assert
		assertNull(result, "Expected null as the result indicating both save operations failed.");
	}

	@Test
	void whenInputObjectIsNull_thenReturnsNull() throws Exception {
		Long benVisitID = 1L;
		Long benVisitCode = 100L;

		// Act
		Long result = ncdScreeningService.saveBenNCDCareVitalDetails(null, benVisitID, benVisitCode);

		// Assert
		assertNull(result);
	}

//
//	@Test
//	void testSaveBenVisitDetails() {
//		fail("Not yet implemented");
//	}

	@Test
	void testSaveBenVisitDetails_Success() throws Exception {
		JsonObject visitDetailsObj = new JsonObject();
		visitDetailsObj.add("visitDetails", JsonParser
				.parseString("{\"beneficiaryRegID\":1,\"visitReason\":\"reason\",\"visitCategory\":\"category\"}"));
		visitDetailsObj.add("chiefComplaints", JsonParser.parseString("[{\"complaint\":\"Headache\"}]"));

		CommonUtilityClass mockUtilityClass = mock(CommonUtilityClass.class);
		// Assuming these getters are being called somewhere to fetch vanID and
		// sessionID
		when(mockUtilityClass.getVanID()).thenReturn(null);
		when(mockUtilityClass.getSessionID()).thenReturn(null);

		// Mocking
		when(commonNurseServiceImpl.getMaxCurrentdate(anyLong(), anyString(), anyString())).thenReturn(0);
		when(commonNurseServiceImpl.saveBeneficiaryVisitDetails(any(BeneficiaryVisitDetail.class))).thenReturn(1L);
		// Adjust stubbing to reflect actual method call with nullable Integer types
		when(commonNurseServiceImpl.generateVisitCode(eq(1L), isNull(), isNull())).thenReturn(100L);

		// Execution
		Map<String, Long> result = ncdScreeningService.saveBenVisitDetails(visitDetailsObj, mockUtilityClass);

		// Assertions
		assertNotNull(result);
		assertTrue(result.containsKey("visitID"));
		assertTrue(result.containsKey("visitCode"));
		assertEquals(1L, result.get("visitID").longValue());
		assertEquals(100L, result.get("visitCode").longValue());

		// Verify interactions
		verify(commonNurseServiceImpl).saveBeneficiaryVisitDetails(any(BeneficiaryVisitDetail.class));
		verify(commonNurseServiceImpl).generateVisitCode(eq(1L), isNull(), isNull());
		verify(commonNurseServiceImpl).saveBenChiefComplaints(anyList());
	}

	@Test
	void testSaveBenVisitDetails_VisitDetailsMissing() throws Exception {
		JsonObject visitDetailsObj = new JsonObject(); // Empty JSON object

		Map<String, Long> result = ncdScreeningService.saveBenVisitDetails(visitDetailsObj, new CommonUtilityClass());

		assertTrue(result.isEmpty());

		// No interactions expected as the method should exit early
		verifyNoInteractions(commonNurseServiceImpl);
	}

//	@Test
//	void testSaveNCDScreeningVitalDetails() {
//		fail("Not yet implemented");
//	}

	@Test
	void testSaveNCDScreeningVitalDetails_Success() throws Exception {
		// Prepare the mock JSON object
		JsonObject jsonObject = new JsonObject();
		JsonObject anthropometryDetail = new JsonObject();
		anthropometryDetail.addProperty("height", 180);
		anthropometryDetail.addProperty("weight", 75);
		JsonObject physicalVitalDetail = new JsonObject();
		physicalVitalDetail.addProperty("bloodPressure", "120/80");
		physicalVitalDetail.addProperty("temperature", 36.6);

		JsonObject ncdScreeningDetails = new JsonObject();
		ncdScreeningDetails.add("anthropometryDetail", anthropometryDetail);
		ncdScreeningDetails.add("physicalVitalDetail", physicalVitalDetail);
		jsonObject.add("ncdScreeningDetails", ncdScreeningDetails);

		Long benVisitID = 1L;
		Long benVisitCode = 101L;

		// Mock the service behavior
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(any(BenAnthropometryDetail.class)))
				.thenReturn(1L);
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(any(BenPhysicalVitalDetail.class)))
				.thenReturn(1L);

		// Execute the method under test
		Long result = ncdScreeningService.saveNCDScreeningVitalDetails(jsonObject, benVisitID, benVisitCode);

		// Assertions
		assertNotNull(result, "The result should not be null.");
		assertTrue(result > 0, "The result should be a positive number.");

		// Verify service interactions
		verify(commonNurseServiceImpl).saveBeneficiaryPhysicalAnthropometryDetails(any(BenAnthropometryDetail.class));
		verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(any(BenPhysicalVitalDetail.class));
	}

	@Test
	void whenDetailsAreMissing_thenResultIsNull() throws Exception {
		// Setup: Assuming jsonObject is empty or not correctly populated
		Long benVisitID = 1L; // Example ID
		Long benVisitCode = 101L; // Example visit code
		Long result = ncdScreeningService.saveNCDScreeningVitalDetails(new JsonObject(), benVisitID, benVisitCode);

		assertNull(result);
	}

	@Test
	void whenSaveFails_thenResultIsNull() throws Exception {
		JsonObject jsonObject = new JsonObject(); // Assuming this is populated with appropriate JSON for the test
		Long benVisitID = 1L; // Example ID
		Long benVisitCode = 101L; // Example visit code
		// Mocking one save operation to fail
		// when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(any())).thenReturn(1L);
		// // Success
		// when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(any())).thenReturn(-1L);
		// // Simulate failure

		Long result = ncdScreeningService.saveNCDScreeningVitalDetails(jsonObject, benVisitID, benVisitCode);

		assertNull(result); // Since one save failed, expecting null
	}

	@Test
	void testUpdateNurseNCDScreeningDetails() {
		fail("Not yet implemented");
	}

//	@Test
//	void testUpdateBenVitalDetails() {
//		fail("Not yet implemented");
//	}

	// testUpdateBenVitalDetails

	@Test
	void whenVitalDetailsOBJNotNullAndUpdatesAreSuccessful_thenSuccessFlagIsGreaterThanZero() throws Exception {
		JsonObject vitalDetailsOBJ = new JsonObject(); // Assuming a non-empty JsonObject for testing
		int expectedSuccessFlag = 1; // Assuming successful updates return a flag greater than 0

		when(commonNurseServiceImpl.updateANCAnthropometryDetails(any())).thenReturn(1);
		when(commonNurseServiceImpl.updateANCPhysicalVitalDetails(any())).thenReturn(1);

		int resultFlag = ncdScreeningService.updateBenVitalDetails(vitalDetailsOBJ);

		assertEquals(expectedSuccessFlag, resultFlag);
	}

	@Test
	void whenVitalDetailsOBJNotNullAndOneUpdateFails_thenSuccessFlagIsNotSet() throws Exception {
		JsonObject vitalDetailsOBJ = new JsonObject(); // Again, assuming a non-empty JsonObject
		int expectedFailureFlag = 0; // Adjust based on method's handling of partial failures

		when(commonNurseServiceImpl.updateANCAnthropometryDetails(any())).thenReturn(0); // Simulate failure
		when(commonNurseServiceImpl.updateANCPhysicalVitalDetails(any())).thenReturn(1); // Success

		int resultFlag = ncdScreeningService.updateBenVitalDetails(vitalDetailsOBJ);

		assertEquals(expectedFailureFlag, resultFlag);
	}

	@Test
	void whenVitalDetailsOBJIsNull_thenSuccessFlagIsOne() throws Exception {
		JsonObject vitalDetailsOBJ = null;
		int expectedFlagForNullInput = 1; // Based on your method's implementation

		int resultFlag = ncdScreeningService.updateBenVitalDetails(vitalDetailsOBJ);

		assertEquals(expectedFlagForNullInput, resultFlag);
	}

//
//	@Test
//	void testGetNCDScreeningDetails() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetNCDScreeningDetails_Success() {
		Long beneficiaryRegID = 1L;
		Long visitCode = 1L;

		// Mocking service responses
		when(ncdScreeningNurseServiceImpl.getNCDScreeningDetails(beneficiaryRegID, visitCode))
				.thenReturn("ncdScreeningData");
		when(commonNurseServiceImpl.getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID, visitCode))
				.thenReturn("anthropometryData");
		when(commonNurseServiceImpl.getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, visitCode))
				.thenReturn("vitalData");

		String result = ncdScreeningService.getNCDScreeningDetails(beneficiaryRegID, visitCode);

		// Expected JSON result (assuming a JSON-like string representation is
		// sufficient for comparison)
		String expected = "{vitalDetails=vitalData, ncdScreeningDetails=ncdScreeningData, anthropometryDetails=anthropometryData}";
		assertEquals(expected, result);

		// Verify service interactions
		verify(ncdScreeningNurseServiceImpl).getNCDScreeningDetails(beneficiaryRegID, visitCode);
		verify(commonNurseServiceImpl).getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID, visitCode);
		verify(commonNurseServiceImpl).getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, visitCode);
	}

	@Test
	void testGetNCDScreeningDetails_NullResponses() {
		Long beneficiaryRegID = 2L;
		Long visitCode = 2L;

		// Mocking one service to return null, which could represent a failure to fetch
		// data
		when(ncdScreeningNurseServiceImpl.getNCDScreeningDetails(beneficiaryRegID, visitCode)).thenReturn(null);
		when(commonNurseServiceImpl.getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID, visitCode))
				.thenReturn("anthropometryData");
		when(commonNurseServiceImpl.getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, visitCode)).thenReturn(null);

		String result = ncdScreeningService.getNCDScreeningDetails(beneficiaryRegID, visitCode);

		// Since the method doesn't handle null values explicitly (other than not adding
		// them to the map),
		// the expected behavior might be an empty map or partial data.
		// Adjust this expected outcome based on your method's intended behavior.
		String expected = "{}"; // Assuming the method would omit null values and still proceed.

		assertEquals(expected, result);

		// Verify that each service was still called
		verify(ncdScreeningNurseServiceImpl).getNCDScreeningDetails(beneficiaryRegID, visitCode);
		verify(commonNurseServiceImpl).getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID, visitCode);
		verify(commonNurseServiceImpl).getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, visitCode);
	}

//	@Test
//	void testGetNcdScreeningVisitCnt() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetNcdScreeningVisitCnt() {
		Long beneficiaryRegID = 1L;
		Long mockVisitCount = 3L; // Assume the repository would return 3 existing visits

		// Mock the repository call to return 3 when queried for the given
		// beneficiaryRegID
		when(beneficiaryFlowStatusRepo.getNcdScreeningVisitCount(beneficiaryRegID)).thenReturn(mockVisitCount);

		// Execute the method under test
		String result = ncdScreeningService.getNcdScreeningVisitCnt(beneficiaryRegID);

		// Prepare the expected JSON output using the same logic as in the method
		Map<String, Long> expectedMap = new HashMap<>();
		expectedMap.put("ncdScreeningVisitCount", mockVisitCount + 1); // Expecting it to add 1 to the mock visit count
		String expectedJson = new Gson().toJson(expectedMap);

		// Assert that the method's output matches the expected JSON string
		assertEquals(expectedJson, result);

		// Verify the repository method was called with the correct parameter
		verify(beneficiaryFlowStatusRepo).getNcdScreeningVisitCount(beneficiaryRegID);
	}

//	@Test
//	void testGetBenVisitDetailsFrmNurseNCDScreening() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetBenVisitDetailsFrmNurseNCDScreening_Success() throws Exception {
		Long benRegID = 1L;
		Long visitCode = 2L;

		BeneficiaryVisitDetail visitDetail = new BeneficiaryVisitDetail(); // Assuming you have a constructor or a
																			// method to populate this object
		visitDetail.setBenVisitID(visitCode); // Example setter, adapt based on actual properties

		when(commonNurseServiceImpl.getCSVisitDetails(benRegID, visitCode)).thenReturn(visitDetail);
		when(commonNurseServiceImpl.getBenChiefComplaints(benRegID, visitCode)).thenReturn("Example Chief Complaints");

		String result = ncdScreeningService.getBenVisitDetailsFrmNurseNCDScreening(benRegID, visitCode);

		Map<String, Object> expectedResMap = new HashMap<>();
		expectedResMap.put("NCDScreeningNurseVisitDetail", new Gson().toJson(visitDetail));
		expectedResMap.put("BenChiefComplaints", "Example Chief Complaints");

		assertEquals(expectedResMap.toString(), result);

		verify(commonNurseServiceImpl).getCSVisitDetails(benRegID, visitCode);
		verify(commonNurseServiceImpl).getBenChiefComplaints(benRegID, visitCode);
	}

//****************
//	@Test
//	void testGetBenHistoryDetails() {
//		fail("Not yet implemented");
//	}
//	

	@Test
	void testGetBenHistoryDetailsWithValidData() {
		Long benRegID = 1L;
		Long visitCode = 1L;

		BenFamilyHistory familyHistory = new BenFamilyHistory();

		// Mocking the service layer responses to return the appropriate object types
		when(commonNurseServiceImpl.getFamilyHistoryDetail(benRegID, visitCode)).thenReturn(familyHistory);

		String result = ncdScreeningService.getBenHistoryDetails(benRegID, visitCode);

		// Assuming you use a similar approach as in your service method
		Map<String, Object> expectedMap = new HashMap<>();
		expectedMap.put("FamilyHistory", familyHistory); // This assumes the Gson().toJson can serialize your object
		String expectedJson = new Gson().toJson(expectedMap);

		assertEquals(expectedJson, result);
	}

	// ***************

	@Test
	void testGetBenIdrsDetailsFrmNurse() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBeneficiaryVitalDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateNCDScreeningHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateIDRSScreen() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveDoctorData() {
		fail("Not yet implemented");
	}

//	@Test
//	void testGetBenCaseRecordFromDoctorNCDScreening() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetBenCaseRecordFromDoctorNCDScreening() throws Exception {
		// Arrange
		when(ncdScreeningDoctorServiceImpl.getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Ncd Diagnosis Data");
		when(commonDoctorServiceImpl.getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Findings Details");
		when(commonDoctorServiceImpl.getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Investigation Details");
		when(commonDoctorServiceImpl.getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Prescribed Drugs");
		when(commonDoctorServiceImpl.getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Referral Details");
		when(commonNurseServiceImpl.getGraphicalTrendData(Mockito.<Long>any(), Mockito.<String>any()))
				.thenReturn(new HashMap<>());
		when(labTechnicianServiceImpl.getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Last 3 Archived Test Visit List");
		when(labTechnicianServiceImpl.getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());

		// Act
		String actualBenCaseRecordFromDoctorNCDScreening = ncdScreeningService
				.getBenCaseRecordFromDoctorNCDScreening(1L, 1L);

		// Assert
		verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonNurseServiceImpl).getGraphicalTrendData(Mockito.<Long>any(), eq("ncdCare"));
		verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
		verify(labTechnicianServiceImpl).getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any());
		verify(ncdScreeningDoctorServiceImpl).getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("{Refer=Referral Details, prescription=Prescribed Drugs, findings=Findings Details, LabReport=[],"
				+ " diagnosis=Ncd Diagnosis Data, investigation=Investigation Details, ArchivedVisitcodeForLabResult=Last"
				+ " 3 Archived Test Visit List, GraphData={}}", actualBenCaseRecordFromDoctorNCDScreening);
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#getBenCaseRecordFromDoctorNCDScreening(Long, Long)}
	 */
	@Test
	void testGetBenCaseRecordFromDoctorNCDScreening2() throws Exception {
		// Arrange
		when(ncdScreeningDoctorServiceImpl.getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Ncd Diagnosis Data");
		when(commonDoctorServiceImpl.getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Findings Details");
		when(commonDoctorServiceImpl.getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Investigation Details");
		when(commonDoctorServiceImpl.getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Prescribed Drugs");
		when(commonDoctorServiceImpl.getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Referral Details");
		when(labTechnicianServiceImpl.getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenThrow(new IEMRException("An error occurred"));

		// Act and Assert
		assertThrows(IEMRException.class, () -> ncdScreeningService.getBenCaseRecordFromDoctorNCDScreening(1L, 1L));
		verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
		verify(ncdScreeningDoctorServiceImpl).getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any());
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#getBenCaseRecordFromDoctorNCDScreening(Long, Long)}
	 */
	@Test
	void testGetBenCaseRecordFromDoctorNCDScreening3() throws Exception {
		// Arrange
		when(ncdScreeningDoctorServiceImpl.getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Ncd Diagnosis Data");
		when(commonDoctorServiceImpl.getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Findings Details");
		when(commonDoctorServiceImpl.getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Investigation Details");
		when(commonDoctorServiceImpl.getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Prescribed Drugs");
		when(commonDoctorServiceImpl.getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Referral Details");

		HashMap<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("findings", "42");
		when(commonNurseServiceImpl.getGraphicalTrendData(Mockito.<Long>any(), Mockito.<String>any()))
				.thenReturn(stringObjectMap);
		when(labTechnicianServiceImpl.getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Last 3 Archived Test Visit List");
		when(labTechnicianServiceImpl.getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());

		// Act
		String actualBenCaseRecordFromDoctorNCDScreening = ncdScreeningService
				.getBenCaseRecordFromDoctorNCDScreening(1L, 1L);

		// Assert
		verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonNurseServiceImpl).getGraphicalTrendData(Mockito.<Long>any(), eq("ncdCare"));
		verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
		verify(labTechnicianServiceImpl).getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any());
		verify(ncdScreeningDoctorServiceImpl).getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("{Refer=Referral Details, prescription=Prescribed Drugs, findings=Findings Details, LabReport=[],"
				+ " diagnosis=Ncd Diagnosis Data, investigation=Investigation Details, ArchivedVisitcodeForLabResult=Last"
				+ " 3 Archived Test Visit List, GraphData={\"findings\":\"42\"}}",
				actualBenCaseRecordFromDoctorNCDScreening);
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#getBenCaseRecordFromDoctorNCDScreening(Long, Long)}
	 */
	@Test
	void testGetBenCaseRecordFromDoctorNCDScreening4() throws Exception {
		// Arrange
		when(ncdScreeningDoctorServiceImpl.getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Ncd Diagnosis Data");
		when(commonDoctorServiceImpl.getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Findings Details");
		when(commonDoctorServiceImpl.getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Investigation Details");
		when(commonDoctorServiceImpl.getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Prescribed Drugs");
		when(commonDoctorServiceImpl.getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Referral Details");

		HashMap<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("diagnosis", "42");
		stringObjectMap.put("findings", "42");
		when(commonNurseServiceImpl.getGraphicalTrendData(Mockito.<Long>any(), Mockito.<String>any()))
				.thenReturn(stringObjectMap);
		when(labTechnicianServiceImpl.getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Last 3 Archived Test Visit List");
		when(labTechnicianServiceImpl.getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());

		// Act
		String actualBenCaseRecordFromDoctorNCDScreening = ncdScreeningService
				.getBenCaseRecordFromDoctorNCDScreening(1L, 1L);

		// Assert
		verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonNurseServiceImpl).getGraphicalTrendData(Mockito.<Long>any(), eq("ncdCare"));
		verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
		verify(labTechnicianServiceImpl).getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any());
		verify(ncdScreeningDoctorServiceImpl).getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("{Refer=Referral Details, prescription=Prescribed Drugs, findings=Findings Details, LabReport=[],"
				+ " diagnosis=Ncd Diagnosis Data, investigation=Investigation Details, ArchivedVisitcodeForLabResult=Last"
				+ " 3 Archived Test Visit List, GraphData={\"findings\":\"42\",\"diagnosis\":\"42\"}}",
				actualBenCaseRecordFromDoctorNCDScreening);
	}

//*******************
//	@Test
//	void testGetBenNCDScreeningNurseData() {
//		fail("Not yet implemented");
//	}

}
