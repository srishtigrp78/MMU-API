package com.iemr.mmu.data.covid19;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class CovidSymptomsMasterTest {
   
    @Test
    void testGettersAndSetters() {
        // Arrange
        CovidSymptomsMaster covidSymptomsMaster = new CovidSymptomsMaster();

        // Act
        covidSymptomsMaster.setCovidSymptomID(1);
        covidSymptomsMaster.setDeleted(true);
        covidSymptomsMaster.setSymptoms("Symptoms");
        Integer actualCovidSymptomID = covidSymptomsMaster.getCovidSymptomID();
        Boolean actualDeleted = covidSymptomsMaster.getDeleted();

        // Assert that nothing has changed
        assertEquals("Symptoms", covidSymptomsMaster.getSymptoms());
        assertEquals(1, actualCovidSymptomID.intValue());
        assertTrue(actualDeleted);
    }
}
