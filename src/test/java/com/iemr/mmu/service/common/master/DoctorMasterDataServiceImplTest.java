package com.iemr.mmu.service.common.master;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.mmu.repo.masterrepo.anc.ServiceMasterRepo;
import com.iemr.mmu.repo.masterrepo.doctor.InstituteRepo;
import com.iemr.mmu.repo.masterrepo.doctor.PreMalignantLesionMasterRepo;

@ExtendWith(MockitoExtension.class)
class DoctorMasterDataServiceImplTest {

	@Mock
	private PreMalignantLesionMasterRepo preMalignantLesionMasterRepo;
	@Mock
	private InstituteRepo instituteRepo;
	@Mock
	private ServiceMasterRepo serviceMasterRepo;
	@InjectMocks
	DoctorMasterDataServiceImpl doctorMasterDataService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Test
	void testGetCancerScreeningMasterDataForDoctor() {
		int psmID = 1; // Example psmID

		// Mocking repository calls
		when(preMalignantLesionMasterRepo.getPreMalignantLesionMaster()).thenReturn(new ArrayList<>());
		when(instituteRepo.getInstituteDetails(psmID)).thenReturn(new ArrayList<>());
		when(serviceMasterRepo.getAdditionalServices()).thenReturn(new ArrayList<>());

		// Call the method under test
		String result = doctorMasterDataService.getCancerScreeningMasterDataForDoctor(psmID);

		// Verify repository interactions
		verify(preMalignantLesionMasterRepo, times(1)).getPreMalignantLesionMaster();
		verify(instituteRepo, times(1)).getInstituteDetails(psmID);
		verify(serviceMasterRepo, times(1)).getAdditionalServices();

		// Assert the results (based on expected JSON structure)
		assertNotNull(result);
	}

}
