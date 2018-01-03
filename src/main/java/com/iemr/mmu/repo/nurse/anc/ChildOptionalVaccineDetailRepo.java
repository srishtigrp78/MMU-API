package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.ChildOptionalVaccineDetail;

@Repository
public interface ChildOptionalVaccineDetailRepo extends CrudRepository<ChildOptionalVaccineDetail, Long>{

	@Query("select defaultReceivingAge, vaccineName, status, receivedDate, actualReceivingAge, receivedFacilityName "
			+ "from ChildOptionalVaccineDetail a where a.beneficiaryRegID = :beneficiaryRegID ORDER BY createdDate DESC ")
	public ArrayList<Object[]> getBenOptionalVaccineDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);
	
	
	@Query("select beneficiaryRegID, benVisitID, providerServiceMapID, defaultReceivingAge, vaccineName, status, receivedDate, actualReceivingAge, "
			+ "receivedFacilityName from ChildOptionalVaccineDetail a where a.beneficiaryRegID = :beneficiaryRegID and a.benVisitID = :benVisitID")
	public ArrayList<Object[]> getBenOptionalVaccineDetail(@Param("beneficiaryRegID") Long beneficiaryRegID, @Param("benVisitID") Long benVisitID);
	
	@Modifying
	@Transactional
	@Query(" Delete from ChildOptionalVaccineDetail WHERE beneficiaryRegID = :benRegID and benVisitID = :benVisitID")
		public int deleteExistingChildOptionalVaccineDetail(@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID);
	
}
