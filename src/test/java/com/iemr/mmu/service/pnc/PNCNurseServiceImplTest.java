package com.iemr.mmu.service.pnc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.mmu.data.pnc.PNCCare;
import com.iemr.mmu.repo.nurse.pnc.PNCCareRepo;

@ExtendWith(MockitoExtension.class)
class PNCNurseServiceImplTest {
	@Mock
	private PNCCareRepo pNCCareRepo;

	@InjectMocks
	private PNCNurseServiceImpl pNCNurseServiceImpl;

	@Test
	void testSetPncCareRepo() {

		// Arrange and Act
		(new PNCNurseServiceImpl()).setPncCareRepo(mock(PNCCareRepo.class));
	}

	@Test
	void testSaveBenPncCareDetails() throws ParseException {
		// Arrange
		when(pNCCareRepo.save(Mockito.<PNCCare>any())).thenReturn(new PNCCare(1L, 1L, 1L, 1, (short) 1, (short) 1,
				"Delivery Type", (short) 1, "Delivery Place", "Other Delivery Place", mock(Date.class), (short) 1,
				"Delivery Complication", "Other Delivery Complication", (short) 1, "Preg Outcome", (short) 1,
				"Post Natal Complication", "Other Post Natal Complication", (short) 1, "Gestation Name", 10.0d, 1,
				"New Born Health Status", 1L));

		// Act
		Long actualSaveBenPncCareDetailsResult = pNCNurseServiceImpl.saveBenPncCareDetails(new PNCCare(1L, 1L, 1L, 1,
				(short) 1, (short) 1, "Delivery Type", (short) 1, "Delivery Place", "Other Delivery Place",
				mock(Date.class), (short) 1, "Delivery Complication", "Other Delivery Complication", (short) 1,
				"Preg Outcome", (short) 1, "Post Natal Complication", "Other Post Natal Complication", (short) 1,
				"Gestation Name", 10.0d, 1, "New Born Health Status", 1L));

		// Assert
		verify(pNCCareRepo).save(Mockito.<PNCCare>any());
		assertEquals(1L, actualSaveBenPncCareDetailsResult.longValue());
	}

	@Test
	void testSaveBenPncCareDetails2() throws ParseException {
		// Arrange
		when(pNCCareRepo.save(Mockito.<PNCCare>any())).thenReturn(new PNCCare(0L, 1L, 1L, 1, (short) 1, (short) 1,
				"Delivery Type", (short) 1, "Delivery Place", "Other Delivery Place", mock(Date.class), (short) 1,
				"Delivery Complication", "Other Delivery Complication", (short) 1, "Preg Outcome", (short) 1,
				"Post Natal Complication", "Other Post Natal Complication", (short) 1, "Gestation Name", 10.0d, 1,
				"New Born Health Status", 1L));

		// Act
		Long actualSaveBenPncCareDetailsResult = pNCNurseServiceImpl.saveBenPncCareDetails(new PNCCare(1L, 1L, 1L, 1,
				(short) 1, (short) 1, "Delivery Type", (short) 1, "Delivery Place", "Other Delivery Place",
				mock(Date.class), (short) 1, "Delivery Complication", "Other Delivery Complication", (short) 1,
				"Preg Outcome", (short) 1, "Post Natal Complication", "Other Post Natal Complication", (short) 1,
				"Gestation Name", 10.0d, 1, "New Born Health Status", 1L));

		// Assert
		verify(pNCCareRepo).save(Mockito.<PNCCare>any());
		assertNull(actualSaveBenPncCareDetailsResult);
	}

	@Test
	void testSaveBenPncCareDetails3() throws ParseException {
		// Arrange
		when(pNCCareRepo.save(Mockito.<PNCCare>any())).thenReturn(null);

		// Act
		Long actualSaveBenPncCareDetailsResult = pNCNurseServiceImpl.saveBenPncCareDetails(new PNCCare(1L, 1L, 1L, 1,
				(short) 1, (short) 1, "Delivery Type", (short) 1, "Delivery Place", "Other Delivery Place",
				mock(Date.class), (short) 1, "Delivery Complication", "Other Delivery Complication", (short) 1,
				"Preg Outcome", (short) 1, "Post Natal Complication", "Other Post Natal Complication", (short) 1,
				"Gestation Name", 10.0d, 1, "New Born Health Status", 1L));

		// Assert
		verify(pNCCareRepo).save(Mockito.<PNCCare>any());
		assertNull(actualSaveBenPncCareDetailsResult);
	}

