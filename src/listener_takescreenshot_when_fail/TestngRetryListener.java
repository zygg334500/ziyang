package listener_takescreenshot_when_fail;

import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Interface.TestInfo;


public  class TestngRetryListener implements ITestListener {

	public void onTestFailure(ITestResult result) {
		String s= result.getInstanceName();

	    String className=s;
		try {
			ScreenShotOnFailure.takeScreentShot(result.getInstanceName());
			TestInfo test=(TestInfo)Class.forName(className).newInstance();
			System.out.println(test.getDriver().getScreenshotAs(OutputType.FILE) + " failed, the screenshot saved in "
					+ ScreenShotOnFailure.getScreenShotPath() + " screenshot name : "
					+ ScreenShotOnFailure.getScreenShotName());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
}