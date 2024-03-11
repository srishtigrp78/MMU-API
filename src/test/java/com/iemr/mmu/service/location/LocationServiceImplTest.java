package com.iemr.mmu.service.location;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Type;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.iemr.mmu.data.location.Country;
import com.iemr.mmu.data.location.CountryCityMaster;
import com.iemr.mmu.data.location.DistrictBlock;
import com.iemr.mmu.data.location.DistrictBranchMapping;
import com.iemr.mmu.data.location.Districts;
import com.iemr.mmu.data.location.States;
import com.iemr.mmu.data.location.V_GetLocDetailsFromSPidAndPSMid;
import com.iemr.mmu.data.location.ZoneMaster;
import com.iemr.mmu.data.login.MasterServicePoint;
import com.iemr.mmu.data.login.ParkingPlace;
import com.iemr.mmu.repo.location.CountryCityMasterRepo;
import com.iemr.mmu.repo.location.CountryMasterRepo;
import com.iemr.mmu.repo.location.DistrictBlockMasterRepo;
import com.iemr.mmu.repo.location.DistrictBranchMasterRepo;
import com.iemr.mmu.repo.location.DistrictMasterRepo;
import com.iemr.mmu.repo.location.ParkingPlaceMasterRepo;
import com.iemr.mmu.repo.location.ServicePointMasterRepo;
import com.iemr.mmu.repo.location.StateMasterRepo;
import com.iemr.mmu.repo.location.V_GetLocDetailsFromSPidAndPSMidRepo;
import com.iemr.mmu.repo.location.V_get_prkngplc_dist_zone_state_from_spidRepo;
import com.iemr.mmu.repo.location.ZoneMasterRepo;
import com.iemr.mmu.repo.login.ServicePointVillageMappingRepo;

@ExtendWith(MockitoExtension.class)
class LocationServiceImplTest {
	@Mock
	private CountryMasterRepo countryMasterRepo;
	@Mock
	private CountryCityMasterRepo countryCityMasterRepo;
	@Mock
	private StateMasterRepo stateMasterRepo;
	@Mock
	private ZoneMasterRepo zoneMasterRepo;
	@Mock
	private DistrictMasterRepo districtMasterRepo;
	@Mock
	private DistrictBlockMasterRepo districtBlockMasterRepo;
	@Mock
	private ParkingPlaceMasterRepo parkingPlaceMasterRepo;
	@Mock
	private ServicePointMasterRepo servicePointMasterRepo;
	@Mock
	private V_GetLocDetailsFromSPidAndPSMidRepo v_GetLocDetailsFromSPidAndPSMidRepo;
	@Mock
	private ServicePointVillageMappingRepo servicePointVillageMappingRepo;
	@Mock
	private DistrictBranchMasterRepo districtBranchMasterRepo;
	@Mock
	private V_get_prkngplc_dist_zone_state_from_spidRepo v_get_prkngplc_dist_zone_state_from_spidRepo;

	@InjectMocks
	LocationServiceImpl locationServiceImpl;

	@Test
	public void testGetStateList() {
		// Prepare mock data
		ArrayList<Object[]> mockData = new ArrayList<>();
		mockData.add(new Object[] { 1, "State 1" });
		mockData.add(new Object[] { 2, "State 2" });

		// Mock the behavior of stateMasterRepo to return the mock data
		when(stateMasterRepo.getStateMaster()).thenReturn(mockData);

		// Call the method under test
		String result = locationServiceImpl.getStateList();

		// Prepare expected result
		ArrayList<States> expectedList = new ArrayList<>();
		expectedList.add(new States(1, "State 1"));
		expectedList.add(new States(2, "State 2"));
		String expectedResult = new Gson().toJson(expectedList);

		// Assert the result
		assertEquals(expectedResult, result);
	}

