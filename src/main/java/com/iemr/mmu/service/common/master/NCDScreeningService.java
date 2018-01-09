package com.iemr.mmu.service.common.master;

import java.util.List;

public interface NCDScreeningService {

	public List<Object[]> getNCDScreeningConditions(); 

	public List<Object[]> getNCDScreeningReasons();
	
	public List<Object[]> getBPAndDiabeticStatus(Boolean isBPStatus);
	
	public List<Object[]> getNCDTest();
	
	public String getNCDScreeningMasterData();
	
}
