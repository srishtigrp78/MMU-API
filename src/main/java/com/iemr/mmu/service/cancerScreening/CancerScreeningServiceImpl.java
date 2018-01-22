package com.iemr.mmu.service.cancerScreening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.iemr.mmu.utils.mapper.InputMapper;

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

	public void saveCancerScreeningNurseData(JsonObject requestOBJ) throws Exception {
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
	public Long saveBenVisitDetails(JsonObject requestOBJ) throws Exception {
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
	 * @throws Exception
	 */
	public Long saveBenHistoryDetails(JsonObject requestOBJ, Long benVisitID) throws Exception {
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
	 * @throws Exception
	 */
	public Long saveBenVitalsDetails(JsonObject requestOBJ, Long benVisitID) throws Exception {
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
	public int UpdateCSHistoryNurseData(JsonObject jsnOBJ) throws Exception {

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

				familyCURes = updateBeneficiaryFamilyCancerHistory(benFamilyCancerHistoryList);
			}

			if (null != historyDetails && historyDetails.has("pastObstetricHistory")
					&& !historyDetails.get("pastObstetricHistory").isJsonNull()) {

				BenObstetricCancerHistory benObstetricCancerHistory = InputMapper.gson()
						.fromJson(historyDetails.get("pastObstetricHistory"), BenObstetricCancerHistory.class);
				pastObstetricCURes = updateBenObstetricCancerHistory(benObstetricCancerHistory);
			}

			if (null != historyDetails && historyDetails.has("personalHistory")
					&& !historyDetails.get("personalHistory").isJsonNull()) {

				BenPersonalCancerHistory benPersonalCancerHistory = InputMapper.gson()
						.fromJson(historyDetails.get("personalHistory"), BenPersonalCancerHistory.class);

				BenPersonalCancerDietHistory benPersonalCancerDietHistory = InputMapper.gson()
						.fromJson(historyDetails.get("personalHistory"), BenPersonalCancerDietHistory.class);

				personalCURes = updateBenPersonalCancerHistory(benPersonalCancerHistory);

				personalDietURes = updateBenPersonalCancerDietHistory(benPersonalCancerDietHistory);

			}

			if (familyCURes > 0 && pastObstetricCURes > 0 && personalCURes > 0 && personalDietURes > 0) {
				historyUpdateRes = 1;
			} else {
				// TODO Rollback the succeded transactions
			}

		}
		return historyUpdateRes;
	}

	@Override
	public int updateBeneficiaryFamilyCancerHistory(List<BenFamilyCancerHistory> benFamilyCancerHistoryList) {
		int response = 0;
		int delRes = 0;
		try {
			if (benFamilyCancerHistoryList.size() > 0) {

				ArrayList<Object[]> benFamilyCancerHistoryStatuses = benFamilyCancerHistoryRepo
						.getFamilyCancerHistoryStatus(benFamilyCancerHistoryList.get(0).getBeneficiaryRegID(),
								benFamilyCancerHistoryList.get(0).getBenVisitID());

				for (Object[] obj : benFamilyCancerHistoryStatuses) {
					Character processed = (Character) obj[1];
					if (null != processed && processed != 'N') {
						processed = 'U';
					}
					delRes = benFamilyCancerHistoryRepo.deleteExistingFamilyRecord((Long) obj[0], processed);
				}

			}
			ArrayList<BenFamilyCancerHistory> newbenFamilyCancerHistoryList = new ArrayList<BenFamilyCancerHistory>();
			if (delRes > 0) {
				for (BenFamilyCancerHistory benFamilyCancerHistory : benFamilyCancerHistoryList) {
					List<String> familyMenberList = benFamilyCancerHistory.getFamilyMemberList();
					if (null != familyMenberList && !familyMenberList.isEmpty()) {
						String familyMemberData = "";
						for (String familyMember : familyMenberList) {
							familyMemberData += familyMember + ",";
						}
						benFamilyCancerHistory.setFamilyMember(familyMemberData);
						newbenFamilyCancerHistoryList.add(benFamilyCancerHistory);
					}

				}
				if (newbenFamilyCancerHistoryList.size() > 0) {
					ArrayList<BenFamilyCancerHistory> benFamilyCancerHistories = (ArrayList<BenFamilyCancerHistory>) benFamilyCancerHistoryRepo
							.save(newbenFamilyCancerHistoryList);
					if (benFamilyCancerHistories.size() > 0) {
						response = benFamilyCancerHistories.size();
					}
				} else {
					response = 0;
				}
			} else {
				response = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	@Override
	public int updateBenObstetricCancerHistory(BenObstetricCancerHistory benObstetricCancerHistory) {
		int response = 0;

		Character processed = benObstetricCancerHistoryRepo.getObstetricCancerHistoryStatus(
				benObstetricCancerHistory.getBeneficiaryRegID(), benObstetricCancerHistory.getBenVisitID());
		if (null != processed && processed != 'N') {
			processed = 'U';
		}
		try {

			response = benObstetricCancerHistoryRepo.updateBenObstetricCancerHistory(
					benObstetricCancerHistory.getProviderServiceMapID(), benObstetricCancerHistory.getPregnancyStatus(),
					benObstetricCancerHistory.getIsUrinePregTest(), benObstetricCancerHistory.getPregnant_No(),
					benObstetricCancerHistory.getNoOfLivingChild(), benObstetricCancerHistory.getIsAbortion(),
					benObstetricCancerHistory.getIsOralContraceptiveUsed(),
					benObstetricCancerHistory.getIsHormoneReplacementTherapy(),
					benObstetricCancerHistory.getMenarche_Age(), benObstetricCancerHistory.getIsMenstrualCycleRegular(),
					benObstetricCancerHistory.getMenstrualCycleLength(),
					benObstetricCancerHistory.getMenstrualFlowDuration(),
					benObstetricCancerHistory.getMenstrualFlowType(), benObstetricCancerHistory.getIsDysmenorrhea(),
					benObstetricCancerHistory.getIsInterMenstrualBleeding(),
					benObstetricCancerHistory.getMenopauseAge(), benObstetricCancerHistory.getIsPostMenopauseBleeding(),
					benObstetricCancerHistory.getIsFoulSmellingDischarge(), benObstetricCancerHistory.getModifiedBy(),
					benObstetricCancerHistory.getBeneficiaryRegID(), benObstetricCancerHistory.getBenVisitID(),
					processed);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	@Override
	public int updateBenPersonalCancerHistory(BenPersonalCancerHistory benPersonalCancerHistory) {
		int response = 0;

		Character processed = benPersonalCancerHistoryRepo.getPersonalCancerHistoryStatus(
				benPersonalCancerHistory.getBeneficiaryRegID(), benPersonalCancerHistory.getBenVisitID());
		if (null != processed && processed != 'N') {
			processed = 'U';
		}

		try {

			List<String> typeOfTobaccoProductList = benPersonalCancerHistory.getTypeOfTobaccoProductList();
			if (null != typeOfTobaccoProductList && !typeOfTobaccoProductList.isEmpty()) {
				String typeOfTobaccoProductData = "";
				for (String typeOfTobaccoProduct : typeOfTobaccoProductList) {
					typeOfTobaccoProductData += typeOfTobaccoProduct + ",";
				}
				benPersonalCancerHistory.setTypeOfTobaccoProduct(typeOfTobaccoProductData);
			}
			response = benPersonalCancerHistoryRepo.updateBenPersonalCancerHistory(
					benPersonalCancerHistory.getProviderServiceMapID(), benPersonalCancerHistory.getTobaccoUse(),
					benPersonalCancerHistory.getStartAge_year(), benPersonalCancerHistory.getEndAge_year(),
					benPersonalCancerHistory.getTypeOfTobaccoProduct(), benPersonalCancerHistory.getQuantityPerDay(),
					benPersonalCancerHistory.getIsFilteredCigaerette(),
					benPersonalCancerHistory.getIsCigaretteExposure(), benPersonalCancerHistory.getIsBetelNutChewing(),
					benPersonalCancerHistory.getDurationOfBetelQuid(), benPersonalCancerHistory.getAlcoholUse(),
					benPersonalCancerHistory.getSsAlcoholUsed(), benPersonalCancerHistory.getFrequencyOfAlcoholUsed(),
					benPersonalCancerHistory.getModifiedBy(), benPersonalCancerHistory.getBeneficiaryRegID(),
					benPersonalCancerHistory.getBenVisitID(), processed);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	@Override
	public int updateBenPersonalCancerDietHistory(BenPersonalCancerDietHistory benPersonalCancerDietHistory) {
		int response = 0;

		Character processed = benPersonalCancerDietHistoryRepo.getPersonalCancerDietHistoryStatus(
				benPersonalCancerDietHistory.getBeneficiaryRegID(), benPersonalCancerDietHistory.getBenVisitID());
		if (null != processed && processed != 'N') {
			processed = 'U';
		}

		try {
			List<String> typeOfOilConsumedList = benPersonalCancerDietHistory.getTypeOfOilConsumedList();
			if (null != typeOfOilConsumedList && !typeOfOilConsumedList.isEmpty()) {
				String typeOfOilConsumedData = "";
				for (String typeOfOilConsumed : typeOfOilConsumedList) {
					typeOfOilConsumedData += typeOfOilConsumed + ",";
				}
				benPersonalCancerDietHistory.setTypeOfOilConsumed(typeOfOilConsumedData);
			}

			response = benPersonalCancerDietHistoryRepo.updateBenPersonalCancerDietHistory(
					benPersonalCancerDietHistory.getProviderServiceMapID(), benPersonalCancerDietHistory.getDietType(),
					benPersonalCancerDietHistory.getFruitConsumptionDays(),
					benPersonalCancerDietHistory.getFruitQuantityPerDay(),
					benPersonalCancerDietHistory.getVegetableConsumptionDays(),
					benPersonalCancerDietHistory.getVegetableQuantityPerDay(),
					benPersonalCancerDietHistory.getIntakeOfOutsidePreparedMeal(),
					benPersonalCancerDietHistory.getTypeOfOilConsumed(),
					benPersonalCancerDietHistory.getPhysicalActivityType(),
					benPersonalCancerDietHistory.getSsRadiationExposure(),
					benPersonalCancerDietHistory.getIsThyroidDisorder(), benPersonalCancerDietHistory.getModifiedBy(),
					benPersonalCancerDietHistory.getBeneficiaryRegID(), benPersonalCancerDietHistory.getBenVisitID(),
					processed);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	@Override
	public int updateBenVitalDetail(BenCancerVitalDetail benCancerVitalDetail) {

		Character processed = benCancerVitalDetailRepo.getCancerVitalStatus(benCancerVitalDetail.getBeneficiaryRegID(),
				benCancerVitalDetail.getBenVisitID());
		if (null != processed && processed != 'N') {
			processed = 'U';
		}
		int response = benCancerVitalDetailRepo.updateBenCancerVitalDetail(
				benCancerVitalDetail.getProviderServiceMapID(), benCancerVitalDetail.getWeight_Kg(),
				benCancerVitalDetail.getHeight_cm(), benCancerVitalDetail.getWaistCircumference_cm(),
				benCancerVitalDetail.getBloodGlucose_Fasting(), benCancerVitalDetail.getBloodGlucose_Random(),
				benCancerVitalDetail.getBloodGlucose_2HrPostPrandial(), benCancerVitalDetail.getSystolicBP_1stReading(),
				benCancerVitalDetail.getDiastolicBP_1stReading(), benCancerVitalDetail.getSystolicBP_2ndReading(),
				benCancerVitalDetail.getDiastolicBP_2ndReading(), benCancerVitalDetail.getSystolicBP_3rdReading(),
				benCancerVitalDetail.getDiastolicBP_3rdReading(), benCancerVitalDetail.getHbA1C(),
				benCancerVitalDetail.getHemoglobin(), benCancerVitalDetail.getModifiedBy(),
				benCancerVitalDetail.getBeneficiaryRegID(), benCancerVitalDetail.getBenVisitID(), processed);
		return response;
	}

}
