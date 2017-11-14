package com.iemr.mmu.repo.nurse;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;

@Repository
public interface BenVisitDetailRepo extends CrudRepository<BeneficiaryVisitDetail, Long> {

	@Transactional
	@Modifying
	@Query("update BeneficiaryVisitDetail set visitReasonID=:visitReasonID, visitReason=:visitReason, visitCategoryID=:visitCategoryID, "
			+ " visitCategory=:visitCategory, pregnancyStatus=:pregnancyStatus, "
			+ "rCHID=:rCHID, healthFacilityType=:healthFacilityType, healthFacilityLocation=:healthFacilityLocation "
			+ ", modifiedBy=:modifiedBy where benVisitID=:benVisitID")
	public int updateBeneficiaryVisitDetail(@Param("visitReasonID") Short visitReasonID,
			@Param("visitReason") String visitReason, @Param("visitCategoryID") Integer visitCategoryID,
			@Param("visitCategory") String visitCategory, @Param("pregnancyStatus") String pregnancyStatus,
			@Param("rCHID") String rCHID, @Param("healthFacilityType") String healthFacilityType,
			@Param("healthFacilityLocation") String healthFacilityLocation,
			// @Param("reportFilePath") String reportFilePath,
			@Param("modifiedBy") String modifiedBy, @Param("benVisitID") Long benVisitID);

	@Query(" SELECT bvd from BeneficiaryVisitDetail bvd WHERE bvd.beneficiaryRegID = :benRegID AND bvd.benVisitID = :benVisitID ")
	public BeneficiaryVisitDetail getVisitDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);

	@Query(" SELECT bvd from BeneficiaryVisitDetail bvd WHERE bvd.beneficiaryRegID = :benRegID and DATE(CreatedDate)<curdate()")
	public List<BeneficiaryVisitDetail> getBeneficiaryVisitHistory(@Param("benRegID") Long benRegID);

	@Transactional
	@Modifying
	@Query("UPDATE BeneficiaryVisitDetail set visitFlowStatusFlag = :visitFlowStatusFlag, lastModDate = curdate() where benVisitID = :benVisitID ")
	public Integer updateBenFlowStatus(@Param("visitFlowStatusFlag") String visitFlowStatusFlag,
			@Param("benVisitID") Long benVisitID);
		
	@Query(" SELECT bvd.benVisitID, bvd.beneficiaryRegID, bvd.providerServiceMapID, bvd.visitDateTime, bvd.visitNo, bvd.visitReasonID, bvd.visitReason, "
			+ "bvd.visitCategoryID, bvd.visitCategory, bvd.pregnancyStatus, bvd.rCHID, bvd.healthFacilityType, bvd.healthFacilityLocation, "
			+ "bvd.reportFilePath,sp.serviceProviderName from BeneficiaryVisitDetail bvd "
			+ "INNER JOIN bvd.providerServiceMapping p "
			+ "INNER JOIN p.serviceProvider sp "
			+ "WHERE bvd.beneficiaryRegID = :benRegID AND bvd.benVisitID = :benVisitID AND DATE(bvd.createdDate) = :createdDate")
	public List<Objects[]> getBeneficiaryVisitDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID, @Param("createdDate") Date createdDate);
	
	

}
