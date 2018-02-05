package com.iemr.mmu.service.generalOPD;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.BenAllergyHistory;
import com.iemr.mmu.data.anc.BenChildDevelopmentHistory;
import com.iemr.mmu.data.anc.BenFamilyHistory;
import com.iemr.mmu.data.anc.BenMedHistory;
import com.iemr.mmu.data.anc.BenMenstrualDetails;
import com.iemr.mmu.data.anc.BenPersonalHabit;
import com.iemr.mmu.data.anc.ChildFeedingDetails;
import com.iemr.mmu.data.anc.PerinatalHistory;
import com.iemr.mmu.data.anc.PhyGeneralExamination;
import com.iemr.mmu.data.anc.PhyHeadToToeExamination;
import com.iemr.mmu.data.anc.SysCardiovascularExamination;
import com.iemr.mmu.data.anc.SysCentralNervousExamination;
import com.iemr.mmu.data.anc.SysGastrointestinalExamination;
import com.iemr.mmu.data.anc.SysGenitourinarySystemExamination;
import com.iemr.mmu.data.anc.SysMusculoskeletalSystemExamination;
import com.iemr.mmu.data.anc.SysRespiratoryExamination;
import com.iemr.mmu.data.anc.WrapperChildOptionalVaccineDetail;
import com.iemr.mmu.data.anc.WrapperComorbidCondDetails;
import com.iemr.mmu.data.anc.WrapperFemaleObstetricHistory;
import com.iemr.mmu.data.anc.WrapperImmunizationHistory;
import com.iemr.mmu.data.anc.WrapperMedicationHistory;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;

/***
 * 
 * @author NE298657
 *
 */
@Service
public class GeneralOPDServiceImpl implements GeneralOPDService {

	private CommonNurseServiceImpl commonNurseServiceImpl;
	private GeneralOPDNurseServiceImpl generalOPDNurseServiceImpl;

	@Autowired
	public void setGeneralOPDNurseServiceImpl(GeneralOPDNurseServiceImpl generalOPDNurseServiceImpl) {
		this.generalOPDNurseServiceImpl = generalOPDNurseServiceImpl;
	}

	@Autowired
	public void setCommonNurseServiceImpl(CommonNurseServiceImpl commonNurseServiceImpl) {
		this.commonNurseServiceImpl = commonNurseServiceImpl;
	}

	/// --------------- start of saving nurse data ------------------------
	@Override
	public Long saveNurseData(JsonObject requestOBJ) throws Exception {
		Long historySaveSuccessFlag = null;
		Long vitalSaveSuccessFlag = null;
		Long examtnSaveSuccessFlag = null;
		Long saveSuccessFlag = null;
		if (requestOBJ != null && requestOBJ.has("visitDetails") && !requestOBJ.get("visitDetails").isJsonNull()) {
			// Call method to save visit details data
			Long benVisitID = saveBenVisitDetails(requestOBJ.getAsJsonObject("visitDetails"));

			if (benVisitID != null && benVisitID > 0) {
				// call method to save History data
				historySaveSuccessFlag = saveBenGeneralOPDHistoryDetails(requestOBJ.getAsJsonObject("historyDetails"),
						benVisitID);

				// call method to save vital data
				vitalSaveSuccessFlag = saveBenVitalDetails(requestOBJ.getAsJsonObject("vitalDetails"), benVisitID);

				// call method to save examination data
				examtnSaveSuccessFlag = saveBenExaminationDetails(requestOBJ.getAsJsonObject("examinationDetails"),
						benVisitID);

				JsonObject tmpOBJ = requestOBJ.get("visitDetails").getAsJsonObject();
				JsonObject tmpOBJ1 = tmpOBJ.get("visitDetails").getAsJsonObject();

				int i = commonNurseServiceImpl.updateBeneficiaryStatus('N',
						tmpOBJ1.get("beneficiaryRegID").getAsLong());
			} else {
				// Beneficiary Visit ID not generated.
			}

			if ((null != historySaveSuccessFlag && historySaveSuccessFlag > 0)
					&& (null != vitalSaveSuccessFlag && vitalSaveSuccessFlag > 0)
					&& (null != examtnSaveSuccessFlag && examtnSaveSuccessFlag > 0)) {
				saveSuccessFlag = historySaveSuccessFlag;
			}
		} else {
			// Can't create benVisitID.
		}
		return saveSuccessFlag;
	}

