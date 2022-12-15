package AdvantageOnlineShopping;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class verifySocialApps {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {

		System.setProperty("webdriver.gecko.driver", "C:\\Selenium Training\\geckodriver-v0.31.0-win64\\geckodriver.exe" );
		driver = new FirefoxDriver();
		
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	
	@Test
	public void verifySocialAppsFromContactUsScreen() {
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
		
		
		//click the contact US button
		WebElement contactUSButton = driver.findElement(By.xpath("//a[@translate='CONTACT_US']"));
		contactUSButton.click();
		
		String mainWindow = driver.getWindowHandle();
		int noOpenedWindow = driver.getWindowHandles().size();
		
		//explicit wait
		WebDriverWait waitFor = new WebDriverWait(driver,  Duration.ofSeconds(4), Duration.ofSeconds(2));

		//wait for facebook button
		waitFor.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@name='follow_facebook']/..")));
		
		//click the contact us facebook button
		System.out.println("Click facebook button");
		WebElement facebookButton = driver.findElement(By.xpath("//img[@name='follow_facebook']"));
		facebookButton.click();
		
		
		//wait for the new opened window
		waitFor.until(ExpectedConditions.numberOfWindowsToBe(noOpenedWindow+1));
		
		for (String windowHandle:driver.getWindowHandles()) {
			if (!mainWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
				
			}
		}
		
		
		WebElement facebookContactUsButton = driver.findElement(By.xpath("//span[text()='Contactarnos']"));
		
		if (facebookContactUsButton.isDisplayed())
			System.out.println("PASSED: The facebook contact button is displayed");
		else 
			Assert.fail("FAILED: the facebook contact button was not displayed");
		
		//close facebook window
		driver.close();
		
		//switch to the main window
		driver.switchTo().window(mainWindow);
		
		System.out.println("Click twitter button");
		WebElement twitterButton = driver.findElement(By.xpath("//img[@name='follow_twitter']"));
		twitterButton.click();
		
		//wait for the new opened window
		waitFor.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		for (String windowHandle:driver.getWindowHandles()) {
			if (!mainWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
				
			}
		}
		
		//verify label in twitter window
		WebElement twitterLabel = driver.findElement(By.xpath("(//span[text()='Micro Focus'])[1]" ));
		if (twitterLabel.isDisplayed())
			System.out.println("PASSED: The twitter page was opened sucessfully");
		else
			Assert.fail("FAILED: Twitter page was not opened");
		
		//close twitter window
		driver.close();
		
		//switch to main window
		driver.switchTo().window(mainWindow);
		
	}
}
