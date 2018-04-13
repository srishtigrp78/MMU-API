package com.iemr.mmu.repo.quickConsultation;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.quickConsultation.BenClinicalObservations;

@Repository
public interface BenClinicalObservationsRepo extends CrudRepository<BenClinicalObservations, Long>{

	@Query("select Date(createdDate), significantFindings  from BenClinicalObservations a where a.beneficiaryRegID = :beneficiaryRegID "
			+ "AND significantFindings is not null AND isForHistory = true AND deleted = false")
	public ArrayList<Object[]> getPreviousSignificantFindings(@Param("beneficiaryRegID") Long beneficiaryRegID);
}
