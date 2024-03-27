package com.iemr.mmu.service.quickConsultation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyShort;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.BenClinicalObservations;
import com.iemr.mmu.data.quickConsultation.ExternalLabTestOrder;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;
import com.iemr.mmu.data.tele_consultation.TCRequestModel;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;
import com.iemr.mmu.repo.quickConsultation.BenClinicalObservationsRepo;
import com.iemr.mmu.repo.quickConsultation.ExternalTestOrderRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.generalOPD.GeneralOPDDoctorServiceImpl;
import com.iemr.mmu.service.labtechnician.LabTechnicianServiceImpl;
import com.iemr.mmu.service.tele_consultation.TeleConsultationServiceImpl;

@ExtendWith(MockitoExtension.class)
class QuickConsultationServiceImplTest {
	@Mock
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;

	@Mock
	private GeneralOPDDoctorServiceImpl generalOPDDoctorServiceImpl;

	@Mock
	private BenChiefComplaintRepo benChiefComplaintRepo;
	@Mock
	private BenClinicalObservationsRepo benClinicalObservationsRepo;
	@Mock
	private PrescriptionDetailRepo prescriptionDetailRepo;
	@Mock
	private ExternalTestOrderRepo externalTestOrderRepo;
	@Mock
	private CommonNurseServiceImpl commonNurseServiceImpl;
	@Mock
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;
	@Mock
	private LabTechnicianServiceImpl labTechnicianServiceImpl;
	@Mock
	private CommonDoctorServiceImpl commonDoctorServiceImpl;
	@Mock
	private TeleConsultationServiceImpl teleConsultationServiceImpl;

	@InjectMocks
	private QuickConsultationServiceImpl quickConsultationService;

	private JsonObject convertStringToJson(String json) {
		return new JsonParser().parse(json).getAsJsonObject();
	}

//	@Test
//	void testSaveBeneficiaryChiefComplaint() {
//		fail("Not yet implemented");
//	}

	// SaveBeneficiaryChiefComplaint
	@Test
	void whenChiefComplaintsAreSuccessfullySaved_thenReturnOne() {
		// Simulate caseSheet JSON that would result in a non-empty BenChiefComplaint
		// list
		JsonObject caseSheet = new JsonObject();
		// Assuming you have a static method to populate this JsonObject based on your
		// logic

		ArrayList<BenChiefComplaint> mockComplaints = new ArrayList<>();
		mockComplaints.add(new BenChiefComplaint()); // Populate with at least one mock BenChiefComplaint

		// when(benChiefComplaintRepo.saveAll(any(List.class))).thenReturn(mockComplaints);

		Long result = quickConsultationService.saveBeneficiaryChiefComplaint(caseSheet);

		assertEquals(Long.valueOf(1), result);
	}

	@Test
	void whenNoChiefComplaints_thenReturnOne() {
		// Simulate caseSheet JSON that would result in an empty BenChiefComplaint list
		JsonObject caseSheet = new JsonObject();
		// Populate JsonObject accordingly

		Long result = quickConsultationService.saveBeneficiaryChiefComplaint(caseSheet);

		assertEquals(Long.valueOf(1), result);
	}

//	@Test
//	void testSaveBeneficiaryChiefComplaintWithNonEmptyList() {
//		fail("Not yet implemented");
//	}

	// SaveBeneficiaryChiefComplaintWithNonEmptyList

//	@Test
//	void testSaveBeneficiaryClinicalObservations() {
//		fail("Not yet implemented");
//	}

	// testSaveBeneficiaryClinicalObservations()
	@Test
	void shouldSaveWithValidSnomedCTCodes() throws Exception {
		String jsonInput = "{\"otherSymptoms\":\"Cough\"}";
		JsonObject caseSheet = convertStringToJson(jsonInput);

		BenClinicalObservations observations = new BenClinicalObservations();
		observations.setOtherSymptoms("Cough");
		observations.setClinicalObservationID(1L);

		String[] snomedCTCodes = { "12345", "Cough Term" };
		when(commonDoctorServiceImpl.getSnomedCTcode("Cough")).thenReturn(snomedCTCodes);
		when(benClinicalObservationsRepo.save(any(BenClinicalObservations.class))).thenReturn(observations);

		Long result = quickConsultationService.saveBeneficiaryClinicalObservations(caseSheet);
		assertEquals(1L, result);
	}

