package JPetStorePO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class JP_ValidationAnimalselectedPage {
	WebDriver Driver;

	public JP_ValidationAnimalselectedPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);

	}
}
