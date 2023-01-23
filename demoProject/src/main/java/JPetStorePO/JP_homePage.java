package JPetStorePO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JP_homePage {
	WebDriver Driver;
 public JP_homePage(WebDriver Driver) {
	 this.Driver=Driver;
	PageFactory.initElements(Driver, this);

 }
	
// ---------- SELECT DOGS TAB ----------------- DIANA
	// XPATHS FOR DOGS TAB
@FindBy (xpath = "//*[@href='/actions/Catalog.action;jsessionid=3770D7D5B4516EE0D2E3E630D400835E?viewCategory=&categoryId=DOGS']" ) WebElement dogsTab;


}
