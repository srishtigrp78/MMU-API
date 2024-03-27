package com.iemr.mmu.service.common.master;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iemr.mmu.data.doctor.TempMasterDrug;
import com.iemr.mmu.repo.doctor.ChiefComplaintMasterRepo;
import com.iemr.mmu.repo.doctor.DrugDoseMasterRepo;
import com.iemr.mmu.repo.doctor.DrugDurationUnitMasterRepo;
import com.iemr.mmu.repo.doctor.DrugFormMasterRepo;
import com.iemr.mmu.repo.doctor.DrugFrequencyMasterRepo;
import com.iemr.mmu.repo.doctor.LabTestMasterRepo;
import com.iemr.mmu.repo.doctor.TempMasterDrugRepo;
import com.iemr.mmu.repo.labModule.ProcedureRepo;

@ExtendWith(MockitoExtension.class)
class QCMasterDataServiceImplTest {

	@Mock
	private ChiefComplaintMasterRepo chiefComplaintMasterRepo;
	@Mock
	private DrugDoseMasterRepo drugDoseMasterRepo;
	@Mock
	private DrugDurationUnitMasterRepo drugDurationUnitMasterRepo;
	@Mock
	private DrugFormMasterRepo drugFormMasterRepo;
	@Mock
	private DrugFrequencyMasterRepo drugFrequencyMasterRepo;
	@Mock
	private LabTestMasterRepo labTestMasterRepo;
	@Mock
	private TempMasterDrugRepo tempMasterDrugRepo;
	@Mock
	private ProcedureRepo procedureRepo;
	@InjectMocks
	QCMasterDataServiceImpl QCMasterDataService;

	@Test
	void testGetQuickConsultMasterData() {
		Integer providerServiceMapID = 1;
		String gender = "male";
		ArrayList<Object[]> mockCCList = new ArrayList<>(); // Populate with mock data
		ArrayList<Object[]> mockDDMList = new ArrayList<>(); // Populate with mock data
		// Continue for other lists...

		when(chiefComplaintMasterRepo.getChiefComplaintMaster()).thenReturn(mockCCList);
		when(drugDoseMasterRepo.getDrugDoseMaster()).thenReturn(mockDDMList);
		// Continue for other repo mocks...

		ArrayList<TempMasterDrug> mockTempMasterDrugList = new ArrayList<>(); // Populate with mock data
		when(tempMasterDrugRepo.findByDeletedFalseOrderByDrugDisplayNameAsc()).thenReturn(mockTempMasterDrugList);

		ArrayList<Object[]> mockProcedures = new ArrayList<>(); // Populate with mock data
		when(procedureRepo.getProcedureMasterData(providerServiceMapID, gender)).thenReturn(mockProcedures);

		// Execute the method under test
		String result = QCMasterDataService.getQuickConsultMasterData(providerServiceMapID, gender);

		// Assertions
		assertNotNull(result);
		// You can deserialize the result back to a Map and assert on specific expected
		// values
		Map<String, Object> resultMap = new Gson().fromJson(result, Map.class);

		assertTrue(resultMap.containsKey("chiefComplaintMaster"));
		assertTrue(resultMap.containsKey("drugDoseMaster"));
		// Continue assertions for other keys...
	}

}
