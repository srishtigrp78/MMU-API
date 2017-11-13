package com.iemr.mmu.service.masterservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.masterdata.nurse.CancerDiseaseType;

@Service
public class ANCMasterDataServiceImpl {
	
	public String getANCMasterData() {
		Map<String, Object> resMap = new HashMap<String, Object>();
//		ArrayList<Object[]> DiseaseTypes = cancerDiseaseMasterRepo.getCancerDiseaseMaster();
//			resMap.put("CancerDiseaseType", CancerDiseaseType.getCancerDiseaseTypeMasterData(DiseaseTypes));
		return new Gson().toJson(resMap);
	}
}
