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
class PerinatalHistoryTest {
    
    @Test
    void testGetBenPerinatalDetails() {
        // Arrange, Act and Assert
        assertNull(PerinatalHistory.getBenPerinatalDetails(new ArrayList<>()));
    }

    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        PerinatalHistory actualPerinatalHistory = new PerinatalHistory();
        actualPerinatalHistory.setBenVisitID(1L);
        actualPerinatalHistory.setBeneficiaryRegID(1L);
        actualPerinatalHistory.setBirthWeight_kg(10.0d);
        actualPerinatalHistory.setComplicationAtBirth("Complication At Birth");
        actualPerinatalHistory.setComplicationAtBirthID((short) 1);
        actualPerinatalHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualPerinatalHistory.setCreatedDate(createdDate);
        actualPerinatalHistory.setDeleted(true);
        actualPerinatalHistory.setDeliveryPlaceID((short) 1);
        actualPerinatalHistory.setDeliveryTypeID((short) 1);
        actualPerinatalHistory.setGestation("Gestation");
        actualPerinatalHistory.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualPerinatalHistory.setLastModDate(lastModDate);
        actualPerinatalHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualPerinatalHistory.setOtherComplicationAtBirth("Other Complication At Birth");
        actualPerinatalHistory.setOtherPlaceOfDelivery("Other Place Of Delivery");
        actualPerinatalHistory.setParkingPlaceID(1);
        actualPerinatalHistory.setPlaceOfDelivery("Place Of Delivery");
        actualPerinatalHistory.setProcessed("Processed");
        actualPerinatalHistory.setProviderServiceMapID(1);
        actualPerinatalHistory.setReservedForChange("Reserved For Change");
        actualPerinatalHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualPerinatalHistory.setSyncedDate(syncedDate);
        actualPerinatalHistory.setTypeOfDelivery("Type Of Delivery");
        actualPerinatalHistory.setVanSerialNo(1L);
        actualPerinatalHistory.setVehicalNo("Vehical No");
        actualPerinatalHistory.setVisitCode(1L);
        Long actualBenVisitID = actualPerinatalHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualPerinatalHistory.getBeneficiaryRegID();
        Double actualBirthWeight_kg = actualPerinatalHistory.getBirthWeight_kg();
        String actualComplicationAtBirth = actualPerinatalHistory.getComplicationAtBirth();
        Short actualComplicationAtBirthID = actualPerinatalHistory.getComplicationAtBirthID();
        String actualCreatedBy = actualPerinatalHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualPerinatalHistory.getCreatedDate();
        Boolean actualDeleted = actualPerinatalHistory.getDeleted();
        Short actualDeliveryPlaceID = actualPerinatalHistory.getDeliveryPlaceID();
        Short actualDeliveryTypeID = actualPerinatalHistory.getDeliveryTypeID();
        String actualGestation = actualPerinatalHistory.getGestation();
        Long actualID = actualPerinatalHistory.getID();
        Timestamp actualLastModDate = actualPerinatalHistory.getLastModDate();
        String actualModifiedBy = actualPerinatalHistory.getModifiedBy();
        String actualOtherComplicationAtBirth = actualPerinatalHistory.getOtherComplicationAtBirth();
        String actualOtherPlaceOfDelivery = actualPerinatalHistory.getOtherPlaceOfDelivery();
        Integer actualParkingPlaceID = actualPerinatalHistory.getParkingPlaceID();
        String actualPlaceOfDelivery = actualPerinatalHistory.getPlaceOfDelivery();
        String actualProcessed = actualPerinatalHistory.getProcessed();
        Integer actualProviderServiceMapID = actualPerinatalHistory.getProviderServiceMapID();
        String actualReservedForChange = actualPerinatalHistory.getReservedForChange();
        String actualSyncedBy = actualPerinatalHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualPerinatalHistory.getSyncedDate();
        String actualTypeOfDelivery = actualPerinatalHistory.getTypeOfDelivery();
        Long actualVanSerialNo = actualPerinatalHistory.getVanSerialNo();
        String actualVehicalNo = actualPerinatalHistory.getVehicalNo();
        Long actualVisitCode = actualPerinatalHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Complication At Birth", actualComplicationAtBirth);
        assertEquals("Gestation", actualGestation);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Complication At Birth", actualOtherComplicationAtBirth);
        assertEquals("Other Place Of Delivery", actualOtherPlaceOfDelivery);
        assertEquals("Place Of Delivery", actualPlaceOfDelivery);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Type Of Delivery", actualTypeOfDelivery);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(10.0d, actualBirthWeight_kg.doubleValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualComplicationAtBirthID.shortValue());
        assertEquals((short) 1, actualDeliveryPlaceID.shortValue());
        assertEquals((short) 1, actualDeliveryTypeID.shortValue());
        assertTrue(actualDeleted);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        PerinatalHistory actualPerinatalHistory = new PerinatalHistory(1L, 1L, 1, (short) 1, "Place Of Delivery",
                "Other Place Of Delivery", (short) 1, "Type Of Delivery", (short) 1, "Complication At Birth",
                "Other Complication At Birth", "Gestation", 10.0d, 1L);
        actualPerinatalHistory.setBenVisitID(1L);
        actualPerinatalHistory.setBeneficiaryRegID(1L);
        actualPerinatalHistory.setBirthWeight_kg(10.0d);
        actualPerinatalHistory.setComplicationAtBirth("Complication At Birth");
        actualPerinatalHistory.setComplicationAtBirthID((short) 1);
        actualPerinatalHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualPerinatalHistory.setCreatedDate(createdDate);
        actualPerinatalHistory.setDeleted(true);
        actualPerinatalHistory.setDeliveryPlaceID((short) 1);
        actualPerinatalHistory.setDeliveryTypeID((short) 1);
        actualPerinatalHistory.setGestation("Gestation");
        actualPerinatalHistory.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualPerinatalHistory.setLastModDate(lastModDate);
        actualPerinatalHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualPerinatalHistory.setOtherComplicationAtBirth("Other Complication At Birth");
        actualPerinatalHistory.setOtherPlaceOfDelivery("Other Place Of Delivery");
        actualPerinatalHistory.setParkingPlaceID(1);
        actualPerinatalHistory.setPlaceOfDelivery("Place Of Delivery");
        actualPerinatalHistory.setProcessed("Processed");
        actualPerinatalHistory.setProviderServiceMapID(1);
        actualPerinatalHistory.setReservedForChange("Reserved For Change");
        actualPerinatalHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualPerinatalHistory.setSyncedDate(syncedDate);
        actualPerinatalHistory.setTypeOfDelivery("Type Of Delivery");
        actualPerinatalHistory.setVanSerialNo(1L);
        actualPerinatalHistory.setVehicalNo("Vehical No");
        actualPerinatalHistory.setVisitCode(1L);
        Long actualBenVisitID = actualPerinatalHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualPerinatalHistory.getBeneficiaryRegID();
        Double actualBirthWeight_kg = actualPerinatalHistory.getBirthWeight_kg();
        String actualComplicationAtBirth = actualPerinatalHistory.getComplicationAtBirth();
        Short actualComplicationAtBirthID = actualPerinatalHistory.getComplicationAtBirthID();
        String actualCreatedBy = actualPerinatalHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualPerinatalHistory.getCreatedDate();
        Boolean actualDeleted = actualPerinatalHistory.getDeleted();
        Short actualDeliveryPlaceID = actualPerinatalHistory.getDeliveryPlaceID();
        Short actualDeliveryTypeID = actualPerinatalHistory.getDeliveryTypeID();
        String actualGestation = actualPerinatalHistory.getGestation();
        Long actualID = actualPerinatalHistory.getID();
        Timestamp actualLastModDate = actualPerinatalHistory.getLastModDate();
        String actualModifiedBy = actualPerinatalHistory.getModifiedBy();
        String actualOtherComplicationAtBirth = actualPerinatalHistory.getOtherComplicationAtBirth();
        String actualOtherPlaceOfDelivery = actualPerinatalHistory.getOtherPlaceOfDelivery();
        Integer actualParkingPlaceID = actualPerinatalHistory.getParkingPlaceID();
        String actualPlaceOfDelivery = actualPerinatalHistory.getPlaceOfDelivery();
        String actualProcessed = actualPerinatalHistory.getProcessed();
        Integer actualProviderServiceMapID = actualPerinatalHistory.getProviderServiceMapID();
        String actualReservedForChange = actualPerinatalHistory.getReservedForChange();
        String actualSyncedBy = actualPerinatalHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualPerinatalHistory.getSyncedDate();
        String actualTypeOfDelivery = actualPerinatalHistory.getTypeOfDelivery();
        Long actualVanSerialNo = actualPerinatalHistory.getVanSerialNo();
        String actualVehicalNo = actualPerinatalHistory.getVehicalNo();
        Long actualVisitCode = actualPerinatalHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Complication At Birth", actualComplicationAtBirth);
        assertEquals("Gestation", actualGestation);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Complication At Birth", actualOtherComplicationAtBirth);
        assertEquals("Other Place Of Delivery", actualOtherPlaceOfDelivery);
        assertEquals("Place Of Delivery", actualPlaceOfDelivery);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Type Of Delivery", actualTypeOfDelivery);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(10.0d, actualBirthWeight_kg.doubleValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualComplicationAtBirthID.shortValue());
        assertEquals((short) 1, actualDeliveryPlaceID.shortValue());
        assertEquals((short) 1, actualDeliveryTypeID.shortValue());
        assertTrue(actualDeleted);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

