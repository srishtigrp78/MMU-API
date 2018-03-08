package com.iemr.mmu.repo.doctor;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.doctor.CancerDiagnosis;

@Repository
public interface CancerDiagnosisRepo extends CrudRepository<CancerDiagnosis, Long> {

	@Query(" SELECT c from CancerDiagnosis c  WHERE c.beneficiaryRegID = :benRegID AND c.benVisitID = :benVisitID "
			+ " AND c.deleted = false")
	public CancerDiagnosis getBenCancerDiagnosisDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);

	@Query(" SELECT ID, processed  from CancerDiagnosis c  WHERE c.beneficiaryRegID = :benRegID AND c.benVisitID = :benVisitID ")
	public ArrayList<Object[]> checkDiagonosisDataAvailableForBen(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);

	@Transactional
	@Modifying
	@Query(" update CancerDiagnosis set provisionalDiagnosisOncologist=:provisionalDiagnosisOncologist, modifiedBy=:modifiedBy "
			+ "WHERE beneficiaryRegID = :benRegID AND benVisitID = :benVisitID")
	public int updateDetailsByOncologist(@Param("provisionalDiagnosisOncologist") String provisionalDiagnosisOncologist,
			@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID,
			@Param("modifiedBy") String modifiedBy);

}
