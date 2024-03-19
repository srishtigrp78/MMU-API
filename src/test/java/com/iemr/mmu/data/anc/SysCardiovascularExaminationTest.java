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
class SysCardiovascularExaminationTest {
    
    @Test
    void testGettersAndSetters() {
        // Arrange
        SysCardiovascularExamination sysCardiovascularExamination = new SysCardiovascularExamination();

        // Act
        sysCardiovascularExamination.setAdditionalHeartSounds("Additional Heart Sounds");
        sysCardiovascularExamination.setApexbeatLocation("Apexbeat Location");
        sysCardiovascularExamination.setApexbeatType("Apexbeat Type");
        sysCardiovascularExamination.setBenVisitID(1L);
        sysCardiovascularExamination.setBeneficiaryRegID(1L);
        sysCardiovascularExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        sysCardiovascularExamination.setCreatedDate(createdDate);
        sysCardiovascularExamination.setDeleted(true);
        sysCardiovascularExamination.setFirstHeartSound_S1("First Heart Sound S1");
        sysCardiovascularExamination.setID(1L);
        sysCardiovascularExamination.setJugularVenousPulse_JVP("Jugular Venous Pulse JVP");
        Timestamp lastModDate = mock(Timestamp.class);
        sysCardiovascularExamination.setLastModDate(lastModDate);
        sysCardiovascularExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        sysCardiovascularExamination.setMurmurs("Murmurs");
        sysCardiovascularExamination.setParkingPlaceID(1);
        sysCardiovascularExamination.setPericardialRub("Pericardial Rub");
        sysCardiovascularExamination.setProcessed("Processed");
        sysCardiovascularExamination.setProviderServiceMapID(1);
        sysCardiovascularExamination.setReservedForChange("Reserved For Change");
        sysCardiovascularExamination.setSecondHeartSound_S2("Second Heart Sound S2");
        sysCardiovascularExamination.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        sysCardiovascularExamination.setSyncedDate(syncedDate);
        sysCardiovascularExamination.setVanSerialNo(1L);
        sysCardiovascularExamination.setVehicalNo("Vehical No");
        sysCardiovascularExamination.setVisitCode(1L);
        String actualAdditionalHeartSounds = sysCardiovascularExamination.getAdditionalHeartSounds();
        String actualApexbeatLocation = sysCardiovascularExamination.getApexbeatLocation();
        String actualApexbeatType = sysCardiovascularExamination.getApexbeatType();
        Long actualBenVisitID = sysCardiovascularExamination.getBenVisitID();
        Long actualBeneficiaryRegID = sysCardiovascularExamination.getBeneficiaryRegID();
        String actualCreatedBy = sysCardiovascularExamination.getCreatedBy();
        Timestamp actualCreatedDate = sysCardiovascularExamination.getCreatedDate();
        Boolean actualDeleted = sysCardiovascularExamination.getDeleted();
        String actualFirstHeartSound_S1 = sysCardiovascularExamination.getFirstHeartSound_S1();
        Long actualID = sysCardiovascularExamination.getID();
        String actualJugularVenousPulse_JVP = sysCardiovascularExamination.getJugularVenousPulse_JVP();
        Timestamp actualLastModDate = sysCardiovascularExamination.getLastModDate();
        String actualModifiedBy = sysCardiovascularExamination.getModifiedBy();
        String actualMurmurs = sysCardiovascularExamination.getMurmurs();
        Integer actualParkingPlaceID = sysCardiovascularExamination.getParkingPlaceID();
        String actualPericardialRub = sysCardiovascularExamination.getPericardialRub();
        String actualProcessed = sysCardiovascularExamination.getProcessed();
        Integer actualProviderServiceMapID = sysCardiovascularExamination.getProviderServiceMapID();
        String actualReservedForChange = sysCardiovascularExamination.getReservedForChange();
        String actualSecondHeartSound_S2 = sysCardiovascularExamination.getSecondHeartSound_S2();
        String actualSyncedBy = sysCardiovascularExamination.getSyncedBy();
        Timestamp actualSyncedDate = sysCardiovascularExamination.getSyncedDate();
        Long actualVanSerialNo = sysCardiovascularExamination.getVanSerialNo();
        String actualVehicalNo = sysCardiovascularExamination.getVehicalNo();
        Long actualVisitCode = sysCardiovascularExamination.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Additional Heart Sounds", actualAdditionalHeartSounds);
        assertEquals("Apexbeat Location", actualApexbeatLocation);
        assertEquals("Apexbeat Type", actualApexbeatType);
        assertEquals("First Heart Sound S1", actualFirstHeartSound_S1);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Jugular Venous Pulse JVP", actualJugularVenousPulse_JVP);
        assertEquals("Murmurs", actualMurmurs);
        assertEquals("Pericardial Rub", actualPericardialRub);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Second Heart Sound S2", actualSecondHeartSound_S2);
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
