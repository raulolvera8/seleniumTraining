package library;

import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class listenersJuan implements ITestListener, ISuiteListener  {
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(" Test case started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase passed is:"+result.getName());	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is:" + result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase Skipped is:"+result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("The test execution has been completed partly: " + result.getName());

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Class starting with tests to execute: " + context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Class finishing with tests to execute: " + context.getName());

	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Suite main method started: " + suite.getName());

	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Suite main method finished: " + suite.getName());

	}
	

}
