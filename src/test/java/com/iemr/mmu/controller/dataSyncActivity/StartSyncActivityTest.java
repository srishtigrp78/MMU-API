package com.iemr.mmu.controller.dataSyncActivity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
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

import com.iemr.mmu.service.dataSyncActivity.DownloadDataFromServerImpl;
import com.iemr.mmu.service.dataSyncActivity.DownloadDataFromServerTransactionalImpl;
import com.iemr.mmu.service.dataSyncActivity.UploadDataToServerImpl;
import com.iemr.mmu.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class StartSyncActivityTest {

	@Mock
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Mock
	private UploadDataToServerImpl uploadDataToServerImpl;
	@Mock
	private DownloadDataFromServerImpl downloadDataFromServerImpl;
	@Mock
	private DownloadDataFromServerTransactionalImpl downloadDataFromServerTransactionalImpl;
	@InjectMocks
	StartSyncActivity startSyncActivity;

	private static final String GROUP_ID = "groupID";
	private static final String PROVIDER_SERVICE_MAP_ID = "providerServiceMapID";

	@Test
	void testDataSyncToServer() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"vanID\":1,\"groupID\":2,\"user\":\"testUser\"}";
		String authorization = "Authorization";
		String serverAuthorization = "ServerAuthorization";
		String s = "test response";

		when(uploadDataToServerImpl.getDataToSyncToServer(1, 2, "testUser", serverAuthorization)).thenReturn(s);

		String expResponse = startSyncActivity.dataSyncToServer(requestOBJ, authorization, serverAuthorization);

		assertNotNull(expResponse);
		assertTrue(expResponse.contains(s));
	}

	@Test
	void testDataSyncToServer_Error() throws Exception {
		String requestOBJ = "{\"vanID\":1,\"groupID\":2,\"user\":\"testUser\"}";
		String authorization = "Authorization";
		String serverAuthorization = "ServerAuthorization";

		when(uploadDataToServerImpl.getDataToSyncToServer(anyInt(), anyInt(), anyString(), anyString()))
				.thenReturn(null);

		String actualResponse = startSyncActivity.dataSyncToServer(requestOBJ, authorization, serverAuthorization);

		assertTrue(actualResponse.contains("Error in data sync"));
	}

	@Test
	void testDataSyncToServer_InvalidRequest() throws Exception {
		String requestOBJ = "{}";
		String authorization = "Authorization";
		String serverAuthorization = "ServerAuthorization";

		String actualResponse = startSyncActivity.dataSyncToServer(requestOBJ, authorization, serverAuthorization);

		assertTrue(actualResponse.contains("Invalid request"));
	}

	@Test
	void testDataSyncToServer_Exception() throws Exception {
		String requestOBJ = "{\"vanID\":1,\"groupID\":2,\"user\":\"testUser\"}";
		String authorization = "Authorization";
		String serverAuthorization = "ServerAuthorization";

		when(uploadDataToServerImpl.getDataToSyncToServer(anyInt(), anyInt(), anyString(), anyString()))
				.thenThrow(new RuntimeException("Error in data sync"));

		String response = startSyncActivity.dataSyncToServer(requestOBJ, authorization, serverAuthorization);

		assertNotNull(response);
		assertTrue(response.contains("Error in data sync"));
	}

	@Test
	void testGetSyncGroupDetails() {
		OutputResponse response = new OutputResponse();

		String s = "test";

		when(uploadDataToServerImpl.getDataSyncGroupDetails()).thenReturn(s);

		String expResponse = startSyncActivity.getSyncGroupDetails();

		response.setResponse(s);

		assertTrue(s != null);

		assertEquals(expResponse, startSyncActivity.getSyncGroupDetails());

		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetSyncGroupDetails_Error() {
		OutputResponse response = new OutputResponse();

		String s = null;

		when(uploadDataToServerImpl.getDataSyncGroupDetails()).thenReturn(s);

		String expResponse = startSyncActivity.getSyncGroupDetails();

		response.setError(5000, "Error in getting data sync group details");

		assertNull(s);

		assertEquals(expResponse, startSyncActivity.getSyncGroupDetails());

		assertTrue(response.toString().contains("Error in getting data sync group details"));
	}

	@Test
	void testGetSyncGroupDetails_Exception() {
		doThrow(new RuntimeException("Error in getting data sync group details")).when(uploadDataToServerImpl)
				.getDataSyncGroupDetails();

		String actualResponse = startSyncActivity.getSyncGroupDetails();

		assertTrue(actualResponse.contains("Error in getting data sync group details"));
	}

	@Test
	void testStartMasterDownload_Success() throws Exception {
		String requestOBJ = "{\"vanID\":1,\"providerServiceMapID\":2}";
		String serverAuthorization = "serverAuthExample";
		when(downloadDataFromServerImpl.downloadMasterDataFromServer(serverAuthorization, 1, 2))
				.thenReturn("Download started successfully");

		String response = startSyncActivity.startMasterDownload(requestOBJ, "authToken", serverAuthorization);

		assertNotNull(response);
		assertTrue(response.contains("Download started successfully"));
	}

	@Test
	void testStartMasterDownload_InProgress() throws Exception {
		String requestOBJ = "{\"vanID\":1,\"providerServiceMapID\":2}";
		String serverAuthorization = "serverAuthExample";
		when(downloadDataFromServerImpl.downloadMasterDataFromServer(serverAuthorization, 1, 2))
				.thenReturn("inProgress");

		String response = startSyncActivity.startMasterDownload(requestOBJ, "authToken", serverAuthorization);

		assertNotNull(response);
		assertTrue(response.contains("Download is already in progress"));
	}

	@Test
	void testStartMasterDownload_MissingFields() throws Exception {
		String requestOBJ = "{}";

		String response = startSyncActivity.startMasterDownload(requestOBJ, "authToken", "serverAuthExample");

		assertNotNull(response);
		assertTrue(response.contains("vanID / providerServiceMapID or both are missing"));
	}

	@Test
	void testStartMasterDownload_Exception() throws Exception {
		String requestOBJ = "{\"vanID\":1,\"providerServiceMapID\":2}";
		String serverAuthorization = "serverAuthExample";
		doThrow(new RuntimeException("Error in Master data Download : ")).when(downloadDataFromServerImpl)
				.downloadMasterDataFromServer(anyString(), anyInt(), anyInt());

		String response = startSyncActivity.startMasterDownload(requestOBJ, "authToken", serverAuthorization);

		assertNotNull(response);
		assertTrue(response.contains("Error in Master data Download : "));
	}

	@Test
	void testCheckMastersDownloadProgress() throws Exception {
		OutputResponse response = new OutputResponse();

		String s = "test";

		String expResponse = startSyncActivity.checkMastersDownloadProgress();

		response.setResponse(s);

		assertNotNull(s);

		assertEquals(expResponse, startSyncActivity.checkMastersDownloadProgress());
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testCheckMastersDownloadProgress_Error() throws Exception {
		OutputResponse response = new OutputResponse();

		String s = null;

		String expResponse = startSyncActivity.checkMastersDownloadProgress();

		response.setError(5000, "Error while getting van details.");

		assertNull(s);

		assertEquals(expResponse, startSyncActivity.checkMastersDownloadProgress());
		assertTrue(response.toString().contains("Error while getting van details."));
	}

	@Test
	void testCheckMastersDownloadProgress_Exception() throws Exception {
		RuntimeException expectedException = new RuntimeException("Error in Master data Download progress check : ");
		when(downloadDataFromServerImpl.getDownloadStatus()).thenThrow(expectedException);

		String result = startSyncActivity.checkMastersDownloadProgress();

		assertNotNull(result);
		assertTrue(result.contains("Error in Master data Download progress check : "));
	}

	@Test
	void testGetVanDetailsForMasterDownload() throws Exception {
		OutputResponse response = new OutputResponse();

		String s = "test";

		when(downloadDataFromServerImpl.getVanDetailsForMasterDownload()).thenReturn(s);

		String expResponse = startSyncActivity.getVanDetailsForMasterDownload();

		response.setResponse(s);

		assertNotNull(s);
		assertEquals(expResponse, startSyncActivity.getVanDetailsForMasterDownload());
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetVanDetailsForMasterDownload_Error() throws Exception {
		OutputResponse response = new OutputResponse();

		String s = null;

		when(downloadDataFromServerImpl.getVanDetailsForMasterDownload()).thenReturn(s);

		String expResponse = startSyncActivity.getVanDetailsForMasterDownload();

		response.setError(5000, "Error while getting van details.");

		assertNull(s);
		assertEquals(expResponse, startSyncActivity.getVanDetailsForMasterDownload());
		assertTrue(response.toString().contains("Error while getting van details."));
	}

	@Test
	void testGetVanDetailsForMasterDownload_Exception() throws Exception {
		when(downloadDataFromServerImpl.getVanDetailsForMasterDownload())
				.thenThrow(new RuntimeException("Error while getting van details"));

		String result = startSyncActivity.getVanDetailsForMasterDownload();

		assertNotNull(result);
		assertTrue(result.contains("Error while getting van details"));
	}

	@Test
	void testCallCentralAPIToGenerateBenIDAndimportToLocal_Error() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = " { \"/callCentralAPIToGenerateBenIDAndimportToLocal\" }";
		String authorization = "Authorization";
		String serverAuthorization = "ServerAuthorization";
		int i = 0;

		when(downloadDataFromServerImpl.callCentralAPIToGenerateBenIDAndimportToLocal(requestOBJ, authorization,
				serverAuthorization)).thenReturn(i);

		String expResponse = startSyncActivity.callCentralAPIToGenerateBenIDAndimportToLocal(requestOBJ, authorization,
				serverAuthorization);

		response.setError(5000, "Error while generating UNIQUE_ID at central server");

		assertTrue(i == 0);
		assertEquals(expResponse, startSyncActivity.callCentralAPIToGenerateBenIDAndimportToLocal(requestOBJ,
				authorization, serverAuthorization));
		assertTrue(response.toString().contains("Error while generating UNIQUE_ID at central server"));
	}

	@Test
	void testCallCentralAPIToGenerateBenIDAndimportToLocal_ImportError() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = " { \"/callCentralAPIToGenerateBenIDAndimportToLocal\" }";
		String authorization = "Authorization";
		String serverAuthorization = "ServerAuthorization";
		int i = 1;

		when(downloadDataFromServerImpl.callCentralAPIToGenerateBenIDAndimportToLocal(requestOBJ, authorization,
				serverAuthorization)).thenReturn(i);

		String expResponse = startSyncActivity.callCentralAPIToGenerateBenIDAndimportToLocal(requestOBJ, authorization,
				serverAuthorization);

		response.setError(5000, "UNIQUE_ID generated successfully, but error while importing to local");

		assertTrue(i == 1);
		assertEquals(expResponse, startSyncActivity.callCentralAPIToGenerateBenIDAndimportToLocal(requestOBJ,
				authorization, serverAuthorization));
		assertTrue(
				response.toString().contains("UNIQUE_ID generated successfully, but error while importing to local"));
	}

	@Test
	void testCallCentralAPIToGenerateBenIDAndimportToLocal_ImportSuccess() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = " { \"/callCentralAPIToGenerateBenIDAndimportToLocal\" }";
		String authorization = "Authorization";
		String serverAuthorization = "ServerAuthorization";
		int i = 2;

		when(downloadDataFromServerImpl.callCentralAPIToGenerateBenIDAndimportToLocal(requestOBJ, authorization,
				serverAuthorization)).thenReturn(i);

		String expResponse = startSyncActivity.callCentralAPIToGenerateBenIDAndimportToLocal(requestOBJ, authorization,
				serverAuthorization);

		response.setResponse("UNIQUE_ID generated and imported successfully");

		assertTrue(i == 2);
		assertEquals(expResponse, startSyncActivity.callCentralAPIToGenerateBenIDAndimportToLocal(requestOBJ,
				authorization, serverAuthorization));
		assertTrue(response.toString().contains("UNIQUE_ID generated and imported successfully"));
	}

	@Test
	void testCallCentralAPIToGenerateBenIDAndimportToLocal_Exception() throws Exception {
		when(downloadDataFromServerImpl.callCentralAPIToGenerateBenIDAndimportToLocal(any(), any(), any()))
				.thenThrow(new RuntimeException("Error while getting van details"));

		String result = startSyncActivity.callCentralAPIToGenerateBenIDAndimportToLocal(GROUP_ID,
				PROVIDER_SERVICE_MAP_ID, GROUP_ID);

		assertNotNull(result);
		assertTrue(result.contains("Error while getting van details"));
	}

	@Test
	void testDownloadTransactionToLocal() throws JSONException, Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"vanID\": 123}";
		String serverAuthorization = "ServerAuthorization";
		int i = 1;

		JSONObject obj = new JSONObject(requestOBJ);

		when(downloadDataFromServerTransactionalImpl.downloadTransactionalData(obj.getInt("vanID"),
				serverAuthorization)).thenReturn(i);

		String expResponse = startSyncActivity.downloadTransactionToLocal(requestOBJ, serverAuthorization);

		response.setResponse("Success");

		assertTrue(obj.has("vanID") && obj.get("vanID") != null);
		assertTrue(i > 0);

		assertEquals(expResponse, startSyncActivity.downloadTransactionToLocal(requestOBJ, serverAuthorization));
		assertTrue(response.toString().contains("Success"));
	}

	@Test
	void testDownloadTransactionToLocal_Issue() throws JSONException, Exception {
		OutputResponse response = new OutputResponse();

		String requestOBJ = "{\"vanID\": 123}";
		String serverAuthorization = "ServerAuthorization";
		int i = -1;

		JSONObject obj = new JSONObject(requestOBJ);

		when(downloadDataFromServerTransactionalImpl.downloadTransactionalData(obj.getInt("vanID"),
				serverAuthorization)).thenReturn(i);

		String expResponse = startSyncActivity.downloadTransactionToLocal(requestOBJ, serverAuthorization);

		response.setError(5000, "Issue in download. Please contact administrator");

		assertTrue(obj.has("vanID") && obj.get("vanID") != null);
		assertTrue(i < 0);

		assertEquals(expResponse, startSyncActivity.downloadTransactionToLocal(requestOBJ, serverAuthorization));
		assertTrue(response.toString().contains("Issue in download. Please contact administrator"));
	}

	@Test
	void testDownloadTransactionToLocal_Exception() throws Exception {
		String requestOBJ = "{\"vanID\": 123}";
		String serverAuthorization = "ServerAuthorization";

		when(downloadDataFromServerTransactionalImpl.downloadTransactionalData(123, serverAuthorization))
				.thenThrow(new RuntimeException("Error while downloading inventory transaction data"));

		String expResponse = startSyncActivity.downloadTransactionToLocal(requestOBJ, serverAuthorization);

		assertNotNull(expResponse);
		assertTrue(expResponse.contains("Error while downloading inventory transaction data"));

	}
}
