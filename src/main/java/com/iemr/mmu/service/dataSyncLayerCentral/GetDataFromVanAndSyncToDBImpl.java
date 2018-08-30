package com.iemr.mmu.service.dataSyncLayerCentral;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class GetDataFromVanAndSyncToDBImpl implements GetDataFromVanAndSyncToDB {
	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	private String syncDataToServer(String schemaName, String tableName, String serverColumns,
			List<Map<String, Object>> dataToBesync) {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();

		List<Object[]> syncDataList = new ArrayList<>();

		// Map<String, Object> dataMap = new HashMap<>();
		// dataMap.put("schemaName", schemaName);
		// dataMap.put("tableName", tableName);
		// dataMap.put("serverColumns", serverColumns);
		// dataMap.put("syncData", dataToBesync);

		Object[] objArr;
		StringBuilder vanSerialNos = new StringBuilder();

		int pointer1 = 0;

		for (Map<String, Object> map : dataToBesync) {
			int pointer = 0;
			objArr = new Object[map.size()];
			if (pointer1 == dataToBesync.size() - 1)
				vanSerialNos.append(map.get("BenVisitID"));
			else
				vanSerialNos.append(map.get("BenVisitID") + ",");
			// vanSerialNoArr[pointer1] = map.get("BenVisitID");

			for (Map.Entry<String, Object> entry : map.entrySet()) {
				objArr[pointer] = entry.getValue();
				pointer++;
			}
			syncDataList.add(objArr);
			pointer1++;
		}

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String query = getQueryToInsertUpdateDataToServerDB(SCHEMA_TESTING, tableName, serverColumns);
		int[] i = jdbcTemplate.batchUpdate(query, syncDataList);

		// after sync completed then update processed flag in van DB
		if (i.length == syncDataList.size()) {
			dataSyncRepository.updateProcessedFlagInVan(SCHEMA_IEMR, tableName, vanSerialNos, "BenVisitID");
		}

		System.out.println("kamariya karela baloop LOLLYPOP lagelu ........");
		// return gson.toJson(dataMap);
		return "Data successfully sync";
	}

	public String getQueryToInsertUpdateDataToServerDB(String schemaName, String tableName, String serverColumns) {
		String[] columnsArr = null;
		if (serverColumns != null)
			columnsArr = serverColumns.split(",");

		StringBuilder preparedStatementSetter = new StringBuilder();
		StringBuilder updateStatement = new StringBuilder();

		if (columnsArr != null && columnsArr.length > 0) {
			int index = 0;
			for (String column : columnsArr) {
				if (index == columnsArr.length - 1) {
					preparedStatementSetter.append(" ? ");
					updateStatement.append(column + "=VALUES(" + column + ")");
				} else {
					preparedStatementSetter.append(" ?, ");
					updateStatement.append(column + "=VALUES(" + column + "),");
				}
				index++;
			}
		}

		String query = " INSERT INTO " + schemaName + "." + tableName + "( " + serverColumns + ") VALUES ( "
				+ preparedStatementSetter + " ) ON DUPLICATE KEY UPDATE " + updateStatement;

		return query;
	}

}
