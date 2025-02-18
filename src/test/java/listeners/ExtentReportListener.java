//package listners;
//
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Calendar;
//import java.util.Date;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.microsoft.playwright.Page;
//
//import base.BaseTest;
//
//
//public class ExtentReportListener implements ITestListener {
//
//    private static final String OUTPUT_FOLDER = "./build/";
//    private static final String FILE_NAME = "TestExecutionReport.html";
//
//    private static ExtentReports extent = init();
//    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//    private static final Logger log = LogManager.getLogger(ExtentReportListener.class);  // Logger setup
//
//    private static ExtentReports init() {
//        Path path = Paths.get(OUTPUT_FOLDER);
//        if (!Files.exists(path)) {
//            try {
//                Files.createDirectories(path);
//            } catch (IOException e) {
//                log.error("Failed to create output directory!", e);  // Logging error for output directory creation
//            }
//        }
//
//        extent = new ExtentReports();
//        ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
//        reporter.config().setReportName("Test Automation Results");
//        extent.attachReporter(reporter);
//        extent.setSystemInfo("System", "MAC");
//        extent.setSystemInfo("Author", "QA Team");
//        extent.setSystemInfo("Build#", "1.1");
//        extent.setSystemInfo("Team", "QA");
//        extent.setSystemInfo("Customer", "Client XYZ");
//
//        return extent;
//    }
//
//    @Override
//    public synchronized void onStart(ITestContext context) {
//        log.info("Test Suite started: " + context.getName());
//    }
//
//    @Override
//    public synchronized void onFinish(ITestContext context) {
//        log.info("Test Suite finished: " + context.getName());
//        extent.flush();
//        test.remove();
//    }
//
//    @Override
//    public synchronized void onTestStart(ITestResult result) {
//        log.info("Test started: " + result.getMethod().getMethodName());
//
//        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
//        extentTest.assignCategory(result.getTestContext().getSuite().getName());
//        test.set(extentTest);
//        test.get().getModel().setStartTime(getTime(result.getStartMillis()));
//    }
//
//    @Override
//    public synchronized void onTestSuccess(ITestResult result) {
//        log.info("Test Passed: " + result.getMethod().getMethodName());
//        test.get().pass("Test passed");
//        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
//        test.remove(); // Avoid memory leaks
//    }
//
//    @Override
//    public synchronized void onTestFailure(ITestResult result) {
//        log.error("Test Failed: " + result.getMethod().getMethodName(), result.getThrowable());
//
//        if (result.getInstance() instanceof BaseTest) {
//            Page page = ((BaseTest) result.getInstance()).page; // Get Playwright page instance
//            if (page != null) {
//                String screenshotBase64 = captureScreenshot(page, result.getMethod().getMethodName());
//                test.get().fail(result.getThrowable(),
//                        MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64, result.getMethod().getMethodName()).build());
//            }
//        }
//
//        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
//        test.remove(); // Avoid memory leaks
//    }
//
//    @Override
//    public synchronized void onTestSkipped(ITestResult result) {
//        log.warn("Test Skipped: " + result.getMethod().getMethodName());
//        test.get().skip(result.getThrowable());
//        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
//        test.remove(); // Avoid memory leaks
//    }
//
//    @Override
//    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        log.info("Test partially failed: " + result.getMethod().getMethodName());
//    }
//
//    private Date getTime(long millis) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(millis);
//        return calendar.getTime();
//    }
//
//    private String captureScreenshot(Page page, String testName) {
//        try {
//            Path screenshotPath = Paths.get("Screenshots", testName + ".png");
//
//            // Ensure Screenshots directory exists
//            Files.createDirectories(screenshotPath.getParent());
//
//            // Take screenshot and save as PNG
//            page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));
//
//            log.info("Screenshot saved: " + screenshotPath.toAbsolutePath());  // Logging screenshot save
//
//            // Convert screenshot to Base64
//            byte[] fileContent = Files.readAllBytes(screenshotPath);
//            return java.util.Base64.getEncoder().encodeToString(fileContent);
//
//        } catch (Exception e) {
//            log.error("Failed to capture screenshot!", e);  // Logging the error if screenshot capture fails
//            return "";
//        }
//    }
//}





