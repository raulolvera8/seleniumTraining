package JPetStorePO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JP_paymentDetailsPage {
WebDriver Driver;
public JP_paymentDetailsPage(WebDriver Driver){
	this.Driver=Driver;
	PageFactory.initElements(Driver, this);
}

// ------- PAYMENTS DETAILS SCREEN ------ DIANA
@FindBy (name="newOrder") WebElement continueBtn;
public WebElement getContinueBtn() {
	return continueBtn;
}
public void clickContinueBtn() {
	getContinueBtn().click();
}
}
