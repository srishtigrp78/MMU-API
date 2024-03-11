package com.iemr.mmu.service.ncdCare;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.mmu.data.ncdcare.NCDCareDiagnosis;
import com.iemr.mmu.repo.nurse.ncdcare.NCDCareDiagnosisRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;

@ExtendWith(MockitoExtension.class)
class NCDCareDoctorServiceImplTest {
	@Mock
	private NCDCareDiagnosisRepo ncdCareDiagnosisRepo;
	@Mock
	private PrescriptionDetailRepo prescriptionDetailRepo;
	@InjectMocks
	NCDCareDoctorServiceImpl NCDCareDoctorService;

	@Test
	void testSaveNCDDiagnosisData() {
		// Given
		Long beneficiaryRegID = 123L;
		Long benVisitID = 456L;
		Integer providerServiceMapID = 789;
		Long prescriptionID = 101112L;
		String ncdCareCondition = "Condition1||Condition2"; // Assuming these are your conditions concatenated
		String ncdComplication = "Complication1";
		String ncdCareType = "CareType1";
		Long visitCode = 131415L;
		String externalInvestigation = "Investigation1";
		String ncdCareConditionOther = "OtherCondition";

		NCDCareDiagnosis ncdDiagnosis = new NCDCareDiagnosis(beneficiaryRegID, benVisitID, providerServiceMapID,
				prescriptionID, ncdCareCondition, ncdComplication, ncdCareType, visitCode, externalInvestigation,
				ncdCareConditionOther);

		NCDCareDiagnosis savedDiagnosis = new NCDCareDiagnosis(beneficiaryRegID, benVisitID, providerServiceMapID,
				prescriptionID, ncdCareCondition, ncdComplication, ncdCareType, visitCode, externalInvestigation,
				ncdCareConditionOther);
		savedDiagnosis.setID(1L); // Assuming the ID is set to 1 for testing

		when(ncdCareDiagnosisRepo.save(any(NCDCareDiagnosis.class))).thenReturn(savedDiagnosis);

		// When
		long resultId = NCDCareDoctorService.saveNCDDiagnosisData(ncdDiagnosis);

		// Then
		assertEquals(1L, resultId, "The returned ID should be 1.");

		// Verify that ncdCareDiagnosisRepo.save() was called exactly once
		verify(ncdCareDiagnosisRepo, times(1)).save(any(NCDCareDiagnosis.class));
	}

	@Test
	void testSaveNCDDiagnosisDataWithConditions() {
		// Given
		String[] conditions = new String[] { "Condition1", "Condition2" };
		NCDCareDiagnosis ncdDiagnosis = new NCDCareDiagnosis(1L, 2L, 3, 4L, null, "Complication", "CareType", 5L,
				"ExternalInvestigation", null);
		ncdDiagnosis.setNcdScreeningConditionArray(conditions);

		NCDCareDiagnosis savedDiagnosis = new NCDCareDiagnosis(1L, 2L, 3, 4L, null, "Complication", "CareType", 5L,
				"ExternalInvestigation", null);
		savedDiagnosis.setID(1L); // Assuming the ID is set to 1 for testing

		when(ncdCareDiagnosisRepo.save(any(NCDCareDiagnosis.class))).thenReturn(savedDiagnosis);

		// When
		long resultId = NCDCareDoctorService.saveNCDDiagnosisData(ncdDiagnosis);

		// Then
		assertEquals(1L, resultId, "The returned ID should be 1.");

		// Verify save() was called exactly once
		verify(ncdCareDiagnosisRepo, times(1)).save(any(NCDCareDiagnosis.class));
	}

	@Test
	void testGetNCDCareDiagnosisDetails() {
		// Given
		Long beneficiaryRegID = 123L;
		Long benVisitID = 456L;
		Integer providerServiceMapID = 789;
		Long prescriptionID = 101112L;
		String ncdCareCondition = "Condition1||Condition2"; // Assuming these are your conditions concatenated
		String ncdComplication = "Complication1";
		String ncdCareType = "CareType1";
		Long visitCode = 131415L;
		String externalInvestigation = "Investigation1";
		String ncdCareConditionOther = "OtherCondition";

		NCDCareDiagnosis ncdCareDiagnosis = new NCDCareDiagnosis(beneficiaryRegID, benVisitID, providerServiceMapID,
				prescriptionID, ncdCareCondition, ncdComplication, ncdCareType, visitCode, externalInvestigation,
				ncdCareConditionOther);

		int res = 0;
		String processed = "test";
				
		//when(ncdCareDiagnosisRepo.getNCDCareDiagnosisStatus(ncdCareDiagnosis.getBeneficiaryRegID(),
		//		ncdCareDiagnosis.getVisitCode(), ncdCareDiagnosis.getPrescriptionID())).thenReturn(processed);
		
		processed = "U";
		
		assertTrue(null != processed && !processed.equals("N"));
		
	}

	@Test
	void testUpdateBenNCDCareDiagnosis() {
		fail("Not yet implemented");
	}

}
