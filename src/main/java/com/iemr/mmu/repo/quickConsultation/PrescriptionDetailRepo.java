package com.iemr.mmu.repo.quickConsultation;

import java.sql.Date;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;

@Repository
public interface PrescriptionDetailRepo extends CrudRepository<PrescriptionDetail, Long>{

	@Query(" SELECT prescriptionID, beneficiaryRegID, benVisitID, providerServiceMapID, diagnosisProvided, instruction, externalInvestigation "
			+ "from PrescriptionDetail ba WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID AND ba.deleted = false")
	public ArrayList<Object[]> getBenPrescription(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Query(" SELECT prescriptionID, beneficiaryRegID, benVisitID, providerServiceMapID, diagnosisProvided, instruction "
			+ "from PrescriptionDetail ba WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID AND ba.deleted = false")
	public ArrayList<Object[]> getGeneralOPDDiagnosisDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Query("SELECT processed from PrescriptionDetail where beneficiaryRegID=:benRegID AND benVisitID = :benVisitID")
	public String getGeneralOPDDiagnosisStatus(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Transactional
	@Modifying
	@Query("update PrescriptionDetail set diagnosisProvided=:diagnosisProvided, instruction=:instruction, "
			+ "modifiedBy=:modifiedBy, processed=:processed "
			+ "where benVisitID=:benVisitID AND beneficiaryRegID=:beneficiaryRegID AND prescriptionID=:prescriptionID")
	public int updateGeneralOPDDiagnosis(@Param("diagnosisProvided") String diagnosisProvided,
			@Param("instruction") String instruction,
			@Param("modifiedBy") String modifiedBy,
			@Param("processed") String processed,
			@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("benVisitID") Long benVisitID,
			@Param("prescriptionID") Long prescriptionID);
	
}
