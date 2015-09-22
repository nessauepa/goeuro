package com.goeuro;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.goeuro.position.LocationManager;

public class AppTest {

	@Mock
 	private LocationManager manager;
	
	@InjectMocks
	private App app;
	
	@BeforeMethod
	public void tearUp() {
		MockitoAnnotations.initMocks(this);
	}
	
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
	public void shouldReturnUsageMessage(String[] args) throws IOException {

		String response = app.execute(args);

		assertEquals(response, "Usage: java -jar GoEuroTest.java <city>");
		verify(manager, times(0)).searchAndGenerateFile(anyString());
	}
	
	@Test
	public void shouldReturnSuccess() throws IOException {
		
		when(manager.searchAndGenerateFile("Berlin")).thenReturn("Berlin.csv");
		
		String response = app.execute(new String[]{ "Berlin" });
		
		assertEquals(response, "File generated: Berlin.csv");
		verify(manager, times(1)).searchAndGenerateFile("Berlin");
	}
}
