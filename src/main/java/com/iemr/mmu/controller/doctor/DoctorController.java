package com.iemr.mmu.controller.doctor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.iemr.mmu.data.doctor.CancerAbdominalExamination;
import com.iemr.mmu.data.doctor.CancerBreastExamination;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.doctor.CancerGynecologicalExamination;
import com.iemr.mmu.data.doctor.CancerLymphNodeDetails;
import com.iemr.mmu.data.doctor.CancerOralExamination;
import com.iemr.mmu.data.doctor.CancerSignAndSymptoms;
import com.iemr.mmu.data.doctor.WrapperCancerSymptoms;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.doctor.DoctorServiceImpl;
import com.iemr.mmu.service.masterservice.DoctorMasterDataService;
import com.iemr.mmu.service.masterservice.DoctorMasterDataServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

@CrossOrigin
@RestController
@RequestMapping({ "/doctor" })
public class DoctorController {

	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;

	private DoctorMasterDataService doctorMasterDataService;
	private DoctorMasterDataServiceImpl doctorMasterDataServiceImpl;
	
	@Autowired
	private DoctorServiceImpl doctorServiceImpl;
	
	@Autowired
	public void setDoctorMasterDataServiceImpl(DoctorMasterDataServiceImpl doctorMasterDataServiceImpl) {
		this.doctorMasterDataServiceImpl = doctorMasterDataServiceImpl;
	}
	
	@Autowired
	private NurseServiceImpl nurseServiceImpl;

