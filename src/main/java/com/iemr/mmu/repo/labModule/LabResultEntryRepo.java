package com.iemr.mmu.repo.labModule;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.labModule.LabResultEntry;

@Repository
public interface LabResultEntryRepo extends CrudRepository<LabResultEntry, Long> {
	@Query("SELECT procedureID FROM LabResultEntry WHERE beneficiaryRegID = :benRegID AND "
			+ " benVisitID = :benVisitID ")
	ArrayList<Integer> findProcedureListByBeneficiaryRegIDAndBenVisitID(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);

	ArrayList<LabResultEntry> findByBeneficiaryRegIDAndVisitCodeOrderByProcedureIDAsc(Long benRegID, Long visitCode);
}
