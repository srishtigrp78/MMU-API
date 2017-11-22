package com.iemr.mmu.service.anc;

import java.util.List;

import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.ANCWomenVaccineDetail;
import com.iemr.mmu.data.anc.BenAdherence;

public interface ANCService {

	public Long saveBeneficiaryANCDetails(ANCCareDetails ancCareDetails);

	public Long saveANCWomenVaccineDetails(List<ANCWomenVaccineDetail> ancWomenVaccineDetails);

	public int saveBenAdherenceDetails(BenAdherence benAdherence);

	public void saveBenChiefComplaints();

	public void saveBenInvestigation();
}
