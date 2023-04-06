package IrisRodriguez;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;

public class appiumTest {
	public AndroidDriver driver;
	public WebDriverWait wait;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Nexus_S_API_22");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "5.1.1");
		caps.setCapability("automatorName", "UiAutomator2");
		caps.setCapability("noSign", "true");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void testCal() throws Exception {
		// locate the Text on the calculator by using By.name()
		WebElement seven = driver.findElement(By.id("com.android.calculator2:id/digit_7"));
		seven.click();
		WebElement plus = driver.findElement(By.id("com.android.calculator2:id/op_add"));
		plus.click();
		WebElement three = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
		three.click();
		WebElement equalTo = driver.findElement(By.id("com.android.calculator2:id/eq"));
		equalTo.click();

		// locate the edit box of the calculator by using By.tagName()
		WebElement results = driver.findElement(By.className("android.widget.EditText"));

		// Check the calculated value on the edit box
		assert results.getText().toString().equals("10")
				: "Actual value is : " + results.getText() + " did not match with expected value: 6";
	}

	@AfterClass
	public void teardown() { // close the app
		driver.quit();
	}

}