package com.iemr.mmu.service.labtechnician;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.labtechnician.V_benLabTestOrderedDetails;
import com.iemr.mmu.repo.labtechnician.V_benLabTestOrderedDetailsRepo;

@Service
public class LabTechnicianServiceImpl implements LabTechnicianService {
	private V_benLabTestOrderedDetailsRepo v_benLabTestOrderedDetailsRepo;

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

				procedureCompDetails.put("compListDetails", compDetails);

				returnOBJ.add(procedureCompDetails);

			}
		}

		return returnOBJ;
	}
}
