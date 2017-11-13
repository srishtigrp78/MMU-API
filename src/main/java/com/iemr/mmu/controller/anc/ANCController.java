package com.iemr.mmu.controller.anc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.controller.doctor.DoctorController;
import com.iemr.mmu.service.masterservice.DoctorMasterDataService;
import com.iemr.mmu.service.masterservice.DoctorMasterDataServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping({ "/anc" })
public class ANCController {
	
	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	@CrossOrigin()
	@ApiOperation(value = "provides master Data for ANC Screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/ancMasterData" }, method = { RequestMethod.POST })
	public String getMasterDataForANC() {

		OutputResponse response = new OutputResponse();
		logger.info("getMasterDataForANC..");
		try {
			//response.setResponse(doctorMasterDataServiceImpl.getDoctorMasterData());
			logger.info("getMasterDataForANC response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getMasterDataForANC:" + e);
		}
		return response.toString();
	}

}
