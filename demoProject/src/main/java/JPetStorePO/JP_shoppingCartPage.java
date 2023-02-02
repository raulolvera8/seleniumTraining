package JPetStorePO;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JP_shoppingCartPage {
	WebDriver Driver;

	public JP_shoppingCartPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);

	}
	
	// ----------- CHANGE QUANTITY ---------- DIANA
	// ---- XPAHT ----
	@FindBy (xpath="//tr[2]/td[5]/input") WebElement quantityInput;
	
	public WebElement getQuantityInput() {
		return quantityInput;
	}
	public void changeQuanity(String quantities) throws InterruptedException {
		getQuantityInput().clear();
		Thread.sleep(1000);
		getQuantityInput().sendKeys(quantities);
	}
	
	//- ------ GET QUANTITY OF PRODUCT ------ DIANA
	public String readQuantityInput() {
		String quantity =getQuantityInput().getAttribute("value");
		return  quantity;
	}
	
	// ------ GET LIST PRICE --------- DIANA
	@FindBy (xpath="//tr[2]/td[6]") WebElement listPriceLabel;

	public WebElement getListPriceLabel() {
		return listPriceLabel;
	}
	public String readListPriceLabel() {
		String listPriceLabel = this.getListPriceLabel().getText();
		 return listPriceLabel.substring(1);

	}
	// ---------- GET TOTAL COST --------- DIANA
	// --------- XPATH
	@FindBy (xpath="//tr[2]/td[7]") WebElement totalCostLabel;
	public WebElement getTotalCostLabel() {
		return totalCostLabel;
	}
	public String readTotalCostLabel() {
		String label = this.getTotalCostLabel().getText();
		 return label.substring(1);
	}
	// ----------- UPDATE CART BUTTON ------ DIANA
		// ------ XPATH -----
		@FindBy (name="updateCartQuantities") WebElement updateCartBtn;
		
		public WebElement getUpdateCartBtn() {
			return updateCartBtn;
		}
		public void clickUpdateCartBtn() {
			getUpdateCartBtn().click();
		}
	// --------- PROCEED TO CHECKOUT -------- DIANA
	// ------ XPATH
	@FindBy (xpath="//*[@class='Button'][text()='Proceed to Checkout']") WebElement ProceedtoCheckoutBtn;	
	public WebElement getProceedtoCheckoutBtn() {
		return ProceedtoCheckoutBtn;
	}
	public void clickProceedtoCheckoutBtn() {
		getProceedtoCheckoutBtn().click();;
	}
}
