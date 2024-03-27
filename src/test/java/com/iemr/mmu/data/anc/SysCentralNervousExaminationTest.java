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
class SysCentralNervousExaminationTest {
   
    @Test
    void testGettersAndSetters() {
        // Arrange
        SysCentralNervousExamination sysCentralNervousExamination = new SysCentralNervousExamination();

        // Act
        sysCentralNervousExamination.setAutonomicSystem("Autonomic System");
        sysCentralNervousExamination.setBenVisitID(1L);
        sysCentralNervousExamination.setBeneficiaryRegID(1L);
        sysCentralNervousExamination.setCerebellarSigns("Cerebellar Signs");
        sysCentralNervousExamination.setCranialNervesExamination("Cranial Nerves Examination");
        sysCentralNervousExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        sysCentralNervousExamination.setCreatedDate(createdDate);
        sysCentralNervousExamination.setDeleted(true);
        sysCentralNervousExamination.setHandedness("Handedness");
        sysCentralNervousExamination.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        sysCentralNervousExamination.setLastModDate(lastModDate);
        sysCentralNervousExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        sysCentralNervousExamination.setMotorSystem("Motor System");
        sysCentralNervousExamination.setParkingPlaceID(1);
        sysCentralNervousExamination.setProcessed("Processed");
        sysCentralNervousExamination.setProviderServiceMapID(1);
        sysCentralNervousExamination.setReservedForChange("Reserved For Change");
        sysCentralNervousExamination.setSensorySystem("Sensory System");
        sysCentralNervousExamination.setSignsOfMeningealIrritation("Signs Of Meningeal Irritation");
        sysCentralNervousExamination.setSkull("Skull");
        sysCentralNervousExamination.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        sysCentralNervousExamination.setSyncedDate(syncedDate);
        sysCentralNervousExamination.setVanSerialNo(1L);
        sysCentralNervousExamination.setVehicalNo("Vehical No");
        sysCentralNervousExamination.setVisitCode(1L);
        String actualAutonomicSystem = sysCentralNervousExamination.getAutonomicSystem();
        Long actualBenVisitID = sysCentralNervousExamination.getBenVisitID();
        Long actualBeneficiaryRegID = sysCentralNervousExamination.getBeneficiaryRegID();
        String actualCerebellarSigns = sysCentralNervousExamination.getCerebellarSigns();
        String actualCranialNervesExamination = sysCentralNervousExamination.getCranialNervesExamination();
        String actualCreatedBy = sysCentralNervousExamination.getCreatedBy();
        Timestamp actualCreatedDate = sysCentralNervousExamination.getCreatedDate();
        Boolean actualDeleted = sysCentralNervousExamination.getDeleted();
        String actualHandedness = sysCentralNervousExamination.getHandedness();
        Long actualID = sysCentralNervousExamination.getID();
        Timestamp actualLastModDate = sysCentralNervousExamination.getLastModDate();
        String actualModifiedBy = sysCentralNervousExamination.getModifiedBy();
        String actualMotorSystem = sysCentralNervousExamination.getMotorSystem();
        Integer actualParkingPlaceID = sysCentralNervousExamination.getParkingPlaceID();
        String actualProcessed = sysCentralNervousExamination.getProcessed();
        Integer actualProviderServiceMapID = sysCentralNervousExamination.getProviderServiceMapID();
        String actualReservedForChange = sysCentralNervousExamination.getReservedForChange();
        String actualSensorySystem = sysCentralNervousExamination.getSensorySystem();
        String actualSignsOfMeningealIrritation = sysCentralNervousExamination.getSignsOfMeningealIrritation();
        String actualSkull = sysCentralNervousExamination.getSkull();
        String actualSyncedBy = sysCentralNervousExamination.getSyncedBy();
        Timestamp actualSyncedDate = sysCentralNervousExamination.getSyncedDate();
        Long actualVanSerialNo = sysCentralNervousExamination.getVanSerialNo();
        String actualVehicalNo = sysCentralNervousExamination.getVehicalNo();
        Long actualVisitCode = sysCentralNervousExamination.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Autonomic System", actualAutonomicSystem);
        assertEquals("Cerebellar Signs", actualCerebellarSigns);
        assertEquals("Cranial Nerves Examination", actualCranialNervesExamination);
        assertEquals("Handedness", actualHandedness);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Motor System", actualMotorSystem);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Sensory System", actualSensorySystem);
        assertEquals("Signs Of Meningeal Irritation", actualSignsOfMeningealIrritation);
        assertEquals("Skull", actualSkull);
        assertEquals("Synced By", actualSyncedBy);
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
