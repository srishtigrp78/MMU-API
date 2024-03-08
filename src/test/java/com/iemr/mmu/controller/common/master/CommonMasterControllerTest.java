package com.iemr.mmu.controller.common.master;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.mmu.service.common.master.CommonMasterServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;
@ExtendWith(MockitoExtension.class)
class CommonMasterControllerTest {
	
	@Mock
	private Logger logger = LoggerFactory.getLogger(CommonMasterController.class);
	@Mock
	private CommonMasterServiceImpl commonMasterServiceImpl;
	@InjectMocks
	CommonMasterController commonMasterController;

	@Test
    void testGetVisitReasonAndCategories() {
        OutputResponse mockResponse = new OutputResponse();
        mockResponse.setResponse("Mocked response data");
        when(commonMasterServiceImpl.getVisitReasonAndCategories()).thenReturn("Mocked response data");

        String result = commonMasterController.getVisitReasonAndCategories();

        assertEquals(mockResponse.toString(), result);
        verify(commonMasterServiceImpl).getVisitReasonAndCategories();
        logger.info("Test passed: testGetVisitReasonAndCategories");
    }

	@Test
	void testNurseMasterData() {
        Integer visitCategoryID = 1;
        Integer providerServiceMapID = 2;
        String gender = "Female";
        OutputResponse mockResponse = new OutputResponse();
        mockResponse.setResponse("Mocked Nurse master data");
        when(commonMasterServiceImpl.getMasterDataForNurse(visitCategoryID, providerServiceMapID, gender)).thenReturn("Mocked Nurse master data");

        String result = commonMasterController.nurseMasterData(visitCategoryID, providerServiceMapID, gender);

        assertEquals(mockResponse.toString(), result);
        verify(commonMasterServiceImpl).getMasterDataForNurse(visitCategoryID, providerServiceMapID, gender);
    }
	
	@Test
    void testDoctorMasterData() {
        Integer visitCategoryID = 1;
        Integer providerServiceMapID = 2;
        String gender = "M";
        Integer facilityID = 3;
        Integer vanID = 4;

        OutputResponse mockResponse = new OutputResponse();
        mockResponse.setResponse("Mocked doctor master data");
        
        when(commonMasterServiceImpl.getMasterDataForDoctor(visitCategoryID, providerServiceMapID, gender, facilityID, vanID))
                .thenReturn("Mocked doctor master data");

        String result = commonMasterController.doctorMasterData(visitCategoryID, providerServiceMapID, gender, facilityID, vanID);

        assertEquals(mockResponse.toString(), result);
        verify(commonMasterServiceImpl).getMasterDataForDoctor(visitCategoryID, providerServiceMapID, gender, facilityID, vanID);
    }

	

	@Test
	void testGetECGAbnormalities() throws Exception {
        String expectedResponseData = "Mocked ECG abnormalities data";
        when(commonMasterServiceImpl.getECGAbnormalities()).thenReturn(expectedResponseData);
        
        OutputResponse expectedResponse = new OutputResponse();
        expectedResponse.setResponse(expectedResponseData);

        String actualResponse = commonMasterController.getECGAbnormalities();

        assertEquals(expectedResponse.toString(), actualResponse);
        verify(commonMasterServiceImpl).getECGAbnormalities();
    }

    @Test
    void testGetECGAbnormalities_WithException() throws Exception {
        String errorMessage = "Database connection error";
        doThrow(new RuntimeException(errorMessage)).when(commonMasterServiceImpl).getECGAbnormalities();
        
        OutputResponse expectedResponse = new OutputResponse();
        expectedResponse.setError(5000, errorMessage);

        String actualResponse = commonMasterController.getECGAbnormalities();

        assertEquals(expectedResponse.toString(), actualResponse);
        verify(commonMasterServiceImpl).getECGAbnormalities();
    }
} 