	@Test
	public void testGetCountryList() {
		// Prepare mock data
		ArrayList<Country> mockData = new ArrayList<>();
		mockData.add(new Country(1, "Country 1"));
		mockData.add(new Country(2, "Country 2"));

		// Mock the behavior of countryMasterRepo to return the mock data
		when(countryMasterRepo.findAllCountries()).thenReturn(mockData);

		// Call the method under test
		String result = locationServiceImpl.getCountryList();

		// Prepare expected result
		String expectedResult = new Gson().toJson(mockData);

		// Assert the result
		assertEquals(expectedResult, result);
	}

	@Test
	public void testGetCountryCityList() {
		Integer countryID = 1; // Example country ID
		// Prepare mock data
		ArrayList<CountryCityMaster> mockData = new ArrayList<>();

		// Mock the behavior of countryCityMasterRepo to return the mock data
		when(countryCityMasterRepo.findByCountryIDAndDeleted(countryID, false)).thenReturn(mockData);

		// Call the method under test
		String result = locationServiceImpl.getCountryCityList(countryID);

		// Prepare expected result
		String expectedResult = new Gson().toJson(mockData);

		// Assert the result
		assertEquals(expectedResult, result, "The expected JSON does not match the actual JSON.");
	}

	@Test
	public void testGetZoneList() {
		Integer providerServiceMapID = 1; // Example ID
		// Prepare mock data
		ArrayList<Object[]> mockZoneMasterList = new ArrayList<>();
		mockZoneMasterList.add(new Object[] { 1, "Zone 1" });
		mockZoneMasterList.add(new Object[] { 2, "Zone 2" });

		// Mock the behavior of zoneMasterRepo
		when(zoneMasterRepo.getZoneMaster(providerServiceMapID)).thenReturn(mockZoneMasterList);

		// Execute the method under test
		String result = locationServiceImpl.getZoneList(providerServiceMapID);

		// Prepare the expected result
		ArrayList<ZoneMaster> expectedZoneList = new ArrayList<>();
		expectedZoneList.add(new ZoneMaster(1, "Zone 1"));
		expectedZoneList.add(new ZoneMaster(2, "Zone 2"));
		String expectedResult = new Gson().toJson(expectedZoneList);

		// Assert the result
		assertEquals(expectedResult, result, "The expected JSON does not match the actual JSON.");
	}

	@Test
	void testGetDistrictList() {
		Integer stateID = 1; // Example state ID
		// Prepare mock data
		ArrayList<Object[]> mockDistrictMasterList = new ArrayList<>();
		mockDistrictMasterList.add(new Object[] { 1, "District 1" });
		mockDistrictMasterList.add(new Object[] { 2, "District 2" });

		// Mock the behavior of districtMasterRepo
		when(districtMasterRepo.getDistrictMaster(stateID)).thenReturn(mockDistrictMasterList);

		// Execute the method under test
		String result = locationServiceImpl.getDistrictList(stateID);

		// Prepare the expected result
		ArrayList<Districts> expectedDistrictList = new ArrayList<>();
		expectedDistrictList.add(new Districts(1, "District 1"));
		expectedDistrictList.add(new Districts(2, "District 2"));
		String expectedResult = new Gson().toJson(expectedDistrictList);

		// Assert the result
		assertEquals(expectedResult, result, "The expected JSON does not match the actual JSON.");
	}

	@Test
	void testGetDistrictBlockList() {
		Integer districtID = 1; // Example district ID
		// Prepare mock data
		ArrayList<Object[]> mockDistrictBlockMasterList = new ArrayList<>();
		mockDistrictBlockMasterList.add(new Object[] { 1, "Block 1" });
		mockDistrictBlockMasterList.add(new Object[] { 2, "Block 2" });

		// Mock the behavior of districtBlockMasterRepo
		when(districtBlockMasterRepo.getDistrictBlockMaster(districtID)).thenReturn(mockDistrictBlockMasterList);

		// Execute the method under test
		String result = locationServiceImpl.getDistrictBlockList(districtID);

		// Prepare the expected result
		ArrayList<DistrictBlock> expectedBlockList = new ArrayList<>();
		expectedBlockList.add(new DistrictBlock(1, "Block 1"));
		expectedBlockList.add(new DistrictBlock(2, "Block 2"));
		String expectedResult = new Gson().toJson(expectedBlockList);

		// Assert the result
		assertEquals(expectedResult, result, "The expected JSON does not match the actual JSON.");
	}

