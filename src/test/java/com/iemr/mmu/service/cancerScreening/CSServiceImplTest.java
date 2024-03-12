package com.iemr.mmu.service.cancerScreening;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.doctor.CancerAbdominalExamination;
import com.iemr.mmu.data.doctor.CancerBreastExamination;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.doctor.CancerGynecologicalExamination;
import com.iemr.mmu.data.doctor.CancerOralExamination;
import com.iemr.mmu.data.doctor.CancerSignAndSymptoms;
import com.iemr.mmu.data.doctor.WrapperCancerExamImgAnotasn;
import com.iemr.mmu.data.institution.Institute;
import com.iemr.mmu.data.location.Districts;
import com.iemr.mmu.data.location.States;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.nurse.CommonUtilityClass;
import com.iemr.mmu.data.provider.ProviderServiceMapping;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.location.ZoneDistrictMapping;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenData;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.tele_consultation.TeleConsultationServiceImpl;

@ExtendWith(MockitoExtension.class)
class CSServiceImplTest {
	@Mock
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;

	@Mock
	private CSCarestreamServiceImpl cSCarestreamServiceImpl;

	@Mock
	private CSDoctorServiceImpl cSDoctorServiceImpl;

	@Mock
	private CSNurseServiceImpl cSNurseServiceImpl;

	@Mock
	private CSOncologistServiceImpl cSOncologistServiceImpl;

	@InjectMocks
	private CSServiceImpl cSServiceImpl;

	@Mock
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;

	@Mock
	private CommonDoctorServiceImpl commonDoctorServiceImpl;

	@Mock
	private CommonNurseServiceImpl commonNurseServiceImpl;

	@Mock
	private RegistrarRepoBenData registrarRepoBenData;

	@Mock
	private TeleConsultationServiceImpl teleConsultationServiceImpl;

	@Test
	void testSaveCancerScreeningNurseData() throws Exception {
		// Arrange, Act and Assert
		assertNull(cSServiceImpl.saveCancerScreeningNurseData(new JsonObject(), "JaneDoe"));
		assertNull(cSServiceImpl.saveCancerScreeningNurseData(null, "JaneDoe"));
	}

	@Test
	void testSaveCancerScreeningNurseData2() throws Exception {
		// Arrange
		JsonObject requestOBJ = new JsonObject();
		requestOBJ.add("Property", new JsonArray(3));

		// Act and Assert
		assertNull(cSServiceImpl.saveCancerScreeningNurseData(requestOBJ, "JaneDoe"));
	}

	@Test
	void testSaveCancerScreeningNurseData3() throws Exception {
		// Arrange
		JsonObject requestOBJ = new JsonObject();
		requestOBJ.addProperty("visitDetails", (String) null);

		// Act and Assert
		assertNull(cSServiceImpl.saveCancerScreeningNurseData(requestOBJ, "JaneDoe"));
	}

	@Test
	void testSaveBenVisitDetails() throws Exception {
		// Arrange
		when(commonNurseServiceImpl.getMaxCurrentdate(Mockito.<Long>any(), Mockito.<String>any(),
				Mockito.<String>any())).thenReturn(3);

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

		BeneficiaryVisitDetail benVisitDetailsOBJ = new BeneficiaryVisitDetail();
		benVisitDetailsOBJ.setBenVisitID(1L);
		benVisitDetailsOBJ.setBeneficiaryRegID(1L);
		benVisitDetailsOBJ.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benVisitDetailsOBJ.setCreatedDate(mock(Timestamp.class));
		benVisitDetailsOBJ.setDeleted(true);
		benVisitDetailsOBJ.setFileIDs(new String[] { "File IDs" });
		benVisitDetailsOBJ.setFiles(new ArrayList<>());
		benVisitDetailsOBJ.setHealthFacilityLocation("Health Facility Location");
		benVisitDetailsOBJ.setHealthFacilityType("Health Facility Type");
		benVisitDetailsOBJ.setLastModDate(mock(Timestamp.class));
		benVisitDetailsOBJ.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benVisitDetailsOBJ.setParkingPlaceID(1);
		benVisitDetailsOBJ.setPregnancyStatus("Pregnancy Status");
		benVisitDetailsOBJ.setProcessed("Processed");
		benVisitDetailsOBJ.setProviderServiceMapID(1);
		benVisitDetailsOBJ.setProviderServiceMapping(providerServiceMapping);
		benVisitDetailsOBJ.setReportFilePath("/directory/foo.txt");
		benVisitDetailsOBJ.setReservedForChange("Reserved For Change");
		benVisitDetailsOBJ.setServiceProviderName("Service Provider Name");
		benVisitDetailsOBJ.setSyncedBy("Synced By");
		benVisitDetailsOBJ.setSyncedDate(mock(Timestamp.class));
		benVisitDetailsOBJ.setVanID(1);
		benVisitDetailsOBJ.setVanSerialNo(1L);
		benVisitDetailsOBJ.setVehicalNo("Vehical No");
		benVisitDetailsOBJ.setVisitCategory("Visit Category");
		benVisitDetailsOBJ.setVisitCategoryID(1);
		benVisitDetailsOBJ.setVisitCode(1L);
		benVisitDetailsOBJ.setVisitDateTime(mock(Timestamp.class));
		benVisitDetailsOBJ.setVisitFlowStatusFlag("Visit Flow Status Flag");
		benVisitDetailsOBJ.setVisitNo((short) 1);
		benVisitDetailsOBJ.setVisitReason("Just cause");
		benVisitDetailsOBJ.setVisitReasonID((short) 1);
		benVisitDetailsOBJ.setrCHID("R CHID");

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

		// Act
		Map<String, Long> actualSaveBenVisitDetailsResult = cSServiceImpl.saveBenVisitDetails(benVisitDetailsOBJ,
				nurseUtilityClass);

		// Assert
		verify(commonNurseServiceImpl).getMaxCurrentdate(Mockito.<Long>any(), eq("Just cause"), eq("Visit Category"));
		assertTrue(actualSaveBenVisitDetailsResult.isEmpty());
	}

	@Test
	void testSaveBenVisitDetails2() throws Exception {
		// Arrange
		when(commonNurseServiceImpl.getMaxCurrentdate(Mockito.<Long>any(), Mockito.<String>any(),
				Mockito.<String>any())).thenReturn(0);
		when(commonNurseServiceImpl.generateVisitCode(Mockito.<Long>any(), Mockito.<Integer>any(),
				Mockito.<Integer>any())).thenReturn(1L);
		when(commonNurseServiceImpl.saveBeneficiaryVisitDetails(Mockito.<BeneficiaryVisitDetail>any())).thenReturn(1L);

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

		BeneficiaryVisitDetail benVisitDetailsOBJ = new BeneficiaryVisitDetail();
		benVisitDetailsOBJ.setBenVisitID(1L);
		benVisitDetailsOBJ.setBeneficiaryRegID(1L);
		benVisitDetailsOBJ.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benVisitDetailsOBJ.setCreatedDate(mock(Timestamp.class));
		benVisitDetailsOBJ.setDeleted(true);
		benVisitDetailsOBJ.setFileIDs(new String[] { "File IDs" });
		benVisitDetailsOBJ.setFiles(new ArrayList<>());
		benVisitDetailsOBJ.setHealthFacilityLocation("Health Facility Location");
		benVisitDetailsOBJ.setHealthFacilityType("Health Facility Type");
		benVisitDetailsOBJ.setLastModDate(mock(Timestamp.class));
		benVisitDetailsOBJ.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benVisitDetailsOBJ.setParkingPlaceID(1);
		benVisitDetailsOBJ.setPregnancyStatus("Pregnancy Status");
		benVisitDetailsOBJ.setProcessed("Processed");
		benVisitDetailsOBJ.setProviderServiceMapID(1);
		benVisitDetailsOBJ.setProviderServiceMapping(providerServiceMapping);
		benVisitDetailsOBJ.setReportFilePath("/directory/foo.txt");
		benVisitDetailsOBJ.setReservedForChange("Reserved For Change");
		benVisitDetailsOBJ.setServiceProviderName("Service Provider Name");
		benVisitDetailsOBJ.setSyncedBy("Synced By");
		benVisitDetailsOBJ.setSyncedDate(mock(Timestamp.class));
		benVisitDetailsOBJ.setVanID(1);
		benVisitDetailsOBJ.setVanSerialNo(1L);
		benVisitDetailsOBJ.setVehicalNo("Vehical No");
		benVisitDetailsOBJ.setVisitCategory("Visit Category");
		benVisitDetailsOBJ.setVisitCategoryID(1);
		benVisitDetailsOBJ.setVisitCode(1L);
		benVisitDetailsOBJ.setVisitDateTime(mock(Timestamp.class));
		benVisitDetailsOBJ.setVisitFlowStatusFlag("Visit Flow Status Flag");
		benVisitDetailsOBJ.setVisitNo((short) 1);
		benVisitDetailsOBJ.setVisitReason("Just cause");
		benVisitDetailsOBJ.setVisitReasonID((short) 1);
		benVisitDetailsOBJ.setrCHID("R CHID");

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

		// Act
		Map<String, Long> actualSaveBenVisitDetailsResult = cSServiceImpl.saveBenVisitDetails(benVisitDetailsOBJ,
				nurseUtilityClass);

		// Assert
		verify(commonNurseServiceImpl).generateVisitCode(Mockito.<Long>any(), Mockito.<Integer>any(),
				Mockito.<Integer>any());
		verify(commonNurseServiceImpl).getMaxCurrentdate(Mockito.<Long>any(), eq("Just cause"), eq("Visit Category"));
		verify(commonNurseServiceImpl).saveBeneficiaryVisitDetails(Mockito.<BeneficiaryVisitDetail>any());
		assertEquals(2, actualSaveBenVisitDetailsResult.size());
		assertEquals(1L, actualSaveBenVisitDetailsResult.get("visitCode").longValue());
		assertEquals(1L, actualSaveBenVisitDetailsResult.get("visitID").longValue());
	}

