package com.iemr.mmu.service.labtechnician;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.labModule.LabResultEntry;
import com.iemr.mmu.data.labModule.WrapperLabResultEntry;
import com.iemr.mmu.data.labtechnician.V_benLabTestOrderedDetails;
import com.iemr.mmu.repo.labModule.LabResultEntryRepo;
import com.iemr.mmu.repo.labtechnician.V_benLabTestOrderedDetailsRepo;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
public class LabTechnicianServiceImpl implements LabTechnicianService {
	private V_benLabTestOrderedDetailsRepo v_benLabTestOrderedDetailsRepo;
	private LabResultEntryRepo labResultEntryRepo;
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;

	@Autowired
	public void setCommonBenStatusFlowServiceImpl(CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl) {
		this.commonBenStatusFlowServiceImpl = commonBenStatusFlowServiceImpl;
	}

	@Autowired
	public void setLabResultEntryRepo(LabResultEntryRepo labResultEntryRepo) {
		this.labResultEntryRepo = labResultEntryRepo;
	}

	@Autowired
	public void setV_benLabTestOrderedDetailsRepo(V_benLabTestOrderedDetailsRepo v_benLabTestOrderedDetailsRepo) {
		this.v_benLabTestOrderedDetailsRepo = v_benLabTestOrderedDetailsRepo;
	}

	public String getBenePrescribedProcedureDetails(Long benRegID, Long benVisitID) {
		Map<String, Object> returnOBJ = new HashMap<>();

		ArrayList<Object> radiologyList;
		ArrayList<Object> laboratoryList;

		ArrayList<V_benLabTestOrderedDetails> orderedLabTestListLab = v_benLabTestOrderedDetailsRepo
				.findDistinctByBeneficiaryRegIDAndBenVisitIDAndProcedureTypeOrderByProcedureIDAscTestComponentIDAscResultValueAsc(
						benRegID, benVisitID, "Laboratory");

		ArrayList<V_benLabTestOrderedDetails> orderedLabTestListRadio = v_benLabTestOrderedDetailsRepo
				.findDistinctByBeneficiaryRegIDAndBenVisitIDAndProcedureTypeOrderByProcedureIDAscTestComponentIDAscResultValueAsc(
						benRegID, benVisitID, "Radiology");

		radiologyList = getPrescribedLabTestInJsonFormatRadiology(orderedLabTestListRadio);
		laboratoryList = getPrescribedLabTestInJsonFormatlaboratory(orderedLabTestListLab);

		returnOBJ.put("radiologyList", radiologyList);
		returnOBJ.put("laboratoryList", laboratoryList);

		return new Gson().toJson(returnOBJ);
	}

	private ArrayList<Object> getPrescribedLabTestInJsonFormatlaboratory(
			ArrayList<V_benLabTestOrderedDetails> orderedLabTestList) {

		ArrayList<Object> returnOBJ = new ArrayList<>();
		Map<String, Object> procDetails = null;
		ArrayList<Object> compList = null;
		Map<String, Object> compDetails = null;
		Map<String, Object> compOption = null;
		ArrayList<Object> compOptionList = null;

		if (orderedLabTestList != null && orderedLabTestList.size() > 0) {
			for (V_benLabTestOrderedDetails obj : orderedLabTestList) {
				if (procDetails == null || procDetails.containsValue(obj.getProcedureID()) == false) {
					procDetails = new HashMap<>();
					compList = new ArrayList<>();

					procDetails.put("procedureID", obj.getProcedureID());
					procDetails.put("procedureName", obj.getProcedureName());
					procDetails.put("procedureDesc", obj.getProcedureDesc());
					procDetails.put("procedureType", "Laboratory");
					procDetails.put("prescriptionID", obj.getPrescriptionID());

					if (procDetails.containsKey("compListDetails") == false) {
						compList = new ArrayList<>();
						compDetails = new HashMap<>();
						compDetails.put("testComponentID", obj.getTestComponentID());
						compDetails.put("testComponentName", obj.getTestComponentName());
						compDetails.put("testComponentDesc", obj.getTestComponentDesc());
						compDetails.put("inputType", obj.getInputType());
						compDetails.put("measurementUnit", obj.getMeasurementUnit());
						compDetails.put("range_min", obj.getRange_min());
						compDetails.put("range_normal_min", obj.getRange_normal_min());
						compDetails.put("range_normal_max", obj.getRange_normal_max());
						compDetails.put("range_max", obj.getRange_max());

						compOption = new HashMap<>();
						compOptionList = new ArrayList<>();

						compOption.put("name", obj.getResultValue());
						compOptionList.add(compOption);

						compDetails.put("compOpt", compOptionList);

						compList.add(compDetails);
						procDetails.put("compListDetails", compList);

					} else {
						compDetails = new HashMap<>();
						compDetails.put("testComponentID", obj.getTestComponentID());
						compDetails.put("testComponentName", obj.getTestComponentName());
						compDetails.put("testComponentDesc", obj.getTestComponentDesc());
						compDetails.put("inputType", obj.getInputType());
						compDetails.put("measurementUnit", obj.getMeasurementUnit());
						compDetails.put("range_min", obj.getRange_min());
						compDetails.put("range_normal_min", obj.getRange_normal_min());
						compDetails.put("range_normal_max", obj.getRange_normal_max());
						compDetails.put("range_max", obj.getRange_max());

						compOption = new HashMap<>();
						compOptionList = new ArrayList<>();

						compOption.put("name", obj.getResultValue());
						compOptionList.add(compOption);

						compDetails.put("compOpt", compOptionList);

						compList.add(compDetails);

					}

					returnOBJ.add(procDetails);

				} else {
					if (compDetails == null || compDetails.get("testComponentID") != obj.getTestComponentID()) {
						compDetails = new HashMap<>();
						compDetails.put("testComponentID", obj.getTestComponentID());
						compDetails.put("testComponentName", obj.getTestComponentName());
						compDetails.put("testComponentDesc", obj.getTestComponentDesc());
						compDetails.put("inputType", obj.getInputType());
						compDetails.put("measurementUnit", obj.getMeasurementUnit());
						compDetails.put("range_min", obj.getRange_min());
						compDetails.put("range_normal_min", obj.getRange_normal_min());
						compDetails.put("range_normal_max", obj.getRange_normal_max());
						compDetails.put("range_max", obj.getRange_max());

						compOption = new HashMap<>();
						compOptionList = new ArrayList<>();

						compOption.put("name", obj.getResultValue());
						compOptionList.add(compOption);

						compDetails.put("compOpt", compOptionList);

						compList.add(compDetails);
					} else {
						compOption = new HashMap<>();
						compOption.put("name", obj.getResultValue());
						compOptionList.add(compOption);
					}

				}
			}
		}

		return returnOBJ;
	}

