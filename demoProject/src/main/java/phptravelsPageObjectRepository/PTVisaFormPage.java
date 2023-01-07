package phptravelsPageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PTVisaFormPage {
	WebDriver driver;

	public PTVisaFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//-----------------SUBMISSION FORM -------------//
	
		@FindBy (name="first_name") WebElement firstNameTb;
		@FindBy (name="last_name") WebElement lastNameTb;
		@FindBy (name="email") WebElement emailTb;
		@FindBy (name="phone") WebElement phoneTb;
		@FindBy (name="notes") WebElement notesTb;
		@FindBy (id="submit") WebElement submitBtn;

		
		//------- FIRST NAME-----------------//

		public WebElement getFirstName() {
			return firstNameTb;
		}
		public void writeFirstName(String firstName) {
			getFirstName().sendKeys(firstName);
		}
		//------- LAST NAME-----------------//

		public WebElement getLasttName() {
			return lastNameTb;
		}
		public void writeLastName(String lastName) {
			getLasttName().sendKeys(lastName);
		}
		//------- EMAIL -----------------//

		public WebElement getEmail() {
			return emailTb;
		}
		public void writeEmail(String email) {
			getEmail().sendKeys(email);
		}
		//------- PHONE -----------------//

		public WebElement getPhone() {
			return phoneTb;
		}
		public void writePhone(String phone) {
			getPhone().sendKeys(phone);
		}
		//------- NOTES-----------------//

		public WebElement getNotes() {
			return notesTb;
		}
		public void writeNotes(String notes) {
			getNotes().sendKeys(notes);
		}
		
		//-------  SUMBIT BTN-----------------//
		public WebElement getSubmitBtn() {
			return submitBtn;
		}
		public void clickSubmitBtn() {
			getSubmitBtn().click();
			
		}
}
