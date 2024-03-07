package com.iemr.mmu.controller.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
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

import com.iemr.mmu.controller.registrar.main.RegistrarController;
import com.iemr.mmu.service.login.IemrMmuLoginServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class IemrMmuLoginControllerTest {

	@Mock
	private Logger logger = LoggerFactory.getLogger(RegistrarController.class);
	@Mock
	private InputMapper inputMapper = new InputMapper();
	@Mock
	private IemrMmuLoginServiceImpl iemrMmuLoginServiceImpl;
	@InjectMocks
	private IemrMmuLoginController iemrMmuLoginController;

	@Test
	void getUserServicePointVanDetails_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"userID\": 1}";
		String responseData = "test";

		JSONObject obj = new JSONObject(comingRequest);

		when(iemrMmuLoginServiceImpl.getUserServicePointVanDetails(obj.getInt("userID"))).thenReturn(responseData);

		String expResponse = iemrMmuLoginController.getUserServicePointVanDetails(comingRequest);

		response.setResponse(responseData);

		assertEquals(expResponse, iemrMmuLoginController.getUserServicePointVanDetails(comingRequest));
		assertTrue(response.toString().contains(responseData));
	}

	@Test
	void getUserServicePointVanDetails_Exception() throws Exception {
		String comingRequest = "{\"userID\": 1}";

		when(iemrMmuLoginServiceImpl.getUserServicePointVanDetails(anyInt()))
				.thenThrow(new RuntimeException("Simulated service failure"));

		String responseString = iemrMmuLoginController.getUserServicePointVanDetails(comingRequest);

		assertTrue(responseString.contains("Error while getting service points and van data"));
	}

	@Test
	void testGetServicepointVillages() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"servicePointID\": 1}";
		String responseData = "Test";

		JSONObject obj = new JSONObject(comingRequest);

		when(iemrMmuLoginServiceImpl.getServicepointVillages(obj.getInt("servicePointID"))).thenReturn(responseData);

		String expResponse = iemrMmuLoginController.getServicepointVillages(comingRequest);

		response.setResponse(responseData);

		assertEquals(expResponse, iemrMmuLoginController.getServicepointVillages(comingRequest));
		assertTrue(response.toString().contains(responseData));
	}

	@Test
	void getServicepointVillages_Exception() {
		String requestJson = "{\"servicePointID\": 1}";
		when(iemrMmuLoginServiceImpl.getServicepointVillages(anyInt()))
				.thenThrow(new RuntimeException("Test Exception"));

		String response = iemrMmuLoginController.getServicepointVillages(requestJson);

		assertTrue(response.contains("Error while getting service points and villages"));
		assertTrue(response.contains("5000"));
	}

	@Test
	void testGetUserVanSpDetails() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"userID\": 1,\"providerServiceMapID\": 1 }";
		String responseData = "Test";

		JSONObject obj = new JSONObject(comingRequest);

		when(iemrMmuLoginServiceImpl.getUserVanSpDetails(obj.getInt("userID"), obj.getInt("providerServiceMapID")))
				.thenReturn(responseData);

		String expresponse = iemrMmuLoginController.getUserVanSpDetails(comingRequest);

		response.setResponse(responseData);

		assertTrue(obj.has("userID") && obj.has("providerServiceMapID"));

		assertEquals(expresponse, iemrMmuLoginController.getUserVanSpDetails(comingRequest));
		assertTrue(response.toString().contains(responseData));
	}

	@Test
	void getUserVanSpDetails_InvalidRequest() {
		String invalidRequestJson = "{\"someOtherField\": 123}";

		String response = iemrMmuLoginController.getUserVanSpDetails(invalidRequestJson);

		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void getUserVanSpDetails_ThrowsException() {
		String requestJson = "{\"userID\": 1, \"providerServiceMapID\": 2}";

		when(iemrMmuLoginServiceImpl.getUserVanSpDetails(anyInt(), anyInt()))
				.thenThrow(new RuntimeException("Test exception"));

		String response = iemrMmuLoginController.getUserVanSpDetails(requestJson);

		assertTrue(response.contains("Error while getting van and service points data"));
	}

	@Test
	void getVanMaster_ValidPsmID() throws Exception {
		Integer validPsmID = 1;
		String expectedResponse = "van details";

		when(iemrMmuLoginServiceImpl.getVanMaster(validPsmID)).thenReturn(expectedResponse);

		String response = iemrMmuLoginController.getVanMaster(validPsmID);

		assertTrue(response.toString().contains(expectedResponse));
	}

	@Test
	void getVanMaster_NullPsmID() {
		String response = iemrMmuLoginController.getVanMaster(null);

		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void getVanMaster_Exception() throws Exception {
		Integer invalidPsmID = 2;

		when(iemrMmuLoginServiceImpl.getVanMaster(invalidPsmID)).thenThrow(new RuntimeException("Test exception"));

		String response = iemrMmuLoginController.getVanMaster(invalidPsmID);

		assertTrue(response.toString().contains("Error occurred while fetching van master"));
	}

}
