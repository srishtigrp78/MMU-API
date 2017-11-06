package com.iemr.mmu.data.emergencyCasesheet;

import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

public class WrapperEmergencyCaseSheet {
	
	@Expose
	private JsonObject emCaseSheet;
	
	@Expose
	private PrescribedDrugDetail prescribedDrugDetail;

	public PrescribedDrugDetail getPrescribedDrugDetail() {
		return prescribedDrugDetail;
	}

	public void setPrescribedDrugDetail(PrescribedDrugDetail prescribedDrugDetail) {
		this.prescribedDrugDetail = prescribedDrugDetail;
	}

	public JsonObject getEmCaseSheet() {
		return emCaseSheet;
	}

	public void setEmCaseSheet(JsonObject emCaseSheet) {
		this.emCaseSheet = emCaseSheet;
	}
	
}
