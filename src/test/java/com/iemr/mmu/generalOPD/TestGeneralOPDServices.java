package com.iemr.mmu.generalOPD;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.data.anc.BenAllergyHistory;
import com.iemr.mmu.data.anc.BenChildDevelopmentHistory;
import com.iemr.mmu.data.anc.BenFamilyHistory;
import com.iemr.mmu.data.anc.BenMedHistory;
import com.iemr.mmu.data.anc.BenMedicationHistory;
import com.iemr.mmu.data.anc.BenMenstrualDetails;
import com.iemr.mmu.data.anc.BenPersonalHabit;
import com.iemr.mmu.data.anc.BencomrbidityCondDetails;
import com.iemr.mmu.data.anc.ChildFeedingDetails;
import com.iemr.mmu.data.anc.ChildOptionalVaccineDetail;
import com.iemr.mmu.data.anc.ChildVaccineDetail1;
import com.iemr.mmu.data.anc.FemaleObstetricHistory;
import com.iemr.mmu.data.anc.PerinatalHistory;
import com.iemr.mmu.data.anc.PhyGeneralExamination;
import com.iemr.mmu.data.anc.PhyHeadToToeExamination;
import com.iemr.mmu.data.anc.SysCardiovascularExamination;
import com.iemr.mmu.data.anc.SysCentralNervousExamination;
import com.iemr.mmu.data.anc.SysGastrointestinalExamination;
import com.iemr.mmu.data.anc.SysGenitourinarySystemExamination;
import com.iemr.mmu.data.anc.SysMusculoskeletalSystemExamination;
import com.iemr.mmu.data.anc.SysRespiratoryExamination;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.repo.nurse.BenAnthropometryRepo;
import com.iemr.mmu.repo.nurse.BenPhysicalVitalRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
import com.iemr.mmu.repo.nurse.anc.BenAllergyHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenChildDevelopmentHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenFamilyHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenMedHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenMedicationHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.BenMenstrualDetailsRepo;
import com.iemr.mmu.repo.nurse.anc.BenPersonalHabitRepo;
import com.iemr.mmu.repo.nurse.anc.BencomrbidityCondRepo;
import com.iemr.mmu.repo.nurse.anc.ChildFeedingDetailsRepo;
import com.iemr.mmu.repo.nurse.anc.ChildOptionalVaccineDetailRepo;
import com.iemr.mmu.repo.nurse.anc.ChildVaccineDetail1Repo;
import com.iemr.mmu.repo.nurse.anc.FemaleObstetricHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.PerinatalHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.PhyGeneralExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.PhyHeadToToeExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysCardiovascularExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysCentralNervousExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysGastrointestinalExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysGenitourinarySystemExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysMusculoskeletalSystemExaminationRepo;
import com.iemr.mmu.repo.nurse.anc.SysRespiratoryExaminationRepo;
import com.iemr.mmu.repo.quickConsultation.BenChiefComplaintRepo;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenData;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.generalOPD.GeneralOPDNurseServiceImpl;
import com.iemr.mmu.service.generalOPD.GeneralOPDServiceImpl;

public class TestGeneralOPDServices {

	@InjectMocks
	private static GeneralOPDServiceImpl generalOPDServiceImpl = spy(GeneralOPDServiceImpl.class);
	private static GeneralOPDNurseServiceImpl generalOPDNurseServiceImpl = spy(GeneralOPDNurseServiceImpl.class);
	private static CommonNurseServiceImpl commonNurseServiceImpl = spy(CommonNurseServiceImpl.class);
	
	private static BenVisitDetailRepo benVisitDetailRepoMock = mock(BenVisitDetailRepo.class);
	private static BenChiefComplaintRepo benChiefComplaintRepoMock = mock(BenChiefComplaintRepo.class);
	private static BenMedHistoryRepo benMedHistoryRepoMock = mock(BenMedHistoryRepo.class);
	private static BencomrbidityCondRepo bencomrbidityCondRepoMock = mock(BencomrbidityCondRepo.class);
	private static BenMedicationHistoryRepo benMedicationHistoryRepoMock = mock(BenMedicationHistoryRepo.class);
	private static FemaleObstetricHistoryRepo femaleObstetricHistoryRepoMock = mock(FemaleObstetricHistoryRepo.class);
	private static BenMenstrualDetailsRepo benMenstrualDetailsRepoMock = mock(BenMenstrualDetailsRepo.class);
	private static BenFamilyHistoryRepo benFamilyHistoryRepoMock = mock(BenFamilyHistoryRepo.class);
	private static BenPersonalHabitRepo benPersonalHabitRepoMock = mock(BenPersonalHabitRepo.class);
	private static BenAllergyHistoryRepo benAllergyHistoryRepoMock = mock(BenAllergyHistoryRepo.class);
	private static ChildOptionalVaccineDetailRepo childOptionalVaccineDetailRepoMock = mock(
			ChildOptionalVaccineDetailRepo.class);
	private static ChildVaccineDetail1Repo childVaccineDetail1RepoMock = mock(ChildVaccineDetail1Repo.class);
	private static BenChildDevelopmentHistoryRepo benChildDevelopmentHistoryRepoMock =mock(BenChildDevelopmentHistoryRepo.class);
	private static ChildFeedingDetailsRepo childFeedingDetailsRepoMock = mock(ChildFeedingDetailsRepo.class);
	private static PerinatalHistoryRepo perinatalHistoryRepoMock = mock(PerinatalHistoryRepo.class);
	
