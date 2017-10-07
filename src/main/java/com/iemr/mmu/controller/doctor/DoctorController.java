package com.iemr.mmu.controller.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iemr.mmu.data.doctor.CancerAbdominalExamination;
import com.iemr.mmu.data.doctor.CancerBreastExamination;
import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.doctor.CancerGynecologicalExamination;
import com.iemr.mmu.data.doctor.CancerLymphNodeDetails;
import com.iemr.mmu.data.doctor.CancerOralExamination;
import com.iemr.mmu.data.doctor.CancerSignAndSymptoms;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.doctor.DoctorServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	
	@Autowired
	private DoctorServiceImpl doctorServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = { "/save/examinationScreen/abdominal" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String saveAbdominalExaminationDetail(@RequestBody String requestObj) {

		response = new OutputResponse();

		CancerAbdominalExamination cancerAbdominalExamination = InputMapper.gson().fromJson(requestObj,
				CancerAbdominalExamination.class);
		try {
			CancerAbdominalExamination responseObj = doctorServiceImpl.saveCancerAbdominalExaminationData(cancerAbdominalExamination);
			if (responseObj.getID() > 0) {
				response.setResponse("Abdominal Examination Detail Stored Successfully");
			} else {
				response.setError(0, "Failed to Store Abdominal Examination Detail");
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
			CancerBreastExamination responseObj = doctorServiceImpl.saveCancerBreastExaminationData(cancerBreastExamination);
			if (responseObj.getID() > 0) {
				response.setResponse("Breast Examination Detail Stored Successfully");
			} else {
				response.setError(0, "Failed to Store Breast Examination Detail");
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

		CancerDiagnosis cancerDiagnosis = InputMapper.gson().fromJson(requestObj,
				CancerDiagnosis.class);
		try {
			CancerDiagnosis responseObj = doctorServiceImpl.saveCancerDiagnosisData(cancerDiagnosis);
			if (responseObj.getID() > 0) {
				response.setResponse("Diagnosis Examination Detail Stored Successfully");
			} else {
				response.setError(0, "Failed to Store Diagnosis Examination Detail");
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
			CancerGynecologicalExamination responseObj = doctorServiceImpl.saveCancerGynecologicalExaminationData(cancerGynecologicalExamination);
			if (responseObj.getID() > 0) {
				response.setResponse("Gynecological Examination Detail Stored Successfully");
			} else {
				response.setError(0, "Failed to Store Gynecological Examination Detail");
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

		CancerLymphNodeDetails cancerLymphNodeDetails = InputMapper.gson().fromJson(requestObj,
				CancerLymphNodeDetails.class);
		try {
			CancerLymphNodeDetails responseObj = doctorServiceImpl.saveLymphNodeDetails(cancerLymphNodeDetails);
			if (responseObj.getID() > 0) {
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
			CancerOralExamination responseObj = doctorServiceImpl.saveCancerOralExaminationData(cancerOralExamination);
			if (responseObj.getID() > 0) {
				response.setResponse("Oral Examination Detail Stored Successfully");
			} else {
				response.setError(0, "Failed to Store Oral Examination Detail");
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

		CancerSignAndSymptoms cancerSignAndSymptoms = InputMapper.gson().fromJson(requestObj,
				CancerSignAndSymptoms.class);
		try {
			CancerSignAndSymptoms responseObj = doctorServiceImpl.saveCancerSignAndSymptomsData(cancerSignAndSymptoms);
			if (responseObj.getID() > 0) {
				response.setResponse("Cancer Sign and Symptoms Detail Stored Successfully");
			} else {
				response.setError(0, "Failed to Store Cancer Sign and Symptoms Detail");
			}
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}
}
