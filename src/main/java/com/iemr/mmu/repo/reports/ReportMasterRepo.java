/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mmu.repo.reports;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.reports.ReportMaster;

@Repository
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