	private ArrayList<Object> getPrescribedLabTestInJsonFormatRadiology(
			ArrayList<V_benLabTestOrderedDetails> orderedLabTestList) {
		ArrayList<Object> returnOBJ = new ArrayList<>();
		Map<String, Object> procedureCompDetails;

		Map<String, Object> compDetails;

		if (orderedLabTestList != null && orderedLabTestList.size() > 0) {
			for (V_benLabTestOrderedDetails obj : orderedLabTestList) {
				procedureCompDetails = new HashMap<>();
				compDetails = new HashMap<>();

				procedureCompDetails.put("procedureID", obj.getProcedureID());
				procedureCompDetails.put("procedureName", obj.getProcedureName());
				procedureCompDetails.put("procedureDesc", obj.getProcedureDesc());
				procedureCompDetails.put("procedureType", "Radiology");
				procedureCompDetails.put("prescriptionID", obj.getPrescriptionID());

				compDetails.put("testComponentID", obj.getTestComponentID());
				compDetails.put("testComponentName", obj.getTestComponentName());
				compDetails.put("testComponentDesc", obj.getTestComponentDesc());
				compDetails.put("inputType", "File");

				procedureCompDetails.put("compDetails", compDetails);

				returnOBJ.add(procedureCompDetails);

			}
		}

		return returnOBJ;
	}

	/*
	 * @Transactional(rollbackFor = Exception.class) public Integer
	 * saveLabTestResult(JsonObject requestOBJ) throws Exception {
	 * 
	 * Integer labResultSaveFlag = null; if (requestOBJ != null &&
	 * requestOBJ.has("labTestResults") && null !=
	 * requestOBJ.get("labTestResults") &&
	 * !requestOBJ.get("labTestResults").isJsonNull()) {
	 * 
	 * LabResultEntry[] labResults =
	 * InputMapper.gson().fromJson(requestOBJ.get("labTestResults"),
	 * LabResultEntry[].class); List<LabResultEntry> labResultsList =
	 * Arrays.asList(labResults);
	 * 
	 * if(null != labResultsList && labResultsList.size()>0){
	 * List<LabResultEntry> labResultsListNew = new ArrayList<LabResultEntry>();
	 * for(LabResultEntry labResult : labResultsList){ List<Map<String, String>>
	 * compResult = labResult.getCompList(); if(null != compResult &&
	 * compResult.size()>0){ for(Map<String, String> comp: compResult){
	 * LabResultEntry labCompResult = new LabResultEntry();
	 * labCompResult.setPrescriptionID(labResult.getPrescriptionID());
	 * labCompResult.setProcedureID(labResult.getProcedureID());
	 * 
	 * if(null != comp.get("testComponentID") &&
	 * !comp.get("testComponentID").toString().isEmpty() && null !=
	 * comp.get("testResultValue") &&
	 * !comp.get("testResultValue").toString().isEmpty()){
	 * labCompResult.setTestComponentID(Integer.parseInt(comp.get(
	 * "testComponentID")));
	 * labCompResult.setTestResultValue(comp.get("testResultValue").toString());
	 * 
	 * if(requestOBJ.has("beneficiaryRegID") && null !=
	 * requestOBJ.get("beneficiaryRegID") &&
	 * !requestOBJ.get("beneficiaryRegID").isJsonArray()){
	 * labCompResult.setBeneficiaryRegID(requestOBJ.get("beneficiaryRegID").
	 * getAsLong()); }
	 * 
	 * if(requestOBJ.has("createdBy") && null != requestOBJ.get("createdBy") &&
	 * !requestOBJ.get("createdBy").isJsonArray()){
	 * labCompResult.setCreatedBy(requestOBJ.get("createdBy").toString()); }
	 * 
	 * labResultsListNew.add(labCompResult); }
	 * 
	 * } } } List<LabResultEntry> labResultEntryRes = (List<LabResultEntry>)
	 * labResultEntryRepo.save(labResultsListNew); if(null != labResultEntryRes
	 * && labResultsListNew.size() == labResultEntryRes.size()){
	 * labResultSaveFlag = 1; } }else{ labResultSaveFlag = 1; } }else{
	 * labResultSaveFlag = 1; } return labResultSaveFlag; }
	 */

