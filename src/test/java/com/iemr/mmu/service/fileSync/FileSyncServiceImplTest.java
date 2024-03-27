package com.iemr.mmu.service.fileSync;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.NotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.test.util.ReflectionTestUtils;

import com.google.gson.Gson;
import com.iemr.mmu.utils.http.HttpUtils;

@ExtendWith(MockitoExtension.class)
class FileSyncServiceImplTest {

	@InjectMocks
	private FileSyncServiceImpl fileSyncService;

	@Mock
	private HttpUtils httpUtils;

	@Mock
	private Logger logger;

	@Mock
	private Process process;

	@Mock
	private Runtime runtime;

	@Test
	void testGetServerCredential() {
		// Arrange
		String expectedServerIP = "192.168.1.1";
		String expectedServerDomain = "example.com";
		String expectedServerUserName = "user";
		String expectedServerPassword = "password";

		Map<String, String> expectedMap = new HashMap<>();
		expectedMap.put("serverIP", expectedServerIP);
		expectedMap.put("serverDomain", expectedServerDomain);
		expectedMap.put("serverUserName", expectedServerUserName);
		expectedMap.put("serverPassword", expectedServerPassword);

		String expectedJsonResult = new Gson().toJson(expectedMap);

		// Set the private fields using ReflectionTestUtils
		ReflectionTestUtils.setField(fileSyncService, "serverIP", expectedServerIP);
		ReflectionTestUtils.setField(fileSyncService, "serverDomain", expectedServerDomain);
		ReflectionTestUtils.setField(fileSyncService, "serverUserName", expectedServerUserName);
		ReflectionTestUtils.setField(fileSyncService, "serverPassword", expectedServerPassword);

		// Act
		String actualJsonResult = fileSyncService.getServerCredential();

		// Assert
		assertEquals(expectedJsonResult, actualJsonResult);
	}

//	@Test
//	void testSyncFilesSuccess() throws Exception {
//		// Setup mock behavior
//		when(httpUtils.get(anyString(),any(HashMap.class))).thenReturn(
//				"{\"statusCode\":200, \"data\":\"{\\\"serverIP\\\":\\\"127.0.0.1\\\",\\\"serverDomain\\\":\\\"local\\\",\\\"serverUserName\\\":\\\"user\\\",\\\"serverPassword\\\":\\\"pass\\\"}\"}");
//
//		// Execute the method
//		String result = fileSyncService.syncFiles("Bearer some-token");
//
//		// Verify result
//		assertEquals("File Sync activity Completed", result);
//
//		// Verify interactions
//		verify(httpUtils).get(anyString(),any(HashMap.class));
//	}

//	@Test
//	void testSyncFilesFailure()  {
//		// Assume your service behaves differently on a specific error condition
//		when(httpUtils.get(anyString())).thenThrow( IllegalArgumentException.class);
//
//		// Handling the exception in the test
//		Exception exception = assertThrows(IllegalArgumentException.class, () -> fileSyncService.syncFiles("Bearer some-token"));
//
//		System.out.println(exception);
//		
//		// Verify the exception message
//		assertTrue(exception.getMessage().contains(" "));
//
//	}

}
