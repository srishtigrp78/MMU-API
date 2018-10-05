package com.iemr.mmu.service.dataSyncLayerCentral;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/***
 * 
 * @author NE298657
 *
 */

@Service
public class DataSyncRepositoryCentral {
	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	private JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);

	}

	public int checkRecordIsAlreadyPresentOrNot(String schemaName, String tableName, String vanSerialNo, String vanID) {
		jdbcTemplate = getJdbcTemplate();
		String query = " SELECT * FROM " + schemaName + "." + tableName + " WHERE VanSerialNo = " + vanSerialNo
				+ " AND VanID = " + vanID;
		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(query);
		if (resultSet != null && resultSet.size() > 0)
			return 1;
		else
			return 0;
	}

	public int[] syncDataToCentralDB(String query, List<Object[]> syncDataList) {
		// get JDBC template
		jdbcTemplate = getJdbcTemplate();
		// start batch insert/update
		int[] i = jdbcTemplate.batchUpdate(query, syncDataList);

		return i;
	}
}
