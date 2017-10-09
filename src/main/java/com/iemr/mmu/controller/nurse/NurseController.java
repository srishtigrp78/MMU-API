package com.iemr.mmu.controller.nurse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

@Controller
@RequestMapping("/nurse")
public class NurseController {

	private InputMapper inputMapper;
	private OutputResponse response;

	private NurseServiceImpl nurseServiceImpl;

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
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

		response = new OutputResponse();
		inputMapper = new InputMapper();

		BeneficiaryVisitDetail beneficiaryVisitDetail = InputMapper.gson().fromJson(requestObj,
				BeneficiaryVisitDetail.class);
		try {
			Long benVisitID = nurseServiceImpl.saveBeneficiaryVisitDetails(beneficiaryVisitDetail);
			if (benVisitID != null && benVisitID > 0) {
				System.out.println("hellooo");
				Map<String, Long> resMap = new HashMap<String, Long>();
				resMap.put("benVisitID", benVisitID);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(0, "Failed to Store Beneficiary Visit Details");
				System.out.println("hellooo");
			}
			System.out.println("hellooo");
		} catch (Exception e) {
			response.setError(e);
			System.out.println("hellooo");
		}

		System.out.println(response.toString());
		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/historyScreen/benFamilyCancerHistory" }, method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String saveBenFamilyCancerHistory(@RequestBody String requestObj) {

		response = new OutputResponse();

		try {
			BenFamilyCancerHistory[] benFamilyCancerHistoryArray = InputMapper.gson().fromJson(requestObj,
					BenFamilyCancerHistory[].class);

			List<BenFamilyCancerHistory> benFamilyCancerHistoryList = Arrays.asList(benFamilyCancerHistoryArray);

			if (benFamilyCancerHistoryList.size() > 0) {
				int responseData = nurseServiceImpl.saveBenFamilyCancerHistory(benFamilyCancerHistoryList);
				if (responseData > 0) {
					response.setResponse("Beneficiary benFamily Data saved successfully.");
				} else {
					response.setError(0, "Data not saved successfully. Please see log file for detailed info");
				}
			} else {
				response.setError(0, "There is no data to save");
			}
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/historyScreen/benObstetricCancerHistory" }, method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String saveBenObstetricCancerHistory(@RequestBody String requestObj) {

		response = new OutputResponse();

		try {
			BenObstetricCancerHistory benObstetricCancerHistory = InputMapper.gson().fromJson(requestObj,
					BenObstetricCancerHistory.class);

			Long responseObj = nurseServiceImpl.saveBenObstetricCancerHistory(benObstetricCancerHistory);
			if (responseObj != null && responseObj > 0) {
				response.setResponse("Beneficiary Obstetric Cancer History Details Stored Successfully");
			} else {
				response.setResponse("Failed to Store Beneficiary Obstetric Cancer History Details");
			}
			response.setResponse(response.toString());
		} catch (Exception e) {
			response.setError(e);
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

		response = new OutputResponse();
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
				response.setResponse("Failed to Store Beneficiary Personal Cancer History Details");
			}
			response.setResponse(response.toString());
		} catch (Exception e) {
			response.setError(e);
		}
		System.out.println(response.toString());
		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/vitalScreen/benVitalDetail" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String saveBenVitalDetail(@RequestBody String requestObj) {

		response = new OutputResponse();

		BenCancerVitalDetail benCancerVitalDetail = InputMapper.gson().fromJson(requestObj, BenCancerVitalDetail.class);
		try {
			Long responseObj = nurseServiceImpl.saveBenVitalDetail(benCancerVitalDetail);
			if (responseObj != null && responseObj > 0) {
				response.setResponse("Beneficiary Vital Details Stored Successfully");
			} else {
				response.setResponse("Failed to Store Beneficiary Vital Details");
			}
			response.setResponse(response.toString());
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}

}
