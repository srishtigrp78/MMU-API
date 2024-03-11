package com.iemr.mmu.service.common.transaction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.google.gson.Gson;
import com.iemr.mmu.data.anc.BenFamilyHistory;
import com.iemr.mmu.data.anc.PhyGeneralExamination;
import com.iemr.mmu.data.anc.PhyHeadToToeExamination;
import com.iemr.mmu.data.anc.SysCardiovascularExamination;
import com.iemr.mmu.data.anc.SysCentralNervousExamination;
import com.iemr.mmu.data.anc.SysGastrointestinalExamination;
import com.iemr.mmu.data.anc.SysGenitourinarySystemExamination;
import com.iemr.mmu.data.anc.SysMusculoskeletalSystemExamination;
import com.iemr.mmu.data.anc.SysRespiratoryExamination;
import com.iemr.mmu.data.ncdScreening.IDRSData;
import com.iemr.mmu.data.ncdScreening.PhysicalActivityType;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.bmiCalculation.BMICalculationRepo;
import com.iemr.mmu.repo.nurse.BenAnthropometryRepo;
import com.iemr.mmu.repo.nurse.BenCancerVitalDetailRepo;
import com.iemr.mmu.repo.nurse.BenPhysicalVitalRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
import com.iemr.mmu.repo.nurse.anc.BenAdherenceRepo;
import com.iemr.mmu.repo.nurse.anc.BenAllergyHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenChildDevelopmentHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenFamilyHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenMedHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenMedicationHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenMenstrualDetailsRepo;
import com.iemr.mmu.repo.nurse.anc.BenPersonalHabitRepo;
import com.iemr.mmu.repo.nurse.anc.BencomrbidityCondRepo;
import com.iemr.mmu.repo.nurse.anc.ChildFeedingDetailsRepo;
import com.iemr.mmu.repo.nurse.anc.ChildOptionalVaccineDetailRepo;
import com.iemr.mmu.repo.nurse.anc.ChildVaccineDetail1Repo;
import com.iemr.mmu.repo.nurse.anc.FemaleObstetricHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.PerinatalHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.PhyGeneralExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.PhyHeadToToeExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysCardiovascularExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysCentralNervousExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysGastrointestinalExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysGenitourinarySystemExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysMusculoskeletalSystemExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysRespiratoryExaminationRepo;
import com.iemr.mmu.repo.nurse.ncdscreening.IDRSDataRepo;
import com.iemr.mmu.repo.nurse.ncdscreening.PhysicalActivityTypeRepo;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;
import com.iemr.mmu.repo.quickConsultation.LabTestOrderDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescribedDrugDetailRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenData;
import com.iemr.mmu.repo.registrar.ReistrarRepoBenSearch;
import com.iemr.mmu.utils.AESEncryption.AESEncryptionDecryption;
import com.iemr.mmu.utils.exception.IEMRException;

@ExtendWith(MockitoExtension.class)
class CommonNurseServiceImplTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Mock
	private BenVisitDetailRepo benVisitDetailRepo;
	@Mock
	private BenChiefComplaintRepo benChiefComplaintRepo;
	@Mock
	private BenMedHistoryRepo benMedHistoryRepo;
	@Mock
	private BencomrbidityCondRepo bencomrbidityCondRepo;
	@Mock
	private BenMedicationHistoryRepo benMedicationHistoryRepo;
	@Mock
	private FemaleObstetricHistoryRepo femaleObstetricHistoryRepo;
	@Mock
	private BenMenstrualDetailsRepo benMenstrualDetailsRepo;
	@Mock
	private BenFamilyHistoryRepo benFamilyHistoryRepo;
	@Mock
	private BenPersonalHabitRepo benPersonalHabitRepo;
	@Mock
	private BenAllergyHistoryRepo benAllergyHistoryRepo;
	@Mock
	private ChildOptionalVaccineDetailRepo childOptionalVaccineDetailRepo;
	@Mock
	private ChildVaccineDetail1Repo childVaccineDetail1Repo;
	@Mock
	private BenAnthropometryRepo benAnthropometryRepo;
	@Mock
	private BenPhysicalVitalRepo benPhysicalVitalRepo;
	@Mock
	private PhyGeneralExaminationRepo phyGeneralExaminationRepo;
	@Mock
	private PhyHeadToToeExaminationRepo phyHeadToToeExaminationRepo;
	@Mock
	private SysGastrointestinalExaminationRepo sysGastrointestinalExaminationRepo;
	@Mock
	private SysCardiovascularExaminationRepo sysCardiovascularExaminationRepo;
	@Mock
	private SysRespiratoryExaminationRepo sysRespiratoryExaminationRepo;
	@Mock
	private SysCentralNervousExaminationRepo sysCentralNervousExaminationRepo;
	@Mock
	private SysMusculoskeletalSystemExaminationRepo sysMusculoskeletalSystemExaminationRepo;
	@Mock
	private SysGenitourinarySystemExaminationRepo sysGenitourinarySystemExaminationRepo;
	@Mock
	private RegistrarRepoBenData registrarRepoBenData;
	@Mock
	private PrescriptionDetailRepo prescriptionDetailRepo;
	@Mock
	private LabTestOrderDetailRepo labTestOrderDetailRepo;
	@Mock
	private PrescribedDrugDetailRepo prescribedDrugDetailRepo;
	@Mock
	private ReistrarRepoBenSearch reistrarRepoBenSearch;
	@Mock
	private BenAdherenceRepo benAdherenceRepo;
	@Mock
	private BenChildDevelopmentHistoryRepo benChildDevelopmentHistoryRepo;
	@Mock
	private ChildFeedingDetailsRepo childFeedingDetailsRepo;
	@Mock
	private PerinatalHistoryRepo perinatalHistoryRepo;
	@Mock
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
	@Mock
	private BenCancerVitalDetailRepo benCancerVitalDetailRepo;
	@Mock
	private CommonDoctorServiceImpl commonDoctorServiceImpl;
	@Mock
	private PhysicalActivityTypeRepo physicalActivityTypeRepo;
	@Mock
	private AESEncryptionDecryption aESEncryptionDecryption;
	@Mock
	private IDRSDataRepo iDRSDataRepo;
	@Mock
	private BMICalculationRepo bmiCalculationRepo;

	@InjectMocks
	CommonNurseServiceImpl commonNurseService;

	@Test
	void testUpdateBeneficiaryStatus() {
		Character c = 'a';
		Long benRegID = 1L;
		Integer i = 1;

		when(registrarRepoBenData.updateBenFlowStatus(c, benRegID)).thenReturn(i);

		int expResponse = commonNurseService.updateBeneficiaryStatus(c, benRegID);

		assertEquals(expResponse, commonNurseService.updateBeneficiaryStatus(c, benRegID));
	}

	@Test
	void testSaveBeneficiaryVisitDetails() {
		BeneficiaryVisitDetail beneficiaryVisitDetail = new BeneficiaryVisitDetail();

		BeneficiaryVisitDetail response = null;
		Short benVisitCount = 1;

		when(benVisitDetailRepo.getVisitCountForBeneficiary(beneficiaryVisitDetail.getBeneficiaryRegID()))
				.thenReturn(benVisitCount);

		benVisitCount = (short) (benVisitCount + 1);

		Long expResponse = commonNurseService.saveBeneficiaryVisitDetails(beneficiaryVisitDetail);

		response = benVisitDetailRepo.save(beneficiaryVisitDetail);

		assertTrue(benVisitCount != null && benVisitCount >= 0);

		assertEquals(expResponse, commonNurseService.saveBeneficiaryVisitDetails(beneficiaryVisitDetail));
	}

