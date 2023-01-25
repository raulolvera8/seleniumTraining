package JPetStorePO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import library.utilities;

public class JP_EditAccountFormPage {
	WebDriver Driver;
	String newPassword;
	utilities utility = new utilities(Driver);

	public JP_EditAccountFormPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}

	// ******************************************************
	// Title: setNewPasswordTxtbox
	// Objective: Sets the new password text box.
	// Author: Elías Lara.
	// Date of creation/adding: 01 25 23
	// ******************************************************

	@FindBy(xpath = "//input[@name='password']")
	WebElement newPwdTxtbox;

	public WebElement getNewPwdTxtbox() {
		return newPwdTxtbox;
	}

	public void setNewPasswordTxtbox(String newPassword) {
		getNewPwdTxtbox().sendKeys(newPassword);
		System.out.println("New Password has been inserted. Password has changed to: " + newPassword + ".");
		this.newPassword = newPassword;
	}

	// ******************************************************
	// Title: validatePwdIsChanged
	// Objective: Validates if the password has been changed.
	// Author: Elías Lara.
	// Date of creation/adding: 01 25 23
	// ******************************************************
	
	public void validatePwdIsChanged() {
		String value = getNewPwdTxtbox().getAttribute("value");
		if(value == newPassword) {
			System.out.println("The password is saved and matches with the expected value. Value obtained: " + value + ", Value expected: " + newPassword);
		} else {
			System.out.println("The password has not been saved and does not match with the expected value. Value obtained: " + value + ", Value expected: " + newPassword);
			Assert.fail();
		}
	}

	// ******************************************************
	// Title: setRepeatedPasswordTxtbox
	// Objective: Sets the new password in Repeated password text box.
	// Author: Elías Lara.
	// Date of creation/adding: 01 25 23
	// ******************************************************

	@FindBy(xpath = "//input[@name='repeatedPassword']")
	WebElement repPwdTxtbox;

	public WebElement getRepPwdTxtbox() {
		return repPwdTxtbox;
	}

	public void setRepeatedPasswordTxtbox() {
		String newPwd = this.newPassword;
		getRepPwdTxtbox().sendKeys(newPwd);
		System.out.println(
				"Repeated Password has been inserted. Password has been repeated with value: " + newPassword + ".");
	}

	// ******************************************************
	// Title: clickSaveAccountInfoBtn
	// Objective: Click on Save Account Information button.
	// Author: Elías Lara.
	// Date of creation/adding: 01 25 23
	// ******************************************************

	@FindBy(xpath = "//input[@name='editAccount']")
	WebElement saveAccntBtn;

	public WebElement getSaveAccntBtn() {
		return saveAccntBtn;
	}

	public void clickSaveAccountInfoBtn() {
		utility.ScrollDown(Driver, "0", "700");
		getSaveAccntBtn().click();
		System.out.println("Save Account button has been clicked.");
	}

}
