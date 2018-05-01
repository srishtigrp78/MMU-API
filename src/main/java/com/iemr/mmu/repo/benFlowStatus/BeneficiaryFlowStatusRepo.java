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
	@Query("SELECT  t from BeneficiaryFlowStatus t WHERE (t.nurseFlag = 1 OR t.nurseFlag = 100) AND t.deleted = false "
			+ " AND Date(t.visitDate)  = curdate()")
	public ArrayList<BeneficiaryFlowStatus> getNurseWorklistNew();

	@Transactional
	@Modifying
	@Query("UPDATE BeneficiaryFlowStatus t set t.benVisitID = :benVisitID, t.VisitReason = :visitReason, "
			+ " t.VisitCategory = :visitCategory, t.nurseFlag = :nurseFlag, t.doctorFlag = :docFlag, "
			+ " t.labIteration = :labIteration, t.lab_technician_flag = 0, t.radiologist_flag = :radiologistFlag, "
			+ " t.oncologist_flag = :oncologistFlag  WHERE t.benFlowID = :benFlowID AND t.beneficiaryRegID = :benRegID "
			+ " AND nurseFlag = 1  ")
	public int updateBenFlowStatusAfterNurseActivity(@Param("benFlowID") Long benFlowID,
			@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID,
			@Param("visitReason") String visitReason, @Param("visitCategory") String visitCategory,
			@Param("nurseFlag") Short nurseFlag, @Param("docFlag") Short docFlag,
			@Param("labIteration") Short labIteration, @Param("radiologistFlag") Short radiologistFlag,
			@Param("oncologistFlag") Short oncologistFlag);

	@Query("SELECT  t.benFlowID, t.beneficiaryRegID, t.visitDate, t.benName, t.age, t.ben_age_val, t.genderID, t.genderName, "
			+ " t.villageName, t.districtName, t.beneficiaryID, t.servicePointName from BeneficiaryFlowStatus t "
			+ " Where t.beneficiaryRegID = :benRegID AND t.benFlowID = :benFlowID ")
	public ArrayList<Object[]> getBenDetailsForLeftSidePanel(@Param("benRegID") Long benRegID,
			@Param("benFlowID") Long benFlowID);

	@Query("SELECT t from BeneficiaryFlowStatus t WHERE (t.doctorFlag = 1 OR t.doctorFlag = 2 OR "
			+ " t.doctorFlag = 3 OR t.nurseFlag = 2 OR t.doctorFlag = 9) AND t.deleted = false")
	public ArrayList<BeneficiaryFlowStatus> getDocWorkListNew();

	@Query("SELECT  t.benFlowID from BeneficiaryFlowStatus t WHERE t.beneficiaryRegID = :benRegID AND "
			+ " (t.nurseFlag = 1 OR t.nurseFlag = 100) AND Date(t.visitDate)  = curdate() AND t.deleted = false")
	public ArrayList<Long> checkBenAlreadyInNurseWorkList(@Param("benRegID") Long benRegID);

	@Query("SELECT t from BeneficiaryFlowStatus t WHERE (t.nurseFlag = 2 OR t.doctorFlag = 2) AND t.deleted = false")
	public ArrayList<BeneficiaryFlowStatus> getLabWorklistNew();

	@Transactional
	@Modifying
	@Query("UPDATE BeneficiaryFlowStatus t set t.doctorFlag = :docFlag , t.pharmacist_flag = :pharmaFlag, "
			+ " t.oncologist_flag = :oncologistFlag " + " WHERE t.benFlowID = :benFlowID AND "
			+ " t.beneficiaryRegID = :benRegID AND t.beneficiaryID = :benID AND t.benVisitID = :benVisitID ")
	public int updateBenFlowStatusAfterDoctorActivity(@Param("benFlowID") Long benFlowID,
			@Param("benRegID") Long benRegID, @Param("benID") Long benID, @Param("benVisitID") Long benVisitID,
			@Param("docFlag") Short docFlag, @Param("pharmaFlag") Short pharmaFlag,
			@Param("oncologistFlag") Short oncologistFlag);

	@Transactional
	@Modifying
	@Query("UPDATE BeneficiaryFlowStatus t set t.doctorFlag = :docFlag , t.pharmacist_flag = :pharmaFlag, "
			+ " t.oncologist_flag = :oncologistFlag " + " WHERE t.benFlowID = :benFlowID AND "
			+ " t.beneficiaryRegID = :benRegID AND t.beneficiaryID = :benID AND t.benVisitID = :benVisitID ")
	public int updateBenFlowStatusAfterDoctorActivityUpdate(@Param("benFlowID") Long benFlowID,
			@Param("benRegID") Long benRegID, @Param("benID") Long benID, @Param("benVisitID") Long benVisitID,
			@Param("docFlag") Short docFlag, @Param("pharmaFlag") Short pharmaFlag,
			@Param("oncologistFlag") Short oncologistFlag);

	@Query("SELECT t from BeneficiaryFlowStatus t WHERE t.radiologist_flag = 1")
	public ArrayList<BeneficiaryFlowStatus> getRadiologistWorkListNew();

	@Query("SELECT t from BeneficiaryFlowStatus t WHERE t.oncologist_flag = 1")
	public ArrayList<BeneficiaryFlowStatus> getOncologistWorkListNew();

	@Query("SELECT t from BeneficiaryFlowStatus t WHERE t.pharmacist_flag = 1")
	public ArrayList<BeneficiaryFlowStatus> getPharmaWorkListNew();

	@Query("SELECT t.pharmacist_flag from BeneficiaryFlowStatus t WHERE t.benFlowID = :benFlowID")
	public Short getPharmaFlag(@Param("benFlowID") Long benFlowID);

	@Transactional
	@Modifying
	@Query("UPDATE BeneficiaryFlowStatus t set t.nurseFlag = :nurseFlag where t.benFlowID = :benFlowID AND t.beneficiaryRegID = :benRegID ")
	public int updateBenFlowStatusAfterNurseDataUpdateNCD_Screening(@Param("benFlowID") Long benFlowID,
			@Param("benRegID") Long benRegID, @Param("nurseFlag") Short nurseFlag);

	@Transactional
	@Modifying
	@Query("UPDATE BeneficiaryFlowStatus t set t.nurseFlag = :nurseFlag, t.doctorFlag = :doctorFlag, t.lab_technician_flag = :labFlag "
			+ " WHERE t.benFlowID = :benFlowID AND t.beneficiaryRegID = :benRegID AND t.benVisitID = :benVisitID ")
	public int updateBenFlowStatusAfterLabResultEntry(@Param("benFlowID") Long benFlowID,
			@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID, @Param("nurseFlag") Short nurseFlag,
			@Param("doctorFlag") Short doctorFlag, @Param("labFlag") Short labFlag);

}