//	@Test
//	void testGetMaxCurrentdate() throws IEMRException {
//		Long beneficiaryRegID = 1L;
//		String visitreason = "Test";
//		String visitcategory = "A";
//
//		String maxDate = "test";
//
//		when(benVisitDetailRepo.getMaxCreatedDate(beneficiaryRegID, visitreason, visitcategory)).thenReturn(maxDate);
//
//		int i = 0;
//	}

	@Test
	void testGetMaxCurrentdate_whenMaxDateIsNullThenReturnZero() throws IEMRException {
		when(benVisitDetailRepo.getMaxCreatedDate(1L, "reason", "category")).thenReturn(null);

		int result = commonNurseService.getMaxCurrentdate(1L, "reason", "category");
		assertEquals(0, result);
	}

	@Test
	void testGetMaxCurrentdate_whenMaxDateIsBeforeCurrentThenReturnNegative() throws IEMRException {
		// Assuming the current date is after "2023-03-06 10:00:00"
		when(benVisitDetailRepo.getMaxCreatedDate(1L, "reason", "category")).thenReturn("2023-03-06 09:45:00.0");

		int result = commonNurseService.getMaxCurrentdate(1L, "reason", "category");
		assertEquals(-1, result);
	}

//	@Test
//	void testGetMaxCurrentdate_whenMaxDateIsAfterCurrentThenReturnPositive() throws IEMRException, ParseException {
//		// Mock current date to a fixed date for the test
//		DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Calendar fixedCurrentDate = Calendar.getInstance();
//		fixedCurrentDate.setTime(timeFormat.parse("2023-03-06 10:00:00"));
//
//		// Use Reflection or adjust your method to allow injecting a fixed current date
//		// for testing
//		// This step depends on how your service is designed
//
//		when(benVisitDetailRepo.getMaxCreatedDate(1L, "reason", "category")).thenReturn("2023-03-06 09:55:00.0");
//
//		int result = commonNurseService.getMaxCurrentdate(1L, "reason", "category");
//		assertEquals(1, result); // Assuming your service logic adjusts to the mocked current date
//	}
//
//	@Test
//	void whenParseExceptionThenThrowIEMRException() {
//		when(benVisitDetailRepo.getMaxCreatedDate(1L, "reason", "category")).thenReturn("invalid-date-format");
//
//		assertThrows(IEMRException.class, () -> commonNurseService.getMaxCurrentdate(1L, "reason", "category"));
//	}

	@Test
	void testGenerateVisitCode() {
		fail("Not yet implemented");
	}

	@Test
	void testGenerateVisitCode_whenUpdateSucceeds_ReturnGeneratedVisitCode() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateVisitCodeInVisitDetailsTable() {
		Long visitCode = 1L;
		Long visitID = 1L;
		int i = 1;

		when(benVisitDetailRepo.updateVisitCode(visitCode, visitID)).thenReturn(i);
		int expResponse = commonNurseService.updateVisitCodeInVisitDetailsTable(visitCode, visitID);
		assertEquals(expResponse, commonNurseService.updateVisitCodeInVisitDetailsTable(visitCode, visitID));
	}

	@Test
	void testGetBenVisitCount_Success() {
		Long benRegID = 1L;
		Short benVisitCount = 1;

		when(benVisitDetailRepo.getVisitCountForBeneficiary(benRegID)).thenReturn(benVisitCount);

		benVisitCount = (short) (benVisitCount + 1);

		Short expResponse = commonNurseService.getBenVisitCount(benRegID);

		assertTrue(benVisitCount != null && benVisitCount >= 0);
		assertEquals(expResponse, commonNurseService.getBenVisitCount(benRegID));
	}

	@Test
	void testGetBenVisitCount_False() {
		Long benRegID = 1L;
		Short benVisitCount = 0;

		when(benVisitDetailRepo.getVisitCountForBeneficiary(benRegID)).thenReturn(benVisitCount);

		benVisitCount = 1;

		Short expResponse = commonNurseService.getBenVisitCount(benRegID);

		assertTrue(benVisitCount == 0);
		assertEquals(expResponse, commonNurseService.getBenVisitCount(benRegID));
	}

	@Test
	void testUpdateBeneficiaryVisitDetails() {
		BeneficiaryVisitDetail beneficiaryVisitDetail = new BeneficiaryVisitDetail();

		beneficiaryVisitDetail.setVisitReasonID((short) 1);
		beneficiaryVisitDetail.setVisitReason("X");
		beneficiaryVisitDetail.setVisitCategoryID(1);
		beneficiaryVisitDetail.setVisitCategory("Y");
		beneficiaryVisitDetail.setPregnancyStatus("OK");
		beneficiaryVisitDetail.setrCHID("Z");
		beneficiaryVisitDetail.setHealthFacilityType("A");
		beneficiaryVisitDetail.setHealthFacilityLocation("B");
		beneficiaryVisitDetail.setModifiedBy("user1");
		beneficiaryVisitDetail.setBenVisitID(1L);

		beneficiaryVisitDetail.toString();

		int response = 0;

		when(benVisitDetailRepo.updateBeneficiaryVisitDetail(beneficiaryVisitDetail.getVisitReasonID(),
				beneficiaryVisitDetail.getVisitReason(), beneficiaryVisitDetail.getVisitCategoryID(),
				beneficiaryVisitDetail.getVisitCategory(), beneficiaryVisitDetail.getPregnancyStatus(),
				beneficiaryVisitDetail.getrCHID(), beneficiaryVisitDetail.getHealthFacilityType(),
				beneficiaryVisitDetail.getHealthFacilityLocation(), beneficiaryVisitDetail.getModifiedBy(),
				beneficiaryVisitDetail.getBenVisitID())).thenReturn(response);

		int expResponse = commonNurseService.updateBeneficiaryVisitDetails(beneficiaryVisitDetail);

		assertEquals(expResponse, commonNurseService.updateBeneficiaryVisitDetails(beneficiaryVisitDetail));
	}

	@Test
	void testUpdateBeneficiaryVisitDetails_Exception() {
	}

	@Test
	void testGetCSVisitDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenChiefComplaints() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenPastHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenComorbidConditions() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenMedicationHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveFemaleObstetricHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenMenstrualHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenFamilyHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testSavePersonalHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveAllergyHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveChildOptionalVaccineDetail() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveImmunizationHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBeneficiaryPhysicalAnthropometryDetails() {
		BenAnthropometryDetail benAnthropometryDetail = new BenAnthropometryDetail();
		benAnthropometryDetail.setID(1L);

		BenAnthropometryDetail response = new BenAnthropometryDetail();

		when(benAnthropometryRepo.save(benAnthropometryDetail)).thenReturn(response);

		Long expResponse = commonNurseService.saveBeneficiaryPhysicalAnthropometryDetails(benAnthropometryDetail);

		assertEquals(expResponse,
				commonNurseService.saveBeneficiaryPhysicalAnthropometryDetails(benAnthropometryDetail));
	}

	@Test
	void testSaveBeneficiaryPhysicalVitalDetails() {
		fail("Not yet implemented");
	}

