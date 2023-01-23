package JPetStorePO;

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

public class JP_homePage {
	WebDriver Driver;

	public JP_homePage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);

	}

// ---------- SELECT DOGS TAB ----------------- DIANA
	// XPATHS FOR DOGS TAB
	@FindBy(xpath = "//*[@href='/actions/Catalog.action;jsessionid=3770D7D5B4516EE0D2E3E630D400835E?viewCategory=&categoryId=DOGS']")
	WebElement dogsTab;

//******************************************************
//Title:clickReptilesIcon
//Objective: Click on Reptiles Icon.
//Author: Elías Lara.
//Date of creation/adding: 01 23 23
//*******************************************************

	@FindBy(xpath = "(//img[contains(@src, 'reptiles')])[2]")
	WebElement reptilesIcon;

	public WebElement getReptilesIcon() {
		return reptilesIcon;
	}

	public void clickReptilesIcon() {
		getReptilesIcon().click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(Driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Reptiles']")));

		System.out.println("The Reptiles Icon has been clicked. The user is now in Reptiles Dashboard...");
	}

	//--------------------- CLICK ON FISH ICON --------------------------- IRIS
	@FindBy(xpath = "//img[@src='../images/fish_icon.gif']")
	WebElement fishIcon;

	public WebElement getFishIcon() {
		return fishIcon;
	}

	public void clickFishesIcon() {
		getFishIcon().click();

		System.out.println("Clicking on Fish section... glu glu glu...");
	}

	//--------------------- CLICK ON FIRST ELEMENT FROM TABLE--------------------------- IRIS
	@FindBy(xpath = "(//td)[1]")
	WebElement FirstElementTable;

	public WebElement getFirstElementTable() {
		return FirstElementTable;
	}

	public void clickFirstElementTable() {
		getFirstElementTable().click();

		System.out.println("Clicking on first option...");
	}
}
