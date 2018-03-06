package com.iemr.mmu.cancerScreening;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Matchers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.data.anc.BenChildDevelopmentHistory;
import com.iemr.mmu.data.anc.BenFamilyHistory;
import com.iemr.mmu.data.anc.BenMedHistory;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.repo.doctor.CancerAbdominalExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerBreastExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerExaminationImageAnnotationRepo;
import com.iemr.mmu.repo.doctor.CancerGynecologicalExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerLymphNodeExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerOralExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerSignAndSymptomsRepo;
import com.iemr.mmu.repo.nurse.BenCancerVitalDetailRepo;
import com.iemr.mmu.repo.nurse.BenFamilyCancerHistoryRepo;
import com.iemr.mmu.repo.nurse.BenObstetricCancerHistoryRepo;
import com.iemr.mmu.repo.nurse.BenPersonalCancerDietHistoryRepo;
import com.iemr.mmu.repo.nurse.BenPersonalCancerHistoryRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenData;
import com.iemr.mmu.service.cancerScreening.CSNurseServiceImpl;
import com.iemr.mmu.service.cancerScreening.CSServiceImpl;

public class TestCSServices
{
	private static CSServiceImpl cSServiceImpl = spy(CSServiceImpl.class);
	private static CSNurseServiceImpl cSNurseServiceImplMock = spy(CSNurseServiceImpl.class);
	private static BenVisitDetailRepo benVisitDetailRepoMock = mock(BenVisitDetailRepo.class);
	private static BenFamilyCancerHistoryRepo benFamilyCancerHistoryRepoMock = mock(BenFamilyCancerHistoryRepo.class);
	private static BenPersonalCancerHistoryRepo benPersonalCancerHistoryRepoMock = mock(BenPersonalCancerHistoryRepo.class);
	private static BenPersonalCancerDietHistoryRepo benPersonalCancerDietHistoryRepoMock = mock(BenPersonalCancerDietHistoryRepo.class);
	private static BenObstetricCancerHistoryRepo benObstetricCancerHistoryRepoMock = mock(BenObstetricCancerHistoryRepo.class);
	private static CancerSignAndSymptomsRepo cancerSignAndSymptomsRepoMock = mock(CancerSignAndSymptomsRepo.class);
	private static CancerLymphNodeExaminationRepo cancerLymphNodeExaminationRepoMock = mock(CancerLymphNodeExaminationRepo.class);
	private static CancerOralExaminationRepo cancerOralExaminationRepoMock = mock(CancerOralExaminationRepo.class);
	private static CancerBreastExaminationRepo cancerBreastExaminationRepoMock = mock(CancerBreastExaminationRepo.class);
	private static CancerAbdominalExaminationRepo cancerAbdominalExaminationRepoMock = mock(CancerAbdominalExaminationRepo.class);
	private static CancerGynecologicalExaminationRepo cancerGynecologicalExaminationRepoMock = mock(CancerGynecologicalExaminationRepo.class);
	private static CancerExaminationImageAnnotationRepo cancerExaminationImageAnnotationRepoMock = mock(CancerExaminationImageAnnotationRepo.class);
	private static BenCancerVitalDetailRepo benCancerVitalDetailRepoMock = mock(BenCancerVitalDetailRepo.class);
	private static RegistrarRepoBenData registrarRepoBenData = mock(RegistrarRepoBenData.class);
	
	static String nurseObjPve = "";
	public static JsonObject jsnOBJPve = null;
	
