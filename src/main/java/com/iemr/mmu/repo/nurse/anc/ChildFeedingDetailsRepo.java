package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.ChildFeedingDetails;

@Repository
public interface ChildFeedingDetailsRepo extends CrudRepository<ChildFeedingDetails, Long>{
	
	@Query("select Date(createdDate), childID, benMotherID, typeOfFeed, compFeedStartAge, noOfCompFeedPerDay, foodIntoleranceStatus,"
			+ " typeofFoodIntolerance "
			+ "from ChildFeedingDetails a where a.beneficiaryRegID = :beneficiaryRegID AND (typeOfFeed is not null OR "
			+ "compFeedStartAge is not null OR foodIntoleranceStatus is not null)"
			+ "AND deleted = false ORDER BY createdDate DESC ")
	public ArrayList<Object[]> getBenFeedingHistoryDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);
}
