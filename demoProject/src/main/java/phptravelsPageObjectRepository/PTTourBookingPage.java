package phptravelsPageObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.utilities;

public class PTTourBookingPage {
	WebDriver driver;
	///utilities utils;


	public PTTourBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//------------TRAVELLERS INFORMATION----------
	
	
		//TRAVELLER 1
		@FindBy(xpath="//*[@name='title_1']//option[@value='Mr']") WebElement traveller1;
		@FindBy(xpath="//*[@name='firstname_1']") WebElement firstName1;
		@FindBy(xpath="//*[@name='lastname_1']") WebElement lastName1;


		public WebElement getTraveller1() {
			 return traveller1;


			}

			public void clickTraveller1() {


			getTraveller1().click();

			WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
			Duration.ofSeconds(5));
			waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
			("//*[text()='Tour Booking']")));

				

			}
			public WebElement getFirstName1() {
				return firstName1;
			}


			public void writeFirstName1(String firstName) {			
				getFirstName1().sendKeys(firstName);
					
					
				WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
						Duration.ofSeconds(5));
						waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
						("//*[text()='Tour Booking']")));
				
				}
			public WebElement getLastName1() {
				return lastName1;
			}


			public void writeLastName1(String lastName) {			
				getLastName1().sendKeys(lastName);
					
					
				WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
						Duration.ofSeconds(5));
						waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
						("//*[text()='Tour Booking']")));
				
				}
			
			
			//TRAVELLER 2
			@FindBy(xpath="//*[@name='title_2']//option[@value='Mrs']") WebElement traveller2;
			@FindBy(xpath="//*[@name='firstname_2']") WebElement firstName2;
			@FindBy(xpath="//*[@name='lastname_2']") WebElement lastName2;


			public WebElement getTraveller2() {
				 return traveller2;


				}

				public void clickTraveller2() {


				getTraveller2().click();

				WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
				Duration.ofSeconds(5));
				waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
				("//*[text()='Tour Booking']")));

					

				}
				public WebElement getFirstName2() {
					return firstName2;
				}


				public void writeFirstName2(String firstName) {			
					getFirstName2().sendKeys(firstName);
						
						
					WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
							Duration.ofSeconds(5));
							waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
							("//*[text()='Tour Booking']")));
					
					}
				public WebElement getLastName2() {
					return lastName2;
				}


				public void writeLastName2(String lastName) {			
					getFirstName2().sendKeys(lastName);
						
						
					WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
							Duration.ofSeconds(5));
							waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
							("//*[text()='Tour Booking']")));
					
					}
				
				//TRAVELLER 3
				
				@FindBy(xpath="//*[@name='title_3']//option[@value='Miss']") WebElement traveller3;
				@FindBy(xpath="//*[@name='firstname_3']") WebElement firstName3;
				@FindBy(xpath="//*[@name='lastname_3']") WebElement lastName3;


				public WebElement getTraveller3() {
					 return traveller3;


					}

					public void clickTraveller3() {

					getTraveller3().click();

					WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
					Duration.ofSeconds(5));
					waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
					("//*[text()='Tour Booking']")));



					}
					public WebElement getFirstName3() {
						return firstName3;
					}


					public void writeFirstName3(String firstName) {			
						getFirstName3().sendKeys(firstName);
							
							
						WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
								Duration.ofSeconds(5));
								waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
								("//*[text()='Tour Booking']")));
						
						}
					public WebElement getLastName3() {
						return lastName3;
					}


					public void writeLastName3(String lastName) {			
						getFirstName3().sendKeys(lastName);
							
							
						WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
								Duration.ofSeconds(5));
								waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
								("//*[text()='Tour Booking']")));
						
						}
					
					//TRAVELLER INFORMATION 4
					@FindBy(xpath="//*[@name='title_4']//option[@value='Miss']") WebElement traveller4;
					@FindBy(xpath="//*[@name='firstname_4']") WebElement firstName4;
					@FindBy(xpath="//*[@name='lastname_4']") WebElement lastName4;
					
					public WebElement getTraveller4() {
						 return traveller4;


						}

						public void clickTraveller4() {


						getTraveller4().click();

						WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
						Duration.ofSeconds(5));
						waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
						("//*[text()='Tour Booking']")));

							

						}
						public WebElement getFirstName4() {
							return firstName4;
						}


						public void writeFirstName4(String firstName) {			
							getFirstName4().sendKeys(firstName);
								
								
							WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
									Duration.ofSeconds(5));
									waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
									("//*[text()='Tour Booking']")));
							
							}
						public WebElement getLastName4() {
							return lastName4;
						}


						public void writeLastName4(String lastName) {			
							getFirstName4().sendKeys(lastName);
								
								
							WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
									Duration.ofSeconds(5));
									waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
									("//*[text()='Tour Booking']")));
							
							}
						
						//PAYMENT METHOD
						
						@FindBy(xpath="//*[@id='gateway_stripe']") WebElement paymentMethod;
						
						public WebElement getPaymentMethod() {
							 return paymentMethod;


							}

							public void clickPaymentMethod() {


							getPaymentMethod().click();

							WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
							Duration.ofSeconds(5));
							waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
							("//*[text()='Tour Booking']")));
							
							}
							
							
							@FindBy(xpath="//*[@id='agreechb']") WebElement checkboxContinuing;
							
							public WebElement getContinuing() {
								 return checkboxContinuing;


								}

								public void clickContinuing() {


								getContinuing().click();

								WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
								Duration.ofSeconds(5));
								waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
								("//*[text()='Tour Booking']")));
								
								}
								
								
								@FindBy(xpath="//*[@id='booking']") WebElement confirmBooking;
								
								public WebElement getconfirm() {
									 return confirmBooking;


									}

									public void clickConfirmBooking() {


									getconfirm().click();

									WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10),
									Duration.ofSeconds(5));
									waitElement.until(ExpectedConditions.elementToBeClickable(By.xpath
									("//*[text()='Tour Booking']")));
									
									}
									
									
	

}
