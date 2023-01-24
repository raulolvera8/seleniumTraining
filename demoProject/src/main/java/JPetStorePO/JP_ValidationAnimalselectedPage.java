package JPetStorePO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JP_ValidationAnimalselectedPage {
	WebDriver Driver;

	public JP_ValidationAnimalselectedPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);

	}
	@FindBy (xpath="//h2") WebElement headerProduct;
	public WebElement getHeaderProduct() {
		return headerProduct;
	}
	public void validationMsg() {
		if (getHeaderProduct().isDisplayed()) {
			System.out.println("Animal: " + getHeaderProduct().getText());
		}
	}
}
