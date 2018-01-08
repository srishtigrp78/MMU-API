package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.anc.PhyHeadToToeExamination;

@Repository
public interface PhyHeadToToeExaminationRepo extends CrudRepository<PhyHeadToToeExamination, Long> {
	
	@Query(" SELECT u FROM PhyHeadToToeExamination u WHERE u.beneficiaryRegID = :benRegID AND u.benVisitID = :benVisitID ")
	public PhyHeadToToeExamination getPhyHeadToToeExaminationData(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	

	@Transactional
	@Modifying
	@Query("update PhyHeadToToeExamination set headtoToeExam=:headtoToeExam, head=:head, eyes=:eyes, ears=:ears, nose=:nose, oralCavity=:oralCavity,"
			+ "throat=:throat, breastAndNipples=:breastAndNipples, trunk=:trunk, upperLimbs =:upperLimbs, lowerLimbs=:lowerLimbs, skin=:skin, hair=:hair,"
			+ "nails=:nails, modifiedBy=:modifiedBy where beneficiaryRegID=:benRegID and benVisitID = :benVisitID ")
	public int updatePhyHeadToToeExamination(@Param("headtoToeExam") String headtoToeExam,
			@Param("head") String head,
			@Param("eyes") String eyes,
			@Param("ears") String ears,
			@Param("nose") String nose,
			@Param("oralCavity") String oralCavity,
			@Param("throat") String throat,
			@Param("breastAndNipples") String breastAndNipples,
			@Param("trunk") String trunk,
			@Param("upperLimbs") String upperLimbs,
			@Param("lowerLimbs") String lowerLimbs,
			@Param("skin") String skin,
			@Param("hair") String hair,
			@Param("nails") String nails,
			@Param("modifiedBy") String modifiedBy,
			@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
