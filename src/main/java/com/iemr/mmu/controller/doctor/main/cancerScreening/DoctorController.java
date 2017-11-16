package com.iemr.mmu.controller.doctor.main.cancerScreening;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.iemr.mmu.data.doctor.CancerAbdominalExamination;
import com.iemr.mmu.data.doctor.CancerBreastExamination;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.doctor.CancerGynecologicalExamination;
import com.iemr.mmu.data.doctor.CancerLymphNodeDetails;
import com.iemr.mmu.data.doctor.CancerOralExamination;
import com.iemr.mmu.data.doctor.WrapperCancerExamImgAnotasn;
import com.iemr.mmu.data.doctor.WrapperCancerSymptoms;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.doctor.DoctorServiceImpl;
import com.iemr.mmu.service.masterservice.DoctorMasterDataService;
import com.iemr.mmu.service.masterservice.DoctorMasterDataServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/doctor" })
public class DoctorController {

	/*private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(DoctorController.class);
	private DoctorMasterDataService doctorMasterDataService;
	private DoctorMasterDataServiceImpl doctorMasterDataServiceImpl;

	@Autowired
	private DoctorServiceImpl doctorServiceImpl;

	@Autowired
	public void setDoctorMasterDataServiceImpl(DoctorMasterDataServiceImpl doctorMasterDataServiceImpl) {
		this.doctorMasterDataServiceImpl = doctorMasterDataServiceImpl;
	}

	@Autowired
	private NurseServiceImpl nurseServiceImpl;

	@CrossOrigin
	@ApiOperation(value = "save Abdominal Examination Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examinationScreen/abdominal" }, method = { RequestMethod.POST })
	public String saveAbdominalExaminationDetail(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\", \"benVisitID\":\"Long\", \"providerServiceMapID\":\"Integer\", "
					+ " \"abdominalInspection_Normal\":\"Boolean\", \"liver\":\"string\", \"ascites_Present\":\"Boolean\","
					+ "\"anyOtherMass_Present\":\"Boolean\",\"lymphNodes_Enlarged\":\"Boolean\", \"lymphNode_Inguinal_Left\":\"Boolean\","
					+ "\"lymphNode_ExternalIliac_Left\":\"Boolean\", \"lymphNode_ParaAortic_Left\":\"Boolean\", "
					+ "\"observation\":\"string\",\"image\":\"Blob\",\"createdBy\":\"string\"}") @RequestBody String requestObj) {

		response = new OutputResponse();
		logger.info("saveAbdominalExaminationDetail request:" + requestObj);
		CancerAbdominalExamination cancerAbdominalExamination = InputMapper.gson().fromJson(requestObj,
				CancerAbdominalExamination.class);
		try {
			Long ID = doctorServiceImpl.saveCancerAbdominalExaminationData(cancerAbdominalExamination);
			if (ID != null && ID > 0) {
				Map<String, Long> resMap = new HashMap<String, Long>();
				resMap.put("ID", ID);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to Store Abdominal Examination Detail");
			}
			logger.info("saveAbdominalExaminationDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveAbdominalExaminationDetail:" + e);
		}

		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "save Breast Examination Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examinationScreen/breast" }, method = { RequestMethod.POST })
	public String saveBreastExaminationDetail(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\", \"benVisitID\":\"Long\", \"providerServiceMapID\":\"Integer\", "
					+ " \"everBreastFed\":\"Boolean\", \"breastFeedingDurationGTE6months\":\"Boolean\", \"breastsAppear_Normal\":\"Boolean\","
					+ "\"rashOnBreast\":\"Boolean\",\"dimplingSkinOnBreast\":\"Boolean\", \"dischargeFromNipple\":\"Boolean\","
					+ "\"peaudOrange\":\"Boolean\", \"lumpInBreast\":\"Boolean\", \"lumpSize\":\"string\",\"lumpShape\":\"string\","
					+ "\"lumpTexture\":\"String\", \"referredToMammogram\":\"Boolean\", \"mamogramReport\":\"string\","
					+ " \"image\":\"Blob\",\"createdBy\":\"string\"}") @RequestBody String requestObj) {

		response = new OutputResponse();
		logger.info("saveBreastExaminationDetail request:" + requestObj);
		CancerBreastExamination cancerBreastExamination = InputMapper.gson().fromJson(requestObj,
				CancerBreastExamination.class);
		try {
			Long ID = doctorServiceImpl.saveCancerBreastExaminationData(cancerBreastExamination);
			if (ID != null && ID > 0) {
				Map<String, Long> resMap = new HashMap<String, Long>();
				resMap.put("ID", ID);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to Store Breast Examination Detail");
			}
			logger.info("saveBreastExaminationDetail response:" + response);

		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveBreastExaminationDetail:" + e);
		}

		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "save Diagnosis Examination Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examinationScreen/diagnosis" }, method = { RequestMethod.POST })
	public String saveDiagnosisExaminationDetail(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\", \"benVisitID\":\"Long\", \"providerServiceMapID\":\"Integer\", "
					+ " \"provisionalDiagnosisPrimaryDoctor\":\"String\", \"provisionalDiagnosisOncologist\":\"String\", "
					+ "\"remarks\":\"String\", \"referredToInstituteID\":\"Integer\",\"refrredToAdditionalService\":\"String\","
					+ " \"createdBy\":\"string\"}") @RequestBody String requestObj) {

		response = new OutputResponse();
		logger.info("saveDiagnosisExaminationDetail request:" + requestObj);
		CancerDiagnosis cancerDiagnosis = InputMapper.gson().fromJson(requestObj, CancerDiagnosis.class);
		try {
			Long ID = doctorServiceImpl.saveCancerDiagnosisData(cancerDiagnosis);
			if (ID != null && ID > 0) {
				Map<String, Long> resMap = new HashMap<String, Long>();
				resMap.put("ID", ID);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to Store Diagnosis Examination Detail");
			}
			logger.info("saveDiagnosisExaminationDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveDiagnosisExaminationDetail:" + e);
		}

		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "save Gynecological Examination Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examinationScreen/gynecological" }, method = { RequestMethod.POST })
	public String saveGynecologicalExaminationDetail(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\", \"benVisitID\":\"Long\", \"providerServiceMapID\":\"Integer\", "
					+ " \"appearanceOfCervix\":\"String\", \"typeOfLesionList\":\"List\", "
					+ "\"vulvalInvolvement\":\"Boolean\", \"vaginalInvolvement\":\"Boolean\",\"uterus_Normal\":\"Boolean\","
					+ "\"sufferedFromRTIOrSTI\":\"Boolean\", \"rTIOrSTIDetail\":\"String\",\"filePath\":\"String\","
					+ "\"experiencedPostCoitalBleeding\":\"Boolean\", \"observation\":\"String\","
					+ " \"createdBy\":\"string\"}") @RequestBody String requestObj) {

		response = new OutputResponse();
		logger.info("saveGynecologicalExaminationDetail request:" + requestObj);
		CancerGynecologicalExamination cancerGynecologicalExamination = InputMapper.gson().fromJson(requestObj,
				CancerGynecologicalExamination.class);
		try {
			Long ID = doctorServiceImpl.saveCancerGynecologicalExaminationData(cancerGynecologicalExamination);
			if (ID != null && ID > 0) {
				Map<String, Long> resMap = new HashMap<String, Long>();
				resMap.put("ID", ID);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to Store Gynecological Examination Detail");
			}
			logger.info("saveGynecologicalExaminationDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveGynecologicalExaminationDetail:" + e);
		}

		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "save LymphNode Examination Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examinationScreen/lymphNode" }, method = { RequestMethod.POST })
	public String saveLymphNodeExaminationDetail(
			@ApiParam(value = "[{\"beneficiaryRegID\":\"Long\", \"benVisitID\":\"Long\", \"providerServiceMapID\":\"Integer\", "
					+ " \"lymphNodeName\":\"String\", \"mobility_Left\":\"Boolean\", \"size_Left\":\"String\""
					+ "\"mobility_Right\":\"Boolean\", \"size_Right\":\"String\", \"createdBy\":\"string\"}]") @RequestBody String requestObj) {

		response = new OutputResponse();
		logger.info("saveLymphNodeExaminationDetail request:" + requestObj);
		CancerLymphNodeDetails[] cancerLymphNodeDetails = InputMapper.gson().fromJson(requestObj,
				CancerLymphNodeDetails[].class);

		List<CancerLymphNodeDetails> cancerLymphNodeDetailsList = Arrays.asList(cancerLymphNodeDetails);
		try {
			int result = doctorServiceImpl.saveLymphNodeDetails(cancerLymphNodeDetailsList);
			if (result > 0) {
				response.setResponse("LymphNode Examination Detail Stored Successfully");
			} else {
				response.setError(0, "Failed to Store LymphNode Examination Detail");
			}
			logger.info("saveLymphNodeExaminationDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveLymphNodeExaminationDetail:" + e);
		}

		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "save Oral Examination Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examinationScreen/oral" }, method = { RequestMethod.POST })
	public String saveOralExaminationDetail(
			@ApiParam(value = "[{\"beneficiaryRegID\":\"Long\", \"benVisitID\":\"Long\", \"providerServiceMapID\":\"Integer\", "
					+ " \"limitedMouthOpening\":\"String\", \"premalignantLesions\":\"Boolean\", \"preMalignantLesionTypeList\":\"List\""
					+ "\"prolongedIrritation\":\"Boolean\", \"chronicBurningSensation\":\"Boolean\", \"observation\":\"String\","
					+ "\"image\":\"Blob\", \"createdBy\":\"string\"}]") @RequestBody String requestObj) {

		response = new OutputResponse();
		logger.info("saveOralExaminationDetail request:" + requestObj);
		CancerOralExamination cancerOralExamination = InputMapper.gson().fromJson(requestObj,
				CancerOralExamination.class);
		try {
			Long ID = doctorServiceImpl.saveCancerOralExaminationData(cancerOralExamination);
			if (ID != null && ID > 0) {
				Map<String, Long> resMap = new HashMap<String, Long>();
				resMap.put("ID", ID);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to Store Oral Examination Detail");
			}
			logger.info("saveOralExaminationDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveOralExaminationDetail:" + e);
		}

		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "save Cancer SignAndSymptoms Examination Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examinationScreen/signAndSymptoms" }, method = { RequestMethod.POST })
	public String saveCancerSignAndSymptomsDetail(
			@ApiParam(value = "{\"cancerSignAndSymptoms\":{\"beneficiaryRegID\": \"Long\", \"benVisitID\": \"Long\", \"providerServiceMapID\": \"Integer\","
					+ "\"shortnessOfBreath\":\"Boolean\", \"cough=2Weeks\":\"Boolean\", \"bloodInSputum\":\"Boolean\", \"difficultyInOpeningMouth\":\"Boolean\","
					+ "\"nonHealingUlcerOrPatchOrGrowth\":\"Boolean\", \"changeInTheToneOfVoice\":\"Boolean\", \"lumpInTheBreast\":\"Boolean\","
					+ "\"bloodStainedDischargeFromNipple\":\"Boolean\", \"changeInShapeAndSizeOfBreasts\":\"Boolean\", \"vaginalBleedingBetweenPeriods\":\"Boolean\","
					+ "\"vaginalBleedingAfterMenopause\":\"Boolean\", \"vaginalBleedingAfterIntercourse\":\"Boolean\", \"foulSmellingVaginalDischarge\":\"Boolean\", "
					+ "\"lymphNode_Enlarged\":\"Boolean\",\"createdBy\":\"String\"}, "
					+ "\"cancerLymphNodeDetails\":[{\"beneficiaryRegID\": \"Long\", \"benVisitID\": \"Long\", \"providerServiceMapID\": \"Integer\", "
					+ "\"lymphNodeName\":\"String\",\"mobility_Left\":\"Boolean\",\"size_Left\":\"String\", \"mobility_Right\":\"Boolean\", "
					+ "\"createdBy\":\"String\"}]}") @RequestBody String requestObj) {

		response = new OutputResponse();
		logger.info("saveCancerSignAndSymptomsDetail request:" + requestObj);
		WrapperCancerSymptoms wrapperCancerSymptoms = InputMapper.gson().fromJson(requestObj,
				WrapperCancerSymptoms.class);

		// CancerLymphNodeDetails[] cancerLymphNodeDetails =
		// InputMapper.gson().fromJson(requestObj,
		// CancerLymphNodeDetails[].class);
		//
		// List<CancerLymphNodeDetails> cancerLymphNodeDetailsList =
		// Arrays.asList(cancerLymphNodeDetails);

		try {
			Long ID = doctorServiceImpl.saveCancerSignAndSymptomsData(wrapperCancerSymptoms.getCancerSignAndSymptoms());

			if (ID != null && ID > 0) {
				response.setResponse("Cancer Sign and Symptoms Detail Stored Successfully");

				int result = doctorServiceImpl.saveLymphNodeDetails(wrapperCancerSymptoms.getCancerLymphNodeDetails());
				if (result > 0) {
					response.setResponse(
							"Cancer Sign and Symptoms Detail and LymphNode Examination Detail Stored Successfully");
				} else {
					response.setError(500,
							"Cancer Sign and Symptoms Detail Stored but Failed to Store LymphNode Examination Detail");
				}

			} else {
				response.setError(500, "Failed to Store Cancer Sign and Symptoms Detail");
			}
			logger.info("saveCancerSignAndSymptomsDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveCancerSignAndSymptomsDetail:" + e);
		}

		return response.toString();
	}

	*//**
	 * @Param
	 * @Objective: Save doc cancer examination image annotation data.
	 * @return
	 *//*
	@CrossOrigin()
	@ApiOperation(value = "Save doc examination image annotaion for cancer screening", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/saveCancerExaminationImageAnnotation" }, method = { RequestMethod.POST })
	public String saveExaminationImageAnnotation(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveCancerExaminationImageAnnotation..");
		try {

			WrapperCancerExamImgAnotasn[] wrapperCancerExamImgAnotasn = InputMapper.gson().fromJson(requestObj,
					WrapperCancerExamImgAnotasn[].class);

			List<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = Arrays
					.asList(wrapperCancerExamImgAnotasn);

			Long r = doctorServiceImpl.saveDocExaminationImageAnnotation(wrapperCancerExamImgAnotasnList);
			if (r != null) {
				response.setResponse("Data Successfully saved");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "provides doctor master Data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/doctorMasterData" }, method = { RequestMethod.POST })
	public String getMasterDataForDoctor() {

		OutputResponse response = new OutputResponse();
		logger.info("getMasterDataForDoctor..");
		try {
			response.setResponse(doctorMasterDataServiceImpl.getDoctorMasterData());
			logger.info("getMasterDataForDoctor response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getMasterDataForDoctor:" + e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "update nurse visit detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/visitDetailScreen/VisitDetail" }, method = { RequestMethod.POST })
	public String updateBeneficiaryVisitDetail(
			@ApiParam(value = "{\"benVisitID\": \"Long\", \"beneficiaryRegID\":\"Long\",\"providerServiceMapID\": \"Integer\","
					+ "\"visitDateTime\":\"Timestamp\", \"visitNo\":\"Short\", \"visitReasonID\":\"Short\", \"visitReason\":\"String\","
					+ "\"visitCategoryID\":\"Integer\", \"visitCategory\":\"String\", \"pregnancyStatus\":\"String\","
					+ "\"rCHID\":\"String\", \"healthFacilityType\":\"String\", \"healthFacilityLocation\":\"String\","
					+ "\"reportFilePath\":\"String\",\"modifiedBy\":\"String\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("updateBeneficiaryVisitDetail request:" + requestObj);
		BeneficiaryVisitDetail beneficiaryVisitDetail = InputMapper.gson().fromJson(requestObj,
				BeneficiaryVisitDetail.class);
		try {
			int result = nurseServiceImpl.updateBeneficiaryVisitDetails(beneficiaryVisitDetail);
			if (result > 0) {
				Map<String, Integer> resMap = new HashMap<String, Integer>();
				resMap.put("result", result);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to update Beneficiary Visit Details");
			}
			logger.info("updateBeneficiaryVisitDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in updateBeneficiaryVisitDetail :" + e);
		}

		System.out.println(response.toString());
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "update Ben Family Cancer History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/historyScreen/benFamilyCancerHistory" }, method = { RequestMethod.POST })
	public String updateBenFamilyCancerHistory(
			@ApiParam(value = "[{\"ID\": \"Long\", \"beneficiaryRegID\":\"Long\",\"benVisitID\":\"Long\","
					+ "\"cancerDiseaseType\":\"String\", \"familyMemberList\":\"List\", \"modifiedBy\":\"String\"},"
					+ "{ \"beneficiaryRegID\":\"Long\",\"benVisitID\":\"Long\","
					+ "\"cancerDiseaseType\":\"String\", \"familyMemberList\":\"List\", \"createdBy\":\"String\"}]") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("updateBenFamilyCancerHistory request:" + requestObj);
		BenFamilyCancerHistory[] benFamilyCancerHistoryArray = InputMapper.gson().fromJson(requestObj,
				BenFamilyCancerHistory[].class);

		List<BenFamilyCancerHistory> benFamilyCancerHistoryList = Arrays.asList(benFamilyCancerHistoryArray);
		try {
			int result = nurseServiceImpl.updateBeneficiaryFamilyCancerHistory(benFamilyCancerHistoryList);
			if (result > 0) {
				Map<String, Integer> resMap = new HashMap<String, Integer>();
				resMap.put("result", result);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to update Beneficiary Family Cancer History");
			}
			logger.info("updateBenFamilyCancerHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in updateBenFamilyCancerHistory :" + e);
		}

		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "update Ben Obstetric Cancer History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/historyScreen/benObstetricCancerHistory" }, method = { RequestMethod.POST })
	public String updateBenObstetricCancerHistory(
			@ApiParam(value = "{\"ID\": \"Long\", \"beneficiaryRegID\":\"Long\",\"benVisitID\":\"Long\","
					+ "\"pregnancyStatus\":\"String\", \"isUrinePregTest\":\"Boolean\", \"pregnant_No\":\"String\", \"noOfLivingChild\":\"Integer\","
					+ "\"isAbortion\":\"Boolean\", \"isOralContraceptiveUsed\":\"Boolean\", \"isHormoneReplacementTherapy\":\"Boolean\", \"menarche_Age\":\"Integer\","
					+ "\"isMenstrualCycleRegular\":\"Boolean\", \"menstrualCycleLength\":\"Integer\", \"menstrualFlowDuration\":\"Integer\", \"menstrualFlowType\":\"String\","
					+ "\"isDysmenorrhea\":\"Boolean\", \"isInterMenstrualBleeding\":\"Boolean\", \"menopauseAge\":\"Integer\", \"isPostMenopauseBleeding\":\"Boolean\","
					+ " \"isFoulSmellingDischarge\":\"Boolean\", \"modifiedBy\":\"String\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("updateBenObstetricCancerHistory request:" + requestObj);
		try {
			BenObstetricCancerHistory benObstetricCancerHistory = InputMapper.gson().fromJson(requestObj,
					BenObstetricCancerHistory.class);

			int result = nurseServiceImpl.updateBenObstetricCancerHistory(benObstetricCancerHistory);
			if (result > 0) {
				response.setResponse("Beneficiary Obstetric Cancer History Details updated Successfully");
			} else {
				response.setError(500, "Failed to update Beneficiary Obstetric Cancer History Details");
			}
			response.setResponse(response.toString());
			logger.info("updateBenObstetricCancerHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in updateBenObstetricCancerHistory :" + e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "update Ben Personal Cancer History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/historyScreen/benPersonalCancerHistory" }, method = { RequestMethod.POST })
	public String updateBenPersonalCancerHistory(
			@ApiParam(value = "{\"ID\": \"Long\", \"beneficiaryRegID\":\"Long\",\"benVisitID\":\"Long\","
					+ "\"tobaccoUse\":\"String\", \"startAge_year\":\"Integer\", \"endAge_year\":\"Integer\", \"typeOfTobaccoProductList\":\"List\","
					+ "\"quantityPerDay\":\"Integer\", \"isFilteredCigaerette\":\"Boolean\", \"isCigaretteExposure\":\"Boolean\", \"isBetelNutChewing\":\"Boolean\","
					+ "\"durationOfBetelQuid\":\"Integer\", \"alcoholUse\":\"String\", \"ssAlcoholUsed\":\"Boolean\", \"frequencyOfAlcoholUsed\":\"String\","
					+ " \"dietType\":\"String\",\"fruitConsumptionDays\":\"Integer\",\"fruitQuantityPerDay\":\"Integer\",\"vegetableConsumptionDays\":\"Integer\","
					+ "\"vegetableQuantityPerDay\":\"Integer\", \"intakeOfOutsidePreparedMeal\":\"Integer\",\"typeOfOilConsumedList\":\"List\","
					+ "\"physicalActivityType\":\"String\", \"ssRadiationExposure\":\"Boolean\", \"isThyroidDisorder\":\"Boolean\",\"modifiedBy\":\"String\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("updateBenPersonalCancerHistory request:" + requestObj);
		try {
			BenPersonalCancerHistory benPersonalCancerHistory = InputMapper.gson().fromJson(requestObj,
					BenPersonalCancerHistory.class);

			BenPersonalCancerDietHistory benPersonalCancerDietHistory = InputMapper.gson().fromJson(requestObj,
					BenPersonalCancerDietHistory.class);

			int responseObjP = nurseServiceImpl.updateBenPersonalCancerHistory(benPersonalCancerHistory);

			int responseObjD = nurseServiceImpl.updateBenPersonalCancerDietHistory(benPersonalCancerDietHistory);

			if (responseObjP > 0 && responseObjD > 0) {
				response.setResponse("Beneficiary Personal Cancer History Details updated Successfully");
			} else {
				response.setError(500, "Failed to update Beneficiary Personal Cancer History Details");
			}
			logger.info("updateBenPersonalCancerHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in updateBenPersonalCancerHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "update Ben Vital Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/vitalScreen/benVitalDetail" }, method = { RequestMethod.POST })
	public String upodateBenVitalDetail(
			@ApiParam(value = "{\"ID\": \"Long\", \"beneficiaryRegID\":\"Long\",\"benVisitID\":\"Long\","
					+ "\"weight_Kg\":\"Double\", \"height_cm\":\"Double\", \"waistCircumference_cm\":\"Double\", \"bloodGlucose_Fasting\":\"Short\","
					+ "\"bloodGlucose_Random\":\"Short\", \"bloodGlucose_2HrPostPrandial\":\"Short\", \"systolicBP_1stReading\":\"Short\", "
					+ "\"diastolicBP_1stReading\":\"Short\", \"systolicBP_2ndReading\":\"Short\", \"diastolicBP_2ndReading\":\"Short\", "
					+ "\"systolicBP_3rdReading\":\"Short\", \"diastolicBP_3rdReading\":\"Short\","
					+ " \"hbA1C\":\"Short\",\"hemoglobin\":\"Short\",\"modifiedBy\":\"String\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("upodateBenVitalDetail request:" + requestObj);
		BenCancerVitalDetail benCancerVitalDetail = InputMapper.gson().fromJson(requestObj, BenCancerVitalDetail.class);
		try {
			int responseObj = nurseServiceImpl.updateBenVitalDetail(benCancerVitalDetail);
			if (responseObj > 0) {
				response.setResponse("Beneficiary Vital Details updated Successfully");
			} else {
				response.setError(500, "Failed to update Beneficiary Vital Details");
			}
			logger.info("upodateBenVitalDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in upodateBenVitalDetail:" + e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "provides doctor worklist", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getDocWorklist" }, method = { RequestMethod.GET })
	public String getNurseWorkList() {
		OutputResponse response = new OutputResponse();
		try {
			String s = doctorServiceImpl.getDocWorkList();
			response.setResponse(s);
		} catch (Exception e) {
			logger.error("Error in getNurseWorkList:" + e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "ben VisitID", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/updateBeneficiaryStatus" }, method = { RequestMethod.POST })
	public String updateBeneficiaryStatus(
			@ApiParam(value = "{\"benVisitID\": \"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 0 && obj.has("benVisitID")) {

				String s = doctorServiceImpl.updateBenStatus(obj.getLong("benVisitID"), "D");
				logger.info("updated status flag for Beneficiary Done Successfully.");
				response.setResponse(s);
			} else {
				response.setError(5000, "Beneficiary VisitID is Missing");
				logger.info("updateBeneficiaryStatus -> Beneficiary VisitID is Missing");
			}

		} catch (Exception e) {
			logger.error("Error in updateBeneficiaryStatus:" + e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Quick Consultation master data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/quickConsultationMasterData" }, method = { RequestMethod.GET })
	public String quickConsultationMasterData() {
		OutputResponse response = new OutputResponse();
		try {
			String s = doctorServiceImpl.getQuickConsultMasterData();
			if (s != null)
				response.setResponse(s);
			else
				response.setError(5000, "No Master Data Available");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Quick Consultation master data:" + e);
			response.setError(e);
		}
		return response.toString();
	}*/

}
