package com.iemr.mmu.service.snomedct;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.snomedct.SCTDescription;
import com.iemr.mmu.repo.snomedct.SnomedRepository;

@Service
public class SnomedServiceImpl implements SnomedService {

	@Autowired
	private SnomedRepository snomedRepository;

	@Override
	public List<SCTDescription> findSnomedCTRecordFromTerm(String term) {

		List<SCTDescription> sctDesList = new ArrayList<SCTDescription>();

		List<Objects[]> records = snomedRepository.findSnomedCTRecordFromTerm(term);

		for (Object[] sctdescription : records) {
			if (sctdescription != null && sctdescription.length > 1) {
				
				SCTDescription sctDes = new SCTDescription( (String)sctdescription[0], (String)sctdescription[1]);
				sctDesList.add(sctDes);
			}
		}
		
		return sctDesList;

	}

}
