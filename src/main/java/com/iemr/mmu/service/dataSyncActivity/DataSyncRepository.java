package com.iemr.mmu.service.dataSyncActivity;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.syncActivity_syncLayer.SyncUtilityClass;
import com.iemr.mmu.repo.syncActivity_syncLayer.SyncUtilityClassRepo;

@Service
public class DataSyncRepository {
	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SyncUtilityClassRepo syncutilityClassRepo;

	private JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);

	}

	public List<Map<String, Object>> getDataForGivenSchemaAndTable(String schema, String table, String columnNames) {
		jdbcTemplate = getJdbcTemplate();
		String baseQuery = " SELECT " + columnNames + " FROM " + schema + "." + table + " WHERE processed != ? ";

		List<Map<String, Object>> resultSetList = jdbcTemplate.queryForList(baseQuery, "P");

		return resultSetList;
	}

	public List<SyncUtilityClass> getVanAndServerColumnList(List<Integer> syncTableDetailsIDs) {
		List<SyncUtilityClass> syncUtilityClassList = syncutilityClassRepo
				.findBySyncTableDetailIDInOrderBySyncTableDetailID(syncTableDetailsIDs);
		return syncUtilityClassList;
	}

	public int updateProcessedFlagInVan(String schemaName, String tableName, StringBuilder vanSerialNos,
			String autoIncreamentColumn) {
		jdbcTemplate = getJdbcTemplate();
		String query = " UPDATE " + schemaName + "." + tableName
				+ " SET processed = 'P' , SyncedDate = now(), Syncedby = 'Neeraj baba' WHERE " + autoIncreamentColumn
				+ " IN (" + vanSerialNos + ")";
		System.out.println("hello");

		int i = jdbcTemplate.update(query);

		return i;

	}

}
