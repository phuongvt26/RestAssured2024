package RestAssured.Listen;

import org.example.untils.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onStart(ITestContext result) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onFinish(ITestContext result) {
        // TODO Auto-generated method stub

    }
    @Override

    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
//        System.out.println("Đây là test case success: " + result.getName()+ " is passed.");
        LogUtils.info("Test case pass " + result.getName()+ " is passed.");
    }
    @Override
    public void onTestFailure(ITestResult result) {
//        System.out.println("Đây là test case failed: " + result.getName()+ " is failed." );
        LogUtils.error("Tcs failed "+result.getName()+ " is failed.");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
    }

}