	private static BenAnthropometryRepo benAnthropometryRepoMock = mock(BenAnthropometryRepo.class);
	private static BenPhysicalVitalRepo benPhysicalVitalRepoMock = mock(BenPhysicalVitalRepo.class);
	private static PhyGeneralExaminationRepo phyGeneralExaminationRepoMock = mock(PhyGeneralExaminationRepo.class);
	private static PhyHeadToToeExaminationRepo phyHeadToToeExaminationRepoMock = mock(PhyHeadToToeExaminationRepo.class);
	private static SysCardiovascularExaminationRepo sysCardiovascularExaminationRepoMock = mock(
			SysCardiovascularExaminationRepo.class);
	private static SysRespiratoryExaminationRepo sysRespiratoryExaminationRepoMock = mock(SysRespiratoryExaminationRepo.class);
	private static SysCentralNervousExaminationRepo sysCentralNervousExaminationRepoMock = mock(
			SysCentralNervousExaminationRepo.class);
	private static SysMusculoskeletalSystemExaminationRepo sysMusculoskeletalSystemExaminationRepoMock = mock(
			SysMusculoskeletalSystemExaminationRepo.class);
	private static SysGenitourinarySystemExaminationRepo sysGenitourinarySystemExaminationRepoMock = mock(
			SysGenitourinarySystemExaminationRepo.class);
	private static SysGastrointestinalExaminationRepo sysGastrointestinalExaminationRepoMock = mock(
			SysGastrointestinalExaminationRepo.class);
	
	private static RegistrarRepoBenData registrarRepoBenData = mock(RegistrarRepoBenData.class);

	static String requestObjPve = "";
	static JsonObject jsnOBJPve;
	static String requestObjNve = "";
	static JsonObject jsnOBJNve;

