package com.iemr.mmu.controller.dataSyncLayerCentral;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.dataSyncLayerCentral.GetDataFromVanAndSyncToDBImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

/***
 * 
 * @author NE298657
 * @date 16-08-2018
 * @operation Class used for data sync from van-to-server & server-to-van
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/dataSync", headers = "Authorization")
public class MMU_DataSync_VanToServer {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	private GetDataFromVanAndSyncToDBImpl getDataFromVanAndSyncToDBImpl;

	@CrossOrigin()
	@ApiOperation(value = "sync data from van-to-server", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/van-to-server" }, method = { RequestMethod.POST })
	public String dataSyncToServer(@RequestBody String requestOBJ,
			@RequestHeader(value = "Authorization") String Authorization) {
		OutputResponse response = new OutputResponse();
		try {
			String s = getDataFromVanAndSyncToDBImpl.syncDataToServer(requestOBJ, Authorization);
			if (s != null)
				response.setResponse(s);
			else
				response.setError(5000, "data dync failed");
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

}
