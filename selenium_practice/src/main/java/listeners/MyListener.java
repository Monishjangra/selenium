package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        String name = result.getName();
        System.out.println(name +" start executing");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String name = result.getName();
        System.out.println(name +" got successful ");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String name = result.getName();
        System.out.println(name +" got failed ");
        System.out.println(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String name = result.getName();
        System.out.println(name +" got skipped ");
        System.out.println(result.getThrowable());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println(" project test start");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(" project test finish");
    }

}
