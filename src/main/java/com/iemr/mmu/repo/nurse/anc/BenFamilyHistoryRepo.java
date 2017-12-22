package com.iemr.mmu.repo.nurse.anc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.BenFamilyHistory;

@Repository
public interface BenFamilyHistoryRepo extends CrudRepository<BenFamilyHistory, Long>{
	
	@Query("select familyMember, diseaseTypeID, diseaseType, otherDiseaseType, isGeneticDisorder, geneticDisorder, isConsanguineousMarrige "
			+ "from BenFamilyHistory a where a.beneficiaryRegID = :beneficiaryRegID")
	public ArrayList<Object[]> getBenFamilyHistoryDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);
	
	@Query(" SELECT beneficiaryRegID, benVisitID, providerServiceMapID, familyMember, diseaseTypeID, diseaseType, otherDiseaseType, "
			+ "isGeneticDisorder, geneticDisorder, isConsanguineousMarrige  FROM BenFamilyHistory "
			+ " WHERE beneficiaryRegID = :benRegID AND benVisitID = :benVisitID ")
	public ArrayList<Object[]> getBenFamilyHistoryDetail(@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID);
	
	
}
