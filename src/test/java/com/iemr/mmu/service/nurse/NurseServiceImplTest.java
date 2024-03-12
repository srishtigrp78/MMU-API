package com.iemr.mmu.service.nurse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;

@ExtendWith(MockitoExtension.class)
class NurseServiceImplTest {

	@Mock
	private BenVisitDetailRepo benVisitDetailRepo;

	@InjectMocks
	NurseServiceImpl nurseService;
	
	private RestTemplate restTemplate;

	@Test
	void testSavePatientVisitDetails() {
		// Arrange
		BenFamilyCancerHistory obj = new BenFamilyCancerHistory();
		obj.setCreatedBy("neeraj");

		BenObstetricCancerHistory obj1 = new BenObstetricCancerHistory();
		obj1.setCreatedBy("neeraj");

		when(restTemplate.postForEntity(anyString(), any(), eq(String.class)))
				.thenReturn(ResponseEntity.ok("dummyResponse"));

		// Act
		nurseService.savePatientVisitDetails();

		// Assert
		verify(restTemplate, times(1)).postForEntity("http://localhost:8080/nurse/testrest1", obj, String.class);
		verify(restTemplate, times(1)).postForEntity("http://localhost:8080/nurse/testrest2", obj1, String.class);
	}

	@Test
	void testSavePatientVisitDetails1() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBeneficiaryVisitHistory() {
		fail("Not yet implemented");
	}

}