//	@Test
//	void testGetBeneficiaryPhysicalAnthropometryDetails() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetBeneficiaryPhysicalAnthropometryDetails() {
		Long beneficiaryRegID = 1L;
		Long visitCode = 101L;
		BenAnthropometryDetail expectedDetail = new BenAnthropometryDetail();
		expectedDetail.setID(1L); // Setup the expected object (populate it as needed)

		// Configure the mock to return the expected object when the method is called
		when(benAnthropometryRepo.getBenAnthropometryDetail(beneficiaryRegID, visitCode)).thenReturn(expectedDetail);

		// Execute the method under test
		String jsonResult = commonNurseService.getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID, visitCode);

		// Verify the behavior and the output
		assertNotNull(jsonResult, "The result should not be null");
		// You can add more detailed checks here to validate the JSON structure/content
		verify(benAnthropometryRepo, times(1)).getBenAnthropometryDetail(beneficiaryRegID, visitCode); // Ensure
																										// interaction
																										// expected
	}

//	@Test
//	void testGetBeneficiaryPhysicalVitalDetails() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetBeneficiaryPhysicalVitalDetails() {
		Long beneficiaryRegID = 1L;
		Long visitCode = 101L;
		BenPhysicalVitalDetail expectedDetail = new BenPhysicalVitalDetail();
		expectedDetail.setID(1L); // Mock the expected behavior

		// Configure Mockito to return the expected detail when the repo method is
		// called
		when(benPhysicalVitalRepo.getBenPhysicalVitalDetail(beneficiaryRegID, visitCode)).thenReturn(expectedDetail);

		// Call the method under test
		String resultJson = commonNurseService.getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, visitCode);

		// Assert the results
		assertNotNull(resultJson, "Resulting JSON should not be null");
		// Here, you could further assert that the JSON contains the expected values,
		// using a library like Jackson or Gson for parsing if necessary

		// Verify that the repo method was called exactly once with the expected
		// parameters
		verify(benPhysicalVitalRepo, times(1)).getBenPhysicalVitalDetail(beneficiaryRegID, visitCode);
	}

//	@Test
//	void testUpdateANCAnthropometryDetails() {
//		fail("Not yet implemented");
//	}

	@Test
	void testUpdateANCAnthropometryDetails_WithNullDetail() {
		int result = commonNurseService.updateANCAnthropometryDetails(null);
		assertEquals(0, result, "Expected result to be 0 when input is null");
	}

