package com.iemr.mmu.service.dataSyncLayerCentral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iemr.mmu.data.syncActivity_syncLayer.SyncUploadDataDigester;
import com.iemr.mmu.repo.syncActivity_syncLayer.IndentIssueRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.IndentOrderRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.IndentRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.ItemStockEntryRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.StockTransferRepo;

@Service
public class FetchDownloadDataImpl implements FetchDownloadData {

	@Autowired
	private IndentRepo indentRepo;
	@Autowired
	private IndentOrderRepo indentOrderRepo;
	@Autowired
	private IndentIssueRepo indentIssueRepo;
	@Autowired
	private StockTransferRepo stockTransferRepo;
	@Autowired
	private ItemStockEntryRepo itemStockEntryRepo;
	@Autowired
	private DataSyncRepositoryCentral dataSyncRepositoryCentral;

	public String getDownloadData(SyncUploadDataDigester syncUploadDataDigester) throws Exception {
		if (syncUploadDataDigester.getSchemaName() != null && syncUploadDataDigester.getTableName() != null
				&& syncUploadDataDigester.getFacilityID() != null) {

			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.serializeNulls();
			Gson gson = gsonBuilder.create();

			switch (syncUploadDataDigester.getTableName()) {
			case "t_indent": {
				return gson.toJson(
						indentRepo.findByFromFacilityIDAndProcessedNotAndSyncFacilityIDNotNullAndVanSerialNoNotNull(
								syncUploadDataDigester.getFacilityID(), "P"));

			}
			case "t_indentorder": {
				return gson.toJson(indentOrderRepo
						.findByFromFacilityIDAndProcessedNotAndSyncFacilityIDNotNullAndVanSerialNoNotNull(
								syncUploadDataDigester.getFacilityID(), "P"));
			}
			case "t_indentissue": {
				return gson.toJson(
						indentIssueRepo.findByToFacilityIDAndProcessedNotAndSyncFacilityIDNotNullAndVanSerialNoNotNull(
								syncUploadDataDigester.getFacilityID(), "P"));
			}
			case "t_stocktransfer": {
				return gson.toJson(stockTransferRepo
						.findByTransferToFacilityIDAndProcessedNotAndSyncFacilityIDNotNullAndVanSerialNoNotNull(
								syncUploadDataDigester.getFacilityID(), "P"));
			}
			case "t_itemstockentry": {
				return gson.toJson(
						itemStockEntryRepo.findByFacilityIDAndProcessedNotAndSyncFacilityIDNotNullAndVanSerialNoNotNull(
								syncUploadDataDigester.getFacilityID(), "P"));
			}
			default:
				throw new Exception("invalid download request. Table info is missing/wrong");
			}
		} else
			throw new Exception("invalid download request. Either table or facility info is missing/wrong");

	}

	public int updateProcessedFlagPostSuccessfullDownload(SyncUploadDataDigester syncUploadDataDigester)
			throws Exception {

		int status = 0;
		if (syncUploadDataDigester.getSchemaName() != null && syncUploadDataDigester.getTableName() != null
				&& syncUploadDataDigester.getIds() != null) {

			switch (syncUploadDataDigester.getTableName()) {
			case "t_indent": {
				status = indentRepo.updateProcessedFlag(syncUploadDataDigester.getIds());
				break;
			}
			case "t_indentorder": {
				status = indentOrderRepo.updateProcessedFlag(syncUploadDataDigester.getIds());
				break;
			}
			case "t_indentissue": {
				status = indentIssueRepo.updateProcessedFlag(syncUploadDataDigester.getIds());
				break;
			}
			case "t_stocktransfer": {
				status = stockTransferRepo.updateProcessedFlag(syncUploadDataDigester.getIds());
				break;
			}
			case "t_itemstockentry": {
				status = itemStockEntryRepo.updateProcessedFlag(syncUploadDataDigester.getIds());
				break;
			}
			default:
				throw new Exception("invalid request. Table info is missing/wrong");
			}
		} else
			throw new Exception("invalid request.table /facility /serialNo info is missing/wrong");

		return status;
	}

}
