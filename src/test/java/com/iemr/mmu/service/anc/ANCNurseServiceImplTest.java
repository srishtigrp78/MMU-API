package com.iemr.mmu.service.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.Gson;
import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.ANCWomenVaccineDetail;
import com.iemr.mmu.data.anc.BenAdherence;
import com.iemr.mmu.data.anc.SysObstetricExamination;
import com.iemr.mmu.data.anc.WrapperAncImmunization;
import com.iemr.mmu.data.anc.WrapperBenInvestigationANC;
import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;
import com.iemr.mmu.repo.nurse.anc.ANCCareRepo;
import com.iemr.mmu.repo.nurse.anc.ANCWomenVaccineRepo;
import com.iemr.mmu.repo.nurse.anc.BenAdherenceRepo;
import com.iemr.mmu.repo.nurse.anc.SysObstetricExaminationRepo;
import com.iemr.mmu.repo.quickConsultation.LabTestOrderDetailRepo;

import jakarta.mail.internet.ParseException;

@ExtendWith(MockitoExtension.class)
class ANCNurseServiceImplTest {

	@Mock
	private ANCCareRepo ancCareRepo;
	@Mock
	private ANCWomenVaccineRepo ancWomenVaccineRepo;
	@Mock
	private BenAdherenceRepo benAdherenceRepo;
	@Mock
	private SysObstetricExaminationRepo sysObstetricExaminationRepo;
	@Mock
	private LabTestOrderDetailRepo labTestOrderDetailRepo;
	@InjectMocks
	ANCNurseServiceImpl ancNurseServiceImpl;

	@Test
	void testSaveBeneficiaryANCDetails() {
		ANCCareDetails ancCareDetails = new ANCCareDetails();

		ancCareDetails.setID(1L);

		when(ancCareRepo.save(any(ANCCareDetails.class))).thenReturn(ancCareDetails);

		Long ancCareID = ancNurseServiceImpl.saveBeneficiaryANCDetails(new ANCCareDetails());

		assertEquals(ancCareDetails.getID(), ancCareID, "The saved ID should match the expected ID.");
	}

	@Test
	void testSaveANCWomenVaccineDetails() {
		ANCWomenVaccineDetail vaccineDetail1 = new ANCWomenVaccineDetail();
		vaccineDetail1.setID(1L);
		ANCWomenVaccineDetail vaccineDetail2 = new ANCWomenVaccineDetail();
		vaccineDetail2.setID(2L);

		List<ANCWomenVaccineDetail> vaccineDetails = Arrays.asList(vaccineDetail1, vaccineDetail2);

		when(ancWomenVaccineRepo.saveAll(any(List.class))).thenReturn(vaccineDetails);

		Long lastSavedId = ancNurseServiceImpl.saveANCWomenVaccineDetails(vaccineDetails);

		assertEquals(vaccineDetail2.getID(), lastSavedId,
				"The returned ID should match the ID of the last saved vaccine detail.");
	}

	@Test
	void testSaveBenInvestigationFromDoc_WithNonEmptyList() {
		// Arrange
		WrapperBenInvestigationANC wrapper = new WrapperBenInvestigationANC();
		wrapper.setBeneficiaryRegID(1L);
		wrapper.setBenVisitID(2L);
		wrapper.setProviderServiceMapID(3);
		wrapper.setCreatedBy("TestUser");
		wrapper.setPrescriptionID(4L);

		ArrayList<LabTestOrderDetail> investigationList = new ArrayList<>();
		LabTestOrderDetail detail = new LabTestOrderDetail();
		investigationList.add(detail);
		wrapper.setLaboratoryList(investigationList);

		when(labTestOrderDetailRepo.saveAll(any())).thenReturn(investigationList);

		Integer result = ancNurseServiceImpl.saveBenInvestigationFromDoc(wrapper);

		assertEquals(Integer.valueOf(1), result);
		verify(labTestOrderDetailRepo, times(1)).saveAll(any());
	}

