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
class SysGenitourinarySystemExaminationTest {
    
    @Test
    void testGettersAndSetters() {
        // Arrange
        SysGenitourinarySystemExamination sysGenitourinarySystemExamination = new SysGenitourinarySystemExamination();

        // Act
        sysGenitourinarySystemExamination.setBenVisitID(1L);
        sysGenitourinarySystemExamination.setBeneficiaryRegID(1L);
        sysGenitourinarySystemExamination.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        sysGenitourinarySystemExamination.setCreatedDate(createdDate);
        sysGenitourinarySystemExamination.setDeleted(true);
        sysGenitourinarySystemExamination.setExternalGenitalia("External Genitalia");
        sysGenitourinarySystemExamination.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        sysGenitourinarySystemExamination.setLastModDate(lastModDate);
        sysGenitourinarySystemExamination.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        sysGenitourinarySystemExamination.setParkingPlaceID(1);
        sysGenitourinarySystemExamination.setProcessed("Processed");
        sysGenitourinarySystemExamination.setProviderServiceMapID(1);
        sysGenitourinarySystemExamination.setRenalAngle("Renal Angle");
        sysGenitourinarySystemExamination.setReservedForChange("Reserved For Change");
        sysGenitourinarySystemExamination.setSuprapubicRegion("us-east-2");
        sysGenitourinarySystemExamination.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        sysGenitourinarySystemExamination.setSyncedDate(syncedDate);
        sysGenitourinarySystemExamination.setVanSerialNo(1L);
        sysGenitourinarySystemExamination.setVehicalNo("Vehical No");
        sysGenitourinarySystemExamination.setVisitCode(1L);
        Long actualBenVisitID = sysGenitourinarySystemExamination.getBenVisitID();
        Long actualBeneficiaryRegID = sysGenitourinarySystemExamination.getBeneficiaryRegID();
        String actualCreatedBy = sysGenitourinarySystemExamination.getCreatedBy();
        Timestamp actualCreatedDate = sysGenitourinarySystemExamination.getCreatedDate();
        Boolean actualDeleted = sysGenitourinarySystemExamination.getDeleted();
        String actualExternalGenitalia = sysGenitourinarySystemExamination.getExternalGenitalia();
        Long actualID = sysGenitourinarySystemExamination.getID();
        Timestamp actualLastModDate = sysGenitourinarySystemExamination.getLastModDate();
        String actualModifiedBy = sysGenitourinarySystemExamination.getModifiedBy();
        Integer actualParkingPlaceID = sysGenitourinarySystemExamination.getParkingPlaceID();
        String actualProcessed = sysGenitourinarySystemExamination.getProcessed();
        Integer actualProviderServiceMapID = sysGenitourinarySystemExamination.getProviderServiceMapID();
        String actualRenalAngle = sysGenitourinarySystemExamination.getRenalAngle();
        String actualReservedForChange = sysGenitourinarySystemExamination.getReservedForChange();
        String actualSuprapubicRegion = sysGenitourinarySystemExamination.getSuprapubicRegion();
        String actualSyncedBy = sysGenitourinarySystemExamination.getSyncedBy();
        Timestamp actualSyncedDate = sysGenitourinarySystemExamination.getSyncedDate();
        Long actualVanSerialNo = sysGenitourinarySystemExamination.getVanSerialNo();
        String actualVehicalNo = sysGenitourinarySystemExamination.getVehicalNo();
        Long actualVisitCode = sysGenitourinarySystemExamination.getVisitCode();

        // Assert that nothing has changed
        assertEquals("External Genitalia", actualExternalGenitalia);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Renal Angle", actualRenalAngle);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals("us-east-2", actualSuprapubicRegion);
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
