package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class ANCDiagnosisTest {
    
    @Test
    void testGetANCDiagnosisDetails() {
        assertNull(ANCDiagnosis.getANCDiagnosisDetails(new ArrayList<>()));
    }
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        ANCDiagnosis actualAncDiagnosis = new ANCDiagnosis();
        actualAncDiagnosis.setBenVisitID(1L);
        actualAncDiagnosis.setBeneficiaryRegID(1L);
        actualAncDiagnosis.setCauseOfDeath("Cause Of Death");
        actualAncDiagnosis.setComplicationOfCurrentPregnancy("Complication Of Current Pregnancy");
        ArrayList<Map<String, String>> complicationOfCurrentPregnancyList = new ArrayList<>();
        actualAncDiagnosis.setComplicationOfCurrentPregnancyList(complicationOfCurrentPregnancyList);
        actualAncDiagnosis.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualAncDiagnosis.setCreatedDate(createdDate);
        Date dateOfDeath = mock(Date.class);
        actualAncDiagnosis.setDateOfDeath(dateOfDeath);
        actualAncDiagnosis.setDeleted(true);
        actualAncDiagnosis.setExternalInvestigation("External Investigation");
        actualAncDiagnosis.setHighRiskCondition("High Risk Condition");
        actualAncDiagnosis.setHighRiskStatus("High Risk Status");
        actualAncDiagnosis.setID(1L);
        actualAncDiagnosis.setIsMaternalDeath(true);
        Timestamp lastModDate = mock(Timestamp.class);
        actualAncDiagnosis.setLastModDate(lastModDate);
        actualAncDiagnosis.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualAncDiagnosis.setOtherCurrPregComplication("Other Curr Preg Complication");
        actualAncDiagnosis.setParkingPlaceID(1);
        actualAncDiagnosis.setPlaceOfDeath("Place Of Death");
        actualAncDiagnosis.setPrescriptionID(1L);
        actualAncDiagnosis.setProcessed("Processed");
        actualAncDiagnosis.setProviderServiceMapID(1);
        actualAncDiagnosis.setReservedForChange("Reserved For Change");
        actualAncDiagnosis.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualAncDiagnosis.setSyncedDate(syncedDate);
        actualAncDiagnosis.setVanID(1);
        actualAncDiagnosis.setVanSerialNo(1L);
        actualAncDiagnosis.setVehicalNo("Vehical No");
        actualAncDiagnosis.setVisitCode(1L);
        Long actualBenVisitID = actualAncDiagnosis.getBenVisitID();
        Long actualBeneficiaryRegID = actualAncDiagnosis.getBeneficiaryRegID();
        String actualCauseOfDeath = actualAncDiagnosis.getCauseOfDeath();
        String actualComplicationOfCurrentPregnancy = actualAncDiagnosis.getComplicationOfCurrentPregnancy();
        ArrayList<Map<String, String>> actualComplicationOfCurrentPregnancyList = actualAncDiagnosis
                .getComplicationOfCurrentPregnancyList();
        String actualCreatedBy = actualAncDiagnosis.getCreatedBy();
        Timestamp actualCreatedDate = actualAncDiagnosis.getCreatedDate();
        Date actualDateOfDeath = actualAncDiagnosis.getDateOfDeath();
        Boolean actualDeleted = actualAncDiagnosis.getDeleted();
        String actualExternalInvestigation = actualAncDiagnosis.getExternalInvestigation();
        String actualHighRiskCondition = actualAncDiagnosis.getHighRiskCondition();
        String actualHighRiskStatus = actualAncDiagnosis.getHighRiskStatus();
        Long actualID = actualAncDiagnosis.getID();
        Boolean actualIsMaternalDeath = actualAncDiagnosis.getIsMaternalDeath();
        Timestamp actualLastModDate = actualAncDiagnosis.getLastModDate();
        String actualModifiedBy = actualAncDiagnosis.getModifiedBy();
        String actualOtherCurrPregComplication = actualAncDiagnosis.getOtherCurrPregComplication();
        Integer actualParkingPlaceID = actualAncDiagnosis.getParkingPlaceID();
        String actualPlaceOfDeath = actualAncDiagnosis.getPlaceOfDeath();
        Long actualPrescriptionID = actualAncDiagnosis.getPrescriptionID();
        String actualProcessed = actualAncDiagnosis.getProcessed();
        Integer actualProviderServiceMapID = actualAncDiagnosis.getProviderServiceMapID();
        String actualReservedForChange = actualAncDiagnosis.getReservedForChange();
        String actualSyncedBy = actualAncDiagnosis.getSyncedBy();
        Timestamp actualSyncedDate = actualAncDiagnosis.getSyncedDate();
        Integer actualVanID = actualAncDiagnosis.getVanID();
        Long actualVanSerialNo = actualAncDiagnosis.getVanSerialNo();
        String actualVehicalNo = actualAncDiagnosis.getVehicalNo();
        Long actualVisitCode = actualAncDiagnosis.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Cause Of Death", actualCauseOfDeath);
        assertEquals("Complication Of Current Pregnancy", actualComplicationOfCurrentPregnancy);
        assertEquals("External Investigation", actualExternalInvestigation);
        assertEquals("High Risk Condition", actualHighRiskCondition);
        assertEquals("High Risk Status", actualHighRiskStatus);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Curr Preg Complication", actualOtherCurrPregComplication);
        assertEquals("Place Of Death", actualPlaceOfDeath);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualPrescriptionID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertTrue(actualIsMaternalDeath);
        assertSame(complicationOfCurrentPregnancyList, actualComplicationOfCurrentPregnancyList);
        assertSame(dateOfDeath, actualDateOfDeath);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        ANCDiagnosis actualAncDiagnosis = new ANCDiagnosis(1L, 1L, 1L, 1, 1L, "High Risk Status", "High Risk Condition",
                "Complication Of Current Pregnancy", true, "Place Of Death", mock(Date.class), "Cause Of Death", 1L,
                "External Investigation");
        actualAncDiagnosis.setBenVisitID(1L);
        actualAncDiagnosis.setBeneficiaryRegID(1L);
        actualAncDiagnosis.setCauseOfDeath("Cause Of Death");
        actualAncDiagnosis.setComplicationOfCurrentPregnancy("Complication Of Current Pregnancy");
        ArrayList<Map<String, String>> complicationOfCurrentPregnancyList = new ArrayList<>();
        actualAncDiagnosis.setComplicationOfCurrentPregnancyList(complicationOfCurrentPregnancyList);
        actualAncDiagnosis.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualAncDiagnosis.setCreatedDate(createdDate);
        Date dateOfDeath = mock(Date.class);
        actualAncDiagnosis.setDateOfDeath(dateOfDeath);
        actualAncDiagnosis.setDeleted(true);
        actualAncDiagnosis.setExternalInvestigation("External Investigation");
        actualAncDiagnosis.setHighRiskCondition("High Risk Condition");
        actualAncDiagnosis.setHighRiskStatus("High Risk Status");
        actualAncDiagnosis.setID(1L);
        actualAncDiagnosis.setIsMaternalDeath(true);
        Timestamp lastModDate = mock(Timestamp.class);
        actualAncDiagnosis.setLastModDate(lastModDate);
        actualAncDiagnosis.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualAncDiagnosis.setOtherCurrPregComplication("Other Curr Preg Complication");
        actualAncDiagnosis.setParkingPlaceID(1);
        actualAncDiagnosis.setPlaceOfDeath("Place Of Death");
        actualAncDiagnosis.setPrescriptionID(1L);
        actualAncDiagnosis.setProcessed("Processed");
        actualAncDiagnosis.setProviderServiceMapID(1);
        actualAncDiagnosis.setReservedForChange("Reserved For Change");
        actualAncDiagnosis.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualAncDiagnosis.setSyncedDate(syncedDate);
        actualAncDiagnosis.setVanID(1);
        actualAncDiagnosis.setVanSerialNo(1L);
        actualAncDiagnosis.setVehicalNo("Vehical No");
        actualAncDiagnosis.setVisitCode(1L);
        Long actualBenVisitID = actualAncDiagnosis.getBenVisitID();
        Long actualBeneficiaryRegID = actualAncDiagnosis.getBeneficiaryRegID();
        String actualCauseOfDeath = actualAncDiagnosis.getCauseOfDeath();
        String actualComplicationOfCurrentPregnancy = actualAncDiagnosis.getComplicationOfCurrentPregnancy();
        ArrayList<Map<String, String>> actualComplicationOfCurrentPregnancyList = actualAncDiagnosis
                .getComplicationOfCurrentPregnancyList();
        String actualCreatedBy = actualAncDiagnosis.getCreatedBy();
        Timestamp actualCreatedDate = actualAncDiagnosis.getCreatedDate();
        Date actualDateOfDeath = actualAncDiagnosis.getDateOfDeath();
        Boolean actualDeleted = actualAncDiagnosis.getDeleted();
        String actualExternalInvestigation = actualAncDiagnosis.getExternalInvestigation();
        String actualHighRiskCondition = actualAncDiagnosis.getHighRiskCondition();
        String actualHighRiskStatus = actualAncDiagnosis.getHighRiskStatus();
        Long actualID = actualAncDiagnosis.getID();
        Boolean actualIsMaternalDeath = actualAncDiagnosis.getIsMaternalDeath();
        Timestamp actualLastModDate = actualAncDiagnosis.getLastModDate();
        String actualModifiedBy = actualAncDiagnosis.getModifiedBy();
        String actualOtherCurrPregComplication = actualAncDiagnosis.getOtherCurrPregComplication();
        Integer actualParkingPlaceID = actualAncDiagnosis.getParkingPlaceID();
        String actualPlaceOfDeath = actualAncDiagnosis.getPlaceOfDeath();
        Long actualPrescriptionID = actualAncDiagnosis.getPrescriptionID();
        String actualProcessed = actualAncDiagnosis.getProcessed();
        Integer actualProviderServiceMapID = actualAncDiagnosis.getProviderServiceMapID();
        String actualReservedForChange = actualAncDiagnosis.getReservedForChange();
        String actualSyncedBy = actualAncDiagnosis.getSyncedBy();
        Timestamp actualSyncedDate = actualAncDiagnosis.getSyncedDate();
        Integer actualVanID = actualAncDiagnosis.getVanID();
        Long actualVanSerialNo = actualAncDiagnosis.getVanSerialNo();
        String actualVehicalNo = actualAncDiagnosis.getVehicalNo();
        Long actualVisitCode = actualAncDiagnosis.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Cause Of Death", actualCauseOfDeath);
        assertEquals("Complication Of Current Pregnancy", actualComplicationOfCurrentPregnancy);
        assertEquals("External Investigation", actualExternalInvestigation);
        assertEquals("High Risk Condition", actualHighRiskCondition);
        assertEquals("High Risk Status", actualHighRiskStatus);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Curr Preg Complication", actualOtherCurrPregComplication);
        assertEquals("Place Of Death", actualPlaceOfDeath);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualPrescriptionID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertTrue(actualIsMaternalDeath);
        assertSame(complicationOfCurrentPregnancyList, actualComplicationOfCurrentPregnancyList);
        assertSame(dateOfDeath, actualDateOfDeath);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }
}
