package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

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
		//	+ "alcoholIntakeStatus, alcoholTypeID, alcoholType, otherAlcoholType, alcoholIntakeFrequency, avgAlcoholConsumption, alcoholDuration, "
			+ "riskySexualPracticesStatus from BenPersonalHabit a where a.beneficiaryRegID = :beneficiaryRegID AND benVisitID = :benVisitID")
	public ArrayList<Object[]> getBenPersonalTobaccoHabitDetail(@Param("beneficiaryRegID") Long beneficiaryRegID, @Param("benVisitID") Long benVisitID);
	
	@Query("select dietaryType, physicalActivityType, alcoholIntakeStatus, alcoholTypeID, alcoholType, otherAlcoholType, alcoholIntakeFrequency, "
			+ " avgAlcoholConsumption, alcoholDuration, riskySexualPracticesStatus "
			+ " from BenPersonalHabit a where a.beneficiaryRegID = :beneficiaryRegID AND benVisitID = :benVisitID")
		public ArrayList<Object[]> getBenPersonalAlcoholHabitDetail(@Param("beneficiaryRegID") Long beneficiaryRegID, @Param("benVisitID") Long benVisitID);
		
}
