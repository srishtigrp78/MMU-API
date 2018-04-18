package com.iemr.mmu.service.anc;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.ANCDiagnosis;
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
import com.iemr.mmu.data.anc.SysGenitourinarySystemExamination;
import com.iemr.mmu.data.anc.SysMusculoskeletalSystemExamination;
import com.iemr.mmu.data.anc.SysObstetricExamination;
import com.iemr.mmu.data.anc.SysRespiratoryExamination;
import com.iemr.mmu.data.anc.WrapperAncFindings;
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
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
public class ANCServiceImpl implements ANCService {

	private ANCNurseServiceImpl ancNurseServiceImpl;
	private NurseServiceImpl nurseServiceImpl;
	private ANCDoctorServiceImpl ancDoctorServiceImpl;
	private CommonNurseServiceImpl commonNurseServiceImpl;
	private CommonDoctorServiceImpl commonDoctorServiceImpl;
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;

	@Autowired
	public void setCommonBenStatusFlowServiceImpl(CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl) {
		this.commonBenStatusFlowServiceImpl = commonBenStatusFlowServiceImpl;
	}

	@Autowired
	public void setCommonDoctorServiceImpl(CommonDoctorServiceImpl commonDoctorServiceImpl) {
		this.commonDoctorServiceImpl = commonDoctorServiceImpl;
	}

