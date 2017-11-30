package com.iemr.mmu.controller.common.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.common.master.CommonMasterServiceImpl;
import com.iemr.mmu.service.common.master.CommonMaterService;
import com.iemr.mmu.service.doctor.DoctorServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import javax.ws.rs.core.MediaType;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
@RequestMapping({ "/master" })
/** Objective: provides master data based on given  visitCategory*/
public class CommonMasterController {
	
	
	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(CommonMasterController.class);
	
	private CommonMasterServiceImpl commonMasterServiceImpl;
	
	@Autowired
	public void setCommonMasterServiceImpl(CommonMasterServiceImpl commonMasterServiceImpl) {
		this.commonMasterServiceImpl = commonMasterServiceImpl;
	}
	
	@ApiOperation(
			value = "Master Data for Visit Reasons & Categories",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value = "/get/visitReasonAndCategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String getVisitReasonAndCategories()
	{
		logger.info("getVisitReasonAndCategories ...");
		OutputResponse response = new OutputResponse();
		response.setResponse(commonMasterServiceImpl.getVisitReasonAndCategories());
		logger.info("visitReasonAndCategories" + response.toString());
		return response.toString();
	}
	
	
	@ApiOperation(
			value = "Master Data API for Nurse",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value = "/nurse/masterData/{visitCategoryID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String NurseMasterData(@PathVariable("visitCategoryID") Integer visitCategoryID)
	{
		logger.info("Nurse master Data for categoryID:" + visitCategoryID);
		OutputResponse response = new OutputResponse();
		response.setResponse(commonMasterServiceImpl.getMasterDataForNurse(visitCategoryID));
		logger.info("Nurse master Data for categoryID:" + response.toString());
		return response.toString();
	}
	
	@ApiOperation(
			value = "Master Data API for Doctor",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value = "/doctor/masterData/{visitCategoryID}/{providerServiceMapID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String DoctorMasterData(@PathVariable("visitCategoryID") Integer visitCategoryID,@PathVariable("providerServiceMapID") Integer providerServiceMapID)
	{
		logger.info("Doctor master Data for categoryID:" + visitCategoryID + " and providerServiceMapID:"+providerServiceMapID);
		OutputResponse response = new OutputResponse();
		response.setResponse(commonMasterServiceImpl.getMasterDataForDoctor(visitCategoryID,providerServiceMapID));
		logger.info("Doctor master Data for categoryID:" + response.toString());
		return response.toString();
	}
	
	
}