	@Test
	void testSaveBenPncCareDetails4() throws ParseException {
		// Arrange
		PNCCare pncCare = mock(PNCCare.class);
		when(pncCare.getID()).thenReturn(1L);
		when(pNCCareRepo.save(Mockito.<PNCCare>any())).thenReturn(pncCare);

		// Act
		Long actualSaveBenPncCareDetailsResult = pNCNurseServiceImpl.saveBenPncCareDetails(new PNCCare(1L, 1L, 1L, 1,
				(short) 1, (short) 1, "Delivery Type", (short) 1, "Delivery Place", "Other Delivery Place",
				mock(Date.class), (short) 1, "Delivery Complication", "Other Delivery Complication", (short) 1,
				"Preg Outcome", (short) 1, "Post Natal Complication", "Other Post Natal Complication", (short) 1,
				"Gestation Name", 10.0d, 1, "New Born Health Status", 1L));

		// Assert
		verify(pncCare, atLeast(1)).getID();
		verify(pNCCareRepo).save(Mockito.<PNCCare>any());
		assertEquals(1L, actualSaveBenPncCareDetailsResult.longValue());
	}

	@Test
	void testGetPNCCareDetails() {
		// Arrange
		when(pNCCareRepo.getPNCCareDetails(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(new ArrayList<>());

		// Act
		String actualPNCCareDetails = pNCNurseServiceImpl.getPNCCareDetails(1L, 1L);

		// Assert
		verify(pNCCareRepo).getPNCCareDetails(Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("null", actualPNCCareDetails);
	}

	@Test
	void testUpdateBenPNCCareDetails() throws ParseException {
		// Arrange
		when(pNCCareRepo.updatePNCCareDetails(Mockito.<Short>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Date>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(), Mockito.<String>any(),
				Mockito.<Short>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<Double>any(), Mockito.<Integer>any(), Mockito.<String>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(1);
		when(pNCCareRepo.getBenPNCCareDetailsStatus(Mockito.<Long>any(), Mockito.<Long>any()))
				.thenReturn("Ben PNCCare Details Status");
		PNCCare pncCareDetailsOBJ = new PNCCare(1L, 1L, 1L, 1, (short) 1, (short) 1, "Delivery Type", (short) 1,
				"Delivery Place", "Other Delivery Place", mock(Date.class), (short) 1, "Delivery Complication",
				"Other Delivery Complication", (short) 1, "Preg Outcome", (short) 1, "Post Natal Complication",
				"Other Post Natal Complication", (short) 1, "Gestation Name", 10.0d, 1, "New Born Health Status", 1L);

		// Act
		int actualUpdateBenPNCCareDetailsResult = pNCNurseServiceImpl.updateBenPNCCareDetails(pncCareDetailsOBJ);

		// Assert
		verify(pNCCareRepo).getBenPNCCareDetailsStatus(Mockito.<Long>any(), Mockito.<Long>any());
		verify(pNCCareRepo).updatePNCCareDetails(Mockito.<Short>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Date>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(), Mockito.<String>any(),
				Mockito.<Short>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<Double>any(), Mockito.<Integer>any(), Mockito.<String>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("U", pncCareDetailsOBJ.getProcessed());
		assertEquals(1, actualUpdateBenPNCCareDetailsResult);
	}

	@Test
	void testUpdateBenPNCCareDetails2() throws ParseException {
		// Arrange
		when(pNCCareRepo.updatePNCCareDetails(Mockito.<Short>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Date>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(), Mockito.<String>any(),
				Mockito.<Short>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<Double>any(), Mockito.<Integer>any(), Mockito.<String>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(1);
		when(pNCCareRepo.getBenPNCCareDetailsStatus(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn("N");
		PNCCare pncCareDetailsOBJ = new PNCCare(1L, 1L, 1L, 1, (short) 1, (short) 1, "Delivery Type", (short) 1,
				"Delivery Place", "Other Delivery Place", mock(Date.class), (short) 1, "Delivery Complication",
				"Other Delivery Complication", (short) 1, "Preg Outcome", (short) 1, "Post Natal Complication",
				"Other Post Natal Complication", (short) 1, "Gestation Name", 10.0d, 1, "New Born Health Status", 1L);

		// Act
		int actualUpdateBenPNCCareDetailsResult = pNCNurseServiceImpl.updateBenPNCCareDetails(pncCareDetailsOBJ);

		// Assert
		verify(pNCCareRepo).getBenPNCCareDetailsStatus(Mockito.<Long>any(), Mockito.<Long>any());
		verify(pNCCareRepo).updatePNCCareDetails(Mockito.<Short>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Date>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(), Mockito.<String>any(),
				Mockito.<Short>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<Double>any(), Mockito.<Integer>any(), Mockito.<String>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals("N", pncCareDetailsOBJ.getProcessed());
		assertEquals(1, actualUpdateBenPNCCareDetailsResult);
	}

	@Test
	void testUpdateBenPNCCareDetails3() throws ParseException {
		// Arrange
		when(pNCCareRepo.save(Mockito.<PNCCare>any())).thenReturn(new PNCCare(1L, 1L, 1L, 1, (short) 1, (short) 1,
				"Delivery Type", (short) 1, "Delivery Place", "Other Delivery Place", mock(Date.class), (short) 1,
				"Delivery Complication", "Other Delivery Complication", (short) 1, "Preg Outcome", (short) 1,
				"Post Natal Complication", "Other Post Natal Complication", (short) 1, "Gestation Name", 10.0d, 1,
				"New Born Health Status", 1L));
		when(pNCCareRepo.getBenPNCCareDetailsStatus(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(null);
		PNCCare pncCareDetailsOBJ = new PNCCare(1L, 1L, 1L, 1, (short) 1, (short) 1, "Delivery Type", (short) 1,
				"Delivery Place", "Other Delivery Place", mock(Date.class), (short) 1, "Delivery Complication",
				"Other Delivery Complication", (short) 1, "Preg Outcome", (short) 1, "Post Natal Complication",
				"Other Post Natal Complication", (short) 1, "Gestation Name", 10.0d, 1, "New Born Health Status", 1L);

		// Act
		int actualUpdateBenPNCCareDetailsResult = pNCNurseServiceImpl.updateBenPNCCareDetails(pncCareDetailsOBJ);

		// Assert
		verify(pNCCareRepo).getBenPNCCareDetailsStatus(Mockito.<Long>any(), Mockito.<Long>any());
		verify(pNCCareRepo).save(Mockito.<PNCCare>any());
		assertEquals("N", pncCareDetailsOBJ.getProcessed());
		assertNull(pncCareDetailsOBJ.getCreatedBy());
		assertEquals(1, actualUpdateBenPNCCareDetailsResult);
	}

	@Test
	void testUpdateBenPNCCare() throws ParseException {
		// Arrange
		when(pNCCareRepo.updatePNCCareDetails(Mockito.<Short>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Date>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(), Mockito.<String>any(),
				Mockito.<Short>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<Double>any(), Mockito.<Integer>any(), Mockito.<String>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(1);

		// Act
		int actualUpdateBenPNCCareResult = pNCNurseServiceImpl.updateBenPNCCare(new PNCCare(1L, 1L, 1L, 1, (short) 1,
				(short) 1, "Delivery Type", (short) 1, "Delivery Place", "Other Delivery Place", mock(Date.class),
				(short) 1, "Delivery Complication", "Other Delivery Complication", (short) 1, "Preg Outcome", (short) 1,
				"Post Natal Complication", "Other Post Natal Complication", (short) 1, "Gestation Name", 10.0d, 1,
				"New Born Health Status", 1L));

		// Assert
		verify(pNCCareRepo).updatePNCCareDetails(Mockito.<Short>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Date>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(), Mockito.<String>any(),
				Mockito.<Short>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<Double>any(), Mockito.<Integer>any(), Mockito.<String>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals(1, actualUpdateBenPNCCareResult);
	}

	@Test
	void testUpdateBenPNCCare2() throws ParseException {
		// Arrange
		when(pNCCareRepo.updatePNCCareDetails(Mockito.<Short>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Date>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(), Mockito.<String>any(),
				Mockito.<Short>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<Double>any(), Mockito.<Integer>any(), Mockito.<String>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(1);
		PNCCare pncCareOBJ = mock(PNCCare.class);
		doNothing().when(pncCareOBJ).setDateOfDelivery(Mockito.<Date>any());
		when(pncCareOBJ.getBirthWeightOfNewborn()).thenReturn(10.0d);
		when(pncCareOBJ.getNewBornHealthStatusID()).thenReturn(1);
		when(pncCareOBJ.getBeneficiaryRegID()).thenReturn(1L);
		when(pncCareOBJ.getVisitCode()).thenReturn(1L);
		when(pncCareOBJ.getDeliveryComplicationID()).thenReturn((short) 1);
		when(pncCareOBJ.getDeliveryPlaceID()).thenReturn((short) 1);
		when(pncCareOBJ.getDeliveryTypeID()).thenReturn((short) 1);
		when(pncCareOBJ.getGestationID()).thenReturn((short) 1);
		when(pncCareOBJ.getPostNatalComplicationID()).thenReturn((short) 1);
		when(pncCareOBJ.getPregOutcomeID()).thenReturn((short) 1);
		when(pncCareOBJ.getDeliveryComplication()).thenReturn("Delivery Complication");
		when(pncCareOBJ.getDeliveryPlace()).thenReturn("Delivery Place");
		when(pncCareOBJ.getDeliveryType()).thenReturn("Delivery Type");
		when(pncCareOBJ.getGestationName()).thenReturn("Gestation Name");
		when(pncCareOBJ.getModifiedBy()).thenReturn("Jan 1, 2020 9:00am GMT+0100");
		when(pncCareOBJ.getNewBornHealthStatus()).thenReturn("New Born Health Status");
		when(pncCareOBJ.getOtherDeliveryComplication()).thenReturn("Other Delivery Complication");
		when(pncCareOBJ.getOtherDeliveryPlace()).thenReturn("Other Delivery Place");
		when(pncCareOBJ.getOtherPostNatalComplication()).thenReturn("Other Post Natal Complication");
		when(pncCareOBJ.getPostNatalComplication()).thenReturn("Post Natal Complication");
		when(pncCareOBJ.getPregOutcome()).thenReturn("Preg Outcome");
		when(pncCareOBJ.getProcessed()).thenReturn("Processed");
		when(pncCareOBJ.getdDate()).thenReturn("2020-03-01");
		when(pncCareOBJ.getDateOfDelivery()).thenReturn(mock(Date.class));

		// Act
		int actualUpdateBenPNCCareResult = pNCNurseServiceImpl.updateBenPNCCare(pncCareOBJ);

		// Assert
		verify(pncCareOBJ).getBeneficiaryRegID();
		verify(pncCareOBJ).getBirthWeightOfNewborn();
		verify(pncCareOBJ).getDateOfDelivery();
		verify(pncCareOBJ).getDeliveryComplication();
		verify(pncCareOBJ).getDeliveryComplicationID();
		verify(pncCareOBJ).getDeliveryPlace();
		verify(pncCareOBJ).getDeliveryPlaceID();
		verify(pncCareOBJ).getDeliveryType();
		verify(pncCareOBJ).getDeliveryTypeID();
		verify(pncCareOBJ).getGestationID();
		verify(pncCareOBJ).getGestationName();
		verify(pncCareOBJ).getModifiedBy();
		verify(pncCareOBJ).getNewBornHealthStatus();
		verify(pncCareOBJ).getNewBornHealthStatusID();
		verify(pncCareOBJ).getOtherDeliveryComplication();
		verify(pncCareOBJ).getOtherDeliveryPlace();
		verify(pncCareOBJ).getOtherPostNatalComplication();
		verify(pncCareOBJ).getPostNatalComplication();
		verify(pncCareOBJ).getPostNatalComplicationID();
		verify(pncCareOBJ).getPregOutcome();
		verify(pncCareOBJ).getPregOutcomeID();
		verify(pncCareOBJ).getProcessed();
		verify(pncCareOBJ).getVisitCode();
		verify(pncCareOBJ, atLeast(1)).getdDate();
		verify(pncCareOBJ).setDateOfDelivery(Mockito.<Date>any());
		verify(pNCCareRepo).updatePNCCareDetails(Mockito.<Short>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Date>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(), Mockito.<String>any(),
				Mockito.<Short>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Short>any(),
				Mockito.<String>any(), Mockito.<Double>any(), Mockito.<Integer>any(), Mockito.<String>any(),
				Mockito.<String>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any());
		assertEquals(1, actualUpdateBenPNCCareResult);
	}
}
