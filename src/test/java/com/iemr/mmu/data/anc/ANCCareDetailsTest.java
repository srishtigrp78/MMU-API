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
class ANCCareDetailsTest {
    
    @Test
    void testGetANCCareDetails() {
        assertNull(ANCCareDetails.getANCCareDetails(new ArrayList<>()));
    }

    
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        ANCCareDetails actualAncCareDetails = new ANCCareDetails();
        actualAncCareDetails.setAbortions_A((short) 1);
        actualAncCareDetails.setBenVisitID(1L);
        actualAncCareDetails.setBeneficiaryRegID(1L);
        actualAncCareDetails.setBloodGroup("Blood Group");
        actualAncCareDetails.setComolaintType("Comolaint Type");
        actualAncCareDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualAncCareDetails.setCreatedDate(createdDate);
        actualAncCareDetails.setDeleted(true);
        actualAncCareDetails.setDescription("The characteristics of someone or something");
        actualAncCareDetails.setDuration("Duration");
        actualAncCareDetails.setExpDelDt("Exp Del Dt");
        Date expectedDateofDelivery = mock(Date.class);
        actualAncCareDetails.setExpectedDateofDelivery(expectedDateofDelivery);
        actualAncCareDetails.setGestationalAgeOrPeriodofAmenorrhea_POA((short) 1);
        actualAncCareDetails.setGravida_G((short) 1);
        actualAncCareDetails.setID(1L);
        Date lastMenstrualPeriod_LMP = mock(Date.class);
        actualAncCareDetails.setLastMenstrualPeriod_LMP(lastMenstrualPeriod_LMP);
        Timestamp lastModDate = mock(Timestamp.class);
        actualAncCareDetails.setLastModDate(lastModDate);
        actualAncCareDetails.setLivebirths_L((short) 1);
        actualAncCareDetails.setLmpDate("2020-03-01");
        actualAncCareDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualAncCareDetails.setParkingPlaceID(1);
        actualAncCareDetails.setPretermDeliveries_P((short) 1);
        actualAncCareDetails.setPrimiGravida(true);
        actualAncCareDetails.setProcessed("Processed");
        actualAncCareDetails.setProviderServiceMapID(1);
        actualAncCareDetails.setReservedForChange("Reserved For Change");
        actualAncCareDetails.setStillBirth(1);
        actualAncCareDetails.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualAncCareDetails.setSyncedDate(syncedDate);
        actualAncCareDetails.setTermDeliveries_T((short) 1);
        actualAncCareDetails.setTrimesterNumber((short) 1);
        actualAncCareDetails.setVanID(1);
        actualAncCareDetails.setVanSerialNo(1L);
        actualAncCareDetails.setVehicalNo("Vehical No");
        actualAncCareDetails.setVisitCode(1L);
        actualAncCareDetails.setVisitNo((short) 1);
        Short actualAbortions_A = actualAncCareDetails.getAbortions_A();
        Long actualBenVisitID = actualAncCareDetails.getBenVisitID();
        Long actualBeneficiaryRegID = actualAncCareDetails.getBeneficiaryRegID();
        String actualBloodGroup = actualAncCareDetails.getBloodGroup();
        String actualComolaintType = actualAncCareDetails.getComolaintType();
        String actualCreatedBy = actualAncCareDetails.getCreatedBy();
        Timestamp actualCreatedDate = actualAncCareDetails.getCreatedDate();
        Boolean actualDeleted = actualAncCareDetails.getDeleted();
        String actualDescription = actualAncCareDetails.getDescription();
        String actualDuration = actualAncCareDetails.getDuration();
        String actualExpDelDt = actualAncCareDetails.getExpDelDt();
        Date actualExpectedDateofDelivery = actualAncCareDetails.getExpectedDateofDelivery();
        Short actualGestationalAgeOrPeriodofAmenorrhea_POA = actualAncCareDetails
                .getGestationalAgeOrPeriodofAmenorrhea_POA();
        Short actualGravida_G = actualAncCareDetails.getGravida_G();
        Long actualID = actualAncCareDetails.getID();
        Date actualLastMenstrualPeriod_LMP = actualAncCareDetails.getLastMenstrualPeriod_LMP();
        Timestamp actualLastModDate = actualAncCareDetails.getLastModDate();
        Short actualLivebirths_L = actualAncCareDetails.getLivebirths_L();
        String actualLmpDate = actualAncCareDetails.getLmpDate();
        String actualModifiedBy = actualAncCareDetails.getModifiedBy();
        Integer actualParkingPlaceID = actualAncCareDetails.getParkingPlaceID();
        Short actualPretermDeliveries_P = actualAncCareDetails.getPretermDeliveries_P();
        Boolean actualPrimiGravida = actualAncCareDetails.getPrimiGravida();
        String actualProcessed = actualAncCareDetails.getProcessed();
        Integer actualProviderServiceMapID = actualAncCareDetails.getProviderServiceMapID();
        String actualReservedForChange = actualAncCareDetails.getReservedForChange();
        Integer actualStillBirth = actualAncCareDetails.getStillBirth();
        String actualSyncedBy = actualAncCareDetails.getSyncedBy();
        Timestamp actualSyncedDate = actualAncCareDetails.getSyncedDate();
        Short actualTermDeliveries_T = actualAncCareDetails.getTermDeliveries_T();
        Short actualTrimesterNumber = actualAncCareDetails.getTrimesterNumber();
        Integer actualVanID = actualAncCareDetails.getVanID();
        Long actualVanSerialNo = actualAncCareDetails.getVanSerialNo();
        String actualVehicalNo = actualAncCareDetails.getVehicalNo();
        Long actualVisitCode = actualAncCareDetails.getVisitCode();
        Short actualVisitNo = actualAncCareDetails.getVisitNo();

