package Juan;

import org.testng.annotations.DataProvider;

public class dataProviderTour {

	@DataProvider(name = "myInformation")
	public Object[][]  cardData() {
		return new Object[][] { 			
			{"5555 5555 5555 4444", "1220","200","Customer January"},
		};
}
}
