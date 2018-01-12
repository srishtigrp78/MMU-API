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
import com.iemr.mmu.controller.nurse.main.quickConsultation.InsertNurseQCController;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author NE298657
 * @Objective Saving general OPD quick consult data for Nurse and Doctor both.
 * @Date 12-01-2018
 *
 */
@CrossOrigin
@RestController
@RequestMapping({ "/genOPD-QC-quickConsult" })
public class QuickConsultCreateController {
	private Logger logger = LoggerFactory.getLogger(InsertNurseQCController.class);
	private NurseServiceImpl nurseServiceImpl;

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	/**
	 * 
	 * @param requestObj
	 * @return success or failure response
	 * @objective first data will be pushed to BenVisitDetails Table and
	 *            benVisitID will be generated and then this benVisitID will be
	 *            patched with Beneficiary Vital and Anthropometry Detail Object
	 *            and pushed to Database table
	 */
	@CrossOrigin
	@ApiOperation(value = "Save quick consult nurse data..", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/nurseData" }, method = { RequestMethod.POST })
	public String saveBenQuickConsultDataNurse(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveBenPhysicalVitalDetail request:" + requestObj);
		try {
			JsonObject jsnOBJ = new JsonObject();
			JsonParser jsnParser = new JsonParser();
			JsonElement jsnElmnt = jsnParser.parse(requestObj);
			jsnOBJ = jsnElmnt.getAsJsonObject();

			if (jsnOBJ != null) {
				Integer r = nurseServiceImpl.quickConsultNurseDataInsert(jsnOBJ);
				if (r == 1) {
					response.setResponse("Beneficiary Visit Details and Vitals data saved successfully");
				}
			} else {
				response.setError(5000, "Invalid Data !!!");
			}
			System.out.println("hii");
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("Error in beneficiary Visit details and Vitals data in Nurse");

		}
		return response.toString();
	}
}
