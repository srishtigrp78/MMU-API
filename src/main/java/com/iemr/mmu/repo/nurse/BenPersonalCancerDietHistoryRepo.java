package com.iemr.mmu.repo.nurse;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;

@Repository
public interface BenPersonalCancerDietHistoryRepo extends CrudRepository<BenPersonalCancerDietHistory, Long> {
	@Query("SELECT bpdh from BenPersonalCancerDietHistory bpdh  WHERE bpdh.beneficiaryRegID = :benRegID AND bpdh.benVisitID = :benVisitID")
	public BenPersonalCancerDietHistory getBenPersonaDietHistory(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);

	@Transactional
	@Modifying
	@Query("update BenPersonalCancerDietHistory set dietType=:dietType, fruitConsumptionDays=:fruitConsumptionDays, "
			+ "fruitQuantityPerDay=:fruitQuantityPerDay, vegetableConsumptionDays=:vegetableConsumptionDays, vegetableQuantityPerDay=:vegetableQuantityPerDay, "
			+ " intakeOfOutsidePreparedMeal=:intakeOfOutsidePreparedMeal, typeOfOilConsumed=:typeOfOilConsumed, physicalActivityType=:physicalActivityType,"
			+ " ssRadiationExposure=:ssRadiationExposure, isThyroidDisorder=:isThyroidDisorder,"
			+ " modifiedBy=:modifiedBy where iD=:iD")
	public int updateBenPersonalCancerDietHistory(@Param("dietType") String dietType,
			@Param("fruitConsumptionDays") Integer fruitConsumptionDays,
			@Param("fruitQuantityPerDay") Integer fruitQuantityPerDay,
			@Param("vegetableConsumptionDays") Integer vegetableConsumptionDays,
			@Param("vegetableQuantityPerDay") Integer vegetableQuantityPerDay,
			@Param("intakeOfOutsidePreparedMeal") Integer intakeOfOutsidePreparedMeal,
			@Param("typeOfOilConsumed") String typeOfOilConsumed,
			@Param("physicalActivityType") String physicalActivityType,
			@Param("ssRadiationExposure") Boolean ssRadiationExposure,
			@Param("isThyroidDisorder") Boolean isThyroidDisorder, @Param("modifiedBy") String modifiedBy,
			@Param("iD") Long iD);

}
