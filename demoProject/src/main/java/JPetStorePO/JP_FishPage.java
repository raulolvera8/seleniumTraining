package JPetStorePO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JP_FishPage {

	WebDriver Driver;

	public JP_FishPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);

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
	
	// ------------------ GET PRODUCT ID FIRST ELEMENT FROM TABLE ---------------------------- IRIS
	@FindBy(xpath = "(//tr/td[1])[1]")
	WebElement PrintIdFirstElementTable;

	public WebElement getPrintIdFirstElementTable() {
		return FirstElementTable;
	}

	public void PrintIdFirstColumn() {
		String value = getPrintIdFirstElementTable().getText();
		System.out.println("The first Product ID is " + value + ".");
	}
	
	// ------------------ GET NAME FIRST ELEMENT FROM TABLE ---------------------------- IRIS
	@FindBy(xpath = "(//tr/td[2])[1]")
	WebElement PrintNameFirstElementTable;

	public WebElement getPrintNameFirstElementTable() {
		return PrintNameFirstElementTable;
	}

	public void PrintNameFirstColumn() {
		String value = getPrintNameFirstElementTable().getText();
		System.out.println("The first fish name is " + value + ".");
	}

}