	@BeforeClass
	public static void initializeParams(){
		nurseObjPve = "{\"visitDetails\": { \"beneficiaryRegID\": \"7506\", \"providerServiceMapID\": \"1320\", \"visitNo\": null, \"visitReason\": \"Screening\", \"visitCategory\": \"Cancer Screening\", \"pregnancyStatus\": \"Yes\", \"rCHID\": \"7777\", \"healthFacilityType\": null, \"healthFacilityLocation\": null, \"reportFilePath\": null, \"createdBy\": \"888\" }, \"vitalsDetails\": { \"beneficiaryRegID\": \"7506\", \"benVisitID\": null, \"providerServiceMapID\": \"1320\", \"weight_Kg\": \"64\", \"height_cm\": \"166\", \"waistCircumference_cm\": \"56\", \"systolicBP_1stReading\": \"120\", \"diastolicBP_1stReading\": \"65\", \"systolicBP_2ndReading\": \"113\", \"diastolicBP_2ndReading\": \"73\", \"systolicBP_3rdReading\": \"123\", \"diastolicBP_3rdReading\": \"66\", \"hbA1C\": \"4\", \"hemoglobin\": \"14\", \"bloodGlucose_Fasting\": \"123\", \"bloodGlucose_Random\": \"143\", \"bloodGlucose_2HrPostPrandial\": \"145\", \"createdBy\": \"888\" }, \"examinationDetails\": { \"signsDetails\": { \"cancerSignAndSymptoms\": { \"shortnessOfBreath\": null, \"coughgt2Weeks\": true, \"bloodInSputum\": true, \"difficultyInOpeningMouth\": true, \"nonHealingUlcerOrPatchOrGrowth\": null, \"changeInTheToneOfVoice\": null, \"lumpInTheBreast\": null, \"bloodStainedDischargeFromNipple\": null, \"changeInShapeAndSizeOfBreasts\": null, \"vaginalBleedingBetweenPeriods\": null, \"vaginalBleedingAfterMenopause\": null, \"vaginalBleedingAfterIntercourse\": null, \"foulSmellingVaginalDischarge\": null, \"lymphNode_Enlarged\": true, \"breastEnlargement\": null, \"observation\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry\", \"beneficiaryRegID\": \"7506\", \"providerServiceMapID\": \"1320\", \"createdBy\": \"888\" }, \"cancerLymphNodeDetails\": [ { \"lymphNodeName\": \" Sub Mandibular\", \"size_Left\": \"3-6 cm\", \"mobility_Left\": true, \"size_Right\": \"3-6 cm\", \"mobility_Right\": true, \"beneficiaryRegID\": \"7506\", \"providerServiceMapID\": \"1320\", \"createdBy\": \"888\" } ] }, \"oralDetails\": { \"limitedMouthOpening\": \"+\", \"premalignantLesions\": true, \"preMalignantLesionTypeList\": [ \"Sub muscus fibrosis\" ], \"prolongedIrritation\": null, \"chronicBurningSensation\": null, \"observation\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry\", \"beneficiaryRegID\": \"7506\", \"providerServiceMapID\": \"1320\", \"createdBy\": \"888\" }, \"breastDetails\": { \"everBreastFed\": true, \"breastFeedingDurationGTE6months\": true, \"breastsAppear_Normal\": true, \"rashOnBreast\": null, \"dimplingSkinOnBreast\": true, \"dischargeFromNipple\": null, \"peaudOrange\": null, \"lumpInBreast\": null, \"lumpSize\": null, \"lumpShape\": null, \"lumpTexture\": null, \"referredToMammogram\": null, \"beneficiaryRegID\": \"7506\", \"providerServiceMapID\": \"1320\", \"createdBy\": \"888\" }, \"abdominalDetails\": { \"abdominalInspection_Normal\": true, \"liver\": \"Not palpable\", \"ascites_Present\": true, \"anyOtherMass_Present\": true, \"lymphNodes_Enlarged\": null, \"lymphNode_Inguinal_Left\": null, \"lymphNode_Inguinal_Right\": null, \"lymphNode_ExternalIliac_Left\": null, \"lymphNode_ExternalIliac_Right\": null, \"lymphNode_ParaAortic_Left\": null, \"lymphNode_ParaAortic_Right\": null, \"observation\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry\", \"beneficiaryRegID\": \"7506\", \"providerServiceMapID\": \"1320\", \"createdBy\": \"888\" }, \"gynecologicalDetails\": { \"appearanceOfCervix\": null, \"typeOfLesionList\": null, \"vulvalInvolvement\": null, \"vaginalInvolvement\": true, \"uterus_Normal\": true, \"sufferedFromRTIOrSTI\": null, \"rTIOrSTIDetail\": null, \"filePath\": null, \"experiencedPostCoitalBleeding\": null, \"observation\": \"Lorem Ipsum is simply dummy text of the printing and typesetting industry\", \"beneficiaryRegID\": \"7506\", \"providerServiceMapID\": \"1320\", \"createdBy\": \"888\" }, \"imageCoordinates\": [ { \"beneficiaryRegID\": \"7506\", \"visitID\": null, \"createdBy\": \"888\", \"imageID\": 3, \"providerServiceMapID\": \"1320\", \"markers\": [ { \"xCord\": 97, \"yCord\": 174, \"description\": \"one\", \"point\": 1 } ] }, { \"beneficiaryRegID\": \"7506\", \"visitID\": null, \"createdBy\": \"888\", \"imageID\": 1, \"providerServiceMapID\": \"1320\", \"markers\": [ { \"xCord\": 146, \"yCord\": 184, \"description\": \"three\", \"point\": 1 } ] }, { \"beneficiaryRegID\": \"7506\", \"visitID\": null, \"createdBy\": \"888\", \"imageID\": 4, \"providerServiceMapID\": \"1320\", \"markers\": [ { \"xCord\": 102, \"yCord\": 154, \"description\": \"four\", \"point\": 1 } ] }, { \"beneficiaryRegID\": \"7506\", \"visitID\": null, \"createdBy\": \"888\", \"imageID\": 2, \"providerServiceMapID\": \"1320\", \"markers\": [ { \"xCord\": 171, \"yCord\": 156, \"description\": \"two\", \"point\": 1 } ] } ] }, \"historyDetails\": { \"familyHistory\": { \"diseases\": [ { \"beneficiaryRegID\": \"7506\", \"benVisitID\": null, \"providerServiceMapID\": \"1320\", \"cancerDiseaseType\": \"Breast Cancer\", \"otherDiseaseType\": null, \"familyMemberList\": [ \"Aunt\", \"Brother\" ], \"createdBy\": \"888\" }, { \"beneficiaryRegID\": \"7506\", \"benVisitID\": null, \"providerServiceMapID\": \"1320\", \"cancerDiseaseType\": \"lorem ipsum\", \"otherDiseaseType\": \"lorem ipsum\", \"familyMemberList\": [ \"Grand Father\" ], \"createdBy\": \"888\" } ], \"beneficiaryRegID\": \"7506\", \"providerServiceMapID\": \"1320\", \"createdBy\": \"888\" }, \"personalHistory\": { \"beneficiaryRegID\": \"7506\", \"benVisitID\": null, \"providerServiceMapID\": \"1320\", \"tobaccoUse\": \"Used in Past\", \"startAge_year\": \"23\", \"endAge_year\": \"24\", \"typeOfTobaccoProductList\": [ \"Beedi\", \"Chewing\", \"Cigarettes\" ], \"quantityPerDay\": \"2\", \"isFilteredCigaerette\": true, \"isCigaretteExposure\": false, \"isBetelNutChewing\": true, \"durationOfBetelQuid\": \"12\", \"alcoholUse\": \"Currently Using\", \"ssAlcoholUsed\": true, \"frequencyOfAlcoholUsed\": \"1-4 days/week\", \"dietType\": \"Eggetarian\", \"otherDiet\": null, \"intakeOfOutsidePreparedMeal\": \"2\", \"fruitConsumptionDays\": \"2\", \"fruitQuantityPerDay\": \"2\", \"vegetableConsumptionDays\": \"2\", \"vegetableQuantityPerDay\": \"2\", \"typeOfOilConsumedList\": [ \"Coconut Oil\", \"Corn Oil\" ], \"otherOilType\": null, \"physicalActivityType\": \"Light Activity\", \"ssRadiationExposure\": false, \"isThyroidDisorder\": false, \"createdBy\": \"888\" }, \"pastObstetricHistory\": { \"beneficiaryRegID\": \"7506\", \"benVisitID\": null, \"providerServiceMapID\": \"1320\", \"pregnancyStatus\": \"Yes\", \"isUrinePregTest\": null, \"pregnant_No\": \"1\", \"noOfLivingChild\": \"1\", \"isAbortion\": false, \"isOralContraceptiveUsed\": false, \"isHormoneReplacementTherapy\": false, \"menarche_Age\": \"13\", \"isMenstrualCycleRegular\": true, \"menstrualCycleLength\": \"28\", \"menstrualFlowDuration\": \"3\", \"menstrualFlowType\": \"Little\", \"isDysmenorrhea\": false, \"isInterMenstrualBleeding\": false, \"menopauseAge\": null, \"isPostMenopauseBleeding\": null, \"createdBy\": \"888\" } } }";
		
		jsnOBJPve = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(nurseObjPve);
		jsnOBJPve = jsnElmnt.getAsJsonObject();
		

		BeneficiaryVisitDetail beneficiaryVisitDetail = spy(BeneficiaryVisitDetail.class);
		beneficiaryVisitDetail.setBenVisitID(1L);
		when(benVisitDetailRepoMock.save(beneficiaryVisitDetail)).thenReturn(beneficiaryVisitDetail);
		
		BenFamilyCancerHistory benFamilyHistory = spy(BenFamilyCancerHistory.class);
		benFamilyHistory.setID(1L);
		List<BenFamilyCancerHistory> familyRes =  new ArrayList<BenFamilyCancerHistory>();
		familyRes.add(benFamilyHistory);
		when(benFamilyCancerHistoryRepoMock.save(Matchers.anyListOf(BenFamilyCancerHistory.class))).thenReturn(familyRes);
		
		
		
	
		BenPersonalCancerHistory personalHstry = spy(BenPersonalCancerHistory.class);
		personalHstry.setID(1L);
		when(benPersonalCancerHistoryRepoMock.save(isA(BenPersonalCancerHistory.class))).thenReturn(personalHstry);
		
		BenPersonalCancerDietHistory personaldietHstry = spy(BenPersonalCancerDietHistory.class);
		personaldietHstry.setID(1L);
		when(benPersonalCancerDietHistoryRepoMock.save(isA(BenPersonalCancerDietHistory.class))).thenReturn(personaldietHstry);
		
		//when(cancerSignAndSymptomsRepoMock.save(isA(CancerSignAndSymptoms.class))).thenReturn();
		/*	
		cancerSignAndSymptomsRepo.save(cancerSignAndSymptoms);
		cancerLymphNodeExaminationRepo
				.save(cancerLymphNodeDetails);
		
		cancerOralExaminationRepo.save(cancerOralExamination);
		cancerBreastExaminationRepo.save(cancerBreastExamination);
		cancerAbdominalExaminationRepo.save(cancerAbdominalExamination);
		
		cancerGynecologicalExaminationRepo
				.save(cancerGynecologicalExamination);
		cancerExaminationImageAnnotationRepo
				.save(getCancerExaminationImageAnnotationList(wrapperCancerExamImgAnotasnList));
		
		
		benCancerVitalDetailRepo.save(benCancerVitalDetail);
		
		registrarRepoBenData.updateBenFlowStatus(c, benRegID);*/
		
	}
	
	@Test
	public void  saveCancerScreeningNurseDataPveTest(){
		
		/*Long response = cSServiceImpl.saveCancerScreeningNurseData(jsnOBJPve);
		
		assertTrue("",
				response.equals("{\"data\":{\"response\":\"Nurse data saved successfully.\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}"));*/
	}
	
}
