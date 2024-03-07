package com.iemr.mmu.controller.dataSyncLayerCentral;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iemr.mmu.data.syncActivity_syncLayer.SyncDownloadMaster;
import com.iemr.mmu.data.syncActivity_syncLayer.SyncUploadDataDigester;
import com.iemr.mmu.service.dataSyncLayerCentral.FetchDownloadDataImpl;
import com.iemr.mmu.service.dataSyncLayerCentral.GetDataFromVanAndSyncToDBImpl;
import com.iemr.mmu.service.dataSyncLayerCentral.GetMasterDataFromCentralForVanImpl;
import com.iemr.mmu.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class MMUDataSyncVanToServerTest {
	@Mock
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Mock
	private GetDataFromVanAndSyncToDBImpl getDataFromVanAndSyncToDBImpl;
	@Mock
	private GetMasterDataFromCentralForVanImpl getMasterDataFromCentralForVanImpl;
	@Mock
	private FetchDownloadDataImpl fetchDownloadDataImpl;

	@InjectMocks
	MMUDataSyncVanToServer mmuDataSyncVanToServer;

	@Test
	void testDataSyncToServer_Success() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestOBJ = "{\"requestOBJ\":\"van-to-server\"}";
		String Authorization = "Authorization";
		String s = "test";

		when(getDataFromVanAndSyncToDBImpl.syncDataToServer(requestOBJ, Authorization)).thenReturn(s);

		String expResponse = mmuDataSyncVanToServer.dataSyncToServer(requestOBJ, Authorization);

		response.setResponse(s);

		assertNotNull(s);
		assertEquals(expResponse, mmuDataSyncVanToServer.dataSyncToServer(requestOBJ, Authorization));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testDataSyncToServer_Fail() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestOBJ = "{\"requestOBJ\":\"van-to-server\"}";
		String Authorization = "Authorization";
		String s = null;

		when(getDataFromVanAndSyncToDBImpl.syncDataToServer(requestOBJ, Authorization)).thenReturn(s);

		String expResponse = mmuDataSyncVanToServer.dataSyncToServer(requestOBJ, Authorization);

		response.setError(5000, "data dync failed");

		assertNull(s);
		assertEquals(expResponse, mmuDataSyncVanToServer.dataSyncToServer(requestOBJ, Authorization));
		assertTrue(response.toString().contains("data dync failed"));
	}

	@Test
	void testDataSyncToServer_Exception() throws Exception {
		String requestOBJ = "{\"requestOBJ\":\"van-to-server\"}";
		String Authorization = "Authorization";
		Exception mockException = new RuntimeException("Upload SYNC Exception");

		when(getDataFromVanAndSyncToDBImpl.syncDataToServer(requestOBJ, Authorization)).thenThrow(mockException);

		String actualResponse = mmuDataSyncVanToServer.dataSyncToServer(requestOBJ, Authorization);

		OutputResponse expectedErrorResponse = new OutputResponse();
		expectedErrorResponse.setError(mockException);

		assertNotNull(actualResponse);
		assertTrue(actualResponse.contains("Upload SYNC Exception"));
	}