//	@Test
//	void testUpdateANCAnthropometryDetails_WithStatusN() {
//		BenAnthropometryDetail detail = mock(BenAnthropometryDetail.class);
//		when(detail.getBeneficiaryRegID()).thenReturn(1L);
//		when(detail.getVisitCode()).thenReturn(1L);
//		when(benAnthropometryRepo.getBenAnthropometryStatus(anyLong(), anyLong())).thenReturn("N");
//
//		when(benAnthropometryRepo.updateANCCareDetails(anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyDouble(),
//				anyDouble(), anyDouble(), anyDouble(), anyString(), eq("N"), anyLong(), anyLong())).thenReturn(1);
//
//		int result = commonNurseService.updateANCAnthropometryDetails(detail);
//
//		assertEquals(1, result);
//		verify(benAnthropometryRepo).updateANCCareDetails(anyDouble(), anyDouble(), anyDouble(), anyDouble(),
//				anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyString(), eq("N"), anyLong(), anyLong());
//	}
//
//
//	@Test
//	void testUpdateANCAnthropometryDetailsWithStatusProcessed() {
//		BenAnthropometryDetail detail = mock(BenAnthropometryDetail.class);
//		when(detail.getBeneficiaryRegID()).thenReturn(1L);
//		when(detail.getVisitCode()).thenReturn(1L);
//		when(benAnthropometryRepo.getBenAnthropometryStatus(anyLong(), anyLong())).thenReturn("Processed");
//
//		when(benAnthropometryRepo.updateANCCareDetails(anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyDouble(),
//				anyDouble(), anyDouble(), anyDouble(), anyString(), eq("U"), anyLong(), anyLong())).thenReturn(1);
//
//		int result = commonNurseService.updateANCAnthropometryDetails(detail);
//
//		assertEquals(1, result);
//		verify(benAnthropometryRepo).updateANCCareDetails(anyDouble(), anyDouble(), anyDouble(), anyDouble(),
//				anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyString(), eq("U"), anyLong(), anyLong());
//	}

