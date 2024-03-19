package com.iemr.mmu.service.location;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.mmu.data.location.Country;
import com.iemr.mmu.data.location.CountryCityMaster;
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
import com.iemr.mmu.service.location.LocationServiceImpl;

@ExtendWith(MockitoExtension.class)
class LocationServiceImplTest2 {
	@Mock
	private CountryCityMasterRepo countryCityMasterRepo;

	@Mock
	private CountryMasterRepo countryMasterRepo;

	@Mock
	private DistrictBlockMasterRepo districtBlockMasterRepo;

	@Mock
	private DistrictBranchMasterRepo districtBranchMasterRepo;

	@Mock
	private DistrictMasterRepo districtMasterRepo;

	@InjectMocks
	private LocationServiceImpl locationServiceImpl;

	@Mock
	private ParkingPlaceMasterRepo parkingPlaceMasterRepo;

	@Mock
	private ServicePointMasterRepo servicePointMasterRepo;

	@Mock
	private ServicePointVillageMappingRepo servicePointVillageMappingRepo;

	@Mock
	private StateMasterRepo stateMasterRepo;

	@Mock
	private V_GetLocDetailsFromSPidAndPSMidRepo v_GetLocDetailsFromSPidAndPSMidRepo;

	@Mock
	private V_get_prkngplc_dist_zone_state_from_spidRepo v_get_prkngplc_dist_zone_state_from_spidRepo;

	@Mock
	private ZoneMasterRepo zoneMasterRepo;

	@Test
	void testGetStateList() {
		// Arrange
		when(stateMasterRepo.getStateMaster()).thenReturn(new ArrayList<>());

		// Act
		String actualStateList = locationServiceImpl.getStateList();

		// Assert
		verify(stateMasterRepo).getStateMaster();
		assertEquals("[]", actualStateList);
	}

	@Test
	void testGetCountryList() {
		// Arrange
		when(countryMasterRepo.findAllCountries()).thenReturn(new ArrayList<>());

		// Act
		String actualCountryList = locationServiceImpl.getCountryList();

		// Assert
		verify(countryMasterRepo).findAllCountries();
		assertEquals("[]", actualCountryList);
	}

	@Test
	void testGetCountryList2() {
		// Arrange
		ArrayList<Country> countryList = new ArrayList<>();
		countryList.add(new Country(1, "Bharat", "+91", "Asia"));
		when(countryMasterRepo.findAllCountries()).thenReturn(countryList);

		// Act
		String actualCountryList = locationServiceImpl.getCountryList();

		// Assert
		verify(countryMasterRepo).findAllCountries();
		assertEquals("[{\"outputMapper\":{}}]", actualCountryList);
	}

	@Test
	void testGetCountryList3() {
		// Arrange
		ArrayList<Country> countryList = new ArrayList<>();
		countryList.add(new Country(1, "Bharat", "+91", "Asia"));
		countryList.add(new Country(2, "London", "+44", "Asia"));
		when(countryMasterRepo.findAllCountries()).thenReturn(countryList);

		// Act
		String actualCountryList = locationServiceImpl.getCountryList();

		// Assert
		verify(countryMasterRepo).findAllCountries();
		assertEquals("[{\"outputMapper\":{}},{\"outputMapper\":{}}]", actualCountryList);
	}

	@Test
	void testGetCountryList4() {
		// Arrange
		ArrayList<Country> countryList = new ArrayList<>();
		countryList.add(new Country(1, "GB"));
		when(countryMasterRepo.findAllCountries()).thenReturn(countryList);

		// Act
		String actualCountryList = locationServiceImpl.getCountryList();

		// Assert
		verify(countryMasterRepo).findAllCountries();
		assertEquals("[{\"countryID\":1,\"countryName\":\"GB\",\"outputMapper\":{}}]", actualCountryList);
	}

