/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mmu.service.dataSyncActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iemr.mmu.data.syncActivity_syncLayer.DataSyncGroups;
import com.iemr.mmu.data.syncActivity_syncLayer.SyncUtilityClass;
import com.iemr.mmu.repo.login.MasterVanRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.DataSyncGroupsRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.SyncUtilityClassRepo;

/***
 * 
 * @author NE298657
 * @date 16-08-2018
 * @purpose "This service is user for data sync activity from van side. Means
 *          taking unprocessed data from van and sync to server and based on
 *          success or failure update local tables processed flag"
 *
 */
@Service
@PropertySource("classpath:application.properties")
public class UploadDataToServerImpl implements UploadDataToServer {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	// rest URLs from server to consume local van data and to sync to DB server
	@Value("${dataSyncUploadUrl}")
	private String dataSyncUploadUrl;

	@Value("${BATCH_SIZE}")
	private int BATCH_SIZE;

	@Autowired
	private DataSyncRepository dataSyncRepository;
	@Autowired
	private DataSyncGroupsRepo dataSyncGroupsRepo;
	@Autowired
	private MasterVanRepo masterVanRepo;

	@Autowired
	private SyncUtilityClassRepo syncutilityClassRepo;

	// batch size for data upload
	// private static final int BATCH_SIZE = 30;

	/**
	 * 
	 * @param groupName
	 * @param Authorization
	 * @return
	 */
	// @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {
	// Exception.class })
	public String getDataToSyncToServer(int vanID, String user, String Authorization) throws Exception {

		String syncData = null;
		syncData = syncIntercepter(vanID, user, Authorization);

		return syncData;
	}

	/**
	 * 
	 * @param Authorization
	 * @return
	 */
	public String syncIntercepter(int vanID, String user, String Authorization) throws Exception {

		// sync activity trigger
		String serverAcknowledgement = startDataSync(vanID, user, Authorization);

		return serverAcknowledgement;
	}

	/**
	 * 
	 * @param syncTableDetailsIDs
	 * @param Authorization
	 * @return
	 */

	private String startDataSync(int vanID, String user, String Authorization) throws Exception {
		String serverAcknowledgement = null;
		List<Map<String, String>> responseStatus = new ArrayList<>();
		boolean isProgress = false;
		// fetch group masters
		List<DataSyncGroups> dataSyncGroupList = dataSyncGroupsRepo.findByDeleted(false);
		for (DataSyncGroups dataSyncGroups : dataSyncGroupList) {
			int groupId = dataSyncGroups.getSyncTableGroupID();
			List<SyncUtilityClass> syncUtilityClassList = getVanAndServerColumns(groupId);
			List<Map<String, Object>> syncData;
			List<Map<String, Object>> syncDataBatch;
			Map<String, String> groupIdStatus = new HashMap<>();
			for (SyncUtilityClass obj : syncUtilityClassList) {
		//		if (!isProgress) {
					// get data from DB to sync to server
					syncData = getDataToSync(obj.getSchemaName(), obj.getTableName(), obj.getVanColumnName());
					// System.out.println(new Gson().toJson(syncData));
					if (syncData != null && syncData.size() > 0) {
						int dataSize = syncData.size();
						int startIndex = 0;
						int fullBatchCount = dataSize / BATCH_SIZE;
						int remainder = dataSize % BATCH_SIZE;

						// sync data to server for batches
						for (int i = 0; i < fullBatchCount; i++) {
							// get data for each batch
							syncDataBatch = getBatchOfAskedSizeDataToSync(syncData, startIndex, BATCH_SIZE);
							// for each batch sync data to central server
							serverAcknowledgement = syncDataToServer(vanID, obj.getSchemaName(), obj.getTableName(),
									obj.getVanAutoIncColumnName(), obj.getServerColumnName(), syncDataBatch, user,
									Authorization);
		//					isProgress = setResponseStatus(groupIdStatus, groupId, serverAcknowledgement, responseStatus, isProgress);
							startIndex += BATCH_SIZE;
//							if(isProgress) 
//								break;
						}
						// sync data to server for rest data left from batch
						if (remainder > 0 && !isProgress) {
							// get data for extra data from batch
							syncDataBatch = getBatchOfAskedSizeDataToSync(syncData, startIndex, remainder);
							// for extra data from batch sync data to central server
							serverAcknowledgement = syncDataToServer(vanID, obj.getSchemaName(), obj.getTableName(),
									obj.getVanAutoIncColumnName(), obj.getServerColumnName(), syncDataBatch, user,
									Authorization);
			//				isProgress = setResponseStatus(groupIdStatus, groupId, serverAcknowledgement, responseStatus, isProgress);

						}

					} else {
						// nothing to sync
						serverAcknowledgement = "Data successfully synced";
					}
//				} else {
//					groupIdStatus.put("groupId", String.valueOf(groupId));
//					groupIdStatus.put("status", "pending");
//					responseStatus.add(groupIdStatus);
//				}
			} if(isProgress) {
				isProgress = setResponseStatus(groupIdStatus, groupId, serverAcknowledgement, responseStatus, isProgress);
			}
		}
		if (isProgress) {
			return responseStatus.toString();
		} else {

			return serverAcknowledgement;
		}
	}

