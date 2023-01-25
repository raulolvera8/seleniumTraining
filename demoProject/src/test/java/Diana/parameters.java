package Diana;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters; 
import org.testng.annotations.Test;
public class parameters {
	// This test method will take one parameter as input. The value of parameter is defined at suite level.  @Parameters({"Name"}) 
	@BeforeClass (alwaysRun=true)
	public void setup() {
		
	}

	@Parameters({"name"}) 
	@Test(priority = 1) 
	public void stName(String n) 
	{ 
	  System.out.println("Student's name: " +n); 
	} 
	@Parameters({"School"}) 
	@Test(priority = 2) 
	
	public void scName(String sc) 
	{ 
	  System.out.println("School's name: " +sc); 
	} 
	// This test method will take two parameters as input. // The value of test parameter is defined at the test level. The suite level parameter is overridden at test level.  @Parameters({"STD", "RollNo"}) 
	@Parameters({"parameter_1", "parameter_2"}) 
	@Test(priority = 3) 
	public void rollSTD(String s, String r) 
	{ 
	   System.out.println("STD: " +s); 
	   System.out.println("Roll No: " +r); 
	  }
	@AfterClass (alwaysRun=true)
	public void tearDown() {
	}
}
