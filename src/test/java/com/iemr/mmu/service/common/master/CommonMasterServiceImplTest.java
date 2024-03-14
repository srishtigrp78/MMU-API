package com.iemr.mmu.service.common.master;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.Gson;
import com.iemr.mmu.data.labtechnician.M_ECGabnormalities;
import com.iemr.mmu.repo.labtechnician.M_ECGabnormalitiesRepo;

@ExtendWith(MockitoExtension.class)
class CommonMasterServiceImplTest {
	@Mock
	private ANCMasterDataServiceImpl ancMasterDataServiceImpl;
	@Mock
	private NurseMasterDataServiceImpl nurseMasterDataServiceImpl;
	@Mock
	private DoctorMasterDataServiceImpl doctorMasterDataServiceImpl;
	@Mock
	private RegistrarServiceMasterDataImpl registrarServiceMasterDataImpl;
	@Mock
	private NCDScreeningMasterServiceImpl ncdScreeningServiceImpl;
	@Mock
	private QCMasterDataServiceImpl qCMasterDataServiceImpl;
	@Mock
	private NCDCareMasterDataServiceImpl ncdCareMasterDataServiceImpl;

	@Mock
	private M_ECGabnormalitiesRepo m_ECGabnormalitiesRepo;

	@InjectMocks
	CommonMasterServiceImpl commonMasterServiceImpl;

	@Test
	void testGetVisitReasonAndCategories() {
		String visitReasonAndCategories = "test";
		when(nurseMasterDataServiceImpl.GetVisitReasonAndCategories()).thenReturn(visitReasonAndCategories);

		String expeResponse = commonMasterServiceImpl.getVisitReasonAndCategories();

		assertEquals(expeResponse, commonMasterServiceImpl.getVisitReasonAndCategories());
	}

//******

	@Test
	void testGetMasterDataForNurse_WithNullVisitCategoryID() {
		String result = commonMasterServiceImpl.getMasterDataForNurse(null, null, null);
		assertEquals("Invalid VisitCategoryID", result);
	}

	@Test
	void testGetMasterDataForNurse_WithCase1() {
		when(nurseMasterDataServiceImpl.getCancerScreeningMasterDataForNurse()).thenReturn("Cancer Screening Data");
		String result = commonMasterServiceImpl.getMasterDataForNurse(1, null, null);
		assertEquals("Cancer Screening Data", result);
	}

	@Test
	void testGetMasterDataForNurse_WithCase2() {
		when(ncdScreeningServiceImpl.getNCDScreeningMasterData(anyInt(), anyInt(), anyString()))
				.thenReturn("NCD Screening Data");
		String result = commonMasterServiceImpl.getMasterDataForNurse(2, 1, "M");
		assertEquals("NCD Screening Data", result);
	}

	@Test
	void testGetMasterDataForNurse_WithCase3() {
		when(ancMasterDataServiceImpl.getCommonNurseMasterDataForGenopdAncNcdcarePnc(anyInt(), anyInt(), anyString()))
				.thenReturn("NCD Care Data");
		String result = commonMasterServiceImpl.getMasterDataForNurse(3, 1, "F");
		assertEquals("NCD Care Data", result);
	}

	@Test
	void testGetMasterDataForNurse_WithCase4() {
		when(ancMasterDataServiceImpl.getCommonNurseMasterDataForGenopdAncNcdcarePnc(4, 1, "F"))
				.thenReturn("ANC Master Data");
		String result = commonMasterServiceImpl.getMasterDataForNurse(4, 1, "F");
		assertEquals("ANC Master Data", result);
	}

	@Test
	void testGetMasterDataForNurse_WithCase5() {
		when(ancMasterDataServiceImpl.getCommonNurseMasterDataForGenopdAncNcdcarePnc(5, 2, "M"))
				.thenReturn("PNC Master Data");
		String result = commonMasterServiceImpl.getMasterDataForNurse(5, 2, "M");
		assertEquals("PNC Master Data", result);
	}

	@Test
	void testGetMasterDataForNurse_WithCase6() {
		when(ancMasterDataServiceImpl.getCommonNurseMasterDataForGenopdAncNcdcarePnc(6, 3, "Unknown"))
				.thenReturn("General OPD Master Data");
		String result = commonMasterServiceImpl.getMasterDataForNurse(6, 3, "Unknown");
		assertEquals("General OPD Master Data", result);
	}

	@Test
	void testGetMasterDataForNurse_WithCase7() {
		String result = commonMasterServiceImpl.getMasterDataForNurse(7, 1, "F");
		assertEquals("No Master Data found for QuickConsultation", result);
	}

	@Test
	void testGetMasterDataForNurse_WithCase8() {
		when(ancMasterDataServiceImpl.getCommonNurseMasterDataForGenopdAncNcdcarePnc(8, 1, "F"))
				.thenReturn("Covid 19 Pandemic Master Data");
		String result = commonMasterServiceImpl.getMasterDataForNurse(8, 1, "F");
		assertEquals("Covid 19 Pandemic Master Data", result);
	}

