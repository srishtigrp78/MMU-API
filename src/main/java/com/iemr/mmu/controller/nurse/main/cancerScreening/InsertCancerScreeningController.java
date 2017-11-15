package com.iemr.mmu.controller.nurse.main.cancerScreening;

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
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.masterservice.NurseMasterDataService;
import com.iemr.mmu.service.masterservice.NurseMasterDataServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/nurse" })
public class InsertCancerScreeningController {
	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(InsertCancerScreeningController.class);

	private NurseServiceImpl nurseServiceImpl;
	private NurseMasterDataService nurseMasterDataService;
	private NurseMasterDataServiceImpl nurseMasterDataServiceImpl;

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	@Autowired
	public void setNurseMasterDataServiceImpl(NurseMasterDataServiceImpl nurseMasterDataServiceImpl) {
		this.nurseMasterDataServiceImpl = nurseMasterDataServiceImpl;
	}

	@CrossOrigin
	@ApiOperation(value = "save Beneficiary Visit Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/visitDetailScreen/VisitDetail" }, method = { RequestMethod.POST })
	public String saveBeneficiaryVisitDetail(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\",\"providerServiceMapID\": \"Integer\","
					+ "\"visitDateTime\":\"Timestamp\", \"visitNo\":\"Short\", \"visitReasonID\":\"Short\", \"visitReason\":\"String\","
					+ "\"visitCategoryID\":\"Integer\", \"visitCategory\":\"String\", \"pregnancyStatus\":\"String\","
					+ "\"rCHID\":\"String\", \"healthFacilityType\":\"String\", \"healthFacilityLocation\":\"String\","
					+ "\"reportFilePath\":\"String\",\"createdBy\":\"String\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("saveBeneficiaryVisitDetail request:" + requestObj);
		BeneficiaryVisitDetail beneficiaryVisitDetail = InputMapper.gson().fromJson(requestObj,
				BeneficiaryVisitDetail.class);
		try {
			Long benVisitID = nurseServiceImpl.saveBeneficiaryVisitDetails(beneficiaryVisitDetail);
			if (benVisitID != null && benVisitID > 0) {

				Integer i = nurseServiceImpl.updateBeneficiaryStatus('N', beneficiaryVisitDetail.getBeneficiaryRegID());
				// Please handle all cases here......after customer demo
				Map<String, Long> resMap = new HashMap<String, Long>();
				resMap.put("benVisitID", benVisitID);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to Store Beneficiary Visit Details");
			}
			logger.info("saveBeneficiaryVisitDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveBeneficiaryVisitDetail:" + e);
		}

		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "save Beneficiary Family Cancer Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/historyScreen/benFamilyCancerHistory" }, method = { RequestMethod.POST })
	public String saveBenFamilyCancerHistory(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\",\"benVisitID\":\"Long\",\"providerServiceMapID\": \"Integer\","
					+ "\"cancerDiseaseType\":\"String\", \"familyMemberList\":\"List\", \"createdBy\":\"String\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("saveBenFamilyCancerHistory request:" + requestObj);
		try {
			BenFamilyCancerHistory[] benFamilyCancerHistoryArray = InputMapper.gson().fromJson(requestObj,
					BenFamilyCancerHistory[].class);

			List<BenFamilyCancerHistory> benFamilyCancerHistoryList = Arrays.asList(benFamilyCancerHistoryArray);
			if (benFamilyCancerHistoryList.size() > 0) {
				int responseData = nurseServiceImpl.saveBenFamilyCancerHistory(benFamilyCancerHistoryList);
				if (responseData > 0) {
					response.setResponse("Beneficiary benFamily Data saved successfully.");
				} else {
					response.setError(500, "Data not saved successfully. Please see log file for detailed info");
				}
			} else {
				response.setError(500, "There is no data to save");
			}
			logger.info("saveBenFamilyCancerHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveBenFamilyCancerHistory:" + e);
		}

		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "save Beneficiary Obstetric Cancer Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/historyScreen/benObstetricCancerHistory" }, method = { RequestMethod.POST })
	public String saveBenObstetricCancerHistory(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\",\"benVisitID\":\"Long\",\"providerServiceMapID\": \"Integer\","
					+ "\"pregnancyStatus\":\"String\", \"isUrinePregTest\":\"Boolean\", \"pregnant_No\":\"String\", \"noOfLivingChild\":\"Integer\","
					+ "\"isAbortion\":\"Boolean\", \"isOralContraceptiveUsed\":\"Boolean\", \"isHormoneReplacementTherapy\":\"Boolean\", \"menarche_Age\":\"Integer\","
					+ "\"isMenstrualCycleRegular\":\"Boolean\", \"menstrualCycleLength\":\"Integer\", \"menstrualFlowDuration\":\"Integer\", \"menstrualFlowType\":\"String\","
					+ "\"isDysmenorrhea\":\"Boolean\", \"isInterMenstrualBleeding\":\"Boolean\", \"menopauseAge\":\"Integer\", \"isPostMenopauseBleeding\":\"Boolean\","
					+ " \"isFoulSmellingDischarge\":\"Boolean\", \"createdBy\":\"String\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("saveBenObstetricCancerHistory request:" + requestObj);
		try {
			BenObstetricCancerHistory benObstetricCancerHistory = InputMapper.gson().fromJson(requestObj,
					BenObstetricCancerHistory.class);

			Long responseObj = nurseServiceImpl.saveBenObstetricCancerHistory(benObstetricCancerHistory);
			if (responseObj != null && responseObj > 0) {
				response.setResponse("Beneficiary Obstetric Cancer History Details Stored Successfully");
			} else {
				response.setError(500, "Failed to Store Beneficiary Obstetric Cancer History Details");
			}
			response.setResponse(response.toString());
			logger.info("saveBenObstetricCancerHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveBenObstetricCancerHistory:" + e);
		}
		return response.toString();
	}

	/*
	 * @CrossOrigin
	 * 
	 * @RequestMapping(value = {
	 * "/save/historyScreen/benPersonalCancerDietHistory" }, method = {
	 * RequestMethod.POST }, produces = { "application/json" }) public String
	 * saveBenPersonalCancerDietHistory(@RequestBody String requestObj) {
	 * 
	 * response = new OutputResponse();
	 * 
	 * BenPersonalCancerDietHistory benPersonalCancerDietHistory =
	 * InputMapper.gson().fromJson(requestObj,
	 * BenPersonalCancerDietHistory.class); try { BenPersonalCancerDietHistory
	 * responseObj = nurseServiceImpl
	 * .saveBenPersonalCancerDietHistory(benPersonalCancerDietHistory); if
	 * (responseObj.getID() > 0) { response.
	 * setResponse("Beneficiary Personal Cancer Diet History Details Stored Successfully"
	 * ); } else { response.
	 * setResponse("Failed to Store Beneficiary Personal Cancer Diet History Details"
	 * ); } response.setResponse(response.toString()); } catch (Exception e) {
	 * response.setError(e); }
	 * 
	 * return response.toString(); }
	 */
	@CrossOrigin
	@ApiOperation(value = "save Beneficiary Personal Cancer Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/historyScreen/benPersonalCancerHistory" }, method = { RequestMethod.POST })
	public String saveBenPersonalCancerHistory(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\",\"benVisitID\":\"Long\",\"providerServiceMapID\": \"Integer\","
					+ "\"tobaccoUse\":\"String\", \"startAge_year\":\"Integer\", \"endAge_year\":\"Integer\", \"typeOfTobaccoProductList\":\"List\","
					+ "\"quantityPerDay\":\"Integer\", \"isFilteredCigaerette\":\"Boolean\", \"isCigaretteExposure\":\"Boolean\", \"isBetelNutChewing\":\"Boolean\","
					+ "\"durationOfBetelQuid\":\"Integer\", \"alcoholUse\":\"String\", \"ssAlcoholUsed\":\"Boolean\", \"frequencyOfAlcoholUsed\":\"String\","
					+ " \"dietType\":\"String\",\"fruitConsumptionDays\":\"Integer\",\"fruitQuantityPerDay\":\"Integer\",\"vegetableConsumptionDays\":\"Integer\","
					+ "\"vegetableQuantityPerDay\":\"Integer\", \"intakeOfOutsidePreparedMeal\":\"Integer\",\"typeOfOilConsumedList\":\"List\","
					+ "\"physicalActivityType\":\"String\", \"ssRadiationExposure\":\"Boolean\", \"isThyroidDisorder\":\"Boolean\",\"createdBy\":\"String\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("saveBenPersonalCancerHistory request:" + requestObj);
		try {
			BenPersonalCancerHistory benPersonalCancerHistory = InputMapper.gson().fromJson(requestObj,
					BenPersonalCancerHistory.class);

			BenPersonalCancerDietHistory benPersonalCancerDietHistory = InputMapper.gson().fromJson(requestObj,
					BenPersonalCancerDietHistory.class);

			Long responseObjP = nurseServiceImpl.saveBenPersonalCancerHistory(benPersonalCancerHistory);

			Long responseObjD = nurseServiceImpl.saveBenPersonalCancerDietHistory(benPersonalCancerDietHistory);

			if (responseObjP != null && responseObjP > 0 && responseObjD != null && responseObjD > 0) {
				response.setResponse("Beneficiary Personal Cancer History Details Stored Successfully");
			} else {
				response.setError(500, "Failed to Store Beneficiary Personal Cancer History Details");
			}
			logger.info("saveBenPersonalCancerHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveBenPersonalCancerHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "save Beneficiary Vital Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/vitalScreen/benVitalDetail" }, method = { RequestMethod.POST })
	public String saveBenVitalDetail(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\",\"benVisitID\":\"Long\",\"providerServiceMapID\": \"Integer\","
					+ "\"weight_Kg\":\"Double\", \"height_cm\":\"Double\", \"waistCircumference_cm\":\"Double\", \"bloodGlucose_Fasting\":\"Short\","
					+ "\"bloodGlucose_Random\":\"Short\", \"bloodGlucose_2HrPostPrandial\":\"Short\", \"systolicBP_1stReading\":\"Short\", "
					+ "\"diastolicBP_1stReading\":\"Short\", \"systolicBP_2ndReading\":\"Short\", \"diastolicBP_2ndReading\":\"Short\", "
					+ "\"systolicBP_3rdReading\":\"Short\", \"diastolicBP_3rdReading\":\"Short\","
					+ " \"hbA1C\":\"Short\",\"hemoglobin\":\"Short\",\"createdBy\":\"String\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("saveBenVitalDetail request:" + requestObj);
		BenCancerVitalDetail benCancerVitalDetail = InputMapper.gson().fromJson(requestObj, BenCancerVitalDetail.class);
		try {
			Long responseObj = nurseServiceImpl.saveBenVitalDetail(benCancerVitalDetail);
			if (responseObj != null && responseObj > 0) {
				response.setResponse("Beneficiary Vital Details Stored Successfully");
			} else {
				response.setError(500, "Failed to Store Beneficiary Vital Details");
			}
			logger.info("saveBenVitalDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveBenVitalDetail:" + e);
		}

		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "save Beneficiary Physical Vital Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/vitalScreen/benPhysicalVitalDetail" }, method = { RequestMethod.POST })
	public String saveBenPhysicalVitalDetail(@RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("saveBenPhysicalVitalDetail request:" + requestObj);

		BenAnthropometryDetail benAnthropometryDetail = InputMapper.gson().fromJson(requestObj,
				BenAnthropometryDetail.class);
		BenPhysicalVitalDetail benPhysicalVitalDetail = InputMapper.gson().fromJson(requestObj,
				BenPhysicalVitalDetail.class);

		try {
			Long responseObj = nurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(benAnthropometryDetail);
			Long responseObj2 = nurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(benPhysicalVitalDetail);
			if (responseObj != null && responseObj > 0 && responseObj2 != null && responseObj2 > 0) {
				response.setResponse("Beneficiary Physical Vital Details Stored Successfully");
			} else {
				response.setError(500, "Failed to Store Beneficiary Physical Vital Details");
			}
			logger.info("saveBenPhysicalVitalDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveBenPhysicalVitalDetail:" + e);
		}

		return response.toString();
	}

}