	@Test
	void testSaveBenInvestigationFromDoc_WithEmptyList() {
		WrapperBenInvestigationANC wrapper = new WrapperBenInvestigationANC();
		wrapper.setLaboratoryList(new ArrayList<>()); // Empty list

		Integer result = ancNurseServiceImpl.saveBenInvestigationFromDoc(wrapper);

		assertEquals(Integer.valueOf(1), result);
		verify(labTestOrderDetailRepo, never()).saveAll(any());
	}

	@Test
	void testSaveBenAncCareDetails() throws ParseException, java.text.ParseException {
		// Prepare test data
		ANCCareDetails ancCareDetails = new ANCCareDetails();
		ancCareDetails.setLmpDate("2023-01-01T00:00:00Z");
		ancCareDetails.setExpDelDt("2023-09-08T00:00:00Z");

		ANCCareDetails savedDetails = new ANCCareDetails();
		savedDetails.setID(1L);
		when(ancCareRepo.save(any(ANCCareDetails.class))).thenReturn(savedDetails);

		Long result = ancNurseServiceImpl.saveBenAncCareDetails(ancCareDetails);

		assertNotNull(result);
		assertEquals(1L, result);

		verify(ancCareRepo, times(1)).save(any(ANCCareDetails.class));
	}

//	@Test
//	void testSaveAncImmunizationDetails() {
//
//	}

	@Test
	void testSaveAncImmunizationDetails_Success() throws ParseException, java.text.ParseException {
		// Arrange
		WrapperAncImmunization wrapper = new WrapperAncImmunization(); // Assuming you have a constructor or a method to
																		// populate this
		ANCWomenVaccineDetail detail = new ANCWomenVaccineDetail();
		detail.setID(1L); // Mock ID for testing
		when(ancWomenVaccineRepo.saveAll(any())).thenReturn(Arrays.asList(detail));

		// Act
		Long result = ancNurseServiceImpl.saveAncImmunizationDetails(wrapper);

		// Assert
		assertNotNull(result);
		assertEquals(1L, result);
	}

	@Test
	void testSaveAncImmunizationDetails_Failure() throws ParseException, java.text.ParseException {
		// Arrange
		WrapperAncImmunization wrapper = new WrapperAncImmunization(); // Setup your wrapper accordingly
		when(ancWomenVaccineRepo.saveAll(any())).thenReturn(Collections.emptyList());

		// Act
		Long result = ancNurseServiceImpl.saveAncImmunizationDetails(wrapper);

		// Assert
		assertNull(result);
	}

	@Test
	void testSaveSysObstetricExamination() {
		SysObstetricExamination obstetricExamination = new SysObstetricExamination();
		obstetricExamination.setID(1L); // Assuming your entity has a setter method for ID

		when(sysObstetricExaminationRepo.save(obstetricExamination)).thenReturn(obstetricExamination);

		Long result = ancNurseServiceImpl.saveSysObstetricExamination(obstetricExamination);

		assertEquals(1L, result);
	}

	@Test
	void testGetSysObstetricExamination() {
		Long benRegID = 1L;
		Long visitCode = 1L;
		SysObstetricExamination expectedObstetricExamination = new SysObstetricExamination();
		expectedObstetricExamination.setID(1L);

		when(sysObstetricExaminationRepo.getSysObstetricExaminationData(benRegID, visitCode))
				.thenReturn(expectedObstetricExamination);

		SysObstetricExamination result = ancNurseServiceImpl.getSysObstetricExamination(benRegID, visitCode);

		assertEquals(expectedObstetricExamination, result);
	}

	@Test
	void testGetANCCareDetails() {
		Long beneficiaryRegID = 1L;
		Long visitCode = 101L;

		ArrayList<Object[]> mockResponse = new ArrayList<>();
		when(ancCareRepo.getANCCareDetails(beneficiaryRegID, visitCode)).thenReturn(mockResponse);

		ANCCareDetails expectedDetails = new ANCCareDetails();

		String expectedJson = new Gson().toJson(expectedDetails);
		String resultJson = ancNurseServiceImpl.getANCCareDetails(beneficiaryRegID, visitCode);

		assertNotNull(resultJson);
	}

