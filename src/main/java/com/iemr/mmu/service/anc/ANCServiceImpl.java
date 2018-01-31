package com.iemr.mmu.service.anc;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.BenAdherence;
import com.iemr.mmu.data.anc.BenAllergyHistory;
import com.iemr.mmu.data.anc.BenFamilyHistory;
import com.iemr.mmu.data.anc.BenMedHistory;
import com.iemr.mmu.data.anc.BenMenstrualDetails;
import com.iemr.mmu.data.anc.BenPersonalHabit;
import com.iemr.mmu.data.anc.PhyGeneralExamination;
import com.iemr.mmu.data.anc.PhyHeadToToeExamination;
import com.iemr.mmu.data.anc.SysCardiovascularExamination;
import com.iemr.mmu.data.anc.SysCentralNervousExamination;
import com.iemr.mmu.data.anc.SysGastrointestinalExamination;
import com.iemr.mmu.data.anc.SysGenitourinarySystemExamination;
import com.iemr.mmu.data.anc.SysMusculoskeletalSystemExamination;
import com.iemr.mmu.data.anc.SysObstetricExamination;
import com.iemr.mmu.data.anc.SysRespiratoryExamination;
import com.iemr.mmu.data.anc.WrapperAncImmunization;
import com.iemr.mmu.data.anc.WrapperBenInvestigationANC;
import com.iemr.mmu.data.anc.WrapperChildOptionalVaccineDetail;
import com.iemr.mmu.data.anc.WrapperComorbidCondDetails;
import com.iemr.mmu.data.anc.WrapperFemaleObstetricHistory;
import com.iemr.mmu.data.anc.WrapperImmunizationHistory;
import com.iemr.mmu.data.anc.WrapperMedicationHistory;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
public class ANCServiceImpl implements ANCService {

	private ANCNurseServiceImpl ancNurseServiceImpl;
	private NurseServiceImpl nurseServiceImpl;
	private ANCDoctorServiceImpl ancDoctorServiceImpl;

	@Autowired
	public void setANCDoctorServiceImpl(ANCDoctorServiceImpl ancDoctorServiceImpl) {
		this.ancDoctorServiceImpl = ancDoctorServiceImpl;
	}

	@Autowired
	public void setAncNurseServiceImpl(ANCNurseServiceImpl ancNurseServiceImpl) {
		this.ancNurseServiceImpl = ancNurseServiceImpl;
	}

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	@Override
	public Long saveANCNurseData(JsonObject requestOBJ) throws Exception {
		Long saveSuccessFlag = null;
		// check if visit details data is not null
		if (requestOBJ != null && requestOBJ.has("visitDetails") && !requestOBJ.get("visitDetails").isJsonNull()) {
			// Call method to save visit details data
			Long benVisitID = saveBenVisitDetails(requestOBJ.getAsJsonObject("visitDetails"));
			// check if visit details data saved successfully

			Long ancSaveSuccessFlag = null;
			Long historySaveSuccessFlag = null;
			Long vitalSaveSuccessFlag = null;
			Long examtnSaveSuccessFlag = null;
			Integer i = null;
			if (benVisitID != null && benVisitID > 0) {
				// call method to save ANC data
				ancSaveSuccessFlag = saveBenANCDetails(requestOBJ.getAsJsonObject("ancDetails"), benVisitID);
				// call method to save History data
				historySaveSuccessFlag = saveBenANCHistoryDetails(requestOBJ.getAsJsonObject("historyDetails"),
						benVisitID);
				// call method to save Vital data
				vitalSaveSuccessFlag = saveBenANCVitalDetails(requestOBJ.getAsJsonObject("vitalDetails"), benVisitID);
				// call method to save Examination data
				examtnSaveSuccessFlag = saveBenANCExaminationDetails(requestOBJ.getAsJsonObject("examinationDetails"),
						benVisitID);

				JsonObject tmpOBJ = requestOBJ.get("visitDetails").getAsJsonObject();
				JsonObject tmpOBJ1 = tmpOBJ.get("visitDetails").getAsJsonObject();

				i = nurseServiceImpl.updateBeneficiaryStatus('N', tmpOBJ1.get("beneficiaryRegID").getAsLong());
			} else {
				// Error in visit details saving or it is null
			}
			if ((null != ancSaveSuccessFlag && ancSaveSuccessFlag > 0)
					&& (null != historySaveSuccessFlag && historySaveSuccessFlag > 0)
					&& (null != vitalSaveSuccessFlag && vitalSaveSuccessFlag > 0)
					&& (null != examtnSaveSuccessFlag && examtnSaveSuccessFlag > 0) && (i != null)) {
				saveSuccessFlag = ancSaveSuccessFlag;
			}
		} else {
			// Can't create BenVisitID
		}
		return saveSuccessFlag;
	}

