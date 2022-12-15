package AdvantageOnlineShopping;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

public class shoppingCart {
	WebDriver driver;
	String path = "C:\\Selenium Training\\shoppingCart Captures\\";
	
	@BeforeClass
	public void setup() {

		System.setProperty("webdriver.gecko.driver", "C:\\Selenium Training\\geckodriver-v0.31.0-win64\\geckodriver.exe" );
		driver = new FirefoxDriver();
		
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	
	public void screenshot (WebDriver webdriver, String pathToFile ) throws Exception {
		//convert the driver object to takescreenshot
		TakesScreenshot capture = ((TakesScreenshot) webdriver);
		
		//call getscreenshotAs method so we can create the image file
		File srcFile = capture.getScreenshotAs(OutputType.FILE);
		
		File destinationFile = new File (pathToFile);
		
		FileUtils.copyFile(srcFile, destinationFile);
		
	}

	public void screenshot (WebElement Element, String pathToFile ) throws Exception {
		//convert the driver object to takescreenshot
		TakesScreenshot capture = ((TakesScreenshot) Element);
		
		//call getscreenshotAs method so we can create the image file
		File srcFile = capture.getScreenshotAs(OutputType.FILE);
		
		File destinationFile = new File (pathToFile);
		
		FileUtils.copyFile(srcFile, destinationFile);
		
	}
	
	
	@Test
	public void shoppingCartItems() throws Exception {
		String URL = "https://www.advantageonlineshopping.com/#/";
		
		System.out.println("Navigating to Advantage Online Shopping");
		driver.navigate().to(URL);
		
		//setting the implicit wait for all objects
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(ElementNotInteractableException.class);
		
		//wait for invisibility of loading message
		wait.until(ExpectedConditions.attributeToBe(By.xpath("(//div[@class='loader'])[1]"), "style", "display: none; opacity: 0;"));
		
		//wait for visibility of contact us button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@translate='CONTACT_US']")));
		
		this.screenshot(driver, path + "initialScreen.png");
		
		//click user menu
		WebElement userMenu = driver.findElement(By.id("menuUserSVGPath"));
		userMenu.click();
		
		
		//enter username
		WebElement usernameInput = driver.findElement(By.name("username"));
		usernameInput.sendKeys("itstark");
		
		//enter password
		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.sendKeys("Itstark123");
		

		
		//wait for cart page
		WebDriverWait waitElement = new WebDriverWait (driver,Duration.ofSeconds(6),Duration.ofSeconds(3));
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='SIGN IN']")));

		this.screenshot(usernameInput, path + "user.png");
		this.screenshot(driver, path + "login.png");
		
		//click sign in button
		WebElement signInButton = driver.findElement(By.xpath("//button[text()='SIGN IN']"));
		signInButton.click();
		
		//wait for pop up disappears
		WebDriverWait waitPopUp= new WebDriverWait (driver,Duration.ofSeconds(6),Duration.ofSeconds(3));
		waitElement.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='PopUp']"), "style", "display: none;"));
		
		//click cart button
		WebElement cartButton = driver.findElement(By.id("menuCart"));
		cartButton.click();
		
		//wait for cart page
		WebDriverWait waitPage = new WebDriverWait (driver,Duration.ofSeconds(6),Duration.ofSeconds(3));
		waitPage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'SHOPPING CART')]")));
		
		
		WebElement headerCart = driver.findElement(By.xpath("//h3[contains(text(),'SHOPPING CART')]"));
		headerCart.click();
		
		//wait for tooltip cart is not visible
		waitPopUp.until(ExpectedConditions.attributeContains(By.id("toolTipCart"), "style", "display: none;"));
		

		this.screenshot(driver, path + "shoppingCart.png");
		
		List<WebElement> elementList = driver.findElements(By.xpath("//table[@class= 'fixedTableEdgeCompatibility']/tbody/tr[position()=1]/td/child::*"));
		
		System.out.println("Count of found elements: "+ elementList.size());
		
		//print data in the output
		for (WebElement element : elementList) {
			System.out.println("Class: "+ element.getText());
		}
		

		List<WebElement> removeButtonList = driver.findElements(By.xpath("//a[@translate='REMOVE']"));
		int countOfRemoveButtons = removeButtonList.size();
		
		// click on remove button
		for (int row=1;row<= countOfRemoveButtons;row++) {
			removeButtonList = driver.findElements(By.xpath("//a[@translate='REMOVE']"));
			removeButtonList.get(0).click();
		}
		
	}
}
