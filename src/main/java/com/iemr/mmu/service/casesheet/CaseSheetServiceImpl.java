package com.iemr.mmu.service.casesheet;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.doctor.CancerExaminationImageAnnotation;
import com.iemr.mmu.data.doctor.WrapperCancerExamImgAnotasn;
import com.iemr.mmu.repo.doctor.CancerExaminationImageAnnotationRepo;
import com.iemr.mmu.service.doctor.DoctorServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.service.registrar.RegistrarServiceImpl;

@Service
public class CaseSheetServiceImpl {

	private NurseServiceImpl nurseServiceImpl;
	private DoctorServiceImpl doctorServiceImpl;
	private RegistrarServiceImpl registrarServiceImpl;
	private CancerExaminationImageAnnotationRepo cancerExaminationImageAnnotationRepo;

	@Autowired
	public void setCancerExaminationImageAnnotationRepo(
			CancerExaminationImageAnnotationRepo cancerExaminationImageAnnotationRepo) {
		this.cancerExaminationImageAnnotationRepo = cancerExaminationImageAnnotationRepo;
	}

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	@Autowired
	public void setDoctorServiceImpl(DoctorServiceImpl doctorServiceImpl) {
		this.doctorServiceImpl = doctorServiceImpl;
	}
	
	@Autowired
	public void setRegistrarServiceImpl(RegistrarServiceImpl registrarServiceImpl) {
		this.registrarServiceImpl = registrarServiceImpl;
	}

	public String getBenDataForCaseSheet(Long benRegID, Long benVisitID, Date visitDateTime) {
		Map<String, Object> caseSheetData = nurseServiceImpl.getBenNurseDataForCaseSheet(benRegID, benVisitID,
				visitDateTime);
		caseSheetData
				.putAll(doctorServiceImpl.getBenDoctorEnteredDataForCaseSheet(benRegID, benVisitID, visitDateTime));
		caseSheetData.put("BeneficiaryDemographicData", registrarServiceImpl.getBeneficiaryDemographicData(benRegID));
		return new Gson().toJson(caseSheetData);
	}

	public String getBeneficiaryCaseSheetHistory(Long benRegID) {
		String caseSheetHistory = nurseServiceImpl.getBeneficiaryVisitHistory(benRegID);
		return caseSheetHistory;
	}

	public String getCancerExaminationImageAnnotation(Long benRegID, Long benVisitID) {
		ArrayList<WrapperCancerExamImgAnotasn> resList = new ArrayList<>();
		//System.out.println("hello");
		List<CancerExaminationImageAnnotation> cancerExaminationImageAnnotationList = cancerExaminationImageAnnotationRepo
				.getCancerExaminationImageAnnotationList(benRegID, benVisitID);

		if (cancerExaminationImageAnnotationList.size() > 0) {
			int a = 0;
			int b = 0;

			ArrayList<Map<String, Object>> markerList = null;
			Map<String, Object> markerMap;

			WrapperCancerExamImgAnotasn wrapperCancerExamImgAnotasnOBJ = null;

			for (CancerExaminationImageAnnotation obj : cancerExaminationImageAnnotationList) {
				markerMap = new HashMap<String, Object>();
				b = obj.getCancerImageID();
				if (a != b) {
					wrapperCancerExamImgAnotasnOBJ = new WrapperCancerExamImgAnotasn();
					wrapperCancerExamImgAnotasnOBJ.setBeneficiaryRegID(benRegID);
					wrapperCancerExamImgAnotasnOBJ.setVisitID(benVisitID);
					wrapperCancerExamImgAnotasnOBJ.setProviderServiceMapID(obj.getProviderServiceMapID());
					wrapperCancerExamImgAnotasnOBJ.setCreatedBy(obj.getCreatedBy());
					wrapperCancerExamImgAnotasnOBJ.setImageID(obj.getCancerImageID());

					markerList = new ArrayList<>();
					markerMap.put("xCord", obj.getxCoordinate());
					markerMap.put("yCord", obj.getyCoordinate());
					markerMap.put("description", obj.getPointDesc());
					markerMap.put("point", obj.getPoint());

					markerList.add(markerMap);

					wrapperCancerExamImgAnotasnOBJ.setMarkers(markerList);

					resList.add(wrapperCancerExamImgAnotasnOBJ);

				} else {
					markerMap.put("xCord", obj.getxCoordinate());
					markerMap.put("yCord", obj.getyCoordinate());
					markerMap.put("description", obj.getPointDesc());
					markerMap.put("point", obj.getPoint());

					markerList.add(markerMap);
					wrapperCancerExamImgAnotasnOBJ.setMarkers(markerList);
				}

				a = b;

			}

		} else {

		}
	//	System.out.println("hello");
		return new Gson().toJson(resList);
	}
}
