package com.iemr.mmu.service.generalOPD;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;

@ExtendWith(MockitoExtension.class)
class GeneralOPDDoctorServiceImplTest {
	@Mock
	private PrescriptionDetailRepo prescriptionDetailRepo;
	@InjectMocks
	GeneralOPDDoctorServiceImpl generalOPDDoctorService;

	@Test
	void testGetGeneralOPDDiagnosisDetailsWithValidData() {
		Long beneficiaryRegID = 1L;
		Long visitCode = 1L;

		// Mocking the database response
		ArrayList<PrescriptionDetail> mockedResponse = new ArrayList<>();
		PrescriptionDetail pd = new PrescriptionDetail();
		pd.setDiagnosisProvided_SCTCode("12345  ||  67890");
		pd.setDiagnosisProvided("Diagnosis1  ||  Diagnosis2");
		pd.toString();
		mockedResponse.add(pd);

		when(prescriptionDetailRepo.findByBeneficiaryRegIDAndVisitCode(beneficiaryRegID, visitCode))
				.thenReturn(mockedResponse);

		// Actual test call
		String result = generalOPDDoctorService.getGeneralOPDDiagnosisDetails(beneficiaryRegID, visitCode);

		// Verify the method call
		verify(prescriptionDetailRepo).findByBeneficiaryRegIDAndVisitCode(beneficiaryRegID, visitCode);

		// Assertions
		assertNotNull(result);
		assertTrue(result.contains("12345"));
		assertTrue(result.contains("Diagnosis1"));
	}

	@Test
	void testGetGeneralOPDDiagnosisDetailsWithNoData() {
		Long beneficiaryRegID = 2L;
		Long visitCode = 2L;

		// Assuming no data is found for the given IDs
		when(prescriptionDetailRepo.findByBeneficiaryRegIDAndVisitCode(beneficiaryRegID, visitCode))
				.thenReturn(new ArrayList<>());

		// Actual test call
		String result = generalOPDDoctorService.getGeneralOPDDiagnosisDetails(beneficiaryRegID, visitCode);

		// Verify the method call
		verify(prescriptionDetailRepo).findByBeneficiaryRegIDAndVisitCode(beneficiaryRegID, visitCode);

		// Assertions
		assertNotNull(result);
		// Assuming your PrescriptionDetail's default state produces an identifiable
		// JSON structure
		assertTrue(result.contains("{}") || result.contains("default"));
	}
}
