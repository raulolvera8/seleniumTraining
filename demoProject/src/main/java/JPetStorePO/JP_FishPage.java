package JPetStorePO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class JP_FishPage {

	WebDriver Driver;

	public JP_FishPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);

	}
}
