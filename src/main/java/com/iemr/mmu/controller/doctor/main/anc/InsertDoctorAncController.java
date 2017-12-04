package com.iemr.mmu.controller.doctor.main.anc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.controller.doctor.main.cancerScreening.InsertDoctorCSController;
import com.iemr.mmu.data.anc.WrapperAncFindings;
import com.iemr.mmu.service.anc.ANCService;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/doctor" })
public class InsertDoctorAncController {
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(InsertDoctorCSController.class);

	private ANCService aNCService;

	@Autowired
	private void setANCService(ANCService aNCService) {
		this.aNCService = aNCService;
	}

	@CrossOrigin
	@ApiOperation(value = "Save doc anc Findings details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/anc/caseRecordFindings" }, method = { RequestMethod.POST })
	public String caseRecordFindings(@ApiParam(value = "") @RequestBody String requestObj) {
		response = new OutputResponse();
		try {
			if (requestObj != null) {
				WrapperAncFindings wrapperAncFindings = InputMapper.gson().fromJson(requestObj,
						WrapperAncFindings.class);
			} else {
				response.setError(5000, "Data is not sufficient !!!");
			}
		} catch (Exception e) {
			logger.error("error in Save doc anc Findings details" + e);
			response.setError(e);
		}
		return null;
	}

}
