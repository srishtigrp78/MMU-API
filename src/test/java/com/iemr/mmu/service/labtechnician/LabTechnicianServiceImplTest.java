package com.iemr.mmu.service.labtechnician;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.labModule.LabResultEntry;
import com.iemr.mmu.data.labModule.ProcedureData;
import com.iemr.mmu.data.labModule.TestComponentMaster;
import com.iemr.mmu.data.labModule.WrapperLabResultEntry;
import com.iemr.mmu.data.labtechnician.V_benLabTestOrderedDetails;
import com.iemr.mmu.repo.labModule.LabResultEntryRepo;
import com.iemr.mmu.repo.labtechnician.V_benLabTestOrderedDetailsRepo;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;

@ExtendWith(MockitoExtension.class)
class LabTechnicianServiceImplTest {
	@Mock
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;

	@Mock
	private LabResultEntryRepo labResultEntryRepo;

	@InjectMocks
	private LabTechnicianServiceImpl labTechnicianServiceImpl;

	@Mock
	private V_benLabTestOrderedDetailsRepo v_benLabTestOrderedDetailsRepo;

	@Test
	void testGetBenePrescribedProcedureDetails() throws Exception {
		// Arrange
		when(labResultEntryRepo.findByBeneficiaryRegIDAndVisitCodeOrderByProcedureIDAsc(Mockito.<Long>any(),
				Mockito.<Long>any())).thenReturn(new ArrayList<>());
		when(v_benLabTestOrderedDetailsRepo
				.findDistinctByBeneficiaryRegIDAndVisitCodeAndProcedureTypeAndProcedureIDNotInOrderByProcedureIDAscTestComponentIDAscResultValueAsc(
						Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any(),
						Mockito.<ArrayList<Integer>>any()))
				.thenReturn(new ArrayList<>());

		// Act
		String actualBenePrescribedProcedureDetails = labTechnicianServiceImpl.getBenePrescribedProcedureDetails(1L,
				1L);

		// Assert
		verify(labResultEntryRepo).findByBeneficiaryRegIDAndVisitCodeOrderByProcedureIDAsc(Mockito.<Long>any(),
				Mockito.<Long>any());
		verify(v_benLabTestOrderedDetailsRepo, atLeast(1))
				.findDistinctByBeneficiaryRegIDAndVisitCodeAndProcedureTypeAndProcedureIDNotInOrderByProcedureIDAscTestComponentIDAscResultValueAsc(
						Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any(),
						Mockito.<ArrayList<Integer>>any());
		assertEquals("{\"radiologyList\":[],\"laboratoryList\":[],\"archive\":[]}",
				actualBenePrescribedProcedureDetails);
	}

