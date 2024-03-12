package com.iemr.mmu.service.ncdscreening;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.nurse.CommonUtilityClass;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;
import com.iemr.mmu.data.snomedct.SCTDescription;
import com.iemr.mmu.data.tele_consultation.TeleconsultationRequestOBJ;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.tele_consultation.TeleConsultationServiceImpl;

@ExtendWith(MockitoExtension.class)
class NCDSCreeningDoctorServiceImplTest {
	@Mock
	private CommonDoctorServiceImpl commonDoctorServiceImpl;

	@Mock
	private CommonNurseServiceImpl commonNurseServiceImpl;

	@InjectMocks
	private NCDSCreeningDoctorServiceImpl nCDSCreeningDoctorServiceImpl;

	@Mock
	private PrescriptionDetailRepo prescriptionDetailRepo;

	@Mock
	private TeleConsultationServiceImpl teleConsultationServiceImpl;

	@Test
	void testSetPrescriptionDetailRepo() {

		// Arrange and Act
		(new NCDSCreeningDoctorServiceImpl()).setPrescriptionDetailRepo(mock(PrescriptionDetailRepo.class));
	}

	@Test
	void testUpdateDoctorData() throws Exception {
		// Arrange
		when(commonDoctorServiceImpl.updateBenFlowtableAfterDocDataUpdate(Mockito.<CommonUtilityClass>any(),
				Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<TeleconsultationRequestOBJ>any()))
				.thenReturn(1);

		// Act
		int actualUpdateDoctorDataResult = nCDSCreeningDoctorServiceImpl.updateDoctorData(new JsonObject());

		// Assert
		verify(commonDoctorServiceImpl).updateBenFlowtableAfterDocDataUpdate(Mockito.<CommonUtilityClass>any(),
				Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<TeleconsultationRequestOBJ>any());
		assertEquals(1, actualUpdateDoctorDataResult);
	}

	@Test
	void testUpdateDoctorData2() throws Exception {
		// Arrange
		when(commonDoctorServiceImpl.updateBenFlowtableAfterDocDataUpdate(Mockito.<CommonUtilityClass>any(),
				Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<TeleconsultationRequestOBJ>any()))
				.thenReturn(0);

		// Act and Assert
		assertThrows(RuntimeException.class, () -> nCDSCreeningDoctorServiceImpl.updateDoctorData(new JsonObject()));
		verify(commonDoctorServiceImpl).updateBenFlowtableAfterDocDataUpdate(Mockito.<CommonUtilityClass>any(),
				Mockito.<Boolean>any(), Mockito.<Boolean>any(), Mockito.<TeleconsultationRequestOBJ>any());
	}

	@Test
	void testUpdateDoctorData3() throws Exception {
		// Arrange, Act and Assert
		assertEquals(0, nCDSCreeningDoctorServiceImpl.updateDoctorData(null));
	}

