package com.iemr.mmu.service.cancerScreening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.repo.nurse.BenCancerVitalDetailRepo;
import com.iemr.mmu.repo.nurse.BenFamilyCancerHistoryRepo;
import com.iemr.mmu.repo.nurse.BenObstetricCancerHistoryRepo;
import com.iemr.mmu.repo.nurse.BenPersonalCancerDietHistoryRepo;
import com.iemr.mmu.repo.nurse.BenPersonalCancerHistoryRepo;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;

@Service
public class CancerScreeningServiceImpl implements CancerScreeningService {

	private NurseServiceImpl nurseServiceImpl;
	private BenFamilyCancerHistoryRepo benFamilyCancerHistoryRepo;
	private BenObstetricCancerHistoryRepo benObstetricCancerHistoryRepo;
	private BenPersonalCancerDietHistoryRepo benPersonalCancerDietHistoryRepo;
	private BenPersonalCancerHistoryRepo benPersonalCancerHistoryRepo;
	private BenCancerVitalDetailRepo benCancerVitalDetailRepo;

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	@Autowired
	public void setBenFamilyCancerHistoryRepo(BenFamilyCancerHistoryRepo benFamilyCancerHistoryRepo) {
		this.benFamilyCancerHistoryRepo = benFamilyCancerHistoryRepo;
	}

	@Autowired
	public void setBenObstetricCancerHistoryRepo(BenObstetricCancerHistoryRepo benObstetricCancerHistoryRepo) {
		this.benObstetricCancerHistoryRepo = benObstetricCancerHistoryRepo;
	}

	@Autowired
	public void setBenPersonalCancerDietHistoryRepo(BenPersonalCancerDietHistoryRepo benPersonalCancerDietHistoryRepo) {
		this.benPersonalCancerDietHistoryRepo = benPersonalCancerDietHistoryRepo;
	}

	@Autowired
	public void setBenPersonalCancerHistoryRepo(BenPersonalCancerHistoryRepo benPersonalCancerHistoryRepo) {
		this.benPersonalCancerHistoryRepo = benPersonalCancerHistoryRepo;
	}

	@Autowired
	public void setBenCancerVitalDetailRepo(BenCancerVitalDetailRepo benCancerVitalDetailRepo) {
		this.benCancerVitalDetailRepo = benCancerVitalDetailRepo;
	}

