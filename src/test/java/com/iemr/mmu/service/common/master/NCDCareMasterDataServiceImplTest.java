package com.iemr.mmu.service.common.master;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.mmu.data.masterdata.ncdcare.NCDCareType;
import com.iemr.mmu.data.masterdata.ncdscreening.NCDScreeningCondition;
import com.iemr.mmu.repo.masterrepo.ncdCare.NCDCareTypeRepo;

@ExtendWith(MockitoExtension.class)
class NCDCareMasterDataServiceImplTest {

	@Mock
	private NCDScreeningMasterServiceImpl ncdScreeningMasterServiceImpl;
	@Mock
	private NCDCareTypeRepo ncdCareTypeRepo;
	@InjectMocks
	NCDCareMasterDataServiceImpl ncdCareMasterDataService;


	@Test
	void testGetNCDCareMasterData() {
		// Prepare mock data
		ArrayList<Object[]> mockScreeningConditions = new ArrayList<>();
		mockScreeningConditions.add(new Object[] { /* Populate with test data */ });
		ArrayList<Object[]> mockCareTypes = new ArrayList<>();
		mockCareTypes.add(new Object[] { /* Populate with test data */ });

		when(ncdScreeningMasterServiceImpl.getNCDScreeningConditions()).thenReturn(mockScreeningConditions);
		when(ncdCareTypeRepo.getNCDCareTypes()).thenReturn(mockCareTypes);

		// Call the method under test
		String jsonResult = ncdCareMasterDataService.getNCDCareMasterData();

		// Verify the result
		assertNotNull(jsonResult);
		Gson gson = new Gson();
		Map<String, Object> resultMap = gson.fromJson(jsonResult, Map.class);
		assertTrue(resultMap.containsKey("ncdCareConditions"));
		assertTrue(resultMap.containsKey("ncdCareTypes"));

		// Verify the interaction with mock objects
		verify(ncdScreeningMasterServiceImpl).getNCDScreeningConditions();
		verify(ncdCareTypeRepo).getNCDCareTypes();
	}
}
