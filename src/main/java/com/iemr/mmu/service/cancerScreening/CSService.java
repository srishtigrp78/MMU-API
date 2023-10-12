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
package com.iemr.mmu.service.cancerScreening;

import java.util.List;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;

public interface CSService {

	public int UpdateCSHistoryNurseData(JsonObject jsnOBJ) throws Exception;

	public int updateBenVitalDetail(BenCancerVitalDetail benCancerVitalDetail);

	int updateCancerDiagnosisDetailsByOncologist(CancerDiagnosis cancerDiagnosis);

	public Long saveCancerScreeningNurseData(JsonObject jsnOBJ, String authorization)throws Exception;

	public Long saveCancerScreeningDoctorData(JsonObject jsnOBJ, String authorization)throws Exception;

	public String getBenDataFrmNurseToDocVisitDetailsScreen(Long benRegID, Long visitCode)throws Exception;

	public String getBenDataFrmNurseToDocHistoryScreen(Long benRegID, Long visitCode);

	public String getBenDataFrmNurseToDocVitalScreen(Long benRegID, Long visitCode);

	public String getBenDataFrmNurseToDocExaminationScreen(Long benRegID, Long visitCode);

	public String getBenFamilyHistoryData(Long benRegID);

	public String getBenPersonalHistoryData(Long benRegID);

	public String getBenPersonalDietHistoryData(Long benRegID);

	public String getBenObstetricHistoryData(Long benRegID);

	public String getBenCaseRecordFromDoctorCS(Long benRegID, Long visitCode);

	public int updateBenExaminationDetail(JsonObject jsnOBJ)throws Exception;

	public int updateCancerScreeningDoctorData(JsonObject jsnOBJ)throws Exception;

}
