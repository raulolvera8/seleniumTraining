package AdvantageOnlineShopping;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import library.Driver;
import pageObjectRepository.AOSChAddToCart;
import pageObjectRepository.AOSChOCheckOut;
import pageObjectRepository.AOSChOValidationPayment;
import pageObjectRepository.AOSChOhomepage;
import pageObjectRepository.AOSChOpayment;
import pageObjectRepository.AOSChOproductsCategory;
public class checkoutAOS extends Driver{
    WebDriver driver;
    @BeforeClass
    public void setup() {
        System.out.println("SET UP  DRIVER");
        this.driver=initFirefoxDriver();
    }
    @Test
    public void POMExcerciseADS(){
        AOSChOhomepage signIn=new AOSChOhomepage(driver);
        AOSChOproductsCategory selectedOfItems= new AOSChOproductsCategory(driver);
        AOSChAddToCart AddToCartbtn = new AOSChAddToCart(driver);
        AOSChOCheckOut shoppingCart = new AOSChOCheckOut(driver);
        AOSChOpayment pay = new AOSChOpayment(driver);
        AOSChOValidationPayment validation= new AOSChOValidationPayment(driver);
        signIn.clickUserButton();
        signIn.enterUsernameInput("dianavbet");
        //enter password
        signIn.enterPasswordInput("Andromeda21");
        //------------------------------click sign in button-----------------------------------------//
        signIn.clickSignInButton();
        //------------------------------click category-----------------------------------------//
        signIn.selectCategorie();
        //------------------------------Click item -----------------------------------------//
        selectedOfItems.selectItem();
        //------------------------------Click Add To Cart Button -----------------------------------------//
        AddToCartbtn.buttonAddToCart();
        //------------------------------Select Cart Icon -----------------------------------------//
        AddToCartbtn.selectCartIcon();
        //------------------------------Click  checkout Button -----------------------------------------//
        shoppingCart.selectCheckOutBtn();
        //------------------------------Click next  Order payment Button -----------------------------------------//
        pay.clickNextbtn();
        //------------------------------click pay now Button  -----------------------------------------//
        pay.clicPayNowBtn();
        //------------------------------Final Validation ------------------------------//
        validation.msgValidation();     
        // ------------------------------ Order number validation //
        validation.orderNumber();
    }
    @AfterClass
    public void teardown() {
}
}