package com.iemr.mmu.repo.nurse.ncdcare;

import java.sql.Date;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.ncdcare.NCDCareDiagnosis;

public interface NCDCareDiagnosisRepo extends CrudRepository<NCDCareDiagnosis, Long>
{

	@Query(" SELECT beneficiaryRegID, benVisitID, providerServiceMapID, prescriptionID, ncdScreeningCondition, ncdComplication, ncdCareType "
			+ "from NCDCareDiagnosis ba "
			+ "WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID and ba.deleted = false order by createdDate desc")
	public ArrayList<Object[]> getNCDCareDiagnosisDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Query("SELECT processed from NCDCareDiagnosis where beneficiaryRegID=:benRegID AND benVisitID = :benVisitID")
	public String getNCDCareDiagnosisStatus(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Transactional
	@Modifying
	@Query("update NCDCareDiagnosis set ncdScreeningCondition=:ncdScreeningCondition, ncdComplication=:ncdComplication, "
			+ "ncdCareType=:ncdCareType, modifiedBy=:modifiedBy, processed=:processed "
			+ "where benVisitID=:benVisitID AND beneficiaryRegID=:beneficiaryRegID")
	public int updateNCDCareDiagnosis(@Param("ncdScreeningCondition") String ncdScreeningCondition,
			@Param("ncdComplication") String ncdComplication,
			@Param("ncdCareType") String ncdCareType,
			@Param("modifiedBy") String modifiedBy,
			@Param("processed") String processed,
			@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("benVisitID") Long benVisitID);
}