	@Test
	void testGetMasterDataForNurse_WithCase10() {
		when(ancMasterDataServiceImpl.getCommonNurseMasterDataForGenopdAncNcdcarePnc(10, 2, "M"))
				.thenReturn("Covid 19 Pandemic Master Data for 10");
		String result = commonMasterServiceImpl.getMasterDataForNurse(10, 2, "M");
		assertEquals("Covid 19 Pandemic Master Data for 10", result);
	}

	@Test
	void testGetMasterDataForNurse_WithInvalidCase() {
		String result = commonMasterServiceImpl.getMasterDataForNurse(999, 1, "F");
		assertEquals("Invalid VisitCategoryID", result);
	}

//*****

	@Test
	void testGetMasterDataForDoctor_Case1() {
		Integer visitCategoryID = 1;
		Integer providerServiceMapID = 123;
		String gender = "male";
		Integer facilityID = 1;
		Integer vanID = 1;

		String expected = "Cancer Screening Data";
		when(doctorMasterDataServiceImpl.getCancerScreeningMasterDataForDoctor(providerServiceMapID))
				.thenReturn(expected);

		String result = commonMasterServiceImpl.getMasterDataForDoctor(visitCategoryID, providerServiceMapID, gender,
				facilityID, vanID);

		assertEquals(expected, result);
	}

	@Test
	void testGetMasterDataForDoctor_Case2() {
		// Given (Arrange)
		Integer visitCategoryID = 2; // NCD screening
		Integer providerServiceMapID = 1;
		String gender = "male";
		Integer facilityID = 1;
		Integer vanID = 1;
		String expectedMasterData = "Expected NCD Screening Master Data";

		when(ancMasterDataServiceImpl.getCommonDoctorMasterDataForGenopdAncNcdcarePnc(visitCategoryID,
				providerServiceMapID, gender, facilityID, vanID)).thenReturn(expectedMasterData);

		// When (Act)
		String actualMasterData = commonMasterServiceImpl.getMasterDataForDoctor(visitCategoryID, providerServiceMapID,
				gender, facilityID, vanID);

		// Then (Assert)
		assertEquals(expectedMasterData, actualMasterData,
				"The master data should match the expected NCD Screening master data.");
	}

	@Test
	void testGetMasterDataForDoctor_Case3() {
		// Given (Arrange)
		Integer visitCategoryID = 3; // NCD care
		Integer providerServiceMapID = 1;
		String gender = "female";
		Integer facilityID = 1;
		Integer vanID = 1;
		String expectedMasterData = "Expected NCD Care Master Data";

		when(ancMasterDataServiceImpl.getCommonDoctorMasterDataForGenopdAncNcdcarePnc(visitCategoryID,
				providerServiceMapID, gender, facilityID, vanID)).thenReturn(expectedMasterData);

		// When (Act)
		String actualMasterData = commonMasterServiceImpl.getMasterDataForDoctor(visitCategoryID, providerServiceMapID,
				gender, facilityID, vanID);

		// Then (Assert)
		assertEquals(expectedMasterData, actualMasterData,
				"The master data should match the expected NCD Care master data.");
	}

	@Test
	void testGetMasterDataForDoctor_Case4() {
		// Given (Arrange)
		Integer visitCategoryID = 4; // ANC
		Integer providerServiceMapID = 1;
		String gender = "female";
		Integer facilityID = 1;
		Integer vanID = 1;
		String expectedMasterData = "Expected ANC Master Data";

		when(ancMasterDataServiceImpl.getCommonDoctorMasterDataForGenopdAncNcdcarePnc(visitCategoryID,
				providerServiceMapID, gender, facilityID, vanID)).thenReturn(expectedMasterData);

		// When (Act)
		String actualMasterData = commonMasterServiceImpl.getMasterDataForDoctor(visitCategoryID, providerServiceMapID,
				gender, facilityID, vanID);

		// Then (Assert)
		assertEquals(expectedMasterData, actualMasterData,
				"The master data should match the expected ANC master data.");
	}

	@Test
	void testGetMasterDataForDoctor_Case5() {
		// Given (Arrange)
		Integer visitCategoryID = 5; // PNC
		Integer providerServiceMapID = 1;
		String gender = "female";
		Integer facilityID = 1;
		Integer vanID = 1;
		String expectedMasterData = "Expected PNC Master Data";

		when(ancMasterDataServiceImpl.getCommonDoctorMasterDataForGenopdAncNcdcarePnc(visitCategoryID,
				providerServiceMapID, gender, facilityID, vanID)).thenReturn(expectedMasterData);

		// When (Act)
		String actualMasterData = commonMasterServiceImpl.getMasterDataForDoctor(visitCategoryID, providerServiceMapID,
				gender, facilityID, vanID);

		// Then (Assert)
		assertEquals(expectedMasterData, actualMasterData,
				"The master data should match the expected PNC master data.");
	}

