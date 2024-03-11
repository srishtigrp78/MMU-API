package com.iemr.mmu.service.common.master;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.mmu.repo.doctor.ChiefComplaintMasterRepo;
import com.iemr.mmu.repo.doctor.LabTestMasterRepo;
import com.iemr.mmu.repo.labModule.ProcedureRepo;
import com.iemr.mmu.repo.masterrepo.anc.AllergicReactionTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.DiseaseTypeRepo;
import com.iemr.mmu.repo.masterrepo.anc.PersonalHabitTypeRepo;
import com.iemr.mmu.repo.masterrepo.ncdScreening.BPAndDiabeticStatusRepo;
import com.iemr.mmu.repo.masterrepo.ncdScreening.IDRS_ScreenQuestionsRepo;
import com.iemr.mmu.repo.masterrepo.ncdScreening.NCDScreeningConditionRepo;
import com.iemr.mmu.repo.masterrepo.ncdScreening.NCDScreeningReasonRepo;
import com.iemr.mmu.repo.masterrepo.ncdScreening.PhysicalActivityRepo;
import com.iemr.mmu.repo.masterrepo.nurse.FamilyMemberMasterRepo;

@ExtendWith(MockitoExtension.class)
class NCDScreeningMasterServiceImplTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Mock
	private NCDScreeningConditionRepo ncdScreeningConditionRepo;
	@Mock
	private NCDScreeningReasonRepo ncdScreeningReasonRepo;
	@Mock
	private BPAndDiabeticStatusRepo bpAndDiabeticStatusRepo;
	@Mock
	private LabTestMasterRepo labTestMasterRepo;
	@Mock
	private ChiefComplaintMasterRepo chiefComplaintMasterRepo;
	@Mock
	private ProcedureRepo procedureRepo;
	@Mock
	private IDRS_ScreenQuestionsRepo iDRS_ScreenQuestionsRepo;
	@Mock
	private PhysicalActivityRepo physicalActivityRepo;
	@Mock
	private DiseaseTypeRepo diseaseTypeRepo;
	@Mock
	private FamilyMemberMasterRepo familyMemberMasterRepo;

	@Mock
	private PersonalHabitTypeRepo personalHabitTypeRepo;
	@Mock
	private AllergicReactionTypesRepo allergicReactionTypesRepo;
	@InjectMocks
	NCDScreeningMasterServiceImpl ncdScreeningMasterService;

	@Test
	void testGetNCDScreeningConditions_Success() {
		// Setup our mocked repository
		List<Object[]> mockResponse = new ArrayList<>();
		// Assuming your data structure, adjust accordingly
		mockResponse.add(new Object[] { "Condition 1", "Description 1" });
		mockResponse.add(new Object[] { "Condition 2", "Description 2" });
		when(ncdScreeningConditionRepo.getNCDScreeningConditions()).thenReturn((ArrayList<Object[]>) mockResponse);

		// Execute the service method
		List<Object[]> result = ncdScreeningMasterService.getNCDScreeningConditions();

		// Validate the results
		assertNotNull(result);
		assertEquals(2, result.size());
		verify(ncdScreeningConditionRepo, times(1)).getNCDScreeningConditions();
	}

	@Test
	void testGetNCDScreeningConditions_Exception() {
		// Setup our mocked repository to throw an exception
		when(ncdScreeningConditionRepo.getNCDScreeningConditions()).thenThrow(RuntimeException.class);

		// Execute the service method
		List<Object[]> result = ncdScreeningMasterService.getNCDScreeningConditions();

		// Validate the results
		assertNull(result);
		verify(ncdScreeningConditionRepo, times(1)).getNCDScreeningConditions();
	}

	@Test
	void testGetNCDScreeningReasons_Success() {
		// Given
		List<Object[]> mockedList = new ArrayList<>();
		mockedList.add(new Object[] { "Reason1" });
		mockedList.add(new Object[] { "Reason2" });
		when(ncdScreeningReasonRepo.getNCDScreeningReasons()).thenReturn((ArrayList<Object[]>) mockedList);

		// When
		List<Object[]> result = ncdScreeningMasterService.getNCDScreeningReasons();

		// Then
		assertNotNull(result);
		assertEquals(2, result.size());
		verify(ncdScreeningReasonRepo, times(1)).getNCDScreeningReasons();
	}

	@Test
	void testGetNCDScreeningReasons_Exception() {
		// Given
		when(ncdScreeningReasonRepo.getNCDScreeningReasons()).thenThrow(RuntimeException.class);

		// When
		List<Object[]> result = ncdScreeningMasterService.getNCDScreeningReasons();

		// Then
		assertNull(result);
	}

	@Test
	void testGetBPAndDiabeticStatus_Success() {
		// Given
		List<Object[]> mockedList = new ArrayList<>();
		mockedList.add(new Object[] { "BPStatus1", "DiabeticStatus1" });
		mockedList.add(new Object[] { "BPStatus2", "DiabeticStatus2" });
		boolean isBPStatus = true;
		when(bpAndDiabeticStatusRepo.getBPAndDiabeticStatus(isBPStatus)).thenReturn((ArrayList<Object[]>) mockedList);

		// When
		List<Object[]> result = ncdScreeningMasterService.getBPAndDiabeticStatus(isBPStatus);

		// Then
		assertNotNull(result);
		assertEquals(2, result.size());
		verify(bpAndDiabeticStatusRepo, times(1)).getBPAndDiabeticStatus(isBPStatus);
	}

	@Test
	void testGetBPAndDiabeticStatus_Exception() {
		// Given
		boolean isBPStatus = false;
		when(bpAndDiabeticStatusRepo.getBPAndDiabeticStatus(isBPStatus)).thenThrow(RuntimeException.class);

		// When
		List<Object[]> result = ncdScreeningMasterService.getBPAndDiabeticStatus(isBPStatus);

		// Then
		assertNull(result);
	}

	@Test
	void testGetNCDTest_Success() {
		// Given
		ArrayList<Object[]> mockedList = new ArrayList<>();
		mockedList.add(new Object[] { "Test1", "Description1" });
		mockedList.add(new Object[] { "Test2", "Description2" });
		when(labTestMasterRepo.getTestsBYVisitCategory("NCD Screening")).thenReturn(mockedList);

		// When
		ArrayList<Object[]> result = ncdScreeningMasterService.getNCDTest();

		// Then
		assertNotNull(result);
		assertEquals(2, result.size());
		verify(labTestMasterRepo, times(1)).getTestsBYVisitCategory("NCD Screening");
	}

	@Test
	void testGetNCDTest_Exception() {
		// Given
		when(labTestMasterRepo.getTestsBYVisitCategory("NCD Screening")).thenThrow(RuntimeException.class);

		// When
		ArrayList<Object[]> result = ncdScreeningMasterService.getNCDTest();

		// Then
		assertNull(result);
	}

	@Test
	void getChiefComplaintMaster_Success() {
		// Given
		List<Object[]> expectedList = new ArrayList<>();
		expectedList.add(new Object[] { "Complaint1", "Description1" });
		expectedList.add(new Object[] { "Complaint2", "Description2" });
		when(chiefComplaintMasterRepo.getChiefComplaintMaster()).thenReturn((ArrayList<Object[]>) expectedList);

		// When
		List<Object[]> result = ncdScreeningMasterService.getChiefComplaintMaster();

		// Then
		assertNotNull(result, "Result should not be null");
		assertEquals(expectedList.size(), result.size(), "The size of the result list should match the expected list");
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expectedList.get(i)[0], result.get(i)[0], "Expected and actual complaint should match");
			assertEquals(expectedList.get(i)[1], result.get(i)[1], "Expected and actual description should match");
		}
	}

	@Test
	void getChiefComplaintMasterHandles_Exception() {
		// Given
		when(chiefComplaintMasterRepo.getChiefComplaintMaster()).thenThrow(RuntimeException.class);

		// When
		List<Object[]> result = ncdScreeningMasterService.getChiefComplaintMaster();

		// Then
		assertNull(result, "Result should not be null even in case of exception");
	}

	@Test
	void getNCDScreeningMasterData_Success() {
		// Given
		Integer visitCategoryID = 1, providerServiceMapID = 1;
		String gender = "Male";

		// Mock the repository calls
		when(chiefComplaintMasterRepo.getChiefComplaintMaster()).thenReturn(new ArrayList<>());
		when(diseaseTypeRepo.getDiseaseTypes()).thenReturn(new ArrayList<>());
		when(familyMemberMasterRepo.getFamilyMemberTypeMaster()).thenReturn(new ArrayList<>());
		// Mock other repository methods similarly...

		// When
		String result = ncdScreeningMasterService.getNCDScreeningMasterData(visitCategoryID, providerServiceMapID,
				gender);

		// Then
		assertNotNull(result, "The result should not be null.");
		// Here you would assert specific structure/content of the JSON if necessary,
		// but for simplicity we're just checking not null.

		// Verify that all expected methods were called.
		verify(chiefComplaintMasterRepo, times(1)).getChiefComplaintMaster();
		verify(diseaseTypeRepo, times(1)).getDiseaseTypes();
		verify(familyMemberMasterRepo, times(1)).getFamilyMemberTypeMaster();
		// Verify other repositories were called...
	}

	
}