package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class WrapperANCCareDetailTest {
  
    @Test
    void testGettersAndSetters() {
        // Arrange
        WrapperANCCareDetail wrapperANCCareDetail = new WrapperANCCareDetail();

        ANCCareDetails ancCareDetails = new ANCCareDetails();
        ancCareDetails.setAbortions_A((short) 1);
        ancCareDetails.setBenVisitID(1L);
        ancCareDetails.setBeneficiaryRegID(1L);
        ancCareDetails.setBloodGroup("Blood Group");
        ancCareDetails.setComolaintType("Comolaint Type");
        ancCareDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        ancCareDetails.setCreatedDate(mock(Timestamp.class));
        ancCareDetails.setDeleted(true);
        ancCareDetails.setDescription("The characteristics of someone or something");
        ancCareDetails.setDuration("Duration");
        ancCareDetails.setExpDelDt("Exp Del Dt");
        ancCareDetails.setExpectedDateofDelivery(mock(Date.class));
        ancCareDetails.setGestationalAgeOrPeriodofAmenorrhea_POA((short) 1);
        ancCareDetails.setGravida_G((short) 1);
        ancCareDetails.setID(1L);
        ancCareDetails.setLastMenstrualPeriod_LMP(mock(Date.class));
        ancCareDetails.setLastModDate(mock(Timestamp.class));
        ancCareDetails.setLivebirths_L((short) 1);
        ancCareDetails.setLmpDate("2020-03-01");
        ancCareDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        ancCareDetails.setParkingPlaceID(1);
        ancCareDetails.setPretermDeliveries_P((short) 1);
        ancCareDetails.setPrimiGravida(true);
        ancCareDetails.setProcessed("Processed");
        ancCareDetails.setProviderServiceMapID(1);
        ancCareDetails.setReservedForChange("Reserved For Change");
        ancCareDetails.setStillBirth(1);
        ancCareDetails.setSyncedBy("Synced By");
        ancCareDetails.setSyncedDate(mock(Timestamp.class));
        ancCareDetails.setTermDeliveries_T((short) 1);
        ancCareDetails.setTrimesterNumber((short) 1);
        ancCareDetails.setVanID(1);
        ancCareDetails.setVanSerialNo(1L);
        ancCareDetails.setVehicalNo("Vehical No");
        ancCareDetails.setVisitCode(1L);
        ancCareDetails.setVisitNo((short) 1);

        // Act
        wrapperANCCareDetail.setAncCareDetails(ancCareDetails);
        ArrayList<ANCWomenVaccineDetail> ancWomenVaccineDetail = new ArrayList<>();
        wrapperANCCareDetail.setAncWomenVaccineDetail(ancWomenVaccineDetail);
        ANCCareDetails actualAncCareDetails = wrapperANCCareDetail.getAncCareDetails();

        // Assert that nothing has changed
        assertSame(ancCareDetails, actualAncCareDetails);
        assertSame(ancWomenVaccineDetail, wrapperANCCareDetail.getAncWomenVaccineDetail());
    }
}
