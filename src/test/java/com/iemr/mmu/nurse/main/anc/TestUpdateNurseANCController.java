package com.iemr.mmu.nurse.main.anc;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.Gson;
import com.iemr.mmu.controller.nurse.main.anc.UpdateNurseANCController;
import com.iemr.mmu.service.anc.ANCServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestUpdateNurseANCController {

	private UpdateNurseANCController controllerMock;
	private ANCServiceImpl serviceMock;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void initialize()
	{
		serviceMock = mock(ANCServiceImpl.class);
		controllerMock = new UpdateNurseANCController();
		
		controllerMock.setAncServiceImpl(serviceMock);
		
	}
	
	@Test
	public void testUpdateANCMedicationHstory(){
		
		try { 
	
			String json ="{\"medicationHistoryList\":[{\"currentMedication\": \"abc\","
					+ "\"timePeriodAgo\":\"3\", \"timePeriodUnit\":\"Days\"}], \"beneficiaryRegID\":\"7398\", \"benVisitID\":\"455\", "
					+ "\"providerServiceMapID\":\"1316\", \"createdBy\":\"786\"}";
			
			mockMvc.perform(post("/anc/update/history/medicationHistory")
					 .contentType(MediaType.APPLICATION_JSON)
					 .content(json)).andExpect(content().string("Beneficiary ANC Medication History Details updated successfully"));
					

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
