package com.iemr.mmu.service.cancerScreening;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
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
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.service.registrar.RegistrarServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
public class CSServiceImpl implements CSService {

	private NurseServiceImpl nurseServiceImpl;
	private CSNurseServiceImpl cSNurseServiceImpl;
	private CSDoctorServiceImpl cSDoctorServiceImpl;
	private RegistrarServiceImpl registrarServiceImpl;
	private CSOncologistServiceImpl csOncologistServiceImpl;
	
	@Autowired
	public void setRegistrarServiceImpl(RegistrarServiceImpl registrarServiceImpl) {
		this.registrarServiceImpl = registrarServiceImpl;
	}

	@Autowired
	public void setcSDoctorServiceImpl(CSDoctorServiceImpl cSDoctorServiceImpl) {
		this.cSDoctorServiceImpl = cSDoctorServiceImpl;
	}

	@Autowired
	public void setcSNurseServiceImpl(CSNurseServiceImpl cSNurseServiceImpl) {
		this.cSNurseServiceImpl = cSNurseServiceImpl;
	}

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	@Autowired
	public void setCsOncologistServiceImpl(CSOncologistServiceImpl csOncologistServiceImpl) {
		this.csOncologistServiceImpl = csOncologistServiceImpl;
	}
	
	// ----------Save/Create (Nurse)--------------------------------------

