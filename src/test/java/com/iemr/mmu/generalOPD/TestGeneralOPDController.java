package com.iemr.mmu.generalOPD;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.controller.generalOPD.GeneralOPDCreateController;
import com.iemr.mmu.controller.generalOPD.GeneralOPDUpdateController;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.generalOPD.GeneralOPDServiceImpl;

public class TestGeneralOPDController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@InjectMocks
	private static GeneralOPDCreateController createControllerMock = spy(GeneralOPDCreateController.class);
	private static GeneralOPDUpdateController updateControllerMock = spy(GeneralOPDUpdateController.class);
	private static GeneralOPDServiceImpl generalOPDServiceImplMock = mock(GeneralOPDServiceImpl.class);
	
	static String nurseObjPve=  "";
	static JsonObject nurseJsnOBJPve;
	static String nurseObjNve =  "";
	static JsonObject nurseJsnOBJNve;
	
	static String doctorObjPve=  "";
	static JsonObject doctorJsnOBJPve;
	static String doctorObjNve =  "";
	static JsonObject doctorJsnOBJNve;
	
	@BeforeClass
	public static void initializeParams(){
		
		createControllerMock.setGeneralOPDServiceImpl(generalOPDServiceImplMock);
		updateControllerMock.setGeneralOPDServiceImpl(generalOPDServiceImplMock);
		
		nurseObjPve = "{\"visitDetails\":{ \"visitDetails\":{ \"beneficiaryRegID\":\"7469\", \"providerServiceMapID\":\"1320\", \"visitNo\":null, \"visitReason\":\"FollowUp\", \"visitCategory\":\"General OPD\", \"pregnancyStatus\":null, \"rCHID\":null, \"healthFacilityType\":null, \"healthFacilityLocation\":null, \"reportFilePath\":null, \"createdBy\":\"891\" }, \"chiefComplaints\":[ { \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"chiefComplaint\":null, \"chiefComplaintID\":null, \"duration\":null, \"unitOfDuration\":null, \"description\":null, \"createdBy\":\"891\" } ] }, \"vitalDetails\":{ \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"weight_Kg\":null, \"height_cm\":null, \"waistCircumference_cm\":null, \"hipCircumference_cm\":null, \"bMI\":null, \"waistHipRatio\":null, \"temperature\":null, \"pulseRate\":null, \"systolicBP_1stReading\":null, \"diastolicBP_1stReading\":null, \"bloodGlucose_Fasting\":null, \"bloodGlucose_Random\":null, \"bloodGlucose_2hr_PP\":null, \"respiratoryRate\":null, \"createdBy\":\"891\" }, \"historyDetails\":{ \"pastHistory\":{ \"pastIllness\":[ { \"illnessTypeID\":null, \"illnessType\":null, \"otherIllnessType\":null, \"timePeriodAgo\":null, \"timePeriodUnit\":null } ], \"pastSurgery\":[ { \"surgeryID\":null, \"surgeryType\":null, \"otherSurgeryType\":null, \"timePeriodAgo\":null, \"timePeriodUnit\":null } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"comorbidConditions\":{ \"comorbidityConcurrentConditionsList\":[ { \"comorbidConditions\":null, \"otherComorbidCondition\":null, \"timePeriodAgo\":null, \"timePeriodUnit\":null, \"isForHistory\":null } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"medicationHistory\":{ \"medicationHistoryList\":[ { \"currentMedication\":null, \"timePeriodAgo\":null, \"timePeriodUnit\":null } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"femaleObstetricHistory\":{ \"totalNoOfPreg\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\", \"femaleObstetricHistoryList\":[ ] }, \"menstrualHistory\":{ \"menstrualCycleStatus\":null, \"menstrualCycleStatusID\":null, \"regularity\":null, \"cycleLength\":null, \"menstrualCyclelengthID\":null, \"menstrualFlowDurationID\":null, \"bloodFlowDuration\":null, \"menstrualProblemID\":null, \"problemName\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"familyHistory\":{ \"familyDiseaseList\":[ { \"diseaseTypeID\":null, \"diseaseType\":null, \"otherDiseaseType\":null, \"familyMembers\":null } ], \"isGeneticDisorder\":null, \"geneticDisorder\":null, \"isConsanguineousMarrige\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"personalHistory\":{ \"dietaryType\":null, \"physicalActivityType\":null, \"riskySexualPracticesStatus\":0, \"tobaccoUseStatus\":null, \"alcoholIntakeStatus\":null, \"allergyStatus\":null, \"tobaccoList\":[ ], \"alcoholList\":[ ], \"allergicList\":[ ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"childVaccineDetails\":{ \"childOptionalVaccineList\":[ { \"vaccineName\":null, \"otherVaccineName\":null, \"actualReceivingAge\":null, \"receivedFacilityName\":null } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"immunizationHistory\":{ \"immunizationList\":[ { \"defaultReceivingAge\":\"At Birth\", \"vaccines\":[ { \"vaccine\":\"BCG\", \"status\":false }, { \"vaccine\":\"HBV-0\", \"status\":false }, { \"vaccine\":\"OPV-0\", \"status\":false } ] }, { \"defaultReceivingAge\":\"6 Weeks\", \"vaccines\":[ { \"vaccine\":\"IPV-1\", \"status\":false }, { \"vaccine\":\"OPV\", \"status\":false }, { \"vaccine\":\"Pentavalent-1\", \"status\":false }, { \"vaccine\":\"Rota Vaccine-1\", \"status\":false } ] }, { \"defaultReceivingAge\":\"10 Weeks\", \"vaccines\":[ { \"vaccine\":\"IPV-2\", \"status\":false }, { \"vaccine\":\"OPV\", \"status\":false }, { \"vaccine\":\"Pentavalent-2\", \"status\":false }, { \"vaccine\":\"Rota Vaccine-2\", \"status\":false } ] }, { \"defaultReceivingAge\":\"14 Weeks\", \"vaccines\":[ { \"vaccine\":\"IPV-3 \", \"status\":false }, { \"vaccine\":\"OPV\", \"status\":false }, { \"vaccine\":\"Pentavalent-3\", \"status\":false }, { \"vaccine\":\"Rota Vaccine-3\", \"status\":false } ] }, { \"defaultReceivingAge\":\"9 Months\", \"vaccines\":[ { \"vaccine\":\"JE Vaccine\", \"status\":false }, { \"vaccine\":\"Measles Vaccine/MR\", \"status\":false }, { \"vaccine\":\"Vitamin A\", \"status\":false } ] }, { \"defaultReceivingAge\":\"16-24 Months\", \"vaccines\":[ { \"vaccine\":\"DPT-B 1\", \"status\":false }, { \"vaccine\":\"Measles/MR Vaccine\", \"status\":false }, { \"vaccine\":\"OPV\", \"status\":false } ] }, { \"defaultReceivingAge\":\"5 Years\", \"vaccines\":[ { \"vaccine\":\"\", \"status\":false } ] }, { \"defaultReceivingAge\":\"10 Years\", \"vaccines\":[ { \"vaccine\":\"TT\", \"status\":false } ] }, { \"defaultReceivingAge\":\"16 Years\", \"vaccines\":[ { \"vaccine\":\"TT\", \"status\":false } ] } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"developmentHistory\":{ \"grossMotorMilestones\":null, \"fineMotorMilestones\":null, \"socialMilestones\":null, \"languageMilestones\":null, \"developmentalProblems\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"feedingHistory\":{ \"typeOfFeed\":null, \"compFeedStartAge\":null, \"noOfCompFeedPerDay\":null, \"foodIntoleranceStatus\":0, \"typeofFoodIntolerance\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"perinatalHistroy\":{ \"deliveryPlaceID\":null, \"placeOfDelivery\":null, \"otherPlaceOfDelivery\":null, \"deliveryTypeID\":null, \"typeOfDelivery\":null, \"complicationAtBirthID\":null, \"complicationAtBirth\":null, \"otherComplicationAtBirth\":null, \"gestation\":null, \"birthWeight_kg\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" } }, \"examinationDetails\":{ \"generalExamination\":{ \"consciousness\":null, \"coherence\":null, \"cooperation\":null, \"comfortness\":null, \"builtAndAppearance\":null, \"gait\":null, \"dangerSigns\":null, \"typeOfDangerSigns\":null, \"pallor\":null, \"jaundice\":null, \"cyanosis\":null, \"clubbing\":null, \"lymphadenopathy\":null, \"lymphnodesInvolved\":null, \"typeOfLymphadenopathy\":null, \"edema\":null, \"extentOfEdema\":null, \"edemaType\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"headToToeExamination\":{ \"headtoToeExam\":null, \"head\":null, \"eyes\":null, \"ears\":null, \"nose\":null, \"oralCavity\":null, \"throat\":null, \"breastAndNipples\":null, \"trunk\":null, \"upperLimbs\":null, \"lowerLimbs\":null, \"skin\":null, \"hair\":null, \"nails\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"gastroIntestinalExamination\":{ \"inspection\":null, \"palpation_AbdomenTexture\":null, \"palpation_Liver\":null, \"palpation_Spleen\":null, \"palpation_Tenderness\":null, \"palpation_LocationOfTenderness\":null, \"percussion\":null, \"auscultation\":null, \"analRegion\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"cardioVascularExamination\":{ \"jugularVenousPulse_JVP\":null, \"apexbeatLocation\":null, \"apexbeatType\":null, \"firstHeartSound_S1\":null, \"secondHeartSound_S2\":null, \"additionalHeartSounds\":null, \"murmurs\":null, \"pericardialRub\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"respiratorySystemExamination\":{ \"trachea\":null, \"inspection\":null, \"signsOfRespiratoryDistress\":null, \"palpation\":null, \"auscultation_Stridor\":null, \"auscultation_BreathSounds\":null, \"auscultation_Crepitations\":null, \"auscultation_Wheezing\":null, \"auscultation_PleuralRub\":null, \"auscultation_ConductedSounds\":null, \"percussion\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"centralNervousSystemExamination\":{ \"handedness\":null, \"cranialNervesExamination\":null, \"motorSystem\":null, \"sensorySystem\":null, \"autonomicSystem\":null, \"cerebellarSigns\":null, \"signsOfMeningealIrritation\":null, \"skull\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"musculoskeletalSystemExamination\":{ \"joint_TypeOfJoint\":null, \"joint_Laterality\":null, \"joint_Abnormality\":null, \"upperLimb_Laterality\":null, \"upperLimb_Abnormality\":null, \"lowerLimb_Laterality\":null, \"lowerLimb_Abnormality\":null, \"chestWall\":null, \"spine\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" }, \"genitoUrinarySystemExamination\":{ \"renalAngle\":null, \"suprapubicRegion\":null, \"externalGenitalia\":null, \"beneficiaryRegID\":\"7469\", \"benVisitID\":null, \"providerServiceMapID\":\"1320\", \"createdBy\":\"891\" } } }";
		nurseObjNve = "{}";
		
		doctorObjPve = "{ \"findings\":{ \"beneficiaryRegID\":\"7469\", \"benVisitID\":\"846\", \"providerServiceMapID\":\"1320\", \"clinicalObservation\":\"Lorem Ipsum is simply dummy text\", \"otherSymptoms\":\"Lorem Ipsum is simply dummy text\", \"significantFindings\":\"Lorem Ipsum \", \"complaints\":[ { \"chiefComplaint\":\"Abdominal Bloating\", \"chiefComplaintID\":1, \"duration\":\"23\", \"unitOfDuration\":\"Hours\", \"description\":\"Lorem Ipsum is simply dummy text\" }, { \"chiefComplaint\":\"Abdominal Distention\", \"chiefComplaintID\":5, \"duration\":\"24\", \"unitOfDuration\":\"Hours\", \"description\":\"Lorem Ipsum is simply dummy text\" } ], \"createdBy\":\"888\" }, \"diagnosis\":{ \"provisionalDiagnosis\":\"Lorem Ipsum is simply dummy text\", \"specialistAdvice\":\"Lorem Ipsum is simply dummy text\", \"beneficiaryRegID\":\"7469\", \"benVisitID\":\"846\", \"providerServiceMapID\":\"1320\", \"createdBy\":\"888\" }, \"investigation\":{ \"externalInvestigation\":\"Lorem Ipsum is simply dummy text\", \"beneficiaryRegID\":\"7469\", \"benVisitID\":\"846\", \"providerServiceMapID\":\"1320\", \"createdBy\":\"888\", \"laboratoryList\":[ { \"testID\":2, \"testName\":\"Blood Glucose Measurement\", \"isRadiologyImaging\":false }, { \"testID\":12, \"testName\":\"Blood grouping and Rh typing \", \"isRadiologyImaging\":false }, { \"testID\":17, \"testName\":\"BUN, Creatinine, Uric acid\", \"isRadiologyImaging\":false }, { \"testID\":29, \"testName\":\"CT Brain\", \"isRadiologyImaging\":true }, { \"testID\":30, \"testName\":\"CT Whole Spine \", \"isRadiologyImaging\":true }, { \"testID\":33, \"testName\":\"Flouroscopy- Urethrogram \", \"isRadiologyImaging\":true } ] }, \"prescription\":{ \"prescribedDrugs\":[ { \"specialInstruction\":\"After Food\", \"genericDrugName\":\"Glimepride Tablets IP 1mg\", \"dose\":\"Days \", \"frequency\":\"Once Daily(OD)\", \"drugForm\":\"Capsule\", \"drugDuration\":\"2\", \"qih\":10 }, { \"specialInstruction\":\"After Food\", \"genericDrugName\":\"Metformin Tablets IP 500 mg\", \"dose\":\"Days \", \"frequency\":\"Once Daily(OD)\", \"drugForm\":\"Capsule\", \"drugDuration\":\"2\", \"qih\":3 } ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":\"846\", \"providerServiceMapID\":\"1320\", \"createdBy\":\"888\" }, \"refer\":{ \"referredToInstituteID\":null, \"refrredToAdditionalServiceList\":[ 3, 1, 5 ], \"beneficiaryRegID\":\"7469\", \"benVisitID\":\"846\", \"providerServiceMapID\":\"1320\", \"createdBy\":\"888\" } }";
		doctorObjNve = "{}";
		
		nurseJsnOBJPve = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(nurseObjPve);
		nurseJsnOBJPve = jsnElmnt.getAsJsonObject();
		
		doctorJsnOBJPve = new JsonObject();
		JsonElement jsnElmnt2 = jsnParser.parse(doctorObjPve);
		doctorJsnOBJPve = jsnElmnt2.getAsJsonObject();
		
		try {
			when(generalOPDServiceImplMock.saveNurseData(nurseJsnOBJPve)).thenReturn(new Long(1L));
			
			when(generalOPDServiceImplMock.saveDoctorData(doctorJsnOBJPve)).thenReturn(new Long(1L));
			
			when(generalOPDServiceImplMock.updateBenHistoryDetails(nurseJsnOBJPve)).thenReturn(1);
			
			when(generalOPDServiceImplMock.updateBenVitalDetails(nurseJsnOBJPve)).thenReturn(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Before
	public void initialize() {
		
	}
	
	@Test
	public void  saveGOPDNurseDataPveTest(){
		
		String response = createControllerMock.saveBenGenOPDNurseData(nurseObjPve);
		
		assertTrue("",
				response.equals("{\"data\":{\"response\":\"General OPD Nurse Entered Details stored successfully.\"},\"statusCode\":200,"
						+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
	}
	
	
	@Test
	public void  saveGOPDNurseDataNveTest(){
		
		String response = createControllerMock.saveBenGenOPDNurseData(nurseObjNve);
		
		assertTrue("",
				response.equals("{\"data\":{\"response\":\"Failed to store General OPD Details.\"},\"statusCode\":200,"
						+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
	}
	
	
	@Test
	public void  saveGOPDDoctorDataPveTest(){
		
		String response = createControllerMock.saveBenGenOPDDoctorData(doctorObjPve);
		
		assertTrue("",
				response.equals("{\"data\":{\"response\":\"General OPD doctor Entered Details stored successfully.\"},\"statusCode\":200,"
						+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
	}
	
	@Test
	public void  saveGOPDDoctorDataNveTest(){
		
		String response = createControllerMock.saveBenGenOPDDoctorData(doctorObjNve);
		
		assertTrue("",
				response.equals("{\"data\":{\"response\":\"Failed to store General OPD doctor Details.\"},\"statusCode\":200,"
						+ "\"errorMessage\":\"Success\",\"status\":\"Success\"}"));
	}
	
	@Test
	public void  updateHistoryNursePveTest(){
		String expectedRes = "{\"data\":{\"result\":1},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
		String response = updateControllerMock.updateHistoryNurse(nurseObjPve);
		
		System.out.println("response " +response);
		assertTrue("",
				response.equals(expectedRes));
	}
	
	@Test
	public void  updateHistoryNurseNveTest(){
		String expectedRes = "{\"statusCode\":500,\"errorMessage\":\"Failed to update General OPD History Nurse Data\","
				+ "\"status\":\"Failed to update General OPD History Nurse Data\"}";
		String response = updateControllerMock.updateHistoryNurse(nurseObjNve);
		
		System.out.println("response " +response);
		assertTrue("",
				response.equals(expectedRes));
	}
	
	@Test
	public void  updateVitalNursePveTest(){
		String expectedRes = "{\"data\":{\"result\":1},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}";
		String response = updateControllerMock.updateVitalNurse(nurseObjPve);
		
		System.out.println("response " +response);
		assertTrue("",
				response.equals(expectedRes));
	}
	
}
