package demo_Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener_demo implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" test case started");			
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase passed is :"+result.getName());	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is :"+result.getName());			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase Skipped is :"+result.getName());		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("The testing is Started: "+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("The testng is ended: "+context.getName());
	}

}