	@Test
	void shouldReturnNullWhenSaveFails() throws Exception {
		String jsonInput = "{\"otherSymptoms\":\"Fever\"}";
		JsonObject caseSheet = convertStringToJson(jsonInput);

		when(commonDoctorServiceImpl.getSnomedCTcode("Fever")).thenReturn(new String[] { "67890", "Fever Term" });
		when(benClinicalObservationsRepo.save(any(BenClinicalObservations.class))).thenReturn(null);

		Long result = quickConsultationService.saveBeneficiaryClinicalObservations(caseSheet);
		assertNull(result);
	}

	// saveBeneficiaryClinicalObservations

	@Test
	void whenClinicalObservationsWithSnomedCTCodes_thenReturnId() throws Exception {
		JsonObject caseSheet = new JsonObject();
		caseSheet.addProperty("otherSymptoms", "Cough");

		BenClinicalObservations mockObservations = new BenClinicalObservations();
		mockObservations.setClinicalObservationID(1L); // Assuming ID is set after saving

		String[] snomedCTCodes = { "12345", "Cough" };

		when(commonDoctorServiceImpl.getSnomedCTcode(any(String.class))).thenReturn(snomedCTCodes);
		when(benClinicalObservationsRepo.save(any(BenClinicalObservations.class))).thenReturn(mockObservations);

		Long result = quickConsultationService.saveBeneficiaryClinicalObservations(caseSheet);

		assertEquals(Long.valueOf(1), result);
	}

	@Test
	void whenClinicalObservationsWithoutSnomedCTCodes_thenReturnId() throws Exception {
		JsonObject caseSheet = new JsonObject();
		caseSheet.addProperty("otherSymptoms", "Cough");

		BenClinicalObservations mockObservations = new BenClinicalObservations();
		mockObservations.setClinicalObservationID(2L);

		when(commonDoctorServiceImpl.getSnomedCTcode(any(String.class))).thenReturn(null);
		when(benClinicalObservationsRepo.save(any(BenClinicalObservations.class))).thenReturn(mockObservations);

		Long result = quickConsultationService.saveBeneficiaryClinicalObservations(caseSheet);

		assertEquals(Long.valueOf(2), result);
	}

	@Test
	void whenSaveOperationFails_thenReturnNull() throws Exception {
		JsonObject caseSheet = new JsonObject();
		caseSheet.addProperty("otherSymptoms", "Cough");

		when(commonDoctorServiceImpl.getSnomedCTcode(any(String.class))).thenReturn(new String[] { "12345", "Cough" });
		when(benClinicalObservationsRepo.save(any(BenClinicalObservations.class))).thenReturn(null);

		Long result = quickConsultationService.saveBeneficiaryClinicalObservations(caseSheet);

		assertNull(result);
	}

//	@Test
//	void testSaveBenPrescriptionForANC() {
//		fail("Not yet implemented");
//	}

	// testSaveBenPrescriptionForANC
	@Test
	void whenPrescriptionSavedSuccessfully_thenReturnsPrescriptionId() {
		// Arrange
		PrescriptionDetail prescription = new PrescriptionDetail();
		prescription.setPrescriptionID(1L); // Assuming setter method exists

		when(prescriptionDetailRepo.save(any(PrescriptionDetail.class))).thenReturn(prescription);

		// Act
		Long result = quickConsultationService.saveBenPrescriptionForANC(prescription);

		// Assert
		assertNotNull(result);
		assertEquals(1L, result);
	}

	@Test
	void whenSaveOperationReturnsNull_thenReturnsNull() {
		// Arrange
		PrescriptionDetail prescription = new PrescriptionDetail();
		when(prescriptionDetailRepo.save(any(PrescriptionDetail.class))).thenReturn(null);

		// Act
		Long result = quickConsultationService.saveBenPrescriptionForANC(prescription);

		// Assert
		assertNull(result);
	}

