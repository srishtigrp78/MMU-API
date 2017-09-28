package com.iemr.mmu.controller.login;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.utils.response.OutputResponse;

@RequestMapping("/login")
@RestController
public class IemrMmuLoginController {

	@CrossOrigin()
	@RequestMapping(value = { "/userAuthentication" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String userAuthentication(@RequestBody String jsonRequest) {

		OutputResponse response = new OutputResponse();
		try {
			System.out.println("BABA");
			response.setResponse("BABA");

		} catch (Exception e) {
			e.printStackTrace();
			response.setError(e);
		}
		return response.toString();
	}

}
