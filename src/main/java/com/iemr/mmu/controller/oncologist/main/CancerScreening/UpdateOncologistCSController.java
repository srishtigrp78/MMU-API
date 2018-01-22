package com.iemr.mmu.controller.oncologist.main.CancerScreening;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.controller.doctor.main.cancerScreening.UpdateDoctorCSController;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.service.oncologist.OncologistServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping(value = "/oncologist", headers = "Authorization")
public class UpdateOncologistCSController {

	private InputMapper inputMapper;
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(UpdateDoctorCSController.class);
	private OncologistServiceImpl oncologistServiceImpl;

	@Autowired
	public void setOncologistServiceImpl(OncologistServiceImpl oncologistServiceImpl) {
		this.oncologistServiceImpl = oncologistServiceImpl;
	}

	@CrossOrigin
	@ApiOperation(value = "update Cancer Diagnosis Details By Oncologist", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/examinationScreen/diagnosis" }, method = { RequestMethod.POST })
	public String updateCancerDiagnosisDetailsByOncologist(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\", \"benVisitID\":\"Long\", "
					+ "\"provisionalDiagnosisOncologist\":\"String\", \"modifiedBy\":\"string\"}") @RequestBody String requestObj) {

		response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("updateCancerDiagnosisDetailsByOncologist request:" + requestObj);

		try {
			CancerDiagnosis cancerDiagnosis = InputMapper.gson().fromJson(requestObj, CancerDiagnosis.class);
			int result = oncologistServiceImpl.updateCancerDiagnosisDetailsByOncologist(cancerDiagnosis);
			if (result > 0) {
				response.setResponse("Cancer Diagnosis Details updated By Oncologist Successfully");
			} else {
				response.setError(5000, "Failed to update Cancer Diagnosis Details By Oncologist");
			}
			logger.info("updateCancerDiagnosisDetailsByOncologist response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in updateCancerDiagnosisDetailsByOncologist :" + e);
		}

		return response.toString();
	}

}
