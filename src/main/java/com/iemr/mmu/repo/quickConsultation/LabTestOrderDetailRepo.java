package com.iemr.mmu.repo.quickConsultation;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;

@Repository
public interface LabTestOrderDetailRepo extends CrudRepository<LabTestOrderDetail, Long>{

	@Query(" SELECT labTestOrderID, beneficiaryRegID, benVisitID, providerServiceMapID,	prescriptionID, testID, testName, testingRequirements, "
			+ "isRadiologyImaging  from LabTestOrderDetail ba WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID ")
	public ArrayList<Object[]> getLabTestOrderDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
}