	@CrossOrigin
	@RequestMapping(value = { "/save/examinationScreen/abdominal" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String saveAbdominalExaminationDetail(@RequestBody String requestObj) {

		response = new OutputResponse();

		CancerAbdominalExamination cancerAbdominalExamination = InputMapper.gson().fromJson(requestObj,
				CancerAbdominalExamination.class);
		try {
			Long ID = doctorServiceImpl
					.saveCancerAbdominalExaminationData(cancerAbdominalExamination);
			if (ID != null && ID > 0) {
				Map<String, Long> resMap = new HashMap<String, Long>();
				resMap.put("ID", ID);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to Store Abdominal Examination Detail");
			}
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/examinationScreen/breast" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String saveBreastExaminationDetail(@RequestBody String requestObj) {

		response = new OutputResponse();

		CancerBreastExamination cancerBreastExamination = InputMapper.gson().fromJson(requestObj,
				CancerBreastExamination.class);
		try {
			Long ID = doctorServiceImpl
					.saveCancerBreastExaminationData(cancerBreastExamination);			
			if (ID != null && ID > 0) {
				Map<String, Long> resMap = new HashMap<String, Long>();
				resMap.put("ID", ID);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to Store Breast Examination Detail");
			}
			
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/examinationScreen/diagnosis" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String saveDiagnosisExaminationDetail(@RequestBody String requestObj) {

		response = new OutputResponse();

		CancerDiagnosis cancerDiagnosis = InputMapper.gson().fromJson(requestObj, CancerDiagnosis.class);
		try {
			Long ID = doctorServiceImpl.saveCancerDiagnosisData(cancerDiagnosis);
			if (ID != null && ID > 0) {
				Map<String, Long> resMap = new HashMap<String, Long>();
				resMap.put("ID", ID);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to Store Diagnosis Examination Detail");
			}
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/examinationScreen/gynecological" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String saveGynecologicalExaminationDetail(@RequestBody String requestObj) {

		response = new OutputResponse();

		CancerGynecologicalExamination cancerGynecologicalExamination = InputMapper.gson().fromJson(requestObj,
				CancerGynecologicalExamination.class);
		try {
			Long ID = doctorServiceImpl
					.saveCancerGynecologicalExaminationData(cancerGynecologicalExamination);
			if (ID != null && ID > 0) {
				Map<String, Long> resMap = new HashMap<String, Long>();
				resMap.put("ID", ID);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to Store Gynecological Examination Detail");
			}
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/examinationScreen/lymphNode" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String saveLymphNodeExaminationDetail(@RequestBody String requestObj) {

		response = new OutputResponse();

		CancerLymphNodeDetails[] cancerLymphNodeDetails = InputMapper.gson().fromJson(requestObj,
				CancerLymphNodeDetails[].class);

		List<CancerLymphNodeDetails> cancerLymphNodeDetailsList = Arrays.asList(cancerLymphNodeDetails);
		try {
			int result = doctorServiceImpl.saveLymphNodeDetails(cancerLymphNodeDetailsList);
			if (result > 0) {
				response.setResponse("LymphNode Examination Detail Stored Successfully");
			} else {
				response.setError(0, "Failed to Store LymphNode Examination Detail");
			}
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/examinationScreen/oral" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String saveOralExaminationDetail(@RequestBody String requestObj) {

		response = new OutputResponse();

		CancerOralExamination cancerOralExamination = InputMapper.gson().fromJson(requestObj,
				CancerOralExamination.class);
		try {
			Long ID = doctorServiceImpl.saveCancerOralExaminationData(cancerOralExamination);
			if (ID != null && ID > 0) {
				Map<String, Long> resMap = new HashMap<String, Long>();
				resMap.put("ID", ID);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to Store Oral Examination Detail");
			}
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/save/examinationScreen/signAndSymptoms" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String saveCancerSignAndSymptomsDetail(@RequestBody String requestObj) {

		response = new OutputResponse();

		WrapperCancerSymptoms wrapperCancerSymptoms = InputMapper.gson().fromJson(requestObj,
				WrapperCancerSymptoms.class);

		// CancerLymphNodeDetails[] cancerLymphNodeDetails =
		// InputMapper.gson().fromJson(requestObj,
		// CancerLymphNodeDetails[].class);
		//
		// List<CancerLymphNodeDetails> cancerLymphNodeDetailsList =
		// Arrays.asList(cancerLymphNodeDetails);

		try {
			Long ID = doctorServiceImpl
					.saveCancerSignAndSymptomsData(wrapperCancerSymptoms.getCancerSignAndSymptoms());

			if (ID != null && ID > 0) {
				response.setResponse("Cancer Sign and Symptoms Detail Stored Successfully");

				int result = doctorServiceImpl.saveLymphNodeDetails(wrapperCancerSymptoms.getCancerLymphNodeDetails());
				if (result > 0) {
					response.setResponse(
							"Cancer Sign and Symptoms Detail and LymphNode Examination Detail Stored Successfully");
				} else {
					response.setError(500,
							"Cancer Sign and Symptoms Detail Stored but Failed to Store LymphNode Examination Detail");
				}

			} else {
				response.setError(500, "Failed to Store Cancer Sign and Symptoms Detail");
			}
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}
	
	@CrossOrigin()
	@RequestMapping(value = { "/doctorMasterData" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String getMasterDataForDoctor() {
		
		OutputResponse response = new OutputResponse();
		
		try {
			response.setResponse(doctorMasterDataServiceImpl.getDoctorMasterData());

		} catch (Exception e) {
			e.printStackTrace();
			response.setError(e);
		}
		return response.toString();
	}
	
	@CrossOrigin
	@RequestMapping(value = { "/update/visitDetailScreen/VisitDetail" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String updateBeneficiaryVisitDetail(@RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();

		BeneficiaryVisitDetail beneficiaryVisitDetail = InputMapper.gson().fromJson(requestObj,
				BeneficiaryVisitDetail.class);
		try {
			int result = nurseServiceImpl.updateBeneficiaryVisitDetails(beneficiaryVisitDetail);
			if (result > 0) {
				Map<String, Integer> resMap = new HashMap<String, Integer>();
				resMap.put("result", result);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to update Beneficiary Visit Details");
			}
		} catch (Exception e) {
			response.setError(e);
		}

		System.out.println(response.toString());
		return response.toString();
	}
	
	@CrossOrigin
	@RequestMapping(value = { "/update/historyScreen/benFamilyCancerHistory" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String updateBenFamilyCancerHistory(@RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();

		BenFamilyCancerHistory[] benFamilyCancerHistoryArray = InputMapper.gson().fromJson(requestObj,
				BenFamilyCancerHistory[].class);
		
		List<BenFamilyCancerHistory> benFamilyCancerHistoryList = Arrays.asList(benFamilyCancerHistoryArray);
		try {
			int result = nurseServiceImpl.updateBeneficiaryFamilyCancerHistory(benFamilyCancerHistoryList);
			if (result > 0) {
				Map<String, Integer> resMap = new HashMap<String, Integer>();
				resMap.put("result", result);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to update Beneficiary Family Cancer History");
			}
		} catch (Exception e) {
			response.setError(e);
		}

		System.out.println(response.toString());
		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/update/historyScreen/benObstetricCancerHistory" }, method = {
			RequestMethod.POST }, produces = { "application/json" })
	public String updateBenObstetricCancerHistory(@RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();

		try {
			BenObstetricCancerHistory benObstetricCancerHistory = InputMapper.gson().fromJson(requestObj,
					BenObstetricCancerHistory.class);

			int result = nurseServiceImpl.updateBenObstetricCancerHistory(benObstetricCancerHistory);
			if (result > 0) {
				response.setResponse("Beneficiary Obstetric Cancer History Details updated Successfully");
			} else {
				response.setError(500, "Failed to update Beneficiary Obstetric Cancer History Details");
			}
			response.setResponse(response.toString());
		} catch (Exception e) {
			response.setError(e);
		}
		System.out.println(response.toString());
		return response.toString();
	}
	
	
}
