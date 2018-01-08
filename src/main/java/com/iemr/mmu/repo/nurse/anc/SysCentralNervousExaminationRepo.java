package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.anc.SysCentralNervousExamination;

@Repository
public interface SysCentralNervousExaminationRepo extends CrudRepository<SysCentralNervousExamination, Long> {

	@Query(" SELECT u FROM SysCentralNervousExamination u WHERE u.beneficiaryRegID = :benRegID AND u.benVisitID = :benVisitID ")
	public SysCentralNervousExamination getSysCentralNervousExaminationData(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Transactional
	@Modifying
	@Query("update SysRespiratoryExamination set handedness=:handedness, cranialNervesExamination=:cranialNervesExamination, "
			+ "motorSystem=:motorSystem, sensorySystem=:sensorySystem, autonomicSystem =:autonomicSystem, "
			+ "cerebellarSigns=:cerebellarSigns, signsOfMeningealIrritation=:signsOfMeningealIrritation, skull =:skull, modifiedBy=:modifiedBy "
			+ "where beneficiaryRegID=:benRegID and benVisitID = :benVisitID ")
	public int updateSysCentralNervousExamination(@Param("handedness") String handedness,
			@Param("cranialNervesExamination") String cranialNervesExamination,
			@Param("motorSystem") String motorSystem,
			@Param("sensorySystem") String sensorySystem,
			@Param("autonomicSystem") String autonomicSystem,
			@Param("cerebellarSigns") String cerebellarSigns,
			@Param("signsOfMeningealIrritation") String signsOfMeningealIrritation,
			@Param("skull") String skull,
			@Param("modifiedBy") String modifiedBy,
			@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
