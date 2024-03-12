package com.iemr.mmu.service.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.ANCDiagnosis;
import com.iemr.mmu.repo.nurse.anc.ANCDiagnosisRepo;
import com.iemr.mmu.repo.quickConsultation.PrescriptionDetailRepo;
import com.iemr.mmu.utils.exception.IEMRException;


@ExtendWith(MockitoExtension.class)
class ANCDoctorServiceImplTest {
    @Mock
    private ANCDiagnosisRepo aNCDiagnosisRepo;

    @InjectMocks
    private ANCDoctorServiceImpl aNCDoctorServiceImpl;

    @Mock
    private PrescriptionDetailRepo prescriptionDetailRepo;

    @Test
    void testSaveBenANCDiagnosis() throws IEMRException {
        // Arrange
        ANCDiagnosis ancDiagnosis = new ANCDiagnosis();
        ancDiagnosis.setBenVisitID(1L);
        ancDiagnosis.setBeneficiaryRegID(1L);
        ancDiagnosis.setCauseOfDeath("Cause Of Death");
        ancDiagnosis.setComplicationOfCurrentPregnancy("Complication Of Current Pregnancy");
        ancDiagnosis.setComplicationOfCurrentPregnancyList(new ArrayList<>());
        ancDiagnosis.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        ancDiagnosis.setCreatedDate(mock(Timestamp.class));
        ancDiagnosis.setDateOfDeath(mock(Date.class));
        ancDiagnosis.setDeleted(true);
        ancDiagnosis.setExternalInvestigation("External Investigation");
        ancDiagnosis.setHighRiskCondition("High Risk Condition");
        ancDiagnosis.setHighRiskStatus("High Risk Status");
        ancDiagnosis.setID(1L);
        ancDiagnosis.setIsMaternalDeath(true);
        ancDiagnosis.setLastModDate(mock(Timestamp.class));
        ancDiagnosis.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        ancDiagnosis.setOtherCurrPregComplication("Other Curr Preg Complication");
        ancDiagnosis.setParkingPlaceID(1);
        ancDiagnosis.setPlaceOfDeath("Place Of Death");
        ancDiagnosis.setPrescriptionID(1L);
        ancDiagnosis.setProcessed("Processed");
        ancDiagnosis.setProviderServiceMapID(1);
        ancDiagnosis.setReservedForChange("Reserved For Change");
        ancDiagnosis.setSyncedBy("Synced By");
        ancDiagnosis.setSyncedDate(mock(Timestamp.class));
        ancDiagnosis.setVanID(1);
        ancDiagnosis.setVanSerialNo(1L);
        ancDiagnosis.setVehicalNo("Vehical No");
        ancDiagnosis.setVisitCode(1L);
        when(aNCDiagnosisRepo.save(Mockito.<ANCDiagnosis>any())).thenReturn(ancDiagnosis);

        // Act
        Long actualSaveBenANCDiagnosisResult = aNCDoctorServiceImpl.saveBenANCDiagnosis(new JsonObject(), 1L);

        // Assert
        verify(aNCDiagnosisRepo).save(Mockito.<ANCDiagnosis>any());
        assertEquals(1L, actualSaveBenANCDiagnosisResult.longValue());
    }

  
    @Test
    void testSaveBenANCDiagnosis2() throws IEMRException {
        // Arrange
        ANCDiagnosis ancDiagnosis = mock(ANCDiagnosis.class);
        when(ancDiagnosis.getID()).thenReturn(-1L);
        doNothing().when(ancDiagnosis).setBenVisitID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setBeneficiaryRegID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setCauseOfDeath(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setComplicationOfCurrentPregnancy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setComplicationOfCurrentPregnancyList(Mockito.<ArrayList<Map<String, String>>>any());
        doNothing().when(ancDiagnosis).setCreatedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setCreatedDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setDateOfDeath(Mockito.<Date>any());
        doNothing().when(ancDiagnosis).setDeleted(Mockito.<Boolean>any());
        doNothing().when(ancDiagnosis).setExternalInvestigation(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setHighRiskCondition(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setHighRiskStatus(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setIsMaternalDeath(Mockito.<Boolean>any());
        doNothing().when(ancDiagnosis).setLastModDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setModifiedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setOtherCurrPregComplication(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setParkingPlaceID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setPlaceOfDeath(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setPrescriptionID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setProcessed(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setProviderServiceMapID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setReservedForChange(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setSyncedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setSyncedDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setVanID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setVanSerialNo(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setVehicalNo(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setVisitCode(Mockito.<Long>any());
        ancDiagnosis.setBenVisitID(1L);
        ancDiagnosis.setBeneficiaryRegID(1L);
        ancDiagnosis.setCauseOfDeath("Cause Of Death");
        ancDiagnosis.setComplicationOfCurrentPregnancy("Complication Of Current Pregnancy");
        ancDiagnosis.setComplicationOfCurrentPregnancyList(new ArrayList<>());
        ancDiagnosis.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        ancDiagnosis.setCreatedDate(mock(Timestamp.class));
        ancDiagnosis.setDateOfDeath(mock(Date.class));
        ancDiagnosis.setDeleted(true);
        ancDiagnosis.setExternalInvestigation("External Investigation");
        ancDiagnosis.setHighRiskCondition("High Risk Condition");
        ancDiagnosis.setHighRiskStatus("High Risk Status");
        ancDiagnosis.setID(1L);
        ancDiagnosis.setIsMaternalDeath(true);
        ancDiagnosis.setLastModDate(mock(Timestamp.class));
        ancDiagnosis.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        ancDiagnosis.setOtherCurrPregComplication("Other Curr Preg Complication");
        ancDiagnosis.setParkingPlaceID(1);
        ancDiagnosis.setPlaceOfDeath("Place Of Death");
        ancDiagnosis.setPrescriptionID(1L);
        ancDiagnosis.setProcessed("Processed");
        ancDiagnosis.setProviderServiceMapID(1);
        ancDiagnosis.setReservedForChange("Reserved For Change");
        ancDiagnosis.setSyncedBy("Synced By");
        ancDiagnosis.setSyncedDate(mock(Timestamp.class));
        ancDiagnosis.setVanID(1);
        ancDiagnosis.setVanSerialNo(1L);
        ancDiagnosis.setVehicalNo("Vehical No");
        ancDiagnosis.setVisitCode(1L);
        when(aNCDiagnosisRepo.save(Mockito.<ANCDiagnosis>any())).thenReturn(ancDiagnosis);

        // Act
        Long actualSaveBenANCDiagnosisResult = aNCDoctorServiceImpl.saveBenANCDiagnosis(new JsonObject(), 1L);

        // Assert
        verify(ancDiagnosis).getID();
        verify(ancDiagnosis).setBenVisitID(Mockito.<Long>any());
        verify(ancDiagnosis).setBeneficiaryRegID(Mockito.<Long>any());
        verify(ancDiagnosis).setCauseOfDeath(eq("Cause Of Death"));
        verify(ancDiagnosis).setComplicationOfCurrentPregnancy(eq("Complication Of Current Pregnancy"));
        verify(ancDiagnosis).setComplicationOfCurrentPregnancyList(Mockito.<ArrayList<Map<String, String>>>any());
        verify(ancDiagnosis).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
        verify(ancDiagnosis).setCreatedDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setDateOfDeath(Mockito.<Date>any());
        verify(ancDiagnosis).setDeleted(Mockito.<Boolean>any());
        verify(ancDiagnosis).setExternalInvestigation(eq("External Investigation"));
        verify(ancDiagnosis).setHighRiskCondition(eq("High Risk Condition"));
        verify(ancDiagnosis).setHighRiskStatus(eq("High Risk Status"));
        verify(ancDiagnosis).setID(Mockito.<Long>any());
        verify(ancDiagnosis).setIsMaternalDeath(Mockito.<Boolean>any());
        verify(ancDiagnosis).setLastModDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
        verify(ancDiagnosis).setOtherCurrPregComplication(eq("Other Curr Preg Complication"));
        verify(ancDiagnosis).setParkingPlaceID(Mockito.<Integer>any());
        verify(ancDiagnosis).setPlaceOfDeath(eq("Place Of Death"));
        verify(ancDiagnosis).setPrescriptionID(Mockito.<Long>any());
        verify(ancDiagnosis).setProcessed(eq("Processed"));
        verify(ancDiagnosis).setProviderServiceMapID(Mockito.<Integer>any());
        verify(ancDiagnosis).setReservedForChange(eq("Reserved For Change"));
        verify(ancDiagnosis).setSyncedBy(eq("Synced By"));
        verify(ancDiagnosis).setSyncedDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setVanID(Mockito.<Integer>any());
        verify(ancDiagnosis).setVanSerialNo(Mockito.<Long>any());
        verify(ancDiagnosis).setVehicalNo(eq("Vehical No"));
        verify(ancDiagnosis).setVisitCode(Mockito.<Long>any());
        verify(aNCDiagnosisRepo).save(Mockito.<ANCDiagnosis>any());
        assertNull(actualSaveBenANCDiagnosisResult);
    }

    
    @Test
    void testSaveBenANCDiagnosis3() throws IEMRException {
        // Arrange
        ANCDiagnosis ancDiagnosis = mock(ANCDiagnosis.class);
        when(ancDiagnosis.getID()).thenReturn(1L);
        doNothing().when(ancDiagnosis).setBenVisitID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setBeneficiaryRegID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setCauseOfDeath(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setComplicationOfCurrentPregnancy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setComplicationOfCurrentPregnancyList(Mockito.<ArrayList<Map<String, String>>>any());
        doNothing().when(ancDiagnosis).setCreatedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setCreatedDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setDateOfDeath(Mockito.<Date>any());
        doNothing().when(ancDiagnosis).setDeleted(Mockito.<Boolean>any());
        doNothing().when(ancDiagnosis).setExternalInvestigation(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setHighRiskCondition(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setHighRiskStatus(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setIsMaternalDeath(Mockito.<Boolean>any());
        doNothing().when(ancDiagnosis).setLastModDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setModifiedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setOtherCurrPregComplication(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setParkingPlaceID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setPlaceOfDeath(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setPrescriptionID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setProcessed(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setProviderServiceMapID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setReservedForChange(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setSyncedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setSyncedDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setVanID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setVanSerialNo(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setVehicalNo(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setVisitCode(Mockito.<Long>any());
        ancDiagnosis.setBenVisitID(1L);
        ancDiagnosis.setBeneficiaryRegID(1L);
        ancDiagnosis.setCauseOfDeath("Cause Of Death");
        ancDiagnosis.setComplicationOfCurrentPregnancy("Complication Of Current Pregnancy");
        ancDiagnosis.setComplicationOfCurrentPregnancyList(new ArrayList<>());
        ancDiagnosis.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        ancDiagnosis.setCreatedDate(mock(Timestamp.class));
        ancDiagnosis.setDateOfDeath(mock(Date.class));
        ancDiagnosis.setDeleted(true);
        ancDiagnosis.setExternalInvestigation("External Investigation");
        ancDiagnosis.setHighRiskCondition("High Risk Condition");
        ancDiagnosis.setHighRiskStatus("High Risk Status");
        ancDiagnosis.setID(1L);
        ancDiagnosis.setIsMaternalDeath(true);
        ancDiagnosis.setLastModDate(mock(Timestamp.class));
        ancDiagnosis.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        ancDiagnosis.setOtherCurrPregComplication("Other Curr Preg Complication");
        ancDiagnosis.setParkingPlaceID(1);
        ancDiagnosis.setPlaceOfDeath("Place Of Death");
        ancDiagnosis.setPrescriptionID(1L);
        ancDiagnosis.setProcessed("Processed");
        ancDiagnosis.setProviderServiceMapID(1);
        ancDiagnosis.setReservedForChange("Reserved For Change");
        ancDiagnosis.setSyncedBy("Synced By");
        ancDiagnosis.setSyncedDate(mock(Timestamp.class));
        ancDiagnosis.setVanID(1);
        ancDiagnosis.setVanSerialNo(1L);
        ancDiagnosis.setVehicalNo("Vehical No");
        ancDiagnosis.setVisitCode(1L);
        when(aNCDiagnosisRepo.save(Mockito.<ANCDiagnosis>any())).thenReturn(ancDiagnosis);

        JsonObject obj = new JsonObject();
        obj.add("Property", new JsonArray(3));

        // Act
        Long actualSaveBenANCDiagnosisResult = aNCDoctorServiceImpl.saveBenANCDiagnosis(obj, 1L);

        // Assert
        verify(ancDiagnosis, atLeast(1)).getID();
        verify(ancDiagnosis).setBenVisitID(Mockito.<Long>any());
        verify(ancDiagnosis).setBeneficiaryRegID(Mockito.<Long>any());
        verify(ancDiagnosis).setCauseOfDeath(eq("Cause Of Death"));
        verify(ancDiagnosis).setComplicationOfCurrentPregnancy(eq("Complication Of Current Pregnancy"));
        verify(ancDiagnosis).setComplicationOfCurrentPregnancyList(Mockito.<ArrayList<Map<String, String>>>any());
        verify(ancDiagnosis).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
        verify(ancDiagnosis).setCreatedDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setDateOfDeath(Mockito.<Date>any());
        verify(ancDiagnosis).setDeleted(Mockito.<Boolean>any());
        verify(ancDiagnosis).setExternalInvestigation(eq("External Investigation"));
        verify(ancDiagnosis).setHighRiskCondition(eq("High Risk Condition"));
        verify(ancDiagnosis).setHighRiskStatus(eq("High Risk Status"));
        verify(ancDiagnosis).setID(Mockito.<Long>any());
        verify(ancDiagnosis).setIsMaternalDeath(Mockito.<Boolean>any());
        verify(ancDiagnosis).setLastModDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
        verify(ancDiagnosis).setOtherCurrPregComplication(eq("Other Curr Preg Complication"));
        verify(ancDiagnosis).setParkingPlaceID(Mockito.<Integer>any());
        verify(ancDiagnosis).setPlaceOfDeath(eq("Place Of Death"));
        verify(ancDiagnosis).setPrescriptionID(Mockito.<Long>any());
        verify(ancDiagnosis).setProcessed(eq("Processed"));
        verify(ancDiagnosis).setProviderServiceMapID(Mockito.<Integer>any());
        verify(ancDiagnosis).setReservedForChange(eq("Reserved For Change"));
        verify(ancDiagnosis).setSyncedBy(eq("Synced By"));
        verify(ancDiagnosis).setSyncedDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setVanID(Mockito.<Integer>any());
        verify(ancDiagnosis).setVanSerialNo(Mockito.<Long>any());
        verify(ancDiagnosis).setVehicalNo(eq("Vehical No"));
        verify(ancDiagnosis).setVisitCode(Mockito.<Long>any());
        verify(aNCDiagnosisRepo).save(Mockito.<ANCDiagnosis>any());
        assertEquals(1L, actualSaveBenANCDiagnosisResult.longValue());
    }

  
    @Test
    void testSaveBenANCDiagnosis4() throws IEMRException {
        // Arrange
        ANCDiagnosis ancDiagnosis = mock(ANCDiagnosis.class);
        when(ancDiagnosis.getID()).thenReturn(1L);
        doNothing().when(ancDiagnosis).setBenVisitID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setBeneficiaryRegID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setCauseOfDeath(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setComplicationOfCurrentPregnancy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setComplicationOfCurrentPregnancyList(Mockito.<ArrayList<Map<String, String>>>any());
        doNothing().when(ancDiagnosis).setCreatedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setCreatedDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setDateOfDeath(Mockito.<Date>any());
        doNothing().when(ancDiagnosis).setDeleted(Mockito.<Boolean>any());
        doNothing().when(ancDiagnosis).setExternalInvestigation(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setHighRiskCondition(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setHighRiskStatus(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setIsMaternalDeath(Mockito.<Boolean>any());
        doNothing().when(ancDiagnosis).setLastModDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setModifiedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setOtherCurrPregComplication(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setParkingPlaceID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setPlaceOfDeath(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setPrescriptionID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setProcessed(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setProviderServiceMapID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setReservedForChange(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setSyncedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setSyncedDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setVanID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setVanSerialNo(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setVehicalNo(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setVisitCode(Mockito.<Long>any());
        ancDiagnosis.setBenVisitID(1L);
        ancDiagnosis.setBeneficiaryRegID(1L);
        ancDiagnosis.setCauseOfDeath("Cause Of Death");
        ancDiagnosis.setComplicationOfCurrentPregnancy("Complication Of Current Pregnancy");
        ancDiagnosis.setComplicationOfCurrentPregnancyList(new ArrayList<>());
        ancDiagnosis.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        ancDiagnosis.setCreatedDate(mock(Timestamp.class));
        ancDiagnosis.setDateOfDeath(mock(Date.class));
        ancDiagnosis.setDeleted(true);
        ancDiagnosis.setExternalInvestigation("External Investigation");
        ancDiagnosis.setHighRiskCondition("High Risk Condition");
        ancDiagnosis.setHighRiskStatus("High Risk Status");
        ancDiagnosis.setID(1L);
        ancDiagnosis.setIsMaternalDeath(true);
        ancDiagnosis.setLastModDate(mock(Timestamp.class));
        ancDiagnosis.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        ancDiagnosis.setOtherCurrPregComplication("Other Curr Preg Complication");
        ancDiagnosis.setParkingPlaceID(1);
        ancDiagnosis.setPlaceOfDeath("Place Of Death");
        ancDiagnosis.setPrescriptionID(1L);
        ancDiagnosis.setProcessed("Processed");
        ancDiagnosis.setProviderServiceMapID(1);
        ancDiagnosis.setReservedForChange("Reserved For Change");
        ancDiagnosis.setSyncedBy("Synced By");
        ancDiagnosis.setSyncedDate(mock(Timestamp.class));
        ancDiagnosis.setVanID(1);
        ancDiagnosis.setVanSerialNo(1L);
        ancDiagnosis.setVehicalNo("Vehical No");
        ancDiagnosis.setVisitCode(1L);
        when(aNCDiagnosisRepo.save(Mockito.<ANCDiagnosis>any())).thenReturn(ancDiagnosis);

        JsonObject obj = new JsonObject();
        obj.addProperty("Property", "42");

        // Act
        Long actualSaveBenANCDiagnosisResult = aNCDoctorServiceImpl.saveBenANCDiagnosis(obj, 1L);

        // Assert
        verify(ancDiagnosis, atLeast(1)).getID();
        verify(ancDiagnosis).setBenVisitID(Mockito.<Long>any());
        verify(ancDiagnosis).setBeneficiaryRegID(Mockito.<Long>any());
        verify(ancDiagnosis).setCauseOfDeath(eq("Cause Of Death"));
        verify(ancDiagnosis).setComplicationOfCurrentPregnancy(eq("Complication Of Current Pregnancy"));
        verify(ancDiagnosis).setComplicationOfCurrentPregnancyList(Mockito.<ArrayList<Map<String, String>>>any());
        verify(ancDiagnosis).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
        verify(ancDiagnosis).setCreatedDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setDateOfDeath(Mockito.<Date>any());
        verify(ancDiagnosis).setDeleted(Mockito.<Boolean>any());
        verify(ancDiagnosis).setExternalInvestigation(eq("External Investigation"));
        verify(ancDiagnosis).setHighRiskCondition(eq("High Risk Condition"));
        verify(ancDiagnosis).setHighRiskStatus(eq("High Risk Status"));
        verify(ancDiagnosis).setID(Mockito.<Long>any());
        verify(ancDiagnosis).setIsMaternalDeath(Mockito.<Boolean>any());
        verify(ancDiagnosis).setLastModDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
        verify(ancDiagnosis).setOtherCurrPregComplication(eq("Other Curr Preg Complication"));
        verify(ancDiagnosis).setParkingPlaceID(Mockito.<Integer>any());
        verify(ancDiagnosis).setPlaceOfDeath(eq("Place Of Death"));
        verify(ancDiagnosis).setPrescriptionID(Mockito.<Long>any());
        verify(ancDiagnosis).setProcessed(eq("Processed"));
        verify(ancDiagnosis).setProviderServiceMapID(Mockito.<Integer>any());
        verify(ancDiagnosis).setReservedForChange(eq("Reserved For Change"));
        verify(ancDiagnosis).setSyncedBy(eq("Synced By"));
        verify(ancDiagnosis).setSyncedDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setVanID(Mockito.<Integer>any());
        verify(ancDiagnosis).setVanSerialNo(Mockito.<Long>any());
        verify(ancDiagnosis).setVehicalNo(eq("Vehical No"));
        verify(ancDiagnosis).setVisitCode(Mockito.<Long>any());
        verify(aNCDiagnosisRepo).save(Mockito.<ANCDiagnosis>any());
        assertEquals(1L, actualSaveBenANCDiagnosisResult.longValue());
    }

    @Test
    void testSaveBenANCDiagnosis5() throws IEMRException {
        // Arrange
        ANCDiagnosis ancDiagnosis = mock(ANCDiagnosis.class);
        when(ancDiagnosis.getID()).thenReturn(1L);
        doNothing().when(ancDiagnosis).setBenVisitID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setBeneficiaryRegID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setCauseOfDeath(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setComplicationOfCurrentPregnancy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setComplicationOfCurrentPregnancyList(Mockito.<ArrayList<Map<String, String>>>any());
        doNothing().when(ancDiagnosis).setCreatedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setCreatedDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setDateOfDeath(Mockito.<Date>any());
        doNothing().when(ancDiagnosis).setDeleted(Mockito.<Boolean>any());
        doNothing().when(ancDiagnosis).setExternalInvestigation(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setHighRiskCondition(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setHighRiskStatus(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setIsMaternalDeath(Mockito.<Boolean>any());
        doNothing().when(ancDiagnosis).setLastModDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setModifiedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setOtherCurrPregComplication(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setParkingPlaceID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setPlaceOfDeath(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setPrescriptionID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setProcessed(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setProviderServiceMapID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setReservedForChange(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setSyncedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setSyncedDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setVanID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setVanSerialNo(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setVehicalNo(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setVisitCode(Mockito.<Long>any());
        ancDiagnosis.setBenVisitID(1L);
        ancDiagnosis.setBeneficiaryRegID(1L);
        ancDiagnosis.setCauseOfDeath("Cause Of Death");
        ancDiagnosis.setComplicationOfCurrentPregnancy("Complication Of Current Pregnancy");
        ancDiagnosis.setComplicationOfCurrentPregnancyList(new ArrayList<>());
        ancDiagnosis.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        ancDiagnosis.setCreatedDate(mock(Timestamp.class));
        ancDiagnosis.setDateOfDeath(mock(Date.class));
        ancDiagnosis.setDeleted(true);
        ancDiagnosis.setExternalInvestigation("External Investigation");
        ancDiagnosis.setHighRiskCondition("High Risk Condition");
        ancDiagnosis.setHighRiskStatus("High Risk Status");
        ancDiagnosis.setID(1L);
        ancDiagnosis.setIsMaternalDeath(true);
        ancDiagnosis.setLastModDate(mock(Timestamp.class));
        ancDiagnosis.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        ancDiagnosis.setOtherCurrPregComplication("Other Curr Preg Complication");
        ancDiagnosis.setParkingPlaceID(1);
        ancDiagnosis.setPlaceOfDeath("Place Of Death");
        ancDiagnosis.setPrescriptionID(1L);
        ancDiagnosis.setProcessed("Processed");
        ancDiagnosis.setProviderServiceMapID(1);
        ancDiagnosis.setReservedForChange("Reserved For Change");
        ancDiagnosis.setSyncedBy("Synced By");
        ancDiagnosis.setSyncedDate(mock(Timestamp.class));
        ancDiagnosis.setVanID(1);
        ancDiagnosis.setVanSerialNo(1L);
        ancDiagnosis.setVehicalNo("Vehical No");
        ancDiagnosis.setVisitCode(1L);
        when(aNCDiagnosisRepo.save(Mockito.<ANCDiagnosis>any())).thenReturn(ancDiagnosis);

        JsonObject obj = new JsonObject();
        obj.addProperty("Property", Integer.valueOf(1));

        // Act
        Long actualSaveBenANCDiagnosisResult = aNCDoctorServiceImpl.saveBenANCDiagnosis(obj, 1L);

        // Assert
        verify(ancDiagnosis, atLeast(1)).getID();
        verify(ancDiagnosis).setBenVisitID(Mockito.<Long>any());
        verify(ancDiagnosis).setBeneficiaryRegID(Mockito.<Long>any());
        verify(ancDiagnosis).setCauseOfDeath(eq("Cause Of Death"));
        verify(ancDiagnosis).setComplicationOfCurrentPregnancy(eq("Complication Of Current Pregnancy"));
        verify(ancDiagnosis).setComplicationOfCurrentPregnancyList(Mockito.<ArrayList<Map<String, String>>>any());
        verify(ancDiagnosis).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
        verify(ancDiagnosis).setCreatedDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setDateOfDeath(Mockito.<Date>any());
        verify(ancDiagnosis).setDeleted(Mockito.<Boolean>any());
        verify(ancDiagnosis).setExternalInvestigation(eq("External Investigation"));
        verify(ancDiagnosis).setHighRiskCondition(eq("High Risk Condition"));
        verify(ancDiagnosis).setHighRiskStatus(eq("High Risk Status"));
        verify(ancDiagnosis).setID(Mockito.<Long>any());
        verify(ancDiagnosis).setIsMaternalDeath(Mockito.<Boolean>any());
        verify(ancDiagnosis).setLastModDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
        verify(ancDiagnosis).setOtherCurrPregComplication(eq("Other Curr Preg Complication"));
        verify(ancDiagnosis).setParkingPlaceID(Mockito.<Integer>any());
        verify(ancDiagnosis).setPlaceOfDeath(eq("Place Of Death"));
        verify(ancDiagnosis).setPrescriptionID(Mockito.<Long>any());
        verify(ancDiagnosis).setProcessed(eq("Processed"));
        verify(ancDiagnosis).setProviderServiceMapID(Mockito.<Integer>any());
        verify(ancDiagnosis).setReservedForChange(eq("Reserved For Change"));
        verify(ancDiagnosis).setSyncedBy(eq("Synced By"));
        verify(ancDiagnosis).setSyncedDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setVanID(Mockito.<Integer>any());
        verify(ancDiagnosis).setVanSerialNo(Mockito.<Long>any());
        verify(ancDiagnosis).setVehicalNo(eq("Vehical No"));
        verify(ancDiagnosis).setVisitCode(Mockito.<Long>any());
        verify(aNCDiagnosisRepo).save(Mockito.<ANCDiagnosis>any());
        assertEquals(1L, actualSaveBenANCDiagnosisResult.longValue());
    }

    @Test
    void testSaveBenANCDiagnosis6() throws IEMRException {
        // Arrange
        ANCDiagnosis ancDiagnosis = mock(ANCDiagnosis.class);
        when(ancDiagnosis.getID()).thenReturn(1L);
        doNothing().when(ancDiagnosis).setBenVisitID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setBeneficiaryRegID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setCauseOfDeath(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setComplicationOfCurrentPregnancy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setComplicationOfCurrentPregnancyList(Mockito.<ArrayList<Map<String, String>>>any());
        doNothing().when(ancDiagnosis).setCreatedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setCreatedDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setDateOfDeath(Mockito.<Date>any());
        doNothing().when(ancDiagnosis).setDeleted(Mockito.<Boolean>any());
        doNothing().when(ancDiagnosis).setExternalInvestigation(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setHighRiskCondition(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setHighRiskStatus(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setIsMaternalDeath(Mockito.<Boolean>any());
        doNothing().when(ancDiagnosis).setLastModDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setModifiedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setOtherCurrPregComplication(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setParkingPlaceID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setPlaceOfDeath(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setPrescriptionID(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setProcessed(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setProviderServiceMapID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setReservedForChange(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setSyncedBy(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setSyncedDate(Mockito.<Timestamp>any());
        doNothing().when(ancDiagnosis).setVanID(Mockito.<Integer>any());
        doNothing().when(ancDiagnosis).setVanSerialNo(Mockito.<Long>any());
        doNothing().when(ancDiagnosis).setVehicalNo(Mockito.<String>any());
        doNothing().when(ancDiagnosis).setVisitCode(Mockito.<Long>any());
        ancDiagnosis.setBenVisitID(1L);
        ancDiagnosis.setBeneficiaryRegID(1L);
        ancDiagnosis.setCauseOfDeath("Cause Of Death");
        ancDiagnosis.setComplicationOfCurrentPregnancy("Complication Of Current Pregnancy");
        ancDiagnosis.setComplicationOfCurrentPregnancyList(new ArrayList<>());
        ancDiagnosis.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        ancDiagnosis.setCreatedDate(mock(Timestamp.class));
        ancDiagnosis.setDateOfDeath(mock(Date.class));
        ancDiagnosis.setDeleted(true);
        ancDiagnosis.setExternalInvestigation("External Investigation");
        ancDiagnosis.setHighRiskCondition("High Risk Condition");
        ancDiagnosis.setHighRiskStatus("High Risk Status");
        ancDiagnosis.setID(1L);
        ancDiagnosis.setIsMaternalDeath(true);
        ancDiagnosis.setLastModDate(mock(Timestamp.class));
        ancDiagnosis.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        ancDiagnosis.setOtherCurrPregComplication("Other Curr Preg Complication");
        ancDiagnosis.setParkingPlaceID(1);
        ancDiagnosis.setPlaceOfDeath("Place Of Death");
        ancDiagnosis.setPrescriptionID(1L);
        ancDiagnosis.setProcessed("Processed");
        ancDiagnosis.setProviderServiceMapID(1);
        ancDiagnosis.setReservedForChange("Reserved For Change");
        ancDiagnosis.setSyncedBy("Synced By");
        ancDiagnosis.setSyncedDate(mock(Timestamp.class));
        ancDiagnosis.setVanID(1);
        ancDiagnosis.setVanSerialNo(1L);
        ancDiagnosis.setVehicalNo("Vehical No");
        ancDiagnosis.setVisitCode(1L);
        when(aNCDiagnosisRepo.save(Mockito.<ANCDiagnosis>any())).thenReturn(ancDiagnosis);

        JsonObject obj = new JsonObject();
        obj.addProperty("Property", true);

        // Act
        Long actualSaveBenANCDiagnosisResult = aNCDoctorServiceImpl.saveBenANCDiagnosis(obj, 1L);

        // Assert
        verify(ancDiagnosis, atLeast(1)).getID();
        verify(ancDiagnosis).setBenVisitID(Mockito.<Long>any());
        verify(ancDiagnosis).setBeneficiaryRegID(Mockito.<Long>any());
        verify(ancDiagnosis).setCauseOfDeath(eq("Cause Of Death"));
        verify(ancDiagnosis).setComplicationOfCurrentPregnancy(eq("Complication Of Current Pregnancy"));
        verify(ancDiagnosis).setComplicationOfCurrentPregnancyList(Mockito.<ArrayList<Map<String, String>>>any());
        verify(ancDiagnosis).setCreatedBy(eq("Jan 1, 2020 8:00am GMT+0100"));
        verify(ancDiagnosis).setCreatedDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setDateOfDeath(Mockito.<Date>any());
        verify(ancDiagnosis).setDeleted(Mockito.<Boolean>any());
        verify(ancDiagnosis).setExternalInvestigation(eq("External Investigation"));
        verify(ancDiagnosis).setHighRiskCondition(eq("High Risk Condition"));
        verify(ancDiagnosis).setHighRiskStatus(eq("High Risk Status"));
        verify(ancDiagnosis).setID(Mockito.<Long>any());
        verify(ancDiagnosis).setIsMaternalDeath(Mockito.<Boolean>any());
        verify(ancDiagnosis).setLastModDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setModifiedBy(eq("Jan 1, 2020 9:00am GMT+0100"));
        verify(ancDiagnosis).setOtherCurrPregComplication(eq("Other Curr Preg Complication"));
        verify(ancDiagnosis).setParkingPlaceID(Mockito.<Integer>any());
        verify(ancDiagnosis).setPlaceOfDeath(eq("Place Of Death"));
        verify(ancDiagnosis).setPrescriptionID(Mockito.<Long>any());
        verify(ancDiagnosis).setProcessed(eq("Processed"));
        verify(ancDiagnosis).setProviderServiceMapID(Mockito.<Integer>any());
        verify(ancDiagnosis).setReservedForChange(eq("Reserved For Change"));
        verify(ancDiagnosis).setSyncedBy(eq("Synced By"));
        verify(ancDiagnosis).setSyncedDate(Mockito.<Timestamp>any());
        verify(ancDiagnosis).setVanID(Mockito.<Integer>any());
        verify(ancDiagnosis).setVanSerialNo(Mockito.<Long>any());
        verify(ancDiagnosis).setVehicalNo(eq("Vehical No"));
        verify(ancDiagnosis).setVisitCode(Mockito.<Long>any());
        verify(aNCDiagnosisRepo).save(Mockito.<ANCDiagnosis>any());
        assertEquals(1L, actualSaveBenANCDiagnosisResult.longValue());
    }

    /**
     * Method under test:
     * {@link ANCDoctorServiceImpl#getANCDiagnosisDetails(Long, Long)}
     */
    @Test
    void testGetANCDiagnosisDetails() {
        // Arrange
        when(aNCDiagnosisRepo.findByBeneficiaryRegIDAndVisitCode(Mockito.<Long>any(), Mockito.<Long>any()))
                .thenReturn(new ArrayList<>());
        when(prescriptionDetailRepo.getExternalinvestigationForVisitCode(Mockito.<Long>any(), Mockito.<Long>any()))
                .thenReturn("Externalinvestigation For Visit Code");

        // Act
        String actualANCDiagnosisDetails = aNCDoctorServiceImpl.getANCDiagnosisDetails(1L, 1L);

        // Assert
        verify(aNCDiagnosisRepo).findByBeneficiaryRegIDAndVisitCode(Mockito.<Long>any(), Mockito.<Long>any());
        verify(prescriptionDetailRepo).getExternalinvestigationForVisitCode(Mockito.<Long>any(), Mockito.<Long>any());
        assertEquals(
                "{\"complicationOfCurrentPregnancy\":\"null , Other-complications : null\",\"externalInvestigation\":"
                        + "\"Externalinvestigation For Visit Code\",\"complicationOfCurrentPregnancyList\":[]}",
                actualANCDiagnosisDetails);
    }
    
    @Test
    void testUpdateBenANCDiagnosis() throws IEMRException {
        // Arrange
        when(aNCDiagnosisRepo.updateANCDiagnosis(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
                Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Date>any(), Mockito.<String>any(),
                Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(1);
        when(aNCDiagnosisRepo.getANCDiagnosisStatus(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
                .thenReturn("Anc Diagnosis Status");

        ANCDiagnosis ancDiagnosis = new ANCDiagnosis();
        ancDiagnosis.setBenVisitID(1L);
        ancDiagnosis.setBeneficiaryRegID(1L);
        ancDiagnosis.setCauseOfDeath("Cause Of Death");
        ancDiagnosis.setComplicationOfCurrentPregnancy("Complication Of Current Pregnancy");
        ancDiagnosis.setComplicationOfCurrentPregnancyList(new ArrayList<>());
        ancDiagnosis.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        ancDiagnosis.setCreatedDate(mock(Timestamp.class));
        ancDiagnosis.setDateOfDeath(mock(Date.class));
        ancDiagnosis.setDeleted(true);
        ancDiagnosis.setExternalInvestigation("External Investigation");
        ancDiagnosis.setHighRiskCondition("High Risk Condition");
        ancDiagnosis.setHighRiskStatus("High Risk Status");
        ancDiagnosis.setID(1L);
        ancDiagnosis.setIsMaternalDeath(true);
        ancDiagnosis.setLastModDate(mock(Timestamp.class));
        ancDiagnosis.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        ancDiagnosis.setOtherCurrPregComplication("Other Curr Preg Complication");
        ancDiagnosis.setParkingPlaceID(1);
        ancDiagnosis.setPlaceOfDeath("Place Of Death");
        ancDiagnosis.setPrescriptionID(1L);
        ancDiagnosis.setProcessed("Processed");
        ancDiagnosis.setProviderServiceMapID(1);
        ancDiagnosis.setReservedForChange("Reserved For Change");
        ancDiagnosis.setSyncedBy("Synced By");
        ancDiagnosis.setSyncedDate(mock(Timestamp.class));
        ancDiagnosis.setVanID(1);
        ancDiagnosis.setVanSerialNo(1L);
        ancDiagnosis.setVehicalNo("Vehical No");
        ancDiagnosis.setVisitCode(1L);

        // Act
        int actualUpdateBenANCDiagnosisResult = aNCDoctorServiceImpl.updateBenANCDiagnosis(ancDiagnosis);

        // Assert
        verify(aNCDiagnosisRepo).getANCDiagnosisStatus(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any());
        verify(aNCDiagnosisRepo).updateANCDiagnosis(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
                Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Date>any(), Mockito.<String>any(),
                Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any());
        assertEquals("", ancDiagnosis.getComplicationOfCurrentPregnancy());
        assertEquals("U", ancDiagnosis.getProcessed());
        assertEquals(1, actualUpdateBenANCDiagnosisResult);
    }

    @Test
    void testUpdateBenANCDiagnosis2() throws IEMRException {
        // Arrange
        when(aNCDiagnosisRepo.updateANCDiagnosis(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
                Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Date>any(), Mockito.<String>any(),
                Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
                .thenReturn(0);
        when(aNCDiagnosisRepo.getANCDiagnosisStatus(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any()))
                .thenReturn("Anc Diagnosis Status");

        ANCDiagnosis ancDiagnosis = new ANCDiagnosis();
        ancDiagnosis.setBenVisitID(1L);
        ancDiagnosis.setBeneficiaryRegID(1L);
        ancDiagnosis.setCauseOfDeath("Cause Of Death");
        ancDiagnosis.setComplicationOfCurrentPregnancy("Complication Of Current Pregnancy");
        ancDiagnosis.setComplicationOfCurrentPregnancyList(new ArrayList<>());
        ancDiagnosis.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        ancDiagnosis.setCreatedDate(mock(Timestamp.class));
        ancDiagnosis.setDateOfDeath(mock(Date.class));
        ancDiagnosis.setDeleted(true);
        ancDiagnosis.setExternalInvestigation("External Investigation");
        ancDiagnosis.setHighRiskCondition("High Risk Condition");
        ancDiagnosis.setHighRiskStatus("High Risk Status");
        ancDiagnosis.setID(1L);
        ancDiagnosis.setIsMaternalDeath(true);
        ancDiagnosis.setLastModDate(mock(Timestamp.class));
        ancDiagnosis.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        ancDiagnosis.setOtherCurrPregComplication("Other Curr Preg Complication");
        ancDiagnosis.setParkingPlaceID(1);
        ancDiagnosis.setPlaceOfDeath("Place Of Death");
        ancDiagnosis.setPrescriptionID(1L);
        ancDiagnosis.setProcessed("Processed");
        ancDiagnosis.setProviderServiceMapID(1);
        ancDiagnosis.setReservedForChange("Reserved For Change");
        ancDiagnosis.setSyncedBy("Synced By");
        ancDiagnosis.setSyncedDate(mock(Timestamp.class));
        ancDiagnosis.setVanID(1);
        ancDiagnosis.setVanSerialNo(1L);
        ancDiagnosis.setVehicalNo("Vehical No");
        ancDiagnosis.setVisitCode(1L);

        // Act
        int actualUpdateBenANCDiagnosisResult = aNCDoctorServiceImpl.updateBenANCDiagnosis(ancDiagnosis);

        // Assert
        verify(aNCDiagnosisRepo).getANCDiagnosisStatus(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any());
        verify(aNCDiagnosisRepo).updateANCDiagnosis(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
                Mockito.<Boolean>any(), Mockito.<String>any(), Mockito.<Date>any(), Mockito.<String>any(),
                Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any());
        assertEquals("", ancDiagnosis.getComplicationOfCurrentPregnancy());
        assertEquals("U", ancDiagnosis.getProcessed());
        assertEquals(0, actualUpdateBenANCDiagnosisResult);
    }

    
    @Test
    void testGettersAndSetters() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ANCDoctorServiceImpl.ancDiagnosisRepo
        //     ANCDoctorServiceImpl.prescriptionDetailRepo

        // Arrange
        ANCDoctorServiceImpl ancDoctorServiceImpl = new ANCDoctorServiceImpl();

        // Act
        ancDoctorServiceImpl.setAncDiagnosisRepo(mock(ANCDiagnosisRepo.class));
        ancDoctorServiceImpl.setPrescriptionDetailRepo(mock(PrescriptionDetailRepo.class));
    }
}
