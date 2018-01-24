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
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;

public interface ANCNurseService {

	Long saveBeneficiaryANCDetails(ANCCareDetails ancCareDetails);

	Long saveANCWomenVaccineDetails(List<ANCWomenVaccineDetail> ancWomenVaccineDetails);

	int saveBenAdherenceDetails(BenAdherence benAdherence);

	int saveBenChiefComplaints(List<BenChiefComplaint> benChiefComplaintList);

	Long saveBenInvestigation(WrapperBenInvestigationANC wrapperBenInvestigationANC);

	Long saveBenAncCareDetails(ANCCareDetails ancCareDetailsOBJ) throws ParseException;

	Long saveAncImmunizationDetails(WrapperAncImmunization wrapperAncImmunizationOBJ) throws ParseException;

	Long savePhyHeadToToeExamination(PhyHeadToToeExamination headToToeExamination);

	Long saveSysCardiovascularExamination(SysCardiovascularExamination cardiovascularExamination);

	Long saveSysCentralNervousExamination(SysCentralNervousExamination centralNervousExamination);

	Long saveSysGastrointestinalExamination(SysGastrointestinalExamination gastrointestinalExamination);

	Long saveSysGenitourinarySystemExamination(SysGenitourinarySystemExamination genitourinarySystemExamination);

	Long saveSysMusculoskeletalSystemExamination(SysMusculoskeletalSystemExamination musculoskeletalSystemExamination);

	Long saveSysObstetricExamination(SysObstetricExamination obstetricExamination);

	Long saveSysRespiratoryExamination(SysRespiratoryExamination respiratoryExamination);

	String getANCExaminationDetailsData(Long benRegID, Long benVisitID);

	String getBenAdherence(Long beneficiaryRegID, Long benVisitID);

	String getBenChiefComplaints(Long beneficiaryRegID, Long benVisitID);

	String getLabTestOrders(Long beneficiaryRegID, Long benVisitID);

	String getANCCareDetails(Long beneficiaryRegID, Long benVisitID);

	String getANCWomenVaccineDetails(Long beneficiaryRegID, Long benVisitID);

	Integer saveAncDocFindings(WrapperAncFindings wrapperAncFindings);

	Integer saveBenANCPrescription(List<PrescribedDrugDetail> prescribedDrugDetailList);

	Long saveBenANCPastHistory(BenMedHistory benMedHistory);

	Long saveBenANCComorbidConditions(WrapperComorbidCondDetails wrapperComorbidCondDetails);

	Long saveBenANCMedicationHistory(WrapperMedicationHistory wrapperMedicationHistory);

	Integer saveBenANCMenstrualHistory(BenMenstrualDetails benMenstrualDetails);

	Long saveFemaleObstetricHistory(WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory);

	Long savePerinatalHistory(PerinatalHistory perinatalHistory);

	Long saveChildOptionalVaccineDetail(WrapperChildOptionalVaccineDetail wrapperChildVaccineDetail);

	Long saveChildDevelopmentHistory(BenChildDevelopmentHistory benChildDevelopmentHistory);

	Integer saveANCPersonalHistory(BenPersonalHabit benPersonalHabit);

	Long saveANCAllergyHistory(BenAllergyHistory benAllergyHistory);

	Long saveANCBenFamilyHistory(BenFamilyHistory benFamilyHistory);

	Long saveChildFeedingHistory(ChildFeedingDetails childFeedingDetails);

	Long saveANCImmunizationHistory(WrapperImmunizationHistory wrapperImmunizationHistory);

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

	public int updateBenANCComorbidConditions(WrapperComorbidCondDetails wrapperComorbidCondDetails);

	public int updateBenANCMedicationHistory(WrapperMedicationHistory wrapperMedicationHistory);

	public int updateBenANCPersonalHistory(BenPersonalHabit benPersonalHabit);

	public int updateBenANCAllergicHistory(BenAllergyHistory benAllergyHistory);

	public int updateBenANCFamilyHistory(BenFamilyHistory benFamilyHistory);

	public int updateChildOptionalVaccineDetail(WrapperChildOptionalVaccineDetail wrapperChildOptionalVaccineDetail);

	public int updateANCAnthropometryDetails(BenAnthropometryDetail anthropometryDetail );
	
	public int updateANCPhysicalVitalDetails(BenPhysicalVitalDetail physicalVitalDetail );
	
	public int updateANCChildImmunizationDetail(WrapperImmunizationHistory wrapperImmunizationHistory);

	public String fetchBenImmunizationHistory(Long beneficiaryRegID);

	public int updateSysGastrointestinalExamination(SysGastrointestinalExamination gastrointestinalExamination);

	public int updateSysCardiovascularExamination(SysCardiovascularExamination cardiovascularExamination);

	public int updateSysRespiratoryExamination(SysRespiratoryExamination respiratoryExamination);
	
	public int updateSysCentralNervousExamination(SysCentralNervousExamination centralNervousExamination);

	public int updateSysMusculoskeletalSystemExamination(SysMusculoskeletalSystemExamination musculoskeletalSystemExamination);

	public int updateSysGenitourinarySystemExamination(SysGenitourinarySystemExamination genitourinarySystemExamination);

	public int updateSysObstetricExamination(SysObstetricExamination obstetricExamination);

	public int updatePhyHeadToToeExamination(PhyHeadToToeExamination headToToeExamination);

	public int updateANCMenstrualHistory(BenMenstrualDetails benMenstrualDetails);
	
	public int updateANCPastObstetricHistory(WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory);


}
