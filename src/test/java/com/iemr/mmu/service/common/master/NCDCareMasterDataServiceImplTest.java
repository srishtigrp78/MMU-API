package com.iemr.mmu.service.common.master;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.google.gson.Gson;
import com.iemr.mmu.data.masterdata.ncdcare.NCDCareType;
import com.iemr.mmu.data.masterdata.ncdscreening.NCDScreeningCondition;
import com.iemr.mmu.repo.masterrepo.ncdCare.NCDCareTypeRepo;

class NCDCareMasterDataServiceImplTest {

	@Mock
	private NCDScreeningMasterServiceImpl ncdScreeningMasterServiceImpl;

	@Mock
	private NCDCareTypeRepo ncdCareTypeRepo;

	@InjectMocks
	private NCDCareMasterDataServiceImpl service;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetNCDCareMasterDataWithEmptyResults() {
		// Simulate empty results from both methods
		when(ncdScreeningMasterServiceImpl.getNCDScreeningConditions()).thenReturn(new ArrayList<>());
		when(ncdCareTypeRepo.getNCDCareTypes()).thenReturn(new ArrayList<>());

		// Expected JSON for empty lists
		String expectedJson = "{\"ncdCareTypes\":[],\"ncdCareConditions\":[]}";

		String actualJson = service.getNCDCareMasterData();

		// Verify the interaction and the result
		verify(ncdScreeningMasterServiceImpl, times(1)).getNCDScreeningConditions();
		verify(ncdCareTypeRepo, times(1)).getNCDCareTypes();
		assertEquals(expectedJson, actualJson);
	}
}
