package com.iemr.mmu.service.anc;

import java.util.List;

import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.ANCWomenVaccineDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;

public interface ANCService {

	public Long saveBeneficiaryANCDetails(ANCCareDetails ancCareDetails);

	public Long saveANCWomenVaccineDetails(List<ANCWomenVaccineDetail> ancWomenVaccineDetails);
}
