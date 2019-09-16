package com.iemr.mmu.service.dataSyncLayerCentral;

import java.time.LocalDateTime;
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

		String syncTableName = syncUploadDataDigester.getTableName();

		if (syncUploadDataDigester != null && syncTableName != null
				&& syncTableName.equalsIgnoreCase("m_beneficiaryregidmapping")) {
			String s = update_M_BeneficiaryRegIdMapping_for_provisioned_benID(syncUploadDataDigester);
			return s;
		} else {

			List<Map<String, Object>> dataToBesync = syncUploadDataDigester.getSyncData();

			Object[] objArr;

			// sync data 'list of object array'
			List<Object[]> syncDataListInsert = new ArrayList<>();
			List<Object[]> syncDataListUpdate = new ArrayList<>();

			int pointer;
			String vanSerialNo;
			String vanID;
			int recordCheck;
			int syncFacilityID = 0;

			for (Map<String, Object> map : dataToBesync) {
				pointer = 0;
				recordCheck = 0;
				vanSerialNo = "";
				vanID = "";

				vanSerialNo = String.valueOf(map.get(syncUploadDataDigester.getVanAutoIncColumnName()));
				vanID = String.valueOf(map.get("VanID"));

				map.replace("SyncedBy", syncUploadDataDigester.getSyncedBy());
				map.replace("SyncedDate", String.valueOf(LocalDateTime.now()));

				// if same facilityID change processed flag to "P" else don't alter
				if (syncUploadDataDigester.getFacilityID() != null) {
					switch (syncTableName) {
					case "t_indent": {
						if (map.containsKey("FromFacilityID") && map.get("FromFacilityID") != null
								&& Integer.parseInt(map.get("FromFacilityID").toString()) == syncUploadDataDigester
										.getFacilityID())
							map.replace("Processed", "P");
					}
					case "t_indentorder": {
						if (map.containsKey("FromFacilityID") && map.get("FromFacilityID") != null
								&& Integer.parseInt(map.get("FromFacilityID").toString()) == syncUploadDataDigester
										.getFacilityID())
							map.replace("Processed", "P");
					}
					case "t_indentissue": {
						if (map.containsKey("ToFacilityID") && map.get("ToFacilityID") != null && Integer
								.parseInt(map.get("ToFacilityID").toString()) == syncUploadDataDigester.getFacilityID())
							map.replace("Processed", "P");
					}
					// here a change in rule, will compare with toFacilityID
					case "t_stocktransfer": {
						if (map.containsKey("TransferToFacilityID") && map.get("TransferToFacilityID") != null
								&& Integer.parseInt(map.get("TransferToFacilityID")
										.toString()) == syncUploadDataDigester.getFacilityID())
							map.replace("Processed", "P");
					}
					case "t_itemstockentry": {
						if (map.containsKey("FacilityID") && map.get("FacilityID") != null && Integer
								.parseInt(map.get("FacilityID").toString()) == syncUploadDataDigester.getFacilityID())
							map.replace("Processed", "P");
					}
					default:

					}

				}

				if (map.containsKey("SyncFacilityID"))
					syncFacilityID = (int) map.get("SyncFacilityID");

				recordCheck = dataSyncRepositoryCentral.checkRecordIsAlreadyPresentOrNot(
						syncUploadDataDigester.getSchemaName(), syncUploadDataDigester.getTableName(), vanSerialNo,
						vanID, syncUploadDataDigester.getVanAutoIncColumnName(), syncFacilityID);

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
					/** commented because already we have two variable with same value **/

					// objArr[pointer] =
					// String.valueOf(map.get(syncUploadDataDigester.getVanAutoIncColumnName()));
					// objArr[pointer + 1] = String.valueOf(map.get("VanID"));

					objArr[pointer] = String.valueOf(vanSerialNo);

					if ((syncTableName.equalsIgnoreCase("t_patientissue")
							|| syncTableName.equalsIgnoreCase("t_physicalstockentry")
							|| syncTableName.equalsIgnoreCase("t_stockadjustment")
							|| syncTableName.equalsIgnoreCase("t_saitemmapping")
							|| syncTableName.equalsIgnoreCase("t_stocktransfer")
							|| syncTableName.equalsIgnoreCase("t_patientreturn")
							|| syncTableName.equalsIgnoreCase("t_facilityconsumption")
							|| syncTableName.equalsIgnoreCase("t_indent")
							|| syncTableName.equalsIgnoreCase("t_indentorder")
							|| syncTableName.equalsIgnoreCase("t_indentissue")
							|| syncTableName.equalsIgnoreCase("t_itemstockentry")
							|| syncTableName.equalsIgnoreCase("t_itemstockexit"))
							&& map.containsKey("SyncFacilityID")) {

						objArr[pointer + 1] = String.valueOf(map.get("SyncFacilityID"));
					} else
						objArr[pointer + 1] = String.valueOf(vanID);

					syncDataListUpdate.add(objArr);
				}
				// System.out.println("hello......");
			}

			int[] i = null;
			if (syncDataListInsert != null && syncDataListInsert.size() > 0) {
				// schema name hard coded(Insert query builder)
				String queryInsert = getQueryToInsertDataToServerDB(syncUploadDataDigester.getSchemaName(),
						syncUploadDataDigester.getTableName(), syncUploadDataDigester.getServerColumns());

				// call repository to execute the query with given data list(Insert)
				i = dataSyncRepositoryCentral.syncDataToCentralDB(queryInsert, syncDataListInsert);
			}

			int[] j = null;
			if (syncDataListUpdate != null && syncDataListUpdate.size() > 0) {
				// schema name hard coded(Update query builder)
				String queryUpdate = getQueryToUpdateDataToServerDB(syncUploadDataDigester.getSchemaName(),
						syncUploadDataDigester.getTableName(), syncUploadDataDigester.getServerColumns());

				// call repository to execute the query with given data list(Update)
				j = dataSyncRepositoryCentral.syncDataToCentralDB(queryUpdate, syncDataListUpdate);
			}

			// validating if data sync successfully
			if ((i != null && syncDataListInsert.size() != i.length)
					|| (j != null && syncDataListUpdate.size() != j.length))
				return null;
			else
				return "data sync passed";

		}

	}

	public String update_M_BeneficiaryRegIdMapping_for_provisioned_benID(
			SyncUploadDataDigester syncUploadDataDigester) {
		String returnOBJ = null;
		List<Map<String, Object>> dataToBesync = syncUploadDataDigester.getSyncData();

		Object[] objArr;
		// sync data 'list of object array'
		List<Object[]> syncData = new ArrayList<>();

		String query = getqueryFor_M_BeneficiaryRegIdMapping(syncUploadDataDigester.getSchemaName(),
				syncUploadDataDigester.getTableName());

		for (Map<String, Object> map : dataToBesync) {
			if (map.get("BenRegId") != null && map.get("BeneficiaryID") != null && map.get("VanID") != null) {
				objArr = new Object[4];
				objArr[0] = String.valueOf(syncUploadDataDigester.getSyncedBy());
				objArr[1] = String.valueOf(map.get("BenRegId"));
				objArr[2] = String.valueOf(map.get("BeneficiaryID"));
				objArr[3] = String.valueOf(map.get("VanID"));

				syncData.add(objArr);
			}
		}
		int[] i = null;

		if (syncData != null && syncData.size() > 0) {
			i = dataSyncRepositoryCentral.syncDataToCentralDB(query, syncData);

			if (i.length == syncData.size()) {
				returnOBJ = "data sync passed";
			}
		} else {
			returnOBJ = "data sync passed";
		}

		return returnOBJ;

	}

	private String getqueryFor_M_BeneficiaryRegIdMapping(String schemaName, String tableName) {
		String query = " UPDATE  " + schemaName + "." + tableName
				+ " SET Provisioned = true, SyncedDate = now(), syncedBy = ? "
				+ " WHERE BenRegId = ? AND BeneficiaryID = ? AND VanID = ? ";
		return query;
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
		String query;
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

		if (tableName.equalsIgnoreCase("t_patientissue") || tableName.equalsIgnoreCase("t_physicalstockentry")
				|| tableName.equalsIgnoreCase("t_stockadjustment") || tableName.equalsIgnoreCase("t_saitemmapping")
				|| tableName.equalsIgnoreCase("t_stocktransfer") || tableName.equalsIgnoreCase("t_patientreturn")
				|| tableName.equalsIgnoreCase("t_facilityconsumption") || tableName.equalsIgnoreCase("t_indent")
				|| tableName.equalsIgnoreCase("t_indentorder") || tableName.equalsIgnoreCase("t_indentissue")
				|| tableName.equalsIgnoreCase("t_itemstockentry") || tableName.equalsIgnoreCase("t_itemstockexit")) {

			query = " UPDATE  " + schemaName + "." + tableName + " SET " + preparedStatementSetter
					+ " WHERE VanSerialNo = ? AND SyncFacilityID = ? ";
		} else {
			query = " UPDATE  " + schemaName + "." + tableName + " SET " + preparedStatementSetter
					+ " WHERE VanSerialNo = ? AND VanID = ? ";
		}

		return query;
	}

}
