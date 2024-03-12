//package com.iemr.mmu.service.anc;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
//import com.iemr.mmu.data.benFlowStatus.I_bendemographics;
//import com.iemr.mmu.data.masterdata.registrar.GenderMaster;
//import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
//import com.iemr.mmu.repo.nurse.anc.ANCCareRepo;
//import com.iemr.mmu.repo.nurse.anc.ANCDiagnosisRepo;
//import com.iemr.mmu.repo.nurse.anc.FemaleObstetricHistoryRepo;
//import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
//import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
//import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
//import com.iemr.mmu.service.labtechnician.LabTechnicianServiceImpl;
//import com.iemr.mmu.service.tele_consultation.TeleConsultationServiceImpl;
//@ExtendWith(MockitoExtension.class)
//class ANCServiceImplTest {
//
//	@Mock
//	private ANCNurseServiceImpl ancNurseServiceImpl;
//	@Mock
//	private ANCDoctorServiceImpl ancDoctorServiceImpl;
//	@Mock
//	private CommonNurseServiceImpl commonNurseServiceImpl;
//	@Mock
//	private CommonDoctorServiceImpl commonDoctorServiceImpl;
//	@Mock
//	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;
//	@Mock
//	private LabTechnicianServiceImpl labTechnicianServiceImpl;
//	@Mock
//	private TeleConsultationServiceImpl teleConsultationServiceImpl;
//	@Mock
//	private ANCCareRepo ancCareRepo;
//	@Mock
//	private FemaleObstetricHistoryRepo femaleObstetricHistoryRepo;
//	@Mock
//	private ANCDiagnosisRepo aNCDiagnosisRepo;
//
//	@Mock
//	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
//
//	@InjectMocks
//	ANCServiceImpl ancServiceImpl;
//
//	@Test
//	void testSaveANCNurseData() throws Exception {
//		// Arrange, Act and Assert
//		assertNull(ancServiceImpl.saveANCNurseData(new JsonObject()));
//		assertNull(ancServiceImpl.saveANCNurseData(null));
//	}
//
//	@Test
//	void testSaveANCNurseData2() throws Exception {
//		// Arrange
//		I_bendemographics i_bendemographics = new I_bendemographics();
//		i_bendemographics.setDistrictBranchID(1);
//		i_bendemographics.setDistrictBranchName("janedoe/featurebranch");
//		i_bendemographics.setDistrictID(1);
//		i_bendemographics.setDistrictName("District Name");
//		i_bendemographics.setServicePointID(1);
//		i_bendemographics.setServicePointName("Service Point Name");
//
//		GenderMaster m_gender = new GenderMaster();
//		m_gender.setDeleted(true);
//		m_gender.setGenderID((short) 1);
//		m_gender.setGenderName("Gender Name");
//
//		BeneficiaryFlowStatus beneficiaryFlowStatus = new BeneficiaryFlowStatus();
//		beneficiaryFlowStatus.setAge("Age");
//		beneficiaryFlowStatus.setAgeVal(42);
//		beneficiaryFlowStatus.setAgentId("42");
//		beneficiaryFlowStatus.setAuth("Auth");
//		beneficiaryFlowStatus.setBenArrivedFlag(true);
//		beneficiaryFlowStatus.setBenFlowID(1L);
//		beneficiaryFlowStatus.setBenImage("Ben Image");
//		beneficiaryFlowStatus.setBenName("Ben Name");
//		beneficiaryFlowStatus.setBenPhoneMaps(new ArrayList<>());
//		beneficiaryFlowStatus.setBenVisitCode(1L);
//	//	beneficiaryFlowStatus.setBenVisitDate(mock(Timestamp.class));
//		beneficiaryFlowStatus.setBenVisitID(1L);
//		beneficiaryFlowStatus.setBenVisitNo((short) 1);
//		beneficiaryFlowStatus.setBen_age_val(42);
//		beneficiaryFlowStatus.setBeneficiaryID(1L);
//		beneficiaryFlowStatus.setBeneficiaryName("Beneficiary Name");
//		beneficiaryFlowStatus.setBeneficiaryRegID(1L);
//		beneficiaryFlowStatus.setBloodGroup("Blood Group");
//		beneficiaryFlowStatus.setConsultantID(1);
//		beneficiaryFlowStatus.setConsultantName("Consultant Name");
//		// beneficiaryFlowStatus.setConsultationDate(mock(Timestamp.class));
//		beneficiaryFlowStatus.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
//		// beneficiaryFlowStatus.setCreatedDate(mock(Timestamp.class));
//		beneficiaryFlowStatus.setDeleted(true);
//		beneficiaryFlowStatus.setDistrictID(1);
//		beneficiaryFlowStatus.setDistrictName("District Name");
//		beneficiaryFlowStatus.setDoctorFlag((short) 1);
//		beneficiaryFlowStatus.setFatherName("Father Name");
//		beneficiaryFlowStatus.setFirstName("Jane");
//		beneficiaryFlowStatus.setGenderID((short) 1);
//		beneficiaryFlowStatus.setGenderName("Gender Name");
//		beneficiaryFlowStatus.setI_bendemographics(i_bendemographics);
//		beneficiaryFlowStatus.setIsCaseSheetdownloaded(true);
//		beneficiaryFlowStatus.setIsTMVisitDone(true);
//		beneficiaryFlowStatus.setLabIteration((short) 1);
//		beneficiaryFlowStatus.setLab_technician_flag((short) 1);
//		beneficiaryFlowStatus.setLastName("Doe");
//		beneficiaryFlowStatus.setM_gender(m_gender);
//		beneficiaryFlowStatus.setModified_by("Jan 1, 2020 9:00am GMT+0100");
//		// beneficiaryFlowStatus.setModified_date(mock(Timestamp.class));
//		beneficiaryFlowStatus.setNurseFlag((short) 1);
//		beneficiaryFlowStatus.setOncologist_flag((short) 1);
//		beneficiaryFlowStatus.setParkingPlaceID(1);
//		beneficiaryFlowStatus.setPassToNurse(true);
//		beneficiaryFlowStatus.setPharmacist_flag((short) 1);
//		beneficiaryFlowStatus.setPreferredPhoneNum("6625550144");
//		beneficiaryFlowStatus.setProcessed("Processed");
//		beneficiaryFlowStatus.setProviderServiceMapID(1);
//		beneficiaryFlowStatus.setProviderServiceMapId(1);
//		beneficiaryFlowStatus.setRadiologist_flag((short) 1);
//		beneficiaryFlowStatus.setReferredVisitCode(1L);
//		// beneficiaryFlowStatus.setRegistrationDate(mock(Timestamp.class));
//		beneficiaryFlowStatus.setReservedForChange("Reserved For Change");
//		// beneficiaryFlowStatus.setServiceDate(mock(Timestamp.class));
//		beneficiaryFlowStatus.setServicePointID(1);
//		beneficiaryFlowStatus.setServicePointName("Service Point Name");
//		beneficiaryFlowStatus.setSpecialist_flag((short) 1);
//		beneficiaryFlowStatus.setSpouseName("Spouse Name");
//		beneficiaryFlowStatus.setSyncedBy("Synced By");
//		// beneficiaryFlowStatus.setSyncedDate(mock(Timestamp.class));
//		beneficiaryFlowStatus.setVanID(1);
//		beneficiaryFlowStatus.setVanNo("Van No");
//		beneficiaryFlowStatus.setVanSerialNo(1L);
//		beneficiaryFlowStatus.setVehicalNo("Vehical No");
//		beneficiaryFlowStatus.setVillageID(1);
//		beneficiaryFlowStatus.setVillageName("Village Name");
//		beneficiaryFlowStatus.setVisitCategory("Visit Category");
//		beneficiaryFlowStatus.setVisitCode(1L);
//		// beneficiaryFlowStatus.setVisitDate(mock(Timestamp.class));
//		beneficiaryFlowStatus.setVisitReason("Just cause");
//		beneficiaryFlowStatus.setVisitSession(1);
//		// beneficiaryFlowStatus.setdOB(mock(Timestamp.class));
//		// beneficiaryFlowStatus.settCRequestDate(mock(Timestamp.class));
//		beneficiaryFlowStatus.settCSpecialistUserID(1);
//		beneficiaryFlowStatus.settC_SpecialistLabFlag((short) 1);
//		when(beneficiaryFlowStatusRepo.checkExistData(Mockito.<Long>any(), Mockito.<Short>any()))
//				.thenReturn(beneficiaryFlowStatus);
//
//		JsonObject requestOBJ = new JsonObject();
//		requestOBJ.add("visitDetails", new JsonArray(3));
//
//		// Act
//		Long actualSaveANCNurseDataResult = ancServiceImpl.saveANCNurseData(requestOBJ);
//
//		// Assert
//		verify(beneficiaryFlowStatusRepo).checkExistData(Mockito.<Long>any(), Mockito.<Short>any());
//		assertEquals(0L, actualSaveANCNurseDataResult.longValue());
//	}
//
//
//}
package com.iemr.mmu.service.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.BenFamilyHistory;
import com.iemr.mmu.data.anc.BenMedHistory;
import com.iemr.mmu.data.anc.BenMenstrualDetails;
import com.iemr.mmu.data.anc.BenPersonalHabit;
import com.iemr.mmu.data.anc.PhyGeneralExamination;
import com.iemr.mmu.data.anc.PhyHeadToToeExamination;
import com.iemr.mmu.data.anc.SysCardiovascularExamination;
import com.iemr.mmu.data.anc.SysCentralNervousExamination;
import com.iemr.mmu.data.anc.SysGenitourinarySystemExamination;
import com.iemr.mmu.data.anc.SysMusculoskeletalSystemExamination;
import com.iemr.mmu.data.anc.SysObstetricExamination;
import com.iemr.mmu.data.anc.SysRespiratoryExamination;
import com.iemr.mmu.data.anc.WrapperChildOptionalVaccineDetail;
import com.iemr.mmu.data.anc.WrapperComorbidCondDetails;
import com.iemr.mmu.data.anc.WrapperFemaleObstetricHistory;
import com.iemr.mmu.data.anc.WrapperImmunizationHistory;
import com.iemr.mmu.data.anc.WrapperMedicationHistory;
import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.data.benFlowStatus.I_bendemographics;
import com.iemr.mmu.data.location.Districts;
import com.iemr.mmu.data.location.States;
import com.iemr.mmu.data.masterdata.registrar.GenderMaster;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.nurse.CommonUtilityClass;
import com.iemr.mmu.data.provider.ProviderServiceMapping;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.location.ZoneDistrictMapping;
import com.iemr.mmu.repo.nurse.BenAnthropometryRepo;
import com.iemr.mmu.repo.nurse.anc.ANCCareRepo;
import com.iemr.mmu.repo.nurse.anc.ANCDiagnosisRepo;
import com.iemr.mmu.repo.nurse.anc.BenMedHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BencomrbidityCondRepo;
import com.iemr.mmu.repo.nurse.anc.FemaleObstetricHistoryRepo;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.labtechnician.LabTechnicianServiceImpl;
import com.iemr.mmu.service.tele_consultation.TeleConsultationServiceImpl;

@ExtendWith(MockitoExtension.class)
class ANCServiceImplTest {
	@Mock
	private ANCCareRepo aNCCareRepo;

	@Mock
	private ANCDiagnosisRepo aNCDiagnosisRepo;

	@Mock
	private ANCDoctorServiceImpl aNCDoctorServiceImpl;

	@Mock
	private ANCNurseServiceImpl aNCNurseServiceImpl;

	@InjectMocks
	private ANCServiceImpl aNCServiceImpl;

	@Mock
	private BenAnthropometryRepo benAnthropometryRepo;

	@Mock
	private BenMedHistoryRepo benMedHistoryRepo;

	@Mock
	private BencomrbidityCondRepo bencomrbidityCondRepo;

	@Mock
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;

	@Mock
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;

	@Mock
	private CommonDoctorServiceImpl commonDoctorServiceImpl;

	@Mock
	private CommonNurseServiceImpl commonNurseServiceImpl;

	@Mock
	private FemaleObstetricHistoryRepo femaleObstetricHistoryRepo;

	@Mock
	private LabTechnicianServiceImpl labTechnicianServiceImpl;

	@Mock
	private TeleConsultationServiceImpl teleConsultationServiceImpl;

	@Test
	void testSetAncNurseServiceImpl() {
		// TODO: Diffblue Cover was only able to create a partial test for this method:
		// Reason: Missing observers.
		// Diffblue Cover was unable to create an assertion.
		// Add getters for the following fields or make them package-private:
		// ANCServiceImpl.aNCDiagnosisRepo
		// ANCServiceImpl.ancCareRepo
		// ANCServiceImpl.ancDoctorServiceImpl
		// ANCServiceImpl.ancNurseServiceImpl
		// ANCServiceImpl.benAnthropometryRepo
		// ANCServiceImpl.benMedHistoryRepo
		// ANCServiceImpl.bencomrbidityCondRepo
		// ANCServiceImpl.beneficiaryFlowStatusRepo
		// ANCServiceImpl.commonBenStatusFlowServiceImpl
		// ANCServiceImpl.commonDoctorServiceImpl
		// ANCServiceImpl.commonNurseServiceImpl
		// ANCServiceImpl.femaleObstetricHistoryRepo
		// ANCServiceImpl.labTechnicianServiceImpl
		// ANCServiceImpl.teleConsultationServiceImpl

		// Arrange
		ANCServiceImpl ancServiceImpl = new ANCServiceImpl();

		// Act
		ancServiceImpl.setAncNurseServiceImpl(new ANCNurseServiceImpl());
	}

	/**
	 * Method under test: {@link ANCServiceImpl#saveANCNurseData(JsonObject)}
	 */
	@Test
	void testSaveANCNurseData() throws Exception {
		// Arrange, Act and Assert
		assertNull(aNCServiceImpl.saveANCNurseData(new JsonObject()));
		assertNull(aNCServiceImpl.saveANCNurseData(null));
	}

