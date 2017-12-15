package com.iemr.mmu.repo.location;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.login.MasterServicePoint;

public interface ServicePointMasterRepo extends CrudRepository<MasterServicePoint, Integer> {
	@Query(" SELECT servicePointID, servicePointName FROM MasterServicePoint WHERE parkingPlaceID = :parkingPlaceID AND deleted != 1 ")
	public ArrayList<Object[]> getServicePointMaster(@Param("parkingPlaceID") Integer parkingPlaceID);
}
