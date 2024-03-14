//package com.iemr.mmu.service.ncdscreening;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.iemr.mmu.data.nurse.CommonUtilityClass;
//import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
//import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
//import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
//import com.iemr.mmu.repo.nurse.ncdscreening.IDRSDataRepo;
//import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
//import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
//import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
//import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
//import com.iemr.mmu.service.common.transaction.CommonServiceImpl;
//import com.iemr.mmu.service.labtechnician.LabTechnicianServiceImpl;
//import com.iemr.mmu.service.tele_consultation.TeleConsultationServiceImpl;
//import com.iemr.mmu.utils.exception.IEMRException;
//import com.iemr.mmu.utils.mapper.InputMapper;
//
//@ExtendWith(MockitoExtension.class)
//class NCDScreeningServiceImplTest {
//
//	@Mock
//	private NCDScreeningNurseServiceImpl ncdScreeningNurseServiceImpl;
//	@Mock
//	private CommonNurseServiceImpl commonNurseServiceImpl;
//	@Mock
//	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;
//	@Mock
//	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
//	@Mock
//	private CommonDoctorServiceImpl commonDoctorServiceImpl;
//	@Mock
//	private LabTechnicianServiceImpl labTechnicianServiceImpl;
//	@Mock
//	private CommonServiceImpl commonServiceImpl;
//	@Mock
//	private PrescriptionDetailRepo prescriptionDetailRepo;
//	@Mock
//	private TeleConsultationServiceImpl teleConsultationServiceImpl;
//	@Mock
//	private BenVisitDetailRepo benVisitDetailRepo;
//	@Mock
//	private IDRSDataRepo iDrsDataRepo;
//	@Mock
//	private NCDSCreeningDoctorServiceImpl ncdSCreeningDoctorServiceImpl;
//
//	@InjectMocks
//	NCDScreeningServiceImpl ncdScreeningService;
//
//}
package com.iemr.mmu.service.ncdscreening;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.BenFamilyHistory;
import com.iemr.mmu.data.anc.BenPersonalHabit;
import com.iemr.mmu.data.ncdScreening.PhysicalActivityType;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
import com.iemr.mmu.repo.nurse.ncdscreening.IDRSDataRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonServiceImpl;
import com.iemr.mmu.service.labtechnician.LabTechnicianServiceImpl;
import com.iemr.mmu.service.tele_consultation.TeleConsultationServiceImpl;
import com.iemr.mmu.utils.exception.IEMRException;

@ExtendWith(MockitoExtension.class)
class NCDScreeningServiceImplTest {
	@Mock
	private BenVisitDetailRepo benVisitDetailRepo;

	@Mock
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;

	@Mock
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;

	@Mock
	private CommonDoctorServiceImpl commonDoctorServiceImpl;

	@Mock
	private CommonNurseServiceImpl commonNurseServiceImpl;

	@Mock
	private CommonServiceImpl commonServiceImpl;

	@Mock
	private IDRSDataRepo iDRSDataRepo;

	@Mock
	private LabTechnicianServiceImpl labTechnicianServiceImpl;

	@Mock
	private NCDSCreeningDoctorServiceImpl nCDSCreeningDoctorServiceImpl;

	@Mock
	private NCDScreeningNurseServiceImpl nCDScreeningNurseServiceImpl;

	@InjectMocks
	private NCDScreeningServiceImpl nCDScreeningServiceImpl;

	@Mock
	private PrescriptionDetailRepo prescriptionDetailRepo;

	@Mock
	private TeleConsultationServiceImpl teleConsultationServiceImpl;

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#getBenHistoryDetails(Long, Long)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGetBenHistoryDetails() {

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
		
		benPersonalHabit.toString();

		PhysicalActivityType physicalActivityType = new PhysicalActivityType();
		physicalActivityType.setActivityType("Activity Type");
		physicalActivityType.setBenVisitID(1L);
		physicalActivityType.setBeneficiaryRegID(1L);
		physicalActivityType.setCaptureDate(mock(Date.class));
		physicalActivityType.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		physicalActivityType.setCreatedDate(mock(Timestamp.class));
		physicalActivityType.setDeleted(true);
		physicalActivityType.setID(1L);
		physicalActivityType.setLastModDate(mock(Timestamp.class));
		physicalActivityType.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		physicalActivityType.setParkingPlaceID(1);
		physicalActivityType.setPhysicalActivityType("Physical Activity Type");
		physicalActivityType.setProcessed("Processed");
		physicalActivityType.setProviderServiceMapID(1);
		physicalActivityType.setVanID(1);
		physicalActivityType.setVanSerialNo(1L);
		physicalActivityType.setVehicalNo("Vehical No");
		physicalActivityType.setVisitCode(1L);
		physicalActivityType.setpAID(1L);
		