	@Test
	void testGetANCWomenVaccineDetails() {
		Long beneficiaryRegID = 1L;
		Long visitCode = 101L;

		ArrayList<Object[]> mockResponse = new ArrayList<>();
		when(ancWomenVaccineRepo.getANCWomenVaccineDetails(beneficiaryRegID, visitCode)).thenReturn(mockResponse);

		WrapperAncImmunization expected = new WrapperAncImmunization();

		String expectedJson = new Gson().toJson(expected);
		String result = ancNurseServiceImpl.getANCWomenVaccineDetails(beneficiaryRegID, visitCode);

		assertNotNull(result);
		assertEquals(expectedJson, result);
		verify(ancWomenVaccineRepo, times(1)).getANCWomenVaccineDetails(beneficiaryRegID, visitCode);
	}

	@Test
	void testUpdateBenAdherenceDetails_WhenProcessedIsNotN() {
		BenAdherence benAdherence = new BenAdherence();
		benAdherence.setBeneficiaryRegID(1L);
		benAdherence.setBenVisitID(1L);
		benAdherence.setID(1L);
		benAdherence.setToDrugs(true);
		benAdherence.setDrugReason("Reason");
		benAdherence.setToReferral(true);
		benAdherence.setReferralReason("Reason");
		benAdherence.setProgress("Good");
		benAdherence.setModifiedBy("Nurse");

		when(benAdherenceRepo.getBenAdherenceDetailsStatus(anyLong(), anyLong(), anyLong())).thenReturn("Y");

		when(benAdherenceRepo.updateBenAdherence(anyBoolean(), anyString(), anyBoolean(), anyString(), anyString(),
				anyString(), anyString(), anyLong(), anyLong(), anyLong())).thenReturn(1);

		int result = ancNurseServiceImpl.updateBenAdherenceDetails(benAdherence);

		assertEquals(1, result);
	}

	@Test
	void testUpdateBenAdherenceDetails_WhenProcessedIsN() {
		BenAdherence benAdherence = new BenAdherence();
		benAdherence.setBeneficiaryRegID(1L);
		benAdherence.setBenVisitID(1L);
		benAdherence.setID(1L);
		benAdherence.setToDrugs(true);
		benAdherence.setDrugReason("Reason");
		benAdherence.setToReferral(true);
		benAdherence.setReferralReason("Reason");
		benAdherence.setProgress("Good");
		benAdherence.setModifiedBy("Nurse");

		when(benAdherenceRepo.getBenAdherenceDetailsStatus(anyLong(), anyLong(), anyLong())).thenReturn("N");

		when(benAdherenceRepo.updateBenAdherence(anyBoolean(), anyString(), anyBoolean(), anyString(), anyString(),
				anyString(), anyString(), anyLong(), anyLong(), anyLong())).thenReturn(1);

		int result = ancNurseServiceImpl.updateBenAdherenceDetails(benAdherence);

		assertEquals(1, result);
	}

	@Test
	public void testUpdateBenAncCareDetails() throws ParseException, java.text.ParseException {
		ANCCareDetails ancCareDetailsOBJ = new ANCCareDetails();
		ancCareDetailsOBJ.setBeneficiaryRegID(1L);
		ancCareDetailsOBJ.setVisitCode(1L);
		ancCareDetailsOBJ.setLmpDate("2023-01-01T00:00:00");
		ancCareDetailsOBJ.setExpDelDt("2023-09-08T00:00:00");

		when(ancCareRepo.getBenANCCareDetailsStatus(any(Long.class), any(Long.class))).thenReturn("Y");
		when(ancCareRepo.updateANCCareDetails(any(), any(), any(), any(), any(), any(), any(), any(), any(), any(),
				any(), any(), any(), any(), any(), any(), any(Long.class), any(Long.class), any())).thenReturn(1);

		int result = ancNurseServiceImpl.updateBenAncCareDetails(ancCareDetailsOBJ);

		assertEquals(1, result);
	}

