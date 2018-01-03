package com.iemr.mmu.nurse.main.anc;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iemr.mmu.controller.nurse.main.anc.UpdateNurseANCController;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUpdateNurseANCController {

	private UpdateNurseANCController controllerMock;
	
	@Before
	public void initialize()
	{
		controllerMock = mock(UpdateNurseANCController.class);
	}
	
	@Test
	public void testUpdateANCMedicationHstory(){
		assertTrue(controllerMock.updateANCBenMedicationHistory("{\"medicationHistoryList\":[{\"currentMedication\": \"String\","
			+ "\"timePeriodAgo\":\"Integer\", \"timePeriodUnit\":\"String\"}], \"beneficiaryRegID\":\"Long\", \"benVisitID\":\"Long\", "
			+ "\"providerServiceMapID\":\"Integer\", \"createdBy\":\"String\"}").equals("Beneficiary ANC Medication History Details updated successfully"));
	}
	
}
