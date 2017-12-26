package com.iemr.mmu.controller.nurse.main.anc;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.data.anc.BenAdherence;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.service.anc.ANCServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping({ "/anc" })
public class UpdateNurseANCController {
	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(InsertNurseANCController.class);

	private ANCServiceImpl ancServiceImpl;

	@Autowired
	public void setAncServiceImpl(ANCServiceImpl ancServiceImpl) {
		this.ancServiceImpl = ancServiceImpl;
	}

	@CrossOrigin
	@ApiOperation(value = "Update Beneficiary Adherence", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/visitDetails/adherence" }, method = { RequestMethod.POST })
	public String updateBenAdherence(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("UpdateBenAdherenceDetail request:" + requestObj);
		// inputMapper = new InputMapper();
		try {
			if (requestObj != null) {
				BenAdherence benAdherence = InputMapper.gson().fromJson(requestObj, BenAdherence.class);
				int r = ancServiceImpl.updateBenAdherenceDetails(benAdherence);
				if (r > 0) {
					response.setResponse("Ben Adherence data update successfully.");
				} else {
					response.setError(5000, "Something went wrong !!!");
				}
			} else {
				response.setError(5000, "Invalid request Data");
			}
		} catch (Exception e) {
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Update Beneficiary Chief complaints", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/visitDetails/chiefComplaints" }, method = { RequestMethod.POST })
	public String updateBenchiefComplaints(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("updateBenchiefComplaints request:" + requestObj);
		try {
			if (requestObj != null) {
				BenChiefComplaint[] benChiefComplaintArray = InputMapper.gson().fromJson(requestObj,
						BenChiefComplaint[].class);

				List<BenChiefComplaint> benChiefComplaintList = Arrays.asList(benChiefComplaintArray);
				int r = ancServiceImpl.updateBenChiefComplaints(benChiefComplaintList);

				if (r > 0) {
					response.setResponse("Chief-complaints data updated successfully.");
				} else {
					response.setError(5000, "Something went Wrong !!!");
				}
			} else {
				response.setError(5000, "Invalid request Data");
			}
			// inputMapper = new InputMapper();
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}
}
