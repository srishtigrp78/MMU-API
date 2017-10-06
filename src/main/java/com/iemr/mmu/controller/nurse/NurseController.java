package com.iemr.mmu.controller.nurse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

@Controller
@RequestMapping("/nurse")
public class NurseController {
	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;

	@CrossOrigin
	@RequestMapping(value = { "/testrest" }, method = { RequestMethod.POST }, produces = { "application/json" })
	public String testRestTemplate(@RequestBody String comingRequest) {
		NurseServiceImpl n = new NurseServiceImpl();
		String s = n.savePatientVisitDetails();
		System.out.println();

		return "hello...";
	}

	@CrossOrigin
	@RequestMapping(value = { "/testrest1" }, method = { RequestMethod.POST }, produces = { "application/json" })
	public String testRest1(@RequestBody String comingRequest) {
		return "hello...";
	}

	@CrossOrigin
	@RequestMapping(value = { "/testrest2" }, method = { RequestMethod.POST }, produces = { "application/json" })
	public String testRest2(@RequestBody String comingRequest) {
		response = new OutputResponse();
		return "hello";
	}

	@CrossOrigin
	@RequestMapping(value = { "/testrest3" }, method = { RequestMethod.POST }, produces = { "application/json" })
	public String testRest3(@RequestBody String comingRequest) {
		return "hello...";
	}

}
