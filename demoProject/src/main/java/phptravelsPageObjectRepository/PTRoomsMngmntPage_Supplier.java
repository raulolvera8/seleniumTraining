package phptravelsPageObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class PTRoomsMngmntPage_Supplier {
	WebDriver driver;

	public PTRoomsMngmntPage_Supplier(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ******************************************************
	// Objective: VERIFIES IF THE ROOM HAS BEEN ADDED IN 'ROOMS MANAGEMENT' SCREEN.
	// Author: Elías Lara.
	// Date of creation/adding: 01 17 23
	// *******************************************************

	public void VerifyIfRoomIsAdded(String roomName) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.attributeToBe(By.xpath("//button[@type='submit']"), "class",
				"btn btn-success mdc-ripple-upgraded"));
		try {
			boolean roomElement = driver
					.findElement(
							By.xpath("//tr[@class='xcrud-row xcrud-row-0']//a[contains(text(), '" + roomName + "')]"))
					.isDisplayed();
			if (roomElement) {
				System.out.println("The room is shown properly in 'Rooms Management' page...");
			}
		} catch (Exception e) {
			System.out.println("The room has not been reflected as expected. Please check.");
			e.printStackTrace();
			Assert.fail();
		}
	}

}