	@BeforeClass
	public static void initializeParams() {
		generalOPDServiceImpl.setCommonNurseServiceImpl(commonNurseServiceImpl);
		generalOPDServiceImpl.setGeneralOPDNurseServiceImpl(generalOPDNurseServiceImpl);
		
		commonNurseServiceImpl.setBenVisitDetailRepo(benVisitDetailRepoMock);
		commonNurseServiceImpl.setBenChiefComplaintRepo(benChiefComplaintRepoMock);
		commonNurseServiceImpl.setBenMedHistoryRepo(benMedHistoryRepoMock);
		commonNurseServiceImpl.setBencomrbidityCondRepo(bencomrbidityCondRepoMock);
		commonNurseServiceImpl.setBenMedicationHistoryRepo(benMedicationHistoryRepoMock);
		commonNurseServiceImpl.setFemaleObstetricHistoryRepo(femaleObstetricHistoryRepoMock);
		commonNurseServiceImpl.setBenMenstrualDetailsRepo(benMenstrualDetailsRepoMock);
		commonNurseServiceImpl.setBenFamilyHistoryRepo(benFamilyHistoryRepoMock);
		commonNurseServiceImpl.setBenPersonalHabitRepo(benPersonalHabitRepoMock);
		commonNurseServiceImpl.setBenAllergyHistoryRepo(benAllergyHistoryRepoMock);
		commonNurseServiceImpl.setChildOptionalVaccineDetailRepo(childOptionalVaccineDetailRepoMock);
		commonNurseServiceImpl.setChildVaccineDetail1Repo(childVaccineDetail1RepoMock);
		commonNurseServiceImpl.setBenAnthropometryRepo(benAnthropometryRepoMock);
		commonNurseServiceImpl.setBenPhysicalVitalRepo(benPhysicalVitalRepoMock);
		commonNurseServiceImpl.setPhyGeneralExaminationRepo(phyGeneralExaminationRepoMock);
		commonNurseServiceImpl.setPhyHeadToToeExaminationRepo(phyHeadToToeExaminationRepoMock);
		commonNurseServiceImpl.setSysGastrointestinalExaminationRepo(sysGastrointestinalExaminationRepoMock);
		commonNurseServiceImpl.setSysCardiovascularExaminationRepo(sysCardiovascularExaminationRepoMock);
		commonNurseServiceImpl.setSysRespiratoryExaminationRepo(sysRespiratoryExaminationRepoMock);
		commonNurseServiceImpl.setSysCentralNervousExaminationRepo(sysCentralNervousExaminationRepoMock);
		commonNurseServiceImpl.setSysMusculoskeletalSystemExaminationRepo(sysMusculoskeletalSystemExaminationRepoMock);
		commonNurseServiceImpl.setSysGenitourinarySystemExaminationRepo(sysGenitourinarySystemExaminationRepoMock);
		generalOPDNurseServiceImpl.setBenChildDevelopmentHistoryRepo(benChildDevelopmentHistoryRepoMock);
		generalOPDNurseServiceImpl.setChildFeedingDetailsRepo(childFeedingDetailsRepoMock);
		generalOPDNurseServiceImpl.setPerinatalHistoryRepo(perinatalHistoryRepoMock);
		generalOPDNurseServiceImpl.setSysGastrointestinalExaminationRepo(sysGastrointestinalExaminationRepoMock);
		
		commonNurseServiceImpl.setRegistrarRepoBenData(registrarRepoBenData);
		
		
		requestObjPve = "{\"visitDetails\":{ \"visitDetails\":{ \"beneficiaryRegID\":\"7469\", \"providerServiceMapID\":\"1320\", \"visitNo\":null, \"visitReason\":\"FollowUp\", \"visitCategory\":\"General OPD\", \"pregnancyStatus\":null, \"rCHID\":null, \"healthFacilityType\":null, \"healthFacilityLocation\":null, \"reportFilePath\":null, \"createdBy\":\"891\" }, \"chiefComplaints\":[ { \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"chiefComplaint\":null, \"chiefComplaintID\":null, \"duration\":null, \"unitOfDuration\":null, \"description\":null, \"createdBy\":\"891\" } ] }, \"vitalDetails\":{ \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"weight_Kg\":null, \"height_cm\":null, \"waistCircumference_cm\":null, \"hipCircumference_cm\":null, \"bMI\":null, \"waistHipRatio\":null, \"temperature\":null, \"pulseRate\":null, \"systolicBP_1stReading\":null, \"diastolicBP_1stReading\":null, \"bloodGlucose_Fasting\":null, \"bloodGlucose_Random\":null, \"bloodGlucose_2hr_PP\":null, \"respiratoryRate\":null, \"createdBy\":\"891\" }, \"historyDetails\":{ \"pastHistory\":{ \"pastIllness\":[ { \"illnessTypeID\":null, \"illnessType\":null, \"otherIllnessType\":null, \"timePeriodAgo\":null, \"timePeriodUnit\":null } ], \"pastSurgery\":[ { \"surgeryID\":null, \"surgeryType\":null, \"otherSurgeryType\":null, \"timePeriodAgo\":null, \"timePeriodUnit\":null } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"comorbidConditions\":{ \"comorbidityConcurrentConditionsList\":[ { \"comorbidConditions\":null, \"otherComorbidCondition\":null, \"timePeriodAgo\":null, \"timePeriodUnit\":null, \"isForHistory\":null } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"medicationHistory\":{ \"medicationHistoryList\":[ { \"currentMedication\":null, \"timePeriodAgo\":null, \"timePeriodUnit\":null } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"femaleObstetricHistory\":{ \"totalNoOfPreg\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\", \"femaleObstetricHistoryList\":[ ] }, \"menstrualHistory\":{ \"menstrualCycleStatus\":null, \"menstrualCycleStatusID\":null, \"regularity\":null, \"cycleLength\":null, \"menstrualCyclelengthID\":null, \"menstrualFlowDurationID\":null, \"bloodFlowDuration\":null, \"menstrualProblemID\":null, \"problemName\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"familyHistory\":{ \"familyDiseaseList\":[ { \"diseaseTypeID\":null, \"diseaseType\":null, \"otherDiseaseType\":null, \"familyMembers\":null } ], \"isGeneticDisorder\":null, \"geneticDisorder\":null, \"isConsanguineousMarrige\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"personalHistory\":{ \"dietaryType\":null, \"physicalActivityType\":null, \"riskySexualPracticesStatus\":0, \"tobaccoUseStatus\":null, \"alcoholIntakeStatus\":null, \"allergyStatus\":null, \"tobaccoList\":[ ], \"alcoholList\":[ ], \"allergicList\":[ ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"childVaccineDetails\":{ \"childOptionalVaccineList\":[ { \"vaccineName\":null, \"otherVaccineName\":null, \"actualReceivingAge\":null, \"receivedFacilityName\":null } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"immunizationHistory\":{ \"immunizationList\":[ { \"defaultReceivingAge\":\"At Birth\", \"vaccines\":[ { \"vaccine\":\"BCG\", \"status\":false }, { \"vaccine\":\"HBV-0\", \"status\":false }, { \"vaccine\":\"OPV-0\", \"status\":false } ] }, { \"defaultReceivingAge\":\"6 Weeks\", \"vaccines\":[ { \"vaccine\":\"IPV-1\", \"status\":false }, { \"vaccine\":\"OPV\", \"status\":false }, { \"vaccine\":\"Pentavalent-1\", \"status\":false }, { \"vaccine\":\"Rota Vaccine-1\", \"status\":false } ] }, { \"defaultReceivingAge\":\"10 Weeks\", \"vaccines\":[ { \"vaccine\":\"IPV-2\", \"status\":false }, { \"vaccine\":\"OPV\", \"status\":false }, { \"vaccine\":\"Pentavalent-2\", \"status\":false }, { \"vaccine\":\"Rota Vaccine-2\", \"status\":false } ] }, { \"defaultReceivingAge\":\"14 Weeks\", \"vaccines\":[ { \"vaccine\":\"IPV-3 \", \"status\":false }, { \"vaccine\":\"OPV\", \"status\":false }, { \"vaccine\":\"Pentavalent-3\", \"status\":false }, { \"vaccine\":\"Rota Vaccine-3\", \"status\":false } ] }, { \"defaultReceivingAge\":\"9 Months\", \"vaccines\":[ { \"vaccine\":\"JE Vaccine\", \"status\":false }, { \"vaccine\":\"Measles Vaccine/MR\", \"status\":false }, { \"vaccine\":\"Vitamin A\", \"status\":false } ] }, { \"defaultReceivingAge\":\"16-24 Months\", \"vaccines\":[ { \"vaccine\":\"DPT-B 1\", \"status\":false }, { \"vaccine\":\"Measles/MR Vaccine\", \"status\":false }, { \"vaccine\":\"OPV\", \"status\":false } ] }, { \"defaultReceivingAge\":\"5 Years\", \"vaccines\":[ { \"vaccine\":\"\", \"status\":false } ] }, { \"defaultReceivingAge\":\"10 Years\", \"vaccines\":[ { \"vaccine\":\"TT\", \"status\":false } ] }, { \"defaultReceivingAge\":\"16 Years\", \"vaccines\":[ { \"vaccine\":\"TT\", \"status\":false } ] } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"developmentHistory\":{ \"grossMotorMilestones\":null, \"fineMotorMilestones\":null, \"socialMilestones\":null, \"languageMilestones\":null, \"developmentalProblems\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"feedingHistory\":{ \"typeOfFeed\":null, \"compFeedStartAge\":null, \"noOfCompFeedPerDay\":null, \"foodIntoleranceStatus\":0, \"typeofFoodIntolerance\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"perinatalHistroy\":{ \"deliveryPlaceID\":null, \"placeOfDelivery\":null, \"otherPlaceOfDelivery\":null, \"deliveryTypeID\":null, \"typeOfDelivery\":null, \"complicationAtBirthID\":null, \"complicationAtBirth\":null, \"otherComplicationAtBirth\":null, \"gestation\":null, \"birthWeight_kg\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" } }, \"examinationDetails\":{ \"generalExamination\":{ \"consciousness\":null, \"coherence\":null, \"cooperation\":null, \"comfortness\":null, \"builtAndAppearance\":null, \"gait\":null, \"dangerSigns\":null, \"typeOfDangerSigns\":null, \"pallor\":null, \"jaundice\":null, \"cyanosis\":null, \"clubbing\":null, \"lymphadenopathy\":null, \"lymphnodesInvolved\":null, \"typeOfLymphadenopathy\":null, \"edema\":null, \"extentOfEdema\":null, \"edemaType\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"headToToeExamination\":{ \"headtoToeExam\":null, \"head\":null, \"eyes\":null, \"ears\":null, \"nose\":null, \"oralCavity\":null, \"throat\":null, \"breastAndNipples\":null, \"trunk\":null, \"upperLimbs\":null, \"lowerLimbs\":null, \"skin\":null, \"hair\":null, \"nails\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"gastroIntestinalExamination\":{ \"inspection\":null, \"palpation_AbdomenTexture\":null, \"palpation_Liver\":null, \"palpation_Spleen\":null, \"palpation_Tenderness\":null, \"palpation_LocationOfTenderness\":null, \"percussion\":null, \"auscultation\":null, \"analRegion\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"cardioVascularExamination\":{ \"jugularVenousPulse_JVP\":null, \"apexbeatLocation\":null, \"apexbeatType\":null, \"firstHeartSound_S1\":null, \"secondHeartSound_S2\":null, \"additionalHeartSounds\":null, \"murmurs\":null, \"pericardialRub\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"respiratorySystemExamination\":{ \"trachea\":null, \"inspection\":null, \"signsOfRespiratoryDistress\":null, \"palpation\":null, \"auscultation_Stridor\":null, \"auscultation_BreathSounds\":null, \"auscultation_Crepitations\":null, \"auscultation_Wheezing\":null, \"auscultation_PleuralRub\":null, \"auscultation_ConductedSounds\":null, \"percussion\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"centralNervousSystemExamination\":{ \"handedness\":null, \"cranialNervesExamination\":null, \"motorSystem\":null, \"sensorySystem\":null, \"autonomicSystem\":null, \"cerebellarSigns\":null, \"signsOfMeningealIrritation\":null, \"skull\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"musculoskeletalSystemExamination\":{ \"joint_TypeOfJoint\":null, \"joint_Laterality\":null, \"joint_Abnormality\":null, \"upperLimb_Laterality\":null, \"upperLimb_Abnormality\":null, \"lowerLimb_Laterality\":null, \"lowerLimb_Abnormality\":null, \"chestWall\":null, \"spine\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"genitoUrinarySystemExamination\":{ \"renalAngle\":null, \"suprapubicRegion\":null, \"externalGenitalia\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" } } }";
		requestObjNve = "{\"visitDetails\":{ \"visitetails\":{ \"beneficiaryRegID\":\"7469\", \"providerServiceMapID\":\"1320\", \"visitNo\":null, \"visitReason\":\"FollowUp\", \"visitCategory\":\"General OPD\", \"pregnancyStatus\":null, \"rCHID\":null, \"healthFacilityType\":null, \"healthFacilityLocation\":null, \"reportFilePath\":null, \"createdBy\":\"891\" }, \"chiefComplaints\":[ { \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"chiefComplaint\":null, \"chiefComplaintID\":null, \"duration\":null, \"unitOfDuration\":null, \"description\":null, \"createdBy\":\"891\" } ] }, \"vitalDetails\":{ \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"weight_Kg\":null, \"height_cm\":null, \"waistCircumference_cm\":null, \"hipCircumference_cm\":null, \"bMI\":null, \"waistHipRatio\":null, \"temperature\":null, \"pulseRate\":null, \"systolicBP_1stReading\":null, \"diastolicBP_1stReading\":null, \"bloodGlucose_Fasting\":null, \"bloodGlucose_Random\":null, \"bloodGlucose_2hr_PP\":null, \"respiratoryRate\":null, \"createdBy\":\"891\" }, \"historyDetails\":{ \"pastHistory\":{ \"pastIllness\":[ { \"illnessTypeID\":null, \"illnessType\":null, \"otherIllnessType\":null, \"timePeriodAgo\":null, \"timePeriodUnit\":null } ], \"pastSurgery\":[ { \"surgeryID\":null, \"surgeryType\":null, \"otherSurgeryType\":null, \"timePeriodAgo\":null, \"timePeriodUnit\":null } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"comorbidConditions\":{ \"comorbidityConcurrentConditionsList\":[ { \"comorbidConditions\":null, \"otherComorbidCondition\":null, \"timePeriodAgo\":null, \"timePeriodUnit\":null, \"isForHistory\":null } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"medicationHistory\":{ \"medicationHistoryList\":[ { \"currentMedication\":null, \"timePeriodAgo\":null, \"timePeriodUnit\":null } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"femaleObstetricHistory\":{ \"totalNoOfPreg\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\", \"femaleObstetricHistoryList\":[ ] }, \"menstrualHistory\":{ \"menstrualCycleStatus\":null, \"menstrualCycleStatusID\":null, \"regularity\":null, \"cycleLength\":null, \"menstrualCyclelengthID\":null, \"menstrualFlowDurationID\":null, \"bloodFlowDuration\":null, \"menstrualProblemID\":null, \"problemName\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"familyHistory\":{ \"familyDiseaseList\":[ { \"diseaseTypeID\":null, \"diseaseType\":null, \"otherDiseaseType\":null, \"familyMembers\":null } ], \"isGeneticDisorder\":null, \"geneticDisorder\":null, \"isConsanguineousMarrige\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"personalHistory\":{ \"dietaryType\":null, \"physicalActivityType\":null, \"riskySexualPracticesStatus\":0, \"tobaccoUseStatus\":null, \"alcoholIntakeStatus\":null, \"allergyStatus\":null, \"tobaccoList\":[ ], \"alcoholList\":[ ], \"allergicList\":[ ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"childVaccineDetails\":{ \"childOptionalVaccineList\":[ { \"vaccineName\":null, \"otherVaccineName\":null, \"actualReceivingAge\":null, \"receivedFacilityName\":null } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"immunizationHistory\":{ \"immunizationList\":[ { \"defaultReceivingAge\":\"At Birth\", \"vaccines\":[ { \"vaccine\":\"BCG\", \"status\":false }, { \"vaccine\":\"HBV-0\", \"status\":false }, { \"vaccine\":\"OPV-0\", \"status\":false } ] }, { \"defaultReceivingAge\":\"6 Weeks\", \"vaccines\":[ { \"vaccine\":\"IPV-1\", \"status\":false }, { \"vaccine\":\"OPV\", \"status\":false }, { \"vaccine\":\"Pentavalent-1\", \"status\":false }, { \"vaccine\":\"Rota Vaccine-1\", \"status\":false } ] }, { \"defaultReceivingAge\":\"10 Weeks\", \"vaccines\":[ { \"vaccine\":\"IPV-2\", \"status\":false }, { \"vaccine\":\"OPV\", \"status\":false }, { \"vaccine\":\"Pentavalent-2\", \"status\":false }, { \"vaccine\":\"Rota Vaccine-2\", \"status\":false } ] }, { \"defaultReceivingAge\":\"14 Weeks\", \"vaccines\":[ { \"vaccine\":\"IPV-3 \", \"status\":false }, { \"vaccine\":\"OPV\", \"status\":false }, { \"vaccine\":\"Pentavalent-3\", \"status\":false }, { \"vaccine\":\"Rota Vaccine-3\", \"status\":false } ] }, { \"defaultReceivingAge\":\"9 Months\", \"vaccines\":[ { \"vaccine\":\"JE Vaccine\", \"status\":false }, { \"vaccine\":\"Measles Vaccine/MR\", \"status\":false }, { \"vaccine\":\"Vitamin A\", \"status\":false } ] }, { \"defaultReceivingAge\":\"16-24 Months\", \"vaccines\":[ { \"vaccine\":\"DPT-B 1\", \"status\":false }, { \"vaccine\":\"Measles/MR Vaccine\", \"status\":false }, { \"vaccine\":\"OPV\", \"status\":false } ] }, { \"defaultReceivingAge\":\"5 Years\", \"vaccines\":[ { \"vaccine\":\"\", \"status\":false } ] }, { \"defaultReceivingAge\":\"10 Years\", \"vaccines\":[ { \"vaccine\":\"TT\", \"status\":false } ] }, { \"defaultReceivingAge\":\"16 Years\", \"vaccines\":[ { \"vaccine\":\"TT\", \"status\":false } ] } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"developmentHistory\":{ \"grossMotorMilestones\":null, \"fineMotorMilestones\":null, \"socialMilestones\":null, \"languageMilestones\":null, \"developmentalProblems\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"feedingHistory\":{ \"typeOfFeed\":null, \"compFeedStartAge\":null, \"noOfCompFeedPerDay\":null, \"foodIntoleranceStatus\":0, \"typeofFoodIntolerance\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"perinatalHistroy\":{ \"deliveryPlaceID\":null, \"placeOfDelivery\":null, \"otherPlaceOfDelivery\":null, \"deliveryTypeID\":null, \"typeOfDelivery\":null, \"complicationAtBirthID\":null, \"complicationAtBirth\":null, \"otherComplicationAtBirth\":null, \"gestation\":null, \"birthWeight_kg\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" } }, \"examinationDetails\":{ \"generalExamination\":{ \"consciousness\":null, \"coherence\":null, \"cooperation\":null, \"comfortness\":null, \"builtAndAppearance\":null, \"gait\":null, \"dangerSigns\":null, \"typeOfDangerSigns\":null, \"pallor\":null, \"jaundice\":null, \"cyanosis\":null, \"clubbing\":null, \"lymphadenopathy\":null, \"lymphnodesInvolved\":null, \"typeOfLymphadenopathy\":null, \"edema\":null, \"extentOfEdema\":null, \"edemaType\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"headToToeExamination\":{ \"headtoToeExam\":null, \"head\":null, \"eyes\":null, \"ears\":null, \"nose\":null, \"oralCavity\":null, \"throat\":null, \"breastAndNipples\":null, \"trunk\":null, \"upperLimbs\":null, \"lowerLimbs\":null, \"skin\":null, \"hair\":null, \"nails\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"gastroIntestinalExamination\":{ \"inspection\":null, \"palpation_AbdomenTexture\":null, \"palpation_Liver\":null, \"palpation_Spleen\":null, \"palpation_Tenderness\":null, \"palpation_LocationOfTenderness\":null, \"percussion\":null, \"auscultation\":null, \"analRegion\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"cardioVascularExamination\":{ \"jugularVenousPulse_JVP\":null, \"apexbeatLocation\":null, \"apexbeatType\":null, \"firstHeartSound_S1\":null, \"secondHeartSound_S2\":null, \"additionalHeartSounds\":null, \"murmurs\":null, \"pericardialRub\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"respiratorySystemExamination\":{ \"trachea\":null, \"inspection\":null, \"signsOfRespiratoryDistress\":null, \"palpation\":null, \"auscultation_Stridor\":null, \"auscultation_BreathSounds\":null, \"auscultation_Crepitations\":null, \"auscultation_Wheezing\":null, \"auscultation_PleuralRub\":null, \"auscultation_ConductedSounds\":null, \"percussion\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"centralNervousSystemExamination\":{ \"handedness\":null, \"cranialNervesExamination\":null, \"motorSystem\":null, \"sensorySystem\":null, \"autonomicSystem\":null, \"cerebellarSigns\":null, \"signsOfMeningealIrritation\":null, \"skull\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"musculoskeletalSystemExamination\":{ \"joint_TypeOfJoint\":null, \"joint_Laterality\":null, \"joint_Abnormality\":null, \"upperLimb_Laterality\":null, \"upperLimb_Abnormality\":null, \"lowerLimb_Laterality\":null, \"lowerLimb_Abnormality\":null, \"chestWall\":null, \"spine\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"genitoUrinarySystemExamination\":{ \"renalAngle\":null, \"suprapubicRegion\":null, \"externalGenitalia\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" } } }"; 
		
		jsnOBJPve = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObjPve);
		jsnOBJPve = jsnElmnt.getAsJsonObject();
		
		
		jsnOBJNve = new JsonObject();
		JsonElement jsnElmntNve = jsnParser.parse(requestObjNve);
		jsnOBJNve = jsnElmntNve.getAsJsonObject();
		
		try {
			when(registrarRepoBenData.updateBenFlowStatus('N', 7469L)).thenReturn(1);
			/*Mocking Visit Details Repo's*/
			//when(commonNurseServiceImpl.saveBeneficiaryVisitDetails(isA(BeneficiaryVisitDetail.class))).thenReturn(1L);
			
			BeneficiaryVisitDetail beneficiaryVisitDetail = spy(BeneficiaryVisitDetail.class);
			beneficiaryVisitDetail.setBenVisitID(1L);
			when(benVisitDetailRepoMock.save(isA(BeneficiaryVisitDetail.class))).thenReturn(beneficiaryVisitDetail);
			
			/*BenChiefComplaint benChiefComplaint = new BenChiefComplaint();
			benChiefComplaint.setBenChiefComplaintID(1L);
			List<BenChiefComplaint> res = new ArrayList<BenChiefComplaint>();
			res.add(benChiefComplaint);*/
			when(benChiefComplaintRepoMock.save(isA(BenChiefComplaint.class))).thenReturn(mock(BenChiefComplaint.class));
			
			/*Mocking History Repo's*/
			BenMedHistory benMedHistory = spy(BenMedHistory.class);
			benMedHistory.setBenMedHistoryID(1L);
			List<BenMedHistory> res = new ArrayList<BenMedHistory>();
			res.add(benMedHistory);
			when(benMedHistoryRepoMock.save(Matchers.anyListOf(BenMedHistory.class))).thenReturn(res);
			
			BencomrbidityCondDetails bencomrbidityCondDetails = spy(BencomrbidityCondDetails.class);
			bencomrbidityCondDetails.setID(1L);
			List<BencomrbidityCondDetails> comorbidRes =  new ArrayList<BencomrbidityCondDetails>();
			comorbidRes.add(bencomrbidityCondDetails);
			when(bencomrbidityCondRepoMock.save(Matchers.anyListOf(BencomrbidityCondDetails.class))).thenReturn(comorbidRes);
			
			BenMedicationHistory benMedicationHistory = spy(BenMedicationHistory.class);
			benMedicationHistory.setID(1L);
			List<BenMedicationHistory> medRes =  new ArrayList<BenMedicationHistory>();
			medRes.add(benMedicationHistory);
			when(benMedicationHistoryRepoMock.save(Matchers.anyListOf(BenMedicationHistory.class))).thenReturn(medRes);
			
			FemaleObstetricHistory femaleObstetricHistory = spy(FemaleObstetricHistory.class);
			femaleObstetricHistory.setObstetricHistoryID(1L);
			List<FemaleObstetricHistory> femaleObsRes =  new ArrayList<FemaleObstetricHistory>();
			femaleObsRes.add(femaleObstetricHistory);
			when(femaleObstetricHistoryRepoMock.save(Matchers.anyListOf(FemaleObstetricHistory.class))).thenReturn(femaleObsRes);
			
			BenMenstrualDetails benMenstrualDetails=spy(BenMenstrualDetails.class);
			benMenstrualDetails.setBenMenstrualID(1);
			when(benMenstrualDetailsRepoMock.save(isA(BenMenstrualDetails.class))).thenReturn(benMenstrualDetails);
			
			BenFamilyHistory benFamilyHistory = spy(BenFamilyHistory.class);
			benFamilyHistory.setID(1L);
			List<BenFamilyHistory> familyRes =  new ArrayList<BenFamilyHistory>();
			familyRes.add(benFamilyHistory);
			when(benFamilyHistoryRepoMock.save(Matchers.anyListOf(BenFamilyHistory.class))).thenReturn(familyRes);
			
			BenPersonalHabit benPersonalHabit = spy(BenPersonalHabit.class);
			benPersonalHabit.setBenPersonalHabitID(1);
			List<BenPersonalHabit> habitRes =  new ArrayList<BenPersonalHabit>();
			habitRes.add(benPersonalHabit);
			when(benPersonalHabitRepoMock.save(Matchers.anyListOf(BenPersonalHabit.class))).thenReturn(habitRes);
			
			BenAllergyHistory benAllergyHistory = spy(BenAllergyHistory.class);
			benAllergyHistory.setID(1L);
			List<BenAllergyHistory> allergyRes =  new ArrayList<BenAllergyHistory>();
			allergyRes.add(benAllergyHistory);
			when(benAllergyHistoryRepoMock.save(Matchers.anyListOf(BenAllergyHistory.class))).thenReturn(allergyRes);
			
			ChildOptionalVaccineDetail optionalVaccineDetail = spy(ChildOptionalVaccineDetail.class);
			optionalVaccineDetail.setID(1L);
			List<ChildOptionalVaccineDetail> vaccineRes =  new ArrayList<ChildOptionalVaccineDetail>();
			vaccineRes.add(optionalVaccineDetail);
			when(childOptionalVaccineDetailRepoMock.save(Matchers.anyListOf(ChildOptionalVaccineDetail.class))).thenReturn(vaccineRes);
			
			ChildVaccineDetail1 childVaccineDetail1 = spy(ChildVaccineDetail1.class);
			childVaccineDetail1.setID(1L);
			List<ChildVaccineDetail1> childVaccineRes =  new ArrayList<ChildVaccineDetail1>();
			childVaccineRes.add(childVaccineDetail1);
			when(childVaccineDetail1RepoMock.save(Matchers.anyListOf(ChildVaccineDetail1.class))).thenReturn(childVaccineRes);
			
			BenChildDevelopmentHistory dvmtHsry= spy(BenChildDevelopmentHistory.class);
			dvmtHsry.setID(1L);
			when(benChildDevelopmentHistoryRepoMock.save(isA(BenChildDevelopmentHistory.class))).thenReturn(dvmtHsry);
			
			ChildFeedingDetails feedingHistry= spy(ChildFeedingDetails.class);
			feedingHistry.setID(1L);
			when(childFeedingDetailsRepoMock.save(isA(ChildFeedingDetails.class))).thenReturn(feedingHistry);
			
			PerinatalHistory perinatalHistry = spy(PerinatalHistory.class);
			perinatalHistry.setID(1L);
			when(perinatalHistoryRepoMock.save(isA(PerinatalHistory.class))).thenReturn(perinatalHistry);
			
			/*if (jsnOBJPve != null && jsnOBJPve.has("visitDetails") && !jsnOBJPve.get("visitDetails").isJsonNull()) {
				JsonObject visitDetailsOBJ = jsnOBJPve.getAsJsonObject("visitDetails");
				if (visitDetailsOBJ != null && visitDetailsOBJ.has("visitDetails")
						&& !visitDetailsOBJ.get("visitDetails").isJsonNull()) {
					// Save Beneficiary visit details
					BeneficiaryVisitDetail benVisitDetailsOBJ = InputMapper.gson().fromJson(visitDetailsOBJ.get("visitDetails"),
							BeneficiaryVisitDetail.class);
					
					when(commonNurseServiceImpl.saveBeneficiaryVisitDetails(benVisitDetailsOBJ)).thenReturn(1L);
				}
			}
			BenChiefComplaint benChiefComplaint = mock(BenChiefComplaint.class);
			List benChiefComplaintList = new ArrayList<BenChiefComplaint>();
			benChiefComplaintList.add(benChiefComplaint);
			when(commonNurseServiceImpl.saveBenChiefComplaints(benChiefComplaintList)).thenReturn(1);
			
			Mocking for HistoryDetails Internal Methods
			BenMedHistory benMedHistory = mock(BenMedHistory.class);
			when(commonNurseServiceImpl.saveBenPastHistory(benMedHistory)).thenReturn(1L);
			
			WrapperComorbidCondDetails wrapperComorbidCondDetails = mock(WrapperComorbidCondDetails.class);
			when(commonNurseServiceImpl.saveBenComorbidConditions(wrapperComorbidCondDetails)).thenReturn(1L);
			
			WrapperMedicationHistory wrapperMedicationHistory = mock(WrapperMedicationHistory.class);
			when(commonNurseServiceImpl.saveBenMedicationHistory(wrapperMedicationHistory)).thenReturn(1L);
			
			WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory =  mock(WrapperFemaleObstetricHistory.class);
			when(commonNurseServiceImpl.saveFemaleObstetricHistory(wrapperFemaleObstetricHistory)).thenReturn(1L);
			
			BenMenstrualDetails menstrualDetails = mock(BenMenstrualDetails.class);
			when(commonNurseServiceImpl.saveBenMenstrualHistory(menstrualDetails)).thenReturn(1);
			
			BenFamilyHistory benFamilyHistory = mock(BenFamilyHistory.class); 
			when(commonNurseServiceImpl.saveBenFamilyHistory(benFamilyHistory)).thenReturn(1L);
			
			BenPersonalHabit personalHabit =  mock(BenPersonalHabit.class);
			when(commonNurseServiceImpl.savePersonalHistory(personalHabit)).thenReturn(1);
			
			BenAllergyHistory benAllergyHistory =  mock(BenAllergyHistory.class);
			when(commonNurseServiceImpl.saveAllergyHistory(benAllergyHistory)).thenReturn(1L);
			
			WrapperChildOptionalVaccineDetail wrapperChildVaccineDetail = mock(WrapperChildOptionalVaccineDetail.class);
			when(commonNurseServiceImpl.saveChildOptionalVaccineDetail(wrapperChildVaccineDetail)).thenReturn(1L);
			
			WrapperImmunizationHistory wrapperImmunizationHistory =  mock(WrapperImmunizationHistory.class);
			when(commonNurseServiceImpl.saveImmunizationHistory(wrapperImmunizationHistory)).thenReturn(1L);
			
			BenChildDevelopmentHistory benChildDevelopmentHistory =  mock(BenChildDevelopmentHistory.class);
			when(generalOPDNurseServiceImplMock.saveChildDevelopmentHistory(benChildDevelopmentHistory)).thenReturn(1L);
			
			ChildFeedingDetails childFeedingDetails =  mock(ChildFeedingDetails.class);
			when(generalOPDNurseServiceImplMock.saveChildFeedingHistory(childFeedingDetails)).thenReturn(1L);
			
			PerinatalHistory perinatalHistory =  mock(PerinatalHistory.class);
			when(generalOPDNurseServiceImplMock.savePerinatalHistory(perinatalHistory)).thenReturn(1L);*/
			
			/*Mocking Vital Repo's*/
			BenAnthropometryDetail benAnthropometryDetail = spy(BenAnthropometryDetail.class);
			benAnthropometryDetail.setID(1L);
			when(benAnthropometryRepoMock.save(isA(BenAnthropometryDetail.class))).thenReturn(benAnthropometryDetail);
			
			BenPhysicalVitalDetail benPhysicalVitalDetail = spy(BenPhysicalVitalDetail.class);
			benPhysicalVitalDetail.setID(1L);
			when(benPhysicalVitalRepoMock.save(isA(BenPhysicalVitalDetail.class))).thenReturn(benPhysicalVitalDetail);
			
			/*Mocking Examination Repo's*/
			PhyGeneralExamination phyGeneralExamination = spy(PhyGeneralExamination.class);
			phyGeneralExamination.setID(1L);
			when(phyGeneralExaminationRepoMock.save(isA(PhyGeneralExamination.class))).thenReturn(phyGeneralExamination);
			
			PhyHeadToToeExamination phyHeadToToeExamination = spy(PhyHeadToToeExamination.class);
			phyHeadToToeExamination.setID(1L);
			when(phyHeadToToeExaminationRepoMock.save(isA(PhyHeadToToeExamination.class))).thenReturn(phyHeadToToeExamination);
			
			SysGastrointestinalExamination sysGastrointestinalExamination = spy(SysGastrointestinalExamination.class);
			sysGastrointestinalExamination.setID(1L);
			when(sysGastrointestinalExaminationRepoMock.save(isA(SysGastrointestinalExamination.class))).thenReturn(sysGastrointestinalExamination);
			
			SysCardiovascularExamination sysCardiovascularExamination = spy(SysCardiovascularExamination.class);
			sysCardiovascularExamination.setID(1L);
			when(sysCardiovascularExaminationRepoMock.save(isA(SysCardiovascularExamination.class))).thenReturn(sysCardiovascularExamination);
			
			SysRespiratoryExamination sysRespiratoryExamination = spy(SysRespiratoryExamination.class);
			sysRespiratoryExamination.setID(1L);
			when(sysRespiratoryExaminationRepoMock.save(isA(SysRespiratoryExamination.class))).thenReturn(sysRespiratoryExamination);
			
			SysCentralNervousExamination sysCentralNervousExamination = spy(SysCentralNervousExamination.class);
			sysCentralNervousExamination.setID(1L);
			when(sysCentralNervousExaminationRepoMock.save(isA(SysCentralNervousExamination.class))).thenReturn(sysCentralNervousExamination);
			
			SysMusculoskeletalSystemExamination sysMusculoskeletalSystemExamination = spy(SysMusculoskeletalSystemExamination.class);
			sysMusculoskeletalSystemExamination.setID(1L);
			when(sysMusculoskeletalSystemExaminationRepoMock.save(isA(SysMusculoskeletalSystemExamination.class))).thenReturn(sysMusculoskeletalSystemExamination);
			
			SysGenitourinarySystemExamination  sysGenitourinarySystemExamination = spy(SysGenitourinarySystemExamination.class);
			sysGenitourinarySystemExamination.setID(1L);
			when(sysGenitourinarySystemExaminationRepoMock.save(isA(SysGenitourinarySystemExamination.class))).thenReturn(sysGenitourinarySystemExamination);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void saveGOPDNurseDataPveTest() {

		Long response = null;
		try {
			response = generalOPDServiceImpl.saveNurseData(jsnOBJPve);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertThat(response).isEqualTo(1);
	}

	@Test
	public void saveGOPDNurseDataNveTest() {

		Long response = null;
		try {
			response = generalOPDServiceImpl.saveNurseData(jsnOBJNve);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertThat(response).isEqualTo(null);
		
		//assertEquals(1, response);
	}
}
