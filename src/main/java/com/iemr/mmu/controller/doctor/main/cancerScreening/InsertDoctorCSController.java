package com.iemr.mmu.controller.doctor.main.cancerScreening;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.iemr.mmu.service.common.master.DoctorMasterDataService;
import com.iemr.mmu.service.common.master.DoctorMasterDataServiceImpl;
import com.iemr.mmu.service.doctor.DoctorServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/doctor" })
/**
 * Objective: Performs Saving Beneficiary Cancer Screening Details entered by
 * doctor
 */
public class InsertDoctorCSController {
	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(InsertDoctorCSController.class);
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

		try {
			CancerAbdominalExamination cancerAbdominalExamination = InputMapper.gson().fromJson(requestObj,
					CancerAbdominalExamination.class);
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

		try {
			CancerBreastExamination cancerBreastExamination = InputMapper.gson().fromJson(requestObj,
					CancerBreastExamination.class);
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

		try {
			CancerDiagnosis cancerDiagnosis = InputMapper.gson().fromJson(requestObj, CancerDiagnosis.class);
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

		try {
			CancerGynecologicalExamination cancerGynecologicalExamination = InputMapper.gson().fromJson(requestObj,
					CancerGynecologicalExamination.class);
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

		try {
			CancerLymphNodeDetails[] cancerLymphNodeDetails = InputMapper.gson().fromJson(requestObj,
					CancerLymphNodeDetails[].class);

			List<CancerLymphNodeDetails> cancerLymphNodeDetailsList = Arrays.asList(cancerLymphNodeDetails);
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

		try {
			CancerOralExamination cancerOralExamination = InputMapper.gson().fromJson(requestObj,
					CancerOralExamination.class);
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

		try {
			WrapperCancerSymptoms wrapperCancerSymptoms = InputMapper.gson().fromJson(requestObj,
					WrapperCancerSymptoms.class);
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

	/**
	 * @Param
	 * @Objective: Save doc cancer examination image annotation data.
	 * @return
	 */
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
}
