package com.iemr.mmu.service.doctor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.doctor.CancerAbdominalExamination;
import com.iemr.mmu.data.doctor.CancerBreastExamination;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.doctor.CancerExaminationImageAnnotation;
import com.iemr.mmu.data.doctor.CancerGynecologicalExamination;
import com.iemr.mmu.data.doctor.CancerLymphNodeDetails;
import com.iemr.mmu.data.doctor.CancerOralExamination;
import com.iemr.mmu.data.doctor.CancerSignAndSymptoms;
import com.iemr.mmu.data.doctor.ChiefComplaintMaster;
import com.iemr.mmu.data.doctor.DrugDoseMaster;
import com.iemr.mmu.data.doctor.DrugDurationUnitMaster;
import com.iemr.mmu.data.doctor.DrugFormMaster;
import com.iemr.mmu.data.doctor.DrugFrequencyMaster;
import com.iemr.mmu.data.doctor.LabTestMaster;
import com.iemr.mmu.data.doctor.TempMasterDrug;
import com.iemr.mmu.data.doctor.WrapperCancerExamImgAnotasn;
import com.iemr.mmu.data.registrar.WrapperRegWorklist;
import com.iemr.mmu.repo.doctor.CancerAbdominalExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerBreastExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerDiagnosisRepo;
import com.iemr.mmu.repo.doctor.CancerExaminationImageAnnotationRepo;
import com.iemr.mmu.repo.doctor.CancerGynecologicalExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerLymphNodeExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerOralExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerSignAndSymptomsRepo;
import com.iemr.mmu.repo.doctor.ChiefComplaintMasterRepo;
import com.iemr.mmu.repo.doctor.DocWorkListRepo;
import com.iemr.mmu.repo.doctor.DrugDoseMasterRepo;
import com.iemr.mmu.repo.doctor.DrugDurationUnitMasterRepo;
import com.iemr.mmu.repo.doctor.DrugFormMasterRepo;
import com.iemr.mmu.repo.doctor.DrugFrequencyMasterRepo;
import com.iemr.mmu.repo.doctor.LabTestMasterRepo;
import com.iemr.mmu.repo.doctor.TempMasterDrugRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;
import com.iemr.mmu.repo.registrar.ReistrarRepoBenSearch;

@Service
public class DoctorServiceImpl implements DoctorService {

	private CancerAbdominalExaminationRepo cancerAbdominalExaminationRepo;
	private CancerBreastExaminationRepo cancerBreastExaminationRepo;
	private CancerDiagnosisRepo cancerDiagnosisRepo;
	private CancerGynecologicalExaminationRepo cancerGynecologicalExaminationRepo;
	private CancerLymphNodeExaminationRepo cancerLymphNodeExaminationRepo;
	private CancerOralExaminationRepo cancerOralExaminationRepo;
	private CancerSignAndSymptomsRepo cancerSignAndSymptomsRepo;
	private ReistrarRepoBenSearch reistrarRepoBenSearch;
	private DocWorkListRepo docWorkListRepo;
	private BenVisitDetailRepo benVisitDetailRepo;

	private ChiefComplaintMasterRepo chiefComplaintMasterRepo;
	private DrugDoseMasterRepo drugDoseMasterRepo;
	private DrugDurationUnitMasterRepo drugDurationUnitMasterRepo;
	private DrugFormMasterRepo drugFormMasterRepo;
	private DrugFrequencyMasterRepo drugFrequencyMasterRepo;
	private LabTestMasterRepo labTestMasterRepo;
	private CancerExaminationImageAnnotationRepo cancerExaminationImageAnnotationRepo;

	@Autowired
	public void setCancerExaminationImageAnnotationRepo(
			CancerExaminationImageAnnotationRepo cancerExaminationImageAnnotationRepo) {
		this.cancerExaminationImageAnnotationRepo = cancerExaminationImageAnnotationRepo;
	}