	@Test
	void testGetParkingPlaceList() {
		Integer providerServiceMapID = 1; // Example provider service map ID
		// Prepare mock data
		ArrayList<Object[]> mockParkingPlaceMasterList = new ArrayList<>();
		mockParkingPlaceMasterList.add(new Object[] { 1, "Parking Place 1" });
		mockParkingPlaceMasterList.add(new Object[] { 2, "Parking Place 2" });

		// Mock the behavior of parkingPlaceMasterRepo
		when(parkingPlaceMasterRepo.getParkingPlaceMaster(providerServiceMapID)).thenReturn(mockParkingPlaceMasterList);

		// Execute the method under test
		String result = locationServiceImpl.getParkingPlaceList(providerServiceMapID);

		// Prepare the expected result
		ArrayList<ParkingPlace> expectedParkingPlaceList = new ArrayList<>();
		expectedParkingPlaceList.add(new ParkingPlace(1, "Parking Place 1"));
		expectedParkingPlaceList.add(new ParkingPlace(2, "Parking Place 2"));
		String expectedResult = new Gson().toJson(expectedParkingPlaceList);

		// Assert the result
		assertEquals(expectedResult, result, "The expected JSON does not match the actual JSON.");
	}

	@Test
	void testGetServicePointPlaceList() {
		Integer parkingPlaceID = 1; // Example parking place ID
		// Prepare mock data
		ArrayList<Object[]> mockServicePointMasterList = new ArrayList<>();
		mockServicePointMasterList.add(new Object[] { 1, "Service Point 1" });
		mockServicePointMasterList.add(new Object[] { 2, "Service Point 2" });

		// Mock the behavior of servicePointMasterRepo
		when(servicePointMasterRepo.getServicePointMaster(parkingPlaceID)).thenReturn(mockServicePointMasterList);

		// Execute the method under test
		String result = locationServiceImpl.getServicePointPlaceList(parkingPlaceID);

		// Prepare the expected result
		ArrayList<MasterServicePoint> expectedServicePointList = new ArrayList<>();
		expectedServicePointList.add(new MasterServicePoint(1, "Service Point 1"));
		expectedServicePointList.add(new MasterServicePoint(2, "Service Point 2"));
		String expectedResult = new Gson().toJson(expectedServicePointList);

		// Assert the result
		assertEquals(expectedResult, result, "The expected JSON does not match the actual JSON.");
	}

	@Test
	public void testGetVillageMasterFromBlockID() {
		Integer distBlockID = 1; // Example district block ID

		// Mocking the static method
		try (MockedStatic<DistrictBranchMapping> mockedStatic = mockStatic(DistrictBranchMapping.class)) {
			// Prepare mock data
			ArrayList<Object[]> mockResultList = new ArrayList<>();
			mockResultList.add(new Object[] { 1, "Village 1" });
			mockResultList.add(new Object[] { 2, "Village 2" });

			// Mock the behavior of districtBranchMasterRepo
			when(districtBranchMasterRepo.findByBlockID(distBlockID)).thenReturn(mockResultList);

			// Define the expected behavior for the static method
			String expectedJson = "[{\"id\":1,\"name\":\"Village 1\"},{\"id\":2,\"name\":\"Village 2\"}]";
			mockedStatic.when(() -> DistrictBranchMapping.getVillageList(any(ArrayList.class)))
					.thenReturn(expectedJson);

			// Execute the method under test
			String result = locationServiceImpl.getVillageMasterFromBlockID(distBlockID);

			// Assert the result
			assertEquals(expectedJson, result, "The expected JSON does not match the actual JSON.");
		}
	}

