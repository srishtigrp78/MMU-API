package com.iemr.mmu.controller.common.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.mmu.data.common.DocFileManager;
import com.iemr.mmu.service.common.transaction.CommonServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class InsertCommonControllerTest {

	@InjectMocks
	InsertCommonController insertCommonController;
	@Mock
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Mock
	private CommonServiceImpl commonServiceImpl;
	
	private String exampleRequestJson = "[{\"documentId\":\"123\", \"content\":\"Sample Content\"}]";
	
	@Test
    void testSaveFilesSuccess() throws Exception {
        when(commonServiceImpl.saveFiles(anyList())).thenReturn("Success");

        String result = insertCommonController.saveFiles(exampleRequestJson);

        assertNotNull(result);
        assertTrue(result.contains("Success"));

        verify(commonServiceImpl, times(1)).saveFiles(anyList());
    }
	
	@Test
    void testSaveFilesException() throws Exception {
        when(commonServiceImpl.saveFiles(anyList())).thenThrow(new RuntimeException("Test Exception"));

        String result = insertCommonController.saveFiles(exampleRequestJson);

        assertNotNull(result);
        assertTrue(result.contains("Error while saving files"));

        verify(commonServiceImpl, times(1)).saveFiles(anyList());
    }

}
