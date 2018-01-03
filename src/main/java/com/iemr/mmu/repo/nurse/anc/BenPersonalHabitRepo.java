package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.iemr.mmu.data.anc.BenPersonalHabit;

@Repository
public interface BenPersonalHabitRepo extends CrudRepository<BenPersonalHabit, Integer>{
	
	@Query("select benVisitID from BenPersonalHabit a where a.beneficiaryRegID = :beneficiaryRegID order by benVisitID desc")
	public ArrayList<Long> getBenLastVisitID(@Param("beneficiaryRegID") Long beneficiaryRegID);

	@Query("select dietaryType, physicalActivityType, tobaccoUseStatus, tobaccoUseTypeID, tobaccoUseType, otherTobaccoUseType, numberperDay, tobaccoUseDuration, "
			+ "riskySexualPracticesStatus from BenPersonalHabit a where a.beneficiaryRegID = :beneficiaryRegID ")
	public ArrayList<Object[]> getBenPersonalTobaccoHabitDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);
	
	@Query("select dietaryType, physicalActivityType, alcoholIntakeStatus, alcoholTypeID, alcoholType, otherAlcoholType, alcoholIntakeFrequency, "
			+ " avgAlcoholConsumption, alcoholDuration, riskySexualPracticesStatus "
			+ " from BenPersonalHabit a where a.beneficiaryRegID = :beneficiaryRegID")
		public ArrayList<Object[]> getBenPersonalAlcoholHabitDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);
		
		
	@Query(" SELECT beneficiaryRegID, benVisitID, providerServiceMapID, dietaryType, physicalActivityType, tobaccoUseStatus, tobaccoUseTypeID, "
			+ "tobaccoUseType, otherTobaccoUseType, numberperDay, tobaccoUseDuration, alcoholIntakeStatus, alcoholTypeID, "
			+ "alcoholType, otherAlcoholType, alcoholIntakeFrequency, avgAlcoholConsumption, alcoholDuration, riskySexualPracticesStatus, createdDate  FROM BenPersonalHabit "
			+ " WHERE beneficiaryRegID = :benRegID AND benVisitID = :benVisitID ")
	public ArrayList<Object[]> getBenPersonalHabitDetail(@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID);

	@Modifying
	@Transactional
	@Query(" Delete from BenPersonalHabit WHERE beneficiaryRegID = :benRegID and benVisitID = :benVisitID")
	public int deleteExistingBenPersonalHistory(@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID);
		
}