	@Test
	void testSaveANCNurseData2() throws Exception {
		// Arrange
		I_bendemographics i_bendemographics = new I_bendemographics();
		i_bendemographics.setDistrictBranchID(1);
		i_bendemographics.setDistrictBranchName("janedoe/featurebranch");
		i_bendemographics.setDistrictID(1);
		i_bendemographics.setDistrictName("District Name");
		i_bendemographics.setServicePointID(1);
		i_bendemographics.setServicePointName("Service Point Name");

		GenderMaster m_gender = new GenderMaster();
		m_gender.setDeleted(true);
		m_gender.setGenderID((short) 1);
		m_gender.setGenderName("Gender Name");

		BeneficiaryFlowStatus beneficiaryFlowStatus = new BeneficiaryFlowStatus();
		beneficiaryFlowStatus.setAge("Age");
		beneficiaryFlowStatus.setAgeVal(42);
		beneficiaryFlowStatus.setAgentId("42");
		beneficiaryFlowStatus.setAuth("Auth");
		beneficiaryFlowStatus.setBenArrivedFlag(true);
		beneficiaryFlowStatus.setBenFlowID(1L);
		beneficiaryFlowStatus.setBenImage("Ben Image");
		beneficiaryFlowStatus.setBenName("Ben Name");
		beneficiaryFlowStatus.setBenPhoneMaps(new ArrayList<>());
		beneficiaryFlowStatus.setBenVisitCode(1L);
		beneficiaryFlowStatus.setBenVisitDate(mock(Timestamp.class));
		beneficiaryFlowStatus.setBenVisitID(1L);
		beneficiaryFlowStatus.setBenVisitNo((short) 1);
		beneficiaryFlowStatus.setBen_age_val(42);
		beneficiaryFlowStatus.setBeneficiaryID(1L);
		beneficiaryFlowStatus.setBeneficiaryName("Beneficiary Name");
		beneficiaryFlowStatus.setBeneficiaryRegID(1L);
		beneficiaryFlowStatus.setBloodGroup("Blood Group");
		beneficiaryFlowStatus.setConsultantID(1);
		beneficiaryFlowStatus.setConsultantName("Consultant Name");
		beneficiaryFlowStatus.setConsultationDate(mock(Timestamp.class));
		beneficiaryFlowStatus.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		beneficiaryFlowStatus.setCreatedDate(mock(Timestamp.class));
		beneficiaryFlowStatus.setDeleted(true);
		beneficiaryFlowStatus.setDistrictID(1);
		beneficiaryFlowStatus.setDistrictName("District Name");
		beneficiaryFlowStatus.setDoctorFlag((short) 1);
		beneficiaryFlowStatus.setFatherName("Father Name");
		beneficiaryFlowStatus.setFirstName("Jane");
		beneficiaryFlowStatus.setGenderID((short) 1);
		beneficiaryFlowStatus.setGenderName("Gender Name");
		beneficiaryFlowStatus.setI_bendemographics(i_bendemographics);
		beneficiaryFlowStatus.setIsCaseSheetdownloaded(true);
		beneficiaryFlowStatus.setIsTMVisitDone(true);
		beneficiaryFlowStatus.setLabIteration((short) 1);
		beneficiaryFlowStatus.setLab_technician_flag((short) 1);
		beneficiaryFlowStatus.setLastName("Doe");
		beneficiaryFlowStatus.setM_gender(m_gender);
		beneficiaryFlowStatus.setModified_by("Jan 1, 2020 9:00am GMT+0100");
		beneficiaryFlowStatus.setModified_date(mock(Timestamp.class));
		beneficiaryFlowStatus.setNurseFlag((short) 1);
		beneficiaryFlowStatus.setOncologist_flag((short) 1);
		beneficiaryFlowStatus.setParkingPlaceID(1);
		beneficiaryFlowStatus.setPassToNurse(true);
		beneficiaryFlowStatus.setPharmacist_flag((short) 1);
		beneficiaryFlowStatus.setPreferredPhoneNum("6625550144");
		beneficiaryFlowStatus.setProcessed("Processed");
		beneficiaryFlowStatus.setProviderServiceMapID(1);
		beneficiaryFlowStatus.setProviderServiceMapId(1);
		beneficiaryFlowStatus.setRadiologist_flag((short) 1);
		beneficiaryFlowStatus.setReferredVisitCode(1L);
		beneficiaryFlowStatus.setRegistrationDate(mock(Timestamp.class));
		beneficiaryFlowStatus.setReservedForChange("Reserved For Change");
		beneficiaryFlowStatus.setServiceDate(mock(Timestamp.class));
		beneficiaryFlowStatus.setServicePointID(1);
		beneficiaryFlowStatus.setServicePointName("Service Point Name");
		beneficiaryFlowStatus.setSpecialist_flag((short) 1);
		beneficiaryFlowStatus.setSpouseName("Spouse Name");
		beneficiaryFlowStatus.setSyncedBy("Synced By");
		beneficiaryFlowStatus.setSyncedDate(mock(Timestamp.class));
		beneficiaryFlowStatus.setVanID(1);
		beneficiaryFlowStatus.setVanNo("Van No");
		beneficiaryFlowStatus.setVanSerialNo(1L);
		beneficiaryFlowStatus.setVehicalNo("Vehical No");
		beneficiaryFlowStatus.setVillageID(1);
		beneficiaryFlowStatus.setVillageName("Village Name");
		beneficiaryFlowStatus.setVisitCategory("Visit Category");
		beneficiaryFlowStatus.setVisitCode(1L);
		beneficiaryFlowStatus.setVisitDate(mock(Timestamp.class));
		beneficiaryFlowStatus.setVisitReason("Just cause");
		beneficiaryFlowStatus.setVisitSession(1);
		beneficiaryFlowStatus.setdOB(mock(Timestamp.class));
		beneficiaryFlowStatus.settCRequestDate(mock(Timestamp.class));
		beneficiaryFlowStatus.settCSpecialistUserID(1);
		beneficiaryFlowStatus.settC_SpecialistLabFlag((short) 1);
		when(beneficiaryFlowStatusRepo.checkExistData(Mockito.<Long>any(), Mockito.<Short>any()))
				.thenReturn(beneficiaryFlowStatus);

		JsonObject requestOBJ = new JsonObject();
		requestOBJ.add("visitDetails", new JsonArray(3));

		// Act
		Long actualSaveANCNurseDataResult = aNCServiceImpl.saveANCNurseData(requestOBJ);

		// Assert
		verify(beneficiaryFlowStatusRepo).checkExistData(Mockito.<Long>any(), Mockito.<Short>any());
		assertEquals(0L, actualSaveANCNurseDataResult.longValue());
	}

	@Test
	void testSaveANCDoctorData() throws Exception {
		// Arrange, Act and Assert
		assertNull(aNCServiceImpl.saveANCDoctorData(null, "JaneDoe"));
	}

	@Test
	void testSaveBenVisitDetails() throws Exception {
		// Arrange
		JsonObject visitDetailsOBJ = new JsonObject();

		CommonUtilityClass nurseUtilityClass = new CommonUtilityClass();
		nurseUtilityClass.setBenFlowID(1L);
		nurseUtilityClass.setBenVisitID(1L);
		nurseUtilityClass.setBeneficiaryID(1L);
		nurseUtilityClass.setBeneficiaryRegID(1L);
		nurseUtilityClass.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		nurseUtilityClass.setFacilityID(1);
		nurseUtilityClass.setIsSpecialist(true);
		nurseUtilityClass.setParkingPlaceID(1);
		nurseUtilityClass.setProviderServiceMapID(1);
		nurseUtilityClass.setServiceID((short) 1);
		nurseUtilityClass.setSessionID(1);
		nurseUtilityClass.setVanID(1);
		nurseUtilityClass.setVisitCode(1L);

		// Act and Assert
		assertTrue(aNCServiceImpl.saveBenVisitDetails(visitDetailsOBJ, nurseUtilityClass).isEmpty());
	}

	@Test
	void testSaveBenVisitDetails2() throws Exception {
		// Arrange
		CommonUtilityClass nurseUtilityClass = new CommonUtilityClass();
		nurseUtilityClass.setBenFlowID(1L);
		nurseUtilityClass.setBenVisitID(1L);
		nurseUtilityClass.setBeneficiaryID(1L);
		nurseUtilityClass.setBeneficiaryRegID(1L);
		nurseUtilityClass.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		nurseUtilityClass.setFacilityID(1);
		nurseUtilityClass.setIsSpecialist(true);
		nurseUtilityClass.setParkingPlaceID(1);
		nurseUtilityClass.setProviderServiceMapID(1);
		nurseUtilityClass.setServiceID((short) 1);
		nurseUtilityClass.setSessionID(1);
		nurseUtilityClass.setVanID(1);
		nurseUtilityClass.setVisitCode(1L);

		// Act and Assert
		assertTrue(aNCServiceImpl.saveBenVisitDetails(null, nurseUtilityClass).isEmpty());
	}

	@Test
	void testSaveBenVisitDetails3() throws Exception {
		// Arrange
		JsonObject visitDetailsOBJ = new JsonObject();
		visitDetailsOBJ.add("Property", new JsonArray(3));

		CommonUtilityClass nurseUtilityClass = new CommonUtilityClass();
		nurseUtilityClass.setBenFlowID(1L);
		nurseUtilityClass.setBenVisitID(1L);
		nurseUtilityClass.setBeneficiaryID(1L);
		nurseUtilityClass.setBeneficiaryRegID(1L);
		nurseUtilityClass.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		nurseUtilityClass.setFacilityID(1);
		nurseUtilityClass.setIsSpecialist(true);
		nurseUtilityClass.setParkingPlaceID(1);
		nurseUtilityClass.setProviderServiceMapID(1);
		nurseUtilityClass.setServiceID((short) 1);
		nurseUtilityClass.setSessionID(1);
		nurseUtilityClass.setVanID(1);
		nurseUtilityClass.setVisitCode(1L);

		// Act and Assert
		assertTrue(aNCServiceImpl.saveBenVisitDetails(visitDetailsOBJ, nurseUtilityClass).isEmpty());
	}

	@Test
	void testSaveBenVisitDetails4() throws Exception {
		// Arrange
		JsonObject visitDetailsOBJ = new JsonObject();
		visitDetailsOBJ.addProperty("visitDetails", (String) null);

		CommonUtilityClass nurseUtilityClass = new CommonUtilityClass();
		nurseUtilityClass.setBenFlowID(1L);
		nurseUtilityClass.setBenVisitID(1L);
		nurseUtilityClass.setBeneficiaryID(1L);
		nurseUtilityClass.setBeneficiaryRegID(1L);
		nurseUtilityClass.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		nurseUtilityClass.setFacilityID(1);
		nurseUtilityClass.setIsSpecialist(true);
		nurseUtilityClass.setParkingPlaceID(1);
		nurseUtilityClass.setProviderServiceMapID(1);
		nurseUtilityClass.setServiceID((short) 1);
		nurseUtilityClass.setSessionID(1);
		nurseUtilityClass.setVanID(1);
		nurseUtilityClass.setVisitCode(1L);

		// Act and Assert
		assertTrue(aNCServiceImpl.saveBenVisitDetails(visitDetailsOBJ, nurseUtilityClass).isEmpty());
	}

	@Test
	void testSaveBenANCDetails() throws Exception {
		// Arrange, Act and Assert
		assertNull(aNCServiceImpl.saveBenANCDetails(new JsonObject(), 1L, 1L));
		assertNull(aNCServiceImpl.saveBenANCDetails(null, 1L, 1L));
	}

	/**
	 * Method under test:
	 * {@link ANCServiceImpl#saveBenANCDetails(JsonObject, Long, Long)}
	 */
	@Test
	void testSaveBenANCDetails2() throws Exception {
		// Arrange
		JsonObject ancDetailsOBJ = new JsonObject();
		ancDetailsOBJ.add("Property", new JsonArray(3));

		// Act and Assert
		assertNull(aNCServiceImpl.saveBenANCDetails(ancDetailsOBJ, 1L, 1L));
	}

	@Test
	void testSaveBenANCDetails3() throws Exception {
		// Arrange
		JsonObject ancDetailsOBJ = new JsonObject();
		ancDetailsOBJ.addProperty("ancObstetricDetails", (String) null);

		// Act and Assert
		assertNull(aNCServiceImpl.saveBenANCDetails(ancDetailsOBJ, 1L, 1L));
	}

	@Test
	void testSaveBenANCHistoryDetails() throws Exception {
		// Arrange, Act and Assert
		assertNull(aNCServiceImpl.saveBenANCHistoryDetails(new JsonObject(), 1L, 1L));
		assertNull(aNCServiceImpl.saveBenANCHistoryDetails(null, 1L, 1L));
	}

	@Test
	void testSaveBenANCHistoryDetails2() throws Exception {
		// Arrange
		JsonObject ancHistoryOBJ = new JsonObject();
		ancHistoryOBJ.add("Property", new JsonArray(3));

		// Act and Assert
		assertNull(aNCServiceImpl.saveBenANCHistoryDetails(ancHistoryOBJ, 1L, 1L));
	}

	@Test
	void testSaveBenANCHistoryDetails3() throws Exception {
		// Arrange
		JsonObject ancHistoryOBJ = new JsonObject();
		ancHistoryOBJ.addProperty("pastHistory", (String) null);

		// Act and Assert
		assertNull(aNCServiceImpl.saveBenANCHistoryDetails(ancHistoryOBJ, 1L, 1L));
	}

	@Test
	void testSaveBenANCVitalDetails() throws Exception {
		// Arrange
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
				.thenReturn(1L);
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
				.thenReturn(1L);

		// Act
		Long actualSaveBenANCVitalDetailsResult = aNCServiceImpl.saveBenANCVitalDetails(new JsonObject(), 1L, 1L);

		// Assert
		verify(commonNurseServiceImpl)
				.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
		verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
		assertEquals(1L, actualSaveBenANCVitalDetailsResult.longValue());
	}

	@Test
	void testSaveBenANCVitalDetails2() throws Exception {
		// Arrange
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
				.thenReturn(0L);
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
				.thenReturn(1L);

		// Act
		Long actualSaveBenANCVitalDetailsResult = aNCServiceImpl.saveBenANCVitalDetails(new JsonObject(), 1L, 1L);

		// Assert
		verify(commonNurseServiceImpl)
				.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
		verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
		assertNull(actualSaveBenANCVitalDetailsResult);
	}

	@Test
	void testSaveBenANCVitalDetails3() throws Exception {
		// Arrange
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
				.thenReturn(null);
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
				.thenReturn(1L);

		// Act
		Long actualSaveBenANCVitalDetailsResult = aNCServiceImpl.saveBenANCVitalDetails(new JsonObject(), 1L, 1L);

		// Assert
		verify(commonNurseServiceImpl)
				.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
		verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
		assertNull(actualSaveBenANCVitalDetailsResult);
	}

	@Test
	void testSaveBenANCVitalDetails4() throws Exception {
		// Arrange
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
				.thenReturn(1L);
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
				.thenReturn(0L);

		// Act
		Long actualSaveBenANCVitalDetailsResult = aNCServiceImpl.saveBenANCVitalDetails(new JsonObject(), 1L, 1L);

		// Assert
		verify(commonNurseServiceImpl)
				.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
		verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
		assertNull(actualSaveBenANCVitalDetailsResult);
	}

	@Test
	void testSaveBenANCVitalDetails5() throws Exception {
		// Arrange
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
				.thenReturn(1L);
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
				.thenReturn(null);

		// Act
		Long actualSaveBenANCVitalDetailsResult = aNCServiceImpl.saveBenANCVitalDetails(new JsonObject(), 1L, 1L);

		// Assert
		verify(commonNurseServiceImpl)
				.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
		verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
		assertNull(actualSaveBenANCVitalDetailsResult);
	}

	@Test
	void testSaveBenANCVitalDetails6() throws Exception {
		// Arrange, Act and Assert
		assertNull(aNCServiceImpl.saveBenANCVitalDetails(null, 1L, 1L));
	}

	@Test
	void testSaveBenANCVitalDetails7() throws Exception {
		// Arrange
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
				.thenReturn(1L);
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
				.thenReturn(1L);

		JsonObject vitalDetailsOBJ = new JsonObject();
		vitalDetailsOBJ.add("Property", new JsonArray(3));

		// Act
		Long actualSaveBenANCVitalDetailsResult = aNCServiceImpl.saveBenANCVitalDetails(vitalDetailsOBJ, 1L, 1L);

		// Assert
		verify(commonNurseServiceImpl)
				.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
		verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
		assertEquals(1L, actualSaveBenANCVitalDetailsResult.longValue());
	}