	@Override
	public Long saveBenVisitDetails(JsonObject visitDetailsOBJ) throws Exception {
		Long benVisitID = null;
		if (visitDetailsOBJ != null && visitDetailsOBJ.has("visitDetails")
				&& !visitDetailsOBJ.get("visitDetails").isJsonNull()) {
			// Save Beneficiary visit details
			BeneficiaryVisitDetail benVisitDetailsOBJ = InputMapper.gson().fromJson(visitDetailsOBJ.get("visitDetails"),
					BeneficiaryVisitDetail.class);
			benVisitID = commonNurseServiceImpl.saveBeneficiaryVisitDetails(benVisitDetailsOBJ);

			if (benVisitID != null && benVisitID > 0) {
				if (visitDetailsOBJ.has("chiefComplaints") && !visitDetailsOBJ.get("chiefComplaints").isJsonNull()) {
					BenChiefComplaint[] benChiefComplaintArray = InputMapper.gson()
							.fromJson(visitDetailsOBJ.get("chiefComplaints"), BenChiefComplaint[].class);

					List<BenChiefComplaint> benChiefComplaintList = Arrays.asList(benChiefComplaintArray);
					if (null != benChiefComplaintList && benChiefComplaintList.size() > 0) {
						for (BenChiefComplaint benChiefComplaint : benChiefComplaintList) {
							benChiefComplaint.setBenVisitID(benVisitID);
						}
					}
					// Save Beneficiary Chief Complaints
					commonNurseServiceImpl.saveBenChiefComplaints(benChiefComplaintList);
				}
			}
		}
		return benVisitID;
	}