	@Test
	void testUpdateBenAncImmunizationDetails_NonEmptyList() throws java.text.ParseException {
		WrapperAncImmunization wrapperAncImmunization = new WrapperAncImmunization();

		wrapperAncImmunization.setBeneficiaryRegID(1L);
		wrapperAncImmunization.setBenVisitID(1L);
		wrapperAncImmunization.setVisitCode(1L);
		wrapperAncImmunization.setProviderServiceMapID(1);
		wrapperAncImmunization.setCreatedBy("Admin");
		wrapperAncImmunization.settT1ID(1L);
		wrapperAncImmunization.settT_1Status("ok");
		wrapperAncImmunization.setDateReceivedForTT_1("01-01-2024");
		wrapperAncImmunization.setFacilityNameOfTT_1("S1");
		wrapperAncImmunization.settT2ID(2L);
		wrapperAncImmunization.settT_2Status("ok");
		wrapperAncImmunization.setDateReceivedForTT_1("01-01-2024");
		wrapperAncImmunization.setFacilityNameOfTT_1("S2");
		wrapperAncImmunization.settT3ID(3L);
		wrapperAncImmunization.settT_3Status("ok");
		wrapperAncImmunization.setDateReceivedForTT_3("01-01-2024");
		wrapperAncImmunization.setFacilityNameOfTT_3("S3");
		wrapperAncImmunization.setModifiedBy("user3");
		wrapperAncImmunization.setVanID(1);
		wrapperAncImmunization.setParkingPlaceID(1);

		List<ANCWomenVaccineDetail> ancWomenVaccineDetailList = new ArrayList<ANCWomenVaccineDetail>();
		ANCWomenVaccineDetail detail = new ANCWomenVaccineDetail();

		detail.setID(1L);
		detail.setBeneficiaryRegID(1L);
		detail.setBenVisitID(1L);
		detail.setProviderServiceMapID(1);
		detail.setVisitCode(1L);
		detail.setVaccineName("ABC");
		detail.setStatus("Available");
		// detail.setReceivedDate("01-10-2024");
		detail.setReceivedFacilityName("x");
		detail.setDeleted(false);
		detail.setProcessed("yes");
		detail.setCreatedBy("user1");
		// detail.setCreatedDate(null);
		detail.setModifiedBy("user2");
		// detail.setLastModDate(null);
		detail.setVanSerialNo(1L);
		detail.setVanID(1);
		detail.setVehicalNo("MH 11 BX 1234");
		detail.setParkingPlaceID(1);
		detail.setSyncedBy("user1");
		// detail.setSyncedDate(null);
		detail.setReservedForChange("xyz");

		ancWomenVaccineDetailList.add(detail);

		ArrayList<Object[]> ancWomenVaccineStatuses = new ArrayList<>();
		Object[] status = { "VaccineName", "Y" };
		ancWomenVaccineStatuses.add(status);

		when(ancWomenVaccineRepo.getBenANCWomenVaccineStatus(anyLong(), anyLong())).thenReturn(ancWomenVaccineStatuses);
		when(ancWomenVaccineRepo.updateANCImmunizationDetails(anyString(), any(), anyString(), anyString(), anyString(),
				anyLong(), anyLong(), anyString())).thenReturn(1);

		int result = ancNurseServiceImpl.updateBenAncImmunizationDetails(wrapperAncImmunization);

		assertEquals(1, result);
	}

	@Test
	void testUpdateBenAncImmunizationDetails_EmptyList() throws java.text.ParseException {
		// Given: Setup WrapperAncImmunization with necessary details but no specific
		// vaccine details
		WrapperAncImmunization wrapperAncImmunization = new WrapperAncImmunization();
		wrapperAncImmunization.setBeneficiaryRegID(1L);
		wrapperAncImmunization.setBenVisitID(1L);
		wrapperAncImmunization.setVisitCode(1L);
		wrapperAncImmunization.setProviderServiceMapID(1);
		wrapperAncImmunization.setCreatedBy("Admin");
		wrapperAncImmunization.setModifiedBy("user3");
		wrapperAncImmunization.setVanID(1);
		wrapperAncImmunization.setParkingPlaceID(1);


		// When: Execute the method under test
		int result = ancNurseServiceImpl.updateBenAncImmunizationDetails(wrapperAncImmunization);

		// Then: Expect no updates to have been performed, indicated by a result of 0
		// (assuming that your method returns 0 if no updates are performed)
		assertEquals(0, result);

		// Verify that updateANCImmunizationDetails was never called due to empty list
		// scenario
		verify(ancWomenVaccineRepo, never()).updateANCImmunizationDetails(anyString(), any(), anyString(), anyString(),
				anyString(), anyLong(), anyLong(), anyString());
	}


