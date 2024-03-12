package com.iemr.mmu.service.common.transaction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iemr.mmu.data.anc.WrapperAncFindings;
import com.iemr.mmu.data.anc.WrapperBenInvestigationANC;
import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.data.doctor.BenReferDetails;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.BenClinicalObservations;
import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
import com.iemr.mmu.data.snomedct.SCTDescription;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.doctor.BenReferDetailsRepo;
import com.iemr.mmu.repo.doctor.DocWorkListRepo;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;
import com.iemr.mmu.repo.quickConsultation.BenClinicalObservationsRepo;
import com.iemr.mmu.repo.quickConsultation.LabTestOrderDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescribedDrugDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.service.snomedct.SnomedServiceImpl;

@ExtendWith(MockitoExtension.class)
class CommonDoctorServiceImplTest {

	@Mock
	private BenClinicalObservationsRepo benClinicalObservationsRepo;
	@Mock
	private BenChiefComplaintRepo benChiefComplaintRepo;
	@Mock
	private DocWorkListRepo docWorkListRepo;
	@Mock
	private BenReferDetailsRepo benReferDetailsRepo;
	@Mock
	private LabTestOrderDetailRepo labTestOrderDetailRepo;
	@Mock
	private PrescribedDrugDetailRepo prescribedDrugDetailRepo;
	@Mock
	private PrescriptionDetailRepo prescriptionDetailRepo;
	@Mock
	private SnomedServiceImpl snomedServiceImpl;
	@Mock
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;
	@Mock
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;

	@InjectMocks
	CommonDoctorServiceImpl commonDoctorService;

	@Test
	void testSaveFindings() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	void testSaveDocFindings_AllSavedSuccessfully() {
		WrapperAncFindings wrapperAncFindings = new WrapperAncFindings(null, null, null, null, null, null, null, null,
				null);
		// Mocking successful save of clinical observations
		when(benClinicalObservationsRepo.save(any(BenClinicalObservations.class)))
				.thenReturn(new BenClinicalObservations()); // Assuming default constructor

		// Preparing test data for chief complaints
		ArrayList<BenChiefComplaint> complaints = new ArrayList<>();
		BenChiefComplaint complaint = new BenChiefComplaint();
		complaint.setChiefComplaint("Test Complaint");
		complaints.add(complaint);
		wrapperAncFindings.setComplaints(complaints);

		// Mocking successful save of chief complaints
		when(benChiefComplaintRepo.saveAll(anyList())).thenReturn(complaints);

		Integer result = commonDoctorService.saveDocFindings(wrapperAncFindings);

		assertEquals(1, result);
	}

	@Test
	void testSaveDocFindings_NoValidChiefComplaints() {
		WrapperAncFindings wrapperAncFindings = new WrapperAncFindings(null, null, null, null, null, null, null, null,
				null);
		// Assume clinical observations are saved successfully
		when(benClinicalObservationsRepo.save(any(BenClinicalObservations.class)))
				.thenReturn(new BenClinicalObservations());

		// No valid chief complaints
		wrapperAncFindings.setComplaints(new ArrayList<>()); // Empty list

		Integer result = commonDoctorService.saveDocFindings(wrapperAncFindings);

		assertEquals(1, result);
	}



	@Test
	void testGetSnomedCTcode_whenRequestStringIsNull_thenExpectEmptyArray() {
		String[] result = commonDoctorService.getSnomedCTcode(null);
		assertArrayEquals(new String[] { "", "" }, result);

		result = commonDoctorService.getSnomedCTcode("");
		assertArrayEquals(new String[] { "", "" }, result);
	}

	@Test
	void testGetSnomedCTcode_whenSingleSymptomMatches_thenExpectMatchingIdsAndTerms() {
		String requestString = "cough";
		when(snomedServiceImpl.findSnomedCTRecordFromTerm("cough")).thenReturn(new SCTDescription("123456", "Cough"));

		String[] result = commonDoctorService.getSnomedCTcode(requestString);

		assertArrayEquals(new String[] { "123456", "Cough" }, result);
	}

