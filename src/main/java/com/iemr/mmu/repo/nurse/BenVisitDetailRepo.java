package com.iemr.mmu.repo.nurse;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;

@Repository
public interface BenVisitDetailRepo extends CrudRepository<BeneficiaryVisitDetail, Long>{

	@Transactional
	@Modifying
	@Query("update BeneficiaryVisitDetail set visitReasonID=:visitReasonID, visitReason=:visitReason, visitCategoryID=:visitCategoryID, "
			+ " visitCategory=:visitCategory, pregnancyStatus=:pregnancyStatus, "
			+ "rCHID=:rCHID, healthFacilityType=:healthFacilityType, healthFacilityLocation=:healthFacilityLocation "
			+ ", modifiedBy=:modifiedBy where benVisitID=:benVisitID")
	public int updateBeneficiaryVisitDetail(@Param("visitReasonID") Short visitReasonID,
			@Param("visitReason") String visitReason,
			@Param("visitCategoryID") Integer visitCategoryID,
			@Param("visitCategory") String visitCategory,
			@Param("pregnancyStatus") String pregnancyStatus,
			@Param("rCHID") String rCHID,
			@Param("healthFacilityType") String healthFacilityType,
			@Param("healthFacilityLocation") String healthFacilityLocation,
			//@Param("reportFilePath") String reportFilePath,
			@Param("modifiedBy") String modifiedBy,
			@Param("benVisitID") Long benVisitID);
	
}