//**********
	@Test
	void testSaveIDRS_Success() {
		IDRSData idrsDetail = new IDRSData(); // Assuming IDRSData has a setter for ID or is set through the constructor
		idrsDetail.setId(1L); // Assuming there's a method to set the ID, adjust according to your actual
								// class

		when(iDRSDataRepo.save(any(IDRSData.class))).thenReturn(idrsDetail);

		Long result = commonNurseService.saveIDRS(new IDRSData());

		assertNotNull(result);
		assertEquals(1L, result);
	}

	@Test
	void testSaveIDRS_Failure() {
		when(iDRSDataRepo.save(any(IDRSData.class))).thenReturn(null);

		Long result = commonNurseService.saveIDRS(new IDRSData());

		assertNull(result);
	}

	@Test
	void testSavePhysicalActivity_Success() {
		PhysicalActivityType physicalActivityDetail = new PhysicalActivityType();
		physicalActivityDetail.setpAID(1L); // Assuming a setter for ID

		when(physicalActivityTypeRepo.save(any(PhysicalActivityType.class))).thenReturn(physicalActivityDetail);

		Long result = commonNurseService.savePhysicalActivity(new PhysicalActivityType());

		assertNotNull(result);
		assertEquals(1L, result, "The returned ID should match the expected value.");
	}

	@Test
	void testSavePhysicalActivity_Failure() {
		when(physicalActivityTypeRepo.save(any(PhysicalActivityType.class))).thenReturn(null);

		Long result = commonNurseService.savePhysicalActivity(new PhysicalActivityType());

		assertNull(result, "The method should return null when save operation fails.");
	}

	@Test
	void testSaveBenFamilyHistoryNCDScreening_SaveNonEmptyFamilyHistory_Success() {
		BenFamilyHistory benFamilyHistory = mock(BenFamilyHistory.class);
		ArrayList<BenFamilyHistory> familyHistoryList = new ArrayList<>(
				Arrays.asList(new BenFamilyHistory(), new BenFamilyHistory()));
		when(benFamilyHistory.getBenFamilyHist()).thenReturn(familyHistoryList);
		when(benFamilyHistoryRepo.saveAll(familyHistoryList)).thenReturn(familyHistoryList); // Simulate successful save

		Long result = commonNurseService.saveBenFamilyHistoryNCDScreening(benFamilyHistory);

		assertEquals(Long.valueOf(1), result, "Expected success flag to be 1");
	}

	@Test
	void testSaveBenFamilyHistoryNCDScreening_SaveNonEmptyFamilyHistory_PartialSuccess() {
		BenFamilyHistory benFamilyHistory = mock(BenFamilyHistory.class);
		ArrayList<BenFamilyHistory> inputList = new ArrayList<>(
				Arrays.asList(new BenFamilyHistory(), new BenFamilyHistory()));
		ArrayList<BenFamilyHistory> resultList = new ArrayList<>(Arrays.asList(new BenFamilyHistory())); // Simulate
																											// partial
																											// save
																											// success

		when(benFamilyHistory.getBenFamilyHist()).thenReturn(inputList);
		when(benFamilyHistoryRepo.saveAll(inputList)).thenReturn(resultList);

		Long result = commonNurseService.saveBenFamilyHistoryNCDScreening(benFamilyHistory);

		assertNull(result, "Expected null due to partial save success");
	}

	@Test
	void testSaveBenFamilyHistoryNCDScreening_SaveEmptyFamilyHistory() {
		BenFamilyHistory benFamilyHistory = mock(BenFamilyHistory.class);
		ArrayList<BenFamilyHistory> familyHistoryList = new ArrayList<>();
		when(benFamilyHistory.getBenFamilyHist()).thenReturn(familyHistoryList);

		Long result = commonNurseService.saveBenFamilyHistoryNCDScreening(benFamilyHistory);

		assertEquals(Long.valueOf(1), result, "Expected success flag to be 1 for empty list");
	}

	@Test
	void testUpdateANCPhysicalVitalDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testSavePhyGeneralExamination_WithDangerSigns() {
		PhyGeneralExamination generalExamination = new PhyGeneralExamination();
		generalExamination.setTypeOfDangerSigns(Arrays.asList("Sign1", "Sign2"));

		PhyGeneralExamination savedExamination = new PhyGeneralExamination();
		savedExamination.setID(1L);
		when(phyGeneralExaminationRepo.save(any(PhyGeneralExamination.class))).thenReturn(savedExamination);

		Long resultID = commonNurseService.savePhyGeneralExamination(generalExamination);

		assertNotNull(resultID);
		assertEquals(1L, resultID);
		verify(phyGeneralExaminationRepo, times(1)).save(any(PhyGeneralExamination.class));
	}

	@Test
	void testSavePhyGeneralExamination_WithNullDangerSigns() {
		PhyGeneralExamination generalExamination = new PhyGeneralExamination();
		generalExamination.setTypeOfDangerSigns(null);

		PhyGeneralExamination savedExamination = new PhyGeneralExamination();
		savedExamination.setID(2L);
		when(phyGeneralExaminationRepo.save(any(PhyGeneralExamination.class))).thenReturn(savedExamination);

		Long resultID = commonNurseService.savePhyGeneralExamination(generalExamination);

		assertNotNull(resultID);
		assertEquals(2L, resultID);
		verify(phyGeneralExaminationRepo, times(1)).save(any(PhyGeneralExamination.class));
	}

	@Test
	void testSavePhyGeneralExamination_WithEmptyDangerSigns() {
		PhyGeneralExamination generalExamination = new PhyGeneralExamination();
		generalExamination.setTypeOfDangerSigns(new ArrayList<>());

		PhyGeneralExamination savedExamination = new PhyGeneralExamination();
		savedExamination.setID(3L);
		when(phyGeneralExaminationRepo.save(any(PhyGeneralExamination.class))).thenReturn(savedExamination);

		Long resultID = commonNurseService.savePhyGeneralExamination(generalExamination);

		assertNotNull(resultID);
		assertEquals(3L, resultID);
		verify(phyGeneralExaminationRepo, times(1)).save(any(PhyGeneralExamination.class));
	}

	@Test
	void testSavePhyHeadToToeExamination_Success() {
		PhyHeadToToeExamination headToToeExamination = new PhyHeadToToeExamination();
		// Set properties for headToToeExamination if necessary

		PhyHeadToToeExamination savedExamination = new PhyHeadToToeExamination();
		savedExamination.setID(1L); // Assuming the ID is set by the repository upon saving
		when(phyHeadToToeExaminationRepo.save(any(PhyHeadToToeExamination.class))).thenReturn(savedExamination);

		Long resultID = commonNurseService.savePhyHeadToToeExamination(headToToeExamination);

		assertNotNull(resultID);
		assertEquals(1L, resultID);
		verify(phyHeadToToeExaminationRepo, times(1)).save(any(PhyHeadToToeExamination.class));
	}

	@Test
	void testSavePhyHeadToToeExamination_Failure() {
		PhyHeadToToeExamination headToToeExamination = new PhyHeadToToeExamination();
		// Set properties for headToToeExamination if necessary

		when(phyHeadToToeExaminationRepo.save(any(PhyHeadToToeExamination.class))).thenReturn(null);

		Long resultID = commonNurseService.savePhyHeadToToeExamination(headToToeExamination);

		assertNull(resultID);
		verify(phyHeadToToeExaminationRepo, times(1)).save(any(PhyHeadToToeExamination.class));
	}

	@Test
	void testSaveSysGastrointestinalExamination_Success() {
		SysGastrointestinalExamination gastrointestinalExamination = new SysGastrointestinalExamination();
		// Configure your object as necessary

		SysGastrointestinalExamination savedExamination = new SysGastrointestinalExamination();
		savedExamination.setID(1L); // Mocking the behavior of setting an ID upon successful save

		when(sysGastrointestinalExaminationRepo.save(any(SysGastrointestinalExamination.class)))
				.thenReturn(savedExamination);

		Long returnedId = commonNurseService.saveSysGastrointestinalExamination(gastrointestinalExamination);

		assertNotNull(returnedId, "The returned ID should not be null.");
		assertEquals(1L, returnedId, "The returned ID should match the expected value.");
		verify(sysGastrointestinalExaminationRepo, times(1)).save(any(SysGastrointestinalExamination.class));
	}

	@Test
	void testSaveSysGastrointestinalExamination_Failure() {
		SysGastrointestinalExamination gastrointestinalExamination = new SysGastrointestinalExamination();
		// Configure your object as necessary

		when(sysGastrointestinalExaminationRepo.save(any(SysGastrointestinalExamination.class))).thenReturn(null);

		Long returnedId = commonNurseService.saveSysGastrointestinalExamination(gastrointestinalExamination);

		assertNull(returnedId, "The returned ID should be null upon failure.");
		verify(sysGastrointestinalExaminationRepo, times(1)).save(any(SysGastrointestinalExamination.class));
	}

	@Test
	void testSaveSysCardiovascularExamination_Success() {
		SysCardiovascularExamination cardiovascularExamination = new SysCardiovascularExamination();
		// Configure your object as necessary

		SysCardiovascularExamination savedExamination = new SysCardiovascularExamination();
		savedExamination.setID(1L); // Simulate setting ID upon successful save

		when(sysCardiovascularExaminationRepo.save(any(SysCardiovascularExamination.class)))
				.thenReturn(savedExamination);

		Long returnedId = commonNurseService.saveSysCardiovascularExamination(cardiovascularExamination);

		assertNotNull(returnedId, "The returned ID should not be null.");
		assertEquals(1L, returnedId, "The returned ID should match the expected value.");
		verify(sysCardiovascularExaminationRepo, times(1)).save(any(SysCardiovascularExamination.class));
	}

	@Test
	void testSaveSysCardiovascularExamination_Failure() {
		SysCardiovascularExamination cardiovascularExamination = new SysCardiovascularExamination();
		// Configure your object as necessary

		when(sysCardiovascularExaminationRepo.save(any(SysCardiovascularExamination.class))).thenReturn(null);

		Long returnedId = commonNurseService.saveSysCardiovascularExamination(cardiovascularExamination);

		assertNull(returnedId, "The returned ID should be null upon failure.");
		verify(sysCardiovascularExaminationRepo, times(1)).save(any(SysCardiovascularExamination.class));
	}

