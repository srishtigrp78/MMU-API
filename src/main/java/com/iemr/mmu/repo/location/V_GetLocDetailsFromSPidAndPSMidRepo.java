package com.iemr.mmu.repo.location;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.location.V_GetLocDetailsFromSPidAndPSMid;

@Repository
public interface V_GetLocDetailsFromSPidAndPSMidRepo extends CrudRepository<V_GetLocDetailsFromSPidAndPSMid, Long> {
	ArrayList<V_GetLocDetailsFromSPidAndPSMid> findByServicepointidAndSpproviderservicemapidAndPpproviderservicemapidAndZdmproviderservicemapid(
			Integer spID, Integer spPSMID, Integer ppPSMID, Integer zdmPSMID);
}
