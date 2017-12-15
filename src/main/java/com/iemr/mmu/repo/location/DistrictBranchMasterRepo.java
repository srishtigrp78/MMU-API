package com.iemr.mmu.repo.location;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.location.DistrictBranchMapping;

public interface DistrictBranchMasterRepo extends CrudRepository<DistrictBranchMapping, Integer> {
	@Query(" SELECT zoneID, zoneName FROM ZoneMaster WHERE stateID = :stateID AND deleted != 1 ")
	public ArrayList<Object[]> getZoneMaster(@Param("stateID") Integer stateID);

}
