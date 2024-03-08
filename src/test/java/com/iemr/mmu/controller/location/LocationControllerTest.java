package com.iemr.mmu.controller.location;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.mmu.controller.common.master.CommonMasterController;
import com.iemr.mmu.service.location.LocationServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class LocationControllerTest {
	@Mock
	private OutputResponse response;
	@Mock
	private Logger logger = LoggerFactory.getLogger(CommonMasterController.class);
	@Mock
	private LocationServiceImpl locationServiceImpl;
	@InjectMocks
	LocationController locationController;

	@Test
	void testGetStateMasterSuccess() {
		response = new OutputResponse();

		String s = "Test";

		when(locationServiceImpl.getStateList()).thenReturn(s);

		String expResponse = locationController.getStateMaster();

		assertNotNull(s);

		response.setResponse(s);

		assertEquals(expResponse, locationController.getStateMaster());
		assertTrue(response.toString().contains(s));

	}

	@Test
	void testGetStateMasterNull() {
		response = new OutputResponse();

		String s = null;

		when(locationServiceImpl.getStateList()).thenReturn(s);

		String expResponse = locationController.getStateMaster();

		assertNull(s);

		response.setError(5000, "Error while getting states");

		assertEquals(expResponse, locationController.getStateMaster());
		assertTrue(response.toString().contains("Error while getting states"));

	}

	@Test
	void testGetCountryMasterSuccess() {
		response = new OutputResponse();
		String s = "Test";

		when(locationServiceImpl.getCountryList()).thenReturn(s);

		String expResponse = locationController.getCountryMaster();

		response.setResponse(s);

		assertNotNull(s);

		assertEquals(expResponse, locationController.getCountryMaster());
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetCountryMasterNull() {
		response = new OutputResponse();
		String s = null;

		when(locationServiceImpl.getCountryList()).thenReturn(s);

		String expResponse = locationController.getCountryMaster();

		response.setError(5000, "Error while getting states");

		assertNull(s);

		assertEquals(expResponse, locationController.getCountryMaster());
		assertTrue(response.toString().contains("Error while getting states"));
	}

	@Test
	void testGetCountryCityMasterSuccess() {
		response = new OutputResponse();
		Integer countryID = 1;
		String s = "Test";

		when(locationServiceImpl.getCountryCityList(countryID)).thenReturn(s);

		String expResponse = locationController.getCountryCityMaster(countryID);

		response.setResponse(s);

		assertNotNull(s);

		assertEquals(expResponse, locationController.getCountryCityMaster(countryID));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetCountryCityMasterNull() {
		response = new OutputResponse();
		Integer countryID = 1;
		String s = null;

		when(locationServiceImpl.getCountryCityList(countryID)).thenReturn(s);

		String expResponse = locationController.getCountryCityMaster(countryID);

		response.setError(5000, "Error while getting country city");

		assertNull(s);

		assertEquals(expResponse, locationController.getCountryCityMaster(countryID));
		assertTrue(response.toString().contains("Error while getting country city"));
	}

//*******
	@Test
	void testGetDistrictMasterSuccess() {
		response = new OutputResponse();

		Integer stateID = 1;
		String s = "Test";

		when(locationServiceImpl.getDistrictList(stateID)).thenReturn(s);

		String expResponse = locationController.getDistrictMaster(stateID);

		response.setResponse(s);

		assertNotNull(s);

		assertEquals(expResponse, locationController.getDistrictMaster(stateID));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetDistrictMasterNull() {
		response = new OutputResponse();

		Integer stateID = 1;
		String s = null;

		when(locationServiceImpl.getDistrictList(stateID)).thenReturn(s);

		String expResponse = locationController.getDistrictMaster(stateID);

		response.setError(5000, "Error while getting districts");

		assertNull(s);

		assertEquals(expResponse, locationController.getDistrictMaster(stateID));
		assertTrue(response.toString().contains("Error while getting districts"));
	}

	@Test
	void testGetDistrictBlockMasterSuccess() {
		response = new OutputResponse();
		String s = "Test";
		Integer districtID = 1;

		when(locationServiceImpl.getDistrictBlockList(districtID)).thenReturn(s);

		String expResponse = locationController.getDistrictBlockMaster(districtID);

		response.setResponse(s);

		assertNotNull(s);

		assertEquals(expResponse, locationController.getDistrictBlockMaster(districtID));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetDistrictBlockMasterNull() {
		response = new OutputResponse();
		String s = null;
		Integer districtID = 1;

		when(locationServiceImpl.getDistrictBlockList(districtID)).thenReturn(s);

		String expResponse = locationController.getDistrictBlockMaster(districtID);

		response.setError(5000, "Error while getting district blocks");

		assertNull(s);

		assertEquals(expResponse, locationController.getDistrictBlockMaster(districtID));
		assertTrue(response.toString().contains("Error while getting district blocks"));
	}

	@Test
	void testGetVillageMasterSuccess() {
		response = new OutputResponse();
		Integer blockID = 1;
		String s = "Test";

		when(locationServiceImpl.getVillageMasterFromBlockID(blockID)).thenReturn(s);

		String expResponse = locationController.getVillageMaster(blockID);

		response.setResponse(s);

		assertNotNull(s);

		assertEquals(expResponse, locationController.getVillageMaster(blockID));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetVillageMasterNull() {
		response = new OutputResponse();
		Integer blockID = 1;
		String s = null;

		when(locationServiceImpl.getVillageMasterFromBlockID(blockID)).thenReturn(s);

		String expResponse = locationController.getVillageMaster(blockID);

		response.setError(5000, "Error while getting villages");

		assertNull(s);

		assertEquals(expResponse, locationController.getVillageMaster(blockID));
		assertTrue(response.toString().contains("Error while getting villages"));
	}

	@Test
	void testGetLocDetailsBasedOnSpIDAndPsmIDNew_Success() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"spID\":1,\"spPSMID\":100}";
		String s = "Test";

		JSONObject obj = new JSONObject(comingRequest);

		when(locationServiceImpl.getLocDetailsNew(obj.getInt("spID"), obj.getInt("spPSMID"))).thenReturn(s);

		String expResponse = locationController.getLocDetailsBasedOnSpIDAndPsmIDNew(comingRequest);

		response.setResponse(s);

		assertTrue(obj != null && obj.has("spID") && obj.has("spPSMID") && obj.get("spID") != null
				&& obj.get("spPSMID") != null);

		assertEquals(expResponse, locationController.getLocDetailsBasedOnSpIDAndPsmIDNew(comingRequest));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetLocDetailsBasedOnSpIDAndPsmIDNew_Invalid() throws JSONException {
		String comingRequest = "{}";

		OutputResponse response = new OutputResponse();

		String expResponse = locationController.getLocDetailsBasedOnSpIDAndPsmIDNew(comingRequest);

		// Assert that the response indicates an invalid request
		assertTrue(expResponse.contains("Invalid request"));

	}

	@Test
	void testGetLocDetailsBasedOnSpIDAndPsmIDNew_CatchBlock() throws JSONException {
		String comingRequest = "{\"spID\":1,\"spPSMID\":100}";
		OutputResponse response = new OutputResponse();
		response.setError(5000, "Error while getting location data");

		// Setup mock to throw an exception
		JSONObject obj = new JSONObject(comingRequest);
		when(locationServiceImpl.getLocDetailsNew(obj.getInt("spID"), obj.getInt("spPSMID")))
				.thenThrow(new RuntimeException("Test exception"));

		String expResponse = locationController.getLocDetailsBasedOnSpIDAndPsmIDNew(comingRequest);

		// Assert that the response indicates an error occurred
		assertTrue(expResponse.contains("Error while getting location data"));
		assertTrue(expResponse.contains("5000"));
	}

	@Test
	void testGetDistrictTalukMasterSuccess() {
		response = new OutputResponse();

		Integer districtBranchID = 1;
		String s = "Test";

		when(locationServiceImpl.getDistrictTalukList(districtBranchID)).thenReturn(s);

		String expResponse = locationController.getDistrictTalukMaster(districtBranchID);

		response.setResponse(s);

		assertNotNull(s);

		assertEquals(expResponse, locationController.getDistrictTalukMaster(districtBranchID));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetDistrictTalukMasterNull() {
		response = new OutputResponse();

		Integer districtBranchID = 1;
		String s = null;

		when(locationServiceImpl.getDistrictTalukList(districtBranchID)).thenReturn(s);

		String expResponse = locationController.getDistrictTalukMaster(districtBranchID);

		response.setError(5000, "Error while getting district blocks");
		assertNull(s);

		assertEquals(expResponse, locationController.getDistrictTalukMaster(districtBranchID));
		assertTrue(response.toString().contains("Error while getting district blocks"));
	}

}