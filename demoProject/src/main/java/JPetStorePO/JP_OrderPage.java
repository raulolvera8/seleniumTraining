package JPetStorePO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JP_OrderPage {
	WebDriver Driver;
	public JP_OrderPage(WebDriver Driver){
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
	}
	// -------- CONFIRM ORDER ------- DIANA
	// ------- XPATH --------
	@FindBy(xpath="//*[@class='Button'][text()='Confirm']") WebElement confirmOrderBtn;
	public WebElement getConfirmOrderBtn() {
		return confirmOrderBtn;
	}
	public void clickConfirmOrderBtn() {
		getConfirmOrderBtn().click();
	}
	// --------- ORDER SUBMMITED LABEL ------ DIANA
	// ---- XPATH -----
	@FindBy (xpath="//*[@class='messages']/li") WebElement confirmationLabel;
	public WebElement getConfirmationLabel() {
		return confirmationLabel;
	}
	public void readconfirmationLabel() {
		System.out.println("Status purchase: " + getConfirmationLabel().getText());
	}

}
