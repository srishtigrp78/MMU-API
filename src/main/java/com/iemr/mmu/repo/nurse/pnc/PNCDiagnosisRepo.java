package com.iemr.mmu.repo.nurse.pnc;

import java.sql.Date;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.pnc.PNCDiagnosis;

@Repository
public interface PNCDiagnosisRepo extends CrudRepository<PNCDiagnosis, Long>{

	@Query(" SELECT beneficiaryRegID, benVisitID, providerServiceMapID, prescriptionID, provisionalDiagnosis, "
			+ "confirmatoryDiagnosis, isMaternalDeath, placeOfDeath, dateOfDeath, causeOfDeath from PNCDiagnosis ba "
			+ "WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID AND ba.deleted = false ")
	public ArrayList<Object[]> getPNCDiagnosisDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Query("SELECT processed from PNCDiagnosis where beneficiaryRegID=:benRegID AND benVisitID = :benVisitID")
	public String getPNCDiagnosisStatus(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Transactional
	@Modifying
	@Query("update PNCDiagnosis set provisionalDiagnosis=:provisionalDiagnosis, confirmatoryDiagnosis=:confirmatoryDiagnosis, "
			+ "isMaternalDeath=:isMaternalDeath, placeOfDeath=:placeOfDeath,"
			+ "dateOfDeath=:dateOfDeath, causeOfDeath=:causeOfDeath, modifiedBy=:modifiedBy, processed=:processed "
			+ "where benVisitID=:benVisitID AND beneficiaryRegID=:beneficiaryRegID AND prescriptionID=:prescriptionID")
	public int updatePNCDiagnosis(@Param("provisionalDiagnosis") String provisionalDiagnosis,
			@Param("confirmatoryDiagnosis") String confirmatoryDiagnosis,
			@Param("isMaternalDeath") Boolean isMaternalDeath,
			@Param("placeOfDeath") String placeOfDeath,
			@Param("dateOfDeath") Date dateOfDeath,
			@Param("causeOfDeath") String causeOfDeath,
			@Param("modifiedBy") String modifiedBy,
			@Param("processed") String processed,
			@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("benVisitID") Long benVisitID,
			@Param("prescriptionID") Long prescriptionID);
	
}
