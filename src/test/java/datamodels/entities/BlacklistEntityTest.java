package test.java.datamodels.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.datamodels.entities.BlacklistEntity;

class BlacklistEntityTest {
	
	private final String SITE = "badsite.com";
	
	private final int REPORTS = 0;
	
	@Test
	void testConstructor_default() {
		BlacklistEntity blackList = new BlacklistEntity();
		blackList.setNumReports(REPORTS);
		blackList.setReportedSite(SITE);
		assertEquals(blackList.getNumReports(), REPORTS);
		assertEquals(blackList.getReportedSite(), SITE);
	}
	
	@Test
	void testConstructor_overloaded() {
		BlacklistEntity blackList = new BlacklistEntity(SITE);
		assertEquals(blackList.getNumReports(), 1);
		assertEquals(blackList.getReportedSite(), SITE);
	}

	@Test
	void testGetterSetter() {
		BlacklistEntity blackList = new BlacklistEntity();
		blackList.setNumReports(REPORTS);
		blackList.setReportedSite(SITE);
		assertEquals(blackList.getNumReports(), REPORTS);
		assertEquals(blackList.getReportedSite(), SITE);
	}
	
	@Test
	void testEquals() {
		BlacklistEntity blackList = new BlacklistEntity();
		blackList.setNumReports(REPORTS);
		blackList.setReportedSite(SITE);
		
		BlacklistEntity blackList2 = new BlacklistEntity();
		blackList2.setNumReports(REPORTS);
		blackList2.setReportedSite(SITE);

		assertTrue(blackList.equals(blackList2));
	}
	
	@Test
	void testBumpReports() {
		BlacklistEntity blackList = new BlacklistEntity(SITE);
		assertEquals(blackList.getNumReports(), 1);
		for(int i = 0; i < 10; i++)
			blackList.bumpReports();
		assertEquals(blackList.getNumReports(), 11);
	}

}
