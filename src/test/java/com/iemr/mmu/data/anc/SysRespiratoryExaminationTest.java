package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class SysRespiratoryExaminationTest {
  
    @Test
    void testGettersAndSetters() {
        // Arrange
        SysRespiratoryExamination sysRespiratoryExamination = new SysRespiratoryExamination();

        // Act
        sysRespiratoryExamination.setAuscultation("Auscultation");
        sysRespiratoryExamination.setAuscultation_BreathSounds("Auscultation Breath Sounds");
        sysRespiratoryExamination.setAuscultation_ConductedSounds("Auscultation Conducted Sounds");
        sysRespiratoryExamination.setAuscultation_Crepitations("Auscultation Crepitations");
        sysRespiratoryExamination.setAuscultation_PleuralRub("Auscultation Pleural Rub");
        sysRespiratoryExamination.setAuscultation_Stridor("Auscultation Stridor");
        sysRespiratoryExamination.setAuscultation_Wheezing("Auscultation Wheezing");
        sysRespiratoryExamination.setBenVisitID(1L);
        sysRespiratoryExamination.setBeneficiaryRegID(1L);
        sysRespiratoryExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        sysRespiratoryExamination.setCreatedDate(createdDate);
        sysRespiratoryExamination.setDeleted(true);
        sysRespiratoryExamination.setID(1L);
        sysRespiratoryExamination.setInspection("Inspection");
        Timestamp lastModDate = mock(Timestamp.class);
        sysRespiratoryExamination.setLastModDate(lastModDate);
        sysRespiratoryExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        sysRespiratoryExamination.setPalpation("Palpation");
        sysRespiratoryExamination.setParkingPlaceID(1);
        sysRespiratoryExamination.setPercussion("Percussion");
        sysRespiratoryExamination.setProcessed("Processed");
        sysRespiratoryExamination.setProviderServiceMapID(1);
        sysRespiratoryExamination.setReservedForChange("Reserved For Change");
        sysRespiratoryExamination.setSignsOfRespiratoryDistress("Signs Of Respiratory Distress");
        sysRespiratoryExamination.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        sysRespiratoryExamination.setSyncedDate(syncedDate);
        sysRespiratoryExamination.setTrachea("Trachea");
        sysRespiratoryExamination.setVanSerialNo(1L);
        sysRespiratoryExamination.setVehicalNo("Vehical No");
        sysRespiratoryExamination.setVisitCode(1L);
        String actualAuscultation = sysRespiratoryExamination.getAuscultation();
        String actualAuscultation_BreathSounds = sysRespiratoryExamination.getAuscultation_BreathSounds();
        String actualAuscultation_ConductedSounds = sysRespiratoryExamination.getAuscultation_ConductedSounds();
        String actualAuscultation_Crepitations = sysRespiratoryExamination.getAuscultation_Crepitations();
        String actualAuscultation_PleuralRub = sysRespiratoryExamination.getAuscultation_PleuralRub();
        String actualAuscultation_Stridor = sysRespiratoryExamination.getAuscultation_Stridor();
        String actualAuscultation_Wheezing = sysRespiratoryExamination.getAuscultation_Wheezing();
        Long actualBenVisitID = sysRespiratoryExamination.getBenVisitID();
        Long actualBeneficiaryRegID = sysRespiratoryExamination.getBeneficiaryRegID();
        String actualCreatedBy = sysRespiratoryExamination.getCreatedBy();
        Timestamp actualCreatedDate = sysRespiratoryExamination.getCreatedDate();
        Boolean actualDeleted = sysRespiratoryExamination.getDeleted();
        Long actualID = sysRespiratoryExamination.getID();
        String actualInspection = sysRespiratoryExamination.getInspection();
        Timestamp actualLastModDate = sysRespiratoryExamination.getLastModDate();
        String actualModifiedBy = sysRespiratoryExamination.getModifiedBy();
        String actualPalpation = sysRespiratoryExamination.getPalpation();
        Integer actualParkingPlaceID = sysRespiratoryExamination.getParkingPlaceID();
        String actualPercussion = sysRespiratoryExamination.getPercussion();
        String actualProcessed = sysRespiratoryExamination.getProcessed();
        Integer actualProviderServiceMapID = sysRespiratoryExamination.getProviderServiceMapID();
        String actualReservedForChange = sysRespiratoryExamination.getReservedForChange();
        String actualSignsOfRespiratoryDistress = sysRespiratoryExamination.getSignsOfRespiratoryDistress();
        String actualSyncedBy = sysRespiratoryExamination.getSyncedBy();
        Timestamp actualSyncedDate = sysRespiratoryExamination.getSyncedDate();
        String actualTrachea = sysRespiratoryExamination.getTrachea();
        Long actualVanSerialNo = sysRespiratoryExamination.getVanSerialNo();
        String actualVehicalNo = sysRespiratoryExamination.getVehicalNo();
        Long actualVisitCode = sysRespiratoryExamination.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Auscultation Breath Sounds", actualAuscultation_BreathSounds);
        assertEquals("Auscultation Conducted Sounds", actualAuscultation_ConductedSounds);
        assertEquals("Auscultation Crepitations", actualAuscultation_Crepitations);
        assertEquals("Auscultation Pleural Rub", actualAuscultation_PleuralRub);
        assertEquals("Auscultation Stridor", actualAuscultation_Stridor);
        assertEquals("Auscultation Wheezing", actualAuscultation_Wheezing);
        assertEquals("Auscultation", actualAuscultation);
        assertEquals("Inspection", actualInspection);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Palpation", actualPalpation);
        assertEquals("Percussion", actualPercussion);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Signs Of Respiratory Distress", actualSignsOfRespiratoryDistress);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Trachea", actualTrachea);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }
}
