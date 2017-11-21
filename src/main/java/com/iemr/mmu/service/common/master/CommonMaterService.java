package com.iemr.mmu.service.common.master;

public interface CommonMaterService {

	public String getVisitReasonAndCategories();
	
	public String getMasterDataForNurse(Integer visitCategoryID); 
	
	public String getMasterDataForDoctor(Integer visitCategoryID); 
}