	public Long saveANCDoctorData(JsonObject requestOBJ) throws Exception {
		Long saveSuccessFlag = null;
		Long prescriptionID = null;
		Long investigationSuccessFlag = null;
		Integer findingSuccessFlag = null;
		Long diagnosisSuccessFlag = null;
		Integer prescriptionSuccessFlag = null;

		String createdBy = null;
		Long bvID = null;

		if (requestOBJ != null) {
			if (requestOBJ.has("findings") && !requestOBJ.get("findings").isJsonNull()) {
				findingSuccessFlag = ancDoctorServiceImpl.saveANCFindings(requestOBJ.get("findings").getAsJsonObject());

			} else {
			}
			if (requestOBJ.has("diagnosis") && !requestOBJ.get("diagnosis").isJsonNull()) {
				diagnosisSuccessFlag = ancDoctorServiceImpl
						.saveBenANCDiagnosis(requestOBJ.get("diagnosis").getAsJsonObject());
			} else {
			}

			if (requestOBJ.has("investigation") && !requestOBJ.get("investigation").isJsonNull()) {
				WrapperBenInvestigationANC wrapperBenInvestigationANC = InputMapper.gson()
						.fromJson(requestOBJ.get("investigation"), WrapperBenInvestigationANC.class);

				if (wrapperBenInvestigationANC != null) {
					prescriptionID = ancNurseServiceImpl.savePrescriptionDetailsAndGetPrescriptionID(
							wrapperBenInvestigationANC.getBeneficiaryRegID(),
							wrapperBenInvestigationANC.getBenVisitID(),
							wrapperBenInvestigationANC.getProviderServiceMapID(),
							wrapperBenInvestigationANC.getCreatedBy());

					createdBy = wrapperBenInvestigationANC.getCreatedBy();
					bvID = wrapperBenInvestigationANC.getBenVisitID();

					wrapperBenInvestigationANC.setPrescriptionID(prescriptionID);
					investigationSuccessFlag = nurseServiceImpl.saveBenInvestigation(wrapperBenInvestigationANC);
				}
			} else {
			}
			if (requestOBJ.has("prescription") && !requestOBJ.get("prescription").isJsonNull()) {
				JsonObject tmpOBJ = requestOBJ.get("prescription").getAsJsonObject();
				if (tmpOBJ.has("prescribedDrugs") && !tmpOBJ.get("prescribedDrugs").isJsonNull()) {
					PrescribedDrugDetail[] prescribedDrugDetail = InputMapper.gson()
							.fromJson(tmpOBJ.get("prescribedDrugs"), PrescribedDrugDetail[].class);

					List<PrescribedDrugDetail> prescribedDrugDetailList = Arrays.asList(prescribedDrugDetail);

					if (prescribedDrugDetailList.size() > 0) {
						for (PrescribedDrugDetail tmpObj : prescribedDrugDetailList) {
							tmpObj.setPrescriptionID(prescriptionID);
							tmpObj.setCreatedBy(createdBy);

						}
						Integer r = nurseServiceImpl.saveBenPrescribedDrugsList(prescribedDrugDetailList);
						if (r > 0 && r != null) {
							prescriptionSuccessFlag = r;
						}

					} else {
						prescriptionSuccessFlag = 1;
					}
				}
			} else {
			}

			if ((findingSuccessFlag != null && findingSuccessFlag > 0)
					&& (diagnosisSuccessFlag != null && diagnosisSuccessFlag > 0)
					&& (investigationSuccessFlag != null && investigationSuccessFlag > 0)
					&& (prescriptionSuccessFlag != null && prescriptionSuccessFlag > 0)) {

				String s = ancDoctorServiceImpl.updateBenVisitStatusFlag(bvID, "D");
				if (s != null && s.length() > 0)
					saveSuccessFlag = diagnosisSuccessFlag;
			}
		} else {
			// request OBJ is null.
		}
		return saveSuccessFlag;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for visitDetails data saving
	 */
	public Long saveBenVisitDetails(JsonObject visitDetailsOBJ) throws Exception {
		Long benVisitID = null;
		if (visitDetailsOBJ != null && visitDetailsOBJ.has("visitDetails")
				&& !visitDetailsOBJ.get("visitDetails").isJsonNull()) {

			BeneficiaryVisitDetail benVisitDetailsOBJ = InputMapper.gson().fromJson(visitDetailsOBJ.get("visitDetails"),
					BeneficiaryVisitDetail.class);
			benVisitID = nurseServiceImpl.saveBeneficiaryVisitDetails(benVisitDetailsOBJ);

			if (benVisitID != null && benVisitID > 0) {
				if (visitDetailsOBJ.has("chiefComplaints") && !visitDetailsOBJ.get("chiefComplaints").isJsonNull()) {
					// Save Ben Chief Complaints
					BenChiefComplaint[] benChiefComplaintArray = InputMapper.gson()
							.fromJson(visitDetailsOBJ.get("chiefComplaints"), BenChiefComplaint[].class);

					List<BenChiefComplaint> benChiefComplaintList = Arrays.asList(benChiefComplaintArray);
					if (null != benChiefComplaintList && benChiefComplaintList.size() > 0) {
						for (BenChiefComplaint benChiefComplaint : benChiefComplaintList) {
							benChiefComplaint.setBenVisitID(benVisitID);
						}
					}
					ancNurseServiceImpl.saveBenChiefComplaints(benChiefComplaintList);
				}
				if (visitDetailsOBJ.has("adherence") && !visitDetailsOBJ.get("adherence").isJsonNull()) {
					// Save Ben Adherence
					BenAdherence benAdherence = InputMapper.gson().fromJson(visitDetailsOBJ.get("adherence"),
							BenAdherence.class);
					benAdherence.setBenVisitID(benVisitID);
					int r = ancNurseServiceImpl.saveBenAdherenceDetails(benAdherence);
				}
				if (visitDetailsOBJ.has("investigation") && !visitDetailsOBJ.get("investigation").isJsonNull()) {
					// Save Ben Investigations
					WrapperBenInvestigationANC wrapperBenInvestigationANC = InputMapper.gson()
							.fromJson(visitDetailsOBJ.get("investigation"), WrapperBenInvestigationANC.class);

					if (wrapperBenInvestigationANC != null) {
						Long prescriptionID = ancNurseServiceImpl.savePrescriptionDetailsAndGetPrescriptionID(
								wrapperBenInvestigationANC.getBeneficiaryRegID(),
								wrapperBenInvestigationANC.getBenVisitID(),
								wrapperBenInvestigationANC.getProviderServiceMapID(),
								wrapperBenInvestigationANC.getCreatedBy());
						wrapperBenInvestigationANC.setBenVisitID(benVisitID);
						wrapperBenInvestigationANC.setPrescriptionID(prescriptionID);
						Long investigationSuccessFlag = nurseServiceImpl
								.saveBenInvestigation(wrapperBenInvestigationANC);
						if (investigationSuccessFlag != null && investigationSuccessFlag > 0) {
							// Investigation data saved successfully.
						} else {
							// Something went wrong !!!
						}
					} else {
						// Invalid Data..
					}
				}

				// TODO Save Ben Upload Files
			}
		}
		return benVisitID;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for visitDetails data saving
	 * @throws ParseException
	 */
	public Long saveBenANCDetails(JsonObject ancDetailsOBJ, Long benVisitID) throws Exception {
		Long ancSuccessFlag = null;
		Long ancCareSuccessFlag = null;
		Long ancImunizationSuccessFlag = null;
		if (ancDetailsOBJ != null && ancDetailsOBJ.has("ancObstetricDetails")
				&& !ancDetailsOBJ.get("ancObstetricDetails").isJsonNull()) {
			// Save Ben ANC Care Details
			ANCCareDetails ancCareDetailsOBJ = InputMapper.gson().fromJson(ancDetailsOBJ.get("ancObstetricDetails"),
					ANCCareDetails.class);
			if (null != ancCareDetailsOBJ) {
				ancCareDetailsOBJ.setBenVisitID(benVisitID);
				ancCareSuccessFlag = ancNurseServiceImpl.saveBenAncCareDetails(ancCareDetailsOBJ);

			}
		}
		if (ancDetailsOBJ != null && ancDetailsOBJ.has("ancImmunization")
				&& !ancDetailsOBJ.get("ancImmunization").isJsonNull()) {
			WrapperAncImmunization wrapperAncImmunizationOBJ = InputMapper.gson()
					.fromJson(ancDetailsOBJ.get("ancImmunization"), WrapperAncImmunization.class);
			if (null != wrapperAncImmunizationOBJ) {
				wrapperAncImmunizationOBJ.setBenVisitID(benVisitID);
				ancImunizationSuccessFlag = ancNurseServiceImpl.saveAncImmunizationDetails(wrapperAncImmunizationOBJ);
			}

		}
		if ((null != ancCareSuccessFlag && ancCareSuccessFlag > 0)
				&& (null != ancImunizationSuccessFlag && ancImunizationSuccessFlag > 0)) {
			ancSuccessFlag = ancCareSuccessFlag;
		}

		return ancSuccessFlag;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for visitDetails data saving
	 */
	public Long saveBenANCHistoryDetails(JsonObject ancHistoryOBJ, Long benVisitID) throws Exception {
		Long pastHistorySuccessFlag = null;
		Long comrbidSuccessFlag = null;
		Long medicationSuccessFlag = null;
		int personalHistorySuccessFlag = 0;
		Long allergyHistorySuccessFlag = null;
		Long familyHistorySuccessFlag = null;
		int menstrualHistorySuccessFlag = 0;
		Long obstetricSuccessFlag = null;
		Long immunizationSuccessFlag = null;
		Long childVaccineSuccessFlag = null;

		// Save Past History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("pastHistory")
				&& !ancHistoryOBJ.get("pastHistory").isJsonNull()) {
			BenMedHistory benMedHistory = InputMapper.gson().fromJson(ancHistoryOBJ.get("pastHistory"),
					BenMedHistory.class);
			if (null != benMedHistory) {
				benMedHistory.setBenVisitID(benVisitID);
				pastHistorySuccessFlag = ancNurseServiceImpl.saveBenANCPastHistory(benMedHistory);
			}

		}

		// Save Comorbidity/concurrent Conditions
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("comorbidConditions")
				&& !ancHistoryOBJ.get("comorbidConditions").isJsonNull()) {
			WrapperComorbidCondDetails wrapperComorbidCondDetails = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("comorbidConditions"), WrapperComorbidCondDetails.class);
			if (null != wrapperComorbidCondDetails) {
				wrapperComorbidCondDetails.setBenVisitID(benVisitID);
				comrbidSuccessFlag = ancNurseServiceImpl.saveBenANCComorbidConditions(wrapperComorbidCondDetails);
			}
		}

		// Save Medication History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("medicationHistory")
				&& !ancHistoryOBJ.get("medicationHistory").isJsonNull()) {
			WrapperMedicationHistory wrapperMedicationHistory = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("medicationHistory"), WrapperMedicationHistory.class);
			if (null != wrapperMedicationHistory) {
				wrapperMedicationHistory.setBenVisitID(benVisitID);
				medicationSuccessFlag = ancNurseServiceImpl.saveBenANCMedicationHistory(wrapperMedicationHistory);
			}

		}
		// Save Personal History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("personalHistory")
				&& !ancHistoryOBJ.get("personalHistory").isJsonNull()) {
			// Save Ben Personal Habits..
			BenPersonalHabit personalHabit = InputMapper.gson().fromJson(ancHistoryOBJ.get("personalHistory"),
					BenPersonalHabit.class);
			if (null != personalHabit) {
				personalHabit.setBenVisitID(benVisitID);
				personalHistorySuccessFlag = ancNurseServiceImpl.saveANCPersonalHistory(personalHabit);
			}

			BenAllergyHistory benAllergyHistory = InputMapper.gson().fromJson(ancHistoryOBJ.get("personalHistory"),
					BenAllergyHistory.class);
			if (null != benAllergyHistory) {
				benAllergyHistory.setBenVisitID(benVisitID);
				allergyHistorySuccessFlag = ancNurseServiceImpl.saveANCAllergyHistory(benAllergyHistory);
			}

		}

		// Save Family History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("familyHistory")
				&& !ancHistoryOBJ.get("familyHistory").isJsonNull()) {
			BenFamilyHistory benFamilyHistory = InputMapper.gson().fromJson(ancHistoryOBJ.get("familyHistory"),
					BenFamilyHistory.class);
			if (null != benFamilyHistory) {
				benFamilyHistory.setBenVisitID(benVisitID);
				familyHistorySuccessFlag = ancNurseServiceImpl.saveANCBenFamilyHistory(benFamilyHistory);
			}
		}

		// Save Menstrual History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("menstrualHistory")
				&& !ancHistoryOBJ.get("menstrualHistory").isJsonNull()) {
			BenMenstrualDetails menstrualDetails = InputMapper.gson().fromJson(ancHistoryOBJ.get("menstrualHistory"),
					BenMenstrualDetails.class);
			if (null != menstrualDetails) {
				menstrualDetails.setBenVisitID(benVisitID);
				menstrualHistorySuccessFlag = ancNurseServiceImpl.saveBenANCMenstrualHistory(menstrualDetails);
			}

		}

		// Save Past Obstetric History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("femaleObstetricHistory")
				&& !ancHistoryOBJ.get("femaleObstetricHistory").isJsonNull()) {
			WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("femaleObstetricHistory"), WrapperFemaleObstetricHistory.class);

			if (wrapperFemaleObstetricHistory != null) {
				wrapperFemaleObstetricHistory.setBenVisitID(benVisitID);
				obstetricSuccessFlag = ancNurseServiceImpl.saveFemaleObstetricHistory(wrapperFemaleObstetricHistory);
			} else {
				// Female Obstetric Details not provided.
			}

		} else {
			obstetricSuccessFlag = new Long(1);
		}

		/** For Female above 12 and below 16 years.. **/
		// Save Immunization History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("immunizationHistory")
				&& !ancHistoryOBJ.get("immunizationHistory").isJsonNull()) {
			WrapperImmunizationHistory wrapperImmunizationHistory = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("immunizationHistory"), WrapperImmunizationHistory.class);
			if (null != wrapperImmunizationHistory) {
				wrapperImmunizationHistory.setBenVisitID(benVisitID);
				immunizationSuccessFlag = ancNurseServiceImpl.saveANCImmunizationHistory(wrapperImmunizationHistory);
			} else {

				// ImmunizationList Data not Available
			}

		} else {
			immunizationSuccessFlag = new Long(1);
		}

		// Save Other/Optional Vaccines History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("childVaccineDetails")
				&& !ancHistoryOBJ.get("childVaccineDetails").isJsonNull()) {
			WrapperChildOptionalVaccineDetail wrapperChildVaccineDetail = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("childVaccineDetails"), WrapperChildOptionalVaccineDetail.class);
			if (null != wrapperChildVaccineDetail) {
				wrapperChildVaccineDetail.setBenVisitID(benVisitID);
				childVaccineSuccessFlag = ancNurseServiceImpl.saveChildOptionalVaccineDetail(wrapperChildVaccineDetail);
			} else {
				// Child Optional Vaccine Detail not provided.
			}

		} else {
			childVaccineSuccessFlag = new Long(1);
		}

		Long historySuccessFlag = null;

		if ((null != pastHistorySuccessFlag && pastHistorySuccessFlag > 0)
				&& (null != comrbidSuccessFlag && comrbidSuccessFlag > 0)
				&& (null != medicationSuccessFlag && medicationSuccessFlag > 0)
				&& (null != allergyHistorySuccessFlag && allergyHistorySuccessFlag > 0)
				&& (null != familyHistorySuccessFlag && familyHistorySuccessFlag > 0)
				&& (null != obstetricSuccessFlag && obstetricSuccessFlag > 0)
				&& (null != immunizationSuccessFlag && immunizationSuccessFlag > 0)
				&& (null != childVaccineSuccessFlag && childVaccineSuccessFlag > 0) && personalHistorySuccessFlag > 0
				&& menstrualHistorySuccessFlag > 0) {
			historySuccessFlag = pastHistorySuccessFlag;
		}
		return historySuccessFlag;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for visitDetails data saving
	 */
	public Long saveBenANCVitalDetails(JsonObject vitalDetailsOBJ, Long benVisitID) throws Exception {
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
				anthropometrySuccessFlag = nurseServiceImpl
						.saveBeneficiaryPhysicalAnthropometryDetails(benAnthropometryDetail);
			}
			if (null != benPhysicalVitalDetail) {
				benPhysicalVitalDetail.setBenVisitID(benVisitID);
				phyVitalSuccessFlag = nurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(benPhysicalVitalDetail);
			}

			if (anthropometrySuccessFlag != null && anthropometrySuccessFlag > 0 && phyVitalSuccessFlag != null
					&& phyVitalSuccessFlag > 0) {
				vitalSuccessFlag = anthropometrySuccessFlag;
			}
		}

		return vitalSuccessFlag;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for visitDetails data saving
	 */
	public Long saveBenANCExaminationDetails(JsonObject examinationDetailsOBJ, Long benVisitID) throws Exception {

		Long exmnSuccessFlag = null;

		Long genExmnSuccessFlag = null;
		Long headToToeExmnSuccessFlag = null;
		Long gastroIntsExmnSuccessFlag = null;
		Long cardiExmnSuccessFlag = null;
		Long respiratoryExmnSuccessFlag = null;
		Long centralNrvsExmnSuccessFlag = null;
		Long muskelstlExmnSuccessFlag = null;
		Long genitorinaryExmnSuccessFlag = null;
		Long obstetricExmnSuccessFlag = null;

		// Save General Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("generalExamination")
				&& !examinationDetailsOBJ.get("generalExamination").isJsonNull()) {
			PhyGeneralExamination generalExamination = InputMapper.gson()
					.fromJson(examinationDetailsOBJ.get("generalExamination"), PhyGeneralExamination.class);
			if (null != generalExamination) {
				generalExamination.setBenVisitID(benVisitID);
				genExmnSuccessFlag = ancNurseServiceImpl.savePhyGeneralExamination(generalExamination);
			}

		}

		// Save Head to toe Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("headToToeExamination")
				&& !examinationDetailsOBJ.get("headToToeExamination").isJsonNull()) {
			PhyHeadToToeExamination headToToeExamination = InputMapper.gson()
					.fromJson(examinationDetailsOBJ.get("headToToeExamination"), PhyHeadToToeExamination.class);
			if (null != headToToeExamination) {
				headToToeExamination.setBenVisitID(benVisitID);
				headToToeExmnSuccessFlag = ancNurseServiceImpl.savePhyHeadToToeExamination(headToToeExamination);
			}

		}
		// Save Gastro Intestinal Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("gastroIntestinalExamination")
				&& !examinationDetailsOBJ.get("gastroIntestinalExamination").isJsonNull()) {
			SysGastrointestinalExamination gastrointestinalExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("gastroIntestinalExamination"), SysGastrointestinalExamination.class);
			if (null != gastrointestinalExamination) {
				gastrointestinalExamination.setBenVisitID(benVisitID);
				gastroIntsExmnSuccessFlag = ancNurseServiceImpl
						.saveSysGastrointestinalExamination(gastrointestinalExamination);

			}
		}
		// Save Cardio Vascular Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("cardioVascularExamination")
				&& !examinationDetailsOBJ.get("cardioVascularExamination").isJsonNull()) {
			SysCardiovascularExamination cardiovascularExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("cardioVascularExamination"), SysCardiovascularExamination.class);
			if (null != cardiovascularExamination) {
				cardiovascularExamination.setBenVisitID(benVisitID);
				cardiExmnSuccessFlag = ancNurseServiceImpl.saveSysCardiovascularExamination(cardiovascularExamination);

			}
		}

		// Save Respiratory Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("respiratorySystemExamination")
				&& !examinationDetailsOBJ.get("respiratorySystemExamination").isJsonNull()) {
			SysRespiratoryExamination sysRespiratoryExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("respiratorySystemExamination"), SysRespiratoryExamination.class);
			if (null != sysRespiratoryExamination) {
				sysRespiratoryExamination.setBenVisitID(benVisitID);
				respiratoryExmnSuccessFlag = ancNurseServiceImpl
						.saveSysRespiratoryExamination(sysRespiratoryExamination);
			}
		}

		// Save Central Nervous Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("centralNervousSystemExamination")
				&& !examinationDetailsOBJ.get("centralNervousSystemExamination").isJsonNull()) {
			SysCentralNervousExamination sysCentralNervousExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("centralNervousSystemExamination"), SysCentralNervousExamination.class);
			if (null != sysCentralNervousExamination) {
				sysCentralNervousExamination.setBenVisitID(benVisitID);
				centralNrvsExmnSuccessFlag = ancNurseServiceImpl
						.saveSysCentralNervousExamination(sysCentralNervousExamination);
			}
		}

		// Save Muskeloskeletal Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("musculoskeletalSystemExamination")
				&& !examinationDetailsOBJ.get("musculoskeletalSystemExamination").isJsonNull()) {
			SysMusculoskeletalSystemExamination sysMusculoskeletalSystemExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("musculoskeletalSystemExamination"),
					SysMusculoskeletalSystemExamination.class);
			if (null != sysMusculoskeletalSystemExamination) {
				sysMusculoskeletalSystemExamination.setBenVisitID(benVisitID);
				muskelstlExmnSuccessFlag = ancNurseServiceImpl
						.saveSysMusculoskeletalSystemExamination(sysMusculoskeletalSystemExamination);

			}
		}

		// Save Genito Urinary Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("genitoUrinarySystemExamination")
				&& !examinationDetailsOBJ.get("genitoUrinarySystemExamination").isJsonNull()) {
			SysGenitourinarySystemExamination sysGenitourinarySystemExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("genitoUrinarySystemExamination"),
					SysGenitourinarySystemExamination.class);
			if (null != sysGenitourinarySystemExamination) {
				sysGenitourinarySystemExamination.setBenVisitID(benVisitID);
				genitorinaryExmnSuccessFlag = ancNurseServiceImpl
						.saveSysGenitourinarySystemExamination(sysGenitourinarySystemExamination);

			}
		}

		// Save Obstetric Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("obstetricExamination")
				&& !examinationDetailsOBJ.get("obstetricExamination").isJsonNull()) {
			SysObstetricExamination sysObstetricExamination = InputMapper.gson()
					.fromJson(examinationDetailsOBJ.get("obstetricExamination"), SysObstetricExamination.class);
			if (null != sysObstetricExamination) {
				sysObstetricExamination.setBenVisitID(benVisitID);
				obstetricExmnSuccessFlag = ancNurseServiceImpl.saveSysObstetricExamination(sysObstetricExamination);

			}
		}

		if ((null != genExmnSuccessFlag && genExmnSuccessFlag > 0)
				&& (null != headToToeExmnSuccessFlag && headToToeExmnSuccessFlag > 0)
				&& (null != gastroIntsExmnSuccessFlag && gastroIntsExmnSuccessFlag > 0)
				&& (null != cardiExmnSuccessFlag && cardiExmnSuccessFlag > 0)
				&& (null != respiratoryExmnSuccessFlag && respiratoryExmnSuccessFlag > 0)
				&& (null != centralNrvsExmnSuccessFlag && centralNrvsExmnSuccessFlag > 0)
				&& (null != muskelstlExmnSuccessFlag && muskelstlExmnSuccessFlag > 0)
				&& (null != genitorinaryExmnSuccessFlag && genitorinaryExmnSuccessFlag > 0)
				&& (null != obstetricExmnSuccessFlag && obstetricExmnSuccessFlag > 0)) {
			exmnSuccessFlag = genExmnSuccessFlag;
		}
		return exmnSuccessFlag;
	}

	// ----------Fetch ANC (Nurse) --------------------------------------

	@Override
	public String getBenVisitDetailsFrmNurseANC(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		resMap.put("ANCNurseVisitDetail", nurseServiceImpl.getCSVisitDetails(benRegID, benVisitID));

		resMap.put("BenAdherence", ancNurseServiceImpl.getBenAdherence(benRegID, benVisitID));

		resMap.put("BenChiefComplaints", ancNurseServiceImpl.getBenChiefComplaints(benRegID, benVisitID));

		resMap.put("LabTestOrders", ancNurseServiceImpl.getLabTestOrders(benRegID, benVisitID));

		return resMap.toString();
	}

	@Override
	public String getBenANCDetailsFrmNurseANC(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		resMap.put("ANCCareDetail", ancNurseServiceImpl.getANCCareDetails(benRegID, benVisitID));

		resMap.put("ANCWomenVaccineDetails", ancNurseServiceImpl.getANCWomenVaccineDetails(benRegID, benVisitID));

		return resMap.toString();
	}

	@Override
	public String getBenANCHistoryDetails(Long benRegID, Long benVisitID) {
		Map<String, Object> HistoryDetailsMap = new HashMap<String, Object>();

		HistoryDetailsMap.put("PastHistory", ancNurseServiceImpl.getPastHistoryData(benRegID, benVisitID));
		HistoryDetailsMap.put("ComorbidityConditions",
				ancNurseServiceImpl.getComorbidityConditionsHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("MedicationHistory", ancNurseServiceImpl.getMedicationHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("PersonalHistory", ancNurseServiceImpl.getPersonalHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("FamilyHistory", ancNurseServiceImpl.getFamilyHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("MenstrualHistory", ancNurseServiceImpl.getMenstrualHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("FemaleObstetricHistory",
				ancNurseServiceImpl.getFemaleObstetricHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("ImmunizationHistory", ancNurseServiceImpl.getImmunizationHistory(benRegID, benVisitID));
		HistoryDetailsMap.put("childOptionalVaccineHistory",
				ancNurseServiceImpl.getChildOptionalVaccineHistory(benRegID, benVisitID));

		return new Gson().toJson(HistoryDetailsMap);
	}

	@Override
	public String getBeneficiaryVitalDetails(Long beneficiaryRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		resMap.put("benAnthropometryDetail",
				nurseServiceImpl.getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID, benVisitID));
		resMap.put("benPhysicalVitalDetail",
				nurseServiceImpl.getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, benVisitID));

		return resMap.toString();
	}

	@Override
	public String getANCExaminationDetailsData(Long benRegID, Long benVisitID) {
		Map<String, Object> examinationDetailsMap = new HashMap<String, Object>();

		examinationDetailsMap.put("generalExamination",
				ancNurseServiceImpl.getGeneralExaminationData(benRegID, benVisitID));
		examinationDetailsMap.put("headToToeExamination",
				ancNurseServiceImpl.getHeadToToeExaminationData(benRegID, benVisitID));
		examinationDetailsMap.put("gastrointestinalExamination",
				ancNurseServiceImpl.getSysGastrointestinalExamination(benRegID, benVisitID));
		examinationDetailsMap.put("cardiovascularExamination",
				ancNurseServiceImpl.getCardiovascularExamination(benRegID, benVisitID));
		examinationDetailsMap.put("respiratoryExamination",
				ancNurseServiceImpl.getRespiratoryExamination(benRegID, benVisitID));
		examinationDetailsMap.put("centralNervousExamination",
				ancNurseServiceImpl.getSysCentralNervousExamination(benRegID, benVisitID));
		examinationDetailsMap.put("musculoskeletalExamination",
				ancNurseServiceImpl.getMusculoskeletalExamination(benRegID, benVisitID));
		examinationDetailsMap.put("genitourinaryExamination",
				ancNurseServiceImpl.getGenitourinaryExamination(benRegID, benVisitID));
		examinationDetailsMap.put("obstetricExamination",
				ancNurseServiceImpl.getSysObstetricExamination(benRegID, benVisitID));

		return new Gson().toJson(examinationDetailsMap);
	}

	// ---------- ENd of Fetch ANC (Nurse)--------------------------------------

	// ------- Fetch beneficiary all past history data ------------------
	public String getANCPastHistoryData(Long beneficiaryRegID) {
		return ancNurseServiceImpl.fetchBenPastMedicalHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all past history data ----------

	// ------- Fetch beneficiary all Comorbid conditions history data
	// ------------------
	public String getANCComorbidHistoryData(Long beneficiaryRegID) {
		return ancNurseServiceImpl.fetchBenComorbidityHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Comorbid conditions history data
	/// --------

	// ------- Fetch beneficiary all Medication history data -----------
	public String getANCMedicationHistoryData(Long beneficiaryRegID) {
		return ancNurseServiceImpl.fetchBenPersonalMedicationHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Medication history data --

	// ------- Fetch beneficiary all Personal Tobacco history data
	// ---------------
	public String getANCPersonalTobaccoHistoryData(Long beneficiaryRegID) {
		return ancNurseServiceImpl.fetchBenPersonalTobaccoHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Personal Tobacco history data
	/// ------

	// ------- Fetch beneficiary all Personal Alcohol history data
	// ---------------
	public String getANCPersonalAlcoholHistoryData(Long beneficiaryRegID) {
		return ancNurseServiceImpl.fetchBenPersonalAlcoholHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Personal Alcohol history data
	/// ------

	// ------- Fetch beneficiary all Personal Allergy history data
	// ---------------
	public String getANCPersonalAllergyHistoryData(Long beneficiaryRegID) {
		return ancNurseServiceImpl.fetchBenPersonalAllergyHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Personal Allergy history data
	/// ------

	// ------- Fetch beneficiary all Family history data ---------------
	public String getANCFamilyHistoryData(Long beneficiaryRegID) {
		return ancNurseServiceImpl.fetchBenPersonalFamilyHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Family history data ------

	// ------- Fetch beneficiary all Menstrual history data -----------
	public String getANCMenstrualHistoryData(Long beneficiaryRegID) {
		return ancNurseServiceImpl.fetchBenMenstrualHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Menstrual history data --

	// ------- Fetch beneficiary all past obstetric history data ---------------
	public String getANCObstetricHistoryData(Long beneficiaryRegID) {
		return ancNurseServiceImpl.fetchBenPastObstetricHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all past obstetric history data ------

	// ------- Fetch beneficiary all Immunization history data ---------------
	public String getANCImmunizationHistoryData(Long beneficiaryRegID) {
		return ancNurseServiceImpl.fetchBenImmunizationHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Immunization history data ------

	// ------- Fetch beneficiary all Child Vaccine history data ---------------
	public String getANCChildVaccineHistoryData(Long beneficiaryRegID) {
		return ancNurseServiceImpl.fetchBenOptionalVaccineHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Child Vaccine history data ------

	// -------Update (Nurse data from Doctor screen)----------------------

	@Override
	public int UpdateANCVisitDetails(JsonObject jsnOBJ) throws Exception {

		int visitDetailsUpdateRes = 0;
		int chiefCompltUpdateRes = 0;
		int adherenceUpdateRes = 0;
		Long investigationUpdateRes = null;

		if (jsnOBJ != null && jsnOBJ.has("visitDetails") && !jsnOBJ.get("visitDetails").isJsonNull()) {

			if (jsnOBJ.has("chiefComplaints") && !jsnOBJ.get("chiefComplaints").isJsonNull()) {
				// Update Ben Chief Complaints
				BenChiefComplaint[] benChiefComplaintArray = InputMapper.gson().fromJson(jsnOBJ.get("chiefComplaints"),
						BenChiefComplaint[].class);

				List<BenChiefComplaint> benChiefComplaintList = Arrays.asList(benChiefComplaintArray);

				chiefCompltUpdateRes = ancNurseServiceImpl.updateBenChiefComplaints(benChiefComplaintList);
			}
			if (jsnOBJ.has("adherence") && !jsnOBJ.get("adherence").isJsonNull()) {
				// Update Ben Adherence
				BenAdherence benAdherence = InputMapper.gson().fromJson(jsnOBJ.get("adherence"), BenAdherence.class);
				adherenceUpdateRes = ancNurseServiceImpl.updateBenAdherenceDetails(benAdherence);
			}
			if (jsnOBJ.has("investigation") && !jsnOBJ.get("investigation").isJsonNull()) {
				// Update Ben Investigations
				WrapperBenInvestigationANC wrapperBenInvestigationANC = InputMapper.gson()
						.fromJson(jsnOBJ.get("investigation"), WrapperBenInvestigationANC.class);

				investigationUpdateRes = ancNurseServiceImpl.updateBenInvestigation(wrapperBenInvestigationANC);
			}

		}
		if (chiefCompltUpdateRes > 0 && adherenceUpdateRes > 0
				&& (null != investigationUpdateRes && investigationUpdateRes > 0)) {
			visitDetailsUpdateRes = 1;
		}
		return visitDetailsUpdateRes;
	}

	/***
	 * 
	 * @param ancDetailsOBJ
	 * @param benVisitID
	 * @return success or failure flag for ANC update
	 * @throws Exception
	 */
	public int updateBenANCDetails(JsonObject ancDetailsOBJ) throws Exception {
		int ancSuccessFlag = 0;
		int ancCareSuccessFlag = 0;
		int ancImunizationSuccessFlag = 0;
		if (ancDetailsOBJ != null && ancDetailsOBJ.has("ancObstetricDetails")
				&& !ancDetailsOBJ.get("ancObstetricDetails").isJsonNull()) {
			// Update Ben ANC Care Details
			ANCCareDetails ancCareDetailsOBJ = InputMapper.gson().fromJson(ancDetailsOBJ.get("ancObstetricDetails"),
					ANCCareDetails.class);
			ancCareSuccessFlag = ancNurseServiceImpl.updateBenAncCareDetails(ancCareDetailsOBJ);
		}
		if (ancDetailsOBJ != null && ancDetailsOBJ.has("ancImmunization")
				&& !ancDetailsOBJ.get("ancImmunization").isJsonNull()) {
			WrapperAncImmunization wrapperAncImmunizationOBJ = InputMapper.gson()
					.fromJson(ancDetailsOBJ.get("ancImmunization"), WrapperAncImmunization.class);
			ancImunizationSuccessFlag = ancNurseServiceImpl.updateBenAncImmunizationDetails(wrapperAncImmunizationOBJ);

		}
		if (ancCareSuccessFlag > 0 && ancImunizationSuccessFlag > 0) {
			ancSuccessFlag = ancImunizationSuccessFlag;
		}

		return ancSuccessFlag;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for ANC History updating by Doctor
	 */
	public int updateBenANCHistoryDetails(JsonObject ancHistoryOBJ) throws Exception {
		int pastHistorySuccessFlag = 0;
		int comrbidSuccessFlag = 0;
		int medicationSuccessFlag = 0;
		int personalHistorySuccessFlag = 0;
		int allergyHistorySuccessFlag = 0;
		int familyHistorySuccessFlag = 0;
		int menstrualHistorySuccessFlag = 0;
		int obstetricSuccessFlag = 0;
		int immunizationSuccessFlag = 0;
		int childVaccineSuccessFlag = 0;

		// Update Past History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("pastHistory")
				&& !ancHistoryOBJ.get("pastHistory").isJsonNull()) {
			BenMedHistory benMedHistory = InputMapper.gson().fromJson(ancHistoryOBJ.get("pastHistory"),
					BenMedHistory.class);
			pastHistorySuccessFlag = ancNurseServiceImpl.updateBenAncPastHistoryDetails(benMedHistory);

		}

		// Update Comorbidity/concurrent Conditions
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("comorbidConditions")
				&& !ancHistoryOBJ.get("comorbidConditions").isJsonNull()) {
			WrapperComorbidCondDetails wrapperComorbidCondDetails = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("comorbidConditions"), WrapperComorbidCondDetails.class);
			comrbidSuccessFlag = ancNurseServiceImpl.updateBenANCComorbidConditions(wrapperComorbidCondDetails);
		}

		// Update Medication History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("medicationHistory")
				&& !ancHistoryOBJ.get("medicationHistory").isJsonNull()) {
			WrapperMedicationHistory wrapperMedicationHistory = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("medicationHistory"), WrapperMedicationHistory.class);
			medicationSuccessFlag = ancNurseServiceImpl.updateBenANCMedicationHistory(wrapperMedicationHistory);
		}
		// Update Personal History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("personalHistory")
				&& !ancHistoryOBJ.get("personalHistory").isJsonNull()) {
			// Update Ben Personal Habits..
			BenPersonalHabit personalHabit = InputMapper.gson().fromJson(ancHistoryOBJ.get("personalHistory"),
					BenPersonalHabit.class);

			personalHistorySuccessFlag = ancNurseServiceImpl.updateBenANCPersonalHistory(personalHabit);

			// Update Ben Allergy History..
			BenAllergyHistory benAllergyHistory = InputMapper.gson().fromJson(ancHistoryOBJ.get("personalHistory"),
					BenAllergyHistory.class);
			allergyHistorySuccessFlag = ancNurseServiceImpl.updateBenANCAllergicHistory(benAllergyHistory);

		}

		// Update Family History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("familyHistory")
				&& !ancHistoryOBJ.get("familyHistory").isJsonNull()) {
			BenFamilyHistory benFamilyHistory = InputMapper.gson().fromJson(ancHistoryOBJ.get("familyHistory"),
					BenFamilyHistory.class);
			familyHistorySuccessFlag = ancNurseServiceImpl.updateBenANCFamilyHistory(benFamilyHistory);
		}

		// Update Menstrual History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("menstrualHistory")
				&& !ancHistoryOBJ.get("menstrualHistory").isJsonNull()) {
			BenMenstrualDetails menstrualDetails = InputMapper.gson().fromJson(ancHistoryOBJ.get("menstrualHistory"),
					BenMenstrualDetails.class);
			menstrualHistorySuccessFlag = ancNurseServiceImpl.updateANCMenstrualHistory(menstrualDetails);
		}

		// Update Past Obstetric History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("femaleObstetricHistory")
				&& !ancHistoryOBJ.get("femaleObstetricHistory").isJsonNull()) {
			WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("femaleObstetricHistory"), WrapperFemaleObstetricHistory.class);

			obstetricSuccessFlag = ancNurseServiceImpl.updateANCPastObstetricHistory(wrapperFemaleObstetricHistory);
		}

		/** For Female above 12 yrs old and below 16 years old.. **/
		// Update Immunization History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("immunizationHistory")
				&& !ancHistoryOBJ.get("immunizationHistory").isJsonNull()) {
			WrapperImmunizationHistory wrapperImmunizationHistory = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("immunizationHistory"), WrapperImmunizationHistory.class);
			immunizationSuccessFlag = ancNurseServiceImpl.updateANCChildImmunizationDetail(wrapperImmunizationHistory);
		}else{
			immunizationSuccessFlag = 1;
		}
		// Update Other/Optional Vaccines History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("childVaccineDetails")
				&& !ancHistoryOBJ.get("childVaccineDetails").isJsonNull()) {
			WrapperChildOptionalVaccineDetail wrapperChildVaccineDetail = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("childVaccineDetails"), WrapperChildOptionalVaccineDetail.class);
			childVaccineSuccessFlag = ancNurseServiceImpl.updateChildOptionalVaccineDetail(wrapperChildVaccineDetail);
		} else {
			childVaccineSuccessFlag = 1;
		}

		int historyUpdateSuccessFlag = 0;

		if (pastHistorySuccessFlag > 0 && comrbidSuccessFlag > 0 && medicationSuccessFlag > 0
				&& allergyHistorySuccessFlag > 0 && familyHistorySuccessFlag > 0 && obstetricSuccessFlag > 0
				&& immunizationSuccessFlag > 0 && childVaccineSuccessFlag > 0 && personalHistorySuccessFlag > 0
				&& menstrualHistorySuccessFlag > 0) {

			historyUpdateSuccessFlag = pastHistorySuccessFlag;
		}
		return historyUpdateSuccessFlag;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for vitals data updating
	 */
	public int updateBenANCVitalDetails(JsonObject vitalDetailsOBJ) throws Exception {
		int vitalSuccessFlag = 0;
		int anthropometrySuccessFlag = 0;
		int phyVitalSuccessFlag = 0;
		// Save Physical Anthropometry && Physical Vital Details
		if (vitalDetailsOBJ != null) {
			BenAnthropometryDetail benAnthropometryDetail = InputMapper.gson().fromJson(vitalDetailsOBJ,
					BenAnthropometryDetail.class);
			BenPhysicalVitalDetail benPhysicalVitalDetail = InputMapper.gson().fromJson(vitalDetailsOBJ,
					BenPhysicalVitalDetail.class);

			anthropometrySuccessFlag = nurseServiceImpl.updateANCAnthropometryDetails(benAnthropometryDetail);
			phyVitalSuccessFlag = nurseServiceImpl.updateANCPhysicalVitalDetails(benPhysicalVitalDetail);

			if (anthropometrySuccessFlag > 0 && phyVitalSuccessFlag > 0) {
				vitalSuccessFlag = anthropometrySuccessFlag;
			}
		}

		return vitalSuccessFlag;
	}

	/**
	 * 
	 * @param requestOBJ
	 * @return success or failure flag for Examinationm data updating
	 */
	public int updateBenANCExaminationDetails(JsonObject examinationDetailsOBJ) throws Exception {

		int exmnSuccessFlag = 0;

		int genExmnSuccessFlag = 0;
		int headToToeExmnSuccessFlag = 0;
		int gastroIntsExmnSuccessFlag = 0;
		int cardiExmnSuccessFlag = 0;
		int respiratoryExmnSuccessFlag = 0;
		int centralNrvsExmnSuccessFlag = 0;
		int muskelstlExmnSuccessFlag = 0;
		int genitorinaryExmnSuccessFlag = 0;
		int obstetricExmnSuccessFlag = 0;

		// Save General Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("generalExamination")
				&& !examinationDetailsOBJ.get("generalExamination").isJsonNull()) {
			PhyGeneralExamination generalExamination = InputMapper.gson()
					.fromJson(examinationDetailsOBJ.get("generalExamination"), PhyGeneralExamination.class);
			genExmnSuccessFlag = ancNurseServiceImpl.updatePhyGeneralExamination(generalExamination);
		}

		// Save Head to toe Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("headToToeExamination")
				&& !examinationDetailsOBJ.get("headToToeExamination").isJsonNull()) {
			PhyHeadToToeExamination headToToeExamination = InputMapper.gson()
					.fromJson(examinationDetailsOBJ.get("headToToeExamination"), PhyHeadToToeExamination.class);
			headToToeExmnSuccessFlag = ancNurseServiceImpl.updatePhyHeadToToeExamination(headToToeExamination);
		}
		// Save Gastro Intestinal Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("gastroIntestinalExamination")
				&& !examinationDetailsOBJ.get("gastroIntestinalExamination").isJsonNull()) {
			SysGastrointestinalExamination gastrointestinalExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("gastroIntestinalExamination"), SysGastrointestinalExamination.class);
			gastroIntsExmnSuccessFlag = ancNurseServiceImpl
					.updateSysGastrointestinalExamination(gastrointestinalExamination);
		}
		// Save Cardio Vascular Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("cardioVascularExamination")
				&& !examinationDetailsOBJ.get("cardioVascularExamination").isJsonNull()) {
			SysCardiovascularExamination cardiovascularExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("cardioVascularExamination"), SysCardiovascularExamination.class);
			cardiExmnSuccessFlag = ancNurseServiceImpl.updateSysCardiovascularExamination(cardiovascularExamination);
		}

		// Save Respiratory Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("respiratorySystemExamination")
				&& !examinationDetailsOBJ.get("respiratorySystemExamination").isJsonNull()) {
			SysRespiratoryExamination sysRespiratoryExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("respiratorySystemExamination"), SysRespiratoryExamination.class);
			respiratoryExmnSuccessFlag = ancNurseServiceImpl.updateSysRespiratoryExamination(sysRespiratoryExamination);
		}

		// Save Central Nervous Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("centralNervousSystemExamination")
				&& !examinationDetailsOBJ.get("centralNervousSystemExamination").isJsonNull()) {
			SysCentralNervousExamination sysCentralNervousExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("centralNervousSystemExamination"), SysCentralNervousExamination.class);
			centralNrvsExmnSuccessFlag = ancNurseServiceImpl
					.updateSysCentralNervousExamination(sysCentralNervousExamination);
		}

		// Save Muskeloskeletal Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("musculoskeletalSystemExamination")
				&& !examinationDetailsOBJ.get("musculoskeletalSystemExamination").isJsonNull()) {
			SysMusculoskeletalSystemExamination sysMusculoskeletalSystemExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("musculoskeletalSystemExamination"),
					SysMusculoskeletalSystemExamination.class);
			muskelstlExmnSuccessFlag = ancNurseServiceImpl
					.updateSysMusculoskeletalSystemExamination(sysMusculoskeletalSystemExamination);
		}

		// Save Genito Urinary Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("genitoUrinarySystemExamination")
				&& !examinationDetailsOBJ.get("genitoUrinarySystemExamination").isJsonNull()) {
			SysGenitourinarySystemExamination sysGenitourinarySystemExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("genitoUrinarySystemExamination"),
					SysGenitourinarySystemExamination.class);
			genitorinaryExmnSuccessFlag = ancNurseServiceImpl
					.updateSysGenitourinarySystemExamination(sysGenitourinarySystemExamination);
		}

		// Save Obstetric Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("obstetricExamination")
				&& !examinationDetailsOBJ.get("obstetricExamination").isJsonNull()) {
			SysObstetricExamination sysObstetricExamination = InputMapper.gson()
					.fromJson(examinationDetailsOBJ.get("obstetricExamination"), SysObstetricExamination.class);
			obstetricExmnSuccessFlag = ancNurseServiceImpl.updateSysObstetricExamination(sysObstetricExamination);
		}

		if (genExmnSuccessFlag > 0 && headToToeExmnSuccessFlag > 0 && gastroIntsExmnSuccessFlag > 0
				&& cardiExmnSuccessFlag > 0 && respiratoryExmnSuccessFlag > 0 && centralNrvsExmnSuccessFlag > 0
				&& muskelstlExmnSuccessFlag > 0 && genitorinaryExmnSuccessFlag > 0 && obstetricExmnSuccessFlag > 0) {
			exmnSuccessFlag = genExmnSuccessFlag;
		}
		return exmnSuccessFlag;
	}

}
