package com.iemr.mmu.repo.nurse.anc;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.BenAllergyHistory;

@Repository
public interface BenAllergyHistoryRepo extends CrudRepository<BenAllergyHistory, Long> {

	@Query("select Date(createdDate), allergyStatus, allergyType, allergyName, allergicReactionType, otherAllergicReaction, remarks "
			+ " from BenAllergyHistory a where a.beneficiaryRegID = :beneficiaryRegID AND allergyStatus is not null and deleted = false "
			+ "order by createdDate DESC")
	public ArrayList<Object[]> getBenPersonalAllergyDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);

	@Query(" SELECT beneficiaryRegID, benVisitID, providerServiceMapID, allergyStatus, allergyType, allergyName, allergicReactionTypeID, "
			+ "allergicReactionType, otherAllergicReaction, remarks  FROM BenAllergyHistory "
			+ " WHERE beneficiaryRegID = :benRegID AND benVisitID = :benVisitID ")
	public ArrayList<Object[]> getBenPersonalAllergyDetail(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);

	@Modifying
	@Transactional
	@Query(" Delete from BenAllergyHistory WHERE beneficiaryRegID = :benRegID and benVisitID = :benVisitID")
	public int deleteExistingBenAllergyHistory(@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID);
}