//	@Test
//	void testSaveSysRespiratoryExamination() {
//		fail("Not yet implemented");
//	}

	@Test
	void testSaveSysRespiratoryExamination_whenSaveSuccess_thenReturnsNonNullId() {
		SysRespiratoryExamination examination = new SysRespiratoryExamination();
		SysRespiratoryExamination savedExamination = new SysRespiratoryExamination();
		savedExamination.setID(1L); // Assuming the ID is set after saving

		when(sysRespiratoryExaminationRepo.save(any(SysRespiratoryExamination.class))).thenReturn(savedExamination);

		Long resultId = commonNurseService.saveSysRespiratoryExamination(examination);

		assertNotNull(resultId, "ID should not be null on successful save");
		assertEquals(1L, resultId, "The saved ID should match the expected value.");
	}

	@Test
	void testSaveSysRespiratoryExamination_whenSaveFails_thenReturnsNullId() {
		SysRespiratoryExamination examination = new SysRespiratoryExamination();

		when(sysRespiratoryExaminationRepo.save(any(SysRespiratoryExamination.class))).thenReturn(null);

		Long resultId = commonNurseService.saveSysRespiratoryExamination(examination);

		assertNull(resultId, "ID should be null when save operation fails");
	}

	@Test
	void testSaveSysCentralNervousExamination_whenSaveSuccess_thenReturnsNonNullId() {
		SysCentralNervousExamination examination = new SysCentralNervousExamination();
		SysCentralNervousExamination savedExamination = new SysCentralNervousExamination();
		savedExamination.setID(1L); // Assume an ID is assigned upon saving

		when(sysCentralNervousExaminationRepo.save(any(SysCentralNervousExamination.class)))
				.thenReturn(savedExamination);

		Long resultId = commonNurseService.saveSysCentralNervousExamination(examination);

		assertNotNull(resultId, "ID should not be null on successful save");
		assertEquals(1L, resultId, "The saved ID should match the expected value.");
	}

	@Test
	void testSaveSysCentralNervousExamination_whenSaveFails_thenReturnsNullId() {
		SysCentralNervousExamination examination = new SysCentralNervousExamination();

		when(sysCentralNervousExaminationRepo.save(any(SysCentralNervousExamination.class))).thenReturn(null);

		Long resultId = commonNurseService.saveSysCentralNervousExamination(examination);

		assertNull(resultId, "ID should be null when save operation fails");
	}

//	@Test
//	void testSaveSysMusculoskeletalSystemExamination() {
//		fail("Not yet implemented");
//	}

	@Test
	void testSaveSysMusculoskeletalSystemExamination_whenSaveSuccess_thenReturnsNonNullId() {
		SysMusculoskeletalSystemExamination examination = new SysMusculoskeletalSystemExamination();
		SysMusculoskeletalSystemExamination savedExamination = new SysMusculoskeletalSystemExamination();
		savedExamination.setID(1L); // Assuming successful save assigns an ID

		when(sysMusculoskeletalSystemExaminationRepo.save(any(SysMusculoskeletalSystemExamination.class)))
				.thenReturn(savedExamination);

		Long resultId = commonNurseService.saveSysMusculoskeletalSystemExamination(examination);

		assertNotNull(resultId, "ID should not be null on successful save");
		assertEquals(1L, resultId, "The returned ID should match the expected value.");
	}

	@Test
	void testSaveSysMusculoskeletalSystemExamination_whenSaveFails_thenReturnsNullId() {
		SysMusculoskeletalSystemExamination examination = new SysMusculoskeletalSystemExamination();

		when(sysMusculoskeletalSystemExaminationRepo.save(any(SysMusculoskeletalSystemExamination.class)))
				.thenReturn(null);

		Long resultId = commonNurseService.saveSysMusculoskeletalSystemExamination(examination);

		assertNull(resultId, "ID should be null when save operation fails");
	}

	@Test
	void testSaveSysGenitourinarySystemExamination_whenSaveSuccess_thenReturnsNonNullId() {
		SysGenitourinarySystemExamination examination = new SysGenitourinarySystemExamination();
		SysGenitourinarySystemExamination savedExamination = new SysGenitourinarySystemExamination();
		savedExamination.setID(1L); // Assuming the save operation assigns an ID

		when(sysGenitourinarySystemExaminationRepo.save(any(SysGenitourinarySystemExamination.class)))
				.thenReturn(savedExamination);

		Long resultId = commonNurseService.saveSysGenitourinarySystemExamination(examination);

		assertNotNull(resultId, "ID should not be null on successful save");
		assertEquals(1L, resultId, "The returned ID should match the expected value.");
	}

	@Test
	void testSaveSysGenitourinarySystemExamination_whenSaveFails_thenReturnsNullId() {
		SysGenitourinarySystemExamination examination = new SysGenitourinarySystemExamination();

		when(sysGenitourinarySystemExaminationRepo.save(any(SysGenitourinarySystemExamination.class))).thenReturn(null);

		Long resultId = commonNurseService.saveSysGenitourinarySystemExamination(examination);

		assertNull(resultId, "ID should be null when save operation fails");
	}

	@Test
	void testFetchBenPastMedicalHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchBenPersonalTobaccoHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchBenPersonalAlcoholHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchBenPersonalAllergyHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchBenPersonalMedicationHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchBenPersonalFamilyHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchBenPhysicalHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchBenMenstrualHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchBenPastObstetricHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchBenComorbidityHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchBenImmunizationHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchBenOptionalVaccineHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenChiefComplaints() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPastHistoryData() {
		fail("Not yet implemented");
	}

	@Test
	void testGetComorbidityConditionsHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMedicationHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPersonalHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFamilyHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFamilyHistoryDetail() {
		fail("Not yet implemented");
	}