	@Test
	void testSaveBenANCVitalDetails8() throws Exception {
		// Arrange
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
				.thenReturn(1L);
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
				.thenReturn(1L);

		JsonObject vitalDetailsOBJ = new JsonObject();
		vitalDetailsOBJ.addProperty("Property", "42");

		// Act
		Long actualSaveBenANCVitalDetailsResult = aNCServiceImpl.saveBenANCVitalDetails(vitalDetailsOBJ, 1L, 1L);

		// Assert
		verify(commonNurseServiceImpl)
				.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
		verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
		assertEquals(1L, actualSaveBenANCVitalDetailsResult.longValue());
	}

	@Test
	void testSaveBenANCVitalDetails9() throws Exception {
		// Arrange
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
				.thenReturn(1L);
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
				.thenReturn(1L);

		JsonObject vitalDetailsOBJ = new JsonObject();
		vitalDetailsOBJ.addProperty("Property", Integer.valueOf(1));

		// Act
		Long actualSaveBenANCVitalDetailsResult = aNCServiceImpl.saveBenANCVitalDetails(vitalDetailsOBJ, 1L, 1L);

		// Assert
		verify(commonNurseServiceImpl)
				.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
		verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
		assertEquals(1L, actualSaveBenANCVitalDetailsResult.longValue());
	}

