package com.iemr.mmu.service.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.iemr.mmu.data.login.MasterVan;
import com.iemr.mmu.data.login.ServicePointVillageMapping;
import com.iemr.mmu.repo.login.MasterVanRepo;
import com.iemr.mmu.repo.login.ServicePointVillageMappingRepo;
import com.iemr.mmu.repo.login.UserParkingplaceMappingRepo;
import com.iemr.mmu.repo.login.UserVanSpDetails_View_Repo;
import com.iemr.mmu.repo.login.VanServicepointMappingRepo;

@ExtendWith(MockitoExtension.class)
class IemrMmuLoginServiceImplTest {

	@Mock
	private UserParkingplaceMappingRepo userParkingplaceMappingRepo;
	@Mock
	private MasterVanRepo masterVanRepo;
	@Mock
	private VanServicepointMappingRepo vanServicepointMappingRepo;
	@Mock
	private ServicePointVillageMappingRepo servicePointVillageMappingRepo;
	@Mock
	private UserVanSpDetails_View_Repo userVanSpDetails_View_Repo;

	@InjectMocks
	IemrMmuLoginServiceImpl iemrMmuLoginServiceImpl;

	@Test
	void testGetUserServicePointVanDetailsWithNoParkingPlaces() {
		Integer userID = 1;
		when(userParkingplaceMappingRepo.getUserParkingPlce(userID)).thenReturn(Collections.emptyList());

		String result = iemrMmuLoginServiceImpl.getUserServicePointVanDetails(userID);
		assertNotNull(result);
		assertEquals("{}", result.trim());
	}

	@Test
	void testGetUserServicePointVanDetailsWithData() {
		// Setup mock data for userParkingplaceMappingRepo
		List<Object[]> parkingPlaceData = new ArrayList<>();
		parkingPlaceData
				.add(new Object[] { 1, "StateID", "StateName", "DistrictID", "DistrictName", "BlockID", "BlockName" });
		when(userParkingplaceMappingRepo.getUserParkingPlce(anyInt())).thenReturn(parkingPlaceData);

		// Setup mock data for masterVanRepo
		List<Object[]> vanData = new ArrayList<>();
		vanData.add(new Object[] { 1, "VanNO" });
		when(masterVanRepo.getUserVanDatails(any())).thenReturn(vanData);

		// Setup mock data for vanServicepointMappingRepo
		List<Object[]> servicePointData = new ArrayList<>();
		servicePointData.add(new Object[] { 1, "ServicePointName", "SessionType" });
		when(vanServicepointMappingRepo.getuserSpSessionDetails(any())).thenReturn(servicePointData);

		// Call the method to test
		String result = iemrMmuLoginServiceImpl.getUserServicePointVanDetails(1);

		// Assertions
		assertNotNull(result); // You might want to check for specific contents in the result as per your logic
	}

	@Test
	void testGetServicepointVillages_WithNonEmptyList() {
		// Setup
		Integer servicePointID = 1;
		List<Object[]> mockResponse = Arrays.asList(new Object[] { 1, "Village A" }, new Object[] { 2, "Village B" });
		when(servicePointVillageMappingRepo.getServicePointVillages(servicePointID)).thenReturn(mockResponse);

		// Execute
		String result = iemrMmuLoginServiceImpl.getServicepointVillages(servicePointID);

		// Verify
		List<ServicePointVillageMapping> resultList = new Gson().fromJson(result,
				new TypeToken<List<ServicePointVillageMapping>>() {
				}.getType());
		assertEquals(2, resultList.size());
		assertEquals("Village A", resultList.get(0).getVillageName());
		assertEquals("Village B", resultList.get(1).getVillageName());
		verify(servicePointVillageMappingRepo).getServicePointVillages(servicePointID);
	}

