package com.iemr.mmu.service.dataSyncLayerCentral;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iemr.mmu.data.syncActivity_syncLayer.Indent;
import com.iemr.mmu.data.syncActivity_syncLayer.IndentOrder;
import com.iemr.mmu.data.syncActivity_syncLayer.SyncUploadDataDigester;
import com.iemr.mmu.repo.syncActivity_syncLayer.IndentIssueRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.IndentOrderRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.IndentRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.ItemStockEntryRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.StockTransferRepo;

@ExtendWith(MockitoExtension.class)
class FetchDownloadDataImplTest {
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
	private DataSyncRepositoryCentral dataSyncRepositoryCentral;
	@InjectMocks
	FetchDownloadDataImpl fetchDownloadData;

	@Test
	void testGetDownloadDataForIndent() throws Exception {
		MockitoAnnotations.openMocks(this); // Initialize mocks
		SyncUploadDataDigester digester = new SyncUploadDataDigester();
		digester.setSchemaName("some_schema");
		digester.setTableName("t_indent");
		digester.setFacilityID(123);

		List<Indent> indents = new ArrayList<>();
		// Assume Indent is a proper entity. Populate the list as per your requirements.
		when(indentRepo.findByFromFacilityIDAndProcessedNotAndSyncFacilityIDNotNullAndVanSerialNoNotNull(123, "P"))
				.thenReturn((ArrayList<Indent>) indents);

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();

		String result = fetchDownloadData.getDownloadData(digester);
		assertEquals(gson.toJson(indents), result);
	}

	@Test
	void testGetDownloadDataWithInvalidRequest() {
		MockitoAnnotations.openMocks(this); // Initialize mocks
		SyncUploadDataDigester digester = new SyncUploadDataDigester();
		Exception exception = assertThrows(Exception.class, () -> {
			fetchDownloadData.getDownloadData(digester);
		});
		assertEquals("invalid download request. Either table or facility info is missing/wrong",
				exception.getMessage());
	}

	@Test
	void testGetDownloadDataForUnknownTable() {
		MockitoAnnotations.openMocks(this); // Initialize mocks
		SyncUploadDataDigester digester = new SyncUploadDataDigester();
		digester.setSchemaName("some_schema");
		digester.setTableName("unknown_table");
		digester.setFacilityID(123);

		Exception exception = assertThrows(Exception.class, () -> {
			fetchDownloadData.getDownloadData(digester);
		});
		assertEquals("invalid download request. Table info is missing/wrong", exception.getMessage());
	}

	private final Gson gson = new GsonBuilder().serializeNulls().create();

//	@Test
//	void testGetDownloadDataForIndentOrder() throws Exception {
//		IndentOrderRepo mockIndentOrderRepo = mock(IndentOrderRepo.class);
//		FetchDownloadDataImpl fetchDownloadData = new FetchDownloadDataImpl();
//		fetchDownloadData.indentOrderRepo = mockIndentOrderRepo;
//
//		SyncUploadDataDigester digester = new SyncUploadDataDigester();
//		digester.setSchemaName("some_schema");
//		digester.setTableName("t_indentorder");
//		digester.setFacilityID(123);
//
//		List<IndentOrder> indentOrders = new ArrayList<>();
//		when(mockIndentOrderRepo.findByFromFacilityIDAndProcessedNotAndSyncFacilityIDNotNullAndVanSerialNoNotNull(123,
//				"P")).thenReturn(indentOrders);
//
//		String result = fetchDownloadData.getDownloadData(digester);
//		assertEquals(gson.toJson(indentOrders), result);
//	}

//	@Test
//	void testGetDownloadData() {
//		SyncUploadDataDigester syncUploadDataDigester = new SyncUploadDataDigester();
//		
//		syncUploadDataDigester.setTableName("SampleTable");
//		syncUploadDataDigester.setVanAutoIncColumnName("ID");
//		syncUploadDataDigester.setServerColumns("Column1, Column2, Column3");
//		syncUploadDataDigester.setSyncedBy("User1");
//		syncUploadDataDigester.setFacilityID(123);
//		
//		//syncUploadDataDigester.toString();
//
//		List<Map<String, Object>> syncDataList = new ArrayList<>();
//		Map<String, Object> dataRow1 = new HashMap<>();
//		dataRow1.put("Column1", "Value1");
//		dataRow1.put("Column2", 100);
//		dataRow1.put("Column3", true);
//
//		Map<String, Object> dataRow2 = new HashMap<>();
//		dataRow2.put("Column1", "Value2");
//		dataRow2.put("Column2", 200);
//		dataRow2.put("Column3", false);
//
//		syncDataList.add(dataRow1);
//		syncDataList.add(dataRow2);
//		
//		//syncDataList.toString();
//		
//		syncUploadDataDigester.setSyncData(syncDataList);
//
//		List<Long> ids = Arrays.asList(1L, 2L, 3L);
//		syncUploadDataDigester.setIds(ids);
//
//	}

	@Test
	void testUpdateProcessedFlagPostSuccessfullDownload() {
		fail("Not yet implemented");
	}

}
