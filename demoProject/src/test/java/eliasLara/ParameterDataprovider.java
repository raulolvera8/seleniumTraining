package eliasLara;

import org.testng.annotations.DataProvider;

public class ParameterDataprovider {
	@DataProvider(name = "dataTour")
	public static Object[] allTourInfo() {

		return new Object[][] {

				{ "supplier@phptravels.com", "demosupplier", "Asiatic Memories Tour",
						"This is a brief description about Asiatic Memories Tour thorugh most famous places in Asia.", "2", "250.00", "Yakarta",
						"ASIATIC MEMORIES", "An Asiatic Tour along the most beautiful cities in this continent.", "This is a Meta Description.", "Credit Card",
						"This is a text describing the Policy and Terms of the trip.", "asiatictours@dummymail.com",
						"asiatictoursandtrips.com", "8444578962", "Random St. 4552 WA", "72", "3", "2", "Couples" } 
				};
	}
}