    @Test
    void testGettersAndSetters3() {
        // Arrange and Act
        PerinatalHistory actualPerinatalHistory = new PerinatalHistory(mock(Date.class), "Place Of Delivery",
                "Other Place Of Delivery", "Type Of Delivery", "Complication At Birth", "Other Complication At Birth",
                "Gestation", 10.0d);
        actualPerinatalHistory.setBenVisitID(1L);
        actualPerinatalHistory.setBeneficiaryRegID(1L);
        actualPerinatalHistory.setBirthWeight_kg(10.0d);
        actualPerinatalHistory.setComplicationAtBirth("Complication At Birth");
        actualPerinatalHistory.setComplicationAtBirthID((short) 1);
        actualPerinatalHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualPerinatalHistory.setCreatedDate(createdDate);
        actualPerinatalHistory.setDeleted(true);
        actualPerinatalHistory.setDeliveryPlaceID((short) 1);
        actualPerinatalHistory.setDeliveryTypeID((short) 1);
        actualPerinatalHistory.setGestation("Gestation");
        actualPerinatalHistory.setID(1L);
        Timestamp lastModDate = mock(Timestamp.class);
        actualPerinatalHistory.setLastModDate(lastModDate);
        actualPerinatalHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualPerinatalHistory.setOtherComplicationAtBirth("Other Complication At Birth");
        actualPerinatalHistory.setOtherPlaceOfDelivery("Other Place Of Delivery");
        actualPerinatalHistory.setParkingPlaceID(1);
        actualPerinatalHistory.setPlaceOfDelivery("Place Of Delivery");
        actualPerinatalHistory.setProcessed("Processed");
        actualPerinatalHistory.setProviderServiceMapID(1);
        actualPerinatalHistory.setReservedForChange("Reserved For Change");
        actualPerinatalHistory.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualPerinatalHistory.setSyncedDate(syncedDate);
        actualPerinatalHistory.setTypeOfDelivery("Type Of Delivery");
        actualPerinatalHistory.setVanSerialNo(1L);
        actualPerinatalHistory.setVehicalNo("Vehical No");
        actualPerinatalHistory.setVisitCode(1L);
        Long actualBenVisitID = actualPerinatalHistory.getBenVisitID();
        Long actualBeneficiaryRegID = actualPerinatalHistory.getBeneficiaryRegID();
        Double actualBirthWeight_kg = actualPerinatalHistory.getBirthWeight_kg();
        String actualComplicationAtBirth = actualPerinatalHistory.getComplicationAtBirth();
        Short actualComplicationAtBirthID = actualPerinatalHistory.getComplicationAtBirthID();
        String actualCreatedBy = actualPerinatalHistory.getCreatedBy();
        Timestamp actualCreatedDate = actualPerinatalHistory.getCreatedDate();
        Boolean actualDeleted = actualPerinatalHistory.getDeleted();
        Short actualDeliveryPlaceID = actualPerinatalHistory.getDeliveryPlaceID();
        Short actualDeliveryTypeID = actualPerinatalHistory.getDeliveryTypeID();
        String actualGestation = actualPerinatalHistory.getGestation();
        Long actualID = actualPerinatalHistory.getID();
        Timestamp actualLastModDate = actualPerinatalHistory.getLastModDate();
        String actualModifiedBy = actualPerinatalHistory.getModifiedBy();
        String actualOtherComplicationAtBirth = actualPerinatalHistory.getOtherComplicationAtBirth();
        String actualOtherPlaceOfDelivery = actualPerinatalHistory.getOtherPlaceOfDelivery();
        Integer actualParkingPlaceID = actualPerinatalHistory.getParkingPlaceID();
        String actualPlaceOfDelivery = actualPerinatalHistory.getPlaceOfDelivery();
        String actualProcessed = actualPerinatalHistory.getProcessed();
        Integer actualProviderServiceMapID = actualPerinatalHistory.getProviderServiceMapID();
        String actualReservedForChange = actualPerinatalHistory.getReservedForChange();
        String actualSyncedBy = actualPerinatalHistory.getSyncedBy();
        Timestamp actualSyncedDate = actualPerinatalHistory.getSyncedDate();
        String actualTypeOfDelivery = actualPerinatalHistory.getTypeOfDelivery();
        Long actualVanSerialNo = actualPerinatalHistory.getVanSerialNo();
        String actualVehicalNo = actualPerinatalHistory.getVehicalNo();
        Long actualVisitCode = actualPerinatalHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Complication At Birth", actualComplicationAtBirth);
        assertEquals("Gestation", actualGestation);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Complication At Birth", actualOtherComplicationAtBirth);
        assertEquals("Other Place Of Delivery", actualOtherPlaceOfDelivery);
        assertEquals("Place Of Delivery", actualPlaceOfDelivery);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("Type Of Delivery", actualTypeOfDelivery);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(10.0d, actualBirthWeight_kg.doubleValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualComplicationAtBirthID.shortValue());
        assertEquals((short) 1, actualDeliveryPlaceID.shortValue());
        assertEquals((short) 1, actualDeliveryTypeID.shortValue());
        assertTrue(actualDeleted);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }
}
