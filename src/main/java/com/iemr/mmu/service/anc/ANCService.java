package com.iemr.mmu.service.anc;

import java.util.List;

import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.ANCWomenVaccineDetail;
import com.iemr.mmu.data.anc.BenAdherence;
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
}