	@Override
	public Long saveBenGeneralOPDHistoryDetails(JsonObject generalOPDHistoryOBJ, Long benVisitID) throws Exception {
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
		if (generalOPDHistoryOBJ != null && generalOPDHistoryOBJ.has("pastHistory")
				&& !generalOPDHistoryOBJ.get("pastHistory").isJsonNull()) {
			BenMedHistory benMedHistory = InputMapper.gson().fromJson(generalOPDHistoryOBJ.get("pastHistory"),
					BenMedHistory.class);
			if (null != benMedHistory) {
				benMedHistory.setBenVisitID(benVisitID);
				pastHistorySuccessFlag = commonNurseServiceImpl.saveBenPastHistory(benMedHistory);
			}

		}

		// Save Comorbidity/concurrent Conditions
		if (generalOPDHistoryOBJ != null && generalOPDHistoryOBJ.has("comorbidConditions")
				&& !generalOPDHistoryOBJ.get("comorbidConditions").isJsonNull()) {
			WrapperComorbidCondDetails wrapperComorbidCondDetails = InputMapper.gson()
					.fromJson(generalOPDHistoryOBJ.get("comorbidConditions"), WrapperComorbidCondDetails.class);
			if (null != wrapperComorbidCondDetails) {
				wrapperComorbidCondDetails.setBenVisitID(benVisitID);
				comrbidSuccessFlag = commonNurseServiceImpl.saveBenComorbidConditions(wrapperComorbidCondDetails);
			}
		}

		// Save Medication History
		if (generalOPDHistoryOBJ != null && generalOPDHistoryOBJ.has("medicationHistory")
				&& !generalOPDHistoryOBJ.get("medicationHistory").isJsonNull()) {
			WrapperMedicationHistory wrapperMedicationHistory = InputMapper.gson()
					.fromJson(generalOPDHistoryOBJ.get("medicationHistory"), WrapperMedicationHistory.class);
			if (null != wrapperMedicationHistory) {
				wrapperMedicationHistory.setBenVisitID(benVisitID);
				medicationSuccessFlag = commonNurseServiceImpl.saveBenMedicationHistory(wrapperMedicationHistory);
			}

		}

		// Save Past Obstetric History
		if (generalOPDHistoryOBJ != null && generalOPDHistoryOBJ.has("femaleObstetricHistory")
				&& !generalOPDHistoryOBJ.get("femaleObstetricHistory").isJsonNull()) {
			WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory = InputMapper.gson()
					.fromJson(generalOPDHistoryOBJ.get("femaleObstetricHistory"), WrapperFemaleObstetricHistory.class);

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
		if (generalOPDHistoryOBJ != null && generalOPDHistoryOBJ.has("menstrualHistory")
				&& !generalOPDHistoryOBJ.get("menstrualHistory").isJsonNull()) {
			BenMenstrualDetails menstrualDetails = InputMapper.gson()
					.fromJson(generalOPDHistoryOBJ.get("menstrualHistory"), BenMenstrualDetails.class);
			if (null != menstrualDetails) {
				menstrualDetails.setBenVisitID(benVisitID);
				menstrualHistorySuccessFlag = commonNurseServiceImpl.saveBenMenstrualHistory(menstrualDetails);
			}

		}

		// Save Family History
		if (generalOPDHistoryOBJ != null && generalOPDHistoryOBJ.has("familyHistory")
				&& !generalOPDHistoryOBJ.get("familyHistory").isJsonNull()) {
			BenFamilyHistory benFamilyHistory = InputMapper.gson().fromJson(generalOPDHistoryOBJ.get("familyHistory"),
					BenFamilyHistory.class);
			if (null != benFamilyHistory) {
				benFamilyHistory.setBenVisitID(benVisitID);
				familyHistorySuccessFlag = commonNurseServiceImpl.saveBenFamilyHistory(benFamilyHistory);
			}
		}

		// Save Personal History
		if (generalOPDHistoryOBJ != null && generalOPDHistoryOBJ.has("personalHistory")
				&& !generalOPDHistoryOBJ.get("personalHistory").isJsonNull()) {
			// Save Ben Personal Habits..
			BenPersonalHabit personalHabit = InputMapper.gson().fromJson(generalOPDHistoryOBJ.get("personalHistory"),
					BenPersonalHabit.class);
			if (null != personalHabit) {
				personalHabit.setBenVisitID(benVisitID);
				personalHistorySuccessFlag = commonNurseServiceImpl.savePersonalHistory(personalHabit);
			}

			BenAllergyHistory benAllergyHistory = InputMapper.gson()
					.fromJson(generalOPDHistoryOBJ.get("personalHistory"), BenAllergyHistory.class);
			if (null != benAllergyHistory) {
				benAllergyHistory.setBenVisitID(benVisitID);
				allergyHistorySuccessFlag = commonNurseServiceImpl.saveAllergyHistory(benAllergyHistory);
			}

		}

		// Save Other/Optional Vaccines History
		if (generalOPDHistoryOBJ != null && generalOPDHistoryOBJ.has("childVaccineDetails")
				&& !generalOPDHistoryOBJ.get("childVaccineDetails").isJsonNull()) {
			WrapperChildOptionalVaccineDetail wrapperChildVaccineDetail = InputMapper.gson()
					.fromJson(generalOPDHistoryOBJ.get("childVaccineDetails"), WrapperChildOptionalVaccineDetail.class);
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
		if (generalOPDHistoryOBJ != null && generalOPDHistoryOBJ.has("immunizationHistory")
				&& !generalOPDHistoryOBJ.get("immunizationHistory").isJsonNull()) {
			WrapperImmunizationHistory wrapperImmunizationHistory = InputMapper.gson()
					.fromJson(generalOPDHistoryOBJ.get("immunizationHistory"), WrapperImmunizationHistory.class);
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
		if (generalOPDHistoryOBJ != null && generalOPDHistoryOBJ.has("developmentHistory")
				&& !generalOPDHistoryOBJ.get("developmentHistory").isJsonNull()) {
			BenChildDevelopmentHistory benChildDevelopmentHistory = InputMapper.gson()
					.fromJson(generalOPDHistoryOBJ.get("developmentHistory"), BenChildDevelopmentHistory.class);

			if (null != benChildDevelopmentHistory) {
				benChildDevelopmentHistory.setBenVisitID(benVisitID);
				developmentHistorySuccessFlag = generalOPDNurseServiceImpl
						.saveChildDevelopmentHistory(benChildDevelopmentHistory);
			}

		}

		// Save Feeding History
		if (generalOPDHistoryOBJ != null && generalOPDHistoryOBJ.has("feedingHistory")
				&& !generalOPDHistoryOBJ.get("feedingHistory").isJsonNull()) {
			ChildFeedingDetails childFeedingDetails = InputMapper.gson()
					.fromJson(generalOPDHistoryOBJ.get("feedingHistory"), ChildFeedingDetails.class);

			if (null != childFeedingDetails) {
				childFeedingDetails.setBenVisitID(benVisitID);
				childFeedingSuccessFlag = generalOPDNurseServiceImpl.saveChildFeedingHistory(childFeedingDetails);
			}

		}

		// Save Perinatal Histroy
		if (generalOPDHistoryOBJ != null && generalOPDHistoryOBJ.has("perinatalHistroy")
				&& !generalOPDHistoryOBJ.get("perinatalHistroy").isJsonNull()) {
			PerinatalHistory perinatalHistory = InputMapper.gson()
					.fromJson(generalOPDHistoryOBJ.get("perinatalHistroy"), PerinatalHistory.class);

			if (null != perinatalHistory) {
				perinatalHistory.setBenVisitID(benVisitID);
				perinatalHistorySuccessFlag = generalOPDNurseServiceImpl.savePerinatalHistory(perinatalHistory);
			}

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

	@Override
	public Long saveBenVitalDetails(JsonObject vitalDetailsOBJ, Long benVisitID) throws Exception {
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

	@Override
	public Long saveBenExaminationDetails(JsonObject examinationDetailsOBJ, Long benVisitID) throws Exception {

		Long genExmnSuccessFlag = null;
		Long headToToeExmnSuccessFlag = null;
		Long gastroIntsExmnSuccessFlag = null;
		Long cardiExmnSuccessFlag = null;
		Long respiratoryExmnSuccessFlag = null;
		Long centralNrvsExmnSuccessFlag = null;
		Long muskelstlExmnSuccessFlag = null;
		Long genitorinaryExmnSuccessFlag = null;

		// Save General Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("generalExamination")
				&& !examinationDetailsOBJ.get("generalExamination").isJsonNull()) {
			PhyGeneralExamination generalExamination = InputMapper.gson()
					.fromJson(examinationDetailsOBJ.get("generalExamination"), PhyGeneralExamination.class);
			if (null != generalExamination) {
				generalExamination.setBenVisitID(benVisitID);
				genExmnSuccessFlag = commonNurseServiceImpl.savePhyGeneralExamination(generalExamination);
			}

		}

		// Save Head to toe Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("headToToeExamination")
				&& !examinationDetailsOBJ.get("headToToeExamination").isJsonNull()) {
			PhyHeadToToeExamination headToToeExamination = InputMapper.gson()
					.fromJson(examinationDetailsOBJ.get("headToToeExamination"), PhyHeadToToeExamination.class);
			if (null != headToToeExamination) {
				headToToeExamination.setBenVisitID(benVisitID);
				headToToeExmnSuccessFlag = commonNurseServiceImpl.savePhyHeadToToeExamination(headToToeExamination);
			}

		}

		// Save Gastro Intestinal Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("gastroIntestinalExamination")
				&& !examinationDetailsOBJ.get("gastroIntestinalExamination").isJsonNull()) {
			SysGastrointestinalExamination gastrointestinalExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("gastroIntestinalExamination"), SysGastrointestinalExamination.class);
			if (null != gastrointestinalExamination) {
				gastrointestinalExamination.setBenVisitID(benVisitID);
				gastroIntsExmnSuccessFlag = commonNurseServiceImpl
						.saveSysGastrointestinalExamination(gastrointestinalExamination);

			}
		}

		// Save cardioVascular Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("cardioVascularExamination")
				&& !examinationDetailsOBJ.get("cardioVascularExamination").isJsonNull()) {
			SysCardiovascularExamination cardiovascularExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("cardioVascularExamination"), SysCardiovascularExamination.class);
			if (null != cardiovascularExamination) {
				cardiovascularExamination.setBenVisitID(benVisitID);
				cardiExmnSuccessFlag = commonNurseServiceImpl
						.saveSysCardiovascularExamination(cardiovascularExamination);

			}
		}

		// Save Respiratory Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("respiratorySystemExamination")
				&& !examinationDetailsOBJ.get("respiratorySystemExamination").isJsonNull()) {
			SysRespiratoryExamination sysRespiratoryExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("respiratorySystemExamination"), SysRespiratoryExamination.class);
			if (null != sysRespiratoryExamination) {
				sysRespiratoryExamination.setBenVisitID(benVisitID);
				respiratoryExmnSuccessFlag = commonNurseServiceImpl
						.saveSysRespiratoryExamination(sysRespiratoryExamination);
			}
		}

		// Save Central Nervous System Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("centralNervousSystemExamination")
				&& !examinationDetailsOBJ.get("centralNervousSystemExamination").isJsonNull()) {
			SysCentralNervousExamination sysCentralNervousExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("centralNervousSystemExamination"), SysCentralNervousExamination.class);
			if (null != sysCentralNervousExamination) {
				sysCentralNervousExamination.setBenVisitID(benVisitID);
				centralNrvsExmnSuccessFlag = commonNurseServiceImpl
						.saveSysCentralNervousExamination(sysCentralNervousExamination);
			}
		}

		// Save Musculoskeletal System Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("musculoskeletalSystemExamination")
				&& !examinationDetailsOBJ.get("musculoskeletalSystemExamination").isJsonNull()) {
			SysMusculoskeletalSystemExamination sysMusculoskeletalSystemExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("musculoskeletalSystemExamination"),
					SysMusculoskeletalSystemExamination.class);
			if (null != sysMusculoskeletalSystemExamination) {
				sysMusculoskeletalSystemExamination.setBenVisitID(benVisitID);
				muskelstlExmnSuccessFlag = commonNurseServiceImpl
						.saveSysMusculoskeletalSystemExamination(sysMusculoskeletalSystemExamination);

			}
		}

		// Save Genito Urinary System Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("genitoUrinarySystemExamination")
				&& !examinationDetailsOBJ.get("genitoUrinarySystemExamination").isJsonNull()) {
			SysGenitourinarySystemExamination sysGenitourinarySystemExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("genitoUrinarySystemExamination"),
					SysGenitourinarySystemExamination.class);
			if (null != sysGenitourinarySystemExamination) {
				sysGenitourinarySystemExamination.setBenVisitID(benVisitID);
				genitorinaryExmnSuccessFlag = commonNurseServiceImpl
						.saveSysGenitourinarySystemExamination(sysGenitourinarySystemExamination);

			}
		}

		Long exmnSuccessFlag = null;
		if ((null != genExmnSuccessFlag && genExmnSuccessFlag > 0)
				&& (null != headToToeExmnSuccessFlag && headToToeExmnSuccessFlag > 0)
				&& (null != gastroIntsExmnSuccessFlag && gastroIntsExmnSuccessFlag > 0)
				&& (null != cardiExmnSuccessFlag && cardiExmnSuccessFlag > 0)
				&& (null != respiratoryExmnSuccessFlag && respiratoryExmnSuccessFlag > 0)
				&& (null != centralNrvsExmnSuccessFlag && centralNrvsExmnSuccessFlag > 0)
				&& (null != muskelstlExmnSuccessFlag && muskelstlExmnSuccessFlag > 0)
				&& (null != genitorinaryExmnSuccessFlag && genitorinaryExmnSuccessFlag > 0)) {
			exmnSuccessFlag = genExmnSuccessFlag;
		}

		return exmnSuccessFlag;

	}
	/// --------------- End of saving nurse data ------------------------

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
}
