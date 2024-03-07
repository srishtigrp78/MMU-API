package com.iemr.mmu.controller.fileSync;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.google.common.net.MediaType;
import com.iemr.mmu.service.fileSync.FileSyncService;
import com.iemr.mmu.utils.exception.IEMRException;
import com.iemr.mmu.utils.response.OutputResponse;

import javassist.NotFoundException;

@ExtendWith(MockitoExtension.class)
class FileSyncControllerTest {
	@Mock
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Mock
	FileSyncService fileSyncService;

	@InjectMocks
	FileSyncController fileSyncController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetServerCredential() {
		OutputResponse response = new OutputResponse();

		String data = "Test";

		when(fileSyncService.getServerCredential()).thenReturn(data);

		String expResponse = fileSyncController.getServerCredential();

		response.setResponse(data);

		assertEquals(expResponse, fileSyncController.getServerCredential());
		assertTrue(response.toString().contains(data));
	}

	@Test
	void getServerCredential_ExceptionThrown() {
		when(fileSyncService.getServerCredential()).thenThrow(new RuntimeException("Test exception"));

		String result = fileSyncController.getServerCredential();

		assertTrue(result.contains("Test exception"));
	}

	@Test
	void testSyncFiles() throws IEMRException, IOException {
		OutputResponse response = new OutputResponse();

		String ServerAuthorization = "Test";
		String data = "Test";

		when(fileSyncService.syncFiles(ServerAuthorization)).thenReturn(data);

		String expResponse = fileSyncController.syncFiles(ServerAuthorization);

		response.setResponse(data);

		assertEquals(expResponse, fileSyncController.syncFiles(ServerAuthorization));
		assertTrue(response.toString().contains(data));
	}

	@Test
	void syncFiles_ExceptionThrown() {
		when(fileSyncController.syncFiles("dummyAuth")).thenThrow(new RuntimeException("Test exception"));

		String result = fileSyncController.syncFiles("dummyAuth");

		assertTrue(result.contains("Test exception"));
	}

}
