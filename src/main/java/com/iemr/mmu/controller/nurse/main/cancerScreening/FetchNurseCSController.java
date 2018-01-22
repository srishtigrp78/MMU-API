package com.iemr.mmu.controller.nurse.main.cancerScreening;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.common.master.NurseMasterDataService;
import com.iemr.mmu.service.common.master.NurseMasterDataServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping(value = "/nurse", headers = "Authorization")
/**
 * Objective: Performs fetching Beneficiary Cancer Screening Details entered by
 * nurse
 */
public class FetchNurseCSController {
	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(FetchNurseCSController.class);

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

	/**
	 * Fething beneficiary data filled by Nurse for Doctor screen...
	 */

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Visit details from Nurse screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenDataFrmNurseToDocVisitDetailsScreen" }, method = { RequestMethod.POST })
	public String getBenDataFrmNurseScrnToDocScrnVisitDetails(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getBenDataFrmNurseScrnToDocScrnVisitDetails request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String s = nurseServiceImpl.getBenDataFrmNurseToDocVisitDetailsScreen(benRegID, benVisitID);
				response.setResponse(s);
			} else {

			}
			logger.info("getBenDataFrmNurseScrnToDocScrnVisitDetails response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataFrmNurseScrnToDocScrnVisitDetails:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Cancer History details from Nurse screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenDataFrmNurseToDocHistoryScreen" }, method = { RequestMethod.POST })
	public String getBenDataFrmNurseScrnToDocScrnHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getBenDataFrmNurseScrnToDocScrnHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String s = nurseServiceImpl.getBenDataFrmNurseToDocHistoryScreen(benRegID, benVisitID);
				response.setResponse(s);
			} else {

			}
			logger.info("getBenDataFrmNurseScrnToDocScrnHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataFrmNurseScrnToDocScrnHistory:" + e);
		}
		// System.out.println(response.toString());
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Vital details from Nurse screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenDataFrmNurseToDocVitalScreen" }, method = { RequestMethod.POST })
	public String getBenDataFrmNurseScrnToDocScrnVital(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getBenDataFrmNurseToDocVitalScreen request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String s = nurseServiceImpl.getBenDataFrmNurseToDocVitalScreen(benRegID, benVisitID);
				response.setResponse(s);
			} else {

			}
			logger.info("getBenDataFrmNurseToDocVitalScreen response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataFrmNurseToDocVitalScreen:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Nurse worklist", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getNurseWorklist" }, method = { RequestMethod.GET })
	public String getNurseWorkList() {
		OutputResponse response = new OutputResponse();
		try {
			String s = nurseServiceImpl.getNurseWorkList();
			response.setResponse(s);
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("Error in getNurseWorklist:" + e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Fetch Beneficiary Physical Vital Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/get/vitalScreen/benPhysicalVitalDetail" }, method = { RequestMethod.POST })
	public String getBenPhysicalVitalDetail(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("getBenPhysicalVitalDetail request:" + requestObj);

		try {
			JSONObject obj = new JSONObject(requestObj);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");
				if (null != benRegID && benRegID > 0 && null != benVisitID && benVisitID > 0) {

					String physicalVitalDetails = nurseServiceImpl.getBeneficiaryVitalDetails(benRegID, benVisitID);
					if (physicalVitalDetails != null) {
						response.setResponse(physicalVitalDetails);
					} else {
						response.setError(500, "Failed to Fetch Beneficiary Physical Vital Details");
					}
					logger.info("getBenPhysicalVitalDetail response:" + response);

				} else {
					response.setError(0, "Data Not Sufficient...");
				}
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenPhysicalVitalDetail:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Cancer Family History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenCancerFamilyHistory" }, method = { RequestMethod.POST })
	public String getBenCancerFamilyHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenCancerFamilyHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = nurseServiceImpl.getBenCancerFamilyHistory(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenCancerFamilyHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenCancerFamilyHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Cancer Personal History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenCancerPersonalHistory" }, method = { RequestMethod.POST })
	public String getBenCancerPersonalHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenCancerPersonalHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = nurseServiceImpl.getBenCancerPersonalHistory(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenCancerPersonalHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenCancerPersonalHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Cancer Personal Diet History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenCancerPersonalDietHistory" }, method = { RequestMethod.POST })
	public String getBenCancerPersonalDietHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenCancerPersonalDietHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = nurseServiceImpl.getBenCancerPersonalDietHistory(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenCancerPersonalDietHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenCancerPersonalDietHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Cancer Obstetric History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenCancerObstetricHistory" }, method = { RequestMethod.POST })
	public String getBenCancerObstetricHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenCancerObstetricHistory request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID")) {
				Long benRegID = obj.getLong("benRegID");
				String s = nurseServiceImpl.getBenCancerObstetricHistory(benRegID);
				response.setResponse(s);

			} else {
				logger.info("Invalid Request Data.");
				response.setError(5000, "Invalid Request Data !!!");
			}
			logger.info("getBenCancerObstetricHistory response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenCancerObstetricHistory:" + e);
		}
		return response.toString();
	}
}