//	@Test
//	void testGetPhysicalActivityType() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetPhysicalActivityType_whenGetPhysicalActivityType_thenReturnPhysicalActivityType() {
		// Given
		Long beneficiaryRegID = 1L;
		Long visitCode = 101L;
		PhysicalActivityType expectedPhysicalActivityType = new PhysicalActivityType();
		expectedPhysicalActivityType.setBeneficiaryRegID(beneficiaryRegID);
		expectedPhysicalActivityType.setVisitCode(visitCode);
		// Assume additional properties set as needed

		when(physicalActivityTypeRepo.getBenPhysicalHistoryDetails(beneficiaryRegID, visitCode))
				.thenReturn(expectedPhysicalActivityType);

		// When
		PhysicalActivityType result = commonNurseService.getPhysicalActivityType(beneficiaryRegID, visitCode);

		// Then
		assertNotNull(result, "The result should not be null");
		assertEquals(expectedPhysicalActivityType, result,
				"The returned PhysicalActivityType does not match the expected result");
	}

	@Test
	void testGetBeneficiaryIdrsDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMenstrualHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFemaleObstetricHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetChildOptionalVaccineHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetImmunizationHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetGeneralExaminationData() {
		fail("Not yet implemented");
	}

//	@Test
//	void testGetHeadToToeExaminationData() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetHeadToToeExaminationData_whenValidDataFound_thenReturnsPhyHeadToToeExaminationData() {
		Long benRegID = 1L;
		Long visitCode = 101L;
		PhyHeadToToeExamination mockExaminationData = new PhyHeadToToeExamination();
		// Configure mockExaminationData as needed for your test

		when(phyHeadToToeExaminationRepo.getPhyHeadToToeExaminationData(benRegID, visitCode))
				.thenReturn(mockExaminationData);

		PhyHeadToToeExamination result = commonNurseService.getHeadToToeExaminationData(benRegID, visitCode);

		assertNotNull(result, "PhyHeadToToeExamination data should not be null when valid data is found");
		// Additional assertions can be made here to verify specific attributes of the
		// returned object
	}

	@Test
	void testGetHeadToToeExaminationData_whenNoDataFound_thenReturnsNull() {
		Long benRegID = 2L;
		Long visitCode = 202L;

		when(phyHeadToToeExaminationRepo.getPhyHeadToToeExaminationData(benRegID, visitCode)).thenReturn(null);

		PhyHeadToToeExamination result = commonNurseService.getHeadToToeExaminationData(benRegID, visitCode);

		assertNull(result, "PhyHeadToToeExamination data should be null when no data is found");
	}

//	@Test
//	void testGetSysGastrointestinalExamination() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetSysGastrointestinalExamination_whenValidDataFound() {
		Long benRegID = 1L;
		Long visitCode = 101L;
		SysGastrointestinalExamination mockExaminationData = new SysGastrointestinalExamination();
		// Configure mockExaminationData as needed for your test

		when(sysGastrointestinalExaminationRepo.getSSysGastrointestinalExamination(benRegID, visitCode))
				.thenReturn(mockExaminationData);

		SysGastrointestinalExamination result = commonNurseService.getSysGastrointestinalExamination(benRegID,
				visitCode);

		assertNotNull(result, "SysGastrointestinalExamination data should not be null when valid data is found");
		// Additional assertions can be made here to verify specific attributes of the
		// returned object
	}

	@Test
	void testGetSysGastrointestinalExamination_whenNoDataFound_thenReturnsNull() {
		Long benRegID = 2L;
		Long visitCode = 202L;

		when(sysGastrointestinalExaminationRepo.getSSysGastrointestinalExamination(benRegID, visitCode))
				.thenReturn(null);

		SysGastrointestinalExamination result = commonNurseService.getSysGastrointestinalExamination(benRegID,
				visitCode);

		assertNull(result, "SysGastrointestinalExamination data should be null when no data is found");
	}

//	@Test
//	void testGetCardiovascularExamination() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetCardiovascularExamination_whenValidDataFound() {
		Long benRegID = 1L;
		Long visitCode = 101L;
		SysCardiovascularExamination expectedData = new SysCardiovascularExamination();
		// Configure expectedData as needed for your test scenario

		when(sysCardiovascularExaminationRepo.getSysCardiovascularExaminationData(benRegID, visitCode))
				.thenReturn(expectedData);

		SysCardiovascularExamination actualData = commonNurseService.getCardiovascularExamination(benRegID, visitCode);

		assertNotNull(actualData, "Expected non-null SysCardiovascularExamination data");
		// Further assertions can be made here to verify specific attributes of
		// actualData
	}

	@Test
	void testGetCardiovascularExamination_whenNoDataFound_thenReturnsNull() {
		Long benRegID = 2L;
		Long visitCode = 202L;

		when(sysCardiovascularExaminationRepo.getSysCardiovascularExaminationData(benRegID, visitCode))
				.thenReturn(null);

		SysCardiovascularExamination actualData = commonNurseService.getCardiovascularExamination(benRegID, visitCode);

		assertNull(actualData, "Expected null SysCardiovascularExamination data when no matching data is found");
	}

//	@Test
//	void testGetRespiratoryExamination() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetRespiratoryExamination_whenValidDataFound() {
		Long benRegID = 1L;
		Long visitCode = 101L;
		SysRespiratoryExamination expectedData = new SysRespiratoryExamination();
		// Configure expectedData as necessary for your test scenario

		when(sysRespiratoryExaminationRepo.getSysRespiratoryExaminationData(benRegID, visitCode))
				.thenReturn(expectedData);

		SysRespiratoryExamination actualData = commonNurseService.getRespiratoryExamination(benRegID, visitCode);

		assertNotNull(actualData, "Expected non-null SysRespiratoryExamination data");
		// Additional assertions can be added here to verify specific attributes of
		// actualData
	}

	@Test
	void testGetRespiratoryExamination_whenNoDataFound_thenReturnsNull() {
		Long benRegID = 2L;
		Long visitCode = 202L;

		when(sysRespiratoryExaminationRepo.getSysRespiratoryExaminationData(benRegID, visitCode)).thenReturn(null);

		SysRespiratoryExamination actualData = commonNurseService.getRespiratoryExamination(benRegID, visitCode);

		assertNull(actualData, "Expected null SysRespiratoryExamination data when no data is found");
	}

