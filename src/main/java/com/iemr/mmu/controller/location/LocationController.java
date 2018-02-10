package com.iemr.mmu.controller.location;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.controller.common.master.CommonMasterController;
import com.iemr.mmu.service.location.LocationServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/location", headers = "Authorization")
public class LocationController {
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(CommonMasterController.class);

	private LocationServiceImpl locationServiceImpl;

	@Autowired
	public void setLocationServiceImpl(LocationServiceImpl locationServiceImpl) {
		this.locationServiceImpl = locationServiceImpl;
	}

	@Deprecated
	@ApiOperation(value = "State master for beneficiary", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/get/stateMaster", method = RequestMethod.GET)
	public String getStateMaster() {
		logger.info("get state master ...");
		response = new OutputResponse();
		String s = locationServiceImpl.getStateList();
		if (s != null)
			response.setResponse(s);
		else
			response.setError(5000, "No State Master Data Available !!!");
		logger.info("stateMaster" + response.toString());
		return response.toString();
	}

	@Deprecated
	@ApiOperation(value = "Zone master for beneficiary", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/get/zoneMaster/{providerServiceMapID}/", method = RequestMethod.GET)
	public String getZoneMaster(@PathVariable("providerServiceMapID") Integer providerServiceMapID) {
		logger.info("get Zone master ...");
		response = new OutputResponse();
		String s = locationServiceImpl.getZoneList(providerServiceMapID);
		if (s != null)
			response.setResponse(s);
		else
			response.setError(5000, "No Zone Master Data Available !!!");
		logger.info("zoneMaster" + response.toString());
		return response.toString();
	}

	@ApiOperation(value = "District master for beneficiary", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/get/districtMaster/{stateID}", method = RequestMethod.GET)
	public String getDistrictMaster(@PathVariable("stateID") Integer stateID) {
		logger.info("get District master ...");
		response = new OutputResponse();
		String s = locationServiceImpl.getDistrictList(stateID);
		if (s != null)
			response.setResponse(s);
		else
			response.setError(5000, "No District Master Data Available !!!");
		logger.info("districtMaster" + response.toString());
		return response.toString();
	}

	@ApiOperation(value = "District Block master for beneficiary", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/get/districtBlockMaster/{districtID}", method = RequestMethod.GET)
	public String getDistrictBlockMaster(@PathVariable("districtID") Integer districtID) {
		logger.info("get District Block master districtID ..." + districtID);
		response = new OutputResponse();
		String s = locationServiceImpl.getDistrictBlockList(districtID);
		if (s != null)
			response.setResponse(s);
		else
			response.setError(5000, "No District Block Master Data Available !!!");
		logger.info("districtBlockMaster" + response.toString());
		return response.toString();
	}

	@Deprecated
	@ApiOperation(value = "Parking Place master for beneficiary", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/get/parkingPlaceMaster/{providerServiceMapID}", method = RequestMethod.GET)
	public String getParkingPlaceMaster(@PathVariable("providerServiceMapID") Integer providerServiceMapID) {
		logger.info("get District Block master providerServiceMapID ..." + providerServiceMapID);
		response = new OutputResponse();
		String s = locationServiceImpl.getParkingPlaceList(providerServiceMapID);
		if (s != null)
			response.setResponse(s);
		else
			response.setError(5000, "No Parking Place Master Data Available !!!");
		logger.info("parkingPlaceMaster" + response.toString());
		return response.toString();
	}

	@Deprecated
	@ApiOperation(value = "Service Point master for beneficiary", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/get/servicePointMaster/{parkingPlaceID}", method = RequestMethod.GET)
	public String getServicePointMaster(@PathVariable("parkingPlaceID") Integer parkingPlaceID) {
		logger.info("get Servicepoint master parkingPlaceID ..." + parkingPlaceID);
		response = new OutputResponse();
		String s = locationServiceImpl.getServicePointPlaceList(parkingPlaceID);
		if (s != null)
			response.setResponse(s);
		else
			response.setError(5000, "No servicePoint Master Data Available !!!");
		logger.info("servicePointMaster" + response.toString());
		return response.toString();
	}

	/***
	 * based on servicepoint id and provider service map id get other location
	 * details.
	 * 
	 * @param comingRequest
	 * @return
	 */
	@CrossOrigin()
	@RequestMapping(value = "/getLocDetailsBasedOnSpIDAndPsmID", method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String getLocDetailsBasedOnSpIDAndPsmID(@RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj != null && obj.has("spID") && obj.has("spPSMID") && obj.get("spID") != null
					&& obj.get("spPSMID") != null) {
				String s = locationServiceImpl.getLocDetails(obj.getInt("spID"), obj.getInt("spPSMID"));

				response.setResponse(s);
			} else {
				response.setError(5000, "Invalid Input.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setError(e);
		}
		return response.toString();
	}
}