	@Transactional(rollbackFor = Exception.class)
	public Integer saveLabTestResult(JsonObject requestOBJ) throws Exception {

		Integer labResultSaveFlag = null;
		if (requestOBJ != null && requestOBJ.has("labTestResults") && null != requestOBJ.get("labTestResults")
				&& !requestOBJ.get("labTestResults").isJsonNull()) {

			WrapperLabResultEntry wrapperLabResults = InputMapper.gson().fromJson(requestOBJ,
					WrapperLabResultEntry.class);

			labResultSaveFlag = saveLabTestResult(wrapperLabResults);

			if (labResultSaveFlag == 1) {
				int i = updateBenFlowStatusFlagAfterLabResultEntry(wrapperLabResults.getLabCompleted(),
						wrapperLabResults.getBenFlowID(), wrapperLabResults.getBeneficiaryRegID(),
						wrapperLabResults.getVisitID(), wrapperLabResults.getNurseFlag(),
						wrapperLabResults.getDoctorFlag());
			}

		} else {
			labResultSaveFlag = 1;
		}

		return labResultSaveFlag;
	}

	private int updateBenFlowStatusFlagAfterLabResultEntry(Boolean isLabDone, Long benFlowID, Long benRegID,
			Long benVisitID, Short nurseFlag, Short doctorFlag) {
		int returnOBJ = 0;
		short labFlag = (short) 0;

		if (isLabDone == true) {
			if (nurseFlag == 2) {
				nurseFlag = 3;
				doctorFlag = 1;
			} else {
				if (doctorFlag == 2) {
					doctorFlag = 3;
				}
			}

			labFlag = (short) 1;
		} else {
			labFlag = (short) 1;
		}
		returnOBJ = commonBenStatusFlowServiceImpl.updateFlowAfterLabResultEntry(benFlowID, benRegID, benVisitID,
				nurseFlag, doctorFlag, labFlag);

		return returnOBJ;
	}

	public Integer saveLabTestResult(WrapperLabResultEntry wrapperLabResults) {
		Integer labResultSaveFlag = null;

		List<LabResultEntry> labResultsList = wrapperLabResults.getLabTestResults();

		if (null != labResultsList && labResultsList.size() > 0) {
			List<LabResultEntry> labResultsListNew = new ArrayList<LabResultEntry>();
			for (LabResultEntry labResult : labResultsList) {
				List<Map<String, String>> compResult = labResult.getCompList();
				if (null != compResult && compResult.size() > 0) {
					for (Map<String, String> comp : compResult) {
						LabResultEntry labCompResult = new LabResultEntry();
						labCompResult.setPrescriptionID(labResult.getPrescriptionID());
						labCompResult.setProcedureID(labResult.getProcedureID());

						if (null != comp.get("testComponentID") && !comp.get("testComponentID").toString().isEmpty()
								&& null != comp.get("testResultValue")
								&& !comp.get("testResultValue").toString().isEmpty()) {
							labCompResult.setTestComponentID(Integer.parseInt(comp.get("testComponentID")));
							labCompResult.setTestResultValue(comp.get("testResultValue").toString());

							if (comp.containsKey("testResultUnit") && comp.get("testResultUnit") != null
									&& !comp.get("testResultUnit").isEmpty())
								labCompResult.setTestResultUnit(comp.get("testResultUnit"));

							labCompResult.setBeneficiaryRegID(wrapperLabResults.getBeneficiaryRegID());
							labCompResult.setBenVisitID(wrapperLabResults.getVisitID());
							labCompResult.setProviderServiceMapID(wrapperLabResults.getProviderServiceMapID());
							labCompResult.setCreatedBy(wrapperLabResults.getCreatedBy());

							labResultsListNew.add(labCompResult);
						}

					}
				}
			}
			if (null != labResultsListNew && labResultsListNew.size() > 0) {
				List<LabResultEntry> labResultEntryRes = (List<LabResultEntry>) labResultEntryRepo
						.save(labResultsListNew);
				if (null != labResultEntryRes && labResultsListNew.size() == labResultEntryRes.size()) {
					labResultSaveFlag = 1;
				}
			} else {
				labResultSaveFlag = 1;
			}
		} else {
			labResultSaveFlag = 1;
		}
		return labResultSaveFlag;
	}
}
