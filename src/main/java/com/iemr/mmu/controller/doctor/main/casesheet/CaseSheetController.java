package com.iemr.mmu.controller.doctor.main.casesheet;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.casesheet.CaseSheetServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/casesheet" })
/** Objective: Provides Nurse and doctor entered details for casesheet*/
public class CaseSheetController {

	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(CaseSheetController.class);
	private CaseSheetServiceImpl caseSheetServiceImpl;

	@Autowired
	public void setCaseSheetServiceImpl(CaseSheetServiceImpl caseSheetServiceImpl) {
		this.caseSheetServiceImpl = caseSheetServiceImpl;
	}

	/**
	 * Fething beneficiary data filled by Nurse and Doctor for case sheet...
	 */

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary data for case sheet", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBeneficiaryDataEnteredByNurseAndDoctor" }, method = { RequestMethod.POST })
	public String getBenDataForCaseSheet(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\", \"visitDateTime\":\"Date\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getBenDataForCaseSheet request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");
				Date visitDateTime = null;
				if (obj.has("visitDateTime") && null != obj.getString("visitDateTime")) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
					java.util.Date parsedDate;
					try {
						parsedDate = dateFormat.parse(obj.getString("visitDateTime"));
						Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
						// new Date(timestamp.getYear(), timestamp.getMonth(),
						// timestamp.getDate());
						visitDateTime = new Date(timestamp.getTime());
						//System.out.println("hello");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						logger.error("Error in getBenDataForCaseSheet:" + e);
					}
				}

				String caseSheetData = caseSheetServiceImpl.getBenDataForCaseSheet(benRegID, benVisitID, visitDateTime);

				response.setResponse(caseSheetData);
			} else {

			}
			logger.info("getBenDataForCaseSheet response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataForCaseSheet:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get casesheet History of Beneficiary", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBeneficiaryCaseSheetHistory" }, method = { RequestMethod.POST })
	public String getBeneficiaryCaseSheetHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getBenDataForCaseSheet request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() >= 1) {
				Long benRegID = obj.getLong("benRegID");

				String caseSheetHistory = caseSheetServiceImpl.getBeneficiaryCaseSheetHistory(benRegID);

				response.setResponse(caseSheetHistory);
			} else {

			}
			logger.info("getBenDataForCaseSheet response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataForCaseSheet:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Cancer Examination Image-Annotation of Beneficiary", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getCancerExaminationImageAnnotation" }, method = { RequestMethod.POST })
	public String getCancerExaminationImageAnnotation(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getBenDataForCaseSheet request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);

			if (obj.has("benRegID") && obj.has("benVisitID")) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");
				String s = caseSheetServiceImpl.getCancerExaminationImageAnnotation(benRegID, benVisitID);
				//System.out.println(s);
				response.setResponse(s);

			} else {
				response.setError(5000, "Invalid Request");
			}
			logger.info("getBenDataForCaseSheet response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataForCaseSheet:" + e);
		}
		return response.toString();
	}

}