	@Test
	void testGetSnomedCTcode_whenMultipleSymptomsMatch_thenExpectMatchingIdsAndTerms() {
		String requestString = "cough,fever";
		when(snomedServiceImpl.findSnomedCTRecordFromTerm("cough")).thenReturn(new SCTDescription("123456", "Cough"));
		when(snomedServiceImpl.findSnomedCTRecordFromTerm("fever")).thenReturn(new SCTDescription("789012", "Fever"));

		String[] result = commonDoctorService.getSnomedCTcode(requestString);

		assertArrayEquals(new String[] { "123456,789012", "Cough,Fever" }, result);
	}

	@Test
	void testGetSnomedCTcode_whenMultipleSymptomsSomeMatch_thenExpectMixedResults() {
		String requestString = "cough,unknown";
		when(snomedServiceImpl.findSnomedCTRecordFromTerm("cough")).thenReturn(new SCTDescription("123456", "Cough"));
		when(snomedServiceImpl.findSnomedCTRecordFromTerm("unknown")).thenReturn(null);

		String[] result = commonDoctorService.getSnomedCTcode(requestString);

		assertArrayEquals(new String[] { "123456,N/A", "Cough,N/A" }, result);
	}

	@Test
	void testGetSnomedCTcode_whenNoSymptomsMatch_thenExpectNAForAll() {
		String requestString = "unknown1,unknown2";
		when(snomedServiceImpl.findSnomedCTRecordFromTerm("unknown1")).thenReturn(null);
		when(snomedServiceImpl.findSnomedCTRecordFromTerm("unknown2")).thenReturn(null);

		String[] result = commonDoctorService.getSnomedCTcode(requestString);

		assertArrayEquals(new String[] { "N/A,N/A", "N/A,N/A" }, result);
	}

	@Test
	void testGetDocWorkList() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDocWorkListNew() {
		fail("Not yet implemented");
	}



	@Test
	void testGetDocWorkListNewFutureScheduledForTM_whenServiceIDIsFour_ShouldReturnJson() {
		Integer providerServiceMapId = 1;
		Integer serviceID = 4;
		List<BeneficiaryFlowStatus> mockResult = new ArrayList<>();
		// Assuming BeneficiaryFlowStatus has a no-args constructor
		mockResult.add(new BeneficiaryFlowStatus());

		when(beneficiaryFlowStatusRepo.getDocWorkListNewFutureScheduledTC(providerServiceMapId))
				.thenReturn((ArrayList<BeneficiaryFlowStatus>) mockResult);

		String result = commonDoctorService.getDocWorkListNewFutureScheduledForTM(providerServiceMapId, serviceID);

		assertNotNull(result);
		assertEquals(new Gson().toJson(mockResult), result);

		verify(beneficiaryFlowStatusRepo, times(1)).getDocWorkListNewFutureScheduledTC(providerServiceMapId);
	}

	@Test
	void testGetDocWorkListNewFutureScheduledForTM_whenServiceIDIsNullOrNotFour_ShouldReturnEmptyJson() {
		Integer providerServiceMapId = 1;
		// Test with serviceID null
		String resultWithNullServiceID = commonDoctorService.getDocWorkListNewFutureScheduledForTM(providerServiceMapId,
				null);
		assertEquals("[]", resultWithNullServiceID);

		// Test with serviceID not equal to 4
		Integer serviceIDNotFour = 3; // or any number that is not 4
		String resultWithServiceIDNotFour = commonDoctorService
				.getDocWorkListNewFutureScheduledForTM(providerServiceMapId, serviceIDNotFour);
		assertEquals("[]", resultWithServiceIDNotFour);

		// Verify repository was never called
		verify(beneficiaryFlowStatusRepo, never()).getDocWorkListNewFutureScheduledTC(anyInt());
	}

