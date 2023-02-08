package library;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersIris implements ITestListener, ISuiteListener {

	// SUITE LEVEL
	@Override
	public void onStart(ISuite suite) {
		 System.out.println("onStart: before suite starts");
	}

	@Override
	public void onFinish(ISuite suite) {
        System.out.println("onFinish: after suite completes");
	}

	// TEST
	// WHEN TEST CASE GET STARTED, THIS METHOD IS CALLED
	@Override
	public void onTestStart(ITestResult result) {
        System.out.println(result.getName()+" test case started");
	}

	// WHEN TEST CASE GET PASSED, THIS METHOD IS CALLED
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase passed is: "+result.getName());
	}
	
	// WHEN TEST CASE GET FAILED, THIS METHOD IS CALLED 
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is: " + result.getName());
	}

	// WHEN TEST CASE GET SKIPPED, THIS METHOD IS CALLED
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase Skipped is: "+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Failure of test cases and its details are : "+result.getName());  
	}
	
	//Invoked after the test class is instantiated and before any configuration method is called.
	@Override
	public void onStart(ITestContext context) {
		System.out.println("I am in onStart method " + context.getName());
	}

	//Invoked after all the tests have run and all their Configuration methods have been called.
	@Override
	public void onFinish(ITestContext context) {
        System.out.println("I am in onFinish method " + context.getName());
	}
}
