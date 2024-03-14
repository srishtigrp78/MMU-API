package com.iemr.mmu.service.registrar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.registrar.BeneficiaryData;
import com.iemr.mmu.data.registrar.BeneficiaryDemographicAdditional;
import com.iemr.mmu.data.registrar.BeneficiaryDemographicData;
import com.iemr.mmu.data.registrar.BeneficiaryImage;
import com.iemr.mmu.data.registrar.BeneficiaryPhoneMapping;
import com.iemr.mmu.repo.registrar.BeneficiaryDemographicAdditionalRepo;
import com.iemr.mmu.repo.registrar.BeneficiaryImageRepo;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenData;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenDemoData;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenGovIdMapping;
import com.iemr.mmu.repo.registrar.RegistrarRepoBenPhoneMapData;
import com.iemr.mmu.repo.registrar.RegistrarRepoBeneficiaryDetails;
import com.iemr.mmu.repo.registrar.ReistrarRepoBenSearch;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;

@ExtendWith(MockitoExtension.class)
class RegistrarServiceImplTest {

	@Mock
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Value("${registrationUrl}")
	private String registrationUrl;

	@Value("${registrarQuickSearchByIdUrl}")
	private String registrarQuickSearchByIdUrl;

	@Value("${registrarQuickSearchByPhoneNoUrl}")
	private String registrarQuickSearchByPhoneNoUrl;

	@Value("${beneficiaryEditUrl}")
	private String beneficiaryEditUrl;

	@Value("${registrarAdvanceSearchUrl}")
	private String registrarAdvanceSearchUrl;

	@Mock
	private RegistrarRepoBenData registrarRepoBenData;
	@Mock
	private RegistrarRepoBenDemoData registrarRepoBenDemoData;
	@Mock
	private RegistrarRepoBenPhoneMapData registrarRepoBenPhoneMapData;
	@Mock
	private RegistrarRepoBenGovIdMapping registrarRepoBenGovIdMapping;
	@Mock
	private ReistrarRepoBenSearch reistrarRepoBenSearch;
	@Mock
	private BeneficiaryDemographicAdditionalRepo beneficiaryDemographicAdditionalRepo;
	@Mock
	private RegistrarRepoBeneficiaryDetails registrarRepoBeneficiaryDetails;
	@Mock
	private BeneficiaryImageRepo beneficiaryImageRepo;
	@Mock
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private RegistrarServiceImpl registrarServiceImpl;

	@Test
	void testCreateBeneficiary() {
		// Given
		JsonObject benD = new JsonObject(); // Assuming JsonObject is a valid type you can construct or mock
		BeneficiaryData expectedBenData = new BeneficiaryData(); // Assuming you have a default constructor
		expectedBenData.setBeneficiaryRegID(1L); // Set expected values as per your requirements

		when(registrarRepoBenData.save(any(BeneficiaryData.class))).thenReturn(expectedBenData);

		// When
		BeneficiaryData actualBenData = registrarServiceImpl.createBeneficiary(benD);

		// Then
		assertEquals(expectedBenData, actualBenData);
	}

	// *********

	@Test
	void testCreateBeneficiaryDemographic() {
		JsonObject benD = new JsonObject(); // Assuming you have a JsonObject setup
		Long benRegID = 123L; // Example beneficiary registration ID

		// Mocking the response of the repository
		BeneficiaryDemographicData mockedBenDemoData = new BeneficiaryDemographicData();
		Long expectedDemographicsID = 456L; // Assuming ID to be returned
		mockedBenDemoData.setBenDemographicsID(expectedDemographicsID);
		when(registrarRepoBenDemoData.save(any(BeneficiaryDemographicData.class))).thenReturn(mockedBenDemoData);

		// Calling the method under test
		Long result = registrarServiceImpl.createBeneficiaryDemographic(benD, benRegID);

		// Verification
		assertNotNull(result);
		assertEquals(expectedDemographicsID, result);
	}

