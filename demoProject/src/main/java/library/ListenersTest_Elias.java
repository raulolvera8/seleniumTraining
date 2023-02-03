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
		System.out.println("Suite main method started: " + suite.getName());
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Suite main method finished: " + suite.getName());
		
	}
	
	//Test Listeners.

	@Override //On Method test level.
	public void onTestStart(ITestResult result) {
		System.out.println("Commencing test execution: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The test execution has finished successfully: " + result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The test execution has finished failed: " + result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The test execution has skipped some tests: " + result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("The test execution has been completed partly: " + result.getName());
		
	}

	@Override //Class Level.
	public void onStart(ITestContext context) {
		System.out.println("Class starting with tests to execute: " + context.getName());
		
	}

	@Override //Class Level.
	public void onFinish(ITestContext context) {
		System.out.println("Class finishing with tests to execute: " + context.getName());
		
	}

}
