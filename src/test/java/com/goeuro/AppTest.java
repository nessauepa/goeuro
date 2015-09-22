package com.goeuro;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AppTest {

	@DataProvider(name = "failedInputs")
	public Object[][] provide() throws Exception {
		return new Object[][] {
				{ null },
				{ new String[] {} },
				{ new String[] { null } },
				{ new String[] { "" } },
				{ new String[] { "Param1", "Param2" } }
		};
	}

	@Test(dataProvider = "failedInputs")
	public void shouldReturnUsageMessage(String[] args) {

		String response = new App().execute(args);
		assertEquals(response, "Usage: java -jar GoEuroTest.java <city>");
	}
	
	@Test
	public void shouldReturnSuccess() {
		
		String response = new App().execute(new String[]{ "Berlin" });
		assertEquals(response, "File generated: Berlin.csv");
	}
}