	@Test
	void whenPrescriptionIdNotSetOrInvalid_thenReturnsNull() {
		// Arrange
		PrescriptionDetail prescription = new PrescriptionDetail();
		prescription.setPrescriptionID(0L); // Assuming setter method exists, and ID <= 0 is considered invalid

		when(prescriptionDetailRepo.save(any(PrescriptionDetail.class))).thenReturn(prescription);

		// Act
		Long result = quickConsultationService.saveBenPrescriptionForANC(prescription);

		// Assert
		assertNull(result);
	}

//	@Test
//	void testSaveBeneficiaryExternalLabTestOrderDetails() {
//		fail("Not yet implemented");
//	}

	// saveBeneficiaryExternalLabTestOrderDetails

//	@Test
//	void whenSaveExternalLabTestOrder_thenReturnId() {
//	    JsonObject caseSheet = new JsonObject(); // Assuming JsonObject setup is done correctly for your case
//	    ExternalLabTestOrder order = new ExternalLabTestOrder();
//	    order.setExternalTestOrderID(1L); // Assuming a successful ID return
//
//	    when(externalTestOrderRepo.save(any(ExternalLabTestOrder.class))).thenReturn(order);
//
//	    Long resultId = quickConsultationService.saveBeneficiaryExternalLabTestOrderDetails(caseSheet);
//	    assertNotNull(resultId);
//	    assertEquals(1L, resultId);
//	}

	@Test
	void whenSaveExternalLabTestOrderReturnsNull_thenResultIsNull() {
		JsonObject caseSheet = new JsonObject(); // Setup your JsonObject accordingly

		when(externalTestOrderRepo.save(any(ExternalLabTestOrder.class))).thenReturn(null);

		Long resultId = quickConsultationService.saveBeneficiaryExternalLabTestOrderDetails(caseSheet);
		assertNull(resultId);
	}

//	@Test
//	void whenSaveExternalLabTestOrderReturnsInvalidId_thenResultIsNull() {
//	    JsonObject caseSheet = new JsonObject(); // Properly setup JsonObject
//	    ExternalLabTestOrder order = new ExternalLabTestOrder();
//	    order.setExternalTestOrderID(0L); // Simulating an invalid ID
//
//	    when(externalTestOrderRepo.save(any(ExternalLabTestOrder.class))).thenReturn(order);
//
//	    Long resultId = quickConsultationService.saveBeneficiaryExternalLabTestOrderDetails(caseSheet);
//	    assertNull(resultId);
//	}

//	@Test
//	void testQuickConsultNurseDataInsert() {
//		fail("Not yet implemented");
//	}

	// quickConsultNurseDataInsert

	@Test
	void whenInputIsNull_thenResultIsZero() throws Exception {
		Integer result = quickConsultationService.quickConsultNurseDataInsert(null);
		assertEquals(0, result);
	}
	
	@Test
	void whenJsonObjHasNoVisitDetails_thenReturnsZero() throws Exception {
	    JsonObject jsnOBJ = new JsonObject();
	    Integer result = quickConsultationService.quickConsultNurseDataInsert(jsnOBJ);
	    assertEquals(0, result);
	}
	
//	@Test
//	void whenDataInsertionIsSuccessful_thenResultIsOne() throws Exception {
//		JsonObject jsnOBJ = new JsonObject();
//		JsonObject visitDetails = new JsonObject();
//		visitDetails.addProperty("key", "value"); // Add actual expected properties
//		jsnOBJ.add("visitDetails", visitDetails);
//
//		// Mock other necessary parts of the JsonObject as required by your method
//
//		// Mocking the dependencies
//		when(beneficiaryFlowStatusRepo.checkExistData(anyLong(), anyShort())).thenReturn(null);
//		when(commonNurseServiceImpl.getMaxCurrentdate(anyLong(), anyString(), anyString())).thenReturn(0);
//		when(commonNurseServiceImpl.saveBeneficiaryVisitDetails(any())).thenReturn(1L);
//		when(commonNurseServiceImpl.generateVisitCode(anyLong(), anyInt(), anyInt())).thenReturn(1L);
//		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(any())).thenReturn(1L);
//		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(any())).thenReturn(1L);
//
//		Integer result = quickConsultationService.quickConsultNurseDataInsert(jsnOBJ);
//		assertEquals(1, result);
//	}

//	@Test
//	void whenCheckExistDataReturnsNonNull_thenResultShouldBeZero() throws Exception {
//		// Setup JsonObject to pass required structure
//		JsonObject jsnOBJ = new JsonObject();
//		JsonObject visitDetails = new JsonObject();
//		// Assuming your method expects certain keys in visitDetails, populate them
//		// accordingly
//		visitDetails.addProperty("expectedKey", "expectedValue");
//		jsnOBJ.add("visitDetails", visitDetails);
//
//		// Setup mocks to simulate existing data, causing the method to abort further
//		// processing
//		BeneficiaryFlowStatus mockFlowStatus = new BeneficiaryFlowStatus(); // Assume an appropriate constructor or
//																			// builder pattern
//		when(beneficiaryFlowStatusRepo.checkExistData(anyLong(), anyShort())).thenReturn(mockFlowStatus);
//
//		// Call the method under test
//		Integer result = quickConsultationService.quickConsultNurseDataInsert(jsnOBJ);
//
//		// Verify the outcome for the scenario where data already exists
//		assertEquals(Integer.valueOf(0), result,
//				"Expected the method to return 0 indicating failure due to existing data");
//	}

//	@Test
//	void testQuickConsultDoctorDataInsert() {
//		fail("Not yet implemented");
//	}

