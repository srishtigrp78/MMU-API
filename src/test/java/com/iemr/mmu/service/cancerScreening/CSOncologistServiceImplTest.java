package com.iemr.mmu.service.cancerScreening;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.repo.doctor.CancerDiagnosisRepo;

@ExtendWith(MockitoExtension.class)
class CSOncologistServiceImplTest {

	@Mock
	private CancerDiagnosisRepo cancerDiagnosisRepo;
	@InjectMocks
	CSOncologistServiceImpl csOncologistService;

	
	@Test
	void updateCancerDiagnosisDetailsByOncologist_ExistingRecord_Updated() {
		// setup
		CancerDiagnosis cancerDiagnosis = new CancerDiagnosis();
		cancerDiagnosis.setBeneficiaryRegID(1L);
		cancerDiagnosis.setVisitCode(1L);
		cancerDiagnosis.setProvisionalDiagnosisOncologist("Diagnosis Updated");
		cancerDiagnosis.setModifiedBy("Oncologist");
		
		cancerDiagnosis.toString();

		when(cancerDiagnosisRepo.getCancerDiagnosisStatuses(1L, 1L)).thenReturn("Y");
		when(cancerDiagnosisRepo.updateDetailsByOncologist(any(String.class), eq(1L), eq(1L), any(String.class),
				eq("U"))).thenReturn(1);

		// execute
		int response = csOncologistService.updateCancerDiagnosisDetailsByOncologist(cancerDiagnosis);

		// verify
		assertEquals(1, response);
	}

	@Test
	void updateCancerDiagnosisDetailsByOncologist_NoExistingRecord_Created() {
		// setup
		CancerDiagnosis cancerDiagnosis = new CancerDiagnosis();
		cancerDiagnosis.setBeneficiaryRegID(1L);
		cancerDiagnosis.setVisitCode(1L);
		cancerDiagnosis.setProvisionalDiagnosisOncologist("New Diagnosis");
		cancerDiagnosis.setModifiedBy("Oncologist");

		when(cancerDiagnosisRepo.getCancerDiagnosisStatuses(1L, 1L)).thenReturn(null);
		when(cancerDiagnosisRepo.save(any(CancerDiagnosis.class))).thenReturn(cancerDiagnosis);

		// execute
		int response = csOncologistService.updateCancerDiagnosisDetailsByOncologist(cancerDiagnosis);

		// verify
		assertEquals(1, response);
		verify(cancerDiagnosisRepo).save(any(CancerDiagnosis.class));
	}

}
