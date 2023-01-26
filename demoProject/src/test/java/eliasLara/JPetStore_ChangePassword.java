package eliasLara;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import JPetStorePO.JP_EditAccountFormPage;
import JPetStorePO.JP_LoginPage;
import JPetStorePO.JP_homePage;
import library.Driver;

public class JPetStore_ChangePassword extends Driver{
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		this.driver = initChromeDriverWtURL("https://petstore.octoperf.com/actions/Catalog.action");
	}
	@Test
	public void JPetStore_ChangePasswordScript() {
		//Page Object Instances.
		
		JP_homePage homePage = new JP_homePage(driver);
		JP_LoginPage loginPage = new JP_LoginPage(driver);
		JP_EditAccountFormPage editAcntPage = new JP_EditAccountFormPage(driver);
		
		//Click on Sign In link.
		
		homePage.clickSignInLink();
		
		//Insert User Name text box.
		
		loginPage.ClearPassword();
		loginPage.writeUserName("EliasLara66");
		
		//Insert password text box.
		
		loginPage.writePassword("eliaslara66");
		
		//Click login button.
		
		loginPage.clickLoginButton();
		
		//Click in My Account link, home page signed on user.
		
		homePage.clickMyAccountLink();
		
		//Set New Password field.
		
		editAcntPage.setNewPasswordTxtbox("mockpwd0");
		
		//Repeat the new password.
		
		editAcntPage.setRepeatedPasswordTxtbox();
		
		//Click in Save Account Information button.
		
		editAcntPage.clickSaveAccountInfoBtn();
		
		//Validate the new password is properly saved and displayed.
	
		editAcntPage.validatePwdIsChanged();
		
		//Click in Sign Out link.
		
		homePage.clickSignOutLink();
		
	}
	
	@AfterClass
	public void teardown() {
		System.out.println("The test script has passed successfully.");
		teardownDriver();
	}
}
