package com.iemr.mmu.controller.common.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.controller.cancerscreening.CancerScreeningCreateController;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping({ "/common" })
public class FetchCommonController {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	private CommonDoctorServiceImpl commonDoctorServiceImpl;
	private CommonNurseServiceImpl commonNurseServiceImpl;
	
	@Autowired
	public void setCommonDoctorServiceImpl(CommonDoctorServiceImpl commonDoctorServiceImpl)
	{
		this.commonDoctorServiceImpl = commonDoctorServiceImpl;
	}
	
	@Autowired
	public void setCommonNurseServiceImpl(CommonNurseServiceImpl commonNurseServiceImpl)
	{
		this.commonNurseServiceImpl = commonNurseServiceImpl;
	}
	
	@CrossOrigin()
	@ApiOperation(value = "provides doctor worklist", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getDocWorklist" }, method = { RequestMethod.GET })
	public String getDocWorkList() {
		OutputResponse response = new OutputResponse();
		try {
			String s = commonDoctorServiceImpl.getDocWorkList();
			response.setResponse(s);
		} catch (Exception e) {
			logger.error("Error in getDocWorkList:" + e);
			response.setError(e);
		}
		return response.toString();
	}
	
	
	
	@CrossOrigin()
	@ApiOperation(value = "Get Nurse worklist", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getNurseWorklist" }, method = { RequestMethod.GET })
	public String getNurseWorkList() {
		OutputResponse response = new OutputResponse();
		try {
			String s = commonNurseServiceImpl.getNurseWorkList();
			response.setResponse(s);
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("Error in getNurseWorklist:" + e);
			response.setError(e);
		}
		return response.toString();
	}
	
}