		physicalActivityType.toString();
		when(commonNurseServiceImpl.getFamilyHistoryDetail(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benFamilyHistory);
		when(commonNurseServiceImpl.getPersonalHistory(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(benPersonalHabit);
		when(commonNurseServiceImpl.getPhysicalActivityType(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(physicalActivityType);

		// Act
		nCDScreeningServiceImpl.getBenHistoryDetails(1L, 1L);
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#UpdateNCDScreeningHistory(JsonObject)}
	 */
	@Test
	void testUpdateNCDScreeningHistory() throws Exception {
		// Arrange, Act and Assert
		assertEquals(0, nCDScreeningServiceImpl.UpdateNCDScreeningHistory(new JsonObject()).intValue());
		assertEquals(0, nCDScreeningServiceImpl.UpdateNCDScreeningHistory(null).intValue());
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#UpdateNCDScreeningHistory(JsonObject)}
	 */
	@Test
	void testUpdateNCDScreeningHistory2() throws Exception {
		// Arrange
		JsonObject historyOBJ = new JsonObject();
		historyOBJ.add("Property", new JsonArray(3));

		// Act and Assert
		assertEquals(0, nCDScreeningServiceImpl.UpdateNCDScreeningHistory(historyOBJ).intValue());
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#UpdateNCDScreeningHistory(JsonObject)}
	 */
	@Test
	void testUpdateNCDScreeningHistory3() throws Exception {
		// Arrange
		JsonObject historyOBJ = new JsonObject();
		historyOBJ.addProperty("familyHistory", (String) null);

		// Act and Assert
		assertEquals(0, nCDScreeningServiceImpl.UpdateNCDScreeningHistory(historyOBJ).intValue());
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#UpdateNCDScreeningHistory(JsonObject)}
	 */
	@Test
	void testUpdateNCDScreeningHistory4() throws Exception {
		// Arrange
		when(commonNurseServiceImpl.updateBenFamilyHistoryNCDScreening(Mockito.<BenFamilyHistory>any())).thenReturn(1);

		JsonObject historyOBJ = new JsonObject();
		historyOBJ.add("familyHistory", new JsonObject());

		// Act
		Integer actualUpdateNCDScreeningHistoryResult = nCDScreeningServiceImpl.UpdateNCDScreeningHistory(historyOBJ);

		// Assert
		verify(commonNurseServiceImpl).updateBenFamilyHistoryNCDScreening(Mockito.<BenFamilyHistory>any());
		assertEquals(0, actualUpdateNCDScreeningHistoryResult.intValue());
	}

	
	@Test
	void testGettersAndSetters() {

		// Arrange
		NCDScreeningServiceImpl ncdScreeningServiceImpl = new NCDScreeningServiceImpl();

		// Act
		ncdScreeningServiceImpl.setBeneficiaryFlowStatusRepo(mock(BeneficiaryFlowStatusRepo.class));
		ncdScreeningServiceImpl.setCommonBenStatusFlowServiceImpl(new CommonBenStatusFlowServiceImpl());
		ncdScreeningServiceImpl.setCommonDoctorServiceImpl(new CommonDoctorServiceImpl());
		ncdScreeningServiceImpl.setCommonNurseServiceImpl(new CommonNurseServiceImpl());
		ncdScreeningServiceImpl.setLabTechnicianServiceImpl(new LabTechnicianServiceImpl());
		ncdScreeningServiceImpl.setNcdScreeningNurseServiceImpl(new NCDScreeningNurseServiceImpl());
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#UpdateIDRSScreen(JsonObject)}
	 */
	@Test
	void testUpdateIDRSScreen() throws Exception {
		// Arrange, Act and Assert
		assertNull(nCDScreeningServiceImpl.UpdateIDRSScreen(new JsonObject()));
		assertNull(nCDScreeningServiceImpl.UpdateIDRSScreen(null));
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#UpdateIDRSScreen(JsonObject)}
	 */
	@Test
	void testUpdateIDRSScreen2() throws Exception {
		// Arrange
		JsonObject idrsOBJ = new JsonObject();
		idrsOBJ.add("yyyy-MM-dd'T'HH:mm:ss.SSS", new JsonArray(3));

		// Act and Assert
		assertNull(nCDScreeningServiceImpl.UpdateIDRSScreen(idrsOBJ));
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#UpdateIDRSScreen(JsonObject)}
	 */
	@Test
	void testUpdateIDRSScreen3() throws Exception {
		// Arrange
		JsonObject idrsOBJ = new JsonObject();
		idrsOBJ.add("N", new JsonArray(3));

		// Act and Assert
		assertNull(nCDScreeningServiceImpl.UpdateIDRSScreen(idrsOBJ));
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#UpdateIDRSScreen(JsonObject)}
	 */
	@Test
	void testUpdateIDRSScreen4() throws Exception {
		// Arrange
		JsonObject idrsOBJ = new JsonObject();
		idrsOBJ.addProperty("idrsDetails", (String) null);

		// Act and Assert
		assertNull(nCDScreeningServiceImpl.UpdateIDRSScreen(idrsOBJ));
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#getBenCaseRecordFromDoctorNCDScreening(Long, Long)}
	 */
	@Test
	void testGetBenCaseRecordFromDoctorNCDScreening() throws Exception {
		// Arrange
		when(nCDSCreeningDoctorServiceImpl.getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Ncd Diagnosis Data");
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
		String actualBenCaseRecordFromDoctorNCDScreening = nCDScreeningServiceImpl
				.getBenCaseRecordFromDoctorNCDScreening(1L, 1L);

		// Assert
		verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonNurseServiceImpl).getGraphicalTrendData(Mockito.<Long>any(), eq("ncdCare"));
		verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
		verify(labTechnicianServiceImpl).getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any());
		verify(nCDSCreeningDoctorServiceImpl).getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("{Refer=Referral Details, prescription=Prescribed Drugs, findings=Findings Details, LabReport=[],"
				+ " diagnosis=Ncd Diagnosis Data, investigation=Investigation Details, ArchivedVisitcodeForLabResult=Last"
				+ " 3 Archived Test Visit List, GraphData={}}", actualBenCaseRecordFromDoctorNCDScreening);
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#getBenCaseRecordFromDoctorNCDScreening(Long, Long)}
	 */
	@Test
	void testGetBenCaseRecordFromDoctorNCDScreening2() throws Exception {
		// Arrange
		when(nCDSCreeningDoctorServiceImpl.getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Ncd Diagnosis Data");
		when(commonDoctorServiceImpl.getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Findings Details");
		when(commonDoctorServiceImpl.getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Investigation Details");
		when(commonDoctorServiceImpl.getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Prescribed Drugs");
		when(commonDoctorServiceImpl.getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Referral Details");
		when(labTechnicianServiceImpl.getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenThrow(new IEMRException("An error occurred"));

		// Act and Assert
		assertThrows(IEMRException.class, () -> nCDScreeningServiceImpl.getBenCaseRecordFromDoctorNCDScreening(1L, 1L));
		verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
		verify(nCDSCreeningDoctorServiceImpl).getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any());
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#getBenCaseRecordFromDoctorNCDScreening(Long, Long)}
	 */
	@Test
	void testGetBenCaseRecordFromDoctorNCDScreening3() throws Exception {
		// Arrange
		when(nCDSCreeningDoctorServiceImpl.getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Ncd Diagnosis Data");
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
		String actualBenCaseRecordFromDoctorNCDScreening = nCDScreeningServiceImpl
				.getBenCaseRecordFromDoctorNCDScreening(1L, 1L);

		// Assert
		verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonNurseServiceImpl).getGraphicalTrendData(Mockito.<Long>any(), eq("ncdCare"));
		verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
		verify(labTechnicianServiceImpl).getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any());
		verify(nCDSCreeningDoctorServiceImpl).getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("{Refer=Referral Details, prescription=Prescribed Drugs, findings=Findings Details, LabReport=[],"
				+ " diagnosis=Ncd Diagnosis Data, investigation=Investigation Details, ArchivedVisitcodeForLabResult=Last"
				+ " 3 Archived Test Visit List, GraphData={\"findings\":\"42\"}}",
				actualBenCaseRecordFromDoctorNCDScreening);
	}

	/**
	 * Method under test:
	 * {@link NCDScreeningServiceImpl#getBenCaseRecordFromDoctorNCDScreening(Long, Long)}
	 */
	@Test
	void testGetBenCaseRecordFromDoctorNCDScreening4() throws Exception {
		// Arrange
		when(nCDSCreeningDoctorServiceImpl.getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Ncd Diagnosis Data");
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
		String actualBenCaseRecordFromDoctorNCDScreening = nCDScreeningServiceImpl
				.getBenCaseRecordFromDoctorNCDScreening(1L, 1L);

		// Assert
		verify(commonDoctorServiceImpl).getFindingsDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getInvestigationDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getPrescribedDrugs(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonDoctorServiceImpl).getReferralDetails(Mockito.<Long>any(), Mockito.<Long>any());
		verify(commonNurseServiceImpl).getGraphicalTrendData(Mockito.<Long>any(), eq("ncdCare"));
		verify(labTechnicianServiceImpl).getLabResultDataForBen(Mockito.<Long>any(), Mockito.<Long>any());
		verify(labTechnicianServiceImpl).getLast_3_ArchivedTestVisitList(Mockito.<Long>any(), Mockito.<Long>any());
		verify(nCDSCreeningDoctorServiceImpl).getNCDDiagnosisData(Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("{Refer=Referral Details, prescription=Prescribed Drugs, findings=Findings Details, LabReport=[],"
				+ " diagnosis=Ncd Diagnosis Data, investigation=Investigation Details, ArchivedVisitcodeForLabResult=Last"
				+ " 3 Archived Test Visit List, GraphData={\"findings\":\"42\",\"diagnosis\":\"42\"}}",
				actualBenCaseRecordFromDoctorNCDScreening);
	}
}
