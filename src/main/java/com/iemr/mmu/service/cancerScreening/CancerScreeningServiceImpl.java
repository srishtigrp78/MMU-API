package com.iemr.mmu.service.cancerScreening;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.doctor.CancerAbdominalExamination;
import com.iemr.mmu.data.doctor.CancerBreastExamination;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.doctor.CancerGynecologicalExamination;
import com.iemr.mmu.data.doctor.CancerOralExamination;
import com.iemr.mmu.data.doctor.WrapperCancerExamImgAnotasn;
import com.iemr.mmu.data.doctor.WrapperCancerSymptoms;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.doctor.DoctorServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;

@Service
public class CancerScreeningServiceImpl implements CancerScreeningService {

	private NurseServiceImpl nurseServiceImpl;
	private DoctorServiceImpl doctorServiceImpl;

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	@Autowired
	public void setDoctorServiceImpl(DoctorServiceImpl doctorServiceImpl) {
		this.doctorServiceImpl = doctorServiceImpl;
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
	

	public void saveCancerScreeningDoctorData(JsonObject requestOBJ) {
		if (requestOBJ != null ){
			Long exmntnRes = saveBenExaminationDetails(requestOBJ);
			
			Long DgsRes = saveBenDiagnosisDetails(requestOBJ);
			
		}else{
			// NO input available..
		}
		
		
	}
	
	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for Examination data saving
	 */
	public Long saveBenExaminationDetails(JsonObject requestOBJ) {
		if (requestOBJ != null && requestOBJ.has("signsDetails") && !requestOBJ.get("signsDetails").isJsonNull()) {
			
			JsonObject signsDetailsOBJ = requestOBJ.getAsJsonObject("signsDetails");
			
			WrapperCancerSymptoms wrapperCancerSymptoms = InputMapper.gson().fromJson(signsDetailsOBJ,
					WrapperCancerSymptoms.class);
			
			if ( null != wrapperCancerSymptoms.getCancerSignAndSymptoms() ) {
				Long ID = doctorServiceImpl.saveCancerSignAndSymptomsData(wrapperCancerSymptoms.getCancerSignAndSymptoms());
				
				if (ID != null && ID > 0) {
					if ( null != wrapperCancerSymptoms.getCancerLymphNodeDetails()) {
						int result = doctorServiceImpl.saveLymphNodeDetails(wrapperCancerSymptoms.getCancerLymphNodeDetails());
						if (result > 0) {
							// LymphNode Details stored successfully..
						} else {
							
						}//Failed to store LymphNode Details..
					}

				}
				
			} else {
				//Failed to store SingsANdSymptoms..
			}
			
		} else {
			// signsDetails not available..
		}
		
		if (requestOBJ != null && requestOBJ.has("oralDetails") && !requestOBJ.get("oralDetails").isJsonNull()) {
			
			CancerOralExamination cancerOralExamination = InputMapper.gson().fromJson(requestOBJ.get("oralDetails"),
					CancerOralExamination.class);
			Long ID = doctorServiceImpl.saveCancerOralExaminationData(cancerOralExamination);
			if (ID != null && ID > 0) {
				// oralDetails stored successfully...
			} else {
				// Failed to store oralDetails..
			}
			
		} else {
			// oralDetails not available..
		}
		
		if (requestOBJ != null && requestOBJ.has("breastDetails") && !requestOBJ.get("breastDetails").isJsonNull()) {
			
			CancerBreastExamination cancerBreastExamination = InputMapper.gson().fromJson(requestOBJ.get("breastDetails"),
					CancerBreastExamination.class);
			Long ID = doctorServiceImpl.saveCancerBreastExaminationData(cancerBreastExamination);
			if (ID != null && ID > 0) {
				// breastDetails stored successfully...
			} else {
				// Failed to store breastDetails..
			}
			
		} else {
			// breastDetails not available..
		}
		
		if (requestOBJ != null && requestOBJ.has("abdominalDetails") && !requestOBJ.get("abdominalDetails").isJsonNull()) {
			
			CancerAbdominalExamination cancerAbdominalExamination = InputMapper.gson().fromJson(requestOBJ.get("abdominalDetails"),
					CancerAbdominalExamination.class);
			Long ID = doctorServiceImpl.saveCancerAbdominalExaminationData(cancerAbdominalExamination);
			if (ID != null && ID > 0) {
				// abdominalDetails stored successfully...
			} else {
				// Failed to store abdominalDetails..
			}
			
		} else {
			// abdominalDetails not available..
		}
		
		if (requestOBJ != null && requestOBJ.has("gynecologicalDetails") && !requestOBJ.get("gynecologicalDetails").isJsonNull()) {
			
			CancerGynecologicalExamination cancerGynecologicalExamination = InputMapper.gson().fromJson(requestOBJ.get("gynecologicalDetails"),
					CancerGynecologicalExamination.class);
			Long ID = doctorServiceImpl.saveCancerGynecologicalExaminationData(cancerGynecologicalExamination);
			if (ID != null && ID > 0) {
				// gynecologicalDetails stored successfully...
			} else {
				// Failed to store gynecologicalDetails..
			}
			
		} else {
			// gynecologicalDetails not available..
		}
		
		if (requestOBJ != null && requestOBJ.has("imageCoordinates") && !requestOBJ.get("imageCoordinates").isJsonNull()) {
			
			WrapperCancerExamImgAnotasn[] wrapperCancerExamImgAnotasn = InputMapper.gson().fromJson(requestOBJ.get("imageCoordinates"),
					WrapperCancerExamImgAnotasn[].class);

			List<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = Arrays
					.asList(wrapperCancerExamImgAnotasn);

			Long r = doctorServiceImpl.saveDocExaminationImageAnnotation(wrapperCancerExamImgAnotasnList);
			if (r != null && r > 0) {
				// imageCoordinates stored successfully...
			} else {
				// Failed to store imageCoordinates..
			}
			
		} else {
			// imageCoordinates not available..
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for Diagnosis data saving
	 */
	public Long saveBenDiagnosisDetails(JsonObject requestOBJ) {
		if (requestOBJ != null && requestOBJ.has("diagnosis") && !requestOBJ.get("diagnosis").isJsonNull()) {
			CancerDiagnosis cancerDiagnosis = InputMapper.gson().fromJson(requestOBJ.get("diagnosis"), CancerDiagnosis.class);
			Long ID = doctorServiceImpl.saveCancerDiagnosisData(cancerDiagnosis);
			if (ID != null && ID > 0) {
				// diagnosis details stored successfully...
			} else {
				// Failed to store diagnosis details..
			}
		} else {
			// diagnosis details not available..
		}
		
		return null;
	}
	
}