	@Test
	void getServicepointVillages_ReturnsEmptyList() {
		// Arrange
		Integer servicePointID = 1;
		List<Object[]> mockResponse = new ArrayList<>();
		when(servicePointVillageMappingRepo.getServicePointVillages(servicePointID)).thenReturn(mockResponse);

		// Act
		String result = iemrMmuLoginServiceImpl.getServicepointVillages(servicePointID);

		// Assert
		assertEquals("[]", result);
	}

	@Test
	void testGetUserVanSpDetails() {
		// Setup
		Integer userID = 1;
		Integer providerServiceMapID = 1;
		ArrayList<Object[]> mockedResult = new ArrayList<>();
		mockedResult.add(new Object[] { 1, 1, "ServiceName", (short) 1, 1, "VanName", 1, 1 });
		when(userVanSpDetails_View_Repo.getUserVanSpDetails_View(userID, providerServiceMapID))
				.thenReturn(mockedResult);

		ArrayList<Object[]> mockedParkingPlaceList = new ArrayList<>();
		mockedParkingPlaceList.add(new Object[] { 1, 1, "StateName", 1, "DistrictName", 1, "BlockName" });
		when(userParkingplaceMappingRepo.getUserParkingPlce(userID)).thenReturn(mockedParkingPlaceList);

		// Execution
		String result = iemrMmuLoginServiceImpl.getUserVanSpDetails(userID, providerServiceMapID);

		// Verification
		assertNotNull(result);
		assertTrue(result.contains("ServiceName"));
		assertTrue(result.contains("StateName"));
	}

	@Test
	public void testGetUserVanSpDetails_WithEmptyResults() {
		// Given
		Integer userID = 1;
		Integer providerServiceMapID = 2;
		when(userVanSpDetails_View_Repo.getUserVanSpDetails_View(userID, providerServiceMapID))
				.thenReturn(new ArrayList<>());
		when(userParkingplaceMappingRepo.getUserParkingPlce(userID)).thenReturn(new ArrayList<>());

		// When
		String result = iemrMmuLoginServiceImpl.getUserVanSpDetails(userID, providerServiceMapID);

		// Then
		Map<String, Object> resultMap = new Gson().fromJson(result, new TypeToken<Map<String, Object>>() {
		}.getType());
		assertEquals(2, resultMap.size()); // Because there are two keys: UserVanSpDetails and UserLocDetails

		// Verify UserVanSpDetails is empty
		List<?> userVanSpDetails = (List<?>) resultMap.get("UserVanSpDetails");
		assertEquals(0, userVanSpDetails.size());

		// Verify UserLocDetails is empty
		Map<?, ?> userLocDetails = (Map<?, ?>) resultMap.get("UserLocDetails");
		assertTrue(userLocDetails.isEmpty());
	}

	@Test
	void testGetVanMaster() throws Exception {
		Integer psmID = 1;
		ArrayList<Object[]> mockedResult = new ArrayList<>();
		mockedResult.add(new Object[] { 1, "Van 1" });
		mockedResult.add(new Object[] { 2, "Van 2" });

		when(masterVanRepo.getVanMaster(psmID)).thenReturn(mockedResult);

		String result = iemrMmuLoginServiceImpl.getVanMaster(psmID);

		assertNotNull(result);
		assertFalse(result.isEmpty());

		Type listType = new TypeToken<ArrayList<MasterVan>>() {
		}.getType();
		List<MasterVan> resultVanMasterList = new Gson().fromJson(result, listType);

		// Assertions to ensure the list contains all expected vans including the
		// initial "All" option
		assertEquals(3, resultVanMasterList.size()); // Because we add "All" plus two mocked entries
		assertEquals("All", resultVanMasterList.get(0).getVehicalNo()); // Adjusted to use getVehicalNo
		assertEquals("Van 1", resultVanMasterList.get(1).getVehicalNo()); // Adjusted to use getVehicalNo
		assertEquals("Van 2", resultVanMasterList.get(2).getVehicalNo()); // Adjusted to use getVehicalNo

		// Verify the interaction with the mock
		verify(masterVanRepo).getVanMaster(psmID);
	}

}
