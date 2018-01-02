package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.BenMedHistory;

@Repository
public interface BenMedHistoryRepo extends CrudRepository<BenMedHistory, Long> {

	@Query(" SELECT illnessType, otherIllnessType, Date(yearofIllness), surgeryType, otherSurgeryType, "
			+ " Date(yearofSurgery)  FROM BenMedHistory "
			+ " WHERE beneficiaryRegID = :benRegID AND (illnessType is not null OR surgeryType is not null ) ")
	public ArrayList<Object[]> getBenPastHistory(@Param("benRegID") Long benRegID);
	
	
	@Query(" SELECT beneficiaryRegID, benVisitID, providerServiceMapID, yearofIllness, illnessTypeID,  illnessType, otherIllnessType, "
			+ " surgeryID , surgeryType, yearofSurgery, otherSurgeryType, createdDate  FROM BenMedHistory "
			+ " WHERE beneficiaryRegID = :benRegID AND benVisitID = :benVisitID ")
	public ArrayList<Object[]> getBenPastHistory(@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID);
	
	@Modifying
	@Transactional
	@Query(" Delete from BenMedHistory WHERE beneficiaryRegID = :benRegID")
	public int deleteExistingBenMedHistory(@Param("benRegID") Long benRegID);

}
