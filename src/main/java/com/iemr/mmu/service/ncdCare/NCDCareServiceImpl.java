package com.iemr.mmu.service.ncdCare;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.BenAdherence;
import com.iemr.mmu.data.anc.BenAllergyHistory;
import com.iemr.mmu.data.anc.BenChildDevelopmentHistory;
import com.iemr.mmu.data.anc.BenFamilyHistory;
import com.iemr.mmu.data.anc.BenMedHistory;
import com.iemr.mmu.data.anc.BenMenstrualDetails;
import com.iemr.mmu.data.anc.BenPersonalHabit;
import com.iemr.mmu.data.anc.ChildFeedingDetails;
import com.iemr.mmu.data.anc.PerinatalHistory;
import com.iemr.mmu.data.anc.WrapperAncFindings;
import com.iemr.mmu.data.anc.WrapperBenInvestigationANC;
import com.iemr.mmu.data.anc.WrapperChildOptionalVaccineDetail;
import com.iemr.mmu.data.anc.WrapperComorbidCondDetails;
import com.iemr.mmu.data.anc.WrapperFemaleObstetricHistory;
import com.iemr.mmu.data.anc.WrapperImmunizationHistory;
import com.iemr.mmu.data.anc.WrapperMedicationHistory;
import com.iemr.mmu.data.ncdcare.NCDCareDiagnosis;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
public class NCDCareServiceImpl implements NCDCareService {
	private CommonNurseServiceImpl commonNurseServiceImpl;
	private CommonDoctorServiceImpl commonDoctorServiceImpl;
	private NCDCareDoctorServiceImpl ncdCareDoctorServiceImpl;
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;

	@Autowired
	public void setCommonBenStatusFlowServiceImpl(CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl) {
		this.commonBenStatusFlowServiceImpl = commonBenStatusFlowServiceImpl;
	}

	@Autowired
	public void setNcdCareDoctorServiceImpl(NCDCareDoctorServiceImpl ncdCareDoctorServiceImpl) {
		this.ncdCareDoctorServiceImpl = ncdCareDoctorServiceImpl;
	}

	@Autowired
	public void setCommonDoctorServiceImpl(CommonDoctorServiceImpl commonDoctorServiceImpl) {
		this.commonDoctorServiceImpl = commonDoctorServiceImpl;
	}

