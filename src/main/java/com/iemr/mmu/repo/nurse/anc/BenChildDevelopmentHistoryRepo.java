package com.iemr.mmu.repo.nurse.anc;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.anc.BenChildDevelopmentHistory;

public interface BenChildDevelopmentHistoryRepo extends CrudRepository<BenChildDevelopmentHistory, Long> {

	@Query("select Date(createdDate), grossMotorMilestone, isGMMAttained, fineMotorMilestone, isFMMAttained, "
			+ "socialMilestone, isSMAttained, languageMilestone, isLMAttained, developmentProblem "
			+ "from BenChildDevelopmentHistory a where a.beneficiaryRegID = :beneficiaryRegID "
			+ "AND deleted = false ORDER BY createdDate DESC ")
	public ArrayList<Object[]> getBenDevelopmentHistoryDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);

	@Query("select beneficiaryRegID, benVisitID, providerServiceMapID, grossMotorMilestone, isGMMAttained, fineMotorMilestone, "
			+ "isFMMAttained, socialMilestone, isSMAttained, languageMilestone, isLMAttained, developmentProblem  "
			+ "from BenChildDevelopmentHistory a where a.beneficiaryRegID = :beneficiaryRegID and a.benVisitID = :benVisitID")

	public ArrayList<Object[]> getBenDevelopmentDetails(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("benVisitID") Long benVisitID);

}
