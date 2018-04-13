package com.iemr.mmu.repo.benFlowStatus;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;

/***
 * 
 * @author NE298657
 *
 */
@Repository
public interface BeneficiaryFlowStatusRepo extends CrudRepository<BeneficiaryFlowStatus, Long> {
	@Query("SELECT  t from BeneficiaryFlowStatus t WHERE t.nurseFlag = 1 AND t.deleted = false AND Date(t.visitDate)  = curdate()")
	public ArrayList<BeneficiaryFlowStatus> getNurseWorklistNew();

	@Transactional
	@Modifying
	@Query("UPDATE BeneficiaryFlowStatus t set t.benVisitID = :benVisitID, t.VisitReason = :visitReason, "
			+ " t.VisitCategory = :visitCategory, t.nurseFlag = :nurseFlag, t.doctorFlag = :docFlag, "
			+ " t.labIteration = :labIteration WHERE t.beneficiaryRegID = :benRegID AND t.benVisitID IS NULL "
			+ " AND DATE(visitDate) is CURDATE() AND nurseFlag = 1 ")
	public int updateBenFlowStatusAfterNurseActivity(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID, @Param("visitReason") String visitReason,
			@Param("visitCategory") String visitCategory, @Param("nurseFlag") Short nurseFlag,
			@Param("docFlag") Short docFlag, @Param("labIteration") Short labIteration);

	@Query("SELECT  t.benFlowID, t.beneficiaryRegID, t.visitDate, t.benName, t.age, t.ben_age_val, t.genderID, t.genderName, "
			+ " t.villageName, t.districtName from BeneficiaryFlowStatus t "
			+ " Where t.beneficiaryRegID = :benRegID AND t.benFlowID = :benFlowID ")
	public ArrayList<Object[]> getBenDetailsForLeftSidePanel(@Param("benRegID") Long benRegID,
			@Param("benFlowID") Long benFlowID);

}
