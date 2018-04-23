package com.iemr.mmu.repo.nurse.anc;

import java.sql.Date;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.ANCDiagnosis;

@Repository
public interface ANCDiagnosisRepo extends CrudRepository<ANCDiagnosis, Long>{

	@Query(" SELECT ID, beneficiaryRegID, benVisitID, providerServiceMapID, highRiskStatus, highRiskCondition, complicationOfCurrentPregnancy, "
			+ "isMaternalDeath, placeOfDeath, dateOfDeath, causeOfDeath from ANCDiagnosis ba "
			+ "WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID AND ba.deleted = false ")
	public ArrayList<Object[]> getANCDiagnosisDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Query("SELECT processed from ANCDiagnosis where beneficiaryRegID=:benRegID AND benVisitID = :benVisitID")
	public String getANCDiagnosisStatus(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Transactional
	@Modifying
	@Query("update ANCDiagnosis set highRiskStatus=:highRiskStatus, highRiskCondition=:highRiskCondition, "
			+ "complicationOfCurrentPregnancy=:complicationOfCurrentPregnancy, isMaternalDeath=:isMaternalDeath, placeOfDeath=:placeOfDeath,"
			+ "dateOfDeath=:dateOfDeath, causeOfDeath=:causeOfDeath, modifiedBy=:modifiedBy, processed=:processed "
			+ "where benVisitID=:benVisitID AND beneficiaryRegID=:beneficiaryRegID AND prescriptionID=:prescriptionID")
	public int updateANCDiagnosis(@Param("highRiskStatus") String highRiskStatus,
			@Param("highRiskCondition") String highRiskCondition,
			@Param("complicationOfCurrentPregnancy") String complicationOfCurrentPregnancy,
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
