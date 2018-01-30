package com.iemr.mmu.controller.anc;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.anc.ANCServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @author NA874500
 * @Objective Fetch ANC Nurse data.
 * @Date 19-01-2018
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value =  "/ANC", headers = "Authorization")
public class ANCFetchController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	private ANCServiceImpl ancServiceImpl;

	@Autowired
	public void setAncServiceImpl(ANCServiceImpl ancServiceImpl) {
		this.ancServiceImpl = ancServiceImpl;
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Visit details from Nurse ANC", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenVisitDetailsFrmNurseANC" }, method = { RequestMethod.POST })
	@Transactional(rollbackFor = Exception.class)
	public String getBenVisitDetailsFrmNurseANC(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenVisitDetailsFrmNurseANC request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String res = ancServiceImpl.getBenVisitDetailsFrmNurseANC(benRegID, benVisitID);
				response.setResponse(res);
			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenDataFrmNurseScrnToDocScrnVisitDetails response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataFrmNurseScrnToDocScrnVisitDetails:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC Care details from Nurse ANC", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenANCDetailsFrmNurseANC" }, method = { RequestMethod.POST })
	@Transactional(rollbackFor = Exception.class)
	public String getBenANCDetailsFrmNurseANC(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenANCDetailsFrmNurseANC request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID") && obj.has("benVisitID")) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String res = ancServiceImpl.getBenANCDetailsFrmNurseANC(benRegID, benVisitID);
				response.setResponse(res);
			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenANCDetailsFrmNurseANC response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenANCDetailsFrmNurseANC:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC History details from Nurse to Doctor ", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenANCHistoryDetails" }, method = { RequestMethod.POST })

	public String getBenANCHistoryDetails(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenANCHistoryDetails request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID") && obj.has("benVisitID")) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String s = ancServiceImpl.getBenANCHistoryDetails(benRegID, benVisitID);
				response.setResponse(s);
			} else {
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenANCHistoryDetails response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenANCHistoryDetails:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC vital details from Nurse ANC", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenANCVitalDetailsFrmNurseANC" }, method = { RequestMethod.POST })
	public String getBenANCVitalDetailsFrmNurseANC(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenANCVitalDetailsFrmNurseANC request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID") && obj.has("benVisitID")) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String res = ancServiceImpl.getBeneficiaryVitalDetails(benRegID, benVisitID);
				response.setResponse(res);
			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenANCVitalDetailsFrmNurseANC response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenANCVitalDetailsFrmNurseANC:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC Examination details from Nurse to Doctor ", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenExaminationDetailsANC" }, method = { RequestMethod.POST })

	public String getBenExaminationDetailsANC(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenExaminationDetailsANC request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID") && obj.has("benVisitID")) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String s = ancServiceImpl.getANCExaminationDetailsData(benRegID, benVisitID);
				response.setResponse(s);
			} else {
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenExaminationDetailsANC response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenExaminationDetailsANC:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC Past History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenANCPastHistory" }, method = { RequestMethod.POST })
	public String getBenANCPastHistory(@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenANCPastHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = ancServiceImpl.getANCPastHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenANCPastHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenANCPastHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC Tobacco History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenANCTobaccoHistory" }, method = { RequestMethod.POST })
	public String getBenANCTobaccoHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenANCTobaccoHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = ancServiceImpl.getANCPersonalTobaccoHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenANCTobaccoHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenANCTobaccoHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC Alcohol History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenANCAlcoholHistory" }, method = { RequestMethod.POST })
	public String getBenANCAlcoholHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenANCAlcoholHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = ancServiceImpl.getANCPersonalAlcoholHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenANCAlcoholHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenANCAlcoholHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC Allergy History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenANCAllergyHistory" }, method = { RequestMethod.POST })
	public String getBenANCAllergyHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenANCAllergyHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = ancServiceImpl.getANCPersonalAllergyHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenANCAllergyHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenANCAllergyHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC Medication History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenANCMedicationHistory" }, method = { RequestMethod.POST })
	public String getBenANCMedicationHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenANCMedicationHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = ancServiceImpl.getANCImmunizationHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenANCMedicationHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenANCMedicationHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC Family History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenANCFamilyHistory" }, method = { RequestMethod.POST })
	public String getBenANCFamilyHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenANCFamilyHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = ancServiceImpl.getANCFamilyHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenANCFamilyHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenANCFamilyHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC Menstrual History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenANCMenstrualHistory" }, method = { RequestMethod.POST })
	public String getBenANCMenstrualHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenANCMenstrualHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = ancServiceImpl.getANCMenstrualHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenANCMenstrualHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenANCMenstrualHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC past Obstetric History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenANCPastObstetricHistory" }, method = { RequestMethod.POST })
	public String getBenANCPastObstetricHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenANCPastObstetricHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = ancServiceImpl.getANCObstetricHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenANCPastObstetricHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenANCPastObstetricHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC Comorbidity Condition Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenANCComorbidityConditionHistory" }, method = { RequestMethod.POST })
	public String getBenANCComorbidityConditionHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenANCComorbidityConditionHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = ancServiceImpl.getANCComorbidHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenANCComorbidityConditionHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenANCComorbidityConditionHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC Optional Vaccine Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenANCOptionalVaccineHistory" }, method = { RequestMethod.POST })
	public String getBenANCOptionalVaccineHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenANCOptionalVaccineHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = ancServiceImpl.getANCChildVaccineHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenANCOptionalVaccineHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenANCOptionalVaccineHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC Child Vaccine(Immunization) Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenANCChildVaccineHistory" }, method = { RequestMethod.POST })
	public String getBenANCImmunizationHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenANCImmunizationHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = ancServiceImpl.getANCImmunizationHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenANCImmunizationHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenANCImmunizationHistory:" + e);
		}
		return response.toString();
	}

}