	@Test
	public void testUpdateSysObstetricExaminationProcessedStatusNotN() {
		SysObstetricExamination obstetricExamination = new SysObstetricExamination();
		obstetricExamination.setID(1L);
		obstetricExamination.setBeneficiaryRegID(1L);
		obstetricExamination.setBenVisitID(1L);
		obstetricExamination.setProviderServiceMapID(1);
		obstetricExamination.setVisitCode(1L);
		obstetricExamination.setFundalHeight("5cm");
		obstetricExamination.setfHAndPOA_Status("ok");
		obstetricExamination.setfHAndPOA_Interpretation("ok");
		obstetricExamination.setFetalMovements("yes");
		obstetricExamination.setFetalHeartSounds("observed");
		obstetricExamination.setFetalHeartRate_BeatsPerMinute("70");
		obstetricExamination.setFetalPositionOrLie("ok");
		obstetricExamination.setFetalPresentation("ok");
		obstetricExamination.setAbdominalScars("None");
		obstetricExamination.setDeleted(false);
		obstetricExamination.setProcessed("yes");
		obstetricExamination.setCreatedBy("user1");
		obstetricExamination.setModifiedBy("user1");
		obstetricExamination.setLastModDate(null);
		obstetricExamination.setVanSerialNo(1L);
		obstetricExamination.setVehicalNo("");
		obstetricExamination.setParkingPlaceID(1);
		obstetricExamination.setSyncedBy("user1");
		obstetricExamination.setSyncedDate(null);
		obstetricExamination.setReservedForChange("no");

		when(sysObstetricExaminationRepo.getBenObstetricExaminationStatus(anyLong(), anyLong())).thenReturn("Y");
		when(sysObstetricExaminationRepo.updateSysObstetricExamination(any(), any(), any(), any(), any(), any(), any(),
				any(), any(), any(), any(), anyString(), anyLong(), anyLong())).thenReturn(1);

		int result = ancNurseServiceImpl.updateSysObstetricExamination(obstetricExamination);
		assertEquals(1, result);
	}

	@Test
	public void testUpdateSysObstetricExaminationProcessedStatusN() {
		SysObstetricExamination obstetricExamination = new SysObstetricExamination();
		obstetricExamination.setID(1L);
		obstetricExamination.setBeneficiaryRegID(1L);
		obstetricExamination.setBenVisitID(1L);
		obstetricExamination.setProviderServiceMapID(1);
		obstetricExamination.setVisitCode(1L);
		obstetricExamination.setFundalHeight("5cm");
		obstetricExamination.setfHAndPOA_Status("ok");
		obstetricExamination.setfHAndPOA_Interpretation("ok");
		obstetricExamination.setFetalMovements("yes");
		obstetricExamination.setFetalHeartSounds("observed");
		obstetricExamination.setFetalHeartRate_BeatsPerMinute("70");
		obstetricExamination.setFetalPositionOrLie("ok");
		obstetricExamination.setFetalPresentation("ok");
		obstetricExamination.setAbdominalScars("None");
		obstetricExamination.setDeleted(false);
		obstetricExamination.setProcessed("yes");
		obstetricExamination.setCreatedBy("user1");
		obstetricExamination.setModifiedBy("user1");
		obstetricExamination.setLastModDate(null);
		obstetricExamination.setVanSerialNo(1L);
		obstetricExamination.setVehicalNo("");
		obstetricExamination.setParkingPlaceID(1);
		obstetricExamination.setSyncedBy("user1");
		obstetricExamination.setSyncedDate(null);
		obstetricExamination.setReservedForChange("no");

		when(sysObstetricExaminationRepo.getBenObstetricExaminationStatus(anyLong(), anyLong())).thenReturn("N");
		when(sysObstetricExaminationRepo.updateSysObstetricExamination(any(), any(), any(), any(), any(), any(), any(),
				any(), any(), any(), any(), anyString(), anyLong(), anyLong())).thenReturn(1);

		int result = ancNurseServiceImpl.updateSysObstetricExamination(obstetricExamination);
		assertEquals(1, result);
	}

}
