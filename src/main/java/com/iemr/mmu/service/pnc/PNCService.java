package com.iemr.mmu.service.pnc;

import com.google.gson.JsonObject;

public interface PNCService
{

	Long savePNCNurseData(JsonObject requestOBJ) throws Exception;

	String getBenVisitDetailsFrmNursePNC(Long benRegID, Long benVisitID) throws Exception;

	String getBenPNCDetailsFrmNursePNC(Long benRegID, Long benVisitID);


}