	@Test
	void testCreateBeneficiaryDemographicAdditional() {
		JsonObject benD = new JsonObject(); // Assuming you have a JsonObject setup
		Long benRegID = 1L; // Example beneficiary registration ID

		BeneficiaryDemographicAdditional mockedDemographicAdditional = new BeneficiaryDemographicAdditional();
		Long expectedId = 2L; // Example ID to be returned
		mockedDemographicAdditional.setBenDemoAdditionalID(expectedId);

		when(beneficiaryDemographicAdditionalRepo.save(any(BeneficiaryDemographicAdditional.class)))
				.thenReturn(mockedDemographicAdditional);

		// Execute the method under test
		Long resultId = registrarServiceImpl.createBeneficiaryDemographicAdditional(benD, benRegID);

		// Assert and verify
		assertNotNull(resultId);
		assertEquals(expectedId, resultId);
	}

//*****
	@Test
	void testCreateBeneficiaryImage() {
		// Prepare test data
		JsonObject benD = new JsonObject();
		benD.addProperty("image", "testImageData");
		benD.addProperty("createdBy", "testCreator");

		Long expectedBenRegID = 123L;
		BeneficiaryImage mockedBeneficiaryImage = new BeneficiaryImage();
		mockedBeneficiaryImage.setBeneficiaryRegID(expectedBenRegID);
		// Assume the repository save method returns the same beneficiary image object
		when(beneficiaryImageRepo.save(any(BeneficiaryImage.class))).thenReturn(mockedBeneficiaryImage);

		// Execute the method to test
		Long result = registrarServiceImpl.createBeneficiaryImage(benD, expectedBenRegID);

		// Assert the result
		assertThat(result).isEqualTo(expectedBenRegID);
	}

//******
	@Test
	void testCreateBeneficiaryPhoneMapping() {
		// Given
		Long expectedBenPhMapID = 1L;
		JsonObject benD = new JsonObject();
		benD.addProperty("phoneNumber", "1234567890");
		Long benRegID = 1L;

		BeneficiaryPhoneMapping mockedBenPhoneMap = new BeneficiaryPhoneMapping();
		mockedBenPhoneMap.setBenPhMapID(expectedBenPhMapID);

		when(registrarRepoBenPhoneMapData.save(any(BeneficiaryPhoneMapping.class))).thenReturn(mockedBenPhoneMap);

		// When
		Long actualBenPhMapID = registrarServiceImpl.createBeneficiaryPhoneMapping(benD, benRegID);

		// Then
		assertEquals(expectedBenPhMapID, actualBenPhMapID);
	}

//*********	
	@Test
	void testCreateBenGovIdMapping() {
		fail("Not yet implemented");
	}

//*********
	@Test
	void testGetRegWorkList() {
		fail("Not yet implemented");

	}

	@Test
	void testGetQuickSearchBenData() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAdvanceSearchBenData() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenOBJ() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenDemoOBJ() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBenPhoneOBJ() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBeneficiaryDetails() {
		fail("Not yet implemented");
	}

	

	@Test
	void testGetBenImage() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBeneficiaryJsonObject() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBeneficiaryDemographic() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBeneficiaryPhoneMapping() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBenGovIdMapping() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBeneficiaryDemographicAdditional() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBeneficiaryImage() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBeneficiaryPersonalDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testRegisterBeneficiary() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBeneficiaryStringString() {
		fail("Not yet implemented");
	}

	@Test
	void testBeneficiaryQuickSearch() {
		fail("Not yet implemented");
	}

	@Test
	void testBeneficiaryAdvanceSearch() {
		// Arrange
		String requestObj = "{\"key\":\"value\"}";
		String authorization = "Bearer token";
		String registrarAdvanceSearchUrl = "https://example.com/api/search";

		String expectedResponseBody = "{\"response\":\"data\"}";
		ResponseEntity<String> mockedResponse = new ResponseEntity<>(expectedResponseBody, HttpStatus.OK);

		when(restTemplate.exchange(eq(registrarAdvanceSearchUrl), eq(HttpMethod.POST), any(HttpEntity.class),
				eq(String.class))).thenReturn(mockedResponse);

		// Act
		String result = registrarServiceImpl.beneficiaryAdvanceSearch(requestObj, authorization);

		// Assert
		assertEquals(expectedResponseBody, result);
	}

	@Test
	void testSearchAndSubmitBeneficiaryToNurse() throws Exception {
		String requestOBJ = "test";
		int i = 1;
		when(commonBenStatusFlowServiceImpl.createBenFlowRecord(requestOBJ, null, null)).thenReturn(i);

		int expResponse = registrarServiceImpl.searchAndSubmitBeneficiaryToNurse(requestOBJ);

		assertEquals(i, expResponse);

	}

}
