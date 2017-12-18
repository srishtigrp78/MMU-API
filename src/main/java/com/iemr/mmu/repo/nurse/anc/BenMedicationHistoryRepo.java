package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.BenMedicationHistory;

@Repository
public interface BenMedicationHistoryRepo extends CrudRepository<BenMedicationHistory, Long>{

	@Query("select currentMedication, year from BenMedicationHistory a where a.beneficiaryRegID = :beneficiaryRegID")
		public ArrayList<Object[]> getBenMedicationHistoryDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);
		
}
