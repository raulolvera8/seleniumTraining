package library;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class utilities{
	WebDriver driver;
	public utilities(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void  ScrollDown(WebDriver driver, String X, String Y) throws InterruptedException     {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("window.scroll("+X+","+Y+")");
	  	Thread.sleep(1000);

	  }
	public void elementScrollDown(WebElement element) throws InterruptedException {
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	  	Thread.sleep(1000);

	}
}
