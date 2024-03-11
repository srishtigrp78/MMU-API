package com.iemr.mmu.service.dataSyncLayerCentral;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iemr.mmu.data.syncActivity_syncLayer.SyncDownloadMaster;

@ExtendWith(MockitoExtension.class)
class GetMasterDataFromCentralForVanImplTest {

	@Mock
	private DataSyncRepositoryCentral dataSyncRepositoryCentral;
	@InjectMocks
	GetMasterDataFromCentralForVanImpl getMasterDataFromCentralForVan;

	private Gson gson = new GsonBuilder().serializeNulls().create();

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetMasterDataForVan_ValidInput() throws Exception {
		SyncDownloadMaster obj = new SyncDownloadMaster();
		obj.setSchemaName("testSchema");
		obj.setTableName("testTable");
		// Set other necessary fields of obj as required

		List<Map<String, Object>> mockResult = new ArrayList<>();
		Map<String, Object> data = new HashMap<>();
		data.put("key", "value");
		mockResult.add(data);

		// Use any() for all parameters to ensure our stub works regardless of the
		// actual parameter values passed
		when(dataSyncRepositoryCentral.getMasterDataFromTable(any(), any(), any(), any(), any(), any(), any()))
				.thenReturn(mockResult);

		String result = getMasterDataFromCentralForVan.getMasterDataForVan(obj);
		assertEquals(gson.toJson(mockResult), result);

		// Verify that getMasterDataFromTable was called once.
		// The parameters here also need to be any() matchers to match the stub setup
		verify(dataSyncRepositoryCentral, times(1)).getMasterDataFromTable(any(), any(), any(), any(), any(), any(),
				any());
	}

	@Test
	public void testGetMasterDataForVan_NullObj() throws Exception {
		String result = getMasterDataFromCentralForVan.getMasterDataForVan(null);
		assertNull(result);
	}

	@Test
	public void testGetMasterDataForVan_NullSchemaOrTable() throws Exception {
		SyncDownloadMaster obj = new SyncDownloadMaster();
		obj.setSchemaName(null);
		obj.setTableName(null);
		// set other fields if necessary

		String result = getMasterDataFromCentralForVan.getMasterDataForVan(obj);
		assertNull(result);

		obj.setSchemaName("testSchema");
		// tableName is still null
		result = getMasterDataFromCentralForVan.getMasterDataForVan(obj);
		assertNull(result);
	}

}