	@Test
	void testSaveBenANCVitalDetails10() throws Exception {
		// Arrange
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
				.thenReturn(1L);
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any()))
				.thenReturn(1L);

		JsonObject vitalDetailsOBJ = new JsonObject();
		vitalDetailsOBJ.addProperty("Property", true);

		// Act
		Long actualSaveBenANCVitalDetailsResult = aNCServiceImpl.saveBenANCVitalDetails(vitalDetailsOBJ, 1L, 1L);

		// Assert
		verify(commonNurseServiceImpl)
				.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
		verify(commonNurseServiceImpl).saveBeneficiaryPhysicalVitalDetails(Mockito.<BenPhysicalVitalDetail>any());
		assertEquals(1L, actualSaveBenANCVitalDetailsResult.longValue());
	}

	@Test
	void testSaveBenANCVitalDetails11() throws Exception {
		// Arrange
		when(commonNurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any()))
				.thenThrow(new RuntimeException("foo"));

		// Act and Assert
		assertThrows(RuntimeException.class, () -> aNCServiceImpl.saveBenANCVitalDetails(new JsonObject(), 1L, 1L));
		verify(commonNurseServiceImpl)
				.saveBeneficiaryPhysicalAnthropometryDetails(Mockito.<BenAnthropometryDetail>any());
	}

	@Test
	void testSaveBenANCExaminationDetails() throws Exception {
		// Arrange, Act and Assert
		assertNull(aNCServiceImpl.saveBenANCExaminationDetails(new JsonObject(), 1L, 1L));
		assertNull(aNCServiceImpl.saveBenANCExaminationDetails(null, 1L, 1L));
	}

	@Test
	void testSaveBenANCExaminationDetails2() throws Exception {
		// Arrange
		JsonObject examinationDetailsOBJ = new JsonObject();
		examinationDetailsOBJ.add("Property", new JsonArray(3));

		// Act and Assert
		assertNull(aNCServiceImpl.saveBenANCExaminationDetails(examinationDetailsOBJ, 1L, 1L));
	}

	@Test
	void testSaveBenANCExaminationDetails3() throws Exception {
		// Arrange
		JsonObject examinationDetailsOBJ = new JsonObject();
		examinationDetailsOBJ.addProperty("generalExamination", (String) null);

		// Act and Assert
		assertNull(aNCServiceImpl.saveBenANCExaminationDetails(examinationDetailsOBJ, 1L, 1L));
	}

	@Test
	@Disabled("TODO: Complete this test")
	void testGetBenVisitDetailsFrmNurseANC() throws Exception {
		// TODO: Diffblue Cover was only able to create a partial test for this method:
		// Reason: No inputs found that don't throw a trivial exception.
		// Diffblue Cover tried to run the arrange/act section, but the method under
		// test threw
		// com.google.gson.JsonIOException: Failed making field
		// 'java.sql.Timestamp#nanos' accessible; either increase its visibility or
		// write a custom TypeAdapter for its declaring type.
		// at
		// com.google.gson.internal.reflect.ReflectionHelper.makeAccessible(ReflectionHelper.java:38)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.getBoundFields(ReflectiveTypeAdapterFactory.java:286)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.create(ReflectiveTypeAdapterFactory.java:130)
		// at com.google.gson.Gson.getAdapter(Gson.java:556)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:55)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1.write(ReflectiveTypeAdapterFactory.java:196)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:368)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:70)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1.write(ReflectiveTypeAdapterFactory.java:196)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:368)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:70)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1.write(ReflectiveTypeAdapterFactory.java:196)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:368)
		// at com.google.gson.Gson.toJson(Gson.java:842)
		// at com.google.gson.Gson.toJson(Gson.java:812)
		// at com.google.gson.Gson.toJson(Gson.java:759)
		// at com.google.gson.Gson.toJson(Gson.java:736)
		// at
		// com.iemr.mmu.service.anc.ANCServiceImpl.getBenVisitDetailsFrmNurseANC(ANCServiceImpl.java:981)
		// java.lang.reflect.InaccessibleObjectException: Unable to make field private
		// int java.sql.Timestamp.nanos accessible: module java.sql does not "opens
		// java.sql" to unnamed module @f87c6b6
		// at
		// com.google.gson.internal.reflect.ReflectionHelper.makeAccessible(ReflectionHelper.java:35)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.getBoundFields(ReflectiveTypeAdapterFactory.java:286)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.create(ReflectiveTypeAdapterFactory.java:130)
		// at com.google.gson.Gson.getAdapter(Gson.java:556)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:55)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1.write(ReflectiveTypeAdapterFactory.java:196)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:368)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:70)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1.write(ReflectiveTypeAdapterFactory.java:196)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:368)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:70)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1.write(ReflectiveTypeAdapterFactory.java:196)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:368)
		// at com.google.gson.Gson.toJson(Gson.java:842)
		// at com.google.gson.Gson.toJson(Gson.java:812)
		// at com.google.gson.Gson.toJson(Gson.java:759)
		// at com.google.gson.Gson.toJson(Gson.java:736)
		// at
		// com.iemr.mmu.service.anc.ANCServiceImpl.getBenVisitDetailsFrmNurseANC(ANCServiceImpl.java:981)
		// See https://diff.blue/R013 to resolve this issue.

		// Arrange
		States states = new States();
		states.setCountryID(1);
		states.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		states.setCreatedDate(mock(Timestamp.class));
		states.setDeleted(true);
		states.setLastModDate(mock(Timestamp.class));
		states.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		states.setStateCode("MD");
		states.setStateID(1);
		states.setStateIName("MD");
		states.setStateName("MD");

		ZoneDistrictMapping zoneDistrictMapping = new ZoneDistrictMapping();
		zoneDistrictMapping.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		zoneDistrictMapping.setCreatedDate(mock(Timestamp.class));
		zoneDistrictMapping.setDeleted(true);
		zoneDistrictMapping.setDistrictID(1);
		zoneDistrictMapping.setDistrictsSet(new HashSet<>());
		zoneDistrictMapping.setLastModDate(mock(Timestamp.class));
		zoneDistrictMapping.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		zoneDistrictMapping.setProcessed("Processed");
		zoneDistrictMapping.setProviderServiceMapID(1);
		zoneDistrictMapping.setZoneDistrictMapID(1);
		zoneDistrictMapping.setZoneID(1);

		Districts m_district = new Districts();
		m_district.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		m_district.setCreatedDate(mock(Timestamp.class));
		m_district.setDeleted(true);
		m_district.setDistrictID(1);
		m_district.setDistrictName("District Name");
		m_district.setLastModDate(mock(Timestamp.class));
		m_district.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		m_district.setStateID(1);
		m_district.setStates(states);
		m_district.setZoneDistrictMapping(zoneDistrictMapping);

		States state = new States();
		state.setCountryID(1);
		state.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		state.setCreatedDate(mock(Timestamp.class));
		state.setDeleted(true);
		state.setLastModDate(mock(Timestamp.class));
		state.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		state.setStateCode("MD");
		state.setStateID(1);
		state.setStateIName("MD");
		state.setStateName("MD");

		ProviderServiceMapping providerServiceMapping = new ProviderServiceMapping();
		providerServiceMapping.setAddress("42 Main St");
		providerServiceMapping.setCityID(1);
		providerServiceMapping.setCountryID(1);
		providerServiceMapping.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		providerServiceMapping.setCreatedDate(mock(Timestamp.class));
		providerServiceMapping.setDeleted(true);
		providerServiceMapping.setDistrictBlockID(1);
		providerServiceMapping.setDistrictID(1);
		providerServiceMapping.setLastModDate(mock(Timestamp.class));
		providerServiceMapping.setM_district(m_district);
		providerServiceMapping.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		providerServiceMapping.setProviderServiceMapID(1);
		providerServiceMapping.setServiceID((short) 1);
		providerServiceMapping.setServiceProviderID(1);
		providerServiceMapping.setState(state);
		providerServiceMapping.setStateID(1);
		providerServiceMapping.setStatusID(1);

		BeneficiaryVisitDetail beneficiaryVisitDetail = new BeneficiaryVisitDetail();
		beneficiaryVisitDetail.setBenVisitID(1L);
		beneficiaryVisitDetail.setBeneficiaryRegID(1L);
		beneficiaryVisitDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		beneficiaryVisitDetail.setCreatedDate(mock(Timestamp.class));
		beneficiaryVisitDetail.setDeleted(true);
		beneficiaryVisitDetail.setFileIDs(new String[] { "File IDs" });
		beneficiaryVisitDetail.setFiles(new ArrayList<>());
		beneficiaryVisitDetail.setHealthFacilityLocation("Health Facility Location");
		beneficiaryVisitDetail.setHealthFacilityType("Health Facility Type");
		beneficiaryVisitDetail.setLastModDate(mock(Timestamp.class));
		beneficiaryVisitDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		beneficiaryVisitDetail.setParkingPlaceID(1);
		beneficiaryVisitDetail.setPregnancyStatus("Pregnancy Status");
		beneficiaryVisitDetail.setProcessed("Processed");
		beneficiaryVisitDetail.setProviderServiceMapID(1);
		beneficiaryVisitDetail.setProviderServiceMapping(providerServiceMapping);
		beneficiaryVisitDetail.setReportFilePath("/directory/foo.txt");
		beneficiaryVisitDetail.setReservedForChange("Reserved For Change");
		beneficiaryVisitDetail.setServiceProviderName("Service Provider Name");
		beneficiaryVisitDetail.setSyncedBy("Synced By");
		beneficiaryVisitDetail.setSyncedDate(mock(Timestamp.class));
		beneficiaryVisitDetail.setVanID(1);
		beneficiaryVisitDetail.setVanSerialNo(1L);
		beneficiaryVisitDetail.setVehicalNo("Vehical No");
		beneficiaryVisitDetail.setVisitCategory("Visit Category");
		beneficiaryVisitDetail.setVisitCategoryID(1);
		beneficiaryVisitDetail.setVisitCode(1L);
		beneficiaryVisitDetail.setVisitDateTime(mock(Timestamp.class));
		beneficiaryVisitDetail.setVisitFlowStatusFlag("Visit Flow Status Flag");
		beneficiaryVisitDetail.setVisitNo((short) 1);
		beneficiaryVisitDetail.setVisitReason("Just cause");
		beneficiaryVisitDetail.setVisitReasonID((short) 1);
		beneficiaryVisitDetail.setrCHID("R CHID");
		when(commonNurseServiceImpl.getCSVisitDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(beneficiaryVisitDetail);
		when(commonNurseServiceImpl.getBenAdherence(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Ben Adherence");
		when(commonNurseServiceImpl.getBenChiefComplaints(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Ben Chief Complaints");
		when(commonNurseServiceImpl.getLabTestOrders(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Lab Test Orders");

		// Act
		aNCServiceImpl.getBenVisitDetailsFrmNurseANC(1L, 1L);
	}

	@Test
	void testGetBenANCDetailsFrmNurseANC() {
		// Arrange
		when(aNCNurseServiceImpl.getANCCareDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Anc Care Details");
		when(aNCNurseServiceImpl.getANCWomenVaccineDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Anc Women Vaccine Details");

		// Act
		String actualBenANCDetailsFrmNurseANC = aNCServiceImpl.getBenANCDetailsFrmNurseANC(1L, 1L);

		// Assert
		verify(aNCNurseServiceImpl).getANCCareDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(aNCNurseServiceImpl).getANCWomenVaccineDetails(Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("{ANCWomenVaccineDetails=Anc Women Vaccine Details, ANCCareDetail=Anc Care Details}",
				actualBenANCDetailsFrmNurseANC);
	}

	@Test
	void testGetBenANCDetailsFrmNurseANC2() {
		// Arrange
		when(aNCNurseServiceImpl.getANCCareDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenThrow(new RuntimeException("ANCCareDetail"));

		// Act and Assert
		assertThrows(RuntimeException.class, () -> aNCServiceImpl.getBenANCDetailsFrmNurseANC(1L, 1L));
		verify(aNCNurseServiceImpl).getANCCareDetails(Mockito.<Long>any(), Mockito.<Long>any());
	}

	@Test
	@Disabled("TODO: Complete this test")
	void testGetBenANCHistoryDetails() {
		// TODO: Diffblue Cover was only able to create a partial test for this method:
		// Reason: No inputs found that don't throw a trivial exception.
		// Diffblue Cover tried to run the arrange/act section, but the method under
		// test threw
		// com.google.gson.JsonIOException: Failed making field
		// 'java.sql.Timestamp#nanos' accessible; either increase its visibility or
		// write a custom TypeAdapter for its declaring type.
		// at
		// com.google.gson.internal.reflect.ReflectionHelper.makeAccessible(ReflectionHelper.java:38)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.getBoundFields(ReflectiveTypeAdapterFactory.java:286)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.create(ReflectiveTypeAdapterFactory.java:130)
		// at com.google.gson.Gson.getAdapter(Gson.java:556)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:55)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1.write(ReflectiveTypeAdapterFactory.java:196)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:368)
		// at
		// com.google.gson.internal.bind.ObjectTypeAdapter.write(ObjectTypeAdapter.java:183)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:70)
		// at
		// com.google.gson.internal.bind.MapTypeAdapterFactory$Adapter.write(MapTypeAdapterFactory.java:207)
		// at
		// com.google.gson.internal.bind.MapTypeAdapterFactory$Adapter.write(MapTypeAdapterFactory.java:144)
		// at com.google.gson.Gson.toJson(Gson.java:842)
		// at com.google.gson.Gson.toJson(Gson.java:812)
		// at com.google.gson.Gson.toJson(Gson.java:759)
		// at com.google.gson.Gson.toJson(Gson.java:736)
		// at
		// com.iemr.mmu.service.anc.ANCServiceImpl.getBenANCHistoryDetails(ANCServiceImpl.java:1023)
		// java.lang.reflect.InaccessibleObjectException: Unable to make field private
		// int java.sql.Timestamp.nanos accessible: module java.sql does not "opens
		// java.sql" to unnamed module @f87c6b6
		// at
		// com.google.gson.internal.reflect.ReflectionHelper.makeAccessible(ReflectionHelper.java:35)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.getBoundFields(ReflectiveTypeAdapterFactory.java:286)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.create(ReflectiveTypeAdapterFactory.java:130)
		// at com.google.gson.Gson.getAdapter(Gson.java:556)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:55)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1.write(ReflectiveTypeAdapterFactory.java:196)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:368)
		// at
		// com.google.gson.internal.bind.ObjectTypeAdapter.write(ObjectTypeAdapter.java:183)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:70)
		// at
		// com.google.gson.internal.bind.MapTypeAdapterFactory$Adapter.write(MapTypeAdapterFactory.java:207)
		// at
		// com.google.gson.internal.bind.MapTypeAdapterFactory$Adapter.write(MapTypeAdapterFactory.java:144)
		// at com.google.gson.Gson.toJson(Gson.java:842)
		// at com.google.gson.Gson.toJson(Gson.java:812)
		// at com.google.gson.Gson.toJson(Gson.java:759)
		// at com.google.gson.Gson.toJson(Gson.java:736)
		// at
		// com.iemr.mmu.service.anc.ANCServiceImpl.getBenANCHistoryDetails(ANCServiceImpl.java:1023)
		// See https://diff.blue/R013 to resolve this issue.

		// Arrange
		BenFamilyHistory benFamilyHistory = new BenFamilyHistory();
		benFamilyHistory.setBenVisitID(1L);
		benFamilyHistory.setBeneficiaryRegID(1L);
		benFamilyHistory.setCaptureDate(mock(Date.class));
		benFamilyHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benFamilyHistory.setCreatedDate(mock(Timestamp.class));
		benFamilyHistory.setDeleted(true);
		benFamilyHistory.setDiseaseType("Disease Type");
		benFamilyHistory.setDiseaseTypeID((short) 1);
		benFamilyHistory.setFamilyDiseaseList(new ArrayList<>());
		benFamilyHistory.setFamilyMember("Family Member");
		benFamilyHistory.setGeneticDisorder("Genetic Disorder");
		benFamilyHistory.setID(1L);
		benFamilyHistory.setIsConsanguineousMarrige("Is Consanguineous Marrige");
		benFamilyHistory.setIsGeneticDisorder("Is Genetic Disorder");
		benFamilyHistory.setLastModDate(mock(Timestamp.class));
		benFamilyHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benFamilyHistory.setOtherDiseaseType("Other Disease Type");
		benFamilyHistory.setParkingPlaceID(1);
		benFamilyHistory.setProcessed("Processed");
		benFamilyHistory.setProviderServiceMapID(1);
		benFamilyHistory.setReservedForChange("Reserved For Change");
		benFamilyHistory.setSnomedCode("Snomed Code");
		benFamilyHistory.setSnomedTerm("Snomed Term");
		benFamilyHistory.setSyncedBy("Synced By");
		benFamilyHistory.setSyncedDate(mock(Timestamp.class));
		benFamilyHistory.setVanID(1);
		benFamilyHistory.setVanSerialNo(1L);
		benFamilyHistory.setVehicalNo("Vehical No");
		benFamilyHistory.setVisitCode(1L);

		BenMedHistory benMedHistory = new BenMedHistory();
		benMedHistory.setBenMedHistoryID(1L);
		benMedHistory.setBenVisitID(1L);
		benMedHistory.setBeneficiaryRegID(1L);
		benMedHistory.setCaptureDate(mock(Date.class));
		benMedHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benMedHistory.setCreatedDate(mock(Timestamp.class));
		benMedHistory.setDeleted(true);
		benMedHistory.setDrugComplianceID((short) 1);
		benMedHistory.setIllnessType("Illness Type");
		benMedHistory.setIllnessTypeID(1);
		benMedHistory.setIllness_Type("Illness Type");
		benMedHistory.setLastModDate(mock(Timestamp.class));
		benMedHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benMedHistory.setOtherIllnessType("Other Illness Type");
		benMedHistory.setOtherSurgeryType("Other Surgery Type");
		benMedHistory.setOther_Illness_Type("Other Illness Type");
		benMedHistory.setOther_Surgery_Type("Other Surgery Type");
		benMedHistory.setParkingPlaceID(1);
		benMedHistory.setPastIllness(new ArrayList<>());
		benMedHistory.setPastSurgery(new ArrayList<>());
		benMedHistory.setProcessed("Processed");
		benMedHistory.setProviderServiceMapID(1);
		benMedHistory.setReservedForChange("Reserved For Change");
		benMedHistory.setSurgeryID(1);
		benMedHistory.setSurgeryType("Surgery Type");
		benMedHistory.setSurgery_Type("Surgery Type");
		benMedHistory.setSyncedBy("Synced By");
		benMedHistory.setSyncedDate(mock(Timestamp.class));
		benMedHistory.setVanID(1);
		benMedHistory.setVanSerialNo(1L);
		benMedHistory.setVehicalNo("Vehical No");
		benMedHistory.setVisitCode(1L);
		benMedHistory.setYear_Of_Illness(mock(Date.class));
		benMedHistory.setYear_Of_Surgery(mock(Date.class));
		benMedHistory.setYearofIllness(mock(Timestamp.class));
		benMedHistory.setYearofSurgery(mock(Timestamp.class));

		BenMenstrualDetails benMenstrualDetails = new BenMenstrualDetails();
		benMenstrualDetails.setBenMenstrualID(1);
		benMenstrualDetails.setBenVisitID(1L);
		benMenstrualDetails.setBeneficiaryRegID(1L);
		benMenstrualDetails.setBloodFlowDuration("Blood Flow Duration");
		benMenstrualDetails.setCaptureDate(mock(Date.class));
		benMenstrualDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benMenstrualDetails.setCreatedDate(mock(Timestamp.class));
		benMenstrualDetails.setCycleLength("Cycle Length");
		benMenstrualDetails.setDeleted(true);
		benMenstrualDetails.setLastModDate(mock(Timestamp.class));
		benMenstrualDetails.setLmp_date(mock(Date.class));
		benMenstrualDetails.setMenstrualCycleStatus("Menstrual Cycle Status");
		benMenstrualDetails.setMenstrualCycleStatusID((short) 1);
		benMenstrualDetails.setMenstrualCyclelengthID((short) 1);
		benMenstrualDetails.setMenstrualFlowDurationID((short) 1);
		benMenstrualDetails.setMenstrualProblemID("Menstrual Problem ID");
		benMenstrualDetails.setMenstrualProblemList(new ArrayList<>());
		benMenstrualDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benMenstrualDetails.setParkingPlaceID(1);
		benMenstrualDetails.setProblemName("Problem Name");
		benMenstrualDetails.setProcessed("Processed");
		benMenstrualDetails.setProviderServiceMapID(1);
		benMenstrualDetails.setRegularity("Regularity");
		benMenstrualDetails.setReservedForChange("Reserved For Change");
		benMenstrualDetails.setSyncedBy("Synced By");
		benMenstrualDetails.setSyncedDate(mock(Timestamp.class));
		benMenstrualDetails.setVanID(1);
		benMenstrualDetails.setVanSerialNo(1L);
		benMenstrualDetails.setVehicalNo("Vehical No");
		benMenstrualDetails.setVisitCode(1L);
		benMenstrualDetails.setlMPDate(mock(Timestamp.class));

		BenPersonalHabit benPersonalHabit = new BenPersonalHabit();
		benPersonalHabit.setAlcoholDuration(mock(Timestamp.class));
		benPersonalHabit.setAlcoholIntakeFrequency("Alcohol Intake Frequency");
		benPersonalHabit.setAlcoholIntakeStatus("Alcohol Intake Status");
		benPersonalHabit.setAlcoholList(new ArrayList<>());
		benPersonalHabit.setAlcoholType("Alcohol Type");
		benPersonalHabit.setAlcoholTypeID("Alcohol Type ID");
		benPersonalHabit.setAlcohol_use_duration(mock(Date.class));
		benPersonalHabit.setAllergicList(new ArrayList<>());
		benPersonalHabit.setAllergyStatus("Allergy Status");
		benPersonalHabit.setAvgAlcoholConsumption("Avg Alcohol Consumption");
		benPersonalHabit.setBenPersonalHabitID(1);
		benPersonalHabit.setBenVisitID(1L);
		benPersonalHabit.setBeneficiaryRegID(1L);
		benPersonalHabit.setCaptureDate(mock(Date.class));
		benPersonalHabit.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benPersonalHabit.setCreatedDate(mock(Timestamp.class));
		benPersonalHabit.setDeleted(true);
		benPersonalHabit.setDietaryType("Dietary Type");
		benPersonalHabit.setLastModDate(mock(Timestamp.class));
		benPersonalHabit.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benPersonalHabit.setNumberperDay((short) 1);
		benPersonalHabit.setOtherAlcoholType("Other Alcohol Type");
		benPersonalHabit.setOtherTobaccoUseType("Other Tobacco Use Type");
		benPersonalHabit.setParkingPlaceID(1);
		benPersonalHabit.setPhysicalActivityType("Physical Activity Type");
		benPersonalHabit.setProcessed("Processed");
		benPersonalHabit.setProviderServiceMapID(1);
		benPersonalHabit.setReservedForChange("Reserved For Change");
		benPersonalHabit.setRiskySexualPracticeStatus("Risky Sexual Practice Status");
		benPersonalHabit.setRiskySexualPracticesStatus('A');
		benPersonalHabit.setSyncedBy("Synced By");
		benPersonalHabit.setSyncedDate(mock(Timestamp.class));
		benPersonalHabit.setTobaccoList(new ArrayList<>());
		benPersonalHabit.setTobaccoUseDuration(mock(Timestamp.class));
		benPersonalHabit.setTobaccoUseStatus("Tobacco Use Status");
		benPersonalHabit.setTobaccoUseType("Tobacco Use Type");
		benPersonalHabit.setTobaccoUseTypeID("Tobacco Use Type ID");
		benPersonalHabit.setTobacco_use_duration(mock(Date.class));
		benPersonalHabit.setVanID(1);
		benPersonalHabit.setVanSerialNo(1L);
		benPersonalHabit.setVehicalNo("Vehical No");
		benPersonalHabit.setVisitCode(1L);

		WrapperChildOptionalVaccineDetail wrapperChildOptionalVaccineDetail = new WrapperChildOptionalVaccineDetail();
		wrapperChildOptionalVaccineDetail.setBenVisitID(1L);
		wrapperChildOptionalVaccineDetail.setBeneficiaryRegID(1L);
		wrapperChildOptionalVaccineDetail.setChildOptionalVaccineList(new ArrayList<>());
		wrapperChildOptionalVaccineDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperChildOptionalVaccineDetail.setParkingPlaceID(1);
		wrapperChildOptionalVaccineDetail.setProviderServiceMapID(1);
		wrapperChildOptionalVaccineDetail.setVanID(1);
		wrapperChildOptionalVaccineDetail.setVisitCode(1L);

		WrapperComorbidCondDetails wrapperComorbidCondDetails = new WrapperComorbidCondDetails();
		wrapperComorbidCondDetails.setBenVisitID(1L);
		wrapperComorbidCondDetails.setBeneficiaryRegID(1L);
		wrapperComorbidCondDetails.setComorbidityConcurrentConditionsList(new ArrayList<>());
		wrapperComorbidCondDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperComorbidCondDetails.setParkingPlaceID(1);
		wrapperComorbidCondDetails.setProviderServiceMapID(1);
		wrapperComorbidCondDetails.setVanID(1);
		wrapperComorbidCondDetails.setVisitCode(1L);

		WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory = new WrapperFemaleObstetricHistory();
		wrapperFemaleObstetricHistory.setBenVisitID(1L);
		wrapperFemaleObstetricHistory.setBeneficiaryRegID(1L);
		wrapperFemaleObstetricHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperFemaleObstetricHistory.setFemaleObstetricHistoryList(new ArrayList<>());
		wrapperFemaleObstetricHistory.setParkingPlaceID(1);
		wrapperFemaleObstetricHistory.setProviderServiceMapID(1);
		wrapperFemaleObstetricHistory.setTotalNoOfPreg((short) 1);
		wrapperFemaleObstetricHistory.setVanID(1);
		wrapperFemaleObstetricHistory.setVisitCode(1L);

		WrapperImmunizationHistory wrapperImmunizationHistory = new WrapperImmunizationHistory();
		wrapperImmunizationHistory.setBenVisitID(1L);
		wrapperImmunizationHistory.setBeneficiaryRegID(1L);
		wrapperImmunizationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperImmunizationHistory.setImmunizationList(new ArrayList<>());
		wrapperImmunizationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		wrapperImmunizationHistory.setParkingPlaceID(1);
		wrapperImmunizationHistory.setProviderServiceMapID(1);
		wrapperImmunizationHistory.setVanID(1);
		wrapperImmunizationHistory.setVisitCode(1L);

		WrapperMedicationHistory wrapperMedicationHistory = new WrapperMedicationHistory();
		wrapperMedicationHistory.setBenVisitID(1L);
		wrapperMedicationHistory.setBeneficiaryRegID(1L);
		wrapperMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperMedicationHistory.setMedicationHistoryList(new ArrayList<>());
		wrapperMedicationHistory.setParkingPlaceID(1);
		wrapperMedicationHistory.setProviderServiceMapID(1);
		wrapperMedicationHistory.setVanID(1);
		wrapperMedicationHistory.setVisitCode(1L);
		when(commonNurseServiceImpl.getFamilyHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benFamilyHistory);
		when(commonNurseServiceImpl.getPastHistoryData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benMedHistory);
		when(commonNurseServiceImpl.getMenstrualHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benMenstrualDetails);
		when(commonNurseServiceImpl.getPersonalHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benPersonalHabit);
		when(commonNurseServiceImpl.getChildOptionalVaccineHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(wrapperChildOptionalVaccineDetail);
		when(commonNurseServiceImpl.getComorbidityConditionsHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(wrapperComorbidCondDetails);
		when(commonNurseServiceImpl.getFemaleObstetricHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(wrapperFemaleObstetricHistory);
		when(commonNurseServiceImpl.getImmunizationHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(wrapperImmunizationHistory);
		when(commonNurseServiceImpl.getMedicationHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(wrapperMedicationHistory);

		// Act
		aNCServiceImpl.getBenANCHistoryDetails(1L, 1L);
	}

	@Test
	void testGetBeneficiaryVitalDetails() {
		// Arrange
		when(commonNurseServiceImpl.getBeneficiaryPhysicalAnthropometryDetails(Mockito.<Long>any(),
				Mockito.<Long>any())).thenReturn("Beneficiary Physical Anthropometry Details");
		when(commonNurseServiceImpl.getBeneficiaryPhysicalVitalDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Beneficiary Physical Vital Details");

		// Act
		String actualBeneficiaryVitalDetails = aNCServiceImpl.getBeneficiaryVitalDetails(1L, 1L);

		// Assert
		verify(commonNurseServiceImpl).getBeneficiaryPhysicalAnthropometryDetails(Mockito.<Long>any(),
				Mockito.<Long>any());
		verify(commonNurseServiceImpl).getBeneficiaryPhysicalVitalDetails(Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals(
				"{benAnthropometryDetail=Beneficiary Physical Anthropometry Details, benPhysicalVitalDetail=Beneficiary"
						+ " Physical Vital Details}",
				actualBeneficiaryVitalDetails);
	}

	@Test
	void testGetBeneficiaryVitalDetails2() {
		// Arrange
		when(commonNurseServiceImpl.getBeneficiaryPhysicalAnthropometryDetails(Mockito.<Long>any(),
				Mockito.<Long>any())).thenThrow(new RuntimeException("benAnthropometryDetail"));

		// Act and Assert
		assertThrows(RuntimeException.class, () -> aNCServiceImpl.getBeneficiaryVitalDetails(1L, 1L));
		verify(commonNurseServiceImpl).getBeneficiaryPhysicalAnthropometryDetails(Mockito.<Long>any(),
				Mockito.<Long>any());
	}

	@Test
	@Disabled("TODO: Complete this test")
	void testGetANCExaminationDetailsData() {
		// TODO: Diffblue Cover was only able to create a partial test for this method:
		// Reason: No inputs found that don't throw a trivial exception.
		// Diffblue Cover tried to run the arrange/act section, but the method under
		// test threw
		// com.google.gson.JsonIOException: Failed making field
		// 'java.sql.Timestamp#nanos' accessible; either increase its visibility or
		// write a custom TypeAdapter for its declaring type.
		// at
		// com.google.gson.internal.reflect.ReflectionHelper.makeAccessible(ReflectionHelper.java:38)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.getBoundFields(ReflectiveTypeAdapterFactory.java:286)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.create(ReflectiveTypeAdapterFactory.java:130)
		// at com.google.gson.Gson.getAdapter(Gson.java:556)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:55)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1.write(ReflectiveTypeAdapterFactory.java:196)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:368)
		// at
		// com.google.gson.internal.bind.ObjectTypeAdapter.write(ObjectTypeAdapter.java:183)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:70)
		// at
		// com.google.gson.internal.bind.MapTypeAdapterFactory$Adapter.write(MapTypeAdapterFactory.java:207)
		// at
		// com.google.gson.internal.bind.MapTypeAdapterFactory$Adapter.write(MapTypeAdapterFactory.java:144)
		// at com.google.gson.Gson.toJson(Gson.java:842)
		// at com.google.gson.Gson.toJson(Gson.java:812)
		// at com.google.gson.Gson.toJson(Gson.java:759)
		// at com.google.gson.Gson.toJson(Gson.java:736)
		// at
		// com.iemr.mmu.service.anc.ANCServiceImpl.getANCExaminationDetailsData(ANCServiceImpl.java:1065)
		// java.lang.reflect.InaccessibleObjectException: Unable to make field private
		// int java.sql.Timestamp.nanos accessible: module java.sql does not "opens
		// java.sql" to unnamed module @f87c6b6
		// at
		// com.google.gson.internal.reflect.ReflectionHelper.makeAccessible(ReflectionHelper.java:35)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.getBoundFields(ReflectiveTypeAdapterFactory.java:286)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.create(ReflectiveTypeAdapterFactory.java:130)
		// at com.google.gson.Gson.getAdapter(Gson.java:556)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:55)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1.write(ReflectiveTypeAdapterFactory.java:196)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:368)
		// at
		// com.google.gson.internal.bind.ObjectTypeAdapter.write(ObjectTypeAdapter.java:183)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:70)
		// at
		// com.google.gson.internal.bind.MapTypeAdapterFactory$Adapter.write(MapTypeAdapterFactory.java:207)
		// at
		// com.google.gson.internal.bind.MapTypeAdapterFactory$Adapter.write(MapTypeAdapterFactory.java:144)
		// at com.google.gson.Gson.toJson(Gson.java:842)
		// at com.google.gson.Gson.toJson(Gson.java:812)
		// at com.google.gson.Gson.toJson(Gson.java:759)
		// at com.google.gson.Gson.toJson(Gson.java:736)
		// at
		// com.iemr.mmu.service.anc.ANCServiceImpl.getANCExaminationDetailsData(ANCServiceImpl.java:1065)
		// See https://diff.blue/R013 to resolve this issue.

		// Arrange
		SysObstetricExamination sysObstetricExamination = new SysObstetricExamination();
		sysObstetricExamination.setAbdominalScars("Abdominal Scars");
		sysObstetricExamination.setBenVisitID(1L);
		sysObstetricExamination.setBeneficiaryRegID(1L);
		sysObstetricExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		sysObstetricExamination.setCreatedDate(mock(Timestamp.class));
		sysObstetricExamination.setDeleted(true);
		sysObstetricExamination.setFetalHeartRate_BeatsPerMinute("Fetal Heart Rate Beats Per Minute");
		sysObstetricExamination.setFetalHeartSounds("Fetal Heart Sounds");
		sysObstetricExamination.setFetalMovements("Fetal Movements");
		sysObstetricExamination.setFetalPositionOrLie("Fetal Position Or Lie");
		sysObstetricExamination.setFetalPresentation("Fetal Presentation");
		sysObstetricExamination.setFundalHeight("Fundal Height");
		sysObstetricExamination.setID(1L);
		sysObstetricExamination.setLastModDate(mock(Timestamp.class));
		sysObstetricExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		sysObstetricExamination.setParkingPlaceID(1);
		sysObstetricExamination.setProcessed("Processed");
		sysObstetricExamination.setProviderServiceMapID(1);
		sysObstetricExamination.setReservedForChange("Reserved For Change");
		sysObstetricExamination.setSfh(10.0d);
		sysObstetricExamination.setSyncedBy("Synced By");
		sysObstetricExamination.setSyncedDate(mock(Timestamp.class));
		sysObstetricExamination.setVanSerialNo(1L);
		sysObstetricExamination.setVehicalNo("Vehical No");
		sysObstetricExamination.setVisitCode(1L);
		sysObstetricExamination.setfHAndPOA_Interpretation("F HAnd POA Interpretation");
		sysObstetricExamination.setfHAndPOA_Status("F HAnd POA Status");
		when(aNCNurseServiceImpl.getSysObstetricExamination(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(sysObstetricExamination);

		PhyGeneralExamination phyGeneralExamination = new PhyGeneralExamination();
		phyGeneralExamination.setBenVisitID(1L);
		phyGeneralExamination.setBeneficiaryRegID(1L);
		phyGeneralExamination.setBuiltAndAppearance("Built And Appearance");
		phyGeneralExamination.setClubbing("Clubbing");
		phyGeneralExamination.setCoherence("Coherence");
		phyGeneralExamination.setComfortness("Comfortness");
		phyGeneralExamination.setConsciousness("Consciousness");
		phyGeneralExamination.setCooperation("Cooperation");
		phyGeneralExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		phyGeneralExamination.setCreatedDate(mock(Timestamp.class));
		phyGeneralExamination.setCyanosis("Cyanosis");
		phyGeneralExamination.setDangerSigns("Danger Signs");
		phyGeneralExamination.setDeleted(true);
		phyGeneralExamination.setEdema("Edema");
		phyGeneralExamination.setEdemaType("Edema Type");
		phyGeneralExamination.setExtentOfEdema("Extent Of Edema");
		phyGeneralExamination.setFoetalMovements("Foetal Movements");
		phyGeneralExamination.setGait("Gait");
		phyGeneralExamination.setID(1L);
		phyGeneralExamination.setJaundice("Jaundice");
		phyGeneralExamination.setLastModDate(mock(Timestamp.class));
		phyGeneralExamination.setLymphadenopathy("Lymphadenopathy");
		phyGeneralExamination.setLymphnodesInvolved("Lymphnodes Involved");
		phyGeneralExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		phyGeneralExamination.setPallor("Pallor");
		phyGeneralExamination.setParkingPlaceID(1);
		phyGeneralExamination.setProcessed("Processed");
		phyGeneralExamination.setProviderServiceMapID(1);
		phyGeneralExamination.setQuickening("Quickening");
		phyGeneralExamination.setReservedForChange("Reserved For Change");
		phyGeneralExamination.setSyncedBy("Synced By");
		phyGeneralExamination.setSyncedDate(mock(Timestamp.class));
		phyGeneralExamination.setTypeOfDangerSign("Type Of Danger Sign");
		phyGeneralExamination.setTypeOfDangerSigns(new ArrayList<>());
		phyGeneralExamination.setTypeOfLymphadenopathy("Type Of Lymphadenopathy");
		phyGeneralExamination.setVanSerialNo(1L);
		phyGeneralExamination.setVehicalNo("Vehical No");
		phyGeneralExamination.setVisitCode(1L);

		PhyHeadToToeExamination phyHeadToToeExamination = new PhyHeadToToeExamination();
		phyHeadToToeExamination.setBenVisitID(1L);
		phyHeadToToeExamination.setBeneficiaryRegID(1L);
		phyHeadToToeExamination.setBreastAndNipples("Breast And Nipples");
		phyHeadToToeExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		phyHeadToToeExamination.setCreatedDate(mock(Timestamp.class));
		phyHeadToToeExamination.setDeleted(true);
		phyHeadToToeExamination.setEars("Ears");
		phyHeadToToeExamination.setEyes("Eyes");
		phyHeadToToeExamination.setHair("Hair");
		phyHeadToToeExamination.setHead("Head");
		phyHeadToToeExamination.setID(1L);
		phyHeadToToeExamination.setLastModDate(mock(Timestamp.class));
		phyHeadToToeExamination.setLowerLimbs("Lower Limbs");
		phyHeadToToeExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		phyHeadToToeExamination.setNails("Nails");
		phyHeadToToeExamination.setNose("Nose");
		phyHeadToToeExamination.setOralCavity("Oral Cavity");
		phyHeadToToeExamination.setParkingPlaceID(1);
		phyHeadToToeExamination.setProcessed("Processed");
		phyHeadToToeExamination.setProviderServiceMapID(1);
		phyHeadToToeExamination.setReservedForChange("Reserved For Change");
		phyHeadToToeExamination.setSkin("Skin");
		phyHeadToToeExamination.setSyncedBy("Synced By");
		phyHeadToToeExamination.setSyncedDate(mock(Timestamp.class));
		phyHeadToToeExamination.setThroat("Throat");
		phyHeadToToeExamination.setTrunk("Trunk");
		phyHeadToToeExamination.setUpperLimbs("Upper Limbs");
		phyHeadToToeExamination.setVanSerialNo(1L);
		phyHeadToToeExamination.setVehicalNo("Vehical No");
		phyHeadToToeExamination.setVisitCode(1L);

		SysCardiovascularExamination sysCardiovascularExamination = new SysCardiovascularExamination();
		sysCardiovascularExamination.setAdditionalHeartSounds("Additional Heart Sounds");
		sysCardiovascularExamination.setApexbeatLocation("Apexbeat Location");
		sysCardiovascularExamination.setApexbeatType("Apexbeat Type");
		sysCardiovascularExamination.setBenVisitID(1L);
		sysCardiovascularExamination.setBeneficiaryRegID(1L);
		sysCardiovascularExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		sysCardiovascularExamination.setCreatedDate(mock(Timestamp.class));
		sysCardiovascularExamination.setDeleted(true);
		sysCardiovascularExamination.setFirstHeartSound_S1("First Heart Sound S1");
		sysCardiovascularExamination.setID(1L);
		sysCardiovascularExamination.setJugularVenousPulse_JVP("Jugular Venous Pulse JVP");
		sysCardiovascularExamination.setLastModDate(mock(Timestamp.class));
		sysCardiovascularExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		sysCardiovascularExamination.setMurmurs("Murmurs");
		sysCardiovascularExamination.setParkingPlaceID(1);
		sysCardiovascularExamination.setPericardialRub("Pericardial Rub");
		sysCardiovascularExamination.setProcessed("Processed");
		sysCardiovascularExamination.setProviderServiceMapID(1);
		sysCardiovascularExamination.setReservedForChange("Reserved For Change");
		sysCardiovascularExamination.setSecondHeartSound_S2("Second Heart Sound S2");
		sysCardiovascularExamination.setSyncedBy("Synced By");
		sysCardiovascularExamination.setSyncedDate(mock(Timestamp.class));
		sysCardiovascularExamination.setVanSerialNo(1L);
		sysCardiovascularExamination.setVehicalNo("Vehical No");
		sysCardiovascularExamination.setVisitCode(1L);

		SysCentralNervousExamination sysCentralNervousExamination = new SysCentralNervousExamination();
		sysCentralNervousExamination.setAutonomicSystem("Autonomic System");
		sysCentralNervousExamination.setBenVisitID(1L);
		sysCentralNervousExamination.setBeneficiaryRegID(1L);
		sysCentralNervousExamination.setCerebellarSigns("Cerebellar Signs");
		sysCentralNervousExamination.setCranialNervesExamination("Cranial Nerves Examination");
		sysCentralNervousExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		sysCentralNervousExamination.setCreatedDate(mock(Timestamp.class));
		sysCentralNervousExamination.setDeleted(true);
		sysCentralNervousExamination.setHandedness("Handedness");
		sysCentralNervousExamination.setID(1L);
		sysCentralNervousExamination.setLastModDate(mock(Timestamp.class));
		sysCentralNervousExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		sysCentralNervousExamination.setMotorSystem("Motor System");
		sysCentralNervousExamination.setParkingPlaceID(1);
		sysCentralNervousExamination.setProcessed("Processed");
		sysCentralNervousExamination.setProviderServiceMapID(1);
		sysCentralNervousExamination.setReservedForChange("Reserved For Change");
		sysCentralNervousExamination.setSensorySystem("Sensory System");
		sysCentralNervousExamination.setSignsOfMeningealIrritation("Signs Of Meningeal Irritation");
		sysCentralNervousExamination.setSkull("Skull");
		sysCentralNervousExamination.setSyncedBy("Synced By");
		sysCentralNervousExamination.setSyncedDate(mock(Timestamp.class));
		sysCentralNervousExamination.setVanSerialNo(1L);
		sysCentralNervousExamination.setVehicalNo("Vehical No");
		sysCentralNervousExamination.setVisitCode(1L);

		SysGenitourinarySystemExamination sysGenitourinarySystemExamination = new SysGenitourinarySystemExamination();
		sysGenitourinarySystemExamination.setBenVisitID(1L);
		sysGenitourinarySystemExamination.setBeneficiaryRegID(1L);
		sysGenitourinarySystemExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		sysGenitourinarySystemExamination.setCreatedDate(mock(Timestamp.class));
		sysGenitourinarySystemExamination.setDeleted(true);
		sysGenitourinarySystemExamination.setExternalGenitalia("External Genitalia");
		sysGenitourinarySystemExamination.setID(1L);
		sysGenitourinarySystemExamination.setLastModDate(mock(Timestamp.class));
		sysGenitourinarySystemExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		sysGenitourinarySystemExamination.setParkingPlaceID(1);
		sysGenitourinarySystemExamination.setProcessed("Processed");
		sysGenitourinarySystemExamination.setProviderServiceMapID(1);
		sysGenitourinarySystemExamination.setRenalAngle("Renal Angle");
		sysGenitourinarySystemExamination.setReservedForChange("Reserved For Change");
		sysGenitourinarySystemExamination.setSuprapubicRegion("us-east-2");
		sysGenitourinarySystemExamination.setSyncedBy("Synced By");
		sysGenitourinarySystemExamination.setSyncedDate(mock(Timestamp.class));
		sysGenitourinarySystemExamination.setVanSerialNo(1L);
		sysGenitourinarySystemExamination.setVehicalNo("Vehical No");
		sysGenitourinarySystemExamination.setVisitCode(1L);

		SysMusculoskeletalSystemExamination sysMusculoskeletalSystemExamination = new SysMusculoskeletalSystemExamination();
		sysMusculoskeletalSystemExamination.setBenVisitID(1L);
		sysMusculoskeletalSystemExamination.setBeneficiaryRegID(1L);
		sysMusculoskeletalSystemExamination.setChestWall("Chest Wall");
		sysMusculoskeletalSystemExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		sysMusculoskeletalSystemExamination.setCreatedDate(mock(Timestamp.class));
		sysMusculoskeletalSystemExamination.setDeleted(true);
		sysMusculoskeletalSystemExamination.setID(1L);
		sysMusculoskeletalSystemExamination.setJoint_Abnormality("Joint Abnormality");
		sysMusculoskeletalSystemExamination.setJoint_Laterality("Joint Laterality");
		sysMusculoskeletalSystemExamination.setJoint_TypeOfJoint("Joint Type Of Joint");
		sysMusculoskeletalSystemExamination.setLastModDate(mock(Timestamp.class));
		sysMusculoskeletalSystemExamination.setLowerLimb_Abnormality("Lower Limb Abnormality");
		sysMusculoskeletalSystemExamination.setLowerLimb_Laterality("Lower Limb Laterality");
		sysMusculoskeletalSystemExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		sysMusculoskeletalSystemExamination.setParkingPlaceID(1);
		sysMusculoskeletalSystemExamination.setProcessed("Processed");
		sysMusculoskeletalSystemExamination.setProviderServiceMapID(1);
		sysMusculoskeletalSystemExamination.setReservedForChange("Reserved For Change");
		sysMusculoskeletalSystemExamination.setSpine("Spine");
		sysMusculoskeletalSystemExamination.setSyncedBy("Synced By");
		sysMusculoskeletalSystemExamination.setSyncedDate(mock(Timestamp.class));
		sysMusculoskeletalSystemExamination.setUpperLimb_Abnormality("Upper Limb Abnormality");
		sysMusculoskeletalSystemExamination.setUpperLimb_Laterality("Upper Limb Laterality");
		sysMusculoskeletalSystemExamination.setVanSerialNo(1L);
		sysMusculoskeletalSystemExamination.setVehicalNo("Vehical No");
		sysMusculoskeletalSystemExamination.setVisitCode(1L);

		SysRespiratoryExamination sysRespiratoryExamination = new SysRespiratoryExamination();
		sysRespiratoryExamination.setAuscultation("Auscultation");
		sysRespiratoryExamination.setAuscultation_BreathSounds("Auscultation Breath Sounds");
		sysRespiratoryExamination.setAuscultation_ConductedSounds("Auscultation Conducted Sounds");
		sysRespiratoryExamination.setAuscultation_Crepitations("Auscultation Crepitations");
		sysRespiratoryExamination.setAuscultation_PleuralRub("Auscultation Pleural Rub");
		sysRespiratoryExamination.setAuscultation_Stridor("Auscultation Stridor");
		sysRespiratoryExamination.setAuscultation_Wheezing("Auscultation Wheezing");
		sysRespiratoryExamination.setBenVisitID(1L);
		sysRespiratoryExamination.setBeneficiaryRegID(1L);
		sysRespiratoryExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		sysRespiratoryExamination.setCreatedDate(mock(Timestamp.class));
		sysRespiratoryExamination.setDeleted(true);
		sysRespiratoryExamination.setID(1L);
		sysRespiratoryExamination.setInspection("Inspection");
		sysRespiratoryExamination.setLastModDate(mock(Timestamp.class));
		sysRespiratoryExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		sysRespiratoryExamination.setPalpation("Palpation");
		sysRespiratoryExamination.setParkingPlaceID(1);
		sysRespiratoryExamination.setPercussion("Percussion");
		sysRespiratoryExamination.setProcessed("Processed");
		sysRespiratoryExamination.setProviderServiceMapID(1);
		sysRespiratoryExamination.setReservedForChange("Reserved For Change");
		sysRespiratoryExamination.setSignsOfRespiratoryDistress("Signs Of Respiratory Distress");
		sysRespiratoryExamination.setSyncedBy("Synced By");
		sysRespiratoryExamination.setSyncedDate(mock(Timestamp.class));
		sysRespiratoryExamination.setTrachea("Trachea");
		sysRespiratoryExamination.setVanSerialNo(1L);
		sysRespiratoryExamination.setVehicalNo("Vehical No");
		sysRespiratoryExamination.setVisitCode(1L);
		when(commonNurseServiceImpl.getGeneralExaminationData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(phyGeneralExamination);
		when(commonNurseServiceImpl.getHeadToToeExaminationData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(phyHeadToToeExamination);
		when(commonNurseServiceImpl.getCardiovascularExamination(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(sysCardiovascularExamination);
		when(commonNurseServiceImpl.getSysCentralNervousExamination(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(sysCentralNervousExamination);
		when(commonNurseServiceImpl.getGenitourinaryExamination(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(sysGenitourinarySystemExamination);
		when(commonNurseServiceImpl.getMusculoskeletalExamination(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(sysMusculoskeletalSystemExamination);
		when(commonNurseServiceImpl.getRespiratoryExamination(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(sysRespiratoryExamination);

		// Act
		aNCServiceImpl.getANCExaminationDetailsData(1L, 1L);
	}

	@Test
	@Disabled("TODO: Complete this test")
	void testGetBenANCNurseData() {
		// TODO: Diffblue Cover was only able to create a partial test for this method:
		// Reason: No inputs found that don't throw a trivial exception.
		// Diffblue Cover tried to run the arrange/act section, but the method under
		// test threw
		// com.google.gson.JsonIOException: Failed making field
		// 'java.sql.Timestamp#nanos' accessible; either increase its visibility or
		// write a custom TypeAdapter for its declaring type.
		// at
		// com.google.gson.internal.reflect.ReflectionHelper.makeAccessible(ReflectionHelper.java:38)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.getBoundFields(ReflectiveTypeAdapterFactory.java:286)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.create(ReflectiveTypeAdapterFactory.java:130)
		// at com.google.gson.Gson.getAdapter(Gson.java:556)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:55)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1.write(ReflectiveTypeAdapterFactory.java:196)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:368)
		// at
		// com.google.gson.internal.bind.ObjectTypeAdapter.write(ObjectTypeAdapter.java:183)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:70)
		// at
		// com.google.gson.internal.bind.MapTypeAdapterFactory$Adapter.write(MapTypeAdapterFactory.java:207)
		// at
		// com.google.gson.internal.bind.MapTypeAdapterFactory$Adapter.write(MapTypeAdapterFactory.java:144)
		// at com.google.gson.Gson.toJson(Gson.java:842)
		// at com.google.gson.Gson.toJson(Gson.java:812)
		// at com.google.gson.Gson.toJson(Gson.java:759)
		// at com.google.gson.Gson.toJson(Gson.java:736)
		// at
		// com.iemr.mmu.service.anc.ANCServiceImpl.getBenANCHistoryDetails(ANCServiceImpl.java:1023)
		// at
		// com.iemr.mmu.service.anc.ANCServiceImpl.getBenANCNurseData(ANCServiceImpl.java:1438)
		// java.lang.reflect.InaccessibleObjectException: Unable to make field private
		// int java.sql.Timestamp.nanos accessible: module java.sql does not "opens
		// java.sql" to unnamed module @f87c6b6
		// at
		// com.google.gson.internal.reflect.ReflectionHelper.makeAccessible(ReflectionHelper.java:35)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.getBoundFields(ReflectiveTypeAdapterFactory.java:286)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.create(ReflectiveTypeAdapterFactory.java:130)
		// at com.google.gson.Gson.getAdapter(Gson.java:556)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:55)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1.write(ReflectiveTypeAdapterFactory.java:196)
		// at
		// com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:368)
		// at
		// com.google.gson.internal.bind.ObjectTypeAdapter.write(ObjectTypeAdapter.java:183)
		// at
		// com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:70)
		// at
		// com.google.gson.internal.bind.MapTypeAdapterFactory$Adapter.write(MapTypeAdapterFactory.java:207)
		// at
		// com.google.gson.internal.bind.MapTypeAdapterFactory$Adapter.write(MapTypeAdapterFactory.java:144)
		// at com.google.gson.Gson.toJson(Gson.java:842)
		// at com.google.gson.Gson.toJson(Gson.java:812)
		// at com.google.gson.Gson.toJson(Gson.java:759)
		// at com.google.gson.Gson.toJson(Gson.java:736)
		// at
		// com.iemr.mmu.service.anc.ANCServiceImpl.getBenANCHistoryDetails(ANCServiceImpl.java:1023)
		// at
		// com.iemr.mmu.service.anc.ANCServiceImpl.getBenANCNurseData(ANCServiceImpl.java:1438)
		// See https://diff.blue/R013 to resolve this issue.

		// Arrange
		SysObstetricExamination sysObstetricExamination = new SysObstetricExamination();
		sysObstetricExamination.setAbdominalScars("Abdominal Scars");
		sysObstetricExamination.setBenVisitID(1L);
		sysObstetricExamination.setBeneficiaryRegID(1L);
		sysObstetricExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		sysObstetricExamination.setCreatedDate(mock(Timestamp.class));
		sysObstetricExamination.setDeleted(true);
		sysObstetricExamination.setFetalHeartRate_BeatsPerMinute("Fetal Heart Rate Beats Per Minute");
		sysObstetricExamination.setFetalHeartSounds("Fetal Heart Sounds");
		sysObstetricExamination.setFetalMovements("Fetal Movements");
		sysObstetricExamination.setFetalPositionOrLie("Fetal Position Or Lie");
		sysObstetricExamination.setFetalPresentation("Fetal Presentation");
		sysObstetricExamination.setFundalHeight("Fundal Height");
		sysObstetricExamination.setID(1L);
		sysObstetricExamination.setLastModDate(mock(Timestamp.class));
		sysObstetricExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		sysObstetricExamination.setParkingPlaceID(1);
		sysObstetricExamination.setProcessed("Processed");
		sysObstetricExamination.setProviderServiceMapID(1);
		sysObstetricExamination.setReservedForChange("Reserved For Change");
		sysObstetricExamination.setSfh(10.0d);
		sysObstetricExamination.setSyncedBy("Synced By");
		sysObstetricExamination.setSyncedDate(mock(Timestamp.class));
		sysObstetricExamination.setVanSerialNo(1L);
		sysObstetricExamination.setVehicalNo("Vehical No");
		sysObstetricExamination.setVisitCode(1L);
		sysObstetricExamination.setfHAndPOA_Interpretation("F HAnd POA Interpretation");
		sysObstetricExamination.setfHAndPOA_Status("F HAnd POA Status");
		when(aNCNurseServiceImpl.getSysObstetricExamination(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(sysObstetricExamination);
		when(aNCNurseServiceImpl.getANCCareDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Anc Care Details");
		when(aNCNurseServiceImpl.getANCWomenVaccineDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Anc Women Vaccine Details");

		BenFamilyHistory benFamilyHistory = new BenFamilyHistory();
		benFamilyHistory.setBenVisitID(1L);
		benFamilyHistory.setBeneficiaryRegID(1L);
		benFamilyHistory.setCaptureDate(mock(Date.class));
		benFamilyHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benFamilyHistory.setCreatedDate(mock(Timestamp.class));
		benFamilyHistory.setDeleted(true);
		benFamilyHistory.setDiseaseType("Disease Type");
		benFamilyHistory.setDiseaseTypeID((short) 1);
		benFamilyHistory.setFamilyDiseaseList(new ArrayList<>());
		benFamilyHistory.setFamilyMember("Family Member");
		benFamilyHistory.setGeneticDisorder("Genetic Disorder");
		benFamilyHistory.setID(1L);
		benFamilyHistory.setIsConsanguineousMarrige("Is Consanguineous Marrige");
		benFamilyHistory.setIsGeneticDisorder("Is Genetic Disorder");
		benFamilyHistory.setLastModDate(mock(Timestamp.class));
		benFamilyHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benFamilyHistory.setOtherDiseaseType("Other Disease Type");
		benFamilyHistory.setParkingPlaceID(1);
		benFamilyHistory.setProcessed("Processed");
		benFamilyHistory.setProviderServiceMapID(1);
		benFamilyHistory.setReservedForChange("Reserved For Change");
		benFamilyHistory.setSnomedCode("Snomed Code");
		benFamilyHistory.setSnomedTerm("Snomed Term");
		benFamilyHistory.setSyncedBy("Synced By");
		benFamilyHistory.setSyncedDate(mock(Timestamp.class));
		benFamilyHistory.setVanID(1);
		benFamilyHistory.setVanSerialNo(1L);
		benFamilyHistory.setVehicalNo("Vehical No");
		benFamilyHistory.setVisitCode(1L);

		BenMedHistory benMedHistory = new BenMedHistory();
		benMedHistory.setBenMedHistoryID(1L);
		benMedHistory.setBenVisitID(1L);
		benMedHistory.setBeneficiaryRegID(1L);
		benMedHistory.setCaptureDate(mock(Date.class));
		benMedHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benMedHistory.setCreatedDate(mock(Timestamp.class));
		benMedHistory.setDeleted(true);
		benMedHistory.setDrugComplianceID((short) 1);
		benMedHistory.setIllnessType("Illness Type");
		benMedHistory.setIllnessTypeID(1);
		benMedHistory.setIllness_Type("Illness Type");
		benMedHistory.setLastModDate(mock(Timestamp.class));
		benMedHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benMedHistory.setOtherIllnessType("Other Illness Type");
		benMedHistory.setOtherSurgeryType("Other Surgery Type");
		benMedHistory.setOther_Illness_Type("Other Illness Type");
		benMedHistory.setOther_Surgery_Type("Other Surgery Type");
		benMedHistory.setParkingPlaceID(1);
		benMedHistory.setPastIllness(new ArrayList<>());
		benMedHistory.setPastSurgery(new ArrayList<>());
		benMedHistory.setProcessed("Processed");
		benMedHistory.setProviderServiceMapID(1);
		benMedHistory.setReservedForChange("Reserved For Change");
		benMedHistory.setSurgeryID(1);
		benMedHistory.setSurgeryType("Surgery Type");
		benMedHistory.setSurgery_Type("Surgery Type");
		benMedHistory.setSyncedBy("Synced By");
		benMedHistory.setSyncedDate(mock(Timestamp.class));
		benMedHistory.setVanID(1);
		benMedHistory.setVanSerialNo(1L);
		benMedHistory.setVehicalNo("Vehical No");
		benMedHistory.setVisitCode(1L);
		benMedHistory.setYear_Of_Illness(mock(Date.class));
		benMedHistory.setYear_Of_Surgery(mock(Date.class));
		benMedHistory.setYearofIllness(mock(Timestamp.class));
		benMedHistory.setYearofSurgery(mock(Timestamp.class));

		BenMenstrualDetails benMenstrualDetails = new BenMenstrualDetails();
		benMenstrualDetails.setBenMenstrualID(1);
		benMenstrualDetails.setBenVisitID(1L);
		benMenstrualDetails.setBeneficiaryRegID(1L);
		benMenstrualDetails.setBloodFlowDuration("Blood Flow Duration");
		benMenstrualDetails.setCaptureDate(mock(Date.class));
		benMenstrualDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benMenstrualDetails.setCreatedDate(mock(Timestamp.class));
		benMenstrualDetails.setCycleLength("Cycle Length");
		benMenstrualDetails.setDeleted(true);
		benMenstrualDetails.setLastModDate(mock(Timestamp.class));
		benMenstrualDetails.setLmp_date(mock(Date.class));
		benMenstrualDetails.setMenstrualCycleStatus("Menstrual Cycle Status");
		benMenstrualDetails.setMenstrualCycleStatusID((short) 1);
		benMenstrualDetails.setMenstrualCyclelengthID((short) 1);
		benMenstrualDetails.setMenstrualFlowDurationID((short) 1);
		benMenstrualDetails.setMenstrualProblemID("Menstrual Problem ID");
		benMenstrualDetails.setMenstrualProblemList(new ArrayList<>());
		benMenstrualDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benMenstrualDetails.setParkingPlaceID(1);
		benMenstrualDetails.setProblemName("Problem Name");
		benMenstrualDetails.setProcessed("Processed");
		benMenstrualDetails.setProviderServiceMapID(1);
		benMenstrualDetails.setRegularity("Regularity");
		benMenstrualDetails.setReservedForChange("Reserved For Change");
		benMenstrualDetails.setSyncedBy("Synced By");
		benMenstrualDetails.setSyncedDate(mock(Timestamp.class));
		benMenstrualDetails.setVanID(1);
		benMenstrualDetails.setVanSerialNo(1L);
		benMenstrualDetails.setVehicalNo("Vehical No");
		benMenstrualDetails.setVisitCode(1L);
		benMenstrualDetails.setlMPDate(mock(Timestamp.class));

		BenPersonalHabit benPersonalHabit = new BenPersonalHabit();
		benPersonalHabit.setAlcoholDuration(mock(Timestamp.class));
		benPersonalHabit.setAlcoholIntakeFrequency("Alcohol Intake Frequency");
		benPersonalHabit.setAlcoholIntakeStatus("Alcohol Intake Status");
		benPersonalHabit.setAlcoholList(new ArrayList<>());
		benPersonalHabit.setAlcoholType("Alcohol Type");
		benPersonalHabit.setAlcoholTypeID("Alcohol Type ID");
		benPersonalHabit.setAlcohol_use_duration(mock(Date.class));
		benPersonalHabit.setAllergicList(new ArrayList<>());
		benPersonalHabit.setAllergyStatus("Allergy Status");
		benPersonalHabit.setAvgAlcoholConsumption("Avg Alcohol Consumption");
		benPersonalHabit.setBenPersonalHabitID(1);
		benPersonalHabit.setBenVisitID(1L);
		benPersonalHabit.setBeneficiaryRegID(1L);
		benPersonalHabit.setCaptureDate(mock(Date.class));
		benPersonalHabit.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benPersonalHabit.setCreatedDate(mock(Timestamp.class));
		benPersonalHabit.setDeleted(true);
		benPersonalHabit.setDietaryType("Dietary Type");
		benPersonalHabit.setLastModDate(mock(Timestamp.class));
		benPersonalHabit.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benPersonalHabit.setNumberperDay((short) 1);
		benPersonalHabit.setOtherAlcoholType("Other Alcohol Type");
		benPersonalHabit.setOtherTobaccoUseType("Other Tobacco Use Type");
		benPersonalHabit.setParkingPlaceID(1);
		benPersonalHabit.setPhysicalActivityType("Physical Activity Type");
		benPersonalHabit.setProcessed("Processed");
		benPersonalHabit.setProviderServiceMapID(1);
		benPersonalHabit.setReservedForChange("Reserved For Change");
		benPersonalHabit.setRiskySexualPracticeStatus("Risky Sexual Practice Status");
		benPersonalHabit.setRiskySexualPracticesStatus('A');
		benPersonalHabit.setSyncedBy("Synced By");
		benPersonalHabit.setSyncedDate(mock(Timestamp.class));
		benPersonalHabit.setTobaccoList(new ArrayList<>());
		benPersonalHabit.setTobaccoUseDuration(mock(Timestamp.class));
		benPersonalHabit.setTobaccoUseStatus("Tobacco Use Status");
		benPersonalHabit.setTobaccoUseType("Tobacco Use Type");
		benPersonalHabit.setTobaccoUseTypeID("Tobacco Use Type ID");
		benPersonalHabit.setTobacco_use_duration(mock(Date.class));
		benPersonalHabit.setVanID(1);
		benPersonalHabit.setVanSerialNo(1L);
		benPersonalHabit.setVehicalNo("Vehical No");
		benPersonalHabit.setVisitCode(1L);

		PhyGeneralExamination phyGeneralExamination = new PhyGeneralExamination();
		phyGeneralExamination.setBenVisitID(1L);
		phyGeneralExamination.setBeneficiaryRegID(1L);
		phyGeneralExamination.setBuiltAndAppearance("Built And Appearance");
		phyGeneralExamination.setClubbing("Clubbing");
		phyGeneralExamination.setCoherence("Coherence");
		phyGeneralExamination.setComfortness("Comfortness");
		phyGeneralExamination.setConsciousness("Consciousness");
		phyGeneralExamination.setCooperation("Cooperation");
		phyGeneralExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		phyGeneralExamination.setCreatedDate(mock(Timestamp.class));
		phyGeneralExamination.setCyanosis("Cyanosis");
		phyGeneralExamination.setDangerSigns("Danger Signs");
		phyGeneralExamination.setDeleted(true);
		phyGeneralExamination.setEdema("Edema");
		phyGeneralExamination.setEdemaType("Edema Type");
		phyGeneralExamination.setExtentOfEdema("Extent Of Edema");
		phyGeneralExamination.setFoetalMovements("Foetal Movements");
		phyGeneralExamination.setGait("Gait");
		phyGeneralExamination.setID(1L);
		phyGeneralExamination.setJaundice("Jaundice");
		phyGeneralExamination.setLastModDate(mock(Timestamp.class));
		phyGeneralExamination.setLymphadenopathy("Lymphadenopathy");
		phyGeneralExamination.setLymphnodesInvolved("Lymphnodes Involved");
		phyGeneralExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		phyGeneralExamination.setPallor("Pallor");
		phyGeneralExamination.setParkingPlaceID(1);
		phyGeneralExamination.setProcessed("Processed");
		phyGeneralExamination.setProviderServiceMapID(1);
		phyGeneralExamination.setQuickening("Quickening");
		phyGeneralExamination.setReservedForChange("Reserved For Change");
		phyGeneralExamination.setSyncedBy("Synced By");
		phyGeneralExamination.setSyncedDate(mock(Timestamp.class));
		phyGeneralExamination.setTypeOfDangerSign("Type Of Danger Sign");
		phyGeneralExamination.setTypeOfDangerSigns(new ArrayList<>());
		phyGeneralExamination.setTypeOfLymphadenopathy("Type Of Lymphadenopathy");
		phyGeneralExamination.setVanSerialNo(1L);
		phyGeneralExamination.setVehicalNo("Vehical No");
		phyGeneralExamination.setVisitCode(1L);

		PhyHeadToToeExamination phyHeadToToeExamination = new PhyHeadToToeExamination();
		phyHeadToToeExamination.setBenVisitID(1L);
		phyHeadToToeExamination.setBeneficiaryRegID(1L);
		phyHeadToToeExamination.setBreastAndNipples("Breast And Nipples");
		phyHeadToToeExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		phyHeadToToeExamination.setCreatedDate(mock(Timestamp.class));
		phyHeadToToeExamination.setDeleted(true);
		phyHeadToToeExamination.setEars("Ears");
		phyHeadToToeExamination.setEyes("Eyes");
		phyHeadToToeExamination.setHair("Hair");
		phyHeadToToeExamination.setHead("Head");
		phyHeadToToeExamination.setID(1L);
		phyHeadToToeExamination.setLastModDate(mock(Timestamp.class));
		phyHeadToToeExamination.setLowerLimbs("Lower Limbs");
		phyHeadToToeExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		phyHeadToToeExamination.setNails("Nails");
		phyHeadToToeExamination.setNose("Nose");
		phyHeadToToeExamination.setOralCavity("Oral Cavity");
		phyHeadToToeExamination.setParkingPlaceID(1);
		phyHeadToToeExamination.setProcessed("Processed");
		phyHeadToToeExamination.setProviderServiceMapID(1);
		phyHeadToToeExamination.setReservedForChange("Reserved For Change");
		phyHeadToToeExamination.setSkin("Skin");
		phyHeadToToeExamination.setSyncedBy("Synced By");
		phyHeadToToeExamination.setSyncedDate(mock(Timestamp.class));
		phyHeadToToeExamination.setThroat("Throat");
		phyHeadToToeExamination.setTrunk("Trunk");
		phyHeadToToeExamination.setUpperLimbs("Upper Limbs");
		phyHeadToToeExamination.setVanSerialNo(1L);
		phyHeadToToeExamination.setVehicalNo("Vehical No");
		phyHeadToToeExamination.setVisitCode(1L);

		SysCardiovascularExamination sysCardiovascularExamination = new SysCardiovascularExamination();
		sysCardiovascularExamination.setAdditionalHeartSounds("Additional Heart Sounds");
		sysCardiovascularExamination.setApexbeatLocation("Apexbeat Location");
		sysCardiovascularExamination.setApexbeatType("Apexbeat Type");
		sysCardiovascularExamination.setBenVisitID(1L);
		sysCardiovascularExamination.setBeneficiaryRegID(1L);
		sysCardiovascularExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		sysCardiovascularExamination.setCreatedDate(mock(Timestamp.class));
		sysCardiovascularExamination.setDeleted(true);
		sysCardiovascularExamination.setFirstHeartSound_S1("First Heart Sound S1");
		sysCardiovascularExamination.setID(1L);
		sysCardiovascularExamination.setJugularVenousPulse_JVP("Jugular Venous Pulse JVP");
		sysCardiovascularExamination.setLastModDate(mock(Timestamp.class));
		sysCardiovascularExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		sysCardiovascularExamination.setMurmurs("Murmurs");
		sysCardiovascularExamination.setParkingPlaceID(1);
		sysCardiovascularExamination.setPericardialRub("Pericardial Rub");
		sysCardiovascularExamination.setProcessed("Processed");
		sysCardiovascularExamination.setProviderServiceMapID(1);
		sysCardiovascularExamination.setReservedForChange("Reserved For Change");
		sysCardiovascularExamination.setSecondHeartSound_S2("Second Heart Sound S2");
		sysCardiovascularExamination.setSyncedBy("Synced By");
		sysCardiovascularExamination.setSyncedDate(mock(Timestamp.class));
		sysCardiovascularExamination.setVanSerialNo(1L);
		sysCardiovascularExamination.setVehicalNo("Vehical No");
		sysCardiovascularExamination.setVisitCode(1L);

		SysCentralNervousExamination sysCentralNervousExamination = new SysCentralNervousExamination();
		sysCentralNervousExamination.setAutonomicSystem("Autonomic System");
		sysCentralNervousExamination.setBenVisitID(1L);
		sysCentralNervousExamination.setBeneficiaryRegID(1L);
		sysCentralNervousExamination.setCerebellarSigns("Cerebellar Signs");
		sysCentralNervousExamination.setCranialNervesExamination("Cranial Nerves Examination");
		sysCentralNervousExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		sysCentralNervousExamination.setCreatedDate(mock(Timestamp.class));
		sysCentralNervousExamination.setDeleted(true);
		sysCentralNervousExamination.setHandedness("Handedness");
		sysCentralNervousExamination.setID(1L);
		sysCentralNervousExamination.setLastModDate(mock(Timestamp.class));
		sysCentralNervousExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		sysCentralNervousExamination.setMotorSystem("Motor System");
		sysCentralNervousExamination.setParkingPlaceID(1);
		sysCentralNervousExamination.setProcessed("Processed");
		sysCentralNervousExamination.setProviderServiceMapID(1);
		sysCentralNervousExamination.setReservedForChange("Reserved For Change");
		sysCentralNervousExamination.setSensorySystem("Sensory System");
		sysCentralNervousExamination.setSignsOfMeningealIrritation("Signs Of Meningeal Irritation");
		sysCentralNervousExamination.setSkull("Skull");
		sysCentralNervousExamination.setSyncedBy("Synced By");
		sysCentralNervousExamination.setSyncedDate(mock(Timestamp.class));
		sysCentralNervousExamination.setVanSerialNo(1L);
		sysCentralNervousExamination.setVehicalNo("Vehical No");
		sysCentralNervousExamination.setVisitCode(1L);

		SysGenitourinarySystemExamination sysGenitourinarySystemExamination = new SysGenitourinarySystemExamination();
		sysGenitourinarySystemExamination.setBenVisitID(1L);
		sysGenitourinarySystemExamination.setBeneficiaryRegID(1L);
		sysGenitourinarySystemExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		sysGenitourinarySystemExamination.setCreatedDate(mock(Timestamp.class));
		sysGenitourinarySystemExamination.setDeleted(true);
		sysGenitourinarySystemExamination.setExternalGenitalia("External Genitalia");
		sysGenitourinarySystemExamination.setID(1L);
		sysGenitourinarySystemExamination.setLastModDate(mock(Timestamp.class));
		sysGenitourinarySystemExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		sysGenitourinarySystemExamination.setParkingPlaceID(1);
		sysGenitourinarySystemExamination.setProcessed("Processed");
		sysGenitourinarySystemExamination.setProviderServiceMapID(1);
		sysGenitourinarySystemExamination.setRenalAngle("Renal Angle");
		sysGenitourinarySystemExamination.setReservedForChange("Reserved For Change");
		sysGenitourinarySystemExamination.setSuprapubicRegion("us-east-2");
		sysGenitourinarySystemExamination.setSyncedBy("Synced By");
		sysGenitourinarySystemExamination.setSyncedDate(mock(Timestamp.class));
		sysGenitourinarySystemExamination.setVanSerialNo(1L);
		sysGenitourinarySystemExamination.setVehicalNo("Vehical No");
		sysGenitourinarySystemExamination.setVisitCode(1L);

		SysMusculoskeletalSystemExamination sysMusculoskeletalSystemExamination = new SysMusculoskeletalSystemExamination();
		sysMusculoskeletalSystemExamination.setBenVisitID(1L);
		sysMusculoskeletalSystemExamination.setBeneficiaryRegID(1L);
		sysMusculoskeletalSystemExamination.setChestWall("Chest Wall");
		sysMusculoskeletalSystemExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		sysMusculoskeletalSystemExamination.setCreatedDate(mock(Timestamp.class));
		sysMusculoskeletalSystemExamination.setDeleted(true);
		sysMusculoskeletalSystemExamination.setID(1L);
		sysMusculoskeletalSystemExamination.setJoint_Abnormality("Joint Abnormality");
		sysMusculoskeletalSystemExamination.setJoint_Laterality("Joint Laterality");
		sysMusculoskeletalSystemExamination.setJoint_TypeOfJoint("Joint Type Of Joint");
		sysMusculoskeletalSystemExamination.setLastModDate(mock(Timestamp.class));
		sysMusculoskeletalSystemExamination.setLowerLimb_Abnormality("Lower Limb Abnormality");
		sysMusculoskeletalSystemExamination.setLowerLimb_Laterality("Lower Limb Laterality");
		sysMusculoskeletalSystemExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		sysMusculoskeletalSystemExamination.setParkingPlaceID(1);
		sysMusculoskeletalSystemExamination.setProcessed("Processed");
		sysMusculoskeletalSystemExamination.setProviderServiceMapID(1);
		sysMusculoskeletalSystemExamination.setReservedForChange("Reserved For Change");
		sysMusculoskeletalSystemExamination.setSpine("Spine");
		sysMusculoskeletalSystemExamination.setSyncedBy("Synced By");
		sysMusculoskeletalSystemExamination.setSyncedDate(mock(Timestamp.class));
		sysMusculoskeletalSystemExamination.setUpperLimb_Abnormality("Upper Limb Abnormality");
		sysMusculoskeletalSystemExamination.setUpperLimb_Laterality("Upper Limb Laterality");
		sysMusculoskeletalSystemExamination.setVanSerialNo(1L);
		sysMusculoskeletalSystemExamination.setVehicalNo("Vehical No");
		sysMusculoskeletalSystemExamination.setVisitCode(1L);

		SysRespiratoryExamination sysRespiratoryExamination = new SysRespiratoryExamination();
		sysRespiratoryExamination.setAuscultation("Auscultation");
		sysRespiratoryExamination.setAuscultation_BreathSounds("Auscultation Breath Sounds");
		sysRespiratoryExamination.setAuscultation_ConductedSounds("Auscultation Conducted Sounds");
		sysRespiratoryExamination.setAuscultation_Crepitations("Auscultation Crepitations");
		sysRespiratoryExamination.setAuscultation_PleuralRub("Auscultation Pleural Rub");
		sysRespiratoryExamination.setAuscultation_Stridor("Auscultation Stridor");
		sysRespiratoryExamination.setAuscultation_Wheezing("Auscultation Wheezing");
		sysRespiratoryExamination.setBenVisitID(1L);
		sysRespiratoryExamination.setBeneficiaryRegID(1L);
		sysRespiratoryExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		sysRespiratoryExamination.setCreatedDate(mock(Timestamp.class));
		sysRespiratoryExamination.setDeleted(true);
		sysRespiratoryExamination.setID(1L);
		sysRespiratoryExamination.setInspection("Inspection");
		sysRespiratoryExamination.setLastModDate(mock(Timestamp.class));
		sysRespiratoryExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		sysRespiratoryExamination.setPalpation("Palpation");
		sysRespiratoryExamination.setParkingPlaceID(1);
		sysRespiratoryExamination.setPercussion("Percussion");
		sysRespiratoryExamination.setProcessed("Processed");
		sysRespiratoryExamination.setProviderServiceMapID(1);
		sysRespiratoryExamination.setReservedForChange("Reserved For Change");
		sysRespiratoryExamination.setSignsOfRespiratoryDistress("Signs Of Respiratory Distress");
		sysRespiratoryExamination.setSyncedBy("Synced By");
		sysRespiratoryExamination.setSyncedDate(mock(Timestamp.class));
		sysRespiratoryExamination.setTrachea("Trachea");
		sysRespiratoryExamination.setVanSerialNo(1L);
		sysRespiratoryExamination.setVehicalNo("Vehical No");
		sysRespiratoryExamination.setVisitCode(1L);

		WrapperChildOptionalVaccineDetail wrapperChildOptionalVaccineDetail = new WrapperChildOptionalVaccineDetail();
		wrapperChildOptionalVaccineDetail.setBenVisitID(1L);
		wrapperChildOptionalVaccineDetail.setBeneficiaryRegID(1L);
		wrapperChildOptionalVaccineDetail.setChildOptionalVaccineList(new ArrayList<>());
		wrapperChildOptionalVaccineDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperChildOptionalVaccineDetail.setParkingPlaceID(1);
		wrapperChildOptionalVaccineDetail.setProviderServiceMapID(1);
		wrapperChildOptionalVaccineDetail.setVanID(1);
		wrapperChildOptionalVaccineDetail.setVisitCode(1L);

		WrapperComorbidCondDetails wrapperComorbidCondDetails = new WrapperComorbidCondDetails();
		wrapperComorbidCondDetails.setBenVisitID(1L);
		wrapperComorbidCondDetails.setBeneficiaryRegID(1L);
		wrapperComorbidCondDetails.setComorbidityConcurrentConditionsList(new ArrayList<>());
		wrapperComorbidCondDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperComorbidCondDetails.setParkingPlaceID(1);
		wrapperComorbidCondDetails.setProviderServiceMapID(1);
		wrapperComorbidCondDetails.setVanID(1);
		wrapperComorbidCondDetails.setVisitCode(1L);

		WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory = new WrapperFemaleObstetricHistory();
		wrapperFemaleObstetricHistory.setBenVisitID(1L);
		wrapperFemaleObstetricHistory.setBeneficiaryRegID(1L);
		wrapperFemaleObstetricHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperFemaleObstetricHistory.setFemaleObstetricHistoryList(new ArrayList<>());
		wrapperFemaleObstetricHistory.setParkingPlaceID(1);
		wrapperFemaleObstetricHistory.setProviderServiceMapID(1);
		wrapperFemaleObstetricHistory.setTotalNoOfPreg((short) 1);
		wrapperFemaleObstetricHistory.setVanID(1);
		wrapperFemaleObstetricHistory.setVisitCode(1L);

		WrapperImmunizationHistory wrapperImmunizationHistory = new WrapperImmunizationHistory();
		wrapperImmunizationHistory.setBenVisitID(1L);
		wrapperImmunizationHistory.setBeneficiaryRegID(1L);
		wrapperImmunizationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperImmunizationHistory.setImmunizationList(new ArrayList<>());
		wrapperImmunizationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		wrapperImmunizationHistory.setParkingPlaceID(1);
		wrapperImmunizationHistory.setProviderServiceMapID(1);
		wrapperImmunizationHistory.setVanID(1);
		wrapperImmunizationHistory.setVisitCode(1L);

		WrapperMedicationHistory wrapperMedicationHistory = new WrapperMedicationHistory();
		wrapperMedicationHistory.setBenVisitID(1L);
		wrapperMedicationHistory.setBeneficiaryRegID(1L);
		wrapperMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperMedicationHistory.setMedicationHistoryList(new ArrayList<>());
		wrapperMedicationHistory.setParkingPlaceID(1);
		wrapperMedicationHistory.setProviderServiceMapID(1);
		wrapperMedicationHistory.setVanID(1);
		wrapperMedicationHistory.setVisitCode(1L);
		when(commonNurseServiceImpl.getFamilyHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benFamilyHistory);
		when(commonNurseServiceImpl.getPastHistoryData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benMedHistory);
		when(commonNurseServiceImpl.getMenstrualHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benMenstrualDetails);
		when(commonNurseServiceImpl.getPersonalHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benPersonalHabit);
		when(commonNurseServiceImpl.getGeneralExaminationData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(phyGeneralExamination);
		when(commonNurseServiceImpl.getHeadToToeExaminationData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(phyHeadToToeExamination);
		when(commonNurseServiceImpl.getCardiovascularExamination(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(sysCardiovascularExamination);
		when(commonNurseServiceImpl.getSysCentralNervousExamination(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(sysCentralNervousExamination);
		when(commonNurseServiceImpl.getGenitourinaryExamination(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(sysGenitourinarySystemExamination);
		when(commonNurseServiceImpl.getMusculoskeletalExamination(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(sysMusculoskeletalSystemExamination);
		when(commonNurseServiceImpl.getRespiratoryExamination(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(sysRespiratoryExamination);
		when(commonNurseServiceImpl.getChildOptionalVaccineHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(wrapperChildOptionalVaccineDetail);
		when(commonNurseServiceImpl.getComorbidityConditionsHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(wrapperComorbidCondDetails);
		when(commonNurseServiceImpl.getFemaleObstetricHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(wrapperFemaleObstetricHistory);
		when(commonNurseServiceImpl.getImmunizationHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(wrapperImmunizationHistory);
		when(commonNurseServiceImpl.getMedicationHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(wrapperMedicationHistory);
		when(commonNurseServiceImpl.getBeneficiaryPhysicalAnthropometryDetails(Mockito.<Long>any(),
				Mockito.<Long>any())).thenReturn("Beneficiary Physical Anthropometry Details");
		when(commonNurseServiceImpl.getBeneficiaryPhysicalVitalDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Beneficiary Physical Vital Details");

		// Act
		aNCServiceImpl.getBenANCNurseData(1L, 1L);
	}

	@Test
	void testGetBenCaseRecordFromDoctorANC() throws Exception {
		// Arrange
		when(aNCDoctorServiceImpl.getANCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Anc Diagnosis Details");
		when(commonDoctorServiceImpl.getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Findings Details");
		when(commonDoctorServiceImpl.getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Investigation Details");
		when(commonDoctorServiceImpl.getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Prescribed Drugs");
		when(commonDoctorServiceImpl.getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Referral Details");
		when(commonNurseServiceImpl.getGraphicalTrendData(Mockito.<Long>any(), Mockito.<String>any()))
				.thenReturn(new HashMap<>());
		when(labTechnicianServiceImpl.getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Last 3 Archived Test Visit List");
		when(labTechnicianServiceImpl.getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());

		// Act
		String actualBenCaseRecordFromDoctorANC = aNCServiceImpl.getBenCaseRecordFromDoctorANC(1L, 1L);

		// Assert
		verify(aNCDoctorServiceImpl).getANCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonNurseServiceImpl).getGraphicalTrendData(Mockito.<Long>any(), eq("anc"));
		verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
		verify(labTechnicianServiceImpl).getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("{Refer=Referral Details, prescription=Prescribed Drugs, findings=Findings Details, LabReport=[],"
				+ " diagnosis=Anc Diagnosis Details, investigation=Investigation Details, ArchivedVisitcodeForLabResult=Last"
				+ " 3 Archived Test Visit List, GraphData={}}", actualBenCaseRecordFromDoctorANC);
	}

	@Test
	void testGetBenCaseRecordFromDoctorANC2() throws Exception {
		// Arrange
		when(aNCDoctorServiceImpl.getANCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Anc Diagnosis Details");
		when(commonDoctorServiceImpl.getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Findings Details");
		when(commonDoctorServiceImpl.getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Investigation Details");
		when(commonDoctorServiceImpl.getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Prescribed Drugs");
		when(commonDoctorServiceImpl.getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Referral Details");
		when(labTechnicianServiceImpl.getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenThrow(new Exception("findings"));

		// Act and Assert
		assertThrows(Exception.class, () -> aNCServiceImpl.getBenCaseRecordFromDoctorANC(1L, 1L));
		verify(aNCDoctorServiceImpl).getANCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
	}

	@Test
	void testGetBenCaseRecordFromDoctorANC3() throws Exception {
		// Arrange
		when(aNCDoctorServiceImpl.getANCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Anc Diagnosis Details");
		when(commonDoctorServiceImpl.getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Findings Details");
		when(commonDoctorServiceImpl.getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Investigation Details");
		when(commonDoctorServiceImpl.getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Prescribed Drugs");
		when(commonDoctorServiceImpl.getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Referral Details");

		HashMap<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("findings", "42");
		when(commonNurseServiceImpl.getGraphicalTrendData(Mockito.<Long>any(), Mockito.<String>any()))
				.thenReturn(stringObjectMap);
		when(labTechnicianServiceImpl.getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Last 3 Archived Test Visit List");
		when(labTechnicianServiceImpl.getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());

		// Act
		String actualBenCaseRecordFromDoctorANC = aNCServiceImpl.getBenCaseRecordFromDoctorANC(1L, 1L);

		// Assert
		verify(aNCDoctorServiceImpl).getANCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonNurseServiceImpl).getGraphicalTrendData(Mockito.<Long>any(), eq("anc"));
		verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
		verify(labTechnicianServiceImpl).getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("{Refer=Referral Details, prescription=Prescribed Drugs, findings=Findings Details, LabReport=[],"
				+ " diagnosis=Anc Diagnosis Details, investigation=Investigation Details, ArchivedVisitcodeForLabResult=Last"
				+ " 3 Archived Test Visit List, GraphData={\"findings\":\"42\"}}", actualBenCaseRecordFromDoctorANC);
	}

	@Test
	void testGetBenCaseRecordFromDoctorANC4() throws Exception {
		// Arrange
		when(aNCDoctorServiceImpl.getANCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Anc Diagnosis Details");
		when(commonDoctorServiceImpl.getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Findings Details");
		when(commonDoctorServiceImpl.getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Investigation Details");
		when(commonDoctorServiceImpl.getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Prescribed Drugs");
		when(commonDoctorServiceImpl.getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Referral Details");

		HashMap<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("diagnosis", "42");
		stringObjectMap.put("findings", "42");
		when(commonNurseServiceImpl.getGraphicalTrendData(Mockito.<Long>any(), Mockito.<String>any()))
				.thenReturn(stringObjectMap);
		when(labTechnicianServiceImpl.getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Last 3 Archived Test Visit List");
		when(labTechnicianServiceImpl.getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());

		// Act
		String actualBenCaseRecordFromDoctorANC = aNCServiceImpl.getBenCaseRecordFromDoctorANC(1L, 1L);

		// Assert
		verify(aNCDoctorServiceImpl).getANCDiagnosisDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonNurseServiceImpl).getGraphicalTrendData(Mockito.<Long>any(), eq("anc"));
		verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
		verify(labTechnicianServiceImpl).getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("{Refer=Referral Details, prescription=Prescribed Drugs, findings=Findings Details, LabReport=[],"
				+ " diagnosis=Anc Diagnosis Details, investigation=Investigation Details, ArchivedVisitcodeForLabResult=Last"
				+ " 3 Archived Test Visit List, GraphData={\"findings\":\"42\",\"diagnosis\":\"42\"}}",
				actualBenCaseRecordFromDoctorANC);
	}

	@Test
	void testGetHRPStatus() throws Exception {
		// Arrange
		Timestamp timestamp = mock(Timestamp.class);
		when(timestamp.getTime()).thenReturn(10L);
		when(beneficiaryFlowStatusRepo.getBenAgeVal(Mockito.<Long>any())).thenReturn(timestamp);

		// Act
		String actualHRPStatus = aNCServiceImpl.getHRPStatus(1L, 1L);

		// Assert
		verify(beneficiaryFlowStatusRepo).getBenAgeVal(Mockito.<Long>any());
		verify(timestamp).getTime();
		assertEquals("{\"isHRP\":true}", actualHRPStatus);
	}

	@Test
	void testGetHRPStatus2() throws Exception {
		// Arrange
		Timestamp timestamp = mock(Timestamp.class);
		when(timestamp.getTime()).thenThrow(new RuntimeException("isHRP"));
		when(beneficiaryFlowStatusRepo.getBenAgeVal(Mockito.<Long>any())).thenReturn(timestamp);

		// Act and Assert
		assertThrows(RuntimeException.class, () -> aNCServiceImpl.getHRPStatus(1L, 1L));
		verify(beneficiaryFlowStatusRepo).getBenAgeVal(Mockito.<Long>any());
		verify(timestamp).getTime();
	}

	@Test
	void testGetHRPStatus3() throws Exception {
		// Arrange
		Timestamp timestamp = mock(Timestamp.class);
		when(timestamp.getTime()).thenReturn(Long.MAX_VALUE);
		when(beneficiaryFlowStatusRepo.getBenAgeVal(Mockito.<Long>any())).thenReturn(timestamp);

		// Act
		String actualHRPStatus = aNCServiceImpl.getHRPStatus(1L, 1L);

		// Assert
		verify(beneficiaryFlowStatusRepo).getBenAgeVal(Mockito.<Long>any());
		verify(timestamp).getTime();
		assertEquals("{\"isHRP\":true}", actualHRPStatus);
	}
}
