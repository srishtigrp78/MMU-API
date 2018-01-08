package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.anc.PhyGeneralExamination;

@Repository
public interface PhyGeneralExaminationRepo extends CrudRepository<PhyGeneralExamination, Long> {

	@Query(" SELECT u FROM PhyGeneralExamination u WHERE u.beneficiaryRegID = :benRegID AND u.benVisitID = :benVisitID ")
	public PhyGeneralExamination getPhyGeneralExaminationData(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);

	@Transactional
	@Modifying
	@Query("update PhyGeneralExamination set consciousness=:consciousness, cooperation=:cooperation, coherence=:coherence, comfortness=:comfortness, "
			+ "builtAndAppearance=:builtAndAppearance, gait=:gait, dangerSigns=:dangerSigns, typeOfDangerSign =:typeOfDangerSign, pallor=:pallor, jaundice=:jaundice, "
			+ "cyanosis=:cyanosis, clubbing=:clubbing, lymphadenopathy=:lymphadenopathy, lymphnodesInvolved=:lymphnodesInvolved, "
			+ "typeOfLymphadenopathy=:typeOfLymphadenopathy, edema=:edema, extentOfEdema=:extentOfEdema, edemaType=:edemaType,"
			+ " modifiedBy=:modifiedBy where beneficiaryRegID=:benRegID and benVisitID = :benVisitID ")
	public int updatePhyGeneralExamination(@Param("consciousness") String consciousness,
			@Param("coherence") String coherence,
			@Param("cooperation") String cooperation,
			@Param("comfortness") String comfortness,
			@Param("builtAndAppearance") String builtAndAppearance,
			@Param("gait") String gait,
			@Param("dangerSigns") String dangerSigns,
			@Param("typeOfDangerSign") String typeOfDangerSign,
			@Param("pallor") String pallor,
			@Param("jaundice") String jaundice,
			@Param("cyanosis") String cyanosis,
			@Param("clubbing") String clubbing,
			@Param("lymphadenopathy") String lymphadenopathy,
			@Param("typeOfLymphadenopathy") String typeOfLymphadenopathy,
			@Param("edema") String edema,
			@Param("extentOfEdema") String extentOfEdema,
			@Param("edemaType") String edemaType,
			@Param("modifiedBy") String modifiedBy,
			@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