	@Test
	void testGetTCSpecialistWorkListNewForTM_whenServiceIDIsFour_ShouldReturnJson() {
		Integer providerServiceMapId = 1;
		Integer userID = 2; // Example userID
		Integer serviceID = 4;
		List<BeneficiaryFlowStatus> mockResult = new ArrayList<>();
		mockResult.add(new BeneficiaryFlowStatus()); // Assume default constructor

		when(beneficiaryFlowStatusRepo.getTCSpecialistWorkListNew(providerServiceMapId, userID))
				.thenReturn((ArrayList<BeneficiaryFlowStatus>) mockResult);

		String result = commonDoctorService.getTCSpecialistWorkListNewForTM(providerServiceMapId, userID, serviceID);

		assertNotNull(result);
		assertEquals(new Gson().toJson(mockResult), result);

		verify(beneficiaryFlowStatusRepo).getTCSpecialistWorkListNew(providerServiceMapId, userID);
	}

	@Test
	void testGetTCSpecialistWorkListNewForTM_whenServiceIDIsNullOrNotFour_ShouldReturnEmptyJson() {
		Integer providerServiceMapId = 1;
		Integer userID = 2;

		// Test with serviceID null
		String resultWithNullServiceID = commonDoctorService.getTCSpecialistWorkListNewForTM(providerServiceMapId,
				userID, null);
		assertEquals("[]", resultWithNullServiceID);

		// Test with serviceID not equal to 4
		Integer serviceIDNotFour = 3; // Any number other than 4
		String resultWithServiceIDNotFour = commonDoctorService.getTCSpecialistWorkListNewForTM(providerServiceMapId,
				userID, serviceIDNotFour);
		assertEquals("[]", resultWithServiceIDNotFour);

		// Ensure the repository method was never called
		verify(beneficiaryFlowStatusRepo, never()).getTCSpecialistWorkListNew(anyInt(), anyInt());
	}

	@Test
	void testGetTCSpecialistWorkListNewFutureScheduledForTM_whenServiceIDIsFour_ShouldReturnJson() {
		Integer providerServiceMapId = 1;
		Integer userID = 2; // Example userID
		Integer serviceID = 4;
		List<BeneficiaryFlowStatus> mockResult = new ArrayList<>();
		mockResult.add(new BeneficiaryFlowStatus()); // Assume a default constructor or mock

		when(beneficiaryFlowStatusRepo.getTCSpecialistWorkListNewFutureScheduled(providerServiceMapId, userID))
				.thenReturn((ArrayList<BeneficiaryFlowStatus>) mockResult);

		String result = commonDoctorService.getTCSpecialistWorkListNewFutureScheduledForTM(providerServiceMapId, userID,
				serviceID);

		assertNotNull(result);
		assertEquals(new Gson().toJson(mockResult), result);

		verify(beneficiaryFlowStatusRepo).getTCSpecialistWorkListNewFutureScheduled(providerServiceMapId, userID);
	}

	@Test
	void testGetTCSpecialistWorkListNewFutureScheduledForTM_whenServiceIDIsNullOrNotFour_ShouldReturnEmptyJson() {
		Integer providerServiceMapId = 1;
		Integer userID = 2;

		// Testing with serviceID null
		String resultWithNullServiceID = commonDoctorService
				.getTCSpecialistWorkListNewFutureScheduledForTM(providerServiceMapId, userID, null);
		assertEquals("[]", resultWithNullServiceID);

		// Testing with serviceID not equal to 4
		Integer serviceIDNotFour = 3; // or any other number that's not 4
		String resultWithServiceIDNotFour = commonDoctorService
				.getTCSpecialistWorkListNewFutureScheduledForTM(providerServiceMapId, userID, serviceIDNotFour);
		assertEquals("[]", resultWithServiceIDNotFour);

		// Verifying that the repository method was never called in these scenarios
		verify(beneficiaryFlowStatusRepo, never()).getTCSpecialistWorkListNewFutureScheduled(anyInt(), anyInt());
	}

	@Test
	void testFetchBenPreviousSignificantFindings() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenReferDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenReferDetailsTMreferred() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFindingsDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testGetInvestigationDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPrescribedDrugs() {
		fail("Not yet implemented");
	}

	@Test
	void testGetReferralDetails() {
		fail("Not yet implemented");
	}

