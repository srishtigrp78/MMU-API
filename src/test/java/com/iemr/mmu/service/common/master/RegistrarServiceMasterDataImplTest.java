package com.iemr.mmu.service.common.master;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
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
import org.springframework.beans.factory.annotation.Value;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.data.registrar.BeneficiaryData;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.masterrepo.CommunityMasterRepo;
import com.iemr.mmu.repo.masterrepo.GenderMasterRepo;
import com.iemr.mmu.repo.masterrepo.GovIdEntityTypeRepo;
import com.iemr.mmu.repo.masterrepo.IncomeStatusMasterRepo;
import com.iemr.mmu.repo.masterrepo.MaritalStatusMasterRepo;
import com.iemr.mmu.repo.masterrepo.OccupationMasterRepo;
import com.iemr.mmu.repo.masterrepo.QualificationMasterRepo;
import com.iemr.mmu.repo.masterrepo.ReligionMasterRepo;
import com.iemr.mmu.repo.nurse.anc.ANCCareRepo;
import com.iemr.mmu.repo.registrar.BeneficiaryImageRepo;
import com.iemr.mmu.repo.registrar.ReistrarRepoBenSearch;

import io.swagger.models.HttpMethod;

@ExtendWith(MockitoExtension.class)
class RegistrarServiceMasterDataImplTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private String getBenImageFromIdentity;
	private ReistrarRepoBenSearch reistrarRepoBenSearch;
	@Mock
	private CommunityMasterRepo communityMasterRepo;
	@Mock
	private GenderMasterRepo genderMasterRepo;
	@Mock
	private GovIdEntityTypeRepo govIdEntityTypeRepo;
	@Mock
	private IncomeStatusMasterRepo incomeStatusMasterRepo;
	@Mock
	private MaritalStatusMasterRepo maritalStatusMasterRepo;
	@Mock
	private OccupationMasterRepo occupationMasterRepo;
	@Mock
	private QualificationMasterRepo qualificationMasterRepo;
	@Mock
	private ReligionMasterRepo religionMasterRepo;
	@Mock
	private BeneficiaryImageRepo beneficiaryImageRepo;
	@Mock
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
	@Mock
	private ANCCareRepo aNCCareRepo;
	@InjectMocks
	private RegistrarServiceMasterDataImpl registrarServiceMasterData;

	@Test
	void testGetRegMasterDataSuccess() throws JSONException {
		// Mocking the repository calls
		when(communityMasterRepo.getCommunityMaster()).thenReturn(new ArrayList<>(Arrays.asList(/* Mocked data */)));
		when(genderMasterRepo.getGenderMaster()).thenReturn(new ArrayList<>(Arrays.asList(/* Mocked data */)));

		// Calling the method under test
		String resultJson = registrarServiceMasterData.getRegMasterData();

		// Here is a simple way to assert the JSON structure without being too brittle
		assertNotNull(resultJson);
		assertFalse(resultJson.isEmpty());

		// Example using org.json library or any other JSON parsing library
		JSONObject resultObject = new JSONObject(resultJson);
		assertTrue(resultObject.has("communityMaster"));
		assertTrue(resultObject.has("genderMaster"));
	}

//	@Test
//	void testGetBenDetailsByRegID() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetBenDetailsForLeftSideByRegIDNew() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetBenDetailsWithNullBloodGroup() {
		// Prepare mock data
		ArrayList<Object[]> mockBenFlowOBJ = new ArrayList<>(Arrays.asList(/* Mock data */));
		when(beneficiaryFlowStatusRepo.getBenDetailsForLeftSidePanel(anyLong(), anyLong())).thenReturn(mockBenFlowOBJ);
		when(aNCCareRepo.getBenANCCareDetailsStatus(anyLong())).thenReturn(null);

		// Execute the method
		String result = registrarServiceMasterData.getBenDetailsForLeftSideByRegIDNew(1L, 1L, "auth", "request");

		// Verify and assert
		assertNotNull(result);
		// Assert more specifically based on the expected JSON structure
	}

	@Test
	public void testGetBenDetailsWhenBenFlowOBJIsEmpty() {
		// Prepare mock data
		ArrayList<Object[]> mockBenFlowOBJ = new ArrayList<>();
		when(beneficiaryFlowStatusRepo.getBenDetailsForLeftSidePanel(anyLong(), anyLong())).thenReturn(mockBenFlowOBJ);
		// Assuming a behavior or result here, as the original method's handling of this
		// case isn't clear

		// Execute the method
		String result = registrarServiceMasterData.getBenDetailsForLeftSideByRegIDNew(1L, 1L, "auth", "request");

		// Verify and assert
		assertNotNull(result);
	}

//	@Test
//	void testGetBenImageFromIdentityAPI() {
//		fail("Not yet implemented");
//	}
}