	@Test
	void testGetMasterDataForDoctor_Case6() {
		Integer visitCategoryID = 6; // General OPD
		Integer facilityID = 1;
		String gender = "Male";
		int providerServiceMapID = 1;
		Integer vanID = 1;
		String expected = "General OPD Data";

		when(ancMasterDataServiceImpl.getCommonDoctorMasterDataForGenopdAncNcdcarePnc(visitCategoryID,
				providerServiceMapID, gender, facilityID, vanID)).thenReturn(expected);

		String result = commonMasterServiceImpl.getMasterDataForDoctor(visitCategoryID, providerServiceMapID, gender,
				facilityID, vanID);

		assertEquals(expected, result);
	}

	@Test
	void testGetMasterDataForDoctor_Case7() {
		// Given (Arrange)
		Integer visitCategoryID = 7; // General OPD (QC)
		Integer providerServiceMapID = 1;
		String gender = "male";
		Integer facilityID = 1;
		Integer vanID = 1;
		String expectedMasterData = "Expected General OPD (QC) Master Data";

		when(ancMasterDataServiceImpl.getCommonDoctorMasterDataForGenopdAncNcdcarePnc(visitCategoryID,
				providerServiceMapID, gender, facilityID, vanID)).thenReturn(expectedMasterData);

		// When (Act)
		String actualMasterData = commonMasterServiceImpl.getMasterDataForDoctor(visitCategoryID, providerServiceMapID,
				gender, facilityID, vanID);

		// Then (Assert)
		assertEquals(expectedMasterData, actualMasterData,
				"The master data should match the expected General OPD (QC) master data.");
	}

	@Test
	void testGetMasterDataForDoctor_Case8() {
		Integer visitCategoryID = 8; // COVID
		Integer facilityID = 1;
		String gender = "Male";
		int providerServiceMapID = 1;
		Integer vanID = 1;

		String expected = "COVID Data";
		when(ancMasterDataServiceImpl.getCommonDoctorMasterDataForGenopdAncNcdcarePnc(visitCategoryID,
				providerServiceMapID, gender, facilityID, vanID)).thenReturn(expected);

		String result = commonMasterServiceImpl.getMasterDataForDoctor(visitCategoryID, providerServiceMapID, gender,
				facilityID, vanID);

		assertEquals(expected, result);
	}

	@Test
	void testGetMasterDataForDoctor_Case10() {
		// Given (Arrange)
		Integer visitCategoryID = 10; // Placeholder for specific scenario
		Integer providerServiceMapID = 1;
		String gender = "female";
		Integer facilityID = 1;
		Integer vanID = 1;
		String expectedMasterData = "Expected Case 10 Master Data";

		when(ancMasterDataServiceImpl.getCommonDoctorMasterDataForGenopdAncNcdcarePnc(visitCategoryID,
				providerServiceMapID, gender, facilityID, vanID)).thenReturn(expectedMasterData);

		// When (Act)
		String actualMasterData = commonMasterServiceImpl.getMasterDataForDoctor(visitCategoryID, providerServiceMapID, gender,
				facilityID, vanID);

		// Then (Assert)
		assertEquals(expectedMasterData, actualMasterData,
				"The master data should match the expected Case 10 master data.");
	}

	@Test
    void testGetMasterDataForDoctor_WithInvalidVisitCategoryID() {
        // Given (Arrange)
        Integer invalidVisitCategoryID = 999; // Assuming 999 is not a valid visit category ID
        Integer providerServiceMapID = 1;
        String gender = "female";
        Integer facilityID = 1;
        Integer vanID = 1;
        String expectedMessage = "Invalid VisitCategoryID";

        // When (Act)
        String actualMessage = commonMasterServiceImpl.getMasterDataForDoctor(invalidVisitCategoryID, providerServiceMapID, gender, facilityID, vanID);

        // Then (Assert)
        assertEquals(expectedMessage, actualMessage, "The method should return 'Invalid VisitCategoryID' for an invalid visitCategoryID.");
    }

	// *****
	@Test
	void getECGAbnormalities_ReturnsJsonStringOfECGAbnormalities() throws Exception {
		M_ECGabnormalities ecgAbnormality1 = new M_ECGabnormalities();
		ecgAbnormality1.setId(1);
		ecgAbnormality1.setEcgAbnormality("Abnormality A");
		ecgAbnormality1.setDeleted(false);
		
		ecgAbnormality1.toString();

		M_ECGabnormalities ecgAbnormality2 = new M_ECGabnormalities();
		ecgAbnormality2.setId(2);
		ecgAbnormality2.setEcgAbnormality("Abnormality B");
		ecgAbnormality2.setDeleted(false);

		List<M_ECGabnormalities> mockedList = Arrays.asList(ecgAbnormality1, ecgAbnormality2);

		when(m_ECGabnormalitiesRepo.findByDeleted(false)).thenReturn(mockedList);

		String result = commonMasterServiceImpl.getECGAbnormalities();

		String expectedJson = new Gson().toJson(mockedList);
		assertEquals(expectedJson, result);
	}

}
