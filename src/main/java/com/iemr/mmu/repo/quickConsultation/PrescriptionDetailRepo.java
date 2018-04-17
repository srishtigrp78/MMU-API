package com.iemr.mmu.repo.quickConsultation;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;

@Repository
public interface PrescriptionDetailRepo extends CrudRepository<PrescriptionDetail, Long>{

	@Query(" SELECT prescriptionID, beneficiaryRegID, benVisitID, providerServiceMapID, externalInvestigation "
			+ "from PrescriptionDetail ba WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID AND ba.deleted = false")
	public ArrayList<Object[]> getBenPrescription(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Query(" SELECT prescriptionID, beneficiaryRegID, benVisitID, providerServiceMapID, diagnosisProvided, instruction "
			+ "from PrescriptionDetail ba WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID AND ba.deleted = false")
	public ArrayList<Object[]> getGeneralOPDDiagnosisDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
