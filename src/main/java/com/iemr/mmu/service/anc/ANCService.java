package com.iemr.mmu.service.anc;

import java.text.ParseException;
import java.util.List;

import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.ANCWomenVaccineDetail;
import com.iemr.mmu.data.anc.BenAdherence;
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
}
