package library;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTest_Elias implements ITestListener, ISuiteListener{
	
	//Suite Listeners.
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Suite main method started: " + suite);
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Suite main method finished: " + suite);
		
	}
	
	//Test Listeners.

	@Override //On Method test level.
	public void onTestStart(ITestResult result) {
		System.out.println("Commencing test execution: " + result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The test execution has finished successfully: " + result);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The test execution has finished failed: " + result);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The test execution has skipped some tests: " + result);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("The test execution has been completed partly: " + result);
		
	}

	@Override //Class Level.
	public void onStart(ITestContext context) {
		System.out.println("Class starting with tests to execute: " + context);
		
	}

	@Override //Class Level.
	public void onFinish(ITestContext context) {
		System.out.println("Class finishing with tests to execute: " + context);
		
	}

}
