package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExtentTestListener implements ITestListener {

    private ExtentReports extentReports;
    private ExtentTest extentTest;
    private WebDriver driver;



    @Override
    public void onStart(ITestContext context) {
        // Create the HTML reporter and attach it to ExtentReports
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a test in ExtentReports
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("WebDriver");

        if (driver != null) {
            // Capture screenshot on failure
            String screenshotPath = takeScreenshot(result.getMethod().getMethodName(),driver);
            extentTest.fail(result.getThrowable().getMessage());
            extentTest.addScreenCaptureFromPath(screenshotPath);  // Attach screenshot
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Write the test results to the report file
        extentReports.flush();
    }

    private String takeScreenshot(String methodName, WebDriver driver) {

        // Get screenshot from WebDriver
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "screenshots/" + methodName + System.currentTimeMillis() + ".png";
        try {
            Files.copy(screenshot.toPath(), Paths.get(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}
