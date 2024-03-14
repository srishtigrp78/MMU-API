package com.iemr.mmu.service.dataSyncLayerCentral;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iemr.mmu.data.syncActivity_syncLayer.SyncUploadDataDigester;

@ExtendWith(MockitoExtension.class)
class GetDataFromVanAndSyncToDBImplTest {

	@Mock
	private SyncUploadDataDigester syncUploadDataDigester;

	@Mock
	private DataSyncRepositoryCentral dataSyncRepositoryCentral;

	@InjectMocks
	private GetDataFromVanAndSyncToDBImpl getDataFromVanAndSyncToDBImpl;

	@Mock
	private ObjectMapper objectMapper;

	@Test
	void testSyncDataToServerUpdate(){
	}

	@Test
	void testUpdate_M_BeneficiaryRegIdMapping_for_provisioned_benID() {
		// Setup
		List<Map<String, Object>> mockDataList = new ArrayList<>();
		Map<String, Object> data = new HashMap<>();
		data.put("BenRegId", "123");
		data.put("BeneficiaryID", "456");
		data.put("VanID", "789");
		mockDataList.add(data);

		when(syncUploadDataDigester.getSyncData()).thenReturn(mockDataList);
		when(syncUploadDataDigester.getSchemaName()).thenReturn("schemaName");
		when(syncUploadDataDigester.getTableName()).thenReturn("tableName");
		when(syncUploadDataDigester.getSyncedBy()).thenReturn("syncedByUser");
		when(dataSyncRepositoryCentral.syncDataToCentralDB(anyString(), anyString(), any(), anyString(), anyList()))
				.thenReturn(new int[] { 1 });

		// Act
		String result = getDataFromVanAndSyncToDBImpl
				.update_M_BeneficiaryRegIdMapping_for_provisioned_benID(syncUploadDataDigester);

		// Assert
		assertEquals("data sync passed", result);
		verify(dataSyncRepositoryCentral, times(1)).syncDataToCentralDB(anyString(), anyString(), any(), anyString(),
				anyList());
	}

//	@Test
//	void testGetQueryToInsertDataToServerDB() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetQueryToInsertDataToServerDBWithColumns() {
		String schemaName = "mySchema";
		String tableName = "myTable";
		String serverColumns = "id,name,age";
		String expectedResult = "INSERT INTO mySchema.myTable(id,name,age) VALUES ( ?,  ?,  ? ) ";

		String actualResult = getDataFromVanAndSyncToDBImpl.getQueryToInsertDataToServerDB(schemaName, tableName,
				serverColumns);

		assertEquals(expectedResult, actualResult);
	}

	@Test
	void testGetQueryToInsertDataToServerDBWithNoColumns() {
		String schemaName = "mySchema";
		String tableName = "myTable";
		String serverColumns = "";
		String expectedResult = "INSERT INTO mySchema.myTable() VALUES ( ? ) ";

		String actualResult = getDataFromVanAndSyncToDBImpl.getQueryToInsertDataToServerDB(schemaName, tableName,
				serverColumns);

		assertEquals(expectedResult, actualResult);
	}

	@Test
	void testGetQueryToInsertDataToServerDBWithNullColumns() {
		String schemaName = "mySchema";
		String tableName = "myTable";
		String serverColumns = null;
		// Since the method doesn't handle null explicitly, it's expected to treat it as
		// an empty string.
		String expectedResult = "INSERT INTO mySchema.myTable(null) VALUES () ";

		String actualResult = getDataFromVanAndSyncToDBImpl.getQueryToInsertDataToServerDB(schemaName, tableName,
				serverColumns);

		assertEquals(expectedResult, actualResult);
	}
//
//	@Test
//	void testGetQueryToUpdateDataToServerDB() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetQueryToUpdateDataToServerDB() {

		String schemaName = "testSchema";
		String tableName = "t_patientissue"; // Test with a table that has specific WHERE clause conditions
		String serverColumns = "column1,column2,column3";

		String expectedQuery = " UPDATE  testSchema.t_patientissue SET column1= ?, column2= ?, column3= ? WHERE  VanSerialNo =?  AND  SyncFacilityID = ? ";

		// Act
		String actualQuery = getDataFromVanAndSyncToDBImpl.getQueryToUpdateDataToServerDB(schemaName, serverColumns,
				tableName);

		// Assert
		assertEquals(expectedQuery, actualQuery, "The generated query does not match the expected output.");

		// Test with a table that falls into the default case
		tableName = "someOtherTable";
		expectedQuery = " UPDATE  testSchema.someOtherTable SET column1= ?, column2= ?, column3= ? WHERE  VanSerialNo =?  AND  VanID = ? ";

		// Act
		actualQuery = getDataFromVanAndSyncToDBImpl.getQueryToUpdateDataToServerDB(schemaName, serverColumns,
				tableName);

		// Assert
		assertEquals(expectedQuery, actualQuery,
				"The generated query for a default table does not match the expected output.");
	}

}