	@Test
	void testGetLocDetails() {
		// Setup
		Integer spID = 1, spPSMID = 1;
		ArrayList<Object[]> mockLocDetailsList = new ArrayList<>(); // Populate with mock data as needed
		when(v_GetLocDetailsFromSPidAndPSMidRepo
				.findByServicepointidAndSpproviderservicemapidAndPpproviderservicemapidAndZdmproviderservicemapid(spID,
						spPSMID, spPSMID, spPSMID))
				.thenReturn(mockLocDetailsList);
		// Mock the static call - assuming getOtherLocDetails is a static method. If
		// not, adjust accordingly.
		V_GetLocDetailsFromSPidAndPSMid mockLocDetails = new V_GetLocDetailsFromSPidAndPSMid(); // Populate with mock
																								// data
		// Assume a static utility method - this would actually require PowerMock or
		// refactoring for testing

		ArrayList<Object[]> mockStateMasterList = new ArrayList<>(); // Populate with mock data
		when(stateMasterRepo.getStateMaster()).thenReturn(mockStateMasterList);

		List<Object[]> mockServicePointVillageList = new ArrayList<>(); // Populate with mock data
		when(servicePointVillageMappingRepo.getServicePointVillages(spID)).thenReturn(mockServicePointVillageList);

		// Action
		String resultJson = locationServiceImpl.getLocDetails(spID, spPSMID);

		// Assertion
		assertNotNull(resultJson);
		// Parse result to assert individual elements, assuming the method returns a
		// well-structured JSON string
		Map result = new Gson().fromJson(resultJson, Map.class);
		assertTrue(result.containsKey("otherLoc"));
		assertTrue(result.containsKey("stateMaster"));
		assertTrue(result.containsKey("villageMaster"));

	}

	@Test
	void testGetLocDetailsNew() {
		// Prepare test data
		Integer spID = 1;
		Integer spPSMID = 1;

		// Mocking repository responses
		when(v_get_prkngplc_dist_zone_state_from_spidRepo.getDefaultLocDetails(spID, spPSMID))
				.thenReturn(new ArrayList<>()); // Adjust with realistic return objects

		ArrayList<Object[]> stateMasterList = new ArrayList<>();
		stateMasterList.add(new Object[] { 1, "StateName" });
		when(stateMasterRepo.getStateMaster()).thenReturn(stateMasterList);

		List<Object[]> villageMasterList = new ArrayList<>();
		villageMasterList.add(new Object[] { 1, "VillageName" });
		when(servicePointVillageMappingRepo.getServicePointVillages(spID)).thenReturn(villageMasterList);

		// Mocking external method call if not testable directly
		// Assuming `getDefaultLocDetails` is a method that needs mocking.
		// when(yourService.getDefaultLocDetails(any())).thenReturn("Mocked response");

		// Invoke method under test
		String result = locationServiceImpl.getLocDetailsNew(spID, spPSMID);

		// Assert the results
		assertNotNull(result);
		// Here you might want to deserialize the JSON and assert specific fields
		// For simplicity, let's just check it contains some expected text
		assertTrue(result.contains("StateName"));
		assertTrue(result.contains("VillageName"));
	}

	@Test
	public void testGetDistrictTalukList() {
		Integer districtBranchID = 1;

		// Setting up test data
		ArrayList<Object[]> mockData = new ArrayList<>();
		mockData.add(new Object[] { "BlockName1", 1, "DistrictName1", 1 });
		mockData.add(new Object[] { "BlockName2", 2, "DistrictName2", 2 });

		// Mocking repository call
		when(districtBranchMasterRepo.getDistrictTalukList(districtBranchID)).thenReturn(mockData);

		// Calling the method under test
		String result = locationServiceImpl.getDistrictTalukList(districtBranchID);

		// Verify the results (adjust assertion as needed)
		// Here you would deserialize the result JSON and assert the expected values
		// For simplicity, let's just check the result is not null or empty
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

}
