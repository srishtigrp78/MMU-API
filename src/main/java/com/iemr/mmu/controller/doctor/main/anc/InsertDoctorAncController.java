package com.iemr.mmu.controller.doctor.main.anc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.controller.nurse.main.anc.InsertNurseANCController;
import com.iemr.mmu.data.anc.BenAdherence;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;
import com.iemr.mmu.service.anc.ANCServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/doctor" })
public class InsertDoctorAncController {

	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(InsertDoctorAncController.class);

	private ANCServiceImpl ancServiceImpl;

	@Autowired
	public void setAncServiceImpl(ANCServiceImpl ancServiceImpl) {
		this.ancServiceImpl = ancServiceImpl;
	}
	
	@CrossOrigin
	@ApiOperation(value = "save Beneficiary ANC Diagnosis", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/doctorCasesheet/diagnosis" }, method = { RequestMethod.POST })
	public String saveBenANCDiagnosis(@ApiParam(value = "{\"beneficiaryRegID\":\"Long\",\"benVisitID\": \"Long\","
			+ "\"providerServiceMapID\":\"Integer\", \"diagnosisProvided\":\"String\", \"instruction\":\"String\", "
			+ "\"confirmatoryDiagnosis\":\"String\", \"remarks\":\"String\", \"createdBy\":\"String\"}") @RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
	
		logger.info("saveBenANCDiagnosis request:" + requestObj);
		try {
			if (requestObj != null) {
				PrescriptionDetail prescriptionDetail = InputMapper.gson().fromJson(requestObj, PrescriptionDetail.class);
				Long r = ancServiceImpl.saveBenANCDiagnosis(prescriptionDetail);
				if (r > 0) {
					response.setResponse("Ben ANC Diagnosis data saved successfully.");
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
	
}