	// QuickConsultDoctorDataInsert

//	@Test
//	void testQuickConsultDoctorDataInsertSuccessScenario() throws Exception {
//		JsonObject quickConsultDoctorOBJ = new JsonObject();
//		String authorization = "Bearer token";
//		// Configure your mocks and test data for a successful path
//
//		// Assuming certain methods to return specific values
//		when(commonDoctorServiceImpl.callTmForSpecialistSlotBook(any(), anyString())).thenReturn(1);
//		when(teleConsultationServiceImpl.createTCRequest(any())).thenReturn(1);
//		// Mock further interactions as per the method logic
//
//		// Execute the method
//		Integer result = quickConsultationService.quickConsultDoctorDataInsert(quickConsultDoctorOBJ, authorization);
//
//		// Asserts and verifications
//		assertEquals(1, result);
//		// Verify interactions with mocks
//	}

	@Test
	void testQuickConsultDoctorDataInsertFailureScenario() {
		JsonObject quickConsultDoctorOBJ = new JsonObject();
		String authorization = "Bearer token";
		// Test a failure scenario, for example, slot booking fails
		// when(commonDoctorServiceImpl.callTmForSpecialistSlotBook(any(),
		// anyString())).thenReturn(0);

		// You might expect an exception or a specific return value
		Exception exception = assertThrows(RuntimeException.class,
				() -> quickConsultationService.quickConsultDoctorDataInsert(quickConsultDoctorOBJ, authorization));

		// Further assertions or verifications
	}

//	@Test
//	void testGetBenDataFrmNurseToDocVisitDetailsScreen() {
//		fail("Not yet implemented");
//	}
//	
	// GetBenDataFrmNurseToDocVisitDetailsScreen

	@Test
	void testGetBenDataFrmNurseToDocVisitDetailsScreenWithValidData() throws Exception {
		Long benRegID = 1L;
		Long visitCode = 100L;
		BeneficiaryVisitDetail mockVisitDetail = mock(BeneficiaryVisitDetail.class);

		when(commonNurseServiceImpl.getCSVisitDetails(benRegID, visitCode)).thenReturn(mockVisitDetail);

		String result = quickConsultationService.getBenDataFrmNurseToDocVisitDetailsScreen(benRegID, visitCode);

		assertNotNull(result);
		assertTrue(result.contains("benVisitDetails"));

		verify(commonNurseServiceImpl).getCSVisitDetails(benRegID, visitCode);
	}

	@Test
	void testGetBenDataFrmNurseToDocVisitDetailsScreenWithNoData() throws Exception {
		Long benRegID = 1L;
		Long visitCode = 100L;

		when(commonNurseServiceImpl.getCSVisitDetails(benRegID, visitCode)).thenReturn(null);

		String result = quickConsultationService.getBenDataFrmNurseToDocVisitDetailsScreen(benRegID, visitCode);

		assertNotNull(result);
		assertEquals("{}", result);

		verify(commonNurseServiceImpl).getCSVisitDetails(benRegID, visitCode);
	}

//	@Test
//	void testGetBeneficiaryVitalDetails() {
//		fail("Not yet implemented");
//	}

