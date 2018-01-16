package com.iemr.mmu.controller.cancerscreening;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author NE298657
 * @Objective Saving Cancer screening data for Nurse and Doctor both.
 * @Date 15-01-2018
 *
 */
@CrossOrigin
@RestController
@RequestMapping({ "/CS-cancerScreening" })
public class CancerScreeningCreateController {
	private Logger logger = LoggerFactory.getLogger(CancerScreeningCreateController.class);

}
