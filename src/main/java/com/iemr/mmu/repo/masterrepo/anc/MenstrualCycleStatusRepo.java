package com.iemr.mmu.repo.masterrepo.anc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.anc.MenstrualCycleStatus;

@Repository
public interface MenstrualCycleStatusRepo extends CrudRepository<MenstrualCycleStatus, Short>{
	
	@Query("select menstrualCycleStatusID, name, menstrualCycleStatusDesc from MenstrualCycleStatus where deleted = false order by name")
	public ArrayList<Object[]> getMenstrualCycleStatuses();
}
