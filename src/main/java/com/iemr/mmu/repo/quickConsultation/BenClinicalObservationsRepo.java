package com.iemr.mmu.repo.quickConsultation;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.quickConsultation.BenClinicalObservations;

@Repository
public interface BenClinicalObservationsRepo extends CrudRepository<BenClinicalObservations, Long>{

	@Query("select Date(createdDate), significantFindings  from BenClinicalObservations a where a.beneficiaryRegID = :beneficiaryRegID "
			+ "AND significantFindings is not null AND isForHistory = true AND deleted = false")
	public ArrayList<Object[]> getPreviousSignificantFindings(@Param("beneficiaryRegID") Long beneficiaryRegID);
	
	@Query(" SELECT beneficiaryRegID, benVisitID, providerServiceMapID, clinicalObservation, "
			+ "otherSymptoms, significantFindings, isForHistory, visitCode from BenClinicalObservations ba "
			+ "WHERE ba.beneficiaryRegID = :benRegID AND ba.deleted = false AND ba.visitCode = :visitCode")
	public ArrayList<Object[]> getFindingsData(@Param("benRegID") Long benRegID,
			@Param("visitCode") Long visitCode);
	
	@Query("SELECT processed from BenClinicalObservations where beneficiaryRegID=:benRegID AND visitCode = :visitCode")
	public String getBenClinicalObservationStatus(@Param("benRegID") Long benRegID,
			@Param("visitCode") Long visitCode);
	
	@Transactional
	@Modifying
	@Query("update BenClinicalObservations set clinicalObservation=:clinicalObservation, otherSymptoms=:otherSymptoms, "
			+ "significantFindings=:significantFindings, isForHistory=:isForHistory, "
			+ "  modifiedBy=:modifiedBy, processed=:processed where "
			+ "beneficiaryRegID=:beneficiaryRegID AND visitCode = :visitCode")
	public int updateBenClinicalObservations(
			@Param("clinicalObservation") String clinicalObservation,
			@Param("otherSymptoms") String otherSymptoms,
			@Param("significantFindings") String significantFindings,
			@Param("isForHistory") Boolean isForHistory,
			@Param("modifiedBy") String modifiedBy,
			@Param("processed") String processed,
			@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("visitCode") Long visitCode);
}
