package JPetStorePO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JP_ReptilesDashboard {
	WebDriver Driver;

	public JP_ReptilesDashboard(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}

	// ******************************************************
	// Title: validateFirstColumn.
	// Objective: Extracts the value from first column and shows it to the user.
	// Author: Elías Lara.
	// Date of creation/adding: 01 23 23
	// *******************************************************

	@FindBy(xpath = "(//tbody/tr//td[text()])[1]")
	WebElement firstColumn;

	public WebElement getFirstColumn() {
		return firstColumn;
	}

	public void validateFirstColumn() {
		String value = getFirstColumn().getText();
		System.out.println("The value obtained in the first column is " + value + ".");
	}

	// ******************************************************
	// Title: validateSecondColumn.
	// Objective: Extracts the value from second column and shows it to the user.
	// Author: Elías Lara.
	// Date of creation/adding: 01 23 23
	// *******************************************************

	@FindBy(xpath = "(//tbody/tr//td[text()])[2]")
	WebElement secondColumn;

	public WebElement getSecondColumn() {
		return secondColumn;
	}

	public void validateSecondColumn() {
		String value = getSecondColumn().getText();
		System.out.println("The value obtained in the second column is " + value + ".");
	}

}