	@Test
	void testSaveBenVisitDetails3() throws Exception {
		// Arrange
		when(commonNurseServiceImpl.getMaxCurrentdate(Mockito.<Long>any(), Mockito.<String>any(),
				Mockito.<String>any())).thenReturn(3);

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
		BeneficiaryVisitDetail benVisitDetailsOBJ = mock(BeneficiaryVisitDetail.class);
		when(benVisitDetailsOBJ.getBeneficiaryRegID()).thenReturn(1L);
		when(benVisitDetailsOBJ.getVisitCategory()).thenReturn("Visit Category");
		when(benVisitDetailsOBJ.getVisitReason()).thenReturn("Just cause");
		doNothing().when(benVisitDetailsOBJ).setBenVisitID(Mockito.<Long>any());
		doNothing().when(benVisitDetailsOBJ).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(benVisitDetailsOBJ).setCreatedBy(Mockito.<String>any());
		doNothing().when(benVisitDetailsOBJ).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(benVisitDetailsOBJ).setDeleted(Mockito.<Boolean>any());
		doNothing().when(benVisitDetailsOBJ).setFileIDs(Mockito.<String[]>any());
		doNothing().when(benVisitDetailsOBJ).setFiles(Mockito.<ArrayList<Map<String, String>>>any());
		doNothing().when(benVisitDetailsOBJ).setHealthFacilityLocation(Mockito.<String>any());
		doNothing().when(benVisitDetailsOBJ).setHealthFacilityType(Mockito.<String>any());
		doNothing().when(benVisitDetailsOBJ).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(benVisitDetailsOBJ).setModifiedBy(Mockito.<String>any());
		doNothing().when(benVisitDetailsOBJ).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(benVisitDetailsOBJ).setPregnancyStatus(Mockito.<String>any());
		doNothing().when(benVisitDetailsOBJ).setProcessed(Mockito.<String>any());
		doNothing().when(benVisitDetailsOBJ).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(benVisitDetailsOBJ).setProviderServiceMapping(Mockito.<ProviderServiceMapping>any());
		doNothing().when(benVisitDetailsOBJ).setReportFilePath(Mockito.<String>any());
		doNothing().when(benVisitDetailsOBJ).setReservedForChange(Mockito.<String>any());
		doNothing().when(benVisitDetailsOBJ).setServiceProviderName(Mockito.<String>any());
		doNothing().when(benVisitDetailsOBJ).setSyncedBy(Mockito.<String>any());
		doNothing().when(benVisitDetailsOBJ).setSyncedDate(Mockito.<Timestamp>any());
		doNothing().when(benVisitDetailsOBJ).setVanID(Mockito.<Integer>any());
		doNothing().when(benVisitDetailsOBJ).setVanSerialNo(Mockito.<Long>any());
		doNothing().when(benVisitDetailsOBJ).setVehicalNo(Mockito.<String>any());
		doNothing().when(benVisitDetailsOBJ).setVisitCategory(Mockito.<String>any());
		doNothing().when(benVisitDetailsOBJ).setVisitCategoryID(Mockito.<Integer>any());
		doNothing().when(benVisitDetailsOBJ).setVisitCode(Mockito.<Long>any());
		doNothing().when(benVisitDetailsOBJ).setVisitDateTime(Mockito.<Timestamp>any());
		doNothing().when(benVisitDetailsOBJ).setVisitFlowStatusFlag(Mockito.<String>any());
		doNothing().when(benVisitDetailsOBJ).setVisitNo(Mockito.<Short>any());
		doNothing().when(benVisitDetailsOBJ).setVisitReason(Mockito.<String>any());
		doNothing().when(benVisitDetailsOBJ).setVisitReasonID(Mockito.<Short>any());
		doNothing().when(benVisitDetailsOBJ).setrCHID(Mockito.<String>any());
		benVisitDetailsOBJ.setBenVisitID(1L);
		benVisitDetailsOBJ.setBeneficiaryRegID(1L);
		benVisitDetailsOBJ.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benVisitDetailsOBJ.setCreatedDate(mock(Timestamp.class));
		benVisitDetailsOBJ.setDeleted(true);
		benVisitDetailsOBJ.setFileIDs(new String[] { "File IDs" });
		benVisitDetailsOBJ.setFiles(new ArrayList<>());
		benVisitDetailsOBJ.setHealthFacilityLocation("Health Facility Location");
		benVisitDetailsOBJ.setHealthFacilityType("Health Facility Type");
		benVisitDetailsOBJ.setLastModDate(mock(Timestamp.class));
		benVisitDetailsOBJ.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benVisitDetailsOBJ.setParkingPlaceID(1);
		benVisitDetailsOBJ.setPregnancyStatus("Pregnancy Status");
		benVisitDetailsOBJ.setProcessed("Processed");
		benVisitDetailsOBJ.setProviderServiceMapID(1);
		benVisitDetailsOBJ.setProviderServiceMapping(providerServiceMapping);
		benVisitDetailsOBJ.setReportFilePath("/directory/foo.txt");
		benVisitDetailsOBJ.setReservedForChange("Reserved For Change");
		benVisitDetailsOBJ.setServiceProviderName("Service Provider Name");
		benVisitDetailsOBJ.setSyncedBy("Synced By");
		benVisitDetailsOBJ.setSyncedDate(mock(Timestamp.class));
		benVisitDetailsOBJ.setVanID(1);
		benVisitDetailsOBJ.setVanSerialNo(1L);
		benVisitDetailsOBJ.setVehicalNo("Vehical No");
		benVisitDetailsOBJ.setVisitCategory("Visit Category");
		benVisitDetailsOBJ.setVisitCategoryID(1);
		benVisitDetailsOBJ.setVisitCode(1L);
		benVisitDetailsOBJ.setVisitDateTime(mock(Timestamp.class));
		benVisitDetailsOBJ.setVisitFlowStatusFlag("Visit Flow Status Flag");
		benVisitDetailsOBJ.setVisitNo((short) 1);
		benVisitDetailsOBJ.setVisitReason("Just cause");
		benVisitDetailsOBJ.setVisitReasonID((short) 1);
		benVisitDetailsOBJ.setrCHID("R CHID");

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

		// Act
		Map<String, Long> actualSaveBenVisitDetailsResult = cSServiceImpl.saveBenVisitDetails(benVisitDetailsOBJ,
				nurseUtilityClass);

		// Assert
		verify(benVisitDetailsOBJ).getBeneficiaryRegID();
		verify(benVisitDetailsOBJ).getVisitCategory();
		verify(benVisitDetailsOBJ).getVisitReason();
		verify(benVisitDetailsOBJ).setBenVisitID(Mockito.<Long>any());
		verify(benVisitDetailsOBJ).setBeneficiaryRegID(Mockito.<Long>any());
		verify(benVisitDetailsOBJ).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(benVisitDetailsOBJ).setCreatedDate(Mockito.<Timestamp>any());
		verify(benVisitDetailsOBJ).setDeleted(Mockito.<Boolean>any());
		verify(benVisitDetailsOBJ).setFileIDs(Mockito.<String[]>any());
		verify(benVisitDetailsOBJ).setFiles(Mockito.<ArrayList<Map<String, String>>>any());
		verify(benVisitDetailsOBJ).setHealthFacilityLocation(eq("Health Facility Location"));
		verify(benVisitDetailsOBJ).setHealthFacilityType(eq("Health Facility Type"));
		verify(benVisitDetailsOBJ).setLastModDate(Mockito.<Timestamp>any());
		verify(benVisitDetailsOBJ).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(benVisitDetailsOBJ).setParkingPlaceID(Mockito.<Integer>any());
		verify(benVisitDetailsOBJ).setPregnancyStatus(eq("Pregnancy Status"));
		verify(benVisitDetailsOBJ).setProcessed(eq("Processed"));
		verify(benVisitDetailsOBJ).setProviderServiceMapID(Mockito.<Integer>any());
		verify(benVisitDetailsOBJ).setProviderServiceMapping(Mockito.<ProviderServiceMapping>any());
		verify(benVisitDetailsOBJ).setReportFilePath(eq("/directory/foo.txt"));
		verify(benVisitDetailsOBJ).setReservedForChange(eq("Reserved For Change"));
		verify(benVisitDetailsOBJ).setServiceProviderName(eq("Service Provider Name"));
		verify(benVisitDetailsOBJ).setSyncedBy(eq("Synced By"));
		verify(benVisitDetailsOBJ).setSyncedDate(Mockito.<Timestamp>any());
		verify(benVisitDetailsOBJ).setVanID(Mockito.<Integer>any());
		verify(benVisitDetailsOBJ).setVanSerialNo(Mockito.<Long>any());
		verify(benVisitDetailsOBJ).setVehicalNo(eq("Vehical No"));
		verify(benVisitDetailsOBJ).setVisitCategory(eq("Visit Category"));
		verify(benVisitDetailsOBJ).setVisitCategoryID(Mockito.<Integer>any());
		verify(benVisitDetailsOBJ).setVisitCode(Mockito.<Long>any());
		verify(benVisitDetailsOBJ).setVisitDateTime(Mockito.<Timestamp>any());
		verify(benVisitDetailsOBJ).setVisitFlowStatusFlag(eq("Visit Flow Status Flag"));
		verify(benVisitDetailsOBJ).setVisitNo(Mockito.<Short>any());
		verify(benVisitDetailsOBJ).setVisitReason(eq("Just cause"));
		verify(benVisitDetailsOBJ).setVisitReasonID(Mockito.<Short>any());
		verify(benVisitDetailsOBJ).setrCHID(eq("R CHID"));
		verify(commonNurseServiceImpl).getMaxCurrentdate(Mockito.<Long>any(), eq("Just cause"), eq("Visit Category"));
		assertTrue(actualSaveBenVisitDetailsResult.isEmpty());
	}

	@Test
	void testSaveBenHistoryDetails() throws Exception {
		// Arrange, Act and Assert
		assertEquals(1L, cSServiceImpl.saveBenHistoryDetails(new JsonObject(), 1L, 1L).longValue());
		assertEquals(1L, cSServiceImpl.saveBenHistoryDetails(null, 1L, 1L).longValue());
	}

	@Test
	void testSaveBenFamilyHistoryDetails() {
		// Arrange, Act and Assert
		assertNull(cSServiceImpl.saveBenFamilyHistoryDetails());
	}

	@Test
	void testSaveBenVitalsDetails() throws Exception {
		// Arrange, Act and Assert
		assertEquals(1L, cSServiceImpl.saveBenVitalsDetails(new JsonObject(), 1L, 1L).longValue());
		assertEquals(1L, cSServiceImpl.saveBenVitalsDetails(null, 1L, 1L).longValue());
	}

	@Test
	void testSaveBenVitalsDetails2() throws Exception {
		// Arrange
		JsonObject requestOBJ = new JsonObject();
		requestOBJ.add("Property", new JsonArray(3));

		// Act and Assert
		assertEquals(1L, cSServiceImpl.saveBenVitalsDetails(requestOBJ, 1L, 1L).longValue());
	}

	@Test
	void testSaveBenVitalsDetails3() throws Exception {
		// Arrange
		JsonObject requestOBJ = new JsonObject();
		requestOBJ.addProperty("vitalsDetails", (String) null);

		// Act and Assert
		assertEquals(1L, cSServiceImpl.saveBenVitalsDetails(requestOBJ, 1L, 1L).longValue());
	}

	@Test
	void testGettersAndSetters() {
		// TODO: Diffblue Cover was only able to create a partial test for this method:
		// Reason: Missing observers.
		// Diffblue Cover was unable to create an assertion.
		// Add getters for the following fields or make them package-private:
		// CSServiceImpl.beneficiaryFlowStatusRepo
		// CSServiceImpl.cSCarestreamServiceImpl
		// CSServiceImpl.cSDoctorServiceImpl
		// CSServiceImpl.cSNurseServiceImpl
		// CSServiceImpl.commonBenStatusFlowServiceImpl
		// CSServiceImpl.commonDoctorServiceImpl
		// CSServiceImpl.commonNurseServiceImpl
		// CSServiceImpl.csOncologistServiceImpl
		// CSServiceImpl.logger
		// CSServiceImpl.registrarQuickSearchByIdUrl
		// CSServiceImpl.registrarRepoBenData
		// CSServiceImpl.teleConsultationServiceImpl
		// CSServiceImpl.tmReferCheckValue

		// Arrange
		CSServiceImpl csServiceImpl = new CSServiceImpl();

		// Act
		csServiceImpl.setBeneficiaryFlowStatusRepo(mock(BeneficiaryFlowStatusRepo.class));
		csServiceImpl.setCommonBenStatusFlowServiceImpl(new CommonBenStatusFlowServiceImpl());
		csServiceImpl.setCommonNurseServiceImpl(new CommonNurseServiceImpl());
		csServiceImpl.setCsOncologistServiceImpl(new CSOncologistServiceImpl());
		csServiceImpl.setRegistrarRepoBenData(mock(RegistrarRepoBenData.class));
		csServiceImpl.setcSCarestreamServiceImpl(new CSCarestreamServiceImpl());
		csServiceImpl.setcSDoctorServiceImpl(new CSDoctorServiceImpl());
		csServiceImpl.setcSNurseServiceImpl(new CSNurseServiceImpl());
	}

	@Test
	void testUpdateCSHistoryNurseData() throws Exception {
		// Arrange, Act and Assert
		assertEquals(1, cSServiceImpl.UpdateCSHistoryNurseData(new JsonObject()));
		assertEquals(1, cSServiceImpl.UpdateCSHistoryNurseData(null));
	}

	@Test
	void testUpdateCSHistoryNurseData2() throws Exception {
		// Arrange
		JsonObject jsnOBJ = new JsonObject();
		jsnOBJ.add("familyHistory", new JsonArray(3));

		// Act and Assert
		assertEquals(1, cSServiceImpl.UpdateCSHistoryNurseData(jsnOBJ));
	}

	@Test
	void testUpdateCSHistoryNurseData3() throws Exception {
		// Arrange
		JsonObject jsnOBJ = new JsonObject();
		jsnOBJ.add("yyyy-MM-dd'T'HH:mm:ss.SSS", new JsonArray(3));
		jsnOBJ.add("familyHistory", new JsonArray(3));

		// Act and Assert
		assertEquals(1, cSServiceImpl.UpdateCSHistoryNurseData(jsnOBJ));
	}

	@Test
	void testUpdateCSHistoryNurseData4() throws Exception {
		// Arrange
		JsonObject jsnOBJ = new JsonObject();
		jsnOBJ.add("familyHistory", null);

		// Act and Assert
		assertEquals(1, cSServiceImpl.UpdateCSHistoryNurseData(jsnOBJ));
	}

	@Test
	void testUpdateBenExaminationDetail() throws Exception {
		// Arrange, Act and Assert
		assertEquals(1, cSServiceImpl.updateBenExaminationDetail(new JsonObject()));
		assertEquals(1, cSServiceImpl.updateBenExaminationDetail(null));
	}

