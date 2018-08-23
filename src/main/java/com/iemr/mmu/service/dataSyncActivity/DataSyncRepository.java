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

	@Autowired
	private SyncUtilityClassRepo syncutilityClassRepo;

	public List<Map<String, Object>> getDataForGivenSchemaAndTable(String schema, String table) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String baseQuery1 = " SELECT * FROM ";
		String baseQuery2 = " WHERE processed != ? ";

		String finalQuery = baseQuery1 + schema + "." + table + baseQuery2;
		List<Map<String, Object>> resultSetList = jdbcTemplate.queryForList(finalQuery, "P");

		return resultSetList;
	}

	public List<SyncUtilityClass> getVanAndServerColumnList(List<Integer> syncTableDetailsIDs) {
		List<SyncUtilityClass> syncUtilityClassList = syncutilityClassRepo
				.findBySyncTableDetailIDInOrderBySyncTableDetailID(syncTableDetailsIDs);
		return syncUtilityClassList;
	}
}
