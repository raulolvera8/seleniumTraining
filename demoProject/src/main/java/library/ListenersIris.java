package library;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersIris implements ITestListener, ISuiteListener {

	// WHEN TEST CASE GET STARTED, THIS METHOD IS CALLED
	@Override
	public void onTestStart(ITestResult result) {
		//System.out.println(result.getName()+" test case started");
		 String testMethodName = getTestMethodName(result);
		    System.out.println("Thread: " + Thread.currentThread().getId() + " STARTING TEST - " + testMethodName);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		 System.out.println("Running NG Test - " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ISuite suite) {
		 System.out.println("onStart: before suite starts");
	}

	@Override
	public void onFinish(ISuite suite) {
        System.out.println("onFinish: after suite completes");
	}

	public static String getTestMethodName(ITestResult testResultOfTestMethodThatWasRun) {
		return testResultOfTestMethodThatWasRun.getMethod().getMethodName();
	}

}
