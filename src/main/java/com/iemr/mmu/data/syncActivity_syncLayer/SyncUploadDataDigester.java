package com.iemr.mmu.data.syncActivity_syncLayer;

import java.util.List;
import java.util.Map;

public class SyncUploadDataDigester {
	private String schemaName;
	private String tableName;
	private String vanAutoIncColumnName;
	private String serverColumns;
	private String syncedBy;
	private Integer facilityID;
	// private Long vanSerialNo;
	// private Integer syncFacilityID;
	private List<Map<String, Object>> syncData;

	private List<Long> ids;

	public SyncUploadDataDigester() {
	}

	public SyncUploadDataDigester(String schemaName, String tableName, Integer facilityID) {
		super();
		this.schemaName = schemaName;
		this.tableName = tableName;
		this.facilityID = facilityID;
	}

	public SyncUploadDataDigester(String schemaName, String tableName, List<Long> ids) {
		super();
		this.schemaName = schemaName;
		this.tableName = tableName;
		this.ids = ids;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getVanAutoIncColumnName() {
		return vanAutoIncColumnName;
	}

	public void setVanAutoIncColumnName(String vanAutoIncColumnName) {
		this.vanAutoIncColumnName = vanAutoIncColumnName;
	}

	public String getServerColumns() {
		return serverColumns;
	}

	public void setServerColumns(String serverColumns) {
		this.serverColumns = serverColumns;
	}

	public List<Map<String, Object>> getSyncData() {
		return syncData;
	}

	public void setSyncData(List<Map<String, Object>> syncData) {
		this.syncData = syncData;
	}

	public String getSyncedBy() {
		return syncedBy;
	}

	public void setSyncedBy(String syncedBy) {
		this.syncedBy = syncedBy;
	}

	public Integer getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(Integer facilityID) {
		this.facilityID = facilityID;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

}
