package phptravelsPageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PTFlightSearchResultsPage {
	WebDriver driver;

	public PTFlightSearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//book now button
	
}
