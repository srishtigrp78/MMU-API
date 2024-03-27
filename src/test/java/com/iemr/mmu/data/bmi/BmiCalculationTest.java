package com.iemr.mmu.data.bmi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class BmiCalculationTest {
   
    @Test
    void testGettersAndSetters() {
        // Arrange
        BmiCalculation bmiCalculation = new BmiCalculation();

        // Act
        bmiCalculation.setBmi(10.0d);
        bmiCalculation.setBmiid(1L);
        bmiCalculation.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        bmiCalculation.setCreatedDate(createdDate);
        bmiCalculation.setDeleted(true);
        bmiCalculation.setGender("Gender");
        Timestamp lastModDate = mock(Timestamp.class);
        bmiCalculation.setLastModDate(lastModDate);
        bmiCalculation.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        bmiCalculation.setMonth(1);
        bmiCalculation.setN1SD(10.0d);
        bmiCalculation.setN2SD(10.0d);
        bmiCalculation.setN3SD(10.0d);
        bmiCalculation.setP1SD(10.0d);
        bmiCalculation.setP2SD(10.0d);
        bmiCalculation.setP3SD(10.0d);
        bmiCalculation.setProcessed("Processed");
        bmiCalculation.setYearMonth("Year Month");
        double actualBmi = bmiCalculation.getBmi();
        Long actualBmiid = bmiCalculation.getBmiid();
        String actualCreatedBy = bmiCalculation.getCreatedBy();
        Timestamp actualCreatedDate = bmiCalculation.getCreatedDate();
        Boolean actualDeleted = bmiCalculation.getDeleted();
        String actualGender = bmiCalculation.getGender();
        Timestamp actualLastModDate = bmiCalculation.getLastModDate();
        String actualModifiedBy = bmiCalculation.getModifiedBy();
        Integer actualMonth = bmiCalculation.getMonth();
        double actualN1SD = bmiCalculation.getN1SD();
        double actualN2SD = bmiCalculation.getN2SD();
        double actualN3SD = bmiCalculation.getN3SD();
        double actualP1SD = bmiCalculation.getP1SD();
        double actualP2SD = bmiCalculation.getP2SD();
        double actualP3SD = bmiCalculation.getP3SD();
        String actualProcessed = bmiCalculation.getProcessed();

        // Assert that nothing has changed
        assertEquals("Gender", actualGender);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Processed", actualProcessed);
        assertEquals("Year Month", bmiCalculation.getYearMonth());
        assertEquals(1, actualMonth.intValue());
        assertEquals(10.0d, actualBmi);
        assertEquals(10.0d, actualN1SD);
        assertEquals(10.0d, actualN2SD);
        assertEquals(10.0d, actualN3SD);
        assertEquals(10.0d, actualP1SD);
        assertEquals(10.0d, actualP2SD);
        assertEquals(10.0d, actualP3SD);
        assertEquals(1L, actualBmiid.longValue());
        assertTrue(actualDeleted);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
    }
}
