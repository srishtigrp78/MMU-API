package com.iemr.mmu.service.generalOPD;

import com.google.gson.JsonObject;

public interface GeneralOPDService {

	Long saveNurseData(JsonObject requestOBJ) throws Exception;
	
	Long saveBenGeneralOPDHistoryDetails(JsonObject generalOPDHistoryOBJ, Long benVisitID) throws Exception;

	Long saveBenVitalDetails(JsonObject vitalDetailsOBJ, Long benVisitID) throws Exception;

	Long saveBenExaminationDetails(JsonObject examinationDetailsOBJ, Long benVisitID) throws Exception;

	Long saveBenVisitDetails(JsonObject visitDetailsOBJ) throws Exception;
	
}