	@Test
	void testGetBenePrescribedProcedureDetails2() throws Exception {
		// Arrange
		when(labResultEntryRepo.findByBeneficiaryRegIDAndVisitCodeOrderByProcedureIDAsc(Mockito.<Long>any(),
				Mockito.<Long>any())).thenReturn(new ArrayList<>());

		V_benLabTestOrderedDetails v_benLabTestOrderedDetails = new V_benLabTestOrderedDetails();
		v_benLabTestOrderedDetails.setBenVisitID(1L);
		v_benLabTestOrderedDetails.setBeneficiaryRegID(1L);
		v_benLabTestOrderedDetails.setCalibrationEndAPI("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setCalibrationStartAPI("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setCalibrationStatusAPI("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setComponentCode("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setComponentUnit("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setDiscoveryCode("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setIOTComponentName("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setIOTProcedureID("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setId("42");
		v_benLabTestOrderedDetails.setInputType("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setIotProcedureName("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setIsDecimal(true);
		v_benLabTestOrderedDetails.setIsLabProcedure(true);
		v_benLabTestOrderedDetails.setIsMandatory(true);
		v_benLabTestOrderedDetails.setMeasurementUnit("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setPrescriptionID(1L);
		v_benLabTestOrderedDetails.setProcedureCode("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setProcedureDesc("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setProcedureEndAPI("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setProcedureID(1);
		v_benLabTestOrderedDetails.setProcedureName("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setProcedureStartAPI("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setProcedureStatusAPI("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setProcedureType("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setRange_max(3);
		v_benLabTestOrderedDetails.setRange_min(1);
		v_benLabTestOrderedDetails.setRange_normal_max(3);
		v_benLabTestOrderedDetails.setRange_normal_min(1);
		v_benLabTestOrderedDetails.setResultValue("42");
		v_benLabTestOrderedDetails.setTestComponentDesc("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setTestComponentID(1);
		v_benLabTestOrderedDetails.setTestComponentName("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setVisitCode(1L);
		
		v_benLabTestOrderedDetails.toString();

		ArrayList<V_benLabTestOrderedDetails> v_benLabTestOrderedDetailsList = new ArrayList<>();
		v_benLabTestOrderedDetailsList.add(v_benLabTestOrderedDetails);
		when(v_benLabTestOrderedDetailsRepo
				.findDistinctByBeneficiaryRegIDAndVisitCodeAndProcedureTypeAndProcedureIDNotInOrderByProcedureIDAscTestComponentIDAscResultValueAsc(
						Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any(),
						Mockito.<ArrayList<Integer>>any()))
				.thenReturn(v_benLabTestOrderedDetailsList);

		// Act
		String actualBenePrescribedProcedureDetails = labTechnicianServiceImpl.getBenePrescribedProcedureDetails(1L,
				1L);

		// Assert
		verify(labResultEntryRepo).findByBeneficiaryRegIDAndVisitCodeOrderByProcedureIDAsc(Mockito.<Long>any(),
				Mockito.<Long>any());
		verify(v_benLabTestOrderedDetailsRepo, atLeast(1))
				.findDistinctByBeneficiaryRegIDAndVisitCodeAndProcedureTypeAndProcedureIDNotInOrderByProcedureIDAscTestComponentIDAscResultValueAsc(
						Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any(),
						Mockito.<ArrayList<Integer>>any());
		assertEquals(
				"{\"radiologyList\":[{\"procedureDesc\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"procedureType\":\"Radiology"
						+ "\",\"prescriptionID\":1,\"compDetails\":{\"testComponentName\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\","
						+ "\"inputType\":\"File\",\"testComponentID\":1,\"testComponentDesc\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\""
						+ "},\"procedureName\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"procedureID\":1}],\"laboratoryList\":[{"
						+ "\"procedureDesc\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"procedureType\":\"Laboratory\",\"prescriptionID"
						+ "\":1,\"calibrationEndAPI\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"procedureCode\":\"amrith$%2022@\\u0026"
						+ "*piramal@@swasthya!#\",\"calibrationStatusAPI\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"procedureID\""
						+ ":1,\"iotProcedureName\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"isLabProcedure\":true,\"calibrationStartAPI"
						+ "\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"discoveryCode\":\"amrith$%2022@\\u0026*piramal@@swasthya!#"
						+ "\",\"procedureName\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"compListDetails\":[{\"range_normal_min\":1"
						+ ",\"compOpt\":[{\"name\":\"42\"}],\"componentCode\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"range_min\":1,"
						+ "\"testComponentID\":1,\"measurementUnit\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"testComponentName\":"
						+ "\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"iotComponentName\":\"amrith$%2022@\\u0026*piramal@@swasthya!"
						+ "#\",\"range_normal_max\":3,\"iotProcedureID\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"componentUnit\":"
						+ "\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"isDecimal\":true,\"inputType\":\"amrith$%2022@\\u0026*piramal@"
						+ "@swasthya!#\",\"range_max\":3,\"testComponentDesc\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\"}],"
						+ "\"procedureStatusAPI\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"procedureEndAPI\":\"amrith$%2022@\\u0026"
						+ "*piramal@@swasthya!#\",\"isMandatory\":true,\"procedureStartAPI\":\"amrith$%2022@\\u0026*piramal@@swasthya!"
						+ "#\"}],\"archive\":[]}",
				actualBenePrescribedProcedureDetails);
	}

	@Test
	void testGetBenePrescribedProcedureDetails3() throws Exception {
		// Arrange
		when(labResultEntryRepo.findByBeneficiaryRegIDAndVisitCodeOrderByProcedureIDAsc(Mockito.<Long>any(),
				Mockito.<Long>any())).thenReturn(new ArrayList<>());

		V_benLabTestOrderedDetails v_benLabTestOrderedDetails = new V_benLabTestOrderedDetails();
		v_benLabTestOrderedDetails.setBenVisitID(1L);
		v_benLabTestOrderedDetails.setBeneficiaryRegID(1L);
		v_benLabTestOrderedDetails.setCalibrationEndAPI("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setCalibrationStartAPI("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setCalibrationStatusAPI("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setComponentCode("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setComponentUnit("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setDiscoveryCode("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setIOTComponentName("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setIOTProcedureID("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setId("42");
		v_benLabTestOrderedDetails.setInputType("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setIotProcedureName("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setIsDecimal(true);
		v_benLabTestOrderedDetails.setIsLabProcedure(true);
		v_benLabTestOrderedDetails.setIsMandatory(true);
		v_benLabTestOrderedDetails.setMeasurementUnit("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setPrescriptionID(1L);
		v_benLabTestOrderedDetails.setProcedureCode("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setProcedureDesc("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setProcedureEndAPI("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setProcedureID(1);
		v_benLabTestOrderedDetails.setProcedureName("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setProcedureStartAPI("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setProcedureStatusAPI("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setProcedureType("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setRange_max(3);
		v_benLabTestOrderedDetails.setRange_min(1);
		v_benLabTestOrderedDetails.setRange_normal_max(3);
		v_benLabTestOrderedDetails.setRange_normal_min(1);
		v_benLabTestOrderedDetails.setResultValue("42");
		v_benLabTestOrderedDetails.setTestComponentDesc("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setTestComponentID(1);
		v_benLabTestOrderedDetails.setTestComponentName("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails.setVisitCode(1L);

		V_benLabTestOrderedDetails v_benLabTestOrderedDetails2 = new V_benLabTestOrderedDetails();
		v_benLabTestOrderedDetails2.setBenVisitID(2L);
		v_benLabTestOrderedDetails2.setBeneficiaryRegID(2L);
		v_benLabTestOrderedDetails2.setCalibrationEndAPI("Laboratory");
		v_benLabTestOrderedDetails2.setCalibrationStartAPI("Laboratory");
		v_benLabTestOrderedDetails2.setCalibrationStatusAPI("Laboratory");
		v_benLabTestOrderedDetails2.setComponentCode("Laboratory");
		v_benLabTestOrderedDetails2.setComponentUnit("Laboratory");
		v_benLabTestOrderedDetails2.setDiscoveryCode("Laboratory");
		v_benLabTestOrderedDetails2.setIOTComponentName("Laboratory");
		v_benLabTestOrderedDetails2.setIOTProcedureID("Laboratory");
		v_benLabTestOrderedDetails2.setId("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails2.setInputType("Laboratory");
		v_benLabTestOrderedDetails2.setIotProcedureName("Laboratory");
		v_benLabTestOrderedDetails2.setIsDecimal(false);
		v_benLabTestOrderedDetails2.setIsLabProcedure(false);
		v_benLabTestOrderedDetails2.setIsMandatory(false);
		v_benLabTestOrderedDetails2.setMeasurementUnit("Laboratory");
		v_benLabTestOrderedDetails2.setPrescriptionID(2L);
		v_benLabTestOrderedDetails2.setProcedureCode("Laboratory");
		v_benLabTestOrderedDetails2.setProcedureDesc("Laboratory");
		v_benLabTestOrderedDetails2.setProcedureEndAPI("Laboratory");
		v_benLabTestOrderedDetails2.setProcedureID(2);
		v_benLabTestOrderedDetails2.setProcedureName("Laboratory");
		v_benLabTestOrderedDetails2.setProcedureStartAPI("Laboratory");
		v_benLabTestOrderedDetails2.setProcedureStatusAPI("Laboratory");
		v_benLabTestOrderedDetails2.setProcedureType("Laboratory");
		v_benLabTestOrderedDetails2.setRange_max(1);
		v_benLabTestOrderedDetails2.setRange_min(0);
		v_benLabTestOrderedDetails2.setRange_normal_max(1);
		v_benLabTestOrderedDetails2.setRange_normal_min(0);
		v_benLabTestOrderedDetails2.setResultValue("amrith$%2022@&*piramal@@swasthya!#");
		v_benLabTestOrderedDetails2.setTestComponentDesc("Laboratory");
		v_benLabTestOrderedDetails2.setTestComponentID(2);
		v_benLabTestOrderedDetails2.setTestComponentName("Laboratory");
		v_benLabTestOrderedDetails2.setVisitCode(0L);

		ArrayList<V_benLabTestOrderedDetails> v_benLabTestOrderedDetailsList = new ArrayList<>();
		v_benLabTestOrderedDetailsList.add(v_benLabTestOrderedDetails2);
		v_benLabTestOrderedDetailsList.add(v_benLabTestOrderedDetails);
		when(v_benLabTestOrderedDetailsRepo
				.findDistinctByBeneficiaryRegIDAndVisitCodeAndProcedureTypeAndProcedureIDNotInOrderByProcedureIDAscTestComponentIDAscResultValueAsc(
						Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any(),
						Mockito.<ArrayList<Integer>>any()))
				.thenReturn(v_benLabTestOrderedDetailsList);

		// Act
		String actualBenePrescribedProcedureDetails = labTechnicianServiceImpl.getBenePrescribedProcedureDetails(1L,
				1L);

		// Assert
		verify(labResultEntryRepo).findByBeneficiaryRegIDAndVisitCodeOrderByProcedureIDAsc(Mockito.<Long>any(),
				Mockito.<Long>any());
		verify(v_benLabTestOrderedDetailsRepo, atLeast(1))
				.findDistinctByBeneficiaryRegIDAndVisitCodeAndProcedureTypeAndProcedureIDNotInOrderByProcedureIDAscTestComponentIDAscResultValueAsc(
						Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any(),
						Mockito.<ArrayList<Integer>>any());
		assertEquals(
				"{\"radiologyList\":[{\"procedureDesc\":\"Laboratory\",\"procedureType\":\"Radiology\",\"prescriptionID\":2,"
						+ "\"compDetails\":{\"testComponentName\":\"Laboratory\",\"inputType\":\"File\",\"testComponentID\":2,\"testComponentDesc"
						+ "\":\"Laboratory\"},\"procedureName\":\"Laboratory\",\"procedureID\":2},{\"procedureDesc\":\"amrith$%2022@\\u0026"
						+ "*piramal@@swasthya!#\",\"procedureType\":\"Radiology\",\"prescriptionID\":1,\"compDetails\":{\"testComponentName"
						+ "\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"inputType\":\"File\",\"testComponentID\":1,\"testComponentDesc"
						+ "\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\"},\"procedureName\":\"amrith$%2022@\\u0026*piramal@@swasthya!"
						+ "#\",\"procedureID\":1}],\"laboratoryList\":[{\"procedureDesc\":\"Laboratory\",\"procedureType\":\"Laboratory\","
						+ "\"prescriptionID\":2,\"calibrationEndAPI\":\"Laboratory\",\"procedureCode\":\"Laboratory\",\"calibrationStatusAPI"
						+ "\":\"Laboratory\",\"procedureID\":2,\"iotProcedureName\":\"Laboratory\",\"isLabProcedure\":false,\"calibrationStartAPI"
						+ "\":\"Laboratory\",\"discoveryCode\":\"Laboratory\",\"procedureName\":\"Laboratory\",\"compListDetails\":[{\"range"
						+ "_normal_min\":0,\"compOpt\":[{\"name\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\"}],\"componentCode\":\"Laboratory"
						+ "\",\"range_min\":0,\"testComponentID\":2,\"measurementUnit\":\"Laboratory\",\"testComponentName\":\"Laboratory\","
						+ "\"iotComponentName\":\"Laboratory\",\"range_normal_max\":1,\"iotProcedureID\":\"Laboratory\",\"componentUnit\":"
						+ "\"Laboratory\",\"isDecimal\":false,\"inputType\":\"Laboratory\",\"range_max\":1,\"testComponentDesc\":\"Laboratory"
						+ "\"}],\"procedureStatusAPI\":\"Laboratory\",\"procedureEndAPI\":\"Laboratory\",\"isMandatory\":false,\"procedureStartAPI"
						+ "\":\"Laboratory\"},{\"procedureDesc\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"procedureType\":\"Laboratory"
						+ "\",\"prescriptionID\":1,\"calibrationEndAPI\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"procedureCode\":"
						+ "\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"calibrationStatusAPI\":\"amrith$%2022@\\u0026*piramal@@swasthya"
						+ "!#\",\"procedureID\":1,\"iotProcedureName\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"isLabProcedure\":true"
						+ ",\"calibrationStartAPI\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"discoveryCode\":\"amrith$%2022@\\u0026"
						+ "*piramal@@swasthya!#\",\"procedureName\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"compListDetails\":[{"
						+ "\"range_normal_min\":1,\"compOpt\":[{\"name\":\"42\"}],\"componentCode\":\"amrith$%2022@\\u0026*piramal@@swasthya"
						+ "!#\",\"range_min\":1,\"testComponentID\":1,\"measurementUnit\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\","
						+ "\"testComponentName\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"iotComponentName\":\"amrith$%2022@\\u0026"
						+ "*piramal@@swasthya!#\",\"range_normal_max\":3,\"iotProcedureID\":\"amrith$%2022@\\u0026*piramal@@swasthya!#"
						+ "\",\"componentUnit\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"isDecimal\":true,\"inputType\":\"amrith$%2022"
						+ "@\\u0026*piramal@@swasthya!#\",\"range_max\":3,\"testComponentDesc\":\"amrith$%2022@\\u0026*piramal@@swasthya"
						+ "!#\"}],\"procedureStatusAPI\":\"amrith$%2022@\\u0026*piramal@@swasthya!#\",\"procedureEndAPI\":\"amrith$%2022"
						+ "@\\u0026*piramal@@swasthya!#\",\"isMandatory\":true,\"procedureStartAPI\":\"amrith$%2022@\\u0026*piramal@"
						+ "@swasthya!#\"}],\"archive\":[]}",
				actualBenePrescribedProcedureDetails);
	}

	@Test
	void testGetLabResultDataForBen() throws Exception {
		// Arrange
		when(labResultEntryRepo.findByBeneficiaryRegIDAndVisitCodeOrderByProcedureIDAsc(Mockito.<Long>any(),
				Mockito.<Long>any())).thenReturn(new ArrayList<>());

		// Act
		ArrayList<LabResultEntry> actualLabResultDataForBen = labTechnicianServiceImpl.getLabResultDataForBen(1L, 1L);

		// Assert
		verify(labResultEntryRepo).findByBeneficiaryRegIDAndVisitCodeOrderByProcedureIDAsc(Mockito.<Long>any(),
				Mockito.<Long>any());
		assertTrue(actualLabResultDataForBen.isEmpty());
	}

	@Test
	void testGetLabResultDataForBen2() throws Exception {
		// Arrange
		ProcedureData procedureData = new ProcedureData();
		procedureData.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		procedureData.setCreatedDate(mock(Timestamp.class));
		procedureData.setDeleted(true);
		procedureData.setGender("amrith$%2022@&*piramal@@swasthya!#");
		procedureData.setLabResultEntry(new HashSet<>());
		procedureData.setLastModDate(mock(Timestamp.class));
		procedureData.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		procedureData.setProcedureDesc("amrith$%2022@&*piramal@@swasthya!#");
		procedureData.setProcedureID(1);
		procedureData.setProcedureName("amrith$%2022@&*piramal@@swasthya!#");
		procedureData.setProcedureType("amrith$%2022@&*piramal@@swasthya!#");
		procedureData.setProcessed("amrith$%2022@&*piramal@@swasthya!#");
		procedureData.setProviderServiceMapID(1);
		
		procedureData.toString();

		TestComponentMaster testComponentMaster = new TestComponentMaster();
		testComponentMaster.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		testComponentMaster.setCreatedDate(mock(Timestamp.class));
		testComponentMaster.setDeleted(true);
		testComponentMaster.setInputType("amrith$%2022@&*piramal@@swasthya!#");
		testComponentMaster.setLabResultEntry(new HashSet<>());
		testComponentMaster.setLastModDate(mock(Timestamp.class));
		testComponentMaster.setLionicNum("amrith$%2022@&*piramal@@swasthya!#");
		testComponentMaster.setLionicTerm("amrith$%2022@&*piramal@@swasthya!#");
		testComponentMaster.setMeasurementUnit("amrith$%2022@&*piramal@@swasthya!#");
		testComponentMaster.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		testComponentMaster.setProcessed("amrith$%2022@&*piramal@@swasthya!#");
		testComponentMaster.setProviderServiceMapID(1);
		testComponentMaster.setRange_max(3);
		testComponentMaster.setRange_min(1);
		testComponentMaster.setRange_normal_max(3);
		testComponentMaster.setRange_normal_min(1);
		testComponentMaster.setTestComponentDesc("amrith$%2022@&*piramal@@swasthya!#");
		testComponentMaster.setTestComponentID(1);
		testComponentMaster.setTestComponentName("amrith$%2022@&*piramal@@swasthya!#");
		
		testComponentMaster.toString();

		ProcedureData procedureData2 = new ProcedureData();
		procedureData2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		procedureData2.setCreatedDate(mock(Timestamp.class));
		procedureData2.setDeleted(true);
		procedureData2.setGender("Gender");
		procedureData2.setLabResultEntry(new HashSet<>());
		procedureData2.setLastModDate(mock(Timestamp.class));
		procedureData2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		procedureData2.setProcedureDesc("Procedure Desc");
		procedureData2.setProcedureID(1);
		procedureData2.setProcedureName("Procedure Name");
		procedureData2.setProcedureType("Procedure Type");
		procedureData2.setProcessed("Processed");
		procedureData2.setProviderServiceMapID(1);

		TestComponentMaster testComponentMaster2 = new TestComponentMaster();
		testComponentMaster2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		testComponentMaster2.setCreatedDate(mock(Timestamp.class));
		testComponentMaster2.setDeleted(true);
		testComponentMaster2.setInputType("Input Type");
		testComponentMaster2.setLabResultEntry(new HashSet<>());
		testComponentMaster2.setLastModDate(mock(Timestamp.class));
		testComponentMaster2.setLionicNum("Lionic Num");
		testComponentMaster2.setLionicTerm("Lionic Term");
		testComponentMaster2.setMeasurementUnit("Measurement Unit");
		testComponentMaster2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		testComponentMaster2.setProcessed("Processed");
		testComponentMaster2.setProviderServiceMapID(1);
		testComponentMaster2.setRange_max(3);
		testComponentMaster2.setRange_min(1);
		testComponentMaster2.setRange_normal_max(3);
		testComponentMaster2.setRange_normal_min(1);
		testComponentMaster2.setTestComponentDesc("Test Component Desc");
		testComponentMaster2.setTestComponentID(1);
		testComponentMaster2.setTestComponentName("Test Component Name");
		LabResultEntry labResultEntry = mock(LabResultEntry.class);
		when(labResultEntry.getStripsNotAvailable()).thenReturn(true);
		when(labResultEntry.getEcgAbnormalitiesDB()).thenReturn("Ecg Abnormalities DB");
		when(labResultEntry.getRemarks()).thenReturn("Remarks");
		when(labResultEntry.getTestReportFilePath()).thenReturn("");
		when(labResultEntry.getTestResultUnit()).thenReturn("Test Result Unit");
		when(labResultEntry.getTestResultValue()).thenReturn("42");
		when(labResultEntry.getTestComponentMaster()).thenReturn(testComponentMaster2);
		when(labResultEntry.getTestComponentID()).thenReturn(1);
		when(labResultEntry.getCreatedDate()).thenReturn(mock(Timestamp.class));
		when(labResultEntry.getProcedureData()).thenReturn(procedureData2);
		when(labResultEntry.getProcedureID()).thenReturn(1);
		when(labResultEntry.getPrescriptionID()).thenReturn(1L);
		doNothing().when(labResultEntry).setBenVisitID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setCompList(Mockito.<List<Map<String, Object>>>any());
		doNothing().when(labResultEntry).setComponentList(Mockito.<ArrayList<Map<String, Object>>>any());
		doNothing().when(labResultEntry).setCreatedBy(Mockito.<String>any());
		doNothing().when(labResultEntry).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(labResultEntry).setDate(Mockito.<Date>any());
		doNothing().when(labResultEntry).setDeleted(Mockito.<Boolean>any());
		doNothing().when(labResultEntry).setEcgAbnormalities(Mockito.<String[]>any());
		doNothing().when(labResultEntry).setEcgAbnormalitiesDB(Mockito.<String>any());
		doNothing().when(labResultEntry).setFileIDs(Mockito.<String[]>any());
		doNothing().when(labResultEntry).setID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setLabCompleted(Mockito.<Boolean>any());
		doNothing().when(labResultEntry).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(labResultEntry).setModifiedBy(Mockito.<String>any());
		doNothing().when(labResultEntry).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setPrescriptionID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setProcedureData(Mockito.<ProcedureData>any());
		doNothing().when(labResultEntry).setProcedureID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setProcedureName(Mockito.<String>any());
		doNothing().when(labResultEntry).setProcedureType(Mockito.<String>any());
		doNothing().when(labResultEntry).setProcessed(Mockito.<String>any());
		doNothing().when(labResultEntry).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setRemarks(Mockito.<String>any());
		doNothing().when(labResultEntry).setReservedForChange(Mockito.<String>any());
		doNothing().when(labResultEntry).setStripsNotAvailable(Mockito.<Boolean>any());
		doNothing().when(labResultEntry).setSyncedBy(Mockito.<String>any());
		doNothing().when(labResultEntry).setSyncedDate(Mockito.<Timestamp>any());
		doNothing().when(labResultEntry).setTestComponentID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setTestComponentMaster(Mockito.<TestComponentMaster>any());
		doNothing().when(labResultEntry).setTestReportFilePath(Mockito.<String>any());
		doNothing().when(labResultEntry).setTestResultUnit(Mockito.<String>any());
		doNothing().when(labResultEntry).setTestResultValue(Mockito.<String>any());
		doNothing().when(labResultEntry).setVanID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setVanSerialNo(Mockito.<Long>any());
		doNothing().when(labResultEntry).setVehicalNo(Mockito.<String>any());
		doNothing().when(labResultEntry).setVisitCode(Mockito.<Long>any());
		labResultEntry.setBenVisitID(1L);
		labResultEntry.setBeneficiaryRegID(1L);
		labResultEntry.setCompList(new ArrayList<>());
		labResultEntry.setComponentList(new ArrayList<>());
		labResultEntry.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		labResultEntry.setCreatedDate(mock(Timestamp.class));
		labResultEntry.setDate(mock(Date.class));
		labResultEntry.setDeleted(true);
		labResultEntry.setEcgAbnormalities(new String[] { "amrith$%2022@&*piramal@@swasthya!#" });
		labResultEntry.setEcgAbnormalitiesDB("amrith$%2022@&*piramal@@swasthya!#");
		labResultEntry.setFileIDs(new String[] { "amrith$%2022@&*piramal@@swasthya!#" });
		labResultEntry.setID(1L);
		labResultEntry.setLabCompleted(true);
		labResultEntry.setLastModDate(mock(Timestamp.class));
		labResultEntry.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		labResultEntry.setParkingPlaceID(1);
		labResultEntry.setPrescriptionID(1L);
		labResultEntry.setProcedureData(procedureData);
		labResultEntry.setProcedureID(1);
		labResultEntry.setProcedureName("amrith$%2022@&*piramal@@swasthya!#");
		labResultEntry.setProcedureType("amrith$%2022@&*piramal@@swasthya!#");
		labResultEntry.setProcessed("amrith$%2022@&*piramal@@swasthya!#");
		labResultEntry.setProviderServiceMapID(1);
		labResultEntry.setRemarks("amrith$%2022@&*piramal@@swasthya!#");
		labResultEntry.setReservedForChange("amrith$%2022@&*piramal@@swasthya!#");
		labResultEntry.setStripsNotAvailable(true);
		labResultEntry.setSyncedBy("amrith$%2022@&*piramal@@swasthya!#");
		labResultEntry.setSyncedDate(mock(Timestamp.class));
		labResultEntry.setTestComponentID(1);
		labResultEntry.setTestComponentMaster(testComponentMaster);
		labResultEntry.setTestReportFilePath("/directory/foo.txt");
		labResultEntry.setTestResultUnit("amrith$%2022@&*piramal@@swasthya!#");
		labResultEntry.setTestResultValue("42");
		labResultEntry.setVanID(1);
		labResultEntry.setVanSerialNo(1L);
		labResultEntry.setVehicalNo("amrith$%2022@&*piramal@@swasthya!#");
		labResultEntry.setVisitCode(1L);
		
		labResultEntry.toString();

		ArrayList<LabResultEntry> labResultEntryList = new ArrayList<>();
		labResultEntryList.add(labResultEntry);
		when(labResultEntryRepo.findByBeneficiaryRegIDAndVisitCodeOrderByProcedureIDAsc(Mockito.<Long>any(),
				Mockito.<Long>any())).thenReturn(labResultEntryList);

		// Act
		ArrayList<LabResultEntry> actualLabResultDataForBen = labTechnicianServiceImpl.getLabResultDataForBen(1L, 1L);

		// Assert
		verify(labResultEntry).getCreatedDate();
		verify(labResultEntry, atLeast(1)).getEcgAbnormalitiesDB();
		verify(labResultEntry).getPrescriptionID();
		verify(labResultEntry, atLeast(1)).getProcedureData();
		verify(labResultEntry, atLeast(1)).getProcedureID();
		verify(labResultEntry).getRemarks();
		verify(labResultEntry).getStripsNotAvailable();
		verify(labResultEntry).getTestComponentID();
		verify(labResultEntry, atLeast(1)).getTestComponentMaster();
		verify(labResultEntry, atLeast(1)).getTestReportFilePath();
		verify(labResultEntry).getTestResultUnit();
		verify(labResultEntry).getTestResultValue();
		verify(labResultEntry).setBenVisitID(Mockito.<Long>any());
		verify(labResultEntry).setBeneficiaryRegID(Mockito.<Long>any());
		verify(labResultEntry).setCompList(Mockito.<List<Map<String, Object>>>any());
		verify(labResultEntry).setComponentList(Mockito.<ArrayList<Map<String, Object>>>any());
		verify(labResultEntry).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(labResultEntry).setCreatedDate(Mockito.<Timestamp>any());
		verify(labResultEntry).setDate(Mockito.<Date>any());
		verify(labResultEntry).setDeleted(Mockito.<Boolean>any());
		verify(labResultEntry).setEcgAbnormalities(Mockito.<String[]>any());
		verify(labResultEntry).setEcgAbnormalitiesDB(eq("amrith$%2022@&*piramal@@swasthya!#"));
		verify(labResultEntry).setFileIDs(Mockito.<String[]>any());
		verify(labResultEntry).setID(Mockito.<Long>any());
		verify(labResultEntry).setLabCompleted(Mockito.<Boolean>any());
		verify(labResultEntry).setLastModDate(Mockito.<Timestamp>any());
		verify(labResultEntry).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(labResultEntry).setParkingPlaceID(Mockito.<Integer>any());
		verify(labResultEntry).setPrescriptionID(Mockito.<Long>any());
		verify(labResultEntry).setProcedureData(Mockito.<ProcedureData>any());
		verify(labResultEntry).setProcedureID(Mockito.<Integer>any());
		verify(labResultEntry).setProcedureName(eq("amrith$%2022@&*piramal@@swasthya!#"));
		verify(labResultEntry).setProcedureType(eq("amrith$%2022@&*piramal@@swasthya!#"));
		verify(labResultEntry).setProcessed(eq("amrith$%2022@&*piramal@@swasthya!#"));
		verify(labResultEntry).setProviderServiceMapID(Mockito.<Integer>any());
		verify(labResultEntry).setRemarks(eq("amrith$%2022@&*piramal@@swasthya!#"));
		verify(labResultEntry).setReservedForChange(eq("amrith$%2022@&*piramal@@swasthya!#"));
		verify(labResultEntry).setStripsNotAvailable(Mockito.<Boolean>any());
		verify(labResultEntry).setSyncedBy(eq("amrith$%2022@&*piramal@@swasthya!#"));
		verify(labResultEntry).setSyncedDate(Mockito.<Timestamp>any());
		verify(labResultEntry).setTestComponentID(Mockito.<Integer>any());
		verify(labResultEntry).setTestComponentMaster(Mockito.<TestComponentMaster>any());
		verify(labResultEntry).setTestReportFilePath(eq("/directory/foo.txt"));
		verify(labResultEntry).setTestResultUnit(eq("amrith$%2022@&*piramal@@swasthya!#"));
		verify(labResultEntry).setTestResultValue(eq("42"));
		verify(labResultEntry).setVanID(Mockito.<Integer>any());
		verify(labResultEntry).setVanSerialNo(Mockito.<Long>any());
		verify(labResultEntry).setVehicalNo(eq("amrith$%2022@&*piramal@@swasthya!#"));
		verify(labResultEntry).setVisitCode(Mockito.<Long>any());
		verify(labResultEntryRepo).findByBeneficiaryRegIDAndVisitCodeOrderByProcedureIDAsc(Mockito.<Long>any(),
				Mockito.<Long>any());
		assertEquals(1, actualLabResultDataForBen.size());
	}

	@Test
	void testSaveLabTestResult() throws Exception {
		// Arrange, Act and Assert
		assertEquals(1, labTechnicianServiceImpl.saveLabTestResult(new JsonObject()).intValue());
		assertEquals(1, labTechnicianServiceImpl.saveLabTestResult((JsonObject) null).intValue());
	}

	@Test
	void testSaveLabTestResult2() throws Exception {
		// Arrange
		JsonObject requestOBJ = new JsonObject();
		requestOBJ.addProperty("Property", "42");

		// Act and Assert
		assertEquals(1, labTechnicianServiceImpl.saveLabTestResult(requestOBJ).intValue());
	}

	@Test
	void testSaveLabTestResult3() throws Exception {
		// Arrange
		JsonObject requestOBJ = new JsonObject();
		requestOBJ.addProperty("labTestResults", (String) null);

		// Act and Assert
		assertEquals(1, labTechnicianServiceImpl.saveLabTestResult(requestOBJ).intValue());
	}

	@Test
	void testSaveLabTestResult4() {
		// Arrange
		WrapperLabResultEntry wrapperLabResults = new WrapperLabResultEntry();
		wrapperLabResults.setBenFlowID(1L);
		wrapperLabResults.setBeneficiaryRegID(1L);
		wrapperLabResults.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperLabResults.setDoctorFlag((short) 1);
		wrapperLabResults.setLabCompleted(true);
		wrapperLabResults.setLabTestResults(new ArrayList<>());
		wrapperLabResults.setNurseFlag((short) 1);
		wrapperLabResults.setParkingPlaceID(1);
		wrapperLabResults.setProviderServiceMapID(1);
		wrapperLabResults.setRadiologyTestResults(new ArrayList<>());
		wrapperLabResults.setSpecialist_flag((short) 1);
		wrapperLabResults.setVanID(1);
		wrapperLabResults.setVisitCode(1L);
		wrapperLabResults.setVisitID(1L);
		
		wrapperLabResults.toString();

		// Act and Assert
		assertEquals(1, labTechnicianServiceImpl.saveLabTestResult(wrapperLabResults).intValue());
	}

	@Test
	void testSaveLabTestResult5() {
		// Arrange
		WrapperLabResultEntry wrapperLabResults = mock(WrapperLabResultEntry.class);
		when(wrapperLabResults.getLabTestResults()).thenReturn(new ArrayList<>());
		when(wrapperLabResults.getRadiologyTestResults()).thenReturn(new ArrayList<>());
		doNothing().when(wrapperLabResults).setBenFlowID(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setCreatedBy(Mockito.<String>any());
		doNothing().when(wrapperLabResults).setDoctorFlag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setLabCompleted(Mockito.<Boolean>any());
		doNothing().when(wrapperLabResults).setLabTestResults(Mockito.<List<LabResultEntry>>any());
		doNothing().when(wrapperLabResults).setNurseFlag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setRadiologyTestResults(Mockito.<List<LabResultEntry>>any());
		doNothing().when(wrapperLabResults).setSpecialist_flag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setVanID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setVisitCode(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setVisitID(Mockito.<Long>any());
		wrapperLabResults.setBenFlowID(1L);
		wrapperLabResults.setBeneficiaryRegID(1L);
		wrapperLabResults.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperLabResults.setDoctorFlag((short) 1);
		wrapperLabResults.setLabCompleted(true);
		wrapperLabResults.setLabTestResults(new ArrayList<>());
		wrapperLabResults.setNurseFlag((short) 1);
		wrapperLabResults.setParkingPlaceID(1);
		wrapperLabResults.setProviderServiceMapID(1);
		wrapperLabResults.setRadiologyTestResults(new ArrayList<>());
		wrapperLabResults.setSpecialist_flag((short) 1);
		wrapperLabResults.setVanID(1);
		wrapperLabResults.setVisitCode(1L);
		wrapperLabResults.setVisitID(1L);

		// Act
		Integer actualSaveLabTestResultResult = labTechnicianServiceImpl.saveLabTestResult(wrapperLabResults);

		// Assert
		verify(wrapperLabResults).getLabTestResults();
		verify(wrapperLabResults, atLeast(1)).getRadiologyTestResults();
		verify(wrapperLabResults).setBenFlowID(Mockito.<Long>any());
		verify(wrapperLabResults).setBeneficiaryRegID(Mockito.<Long>any());
		verify(wrapperLabResults).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(wrapperLabResults).setDoctorFlag(Mockito.<Short>any());
		verify(wrapperLabResults).setLabCompleted(Mockito.<Boolean>any());
		verify(wrapperLabResults).setLabTestResults(Mockito.<List<LabResultEntry>>any());
		verify(wrapperLabResults).setNurseFlag(Mockito.<Short>any());
		verify(wrapperLabResults).setParkingPlaceID(Mockito.<Integer>any());
		verify(wrapperLabResults).setProviderServiceMapID(Mockito.<Integer>any());
		verify(wrapperLabResults).setRadiologyTestResults(Mockito.<List<LabResultEntry>>any());
		verify(wrapperLabResults).setSpecialist_flag(Mockito.<Short>any());
		verify(wrapperLabResults).setVanID(Mockito.<Integer>any());
		verify(wrapperLabResults).setVisitCode(Mockito.<Long>any());
		verify(wrapperLabResults).setVisitID(Mockito.<Long>any());
		assertEquals(1, actualSaveLabTestResultResult.intValue());
	}

	@Test
	void testSaveLabTestResult6() {
		// Arrange
		ProcedureData procedureData = new ProcedureData();
		procedureData.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		procedureData.setCreatedDate(mock(Timestamp.class));
		procedureData.setDeleted(true);
		procedureData.setGender("Gender");
		procedureData.setLabResultEntry(new HashSet<>());
		procedureData.setLastModDate(mock(Timestamp.class));
		procedureData.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		procedureData.setProcedureDesc("Procedure Desc");
		procedureData.setProcedureID(1);
		procedureData.setProcedureName("Procedure Name");
		procedureData.setProcedureType("Procedure Type");
		procedureData.setProcessed("Processed");
		procedureData.setProviderServiceMapID(1);

		TestComponentMaster testComponentMaster = new TestComponentMaster();
		testComponentMaster.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		testComponentMaster.setCreatedDate(mock(Timestamp.class));
		testComponentMaster.setDeleted(true);
		testComponentMaster.setInputType("Input Type");
		testComponentMaster.setLabResultEntry(new HashSet<>());
		testComponentMaster.setLastModDate(mock(Timestamp.class));
		testComponentMaster.setLionicNum("Lionic Num");
		testComponentMaster.setLionicTerm("Lionic Term");
		testComponentMaster.setMeasurementUnit("Measurement Unit");
		testComponentMaster.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		testComponentMaster.setProcessed("Processed");
		testComponentMaster.setProviderServiceMapID(1);
		testComponentMaster.setRange_max(3);
		testComponentMaster.setRange_min(1);
		testComponentMaster.setRange_normal_max(3);
		testComponentMaster.setRange_normal_min(1);
		testComponentMaster.setTestComponentDesc("Test Component Desc");
		testComponentMaster.setTestComponentID(1);
		testComponentMaster.setTestComponentName("Test Component Name");
		
		testComponentMaster.toString();

		LabResultEntry labResultEntry = new LabResultEntry();
		labResultEntry.setBenVisitID(1L);
		labResultEntry.setBeneficiaryRegID(1L);
		labResultEntry.setCompList(new ArrayList<>());
		labResultEntry.setComponentList(new ArrayList<>());
		labResultEntry.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		labResultEntry.setCreatedDate(mock(Timestamp.class));
		labResultEntry.setDate(mock(Date.class));
		labResultEntry.setDeleted(true);
		labResultEntry.setEcgAbnormalities(new String[] { "Ecg Abnormalities" });
		labResultEntry.setEcgAbnormalitiesDB("Ecg Abnormalities DB");
		labResultEntry.setFileIDs(new String[] { "File IDs" });
		labResultEntry.setID(1L);
		labResultEntry.setLabCompleted(true);
		labResultEntry.setLastModDate(mock(Timestamp.class));
		labResultEntry.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		labResultEntry.setParkingPlaceID(1);
		labResultEntry.setPrescriptionID(1L);
		labResultEntry.setProcedureData(procedureData);
		labResultEntry.setProcedureID(1);
		labResultEntry.setProcedureName("Procedure Name");
		labResultEntry.setProcedureType("Procedure Type");
		labResultEntry.setProcessed("Processed");
		labResultEntry.setProviderServiceMapID(1);
		labResultEntry.setRemarks("Remarks");
		labResultEntry.setReservedForChange("Reserved For Change");
		labResultEntry.setStripsNotAvailable(true);
		labResultEntry.setSyncedBy("Synced By");
		labResultEntry.setSyncedDate(mock(Timestamp.class));
		labResultEntry.setTestComponentID(1);
		labResultEntry.setTestComponentMaster(testComponentMaster);
		labResultEntry.setTestReportFilePath("/directory/foo.txt");
		labResultEntry.setTestResultUnit("Test Result Unit");
		labResultEntry.setTestResultValue("42");
		labResultEntry.setVanID(1);
		labResultEntry.setVanSerialNo(1L);
		labResultEntry.setVehicalNo("Vehical No");
		labResultEntry.setVisitCode(1L);

		ArrayList<LabResultEntry> labResultEntryList = new ArrayList<>();
		labResultEntryList.add(labResultEntry);
		WrapperLabResultEntry wrapperLabResults = mock(WrapperLabResultEntry.class);
		when(wrapperLabResults.getLabTestResults()).thenReturn(labResultEntryList);
		when(wrapperLabResults.getRadiologyTestResults()).thenReturn(new ArrayList<>());
		doNothing().when(wrapperLabResults).setBenFlowID(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setCreatedBy(Mockito.<String>any());
		doNothing().when(wrapperLabResults).setDoctorFlag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setLabCompleted(Mockito.<Boolean>any());
		doNothing().when(wrapperLabResults).setLabTestResults(Mockito.<List<LabResultEntry>>any());
		doNothing().when(wrapperLabResults).setNurseFlag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setRadiologyTestResults(Mockito.<List<LabResultEntry>>any());
		doNothing().when(wrapperLabResults).setSpecialist_flag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setVanID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setVisitCode(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setVisitID(Mockito.<Long>any());
		wrapperLabResults.setBenFlowID(1L);
		wrapperLabResults.setBeneficiaryRegID(1L);
		wrapperLabResults.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperLabResults.setDoctorFlag((short) 1);
		wrapperLabResults.setLabCompleted(true);
		wrapperLabResults.setLabTestResults(new ArrayList<>());
		wrapperLabResults.setNurseFlag((short) 1);
		wrapperLabResults.setParkingPlaceID(1);
		wrapperLabResults.setProviderServiceMapID(1);
		wrapperLabResults.setRadiologyTestResults(new ArrayList<>());
		wrapperLabResults.setSpecialist_flag((short) 1);
		wrapperLabResults.setVanID(1);
		wrapperLabResults.setVisitCode(1L);
		wrapperLabResults.setVisitID(1L);
		
		wrapperLabResults.toString();

		// Act
		Integer actualSaveLabTestResultResult = labTechnicianServiceImpl.saveLabTestResult(wrapperLabResults);

		// Assert
		verify(wrapperLabResults).getLabTestResults();
		verify(wrapperLabResults).getRadiologyTestResults();
		verify(wrapperLabResults).setBenFlowID(Mockito.<Long>any());
		verify(wrapperLabResults).setBeneficiaryRegID(Mockito.<Long>any());
		verify(wrapperLabResults).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(wrapperLabResults).setDoctorFlag(Mockito.<Short>any());
		verify(wrapperLabResults).setLabCompleted(Mockito.<Boolean>any());
		verify(wrapperLabResults).setLabTestResults(Mockito.<List<LabResultEntry>>any());
		verify(wrapperLabResults).setNurseFlag(Mockito.<Short>any());
		verify(wrapperLabResults).setParkingPlaceID(Mockito.<Integer>any());
		verify(wrapperLabResults).setProviderServiceMapID(Mockito.<Integer>any());
		verify(wrapperLabResults).setRadiologyTestResults(Mockito.<List<LabResultEntry>>any());
		verify(wrapperLabResults).setSpecialist_flag(Mockito.<Short>any());
		verify(wrapperLabResults).setVanID(Mockito.<Integer>any());
		verify(wrapperLabResults).setVisitCode(Mockito.<Long>any());
		verify(wrapperLabResults).setVisitID(Mockito.<Long>any());
		assertEquals(1, actualSaveLabTestResultResult.intValue());
	}

	@Test
	void testSaveLabTestResult7() {
		// Arrange
		when(labResultEntryRepo.saveAll(Mockito.<Iterable<LabResultEntry>>any())).thenReturn(new ArrayList<>());

		ProcedureData procedureData = new ProcedureData();
		procedureData.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		procedureData.setCreatedDate(mock(Timestamp.class));
		procedureData.setDeleted(true);
		procedureData.setGender("Gender");
		procedureData.setLabResultEntry(new HashSet<>());
		procedureData.setLastModDate(mock(Timestamp.class));
		procedureData.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		procedureData.setProcedureDesc("Procedure Desc");
		procedureData.setProcedureID(1);
		procedureData.setProcedureName("Procedure Name");
		procedureData.setProcedureType("Procedure Type");
		procedureData.setProcessed("Processed");
		procedureData.setProviderServiceMapID(1);

		TestComponentMaster testComponentMaster = new TestComponentMaster();
		testComponentMaster.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		testComponentMaster.setCreatedDate(mock(Timestamp.class));
		testComponentMaster.setDeleted(true);
		testComponentMaster.setInputType("Input Type");
		testComponentMaster.setLabResultEntry(new HashSet<>());
		testComponentMaster.setLastModDate(mock(Timestamp.class));
		testComponentMaster.setLionicNum("Lionic Num");
		testComponentMaster.setLionicTerm("Lionic Term");
		testComponentMaster.setMeasurementUnit("Measurement Unit");
		testComponentMaster.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		testComponentMaster.setProcessed("Processed");
		testComponentMaster.setProviderServiceMapID(1);
		testComponentMaster.setRange_max(3);
		testComponentMaster.setRange_min(1);
		testComponentMaster.setRange_normal_max(3);
		testComponentMaster.setRange_normal_min(1);
		testComponentMaster.setTestComponentDesc("Test Component Desc");
		testComponentMaster.setTestComponentID(1);
		testComponentMaster.setTestComponentName("Test Component Name");

		LabResultEntry labResultEntry = new LabResultEntry();
		labResultEntry.setBenVisitID(1L);
		labResultEntry.setBeneficiaryRegID(1L);
		labResultEntry.setCompList(new ArrayList<>());
		labResultEntry.setComponentList(new ArrayList<>());
		labResultEntry.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		labResultEntry.setCreatedDate(mock(Timestamp.class));
		labResultEntry.setDate(mock(Date.class));
		labResultEntry.setDeleted(true);
		labResultEntry.setEcgAbnormalities(new String[] { "Ecg Abnormalities" });
		labResultEntry.setEcgAbnormalitiesDB("Ecg Abnormalities DB");
		labResultEntry.setFileIDs(new String[] { "File IDs" });
		labResultEntry.setID(1L);
		labResultEntry.setLabCompleted(true);
		labResultEntry.setLastModDate(mock(Timestamp.class));
		labResultEntry.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		labResultEntry.setParkingPlaceID(1);
		labResultEntry.setPrescriptionID(1L);
		labResultEntry.setProcedureData(procedureData);
		labResultEntry.setProcedureID(1);
		labResultEntry.setProcedureName("Procedure Name");
		labResultEntry.setProcedureType("Procedure Type");
		labResultEntry.setProcessed("Processed");
		labResultEntry.setProviderServiceMapID(1);
		labResultEntry.setRemarks("Remarks");
		labResultEntry.setReservedForChange("Reserved For Change");
		labResultEntry.setStripsNotAvailable(true);
		labResultEntry.setSyncedBy("Synced By");
		labResultEntry.setSyncedDate(mock(Timestamp.class));
		labResultEntry.setTestComponentID(1);
		labResultEntry.setTestComponentMaster(testComponentMaster);
		labResultEntry.setTestReportFilePath("/directory/foo.txt");
		labResultEntry.setTestResultUnit("Test Result Unit");
		labResultEntry.setTestResultValue("42");
		labResultEntry.setVanID(1);
		labResultEntry.setVanSerialNo(1L);
		labResultEntry.setVehicalNo("Vehical No");
		labResultEntry.setVisitCode(1L);

		ArrayList<LabResultEntry> labResultEntryList = new ArrayList<>();
		labResultEntryList.add(labResultEntry);
		WrapperLabResultEntry wrapperLabResults = mock(WrapperLabResultEntry.class);
		when(wrapperLabResults.getParkingPlaceID()).thenReturn(1);
		when(wrapperLabResults.getProviderServiceMapID()).thenReturn(1);
		when(wrapperLabResults.getVanID()).thenReturn(1);
		when(wrapperLabResults.getBeneficiaryRegID()).thenReturn(1L);
		when(wrapperLabResults.getVisitCode()).thenReturn(1L);
		when(wrapperLabResults.getVisitID()).thenReturn(1L);
		when(wrapperLabResults.getCreatedBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
		when(wrapperLabResults.getLabTestResults()).thenReturn(new ArrayList<>());
		when(wrapperLabResults.getRadiologyTestResults()).thenReturn(labResultEntryList);
		doNothing().when(wrapperLabResults).setBenFlowID(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setCreatedBy(Mockito.<String>any());
		doNothing().when(wrapperLabResults).setDoctorFlag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setLabCompleted(Mockito.<Boolean>any());
		doNothing().when(wrapperLabResults).setLabTestResults(Mockito.<List<LabResultEntry>>any());
		doNothing().when(wrapperLabResults).setNurseFlag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setRadiologyTestResults(Mockito.<List<LabResultEntry>>any());
		doNothing().when(wrapperLabResults).setSpecialist_flag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setVanID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setVisitCode(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setVisitID(Mockito.<Long>any());
		wrapperLabResults.setBenFlowID(1L);
		wrapperLabResults.setBeneficiaryRegID(1L);
		wrapperLabResults.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperLabResults.setDoctorFlag((short) 1);
		wrapperLabResults.setLabCompleted(true);
		wrapperLabResults.setLabTestResults(new ArrayList<>());
		wrapperLabResults.setNurseFlag((short) 1);
		wrapperLabResults.setParkingPlaceID(1);
		wrapperLabResults.setProviderServiceMapID(1);
		wrapperLabResults.setRadiologyTestResults(new ArrayList<>());
		wrapperLabResults.setSpecialist_flag((short) 1);
		wrapperLabResults.setVanID(1);
		wrapperLabResults.setVisitCode(1L);
		wrapperLabResults.setVisitID(1L);

		// Act
		Integer actualSaveLabTestResultResult = labTechnicianServiceImpl.saveLabTestResult(wrapperLabResults);

		// Assert
		verify(wrapperLabResults).getBeneficiaryRegID();
		verify(wrapperLabResults).getCreatedBy();
		verify(wrapperLabResults).getLabTestResults();
		verify(wrapperLabResults).getParkingPlaceID();
		verify(wrapperLabResults).getProviderServiceMapID();
		verify(wrapperLabResults, atLeast(1)).getRadiologyTestResults();
		verify(wrapperLabResults).getVanID();
		verify(wrapperLabResults).getVisitCode();
		verify(wrapperLabResults).getVisitID();
		verify(wrapperLabResults).setBenFlowID(Mockito.<Long>any());
		verify(wrapperLabResults).setBeneficiaryRegID(Mockito.<Long>any());
		verify(wrapperLabResults).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(wrapperLabResults).setDoctorFlag(Mockito.<Short>any());
		verify(wrapperLabResults).setLabCompleted(Mockito.<Boolean>any());
		verify(wrapperLabResults).setLabTestResults(Mockito.<List<LabResultEntry>>any());
		verify(wrapperLabResults).setNurseFlag(Mockito.<Short>any());
		verify(wrapperLabResults).setParkingPlaceID(Mockito.<Integer>any());
		verify(wrapperLabResults).setProviderServiceMapID(Mockito.<Integer>any());
		verify(wrapperLabResults).setRadiologyTestResults(Mockito.<List<LabResultEntry>>any());
		verify(wrapperLabResults).setSpecialist_flag(Mockito.<Short>any());
		verify(wrapperLabResults).setVanID(Mockito.<Integer>any());
		verify(wrapperLabResults).setVisitCode(Mockito.<Long>any());
		verify(wrapperLabResults).setVisitID(Mockito.<Long>any());
		verify(labResultEntryRepo).saveAll(Mockito.<Iterable<LabResultEntry>>any());
		assertNull(actualSaveLabTestResultResult);
	}

	@Test
	void testSaveLabTestResult8() {
		// Arrange
		ProcedureData procedureData = new ProcedureData();
		procedureData.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		procedureData.setCreatedDate(mock(Timestamp.class));
		procedureData.setDeleted(true);
		procedureData.setGender("Gender");
		procedureData.setLabResultEntry(new HashSet<>());
		procedureData.setLastModDate(mock(Timestamp.class));
		procedureData.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		procedureData.setProcedureDesc("Procedure Desc");
		procedureData.setProcedureID(1);
		procedureData.setProcedureName("Procedure Name");
		procedureData.setProcedureType("Procedure Type");
		procedureData.setProcessed("Processed");
		procedureData.setProviderServiceMapID(1);

		TestComponentMaster testComponentMaster = new TestComponentMaster();
		testComponentMaster.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		testComponentMaster.setCreatedDate(mock(Timestamp.class));
		testComponentMaster.setDeleted(true);
		testComponentMaster.setInputType("Input Type");
		testComponentMaster.setLabResultEntry(new HashSet<>());
		testComponentMaster.setLastModDate(mock(Timestamp.class));
		testComponentMaster.setLionicNum("Lionic Num");
		testComponentMaster.setLionicTerm("Lionic Term");
		testComponentMaster.setMeasurementUnit("Measurement Unit");
		testComponentMaster.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		testComponentMaster.setProcessed("Processed");
		testComponentMaster.setProviderServiceMapID(1);
		testComponentMaster.setRange_max(3);
		testComponentMaster.setRange_min(1);
		testComponentMaster.setRange_normal_max(3);
		testComponentMaster.setRange_normal_min(1);
		testComponentMaster.setTestComponentDesc("Test Component Desc");
		testComponentMaster.setTestComponentID(1);
		testComponentMaster.setTestComponentName("Test Component Name");

		LabResultEntry labResultEntry = new LabResultEntry();
		labResultEntry.setBenVisitID(1L);
		labResultEntry.setBeneficiaryRegID(1L);
		labResultEntry.setCompList(new ArrayList<>());
		labResultEntry.setComponentList(new ArrayList<>());
		labResultEntry.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		labResultEntry.setCreatedDate(mock(Timestamp.class));
		labResultEntry.setDate(mock(Date.class));
		labResultEntry.setDeleted(true);
		labResultEntry.setEcgAbnormalities(new String[] { "Ecg Abnormalities" });
		labResultEntry.setEcgAbnormalitiesDB("Ecg Abnormalities DB");
		labResultEntry.setFileIDs(new String[] { "File IDs" });
		labResultEntry.setID(1L);
		labResultEntry.setLabCompleted(true);
		labResultEntry.setLastModDate(mock(Timestamp.class));
		labResultEntry.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		labResultEntry.setParkingPlaceID(1);
		labResultEntry.setPrescriptionID(1L);
		labResultEntry.setProcedureData(procedureData);
		labResultEntry.setProcedureID(1);
		labResultEntry.setProcedureName("Procedure Name");
		labResultEntry.setProcedureType("Procedure Type");
		labResultEntry.setProcessed("Processed");
		labResultEntry.setProviderServiceMapID(1);
		labResultEntry.setRemarks("Remarks");
		labResultEntry.setReservedForChange("Reserved For Change");
		labResultEntry.setStripsNotAvailable(true);
		labResultEntry.setSyncedBy("Synced By");
		labResultEntry.setSyncedDate(mock(Timestamp.class));
		labResultEntry.setTestComponentID(1);
		labResultEntry.setTestComponentMaster(testComponentMaster);
		labResultEntry.setTestReportFilePath("/directory/foo.txt");
		labResultEntry.setTestResultUnit("Test Result Unit");
		labResultEntry.setTestResultValue("42");
		labResultEntry.setVanID(1);
		labResultEntry.setVanSerialNo(1L);
		labResultEntry.setVehicalNo("Vehical No");
		labResultEntry.setVisitCode(1L);

		ArrayList<LabResultEntry> labResultEntryList = new ArrayList<>();
		labResultEntryList.add(labResultEntry);
		when(labResultEntryRepo.saveAll(Mockito.<Iterable<LabResultEntry>>any())).thenReturn(labResultEntryList);

		ProcedureData procedureData2 = new ProcedureData();
		procedureData2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		procedureData2.setCreatedDate(mock(Timestamp.class));
		procedureData2.setDeleted(true);
		procedureData2.setGender("Gender");
		procedureData2.setLabResultEntry(new HashSet<>());
		procedureData2.setLastModDate(mock(Timestamp.class));
		procedureData2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		procedureData2.setProcedureDesc("Procedure Desc");
		procedureData2.setProcedureID(1);
		procedureData2.setProcedureName("Procedure Name");
		procedureData2.setProcedureType("Procedure Type");
		procedureData2.setProcessed("Processed");
		procedureData2.setProviderServiceMapID(1);

		TestComponentMaster testComponentMaster2 = new TestComponentMaster();
		testComponentMaster2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		testComponentMaster2.setCreatedDate(mock(Timestamp.class));
		testComponentMaster2.setDeleted(true);
		testComponentMaster2.setInputType("Input Type");
		testComponentMaster2.setLabResultEntry(new HashSet<>());
		testComponentMaster2.setLastModDate(mock(Timestamp.class));
		testComponentMaster2.setLionicNum("Lionic Num");
		testComponentMaster2.setLionicTerm("Lionic Term");
		testComponentMaster2.setMeasurementUnit("Measurement Unit");
		testComponentMaster2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		testComponentMaster2.setProcessed("Processed");
		testComponentMaster2.setProviderServiceMapID(1);
		testComponentMaster2.setRange_max(3);
		testComponentMaster2.setRange_min(1);
		testComponentMaster2.setRange_normal_max(3);
		testComponentMaster2.setRange_normal_min(1);
		testComponentMaster2.setTestComponentDesc("Test Component Desc");
		testComponentMaster2.setTestComponentID(1);
		testComponentMaster2.setTestComponentName("Test Component Name");

		LabResultEntry labResultEntry2 = new LabResultEntry();
		labResultEntry2.setBenVisitID(1L);
		labResultEntry2.setBeneficiaryRegID(1L);
		labResultEntry2.setCompList(new ArrayList<>());
		labResultEntry2.setComponentList(new ArrayList<>());
		labResultEntry2.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		labResultEntry2.setCreatedDate(mock(Timestamp.class));
		labResultEntry2.setDate(mock(Date.class));
		labResultEntry2.setDeleted(true);
		labResultEntry2.setEcgAbnormalities(new String[] { "Ecg Abnormalities" });
		labResultEntry2.setEcgAbnormalitiesDB("Ecg Abnormalities DB");
		labResultEntry2.setFileIDs(new String[] { "File IDs" });
		labResultEntry2.setID(1L);
		labResultEntry2.setLabCompleted(true);
		labResultEntry2.setLastModDate(mock(Timestamp.class));
		labResultEntry2.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		labResultEntry2.setParkingPlaceID(1);
		labResultEntry2.setPrescriptionID(1L);
		labResultEntry2.setProcedureData(procedureData2);
		labResultEntry2.setProcedureID(1);
		labResultEntry2.setProcedureName("Procedure Name");
		labResultEntry2.setProcedureType("Procedure Type");
		labResultEntry2.setProcessed("Processed");
		labResultEntry2.setProviderServiceMapID(1);
		labResultEntry2.setRemarks("Remarks");
		labResultEntry2.setReservedForChange("Reserved For Change");
		labResultEntry2.setStripsNotAvailable(true);
		labResultEntry2.setSyncedBy("Synced By");
		labResultEntry2.setSyncedDate(mock(Timestamp.class));
		labResultEntry2.setTestComponentID(1);
		labResultEntry2.setTestComponentMaster(testComponentMaster2);
		labResultEntry2.setTestReportFilePath("/directory/foo.txt");
		labResultEntry2.setTestResultUnit("Test Result Unit");
		labResultEntry2.setTestResultValue("42");
		labResultEntry2.setVanID(1);
		labResultEntry2.setVanSerialNo(1L);
		labResultEntry2.setVehicalNo("Vehical No");
		labResultEntry2.setVisitCode(1L);

		ArrayList<LabResultEntry> labResultEntryList2 = new ArrayList<>();
		labResultEntryList2.add(labResultEntry2);
		WrapperLabResultEntry wrapperLabResults = mock(WrapperLabResultEntry.class);
		when(wrapperLabResults.getParkingPlaceID()).thenReturn(1);
		when(wrapperLabResults.getProviderServiceMapID()).thenReturn(1);
		when(wrapperLabResults.getVanID()).thenReturn(1);
		when(wrapperLabResults.getBeneficiaryRegID()).thenReturn(1L);
		when(wrapperLabResults.getVisitCode()).thenReturn(1L);
		when(wrapperLabResults.getVisitID()).thenReturn(1L);
		when(wrapperLabResults.getCreatedBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
		when(wrapperLabResults.getLabTestResults()).thenReturn(new ArrayList<>());
		when(wrapperLabResults.getRadiologyTestResults()).thenReturn(labResultEntryList2);
		doNothing().when(wrapperLabResults).setBenFlowID(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setCreatedBy(Mockito.<String>any());
		doNothing().when(wrapperLabResults).setDoctorFlag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setLabCompleted(Mockito.<Boolean>any());
		doNothing().when(wrapperLabResults).setLabTestResults(Mockito.<List<LabResultEntry>>any());
		doNothing().when(wrapperLabResults).setNurseFlag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setRadiologyTestResults(Mockito.<List<LabResultEntry>>any());
		doNothing().when(wrapperLabResults).setSpecialist_flag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setVanID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setVisitCode(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setVisitID(Mockito.<Long>any());
		wrapperLabResults.setBenFlowID(1L);
		wrapperLabResults.setBeneficiaryRegID(1L);
		wrapperLabResults.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperLabResults.setDoctorFlag((short) 1);
		wrapperLabResults.setLabCompleted(true);
		wrapperLabResults.setLabTestResults(new ArrayList<>());
		wrapperLabResults.setNurseFlag((short) 1);
		wrapperLabResults.setParkingPlaceID(1);
		wrapperLabResults.setProviderServiceMapID(1);
		wrapperLabResults.setRadiologyTestResults(new ArrayList<>());
		wrapperLabResults.setSpecialist_flag((short) 1);
		wrapperLabResults.setVanID(1);
		wrapperLabResults.setVisitCode(1L);
		wrapperLabResults.setVisitID(1L);

		// Act
		Integer actualSaveLabTestResultResult = labTechnicianServiceImpl.saveLabTestResult(wrapperLabResults);

		// Assert
		verify(wrapperLabResults).getBeneficiaryRegID();
		verify(wrapperLabResults).getCreatedBy();
		verify(wrapperLabResults).getLabTestResults();
		verify(wrapperLabResults).getParkingPlaceID();
		verify(wrapperLabResults).getProviderServiceMapID();
		verify(wrapperLabResults, atLeast(1)).getRadiologyTestResults();
		verify(wrapperLabResults).getVanID();
		verify(wrapperLabResults).getVisitCode();
		verify(wrapperLabResults).getVisitID();
		verify(wrapperLabResults).setBenFlowID(Mockito.<Long>any());
		verify(wrapperLabResults).setBeneficiaryRegID(Mockito.<Long>any());
		verify(wrapperLabResults).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(wrapperLabResults).setDoctorFlag(Mockito.<Short>any());
		verify(wrapperLabResults).setLabCompleted(Mockito.<Boolean>any());
		verify(wrapperLabResults).setLabTestResults(Mockito.<List<LabResultEntry>>any());
		verify(wrapperLabResults).setNurseFlag(Mockito.<Short>any());
		verify(wrapperLabResults).setParkingPlaceID(Mockito.<Integer>any());
		verify(wrapperLabResults).setProviderServiceMapID(Mockito.<Integer>any());
		verify(wrapperLabResults).setRadiologyTestResults(Mockito.<List<LabResultEntry>>any());
		verify(wrapperLabResults).setSpecialist_flag(Mockito.<Short>any());
		verify(wrapperLabResults).setVanID(Mockito.<Integer>any());
		verify(wrapperLabResults).setVisitCode(Mockito.<Long>any());
		verify(wrapperLabResults).setVisitID(Mockito.<Long>any());
		verify(labResultEntryRepo).saveAll(Mockito.<Iterable<LabResultEntry>>any());
		assertEquals(1, actualSaveLabTestResultResult.intValue());
	}

	@Test
	void testSaveLabTestResult9() {
		// Arrange
		when(labResultEntryRepo.saveAll(Mockito.<Iterable<LabResultEntry>>any())).thenReturn(new ArrayList<>());

		ProcedureData procedureData = new ProcedureData();
		procedureData.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		procedureData.setCreatedDate(mock(Timestamp.class));
		procedureData.setDeleted(true);
		procedureData.setGender("Gender");
		procedureData.setLabResultEntry(new HashSet<>());
		procedureData.setLastModDate(mock(Timestamp.class));
		procedureData.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		procedureData.setProcedureDesc("Procedure Desc");
		procedureData.setProcedureID(1);
		procedureData.setProcedureName("Procedure Name");
		procedureData.setProcedureType("Procedure Type");
		procedureData.setProcessed("Processed");
		procedureData.setProviderServiceMapID(1);

		TestComponentMaster testComponentMaster = new TestComponentMaster();
		testComponentMaster.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		testComponentMaster.setCreatedDate(mock(Timestamp.class));
		testComponentMaster.setDeleted(true);
		testComponentMaster.setInputType("Input Type");
		testComponentMaster.setLabResultEntry(new HashSet<>());
		testComponentMaster.setLastModDate(mock(Timestamp.class));
		testComponentMaster.setLionicNum("Lionic Num");
		testComponentMaster.setLionicTerm("Lionic Term");
		testComponentMaster.setMeasurementUnit("Measurement Unit");
		testComponentMaster.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		testComponentMaster.setProcessed("Processed");
		testComponentMaster.setProviderServiceMapID(1);
		testComponentMaster.setRange_max(3);
		testComponentMaster.setRange_min(1);
		testComponentMaster.setRange_normal_max(3);
		testComponentMaster.setRange_normal_min(1);
		testComponentMaster.setTestComponentDesc("Test Component Desc");
		testComponentMaster.setTestComponentID(1);
		testComponentMaster.setTestComponentName("Test Component Name");
		LabResultEntry labResultEntry = mock(LabResultEntry.class);
		when(labResultEntry.getFileIDs()).thenReturn(new String[] { "File IDs" });
		doNothing().when(labResultEntry).setBenVisitID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setCompList(Mockito.<List<Map<String, Object>>>any());
		doNothing().when(labResultEntry).setComponentList(Mockito.<ArrayList<Map<String, Object>>>any());
		doNothing().when(labResultEntry).setCreatedBy(Mockito.<String>any());
		doNothing().when(labResultEntry).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(labResultEntry).setDate(Mockito.<Date>any());
		doNothing().when(labResultEntry).setDeleted(Mockito.<Boolean>any());
		doNothing().when(labResultEntry).setEcgAbnormalities(Mockito.<String[]>any());
		doNothing().when(labResultEntry).setEcgAbnormalitiesDB(Mockito.<String>any());
		doNothing().when(labResultEntry).setFileIDs(Mockito.<String[]>any());
		doNothing().when(labResultEntry).setID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setLabCompleted(Mockito.<Boolean>any());
		doNothing().when(labResultEntry).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(labResultEntry).setModifiedBy(Mockito.<String>any());
		doNothing().when(labResultEntry).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setPrescriptionID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setProcedureData(Mockito.<ProcedureData>any());
		doNothing().when(labResultEntry).setProcedureID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setProcedureName(Mockito.<String>any());
		doNothing().when(labResultEntry).setProcedureType(Mockito.<String>any());
		doNothing().when(labResultEntry).setProcessed(Mockito.<String>any());
		doNothing().when(labResultEntry).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setRemarks(Mockito.<String>any());
		doNothing().when(labResultEntry).setReservedForChange(Mockito.<String>any());
		doNothing().when(labResultEntry).setStripsNotAvailable(Mockito.<Boolean>any());
		doNothing().when(labResultEntry).setSyncedBy(Mockito.<String>any());
		doNothing().when(labResultEntry).setSyncedDate(Mockito.<Timestamp>any());
		doNothing().when(labResultEntry).setTestComponentID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setTestComponentMaster(Mockito.<TestComponentMaster>any());
		doNothing().when(labResultEntry).setTestReportFilePath(Mockito.<String>any());
		doNothing().when(labResultEntry).setTestResultUnit(Mockito.<String>any());
		doNothing().when(labResultEntry).setTestResultValue(Mockito.<String>any());
		doNothing().when(labResultEntry).setVanID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setVanSerialNo(Mockito.<Long>any());
		doNothing().when(labResultEntry).setVehicalNo(Mockito.<String>any());
		doNothing().when(labResultEntry).setVisitCode(Mockito.<Long>any());
		labResultEntry.setBenVisitID(1L);
		labResultEntry.setBeneficiaryRegID(1L);
		labResultEntry.setCompList(new ArrayList<>());
		labResultEntry.setComponentList(new ArrayList<>());
		labResultEntry.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		labResultEntry.setCreatedDate(mock(Timestamp.class));
		labResultEntry.setDate(mock(Date.class));
		labResultEntry.setDeleted(true);
		labResultEntry.setEcgAbnormalities(new String[] { "Ecg Abnormalities" });
		labResultEntry.setEcgAbnormalitiesDB("Ecg Abnormalities DB");
		labResultEntry.setFileIDs(new String[] { "File IDs" });
		labResultEntry.setID(1L);
		labResultEntry.setLabCompleted(true);
		labResultEntry.setLastModDate(mock(Timestamp.class));
		labResultEntry.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		labResultEntry.setParkingPlaceID(1);
		labResultEntry.setPrescriptionID(1L);
		labResultEntry.setProcedureData(procedureData);
		labResultEntry.setProcedureID(1);
		labResultEntry.setProcedureName("Procedure Name");
		labResultEntry.setProcedureType("Procedure Type");
		labResultEntry.setProcessed("Processed");
		labResultEntry.setProviderServiceMapID(1);
		labResultEntry.setRemarks("Remarks");
		labResultEntry.setReservedForChange("Reserved For Change");
		labResultEntry.setStripsNotAvailable(true);
		labResultEntry.setSyncedBy("Synced By");
		labResultEntry.setSyncedDate(mock(Timestamp.class));
		labResultEntry.setTestComponentID(1);
		labResultEntry.setTestComponentMaster(testComponentMaster);
		labResultEntry.setTestReportFilePath("/directory/foo.txt");
		labResultEntry.setTestResultUnit("Test Result Unit");
		labResultEntry.setTestResultValue("42");
		labResultEntry.setVanID(1);
		labResultEntry.setVanSerialNo(1L);
		labResultEntry.setVehicalNo("Vehical No");
		labResultEntry.setVisitCode(1L);

		ArrayList<LabResultEntry> labResultEntryList = new ArrayList<>();
		labResultEntryList.add(labResultEntry);
		WrapperLabResultEntry wrapperLabResults = mock(WrapperLabResultEntry.class);
		when(wrapperLabResults.getParkingPlaceID()).thenReturn(1);
		when(wrapperLabResults.getProviderServiceMapID()).thenReturn(1);
		when(wrapperLabResults.getVanID()).thenReturn(1);
		when(wrapperLabResults.getBeneficiaryRegID()).thenReturn(1L);
		when(wrapperLabResults.getVisitCode()).thenReturn(1L);
		when(wrapperLabResults.getVisitID()).thenReturn(1L);
		when(wrapperLabResults.getCreatedBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
		when(wrapperLabResults.getLabTestResults()).thenReturn(new ArrayList<>());
		when(wrapperLabResults.getRadiologyTestResults()).thenReturn(labResultEntryList);
		doNothing().when(wrapperLabResults).setBenFlowID(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setCreatedBy(Mockito.<String>any());
		doNothing().when(wrapperLabResults).setDoctorFlag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setLabCompleted(Mockito.<Boolean>any());
		doNothing().when(wrapperLabResults).setLabTestResults(Mockito.<List<LabResultEntry>>any());
		doNothing().when(wrapperLabResults).setNurseFlag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setRadiologyTestResults(Mockito.<List<LabResultEntry>>any());
		doNothing().when(wrapperLabResults).setSpecialist_flag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setVanID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setVisitCode(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setVisitID(Mockito.<Long>any());
		wrapperLabResults.setBenFlowID(1L);
		wrapperLabResults.setBeneficiaryRegID(1L);
		wrapperLabResults.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperLabResults.setDoctorFlag((short) 1);
		wrapperLabResults.setLabCompleted(true);
		wrapperLabResults.setLabTestResults(new ArrayList<>());
		wrapperLabResults.setNurseFlag((short) 1);
		wrapperLabResults.setParkingPlaceID(1);
		wrapperLabResults.setProviderServiceMapID(1);
		wrapperLabResults.setRadiologyTestResults(new ArrayList<>());
		wrapperLabResults.setSpecialist_flag((short) 1);
		wrapperLabResults.setVanID(1);
		wrapperLabResults.setVisitCode(1L);
		wrapperLabResults.setVisitID(1L);

		// Act
		Integer actualSaveLabTestResultResult = labTechnicianServiceImpl.saveLabTestResult(wrapperLabResults);

		// Assert
		verify(labResultEntry).getFileIDs();
		verify(labResultEntry, atLeast(1)).setBenVisitID(Mockito.<Long>any());
		verify(labResultEntry, atLeast(1)).setBeneficiaryRegID(Mockito.<Long>any());
		verify(labResultEntry).setCompList(Mockito.<List<Map<String, Object>>>any());
		verify(labResultEntry).setComponentList(Mockito.<ArrayList<Map<String, Object>>>any());
		verify(labResultEntry, atLeast(1)).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(labResultEntry).setCreatedDate(Mockito.<Timestamp>any());
		verify(labResultEntry).setDate(Mockito.<Date>any());
		verify(labResultEntry).setDeleted(Mockito.<Boolean>any());
		verify(labResultEntry).setEcgAbnormalities(Mockito.<String[]>any());
		verify(labResultEntry).setEcgAbnormalitiesDB(eq("Ecg Abnormalities DB"));
		verify(labResultEntry).setFileIDs(Mockito.<String[]>any());
		verify(labResultEntry).setID(Mockito.<Long>any());
		verify(labResultEntry).setLabCompleted(Mockito.<Boolean>any());
		verify(labResultEntry).setLastModDate(Mockito.<Timestamp>any());
		verify(labResultEntry).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(labResultEntry, atLeast(1)).setParkingPlaceID(Mockito.<Integer>any());
		verify(labResultEntry).setPrescriptionID(Mockito.<Long>any());
		verify(labResultEntry).setProcedureData(Mockito.<ProcedureData>any());
		verify(labResultEntry).setProcedureID(Mockito.<Integer>any());
		verify(labResultEntry).setProcedureName(eq("Procedure Name"));
		verify(labResultEntry).setProcedureType(eq("Procedure Type"));
		verify(labResultEntry).setProcessed(eq("Processed"));
		verify(labResultEntry, atLeast(1)).setProviderServiceMapID(Mockito.<Integer>any());
		verify(labResultEntry).setRemarks(eq("Remarks"));
		verify(labResultEntry).setReservedForChange(eq("Reserved For Change"));
		verify(labResultEntry).setStripsNotAvailable(Mockito.<Boolean>any());
		verify(labResultEntry).setSyncedBy(eq("Synced By"));
		verify(labResultEntry).setSyncedDate(Mockito.<Timestamp>any());
		verify(labResultEntry).setTestComponentID(Mockito.<Integer>any());
		verify(labResultEntry).setTestComponentMaster(Mockito.<TestComponentMaster>any());
		verify(labResultEntry, atLeast(1)).setTestReportFilePath(Mockito.<String>any());
		verify(labResultEntry).setTestResultUnit(eq("Test Result Unit"));
		verify(labResultEntry).setTestResultValue(eq("42"));
		verify(labResultEntry, atLeast(1)).setVanID(Mockito.<Integer>any());
		verify(labResultEntry).setVanSerialNo(Mockito.<Long>any());
		verify(labResultEntry).setVehicalNo(eq("Vehical No"));
		verify(labResultEntry, atLeast(1)).setVisitCode(Mockito.<Long>any());
		verify(wrapperLabResults).getBeneficiaryRegID();
		verify(wrapperLabResults).getCreatedBy();
		verify(wrapperLabResults).getLabTestResults();
		verify(wrapperLabResults).getParkingPlaceID();
		verify(wrapperLabResults).getProviderServiceMapID();
		verify(wrapperLabResults, atLeast(1)).getRadiologyTestResults();
		verify(wrapperLabResults).getVanID();
		verify(wrapperLabResults).getVisitCode();
		verify(wrapperLabResults).getVisitID();
		verify(wrapperLabResults).setBenFlowID(Mockito.<Long>any());
		verify(wrapperLabResults).setBeneficiaryRegID(Mockito.<Long>any());
		verify(wrapperLabResults).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(wrapperLabResults).setDoctorFlag(Mockito.<Short>any());
		verify(wrapperLabResults).setLabCompleted(Mockito.<Boolean>any());
		verify(wrapperLabResults).setLabTestResults(Mockito.<List<LabResultEntry>>any());
		verify(wrapperLabResults).setNurseFlag(Mockito.<Short>any());
		verify(wrapperLabResults).setParkingPlaceID(Mockito.<Integer>any());
		verify(wrapperLabResults).setProviderServiceMapID(Mockito.<Integer>any());
		verify(wrapperLabResults).setRadiologyTestResults(Mockito.<List<LabResultEntry>>any());
		verify(wrapperLabResults).setSpecialist_flag(Mockito.<Short>any());
		verify(wrapperLabResults).setVanID(Mockito.<Integer>any());
		verify(wrapperLabResults).setVisitCode(Mockito.<Long>any());
		verify(wrapperLabResults).setVisitID(Mockito.<Long>any());
		verify(labResultEntryRepo).saveAll(Mockito.<Iterable<LabResultEntry>>any());
		assertNull(actualSaveLabTestResultResult);
	}

	@Test
	void testSaveLabTestResult10() {
		// Arrange
		when(labResultEntryRepo.saveAll(Mockito.<Iterable<LabResultEntry>>any())).thenReturn(new ArrayList<>());

		ProcedureData procedureData = new ProcedureData();
		procedureData.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		procedureData.setCreatedDate(mock(Timestamp.class));
		procedureData.setDeleted(true);
		procedureData.setGender("Gender");
		procedureData.setLabResultEntry(new HashSet<>());
		procedureData.setLastModDate(mock(Timestamp.class));
		procedureData.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		procedureData.setProcedureDesc("Procedure Desc");
		procedureData.setProcedureID(1);
		procedureData.setProcedureName("Procedure Name");
		procedureData.setProcedureType("Procedure Type");
		procedureData.setProcessed("Processed");
		procedureData.setProviderServiceMapID(1);

		TestComponentMaster testComponentMaster = new TestComponentMaster();
		testComponentMaster.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		testComponentMaster.setCreatedDate(mock(Timestamp.class));
		testComponentMaster.setDeleted(true);
		testComponentMaster.setInputType("Input Type");
		testComponentMaster.setLabResultEntry(new HashSet<>());
		testComponentMaster.setLastModDate(mock(Timestamp.class));
		testComponentMaster.setLionicNum("Lionic Num");
		testComponentMaster.setLionicTerm("Lionic Term");
		testComponentMaster.setMeasurementUnit("Measurement Unit");
		testComponentMaster.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		testComponentMaster.setProcessed("Processed");
		testComponentMaster.setProviderServiceMapID(1);
		testComponentMaster.setRange_max(3);
		testComponentMaster.setRange_min(1);
		testComponentMaster.setRange_normal_max(3);
		testComponentMaster.setRange_normal_min(1);
		testComponentMaster.setTestComponentDesc("Test Component Desc");
		testComponentMaster.setTestComponentID(1);
		testComponentMaster.setTestComponentName("Test Component Name");
		LabResultEntry labResultEntry = mock(LabResultEntry.class);
		when(labResultEntry.getFileIDs()).thenReturn(null);
		doNothing().when(labResultEntry).setBenVisitID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setCompList(Mockito.<List<Map<String, Object>>>any());
		doNothing().when(labResultEntry).setComponentList(Mockito.<ArrayList<Map<String, Object>>>any());
		doNothing().when(labResultEntry).setCreatedBy(Mockito.<String>any());
		doNothing().when(labResultEntry).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(labResultEntry).setDate(Mockito.<Date>any());
		doNothing().when(labResultEntry).setDeleted(Mockito.<Boolean>any());
		doNothing().when(labResultEntry).setEcgAbnormalities(Mockito.<String[]>any());
		doNothing().when(labResultEntry).setEcgAbnormalitiesDB(Mockito.<String>any());
		doNothing().when(labResultEntry).setFileIDs(Mockito.<String[]>any());
		doNothing().when(labResultEntry).setID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setLabCompleted(Mockito.<Boolean>any());
		doNothing().when(labResultEntry).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(labResultEntry).setModifiedBy(Mockito.<String>any());
		doNothing().when(labResultEntry).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setPrescriptionID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setProcedureData(Mockito.<ProcedureData>any());
		doNothing().when(labResultEntry).setProcedureID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setProcedureName(Mockito.<String>any());
		doNothing().when(labResultEntry).setProcedureType(Mockito.<String>any());
		doNothing().when(labResultEntry).setProcessed(Mockito.<String>any());
		doNothing().when(labResultEntry).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setRemarks(Mockito.<String>any());
		doNothing().when(labResultEntry).setReservedForChange(Mockito.<String>any());
		doNothing().when(labResultEntry).setStripsNotAvailable(Mockito.<Boolean>any());
		doNothing().when(labResultEntry).setSyncedBy(Mockito.<String>any());
		doNothing().when(labResultEntry).setSyncedDate(Mockito.<Timestamp>any());
		doNothing().when(labResultEntry).setTestComponentID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setTestComponentMaster(Mockito.<TestComponentMaster>any());
		doNothing().when(labResultEntry).setTestReportFilePath(Mockito.<String>any());
		doNothing().when(labResultEntry).setTestResultUnit(Mockito.<String>any());
		doNothing().when(labResultEntry).setTestResultValue(Mockito.<String>any());
		doNothing().when(labResultEntry).setVanID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setVanSerialNo(Mockito.<Long>any());
		doNothing().when(labResultEntry).setVehicalNo(Mockito.<String>any());
		doNothing().when(labResultEntry).setVisitCode(Mockito.<Long>any());
		labResultEntry.setBenVisitID(1L);
		labResultEntry.setBeneficiaryRegID(1L);
		labResultEntry.setCompList(new ArrayList<>());
		labResultEntry.setComponentList(new ArrayList<>());
		labResultEntry.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		labResultEntry.setCreatedDate(mock(Timestamp.class));
		labResultEntry.setDate(mock(Date.class));
		labResultEntry.setDeleted(true);
		labResultEntry.setEcgAbnormalities(new String[] { "Ecg Abnormalities" });
		labResultEntry.setEcgAbnormalitiesDB("Ecg Abnormalities DB");
		labResultEntry.setFileIDs(new String[] { "File IDs" });
		labResultEntry.setID(1L);
		labResultEntry.setLabCompleted(true);
		labResultEntry.setLastModDate(mock(Timestamp.class));
		labResultEntry.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		labResultEntry.setParkingPlaceID(1);
		labResultEntry.setPrescriptionID(1L);
		labResultEntry.setProcedureData(procedureData);
		labResultEntry.setProcedureID(1);
		labResultEntry.setProcedureName("Procedure Name");
		labResultEntry.setProcedureType("Procedure Type");
		labResultEntry.setProcessed("Processed");
		labResultEntry.setProviderServiceMapID(1);
		labResultEntry.setRemarks("Remarks");
		labResultEntry.setReservedForChange("Reserved For Change");
		labResultEntry.setStripsNotAvailable(true);
		labResultEntry.setSyncedBy("Synced By");
		labResultEntry.setSyncedDate(mock(Timestamp.class));
		labResultEntry.setTestComponentID(1);
		labResultEntry.setTestComponentMaster(testComponentMaster);
		labResultEntry.setTestReportFilePath("/directory/foo.txt");
		labResultEntry.setTestResultUnit("Test Result Unit");
		labResultEntry.setTestResultValue("42");
		labResultEntry.setVanID(1);
		labResultEntry.setVanSerialNo(1L);
		labResultEntry.setVehicalNo("Vehical No");
		labResultEntry.setVisitCode(1L);

		ArrayList<LabResultEntry> labResultEntryList = new ArrayList<>();
		labResultEntryList.add(labResultEntry);
		WrapperLabResultEntry wrapperLabResults = mock(WrapperLabResultEntry.class);
		when(wrapperLabResults.getParkingPlaceID()).thenReturn(1);
		when(wrapperLabResults.getProviderServiceMapID()).thenReturn(1);
		when(wrapperLabResults.getVanID()).thenReturn(1);
		when(wrapperLabResults.getBeneficiaryRegID()).thenReturn(1L);
		when(wrapperLabResults.getVisitCode()).thenReturn(1L);
		when(wrapperLabResults.getVisitID()).thenReturn(1L);
		when(wrapperLabResults.getCreatedBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
		when(wrapperLabResults.getLabTestResults()).thenReturn(new ArrayList<>());
		when(wrapperLabResults.getRadiologyTestResults()).thenReturn(labResultEntryList);
		doNothing().when(wrapperLabResults).setBenFlowID(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setCreatedBy(Mockito.<String>any());
		doNothing().when(wrapperLabResults).setDoctorFlag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setLabCompleted(Mockito.<Boolean>any());
		doNothing().when(wrapperLabResults).setLabTestResults(Mockito.<List<LabResultEntry>>any());
		doNothing().when(wrapperLabResults).setNurseFlag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setRadiologyTestResults(Mockito.<List<LabResultEntry>>any());
		doNothing().when(wrapperLabResults).setSpecialist_flag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setVanID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setVisitCode(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setVisitID(Mockito.<Long>any());
		wrapperLabResults.setBenFlowID(1L);
		wrapperLabResults.setBeneficiaryRegID(1L);
		wrapperLabResults.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperLabResults.setDoctorFlag((short) 1);
		wrapperLabResults.setLabCompleted(true);
		wrapperLabResults.setLabTestResults(new ArrayList<>());
		wrapperLabResults.setNurseFlag((short) 1);
		wrapperLabResults.setParkingPlaceID(1);
		wrapperLabResults.setProviderServiceMapID(1);
		wrapperLabResults.setRadiologyTestResults(new ArrayList<>());
		wrapperLabResults.setSpecialist_flag((short) 1);
		wrapperLabResults.setVanID(1);
		wrapperLabResults.setVisitCode(1L);
		wrapperLabResults.setVisitID(1L);

		// Act
		Integer actualSaveLabTestResultResult = labTechnicianServiceImpl.saveLabTestResult(wrapperLabResults);

		// Assert
		verify(labResultEntry).getFileIDs();
		verify(labResultEntry, atLeast(1)).setBenVisitID(Mockito.<Long>any());
		verify(labResultEntry, atLeast(1)).setBeneficiaryRegID(Mockito.<Long>any());
		verify(labResultEntry).setCompList(Mockito.<List<Map<String, Object>>>any());
		verify(labResultEntry).setComponentList(Mockito.<ArrayList<Map<String, Object>>>any());
		verify(labResultEntry, atLeast(1)).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(labResultEntry).setCreatedDate(Mockito.<Timestamp>any());
		verify(labResultEntry).setDate(Mockito.<Date>any());
		verify(labResultEntry).setDeleted(Mockito.<Boolean>any());
		verify(labResultEntry).setEcgAbnormalities(Mockito.<String[]>any());
		verify(labResultEntry).setEcgAbnormalitiesDB(eq("Ecg Abnormalities DB"));
		verify(labResultEntry).setFileIDs(Mockito.<String[]>any());
		verify(labResultEntry).setID(Mockito.<Long>any());
		verify(labResultEntry).setLabCompleted(Mockito.<Boolean>any());
		verify(labResultEntry).setLastModDate(Mockito.<Timestamp>any());
		verify(labResultEntry).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(labResultEntry, atLeast(1)).setParkingPlaceID(Mockito.<Integer>any());
		verify(labResultEntry).setPrescriptionID(Mockito.<Long>any());
		verify(labResultEntry).setProcedureData(Mockito.<ProcedureData>any());
		verify(labResultEntry).setProcedureID(Mockito.<Integer>any());
		verify(labResultEntry).setProcedureName(eq("Procedure Name"));
		verify(labResultEntry).setProcedureType(eq("Procedure Type"));
		verify(labResultEntry).setProcessed(eq("Processed"));
		verify(labResultEntry, atLeast(1)).setProviderServiceMapID(Mockito.<Integer>any());
		verify(labResultEntry).setRemarks(eq("Remarks"));
		verify(labResultEntry).setReservedForChange(eq("Reserved For Change"));
		verify(labResultEntry).setStripsNotAvailable(Mockito.<Boolean>any());
		verify(labResultEntry).setSyncedBy(eq("Synced By"));
		verify(labResultEntry).setSyncedDate(Mockito.<Timestamp>any());
		verify(labResultEntry).setTestComponentID(Mockito.<Integer>any());
		verify(labResultEntry).setTestComponentMaster(Mockito.<TestComponentMaster>any());
		verify(labResultEntry, atLeast(1)).setTestReportFilePath(Mockito.<String>any());
		verify(labResultEntry).setTestResultUnit(eq("Test Result Unit"));
		verify(labResultEntry).setTestResultValue(eq("42"));
		verify(labResultEntry, atLeast(1)).setVanID(Mockito.<Integer>any());
		verify(labResultEntry).setVanSerialNo(Mockito.<Long>any());
		verify(labResultEntry).setVehicalNo(eq("Vehical No"));
		verify(labResultEntry, atLeast(1)).setVisitCode(Mockito.<Long>any());
		verify(wrapperLabResults).getBeneficiaryRegID();
		verify(wrapperLabResults).getCreatedBy();
		verify(wrapperLabResults).getLabTestResults();
		verify(wrapperLabResults).getParkingPlaceID();
		verify(wrapperLabResults).getProviderServiceMapID();
		verify(wrapperLabResults, atLeast(1)).getRadiologyTestResults();
		verify(wrapperLabResults).getVanID();
		verify(wrapperLabResults).getVisitCode();
		verify(wrapperLabResults).getVisitID();
		verify(wrapperLabResults).setBenFlowID(Mockito.<Long>any());
		verify(wrapperLabResults).setBeneficiaryRegID(Mockito.<Long>any());
		verify(wrapperLabResults).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(wrapperLabResults).setDoctorFlag(Mockito.<Short>any());
		verify(wrapperLabResults).setLabCompleted(Mockito.<Boolean>any());
		verify(wrapperLabResults).setLabTestResults(Mockito.<List<LabResultEntry>>any());
		verify(wrapperLabResults).setNurseFlag(Mockito.<Short>any());
		verify(wrapperLabResults).setParkingPlaceID(Mockito.<Integer>any());
		verify(wrapperLabResults).setProviderServiceMapID(Mockito.<Integer>any());
		verify(wrapperLabResults).setRadiologyTestResults(Mockito.<List<LabResultEntry>>any());
		verify(wrapperLabResults).setSpecialist_flag(Mockito.<Short>any());
		verify(wrapperLabResults).setVanID(Mockito.<Integer>any());
		verify(wrapperLabResults).setVisitCode(Mockito.<Long>any());
		verify(wrapperLabResults).setVisitID(Mockito.<Long>any());
		verify(labResultEntryRepo).saveAll(Mockito.<Iterable<LabResultEntry>>any());
		assertNull(actualSaveLabTestResultResult);
	}

	@Test
	void testSaveLabTestResult11() {
		// Arrange
		when(labResultEntryRepo.saveAll(Mockito.<Iterable<LabResultEntry>>any())).thenReturn(new ArrayList<>());

		ProcedureData procedureData = new ProcedureData();
		procedureData.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		procedureData.setCreatedDate(mock(Timestamp.class));
		procedureData.setDeleted(true);
		procedureData.setGender("Gender");
		procedureData.setLabResultEntry(new HashSet<>());
		procedureData.setLastModDate(mock(Timestamp.class));
		procedureData.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		procedureData.setProcedureDesc("Procedure Desc");
		procedureData.setProcedureID(1);
		procedureData.setProcedureName("Procedure Name");
		procedureData.setProcedureType("Procedure Type");
		procedureData.setProcessed("Processed");
		procedureData.setProviderServiceMapID(1);

		TestComponentMaster testComponentMaster = new TestComponentMaster();
		testComponentMaster.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		testComponentMaster.setCreatedDate(mock(Timestamp.class));
		testComponentMaster.setDeleted(true);
		testComponentMaster.setInputType("Input Type");
		testComponentMaster.setLabResultEntry(new HashSet<>());
		testComponentMaster.setLastModDate(mock(Timestamp.class));
		testComponentMaster.setLionicNum("Lionic Num");
		testComponentMaster.setLionicTerm("Lionic Term");
		testComponentMaster.setMeasurementUnit("Measurement Unit");
		testComponentMaster.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		testComponentMaster.setProcessed("Processed");
		testComponentMaster.setProviderServiceMapID(1);
		testComponentMaster.setRange_max(3);
		testComponentMaster.setRange_min(1);
		testComponentMaster.setRange_normal_max(3);
		testComponentMaster.setRange_normal_min(1);
		testComponentMaster.setTestComponentDesc("Test Component Desc");
		testComponentMaster.setTestComponentID(1);
		testComponentMaster.setTestComponentName("Test Component Name");
		LabResultEntry labResultEntry = mock(LabResultEntry.class);
		when(labResultEntry.getFileIDs()).thenReturn(new String[] {});
		doNothing().when(labResultEntry).setBenVisitID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setCompList(Mockito.<List<Map<String, Object>>>any());
		doNothing().when(labResultEntry).setComponentList(Mockito.<ArrayList<Map<String, Object>>>any());
		doNothing().when(labResultEntry).setCreatedBy(Mockito.<String>any());
		doNothing().when(labResultEntry).setCreatedDate(Mockito.<Timestamp>any());
		doNothing().when(labResultEntry).setDate(Mockito.<Date>any());
		doNothing().when(labResultEntry).setDeleted(Mockito.<Boolean>any());
		doNothing().when(labResultEntry).setEcgAbnormalities(Mockito.<String[]>any());
		doNothing().when(labResultEntry).setEcgAbnormalitiesDB(Mockito.<String>any());
		doNothing().when(labResultEntry).setFileIDs(Mockito.<String[]>any());
		doNothing().when(labResultEntry).setID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setLabCompleted(Mockito.<Boolean>any());
		doNothing().when(labResultEntry).setLastModDate(Mockito.<Timestamp>any());
		doNothing().when(labResultEntry).setModifiedBy(Mockito.<String>any());
		doNothing().when(labResultEntry).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setPrescriptionID(Mockito.<Long>any());
		doNothing().when(labResultEntry).setProcedureData(Mockito.<ProcedureData>any());
		doNothing().when(labResultEntry).setProcedureID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setProcedureName(Mockito.<String>any());
		doNothing().when(labResultEntry).setProcedureType(Mockito.<String>any());
		doNothing().when(labResultEntry).setProcessed(Mockito.<String>any());
		doNothing().when(labResultEntry).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setRemarks(Mockito.<String>any());
		doNothing().when(labResultEntry).setReservedForChange(Mockito.<String>any());
		doNothing().when(labResultEntry).setStripsNotAvailable(Mockito.<Boolean>any());
		doNothing().when(labResultEntry).setSyncedBy(Mockito.<String>any());
		doNothing().when(labResultEntry).setSyncedDate(Mockito.<Timestamp>any());
		doNothing().when(labResultEntry).setTestComponentID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setTestComponentMaster(Mockito.<TestComponentMaster>any());
		doNothing().when(labResultEntry).setTestReportFilePath(Mockito.<String>any());
		doNothing().when(labResultEntry).setTestResultUnit(Mockito.<String>any());
		doNothing().when(labResultEntry).setTestResultValue(Mockito.<String>any());
		doNothing().when(labResultEntry).setVanID(Mockito.<Integer>any());
		doNothing().when(labResultEntry).setVanSerialNo(Mockito.<Long>any());
		doNothing().when(labResultEntry).setVehicalNo(Mockito.<String>any());
		doNothing().when(labResultEntry).setVisitCode(Mockito.<Long>any());
		labResultEntry.setBenVisitID(1L);
		labResultEntry.setBeneficiaryRegID(1L);
		labResultEntry.setCompList(new ArrayList<>());
		labResultEntry.setComponentList(new ArrayList<>());
		labResultEntry.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		labResultEntry.setCreatedDate(mock(Timestamp.class));
		labResultEntry.setDate(mock(Date.class));
		labResultEntry.setDeleted(true);
		labResultEntry.setEcgAbnormalities(new String[] { "Ecg Abnormalities" });
		labResultEntry.setEcgAbnormalitiesDB("Ecg Abnormalities DB");
		labResultEntry.setFileIDs(new String[] { "File IDs" });
		labResultEntry.setID(1L);
		labResultEntry.setLabCompleted(true);
		labResultEntry.setLastModDate(mock(Timestamp.class));
		labResultEntry.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		labResultEntry.setParkingPlaceID(1);
		labResultEntry.setPrescriptionID(1L);
		labResultEntry.setProcedureData(procedureData);
		labResultEntry.setProcedureID(1);
		labResultEntry.setProcedureName("Procedure Name");
		labResultEntry.setProcedureType("Procedure Type");
		labResultEntry.setProcessed("Processed");
		labResultEntry.setProviderServiceMapID(1);
		labResultEntry.setRemarks("Remarks");
		labResultEntry.setReservedForChange("Reserved For Change");
		labResultEntry.setStripsNotAvailable(true);
		labResultEntry.setSyncedBy("Synced By");
		labResultEntry.setSyncedDate(mock(Timestamp.class));
		labResultEntry.setTestComponentID(1);
		labResultEntry.setTestComponentMaster(testComponentMaster);
		labResultEntry.setTestReportFilePath("/directory/foo.txt");
		labResultEntry.setTestResultUnit("Test Result Unit");
		labResultEntry.setTestResultValue("42");
		labResultEntry.setVanID(1);
		labResultEntry.setVanSerialNo(1L);
		labResultEntry.setVehicalNo("Vehical No");
		labResultEntry.setVisitCode(1L);

		ArrayList<LabResultEntry> labResultEntryList = new ArrayList<>();
		labResultEntryList.add(labResultEntry);
		WrapperLabResultEntry wrapperLabResults = mock(WrapperLabResultEntry.class);
		when(wrapperLabResults.getParkingPlaceID()).thenReturn(1);
		when(wrapperLabResults.getProviderServiceMapID()).thenReturn(1);
		when(wrapperLabResults.getVanID()).thenReturn(1);
		when(wrapperLabResults.getBeneficiaryRegID()).thenReturn(1L);
		when(wrapperLabResults.getVisitCode()).thenReturn(1L);
		when(wrapperLabResults.getVisitID()).thenReturn(1L);
		when(wrapperLabResults.getCreatedBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
		when(wrapperLabResults.getLabTestResults()).thenReturn(new ArrayList<>());
		when(wrapperLabResults.getRadiologyTestResults()).thenReturn(labResultEntryList);
		doNothing().when(wrapperLabResults).setBenFlowID(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setBeneficiaryRegID(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setCreatedBy(Mockito.<String>any());
		doNothing().when(wrapperLabResults).setDoctorFlag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setLabCompleted(Mockito.<Boolean>any());
		doNothing().when(wrapperLabResults).setLabTestResults(Mockito.<List<LabResultEntry>>any());
		doNothing().when(wrapperLabResults).setNurseFlag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setParkingPlaceID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setProviderServiceMapID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setRadiologyTestResults(Mockito.<List<LabResultEntry>>any());
		doNothing().when(wrapperLabResults).setSpecialist_flag(Mockito.<Short>any());
		doNothing().when(wrapperLabResults).setVanID(Mockito.<Integer>any());
		doNothing().when(wrapperLabResults).setVisitCode(Mockito.<Long>any());
		doNothing().when(wrapperLabResults).setVisitID(Mockito.<Long>any());
		wrapperLabResults.setBenFlowID(1L);
		wrapperLabResults.setBeneficiaryRegID(1L);
		wrapperLabResults.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		wrapperLabResults.setDoctorFlag((short) 1);
		wrapperLabResults.setLabCompleted(true);
		wrapperLabResults.setLabTestResults(new ArrayList<>());
		wrapperLabResults.setNurseFlag((short) 1);
		wrapperLabResults.setParkingPlaceID(1);
		wrapperLabResults.setProviderServiceMapID(1);
		wrapperLabResults.setRadiologyTestResults(new ArrayList<>());
		wrapperLabResults.setSpecialist_flag((short) 1);
		wrapperLabResults.setVanID(1);
		wrapperLabResults.setVisitCode(1L);
		wrapperLabResults.setVisitID(1L);

		// Act
		Integer actualSaveLabTestResultResult = labTechnicianServiceImpl.saveLabTestResult(wrapperLabResults);

		// Assert
		verify(labResultEntry).getFileIDs();
		verify(labResultEntry, atLeast(1)).setBenVisitID(Mockito.<Long>any());
		verify(labResultEntry, atLeast(1)).setBeneficiaryRegID(Mockito.<Long>any());
		verify(labResultEntry).setCompList(Mockito.<List<Map<String, Object>>>any());
		verify(labResultEntry).setComponentList(Mockito.<ArrayList<Map<String, Object>>>any());
		verify(labResultEntry, atLeast(1)).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(labResultEntry).setCreatedDate(Mockito.<Timestamp>any());
		verify(labResultEntry).setDate(Mockito.<Date>any());
		verify(labResultEntry).setDeleted(Mockito.<Boolean>any());
		verify(labResultEntry).setEcgAbnormalities(Mockito.<String[]>any());
		verify(labResultEntry).setEcgAbnormalitiesDB(eq("Ecg Abnormalities DB"));
		verify(labResultEntry).setFileIDs(Mockito.<String[]>any());
		verify(labResultEntry).setID(Mockito.<Long>any());
		verify(labResultEntry).setLabCompleted(Mockito.<Boolean>any());
		verify(labResultEntry).setLastModDate(Mockito.<Timestamp>any());
		verify(labResultEntry).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
		verify(labResultEntry, atLeast(1)).setParkingPlaceID(Mockito.<Integer>any());
		verify(labResultEntry).setPrescriptionID(Mockito.<Long>any());
		verify(labResultEntry).setProcedureData(Mockito.<ProcedureData>any());
		verify(labResultEntry).setProcedureID(Mockito.<Integer>any());
		verify(labResultEntry).setProcedureName(eq("Procedure Name"));
		verify(labResultEntry).setProcedureType(eq("Procedure Type"));
		verify(labResultEntry).setProcessed(eq("Processed"));
		verify(labResultEntry, atLeast(1)).setProviderServiceMapID(Mockito.<Integer>any());
		verify(labResultEntry).setRemarks(eq("Remarks"));
		verify(labResultEntry).setReservedForChange(eq("Reserved For Change"));
		verify(labResultEntry).setStripsNotAvailable(Mockito.<Boolean>any());
		verify(labResultEntry).setSyncedBy(eq("Synced By"));
		verify(labResultEntry).setSyncedDate(Mockito.<Timestamp>any());
		verify(labResultEntry).setTestComponentID(Mockito.<Integer>any());
		verify(labResultEntry).setTestComponentMaster(Mockito.<TestComponentMaster>any());
		verify(labResultEntry, atLeast(1)).setTestReportFilePath(Mockito.<String>any());
		verify(labResultEntry).setTestResultUnit(eq("Test Result Unit"));
		verify(labResultEntry).setTestResultValue(eq("42"));
		verify(labResultEntry, atLeast(1)).setVanID(Mockito.<Integer>any());
		verify(labResultEntry).setVanSerialNo(Mockito.<Long>any());
		verify(labResultEntry).setVehicalNo(eq("Vehical No"));
		verify(labResultEntry, atLeast(1)).setVisitCode(Mockito.<Long>any());
		verify(wrapperLabResults).getBeneficiaryRegID();
		verify(wrapperLabResults).getCreatedBy();
		verify(wrapperLabResults).getLabTestResults();
		verify(wrapperLabResults).getParkingPlaceID();
		verify(wrapperLabResults).getProviderServiceMapID();
		verify(wrapperLabResults, atLeast(1)).getRadiologyTestResults();
		verify(wrapperLabResults).getVanID();
		verify(wrapperLabResults).getVisitCode();
		verify(wrapperLabResults).getVisitID();
		verify(wrapperLabResults).setBenFlowID(Mockito.<Long>any());
		verify(wrapperLabResults).setBeneficiaryRegID(Mockito.<Long>any());
		verify(wrapperLabResults).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
		verify(wrapperLabResults).setDoctorFlag(Mockito.<Short>any());
		verify(wrapperLabResults).setLabCompleted(Mockito.<Boolean>any());
		verify(wrapperLabResults).setLabTestResults(Mockito.<List<LabResultEntry>>any());
		verify(wrapperLabResults).setNurseFlag(Mockito.<Short>any());
		verify(wrapperLabResults).setParkingPlaceID(Mockito.<Integer>any());
		verify(wrapperLabResults).setProviderServiceMapID(Mockito.<Integer>any());
		verify(wrapperLabResults).setRadiologyTestResults(Mockito.<List<LabResultEntry>>any());
		verify(wrapperLabResults).setSpecialist_flag(Mockito.<Short>any());
		verify(wrapperLabResults).setVanID(Mockito.<Integer>any());
		verify(wrapperLabResults).setVisitCode(Mockito.<Long>any());
		verify(wrapperLabResults).setVisitID(Mockito.<Long>any());
		verify(labResultEntryRepo).saveAll(Mockito.<Iterable<LabResultEntry>>any());
		assertNull(actualSaveLabTestResultResult);
	}

	@Test
	void testGetLast_3_ArchivedTestVisitList() {
		// Arrange
		when(labResultEntryRepo.getLast_3_visitForLabTestDone(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn(new ArrayList<>());

		// Act
		String actualLast_3_ArchivedTestVisitList = labTechnicianServiceImpl.getLast_3_ArchivedTestVisitList(1L, 1L);

		// Assert
		verify(labResultEntryRepo).getLast_3_visitForLabTestDone(Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("[]", actualLast_3_ArchivedTestVisitList);
	}

	@Test
	void testGetLabResultForVisitcode() throws Exception {
		// Arrange
		when(labResultEntryRepo.findByBeneficiaryRegIDAndVisitCodeOrderByProcedureIDAsc(Mockito.<Long>any(),
				Mockito.<Long>any())).thenReturn(new ArrayList<>());

		// Act
		String actualLabResultForVisitcode = labTechnicianServiceImpl.getLabResultForVisitcode(1L, 1L);

		// Assert
		verify(labResultEntryRepo).findByBeneficiaryRegIDAndVisitCodeOrderByProcedureIDAsc(Mockito.<Long>any(),
				Mockito.<Long>any());
		assertEquals("[]", actualLabResultForVisitcode);
	}

	@Test
	void testGettersAndSetters() {

		// Arrange
		LabTechnicianServiceImpl labTechnicianServiceImpl = new LabTechnicianServiceImpl();

		// Act
		labTechnicianServiceImpl.setCommonBenStatusFlowServiceImpl(new CommonBenStatusFlowServiceImpl());
		labTechnicianServiceImpl.setLabResultEntryRepo(mock(LabResultEntryRepo.class));
		labTechnicianServiceImpl.setV_benLabTestOrderedDetailsRepo(mock(V_benLabTestOrderedDetailsRepo.class));
	}
}
