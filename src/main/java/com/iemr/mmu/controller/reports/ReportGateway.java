package com.iemr.mmu.controller.reports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.controller.registrar.master.RegistrarMasterController;
import com.iemr.mmu.service.reports.ReportCheckPostImpl;
import com.iemr.mmu.service.reports.ReportCheckPostImplNew;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/report", headers = "Authorization")
public class ReportGateway {
	private Logger logger = LoggerFactory.getLogger(RegistrarMasterController.class);

	@Autowired
	private ReportCheckPostImpl reportCheckPostImpl;

	@CrossOrigin()
	@ApiOperation(value = "", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getReport" }, method = { RequestMethod.POST })
	public String getReportByReportID(@RequestBody String requestOBJ) {
		OutputResponse response = new OutputResponse();

		try {
			if (requestOBJ != null)
				response.setResponse(reportCheckPostImpl.reportHandler(requestOBJ));
			else
				response.setError(5000, "Invalid request");

		} catch (Exception e) {
			logger.error("Error occurred while fetching report : " + e);
			response.setError(5000, "Error occurred while fetching report is : " + e);
		}
		return response.toStringWithSerialization();
	}
	
	
		@Autowired
		private ReportCheckPostImplNew reportCheckPostImplNew;

		@CrossOrigin()
		@ApiOperation(value = "", consumes = "application/json", produces = "application/json")
		@RequestMapping(value = { "/getReportNew" }, method = { RequestMethod.POST })
		public String getReportByReportID1(@RequestBody String requestOBJ) {
			OutputResponse response = new OutputResponse();

			try {
				if (requestOBJ != null)
					response.setResponse(reportCheckPostImplNew.reportHandler(requestOBJ));
				else
					response.setError(5000, "Invalid request");

			} catch (Exception e) {
				logger.error("Error occurred while fetching report : " + e);
				response.setError(5000, "Error occurred while fetching report is : " + e);
			}
			return response.toStringWithSerialization();
		}
	
	

	@CrossOrigin()
	@ApiOperation(value = "Get Report Master", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getReportMaster/{serviceID}" }, method = { RequestMethod.GET })
	public String getReportMaster(@PathVariable("serviceID") Integer serviceID) {
		OutputResponse response = new OutputResponse();
		try {
			if (serviceID != null) {
				String s = reportCheckPostImpl.getReportMaster(serviceID);

				if (s != null)
					response.setResponse(s);
				else
					response.setError(5000, "Error while fetching report master data");
			} else
				response.setError(5000, "invalid request");

		} catch (Exception e) {
			response.setError(5000, "Error while fetching report master data is : " + e);
		}
		return response.toString();
	}
	
	
}
