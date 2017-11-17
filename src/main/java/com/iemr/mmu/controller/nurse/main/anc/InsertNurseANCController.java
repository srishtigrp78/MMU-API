package com.iemr.mmu.controller.nurse.main.anc;

import java.sql.Date;
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
import com.google.gson.JsonObject;
import com.iemr.mmu.controller.nurse.main.cancerScreening.InsertNurseCSController;
import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.ANCWomenVaccineDetail;
import com.iemr.mmu.data.anc.WrapperANCCareDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.anc.ANCServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/anc" })
public class InsertNurseANCController {
	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(InsertNurseANCController.class);
	
	private ANCServiceImpl ancServiceImpl;
	
	@Autowired
	public void setAncServiceImpl(ANCServiceImpl ancServiceImpl) {
		this.ancServiceImpl = ancServiceImpl;
	}
	
	@CrossOrigin
	@ApiOperation(value = "save Beneficiary ANC Care Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/ancScreen/ancCare" }, method = { RequestMethod.POST })
	public String saveBeneficiaryANCCareDetail(
			@ApiParam(value = "{\"ANCCareDetail\":{\"beneficiaryRegID\":\"Long\", \"benVisitID\": \"Long\", \"providerServiceMapID\": \"Integer\","
					+ "\"visitNo\":\"Short\", \"comolaintType\":\"String\", \"duration\":\"String\", \"description\":\"String\","
					+ "\"aNCRegistrationDate\":\"Timestamp\", \"aNCVisitNumber\":\"Short\", \"lastMenstrualPeriod_LMP\":\"Timestamp\","
					+ "\"gestationalAgeOrPeriodofAmenorrhea_POA\":\"Short\", \"trimesterNumber\":\"Short\", \"expectedDateofDelivery\":\"Timestamp\","
					+ "\"primiGravida\":\"Boolean\", \"obstetricFormula\":\"String\", \"gravida_G\":\"Short\", \"termDeliveries_T\":\"Short\", "
					+ "\"pretermDeliveries_P\":\"Short\", \"abortions_A\":\"Short\", \"livebirths_L\":\"Short\", \"bloodGroup\":\"String\","
					+ " \"createdBy\":\"String\"}, \"ANCWomenVaccineDetail\":[{\"beneficiaryRegID\":\"Long\", \"vaccineName\":\"String\", "
					+ "\"status\":\"String\", \"receivedDate\":\"Timestamp\", \"receivedFacilityName\":\"String\"}]}") @RequestBody String requestObj) {	
		
		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("saveBeneficiaryANCCareDetail request:" + requestObj);
		
		WrapperANCCareDetail ancCareDetails = InputMapper.gson().fromJson(requestObj, WrapperANCCareDetail.class);
		
		
		try {
			Long ancCareID = ancServiceImpl.saveBeneficiaryANCDetails(ancCareDetails.getAncCareDetails());
			Long ancWomenVaccineID =  ancServiceImpl.saveANCWomenVaccineDetails(ancCareDetails.getAncWomenVaccineDetail());
			if (ancCareID != null && ancCareID > 0 && ancWomenVaccineID != null  && ancWomenVaccineID > 0) {
				response.setResponse("Beneficiary ANC Care Details stored successfully");
			} else {
				response.setError(500, "Failed to Store Beneficiary ANC Care Details");
			}
			logger.info("saveBeneficiaryANCCareDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveBeneficiaryANCCareDetail:" + e);
		}

		return response.toString();
	}

}
