package phptravelsPageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PTVisaPage {
	WebDriver driver;

	public PTVisaPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="select2-from_country-container") WebElement fromCountryBtn;
	@FindBy(id="select2-to_country-container") WebElement toCountryBtn;
	@FindBy (id="date") WebElement selectDateBox;
	@FindBy (xpath="//td[@class='day '][contains(text(),'26')]") WebElement selectDayCalendar;
	@FindBy (id="submit") WebElement searchIcon;
	
	//---SELECT FROM COUNTRY---- 
public WebElement getFromCountryBtn() {
return fromCountryBtn;
} 
public void clickFromCountry() {
getFromCountryBtn().click();
}

public void selectItemFromCountry() {
List <WebElement> ListFromCountry =driver.findElements(By.xpath("//*[@id='select2-from_country-results']//li")); ;
ListFromCountry.get(9).click();
}
		//------SELECT TO COUNTRY
public WebElement getToCountryBtn() {
return toCountryBtn;
} 

public void clickToCountryBtn() {
getToCountryBtn().click();
}
public void selectItemToCountry() {
List <WebElement> ListToCountry =driver.findElements(By.xpath("//*[@id='select2-to_country-results']/li")); ;	
ListToCountry.get(5).click();
}
		//-------SELECT DATE BOX -----
public WebElement getDateBox() {
return selectDateBox;
}
public void selectDateBox() {
getDateBox().click();
}
		//-------SELECT DAY-----------------//
public WebElement getDayCalendar() {
return selectDayCalendar;
}
public void clickDayCalendar() {
getDayCalendar().click();
}
		//-----SEARCHING ICON -----///
public WebElement getSearchIcon() {
return searchIcon;
}
public void clickSearchIcon() {
getSearchIcon().click();
}

}
