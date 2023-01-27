package Diana;

import org.testng.annotations.DataProvider;

public class dataProvider_hotelCustomer {
@DataProvider (name = "dataCreditCard")
public Object [] [] dpCreditCard(){
	return new Object[][] {
		{"4242 4242 4242 4242","1024","123","Diana Velasquez"}
	};
}
		
}
