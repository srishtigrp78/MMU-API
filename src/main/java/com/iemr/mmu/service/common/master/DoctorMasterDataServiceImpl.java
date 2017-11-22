package com.iemr.mmu.service.common.master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.masterdata.doctor.PreMalignantLesion;
import com.iemr.mmu.repo.masterrepo.doctor.PreMalignantLesionMasterRepo;

@Service
public class DoctorMasterDataServiceImpl implements DoctorMasterDataService{
	
	@Autowired
	private PreMalignantLesionMasterRepo preMalignantLesionMasterRepo;
	
	public String getCancerScreeningMasterDataForDoctor() {
		Map<String, Object> resMap = new HashMap<String, Object>();
		ArrayList<Object[]> preMalignantLesionTypes = preMalignantLesionMasterRepo.getPreMalignantLesionMaster();
		
		try {
			resMap.put("preMalignantLesionTypes", PreMalignantLesion.getPreMalignantLesionMasterData(preMalignantLesionTypes));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resMap);

	}
}