	/***
	 * 
	 * @param requestOBJ
	 * @throws Exception
	 */
	public Long saveCancerScreeningNurseData(JsonObject requestOBJ) throws Exception {
		Long nurseDataSuccessFlag = null;
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

				if ((historySaveSuccessFlag != null && historySaveSuccessFlag > 0)
						&& (vitalSaveSuccessFlag != null && vitalSaveSuccessFlag > 0)) {
					nurseDataSuccessFlag = historySaveSuccessFlag;
				}

			} else {
				// Error in visit details saving or it is null
			}

		}
		return nurseDataSuccessFlag;
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
						Integer benFamilyHistoryDataSavingSuccessFlag = cSNurseServiceImpl
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

					Long benPersonalHistorySaveSuccessFlag = cSNurseServiceImpl
							.saveBenPersonalCancerHistory(benPersonalCancerHistory);
					Long benPersonalDietHistorySaveSuccessFlag = cSNurseServiceImpl
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
				Long benObstetricSaveSuccessFlag = cSNurseServiceImpl
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
				benVitalSaveSuccessFlag = cSNurseServiceImpl.saveBenVitalDetail(benCancerVitalDetail);
			}
		} else {
			// ben vitals data is not there !!!
		}
		return benVitalSaveSuccessFlag;
	}

	/// -------End of Save/Create (Nurse)-----------------------------------

	// -------Update (Nurse data from Doctor screen)----------------------
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

				familyCURes = cSNurseServiceImpl.updateBeneficiaryFamilyCancerHistory(benFamilyCancerHistoryList);
			}

			if (null != historyDetails && historyDetails.has("pastObstetricHistory")
					&& !historyDetails.get("pastObstetricHistory").isJsonNull()) {

				BenObstetricCancerHistory benObstetricCancerHistory = InputMapper.gson()
						.fromJson(historyDetails.get("pastObstetricHistory"), BenObstetricCancerHistory.class);
				pastObstetricCURes = cSNurseServiceImpl.updateBenObstetricCancerHistory(benObstetricCancerHistory);
			}

			if (null != historyDetails && historyDetails.has("personalHistory")
					&& !historyDetails.get("personalHistory").isJsonNull()) {

				BenPersonalCancerHistory benPersonalCancerHistory = InputMapper.gson()
						.fromJson(historyDetails.get("personalHistory"), BenPersonalCancerHistory.class);

				BenPersonalCancerDietHistory benPersonalCancerDietHistory = InputMapper.gson()
						.fromJson(historyDetails.get("personalHistory"), BenPersonalCancerDietHistory.class);

				personalCURes = cSNurseServiceImpl.updateBenPersonalCancerHistory(benPersonalCancerHistory);

				personalDietURes = cSNurseServiceImpl.updateBenPersonalCancerDietHistory(benPersonalCancerDietHistory);

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
		return cSNurseServiceImpl.updateBenVitalDetail(benCancerVitalDetail);
	}

	/// ------- End of Update (Nurse data from Doctor screen)-----------

	// ------- Fetch (Nurse data to Doctor screen) ----------------
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

		resMap.put("benFamilyHistory", cSNurseServiceImpl.getBenFamilyHisData(benRegID, benVisitID));

		resMap.put("benObstetricHistory", cSNurseServiceImpl.getBenObstetricDetailsData(benRegID, benVisitID));

		resMap.put("benPersonalHistory", cSNurseServiceImpl.getBenPersonalCancerHistoryData(benRegID, benVisitID));

		resMap.put("benPersonalDietHistory",
				cSNurseServiceImpl.getBenPersonalCancerDietHistoryData(benRegID, benVisitID));

		return gson.toJson(resMap);
	}

	public String getBenDataFrmNurseToDocVitalScreen(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("benVitalDetails", cSNurseServiceImpl.getBenCancerVitalDetailData(benRegID, benVisitID));
		return new Gson().toJson(resMap);
	}

	/// -------End of Fetch (Nurse data to Doctor screen) -------

	// -------Create/save (Doctor)---------------------------

	public Long saveCancerScreeningDoctorData(JsonObject requestOBJ) throws Exception {
		Long docDataSuccessFlag = null;
		if (requestOBJ != null) {
			Long examinationSuccessFlag = saveBenExaminationDetails(requestOBJ);

			Long diagnosisSuccessFlag = saveBenDiagnosisDetails(requestOBJ);

			if ((examinationSuccessFlag != null && examinationSuccessFlag > 0)
					&& (diagnosisSuccessFlag != null && diagnosisSuccessFlag > 0)) {
				docDataSuccessFlag = examinationSuccessFlag;
			}

		} else {
			// NO input available..
		}
		return docDataSuccessFlag;

	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for Examination data saving
	 */
	public Long saveBenExaminationDetails(JsonObject requestOBJ) throws Exception {
		Long signSympSuccessFlag = null;
		Long lymphNodeSuccessFlag = null;
		Long oralDetailsSuccessFlag = null;
		Long breastExmnSuccessFlag = null;
		Long abdominalExmnSuccessFlag = null;
		Long gynecologicalExmnSuccessFlag = null;
		Long imgCoordinatesSuccessFlag = null;
		if (requestOBJ != null && requestOBJ.has("signsDetails") && !requestOBJ.get("signsDetails").isJsonNull()) {

			JsonObject signsDetailsOBJ = requestOBJ.getAsJsonObject("signsDetails");

			WrapperCancerSymptoms wrapperCancerSymptoms = InputMapper.gson().fromJson(signsDetailsOBJ,
					WrapperCancerSymptoms.class);

			if (null != wrapperCancerSymptoms.getCancerSignAndSymptoms()) {
				Long ID = cSDoctorServiceImpl
						.saveCancerSignAndSymptomsData(wrapperCancerSymptoms.getCancerSignAndSymptoms());
				if (ID > 0 && ID != null) {
					// SignAndSymptoms Details stored successfully..
					signSympSuccessFlag = ID;
				} else {
					//
				}
			} else {
				// signsDetails not available..
			}

			if (null != wrapperCancerSymptoms.getCancerLymphNodeDetails()) {
				Long ID = cSDoctorServiceImpl.saveLymphNodeDetails(wrapperCancerSymptoms.getCancerLymphNodeDetails());
				if (ID > 0 && ID != null) {
					// LymphNode Details stored successfully..
					lymphNodeSuccessFlag = ID;
				} else {

				} // Failed to store LymphNode Details..
			} else {
				// lymphNode not available..
			}
		}

		if (requestOBJ != null && requestOBJ.has("oralDetails") && !requestOBJ.get("oralDetails").isJsonNull()) {

			CancerOralExamination cancerOralExamination = InputMapper.gson().fromJson(requestOBJ.get("oralDetails"),
					CancerOralExamination.class);
			Long ID = cSDoctorServiceImpl.saveCancerOralExaminationData(cancerOralExamination);
			if (ID != null && ID > 0) {
				// oralDetails stored successfully...
				oralDetailsSuccessFlag = ID;
			} else {
				// Failed to store oralDetails..
			}

		} else {
			// oralDetails not available..
		}

		if (requestOBJ != null && requestOBJ.has("breastDetails") && !requestOBJ.get("breastDetails").isJsonNull()) {

			CancerBreastExamination cancerBreastExamination = InputMapper.gson()
					.fromJson(requestOBJ.get("breastDetails"), CancerBreastExamination.class);
			Long ID = cSDoctorServiceImpl.saveCancerBreastExaminationData(cancerBreastExamination);
			if (ID != null && ID > 0) {
				// breastDetails stored successfully...
				breastExmnSuccessFlag = ID;
			} else {
				// Failed to store breastDetails..
			}

		} else {
			// breastDetails not available..
		}

		if (requestOBJ != null && requestOBJ.has("abdominalDetails")
				&& !requestOBJ.get("abdominalDetails").isJsonNull()) {

			CancerAbdominalExamination cancerAbdominalExamination = InputMapper.gson()
					.fromJson(requestOBJ.get("abdominalDetails"), CancerAbdominalExamination.class);
			Long ID = cSDoctorServiceImpl.saveCancerAbdominalExaminationData(cancerAbdominalExamination);
			if (ID != null && ID > 0) {
				// abdominalDetails stored successfully...
				abdominalExmnSuccessFlag = ID;
			} else {
				// Failed to store abdominalDetails..
			}

		} else {
			// abdominalDetails not available..
		}

		if (requestOBJ != null && requestOBJ.has("gynecologicalDetails")
				&& !requestOBJ.get("gynecologicalDetails").isJsonNull()) {

			CancerGynecologicalExamination cancerGynecologicalExamination = InputMapper.gson()
					.fromJson(requestOBJ.get("gynecologicalDetails"), CancerGynecologicalExamination.class);
			Long ID = cSDoctorServiceImpl.saveCancerGynecologicalExaminationData(cancerGynecologicalExamination);
			if (ID != null && ID > 0) {
				// gynecologicalDetails stored successfully...
				gynecologicalExmnSuccessFlag = ID;
			} else {
				// Failed to store gynecologicalDetails..
			}

		} else {
			// gynecologicalDetails not available..
		}

		if (requestOBJ != null && requestOBJ.has("imageCoordinates")
				&& !requestOBJ.get("imageCoordinates").isJsonNull()) {

			WrapperCancerExamImgAnotasn[] wrapperCancerExamImgAnotasn = InputMapper.gson()
					.fromJson(requestOBJ.get("imageCoordinates"), WrapperCancerExamImgAnotasn[].class);

			List<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList = Arrays
					.asList(wrapperCancerExamImgAnotasn);

			Long r = cSDoctorServiceImpl.saveDocExaminationImageAnnotation(wrapperCancerExamImgAnotasnList);
			if (r != null && r > 0) {
				// imageCoordinates stored successfully...
				imgCoordinatesSuccessFlag = r;
			} else {
				// Failed to store imageCoordinates..
			}

		} else {
			// imageCoordinates not available..
		}

		Long exmnSuccessFlag = null;
		if (null != signSympSuccessFlag && signSympSuccessFlag > 0 && null != lymphNodeSuccessFlag
				&& lymphNodeSuccessFlag > 0 && null != oralDetailsSuccessFlag && oralDetailsSuccessFlag > 0
				&& null != breastExmnSuccessFlag && breastExmnSuccessFlag > 0 && null != abdominalExmnSuccessFlag
				&& abdominalExmnSuccessFlag > 0 && null != gynecologicalExmnSuccessFlag
				&& gynecologicalExmnSuccessFlag > 0 && null != imgCoordinatesSuccessFlag
				&& imgCoordinatesSuccessFlag > 0) {
			exmnSuccessFlag = signSympSuccessFlag;
			return exmnSuccessFlag;
		} else {
			return exmnSuccessFlag;
		}
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for Diagnosis data saving
	 */
	public Long saveBenDiagnosisDetails(JsonObject requestOBJ) throws Exception {

		Long diagnosisSuccessFlag = null;
		if (requestOBJ != null && requestOBJ.has("diagnosis") && !requestOBJ.get("diagnosis").isJsonNull()) {
			CancerDiagnosis cancerDiagnosis = InputMapper.gson().fromJson(requestOBJ.get("diagnosis"),
					CancerDiagnosis.class);
			Long ID = cSDoctorServiceImpl.saveCancerDiagnosisData(cancerDiagnosis);
			if (ID != null && ID > 0) {
				// diagnosis details stored successfully...
				diagnosisSuccessFlag = ID;
			} else {
				// Failed to store diagnosis details..
			}
		} else {
			// diagnosis details not available..
		}

		return diagnosisSuccessFlag;
	}

	/// ------- End of Create/save (Doctor)---------------------------

	// -------Fetch Case-sheet data ----------------------------------

	public String getCancerCasesheetData(JSONObject obj) {

		if (obj.length() > 1) {
			Long benRegID = null;
			Long benVisitID = null;
			try {
				benRegID = obj.getLong("benRegID");
				benVisitID = obj.getLong("benVisitID");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String caseSheetData = getBenDataForCaseSheet(benRegID, benVisitID);

		} else {

		}

		return null;
	}

	public String getBenDataForCaseSheet(Long benRegID, Long benVisitID) {

		Map<String, Object> caseSheetData = cSNurseServiceImpl.getBenNurseDataForCaseSheet(benRegID, benVisitID);

		caseSheetData.putAll(cSDoctorServiceImpl.getBenDoctorEnteredDataForCaseSheet(benRegID, benVisitID));
		caseSheetData.put("BeneficiaryDemographicData", registrarServiceImpl.getBeneficiaryDemographicData(benRegID));
		caseSheetData.put("ImageAnnotatedData",
				cSDoctorServiceImpl.getCancerExaminationImageAnnotationCasesheet(benRegID, benVisitID));

		return new Gson().toJson(caseSheetData);
	}

	/// -------End of Fetch Case-sheet data ----------------------------------

	// -------Fetch beneficiary all past family history data------------------
	public String getBenFamilyHistoryData(Long beneficiaryRegID) {
		return cSNurseServiceImpl.getBenCancerFamilyHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all past family history data----------

	// -------Fetch beneficiary all past personal history data------------------
	public String getBenPersonalHistoryData(Long beneficiaryRegID) {
		return cSNurseServiceImpl.getBenCancerPersonalHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all past personal history data--------

	// -------Fetch beneficiary all past personal diet history data-----------
	public String getBenPersonalDietHistoryData(Long beneficiaryRegID) {
		return cSNurseServiceImpl.getBenCancerPersonalDietHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all past personal diet history data--

	// -------Fetch beneficiary all past obstetric history data---------------
	public String getBenObstetricHistoryData(Long beneficiaryRegID) {
		return cSNurseServiceImpl.getBenCancerObstetricHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all past obstetric history data------

	@Override
	public int updateCancerDiagnosisDetailsByOncologist(CancerDiagnosis cancerDiagnosis) {
		return csOncologistServiceImpl.updateCancerDiagnosisDetailsByOncologist(cancerDiagnosis);

	}
	
}
