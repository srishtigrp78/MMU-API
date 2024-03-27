package com.iemr.mmu.service.dataSyncActivity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.google.gson.Gson;
import com.iemr.mmu.data.syncActivity_syncLayer.SyncUtilityClass;
import com.iemr.mmu.repo.login.MasterVanRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.DataSyncGroupsRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.SyncUtilityClassRepo;

@ExtendWith(MockitoExtension.class)
class UploadDataToServerImplTest2 {

	@Mock
	private DataSyncRepository dataSyncRepository;
	@Mock
	private DataSyncGroupsRepo dataSyncGroupsRepo;
	@Mock
	private MasterVanRepo masterVanRepo;

	@Mock
	private SyncUtilityClassRepo syncutilityClassRepo;

	@InjectMocks
	UploadDataToServerImpl uploadDataToServerService;

	@Mock
	private RestTemplate restTemplate;

	@Test
	public void testGetDataToSyncToServer() throws Exception {
		int vanID = 123;
		int groupID = 456;
		String user = "user";
		String authorization = "auth";

		String expectedSyncData = null;

		String result = uploadDataToServerService.getDataToSyncToServer(vanID, groupID, user, authorization);
		// System.out.println(result);

		assertEquals(expectedSyncData, result);
	}
//	@Test
//	void testSyncIntercepter() {
//		fail("Not yet implemented");
//	}

	@Test
	void testSyncIntercepter_Success() throws Exception {
		// Sample input data
		int vanID = 123;
		int groupID = 456;
		String user = "user";
		String Authorization = "Bearer token";

		// Mock dependencies and behaviors
		int facilityID = 789;
		String dataSyncUploadUrl = "https://example.com/sync";
		String responseBody = "{\"statusCode\":200}";
		List<SyncUtilityClass> syncUtilityClassList = new ArrayList<>(); // Add SyncUtilityClass objects for testing

		// Call the method and verify the output
		String result = uploadDataToServerService.syncIntercepter(vanID, groupID, user, Authorization);

		System.out.println(result);

		assertNull(result);
	}

	@Test
	void testGetVanAndServerColumnList_Success() throws Exception {
		// Sample input data
		Integer groupID = 123;

		// Mock the repository to return a list of SyncUtilityClass objects
		List<SyncUtilityClass> expectedSyncUtilityClassList = new ArrayList<>();
		// Add sample SyncUtilityClass objects to the list if necessary
		// expectedSyncUtilityClassList.add(...);

		Mockito.when(syncutilityClassRepo.findBySyncTableGroupIDAndDeletedOrderBySyncTableDetailID(groupID, false))
				.thenReturn(expectedSyncUtilityClassList);

		// Call the method and verify the output
		List<SyncUtilityClass> result = uploadDataToServerService.getVanAndServerColumnList(groupID);
		assertNotNull(result);
		assertEquals(expectedSyncUtilityClassList.size(), result.size());
		// Add more specific assertions if necessary to compare individual elements
	}
//
//	@Test
//	void testSyncDataToServer() {
//		fail("Not yet implemented");
//	}

	
	@Test
	void testGetVanSerialNoListForSyncedData_NotLastElement() throws Exception {
		// Create a sample dataToBesync list
		List<Map<String, Object>> dataToBesync = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("vanAutoIncColumnName", "12345");
		dataToBesync.add(map1);

		Map<String, Object> map2 = new HashMap<>();
		map2.put("vanAutoIncColumnName", "67890");
		dataToBesync.add(map2);

		StringBuilder vanSerialNos = uploadDataToServerService.getVanSerialNoListForSyncedData("vanAutoIncColumnName",
				dataToBesync);
		assertEquals("12345,67890", vanSerialNos.toString());
	}

	@Test
	void testGetVanSerialNoListForSyncedData_LastElement() throws Exception {
		// Create a sample dataToBesync list with a single element
		List<Map<String, Object>> dataToBesync = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("vanAutoIncColumnName", "67890");
		dataToBesync.add(map1);

		StringBuilder vanSerialNos = uploadDataToServerService.getVanSerialNoListForSyncedData("vanAutoIncColumnName",
				dataToBesync);
		assertEquals("67890", vanSerialNos.toString());
	}

	@Test
	void testGetVanSerialNoListForSyncedData_EmptyList() throws Exception {
		// Test with an empty dataToBesync list
		List<Map<String, Object>> dataToBesync = new ArrayList<>();
		StringBuilder vanSerialNos = uploadDataToServerService.getVanSerialNoListForSyncedData("vanAutoIncColumnName",
				dataToBesync);
		assertEquals("", vanSerialNos.toString());
	}

//	@Test
//	void testGetDataSyncGroupDetails() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetDataSyncGroupDetails() {
		String expectedJson = new Gson().toJson(dataSyncGroupsRepo.findByDeleted(false));
		String actualJson = uploadDataToServerService.getDataSyncGroupDetails();

		// Compare the expected and actual JSON strings
		assertEquals(expectedJson, actualJson);
	}

	@Test
	void testGetDataSyncGroupDetailsReturnsNull() {
		when(dataSyncGroupsRepo.findByDeleted(false)).thenReturn(null);
		String actualJson = uploadDataToServerService.getDataSyncGroupDetails();

		// Verify that the method returns null
		assertNull(actualJson);
	}

}
