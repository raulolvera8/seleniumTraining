package library;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class utilities{
	WebDriver driver;
	public utilities(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void  ScrollDown(WebDriver driver, String X, String Y) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("window.scroll("+X+","+Y+")");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	  }
	public void elementScrollDown(WebElement element) {
		try {
			JavascriptExecutor js;
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		  	Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Error when trying to locate the element " );
			e.printStackTrace();
		}

	}
	
	public void waiting() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	//wait loader
	
	
	
	//
}
	
}