	@Autowired
	public void setCommonNurseServiceImpl(CommonNurseServiceImpl commonNurseServiceImpl) {
		this.commonNurseServiceImpl = commonNurseServiceImpl;
	}

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
	@Transactional(rollbackFor = Exception.class)
	public Long saveANCNurseData(JsonObject requestOBJ) throws Exception {
		// String vr = "";
		// String vc = "";
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

			// code moved from inner code
			JsonObject tmpOBJ = requestOBJ.getAsJsonObject("visitDetails").getAsJsonObject("visitDetails");

			// Getting benflowID for ben status update
			Long benFlowID = null;
			if (requestOBJ.has("benFlowID")) {
				benFlowID = requestOBJ.get("benFlowID").getAsLong();
			}

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

				// Code moved above if statement
				// JsonObject tmpOBJ =
				// requestOBJ.getAsJsonObject("visitDetails").getAsJsonObject("visitDetails");
				// JsonObject tmpOBJ1 =
				// tmpOBJ.get("visitDetails").getAsJsonObject();

				i = commonNurseServiceImpl.updateBeneficiaryStatus('N', tmpOBJ.get("beneficiaryRegID").getAsLong());
			} else {
				// Error in visit details saving or it is null
			}
			if ((null != ancSaveSuccessFlag && ancSaveSuccessFlag > 0)
					&& (null != historySaveSuccessFlag && historySaveSuccessFlag > 0)
					&& (null != vitalSaveSuccessFlag && vitalSaveSuccessFlag > 0)
					&& (null != examtnSaveSuccessFlag && examtnSaveSuccessFlag > 0) && (i != null)) {

				saveSuccessFlag = ancSaveSuccessFlag;

				/**
				 * We have to write new code to update ben status flow new logic
				 */

				int J = updateBenFlowNurseAfterNurseActivityANC(
						requestOBJ.getAsJsonObject("visitDetails").getAsJsonObject("investigation"), tmpOBJ, benVisitID,
						benFlowID);

				// End of update ben status flow new logic

			}
		} else {
			// Can't create BenVisitID
		}
		return saveSuccessFlag;
	}

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
				tmpOBJ.get("visitCategory").getAsString(), nurseFlag, docFlag, labIteration);

		return rs;
	}

	@Transactional(rollbackFor = Exception.class)
	public Long saveANCDoctorData(JsonObject requestOBJ) throws Exception {
		Long saveSuccessFlag = null;
		Long prescriptionID = null;
		Long investigationSuccessFlag = null;
		Integer findingSuccessFlag = null;
		Long diagnosisSuccessFlag = null;
		Integer prescriptionSuccessFlag = null;
		Long referSaveSuccessFlag = null;

		String createdBy = null;
		Long bvID = null;

		if (requestOBJ != null) {
			if (requestOBJ.has("findings") && !requestOBJ.get("findings").isJsonNull()) {
				
				WrapperAncFindings wrapperAncFindings = InputMapper.gson().fromJson(requestOBJ.get("findings"), WrapperAncFindings.class);
				findingSuccessFlag = commonDoctorServiceImpl.saveDocFindings(wrapperAncFindings);
				// findingSuccessFlag =
				// ancDoctorServiceImpl.saveANCFindings(requestOBJ.get("findings").getAsJsonObject());

			} else {
			}

			if (requestOBJ.has("investigation") && !requestOBJ.get("investigation").isJsonNull()) {
				WrapperBenInvestigationANC wrapperBenInvestigationANC = InputMapper.gson()
						.fromJson(requestOBJ.get("investigation"), WrapperBenInvestigationANC.class);

				if (wrapperBenInvestigationANC != null) {
					prescriptionID = commonNurseServiceImpl.savePrescriptionDetailsAndGetPrescriptionID(
							wrapperBenInvestigationANC.getBeneficiaryRegID(),
							wrapperBenInvestigationANC.getBenVisitID(),
							wrapperBenInvestigationANC.getProviderServiceMapID(),
							wrapperBenInvestigationANC.getCreatedBy(),
							wrapperBenInvestigationANC.getExternalInvestigations());

					createdBy = wrapperBenInvestigationANC.getCreatedBy();
					bvID = wrapperBenInvestigationANC.getBenVisitID();

					wrapperBenInvestigationANC.setPrescriptionID(prescriptionID);
					investigationSuccessFlag = commonNurseServiceImpl.saveBenInvestigation(wrapperBenInvestigationANC);
				}
			} else {
			}
			
			if (requestOBJ.has("diagnosis") && !requestOBJ.get("diagnosis").isJsonNull()) {
				diagnosisSuccessFlag = ancDoctorServiceImpl
						.saveBenANCDiagnosis(requestOBJ.get("diagnosis").getAsJsonObject(), prescriptionID);
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
							Map<String, String> drug =tmpObj.getDrug();
							if(null != drug && drug.size()>0 && drug.containsKey("drugID") && drug.containsKey("drugDisplayName")){
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
				}
			} else {
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

				String s = commonNurseServiceImpl.updateBenVisitStatusFlag(bvID, "D");
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
		int investigationSuccessFlag = 0;
		int adherenceSuccessFlag = 0;
		int chiefComplaintsSuccessFlag = 0;
		if (visitDetailsOBJ != null && visitDetailsOBJ.has("visitDetails")
				&& !visitDetailsOBJ.get("visitDetails").isJsonNull()) {

			BeneficiaryVisitDetail benVisitDetailsOBJ = InputMapper.gson().fromJson(visitDetailsOBJ.get("visitDetails"),
					BeneficiaryVisitDetail.class);
			benVisitID = commonNurseServiceImpl.saveBeneficiaryVisitDetails(benVisitDetailsOBJ);

			// benVisitID =
			// nurseServiceImpl.saveBeneficiaryVisitDetails(benVisitDetailsOBJ);

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
					chiefComplaintsSuccessFlag = commonNurseServiceImpl.saveBenChiefComplaints(benChiefComplaintList);
				}
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
				if (adherenceSuccessFlag > 0 && chiefComplaintsSuccessFlag > 0 && investigationSuccessFlag > 0) {
					// Adherence, ChiefComplaints and Investigation Details
					// stored successfully.
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
	 * @return success or failure flag for history data saving
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
				pastHistorySuccessFlag = commonNurseServiceImpl.saveBenPastHistory(benMedHistory);
				// pastHistorySuccessFlag =
				// ancNurseServiceImpl.saveBenANCPastHistory(benMedHistory);
			}

		}

		// Save Comorbidity/concurrent Conditions
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("comorbidConditions")
				&& !ancHistoryOBJ.get("comorbidConditions").isJsonNull()) {
			WrapperComorbidCondDetails wrapperComorbidCondDetails = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("comorbidConditions"), WrapperComorbidCondDetails.class);
			if (null != wrapperComorbidCondDetails) {
				wrapperComorbidCondDetails.setBenVisitID(benVisitID);
				comrbidSuccessFlag = commonNurseServiceImpl.saveBenComorbidConditions(wrapperComorbidCondDetails);
				// comrbidSuccessFlag =
				// ancNurseServiceImpl.saveBenANCComorbidConditions(wrapperComorbidCondDetails);
			}
		}

		// Save Medication History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("medicationHistory")
				&& !ancHistoryOBJ.get("medicationHistory").isJsonNull()) {
			WrapperMedicationHistory wrapperMedicationHistory = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("medicationHistory"), WrapperMedicationHistory.class);
			if (null != wrapperMedicationHistory) {
				wrapperMedicationHistory.setBenVisitID(benVisitID);
				medicationSuccessFlag = commonNurseServiceImpl.saveBenMedicationHistory(wrapperMedicationHistory);

				// medicationSuccessFlag =
				// ancNurseServiceImpl.saveBenANCMedicationHistory(wrapperMedicationHistory);
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

				personalHistorySuccessFlag = commonNurseServiceImpl.savePersonalHistory(personalHabit);
				// personalHistorySuccessFlag =
				// ancNurseServiceImpl.saveANCPersonalHistory(personalHabit);
			}

			BenAllergyHistory benAllergyHistory = InputMapper.gson().fromJson(ancHistoryOBJ.get("personalHistory"),
					BenAllergyHistory.class);
			if (null != benAllergyHistory) {
				benAllergyHistory.setBenVisitID(benVisitID);

				allergyHistorySuccessFlag = commonNurseServiceImpl.saveAllergyHistory(benAllergyHistory);
				// allergyHistorySuccessFlag =
				// ancNurseServiceImpl.saveANCAllergyHistory(benAllergyHistory);
			}

		}

		// Save Family History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("familyHistory")
				&& !ancHistoryOBJ.get("familyHistory").isJsonNull()) {
			BenFamilyHistory benFamilyHistory = InputMapper.gson().fromJson(ancHistoryOBJ.get("familyHistory"),
					BenFamilyHistory.class);
			if (null != benFamilyHistory) {
				benFamilyHistory.setBenVisitID(benVisitID);
				familyHistorySuccessFlag = commonNurseServiceImpl.saveBenFamilyHistory(benFamilyHistory);
				// familyHistorySuccessFlag =
				// ancNurseServiceImpl.saveANCBenFamilyHistory(benFamilyHistory);
			}
		}

		// Save Menstrual History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("menstrualHistory")
				&& !ancHistoryOBJ.get("menstrualHistory").isJsonNull()) {
			BenMenstrualDetails menstrualDetails = InputMapper.gson().fromJson(ancHistoryOBJ.get("menstrualHistory"),
					BenMenstrualDetails.class);
			if (null != menstrualDetails) {
				menstrualDetails.setBenVisitID(benVisitID);
				menstrualHistorySuccessFlag = commonNurseServiceImpl.saveBenMenstrualHistory(menstrualDetails);
				// menstrualHistorySuccessFlag =
				// ancNurseServiceImpl.saveBenANCMenstrualHistory(menstrualDetails);
			}

		}

		// Save Past Obstetric History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("femaleObstetricHistory")
				&& !ancHistoryOBJ.get("femaleObstetricHistory").isJsonNull()) {
			WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("femaleObstetricHistory"), WrapperFemaleObstetricHistory.class);

			if (wrapperFemaleObstetricHistory != null) {
				wrapperFemaleObstetricHistory.setBenVisitID(benVisitID);
				obstetricSuccessFlag = commonNurseServiceImpl.saveFemaleObstetricHistory(wrapperFemaleObstetricHistory);
				// obstetricSuccessFlag =
				// ancNurseServiceImpl.saveFemaleObstetricHistory(wrapperFemaleObstetricHistory);
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
				immunizationSuccessFlag = commonNurseServiceImpl.saveImmunizationHistory(wrapperImmunizationHistory);
				// immunizationSuccessFlag =
				// ancNurseServiceImpl.saveANCImmunizationHistory(wrapperImmunizationHistory);
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
				childVaccineSuccessFlag = commonNurseServiceImpl
						.saveChildOptionalVaccineDetail(wrapperChildVaccineDetail);
				// childVaccineSuccessFlag =
				// ancNurseServiceImpl.saveChildOptionalVaccineDetail(wrapperChildVaccineDetail);
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
				genExmnSuccessFlag = commonNurseServiceImpl.savePhyGeneralExamination(generalExamination);
				// genExmnSuccessFlag =
				// ancNurseServiceImpl.savePhyGeneralExamination(generalExamination);
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
				// headToToeExmnSuccessFlag =
				// ancNurseServiceImpl.savePhyHeadToToeExamination(headToToeExamination);
			}

		}
		// Save Gastro Intestinal Examination Details
		/**
		 * Removed from anc. Only applicable for generalOPD. date: 07-02-2018
		 */
		/*
		 * if (examinationDetailsOBJ != null &&
		 * examinationDetailsOBJ.has("gastroIntestinalExamination") &&
		 * !examinationDetailsOBJ.get("gastroIntestinalExamination").isJsonNull(
		 * )) { SysGastrointestinalExamination gastrointestinalExamination =
		 * InputMapper.gson().fromJson(
		 * examinationDetailsOBJ.get("gastroIntestinalExamination"),
		 * SysGastrointestinalExamination.class); if (null !=
		 * gastrointestinalExamination) {
		 * gastrointestinalExamination.setBenVisitID(benVisitID);
		 * gastroIntsExmnSuccessFlag = ancNurseServiceImpl
		 * .saveSysGastrointestinalExamination(gastrointestinalExamination);
		 * 
		 * } }
		 */
		// Save Cardio Vascular Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("cardioVascularExamination")
				&& !examinationDetailsOBJ.get("cardioVascularExamination").isJsonNull()) {
			SysCardiovascularExamination cardiovascularExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("cardioVascularExamination"), SysCardiovascularExamination.class);
			if (null != cardiovascularExamination) {
				cardiovascularExamination.setBenVisitID(benVisitID);
				cardiExmnSuccessFlag = commonNurseServiceImpl
						.saveSysCardiovascularExamination(cardiovascularExamination);
				// cardiExmnSuccessFlag =
				// ancNurseServiceImpl.saveSysCardiovascularExamination(cardiovascularExamination);

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
				// respiratoryExmnSuccessFlag = ancNurseServiceImpl
				// .saveSysRespiratoryExamination(sysRespiratoryExamination);
			}
		}

		// Save Central Nervous Examination Details
		if (examinationDetailsOBJ != null && examinationDetailsOBJ.has("centralNervousSystemExamination")
				&& !examinationDetailsOBJ.get("centralNervousSystemExamination").isJsonNull()) {
			SysCentralNervousExamination sysCentralNervousExamination = InputMapper.gson().fromJson(
					examinationDetailsOBJ.get("centralNervousSystemExamination"), SysCentralNervousExamination.class);
			if (null != sysCentralNervousExamination) {
				sysCentralNervousExamination.setBenVisitID(benVisitID);
				centralNrvsExmnSuccessFlag = commonNurseServiceImpl
						.saveSysCentralNervousExamination(sysCentralNervousExamination);
				// centralNrvsExmnSuccessFlag = ancNurseServiceImpl
				// .saveSysCentralNervousExamination(sysCentralNervousExamination);
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
				muskelstlExmnSuccessFlag = commonNurseServiceImpl
						.saveSysMusculoskeletalSystemExamination(sysMusculoskeletalSystemExamination);
				// muskelstlExmnSuccessFlag = ancNurseServiceImpl
				// .saveSysMusculoskeletalSystemExamination(sysMusculoskeletalSystemExamination);

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
				genitorinaryExmnSuccessFlag = commonNurseServiceImpl
						.saveSysGenitourinarySystemExamination(sysGenitourinarySystemExamination);
				// genitorinaryExmnSuccessFlag = ancNurseServiceImpl
				// .saveSysGenitourinarySystemExamination(sysGenitourinarySystemExamination);

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
				// && (null != gastroIntsExmnSuccessFlag &&
				// gastroIntsExmnSuccessFlag > 0)
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

		BeneficiaryVisitDetail visitDetail = commonNurseServiceImpl.getCSVisitDetails(benRegID, benVisitID);

		resMap.put("ANCNurseVisitDetail", new Gson().toJson(visitDetail));

		resMap.put("BenAdherence", commonNurseServiceImpl.getBenAdherence(benRegID, benVisitID));

		resMap.put("BenChiefComplaints", commonNurseServiceImpl.getBenChiefComplaints(benRegID, benVisitID));
		// resMap.put("BenChiefComplaints",
		// ancNurseServiceImpl.getBenChiefComplaints(benRegID, benVisitID));

		resMap.put("Investigation", commonNurseServiceImpl.getLabTestOrders(benRegID, benVisitID));

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

		return new Gson().toJson(HistoryDetailsMap);
	}

	@Override
	public String getBeneficiaryVitalDetails(Long beneficiaryRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		resMap.put("benAnthropometryDetail",
				commonNurseServiceImpl.getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID, benVisitID));
		resMap.put("benPhysicalVitalDetail",
				commonNurseServiceImpl.getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, benVisitID));

		return resMap.toString();
	}

	@Override
	public String getANCExaminationDetailsData(Long benRegID, Long benVisitID) {
		Map<String, Object> examinationDetailsMap = new HashMap<String, Object>();

		examinationDetailsMap.put("generalExamination",
				commonNurseServiceImpl.getGeneralExaminationData(benRegID, benVisitID));
		examinationDetailsMap.put("headToToeExamination",
				commonNurseServiceImpl.getHeadToToeExaminationData(benRegID, benVisitID));

		/* Only for General OPD, Can remove from here */
		/*
		 * examinationDetailsMap.put("gastrointestinalExamination",
		 * ancNurseServiceImpl.getSysGastrointestinalExamination(benRegID,
		 * benVisitID));
		 */
		examinationDetailsMap.put("cardiovascularExamination",
				commonNurseServiceImpl.getCardiovascularExamination(benRegID, benVisitID));
		examinationDetailsMap.put("respiratoryExamination",
				commonNurseServiceImpl.getRespiratoryExamination(benRegID, benVisitID));
		examinationDetailsMap.put("centralNervousExamination",
				commonNurseServiceImpl.getSysCentralNervousExamination(benRegID, benVisitID));
		examinationDetailsMap.put("musculoskeletalExamination",
				commonNurseServiceImpl.getMusculoskeletalExamination(benRegID, benVisitID));
		examinationDetailsMap.put("genitourinaryExamination",
				commonNurseServiceImpl.getGenitourinaryExamination(benRegID, benVisitID));
		examinationDetailsMap.put("obstetricExamination",
				ancNurseServiceImpl.getSysObstetricExamination(benRegID, benVisitID));

		return new Gson().toJson(examinationDetailsMap);
	}

	// ---------- ENd of Fetch ANC (Nurse)--------------------------------------

	// ------- Fetch beneficiary all past history data ------------------
	public String getANCPastHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPastMedicalHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all past history data ----------

	// ------- Fetch beneficiary all Comorbid conditions history data
	// ------------------
	public String getANCComorbidHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenComorbidityHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Comorbid conditions history data
	/// --------

	// ------- Fetch beneficiary all Medication history data -----------
	public String getANCMedicationHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalMedicationHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Medication history data --

	// ------- Fetch beneficiary all Personal Tobacco history data
	// ---------------
	public String getANCPersonalTobaccoHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalTobaccoHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Personal Tobacco history data------

	// ------- Fetch beneficiary all Personal Alcohol history data
	// ---------------
	public String getANCPersonalAlcoholHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalAlcoholHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Personal Alcohol history data
	/// ------

	// ------- Fetch beneficiary all Personal Allergy history data
	// ---------------
	public String getANCPersonalAllergyHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalAllergyHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Personal Allergy history data------

	// ------- Fetch beneficiary all Family history data ---------------
	public String getANCFamilyHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPersonalFamilyHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Family history data ------

	// ------- Fetch beneficiary all Menstrual history data -----------
	public String getANCMenstrualHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenMenstrualHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Menstrual history data --

	// ------- Fetch beneficiary all past obstetric history data ---------------
	public String getANCObstetricHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenPastObstetricHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all past obstetric history data ------

	// ------- Fetch beneficiary all Immunization history data ---------------
	public String getANCImmunizationHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenImmunizationHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Immunization history data ------

	// ------- Fetch beneficiary all Child Vaccine history data ---------------
	public String getANCChildVaccineHistoryData(Long beneficiaryRegID) {
		return commonNurseServiceImpl.fetchBenOptionalVaccineHistory(beneficiaryRegID);
	}
	/// ------- End of Fetch beneficiary all Child Vaccine history data ------

	// -------Update (Nurse data from Doctor screen)----------------------

	@Override
	@Transactional(rollbackFor = Exception.class)
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
	@Transactional(rollbackFor = Exception.class)
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
	@Transactional(rollbackFor = Exception.class)
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
			pastHistorySuccessFlag = commonNurseServiceImpl.updateBenPastHistoryDetails(benMedHistory);

		}

		// Update Comorbidity/concurrent Conditions
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("comorbidConditions")
				&& !ancHistoryOBJ.get("comorbidConditions").isJsonNull()) {
			WrapperComorbidCondDetails wrapperComorbidCondDetails = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("comorbidConditions"), WrapperComorbidCondDetails.class);
			comrbidSuccessFlag = commonNurseServiceImpl.updateBenComorbidConditions(wrapperComorbidCondDetails);
		}

		// Update Medication History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("medicationHistory")
				&& !ancHistoryOBJ.get("medicationHistory").isJsonNull()) {
			WrapperMedicationHistory wrapperMedicationHistory = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("medicationHistory"), WrapperMedicationHistory.class);
			medicationSuccessFlag = commonNurseServiceImpl.updateBenMedicationHistory(wrapperMedicationHistory);
		}
		// Update Personal History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("personalHistory")
				&& !ancHistoryOBJ.get("personalHistory").isJsonNull()) {
			// Update Ben Personal Habits..
			BenPersonalHabit personalHabit = InputMapper.gson().fromJson(ancHistoryOBJ.get("personalHistory"),
					BenPersonalHabit.class);

			personalHistorySuccessFlag = commonNurseServiceImpl.updateBenPersonalHistory(personalHabit);

			// Update Ben Allergy History..
			BenAllergyHistory benAllergyHistory = InputMapper.gson().fromJson(ancHistoryOBJ.get("personalHistory"),
					BenAllergyHistory.class);
			allergyHistorySuccessFlag = commonNurseServiceImpl.updateBenAllergicHistory(benAllergyHistory);

		}

		// Update Family History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("familyHistory")
				&& !ancHistoryOBJ.get("familyHistory").isJsonNull()) {
			BenFamilyHistory benFamilyHistory = InputMapper.gson().fromJson(ancHistoryOBJ.get("familyHistory"),
					BenFamilyHistory.class);
			familyHistorySuccessFlag = commonNurseServiceImpl.updateBenFamilyHistory(benFamilyHistory);
		}

		// Update Menstrual History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("menstrualHistory")
				&& !ancHistoryOBJ.get("menstrualHistory").isJsonNull()) {
			BenMenstrualDetails menstrualDetails = InputMapper.gson().fromJson(ancHistoryOBJ.get("menstrualHistory"),
					BenMenstrualDetails.class);
			menstrualHistorySuccessFlag = commonNurseServiceImpl.updateMenstrualHistory(menstrualDetails);
		}

		// Update Past Obstetric History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("femaleObstetricHistory")
				&& !ancHistoryOBJ.get("femaleObstetricHistory").isJsonNull()) {
			WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("femaleObstetricHistory"), WrapperFemaleObstetricHistory.class);

			obstetricSuccessFlag = commonNurseServiceImpl.updatePastObstetricHistory(wrapperFemaleObstetricHistory);
		}

		/** For Female above 12 yrs old and below 16 years old.. **/
		// Update Immunization History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("immunizationHistory")
				&& !ancHistoryOBJ.get("immunizationHistory").isJsonNull()) {

			JsonObject immunizationHistory = ancHistoryOBJ.getAsJsonObject("immunizationHistory");
			if (immunizationHistory.get("immunizationList") != null
					&& immunizationHistory.getAsJsonArray("immunizationList").size() > 0) {
				WrapperImmunizationHistory wrapperImmunizationHistory = InputMapper.gson()
						.fromJson(ancHistoryOBJ.get("immunizationHistory"), WrapperImmunizationHistory.class);
				immunizationSuccessFlag = commonNurseServiceImpl
						.updateChildImmunizationDetail(wrapperImmunizationHistory);
			} else {
				immunizationSuccessFlag = 1;
			}
		} else {
			immunizationSuccessFlag = 1;
		}

		// Update Other/Optional Vaccines History
		if (ancHistoryOBJ != null && ancHistoryOBJ.has("childVaccineDetails")
				&& !ancHistoryOBJ.get("childVaccineDetails").isJsonNull()) {
			WrapperChildOptionalVaccineDetail wrapperChildVaccineDetail = InputMapper.gson()
					.fromJson(ancHistoryOBJ.get("childVaccineDetails"), WrapperChildOptionalVaccineDetail.class);
			childVaccineSuccessFlag = commonNurseServiceImpl
					.updateChildOptionalVaccineDetail(wrapperChildVaccineDetail);
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
	@Transactional(rollbackFor = Exception.class)
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

			anthropometrySuccessFlag = commonNurseServiceImpl.updateANCAnthropometryDetails(benAnthropometryDetail);
			phyVitalSuccessFlag = commonNurseServiceImpl.updateANCPhysicalVitalDetails(benPhysicalVitalDetail);

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
	@Transactional(rollbackFor = Exception.class)
	public int updateBenANCExaminationDetails(JsonObject examinationDetailsOBJ) throws Exception {

		int exmnSuccessFlag = 0;

		int genExmnSuccessFlag = 0;
		int headToToeExmnSuccessFlag = 0;
		// int gastroIntsExmnSuccessFlag = 0;
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
		/**
		 * Removed from anc. Only applicable for generalOPD. date: 05-02-2018
		 */
		// if (examinationDetailsOBJ != null &&
		// examinationDetailsOBJ.has("gastroIntestinalExamination")
		// &&
		// !examinationDetailsOBJ.get("gastroIntestinalExamination").isJsonNull())
		// {
		// SysGastrointestinalExamination gastrointestinalExamination =
		// InputMapper.gson().fromJson(
		// examinationDetailsOBJ.get("gastroIntestinalExamination"),
		// SysGastrointestinalExamination.class);
		// gastroIntsExmnSuccessFlag = ancNurseServiceImpl
		// .updateSysGastrointestinalExamination(gastrointestinalExamination);
		// }
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

		if (genExmnSuccessFlag > 0 && headToToeExmnSuccessFlag > 0 && cardiExmnSuccessFlag > 0
				&& respiratoryExmnSuccessFlag > 0 && centralNrvsExmnSuccessFlag > 0 && muskelstlExmnSuccessFlag > 0
				&& genitorinaryExmnSuccessFlag > 0 && obstetricExmnSuccessFlag > 0) {
			exmnSuccessFlag = genExmnSuccessFlag;
		}
		return exmnSuccessFlag;
	}
	
	public String getBenCaseRecordFromDoctorANC(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		resMap.put("findings", commonDoctorServiceImpl.getFindingsDetails(benRegID, benVisitID));
		
		resMap.put("diagnosis", ancDoctorServiceImpl.getANCDiagnosisDetails(benRegID, benVisitID));

		resMap.put("investigation", commonDoctorServiceImpl.getInvestigationDetails(benRegID, benVisitID));
		
		resMap.put("prescription", commonDoctorServiceImpl.getPrescribedDrugs(benRegID, benVisitID));

		resMap.put("Refer", commonDoctorServiceImpl.getReferralDetails(benRegID, benVisitID));

		return resMap.toString();
	}

}
