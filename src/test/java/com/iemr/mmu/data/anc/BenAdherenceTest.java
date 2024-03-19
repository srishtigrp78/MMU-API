package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class BenAdherenceTest {
    
    @Test
    void testGetBenAdherences() {
        // Arrange, Act and Assert
        assertNull(BenAdherence.getBenAdherences(new ArrayList<>()));
    }

    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        BenAdherence actualBenAdherence = new BenAdherence();
        actualBenAdherence.setBenVisitID(1L);
        actualBenAdherence.setBeneficiaryRegID(1L);
        actualBenAdherence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenAdherence.setCreatedDate(createdDate);
        actualBenAdherence.setDeleted(true);
        actualBenAdherence.setDrugReason("Just cause");
        actualBenAdherence.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenAdherence.setLastModDate(lastModDate);
        actualBenAdherence.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenAdherence.setParkingPlaceID(1);
        actualBenAdherence.setProcessed("Processed");
        actualBenAdherence.setProgress("Progress");
        actualBenAdherence.setProviderServiceMapID(1);
        actualBenAdherence.setReferralReason("Just cause");
        actualBenAdherence.setReservedForChange("Reserved For Change");
        actualBenAdherence.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenAdherence.setSyncedDate(syncedDate);
        actualBenAdherence.setToDrugs(true);
        actualBenAdherence.setToReferral(true);
        actualBenAdherence.setVanSerialNo(1L);
        actualBenAdherence.setVehicalNo("Vehical No");
        actualBenAdherence.setVisitCode(1L);
        Long actualBenVisitID = actualBenAdherence.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenAdherence.getBeneficiaryRegID();
        String actualCreatedBy = actualBenAdherence.getCreatedBy();
        Timestamp actualCreatedDate = actualBenAdherence.getCreatedDate();
        Boolean actualDeleted = actualBenAdherence.getDeleted();
        String actualDrugReason = actualBenAdherence.getDrugReason();
        Long actualID = actualBenAdherence.getID();
        Timestamp actualLastModDate = actualBenAdherence.getLastModDate();
        String actualModifiedBy = actualBenAdherence.getModifiedBy();
        Integer actualParkingPlaceID = actualBenAdherence.getParkingPlaceID();
        String actualProcessed = actualBenAdherence.getProcessed();
        String actualProgress = actualBenAdherence.getProgress();
        Integer actualProviderServiceMapID = actualBenAdherence.getProviderServiceMapID();
        String actualReferralReason = actualBenAdherence.getReferralReason();
        String actualReservedForChange = actualBenAdherence.getReservedForChange();
        String actualSyncedBy = actualBenAdherence.getSyncedBy();
        Timestamp actualSyncedDate = actualBenAdherence.getSyncedDate();
        Boolean actualToDrugs = actualBenAdherence.getToDrugs();
        Boolean actualToReferral = actualBenAdherence.getToReferral();
        Long actualVanSerialNo = actualBenAdherence.getVanSerialNo();
        String actualVehicalNo = actualBenAdherence.getVehicalNo();
        Long actualVisitCode = actualBenAdherence.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Just cause", actualDrugReason);
        assertEquals("Just cause", actualReferralReason);
        assertEquals("Processed", actualProcessed);
        assertEquals("Progress", actualProgress);
        assertEquals("Reserved For Change", actualReservedForChange);
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
        assertTrue(actualToDrugs);
        assertTrue(actualToReferral);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        BenAdherence actualBenAdherence = new BenAdherence(1L, 1L, 1L, 1, 1L, true, "Just cause", true, "Just cause",
                "Progress");
        actualBenAdherence.setBenVisitID(1L);
        actualBenAdherence.setBeneficiaryRegID(1L);
        actualBenAdherence.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualBenAdherence.setCreatedDate(createdDate);
        actualBenAdherence.setDeleted(true);
        actualBenAdherence.setDrugReason("Just cause");
        actualBenAdherence.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualBenAdherence.setLastModDate(lastModDate);
        actualBenAdherence.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualBenAdherence.setParkingPlaceID(1);
        actualBenAdherence.setProcessed("Processed");
        actualBenAdherence.setProgress("Progress");
        actualBenAdherence.setProviderServiceMapID(1);
        actualBenAdherence.setReferralReason("Just cause");
        actualBenAdherence.setReservedForChange("Reserved For Change");
        actualBenAdherence.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualBenAdherence.setSyncedDate(syncedDate);
        actualBenAdherence.setToDrugs(true);
        actualBenAdherence.setToReferral(true);
        actualBenAdherence.setVanSerialNo(1L);
        actualBenAdherence.setVehicalNo("Vehical No");
        actualBenAdherence.setVisitCode(1L);
        Long actualBenVisitID = actualBenAdherence.getBenVisitID();
        Long actualBeneficiaryRegID = actualBenAdherence.getBeneficiaryRegID();
        String actualCreatedBy = actualBenAdherence.getCreatedBy();
        Timestamp actualCreatedDate = actualBenAdherence.getCreatedDate();
        Boolean actualDeleted = actualBenAdherence.getDeleted();
        String actualDrugReason = actualBenAdherence.getDrugReason();
        Long actualID = actualBenAdherence.getID();
        Timestamp actualLastModDate = actualBenAdherence.getLastModDate();
        String actualModifiedBy = actualBenAdherence.getModifiedBy();
        Integer actualParkingPlaceID = actualBenAdherence.getParkingPlaceID();
        String actualProcessed = actualBenAdherence.getProcessed();
        String actualProgress = actualBenAdherence.getProgress();
        Integer actualProviderServiceMapID = actualBenAdherence.getProviderServiceMapID();
        String actualReferralReason = actualBenAdherence.getReferralReason();
        String actualReservedForChange = actualBenAdherence.getReservedForChange();
        String actualSyncedBy = actualBenAdherence.getSyncedBy();
        Timestamp actualSyncedDate = actualBenAdherence.getSyncedDate();
        Boolean actualToDrugs = actualBenAdherence.getToDrugs();
        Boolean actualToReferral = actualBenAdherence.getToReferral();
        Long actualVanSerialNo = actualBenAdherence.getVanSerialNo();
        String actualVehicalNo = actualBenAdherence.getVehicalNo();
        Long actualVisitCode = actualBenAdherence.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Just cause", actualDrugReason);
        assertEquals("Just cause", actualReferralReason);
        assertEquals("Processed", actualProcessed);
        assertEquals("Progress", actualProgress);
        assertEquals("Reserved For Change", actualReservedForChange);
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
        assertTrue(actualToDrugs);
        assertTrue(actualToReferral);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }
}
