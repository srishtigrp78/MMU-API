package com.iemr.mmu.service.anc;

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
import com.iemr.mmu.data.anc.WrapperAncImmunization;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;

public interface ANCService {

	public Long saveBeneficiaryANCDetails(ANCCareDetails ancCareDetails);

	public Long saveANCWomenVaccineDetails(List<ANCWomenVaccineDetail> ancWomenVaccineDetails);

	public int saveBenAdherenceDetails(BenAdherence benAdherence);

	public int saveBenChiefComplaints(List<BenChiefComplaint> benChiefComplaintList);

	public void saveBenInvestigation();

	public int saveBenAncCareDetails(ANCCareDetails ancCareDetailsOBJ);

	public int saveAncImmunizationDetails(WrapperAncImmunization wrapperAncImmunizationOBJ);

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
}
