package com.iemr.mmu.service.common.master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.masterdata.ncdcare.NCDCareType;
import com.iemr.mmu.data.masterdata.ncdscreening.NCDScreeningCondition;
import com.iemr.mmu.repo.masterrepo.ncdCare.NCDCareTypeRepo;

@Service
public class NCDCareMasterDataServiceImpl implements NCDCareMasterDataService
{
	private NCDScreeningMasterServiceImpl ncdScreeningMasterServiceImpl;
	private NCDCareTypeRepo ncdCareTypeRepo;
	
	@Autowired
	public void setNcdScreeningMasterServiceImpl(NCDScreeningMasterServiceImpl ncdScreeningMasterServiceImpl)
	{
		this.ncdScreeningMasterServiceImpl = ncdScreeningMasterServiceImpl;
	}
	
	@Autowired
	public void setNcdCareTypeRepo(NCDCareTypeRepo ncdCareTypeRepo)
	{
		this.ncdCareTypeRepo = ncdCareTypeRepo;
	}
	
	@Override
	public String getNCDCareMasterData() {
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		resMap.put("ncdCareConditions", NCDScreeningCondition.getNCDScreeningCondition((ArrayList<Object[]>) 
																	ncdScreeningMasterServiceImpl.getNCDScreeningConditions()));
		resMap.put("ncdCareTypes", NCDCareType.getNCDCareTypes((ArrayList<Object[]>) getNCDCareTypes()));
		
		return new Gson().toJson(resMap);
	}

	@Override
	public List<Object[]> getNCDCareTypes() {
		List<Object[]> ncdCareTypes  = null;
		try {
			ncdCareTypes = ncdCareTypeRepo.getNCDCareTypes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ncdCareTypes;
	} 
}
