package com.iemr.mmu.controller.cancerscreening;

import java.util.HashMap;
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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.service.cancerScreening.CSServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @author NA874500
 * @Objective Updating Cancer screening data for Nurse.
 * @Date 17-01-2018
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/CS-cancerScreening", headers = "Authorization")
public class CancerScreeningUpdateController {
	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(CancerScreeningUpdateController.class);
	private CSServiceImpl cSServiceImpl;

	@Autowired
	public void setCancerScreeningServiceImpl(CSServiceImpl cSServiceImpl) {
		this.cSServiceImpl = cSServiceImpl;
	}

	/**
	 * 
	 * @param requestObj
	 * @return success or failure response
	 * @objective Replace Cancer Screening History Details entered by Nurse with
	 *            the details entered by Doctor
	 */

	@CrossOrigin
	@ApiOperation(value = "update Cancer Screening History Nurse Data in Doctor screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/historyScreen" }, method = { RequestMethod.POST })
	public String updateCSHistoryNurse(
			@ApiParam(value = "{\"historyDetails\": {\"familyHistory\":{\"diseases\": [{\"beneficiaryRegID\":\"Long\", \"benVisitID\":\"Long\", "
					+ "\"providerServiceMapID\":\"Integer\", \"cancerDiseaseType\":\"String\", \"otherDiseaseType\":\"String\", \"familyMemberList\":\"List\", "
					+ "\"createdBy\":\"String\"}]}, \"personalHistory\":{\"beneficiaryRegID\":\"Long\",\"benVisitID\":\"Long\", \"providerServiceMapID\":\"Integer\", "
					+ "\"tobaccoUse\":\"String\", \"startAge_year\":\"Integer\", \"endAge_year\":\"Integer\", \"typeOfTobaccoProductList\":\"List\", "
					+ "\"quantityPerDay\":\"Integer\", \"isFilteredCigaerette\":\"Boolean\", \"isCigaretteExposure\":\"Boolean\", \"isBetelNutChewing\":\"Boolean\", "
					+ "\"durationOfBetelQuid\":\"Integer\", \"alcoholUse\":\"String\", \"ssAlcoholUsed\":\"Boolean\", \"frequencyOfAlcoholUsed\":\"String\", "
					+ "\"dietType\":\"String\", \"intakeOfOutsidePreparedMeal\":\"Integer\", \"fruitConsumptionDays\":\"Integer\", \"fruitQuantityPerDay\":\"Integer\", "
					+ "\"vegetableConsumptionDays\":\"Integer\", \"vegetableQuantityPerDay\":\"Integer\", \"typeOfOilConsumedList\":\"List\","
					+ "\"physicalActivityType\":\"String\", \"ssRadiationExposure\":\"Boolean\", \"isThyroidDisorder\":\"Boolean\", \"createdBy\":\"String\"}"
					+ "\"pastObstetricHistory\":{\"beneficiaryRegID\":\"Long\", \"benVisitID\":\"Long\", \"providerServiceMapID\":\"Integer\", "
					+ "\"pregnancyStatus\":\"String\", \"isUrinePregTest\":\"Boolean\", \"pregnant_No\":\"String\",\"noOfLivingChild\":\"Integer\","
					+ "\"isAbortion\":\"Boolean\",\"isOralContraceptiveUsed\":\"Boolean\", \"isHormoneReplacementTherapy\":\"Boolean\",\"menarche_Age\":\"Integer\", "
					+ "\"isMenstrualCycleRegular\":\"Boolean\",\"menstrualCycleLength\":\"Integer\", \"menstrualFlowDuration\":\"Integer\", "
					+ "\"menstrualFlowType\":\"String\", \"isDysmenorrhea\":\"Boolean\", \"isInterMenstrualBleeding\":\"Boolean\", "
					+ "\"menopauseAge\":\"Integer\", \"isPostMenopauseBleeding\":\"Boolean\", \"createdBy\":\"String\"}}}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("updateCSHistoryNurse request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();

		try {
			int result = cSServiceImpl.UpdateCSHistoryNurseData(jsnOBJ);
			if (result > 0) {
				response.setResponse("history data updated successfully");
			} else {
				response.setError(500, "Failed to update history data");
			}
			logger.info("updateCSHistoryNurse response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while updating beneficiary history data");
			logger.error("Error in updateCSHistoryNurse :" + e);
		}

		return response.toString();
	}

	/**
	 * 
	 * @param requestObj
	 * @return success or failure response
	 * @objective Replace Cancer Screening Vital Details entered by Nurse with
	 *            the details entered by Doctor
	 */

	@CrossOrigin
	@ApiOperation(value = "update Ben Vital Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/vitalScreen" }, method = { RequestMethod.POST })
	public String upodateBenVitalDetail(
			@ApiParam(value = "{\"ID\": \"Long\", \"beneficiaryRegID\":\"Long\",\"benVisitID\":\"Long\","
					+ "\"weight_Kg\":\"Double\", \"height_cm\":\"Double\", \"waistCircumference_cm\":\"Double\", \"bloodGlucose_Fasting\":\"Short\","
					+ "\"bloodGlucose_Random\":\"Short\", \"bloodGlucose_2HrPostPrandial\":\"Short\", \"systolicBP_1stReading\":\"Short\", "
					+ "\"diastolicBP_1stReading\":\"Short\", \"systolicBP_2ndReading\":\"Short\", \"diastolicBP_2ndReading\":\"Short\", "
					+ "\"systolicBP_3rdReading\":\"Short\", \"diastolicBP_3rdReading\":\"Short\","
					+ " \"hbA1C\":\"Short\",\"hemoglobin\":\"Short\",\"modifiedBy\":\"String\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("upodateBenVitalDetail request:" + requestObj);

		try {
			BenCancerVitalDetail benCancerVitalDetail = InputMapper.gson().fromJson(requestObj,
					BenCancerVitalDetail.class);
			int responseObj = cSServiceImpl.updateBenVitalDetail(benCancerVitalDetail);
			if (responseObj > 0) {
				response.setResponse("Vital data updated successfully");
			} else {
				response.setError(500, "Failed to update vital data");
			}
			logger.info("upodateBenVitalDetail response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while updating beneficiary vital data");
			logger.error("Error in upodateBenVitalDetail:" + e);
		}

		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "update Ben Examination Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/examinationScreen" }, method = { RequestMethod.POST })
	public String upodateBenExaminationDetail(@RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("upodateBenExaminationDetail request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();
		
		try {
			int responseObj = cSServiceImpl.updateBenExaminationDetail(jsnOBJ);
			if (responseObj > 0) {
				response.setResponse("Examination data updated successfully");
			} else {
				response.setError(500, "Failed to update examination data");
			}
			logger.info("upodateBenExaminationDetail response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while updating beneficiary examination data");
			logger.error("Error in upodateBenExaminationDetail:" + e);
		}

		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "update Cancer Diagnosis Details By Oncologist", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/examinationScreen/diagnosis" }, method = { RequestMethod.POST })
	public String updateCancerDiagnosisDetailsByOncologist(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\", \"benVisitID\":\"Long\", "
					+ "\"provisionalDiagnosisOncologist\":\"String\", \"modifiedBy\":\"string\"}") @RequestBody String requestObj) {

		response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("updateCancerDiagnosisDetailsByOncologist request:" + requestObj);

		try {
			CancerDiagnosis cancerDiagnosis = InputMapper.gson().fromJson(requestObj, CancerDiagnosis.class);
			int result = cSServiceImpl.updateCancerDiagnosisDetailsByOncologist(cancerDiagnosis);
			if (result > 0) {
				response.setResponse("Diagnosis data updated by Oncologist successfully");
			} else {
				response.setError(5000, "Failed to update diagnosis data by Oncologist");
			}
			logger.info("updateCancerDiagnosisDetailsByOncologist response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while updating beneficiary diagnosis data");
			logger.error("Error in updateCancerDiagnosisDetailsByOncologist :" + e);
		}

		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "update CancerScreening Doctor Data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/doctorData" }, method = { RequestMethod.POST })
	public String updateCancerScreeningDoctorData( @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("updateCancerScreeningDoctorData request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();

		try {
			Long result = cSServiceImpl.updateCancerScreeningDoctorData(jsnOBJ);
			if (null != result && result > 0) {
				response.setResponse("Doctor data updated successfully");
			} else {
				response.setError(500, "Failed to update doctor data");
			}
			logger.info("updateCancerScreeningDoctorData response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while updating beneficiary doctor data");
			logger.error("Error in updateCancerScreeningDoctorData :" + e);
		}

		return response.toString();
	}
}
