package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.BenMenstrualDetails;

@Repository
public interface BenMenstrualDetailsRepo extends CrudRepository<BenMenstrualDetails, Integer>{
	
	@Query("select menstrualCycleStatusID, regularity, menstrualCyclelengthID, cycleLength, menstrualFlowDurationID, bloodFlowDuration, "
			+ "menstrualProblemID, problemName, lMPDate "
			+ "from BenMenstrualDetails a where a.beneficiaryRegID = :beneficiaryRegID")
	public ArrayList<Object[]> getBenMenstrualDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);
	
	@Query(" SELECT beneficiaryRegID, benVisitID, providerServiceMapID, menstrualCycleStatusID, regularity, menstrualCyclelengthID, "
			+ "cycleLength, menstrualFlowDurationID, bloodFlowDuration, menstrualProblemID, problemName, lMPDate FROM BenMenstrualDetails "
			+ " WHERE beneficiaryRegID = :benRegID AND benVisitID = :benVisitID ")
	public ArrayList<Object[]> getBenMenstrualDetail(@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID);
}
