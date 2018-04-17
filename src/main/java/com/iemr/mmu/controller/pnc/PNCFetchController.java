package com.iemr.mmu.controller.pnc;

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

import com.iemr.mmu.service.pnc.PNCServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @author NA874500
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/PNC", headers = "Authorization")
public class PNCFetchController
{
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	private PNCServiceImpl pncServiceImpl;
	
	@Autowired
	public void setPncServiceImpl(PNCServiceImpl pncServiceImpl)
	{
		this.pncServiceImpl = pncServiceImpl;
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Visit details from Nurse PNC", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenVisitDetailsFrmNursePNC" }, method = { RequestMethod.POST })
	@Transactional(rollbackFor = Exception.class)
	public String getBenVisitDetailsFrmNursePNC(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenVisitDetailsFrmNursePNC request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String res = pncServiceImpl.getBenVisitDetailsFrmNursePNC(benRegID, benVisitID);
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
	@ApiOperation(value = "Get Beneficiary PNC Care details from Nurse PNC", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenPNCDetailsFrmNursePNC" }, method = { RequestMethod.POST })
	@Transactional(rollbackFor = Exception.class)
	public String getBenPNCDetailsFrmNursePNC(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenPNCDetailsFrmNursePNC request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID") && obj.has("benVisitID")) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String res = pncServiceImpl.getBenPNCDetailsFrmNursePNC(benRegID, benVisitID);
				response.setResponse(res);
			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenPNCDetailsFrmNursePNC response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenPNCDetailsFrmNursePNC:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary PNC History details from Nurse to Doctor ", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenHistoryDetails" }, method = { RequestMethod.POST })

	public String getBenHistoryDetails(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenHistoryDetails request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID") && obj.has("benVisitID")) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String s = pncServiceImpl.getBenHistoryDetails(benRegID, benVisitID);
				response.setResponse(s);
			} else {
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenHistoryDetails response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenHistoryDetails:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary vital details from Nurse PNC", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenVitalDetailsFrmNurse" }, method = { RequestMethod.POST })
	public String getBenVitalDetailsFrmNurse(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenVitalDetailsFrmNurse request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID") && obj.has("benVisitID")) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String res = pncServiceImpl.getBeneficiaryVitalDetails(benRegID, benVisitID);
				response.setResponse(res);
			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenVitalDetailsFrmNurse response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenVitalDetailsFrmNurse:" + e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary PNC Examination details from Nurse to Doctor ", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenExaminationDetailsPNC" }, method = { RequestMethod.POST })

	public String getBenExaminationDetailsPNC(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenExaminationDetailsPNC request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID") && obj.has("benVisitID")) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String s = pncServiceImpl.getPNCExaminationDetailsData(benRegID, benVisitID);
				response.setResponse(s);
			} else {
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenExaminationDetailsPNC response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenExaminationDetailsPNC:" + e);
		}
		return response.toString();
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
				String s = pncServiceImpl.getPastHistoryData(benRegID);
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
	public String getBenTobaccoHistory(@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenTobaccoHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = pncServiceImpl.getPersonalTobaccoHistoryData(benRegID);
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
	public String getBenAlcoholHistory(@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenAlcoholHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = pncServiceImpl.getPersonalAlcoholHistoryData(benRegID);
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
	public String getBenAllergyHistory(@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenAllergyHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = pncServiceImpl.getPersonalAllergyHistoryData(benRegID);
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
				String s = pncServiceImpl.getMedicationHistoryData(benRegID);
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
	public String getBenFamilyHistory(@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenFamilyHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = pncServiceImpl.getFamilyHistoryData(benRegID);
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
				String s = pncServiceImpl.getMenstrualHistoryData(benRegID);
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
				String s = pncServiceImpl.getObstetricHistoryData(benRegID);
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
				String s = pncServiceImpl.getComorbidHistoryData(benRegID);
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
				String s = pncServiceImpl.getChildVaccineHistoryData(benRegID);
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
	@ApiOperation(value = "Get Beneficiary Child Vaccine(Immunization) Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenChildVaccineHistory" }, method = { RequestMethod.POST })
	public String getBenImmunizationHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenImmunizationHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = pncServiceImpl.getImmunizationHistoryData(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenImmunizationHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenImmunizationHistory:" + e);
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
				String s = pncServiceImpl.getBenPerinatalHistoryData(benRegID);
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
	public String getBenFeedingHistory(@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenFeedingHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = pncServiceImpl.getBenFeedingHistoryData(benRegID);
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
				String s = pncServiceImpl.getBenDevelopmentHistoryData(benRegID);
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
	
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Doctor Entered Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenCaseRecordFromDoctorPNC" }, method = { RequestMethod.POST })
	@Transactional(rollbackFor = Exception.class)
	public String getBenCaseRecordFromDoctorPNC(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenCaseRecordFromDoctorPNC request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (null != obj && obj.length() > 1 && obj.has("benRegID") && obj.has("benVisitID")) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String res = pncServiceImpl.getBenCaseRecordFromDoctorPNC(benRegID, benVisitID);
				response.setResponse(res);
			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenCaseRecordFromDoctorPNC response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenCaseRecordFromDoctorPNC:" + e);
		}
		return response.toString();
	}

}
