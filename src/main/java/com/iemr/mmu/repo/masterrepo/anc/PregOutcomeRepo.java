package com.iemr.mmu.repo.masterrepo.anc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.anc.PregOutcome;

@Repository
public interface PregOutcomeRepo extends CrudRepository<PregOutcome, Short>{
	
	@Query("select PregOutcomeID, PregOutcome from PregOutcome where deleted = false order by PregOutcome")
	public ArrayList<Object[]> getPregOutcomes();
	
}