	@Test
	void testUpdateBenVitalDetail() {
		// Arrange
		when(cSNurseServiceImpl.updateBenVitalDetail(Mockito.<BenCancerVitalDetail>any())).thenReturn(1);

		BenCancerVitalDetail benCancerVitalDetail = new BenCancerVitalDetail();
		benCancerVitalDetail.setBenVisitID(1L);
		benCancerVitalDetail.setBeneficiaryRegID(1L);
		benCancerVitalDetail.setBloodGlucose_2HrPostPrandial((short) 1);
		benCancerVitalDetail.setBloodGlucose_Fasting((short) 1);
		benCancerVitalDetail.setBloodGlucose_Random((short) 1);
		benCancerVitalDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benCancerVitalDetail.setCreatedDate(mock(Timestamp.class));
		benCancerVitalDetail.setDeleted(true);
		benCancerVitalDetail.setDiastolicBP_1stReading((short) 1);
		benCancerVitalDetail.setDiastolicBP_2ndReading((short) 1);
		benCancerVitalDetail.setDiastolicBP_3rdReading((short) 1);
		benCancerVitalDetail.setHbA1C((short) 1);
		benCancerVitalDetail.setHeight_cm(10.0d);
		benCancerVitalDetail.setHemoglobin(10.0d);
		benCancerVitalDetail.setID(1L);
		benCancerVitalDetail.setLastModDate(mock(Timestamp.class));
		benCancerVitalDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benCancerVitalDetail.setParkingPlaceID(1);
		benCancerVitalDetail.setProcessed("Processed");
		benCancerVitalDetail.setProviderServiceMapID(1);
		benCancerVitalDetail.setRbsTestRemarks("Rbs Test Remarks");
		benCancerVitalDetail.setRbsTestResult("Rbs Test Result");
		benCancerVitalDetail.setReservedForChange("Reserved For Change");
		benCancerVitalDetail.setSyncedBy("Synced By");
		benCancerVitalDetail.setSyncedDate(mock(Timestamp.class));
		benCancerVitalDetail.setSystolicBP_1stReading((short) 1);
		benCancerVitalDetail.setSystolicBP_2ndReading((short) 1);
		benCancerVitalDetail.setSystolicBP_3rdReading((short) 1);
		benCancerVitalDetail.setVanID(1);
		benCancerVitalDetail.setVanSerialNo(1L);
		benCancerVitalDetail.setVehicalNo("Vehical No");
		benCancerVitalDetail.setVisitCode(1L);
		benCancerVitalDetail.setWaistCircumference_cm(10.0d);
		benCancerVitalDetail.setWeight_Kg(10.0d);
		benCancerVitalDetail.setsPO2("S PO2");

		// Act
		int actualUpdateBenVitalDetailResult = cSServiceImpl.updateBenVitalDetail(benCancerVitalDetail);

		// Assert
		verify(cSNurseServiceImpl).updateBenVitalDetail(Mockito.<BenCancerVitalDetail>any());
		assertEquals(1, actualUpdateBenVitalDetailResult);
	}

	@Test
	void testUpdateBenVitalDetail2() {
		// Arrange
		when(cSNurseServiceImpl.updateBenVitalDetail(Mockito.<BenCancerVitalDetail>any()))
				.thenThrow(new RuntimeException("foo"));

		BenCancerVitalDetail benCancerVitalDetail = new BenCancerVitalDetail();
		benCancerVitalDetail.setBenVisitID(1L);
		benCancerVitalDetail.setBeneficiaryRegID(1L);
		benCancerVitalDetail.setBloodGlucose_2HrPostPrandial((short) 1);
		benCancerVitalDetail.setBloodGlucose_Fasting((short) 1);
		benCancerVitalDetail.setBloodGlucose_Random((short) 1);
		benCancerVitalDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benCancerVitalDetail.setCreatedDate(mock(Timestamp.class));
		benCancerVitalDetail.setDeleted(true);
		benCancerVitalDetail.setDiastolicBP_1stReading((short) 1);
		benCancerVitalDetail.setDiastolicBP_2ndReading((short) 1);
		benCancerVitalDetail.setDiastolicBP_3rdReading((short) 1);
		benCancerVitalDetail.setHbA1C((short) 1);
		benCancerVitalDetail.setHeight_cm(10.0d);
		benCancerVitalDetail.setHemoglobin(10.0d);
		benCancerVitalDetail.setID(1L);
		benCancerVitalDetail.setLastModDate(mock(Timestamp.class));
		benCancerVitalDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benCancerVitalDetail.setParkingPlaceID(1);
		benCancerVitalDetail.setProcessed("Processed");
		benCancerVitalDetail.setProviderServiceMapID(1);
		benCancerVitalDetail.setRbsTestRemarks("Rbs Test Remarks");
		benCancerVitalDetail.setRbsTestResult("Rbs Test Result");
		benCancerVitalDetail.setReservedForChange("Reserved For Change");
		benCancerVitalDetail.setSyncedBy("Synced By");
		benCancerVitalDetail.setSyncedDate(mock(Timestamp.class));
		benCancerVitalDetail.setSystolicBP_1stReading((short) 1);
		benCancerVitalDetail.setSystolicBP_2ndReading((short) 1);
		benCancerVitalDetail.setSystolicBP_3rdReading((short) 1);
		benCancerVitalDetail.setVanID(1);
		benCancerVitalDetail.setVanSerialNo(1L);
		benCancerVitalDetail.setVehicalNo("Vehical No");
		benCancerVitalDetail.setVisitCode(1L);
		benCancerVitalDetail.setWaistCircumference_cm(10.0d);
		benCancerVitalDetail.setWeight_Kg(10.0d);
		benCancerVitalDetail.setsPO2("S PO2");

		// Act and Assert
		assertThrows(RuntimeException.class, () -> cSServiceImpl.updateBenVitalDetail(benCancerVitalDetail));
		verify(cSNurseServiceImpl).updateBenVitalDetail(Mockito.<BenCancerVitalDetail>any());
	}

	@Test
	@Disabled("TODO: Complete this test")
	void testGetBenDataFrmNurseToDocVisitDetailsScreen() throws Exception {

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

		// Act
		cSServiceImpl.getBenDataFrmNurseToDocVisitDetailsScreen(1L, 1L);
	}

	@Test
	@Disabled("TODO: Complete this test")
	void testGetBenDataFrmNurseToDocHistoryScreen() {

		// Arrange
		BenObstetricCancerHistory benObstetricCancerHistory = new BenObstetricCancerHistory();
		benObstetricCancerHistory.setBenVisitID(1L);
		benObstetricCancerHistory.setBeneficiaryRegID(1L);
		benObstetricCancerHistory.setCaptureDate(mock(Date.class));
		benObstetricCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benObstetricCancerHistory.setCreatedDate(mock(Timestamp.class));
		benObstetricCancerHistory.setDeleted(true);
		benObstetricCancerHistory.setID(1L);
		benObstetricCancerHistory.setIsAbortion("Is Abortion");
		benObstetricCancerHistory.setIsDysmenorrhea("Is Dysmenorrhea");
		benObstetricCancerHistory.setIsFoulSmellingDischarge("Is Foul Smelling Discharge");
		benObstetricCancerHistory.setIsHormoneReplacementTherapy("Is Hormone Replacement Therapy");
		benObstetricCancerHistory.setIsInterMenstrualBleeding("Is Inter Menstrual Bleeding");
		benObstetricCancerHistory.setIsMenstrualCycleRegular("Is Menstrual Cycle Regular");
		benObstetricCancerHistory.setIsOralContraceptiveUsed("Is Oral Contraceptive Used");
		benObstetricCancerHistory.setIsPostMenopauseBleeding("Is Post Menopause Bleeding");
		benObstetricCancerHistory.setIsUrinePregTest("Is Urine Preg Test");
		benObstetricCancerHistory.setLastModDate(mock(Timestamp.class));
		benObstetricCancerHistory.setMenarche_Age(1);
		benObstetricCancerHistory.setMenopauseAge(1);
		benObstetricCancerHistory.setMenstrualCycleLength(3);
		benObstetricCancerHistory.setMenstrualFlowDuration(1);
		benObstetricCancerHistory.setMenstrualFlowType("Menstrual Flow Type");
		benObstetricCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benObstetricCancerHistory.setNoOfLivingChild(1);
		benObstetricCancerHistory.setParkingPlaceID(1);
		benObstetricCancerHistory.setPregnancyStatus("Pregnancy Status");
		benObstetricCancerHistory.setPregnant_No("Pregnant No");
		benObstetricCancerHistory.setProcessed("Processed");
		benObstetricCancerHistory.setProviderServiceMapID(1);
		benObstetricCancerHistory.setReservedForChange("Reserved For Change");
		benObstetricCancerHistory.setSyncedBy("Synced By");
		benObstetricCancerHistory.setSyncedDate(mock(Timestamp.class));
		benObstetricCancerHistory.setVanID(1);
		benObstetricCancerHistory.setVanSerialNo(1L);
		benObstetricCancerHistory.setVehicalNo("Vehical No");
		benObstetricCancerHistory.setVisitCode(1L);

		BenPersonalCancerDietHistory benPersonalCancerDietHistory = new BenPersonalCancerDietHistory();
		benPersonalCancerDietHistory.setBenVisitID(1L);
		benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
		benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
		benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
		benPersonalCancerDietHistory.setDeleted(true);
		benPersonalCancerDietHistory.setDietType("Diet Type");
		benPersonalCancerDietHistory.setFruitConsumptionDays(1);
		benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
		benPersonalCancerDietHistory.setID(1L);
		benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
		benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
		benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
		benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
		benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benPersonalCancerDietHistory.setParkingPlaceID(1);
		benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
		benPersonalCancerDietHistory.setProcessed("Processed");
		benPersonalCancerDietHistory.setProviderServiceMapID(1);
		benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
		benPersonalCancerDietHistory.setSsRadiationExposure(true);
		benPersonalCancerDietHistory.setSyncedBy("Synced By");
		benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
		benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
		benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
		benPersonalCancerDietHistory.setVanID(1);
		benPersonalCancerDietHistory.setVanSerialNo(1L);
		benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
		benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
		benPersonalCancerDietHistory.setVehicalNo("Vehical No");
		benPersonalCancerDietHistory.setVisitCode(1L);

		BenPersonalCancerHistory benPersonalCancerHistory = new BenPersonalCancerHistory();
		benPersonalCancerHistory.setAlcoholUse("Alcohol Use");
		benPersonalCancerHistory.setBenVisitID(1L);
		benPersonalCancerHistory.setBeneficiaryRegID(1L);
		benPersonalCancerHistory.setCaptureDate(mock(Date.class));
		benPersonalCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benPersonalCancerHistory.setCreatedDate(mock(Timestamp.class));
		benPersonalCancerHistory.setDeleted(true);
		benPersonalCancerHistory.setDurationOfBetelQuid(1);
		benPersonalCancerHistory.setEndAge_year(3);
		benPersonalCancerHistory.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
		benPersonalCancerHistory.setID(1L);
		benPersonalCancerHistory.setIsAlcoholUsed("Is Alcohol Used");
		benPersonalCancerHistory.setIsBetelNutChewing("Is Betel Nut Chewing");
		benPersonalCancerHistory.setIsCigaretteExposure("Is Cigarette Exposure");
		benPersonalCancerHistory.setIsFilteredCigaerette("Is Filtered Cigaerette");
		benPersonalCancerHistory.setLastModDate(mock(Timestamp.class));
		benPersonalCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benPersonalCancerHistory.setParkingPlaceID(1);
		benPersonalCancerHistory.setProcessed("Processed");
		benPersonalCancerHistory.setProviderServiceMapID(1);
		benPersonalCancerHistory.setQuantityPerDay(1);
		benPersonalCancerHistory.setReservedForChange("Reserved For Change");
		benPersonalCancerHistory.setSsAlcoholUsed(true);
		benPersonalCancerHistory.setStartAge_year(1);
		benPersonalCancerHistory.setSyncedBy("Synced By");
		benPersonalCancerHistory.setSyncedDate(mock(Timestamp.class));
		benPersonalCancerHistory.setTobaccoUse("Tobacco Use");
		benPersonalCancerHistory.setTypeOfTobaccoProduct("Type Of Tobacco Product");
		benPersonalCancerHistory.setTypeOfTobaccoProductList(new ArrayList<>());
		benPersonalCancerHistory.setVanID(1);
		benPersonalCancerHistory.setVanSerialNo(1L);
		benPersonalCancerHistory.setVehicalNo("Vehical No");
		benPersonalCancerHistory.setVisitCode(1L);
		when(cSNurseServiceImpl.getBenObstetricDetailsData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benObstetricCancerHistory);
		when(cSNurseServiceImpl.getBenPersonalCancerDietHistoryData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benPersonalCancerDietHistory);
		when(cSNurseServiceImpl.getBenPersonalCancerHistoryData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benPersonalCancerHistory);
		when(cSNurseServiceImpl.getBenFamilyHisData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());

		// Act
		cSServiceImpl.getBenDataFrmNurseToDocHistoryScreen(1L, 1L);
	}

