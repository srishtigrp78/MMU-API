package com.iemr.mmu.repo.nurse.anc;

import java.util.ArrayList;

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
}