//*******
	@Test
	void testDataDownloadFromServer_Success() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestOBJ = "{\"requestOBJ\":\"server-to-van\"}";
		String Authorization = "Authorization";
		SyncDownloadMaster syncDownloadMaster = new SyncDownloadMaster();
		String s = "test";

		when(getMasterDataFromCentralForVanImpl.getMasterDataForVan(syncDownloadMaster)).thenReturn(s);

		String expResponse = mmuDataSyncVanToServer.dataDownloadFromServer(syncDownloadMaster, Authorization);

		response.setResponse(s);

		assertNotNull(syncDownloadMaster);
		assertNotNull(s);
		assertEquals(expResponse, mmuDataSyncVanToServer.dataDownloadFromServer(syncDownloadMaster, Authorization));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testDataDownloadFromServer_Error() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestOBJ = "{\"requestOBJ\":\"server-to-van\"}";
		String Authorization = "Authorization";
		SyncDownloadMaster syncDownloadMaster = new SyncDownloadMaster();
		String s = null;

		when(getMasterDataFromCentralForVanImpl.getMasterDataForVan(syncDownloadMaster)).thenReturn(s);

		String expResponse = mmuDataSyncVanToServer.dataDownloadFromServer(syncDownloadMaster, Authorization);

		response.setError(5000, "Error in master download for table " + syncDownloadMaster.getSchemaName() + "."
				+ syncDownloadMaster.getTableName());

		assertNotNull(syncDownloadMaster);
		assertNull(s);
		assertEquals(expResponse, mmuDataSyncVanToServer.dataDownloadFromServer(syncDownloadMaster, Authorization));
		assertTrue(response.toString().contains("Error in master download for table "));
	}

	@Test
	void testDataDownloadFromServer_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestOBJ = "{\"requestOBJ\":\"server-to-van\"}";
		String Authorization = "Authorization";
		SyncDownloadMaster syncDownloadMaster = null;

		String expResponse = mmuDataSyncVanToServer.dataDownloadFromServer(syncDownloadMaster, Authorization);

		response.setError(5000, "Invalid request");

		assertNull(syncDownloadMaster);
		assertEquals(expResponse, mmuDataSyncVanToServer.dataDownloadFromServer(syncDownloadMaster, Authorization));
		assertTrue(response.toString().contains("Invalid request"));
	}
	
	 @Test
	    public void test_dataDownloadFromServer_catchBlock() throws Exception {
	        // Given
	        SyncDownloadMaster syncDownloadMaster = new SyncDownloadMaster();
	        syncDownloadMaster.setSchemaName("testSchema");
	        syncDownloadMaster.setTableName("testTable");

	        when(getMasterDataFromCentralForVanImpl.getMasterDataForVan(any(SyncDownloadMaster.class)))
	                .thenThrow(new RuntimeException("Test Exception"));

	        // When
	        String result = mmuDataSyncVanToServer.dataDownloadFromServer(syncDownloadMaster, "fakeAuth");

	        // Then
	        OutputResponse expectedResponse = new OutputResponse();
	        expectedResponse.setError(new RuntimeException("Test Exception"));
	        assertEquals(expectedResponse.toStringWithSerialization(), result);

	        // Verify that getMasterDataForVan was called
	        verify(getMasterDataFromCentralForVanImpl).getMasterDataForVan(any(SyncDownloadMaster.class));
	    }

//******
	@Test
	void testDataDownloadFromServerTransactional() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestOBJ = "{\"requestOBJ\":\"server-to-van-transactional\"}";
		String Authorization = "Authorization";
		SyncUploadDataDigester syncUploadDataDigester = new SyncUploadDataDigester();
		String s = "test";

		when(fetchDownloadDataImpl.getDownloadData(syncUploadDataDigester)).thenReturn(s);

		String expResponse = mmuDataSyncVanToServer.dataDownloadFromServerTransactional(syncUploadDataDigester,
				Authorization);

		response.setResponse(s);

		assertNotNull(syncUploadDataDigester);
		assertNotNull(s);
		assertEquals(expResponse,
				mmuDataSyncVanToServer.dataDownloadFromServerTransactional(syncUploadDataDigester, Authorization));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testDataDownloadFromServerTransactional_Error() throws Exception {
		OutputResponse response = new OutputResponse();
		String requestOBJ = "{\"requestOBJ\":\"server-to-van-transactional\"}";
		String Authorization = "Authorization";
		SyncUploadDataDigester syncUploadDataDigester = new SyncUploadDataDigester();
		String s = null;

		when(fetchDownloadDataImpl.getDownloadData(syncUploadDataDigester)).thenReturn(s);

		String expResponse = mmuDataSyncVanToServer.dataDownloadFromServerTransactional(syncUploadDataDigester,
				Authorization);

		response.setError(5000, "Error in data download for table " + syncUploadDataDigester.getSchemaName() + "."
				+ syncUploadDataDigester.getTableName());

		assertNotNull(syncUploadDataDigester);
		assertNull(s);
		assertEquals(expResponse,
				mmuDataSyncVanToServer.dataDownloadFromServerTransactional(syncUploadDataDigester, Authorization));
		assertTrue(response.toString().contains("Error in data download for table "));
	}

	@Test
	void testDataDownloadFromServerTransactional_InvalidRequest() throws Exception {
	    String Authorization = "Authorization";
	    SyncUploadDataDigester syncUploadDataDigester = null; 

	    String response = mmuDataSyncVanToServer.dataDownloadFromServerTransactional(syncUploadDataDigester, Authorization);

	    OutputResponse expectedResponse = new OutputResponse();
	    expectedResponse.setError(5000, "Invalid request");
	    
	    assertNotNull(response);
	    assertEquals(expectedResponse.toStringWithSerialization(), response);
	}

	
	 @Test
	    void testDataDownloadFromServerTransactionalException() throws Exception {
	        SyncUploadDataDigester syncUploadDataDigester = new SyncUploadDataDigester();
	        String authorization = "AuthorizationHeaderContent";

	        when(fetchDownloadDataImpl.getDownloadData(syncUploadDataDigester))
	                .thenThrow(new RuntimeException( " - Error in data download for table "));

	        String response = mmuDataSyncVanToServer.dataDownloadFromServerTransactional(syncUploadDataDigester, authorization);

	        assertTrue(response.contains( " - Error in data download for table "));
	    }
	