	@Test
	void getReferralDetails_WithData_ReturnsJson() {
		// Arrange
		Long beneficiaryRegID = 1L;
		Long visitCode = 100L;
		Object[] mockData = { /*
								 * Mock the data structure returned by the repo, e.g., new Object[]{1, "data1",
								 * "data2"}
								 */ };
		ArrayList<Object[]> resList = new ArrayList<>();

		// Assume BenReferDetails.getBenReferDetails successfully creates an instance
		BenReferDetails referDetails = new BenReferDetails(); // Mocked data structure
		// Customize the setup as needed
		// referDetails.setSomeField("someValue");

		when(benReferDetailsRepo.getBenReferDetails(beneficiaryRegID, visitCode)).thenReturn(resList);
		// Static mock setup if needed. For example, using Mockito or PowerMock to mock
		// the static method.

		// Act
		String result = commonDoctorService.getReferralDetails(beneficiaryRegID, visitCode);

		// Assert
		assertNotNull(result);
		// Further assertions can be made based on the expected JSON structure.
	}



	@Test
	void testUpdateDocFindings() {
		fail("Not yet implemented");
	}

	@Test
	void updateDoctorBenChiefComplaints_WithNonEmptyList_ReturnsSize() {
		// Arrange
		BenChiefComplaint complaint = new BenChiefComplaint(); // Assuming a constructor or builder pattern
		List<BenChiefComplaint> complaintsList = Arrays.asList(complaint, complaint);
		when(benChiefComplaintRepo.saveAll(complaintsList)).thenReturn(complaintsList);

		// Act
		int result = commonDoctorService.updateDoctorBenChiefComplaints(complaintsList);

		// Assert
		assertEquals(2, result);
		verify(benChiefComplaintRepo, times(1)).saveAll(complaintsList);
	}

	@Test
	void updateDoctorBenChiefComplaints_WithEmptyList_ReturnsOne() {
		// Arrange
		List<BenChiefComplaint> complaintsList = Collections.emptyList();

		// Act
		int result = commonDoctorService.updateDoctorBenChiefComplaints(complaintsList);

		// Assert
		assertEquals(1, result);
		verify(benChiefComplaintRepo, never()).saveAll(anyList());
	}

	@Test
	void updateDoctorBenChiefComplaints_WithNullList_ReturnsOne() {
		// Act
		int result = commonDoctorService.updateDoctorBenChiefComplaints(null);

		// Assert
		assertEquals(1, result);
		verify(benChiefComplaintRepo, never()).saveAll(any());
	}

	@Test
	void testUpdateBenClinicalObservations() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenReferDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenFlowtableAfterDocDataSave() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenFlowtableAfterDocDataUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDeletePrescribedMedicine_SuccessfulDeletion_ReturnsSuccessMessage() throws JSONException {
		// Arrange
		JSONObject obj = new JSONObject();
		obj.put("id", 123L);

		when(prescribedDrugDetailRepo.deletePrescribedmedicine(123L)).thenReturn(1);

		// Act
		String result = commonDoctorService.deletePrescribedMedicine(obj);

		// Assert
		assertEquals("record deleted successfully", result);
		verify(prescribedDrugDetailRepo, times(1)).deletePrescribedmedicine(123L);
	}

	@Test
	void testDeletePrescribedMedicine_UnsuccessfulDeletion_ReturnsNull() throws JSONException {
		// Arrange
		JSONObject obj = new JSONObject();
		obj.put("id", 123L);

		when(prescribedDrugDetailRepo.deletePrescribedmedicine(123L)).thenReturn(0);

		// Act
		String result = commonDoctorService.deletePrescribedMedicine(obj);

		// Assert
		assertEquals(null, result);
		verify(prescribedDrugDetailRepo, times(1)).deletePrescribedmedicine(123L);
	}

	@Test
	void testDeletePrescribedMedicine_MissingId_ReturnsNull() {
		// Arrange
		JSONObject obj = new JSONObject();

		// Act
		String result = commonDoctorService.deletePrescribedMedicine(obj);

		// Assert
		assertEquals(null, result);
		verify(prescribedDrugDetailRepo, never()).deletePrescribedmedicine(anyLong());
	}

	@Test
	void testCallTmForSpecialistSlotBook() {
		fail("Not yet implemented");
	}

}
