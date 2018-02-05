package com.iemr.mmu.service.cancerScreening;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.doctor.CancerAbdominalExamination;
import com.iemr.mmu.data.doctor.CancerBreastExamination;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.doctor.CancerExaminationImageAnnotation;
import com.iemr.mmu.data.doctor.CancerGynecologicalExamination;
import com.iemr.mmu.data.doctor.CancerLymphNodeDetails;
import com.iemr.mmu.data.doctor.CancerOralExamination;
import com.iemr.mmu.data.doctor.CancerSignAndSymptoms;
import com.iemr.mmu.data.doctor.WrapperCancerExamImgAnotasn;
import com.iemr.mmu.repo.doctor.CancerAbdominalExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerBreastExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerDiagnosisRepo;
import com.iemr.mmu.repo.doctor.CancerExaminationImageAnnotationRepo;
import com.iemr.mmu.repo.doctor.CancerGynecologicalExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerLymphNodeExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerOralExaminationRepo;
import com.iemr.mmu.repo.doctor.CancerSignAndSymptomsRepo;

@Service
public class CSDoctorServiceImpl implements CSDoctorService {
	private CancerSignAndSymptomsRepo cancerSignAndSymptomsRepo;
	private CancerLymphNodeExaminationRepo cancerLymphNodeExaminationRepo;
	private CancerOralExaminationRepo cancerOralExaminationRepo;
	private CancerBreastExaminationRepo cancerBreastExaminationRepo;
	private CancerAbdominalExaminationRepo cancerAbdominalExaminationRepo;
	private CancerGynecologicalExaminationRepo cancerGynecologicalExaminationRepo;
	private CancerExaminationImageAnnotationRepo cancerExaminationImageAnnotationRepo;
	private CancerDiagnosisRepo cancerDiagnosisRepo;

	@Autowired
	public void setCancerDiagnosisRepo(CancerDiagnosisRepo cancerDiagnosisRepo) {
		this.cancerDiagnosisRepo = cancerDiagnosisRepo;
	}

	@Autowired
	public void setCancerExaminationImageAnnotationRepo(
			CancerExaminationImageAnnotationRepo cancerExaminationImageAnnotationRepo) {
		this.cancerExaminationImageAnnotationRepo = cancerExaminationImageAnnotationRepo;
	}

