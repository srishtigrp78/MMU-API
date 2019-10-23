package com.iemr.mmu.controller.fileSync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.fileSync.FileSyncService;
import com.iemr.mmu.utils.response.OutputResponse;

@RequestMapping("/fileSyncController")
@RestController
public class FileSyncController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	FileSyncService fileSyncService;
	
	@CrossOrigin()
	@RequestMapping(value = "/getServerCredential", headers = "Authorization", method = {
			RequestMethod.GET }, produces = { "application/json" })
	public String getServerCredential() {
		logger.info("getServerCredential request ");
		OutputResponse response = new OutputResponse();
		try {

			 String data = fileSyncService.getServerCredential();
			 response.setResponse(data);
			 logger.info("getServerCredential response "+response.toString());
		} catch (Exception e) {
			e.printStackTrace();
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}

	
	@CrossOrigin()
	@RequestMapping(value = "/syncFiles", headers = "Authorization", method = {
			RequestMethod.GET }, produces = { "application/json" })
	public String syncFiles(@RequestHeader(value = "ServerAuthorization") String ServerAuthorization) {
		logger.info("syncFiles request ");
		OutputResponse response = new OutputResponse();
		try {

			 String data = fileSyncService.syncFiles(ServerAuthorization);
			 response.setResponse(data);
			 logger.info("syncFiles response "+response.toString());
		} catch (Exception e) {
			e.printStackTrace();
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();
	}
}