	@Test
	void testGetNCDDiagnosisData() {
		// Arrange
		when(prescriptionDetailRepo.findByBeneficiaryRegIDAndVisitCode(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());

		// Act
		String actualNCDDiagnosisData = nCDSCreeningDoctorServiceImpl.getNCDDiagnosisData(1L, 1L);

		// Assert
		verify(prescriptionDetailRepo).findByBeneficiaryRegIDAndVisitCode(Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("{}", actualNCDDiagnosisData);
	}

	@Test
	void testGetNCDDiagnosisData2() {
		// Arrange
		PrescriptionDetail prescriptionDetail = mock(PrescriptionDetail.class);
		when(prescriptionDetail.getDiagnosisProvided()).thenThrow(new RuntimeException("foo"));
		when(prescriptionDetail.getDiagnosisProvided_SCTCode()).thenReturn("Diagnosis Provided SCTCode");
		doNothing().when(prescriptionDetail).setBenVisitID(Mockito.<Long>any());
		doNothing().when(prescriptionDetail).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(prescriptionDetail).setConfirmatoryDiagnosis(Mockito.<String>any());
		doNothing().when(prescriptionDetail).setCreatedBy(Mockito.<String>any());
		doNothing().when(prescriptionDetail).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(prescriptionDetail).setDeleted(Mockito.<Boolean>any());
		doNothing().when(prescriptionDetail).setDiagnosisProvided(Mockito.<String>any());
		doNothing().when(prescriptionDetail).setDiagnosisProvided_SCTCode(Mockito.<String>any());
		doNothing().when(prescriptionDetail).setDiagnosisProvided_SCTTerm(Mockito.<String>any());
		doNothing().when(prescriptionDetail).setExternalInvestigation(Mockito.<String>any());
		doNothing().when(prescriptionDetail).setInstruction(Mockito.<String>any());
		doNothing().when(prescriptionDetail).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(prescriptionDetail).setModifiedBy(Mockito.<String>any());
		doNothing().when(prescriptionDetail).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(prescriptionDetail).setPrescribedDrugs(Mockito.<ArrayList<PrescribedDrugDetail>>any());
		doNothing().when(prescriptionDetail).setPrescriptionID(Mockito.<Long>any());
		doNothing().when(prescriptionDetail).setProcessed(Mockito.<String>any());
		doNothing().when(prescriptionDetail).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(prescriptionDetail).setProvisionalDiagnosisList(Mockito.<ArrayList<SCTDescription>>any());
		doNothing().when(prescriptionDetail).setRemarks(Mockito.<String>any());
		doNothing().when(prescriptionDetail).setReservedForChange(Mockito.<String>any());
		doNothing().when(prescriptionDetail).setSyncedBy(Mockito.<String>any());
		doNothing().when(prescriptionDetail).setSyncedDate(Mockito.<Timestamp>any());
		doNothing().when(prescriptionDetail).setVanID(Mockito.<Integer>any());
		doNothing().when(prescriptionDetail).setVanSerialNo(Mockito.<Long>any());
		doNothing().when(prescriptionDetail).setVehicalNo(Mockito.<String>any());
		doNothing().when(prescriptionDetail).setVisitCode(Mockito.<Long>any());
		prescriptionDetail.setBenVisitID(1L);
		prescriptionDetail.setBeneficiaryRegID(1L);
		prescriptionDetail.setConfirmatoryDiagnosis("Confirmatory Diagnosis");
		prescriptionDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		prescriptionDetail.setCreatedDate(mock(Timestamp.class));
		prescriptionDetail.setDeleted(true);
		prescriptionDetail.setDiagnosisProvided("Diagnosis Provided");
		prescriptionDetail.setDiagnosisProvided_SCTCode("Diagnosis Provided SCTCode");
		prescriptionDetail.setDiagnosisProvided_SCTTerm("Diagnosis Provided SCTTerm");
		prescriptionDetail.setExternalInvestigation("External Investigation");
		prescriptionDetail.setInstruction("Instruction");
		prescriptionDetail.setLastModDate(mock(Timestamp.class));
		prescriptionDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		prescriptionDetail.setParkingPlaceID(1);
		prescriptionDetail.setPrescribedDrugs(new ArrayList<>());
		prescriptionDetail.setPrescriptionID(1L);
		prescriptionDetail.setProcessed("Processed");
		prescriptionDetail.setProviderServiceMapID(1);
		prescriptionDetail.setProvisionalDiagnosisList(new ArrayList<>());
		prescriptionDetail.setRemarks("Remarks");
		prescriptionDetail.setReservedForChange("Reserved For Change");
		prescriptionDetail.setSyncedBy("Synced By");
		prescriptionDetail.setSyncedDate(mock(Timestamp.class));
		prescriptionDetail.setVanID(1);
		prescriptionDetail.setVanSerialNo(1L);
		prescriptionDetail.setVehicalNo("Vehical No");
		prescriptionDetail.setVisitCode(1L);

		ArrayList<PrescriptionDetail> prescriptionDetailList = new ArrayList<>();
		prescriptionDetailList.add(prescriptionDetail);
		when(prescriptionDetailRepo.findByBeneficiaryRegIDAndVisitCode(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(prescriptionDetailList);

		// Act and Assert
		assertThrows(RuntimeException.class, () -> nCDSCreeningDoctorServiceImpl.getNCDDiagnosisData(1L, 1L));
		verify(prescriptionDetail).getDiagnosisProvided();
		verify(prescriptionDetail).getDiagnosisProvided_SCTCode();
		verify(prescriptionDetail).setBenVisitID(Mockito.<Long>any());
		verify(prescriptionDetail).setBeneficiaryRegID(Mockito.<Long>any());
		verify(prescriptionDetail).setConfirmatoryDiagnosis(eq("Confirmatory Diagnosis"));
		verify(prescriptionDetail).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(prescriptionDetail).setCreatedDate(Mockito.<Timestamp>any());
		verify(prescriptionDetail).setDeleted(Mockito.<Boolean>any());
		verify(prescriptionDetail).setDiagnosisProvided(eq("Diagnosis Provided"));
		verify(prescriptionDetail).setDiagnosisProvided_SCTCode(eq("Diagnosis Provided SCTCode"));
		verify(prescriptionDetail).setDiagnosisProvided_SCTTerm(eq("Diagnosis Provided SCTTerm"));
		verify(prescriptionDetail).setExternalInvestigation(eq("External Investigation"));
		verify(prescriptionDetail).setInstruction(eq("Instruction"));
		verify(prescriptionDetail).setLastModDate(Mockito.<Timestamp>any());
		verify(prescriptionDetail).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(prescriptionDetail).setParkingPlaceID(Mockito.<Integer>any());
		verify(prescriptionDetail).setPrescribedDrugs(Mockito.<ArrayList<PrescribedDrugDetail>>any());
		verify(prescriptionDetail).setPrescriptionID(Mockito.<Long>any());
		verify(prescriptionDetail).setProcessed(eq("Processed"));
		verify(prescriptionDetail).setProviderServiceMapID(Mockito.<Integer>any());
		verify(prescriptionDetail).setProvisionalDiagnosisList(Mockito.<ArrayList<SCTDescription>>any());
		verify(prescriptionDetail).setRemarks(eq("Remarks"));
		verify(prescriptionDetail).setReservedForChange(eq("Reserved For Change"));
		verify(prescriptionDetail).setSyncedBy(eq("Synced By"));
		verify(prescriptionDetail).setSyncedDate(Mockito.<Timestamp>any());
		verify(prescriptionDetail).setVanID(Mockito.<Integer>any());
		verify(prescriptionDetail).setVanSerialNo(Mockito.<Long>any());
		verify(prescriptionDetail).setVehicalNo(eq("Vehical No"));
		verify(prescriptionDetail).setVisitCode(Mockito.<Long>any());
		verify(prescriptionDetailRepo).findByBeneficiaryRegIDAndVisitCode(Mockito.<Long>any(), Mockito.<Long>any());
	}
}
