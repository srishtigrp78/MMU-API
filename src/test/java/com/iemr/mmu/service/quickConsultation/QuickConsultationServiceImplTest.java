package com.iemr.mmu.service.quickConsultation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.ArrayList;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;
import com.iemr.mmu.repo.quickConsultation.BenClinicalObservationsRepo;
import com.iemr.mmu.repo.quickConsultation.ExternalTestOrderRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.labtechnician.LabTechnicianServiceImpl;

@ExtendWith(MockitoExtension.class)
class QuickConsultationServiceImplTest {
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

	@InjectMocks
	QuickConsultationServiceImpl quickConsultationServiceImpl;

	@Test
	void testSaveBeneficiaryChiefComplaint() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBeneficiaryChiefComplaintWithNonEmptyList() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBeneficiaryClinicalObservations() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBenPrescriptionForANC() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveBeneficiaryExternalLabTestOrderDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testQuickConsultNurseDataInsert() {
		fail("Not yet implemented");
	}

	@Test
	void testQuickConsultDoctorDataInsert() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenDataFrmNurseToDocVisitDetailsScreen() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBeneficiaryVitalDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenQuickConsultNurseData() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenCaseRecordFromDoctorQuickConsult() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateGeneralOPDQCDoctorData() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBeneficiaryClinicalObservations() {
		fail("Not yet implemented");
	}

}
