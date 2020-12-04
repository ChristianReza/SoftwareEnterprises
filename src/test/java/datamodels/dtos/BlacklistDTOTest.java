package test.java.datamodels.dtos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.datamodels.dtos.BlacklistDTO;

class BlacklistDTOTest {
	
	private final String SITE = "badsite.com";
	
	private final int REPORTS = 0;

	@Test
	void testGetterSetter() {
		BlacklistDTO blackList = new BlacklistDTO();
		blackList.setNumReports(REPORTS);
		blackList.setReportedSite(SITE);
		assertEquals(blackList.getNumReports(), REPORTS);
		assertEquals(blackList.getReportedSite(), SITE);
	}
	
	@Test
	void testEquals() {
		BlacklistDTO blackList = new BlacklistDTO();
		blackList.setNumReports(REPORTS);
		blackList.setReportedSite(SITE);
		
		BlacklistDTO blackList2 = new BlacklistDTO();
		blackList2.setNumReports(REPORTS);
		blackList2.setReportedSite(SITE);

		assertTrue(blackList.equals(blackList2));
	}

}
