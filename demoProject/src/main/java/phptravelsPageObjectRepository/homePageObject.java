package phptravelsPageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePageObject {
	WebDriver driver;
	public homePageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	///----Account Button-----
	@FindBy (id="ACCOUNT") WebElement btnAccount;
	public WebElement getBtnAccount() {
		return btnAccount;
	}
	public void clickBtnAccount() {
		getBtnAccount().click();
	}
	///-----Customer login-----
	@FindBy (xpath="//a[ contains (text(), 'Customer Login' ) ]") WebElement customerLoginBtn;
	public WebElement getCustomerLogBtn() {
		return customerLoginBtn;
	}
	public void clickCustomerLoginbtn() {
		getCustomerLogBtn().click();
	}
}
