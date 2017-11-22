package com.iemr.mmu.repo.masterrepo.anc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.anc.ComorbidCondition;

@Repository
public interface ComorbidConditionRepo extends CrudRepository<ComorbidCondition, Short>{
	
	@Query("select comorbidConditionID, comorbidCondition, comorbidConditionDesc from ComorbidCondition where deleted = false order by comorbidCondition")
	public ArrayList<Object[]> getComorbidConditions();
	
}
