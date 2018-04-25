package com.iemr.mmu.controller.quickconsult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.data.quickConsultation.WrapperQuickConsultation;
import com.iemr.mmu.service.quickConsultation.QuickConsultationServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
/**
 * 
 * @author NA874500
 * @Objective updating GeneralOPD (QuickConsult) data for Doctor.
 * @Date 24-04-2018
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value =  "/genOPD-QC-quickConsult", headers = "Authorization")
public class QuickConsultUpdateController {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	private QuickConsultationServiceImpl quickConsultationServiceImpl;
	
	@Autowired
	public void setQuickConsultationServiceImpl(QuickConsultationServiceImpl quickConsultationServiceImpl) {
		this.quickConsultationServiceImpl = quickConsultationServiceImpl;
	}
	
	@CrossOrigin
	@ApiOperation(value = "update GeneralOPD(QuickConsult) Doctor Data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/doctorData" }, method = { RequestMethod.POST })
	public String updateGeneralOPDQCDoctorData( @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("updateGeneralOPDQCDoctorData request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();

		try {
			WrapperQuickConsultation wrapperQuickConsultation = InputMapper.gson().fromJson(requestObj,
					WrapperQuickConsultation.class);

			JsonObject quickConsultDoctorOBJ = wrapperQuickConsultation.getQuickConsultation();
			
			Long result = quickConsultationServiceImpl.updateGeneralOPDQCDoctorData(quickConsultDoctorOBJ);
			if (null != result && result > 0) {
				response.setResponse("GeneralOPD(QC) Doctor Data updated successfully.");
			} else {
				response.setError(500, "Failed to update GeneralOPD(QC) Doctor Data");
			}
			logger.info("updateGeneralOPDQCDoctorData response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in updateGeneralOPDQCDoctorData :" + e);
		}

		return response.toString();
	}
	
}
