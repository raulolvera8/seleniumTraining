package phptravelsPageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePageObject {
	WebDriver driver;

	public homePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/// ----Account Button-----
	@FindBy(id = "ACCOUNT")
	WebElement btnAccount;

	public WebElement getBtnAccount() {
		return btnAccount;
	}

	public void clickBtnAccount() {
		getBtnAccount().click();
	}

	/// -----Customer login-----
	@FindBy(xpath = "//a[ contains (text(), 'Customer Login' ) ]")
	WebElement customerLoginBtn;

	public WebElement getCustomerLogBtn() {
		return customerLoginBtn;
	}

	public void clickCustomerLoginbtn() {
		getCustomerLogBtn().click();
	}

	// ------Agent login -------- Iris
	@FindBy(xpath = "//a[ contains (text(), 'Agent Login' ) ]")
	WebElement agentLoginBtn;

	public WebElement getAgentLogBtn() {
		return agentLoginBtn;
	}

	public void clickAgentLoginbtn() {
		getAgentLogBtn().click();
		System.out.println("Login Agent Account...");
	}

	// ELEMENTS FROM LOGIN FORM ------ Iris
	@FindBy(xpath = "(//input[@name='email'])[1]")
	WebElement emailInput;

	private WebElement getEmailInput() {
		return emailInput;
	}

	public void enterUsernameInput(String email) {
		System.out.println("Entering email...");
		getEmailInput().sendKeys(email);
	}

	@FindBy(name = "password")
	WebElement passwordInput;

	private WebElement getPasswordInput() {
		return passwordInput;
	}

	public void enterPasswordInput(String password) {
		System.out.println("Entering password...");
		getPasswordInput().sendKeys(password);
	}
}
