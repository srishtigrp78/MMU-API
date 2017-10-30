package com.iemr.mmu.repo.registrar;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.registrar.BeneficiaryDemographicData;

public interface RegistrarRepoBenDemoData extends CrudRepository<BeneficiaryDemographicData, Long> {
	
	@Transactional
	@Modifying
	@Query("UPDATE BeneficiaryDemographicData set countryID = :countryID,stateID = :stateID,districtID = :districtID,areaID = :areaID,servicePointID = :servicePointID,"
			+ " districtBranchID = :districtBranchID,communityID = :communityID,religionID = :religionID,occupationID = :occupationID, educationID = :educationID,"
			+ " incomeStatusID = :incomeStatusID, modifiedBy = :modifiedBy where beneficiaryRegID = :beneficiaryRegID ")
	public Integer updateBendemographicData(@Param("countryID") Integer countryID,
			@Param("stateID") Integer stateID,
			@Param("districtID") Integer districtID,
			@Param("areaID") Integer areaID,
			@Param("servicePointID") Integer servicePointID,
			@Param("districtBranchID") Integer districtBranchID,
			@Param("communityID") Short communityID,
			@Param("religionID") Short religionID,
			@Param("occupationID") Short occupationID,
			@Param("educationID") Short educationID,
			@Param("incomeStatusID") Short incomeStatusID,
			@Param("modifiedBy") String modifiedBy,
			@Param("beneficiaryRegID") Long beneficiaryRegID);
	
	
	
//	countryID
//	stateID
//	districtID
//	areaID
//	servicePointID
//	districtBranchID
//	communityID
//	religionID
//	occupationID
//	educationID
//	incomeStatusID

}
