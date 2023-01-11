package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

//##################### CLASS AND CODE CREATED BY ELIAS LARA.

public class PTToursMngmntPage_Supplier {

	WebDriver driver;

	public PTToursMngmntPage_Supplier(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ------------ VERIFY IF THE TOUR ELEMENT EXIST PREVIOUS THE CREATION ----

	public void verifyIfTourExistPrevCreation(String tourName) {
		try {
			boolean tourElement = driver.findElement(By.xpath(
					"//div[@id='layoutDrawer_content']//table/tbody/tr[contains(@class,'xcrud')]/td[5]/a[contains(text(),'"
							+ tourName + "')]"))
					.isDisplayed();
			if (tourElement) {
				System.out.println(
						"The tour is already created or the tour name is the same of an existing one. Please check.");
				Assert.fail();
			}
		} catch (Exception e) {
			System.out.println("No element matching with the info given was found. Continuing with the execution.");
		}
	}

	// ------------- +ADD BUTTON --------------------------------------------

	@FindBy(xpath = "//button[@type='submit']")
	WebElement AddTourBtn;

	public WebElement getAddTourBtn() {
		return AddTourBtn;
	}

	public void clickAddTourBtn() {
		getAddTourBtn().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='tourname']")));

		System.out.println("Add Tour button clicked. The user is in Add Tour page...");

	}

	// Verify if tour added is visible in Tours Management Screen.

	public void VerifyIfTourIsAdded(String tourName) {
		try {
			boolean tourElement = driver.findElement(By.xpath(
					"//div[@id='layoutDrawer_content']//table/tbody/tr[contains(@class,'xcrud')]/td[5]/a[contains(text(),'"
							+ tourName + "')]"))
					.isDisplayed();
			if (tourElement) {
				System.out.println("The tour is shown properly in 'Manage Tours' page...");
			}
		} catch (Exception e) {
			System.out.println("The tour has not been reflected as expected. Please check.");
			e.printStackTrace();
			Assert.fail();
		}
	}

	// Click in Profile button for supplier role.
	@FindBy(xpath = "//button[@id='dropdownMenuProfile']")
	WebElement profileBtn;

	public WebElement getProfileBtn() {
		return profileBtn;
	}

	public void clickProfileBtn() {
		getProfileBtn().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'dropdown-menu')]//i[text()='logout']")));

		System.out.println("Profile button has been clicked. Dropdown is displayed...");
	}

	// Click in Logout option for supplier role.

	@FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]//i[text()='logout']")
	WebElement logoutBtn;

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public void clickLogoutBtn() {
		getLogoutBtn().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//form//input[@name='email' and @type='text']")));

		System.out.println("The user is logged off as expected.");
	}
}