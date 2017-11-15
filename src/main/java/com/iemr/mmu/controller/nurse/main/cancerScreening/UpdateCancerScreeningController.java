package com.iemr.mmu.controller.nurse.main.cancerScreening;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iemr.utils.mapper.InputMapper;

@CrossOrigin
@RestController
@RequestMapping({ "/nurse" })
public class UpdateCancerScreeningController {
	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(UpdateCancerScreeningController.class);

}