	@Test
	@Disabled("TODO: Complete this test")
	void testGetBenDataFrmNurseToDocVitalScreen() {

		// Arrange
		when(commonNurseServiceImpl.getGraphicalTrendData(Mockito.<Long>any(), Mockito.<String>any()))
				.thenReturn(new HashMap<>());

		BenCancerVitalDetail benCancerVitalDetail = new BenCancerVitalDetail();
		benCancerVitalDetail.setBenVisitID(1L);
		benCancerVitalDetail.setBeneficiaryRegID(1L);
		benCancerVitalDetail.setBloodGlucose_2HrPostPrandial((short) 1);
		benCancerVitalDetail.setBloodGlucose_Fasting((short) 1);
		benCancerVitalDetail.setBloodGlucose_Random((short) 1);
		benCancerVitalDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benCancerVitalDetail.setCreatedDate(mock(Timestamp.class));
		benCancerVitalDetail.setDeleted(true);
		benCancerVitalDetail.setDiastolicBP_1stReading((short) 1);
		benCancerVitalDetail.setDiastolicBP_2ndReading((short) 1);
		benCancerVitalDetail.setDiastolicBP_3rdReading((short) 1);
		benCancerVitalDetail.setHbA1C((short) 1);
		benCancerVitalDetail.setHeight_cm(10.0d);
		benCancerVitalDetail.setHemoglobin(10.0d);
		benCancerVitalDetail.setID(1L);
		benCancerVitalDetail.setLastModDate(mock(Timestamp.class));
		benCancerVitalDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benCancerVitalDetail.setParkingPlaceID(1);
		benCancerVitalDetail.setProcessed("Processed");
		benCancerVitalDetail.setProviderServiceMapID(1);
		benCancerVitalDetail.setRbsTestRemarks("Rbs Test Remarks");
		benCancerVitalDetail.setRbsTestResult("Rbs Test Result");
		benCancerVitalDetail.setReservedForChange("Reserved For Change");
		benCancerVitalDetail.setSyncedBy("Synced By");
		benCancerVitalDetail.setSyncedDate(mock(Timestamp.class));
		benCancerVitalDetail.setSystolicBP_1stReading((short) 1);
		benCancerVitalDetail.setSystolicBP_2ndReading((short) 1);
		benCancerVitalDetail.setSystolicBP_3rdReading((short) 1);
		benCancerVitalDetail.setVanID(1);
		benCancerVitalDetail.setVanSerialNo(1L);
		benCancerVitalDetail.setVehicalNo("Vehical No");
		benCancerVitalDetail.setVisitCode(1L);
		benCancerVitalDetail.setWaistCircumference_cm(10.0d);
		benCancerVitalDetail.setWeight_Kg(10.0d);
		benCancerVitalDetail.setsPO2("S PO2");
		when(cSNurseServiceImpl.getBenCancerVitalDetailData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benCancerVitalDetail);

		// Act
		cSServiceImpl.getBenDataFrmNurseToDocVitalScreen(1L, 1L);
	}

