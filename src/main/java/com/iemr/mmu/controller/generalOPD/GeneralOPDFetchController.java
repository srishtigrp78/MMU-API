package com.iemr.mmu.controller.generalOPD;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.generalOPD.GeneralOPDServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin
@RequestMapping(value = "/generalOPD", headers = "Authorization")
public class GeneralOPDFetchController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	private GeneralOPDServiceImpl generalOPDServiceImpl;

	@Autowired
	public void setGeneralOPDServiceImpl(GeneralOPDServiceImpl generalOPDServiceImpl) {
		this.generalOPDServiceImpl = generalOPDServiceImpl;
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Past History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenPastHistory" }, method = { RequestMethod.POST })
	public String getBenPastHistory(@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenPastHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = generalOPDServiceImpl.getPastHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenPastHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenPastHistory:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Tobacco History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenTobaccoHistory" }, method = { RequestMethod.POST })
	public String getBenTobaccoHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenTobaccoHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = generalOPDServiceImpl.getPersonalTobaccoHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenTobaccoHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenTobaccoHistory:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Alcohol History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenAlcoholHistory" }, method = { RequestMethod.POST })
	public String getBenAlcoholHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenAlcoholHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = generalOPDServiceImpl.getPersonalAlcoholHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenAlcoholHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenAlcoholHistory:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Allergy History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenAllergyHistory" }, method = { RequestMethod.POST })
	public String getBenAllergyHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenAllergyHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = generalOPDServiceImpl.getPersonalAllergyHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenAllergyHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenAllergyHistory:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Medication History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenMedicationHistory" }, method = { RequestMethod.POST })
	public String getBenMedicationHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenMedicationHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = generalOPDServiceImpl.getMedicationHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenMedicationHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenMedicationHistory:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Family History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenFamilyHistory" }, method = { RequestMethod.POST })
	public String getBenFamilyHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenFamilyHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = generalOPDServiceImpl.getFamilyHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenFamilyHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenFamilyHistory:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Menstrual History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenMenstrualHistory" }, method = { RequestMethod.POST })
	public String getBenMenstrualHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenMenstrualHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = generalOPDServiceImpl.getMenstrualHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenMenstrualHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenMenstrualHistory:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary past Obstetric History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenPastObstetricHistory" }, method = { RequestMethod.POST })
	public String getBenPastObstetricHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenPastObstetricHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = generalOPDServiceImpl.getObstetricHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenPastObstetricHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenPastObstetricHistory:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Comorbidity Condition Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenComorbidityConditionHistory" }, method = { RequestMethod.POST })
	public String getBenComorbidityConditionHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenComorbidityConditionHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = generalOPDServiceImpl.getComorbidHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenComorbidityConditionHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenComorbidityConditionHistory:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Optional Vaccine Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenOptionalVaccineHistory" }, method = { RequestMethod.POST })
	public String getBenOptionalVaccineHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenOptionalVaccineHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = generalOPDServiceImpl.getChildVaccineHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenOptionalVaccineHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenOptionalVaccineHistory:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Perinatal History Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenPerinatalHistory" }, method = { RequestMethod.POST })
	public String getBenPerinatalHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenPerinatalHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = generalOPDServiceImpl.getBenPerinatalHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenPerinatalHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenPerinatalHistory:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Child Feeding History Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenFeedingHistory" }, method = { RequestMethod.POST })
	public String getBenFeedingHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenFeedingHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = generalOPDServiceImpl.getBenFeedingHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenFeedingHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenFeedingHistory:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Child Development History Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenDevelopmentHistory" }, method = { RequestMethod.POST })
	public String getBenDevelopmentHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenDevelopmentHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = generalOPDServiceImpl.getBenDevelopmentHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenDevelopmentHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDevelopmentHistory:" + e);
		}
		return response.toString();
	}
}
