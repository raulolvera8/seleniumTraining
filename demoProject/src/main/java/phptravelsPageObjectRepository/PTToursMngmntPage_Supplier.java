package phptravelsPageObjectRepository;

import java.time.Duration;
import java.util.List;
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

import library.utilities;

//##################### CLASS AND CODE CREATED BY ELIAS LARA.

public class PTToursMngmntPage_Supplier {

	WebDriver driver;
	PTAddTourPage_Supplier addTour;

	public PTToursMngmntPage_Supplier(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		addTour = new PTAddTourPage_Supplier(driver);
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
		WebElement table = driver.findElement(By.xpath("//div[@id='layoutDrawer_content']//table"));
		List<WebElement> rows = table
				.findElements(By.xpath("//div[@id='layoutDrawer_content']//table//tr[@class='xcrud-th']"));

		Assert.assertEquals(rows.size(), 13);
		System.out.println("Total Rows count in table" + rows.size());

		for (WebElement row : rows) {
			List<WebElement> cols = row
					.findElements(By.xpath("//div[@id='layoutDrawer_content']//tr[@class='xcrud-row xcrud-row-0']"));

			// column count assert and count
			Assert.assertEquals(cols.size(), 13);
			System.out.println("Total Column count in each row" + cols.size());

			for (WebElement col : cols) {
				// to select specific column compare its text
				if (col.getText().equals(tourName)) {
					Assert.assertTrue(true, "Tour Name: " + tourName);
					System.out.println("The tour has been added properly and is shown in the dashboard screen.");
				} else {
					Assert.assertFalse(false, "The tour name does not match with the expected one: " + tourName);
				}

			}
		}

	}

}
