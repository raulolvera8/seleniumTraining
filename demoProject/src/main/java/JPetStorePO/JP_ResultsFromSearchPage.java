package JPetStorePO;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JP_ResultsFromSearchPage {

	WebDriver driver;

	public JP_ResultsFromSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ------------------ GET ELEMENTS FROM TABLE RESULTS -------------------- IRIS
	@FindBy(xpath = "//td/a[text()]")
	List<WebElement> PrintResults;

	public List<WebElement> getPrintResults() {
		return PrintResults;
	}

	public void PrintResults() {
		System.out.println("Your search contains the following results: ");
		for (int indice=0; indice<PrintResults.size(); indice++ ) {
			System.out.println("" + PrintResults.get(indice).getAttribute("text"));
		}
	}
	
}