	@Test
	void testGetCountryList5() {
		// Arrange
		ArrayList<Country> countryList = new ArrayList<>();
		countryList.add(null);
		when(countryMasterRepo.findAllCountries()).thenReturn(countryList);

		// Act
		String actualCountryList = locationServiceImpl.getCountryList();

		// Assert
		verify(countryMasterRepo).findAllCountries();
		assertEquals("[null]", actualCountryList);
	}

	@Test
	void testGetCountryList6() {
		// Arrange
		ArrayList<Country> countryList = new ArrayList<>();
		countryList.add(new Country(1, ""));
		when(countryMasterRepo.findAllCountries()).thenReturn(countryList);

		// Act
		String actualCountryList = locationServiceImpl.getCountryList();

		// Assert
		verify(countryMasterRepo).findAllCountries();
		assertEquals("[{\"countryID\":1,\"countryName\":\"\",\"outputMapper\":{}}]", actualCountryList);
	}

	@Test
	void testGetCountryCityList() {
		// Arrange
		when(countryCityMasterRepo.findByCountryIDAndDeleted(anyInt(), anyBoolean())).thenReturn(new ArrayList<>());

		// Act
		String actualCountryCityList = locationServiceImpl.getCountryCityList(1);

		// Assert
		verify(countryCityMasterRepo).findByCountryIDAndDeleted(eq(1), eq(false));
		assertEquals("[]", actualCountryCityList);
	}

	@Test
	void testGetCountryCityList2() {
		// Arrange
		ArrayList<CountryCityMaster> countryCityMasterList = new ArrayList<>();
		countryCityMasterList.add(new CountryCityMaster());
		when(countryCityMasterRepo.findByCountryIDAndDeleted(anyInt(), anyBoolean())).thenReturn(countryCityMasterList);

		// Act
		String actualCountryCityList = locationServiceImpl.getCountryCityList(1);

		// Assert
		verify(countryCityMasterRepo).findByCountryIDAndDeleted(eq(1), eq(false));
		assertEquals("[{}]", actualCountryCityList);
	}

	@Test
	void testGetCountryCityList3() {
		// Arrange
		ArrayList<CountryCityMaster> countryCityMasterList = new ArrayList<>();
		countryCityMasterList.add(new CountryCityMaster());
		countryCityMasterList.add(new CountryCityMaster());
		when(countryCityMasterRepo.findByCountryIDAndDeleted(anyInt(), anyBoolean())).thenReturn(countryCityMasterList);

		// Act
		String actualCountryCityList = locationServiceImpl.getCountryCityList(1);

		// Assert
		verify(countryCityMasterRepo).findByCountryIDAndDeleted(eq(1), eq(false));
		assertEquals("[{},{}]", actualCountryCityList);
	}

