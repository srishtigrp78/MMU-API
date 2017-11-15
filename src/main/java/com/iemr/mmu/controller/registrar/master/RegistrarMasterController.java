package com.iemr.mmu.controller.registrar.master;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
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
import com.google.gson.JsonObject;
import com.iemr.mmu.data.registrar.BeneficiaryData;
import com.iemr.mmu.data.registrar.V_BenAdvanceSearch;
import com.iemr.mmu.data.registrar.WrapperBeneficiaryRegistration;
import com.iemr.mmu.service.masterservice.RegistrarServiceMasterDataImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.service.registrar.RegistrarServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/registrar" })
/** Objective: Get Registration related master Data*/
public class RegistrarMasterController {
	
	private Logger logger = LoggerFactory.getLogger(RegistrarMasterController.class);
	private RegistrarServiceMasterDataImpl registrarServiceMasterDataImpl;


	@Autowired
	public void setRegistrarServiceMasterDataImpl(RegistrarServiceMasterDataImpl registrarServiceMasterDataImpl) {
		this.registrarServiceMasterDataImpl = registrarServiceMasterDataImpl;
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Master Data for Registrar", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/registrarMasterData" }, method = { RequestMethod.POST })
	public String masterDataForRegistration(
			@ApiParam(value = "{\"spID\": \"Integer\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("masterDataForRegistration request :" + comingRequest);
		try {

			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("spID")) {
				if (obj.getInt("spID") > 0) {
					response.setResponse(registrarServiceMasterDataImpl.getRegMasterData());
				} else {
					response.setError(500, "Invalid Service-Point...");
				}
			} else {
				response.setError(500, "Bad Request... Service-Point is not there in request");
			}
			logger.info("masterDataForRegistration response :" + response);

		} catch (Exception e) {
			logger.error("Error in masterDataForRegistration :" + e);
			response.setError(e);
		}
		return response.toString();
	}
}
