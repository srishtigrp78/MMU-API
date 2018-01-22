package com.iemr.mmu.controller.doctor.main.cancerScreening;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

@CrossOrigin
@RestController
@RequestMapping({ "/doctor" })
/** Objective: Performs Delete Beneficiary Cancer Screening Details entered by Doctor*/
public class DeleteDoctorCSController {
	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(DeleteDoctorCSController.class);
}
