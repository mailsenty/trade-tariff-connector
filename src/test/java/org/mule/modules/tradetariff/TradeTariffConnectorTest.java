package org.mule.modules.tradetariff;

import static org.junit.Assert.*;

import org.junit.Test;


public class TradeTariffConnectorTest {

	TradeTariffConnector  tradeTariffConnector = new TradeTariffConnector();

	@Test
	public void testQuery() {
		System.out.println(tradeTariffConnector.query("horses"));
	}

	@Test
	public void testSources() {
		System.out.println(tradeTariffConnector.sources("GT,AU"));
	}

	@Test
	public void testFinalyears() {
		System.out.println(tradeTariffConnector.finalyears("2005,2006"));
	}

	@Test
	public void testReporterNames() {
		System.out.println(tradeTariffConnector.reporterNames("United+States,Singapore+Bilateral"));
	}

}