	@Test
	void testGetZoneList() {
		// Arrange
		when(zoneMasterRepo.getZoneMaster(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

		// Act
		String actualZoneList = locationServiceImpl.getZoneList(1);

		// Assert
		verify(zoneMasterRepo).getZoneMaster(Mockito.<Integer>any());
		assertEquals("[]", actualZoneList);
	}

	@Test
	void testGetDistrictList() {
		// Arrange
		when(districtMasterRepo.getDistrictMaster(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

		// Act
		String actualDistrictList = locationServiceImpl.getDistrictList(1);

		// Assert
		verify(districtMasterRepo).getDistrictMaster(Mockito.<Integer>any());
		assertEquals("[]", actualDistrictList);
	}

	@Test
	void testGetDistrictBlockList() {
		// Arrange
		when(districtBlockMasterRepo.getDistrictBlockMaster(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

		// Act
		String actualDistrictBlockList = locationServiceImpl.getDistrictBlockList(1);

		// Assert
		verify(districtBlockMasterRepo).getDistrictBlockMaster(Mockito.<Integer>any());
		assertEquals("[]", actualDistrictBlockList);
	}

	@Test
	void testGetParkingPlaceList() {
		// Arrange
		when(parkingPlaceMasterRepo.getParkingPlaceMaster(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

		// Act
		String actualParkingPlaceList = locationServiceImpl.getParkingPlaceList(1);

		// Assert
		verify(parkingPlaceMasterRepo).getParkingPlaceMaster(Mockito.<Integer>any());
		assertEquals("[]", actualParkingPlaceList);
	}

	@Test
	void testGetServicePointPlaceList() {
		// Arrange
		when(servicePointMasterRepo.getServicePointMaster(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

		// Act
		String actualServicePointPlaceList = locationServiceImpl.getServicePointPlaceList(1);

		// Assert
		verify(servicePointMasterRepo).getServicePointMaster(Mockito.<Integer>any());
		assertEquals("[]", actualServicePointPlaceList);
	}

	@Test
	void testGetVillageMasterFromBlockID() {
		// Arrange
		when(districtBranchMasterRepo.findByBlockID(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

		// Act
		String actualVillageMasterFromBlockID = locationServiceImpl.getVillageMasterFromBlockID(1);

		// Assert
		verify(districtBranchMasterRepo).findByBlockID(Mockito.<Integer>any());
		assertEquals("[]", actualVillageMasterFromBlockID);
	}

	

	@Test
	void testGetLocDetailsNew() {
		// Arrange
		when(servicePointVillageMappingRepo.getServicePointVillages(Mockito.<Integer>any()))
				.thenReturn(new ArrayList<>());
		when(stateMasterRepo.getStateMaster()).thenReturn(new ArrayList<>());
		when(v_get_prkngplc_dist_zone_state_from_spidRepo.getDefaultLocDetails(Mockito.<Integer>any(),
				Mockito.<Integer>any())).thenReturn(new ArrayList<>());

		// Act
		String actualLocDetailsNew = locationServiceImpl.getLocDetailsNew(1, 1);

		// Assert
		verify(stateMasterRepo).getStateMaster();
		verify(v_get_prkngplc_dist_zone_state_from_spidRepo).getDefaultLocDetails(Mockito.<Integer>any(),
				Mockito.<Integer>any());
		verify(servicePointVillageMappingRepo).getServicePointVillages(Mockito.<Integer>any());
		assertEquals("{\"villageList\":[],\"otherLoc\":{},\"stateMaster\":[]}", actualLocDetailsNew);
	}

	@Test
	void testGetDistrictTalukList() {
		// Arrange
		when(districtBranchMasterRepo.getDistrictTalukList(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

		// Act
		String actualDistrictTalukList = locationServiceImpl.getDistrictTalukList(1);

		// Assert
		verify(districtBranchMasterRepo).getDistrictTalukList(Mockito.<Integer>any());
		assertEquals("[]", actualDistrictTalukList);
	}

	@Test
	void testGettersAndSetters() {

		// Arrange
		LocationServiceImpl locationServiceImpl = new LocationServiceImpl();

		// Act
		locationServiceImpl.setDistrictBlockMasterRepo(mock(DistrictBlockMasterRepo.class));
		locationServiceImpl.setDistrictBranchMasterRepo(mock(DistrictBranchMasterRepo.class));
		locationServiceImpl.setDistrictMasterRepo(mock(DistrictMasterRepo.class));
		locationServiceImpl.setParkingPlaceMasterRepo(mock(ParkingPlaceMasterRepo.class));
		locationServiceImpl.setServicePointMasterRepo(mock(ServicePointMasterRepo.class));
		locationServiceImpl.setServicePointVillageMappingRepo(mock(ServicePointVillageMappingRepo.class));
		locationServiceImpl.setStateMasterRepo(mock(StateMasterRepo.class));
		locationServiceImpl.setV_GetLocDetailsFromSPidAndPSMidRepo(mock(V_GetLocDetailsFromSPidAndPSMidRepo.class));
		locationServiceImpl.setV_get_prkngplc_dist_zone_state_from_spidRepo(
				mock(V_get_prkngplc_dist_zone_state_from_spidRepo.class));
		locationServiceImpl.setZoneMasterRepo(mock(ZoneMasterRepo.class));
	}
}
