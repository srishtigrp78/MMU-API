package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.ChildOptionalVaccineDetail;

@Repository
public interface ChildOptionalVaccineDetailRepo extends CrudRepository<ChildOptionalVaccineDetail, Long>{

	@Query("select defaultReceivingAge, vaccineName, status, receivedDate, actualReceivingAge, receivedFacilityName "
			+ "from ChildOptionalVaccineDetail a where a.beneficiaryRegID = :beneficiaryRegID")
	public ArrayList<Object[]> getBenOptionalVaccineDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);
	
}