	public void saveCancerScreeningNurseData(JsonObject requestOBJ) {
		// check if visit details data is not null
		if (requestOBJ != null && requestOBJ.has("visitDetails") && !requestOBJ.get("visitDetails").isJsonNull()) {
			// Call method to save visit details data
			Long benVisitID = saveBenVisitDetails(requestOBJ);
			// check if visit details data saved successfully
			if (benVisitID != null && benVisitID > 0) {
				// call method to save history data
				Long historySaveSuccessFlag = saveBenHistoryDetails(requestOBJ, benVisitID);
				// call method to save vitals data
				Long vitalSaveSuccessFlag = saveBenVitalsDetails(requestOBJ, benVisitID);

			} else {
				// Error in visit details saving or it is null
			}
		}
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for visitDetails data saving
	 */
	public Long saveBenVisitDetails(JsonObject requestOBJ) {
		BeneficiaryVisitDetail benVisitDetailsOBJ = InputMapper.gson().fromJson(requestOBJ.get("visitDetails"),
				BeneficiaryVisitDetail.class);
		Long benVisitID = nurseServiceImpl.saveBeneficiaryVisitDetails(benVisitDetailsOBJ);
		return benVisitID;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @param benVisitID
	 * @return success or failure flag for history data saving
	 */
	public Long saveBenHistoryDetails(JsonObject requestOBJ, Long benVisitID) {
		if (requestOBJ != null && requestOBJ.has("historyDetails") && !requestOBJ.get("historyDetails").isJsonNull()) {
			JsonObject historyOBJ = requestOBJ.getAsJsonObject("historyDetails");
			System.out.println("hi...");
			if (historyOBJ != null && historyOBJ.has("familyHistory")
					&& !historyOBJ.get("familyHistory").isJsonNull()) {
				System.out.println("hi...");
				JsonObject familyHistoryOBJ = historyOBJ.getAsJsonObject("familyHistory");
				if (familyHistoryOBJ != null && familyHistoryOBJ.has("diseases")
						&& !familyHistoryOBJ.get("diseases").isJsonNull()) {
					System.out.println("hi...");
					BenFamilyCancerHistory[] benFamilyCancerHistoryArray = InputMapper.gson().fromJson(
							familyHistoryOBJ.get("diseases").getAsJsonArray(), BenFamilyCancerHistory[].class);
					List<BenFamilyCancerHistory> benFamilyCancerHistoryList = Arrays
							.asList(benFamilyCancerHistoryArray);
					if (benFamilyCancerHistoryArray != null && benFamilyCancerHistoryList.size() > 0) {
						for (BenFamilyCancerHistory obj : benFamilyCancerHistoryArray) {
							obj.setBenVisitID(benVisitID);
						}
						Integer benFamilyHistoryDataSavingSuccessFlag = nurseServiceImpl
								.saveBenFamilyCancerHistory(benFamilyCancerHistoryList);

					} else {
						// family cancer history data is null for
						// beneficiary !!!
					}
					System.out.println("hi...");
				} else {
					// familyHistoryOBJ is null or diseases are not
					// there in familyHistoryOBJ or null
				}
			} else {
				// history Obj is null or family history history is null
				// or not there in history obj !!!
			}
			if (historyOBJ != null && historyOBJ.has("personalHistory")
					&& !historyOBJ.get("personalHistory").isJsonNull()) {
				BenPersonalCancerHistory benPersonalCancerHistory = InputMapper.gson()
						.fromJson(historyOBJ.get("personalHistory"), BenPersonalCancerHistory.class);

				BenPersonalCancerDietHistory benPersonalCancerDietHistory = InputMapper.gson()
						.fromJson(historyOBJ.get("personalHistory"), BenPersonalCancerDietHistory.class);

				if (benPersonalCancerHistory != null && benPersonalCancerDietHistory != null) {

					benPersonalCancerHistory.setBenVisitID(benVisitID);
					benPersonalCancerDietHistory.setBenVisitID(benVisitID);

					Long benPersonalHistorySaveSuccessFlag = nurseServiceImpl
							.saveBenPersonalCancerHistory(benPersonalCancerHistory);
					Long benPersonalDietHistorySaveSuccessFlag = nurseServiceImpl
							.saveBenPersonalCancerDietHistory(benPersonalCancerDietHistory);
				}
			} else {
				// ben personal history data not there !!!
			}
			if (historyOBJ != null && historyOBJ.has("pastObstetricHistory")
					&& !historyOBJ.get("pastObstetricHistory").isJsonNull()) {
				BenObstetricCancerHistory benObstetricCancerHistory = InputMapper.gson()
						.fromJson(historyOBJ.get("pastObstetricHistory"), BenObstetricCancerHistory.class);

				benObstetricCancerHistory.setBenVisitID(benVisitID);
				Long benObstetricSaveSuccessFlag = nurseServiceImpl
						.saveBenObstetricCancerHistory(benObstetricCancerHistory);
			} else {
				// ben obstetric history data not there !!!
			}

		} else {
			// History Object is not there in request object !!!
		}
		return null;
	}

	public Long saveBenFamilyHistoryDetails() {
		return null;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @param benVisitID
	 * @return success or failure flag for vitals data saving
	 */
	public Long saveBenVitalsDetails(JsonObject requestOBJ, Long benVisitID) {
		Long benVitalSaveSuccessFlag = null;
		if (requestOBJ != null && requestOBJ.has("vitalsDetails") && !requestOBJ.get("vitalsDetails").isJsonNull()) {
			BenCancerVitalDetail benCancerVitalDetail = InputMapper.gson().fromJson(requestOBJ.get("vitalsDetails"),
					BenCancerVitalDetail.class);
			if (benCancerVitalDetail != null) {
				benCancerVitalDetail.setBenVisitID(benVisitID);
				benVitalSaveSuccessFlag = nurseServiceImpl.saveBenVitalDetail(benCancerVitalDetail);
			}
		} else {
			// ben vitals data is not there !!!
		}
		return benVitalSaveSuccessFlag;
	}

	@Override
	public int UpdateCSHistoryNurseData(JsonObject jsnOBJ) {

		int familyCURes = 0;
		int pastObstetricCURes = 0;
		int personalCURes = 0;
		int personalDietURes = 0;
		int historyUpdateRes = 0;
		if (jsnOBJ.has("historyDetails") && null != jsnOBJ.get("historyDetails")) {
			JsonObject historyDetails = jsnOBJ.get("historyDetails").getAsJsonObject();

			if (null != historyDetails && historyDetails.has("familyHistory")
					&& !historyDetails.get("familyHistory").isJsonNull()) {
				JsonObject familyHistory = historyDetails.get("familyHistory").getAsJsonObject();
				BenFamilyCancerHistory[] benFamilyCancerHistoryArray = InputMapper.gson()
						.fromJson(familyHistory.get("diseases"), BenFamilyCancerHistory[].class);

				List<BenFamilyCancerHistory> benFamilyCancerHistoryList = Arrays.asList(benFamilyCancerHistoryArray);

				familyCURes = nurseServiceImpl.updateBeneficiaryFamilyCancerHistory(benFamilyCancerHistoryList);
			}

			if (null != historyDetails && historyDetails.has("pastObstetricHistory")
					&& !historyDetails.get("pastObstetricHistory").isJsonNull()) {

				BenObstetricCancerHistory benObstetricCancerHistory = InputMapper.gson()
						.fromJson(historyDetails.get("pastObstetricHistory"), BenObstetricCancerHistory.class);
				pastObstetricCURes = nurseServiceImpl.updateBenObstetricCancerHistory(benObstetricCancerHistory);
			}

			if (null != historyDetails && historyDetails.has("personalHistory")
					&& !historyDetails.get("personalHistory").isJsonNull()) {

				BenPersonalCancerHistory benPersonalCancerHistory = InputMapper.gson()
						.fromJson(historyDetails.get("personalHistory"), BenPersonalCancerHistory.class);

				BenPersonalCancerDietHistory benPersonalCancerDietHistory = InputMapper.gson()
						.fromJson(historyDetails.get("personalHistory"), BenPersonalCancerDietHistory.class);

				personalCURes = nurseServiceImpl.updateBenPersonalCancerHistory(benPersonalCancerHistory);

				personalDietURes = nurseServiceImpl.updateBenPersonalCancerDietHistory(benPersonalCancerDietHistory);

			}

			if (familyCURes > 0 && pastObstetricCURes > 0 && personalCURes > 0 && personalDietURes > 0) {
				historyUpdateRes = 1;
			} else {
				// TODO Rollback the succeeded transactions
			}

		}
		return historyUpdateRes;
	}

	@Override
	public int updateBenVitalDetail(BenCancerVitalDetail benCancerVitalDetail) {
		return nurseServiceImpl.updateBenVitalDetail(benCancerVitalDetail);
	}

	public String getBenDataFrmNurseToDocVisitDetailsScreen(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();
		BeneficiaryVisitDetail benVisitDetailsOBJ = nurseServiceImpl.getCSVisitDetails(benRegID, benVisitID);

		if (null != benVisitDetailsOBJ) {

			resMap.put("benVisitDetails", benVisitDetailsOBJ);
		}

		return new Gson().toJson(resMap);
	}
	
	public String getBenDataFrmNurseToDocHistoryScreen(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();

		resMap.put("benFamilyHistory", nurseServiceImpl.getBenFamilyHisData(benRegID, benVisitID));

		resMap.put("benObstetricHistory", nurseServiceImpl.getBenObstetricDetailsData(benRegID, benVisitID));

		resMap.put("benPersonalHistory", nurseServiceImpl.getBenPersonalCancerHistoryData(benRegID, benVisitID));

		resMap.put("benPersonalDietHistory", nurseServiceImpl.getBenPersonalCancerDietHistoryData(benRegID, benVisitID));

		return gson.toJson(resMap);
	}
	
	public String getBenDataFrmNurseToDocVitalScreen(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("benVitalDetails", nurseServiceImpl.getBenCancerVitalDetailData(benRegID, benVisitID));
		return new Gson().toJson(resMap);
	}
}
