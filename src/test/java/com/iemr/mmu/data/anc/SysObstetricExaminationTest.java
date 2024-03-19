package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class SysObstetricExaminationTest {
    @Autowired
    private SysObstetricExamination sysObstetricExamination;

   
    @Test
    void testGetfHAndPOA_Status() {
        // Arrange, Act and Assert
        assertNull((new SysObstetricExamination()).getfHAndPOA_Status());
    }

    @Test
    void testGetfHAndPOA_Status2() {
        // Arrange
        SysObstetricExamination sysObstetricExamination2 = new SysObstetricExamination();
        sysObstetricExamination2.setCreatedDate(mock(Timestamp.class));

        // Act and Assert
        assertNull(sysObstetricExamination2.getfHAndPOA_Status());
    }

    @Test
    void testGetfHAndPOA_Interpretation() {
        // Arrange, Act and Assert
        assertNull((new SysObstetricExamination()).getfHAndPOA_Interpretation());
    }

    
    @Test
    void testGetfHAndPOA_Interpretation2() {
        // Arrange
        SysObstetricExamination sysObstetricExamination2 = new SysObstetricExamination();
        sysObstetricExamination2.setCreatedDate(mock(Timestamp.class));

        // Act and Assert
        assertNull(sysObstetricExamination2.getfHAndPOA_Interpretation());
    }

    @Test
    void testGettersAndSetters() {
        // Arrange
        SysObstetricExamination sysObstetricExamination = new SysObstetricExamination();

        // Act
        sysObstetricExamination.setAbdominalScars("Abdominal Scars");
        sysObstetricExamination.setBenVisitID(1L);
        sysObstetricExamination.setBeneficiaryRegID(1L);
        sysObstetricExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        sysObstetricExamination.setCreatedDate(createdDate);
        sysObstetricExamination.setDeleted(true);
        sysObstetricExamination.setFetalHeartRate_BeatsPerMinute("Fetal Heart Rate Beats Per Minute");
        sysObstetricExamination.setFetalHeartSounds("Fetal Heart Sounds");
        sysObstetricExamination.setFetalMovements("Fetal Movements");
        sysObstetricExamination.setFetalPositionOrLie("Fetal Position Or Lie");
        sysObstetricExamination.setFetalPresentation("Fetal Presentation");
        sysObstetricExamination.setFundalHeight("Fundal Height");
        sysObstetricExamination.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        sysObstetricExamination.setLastModDate(lastModDate);
        sysObstetricExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        sysObstetricExamination.setParkingPlaceID(1);
        sysObstetricExamination.setProcessed("Processed");
        sysObstetricExamination.setProviderServiceMapID(1);
        sysObstetricExamination.setReservedForChange("Reserved For Change");
        sysObstetricExamination.setSfh(10.0d);
        sysObstetricExamination.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        sysObstetricExamination.setSyncedDate(syncedDate);
        sysObstetricExamination.setVanSerialNo(1L);
        sysObstetricExamination.setVehicalNo("Vehical No");
        sysObstetricExamination.setVisitCode(1L);
        sysObstetricExamination.setfHAndPOA_Interpretation("F HAnd POA Interpretation");
        sysObstetricExamination.setfHAndPOA_Status("F HAnd POA Status");
        String actualAbdominalScars = sysObstetricExamination.getAbdominalScars();
        Long actualBenVisitID = sysObstetricExamination.getBenVisitID();
        Long actualBeneficiaryRegID = sysObstetricExamination.getBeneficiaryRegID();
        String actualCreatedBy = sysObstetricExamination.getCreatedBy();
        Timestamp actualCreatedDate = sysObstetricExamination.getCreatedDate();
        Boolean actualDeleted = sysObstetricExamination.getDeleted();
        String actualFetalHeartRate_BeatsPerMinute = sysObstetricExamination.getFetalHeartRate_BeatsPerMinute();
        String actualFetalHeartSounds = sysObstetricExamination.getFetalHeartSounds();
        String actualFetalMovements = sysObstetricExamination.getFetalMovements();
        String actualFetalPositionOrLie = sysObstetricExamination.getFetalPositionOrLie();
        String actualFetalPresentation = sysObstetricExamination.getFetalPresentation();
        String actualFundalHeight = sysObstetricExamination.getFundalHeight();
        Long actualID = sysObstetricExamination.getID();
        Timestamp actualLastModDate = sysObstetricExamination.getLastModDate();
        String actualModifiedBy = sysObstetricExamination.getModifiedBy();
        Integer actualParkingPlaceID = sysObstetricExamination.getParkingPlaceID();
        String actualProcessed = sysObstetricExamination.getProcessed();
        Integer actualProviderServiceMapID = sysObstetricExamination.getProviderServiceMapID();
        String actualReservedForChange = sysObstetricExamination.getReservedForChange();
        Double actualSfh = sysObstetricExamination.getSfh();
        String actualSyncedBy = sysObstetricExamination.getSyncedBy();
        Timestamp actualSyncedDate = sysObstetricExamination.getSyncedDate();
        Long actualVanSerialNo = sysObstetricExamination.getVanSerialNo();
        String actualVehicalNo = sysObstetricExamination.getVehicalNo();
        Long actualVisitCode = sysObstetricExamination.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Abdominal Scars", actualAbdominalScars);
        assertEquals("Fetal Heart Rate Beats Per Minute", actualFetalHeartRate_BeatsPerMinute);
        assertEquals("Fetal Heart Sounds", actualFetalHeartSounds);
        assertEquals("Fetal Movements", actualFetalMovements);
        assertEquals("Fetal Position Or Lie", actualFetalPositionOrLie);
        assertEquals("Fetal Presentation", actualFetalPresentation);
        assertEquals("Fundal Height", actualFundalHeight);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(10.0d, actualSfh.doubleValue());
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
