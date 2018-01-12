package com.iemr.mmu.controller.nurse.main.quickConsultation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.service.common.master.NurseMasterDataService;
import com.iemr.mmu.service.common.master.NurseMasterDataServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping({ "/nurse" })
/**
 * Objective: Performs saving Beneficiary Quick consultation Details entered by
 * nurse
 */
public class InsertNurseQCController {

	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(InsertNurseQCController.class);

	private NurseServiceImpl nurseServiceImpl;
	private NurseMasterDataService nurseMasterDataService;
	private NurseMasterDataServiceImpl nurseMasterDataServiceImpl;

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	@Autowired
	public void setNurseMasterDataServiceImpl(NurseMasterDataServiceImpl nurseMasterDataServiceImpl) {
		this.nurseMasterDataServiceImpl = nurseMasterDataServiceImpl;
	}

	@CrossOrigin
	@ApiOperation(value = "save Beneficiary Physical Vital Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/vitalScreen/benPhysicalVitalDetail" }, method = { RequestMethod.POST })
	public String saveBenPhysicalVitalDetail(@RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("saveBenPhysicalVitalDetail request:" + requestObj);

		try {

			BenAnthropometryDetail benAnthropometryDetail = InputMapper.gson().fromJson(requestObj,
					BenAnthropometryDetail.class);
			BenPhysicalVitalDetail benPhysicalVitalDetail = InputMapper.gson().fromJson(requestObj,
					BenPhysicalVitalDetail.class);

			Long responseObj = nurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(benAnthropometryDetail);
			Long responseObj2 = nurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(benPhysicalVitalDetail);
			if (responseObj != null && responseObj > 0 && responseObj2 != null && responseObj2 > 0) {
				response.setResponse("Beneficiary Physical Vital Details Stored Successfully");
			} else {
				response.setError(5000, "Failed to Store Beneficiary Physical Vital Details");
			}
			logger.info("saveBenPhysicalVitalDetail response:" + response.toString());
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveBenPhysicalVitalDetail:" + e);
		}

		return response.toString();
	}
	
	
}