	@Test
	@Disabled("TODO: Complete this test")
	void testGetBenDataFrmNurseToDocExaminationScreen() {

		// Arrange
		CancerAbdominalExamination cancerAbdominalExamination = new CancerAbdominalExamination();
		cancerAbdominalExamination.setAbdominalInspection_Normal(true);
		cancerAbdominalExamination.setAnyOtherMass_Present(true);
		cancerAbdominalExamination.setAscites_Present(true);
		cancerAbdominalExamination.setBenVisitID(1L);
		cancerAbdominalExamination.setBeneficiaryRegID(1L);
		cancerAbdominalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		cancerAbdominalExamination.setCreatedDate(mock(Timestamp.class));
		cancerAbdominalExamination.setDeleted(true);
		cancerAbdominalExamination.setID(1L);
		cancerAbdominalExamination.setLastModDate(mock(Timestamp.class));
		cancerAbdominalExamination.setLiver("Liver");
		cancerAbdominalExamination.setLymphNode_ExternalIliac_Left(true);
		cancerAbdominalExamination.setLymphNode_ExternalIliac_Right(true);
		cancerAbdominalExamination.setLymphNode_Inguinal_Left(true);
		cancerAbdominalExamination.setLymphNode_Inguinal_Right(true);
		cancerAbdominalExamination.setLymphNode_ParaAortic_Left(true);
		cancerAbdominalExamination.setLymphNode_ParaAortic_Right(true);
		cancerAbdominalExamination.setLymphNodes_Enlarged(true);
		cancerAbdominalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		cancerAbdominalExamination.setObservation("Observation");
		cancerAbdominalExamination.setParkingPlaceID(1);
		cancerAbdominalExamination.setProcessed("Processed");
		cancerAbdominalExamination.setProviderServiceMapID(1);
		cancerAbdominalExamination.setReservedForChange("Reserved For Change");
		cancerAbdominalExamination.setSyncedBy("Synced By");
		cancerAbdominalExamination.setSyncedDate(mock(Timestamp.class));
		cancerAbdominalExamination.setVanID(1);
		cancerAbdominalExamination.setVanSerialNo(1L);
		cancerAbdominalExamination.setVehicalNo("Vehical No");
		cancerAbdominalExamination.setVisitCode(1L);

		CancerBreastExamination cancerBreastExamination = new CancerBreastExamination();
		cancerBreastExamination.setBenVisitID(1L);
		cancerBreastExamination.setBeneficiaryRegID(1L);
		cancerBreastExamination.setBreastFeedingDurationGTE6months(true);
		cancerBreastExamination.setBreastsAppear_Normal(true);
		cancerBreastExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		cancerBreastExamination.setCreatedDate(mock(Timestamp.class));
		cancerBreastExamination.setDeleted(true);
		cancerBreastExamination.setDimplingSkinOnBreast(true);
		cancerBreastExamination.setDischargeFromNipple(true);
		cancerBreastExamination.setEverBreastFed(true);
		cancerBreastExamination.setID(1L);
		cancerBreastExamination.setLastModDate(mock(Timestamp.class));
		cancerBreastExamination.setLumpInBreast(true);
		cancerBreastExamination.setLumpShape("Lump Shape");
		cancerBreastExamination.setLumpSize("Lump Size");
		cancerBreastExamination.setLumpTexture("Lump Texture");
		cancerBreastExamination.setMamogramReport("Mamogram Report");
		cancerBreastExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		cancerBreastExamination.setParkingPlaceID(1);
		cancerBreastExamination.setPeaudOrange(true);
		cancerBreastExamination.setProcessed("Processed");
		cancerBreastExamination.setProviderServiceMapID(1);
		cancerBreastExamination.setRashOnBreast(true);
		cancerBreastExamination.setReferredToMammogram(true);
		cancerBreastExamination.setReservedForChange("Reserved For Change");
		cancerBreastExamination.setSyncedBy("Synced By");
		cancerBreastExamination.setSyncedDate(mock(Timestamp.class));
		cancerBreastExamination.setVanID(1);
		cancerBreastExamination.setVanSerialNo(1L);
		cancerBreastExamination.setVehicalNo("Vehical No");
		cancerBreastExamination.setVisitCode(1L);

		CancerGynecologicalExamination cancerGynecologicalExamination = new CancerGynecologicalExamination();
		cancerGynecologicalExamination.setAppearanceOfCervix("Appearance Of Cervix");
		cancerGynecologicalExamination.setBenVisitID(1L);
		cancerGynecologicalExamination.setBeneficiaryRegID(1L);
		cancerGynecologicalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		cancerGynecologicalExamination.setCreatedDate(mock(Timestamp.class));
		cancerGynecologicalExamination.setDeleted(true);
		cancerGynecologicalExamination.setExperiencedPostCoitalBleeding(true);
		cancerGynecologicalExamination.setFilePath("/directory/foo.txt");
		cancerGynecologicalExamination.setID(1L);
		cancerGynecologicalExamination.setLastModDate(mock(Timestamp.class));
		cancerGynecologicalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		cancerGynecologicalExamination.setObservation("Observation");
		cancerGynecologicalExamination.setParkingPlaceID(1);
		cancerGynecologicalExamination.setProcessed("Processed");
		cancerGynecologicalExamination.setProviderServiceMapID(1);
		cancerGynecologicalExamination.setReservedForChange("Reserved For Change");
		cancerGynecologicalExamination.setSufferedFromRTIOrSTI(true);
		cancerGynecologicalExamination.setSyncedBy("Synced By");
		cancerGynecologicalExamination.setSyncedDate(mock(Timestamp.class));
		cancerGynecologicalExamination.setTypeOfLesion("Type Of Lesion");
		cancerGynecologicalExamination.setTypeOfLesionList(new ArrayList<>());
		cancerGynecologicalExamination.setUterus_Normal(true);
		cancerGynecologicalExamination.setVaginalInvolvement(true);
		cancerGynecologicalExamination.setVanID(1);
		cancerGynecologicalExamination.setVanSerialNo(1L);
		cancerGynecologicalExamination.setVehicalNo("Vehical No");
		cancerGynecologicalExamination.setVisitCode(1L);
		cancerGynecologicalExamination.setVulvalInvolvement(true);
		cancerGynecologicalExamination.setrTIOrSTIDetail("R TIOr STIDetail");

		CancerOralExamination cancerOralExamination = new CancerOralExamination();
		cancerOralExamination.setBenVisitID(1L);
		cancerOralExamination.setBeneficiaryRegID(1L);
		cancerOralExamination.setChronicBurningSensation(true);
		cancerOralExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		cancerOralExamination.setCreatedDate(mock(Timestamp.class));
		cancerOralExamination.setDeleted(true);
		cancerOralExamination.setID(1L);
		cancerOralExamination.setLastModDate(mock(Timestamp.class));
		cancerOralExamination.setLimitedMouthOpening("Limited Mouth Opening");
		cancerOralExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		cancerOralExamination.setObservation("Observation");
		cancerOralExamination.setParkingPlaceID(1);
		cancerOralExamination.setPreMalignantLesionType("Pre Malignant Lesion Type");
		cancerOralExamination.setPreMalignantLesionTypeList(new ArrayList<>());
		cancerOralExamination.setPremalignantLesions(true);
		cancerOralExamination.setProcessed("Processed");
		cancerOralExamination.setProlongedIrritation(true);
		cancerOralExamination.setProviderServiceMapID(1);
		cancerOralExamination.setReservedForChange("Reserved For Change");
		cancerOralExamination.setSyncedBy("Synced By");
		cancerOralExamination.setSyncedDate(mock(Timestamp.class));
		cancerOralExamination.setVanID(1);
		cancerOralExamination.setVanSerialNo(1L);
		cancerOralExamination.setVehicalNo("Vehical No");
		cancerOralExamination.setVisitCode(1L);

		CancerSignAndSymptoms cancerSignAndSymptoms = new CancerSignAndSymptoms();
		cancerSignAndSymptoms.setBenVisitID(1L);
		cancerSignAndSymptoms.setBeneficiaryRegID(1L);
		cancerSignAndSymptoms.setBloodInSputum(true);
		cancerSignAndSymptoms.setBloodStainedDischargeFromNipple(true);
		cancerSignAndSymptoms.setBreastEnlargement(true);
		cancerSignAndSymptoms.setBriefHistory("Observation");
		cancerSignAndSymptoms.setChangeInShapeAndSizeOfBreasts(true);
		cancerSignAndSymptoms.setChangeInTheToneOfVoice(true);
		cancerSignAndSymptoms.setCoughGTE2Weeks(true);
		cancerSignAndSymptoms.setCoughgt2Weeks(true);
		cancerSignAndSymptoms.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		cancerSignAndSymptoms.setCreatedDate(mock(Timestamp.class));
		cancerSignAndSymptoms.setDeleted(true);
		cancerSignAndSymptoms.setDifficultyInOpeningMouth(true);
		cancerSignAndSymptoms.setFoulSmellingVaginalDischarge(true);
		cancerSignAndSymptoms.setID(1L);
		cancerSignAndSymptoms.setLastModDate(mock(Timestamp.class));
		cancerSignAndSymptoms.setLumpInTheBreast(true);
		cancerSignAndSymptoms.setLymphNode_Enlarged(true);
		cancerSignAndSymptoms.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		cancerSignAndSymptoms.setNonHealingUlcerOrPatchOrGrowth(true);
		cancerSignAndSymptoms.setObservation("Observation");
		cancerSignAndSymptoms.setParkingPlaceID(1);
		cancerSignAndSymptoms.setProcessed("Processed");
		cancerSignAndSymptoms.setProviderServiceMapID(1);
		cancerSignAndSymptoms.setReservedForChange("Reserved For Change");
		cancerSignAndSymptoms.setShortnessOfBreath(true);
		cancerSignAndSymptoms.setSyncedBy("Synced By");
		cancerSignAndSymptoms.setSyncedDate(mock(Timestamp.class));
		cancerSignAndSymptoms.setVaginalBleedingAfterIntercourse(true);
		cancerSignAndSymptoms.setVaginalBleedingAfterMenopause(true);
		cancerSignAndSymptoms.setVaginalBleedingBetweenPeriods(true);
		cancerSignAndSymptoms.setVanID(1);
		cancerSignAndSymptoms.setVanSerialNo(1L);
		cancerSignAndSymptoms.setVehicalNo("Vehical No");
		cancerSignAndSymptoms.setVisitCode(1L);
		when(cSNurseServiceImpl.getBenCancerAbdominalExaminationData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(cancerAbdominalExamination);
		when(cSNurseServiceImpl.getBenCancerBreastExaminationData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(cancerBreastExamination);
		when(cSNurseServiceImpl.getBenCancerGynecologicalExaminationData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(cancerGynecologicalExamination);
		when(cSNurseServiceImpl.getBenCancerOralExaminationData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(cancerOralExamination);
		when(cSNurseServiceImpl.getBenCancerSignAndSymptomsData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(cancerSignAndSymptoms);
		when(cSNurseServiceImpl.getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSNurseServiceImpl.getBenCancerLymphNodeDetailsData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());

		// Act
		cSServiceImpl.getBenDataFrmNurseToDocExaminationScreen(1L, 1L);
	}

	@Test
	void testSaveCancerScreeningDoctorData() throws Exception {
		// Arrange, Act and Assert
		assertNull(cSServiceImpl.saveCancerScreeningDoctorData(new JsonObject(), "JaneDoe"));
		assertNull(cSServiceImpl.saveCancerScreeningDoctorData(null, "JaneDoe"));
	}

	@Test
	void testSaveCancerScreeningDoctorData2() throws Exception {
		// Arrange
		JsonObject requestOBJ = new JsonObject();
		requestOBJ.add("Property", new JsonArray(3));

		// Act and Assert
		assertNull(cSServiceImpl.saveCancerScreeningDoctorData(requestOBJ, "JaneDoe"));
	}

	@Test
	void testSaveCancerScreeningDoctorData3() throws Exception {
		// Arrange
		JsonObject requestOBJ = new JsonObject();
		requestOBJ.addProperty("diagnosis", (String) null);

		// Act and Assert
		assertNull(cSServiceImpl.saveCancerScreeningDoctorData(requestOBJ, "JaneDoe"));
	}

	@Test
	void testSaveBenExaminationDetails() throws Exception {
		// Arrange, Act and Assert
		assertEquals(1L, cSServiceImpl.saveBenExaminationDetails(new JsonObject(), 1L, "JaneDoe", 1L, 1L).longValue());
		assertEquals(1L, cSServiceImpl.saveBenExaminationDetails(null, 1L, "JaneDoe", 1L, 1L).longValue());
	}

	@Test
	void testSaveBenDiagnosisDetails() throws Exception {
		// Arrange, Act and Assert
		assertEquals(1L, cSServiceImpl.saveBenDiagnosisDetails(new JsonObject()).longValue());
		assertEquals(1L, cSServiceImpl.saveBenDiagnosisDetails(null).longValue());
	}

	@Test
	void testSaveBenDiagnosisDetails2() throws Exception {
		// Arrange
		JsonObject requestOBJ = new JsonObject();
		requestOBJ.add("Property", new JsonArray(3));

		// Act and Assert
		assertEquals(1L, cSServiceImpl.saveBenDiagnosisDetails(requestOBJ).longValue());
	}

	@Test
	void testSaveBenDiagnosisDetails3() throws Exception {
		// Arrange
		JsonObject requestOBJ = new JsonObject();
		requestOBJ.addProperty("diagnosis", (String) null);

		// Act and Assert
		assertEquals(1L, cSServiceImpl.saveBenDiagnosisDetails(requestOBJ).longValue());
	}

	@Test
	void testSaveBenDiagnosisDetails4() throws Exception {
		// Arrange
		when(cSDoctorServiceImpl.saveCancerDiagnosisData(Mockito.<CancerDiagnosis>any())).thenReturn(1L);

		JsonObject requestOBJ = new JsonObject();
		requestOBJ.add("diagnosis", new JsonObject());

		// Act
		Long actualSaveBenDiagnosisDetailsResult = cSServiceImpl.saveBenDiagnosisDetails(requestOBJ);

		// Assert
		verify(cSDoctorServiceImpl).saveCancerDiagnosisData(Mockito.<CancerDiagnosis>any());
		assertEquals(1L, actualSaveBenDiagnosisDetailsResult.longValue());
	}

	@Test
	void testSaveBenDiagnosisDetails5() throws Exception {
		// Arrange
		when(cSDoctorServiceImpl.saveCancerDiagnosisData(Mockito.<CancerDiagnosis>any())).thenReturn(0L);

		JsonObject requestOBJ = new JsonObject();
		requestOBJ.add("diagnosis", new JsonObject());

		// Act
		Long actualSaveBenDiagnosisDetailsResult = cSServiceImpl.saveBenDiagnosisDetails(requestOBJ);

		// Assert
		verify(cSDoctorServiceImpl).saveCancerDiagnosisData(Mockito.<CancerDiagnosis>any());
		assertNull(actualSaveBenDiagnosisDetailsResult);
	}

	@Test
	void testGetCancerCasesheetData() throws Exception {
		// Arrange, Act and Assert
		assertNull(cSServiceImpl.getCancerCasesheetData(new JSONObject(), "JaneDoe"));
	}

	@Test
	void testGetCancerCasesheetData2() throws Exception {
		// Arrange
		when(beneficiaryFlowStatusRepo.getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSDoctorServiceImpl.getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());
		when(cSNurseServiceImpl.getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSNurseServiceImpl.getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());

		// Act
		String actualCancerCasesheetData = cSServiceImpl
				.getCancerCasesheetData(HTTP.toJSONObject("https://example.org/example"), "JaneDoe");

		// Assert
		verify(beneficiaryFlowStatusRepo).getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSDoctorServiceImpl).getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(),
				Mockito.<Long>any());
		assertEquals("{\"ImageAnnotatedData\":[]}", actualCancerCasesheetData);
	}

	@Test
	void testGetCancerCasesheetData3() throws Exception {
		// Arrange
		when(cSNurseServiceImpl.getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenThrow(new RuntimeException("benRegID"));

		// Act and Assert
		assertThrows(RuntimeException.class, () -> cSServiceImpl
				.getCancerCasesheetData(HTTP.toJSONObject("https://example.org/example"), "JaneDoe"));
		verify(cSNurseServiceImpl).getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
	}

	@Test
	void testGetCancerCasesheetData4() throws Exception {
		// Arrange
		when(beneficiaryFlowStatusRepo.getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());

		HashMap<String, Object> stringObjectMap = new HashMap<>();
		stringObjectMap.put("benRegID", "42");
		when(cSDoctorServiceImpl.getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(stringObjectMap);
		when(cSNurseServiceImpl.getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSNurseServiceImpl.getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());

		// Act
		String actualCancerCasesheetData = cSServiceImpl
				.getCancerCasesheetData(HTTP.toJSONObject("https://example.org/example"), "JaneDoe");

		// Assert
		verify(beneficiaryFlowStatusRepo).getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSDoctorServiceImpl).getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(),
				Mockito.<Long>any());
		assertEquals("{\"benRegID\":\"42\",\"ImageAnnotatedData\":[]}", actualCancerCasesheetData);
	}

	@Test
	void testGetCancerCasesheetData5() throws Exception {
		// Arrange
		when(beneficiaryFlowStatusRepo.getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSDoctorServiceImpl.getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());

		ArrayList<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = new ArrayList<>();
		wrapperCancerExamImgAnotasnList.add(new WrapperCancerExamImgAnotasn());
		when(cSNurseServiceImpl.getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(wrapperCancerExamImgAnotasnList);
		when(cSNurseServiceImpl.getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());

		// Act
		String actualCancerCasesheetData = cSServiceImpl
				.getCancerCasesheetData(HTTP.toJSONObject("https://example.org/example"), "JaneDoe");

		// Assert
		verify(beneficiaryFlowStatusRepo).getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSDoctorServiceImpl).getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(),
				Mockito.<Long>any());
		assertEquals("{\"ImageAnnotatedData\":[{}]}", actualCancerCasesheetData);
	}

	@Test
	void testGetCancerCasesheetData6() throws Exception {
		// Arrange
		when(beneficiaryFlowStatusRepo.getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSDoctorServiceImpl.getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());

		ArrayList<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = new ArrayList<>();
		wrapperCancerExamImgAnotasnList.add(new WrapperCancerExamImgAnotasn());
		wrapperCancerExamImgAnotasnList.add(new WrapperCancerExamImgAnotasn());
		when(cSNurseServiceImpl.getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(wrapperCancerExamImgAnotasnList);
		when(cSNurseServiceImpl.getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());

		// Act
		String actualCancerCasesheetData = cSServiceImpl
				.getCancerCasesheetData(HTTP.toJSONObject("https://example.org/example"), "JaneDoe");

		// Assert
		verify(beneficiaryFlowStatusRepo).getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSDoctorServiceImpl).getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(),
				Mockito.<Long>any());
		assertEquals("{\"ImageAnnotatedData\":[{},{}]}", actualCancerCasesheetData);
	}

	@Test
	void testGetCancerCasesheetData7() throws Exception {
		// Arrange
		when(beneficiaryFlowStatusRepo.getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSDoctorServiceImpl.getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());
		when(cSNurseServiceImpl.getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSNurseServiceImpl.getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());
		JSONObject obj = mock(JSONObject.class);
		when(obj.getLong(Mockito.<String>any())).thenReturn(1L);
		when(obj.length()).thenReturn(3);

		// Act
		String actualCancerCasesheetData = cSServiceImpl.getCancerCasesheetData(obj, "JaneDoe");

		// Assert
		verify(beneficiaryFlowStatusRepo).getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSDoctorServiceImpl).getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(),
				Mockito.<Long>any());
		verify(obj, atLeast(1)).getLong(Mockito.<String>any());
		verify(obj).length();
		assertEquals("{\"ImageAnnotatedData\":[]}", actualCancerCasesheetData);
	}

	@Test
	void testGetCancerCasesheetData8() throws Exception {
		// Arrange
		JSONObject obj = mock(JSONObject.class);
		when(obj.getLong(Mockito.<String>any())).thenThrow(new RuntimeException("benRegID"));
		when(obj.length()).thenReturn(3);

		// Act and Assert
		assertThrows(RuntimeException.class, () -> cSServiceImpl.getCancerCasesheetData(obj, "JaneDoe"));
		verify(obj).getLong(eq("benRegID"));
		verify(obj).length();
	}

	@Test
	void testGetCancerCasesheetData9() throws Exception {
		// Arrange
		when(beneficiaryFlowStatusRepo.getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSDoctorServiceImpl.getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());
		when(cSNurseServiceImpl.getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSNurseServiceImpl.getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());
		JSONObject obj = mock(JSONObject.class);
		when(obj.getLong(Mockito.<String>any())).thenThrow(new JSONException("benRegID"));
		when(obj.length()).thenReturn(3);

		// Act
		String actualCancerCasesheetData = cSServiceImpl.getCancerCasesheetData(obj, "JaneDoe");

		// Assert
		verify(beneficiaryFlowStatusRepo).getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSDoctorServiceImpl).getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(),
				Mockito.<Long>any());
		verify(obj).getLong(eq("benRegID"));
		verify(obj).length();
		assertEquals("{\"ImageAnnotatedData\":[]}", actualCancerCasesheetData);
	}

	@Test
	void testGetBenDataForCaseSheet() throws Exception {
		// Arrange
		when(beneficiaryFlowStatusRepo.getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSDoctorServiceImpl.getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());
		when(cSNurseServiceImpl.getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSNurseServiceImpl.getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());

		// Act
		String actualBenDataForCaseSheet = cSServiceImpl.getBenDataForCaseSheet(1L, 1L, 1L, "JaneDoe");

		// Assert
		verify(beneficiaryFlowStatusRepo).getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSDoctorServiceImpl).getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(),
				Mockito.<Long>any());
		assertEquals("{\"ImageAnnotatedData\":[]}", actualBenDataForCaseSheet);
	}

	/**
	 * Method under test:
	 * {@link CSServiceImpl#getBenDataForCaseSheet(Long, Long, Long, String)}
	 */
	@Test
	void testGetBenDataForCaseSheet2() throws Exception {
		// Arrange
		when(cSNurseServiceImpl.getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenThrow(new RuntimeException("BeneficiaryData"));

		// Act and Assert
		assertThrows(RuntimeException.class, () -> cSServiceImpl.getBenDataForCaseSheet(1L, 1L, 1L, "JaneDoe"));
		verify(cSNurseServiceImpl).getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
	}

	@Test
	void testGetBenDataForCaseSheet3() throws Exception {
		// Arrange
		when(beneficiaryFlowStatusRepo.getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSDoctorServiceImpl.getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());

		ArrayList<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = new ArrayList<>();
		wrapperCancerExamImgAnotasnList.add(new WrapperCancerExamImgAnotasn());
		when(cSNurseServiceImpl.getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(wrapperCancerExamImgAnotasnList);
		when(cSNurseServiceImpl.getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());

		// Act
		String actualBenDataForCaseSheet = cSServiceImpl.getBenDataForCaseSheet(1L, 1L, 1L, "JaneDoe");

		// Assert
		verify(beneficiaryFlowStatusRepo).getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSDoctorServiceImpl).getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(),
				Mockito.<Long>any());
		assertEquals("{\"ImageAnnotatedData\":[{}]}", actualBenDataForCaseSheet);
	}

	@Test
	void testGetBenDataForCaseSheet4() throws Exception {
		// Arrange
		when(beneficiaryFlowStatusRepo.getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSDoctorServiceImpl.getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());

		ArrayList<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = new ArrayList<>();
		wrapperCancerExamImgAnotasnList.add(new WrapperCancerExamImgAnotasn());
		wrapperCancerExamImgAnotasnList.add(new WrapperCancerExamImgAnotasn());
		when(cSNurseServiceImpl.getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(wrapperCancerExamImgAnotasnList);
		when(cSNurseServiceImpl.getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new HashMap<>());

		// Act
		String actualBenDataForCaseSheet = cSServiceImpl.getBenDataForCaseSheet(1L, 1L, 1L, "JaneDoe");

		// Assert
		verify(beneficiaryFlowStatusRepo).getBenDetailsForLeftSidePanel(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSDoctorServiceImpl).getBenDoctorEnteredDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getBenNurseDataForCaseSheet(Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSNurseServiceImpl).getCancerExaminationImageAnnotationCasesheet(Mockito.<Long>any(),
				Mockito.<Long>any());
		assertEquals("{\"ImageAnnotatedData\":[{},{}]}", actualBenDataForCaseSheet);
	}

	@Test
	@Disabled("TODO: Complete this test")
	void testGetBenNurseDataForCaseSheet() {

		// Arrange
		CancerAbdominalExamination cancerAbdominalExamination = new CancerAbdominalExamination();
		cancerAbdominalExamination.setAbdominalInspection_Normal(true);
		cancerAbdominalExamination.setAnyOtherMass_Present(true);
		cancerAbdominalExamination.setAscites_Present(true);
		cancerAbdominalExamination.setBenVisitID(1L);
		cancerAbdominalExamination.setBeneficiaryRegID(1L);
		cancerAbdominalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		cancerAbdominalExamination.setCreatedDate(mock(Timestamp.class));
		cancerAbdominalExamination.setDeleted(true);
		cancerAbdominalExamination.setID(1L);
		cancerAbdominalExamination.setLastModDate(mock(Timestamp.class));
		cancerAbdominalExamination.setLiver("Liver");
		cancerAbdominalExamination.setLymphNode_ExternalIliac_Left(true);
		cancerAbdominalExamination.setLymphNode_ExternalIliac_Right(true);
		cancerAbdominalExamination.setLymphNode_Inguinal_Left(true);
		cancerAbdominalExamination.setLymphNode_Inguinal_Right(true);
		cancerAbdominalExamination.setLymphNode_ParaAortic_Left(true);
		cancerAbdominalExamination.setLymphNode_ParaAortic_Right(true);
		cancerAbdominalExamination.setLymphNodes_Enlarged(true);
		cancerAbdominalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		cancerAbdominalExamination.setObservation("Observation");
		cancerAbdominalExamination.setParkingPlaceID(1);
		cancerAbdominalExamination.setProcessed("Processed");
		cancerAbdominalExamination.setProviderServiceMapID(1);
		cancerAbdominalExamination.setReservedForChange("Reserved For Change");
		cancerAbdominalExamination.setSyncedBy("Synced By");
		cancerAbdominalExamination.setSyncedDate(mock(Timestamp.class));
		cancerAbdominalExamination.setVanID(1);
		cancerAbdominalExamination.setVanSerialNo(1L);
		cancerAbdominalExamination.setVehicalNo("Vehical No");
		cancerAbdominalExamination.setVisitCode(1L);

		CancerBreastExamination cancerBreastExamination = new CancerBreastExamination();
		cancerBreastExamination.setBenVisitID(1L);
		cancerBreastExamination.setBeneficiaryRegID(1L);
		cancerBreastExamination.setBreastFeedingDurationGTE6months(true);
		cancerBreastExamination.setBreastsAppear_Normal(true);
		cancerBreastExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		cancerBreastExamination.setCreatedDate(mock(Timestamp.class));
		cancerBreastExamination.setDeleted(true);
		cancerBreastExamination.setDimplingSkinOnBreast(true);
		cancerBreastExamination.setDischargeFromNipple(true);
		cancerBreastExamination.setEverBreastFed(true);
		cancerBreastExamination.setID(1L);
		cancerBreastExamination.setLastModDate(mock(Timestamp.class));
		cancerBreastExamination.setLumpInBreast(true);
		cancerBreastExamination.setLumpShape("Lump Shape");
		cancerBreastExamination.setLumpSize("Lump Size");
		cancerBreastExamination.setLumpTexture("Lump Texture");
		cancerBreastExamination.setMamogramReport("Mamogram Report");
		cancerBreastExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		cancerBreastExamination.setParkingPlaceID(1);
		cancerBreastExamination.setPeaudOrange(true);
		cancerBreastExamination.setProcessed("Processed");
		cancerBreastExamination.setProviderServiceMapID(1);
		cancerBreastExamination.setRashOnBreast(true);
		cancerBreastExamination.setReferredToMammogram(true);
		cancerBreastExamination.setReservedForChange("Reserved For Change");
		cancerBreastExamination.setSyncedBy("Synced By");
		cancerBreastExamination.setSyncedDate(mock(Timestamp.class));
		cancerBreastExamination.setVanID(1);
		cancerBreastExamination.setVanSerialNo(1L);
		cancerBreastExamination.setVehicalNo("Vehical No");
		cancerBreastExamination.setVisitCode(1L);

		CancerGynecologicalExamination cancerGynecologicalExamination = new CancerGynecologicalExamination();
		cancerGynecologicalExamination.setAppearanceOfCervix("Appearance Of Cervix");
		cancerGynecologicalExamination.setBenVisitID(1L);
		cancerGynecologicalExamination.setBeneficiaryRegID(1L);
		cancerGynecologicalExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		cancerGynecologicalExamination.setCreatedDate(mock(Timestamp.class));
		cancerGynecologicalExamination.setDeleted(true);
		cancerGynecologicalExamination.setExperiencedPostCoitalBleeding(true);
		cancerGynecologicalExamination.setFilePath("/directory/foo.txt");
		cancerGynecologicalExamination.setID(1L);
		cancerGynecologicalExamination.setLastModDate(mock(Timestamp.class));
		cancerGynecologicalExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		cancerGynecologicalExamination.setObservation("Observation");
		cancerGynecologicalExamination.setParkingPlaceID(1);
		cancerGynecologicalExamination.setProcessed("Processed");
		cancerGynecologicalExamination.setProviderServiceMapID(1);
		cancerGynecologicalExamination.setReservedForChange("Reserved For Change");
		cancerGynecologicalExamination.setSufferedFromRTIOrSTI(true);
		cancerGynecologicalExamination.setSyncedBy("Synced By");
		cancerGynecologicalExamination.setSyncedDate(mock(Timestamp.class));
		cancerGynecologicalExamination.setTypeOfLesion("Type Of Lesion");
		cancerGynecologicalExamination.setTypeOfLesionList(new ArrayList<>());
		cancerGynecologicalExamination.setUterus_Normal(true);
		cancerGynecologicalExamination.setVaginalInvolvement(true);
		cancerGynecologicalExamination.setVanID(1);
		cancerGynecologicalExamination.setVanSerialNo(1L);
		cancerGynecologicalExamination.setVehicalNo("Vehical No");
		cancerGynecologicalExamination.setVisitCode(1L);
		cancerGynecologicalExamination.setVulvalInvolvement(true);
		cancerGynecologicalExamination.setrTIOrSTIDetail("R TIOr STIDetail");

		CancerOralExamination cancerOralExamination = new CancerOralExamination();
		cancerOralExamination.setBenVisitID(1L);
		cancerOralExamination.setBeneficiaryRegID(1L);
		cancerOralExamination.setChronicBurningSensation(true);
		cancerOralExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		cancerOralExamination.setCreatedDate(mock(Timestamp.class));
		cancerOralExamination.setDeleted(true);
		cancerOralExamination.setID(1L);
		cancerOralExamination.setLastModDate(mock(Timestamp.class));
		cancerOralExamination.setLimitedMouthOpening("Limited Mouth Opening");
		cancerOralExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		cancerOralExamination.setObservation("Observation");
		cancerOralExamination.setParkingPlaceID(1);
		cancerOralExamination.setPreMalignantLesionType("Pre Malignant Lesion Type");
		cancerOralExamination.setPreMalignantLesionTypeList(new ArrayList<>());
		cancerOralExamination.setPremalignantLesions(true);
		cancerOralExamination.setProcessed("Processed");
		cancerOralExamination.setProlongedIrritation(true);
		cancerOralExamination.setProviderServiceMapID(1);
		cancerOralExamination.setReservedForChange("Reserved For Change");
		cancerOralExamination.setSyncedBy("Synced By");
		cancerOralExamination.setSyncedDate(mock(Timestamp.class));
		cancerOralExamination.setVanID(1);
		cancerOralExamination.setVanSerialNo(1L);
		cancerOralExamination.setVehicalNo("Vehical No");
		cancerOralExamination.setVisitCode(1L);

		CancerSignAndSymptoms cancerSignAndSymptoms = new CancerSignAndSymptoms();
		cancerSignAndSymptoms.setBenVisitID(1L);
		cancerSignAndSymptoms.setBeneficiaryRegID(1L);
		cancerSignAndSymptoms.setBloodInSputum(true);
		cancerSignAndSymptoms.setBloodStainedDischargeFromNipple(true);
		cancerSignAndSymptoms.setBreastEnlargement(true);
		cancerSignAndSymptoms.setBriefHistory("Observation");
		cancerSignAndSymptoms.setChangeInShapeAndSizeOfBreasts(true);
		cancerSignAndSymptoms.setChangeInTheToneOfVoice(true);
		cancerSignAndSymptoms.setCoughGTE2Weeks(true);
		cancerSignAndSymptoms.setCoughgt2Weeks(true);
		cancerSignAndSymptoms.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		cancerSignAndSymptoms.setCreatedDate(mock(Timestamp.class));
		cancerSignAndSymptoms.setDeleted(true);
		cancerSignAndSymptoms.setDifficultyInOpeningMouth(true);
		cancerSignAndSymptoms.setFoulSmellingVaginalDischarge(true);
		cancerSignAndSymptoms.setID(1L);
		cancerSignAndSymptoms.setLastModDate(mock(Timestamp.class));
		cancerSignAndSymptoms.setLumpInTheBreast(true);
		cancerSignAndSymptoms.setLymphNode_Enlarged(true);
		cancerSignAndSymptoms.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		cancerSignAndSymptoms.setNonHealingUlcerOrPatchOrGrowth(true);
		cancerSignAndSymptoms.setObservation("Observation");
		cancerSignAndSymptoms.setParkingPlaceID(1);
		cancerSignAndSymptoms.setProcessed("Processed");
		cancerSignAndSymptoms.setProviderServiceMapID(1);
		cancerSignAndSymptoms.setReservedForChange("Reserved For Change");
		cancerSignAndSymptoms.setShortnessOfBreath(true);
		cancerSignAndSymptoms.setSyncedBy("Synced By");
		cancerSignAndSymptoms.setSyncedDate(mock(Timestamp.class));
		cancerSignAndSymptoms.setVaginalBleedingAfterIntercourse(true);
		cancerSignAndSymptoms.setVaginalBleedingAfterMenopause(true);
		cancerSignAndSymptoms.setVaginalBleedingBetweenPeriods(true);
		cancerSignAndSymptoms.setVanID(1);
		cancerSignAndSymptoms.setVanSerialNo(1L);
		cancerSignAndSymptoms.setVehicalNo("Vehical No");
		cancerSignAndSymptoms.setVisitCode(1L);

		BenCancerVitalDetail benCancerVitalDetail = new BenCancerVitalDetail();
		benCancerVitalDetail.setBenVisitID(1L);
		benCancerVitalDetail.setBeneficiaryRegID(1L);
		benCancerVitalDetail.setBloodGlucose_2HrPostPrandial((short) 1);
		benCancerVitalDetail.setBloodGlucose_Fasting((short) 1);
		benCancerVitalDetail.setBloodGlucose_Random((short) 1);
		benCancerVitalDetail.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benCancerVitalDetail.setCreatedDate(mock(Timestamp.class));
		benCancerVitalDetail.setDeleted(true);
		benCancerVitalDetail.setDiastolicBP_1stReading((short) 1);
		benCancerVitalDetail.setDiastolicBP_2ndReading((short) 1);
		benCancerVitalDetail.setDiastolicBP_3rdReading((short) 1);
		benCancerVitalDetail.setHbA1C((short) 1);
		benCancerVitalDetail.setHeight_cm(10.0d);
		benCancerVitalDetail.setHemoglobin(10.0d);
		benCancerVitalDetail.setID(1L);
		benCancerVitalDetail.setLastModDate(mock(Timestamp.class));
		benCancerVitalDetail.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benCancerVitalDetail.setParkingPlaceID(1);
		benCancerVitalDetail.setProcessed("Processed");
		benCancerVitalDetail.setProviderServiceMapID(1);
		benCancerVitalDetail.setRbsTestRemarks("Rbs Test Remarks");
		benCancerVitalDetail.setRbsTestResult("Rbs Test Result");
		benCancerVitalDetail.setReservedForChange("Reserved For Change");
		benCancerVitalDetail.setSyncedBy("Synced By");
		benCancerVitalDetail.setSyncedDate(mock(Timestamp.class));
		benCancerVitalDetail.setSystolicBP_1stReading((short) 1);
		benCancerVitalDetail.setSystolicBP_2ndReading((short) 1);
		benCancerVitalDetail.setSystolicBP_3rdReading((short) 1);
		benCancerVitalDetail.setVanID(1);
		benCancerVitalDetail.setVanSerialNo(1L);
		benCancerVitalDetail.setVehicalNo("Vehical No");
		benCancerVitalDetail.setVisitCode(1L);
		benCancerVitalDetail.setWaistCircumference_cm(10.0d);
		benCancerVitalDetail.setWeight_Kg(10.0d);
		benCancerVitalDetail.setsPO2("S PO2");

		BenObstetricCancerHistory benObstetricCancerHistory = new BenObstetricCancerHistory();
		benObstetricCancerHistory.setBenVisitID(1L);
		benObstetricCancerHistory.setBeneficiaryRegID(1L);
		benObstetricCancerHistory.setCaptureDate(mock(Date.class));
		benObstetricCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benObstetricCancerHistory.setCreatedDate(mock(Timestamp.class));
		benObstetricCancerHistory.setDeleted(true);
		benObstetricCancerHistory.setID(1L);
		benObstetricCancerHistory.setIsAbortion("Is Abortion");
		benObstetricCancerHistory.setIsDysmenorrhea("Is Dysmenorrhea");
		benObstetricCancerHistory.setIsFoulSmellingDischarge("Is Foul Smelling Discharge");
		benObstetricCancerHistory.setIsHormoneReplacementTherapy("Is Hormone Replacement Therapy");
		benObstetricCancerHistory.setIsInterMenstrualBleeding("Is Inter Menstrual Bleeding");
		benObstetricCancerHistory.setIsMenstrualCycleRegular("Is Menstrual Cycle Regular");
		benObstetricCancerHistory.setIsOralContraceptiveUsed("Is Oral Contraceptive Used");
		benObstetricCancerHistory.setIsPostMenopauseBleeding("Is Post Menopause Bleeding");
		benObstetricCancerHistory.setIsUrinePregTest("Is Urine Preg Test");
		benObstetricCancerHistory.setLastModDate(mock(Timestamp.class));
		benObstetricCancerHistory.setMenarche_Age(1);
		benObstetricCancerHistory.setMenopauseAge(1);
		benObstetricCancerHistory.setMenstrualCycleLength(3);
		benObstetricCancerHistory.setMenstrualFlowDuration(1);
		benObstetricCancerHistory.setMenstrualFlowType("Menstrual Flow Type");
		benObstetricCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benObstetricCancerHistory.setNoOfLivingChild(1);
		benObstetricCancerHistory.setParkingPlaceID(1);
		benObstetricCancerHistory.setPregnancyStatus("Pregnancy Status");
		benObstetricCancerHistory.setPregnant_No("Pregnant No");
		benObstetricCancerHistory.setProcessed("Processed");
		benObstetricCancerHistory.setProviderServiceMapID(1);
		benObstetricCancerHistory.setReservedForChange("Reserved For Change");
		benObstetricCancerHistory.setSyncedBy("Synced By");
		benObstetricCancerHistory.setSyncedDate(mock(Timestamp.class));
		benObstetricCancerHistory.setVanID(1);
		benObstetricCancerHistory.setVanSerialNo(1L);
		benObstetricCancerHistory.setVehicalNo("Vehical No");
		benObstetricCancerHistory.setVisitCode(1L);

		BenPersonalCancerDietHistory benPersonalCancerDietHistory = new BenPersonalCancerDietHistory();
		benPersonalCancerDietHistory.setBenVisitID(1L);
		benPersonalCancerDietHistory.setBeneficiaryRegID(1L);
		benPersonalCancerDietHistory.setCaptureDate(mock(Date.class));
		benPersonalCancerDietHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benPersonalCancerDietHistory.setCreatedDate(mock(Timestamp.class));
		benPersonalCancerDietHistory.setDeleted(true);
		benPersonalCancerDietHistory.setDietType("Diet Type");
		benPersonalCancerDietHistory.setFruitConsumptionDays(1);
		benPersonalCancerDietHistory.setFruitQuantityPerDay(1);
		benPersonalCancerDietHistory.setID(1L);
		benPersonalCancerDietHistory.setIntakeOfOutsidePreparedMeal(1);
		benPersonalCancerDietHistory.setIsRadiationExposure("Is Radiation Exposure");
		benPersonalCancerDietHistory.setIsThyroidDisorder("Is Thyroid Disorder");
		benPersonalCancerDietHistory.setLastModDate(mock(Timestamp.class));
		benPersonalCancerDietHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benPersonalCancerDietHistory.setParkingPlaceID(1);
		benPersonalCancerDietHistory.setPhysicalActivityType("Physical Activity Type");
		benPersonalCancerDietHistory.setProcessed("Processed");
		benPersonalCancerDietHistory.setProviderServiceMapID(1);
		benPersonalCancerDietHistory.setReservedForChange("Reserved For Change");
		benPersonalCancerDietHistory.setSsRadiationExposure(true);
		benPersonalCancerDietHistory.setSyncedBy("Synced By");
		benPersonalCancerDietHistory.setSyncedDate(mock(Timestamp.class));
		benPersonalCancerDietHistory.setTypeOfOilConsumed("Type Of Oil Consumed");
		benPersonalCancerDietHistory.setTypeOfOilConsumedList(new ArrayList<>());
		benPersonalCancerDietHistory.setVanID(1);
		benPersonalCancerDietHistory.setVanSerialNo(1L);
		benPersonalCancerDietHistory.setVegetableConsumptionDays(1);
		benPersonalCancerDietHistory.setVegetableQuantityPerDay(1);
		benPersonalCancerDietHistory.setVehicalNo("Vehical No");
		benPersonalCancerDietHistory.setVisitCode(1L);

		BenPersonalCancerHistory benPersonalCancerHistory = new BenPersonalCancerHistory();
		benPersonalCancerHistory.setAlcoholUse("Alcohol Use");
		benPersonalCancerHistory.setBenVisitID(1L);
		benPersonalCancerHistory.setBeneficiaryRegID(1L);
		benPersonalCancerHistory.setCaptureDate(mock(Date.class));
		benPersonalCancerHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		benPersonalCancerHistory.setCreatedDate(mock(Timestamp.class));
		benPersonalCancerHistory.setDeleted(true);
		benPersonalCancerHistory.setDurationOfBetelQuid(1);
		benPersonalCancerHistory.setEndAge_year(3);
		benPersonalCancerHistory.setFrequencyOfAlcoholUsed("Frequency Of Alcohol Used");
		benPersonalCancerHistory.setID(1L);
		benPersonalCancerHistory.setIsAlcoholUsed("Is Alcohol Used");
		benPersonalCancerHistory.setIsBetelNutChewing("Is Betel Nut Chewing");
		benPersonalCancerHistory.setIsCigaretteExposure("Is Cigarette Exposure");
		benPersonalCancerHistory.setIsFilteredCigaerette("Is Filtered Cigaerette");
		benPersonalCancerHistory.setLastModDate(mock(Timestamp.class));
		benPersonalCancerHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		benPersonalCancerHistory.setParkingPlaceID(1);
		benPersonalCancerHistory.setProcessed("Processed");
		benPersonalCancerHistory.setProviderServiceMapID(1);
		benPersonalCancerHistory.setQuantityPerDay(1);
		benPersonalCancerHistory.setReservedForChange("Reserved For Change");
		benPersonalCancerHistory.setSsAlcoholUsed(true);
		benPersonalCancerHistory.setStartAge_year(1);
		benPersonalCancerHistory.setSyncedBy("Synced By");
		benPersonalCancerHistory.setSyncedDate(mock(Timestamp.class));
		benPersonalCancerHistory.setTobaccoUse("Tobacco Use");
		benPersonalCancerHistory.setTypeOfTobaccoProduct("Type Of Tobacco Product");
		benPersonalCancerHistory.setTypeOfTobaccoProductList(new ArrayList<>());
		benPersonalCancerHistory.setVanID(1);
		benPersonalCancerHistory.setVanSerialNo(1L);
		benPersonalCancerHistory.setVehicalNo("Vehical No");
		benPersonalCancerHistory.setVisitCode(1L);

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
		when(cSNurseServiceImpl.getBenCancerAbdominalExaminationData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(cancerAbdominalExamination);
		when(cSNurseServiceImpl.getBenCancerBreastExaminationData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(cancerBreastExamination);
		when(cSNurseServiceImpl.getBenCancerGynecologicalExaminationData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(cancerGynecologicalExamination);
		when(cSNurseServiceImpl.getBenCancerOralExaminationData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(cancerOralExamination);
		when(cSNurseServiceImpl.getBenCancerSignAndSymptomsData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(cancerSignAndSymptoms);
		when(cSNurseServiceImpl.getBenCancerVitalDetailData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benCancerVitalDetail);
		when(cSNurseServiceImpl.getBenObstetricDetailsData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benObstetricCancerHistory);
		when(cSNurseServiceImpl.getBenPersonalCancerDietHistoryData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benPersonalCancerDietHistory);
		when(cSNurseServiceImpl.getBenPersonalCancerHistoryData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benPersonalCancerHistory);
		when(cSNurseServiceImpl.getBeneficiaryVisitDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(beneficiaryVisitDetail);
		when(cSNurseServiceImpl.getBenCancerLymphNodeDetailsData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());
		when(cSNurseServiceImpl.getBenFamilyHisData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());

		// Act
		cSServiceImpl.getBenNurseDataForCaseSheet(1L, 1L);
	}

	@Test
	void testGetBenFamilyHistoryData() {
		// Arrange
		when(cSNurseServiceImpl.getBenCancerFamilyHistory(Mockito.<Long>any())).thenReturn("Ben Cancer Family History");

		// Act
		String actualBenFamilyHistoryData = cSServiceImpl.getBenFamilyHistoryData(1L);

		// Assert
		verify(cSNurseServiceImpl).getBenCancerFamilyHistory(Mockito.<Long>any());
		assertEquals("Ben Cancer Family History", actualBenFamilyHistoryData);
	}

	@Test
	void testGetBenFamilyHistoryData2() {
		// Arrange
		when(cSNurseServiceImpl.getBenCancerFamilyHistory(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

		// Act and Assert
		assertThrows(RuntimeException.class, () -> cSServiceImpl.getBenFamilyHistoryData(1L));
		verify(cSNurseServiceImpl).getBenCancerFamilyHistory(Mockito.<Long>any());
	}

	@Test
	void testGetBenPersonalHistoryData() {
		// Arrange
		when(cSNurseServiceImpl.getBenCancerPersonalHistory(Mockito.<Long>any()))
				.thenReturn("Ben Cancer Personal History");

		// Act
		String actualBenPersonalHistoryData = cSServiceImpl.getBenPersonalHistoryData(1L);

		// Assert
		verify(cSNurseServiceImpl).getBenCancerPersonalHistory(Mockito.<Long>any());
		assertEquals("Ben Cancer Personal History", actualBenPersonalHistoryData);
	}

	@Test
	void testGetBenPersonalHistoryData2() {
		// Arrange
		when(cSNurseServiceImpl.getBenCancerPersonalHistory(Mockito.<Long>any()))
				.thenThrow(new RuntimeException("foo"));

		// Act and Assert
		assertThrows(RuntimeException.class, () -> cSServiceImpl.getBenPersonalHistoryData(1L));
		verify(cSNurseServiceImpl).getBenCancerPersonalHistory(Mockito.<Long>any());
	}

	@Test
	void testGetBenPersonalDietHistoryData() {
		// Arrange
		when(cSNurseServiceImpl.getBenCancerPersonalDietHistory(Mockito.<Long>any()))
				.thenReturn("Ben Cancer Personal Diet History");

		// Act
		String actualBenPersonalDietHistoryData = cSServiceImpl.getBenPersonalDietHistoryData(1L);

		// Assert
		verify(cSNurseServiceImpl).getBenCancerPersonalDietHistory(Mockito.<Long>any());
		assertEquals("Ben Cancer Personal Diet History", actualBenPersonalDietHistoryData);
	}

	@Test
	void testGetBenPersonalDietHistoryData2() {
		// Arrange
		when(cSNurseServiceImpl.getBenCancerPersonalDietHistory(Mockito.<Long>any()))
				.thenThrow(new RuntimeException("foo"));

		// Act and Assert
		assertThrows(RuntimeException.class, () -> cSServiceImpl.getBenPersonalDietHistoryData(1L));
		verify(cSNurseServiceImpl).getBenCancerPersonalDietHistory(Mockito.<Long>any());
	}

	@Test
	void testGetBenObstetricHistoryData() {
		// Arrange
		when(cSNurseServiceImpl.getBenCancerObstetricHistory(Mockito.<Long>any()))
				.thenReturn("Ben Cancer Obstetric History");

		// Act
		String actualBenObstetricHistoryData = cSServiceImpl.getBenObstetricHistoryData(1L);

		// Assert
		verify(cSNurseServiceImpl).getBenCancerObstetricHistory(Mockito.<Long>any());
		assertEquals("Ben Cancer Obstetric History", actualBenObstetricHistoryData);
	}

	@Test
	void testGetBenObstetricHistoryData2() {
		// Arrange
		when(cSNurseServiceImpl.getBenCancerObstetricHistory(Mockito.<Long>any()))
				.thenThrow(new RuntimeException("foo"));

		// Act and Assert
		assertThrows(RuntimeException.class, () -> cSServiceImpl.getBenObstetricHistoryData(1L));
		verify(cSNurseServiceImpl).getBenCancerObstetricHistory(Mockito.<Long>any());
	}

	@Test
	void testUpdateCancerDiagnosisDetailsByOncologist() {
		// Arrange
		when(cSOncologistServiceImpl.updateCancerDiagnosisDetailsByOncologist(Mockito.<CancerDiagnosis>any()))
				.thenReturn(1);

		Institute institute = new Institute();
		institute.setBlockID(1);
		institute.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		institute.setCreatedDate(mock(Timestamp.class));
		institute.setDeleted(true);
		institute.setDistrictBranchMappingID(1);
		institute.setDistrictID(1);
		institute.setInstitutionID(1);
		institute.setInstitutionName("Institution Name");
		institute.setLastModDate(mock(Timestamp.class));
		institute.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		institute.setProcessed("Processed");
		institute.setProviderServiceMapID(1);
		institute.setStateID(1);

		CancerDiagnosis cancerDiagnosis = new CancerDiagnosis();
		cancerDiagnosis.setBenVisitID(1L);
		cancerDiagnosis.setBeneficiaryRegID(1L);
		cancerDiagnosis.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		cancerDiagnosis.setCreatedDate(mock(Timestamp.class));
		cancerDiagnosis.setDeleted(true);
		cancerDiagnosis.setID(1L);
		cancerDiagnosis.setInstitute(institute);
		cancerDiagnosis.setLastModDate(mock(Timestamp.class));
		cancerDiagnosis.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		cancerDiagnosis.setParkingPlaceID(1);
		cancerDiagnosis.setProcessed("Processed");
		cancerDiagnosis.setProviderServiceMapID(1);
		cancerDiagnosis.setProvisionalDiagnosisOncologist("Provisional Diagnosis Oncologist");
		cancerDiagnosis.setProvisionalDiagnosisPrimaryDoctor("Provisional Diagnosis Primary Doctor");
		cancerDiagnosis.setReferralReason("Just cause");
		cancerDiagnosis.setReferredToInstituteID(1);
		cancerDiagnosis.setReferredToInstituteName("Referred To Institute Name");
		cancerDiagnosis.setRefrredToAdditionalService("Refrred To Additional Service");
		cancerDiagnosis.setRefrredToAdditionalServiceList(new ArrayList<>());
		cancerDiagnosis.setRemarks("Remarks");
		cancerDiagnosis.setReservedForChange("Reserved For Change");
		cancerDiagnosis.setRevisitDate(mock(Timestamp.class));
		cancerDiagnosis.setSyncedBy("Synced By");
		cancerDiagnosis.setSyncedDate(mock(Timestamp.class));
		cancerDiagnosis.setVanID(1);
		cancerDiagnosis.setVanSerialNo(1L);
		cancerDiagnosis.setVehicalNo("Vehical No");
		cancerDiagnosis.setVisitCode(1L);

		// Act
		int actualUpdateCancerDiagnosisDetailsByOncologistResult = cSServiceImpl
				.updateCancerDiagnosisDetailsByOncologist(cancerDiagnosis);

		// Assert
		verify(cSOncologistServiceImpl).updateCancerDiagnosisDetailsByOncologist(Mockito.<CancerDiagnosis>any());
		assertEquals(1, actualUpdateCancerDiagnosisDetailsByOncologistResult);
	}

	@Test
	@Disabled("TODO: Complete this test")
	void testGetBenDoctorDiagnosisData() {

		// Arrange
		Institute institute = new Institute();
		institute.setBlockID(1);
		institute.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		institute.setCreatedDate(mock(Timestamp.class));
		institute.setDeleted(true);
		institute.setDistrictBranchMappingID(1);
		institute.setDistrictID(1);
		institute.setInstitutionID(1);
		institute.setInstitutionName("Institution Name");
		institute.setLastModDate(mock(Timestamp.class));
		institute.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		institute.setProcessed("Processed");
		institute.setProviderServiceMapID(1);
		institute.setStateID(1);

		CancerDiagnosis cancerDiagnosis = new CancerDiagnosis();
		cancerDiagnosis.setBenVisitID(1L);
		cancerDiagnosis.setBeneficiaryRegID(1L);
		cancerDiagnosis.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		cancerDiagnosis.setCreatedDate(mock(Timestamp.class));
		cancerDiagnosis.setDeleted(true);
		cancerDiagnosis.setID(1L);
		cancerDiagnosis.setInstitute(institute);
		cancerDiagnosis.setLastModDate(mock(Timestamp.class));
		cancerDiagnosis.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		cancerDiagnosis.setParkingPlaceID(1);
		cancerDiagnosis.setProcessed("Processed");
		cancerDiagnosis.setProviderServiceMapID(1);
		cancerDiagnosis.setProvisionalDiagnosisOncologist("Provisional Diagnosis Oncologist");
		cancerDiagnosis.setProvisionalDiagnosisPrimaryDoctor("Provisional Diagnosis Primary Doctor");
		cancerDiagnosis.setReferralReason("Just cause");
		cancerDiagnosis.setReferredToInstituteID(1);
		cancerDiagnosis.setReferredToInstituteName("Referred To Institute Name");
		cancerDiagnosis.setRefrredToAdditionalService("Refrred To Additional Service");
		cancerDiagnosis.setRefrredToAdditionalServiceList(new ArrayList<>());
		cancerDiagnosis.setRemarks("Remarks");
		cancerDiagnosis.setReservedForChange("Reserved For Change");
		cancerDiagnosis.setRevisitDate(mock(Timestamp.class));
		cancerDiagnosis.setSyncedBy("Synced By");
		cancerDiagnosis.setSyncedDate(mock(Timestamp.class));
		cancerDiagnosis.setVanID(1);
		cancerDiagnosis.setVanSerialNo(1L);
		cancerDiagnosis.setVehicalNo("Vehical No");
		cancerDiagnosis.setVisitCode(1L);
		when(cSDoctorServiceImpl.getBenCancerDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(cancerDiagnosis);

		// Act
		cSServiceImpl.getBenDoctorDiagnosisData(1L, 1L);
	}

	@Test
	@Disabled("TODO: Complete this test")
	void testGetBenCaseRecordFromDoctorCS() {

		// Arrange
		Institute institute = new Institute();
		institute.setBlockID(1);
		institute.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		institute.setCreatedDate(mock(Timestamp.class));
		institute.setDeleted(true);
		institute.setDistrictBranchMappingID(1);
		institute.setDistrictID(1);
		institute.setInstitutionID(1);
		institute.setInstitutionName("Institution Name");
		institute.setLastModDate(mock(Timestamp.class));
		institute.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		institute.setProcessed("Processed");
		institute.setProviderServiceMapID(1);
		institute.setStateID(1);

		CancerDiagnosis cancerDiagnosis = new CancerDiagnosis();
		cancerDiagnosis.setBenVisitID(1L);
		cancerDiagnosis.setBeneficiaryRegID(1L);
		cancerDiagnosis.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		cancerDiagnosis.setCreatedDate(mock(Timestamp.class));
		cancerDiagnosis.setDeleted(true);
		cancerDiagnosis.setID(1L);
		cancerDiagnosis.setInstitute(institute);
		cancerDiagnosis.setLastModDate(mock(Timestamp.class));
		cancerDiagnosis.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		cancerDiagnosis.setParkingPlaceID(1);
		cancerDiagnosis.setProcessed("Processed");
		cancerDiagnosis.setProviderServiceMapID(1);
		cancerDiagnosis.setProvisionalDiagnosisOncologist("Provisional Diagnosis Oncologist");
		cancerDiagnosis.setProvisionalDiagnosisPrimaryDoctor("Provisional Diagnosis Primary Doctor");
		cancerDiagnosis.setReferralReason("Just cause");
		cancerDiagnosis.setReferredToInstituteID(1);
		cancerDiagnosis.setReferredToInstituteName("Referred To Institute Name");
		cancerDiagnosis.setRefrredToAdditionalService("Refrred To Additional Service");
		cancerDiagnosis.setRefrredToAdditionalServiceList(new ArrayList<>());
		cancerDiagnosis.setRemarks("Remarks");
		cancerDiagnosis.setReservedForChange("Reserved For Change");
		cancerDiagnosis.setRevisitDate(mock(Timestamp.class));
		cancerDiagnosis.setSyncedBy("Synced By");
		cancerDiagnosis.setSyncedDate(mock(Timestamp.class));
		cancerDiagnosis.setVanID(1);
		cancerDiagnosis.setVanSerialNo(1L);
		cancerDiagnosis.setVehicalNo("Vehical No");
		cancerDiagnosis.setVisitCode(1L);
		when(cSDoctorServiceImpl.getBenCancerDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(cancerDiagnosis);

		// Act
		cSServiceImpl.getBenCaseRecordFromDoctorCS(1L, 1L);
	}

	/**
	 * Method under test:
	 * {@link CSServiceImpl#updateCancerScreeningDoctorData(JsonObject)}
	 */
	@Test
	void testUpdateCancerScreeningDoctorData() throws Exception {
		// Arrange, Act and Assert
		assertThrows(RuntimeException.class, () -> cSServiceImpl.updateCancerScreeningDoctorData(new JsonObject()));
		assertThrows(RuntimeException.class, () -> cSServiceImpl.updateCancerScreeningDoctorData(null));
	}

	@Test
	void testUpdateCancerScreeningDoctorData2() throws Exception {
		// Arrange
		JsonObject requestOBJ = new JsonObject();
		requestOBJ.add("Property", new JsonArray(3));

		// Act and Assert
		assertThrows(RuntimeException.class, () -> cSServiceImpl.updateCancerScreeningDoctorData(requestOBJ));
	}

	@Test
	void testUpdateCancerScreeningDoctorData3() throws Exception {
		// Arrange
		JsonObject requestOBJ = new JsonObject();
		requestOBJ.addProperty("diagnosis", (String) null);

		// Act and Assert
		assertThrows(RuntimeException.class, () -> cSServiceImpl.updateCancerScreeningDoctorData(requestOBJ));
	}

	@Test
	void testUpdateCancerScreeningDoctorData4() throws Exception {
		// Arrange
		when(beneficiaryFlowStatusRepo.updateBenFlowAfterTCSpcialistDoneForCanceScreening(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(1);
		when(cSDoctorServiceImpl.updateCancerDiagnosisDetailsByDoctor(Mockito.<CancerDiagnosis>any())).thenReturn(1);

		JsonObject requestOBJ = new JsonObject();
		requestOBJ.add("diagnosis", new JsonObject());

		// Act
		int actualUpdateCancerScreeningDoctorDataResult = cSServiceImpl.updateCancerScreeningDoctorData(requestOBJ);

		// Assert
		verify(beneficiaryFlowStatusRepo).updateBenFlowAfterTCSpcialistDoneForCanceScreening(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSDoctorServiceImpl).updateCancerDiagnosisDetailsByDoctor(Mockito.<CancerDiagnosis>any());
		assertEquals(1, actualUpdateCancerScreeningDoctorDataResult);
	}

	@Test
	void testUpdateCancerScreeningDoctorData5() throws Exception {
		// Arrange
		when(beneficiaryFlowStatusRepo.updateBenFlowAfterTCSpcialistDoneForCanceScreening(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any())).thenThrow(new RuntimeException("diagnosis"));
		when(cSDoctorServiceImpl.updateCancerDiagnosisDetailsByDoctor(Mockito.<CancerDiagnosis>any())).thenReturn(1);

		JsonObject requestOBJ = new JsonObject();
		requestOBJ.add("diagnosis", new JsonObject());

		// Act and Assert
		assertThrows(RuntimeException.class, () -> cSServiceImpl.updateCancerScreeningDoctorData(requestOBJ));
		verify(beneficiaryFlowStatusRepo).updateBenFlowAfterTCSpcialistDoneForCanceScreening(Mockito.<Long>any(),
				Mockito.<Long>any(), Mockito.<Long>any());
		verify(cSDoctorServiceImpl).updateCancerDiagnosisDetailsByDoctor(Mockito.<CancerDiagnosis>any());
	}
}
