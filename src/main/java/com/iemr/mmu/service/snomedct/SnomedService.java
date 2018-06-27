package com.iemr.mmu.service.snomedct;

import java.util.List;

import com.iemr.mmu.data.snomedct.SCTDescription;


public interface SnomedService {
	
	public List<SCTDescription> findSnomedCTRecordFromTerm(String term);

}
