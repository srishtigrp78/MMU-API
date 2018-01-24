package com.iemr.mmu.service.anc;

import com.google.gson.JsonObject;

public interface ANCService {

	public Long saveANCNurseData(JsonObject requestOBJ) throws Exception;

	String getBenANCHistoryDetails(Long benRegID, Long benVisitID);

	String getANCExaminationDetailsData(Long benRegID, Long benVisitID);

	String getBenVisitDetailsFrmNurseANC(Long benRegID, Long benVisitID);

	String getBenANCDetailsFrmNurseANC(Long benRegID, Long benVisitID);

	int UpdateANCVisitDetails(JsonObject jsnOBJ) throws Exception;

	String getBeneficiaryVitalDetails(Long beneficiaryRegID, Long benVisitID);

}
