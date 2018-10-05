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
		List<Object[]> syncDataListInsert = new ArrayList<>();
		List<Object[]> syncDataListUpdate = new ArrayList<>();

		for (Map<String, Object> map : dataToBesync) {
			int pointer = 0;

			String vanSerialNo = String.valueOf(map.get(syncUploadDataDigester.getVanAutoIncColumnName()));
			String vanID = String.valueOf(map.get("VanID"));

			int recordCheck = dataSyncRepositoryCentral.checkRecordIsAlreadyPresentOrNot("db_iemr_sync",
					syncUploadDataDigester.getTableName(), vanSerialNo, vanID);

			if (recordCheck == 0) {
				objArr = new Object[map.size()];
			} else {
				objArr = new Object[map.size() + 2];
			}

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

			if (recordCheck == 0) {
				syncDataListInsert.add(objArr);
			} else {
				objArr[pointer] = String.valueOf(map.get(syncUploadDataDigester.getVanAutoIncColumnName()));
				objArr[pointer + 1] = String.valueOf(map.get("VanID"));
				syncDataListUpdate.add(objArr);
			}

		}

		int[] i = null;
		if (syncDataListInsert != null && syncDataListInsert.size() > 0) {
			// schema name hard coded(Insert query builder)
			String queryInsert = getQueryToInsertDataToServerDB("db_iemr_sync", syncUploadDataDigester.getTableName(),
					syncUploadDataDigester.getServerColumns());

			// call repository to execute the query with given data list(Insert)
			i = dataSyncRepositoryCentral.syncDataToCentralDB(queryInsert, syncDataListInsert);
		}

		int[] j = null;
		if (syncDataListUpdate != null && syncDataListUpdate.size() > 0) {
			// schema name hard coded(Update query builder)
			String queryUpdate = getQueryToUpdateDataToServerDB("db_iemr_sync", syncUploadDataDigester.getTableName(),
					syncUploadDataDigester.getServerColumns());

			// call repository to execute the query with given data list(Update)
			j = dataSyncRepositoryCentral.syncDataToCentralDB(queryUpdate, syncDataListUpdate);
		}

		System.out.println("kamariya karela baloop LOLLYPOP lagelu ........");

		// validating if data sync successfully
		if ((i != null && syncDataListInsert.size() != i.length)
				|| (j != null && syncDataListUpdate.size() != j.length))
			return null;
		else
			return "data sync passed";

	}

	public String getQueryToInsertDataToServerDB(String schemaName, String tableName, String serverColumns) {
		String[] columnsArr = null;
		if (serverColumns != null)
			columnsArr = serverColumns.split(",");

		StringBuilder preparedStatementSetter = new StringBuilder();
		/// StringBuilder updateStatement = new StringBuilder();

		if (columnsArr != null && columnsArr.length > 0) {
			int index = 0;
			for (String column : columnsArr) {
				if (index == columnsArr.length - 1) {
					preparedStatementSetter.append(" ? ");
					/// updateStatement.append(column + "=VALUES(" + column + ")");
				} else {
					preparedStatementSetter.append(" ?, ");
					/// updateStatement.append(column + "=VALUES(" + column + "),");
				}
				index++;
			}
		}

		String query = " INSERT INTO " + schemaName + "." + tableName + "( " + serverColumns + ") VALUES ( "
				+ preparedStatementSetter + " ) ";

		return query;
	}

	public String getQueryToUpdateDataToServerDB(String schemaName, String tableName, String serverColumns) {
		String[] columnsArr = null;
		if (serverColumns != null)
			columnsArr = serverColumns.split(",");

		StringBuilder preparedStatementSetter = new StringBuilder();

		if (columnsArr != null && columnsArr.length > 0) {
			int index = 0;
			for (String column : columnsArr) {
				if (index == columnsArr.length - 1) {
					preparedStatementSetter.append(column + "= ?");
				} else {
					preparedStatementSetter.append(column + "= ?, ");
				}
				index++;
			}
		}

		String query = " UPDATE  " + schemaName + "." + tableName + " SET " + preparedStatementSetter
				+ " WHERE VanSerialNo = ? AND VanID = ? ";

		return query;
	}

}
