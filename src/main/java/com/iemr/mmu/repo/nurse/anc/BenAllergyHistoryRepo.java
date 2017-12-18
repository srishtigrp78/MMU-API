package com.iemr.mmu.repo.nurse.anc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.BenAllergyHistory;

@Repository
public interface BenAllergyHistoryRepo extends CrudRepository<BenAllergyHistory, Long>{

	@Query("select allergyStatus, allergyType, allergenName, allergicReactionTypeID, allergicReactionType, otherAllergicReaction, remarks "
			+ " from BenAllergyHistory a where a.beneficiaryRegID = :beneficiaryRegID AND benVisitID = :benVisitID")
		public ArrayList<Object[]> getBenPersonalAllergyDetail(@Param("beneficiaryRegID") Long beneficiaryRegID, @Param("benVisitID") Long benVisitID);
		
}