        assertEquals("2020-03-01", actualLmpDate);
        assertEquals("Blood Group", actualBloodGroup);
        assertEquals("Comolaint Type", actualComolaintType);
        assertEquals("Duration", actualDuration);
        assertEquals("Exp Del Dt", actualExpDelDt);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualStillBirth.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualAbortions_A.shortValue());
        assertEquals((short) 1, actualGestationalAgeOrPeriodofAmenorrhea_POA.shortValue());
        assertEquals((short) 1, actualGravida_G.shortValue());
        assertEquals((short) 1, actualLivebirths_L.shortValue());
        assertEquals((short) 1, actualPretermDeliveries_P.shortValue());
        assertEquals((short) 1, actualTermDeliveries_T.shortValue());
        assertEquals((short) 1, actualTrimesterNumber.shortValue());
        assertEquals((short) 1, actualVisitNo.shortValue());
        assertTrue(actualDeleted);
        assertTrue(actualPrimiGravida);
        assertSame(expectedDateofDelivery, actualExpectedDateofDelivery);
        assertSame(lastMenstrualPeriod_LMP, actualLastMenstrualPeriod_LMP);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }

   
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        ANCCareDetails actualAncCareDetails = new ANCCareDetails(1L, 1L, 1L, 1, 1L, (short) 1, "Comolaint Type", "Duration",
                "The characteristics of someone or something", mock(Date.class), (short) 1, (short) 1, mock(Date.class), true,
                (short) 1, (short) 1, (short) 1, (short) 1, (short) 1, "Blood Group", 1);
        actualAncCareDetails.setAbortions_A((short) 1);
        actualAncCareDetails.setBenVisitID(1L);
        actualAncCareDetails.setBeneficiaryRegID(1L);
        actualAncCareDetails.setBloodGroup("Blood Group");
        actualAncCareDetails.setComolaintType("Comolaint Type");
        actualAncCareDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        actualAncCareDetails.setCreatedDate(createdDate);
        actualAncCareDetails.setDeleted(true);
        actualAncCareDetails.setDescription("The characteristics of someone or something");
        actualAncCareDetails.setDuration("Duration");
        actualAncCareDetails.setExpDelDt("Exp Del Dt");
        Date expectedDateofDelivery = mock(Date.class);
        actualAncCareDetails.setExpectedDateofDelivery(expectedDateofDelivery);
        actualAncCareDetails.setGestationalAgeOrPeriodofAmenorrhea_POA((short) 1);
        actualAncCareDetails.setGravida_G((short) 1);
        actualAncCareDetails.setID(1L);
        Date lastMenstrualPeriod_LMP = mock(Date.class);
        actualAncCareDetails.setLastMenstrualPeriod_LMP(lastMenstrualPeriod_LMP);
        Timestamp lastModDate = mock(Timestamp.class);
        actualAncCareDetails.setLastModDate(lastModDate);
        actualAncCareDetails.setLivebirths_L((short) 1);
        actualAncCareDetails.setLmpDate("2020-03-01");
        actualAncCareDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualAncCareDetails.setParkingPlaceID(1);
        actualAncCareDetails.setPretermDeliveries_P((short) 1);
        actualAncCareDetails.setPrimiGravida(true);
        actualAncCareDetails.setProcessed("Processed");
        actualAncCareDetails.setProviderServiceMapID(1);
        actualAncCareDetails.setReservedForChange("Reserved For Change");
        actualAncCareDetails.setStillBirth(1);
        actualAncCareDetails.setSyncedBy("Synced By");
        Timestamp syncedDate = mock(Timestamp.class);
        actualAncCareDetails.setSyncedDate(syncedDate);
        actualAncCareDetails.setTermDeliveries_T((short) 1);
        actualAncCareDetails.setTrimesterNumber((short) 1);
        actualAncCareDetails.setVanID(1);
        actualAncCareDetails.setVanSerialNo(1L);
        actualAncCareDetails.setVehicalNo("Vehical No");
        actualAncCareDetails.setVisitCode(1L);
        actualAncCareDetails.setVisitNo((short) 1);
        Short actualAbortions_A = actualAncCareDetails.getAbortions_A();
        Long actualBenVisitID = actualAncCareDetails.getBenVisitID();
        Long actualBeneficiaryRegID = actualAncCareDetails.getBeneficiaryRegID();
        String actualBloodGroup = actualAncCareDetails.getBloodGroup();
        String actualComolaintType = actualAncCareDetails.getComolaintType();
        String actualCreatedBy = actualAncCareDetails.getCreatedBy();
        Timestamp actualCreatedDate = actualAncCareDetails.getCreatedDate();
        Boolean actualDeleted = actualAncCareDetails.getDeleted();
        String actualDescription = actualAncCareDetails.getDescription();
        String actualDuration = actualAncCareDetails.getDuration();
        String actualExpDelDt = actualAncCareDetails.getExpDelDt();
        Date actualExpectedDateofDelivery = actualAncCareDetails.getExpectedDateofDelivery();
        Short actualGestationalAgeOrPeriodofAmenorrhea_POA = actualAncCareDetails
                .getGestationalAgeOrPeriodofAmenorrhea_POA();
        Short actualGravida_G = actualAncCareDetails.getGravida_G();
        Long actualID = actualAncCareDetails.getID();
        Date actualLastMenstrualPeriod_LMP = actualAncCareDetails.getLastMenstrualPeriod_LMP();
        Timestamp actualLastModDate = actualAncCareDetails.getLastModDate();
        Short actualLivebirths_L = actualAncCareDetails.getLivebirths_L();
        String actualLmpDate = actualAncCareDetails.getLmpDate();
        String actualModifiedBy = actualAncCareDetails.getModifiedBy();
        Integer actualParkingPlaceID = actualAncCareDetails.getParkingPlaceID();
        Short actualPretermDeliveries_P = actualAncCareDetails.getPretermDeliveries_P();
        Boolean actualPrimiGravida = actualAncCareDetails.getPrimiGravida();
        String actualProcessed = actualAncCareDetails.getProcessed();
        Integer actualProviderServiceMapID = actualAncCareDetails.getProviderServiceMapID();
        String actualReservedForChange = actualAncCareDetails.getReservedForChange();
        Integer actualStillBirth = actualAncCareDetails.getStillBirth();
        String actualSyncedBy = actualAncCareDetails.getSyncedBy();
        Timestamp actualSyncedDate = actualAncCareDetails.getSyncedDate();
        Short actualTermDeliveries_T = actualAncCareDetails.getTermDeliveries_T();
        Short actualTrimesterNumber = actualAncCareDetails.getTrimesterNumber();
        Integer actualVanID = actualAncCareDetails.getVanID();
        Long actualVanSerialNo = actualAncCareDetails.getVanSerialNo();
        String actualVehicalNo = actualAncCareDetails.getVehicalNo();
        Long actualVisitCode = actualAncCareDetails.getVisitCode();
        Short actualVisitNo = actualAncCareDetails.getVisitNo();

        // Assert that nothing has changed
        assertEquals("2020-03-01", actualLmpDate);
        assertEquals("Blood Group", actualBloodGroup);
        assertEquals("Comolaint Type", actualComolaintType);
        assertEquals("Duration", actualDuration);
        assertEquals("Exp Del Dt", actualExpDelDt);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Reserved For Change", actualReservedForChange);
        assertEquals("Synced By", actualSyncedBy);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals("Vehical No", actualVehicalNo);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualStillBirth.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualAbortions_A.shortValue());
        assertEquals((short) 1, actualGestationalAgeOrPeriodofAmenorrhea_POA.shortValue());
        assertEquals((short) 1, actualGravida_G.shortValue());
        assertEquals((short) 1, actualLivebirths_L.shortValue());
        assertEquals((short) 1, actualPretermDeliveries_P.shortValue());
        assertEquals((short) 1, actualTermDeliveries_T.shortValue());
        assertEquals((short) 1, actualTrimesterNumber.shortValue());
        assertEquals((short) 1, actualVisitNo.shortValue());
        assertTrue(actualDeleted);
        assertTrue(actualPrimiGravida);
        assertSame(expectedDateofDelivery, actualExpectedDateofDelivery);
        assertSame(lastMenstrualPeriod_LMP, actualLastMenstrualPeriod_LMP);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
        assertSame(syncedDate, actualSyncedDate);
    }
}
