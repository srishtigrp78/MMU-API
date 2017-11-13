package com.iemr.mmu.repo.masterrepo.anc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.anc.IllnessTypes;

@Repository
public interface IllnessTypesRepo extends CrudRepository<IllnessTypes, Integer>{
	
	@Query("select illnessID, illnessType, isAcute, isChronic from IllnessTypes where deleted = false order by illnessType")
	public ArrayList<Object[]> getIllnessTypes();
}
