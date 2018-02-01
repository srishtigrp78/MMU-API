package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.BenMedicationHistory;

@Repository
public interface BenMedicationHistoryRepo extends CrudRepository<BenMedicationHistory, Long>{

	@Query("select Date(createdDate), currentMedication, Date(year) from BenMedicationHistory a where a.beneficiaryRegID = :beneficiaryRegID"
			+ " AND currentMedication is not null AND deleted = false order by createdDate DESC")
		public ArrayList<Object[]> getBenMedicationHistoryDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);
	
		@Query(" SELECT beneficiaryRegID, benVisitID, providerServiceMapID, currentMedication, year, createdDate  FROM BenMedicationHistory "
				+ " WHERE beneficiaryRegID = :benRegID AND benVisitID = :benVisitID ")
		public ArrayList<Object[]> getBenMedicationHistoryDetail(@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID);
	
		@Modifying
		@Transactional
		@Query(" Delete from BenMedicationHistory WHERE beneficiaryRegID = :benRegID and benVisitID = :benVisitID")
		public int deleteExistingBenMedicationHistory(@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID);
}
