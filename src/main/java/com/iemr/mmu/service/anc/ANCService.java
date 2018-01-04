package com.iemr.mmu.service.anc;

import java.text.ParseException;
import java.util.List;

import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.ANCWomenVaccineDetail;
import com.iemr.mmu.data.anc.BenAdherence;
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
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;

public interface ANCService {

	public Long saveBeneficiaryANCDetails(ANCCareDetails ancCareDetails);

	public Long saveANCWomenVaccineDetails(List<ANCWomenVaccineDetail> ancWomenVaccineDetails);

	public int saveBenAdherenceDetails(BenAdherence benAdherence);

	public int saveBenChiefComplaints(List<BenChiefComplaint> benChiefComplaintList);

	public Long saveBenInvestigation(WrapperBenInvestigationANC wrapperBenInvestigationANC);

	public int saveBenAncCareDetails(ANCCareDetails ancCareDetailsOBJ) throws ParseException;

	public int saveAncImmunizationDetails(WrapperAncImmunization wrapperAncImmunizationOBJ) throws ParseException;

	public int savePhyGeneralExamination(PhyGeneralExamination generalExamination);

	public int savePhyHeadToToeExamination(PhyHeadToToeExamination headToToeExamination);

	public int saveSysCardiovascularExamination(SysCardiovascularExamination cardiovascularExamination);

	public int saveSysCentralNervousExamination(SysCentralNervousExamination centralNervousExamination);

	public int saveSysGastrointestinalExamination(SysGastrointestinalExamination gastrointestinalExamination);

	public int saveSysGenitourinarySystemExamination(SysGenitourinarySystemExamination genitourinarySystemExamination);

	public int saveSysMusculoskeletalSystemExamination(
			SysMusculoskeletalSystemExamination musculoskeletalSystemExamination);

	public int saveSysObstetricExamination(SysObstetricExamination obstetricExamination);

	public int saveSysRespiratoryExamination(SysRespiratoryExamination respiratoryExamination);

	public String getANCExaminationDetailsData(Long benRegID, Long benVisitID);

	public String getBenAdherence(Long beneficiaryRegID, Long benVisitID);

	public String getLabTestOrders(Long beneficiaryRegID, Long benVisitID);

	public String getANCCareDetails(Long beneficiaryRegID, Long benVisitID);

	public String getANCWomenVaccineDetails(Long beneficiaryRegID, Long benVisitID);

	public Integer saveAncDocFindings(WrapperAncFindings wrapperAncFindings);

	public Long saveBenANCDiagnosis(PrescriptionDetail prescriptionDetail);

	public String getBenChiefComplaints(Long beneficiaryRegID, Long benVisitID);

	public Integer saveBenANCPrescription(List<PrescribedDrugDetail> prescribedDrugDetailList);

	public Integer saveBenANCPastHistory(BenMedHistory benMedHistory);

	public Integer saveBenANCComorbidConditions(WrapperComorbidCondDetails wrapperComorbidCondDetails);

	public Integer saveBenANCMedicationHistory(WrapperMedicationHistory wrapperMedicationHistory);

	public Integer saveBenANCMenstrualHistory(BenMenstrualDetails benMenstrualDetails);

	public Integer saveFemaleObstetricHistory(WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory);

	public Integer savePerinatalHistory(PerinatalHistory perinatalHistory);

	public Integer saveChildOptionalVaccineDetail(WrapperChildOptionalVaccineDetail wrapperChildVaccineDetail);

	public Integer saveChildDevelopmentHistory(BenChildDevelopmentHistory benChildDevelopmentHistory);

	public Integer saveANCPersonalHistory(BenPersonalHabit benPersonalHabit);

	public Integer saveANCAllergyHistory(BenAllergyHistory benAllergyHistory);

	public Integer saveANCBenFamilyHistory(BenFamilyHistory benFamilyHistory);

	public Integer saveChildFeedingHistory(ChildFeedingDetails childFeedingDetails);

	public Integer saveANCImmunizationHistory(WrapperImmunizationHistory wrapperImmunizationHistory);

	public String fetchBenPastMedicalHistory(Long benRegID) throws Exception;

	public String fetchBenPersonalTobaccoHistory(Long beneficiaryRegID);

	public String fetchBenPersonalAlcoholHistory(Long beneficiaryRegID);

	public String fetchBenPersonalAllergyHistory(Long beneficiaryRegID);

	public String fetchBenPersonalMedicationHistory(Long beneficiaryRegID);

	public String fetchBenPersonalFamilyHistory(Long beneficiaryRegID);

	public String fetchBenMenstrualHistory(Long beneficiaryRegID);

	public String fetchBenPastObstetricHistory(Long beneficiaryRegID);

	public String fetchBenComorbidityHistory(Long beneficiaryRegID);

	public String fetchBenOptionalVaccineHistory(Long beneficiaryRegID);

	public String getBenANCHistoryDetails(Long benRegID, Long benVisitID);

	public int updateBenAdherenceDetails(BenAdherence benAdherence);

	public int updateBenChiefComplaints(List<BenChiefComplaint> benChiefComplaintList);
	
	public Long updateBenInvestigation(WrapperBenInvestigationANC wrapperBenInvestigationANC);

	public int updateBenAncCareDetails(ANCCareDetails ancCareDetailsOBJ) throws ParseException;

	public int updateBenAncImmunizationDetails(WrapperAncImmunization wrapperAncImmunization) throws ParseException;

	public int updateBenAncPastHistoryDetails(BenMedHistory benMedHistory) throws ParseException;

	public Integer updateBenANCComorbidConditions(WrapperComorbidCondDetails wrapperComorbidCondDetails);

	public Integer updateBenANCMedicationHistory(WrapperMedicationHistory wrapperMedicationHistory);

	public Integer updateBenANCPersonalHistory(BenPersonalHabit benPersonalHabit);

	public Integer updateBenANCAllergicHistory(BenAllergyHistory benAllergyHistory);

	public Integer updateBenANCFamilyHistory(BenFamilyHistory benFamilyHistory);

	public Integer updateChildOptionalVaccineDetail(WrapperChildOptionalVaccineDetail wrapperChildOptionalVaccineDetail);

	public Integer updateANCChildImmunizationDetail(WrapperImmunizationHistory wrapperImmunizationHistory);

	public String fetchBenImmunizationHistory(Long beneficiaryRegID);

	public int updateSysGastrointestinalExamination(SysGastrointestinalExamination gastrointestinalExamination);

	public int updateSysCardiovascularExamination(SysCardiovascularExamination cardiovascularExamination);

	public int updateSysRespiratoryExamination(SysRespiratoryExamination respiratoryExamination);

}
