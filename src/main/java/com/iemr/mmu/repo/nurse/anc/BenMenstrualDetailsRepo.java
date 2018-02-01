package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.anc.BenMenstrualDetails;

@Repository
public interface BenMenstrualDetailsRepo extends CrudRepository<BenMenstrualDetails, Integer>{
	
	@Query("select Date(createdDate), regularity, cycleLength, bloodFlowDuration, problemName, Date(lMPDate) "
			+ "from BenMenstrualDetails a where a.beneficiaryRegID = :beneficiaryRegID AND menstrualCycleStatusID is not null AND deleted = false "
			+ "order by createdDate DESC")
	public ArrayList<Object[]> getBenMenstrualDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);
	
	@Query(" SELECT beneficiaryRegID, benVisitID, providerServiceMapID, menstrualCycleStatusID, regularity, menstrualCyclelengthID, "
			+ "cycleLength, menstrualFlowDurationID, bloodFlowDuration, menstrualProblemID, problemName, lMPDate FROM BenMenstrualDetails "
			+ " WHERE beneficiaryRegID = :benRegID AND benVisitID = :benVisitID ")
	public ArrayList<Object[]> getBenMenstrualDetail(@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID);
	

	@Query("SELECT processed from BenAnthropometryDetail where beneficiaryRegID=:benRegID AND benVisitID = :benVisitID")
	public String getBenMenstrualDetailStatus(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);

	
	@Transactional
	@Modifying
	@Query("update BenMenstrualDetails set menstrualCycleStatusID=:menstrualCycleStatusID, regularity=:regularity, "
			+ "menstrualCyclelengthID=:menstrualCyclelengthID, cycleLength=:cycleLength,"
			+ " bloodFlowDuration=:bloodFlowDuration, menstrualProblemID=:menstrualProblemID, problemName=:problemName, lMPDate=:lMPDate,"
			+ " menstrualFlowDurationID=:menstrualFlowDurationID,  modifiedBy=:modifiedBy, processed=:processed where "
			+ "beneficiaryRegID=:beneficiaryRegID AND benVisitID = :benVisitID")
	public int updateMenstrualDetails(
			@Param("menstrualCycleStatusID") Short menstrualCycleStatusID,
			@Param("regularity") String regularity,
			@Param("menstrualCyclelengthID") Short menstrualCyclelengthID,
			@Param("cycleLength") String cycleLength,
			@Param("menstrualFlowDurationID") Short menstrualFlowDurationID,
			@Param("bloodFlowDuration") String bloodFlowDuration,
			@Param("menstrualProblemID") Short menstrualProblemID,
			@Param("problemName") String problemName,
			@Param("lMPDate") Timestamp lMPDate,
			@Param("modifiedBy") String modifiedBy,
			@Param("processed") String processed,
			@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("benVisitID") Long benVisitID);
}
