package com.iemr.mmu.service.dataSyncActivity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.iemr.mmu.data.syncActivity_syncLayer.Indent;
import com.iemr.mmu.repo.login.MasterVanRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.IndentIssueRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.IndentOrderRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.IndentRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.ItemStockEntryRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.StockTransferRepo;

@ExtendWith(MockitoExtension.class)
class DownloadDataFromServerTransactionalImplTest2 {

	@Mock
	private MasterVanRepo masterVanRepo;
	@Mock
	private IndentRepo indentRepo;
	@Mock
	private IndentOrderRepo indentOrderRepo;
	@Mock
	private IndentIssueRepo indentIssueRepo;
	@Mock
	private StockTransferRepo stockTransferRepo;
	@Mock
	private ItemStockEntryRepo itemStockEntryRepo;
	@Mock
	private RestTemplate restTemplate;
	@InjectMocks
	DownloadDataFromServerTransactionalImpl downloadDataFromServerTransactional;

	
	@Test
	void testDownloadTransactionalDataWithException() {
		// Arrange
		int vanID = 1;
		String serverAuthorization = "Bearer token";
		when(masterVanRepo.getFacilityID(vanID)).thenReturn(null); // Simulate missing facility mapping

		// Act & Assert
		Exception exception = assertThrows(Exception.class, () -> {
			downloadDataFromServerTransactional.downloadTransactionalData(vanID, serverAuthorization);
		});

		// Assert
		assertTrue(exception.getMessage().contains("Facility mapping for this van is either missing/wrong"));
	}

}