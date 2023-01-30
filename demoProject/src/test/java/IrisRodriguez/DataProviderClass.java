package IrisRodriguez;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "myData")
	public Object[][] cardData() {
		return new Object[][] { 
			{"4242 4242 4242 4242","0630","456","Agent Selenium"},
		};
	}

}