package listeners;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.Page;

import base.BaseTest;

public class ExtentReportListener implements ITestListener {

    private static final String OUTPUT_FOLDER = "./build/";
    private static final String FILE_NAME = "TestExecutionReport.html";

    private static final ExtentReports extent = init();
    private static final Logger log = LogManager.getLogger(ExtentReportListener.class); // Logger setup
    public static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    /**
     * Initialize the Extent Report.
     */
    private static ExtentReports init() {
        Path path = Paths.get(OUTPUT_FOLDER);
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            log.error("❌ Failed to create output directory!", e);
        }

        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
        reporter.config().setReportName("Test Automation Results");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("System", System.getProperty("os.name"));
        extentReports.setSystemInfo("Author", "QA Team");
        extentReports.setSystemInfo("Build#", "1.1");
        extentReports.setSystemInfo("Team", "QA");
        extentReports.setSystemInfo("Customer", "Client XYZ");

        return extentReports;
    }

    @Override
    public synchronized void onStart(ITestContext context) {
        log.info("🚀 Test Suite started: " + context.getName());
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        log.info("✅ Test Suite finished: " + context.getName());
        extent.flush();
        test.remove();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        log.info("🔹 Test started: " + result.getMethod().getMethodName());
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        extentTest.assignCategory(result.getTestContext().getSuite().getName());
        test.set(extentTest);
        test.get().getModel().setStartTime(getTime(result.getStartMillis()));
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        log.info("✅ Test Passed: " + result.getMethod().getMethodName());
        if (test.get() != null) {
            test.get().pass("Test passed successfully");
            test.get().getModel().setEndTime(getTime(result.getEndMillis()));
            test.remove();
        }
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        log.error("❌ Test Failed: " + result.getMethod().getMethodName(), result.getThrowable());

        if (test.get() != null) {
            test.get().fail(result.getThrowable());

            // Capture Screenshot on Failure
            if (result.getInstance() instanceof BaseTest) {
                Page page = ((BaseTest) result.getInstance()).page;
                if (page != null) {
                    String screenshotBase64 = captureScreenshot(page, result.getMethod().getMethodName());
                    if (!screenshotBase64.isEmpty()) {
                        test.get().fail("Screenshot on Failure",
                                MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
                    }
                }
            }

            test.get().getModel().setEndTime(getTime(result.getEndMillis()));
            test.remove();
        }
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        log.warn("⚠️ Test Skipped: " + result.getMethod().getMethodName());
        if (test.get() != null) {
            test.get().skip(result.getThrowable());
            test.get().getModel().setEndTime(getTime(result.getEndMillis()));
            test.remove();
        }
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("🔸 Test partially failed: " + result.getMethod().getMethodName());
    }

    /**
     * Capture a screenshot and return it as a Base64-encoded string.
     *
     * @param page     Playwright Page instance
     * @param testName Name of the test for file naming
     * @return Base64 encoded screenshot string
     */
    private String captureScreenshot(Page page, String testName) {
        try {
            Path screenshotPath = Paths.get("Screenshots", testName + ".png");

            // Ensure Screenshots directory exists
            Files.createDirectories(screenshotPath.getParent());

            // Take screenshot and save as PNG
            page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));

            log.info("📸 Screenshot saved: " + screenshotPath.toAbsolutePath());

            // Convert screenshot to Base64
            byte[] fileContent = Files.readAllBytes(screenshotPath);
            return java.util.Base64.getEncoder().encodeToString(fileContent);

        } catch (Exception e) {
            log.error("⚠️ Failed to capture screenshot!", e);
            return "";
        }
    }

    /**
     * Convert a given timestamp (milliseconds) to a readable Date object.
     *
     * @param millis Timestamp in milliseconds
     * @return Formatted Date object
     */
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}