	@Autowired
	public void setCommonNurseServiceImpl(CommonNurseServiceImpl commonNurseServiceImpl) {
		this.commonNurseServiceImpl = commonNurseServiceImpl;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Long saveNCDCareNurseData(JsonObject requestOBJ) throws Exception {
		Long saveSuccessFlag = null;
		// check if visit details data is not null
		if (requestOBJ != null && requestOBJ.has("visitDetails") && !requestOBJ.get("visitDetails").isJsonNull()) {
			// Call method to save visit details data
			Long benVisitID = saveBenVisitDetails(requestOBJ.getAsJsonObject("visitDetails"));

			// check if visit details data saved successfully
			Long historySaveSuccessFlag = null;
			Long vitalSaveSuccessFlag = null;
			Integer i = null;

			// temporary object for ben flow part. for getting visit reason and
			// category and ben reg id
			JsonObject tmpOBJ = requestOBJ.getAsJsonObject("visitDetails").getAsJsonObject("visitDetails");
			// Getting benflowID for ben status update
			Long benFlowID = null;
			if (requestOBJ.has("benFlowID")) {
				benFlowID = requestOBJ.get("benFlowID").getAsLong();
			}

			if (benVisitID != null && benVisitID > 0) {
				// call method to save History data
				historySaveSuccessFlag = saveBenNCDCareHistoryDetails(requestOBJ.getAsJsonObject("historyDetails"),
						benVisitID);
				// call method to save Vital data
				vitalSaveSuccessFlag = saveBenNCDCareVitalDetails(requestOBJ.getAsJsonObject("vitalDetails"),
						benVisitID);

				i = commonNurseServiceImpl.updateBeneficiaryStatus('N', tmpOBJ.get("beneficiaryRegID").getAsLong());
			} else {
				// Error in visit details saving or it is null
			}
			if ((null != historySaveSuccessFlag && historySaveSuccessFlag > 0)
					&& (null != vitalSaveSuccessFlag && vitalSaveSuccessFlag > 0) && (i != null)) {
				saveSuccessFlag = historySaveSuccessFlag;

				/**
				 * We have to write new code to update ben status flow new logic
				 */
				int J = updateBenFlowNurseAfterNurseActivityANC(
						requestOBJ.getAsJsonObject("visitDetails").getAsJsonObject("investigation"), tmpOBJ, benVisitID,
						benFlowID);
			}
		} else {
			// Can't create BenVisitID
		}
		return saveSuccessFlag;
	}

	// method for updating ben flow status flag for nurse
	private int updateBenFlowNurseAfterNurseActivityANC(JsonObject investigationDataCheck, JsonObject tmpOBJ,
			Long benVisitID, Long benFlowID) {
		short nurseFlag;
		short docFlag;
		short labIteration;

		if (!investigationDataCheck.isJsonNull() && !investigationDataCheck.get("laboratoryList").isJsonNull()
				&& investigationDataCheck.getAsJsonArray("laboratoryList").size() > 0) {

			// ben will transfer to lab and doc both
			nurseFlag = (short) 2;
			docFlag = (short) 0;
			labIteration = (short) 1;
		} else {
			// ben will transfer doc only
			nurseFlag = (short) 9;
			docFlag = (short) 1;
			labIteration = (short) 0;
		}

		int rs = commonBenStatusFlowServiceImpl.updateBenFlowNurseAfterNurseActivity(benFlowID,
				tmpOBJ.get("beneficiaryRegID").getAsLong(), benVisitID, tmpOBJ.get("visitReason").getAsString(),
				tmpOBJ.get("visitCategory").getAsString(), nurseFlag, docFlag, labIteration, (short) 0, (short) 0);

		return rs;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for visitDetails data saving
	 */
	public Long saveBenVisitDetails(JsonObject visitDetailsOBJ) throws Exception {
		Long benVisitID = null;
		int adherenceSuccessFlag = 0;
		int investigationSuccessFlag = 0;
		if (visitDetailsOBJ != null && visitDetailsOBJ.has("visitDetails")
				&& !visitDetailsOBJ.get("visitDetails").isJsonNull()) {

			BeneficiaryVisitDetail benVisitDetailsOBJ = InputMapper.gson().fromJson(visitDetailsOBJ.get("visitDetails"),
					BeneficiaryVisitDetail.class);
			benVisitID = commonNurseServiceImpl.saveBeneficiaryVisitDetails(benVisitDetailsOBJ);

			// benVisitID =
			// nurseServiceImpl.saveBeneficiaryVisitDetails(benVisitDetailsOBJ);

			if (benVisitID != null && benVisitID > 0) {
				if (visitDetailsOBJ.has("adherence") && !visitDetailsOBJ.get("adherence").isJsonNull()) {
					// Save Ben Adherence
					BenAdherence benAdherence = InputMapper.gson().fromJson(visitDetailsOBJ.get("adherence"),
							BenAdherence.class);
					benAdherence.setBenVisitID(benVisitID);
					adherenceSuccessFlag = commonNurseServiceImpl.saveBenAdherenceDetails(benAdherence);
				}
				if (visitDetailsOBJ.has("investigation") && !visitDetailsOBJ.get("investigation").isJsonNull()) {
					// Save Ben Investigations
					WrapperBenInvestigationANC wrapperBenInvestigationANC = InputMapper.gson()
							.fromJson(visitDetailsOBJ.get("investigation"), WrapperBenInvestigationANC.class);

					if (wrapperBenInvestigationANC != null) {
						wrapperBenInvestigationANC.setBenVisitID(benVisitID);
						investigationSuccessFlag = commonNurseServiceImpl
								.saveBenInvestigationDetails(wrapperBenInvestigationANC);

					} else {
						// Invalid Data..
					}
				}

				if (adherenceSuccessFlag > 0 && investigationSuccessFlag > 0) {
					// Adherence and Investigation Details stored successfully.
				}
			}
		}
		return benVisitID;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for visitDetails data saving
	 */
	public Long saveBenNCDCareHistoryDetails(JsonObject ncdCareHistoryOBJ, Long benVisitID) throws Exception {
		Long pastHistorySuccessFlag = null;
		Long comrbidSuccessFlag = null;
		Long medicationSuccessFlag = null;
		Long obstetricSuccessFlag = null;
		Integer menstrualHistorySuccessFlag = null;
		Long familyHistorySuccessFlag = null;
		Integer personalHistorySuccessFlag = null;
		Long allergyHistorySuccessFlag = null;
		Long childVaccineSuccessFlag = null;
		Long immunizationSuccessFlag = null;
		Long developmentHistorySuccessFlag = null;
		Long childFeedingSuccessFlag = null;
		Long perinatalHistorySuccessFlag = null;

		// Save past History
		if (ncdCareHistoryOBJ != null && ncdCareHistoryOBJ.has("pastHistory")
				&& !ncdCareHistoryOBJ.get("pastHistory").isJsonNull()) {
			BenMedHistory benMedHistory = InputMapper.gson().fromJson(ncdCareHistoryOBJ.get("pastHistory"),
					BenMedHistory.class);
			if (null != benMedHistory) {
				benMedHistory.setBenVisitID(benVisitID);
				pastHistorySuccessFlag = commonNurseServiceImpl.saveBenPastHistory(benMedHistory);
			}

		} else {
			pastHistorySuccessFlag = new Long(1);
		}

		// Save Comorbidity/concurrent Conditions
		if (ncdCareHistoryOBJ != null && ncdCareHistoryOBJ.has("comorbidConditions")
				&& !ncdCareHistoryOBJ.get("comorbidConditions").isJsonNull()) {
			WrapperComorbidCondDetails wrapperComorbidCondDetails = InputMapper.gson()
					.fromJson(ncdCareHistoryOBJ.get("comorbidConditions"), WrapperComorbidCondDetails.class);
			if (null != wrapperComorbidCondDetails) {
				wrapperComorbidCondDetails.setBenVisitID(benVisitID);
				comrbidSuccessFlag = commonNurseServiceImpl.saveBenComorbidConditions(wrapperComorbidCondDetails);
			}
		} else {
			comrbidSuccessFlag = new Long(1);
		}

		// Save Medication History
		if (ncdCareHistoryOBJ != null && ncdCareHistoryOBJ.has("medicationHistory")
				&& !ncdCareHistoryOBJ.get("medicationHistory").isJsonNull()) {
			WrapperMedicationHistory wrapperMedicationHistory = InputMapper.gson()
					.fromJson(ncdCareHistoryOBJ.get("medicationHistory"), WrapperMedicationHistory.class);
			if (null != wrapperMedicationHistory
					&& wrapperMedicationHistory.getBenMedicationHistoryDetails().size() > 0) {
				wrapperMedicationHistory.setBenVisitID(benVisitID);
				medicationSuccessFlag = commonNurseServiceImpl.saveBenMedicationHistory(wrapperMedicationHistory);
			} else {
				medicationSuccessFlag = new Long(1);
			}

		} else {
			medicationSuccessFlag = new Long(1);
		}

		// Save Past Obstetric History
		if (ncdCareHistoryOBJ != null && ncdCareHistoryOBJ.has("femaleObstetricHistory")
				&& !ncdCareHistoryOBJ.get("femaleObstetricHistory").isJsonNull()) {
			WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory = InputMapper.gson()
					.fromJson(ncdCareHistoryOBJ.get("femaleObstetricHistory"), WrapperFemaleObstetricHistory.class);

			if (wrapperFemaleObstetricHistory != null) {
				wrapperFemaleObstetricHistory.setBenVisitID(benVisitID);
				obstetricSuccessFlag = commonNurseServiceImpl.saveFemaleObstetricHistory(wrapperFemaleObstetricHistory);
			} else {
				// Female Obstetric Details not provided.
			}

		} else {
			obstetricSuccessFlag = new Long(1);
		}

		// Save Menstrual History
		if (ncdCareHistoryOBJ != null && ncdCareHistoryOBJ.has("menstrualHistory")
				&& !ncdCareHistoryOBJ.get("menstrualHistory").isJsonNull()) {
			BenMenstrualDetails menstrualDetails = InputMapper.gson()
					.fromJson(ncdCareHistoryOBJ.get("menstrualHistory"), BenMenstrualDetails.class);
			if (null != menstrualDetails) {
				menstrualDetails.setBenVisitID(benVisitID);
				menstrualHistorySuccessFlag = commonNurseServiceImpl.saveBenMenstrualHistory(menstrualDetails);
			}

		} else {
			menstrualHistorySuccessFlag = 1;
		}

		// Save Family History
		if (ncdCareHistoryOBJ != null && ncdCareHistoryOBJ.has("familyHistory")
				&& !ncdCareHistoryOBJ.get("familyHistory").isJsonNull()) {
			BenFamilyHistory benFamilyHistory = InputMapper.gson().fromJson(ncdCareHistoryOBJ.get("familyHistory"),
					BenFamilyHistory.class);
			if (null != benFamilyHistory) {
				benFamilyHistory.setBenVisitID(benVisitID);
				familyHistorySuccessFlag = commonNurseServiceImpl.saveBenFamilyHistory(benFamilyHistory);
			}
		} else {
			familyHistorySuccessFlag = new Long(1);
		}

		// Save Personal History
		if (ncdCareHistoryOBJ != null && ncdCareHistoryOBJ.has("personalHistory")
				&& !ncdCareHistoryOBJ.get("personalHistory").isJsonNull()) {
			// Save Ben Personal Habits..
			BenPersonalHabit personalHabit = InputMapper.gson().fromJson(ncdCareHistoryOBJ.get("personalHistory"),
					BenPersonalHabit.class);
			if (null != personalHabit) {
				personalHabit.setBenVisitID(benVisitID);
				personalHistorySuccessFlag = commonNurseServiceImpl.savePersonalHistory(personalHabit);
			}

			BenAllergyHistory benAllergyHistory = InputMapper.gson().fromJson(ncdCareHistoryOBJ.get("personalHistory"),
					BenAllergyHistory.class);
			if (null != benAllergyHistory) {
				benAllergyHistory.setBenVisitID(benVisitID);
				allergyHistorySuccessFlag = commonNurseServiceImpl.saveAllergyHistory(benAllergyHistory);
			}

		} else {
			personalHistorySuccessFlag = 1;
			allergyHistorySuccessFlag = new Long(1);
		}

		// Save Other/Optional Vaccines History
		if (ncdCareHistoryOBJ != null && ncdCareHistoryOBJ.has("childVaccineDetails")
				&& !ncdCareHistoryOBJ.get("childVaccineDetails").isJsonNull()) {
			WrapperChildOptionalVaccineDetail wrapperChildVaccineDetail = InputMapper.gson()
					.fromJson(ncdCareHistoryOBJ.get("childVaccineDetails"), WrapperChildOptionalVaccineDetail.class);
			if (null != wrapperChildVaccineDetail) {
				wrapperChildVaccineDetail.setBenVisitID(benVisitID);
				childVaccineSuccessFlag = commonNurseServiceImpl
						.saveChildOptionalVaccineDetail(wrapperChildVaccineDetail);
			} else {
				// Child Optional Vaccine Detail not provided.
			}

		} else {
			childVaccineSuccessFlag = new Long(1);
		}

		// Save Immunization History
		if (ncdCareHistoryOBJ != null && ncdCareHistoryOBJ.has("immunizationHistory")
				&& !ncdCareHistoryOBJ.get("immunizationHistory").isJsonNull()) {
			WrapperImmunizationHistory wrapperImmunizationHistory = InputMapper.gson()
					.fromJson(ncdCareHistoryOBJ.get("immunizationHistory"), WrapperImmunizationHistory.class);
			if (null != wrapperImmunizationHistory) {
				wrapperImmunizationHistory.setBenVisitID(benVisitID);
				immunizationSuccessFlag = commonNurseServiceImpl.saveImmunizationHistory(wrapperImmunizationHistory);
			} else {

				// ImmunizationList Data not Available
			}

		} else {
			immunizationSuccessFlag = new Long(1);
		}

		// Save Development History
		if (ncdCareHistoryOBJ != null && ncdCareHistoryOBJ.has("developmentHistory")
				&& !ncdCareHistoryOBJ.get("developmentHistory").isJsonNull()) {
			BenChildDevelopmentHistory benChildDevelopmentHistory = InputMapper.gson()
					.fromJson(ncdCareHistoryOBJ.get("developmentHistory"), BenChildDevelopmentHistory.class);

			if (null != benChildDevelopmentHistory) {
				benChildDevelopmentHistory.setBenVisitID(benVisitID);
				developmentHistorySuccessFlag = commonNurseServiceImpl
						.saveChildDevelopmentHistory(benChildDevelopmentHistory);
			}

		} else {
			developmentHistorySuccessFlag = new Long(1);
		}

		// Save Feeding History
		if (ncdCareHistoryOBJ != null && ncdCareHistoryOBJ.has("feedingHistory")
				&& !ncdCareHistoryOBJ.get("feedingHistory").isJsonNull()) {
			ChildFeedingDetails childFeedingDetails = InputMapper.gson()
					.fromJson(ncdCareHistoryOBJ.get("feedingHistory"), ChildFeedingDetails.class);

			if (null != childFeedingDetails) {
				childFeedingDetails.setBenVisitID(benVisitID);
				childFeedingSuccessFlag = commonNurseServiceImpl.saveChildFeedingHistory(childFeedingDetails);
			}

		}
		{
			childFeedingSuccessFlag = new Long(1);
		}

		// Save Perinatal Histroy
		if (ncdCareHistoryOBJ != null && ncdCareHistoryOBJ.has("perinatalHistroy")
				&& !ncdCareHistoryOBJ.get("perinatalHistroy").isJsonNull()) {
			PerinatalHistory perinatalHistory = InputMapper.gson().fromJson(ncdCareHistoryOBJ.get("perinatalHistroy"),
					PerinatalHistory.class);

			if (null != perinatalHistory) {
				perinatalHistory.setBenVisitID(benVisitID);
				perinatalHistorySuccessFlag = commonNurseServiceImpl.savePerinatalHistory(perinatalHistory);
			}

		}
		{
			perinatalHistorySuccessFlag = new Long(1);
		}

		Long historySaveSucccessFlag = null;

		if ((null != pastHistorySuccessFlag && pastHistorySuccessFlag > 0)
				&& (null != comrbidSuccessFlag && comrbidSuccessFlag > 0)
				&& (null != medicationSuccessFlag && medicationSuccessFlag > 0)
				&& (null != obstetricSuccessFlag && obstetricSuccessFlag > 0)
				&& (null != menstrualHistorySuccessFlag && menstrualHistorySuccessFlag > 0)
				&& (null != familyHistorySuccessFlag && familyHistorySuccessFlag > 0)
				&& (null != personalHistorySuccessFlag && personalHistorySuccessFlag > 0)
				&& (null != allergyHistorySuccessFlag && allergyHistorySuccessFlag > 0)
				&& (null != childVaccineSuccessFlag && childVaccineSuccessFlag > 0)
				&& (null != immunizationSuccessFlag && immunizationSuccessFlag > 0)
				&& (null != developmentHistorySuccessFlag && developmentHistorySuccessFlag > 0)
				&& (null != childFeedingSuccessFlag && childFeedingSuccessFlag > 0)
				&& (null != perinatalHistorySuccessFlag && perinatalHistorySuccessFlag > 0)) {

			historySaveSucccessFlag = pastHistorySuccessFlag;
		}
		return historySaveSucccessFlag;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for visitDetails data saving
	 */
	public Long saveBenNCDCareVitalDetails(JsonObject vitalDetailsOBJ, Long benVisitID) throws Exception {
		Long vitalSuccessFlag = null;
		Long anthropometrySuccessFlag = null;
		Long phyVitalSuccessFlag = null;
		// Save Physical Anthropometry && Physical Vital Details
		if (vitalDetailsOBJ != null) {
			BenAnthropometryDetail benAnthropometryDetail = InputMapper.gson().fromJson(vitalDetailsOBJ,
					BenAnthropometryDetail.class);
			BenPhysicalVitalDetail benPhysicalVitalDetail = InputMapper.gson().fromJson(vitalDetailsOBJ,
					BenPhysicalVitalDetail.class);

			if (null != benAnthropometryDetail) {
				benAnthropometryDetail.setBenVisitID(benVisitID);
				anthropometrySuccessFlag = commonNurseServiceImpl
						.saveBeneficiaryPhysicalAnthropometryDetails(benAnthropometryDetail);
			}
			if (null != benPhysicalVitalDetail) {
				benPhysicalVitalDetail.setBenVisitID(benVisitID);
				phyVitalSuccessFlag = commonNurseServiceImpl
						.saveBeneficiaryPhysicalVitalDetails(benPhysicalVitalDetail);
			}

			if (anthropometrySuccessFlag != null && anthropometrySuccessFlag > 0 && phyVitalSuccessFlag != null
					&& phyVitalSuccessFlag > 0) {
				vitalSuccessFlag = anthropometrySuccessFlag;
			}
		}

		return vitalSuccessFlag;
	}

	public String getBenVisitDetailsFrmNurseNCDCare(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		BeneficiaryVisitDetail visitDetail = commonNurseServiceImpl.getCSVisitDetails(benRegID, benVisitID);

		resMap.put("NCDCareNurseVisitDetail", new Gson().toJson(visitDetail));

		resMap.put("BenAdherence", commonNurseServiceImpl.getBenAdherence(benRegID, benVisitID));

		resMap.put("Investigation", commonNurseServiceImpl.getLabTestOrders(benRegID, benVisitID));

		return resMap.toString();
	}

	public String getBenNCDCareHistoryDetails(Long benRegID, Long benVisitID) {
		Map<String, Object> HistoryDetailsMap = new HashMap<String, Object>();

		HistoryDetailsMap.put("PastHistory", commonNurseServiceImpl.getPastHistoryData(benRegID, benVisitID));
		HistoryDetailsMap.put("ComorbidityConditions",
				commonNurseServiceImpl.getComorbidityConditionsHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("MedicationHistory", commonNurseServiceImpl.getMedicationHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("PersonalHistory", commonNurseServiceImpl.getPersonalHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("FamilyHistory", commonNurseServiceImpl.getFamilyHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("MenstrualHistory", commonNurseServiceImpl.getMenstrualHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("FemaleObstetricHistory",
				commonNurseServiceImpl.getFemaleObstetricHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("ImmunizationHistory",
				commonNurseServiceImpl.getImmunizationHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("childOptionalVaccineHistory",
				commonNurseServiceImpl.getChildOptionalVaccineHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("DevelopmentHistory", commonNurseServiceImpl.getDevelopmentHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("PerinatalHistory", commonNurseServiceImpl.getPerinatalHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("FeedingHistory", commonNurseServiceImpl.getFeedingHistory(benRegID, benVisitID));

		return new Gson().toJson(HistoryDetailsMap);
	}

	public String getBeneficiaryVitalDetails(Long beneficiaryRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		resMap.put("benAnthropometryDetail",
				commonNurseServiceImpl.getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID, benVisitID));
		resMap.put("benPhysicalVitalDetail",
				commonNurseServiceImpl.getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, benVisitID));

		return resMap.toString();
	}

	// ------- Fetch beneficiary all past history data ------------------
	public String getPastHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPastMedicalHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all past history data ----------

	// ------- Fetch beneficiary all Personal Tobacco history data-----------
	public String getPersonalTobaccoHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalTobaccoHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Personal Tobacco history data------

	// ------- Fetch beneficiary all Personal Alcohol history data -----------
	public String getPersonalAlcoholHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalAlcoholHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Personal Alcohol history data-----

	// ------- Fetch beneficiary all Personal Allergy history data -----------
	public String getPersonalAllergyHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalAllergyHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Personal Allergy history data------

	// ------- Fetch beneficiary all Medication history data -----------
	public String getMedicationHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalMedicationHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Medication history data --

	// ------- Fetch beneficiary all Family history data ---------------
	public String getFamilyHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalFamilyHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Family history data ------

	// ------- Fetch beneficiary all Menstrual history data -----------
	public String getMenstrualHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenMenstrualHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Menstrual history data --

	// ------- Fetch beneficiary all past obstetric history data ---------------
	public String getObstetricHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPastObstetricHistory(beneficiaryRegID);
	}

	/// ------- End of Fetch beneficiary all past obstetric history data ------

	// ------- Fetch beneficiary all Comorbid conditions history data----------
	public String getComorbidHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenComorbidityHistory(beneficiaryRegID);
	}
	/// -----End of Fetch beneficiary all Comorbid conditions history data ----

	// ------- Fetch beneficiary all Child Vaccine history data ---------------
	public String getChildVaccineHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenOptionalVaccineHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Child Vaccine history data ------

	// ------- Fetch beneficiary all Immunization history data ---------------
	public String getImmunizationHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenImmunizationHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Immunization history data ------

	// ------- Fetch beneficiary all Perinatal history data ---------------
	public String getBenPerinatalHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPerinatalHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Perinatal history data ------

	// ------- Fetch beneficiary all Feeding history data ---------------
	public String getBenFeedingHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenFeedingHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Feeding history data ------

	// ------- Fetch beneficiary all Development history data ---------------
	public String getBenDevelopmentHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenDevelopmentHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Development history data ------

	/// --------------- start of saving doctor data ------------------------
	@Transactional(rollbackFor = Exception.class)
	public Long saveDoctorData(JsonObject requestOBJ) throws Exception {
		Long saveSuccessFlag = null;
		Long prescriptionID = null;
		Long investigationSuccessFlag = null;
		Integer findingSuccessFlag = null;
		Integer prescriptionSuccessFlag = null;
		Long diagnosisSuccessFlag = null;
		Long referSaveSuccessFlag = null;

		String createdBy = null;
		Long bvID = null;

		if (requestOBJ != null) {

			JsonArray testList = null;
			JsonArray drugList = null;
			if (requestOBJ.has("investigation")) {
				testList = requestOBJ.getAsJsonObject("investigation").getAsJsonArray("laboratoryList");
			}
			if (requestOBJ.has("prescription")) {
				drugList = requestOBJ.getAsJsonObject("prescription").getAsJsonArray("prescribedDrugs");
			}

			if (requestOBJ.has("findings") && !requestOBJ.get("findings").isJsonNull()) {
				// findingSuccessFlag =
				// commonDoctorServiceImpl.saveFindings(requestOBJ.get("findings").getAsJsonObject());
				WrapperAncFindings wrapperAncFindings = InputMapper.gson().fromJson(requestOBJ.get("findings"),
						WrapperAncFindings.class);
				findingSuccessFlag = commonDoctorServiceImpl.saveDocFindings(wrapperAncFindings);

			} else {
				findingSuccessFlag = 1;
			}

			/*
			 * if (requestOBJ.has("refer") &&
			 * !requestOBJ.get("refer").isJsonNull()) { PrescriptionDetail
			 * prescriptionDetail =
			 * InputMapper.gson().fromJson(requestOBJ.get("refer"),
			 * PrescriptionDetail.class); // Save Prescription prescriptionID =
			 * commonNurseServiceImpl.saveBenPrescription(prescriptionDetail);
			 * }else{ //prescriptionID = 0; }
			 */

			if (requestOBJ.has("investigation") && !requestOBJ.get("investigation").isJsonNull()) {
				WrapperBenInvestigationANC wrapperBenInvestigationANC = InputMapper.gson()
						.fromJson(requestOBJ.get("investigation"), WrapperBenInvestigationANC.class);

				if (wrapperBenInvestigationANC != null
						&& ((wrapperBenInvestigationANC.getExternalInvestigations() != null
								&& wrapperBenInvestigationANC.getExternalInvestigations().length() > 0)
								|| (wrapperBenInvestigationANC.getLaboratoryList() != null
										&& wrapperBenInvestigationANC.getLaboratoryList().size() > 0))) {

					prescriptionID = commonNurseServiceImpl.savePrescriptionDetailsAndGetPrescriptionID(
							wrapperBenInvestigationANC.getBeneficiaryRegID(),
							wrapperBenInvestigationANC.getBenVisitID(),
							wrapperBenInvestigationANC.getProviderServiceMapID(),
							wrapperBenInvestigationANC.getCreatedBy(),
							wrapperBenInvestigationANC.getExternalInvestigations());

					// bvID = wrapperBenInvestigationANC.getBenVisitID();

					wrapperBenInvestigationANC.setPrescriptionID(prescriptionID);
					investigationSuccessFlag = commonNurseServiceImpl.saveBenInvestigation(wrapperBenInvestigationANC);
				}else{
					investigationSuccessFlag = new Long(1);
				}
			} else {
				investigationSuccessFlag = new Long(1);
			}

			if (requestOBJ.has("diagnosis") && !requestOBJ.get("diagnosis").isJsonNull()) {
				JsonObject diagnosisObj = requestOBJ.getAsJsonObject("diagnosis");
				NCDCareDiagnosis ncdDiagnosis = InputMapper.gson().fromJson(requestOBJ.get("diagnosis"),
						NCDCareDiagnosis.class);
				diagnosisSuccessFlag = ncdCareDoctorServiceImpl.saveNCDDiagnosisData(ncdDiagnosis);

			} else {
				diagnosisSuccessFlag = new Long(1);
			}

			if (requestOBJ.has("prescription") && !requestOBJ.get("prescription").isJsonNull()) {
				JsonObject tmpOBJ = requestOBJ.get("prescription").getAsJsonObject();
				if (null != tmpOBJ && tmpOBJ.has("prescribedDrugs") && !tmpOBJ.get("prescribedDrugs").isJsonNull()) {
					PrescribedDrugDetail[] prescribedDrugDetail = InputMapper.gson()
							.fromJson(tmpOBJ.get("prescribedDrugs"), PrescribedDrugDetail[].class);

					List<PrescribedDrugDetail> prescribedDrugDetailList = Arrays.asList(prescribedDrugDetail);

					if (prescribedDrugDetailList.size() > 0 && prescribedDrugDetailList.get(0).getDrug() != null) {
						if (prescriptionID == null) {
							prescriptionID = commonNurseServiceImpl.saveBeneficiaryPrescription(tmpOBJ);
						}
						for (PrescribedDrugDetail tmpObj : prescribedDrugDetailList) {
							tmpObj.setPrescriptionID(prescriptionID);
							// tmpObj.setCreatedBy(createdBy);
							if (tmpOBJ.has("beneficiaryRegID") && null != tmpOBJ.get("beneficiaryRegID"))
								tmpObj.setBeneficiaryRegID(tmpOBJ.get("beneficiaryRegID").getAsLong());
							if (tmpOBJ.has("benVisitID") && null != tmpOBJ.get("benVisitID"))
								tmpObj.setBenVisitID(tmpOBJ.get("benVisitID").getAsLong());
							if (tmpOBJ.has("createdBy") && null != tmpOBJ.get("createdBy"))
								tmpObj.setCreatedBy(tmpOBJ.get("createdBy").getAsString());

							Map<String, String> drug = tmpObj.getDrug();
							if (null != drug && drug.size() > 0 && drug.containsKey("drugID")
									&& drug.containsKey("drugDisplayName")) {
								tmpObj.setDrugID(Integer.parseInt(drug.get("drugID")));
								tmpObj.setGenericDrugName(drug.get("drugDisplayName"));
							}
						}
						Integer r = commonNurseServiceImpl.saveBenPrescribedDrugsList(prescribedDrugDetailList);
						if (r > 0 && r != null) {
							prescriptionSuccessFlag = r;
						}

					} else {
						prescriptionSuccessFlag = 1;
					}
				} else {
					prescriptionSuccessFlag = 1;
				}
			} else {
				prescriptionSuccessFlag = 1;
			}

			if (requestOBJ.has("refer") && !requestOBJ.get("refer").isJsonNull()) {
				referSaveSuccessFlag = commonDoctorServiceImpl
						.saveBenReferDetails(requestOBJ.get("refer").getAsJsonObject());
			} else {
				referSaveSuccessFlag = new Long(1);
			}

			if ((findingSuccessFlag != null && findingSuccessFlag > 0)
					&& (diagnosisSuccessFlag != null && diagnosisSuccessFlag > 0)
					&& (investigationSuccessFlag != null && investigationSuccessFlag > 0)
					&& (prescriptionSuccessFlag != null && prescriptionSuccessFlag > 0)
					&& (referSaveSuccessFlag != null && referSaveSuccessFlag > 0)) {

				// New code for ben fow logic
				short pharmaFalg;
				short docFlag;
				short labFalg;

				Long tmpBenFlowID = requestOBJ.get("benFlowID").getAsLong();
				Long tmpBeneficiaryID = requestOBJ.get("beneficiaryID").getAsLong();
				Long tmpBenVisitID = requestOBJ.getAsJsonObject("diagnosis").get("benVisitID").getAsLong();
				Long tmpbeneficiaryRegID = requestOBJ.getAsJsonObject("diagnosis").get("beneficiaryRegID").getAsLong();

				// new logic on 25-04-2018
				if (testList != null && !testList.isJsonNull() && testList.size() > 0) {
					docFlag = (short) 2;
				} else {
					docFlag = (short) 9;

				}

				if (drugList != null && !drugList.isJsonNull() && drugList.size() > 0) {
					JsonObject firstDrugDetails = drugList.get(0).getAsJsonObject();
					if (firstDrugDetails.get("drug") == null || firstDrugDetails.get("drug").isJsonNull())
						pharmaFalg = (short) 0;
					else
						pharmaFalg = (short) 1;
				} else {
					pharmaFalg = (short) 0;
				}

				// if (testList != null && !testList.isJsonNull() &&
				// testList.size() > 0 && drugList != null
				// && !drugList.isJsonNull() && drugList.size() > 0) {
				// if (drugList.get(0) != null && !drugList.get(0).isJsonNull())
				// {
				// JsonObject firstDrugDetails =
				// drugList.get(0).getAsJsonObject();
				// if (firstDrugDetails.get("drug") == null ||
				// firstDrugDetails.get("drug").isJsonNull()) {
				// // drug not prescribed
				// pharmaFalg = (short) 0;
				// } else {
				// pharmaFalg = (short) 1;
				// }
				//
				// } else {
				// pharmaFalg = (short) 0;
				// }
				//
				// docFlag = (short) 2;
				//
				// } else {
				// // either lab or drug or both no prescribed
				// if (drugList.get(0) != null && !drugList.get(0).isJsonNull())
				// {
				// JsonObject firstDrugDetails =
				// drugList.get(0).getAsJsonObject();
				// if (firstDrugDetails.get("drug") == null ||
				// firstDrugDetails.get("drug").isJsonNull()) {
				// // drug not prescribed
				// pharmaFalg = (short) 0;
				// } else {
				// pharmaFalg = (short) 1;
				// }
				//
				// } else {
				// pharmaFalg = (short) 0;
				// }
				//
				// docFlag = (short) 9;
				//
				// }

				int l = commonBenStatusFlowServiceImpl.updateBenFlowAfterDocData(tmpBenFlowID, tmpbeneficiaryRegID,
						tmpBeneficiaryID, tmpBenVisitID, docFlag, pharmaFalg, (short) 0);

				// End of new code

				//
				// String s =
				// commonNurseServiceImpl.updateBenVisitStatusFlag(bvID, "D");
				// if (s != null && s.length() > 0)
				saveSuccessFlag = investigationSuccessFlag;
			}
		} else {
			// request OBJ is null.
		}
		return saveSuccessFlag;
	}
	/// --------------- END of saving doctor data ------------------------

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for General OPD History updating by
	 *         Doctor
	 */
	@Transactional(rollbackFor = Exception.class)
	public int updateBenHistoryDetails(JsonObject historyOBJ) throws Exception {
		int pastHistorySuccessFlag = 0;
		int comrbidSuccessFlag = 0;
		int medicationSuccessFlag = 0;
		int personalHistorySuccessFlag = 0;
		int allergyHistorySuccessFlag = 0;
		int familyHistorySuccessFlag = 0;
		int menstrualHistorySuccessFlag = 0;
		int obstetricSuccessFlag = 0;
		int childVaccineSuccessFlag = 0;
		int childFeedingSuccessFlag = 0;
		int perinatalHistorySuccessFlag = 0;
		int developmentHistorySuccessFlag = 0;
		int immunizationSuccessFlag = 0;

		// Update Past History
		if (historyOBJ != null && historyOBJ.has("pastHistory") && !historyOBJ.get("pastHistory").isJsonNull()) {
			BenMedHistory benMedHistory = InputMapper.gson().fromJson(historyOBJ.get("pastHistory"),
					BenMedHistory.class);
			pastHistorySuccessFlag = commonNurseServiceImpl.updateBenPastHistoryDetails(benMedHistory);

		} else {
			pastHistorySuccessFlag = 1;
		}

		// Update Comorbidity/concurrent Conditions
		if (historyOBJ != null && historyOBJ.has("comorbidConditions")
				&& !historyOBJ.get("comorbidConditions").isJsonNull()) {
			WrapperComorbidCondDetails wrapperComorbidCondDetails = InputMapper.gson()
					.fromJson(historyOBJ.get("comorbidConditions"), WrapperComorbidCondDetails.class);
			comrbidSuccessFlag = commonNurseServiceImpl.updateBenComorbidConditions(wrapperComorbidCondDetails);
		} else {
			comrbidSuccessFlag = 1;
		}

		// Update Medication History
		if (historyOBJ != null && historyOBJ.has("medicationHistory")
				&& !historyOBJ.get("medicationHistory").isJsonNull()) {
			WrapperMedicationHistory wrapperMedicationHistory = InputMapper.gson()
					.fromJson(historyOBJ.get("medicationHistory"), WrapperMedicationHistory.class);
			medicationSuccessFlag = commonNurseServiceImpl.updateBenMedicationHistory(wrapperMedicationHistory);
		} else {
			medicationSuccessFlag = 1;
		}
		// Update Personal History
		if (historyOBJ != null && historyOBJ.has("personalHistory")
				&& !historyOBJ.get("personalHistory").isJsonNull()) {
			// Update Ben Personal Habits..
			BenPersonalHabit personalHabit = InputMapper.gson().fromJson(historyOBJ.get("personalHistory"),
					BenPersonalHabit.class);

			personalHistorySuccessFlag = commonNurseServiceImpl.updateBenPersonalHistory(personalHabit);

			// Update Ben Allergy History..
			BenAllergyHistory benAllergyHistory = InputMapper.gson().fromJson(historyOBJ.get("personalHistory"),
					BenAllergyHistory.class);
			allergyHistorySuccessFlag = commonNurseServiceImpl.updateBenAllergicHistory(benAllergyHistory);

		} else {
			allergyHistorySuccessFlag = 1;
			personalHistorySuccessFlag = 1;
		}

		// Update Family History
		if (historyOBJ != null && historyOBJ.has("familyHistory") && !historyOBJ.get("familyHistory").isJsonNull()) {
			BenFamilyHistory benFamilyHistory = InputMapper.gson().fromJson(historyOBJ.get("familyHistory"),
					BenFamilyHistory.class);
			familyHistorySuccessFlag = commonNurseServiceImpl.updateBenFamilyHistory(benFamilyHistory);
		} else {
			familyHistorySuccessFlag = 1;
		}

		// Update Menstrual History
		if (historyOBJ != null && historyOBJ.has("menstrualHistory")
				&& !historyOBJ.get("menstrualHistory").isJsonNull()) {
			BenMenstrualDetails menstrualDetails = InputMapper.gson().fromJson(historyOBJ.get("menstrualHistory"),
					BenMenstrualDetails.class);
			menstrualHistorySuccessFlag = commonNurseServiceImpl.updateMenstrualHistory(menstrualDetails);
		} else {
			menstrualHistorySuccessFlag = 1;
		}

		// Update Past Obstetric History
		if (historyOBJ != null && historyOBJ.has("femaleObstetricHistory")
				&& !historyOBJ.get("femaleObstetricHistory").isJsonNull()) {
			WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory = InputMapper.gson()
					.fromJson(historyOBJ.get("femaleObstetricHistory"), WrapperFemaleObstetricHistory.class);

			obstetricSuccessFlag = commonNurseServiceImpl.updatePastObstetricHistory(wrapperFemaleObstetricHistory);
		} else {
			obstetricSuccessFlag = 1;
		}

		if (historyOBJ != null && historyOBJ.has("immunizationHistory")
				&& !historyOBJ.get("immunizationHistory").isJsonNull()) {

			JsonObject immunizationHistory = historyOBJ.getAsJsonObject("immunizationHistory");
			if (immunizationHistory.get("immunizationList") != null
					&& immunizationHistory.getAsJsonArray("immunizationList").size() > 0) {
				WrapperImmunizationHistory wrapperImmunizationHistory = InputMapper.gson()
						.fromJson(historyOBJ.get("immunizationHistory"), WrapperImmunizationHistory.class);
				immunizationSuccessFlag = commonNurseServiceImpl
						.updateChildImmunizationDetail(wrapperImmunizationHistory);
			} else {
				immunizationSuccessFlag = 1;
			}
		} else {
			immunizationSuccessFlag = 1;
		}

		// Update Other/Optional Vaccines History
		if (historyOBJ != null && historyOBJ.has("childVaccineDetails")
				&& !historyOBJ.get("childVaccineDetails").isJsonNull()) {
			WrapperChildOptionalVaccineDetail wrapperChildVaccineDetail = InputMapper.gson()
					.fromJson(historyOBJ.get("childVaccineDetails"), WrapperChildOptionalVaccineDetail.class);
			childVaccineSuccessFlag = commonNurseServiceImpl
					.updateChildOptionalVaccineDetail(wrapperChildVaccineDetail);
		} else {
			childVaccineSuccessFlag = 1;
		}

		// Update ChildFeeding History
		if (historyOBJ != null && historyOBJ.has("feedingHistory") && !historyOBJ.get("feedingHistory").isJsonNull()) {
			ChildFeedingDetails childFeedingDetails = InputMapper.gson().fromJson(historyOBJ.get("feedingHistory"),
					ChildFeedingDetails.class);

			if (null != childFeedingDetails) {
				childFeedingSuccessFlag = commonNurseServiceImpl.updateChildFeedingHistory(childFeedingDetails);
			}

		} else {
			childFeedingSuccessFlag = 1;
		}

		// Update Perinatal History
		if (historyOBJ != null && historyOBJ.has("perinatalHistroy")
				&& !historyOBJ.get("perinatalHistroy").isJsonNull()) {
			PerinatalHistory perinatalHistory = InputMapper.gson().fromJson(historyOBJ.get("perinatalHistroy"),
					PerinatalHistory.class);

			if (null != perinatalHistory) {
				perinatalHistorySuccessFlag = commonNurseServiceImpl.updatePerinatalHistory(perinatalHistory);
			}

		} else {
			perinatalHistorySuccessFlag = 1;
		}

		// Update Development History
		if (historyOBJ != null && historyOBJ.has("developmentHistory")
				&& !historyOBJ.get("developmentHistory").isJsonNull()) {
			BenChildDevelopmentHistory benChildDevelopmentHistory = InputMapper.gson()
					.fromJson(historyOBJ.get("developmentHistory"), BenChildDevelopmentHistory.class);

			if (null != benChildDevelopmentHistory) {
				developmentHistorySuccessFlag = commonNurseServiceImpl
						.updateChildDevelopmentHistory(benChildDevelopmentHistory);
			}

		} else {
			developmentHistorySuccessFlag = 1;
		}

		int historyUpdateSuccessFlag = 0;

		if (pastHistorySuccessFlag > 0 && comrbidSuccessFlag > 0 && medicationSuccessFlag > 0
				&& allergyHistorySuccessFlag > 0 && familyHistorySuccessFlag > 0 && obstetricSuccessFlag > 0
				&& childVaccineSuccessFlag > 0 && personalHistorySuccessFlag > 0 && menstrualHistorySuccessFlag > 0
				&& immunizationSuccessFlag > 0 && childFeedingSuccessFlag > 0 && perinatalHistorySuccessFlag > 0
				&& developmentHistorySuccessFlag > 0) {

			historyUpdateSuccessFlag = pastHistorySuccessFlag;
		}
		return historyUpdateSuccessFlag;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for vitals data updating
	 */
	@Transactional(rollbackFor = Exception.class)
	public int updateBenVitalDetails(JsonObject vitalDetailsOBJ) throws Exception {
		int vitalSuccessFlag = 0;
		int anthropometrySuccessFlag = 0;
		int phyVitalSuccessFlag = 0;
		// Save Physical Anthropometry && Physical Vital Details
		if (vitalDetailsOBJ != null) {
			BenAnthropometryDetail benAnthropometryDetail = InputMapper.gson().fromJson(vitalDetailsOBJ,
					BenAnthropometryDetail.class);
			BenPhysicalVitalDetail benPhysicalVitalDetail = InputMapper.gson().fromJson(vitalDetailsOBJ,
					BenPhysicalVitalDetail.class);

			anthropometrySuccessFlag = commonNurseServiceImpl.updateANCAnthropometryDetails(benAnthropometryDetail);
			phyVitalSuccessFlag = commonNurseServiceImpl.updateANCPhysicalVitalDetails(benPhysicalVitalDetail);

			if (anthropometrySuccessFlag > 0 && phyVitalSuccessFlag > 0) {
				vitalSuccessFlag = anthropometrySuccessFlag;
			}
		} else {
			vitalSuccessFlag = 1;
		}

		return vitalSuccessFlag;
	}

	public String getBenCaseRecordFromDoctorNCDCare(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		resMap.put("findings", commonDoctorServiceImpl.getFindingsDetails(benRegID, benVisitID));

		resMap.put("diagnosis", ncdCareDoctorServiceImpl.getNCDCareDiagnosisDetails(benRegID, benVisitID));

		resMap.put("investigation", commonDoctorServiceImpl.getInvestigationDetails(benRegID, benVisitID));

		resMap.put("prescription", commonDoctorServiceImpl.getPrescribedDrugs(benRegID, benVisitID));

		resMap.put("Refer", commonDoctorServiceImpl.getReferralDetails(benRegID, benVisitID));

		return resMap.toString();
	}

	@Transactional(rollbackFor = Exception.class)
	public Long updateNCDCareDoctorData(JsonObject requestOBJ) throws Exception {
		Long updateSuccessFlag = null;
		Long prescriptionID = null;
		Long investigationSuccessFlag = null;
		Integer findingSuccessFlag = null;
		Integer diagnosisSuccessFlag = null;
		Integer prescriptionSuccessFlag = null;
		Long referSaveSuccessFlag = null;

		String createdBy = null;
		if (requestOBJ != null) {

			JsonArray testList = null;
			JsonArray drugList = null;
			if (requestOBJ.has("investigation")) {
				testList = requestOBJ.getAsJsonObject("investigation").getAsJsonArray("laboratoryList");
			}
			if (requestOBJ.has("prescription")) {
				drugList = requestOBJ.getAsJsonObject("prescription").getAsJsonArray("prescribedDrugs");
			}

			if (requestOBJ.has("findings") && !requestOBJ.get("findings").isJsonNull()) {

				WrapperAncFindings wrapperAncFindings = InputMapper.gson().fromJson(requestOBJ.get("findings"),
						WrapperAncFindings.class);
				findingSuccessFlag = commonDoctorServiceImpl.updateDocFindings(wrapperAncFindings);

			} else {
				findingSuccessFlag = 1;
			}

			// Fetch Benficiary details to check/create prescription existence
			if (requestOBJ.has("investigation") && !requestOBJ.get("investigation").isJsonNull()) {
				WrapperBenInvestigationANC wrapperBenInvestigationANC = InputMapper.gson()
						.fromJson(requestOBJ.get("investigation"), WrapperBenInvestigationANC.class);

				if (wrapperBenInvestigationANC != null
						&& ((wrapperBenInvestigationANC.getExternalInvestigations() != null
								&& wrapperBenInvestigationANC.getExternalInvestigations().length() > 0)
								|| (wrapperBenInvestigationANC.getLaboratoryList() != null
										&& wrapperBenInvestigationANC.getLaboratoryList().size() > 0))) {

					prescriptionID = commonNurseServiceImpl.savePrescriptionDetailsAndGetPrescriptionID(
							wrapperBenInvestigationANC.getBeneficiaryRegID(),
							wrapperBenInvestigationANC.getBenVisitID(),
							wrapperBenInvestigationANC.getProviderServiceMapID(),
							wrapperBenInvestigationANC.getCreatedBy(),
							wrapperBenInvestigationANC.getExternalInvestigations());

					// bvID = wrapperBenInvestigationANC.getBenVisitID();

					wrapperBenInvestigationANC.setPrescriptionID(prescriptionID);
					investigationSuccessFlag = commonNurseServiceImpl.saveBenInvestigation(wrapperBenInvestigationANC);
				}else{
					investigationSuccessFlag = new Long(1);
				}
			} else {
				investigationSuccessFlag = new Long(1);
			}

			if (requestOBJ.has("diagnosis") && !requestOBJ.get("diagnosis").isJsonNull()) {
				NCDCareDiagnosis ncdCareDiagnosis = InputMapper.gson().fromJson(requestOBJ.get("diagnosis"),
						NCDCareDiagnosis.class);
				diagnosisSuccessFlag = ncdCareDoctorServiceImpl.updateBenNCDCareDiagnosis(ncdCareDiagnosis, null);
			} else {
				diagnosisSuccessFlag = 1;
			}

			if (requestOBJ.has("prescription") && !requestOBJ.get("prescription").isJsonNull()) {
				JsonObject tmpOBJ = requestOBJ.get("prescription").getAsJsonObject();
				if (null != tmpOBJ && tmpOBJ.has("prescribedDrugs") && !tmpOBJ.get("prescribedDrugs").isJsonNull()) {
					PrescribedDrugDetail[] prescribedDrugDetail = InputMapper.gson()
							.fromJson(tmpOBJ.get("prescribedDrugs"), PrescribedDrugDetail[].class);

					List<PrescribedDrugDetail> prescribedDrugDetailList = Arrays.asList(prescribedDrugDetail);

					if (prescribedDrugDetailList.size() > 0 && prescribedDrugDetailList.get(0).getDrug() != null) {
						if (prescriptionID == null) {
							prescriptionID = commonNurseServiceImpl.saveBeneficiaryPrescription(tmpOBJ);
						}
						for (PrescribedDrugDetail tmpObj : prescribedDrugDetailList) {
							tmpObj.setPrescriptionID(prescriptionID);
							// tmpObj.setCreatedBy(createdBy);
							if (tmpOBJ.has("beneficiaryRegID") && null != tmpOBJ.get("beneficiaryRegID"))
								tmpObj.setBeneficiaryRegID(tmpOBJ.get("beneficiaryRegID").getAsLong());
							if (tmpOBJ.has("benVisitID") && null != tmpOBJ.get("benVisitID"))
								tmpObj.setBenVisitID(tmpOBJ.get("benVisitID").getAsLong());
							if (tmpOBJ.has("createdBy") && null != tmpOBJ.get("createdBy"))
								tmpObj.setCreatedBy(tmpOBJ.get("createdBy").getAsString());

							Map<String, String> drug = tmpObj.getDrug();
							if (null != drug && drug.size() > 0 && drug.containsKey("drugID")
									&& drug.containsKey("drugDisplayName")) {
								tmpObj.setDrugID(Integer.parseInt(drug.get("drugID")));
								tmpObj.setGenericDrugName(drug.get("drugDisplayName"));
							}
						}
						Integer r = commonNurseServiceImpl.saveBenPrescribedDrugsList(prescribedDrugDetailList);
						if (r > 0 && r != null) {
							prescriptionSuccessFlag = r;
						}

					} else {
						prescriptionSuccessFlag = 1;
					}
				} else {
					prescriptionSuccessFlag = 1;
				}
			} else {
				prescriptionSuccessFlag = 1;
			}

			if (requestOBJ.has("refer") && !requestOBJ.get("refer").isJsonNull()) {
				referSaveSuccessFlag = commonDoctorServiceImpl
						.updateBenReferDetails(requestOBJ.get("refer").getAsJsonObject());
			} else {
				referSaveSuccessFlag = new Long(1);
			}
			if ((findingSuccessFlag != null && findingSuccessFlag > 0)
					&& (diagnosisSuccessFlag != null && diagnosisSuccessFlag > 0)
					&& (investigationSuccessFlag != null && investigationSuccessFlag > 0)
					&& (prescriptionSuccessFlag != null && prescriptionSuccessFlag > 0)
					&& (referSaveSuccessFlag != null && referSaveSuccessFlag > 0)) {

				// New code for ben fow logic
				short pharmaFalg;
				short docFlag;
				short labFalg;

				Long tmpBenFlowID = requestOBJ.get("benFlowID").getAsLong();
				Long tmpBeneficiaryID = requestOBJ.get("beneficiaryID").getAsLong();
				Long tmpBenVisitID = requestOBJ.getAsJsonObject("diagnosis").get("benVisitID").getAsLong();
				Long tmpbeneficiaryRegID = requestOBJ.getAsJsonObject("diagnosis").get("beneficiaryRegID").getAsLong();

				// new logic on 25-04-2018
				if (testList != null && !testList.isJsonNull() && testList.size() > 0) {
					docFlag = (short) 2;
				} else {
					docFlag = (short) 9;

				}

				if (drugList != null && !drugList.isJsonNull() && drugList.size() > 0) {
					JsonObject firstDrugDetails = drugList.get(0).getAsJsonObject();
					if (firstDrugDetails.get("drug") == null || firstDrugDetails.get("drug").isJsonNull())
						pharmaFalg = (short) 0;
					else
						pharmaFalg = (short) 1;
				} else {
					pharmaFalg = (short) 0;
				}

				int l = commonBenStatusFlowServiceImpl.updateBenFlowAfterDocDataUpdate(tmpBenFlowID,
						tmpbeneficiaryRegID, tmpBeneficiaryID, tmpBenVisitID, docFlag, pharmaFalg, (short) 0);

				updateSuccessFlag = investigationSuccessFlag;
			}
		} else {
			// request OBJ is null.
		}
		return updateSuccessFlag;
	}
}
