package com.iemr.mmu.controller.nurse;

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
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.masterservice.NurseMasterDataService;
import com.iemr.mmu.service.masterservice.NurseMasterDataServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

@CrossOrigin
@RestController
@RequestMapping({ "/nurse" })
public class NurseController {

	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(NurseController.class);

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
	@RequestMapping(value = { "/testrest" }, method = { RequestMethod.POST }, produces = { "application/json" })
	public String testRestTemplate(@RequestBody String comingRequest) {
		NurseServiceImpl n = new NurseServiceImpl();
		String s = n.savePatientVisitDetails();
		System.out.println();

		return "hello...";
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/visitDetailScreen/VisitDetail" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String saveBeneficiaryVisitDetail(@RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("saveBeneficiaryVisitDetail request:" + requestObj);
		BeneficiaryVisitDetail beneficiaryVisitDetail = InputMapper.gson().fromJson(requestObj,
				BeneficiaryVisitDetail.class);
		try {
			Long benVisitID = nurseServiceImpl.saveBeneficiaryVisitDetails(beneficiaryVisitDetail);
			if (benVisitID != null && benVisitID > 0) {
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
	@RequestMapping(value = { "/save/historyScreen/benFamilyCancerHistory" }, method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String saveBenFamilyCancerHistory(@RequestBody String requestObj) {

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
	@RequestMapping(value = { "/save/historyScreen/benObstetricCancerHistory" }, method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String saveBenObstetricCancerHistory(@RequestBody String requestObj) {

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
		System.out.println(response.toString());
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
	@RequestMapping(value = { "/save/historyScreen/benPersonalCancerHistory" }, method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String saveBenPersonalCancerHistory(@RequestBody String requestObj) {

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
		System.out.println(response.toString());
		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/vitalScreen/benVitalDetail" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String saveBenVitalDetail(@RequestBody String requestObj) {

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

	@CrossOrigin()
	@RequestMapping(value = { "/nurseMasterData" }, method = { RequestMethod.POST }, produces = { "application/json" })
	public String masterDataForNurse() {

		OutputResponse response = new OutputResponse();
		logger.info("getting Nurse Master Data ");
		try {
			response.setResponse(nurseMasterDataServiceImpl.getNurseMasterData());
			logger.info("masterDataForNurse response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in masterDataForNurse :" + e);
		}
		return response.toString();
	}

	/**
	 * Fething beneficiary data filled by Nurse for Doctor screen...
	 */

	@CrossOrigin()
	@RequestMapping(value = { "/getBenDataFrmNurseToDocVisitDetailsScreen" }, method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String getBenDataFrmNurseScrnToDocScrnVisitDetails(@RequestBody String comingRequest) {
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
	@RequestMapping(value = { "/getBenDataFrmNurseToDocHistoryScreen" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String getBenDataFrmNurseScrnToDocScrnHistory(@RequestBody String comingRequest) {
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
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = { "/getBenDataFrmNurseToDocVitalScreen" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String getBenDataFrmNurseScrnToDocScrnVital(@RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String s = nurseServiceImpl.getBenDataFrmNurseToDocVitalScreen(benRegID, benVisitID);
				response.setResponse(s);
			} else {

			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataFrmNurseScrnToDocScrnHistory:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = { "/getNurseWorklist" }, method = { RequestMethod.GET }, produces = { "application/json" })
	public String getNurseWorkList() {
		OutputResponse response = new OutputResponse();
		try {
			String s = nurseServiceImpl.getNurseWorkList();
			response.setResponse(s);
		} catch (Exception e) {
			e.printStackTrace();
			response.setError(e);
		}
		return response.toString();
	}

}