	@Autowired
	public void setChiefComplaintMasterRepo(ChiefComplaintMasterRepo chiefComplaintMasterRepo) {
		this.chiefComplaintMasterRepo = chiefComplaintMasterRepo;
	}

	@Autowired
	public void setDrugDoseMasterRepo(DrugDoseMasterRepo drugDoseMasterRepo) {
		this.drugDoseMasterRepo = drugDoseMasterRepo;
	}

	@Autowired
	public void setDrugDurationUnitMasterRepo(DrugDurationUnitMasterRepo drugDurationUnitMasterRepo) {
		this.drugDurationUnitMasterRepo = drugDurationUnitMasterRepo;
	}

	@Autowired
	public void setDrugFormMasterRepo(DrugFormMasterRepo drugFormMasterRepo) {
		this.drugFormMasterRepo = drugFormMasterRepo;
	}

	@Autowired
	public void setDrugFrequencyMasterRepo(DrugFrequencyMasterRepo drugFrequencyMasterRepo) {
		this.drugFrequencyMasterRepo = drugFrequencyMasterRepo;
	}

	@Autowired
	public void setLabTestMasterRepo(LabTestMasterRepo labTestMasterRepo) {
		this.labTestMasterRepo = labTestMasterRepo;
	}

	@Autowired
	public void setBenVisitDetailRepo(BenVisitDetailRepo benVisitDetailRepo) {
		this.benVisitDetailRepo = benVisitDetailRepo;
	}

	@Autowired
	public void setDocWorkListRepo(DocWorkListRepo docWorkListRepo) {
		this.docWorkListRepo = docWorkListRepo;
	}

	@Autowired
	public void setReistrarRepoBenSearch(ReistrarRepoBenSearch reistrarRepoBenSearch) {
		this.reistrarRepoBenSearch = reistrarRepoBenSearch;
	}

	@Autowired
	public void setCancerAbdominalExaminationRepo(CancerAbdominalExaminationRepo cancerAbdominalExaminationRepo) {
		this.cancerAbdominalExaminationRepo = cancerAbdominalExaminationRepo;
	}

	@Autowired
	public void setCancerBreastExaminationRepo(CancerBreastExaminationRepo cancerBreastExaminationRepo) {
		this.cancerBreastExaminationRepo = cancerBreastExaminationRepo;
	}

	@Autowired
	public void setCancerDiagnosisRepo(CancerDiagnosisRepo cancerDiagnosisRepo) {
		this.cancerDiagnosisRepo = cancerDiagnosisRepo;
	}

	@Autowired
	public void setCancerGynecologicalExaminationRepo(
			CancerGynecologicalExaminationRepo cancerGynecologicalExaminationRepo) {
		this.cancerGynecologicalExaminationRepo = cancerGynecologicalExaminationRepo;
	}

	@Autowired
	public void setCancerLymphNodeExaminationRepo(CancerLymphNodeExaminationRepo cancerLymphNodeExaminationRepo) {
		this.cancerLymphNodeExaminationRepo = cancerLymphNodeExaminationRepo;
	}

	@Autowired
	public void setCancerOralExaminationRepo(CancerOralExaminationRepo cancerOralExaminationRepo) {
		this.cancerOralExaminationRepo = cancerOralExaminationRepo;
	}

	@Autowired
	public void setCancerSignAndSymptomsRepo(CancerSignAndSymptomsRepo cancerSignAndSymptomsRepo) {
		this.cancerSignAndSymptomsRepo = cancerSignAndSymptomsRepo;
	}

