package com.iemr.mmu.service.dataSyncLayerCentral;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.syncActivity_syncLayer.SyncUploadDataDigester;
import com.iemr.mmu.utils.mapper.InputMapper;

/***
 * 
 * @author NE298657
 *
 */

@Service
public class GetDataFromVanAndSyncToDBImpl implements GetDataFromVanAndSyncToDB {

	@Autowired
	private DataSyncRepositoryCentral dataSyncRepositoryCentral;

	public String syncDataToServer(String requestOBJ, String Authorization) throws Exception {

		// feed sync request
		SyncUploadDataDigester syncUploadDataDigester = InputMapper.gson().fromJson(requestOBJ,
				SyncUploadDataDigester.class);

		List<Map<String, Object>> dataToBesync = syncUploadDataDigester.getSyncData();

		Object[] objArr;

		// sync data 'list of object array'
		List<Object[]> syncDataList = new ArrayList<>();

		for (Map<String, Object> map : dataToBesync) {
			int pointer = 0;
			objArr = new Object[map.size()];
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				if (entry.getValue() != null) {
					if (String.valueOf(entry.getValue()).equalsIgnoreCase("false")
							|| String.valueOf(entry.getValue()).equalsIgnoreCase("true"))
						objArr[pointer] = entry.getValue();
					else
						objArr[pointer] = String.valueOf(entry.getValue());
				} else
					objArr[pointer] = entry.getValue();
				pointer++;
			}
			syncDataList.add(objArr);
		}

		// schema name hard coded
		String query = getQueryToInsertUpdateDataToServerDB("neeraj", syncUploadDataDigester.getTableName(),
				syncUploadDataDigester.getServerColumns());

		// call repository to execute the query with given data list
		int[] i = dataSyncRepositoryCentral.syncDataToCentralDB(query, syncDataList);

		System.out.println("kamariya karela baloop LOLLYPOP lagelu ........");

		// validating if data sync successfully
		if (syncDataList.size() == i.length)
			return "data sync passed";
		else
			return null;

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
