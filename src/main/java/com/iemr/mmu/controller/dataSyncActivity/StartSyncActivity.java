package com.iemr.mmu.controller.dataSyncActivity;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.dataSyncActivity.UploadDataToServerImpl;

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
@RequestMapping(value = "/dataSyncActivity", headers = "Authorization")
public class StartSyncActivity {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	private UploadDataToServerImpl uploadDataToServerImpl;

	@CrossOrigin()
	@ApiOperation(value = "start data sync from Van to Server", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/van-to-server" }, method = { RequestMethod.POST })
	public String dataSyncToServer(@RequestBody String requestOBJ) {
		try {
			JSONObject obj = new JSONObject(requestOBJ);
			if (obj != null && obj.has("groupName") && obj.get("groupName") != null) {
				uploadDataToServerImpl.getDataToSyncToServer(obj.getString("groupName"));
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
