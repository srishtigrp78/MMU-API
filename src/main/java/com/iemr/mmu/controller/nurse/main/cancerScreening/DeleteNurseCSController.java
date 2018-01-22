package com.iemr.mmu.controller.nurse.main.cancerScreening;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.utils.mapper.InputMapper;

@CrossOrigin
@RestController
@RequestMapping({ "/nurse" })
/**
 * Objective: Performs Delete Beneficiary Cancer Screening Details entered by
 * nurse
 */
public class DeleteNurseCSController {
	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(DeleteNurseCSController.class);

}