	// GetBeneficiaryVitalDetails

//	@Test
//	void getBeneficiaryVitalDetailsWithValidData() {
//		Long beneficiaryRegID = 1L;
//		Long visitCode = 101L;
//		Object mockAnthropometryDetail = new Object(); // Suppose these are your custom object types
//		Object mockPhysicalVitalDetail = new Object();
//
//		when(commonNurseServiceImpl.getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID, visitCode))
//				.thenReturn((String) mockAnthropometryDetail);
//		when(commonNurseServiceImpl.getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, visitCode))
//				.thenReturn((String) mockPhysicalVitalDetail);
//
//		String result = quickConsultationService.getBeneficiaryVitalDetails(beneficiaryRegID, visitCode);
//
//		assertNotNull(result);
//		assertTrue(result.contains("benAnthropometryDetail"));
//		assertTrue(result.contains("benPhysicalVitalDetail"));
//
//		verify(commonNurseServiceImpl).getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID, visitCode);
//		verify(commonNurseServiceImpl).getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, visitCode);
//	}

	@Test
	void getBeneficiaryVitalDetailsWithNullData() {
		Long beneficiaryRegID = 2L;
		Long visitCode = 102L;

		when(commonNurseServiceImpl.getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID, visitCode))
				.thenReturn(null);
		when(commonNurseServiceImpl.getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, visitCode)).thenReturn(null);

		String result = quickConsultationService.getBeneficiaryVitalDetails(beneficiaryRegID, visitCode);

		assertNotNull(result);
		// Assuming toString() of a HashMap containing null values does not exclude
		// those keys
		assertTrue(result.contains("benAnthropometryDetail=null"));
		assertTrue(result.contains("benPhysicalVitalDetail=null"));

		verify(commonNurseServiceImpl).getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID, visitCode);
		verify(commonNurseServiceImpl).getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, visitCode);
	}

//	@Test
//	void testGetBenQuickConsultNurseData() {
//		fail("Not yet implemented");
//	}

	// testGetBenQuickConsultNurseData

	@Test
	void getBenQuickConsultNurseDataReturnsExpectedMapAsString() {
		Long benRegID = 1L;
		Long visitCode = 100L;
		String expectedVitalDetails = "{\"vitals\":\"expectedVitalDetails\"}";

		when(quickConsultationService.getBeneficiaryVitalDetails(benRegID, visitCode)).thenReturn(expectedVitalDetails);

		String result = quickConsultationService.getBenQuickConsultNurseData(benRegID, visitCode);

		assertNotNull(result);
		assertTrue(result.contains("vitals"));
		assertTrue(result.contains(expectedVitalDetails));

		//verify(quickConsultationService).getBeneficiaryVitalDetails(benRegID, visitCode);
	}

//	@Test
//	void testGetBenCaseRecordFromDoctorQuickConsult() {
//		fail("Not yet implemented");
//	}

	// testGetBenCaseRecordFromDoctorQuickConsult

	@Test
	void testGetBenCaseRecordFromDoctorQuickConsult() throws Exception {
		Long benRegID = 1L;
		Long visitCode = 101L;
		// Prepare your mock responses
		String findings = "Findings detail";
		String diagnosis = "Diagnosis detail";
		String investigation = "Investigation detail";
		String prescription = "Prescription detail";
		String labReport = "Lab Report detail";
		String archivedVisitCode = "Archived Visit code";

		when(commonDoctorServiceImpl.getFindingsDetails(benRegID, visitCode)).thenReturn(findings);
		when(generalOPDDoctorServiceImpl.getGeneralOPDDiagnosisDetails(benRegID, visitCode)).thenReturn(diagnosis);
		when(commonDoctorServiceImpl.getInvestigationDetails(benRegID, visitCode)).thenReturn(investigation);
		when(commonDoctorServiceImpl.getPrescribedDrugs(benRegID, visitCode)).thenReturn(prescription);
		// when(labTechnicianServiceImpl.getLabResultDataForBen(benRegID,
		// visitCode)).thenReturn(labReport);
		when(labTechnicianServiceImpl.getLast_3_ArchivedTestVisitList(benRegID, visitCode))
				.thenReturn(archivedVisitCode);

		// Call the method under test
		String result = quickConsultationService.getBenCaseRecordFromDoctorQuickConsult(benRegID, visitCode);

		// Assertions and Verifications
		assertNotNull(result);
		assertTrue(result.contains(findings));
		assertTrue(result.contains(diagnosis));
		assertTrue(result.contains(investigation));
		assertTrue(result.contains(prescription));
		// assertTrue(result.contains(labReport));
		assertTrue(result.contains(archivedVisitCode));

		verify(commonDoctorServiceImpl).getFindingsDetails(benRegID, visitCode);
		verify(generalOPDDoctorServiceImpl).getGeneralOPDDiagnosisDetails(benRegID, visitCode);
		verify(commonDoctorServiceImpl).getInvestigationDetails(benRegID, visitCode);
		verify(commonDoctorServiceImpl).getPrescribedDrugs(benRegID, visitCode);
		verify(labTechnicianServiceImpl).getLabResultDataForBen(benRegID, visitCode);
		verify(labTechnicianServiceImpl).getLast_3_ArchivedTestVisitList(benRegID, visitCode);
	}

