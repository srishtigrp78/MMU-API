package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class WrapperAncImmunizationTest {
    @Autowired
    private WrapperAncImmunization wrapperAncImmunization;

   
    @Test
    void testGettT_1Status() {
        // Arrange, Act and Assert
        assertNull(wrapperAncImmunization.gettT_1Status());
    }

    @Test
    void testGettT_2Status() {
        // Arrange, Act and Assert
        assertNull(wrapperAncImmunization.gettT_2Status());
    }

   
    @Test
    void testGettT_3Status() {
        // Arrange, Act and Assert
        assertNull(wrapperAncImmunization.gettT_3Status());
    }

    @Test
    void testGettT1ID() {
        // Arrange, Act and Assert
        assertNull(wrapperAncImmunization.gettT1ID());
    }

    @Test
    void testGettT2ID() {
        // Arrange, Act and Assert
        assertNull(wrapperAncImmunization.gettT2ID());
    }

  
    @Test
    void testGettT3ID() {
        // Arrange, Act and Assert
        assertNull(wrapperAncImmunization.gettT3ID());
    }

   
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        WrapperAncImmunization actualWrapperAncImmunization = new WrapperAncImmunization();
        actualWrapperAncImmunization.setBenVisitID(1L);
        actualWrapperAncImmunization.setBeneficiaryRegID(1L);
        actualWrapperAncImmunization.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        actualWrapperAncImmunization.setDateReceivedForTT_1("2020-03-01");
        actualWrapperAncImmunization.setDateReceivedForTT_2("2020-03-01");
        actualWrapperAncImmunization.setDateReceivedForTT_3("2020-03-01");
        actualWrapperAncImmunization.setFacilityNameOfTT_1("Facility Name Of TT 1");
        actualWrapperAncImmunization.setFacilityNameOfTT_2("Facility Name Of TT 2");
        actualWrapperAncImmunization.setFacilityNameOfTT_3("Facility Name Of TT 3");
        actualWrapperAncImmunization.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualWrapperAncImmunization.setParkingPlaceID(1);
        actualWrapperAncImmunization.setProviderServiceMapID(1);
        actualWrapperAncImmunization.setVanID(1);
        actualWrapperAncImmunization.setVisitCode(1L);
        actualWrapperAncImmunization.settT1ID(1L);
        actualWrapperAncImmunization.settT2ID(1L);
        actualWrapperAncImmunization.settT3ID(1L);
        actualWrapperAncImmunization.settT_1Status("T T 1 Status");
        actualWrapperAncImmunization.settT_2Status("T T 2 Status");
        actualWrapperAncImmunization.settT_3Status("T T 3 Status");
        Long actualBenVisitID = actualWrapperAncImmunization.getBenVisitID();
        Long actualBeneficiaryRegID = actualWrapperAncImmunization.getBeneficiaryRegID();
        String actualCreatedBy = actualWrapperAncImmunization.getCreatedBy();
        String actualDateReceivedForTT_1 = actualWrapperAncImmunization.getDateReceivedForTT_1();
        String actualDateReceivedForTT_2 = actualWrapperAncImmunization.getDateReceivedForTT_2();
        String actualDateReceivedForTT_3 = actualWrapperAncImmunization.getDateReceivedForTT_3();
        String actualFacilityNameOfTT_1 = actualWrapperAncImmunization.getFacilityNameOfTT_1();
        String actualFacilityNameOfTT_2 = actualWrapperAncImmunization.getFacilityNameOfTT_2();
        String actualFacilityNameOfTT_3 = actualWrapperAncImmunization.getFacilityNameOfTT_3();
        String actualModifiedBy = actualWrapperAncImmunization.getModifiedBy();
        Integer actualParkingPlaceID = actualWrapperAncImmunization.getParkingPlaceID();
        Integer actualProviderServiceMapID = actualWrapperAncImmunization.getProviderServiceMapID();
        Integer actualVanID = actualWrapperAncImmunization.getVanID();
        Long actualVisitCode = actualWrapperAncImmunization.getVisitCode();

        // Assert that nothing has changed
        assertEquals("2020-03-01", actualDateReceivedForTT_1);
        assertEquals("2020-03-01", actualDateReceivedForTT_2);
        assertEquals("2020-03-01", actualDateReceivedForTT_3);
        assertEquals("Facility Name Of TT 1", actualFacilityNameOfTT_1);
        assertEquals("Facility Name Of TT 2", actualFacilityNameOfTT_2);
        assertEquals("Facility Name Of TT 3", actualFacilityNameOfTT_3);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVisitCode.longValue());
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        WrapperAncImmunization actualWrapperAncImmunization = new WrapperAncImmunization(1L, 1L, 1,
                "Jan 1, 2020 8:00am GMT+0100", "T T 1 Status", "2020-03-01", "Facility Name Of TT 1", "T T 2 Status",
                "2020-03-01", "Facility Name Of TT 2", "T T 3 Status", "2020-03-01", "Facility Name Of TT 3");
        actualWrapperAncImmunization.setBenVisitID(1L);
        actualWrapperAncImmunization.setBeneficiaryRegID(1L);
        actualWrapperAncImmunization.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        actualWrapperAncImmunization.setDateReceivedForTT_1("2020-03-01");
        actualWrapperAncImmunization.setDateReceivedForTT_2("2020-03-01");
        actualWrapperAncImmunization.setDateReceivedForTT_3("2020-03-01");
        actualWrapperAncImmunization.setFacilityNameOfTT_1("Facility Name Of TT 1");
        actualWrapperAncImmunization.setFacilityNameOfTT_2("Facility Name Of TT 2");
        actualWrapperAncImmunization.setFacilityNameOfTT_3("Facility Name Of TT 3");
        actualWrapperAncImmunization.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualWrapperAncImmunization.setParkingPlaceID(1);
        actualWrapperAncImmunization.setProviderServiceMapID(1);
        actualWrapperAncImmunization.setVanID(1);
        actualWrapperAncImmunization.setVisitCode(1L);
        actualWrapperAncImmunization.settT1ID(1L);
        actualWrapperAncImmunization.settT2ID(1L);
        actualWrapperAncImmunization.settT3ID(1L);
        actualWrapperAncImmunization.settT_1Status("T T 1 Status");
        actualWrapperAncImmunization.settT_2Status("T T 2 Status");
        actualWrapperAncImmunization.settT_3Status("T T 3 Status");
        Long actualBenVisitID = actualWrapperAncImmunization.getBenVisitID();
        Long actualBeneficiaryRegID = actualWrapperAncImmunization.getBeneficiaryRegID();
        String actualCreatedBy = actualWrapperAncImmunization.getCreatedBy();
        String actualDateReceivedForTT_1 = actualWrapperAncImmunization.getDateReceivedForTT_1();
        String actualDateReceivedForTT_2 = actualWrapperAncImmunization.getDateReceivedForTT_2();
        String actualDateReceivedForTT_3 = actualWrapperAncImmunization.getDateReceivedForTT_3();
        String actualFacilityNameOfTT_1 = actualWrapperAncImmunization.getFacilityNameOfTT_1();
        String actualFacilityNameOfTT_2 = actualWrapperAncImmunization.getFacilityNameOfTT_2();
        String actualFacilityNameOfTT_3 = actualWrapperAncImmunization.getFacilityNameOfTT_3();
        String actualModifiedBy = actualWrapperAncImmunization.getModifiedBy();
        Integer actualParkingPlaceID = actualWrapperAncImmunization.getParkingPlaceID();
        Integer actualProviderServiceMapID = actualWrapperAncImmunization.getProviderServiceMapID();
        Integer actualVanID = actualWrapperAncImmunization.getVanID();
        Long actualVisitCode = actualWrapperAncImmunization.getVisitCode();

        // Assert that nothing has changed
        assertEquals("2020-03-01", actualDateReceivedForTT_1);
        assertEquals("2020-03-01", actualDateReceivedForTT_2);
        assertEquals("2020-03-01", actualDateReceivedForTT_3);
        assertEquals("Facility Name Of TT 1", actualFacilityNameOfTT_1);
        assertEquals("Facility Name Of TT 2", actualFacilityNameOfTT_2);
        assertEquals("Facility Name Of TT 3", actualFacilityNameOfTT_3);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVisitCode.longValue());
    }
}