	@Deprecated
	@Override
	public Long saveCancerAbdominalExaminationData(CancerAbdominalExamination cancerAbdominalExamination) {
		CancerAbdominalExamination response = cancerAbdominalExaminationRepo.save(cancerAbdominalExamination);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Deprecated
	@Override
	public Long saveCancerBreastExaminationData(CancerBreastExamination cancerBreastExamination) {
		CancerBreastExamination response = cancerBreastExaminationRepo.save(cancerBreastExamination);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Deprecated
	@Override
	public Long saveCancerDiagnosisData(CancerDiagnosis cancerDiagnosis) {

		List<String> refrredToAdditionalServiceList = cancerDiagnosis.getRefrredToAdditionalServiceList();
		String refrredToAdditionalServiceData = "";
		if (refrredToAdditionalServiceList != null && refrredToAdditionalServiceList.size() > 0) {
			for (String refrredToAdditionalService : refrredToAdditionalServiceList) {
				refrredToAdditionalServiceData += refrredToAdditionalService + ",";
			}
		}
		cancerDiagnosis.setRefrredToAdditionalService(refrredToAdditionalServiceData);
		CancerDiagnosis response = cancerDiagnosisRepo.save(cancerDiagnosis);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Deprecated
	@Override
	public Long saveCancerGynecologicalExaminationData(CancerGynecologicalExamination cancerGynecologicalExamination) {
		List<String> typeOfLesionList = cancerGynecologicalExamination.getTypeOfLesionList();
		String typeOfLesionData = "";
		if (typeOfLesionList != null && typeOfLesionList.size() > 0) {
			for (String typeOfLesion : typeOfLesionList) {
				typeOfLesionData += typeOfLesion + ",";
			}
		}
		cancerGynecologicalExamination.setTypeOfLesion(typeOfLesionData);

		CancerGynecologicalExamination response = cancerGynecologicalExaminationRepo
				.save(cancerGynecologicalExamination);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Deprecated
	@Override
	public int saveLymphNodeDetails(List<CancerLymphNodeDetails> cancerLymphNodeDetails) {
		int responseData = 0;
		List<CancerLymphNodeDetails> response = (List<CancerLymphNodeDetails>) cancerLymphNodeExaminationRepo
				.save(cancerLymphNodeDetails);
		for (CancerLymphNodeDetails obj : response) {
			if (obj.getID() > 0)
				responseData = 1;
		}
		return responseData;
	}

	@Deprecated
	@Override
	public Long saveCancerOralExaminationData(CancerOralExamination cancerOralExamination) {
		List<String> preMalignantLesionTypeList = cancerOralExamination.getPreMalignantLesionTypeList();
		String preMalignantLesionTypeData = "";
		if (preMalignantLesionTypeList != null && preMalignantLesionTypeList.size() > 0) {
			for (String preMalignantLesionType : cancerOralExamination.getPreMalignantLesionTypeList()) {
				preMalignantLesionTypeData += preMalignantLesionType + ",";
			}
		}
		cancerOralExamination.setPreMalignantLesionType(preMalignantLesionTypeData);

		CancerOralExamination response = cancerOralExaminationRepo.save(cancerOralExamination);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Deprecated
	@Override
	public Long saveCancerSignAndSymptomsData(CancerSignAndSymptoms cancerSignAndSymptoms) {
		CancerSignAndSymptoms response = cancerSignAndSymptomsRepo.save(cancerSignAndSymptoms);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	public String getDocWorkList() {
		List<Object[]> docWorkListData = docWorkListRepo.getDocWorkList();
		// System.out.println("hello");
		return WrapperRegWorklist.getDocWorkListData(docWorkListData);
	}

	public Map<String, Object> getBenDoctorEnteredDataForCaseSheet(Long benRegID, Long benVisitID, Date visitDateTime) {
		Map<String, Object> resMap = new HashMap<>();

		// System.out.println("getBenDoctorEnteredDataForCaseSheet");
		resMap.put("abdominalExamination", getBenCancerAbdominalExaminationData(benRegID, benVisitID, visitDateTime));

		resMap.put("breastExamination", getBenCancerBreastExaminationData(benRegID, benVisitID, visitDateTime));

		resMap.put("diagnosis", getBenCancerDiagnosisData(benRegID, benVisitID, visitDateTime));

		resMap.put("gynecologicalExamination",
				getBenCancerGynecologicalExaminationData(benRegID, benVisitID, visitDateTime));

		resMap.put("signsAndSymptoms", getBenCancerSignAndSymptomsData(benRegID, benVisitID, visitDateTime));

		resMap.put("BenCancerLymphNodeDetails", getBenCancerLymphNodeDetailsData(benRegID, benVisitID, visitDateTime));

		resMap.put("oralExamination", getBenCancerOralExaminationData(benRegID, benVisitID, visitDateTime));

		return resMap;
	}

	private CancerAbdominalExamination getBenCancerAbdominalExaminationData(Long benRegID, Long benVisitID,
			Date visitDateTime) {
		CancerAbdominalExamination cancerAbdominalExamination = cancerAbdominalExaminationRepo
				.getBenCancerAbdominalExaminationDetails(benRegID, benVisitID);
		return cancerAbdominalExamination;
	}

	private CancerBreastExamination getBenCancerBreastExaminationData(Long benRegID, Long benVisitID,
			Date visitDateTime) {
		CancerBreastExamination cancerBreastExamination = cancerBreastExaminationRepo
				.getBenCancerBreastExaminationDetails(benRegID, benVisitID);
		return cancerBreastExamination;
	}

	private CancerDiagnosis getBenCancerDiagnosisData(Long benRegID, Long benVisitID, Date visitDateTime) {
		CancerDiagnosis cancerDiagnosis = cancerDiagnosisRepo.getBenCancerDiagnosisDetails(benRegID, benVisitID);
		// System.out.println("cancerDiagnosis .....");
		if (null != cancerDiagnosis && null != cancerDiagnosis.getInstitute()) {
			cancerDiagnosis.setReferredToInstituteName(cancerDiagnosis.getInstitute().getInstitutionName());
		}

		return cancerDiagnosis;
	}

	private CancerGynecologicalExamination getBenCancerGynecologicalExaminationData(Long benRegID, Long benVisitID,
			Date visitDateTime) {
		CancerGynecologicalExamination cancerGynecologicalExamination = cancerGynecologicalExaminationRepo
				.getBenCancerGynecologicalExaminationDetails(benRegID, benVisitID, visitDateTime);
		return cancerGynecologicalExamination;
	}

	private CancerSignAndSymptoms getBenCancerSignAndSymptomsData(Long benRegID, Long benVisitID, Date visitDateTime) {
		CancerSignAndSymptoms cancerSignAndSymptoms = cancerSignAndSymptomsRepo
				.getBenCancerSignAndSymptomsDetails(benRegID, benVisitID, visitDateTime);
		return cancerSignAndSymptoms;
	}

	private List<CancerLymphNodeDetails> getBenCancerLymphNodeDetailsData(Long benRegID, Long benVisitID,
			Date visitDateTime) {
		List<CancerLymphNodeDetails> cancerLymphNodeDetails = cancerLymphNodeExaminationRepo
				.getBenCancerLymphNodeDetails(benRegID, benVisitID, visitDateTime);
		return cancerLymphNodeDetails;
	}

	private CancerOralExamination getBenCancerOralExaminationData(Long benRegID, Long benVisitID, Date visitDateTime) {
		CancerOralExamination cancerOralExamination = cancerOralExaminationRepo
				.getBenCancerOralExaminationDetails(benRegID, benVisitID, visitDateTime);
		return cancerOralExamination;
	}

	@Override
	public String updateBenStatus(Long benVisitID, String c) {
		Map<String, String> resMap = new HashMap<>();
		Integer i = benVisitDetailRepo.updateBenFlowStatus(c, benVisitID);
		if (i != null && i > 0) {
			resMap.put("status", "Updated Successfully");
		}
		return new Gson().toJson(resMap);
	}

	private TempMasterDrugRepo tempMasterDrugRepo;

	@Autowired
	public void setTempMasterDrugRepo(TempMasterDrugRepo tempMasterDrugRepo) {
		this.tempMasterDrugRepo = tempMasterDrugRepo;
	}

	@Override
	public String getQuickConsultMasterData() {
		Map<String, Object> resMap = new HashMap<>();
		ArrayList<Object[]> ccList = chiefComplaintMasterRepo.getChiefComplaintMaster();
		ArrayList<Object[]> ddmList = drugDoseMasterRepo.getDrugDoseMaster();
		ArrayList<Object[]> ddumList = drugDurationUnitMasterRepo.getDrugDurationUnitMaster();
		ArrayList<Object[]> dfmList = drugFormMasterRepo.getDrugFormMaster();
		ArrayList<Object[]> dfrmList = drugFrequencyMasterRepo.getDrugFrequencyMaster();
		ArrayList<Object[]> ltmList = labTestMasterRepo.getLabTestMaster();
		ArrayList<TempMasterDrug> tempMasterDrugList = tempMasterDrugRepo.findByDeletedFalseOrderByDrugDisplayNameAsc();
		resMap.put("chiefComplaintMaster", ChiefComplaintMaster.getChiefComplaintMasters(ccList));
		resMap.put("drugDoseMaster", DrugDoseMaster.getDrugDoseMasters(ddmList));
		resMap.put("drugDurationUnitMaster", DrugDurationUnitMaster.getDrugDurationUnitMaster(ddumList));
		resMap.put("drugFormMaster", DrugFormMaster.getDrugFormMaster(dfmList));
		resMap.put("drugFrequencyMaster", DrugFrequencyMaster.getDrugFrequencyMaster(dfrmList));
		resMap.put("labTestMaster", LabTestMaster.getLabTestMasters(ltmList));
		resMap.put("tempDrugMaster", TempMasterDrug.getTempDrugMasterList(tempMasterDrugList));
		return new Gson().toJson(resMap);
	}

	@Deprecated
	@Override
	public Long saveDocExaminationImageAnnotation(List<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList) {
		// System.out.println("hello");
		Long x = null;
		List<CancerExaminationImageAnnotation> objList = (List<CancerExaminationImageAnnotation>) cancerExaminationImageAnnotationRepo
				.save(getCancerExaminationImageAnnotationList(wrapperCancerExamImgAnotasnList));
		if (objList != null && objList.size() > 0) {
			x = (long) objList.size();
		}
		return x;
	}

	@Deprecated
	private List<CancerExaminationImageAnnotation> getCancerExaminationImageAnnotationList(
			List<WrapperCancerExamImgAnotasn> wrapperCancerExamImgAnotasnList) {
		List<CancerExaminationImageAnnotation> objList = new ArrayList<>();

		if (wrapperCancerExamImgAnotasnList.size() > 0) {
			for (WrapperCancerExamImgAnotasn obj : wrapperCancerExamImgAnotasnList) {
				if (obj != null) {
					ArrayList<Map<String, Object>> markersList = obj.getMarkers();
					if (markersList != null && markersList.size() > 0) {
						for (Map<String, Object> marker : markersList) {
							CancerExaminationImageAnnotation cancerExaminationImageAnnotation = new CancerExaminationImageAnnotation();
							cancerExaminationImageAnnotation.setBeneficiaryRegID(obj.getBeneficiaryRegID());
							cancerExaminationImageAnnotation.setBenVisitID(obj.getVisitID());
							cancerExaminationImageAnnotation.setProviderServiceMapID(obj.getProviderServiceMapID());
							cancerExaminationImageAnnotation.setCreatedBy(obj.getCreatedBy());
							cancerExaminationImageAnnotation.setCancerImageID(obj.getImageID());
							Double a = (Double) marker.get("xCord");
							cancerExaminationImageAnnotation.setxCoordinate(a.intValue());
							Double b = (Double) marker.get("yCord");
							cancerExaminationImageAnnotation.setyCoordinate(b.intValue());
							Double c = (Double) marker.get("point");
							cancerExaminationImageAnnotation.setPoint(c.intValue());
							cancerExaminationImageAnnotation.setPointDesc((String) marker.get("description"));

							objList.add(cancerExaminationImageAnnotation);
						}
					}
				}
			}
		}

		return objList;

	}
}
