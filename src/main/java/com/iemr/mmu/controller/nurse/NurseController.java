package com.iemr.mmu.controller.nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;

	@Autowired
	private NurseServiceImpl nurseServiceImpl;

	@CrossOrigin
	@RequestMapping(value = { "/testrest" }, method = { RequestMethod.POST }, produces = { "application/json" })
	public String testRestTemplate(@RequestBody String comingRequest) {
		NurseServiceImpl n = new NurseServiceImpl();
		String s = n.savePatientVisitDetails();
		System.out.println();

		return "hello...";
	}

	@CrossOrigin
	@RequestMapping(value = { "/testrest1" }, method = { RequestMethod.POST }, produces = { "application/json" })
	public String testRest1(@RequestBody String comingRequest) {
		return "hello...";
	}

	@CrossOrigin
	@RequestMapping(value = { "/testrest2" }, method = { RequestMethod.POST }, produces = { "application/json" })
	public String testRest2(@RequestBody String comingRequest) {
		response = new OutputResponse();
		return "hello";
	}

	@CrossOrigin
	@RequestMapping(value = { "/testrest3" }, method = { RequestMethod.POST }, produces = { "application/json" })
	public String testRest3(@RequestBody String comingRequest) {
		return "hello...";
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/visitDetailScreen/VisitDetail" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String saveBeneficiaryVisitDetail(@RequestBody String requestObj) {

		response = new OutputResponse();

		BeneficiaryVisitDetail beneficiaryVisitDetail = InputMapper.gson().fromJson(requestObj,
				BeneficiaryVisitDetail.class);
		try {
			BeneficiaryVisitDetail responseObj = nurseServiceImpl.saveBeneficiaryVisitDetails(beneficiaryVisitDetail);
			if (responseObj.getBenVisitID() > 0) {
				System.out.println("hellooo");
				response.setResponse("Beneficiary Visit Details Stored Successfully");
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

		BenFamilyCancerHistory benFamilyCancerHistory = InputMapper.gson().fromJson(requestObj,
				BenFamilyCancerHistory.class);
		try {
			BenFamilyCancerHistory responseObj = nurseServiceImpl.saveBenFamilyCancerHistory(benFamilyCancerHistory);
			if (responseObj.getID() > 0) {
				response.setResponse("Beneficiary Family Cancer History Details Stored Successfully");
			} else {
				response.setResponse("Failed to Store Beneficiary Family Cancer History Details");
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

		BenObstetricCancerHistory benObstetricCancerHistory = InputMapper.gson().fromJson(requestObj,
				BenObstetricCancerHistory.class);
		try {
			BenObstetricCancerHistory responseObj = nurseServiceImpl
					.saveBenObstetricCancerHistory(benObstetricCancerHistory);
			if (responseObj.getID() > 0) {
				response.setResponse("Beneficiary Obstetric Cancer History Details Stored Successfully");
			} else {
				response.setResponse("Failed to Store Beneficiary Obstetric Cancer History Details");
			}
			response.setResponse(response.toString());
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/historyScreen/benPersonalCancerDietHistory" }, method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String saveBenPersonalCancerDietHistory(@RequestBody String requestObj) {

		response = new OutputResponse();

		BenPersonalCancerDietHistory benPersonalCancerDietHistory = InputMapper.gson().fromJson(requestObj,
				BenPersonalCancerDietHistory.class);
		try {
			BenPersonalCancerDietHistory responseObj = nurseServiceImpl
					.saveBenPersonalCancerDietHistory(benPersonalCancerDietHistory);
			if (responseObj.getID() > 0) {
				response.setResponse("Beneficiary Personal Cancer Diet History Details Stored Successfully");
			} else {
				response.setResponse("Failed to Store Beneficiary Personal Cancer Diet History Details");
			}
			response.setResponse(response.toString());
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/historyScreen/benPersonalCancerHistory" }, method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String saveBenPersonalCancerHistory(@RequestBody String requestObj) {

		response = new OutputResponse();

		BenPersonalCancerHistory benPersonalCancerHistory = InputMapper.gson().fromJson(requestObj,
				BenPersonalCancerHistory.class);
		try {
			BenPersonalCancerHistory responseObj = nurseServiceImpl
					.saveBenPersonalCancerHistory(benPersonalCancerHistory);
			if (responseObj.getID() > 0) {
				response.setResponse("Beneficiary Personal Cancer History Details Stored Successfully");
			} else {
				response.setResponse("Failed to Store Beneficiary Personal Cancer History Details");
			}
			response.setResponse(response.toString());
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/vitalScreen/benVitalDetail" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String saveBenVitalDetail(@RequestBody String requestObj) {

		response = new OutputResponse();

		BenCancerVitalDetail benCancerVitalDetail = InputMapper.gson().fromJson(requestObj, BenCancerVitalDetail.class);
		try {
			BenCancerVitalDetail responseObj = nurseServiceImpl.saveBenVitalDetail(benCancerVitalDetail);
			if (responseObj.getID() > 0) {
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
