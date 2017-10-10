package com.iemr.mmu.repo.masterrepo.nurse;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.iemr.mmu.data.masterdata.nurse.VisitReason;

public interface VisitReasonMasterRepo extends CrudRepository<VisitReason, Long>{

	@Query("select visitReasonID, visitReason from VisitReason where deleted = false order by visitReason ")
	public ArrayList<Object[]> getVisitReasonMaster();
	
}