//	@Test
//	void testGetSysCentralNervousExamination() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetSysCentralNervousExamination_whenValidDataFound() {
		Long benRegID = 1L;
		Long visitCode = 101L;
		SysCentralNervousExamination expectedData = new SysCentralNervousExamination();
		// Set up expectedData as necessary for the test

		when(sysCentralNervousExaminationRepo.getSysCentralNervousExaminationData(benRegID, visitCode))
				.thenReturn(expectedData);

		SysCentralNervousExamination actualData = commonNurseService.getSysCentralNervousExamination(benRegID,
				visitCode);

		assertNotNull(actualData, "Expected non-null SysCentralNervousExamination data");
		// Additional assertions to verify specific attributes of actualData
	}

	@Test
	void testGetSysCentralNervousExamination_whenNoDataFound_thenReturnsNull() {
		Long benRegID = 2L;
		Long visitCode = 202L;

		when(sysCentralNervousExaminationRepo.getSysCentralNervousExaminationData(benRegID, visitCode))
				.thenReturn(null);

		SysCentralNervousExamination actualData = commonNurseService.getSysCentralNervousExamination(benRegID,
				visitCode);

		assertNull(actualData, "Expected null SysCentralNervousExamination data when no matching records are found");
	}

//	@Test
//	void testGetMusculoskeletalExamination() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetMusculoskeletalExamination_whenValidDataFound() {
		Long benRegID = 1L;
		Long visitCode = 101L;
		SysMusculoskeletalSystemExamination expectedExamination = new SysMusculoskeletalSystemExamination();
		// Initialize expectedExamination with test data

		when(sysMusculoskeletalSystemExaminationRepo.getSysMusculoskeletalSystemExamination(benRegID, visitCode))
				.thenReturn(expectedExamination);

		SysMusculoskeletalSystemExamination actualExamination = commonNurseService
				.getMusculoskeletalExamination(benRegID, visitCode);

		assertNotNull(actualExamination, "Expected non-null SysMusculoskeletalSystemExamination");
		// Additional assertions can be made here to validate the details of the
		// returned object
	}

	@Test
	void testGetMusculoskeletalExamination_whenNoDataFound_thenReturnsNull() {
		Long benRegID = 2L;
		Long visitCode = 202L;

		when(sysMusculoskeletalSystemExaminationRepo.getSysMusculoskeletalSystemExamination(benRegID, visitCode))
				.thenReturn(null);

		SysMusculoskeletalSystemExamination actualExamination = commonNurseService
				.getMusculoskeletalExamination(benRegID, visitCode);

		assertNull(actualExamination, "Expected null when no SysMusculoskeletalSystemExamination data is found");
	}

//	@Test
//	void testGetGenitourinaryExamination() {
//		fail("Not yet implemented");
//	}
	
	@Test
	void testGetGenitourinaryExamination_whenValidDataFound() {
	    Long benRegID = 1L;
	    Long visitCode = 101L;
	    SysGenitourinarySystemExamination expectedExamination = new SysGenitourinarySystemExamination();
	    // Initialize expectedExamination with test data

	    when(sysGenitourinarySystemExaminationRepo.getSysGenitourinarySystemExaminationData(benRegID, visitCode))
	            .thenReturn(expectedExamination);

	    SysGenitourinarySystemExamination actualExamination = commonNurseService.getGenitourinaryExamination(benRegID, visitCode);

	    assertNotNull(actualExamination, "Expected a non-null SysGenitourinarySystemExamination");
	    // You can add more assertions here to check the correctness of the data in the returned object
	}
	
	@Test
	void testGetGenitourinaryExamination_whenNoDataFound_thenReturnsNull() {
	    Long benRegID = 2L;
	    Long visitCode = 202L;

	    when(sysGenitourinarySystemExaminationRepo.getSysGenitourinarySystemExaminationData(benRegID, visitCode)).thenReturn(null);

	    SysGenitourinarySystemExamination actualExamination = commonNurseService.getGenitourinaryExamination(benRegID, visitCode);

	    assertNull(actualExamination, "Expected null when no SysGenitourinarySystemExamination data is found");
	}

	@Test
	void testUpdateBenChiefComplaints() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenPastHistoryDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenComorbidConditions() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenMedicationHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenPersonalHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenAllergicHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenFamilyHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateMenstrualHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdatePastObstetricHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateChildOptionalVaccineDetail() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateChildImmunizationDetail() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdatePhyGeneralExamination() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdatePhyHeadToToeExamination() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateSysCardiovascularExamination() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateSysRespiratoryExamination() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateSysCentralNervousExamination() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateSysMusculoskeletalSystemExamination() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateSysGenitourinarySystemExamination() {
		fail("Not yet implemented");
	}

	@Test
	void testSavePrescriptionDetailsAndGetPrescriptionID() {
		fail("Not yet implemented");
	}

	@Test
	void testSavePrescriptionDetailsCovid19() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBeneficiaryPrescription() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenPrescription() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdatePrescription() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBeneficiaryLabTestOrderDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenPrescribedDrugsList() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenInvestigationDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenInvestigation() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenVisitStatusFlag() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenStatus() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNurseWorkList() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNurseWorkListNew() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNurseWorkListTMReferred() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLabWorkListNew() {
		fail("Not yet implemented");
	}

	@Test
	void testGetRadiologistWorkListNew() {
		fail("Not yet implemented");
	}

	@Test
	void testGetOncologistWorkListNew() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPharmaWorkListNew() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenAdherenceDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveChildDevelopmentHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveChildFeedingHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testSavePerinatalHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenAdherence() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLabTestOrders() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDevelopmentHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPerinatalHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFeedingHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchBenPerinatalHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchBenFeedingHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchBenDevelopmentHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateChildFeedingHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdatePerinatalHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateChildDevelopmentHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateSysGastrointestinalExamination() {
		fail("Not yet implemented");
	}

	@Test
	void testGetGraphicalTrendData() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenFamilyHistoryNCDScreening() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenPhysicalActivityHistoryNCDScreening() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenSymptomaticData() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenPreviousDiabetesData() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenPreviousReferralData() {
		fail("Not yet implemented");
	}

	@Test
	void testCalculateBMIStatus() {
		fail("Not yet implemented");
	}

}
