package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChildFeedingDetailsTest {
    @Test
    void testGetBenFeedingDetails() {
        // Arrange, Act and Assert
        assertNull(ChildFeedingDetails.getBenFeedingDetails(new ArrayList<>()));
    }

    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        ChildFeedingDetails actualChildFeedingDetails = new ChildFeedingDetails();
        actualChildFeedingDetails.setBenMotherID(1L);
        actualChildFeedingDetails.setBenVisitID(1L);
        actualChildFeedingDetails.setBeneficiaryRegID(1L);
        actualChildFeedingDetails.setChildID(1L);
        actualChildFeedingDetails.setCompFeedStartAge("Comp Feed Start Age");
        actualChildFeedingDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualChildFeedingDetails.setCreatedDate(createdDate);
        actualChildFeedingDetails.setDeleted(true);
        actualChildFeedingDetails.setFoodIntoleranceStatus("Food Intolerance Status");
        actualChildFeedingDetails.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualChildFeedingDetails.setLastModDate(lastModDate);
        actualChildFeedingDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualChildFeedingDetails.setNoOfCompFeedPerDay("No Of Comp Feed Per Day");
        actualChildFeedingDetails.setParkingPlaceID(1);
        actualChildFeedingDetails.setProcessed("Processed");
        actualChildFeedingDetails.setProviderServiceMapID(1);
        actualChildFeedingDetails.setReservedForChange("Reserved For Change");
        actualChildFeedingDetails.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualChildFeedingDetails.setSyncedDate(syncedDate);
        actualChildFeedingDetails.setTypeOfFeed("Type Of Feed");
        actualChildFeedingDetails.setTypeofFoodIntolerance("Typeof Food Intolerance");
        actualChildFeedingDetails.setVanSerialNo(1L);
        actualChildFeedingDetails.setVehicalNo("Vehical No");
        actualChildFeedingDetails.setVisitCode(1L);
        Long actualBenMotherID = actualChildFeedingDetails.getBenMotherID();
        Long actualBenVisitID = actualChildFeedingDetails.getBenVisitID();
        Long actualBeneficiaryRegID = actualChildFeedingDetails.getBeneficiaryRegID();
        Long actualChildID = actualChildFeedingDetails.getChildID();
        String actualCompFeedStartAge = actualChildFeedingDetails.getCompFeedStartAge();
        String actualCreatedBy = actualChildFeedingDetails.getCreatedBy();
        Timestamp actualCreatedDate = actualChildFeedingDetails.getCreatedDate();
        Boolean actualDeleted = actualChildFeedingDetails.getDeleted();
        String actualFoodIntoleranceStatus = actualChildFeedingDetails.getFoodIntoleranceStatus();
        Long actualID = actualChildFeedingDetails.getID();
        Timestamp actualLastModDate = actualChildFeedingDetails.getLastModDate();
        String actualModifiedBy = actualChildFeedingDetails.getModifiedBy();
        String actualNoOfCompFeedPerDay = actualChildFeedingDetails.getNoOfCompFeedPerDay();
        Integer actualParkingPlaceID = actualChildFeedingDetails.getParkingPlaceID();
        String actualProcessed = actualChildFeedingDetails.getProcessed();
        Integer actualProviderServiceMapID = actualChildFeedingDetails.getProviderServiceMapID();
        String actualReservedForChange = actualChildFeedingDetails.getReservedForChange();
        String actualSyncedBy = actualChildFeedingDetails.getSyncedBy();
        Timestamp actualSyncedDate = actualChildFeedingDetails.getSyncedDate();
        String actualTypeOfFeed = actualChildFeedingDetails.getTypeOfFeed();
        String actualTypeofFoodIntolerance = actualChildFeedingDetails.getTypeofFoodIntolerance();
        Long actualVanSerialNo = actualChildFeedingDetails.getVanSerialNo();
        String actualVehicalNo = actualChildFeedingDetails.getVehicalNo();
        Long actualVisitCode = actualChildFeedingDetails.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Comp Feed Start Age", actualCompFeedStartAge);
        assertEquals("Food Intolerance Status", actualFoodIntoleranceStatus);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("No Of Comp Feed Per Day", actualNoOfCompFeedPerDay);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Type Of Feed", actualTypeOfFeed);
        assertEquals("Typeof Food Intolerance", actualTypeofFoodIntolerance);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1L, actualBenMotherID.longValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualChildID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        ChildFeedingDetails actualChildFeedingDetails = new ChildFeedingDetails(1L, 1L, 1, 1L, 1L, "Type Of Feed",
                "Comp Feed Start Age", "No Of Comp Feed Per Day", "Food Intolerance Status", "Typeof Food Intolerance", 1L);
        actualChildFeedingDetails.setBenMotherID(1L);
        actualChildFeedingDetails.setBenVisitID(1L);
        actualChildFeedingDetails.setBeneficiaryRegID(1L);
        actualChildFeedingDetails.setChildID(1L);
        actualChildFeedingDetails.setCompFeedStartAge("Comp Feed Start Age");
        actualChildFeedingDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualChildFeedingDetails.setCreatedDate(createdDate);
        actualChildFeedingDetails.setDeleted(true);
        actualChildFeedingDetails.setFoodIntoleranceStatus("Food Intolerance Status");
        actualChildFeedingDetails.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualChildFeedingDetails.setLastModDate(lastModDate);
        actualChildFeedingDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualChildFeedingDetails.setNoOfCompFeedPerDay("No Of Comp Feed Per Day");
        actualChildFeedingDetails.setParkingPlaceID(1);
        actualChildFeedingDetails.setProcessed("Processed");
        actualChildFeedingDetails.setProviderServiceMapID(1);
        actualChildFeedingDetails.setReservedForChange("Reserved For Change");
        actualChildFeedingDetails.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualChildFeedingDetails.setSyncedDate(syncedDate);
        actualChildFeedingDetails.setTypeOfFeed("Type Of Feed");
        actualChildFeedingDetails.setTypeofFoodIntolerance("Typeof Food Intolerance");
        actualChildFeedingDetails.setVanSerialNo(1L);
        actualChildFeedingDetails.setVehicalNo("Vehical No");
        actualChildFeedingDetails.setVisitCode(1L);
        Long actualBenMotherID = actualChildFeedingDetails.getBenMotherID();
        Long actualBenVisitID = actualChildFeedingDetails.getBenVisitID();
        Long actualBeneficiaryRegID = actualChildFeedingDetails.getBeneficiaryRegID();
        Long actualChildID = actualChildFeedingDetails.getChildID();
        String actualCompFeedStartAge = actualChildFeedingDetails.getCompFeedStartAge();
        String actualCreatedBy = actualChildFeedingDetails.getCreatedBy();
        Timestamp actualCreatedDate = actualChildFeedingDetails.getCreatedDate();
        Boolean actualDeleted = actualChildFeedingDetails.getDeleted();
        String actualFoodIntoleranceStatus = actualChildFeedingDetails.getFoodIntoleranceStatus();
        Long actualID = actualChildFeedingDetails.getID();
        Timestamp actualLastModDate = actualChildFeedingDetails.getLastModDate();
        String actualModifiedBy = actualChildFeedingDetails.getModifiedBy();
        String actualNoOfCompFeedPerDay = actualChildFeedingDetails.getNoOfCompFeedPerDay();
        Integer actualParkingPlaceID = actualChildFeedingDetails.getParkingPlaceID();
        String actualProcessed = actualChildFeedingDetails.getProcessed();
        Integer actualProviderServiceMapID = actualChildFeedingDetails.getProviderServiceMapID();
        String actualReservedForChange = actualChildFeedingDetails.getReservedForChange();
        String actualSyncedBy = actualChildFeedingDetails.getSyncedBy();
        Timestamp actualSyncedDate = actualChildFeedingDetails.getSyncedDate();
        String actualTypeOfFeed = actualChildFeedingDetails.getTypeOfFeed();
        String actualTypeofFoodIntolerance = actualChildFeedingDetails.getTypeofFoodIntolerance();
        Long actualVanSerialNo = actualChildFeedingDetails.getVanSerialNo();
        String actualVehicalNo = actualChildFeedingDetails.getVehicalNo();
        Long actualVisitCode = actualChildFeedingDetails.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Comp Feed Start Age", actualCompFeedStartAge);
        assertEquals("Food Intolerance Status", actualFoodIntoleranceStatus);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("No Of Comp Feed Per Day", actualNoOfCompFeedPerDay);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Type Of Feed", actualTypeOfFeed);
        assertEquals("Typeof Food Intolerance", actualTypeofFoodIntolerance);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1L, actualBenMotherID.longValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualChildID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters3() {
        // Arrange and Act
        ChildFeedingDetails actualChildFeedingDetails = new ChildFeedingDetails(mock(Date.class), 1L, 1L, "Type Of Feed",
                "Comp Feed Start Age", "No Of Comp Feed Per Day", "Food Intolerance Status", "Typeof Food Intolerance");
        actualChildFeedingDetails.setBenMotherID(1L);
        actualChildFeedingDetails.setBenVisitID(1L);
        actualChildFeedingDetails.setBeneficiaryRegID(1L);
        actualChildFeedingDetails.setChildID(1L);
        actualChildFeedingDetails.setCompFeedStartAge("Comp Feed Start Age");
        actualChildFeedingDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualChildFeedingDetails.setCreatedDate(createdDate);
        actualChildFeedingDetails.setDeleted(true);
        actualChildFeedingDetails.setFoodIntoleranceStatus("Food Intolerance Status");
        actualChildFeedingDetails.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualChildFeedingDetails.setLastModDate(lastModDate);
        actualChildFeedingDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualChildFeedingDetails.setNoOfCompFeedPerDay("No Of Comp Feed Per Day");
        actualChildFeedingDetails.setParkingPlaceID(1);
        actualChildFeedingDetails.setProcessed("Processed");
        actualChildFeedingDetails.setProviderServiceMapID(1);
        actualChildFeedingDetails.setReservedForChange("Reserved For Change");
        actualChildFeedingDetails.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualChildFeedingDetails.setSyncedDate(syncedDate);
        actualChildFeedingDetails.setTypeOfFeed("Type Of Feed");
        actualChildFeedingDetails.setTypeofFoodIntolerance("Typeof Food Intolerance");
        actualChildFeedingDetails.setVanSerialNo(1L);
        actualChildFeedingDetails.setVehicalNo("Vehical No");
        actualChildFeedingDetails.setVisitCode(1L);
        Long actualBenMotherID = actualChildFeedingDetails.getBenMotherID();
        Long actualBenVisitID = actualChildFeedingDetails.getBenVisitID();
        Long actualBeneficiaryRegID = actualChildFeedingDetails.getBeneficiaryRegID();
        Long actualChildID = actualChildFeedingDetails.getChildID();
        String actualCompFeedStartAge = actualChildFeedingDetails.getCompFeedStartAge();
        String actualCreatedBy = actualChildFeedingDetails.getCreatedBy();
        Timestamp actualCreatedDate = actualChildFeedingDetails.getCreatedDate();
        Boolean actualDeleted = actualChildFeedingDetails.getDeleted();
        String actualFoodIntoleranceStatus = actualChildFeedingDetails.getFoodIntoleranceStatus();
        Long actualID = actualChildFeedingDetails.getID();
        Timestamp actualLastModDate = actualChildFeedingDetails.getLastModDate();
        String actualModifiedBy = actualChildFeedingDetails.getModifiedBy();
        String actualNoOfCompFeedPerDay = actualChildFeedingDetails.getNoOfCompFeedPerDay();
        Integer actualParkingPlaceID = actualChildFeedingDetails.getParkingPlaceID();
        String actualProcessed = actualChildFeedingDetails.getProcessed();
        Integer actualProviderServiceMapID = actualChildFeedingDetails.getProviderServiceMapID();
        String actualReservedForChange = actualChildFeedingDetails.getReservedForChange();
        String actualSyncedBy = actualChildFeedingDetails.getSyncedBy();
        Timestamp actualSyncedDate = actualChildFeedingDetails.getSyncedDate();
        String actualTypeOfFeed = actualChildFeedingDetails.getTypeOfFeed();
        String actualTypeofFoodIntolerance = actualChildFeedingDetails.getTypeofFoodIntolerance();
        Long actualVanSerialNo = actualChildFeedingDetails.getVanSerialNo();
        String actualVehicalNo = actualChildFeedingDetails.getVehicalNo();
        Long actualVisitCode = actualChildFeedingDetails.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Comp Feed Start Age", actualCompFeedStartAge);
        assertEquals("Food Intolerance Status", actualFoodIntoleranceStatus);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("No Of Comp Feed Per Day", actualNoOfCompFeedPerDay);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Type Of Feed", actualTypeOfFeed);
        assertEquals("Typeof Food Intolerance", actualTypeofFoodIntolerance);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1L, actualBenMotherID.longValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualChildID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualDeleted);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }
}