	private boolean setResponseStatus(Map<String, String> groupIdStatus, int groupId, String serverAcknowledgement,
			List<Map<String, String>> responseStatus, boolean isProgress) {
		if (serverAcknowledgement != null) {
			groupIdStatus.put("groupId", String.valueOf(groupId));
			groupIdStatus.put("status", serverAcknowledgement);
			responseStatus.add(groupIdStatus);
		} else if (isProgress) {
			groupIdStatus.put("groupId", String.valueOf(groupId));
			groupIdStatus.put("status", "pending");
			responseStatus.add(groupIdStatus);
		} else {
			isProgress = true;
			groupIdStatus.put("groupId", String.valueOf(groupId));
			groupIdStatus.put("status", "failed");
			responseStatus.add(groupIdStatus);
		}
		return isProgress;

	}

	/**
	 * 
	 * @param syncTableDetailsIDs
	 * @return
	 */

	private List<SyncUtilityClass> getVanAndServerColumns(Integer groupID) throws Exception {
		List<SyncUtilityClass> syncUtilityClassList = getVanAndServerColumnList(groupID);

		return syncUtilityClassList;
	}

	public List<SyncUtilityClass> getVanAndServerColumnList(Integer groupID) throws Exception {
		List<SyncUtilityClass> syncUtilityClassList = syncutilityClassRepo
				.findBySyncTableGroupIDAndDeletedOrderBySyncTableDetailID(groupID, false);
		return syncUtilityClassList;
	}

	/**
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnNames
	 * @return
	 */

	private List<Map<String, Object>> getDataToSync(String schemaName, String tableName, String columnNames)
			throws Exception {
		List<Map<String, Object>> resultSetList = dataSyncRepository.getDataForGivenSchemaAndTable(schemaName,
				tableName, columnNames);
		return resultSetList;
	}

	/**
	 * 
	 * @param syncData
	 * @param startIndex
	 * @param size
	 * @return
	 */

	private List<Map<String, Object>> getBatchOfAskedSizeDataToSync(List<Map<String, Object>> syncData, int startIndex,
			int size) throws Exception {
		List<Map<String, Object>> syncDataOfBatchSize = syncData.subList(startIndex, (startIndex + size));
		return syncDataOfBatchSize;
	}

	/**
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param vanAutoIncColumnName
	 * @param serverColumns
	 * @param dataToBesync
	 * @param Authorization
	 * @return
	 */

	public String syncDataToServer(int vanID, String schemaName, String tableName, String vanAutoIncColumnName,
			String serverColumns, List<Map<String, Object>> dataToBesync, String user, String Authorization)
			throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		Integer facilityID = masterVanRepo.getFacilityID(vanID);

		// serialize null
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();

		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("schemaName", schemaName);
		dataMap.put("tableName", tableName);
		dataMap.put("vanAutoIncColumnName", vanAutoIncColumnName);
		dataMap.put("serverColumns", serverColumns);
		dataMap.put("syncData", dataToBesync);
		dataMap.put("syncedBy", user);
		if (facilityID != null)
			dataMap.put("facilityID", facilityID);

		String requestOBJ = gson.toJson(dataMap);

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		headers.add("AUTHORIZATION", Authorization);
		HttpEntity<Object> request = new HttpEntity<Object>(requestOBJ, headers);
		logger.info("Before Data sync upload Url" + dataSyncUploadUrl);
		ResponseEntity<String> response = restTemplate.exchange(dataSyncUploadUrl, HttpMethod.POST, request,
				String.class);

		logger.info("After Data sync upload Url" + dataSyncUploadUrl);
		/**
		 * if data successfully synced then getVanSerialNo of synced data to update
		 * processed flag
		 */
		int i = 0;
		if (response != null && response.hasBody()) {
			JSONObject obj = new JSONObject(response.getBody());
			if (obj != null && obj.has("statusCode") && obj.getInt("statusCode") == 200) {
				StringBuilder vanSerialNos = getVanSerialNoListForSyncedData(vanAutoIncColumnName, dataToBesync);
				// update table for processed flag = "P"
				logger.info(schemaName + "|" + tableName + "|" + vanSerialNos.toString() + "|" + vanAutoIncColumnName
						+ "|" + user);
				i = dataSyncRepository.updateProcessedFlagInVan(schemaName, tableName, vanSerialNos,
						vanAutoIncColumnName, user);
			}
		}
		if (i > 0)
			return "Data successfully synced";
		else
			return null;
	}

	/**
	 * 
	 * @param vanAutoIncColumnName
	 * @param dataToBesync
	 * @return
	 */

	public StringBuilder getVanSerialNoListForSyncedData(String vanAutoIncColumnName,
			List<Map<String, Object>> dataToBesync) throws Exception {
		// comma separated van serial no
		StringBuilder vanSerialNos = new StringBuilder();

		int pointer1 = 0;
		for (Map<String, Object> map : dataToBesync) {
			if (pointer1 == dataToBesync.size() - 1)
				vanSerialNos.append(map.get(vanAutoIncColumnName.trim()));
			else
				vanSerialNos.append(map.get(vanAutoIncColumnName.trim()) + ",");

			pointer1++;
		}
		return vanSerialNos;
	}

	public String getDataSyncGroupDetails() {
		List<DataSyncGroups> dataSyncGroupList = dataSyncGroupsRepo.findByDeleted(false);
		if (dataSyncGroupList != null)
			return new Gson().toJson(dataSyncGroupList);
		else
			return null;
	}

}
