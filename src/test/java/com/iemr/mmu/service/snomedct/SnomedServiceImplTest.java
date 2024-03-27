package com.iemr.mmu.service.snomedct;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Page;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

import com.iemr.mmu.data.snomedct.SCTDescription;
import com.iemr.mmu.repo.snomedct.SnomedRepository;
import com.iemr.mmu.utils.mapper.OutputMapper;

@ExtendWith(MockitoExtension.class)
class SnomedServiceImplTest {
	@Mock
	private SnomedRepository snomedRepository;

	@InjectMocks
	private SnomedServiceImpl snomedServiceImpl;

//	@Test
//	@Disabled("TODO: Complete this test")
//	void testFindSnomedCTRecordFromTerm() {
//
//		// Arrange and Act
//		snomedServiceImpl.findSnomedCTRecordFromTerm("Term");
//	}
//

	@Test
	public void testFindSnomedCTRecordFromTerm_Found() {
		String term = "testTerm";
		List<Object[]> mockData = Collections.singletonList(new Object[1]);

		when(snomedRepository.findSnomedCTRecordFromTerm(term)).thenReturn(mockData);

		try {
			SCTDescription actualObj = snomedServiceImpl.findSnomedCTRecordFromTerm(term);
			fail("Expected ArrayIndexOutOfBoundsException"); // This line will fail the test if no exception is thrown
		} catch (ArrayIndexOutOfBoundsException e) {
			// Expected exception, test passes
		}

		verify(snomedRepository).findSnomedCTRecordFromTerm(term);
	}

	@Test
	public void testFindSnomedCTRecordFromTerm_NotFound() {
		String term = "notFoundTerm";
		when(snomedRepository.findSnomedCTRecordFromTerm(term)).thenReturn(Collections.emptyList());

		SCTDescription actualObj = snomedServiceImpl.findSnomedCTRecordFromTerm(term);

		assertNull(actualObj);
		verify(snomedRepository).findSnomedCTRecordFromTerm(term);
	}

	@Test
	void testFindSnomedCTRecordList() throws Exception {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange, Act and Assert
		assertThrows(Exception.class, () -> (new SnomedServiceImpl()).findSnomedCTRecordList(null));
	}

	@Test
	void testFindSnomedCTRecordList2() throws Exception {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		SnomedServiceImpl snomedServiceImpl = new SnomedServiceImpl();

		SCTDescription sctdescription = new SCTDescription();
		sctdescription.setActive("Active");
		sctdescription.setCaseSignificanceID("Case Significance ID");
		sctdescription.setConceptID("Concept ID");
		sctdescription.setSctDesID(1L);
		sctdescription.setPageNo(null);
		sctdescription.setTerm(null);

		// Act and Assert
		assertThrows(Exception.class, () -> snomedServiceImpl.findSnomedCTRecordList(sctdescription));
	}

	@Test
	void testFindSnomedCTRecordList3() throws Exception {

		// Arrange
		SnomedServiceImpl snomedServiceImpl = new SnomedServiceImpl();

		SCTDescription sctdescription = new SCTDescription();
		sctdescription.setActive("Active");
		sctdescription.setCaseSignificanceID("Case Significance ID");
		sctdescription.setConceptID("Concept ID");
		sctdescription.setSctDesID(1L);
		sctdescription.setPageNo(null);
		sctdescription.setTerm("foo");
		
		sctdescription.toString();

		// Act and Assert
		assertThrows(Exception.class, () -> snomedServiceImpl.findSnomedCTRecordList(sctdescription));
	}

//	@Test
//	public void testFindSnomedCTRecordList_validInput_shouldReturnDataMap() throws Exception {
//		// Given
//		SCTDescription sctdescription = new SCTDescription();
//		sctdescription.setTerm("testTerm");
//		sctdescription.setPageNo(0);
//
//		// Create a mock Page
//		Page mockPage = mock(Page.class);
//		List<SCTDescription> mockContent = List.of(new SCTDescription());
//		when(((Slice<SCTDescription>) mockPage).getContent()).thenReturn(mockContent);
//		when(((org.springframework.data.domain.Page<SCTDescription>) mockPage).getTotalPages()).thenReturn(1);
//		when(snomedRepository.findSnomedCTRecordList(Mockito.eq(sctdescription.getTerm()),
//				Mockito.any(PageRequest.class))).thenReturn((org.springframework.data.domain.Page<SCTDescription>) mockPage);
//
//		// When
//		String response = snomedServiceImpl.findSnomedCTRecordList(sctdescription);
//
//		// Then
//		Map<String, Object> expectedOutput = new HashMap<>();
//		expectedOutput.put("sctMaster", mockContent);
//		expectedOutput.put("pageCount", 1);
//		assertEquals(expectedOutput, OutputMapper.gson().fromJson(response, Map.class));
//	}
}