//***********
	@Test
	void testUpdateProcessedFlagPostDownload() throws Exception {
		OutputResponse response = new OutputResponse();
		SyncUploadDataDigester syncUploadDataDigester = new SyncUploadDataDigester();
		String Authorization = "Authorization";
		int i = 1;

		when(fetchDownloadDataImpl.updateProcessedFlagPostSuccessfullDownload(syncUploadDataDigester)).thenReturn(i);

		String expResponse = mmuDataSyncVanToServer.updateProcessedFlagPostDownload(syncUploadDataDigester,
				Authorization);

		response.setResponse("success");

		assertNotNull(syncUploadDataDigester);
		assertTrue(i > 0);
		assertEquals(expResponse,
				mmuDataSyncVanToServer.updateProcessedFlagPostDownload(syncUploadDataDigester, Authorization));
		assertTrue(response.toString().contains("success"));
	}

	@Test
	void testUpdateProcessedFlagPostDownload_Error() throws Exception {
		OutputResponse response = new OutputResponse();
		SyncUploadDataDigester syncUploadDataDigester = new SyncUploadDataDigester();
		String Authorization = "Authorization";
		int i = -1;

		when(fetchDownloadDataImpl.updateProcessedFlagPostSuccessfullDownload(syncUploadDataDigester)).thenReturn(i);

		String expResponse = mmuDataSyncVanToServer.updateProcessedFlagPostDownload(syncUploadDataDigester,
				Authorization);

		response.setError(5000,
				"Error while updating flag. Please contact administrator " + syncUploadDataDigester.getSchemaName()
						+ "." + syncUploadDataDigester.getTableName() + "." + syncUploadDataDigester.getIds());

		assertNotNull(syncUploadDataDigester);
		assertTrue(i < 0);
		assertEquals(expResponse,
				mmuDataSyncVanToServer.updateProcessedFlagPostDownload(syncUploadDataDigester, Authorization));
		assertTrue(response.toString().contains("Error while updating flag. Please contact administrator"));
	}

	
	@Test
	void testUpdateProcessedFlagPostDownload_InvalidRequest() throws Exception {
	    SyncUploadDataDigester syncUploadDataDigester = null; 
	    String Authorization = "Authorization";
	    
	    String expResponse = mmuDataSyncVanToServer.updateProcessedFlagPostDownload(syncUploadDataDigester, Authorization);
	    
	    OutputResponse expectedErrorResponse = new OutputResponse();
	    expectedErrorResponse.setError(5000, "Invalid request");
	    
	    assertNotNull(expResponse);
	    assertTrue(expResponse.contains("Invalid request"));
	    assertEquals(expectedErrorResponse.toStringWithSerialization(), expResponse);
	}

	@Test
	void testUpdateProcessedFlagPostDownload_Exception() throws Exception {
		SyncUploadDataDigester syncUploadDataDigester = new SyncUploadDataDigester();
		String Authorization = "Authorization";

		when(fetchDownloadDataImpl.updateProcessedFlagPostSuccessfullDownload(syncUploadDataDigester))
				.thenThrow(new RuntimeException(" - Error while updating flag. Please contact administrator "));

		String expResponse = mmuDataSyncVanToServer.updateProcessedFlagPostDownload(syncUploadDataDigester,
				Authorization);

		assertTrue(expResponse.contains(" - Error while updating flag. Please contact administrator "));
	}

}
