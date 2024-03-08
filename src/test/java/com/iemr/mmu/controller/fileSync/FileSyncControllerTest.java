package com.iemr.mmu.controller.fileSync;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.mmu.service.fileSync.FileSyncService;
import com.iemr.mmu.utils.exception.IEMRException;
import com.iemr.mmu.utils.response.OutputResponse;

@ExtendWith(MockitoExtension.class)
class FileSyncControllerTest {
	@Mock
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Mock
	FileSyncService fileSyncService;

	@InjectMocks
	FileSyncController fileSyncController;

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
