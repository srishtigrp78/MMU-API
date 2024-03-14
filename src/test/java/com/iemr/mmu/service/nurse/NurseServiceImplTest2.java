package com.iemr.mmu.service.nurse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;

@ExtendWith(MockitoExtension.class)
class NurseServiceImplTest2 {

	@Mock
	private BenVisitDetailRepo benVisitDetailRepo;
	@InjectMocks
	NurseServiceImpl nurseService;

	@Mock
	private RestTemplate restTemplate;

	@Test
    void testSavePatientVisitDetails() {
        String result = nurseService.savePatientVisitDetails();

        // Verify that restTemplate was called with the correct parameters
        verify(restTemplate).postForEntity(eq("http://localhost:8080/nurse/testrest1"), any(BenFamilyCancerHistory.class), eq(String.class));
        verify(restTemplate).postForEntity(eq("http://localhost:8080/nurse/testrest2"), any(BenObstetricCancerHistory.class), eq(String.class));

        // Optionally verify the result
        assertEquals("hii", result, "The method should return 'hii'");
    }
	
	@Test
	void testGetBeneficiaryVisitHistory() {
		// Prepare test data
		Long benRegID = 1L;
		BeneficiaryVisitDetail mockVisitDetail = new BeneficiaryVisitDetail();
		List<BeneficiaryVisitDetail> mockVisitDetails = Arrays.asList(mockVisitDetail);

		// Mocking repository response
		when(benVisitDetailRepo.getBeneficiaryVisitHistory(benRegID)).thenReturn(mockVisitDetails);

		// Expected JSON result
		String expectedJson = new Gson().toJson(Map.of("benVisitDetails", mockVisitDetails));

		// Execute the method under test
		String actualJson = nurseService.getBeneficiaryVisitHistory(benRegID);

		// Assert the result
		assertEquals(expectedJson, actualJson);

		// Verify interaction with mocked repo
		verify(benVisitDetailRepo).getBeneficiaryVisitHistory(benRegID);
	}
}
