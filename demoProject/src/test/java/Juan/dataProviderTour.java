package Juan;

import org.testng.annotations.DataProvider;

public class dataProviderTour {

	@DataProvider(name = "myInformation")
	public Object[][]  cardData() {
		return new Object[][] { 
			{"5555555555554444", "0330","200","Customer January"},
		};
}
}
