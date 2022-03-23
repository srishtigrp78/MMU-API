package com.iemr.mmu.repo.reports;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.reports.ReportMaster;

@Repository
@RestResource(exported = false)
public interface ReportMasterRepo extends CrudRepository<ReportMaster, Integer> {
	ArrayList<ReportMaster> findByServiceIDAndDeletedOrderByReportNameAsc(Integer serviceID, Boolean deleted);

	@Query(value = " CALL db_reporting.SP_PatientAttended(:fromDate, :toDate, :psmID, :vanID) ", nativeQuery = true)
	ArrayList<Object[]> get_report_PatientAttended(@Param("fromDate") Timestamp fromDate,
			@Param("toDate") Timestamp toDate, @Param("psmID") Integer psmID, @Param("vanID") Integer vanID);

	@Query(value = " CALL db_reporting.SP_TestConducted(:fromDate, :toDate, :psmID, :vanID) ", nativeQuery = true)
	ArrayList<Object[]> get_report_TestConducted(@Param("fromDate") Timestamp fromDate,
			@Param("toDate") Timestamp toDate, @Param("psmID") Integer psmID, @Param("vanID") Integer vanID);

	@Query(value = " CALL db_reporting.SP_LabTestresult(:fromDate, :toDate, :psmID, :vanID) ", nativeQuery = true)
	ArrayList<Object[]> get_report_LabTestResult(@Param("fromDate") Timestamp fromDate,
			@Param("toDate") Timestamp toDate, @Param("psmID") Integer psmID, @Param("vanID") Integer vanID);

	@Query(value = " CALL db_reporting.SP_PatientInfo(:fromDate, :toDate, :psmID, :vanID) ", nativeQuery = true)
	ArrayList<Object[]> get_report_PatientInfo(@Param("fromDate") Timestamp fromDate, @Param("toDate") Timestamp toDate,
			@Param("psmID") Integer psmID, @Param("vanID") Integer vanID);

	@Query(value = " CALL db_reporting.SP_ChildrenCases(:fromDate, :toDate, :psmID, :vanID) ", nativeQuery = true)
	ArrayList<Object[]> get_report_SP_ChildrenCases(@Param("fromDate") Timestamp fromDate,
			@Param("toDate") Timestamp toDate, @Param("psmID") Integer psmID, @Param("vanID") Integer vanID);

	@Query(value = " CALL db_reporting.SP_ANC(:fromDate, :toDate, :psmID, :vanID) ", nativeQuery = true)
	ArrayList<Object[]> get_report_SP_ANC(@Param("fromDate") Timestamp fromDate, @Param("toDate") Timestamp toDate,
			@Param("psmID") Integer psmID, @Param("vanID") Integer vanID);
	
//	@Query(value = " CALL db_reporting.SP_PatientVisitInfo(:fromDate, :toDate, :psmID, :vanID) ", nativeQuery = true)
//	ArrayList<Object[]> get_report_SP_ANC(@Param("fromDate") Timestamp fromDate, @Param("toDate") Timestamp toDate,
//			@Param("psmID") Integer psmID, @Param("vanID") Integer vanID);

	@Query(value = " CALL db_reporting.SP_ANCHighRisk(:fromDate, :toDate, :psmID, :vanID) ", nativeQuery = true)
	ArrayList<Object[]> get_report_SP_ANCHighRisk(@Param("fromDate") Timestamp fromDate,
			@Param("toDate") Timestamp toDate, @Param("psmID") Integer psmID, @Param("vanID") Integer vanID);
	
	
	  @Query(value =" CALL db_reporting.SP_PatientVisitInfo_SPARSHA(:fromDate, :toDate, :psmID, :vanID) ", nativeQuery= true)
	  ArrayList<Object[]> get_report_SP_PatientVisitInfo(@Param("fromDate") Timestamp fromDate,
		     @Param("toDate") Timestamp toDate, @Param("psmID") Integer psmID, @Param("vanID") Integer vanID);
	  
	  @Query(value =" CALL db_reporting.SP_LabTestresult_SPARSHA(:fromDate, :toDate, :psmID, :vanID) ", nativeQuery= true)
	  ArrayList<Object[]> get_report_SP_LabTestresult(@Param("fromDate") Timestamp fromDate,
		     @Param("toDate") Timestamp toDate, @Param("psmID") Integer psmID, @Param("vanID") Integer vanID);
	 
	  @Query(value =" CALL db_reporting.SP_PrescribedDrug_SPARSHA(:fromDate, :toDate, :psmID, :vanID) ", nativeQuery= true)
	  ArrayList<Object[]> get_report_SP_PrescribedDrug(@Param("fromDate") Timestamp fromDate,
		     @Param("toDate") Timestamp toDate, @Param("psmID") Integer psmID, @Param("vanID") Integer vanID);
	  
	  @Query(value =" CALL db_reporting.SP_PhyVitals_SPARSHA(:fromDate, :toDate, :psmID, :vanID) ", nativeQuery= true)
	  ArrayList<Object[]> get_report_SP_PhyVitals(@Param("fromDate") Timestamp fromDate,
		     @Param("toDate") Timestamp toDate, @Param("psmID") Integer psmID, @Param("vanID") Integer vanID);
	  
	  
	  
	  
}