	@Autowired
	public void setCancerGynecologicalExaminationRepo(
			CancerGynecologicalExaminationRepo cancerGynecologicalExaminationRepo) {
		this.cancerGynecologicalExaminationRepo = cancerGynecologicalExaminationRepo;
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
	public void setCancerOralExaminationRepo(CancerOralExaminationRepo cancerOralExaminationRepo) {
		this.cancerOralExaminationRepo = cancerOralExaminationRepo;
	}

	@Autowired
	public void setCancerLymphNodeExaminationRepo(CancerLymphNodeExaminationRepo cancerLymphNodeExaminationRepo) {
		this.cancerLymphNodeExaminationRepo = cancerLymphNodeExaminationRepo;
	}

	@Autowired
	public void setCancerSignAndSymptomsRepo(CancerSignAndSymptomsRepo cancerSignAndSymptomsRepo) {
		this.cancerSignAndSymptomsRepo = cancerSignAndSymptomsRepo;
	}

	@Override
	public Long saveCancerSignAndSymptomsData(CancerSignAndSymptoms cancerSignAndSymptoms) {
		CancerSignAndSymptoms response = cancerSignAndSymptomsRepo.save(cancerSignAndSymptoms);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Override
	public Long saveLymphNodeDetails(List<CancerLymphNodeDetails> cancerLymphNodeDetails) {
		Long responseData = null;
		List<CancerLymphNodeDetails> response = (List<CancerLymphNodeDetails>) cancerLymphNodeExaminationRepo
				.save(cancerLymphNodeDetails);
		if (null != response && response.size() > 0) {
			for (CancerLymphNodeDetails obj : response) {
				if (obj.getID() > 0)
					responseData = obj.getID();
				break;
			}
		}
		return responseData;
	}

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

	@Override
	public Long saveCancerBreastExaminationData(CancerBreastExamination cancerBreastExamination) {
		CancerBreastExamination response = cancerBreastExaminationRepo.save(cancerBreastExamination);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Override
	public Long saveCancerAbdominalExaminationData(CancerAbdominalExamination cancerAbdominalExamination) {
		CancerAbdominalExamination response = cancerAbdominalExaminationRepo.save(cancerAbdominalExamination);
		if (response != null)
			return response.getID();
		else
			return null;
	}

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

	@Override
	public Long saveCancerDiagnosisData(CancerDiagnosis cancerDiagnosis) {

		List<String> refrredToAdditionalServiceList = cancerDiagnosis.getRefrredToAdditionalServiceList();
		String refrredToAdditionalServiceData = "";
		if (refrredToAdditionalServiceList != null && refrredToAdditionalServiceList.size() > 0) {
			for (int i = 0; i < refrredToAdditionalServiceList.size(); i++) {
				if (i == (refrredToAdditionalServiceList.size() - 1))
					refrredToAdditionalServiceData += refrredToAdditionalServiceList.get(i);
				else
					refrredToAdditionalServiceData += refrredToAdditionalServiceList.get(i) + ",";
			}
		}
		cancerDiagnosis.setRefrredToAdditionalService(refrredToAdditionalServiceData);
		CancerDiagnosis response = cancerDiagnosisRepo.save(cancerDiagnosis);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	public Map<String, Object> getBenDoctorEnteredDataForCaseSheet(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		// System.out.println("getBenDoctorEnteredDataForCaseSheet");
		resMap.put("abdominalExamination", getBenCancerAbdominalExaminationData(benRegID, benVisitID));

		resMap.put("breastExamination", getBenCancerBreastExaminationData(benRegID, benVisitID));

		resMap.put("diagnosis", getBenCancerDiagnosisData(benRegID, benVisitID));

		resMap.put("gynecologicalExamination", getBenCancerGynecologicalExaminationData(benRegID, benVisitID));

		resMap.put("signsAndSymptoms", getBenCancerSignAndSymptomsData(benRegID, benVisitID));

		resMap.put("BenCancerLymphNodeDetails", getBenCancerLymphNodeDetailsData(benRegID, benVisitID));

		resMap.put("oralExamination", getBenCancerOralExaminationData(benRegID, benVisitID));

		return resMap;
	}

	private CancerAbdominalExamination getBenCancerAbdominalExaminationData(Long benRegID, Long benVisitID) {
		CancerAbdominalExamination cancerAbdominalExamination = cancerAbdominalExaminationRepo
				.getBenCancerAbdominalExaminationDetails(benRegID, benVisitID);
		return cancerAbdominalExamination;
	}

	private CancerBreastExamination getBenCancerBreastExaminationData(Long benRegID, Long benVisitID) {
		CancerBreastExamination cancerBreastExamination = cancerBreastExaminationRepo
				.getBenCancerBreastExaminationDetails(benRegID, benVisitID);
		return cancerBreastExamination;
	}

	private CancerDiagnosis getBenCancerDiagnosisData(Long benRegID, Long benVisitID) {
		CancerDiagnosis cancerDiagnosis = cancerDiagnosisRepo.getBenCancerDiagnosisDetails(benRegID, benVisitID);
		// System.out.println("cancerDiagnosis .....");
		if (null != cancerDiagnosis && null != cancerDiagnosis.getInstitute()) {
			cancerDiagnosis.setReferredToInstituteName(cancerDiagnosis.getInstitute().getInstitutionName());
		}

		return cancerDiagnosis;
	}

	private CancerGynecologicalExamination getBenCancerGynecologicalExaminationData(Long benRegID, Long benVisitID) {
		CancerGynecologicalExamination cancerGynecologicalExamination = cancerGynecologicalExaminationRepo
				.getBenCancerGynecologicalExaminationDetails(benRegID, benVisitID);
		return cancerGynecologicalExamination;
	}

	private CancerSignAndSymptoms getBenCancerSignAndSymptomsData(Long benRegID, Long benVisitID) {
		CancerSignAndSymptoms cancerSignAndSymptoms = cancerSignAndSymptomsRepo
				.getBenCancerSignAndSymptomsDetails(benRegID, benVisitID);
		return cancerSignAndSymptoms;
	}

	private List<CancerLymphNodeDetails> getBenCancerLymphNodeDetailsData(Long benRegID, Long benVisitID) {
		List<CancerLymphNodeDetails> cancerLymphNodeDetails = cancerLymphNodeExaminationRepo
				.getBenCancerLymphNodeDetails(benRegID, benVisitID);
		return cancerLymphNodeDetails;
	}

	private CancerOralExamination getBenCancerOralExaminationData(Long benRegID, Long benVisitID) {
		CancerOralExamination cancerOralExamination = cancerOralExaminationRepo
				.getBenCancerOralExaminationDetails(benRegID, benVisitID);
		return cancerOralExamination;
	}

	public ArrayList<WrapperCancerExamImgAnotasn> getCancerExaminationImageAnnotationCasesheet(Long benRegID,
			Long benVisitID) {
		ArrayList<WrapperCancerExamImgAnotasn> resList = new ArrayList<>();
		// System.out.println("hello");
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
		// System.out.println("hello");
		return resList;
	}
}