//	@Test
//	void testUpdateGeneralOPDQCDoctorData() {
//		fail("Not yet implemented");
//	}

	// testUpdateGeneralOPDQCDoctorData

//	@Test
//	void testUpdateGeneralOPDQCDoctorData() throws Exception {
//		// Setup
//		Long expectedBenChiefComplaintID = 1L;
//		Integer expectedClinicalObservationID = 1;
//		Long expectedPrescriptionID = 1L;
//		Long expectedSuccessFlag = 1L;
//		JsonObject quickConsultDoctorOBJ = new JsonObject(); // Populate this as needed for the test
//		String Authorization = "Bearer someToken";
//
//		when(((QuickConsultationService) commonDoctorServiceImpl).saveBeneficiaryChiefComplaint(any(JsonObject.class)))
//				.thenReturn(expectedBenChiefComplaintID);
//		when(commonNurseServiceImpl.updatePrescription(any(PrescriptionDetail.class))).thenReturn(1); // Assume success
//		when(commonNurseServiceImpl.saveBenPrescribedDrugsList(anyList())).thenReturn(1); // Assume success
//		when(commonNurseServiceImpl.saveBeneficiaryLabTestOrderDetails(any(JsonObject.class), anyLong()))
//				.thenReturn(expectedSuccessFlag); // Assume success
//		when(teleConsultationServiceImpl.createTCRequest(any(TCRequestModel.class))).thenReturn(1); // Assume success
//
//		// Execute
//		Long resultFlag = quickConsultationService.updateGeneralOPDQCDoctorData(quickConsultDoctorOBJ, Authorization);
//
//		// Verify
//		assertNotNull(resultFlag);
//		assertEquals(expectedSuccessFlag, resultFlag);
//
//		//((QuickConsultationService) verify(commonDoctorServiceImpl, times(1))).saveBeneficiaryChiefComplaint(any(JsonObject.class));
//		verify(commonNurseServiceImpl, times(1)).updatePrescription(any(PrescriptionDetail.class));
//		verify(commonNurseServiceImpl, times(1)).saveBenPrescribedDrugsList(anyList());
//		verify(commonNurseServiceImpl, times(1)).saveBeneficiaryLabTestOrderDetails(any(JsonObject.class), anyLong());
//		verify(teleConsultationServiceImpl, times(1)).createTCRequest(any(TCRequestModel.class));
//		// Add more verifications as needed for each mocked call
//	}

//	@Test
//	void testUpdateBeneficiaryClinicalObservations() {
//		fail("Not yet implemented");
//	}

	@Test
	void testUpdateBeneficiaryClinicalObservations() throws Exception {
		// Prepare the JSON input as JsonObject
		JsonObject jsonInput = new JsonObject();
		jsonInput.addProperty("otherSymptoms", "Cough");

		// Mock expected behavior and interactions
		String[] snomedCTCodes = { "12345", "Cough" };
		when(commonDoctorServiceImpl.getSnomedCTcode(any(String.class))).thenReturn(snomedCTCodes);
		when(commonDoctorServiceImpl.updateBenClinicalObservations(any(BenClinicalObservations.class))).thenReturn(1);

		// Perform the action
		Integer result = quickConsultationService.updateBeneficiaryClinicalObservations(jsonInput);

		// Assert and verify
		assertEquals(Integer.valueOf(1), result);
		// Add more verifications if necessary
	}

}
