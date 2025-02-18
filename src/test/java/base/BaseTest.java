//package base;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Properties;
//import java.util.Scanner;
//
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//
//import com.microsoft.playwright.BrowserContext;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Tracing;
//
//import factory.PlaywrightFactory;
//import pages.LoginProcess;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//public class BaseTest {
//
//    private static final Logger log = LogManager.getLogger(BaseTest.class);  // Logger setup
//
//    private PlaywrightFactory pf;
//    public Page page;
//    protected BrowserContext browserContext;
//    protected LoginProcess loginProcess;
//    protected Properties prop;
//
//    private String appUrl;
//    private String username;
//    private String password;
//    protected String otp;
//
//    @BeforeTest
//    public void setUp() {
//        pf = new PlaywrightFactory();
//        prop = pf.init_prop();
//        page = pf.initBrowserWithInputs(prop); // You can change to 'firefox' or 'chrome' as needed
//        browserContext = page.context(); // Get the browser context from the page
//       loginProcess = new LoginProcess(page);
//
//        // Start tracing before creating or navigating a page
//        browserContext.tracing().start(new Tracing.StartOptions()
//                .setScreenshots(true)
//                .setSnapshots(true)
//                .setSources(true));
//
//        log.info("Test Setup completed.");
//    }
//
////    @AfterTest
////    public void tearDown() {
////        String traceFolderPath = "D:\\eclipse-workspace\\AHS_NEW\\src\\main\\resources";
////        String traceFileName = "traceTests.zip" ;
//    @AfterTest
//    public void tearDown(ITestResult result) {
//    	// Get test name or description dynamically
//        String testName = result.getMethod().getMethodName(); // Get test method name
//        String testDescription = result.getMethod().getDescription(); // Get test description
//
//        // Generate a unique trace file name based on test name/description
//        String traceFileName = "trace_" + (testDescription != null ? testDescription.replaceAll("\\s+", "_") : testName) + ".zip";
//        String traceFolderPath = "D:\\eclipse-workspace\\AHS_NEW\\src\\main\\resources";
//
//        Path tracePath = Paths.get(traceFolderPath, traceFileName);
//
//        try {
//            if (!Files.exists(tracePath.getParent())) {
//                Files.createDirectories(tracePath.getParent());
//            }
//
//            browserContext.tracing().stop(new Tracing.StopOptions().setPath(tracePath));
//            log.info("Trace saved to: " + tracePath.toAbsolutePath());  // Logging trace save
//
//        } catch (Exception e) {
//            log.error("Failed to save trace: " + e.getMessage(), e);  // Logging trace save failure
//        }
//
//        
//     // Ensure the browser is closed after the test
//        if (page != null ) {
//            page.context().browser().close();
//            
//            log.info("Browser closed after test: " + result.getMethod().getMethodName());
//        } else {
//            log.warn("Page or browser context is null, skipping browser close.");
//        }
//                
//        
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//    
//
//}

//Now testing
//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------


//package base;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Properties;
//
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import com.microsoft.playwright.BrowserContext;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Tracing;
//
//import factory.PlaywrightFactory;
//import pages.LoginProcess;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//public class BaseTest {
//
//    private static final Logger log = LogManager.getLogger(BaseTest.class);  // Logger setup
//
//    private PlaywrightFactory pf;
//    public Page page;
//    protected BrowserContext browserContext;
//    protected LoginProcess loginProcess;
//    protected Properties prop;
//
//    private String appUrl;
//    private String username;
//    private String password;
//    protected String otp;
//
//    @BeforeTest
//    public void setUp() {
//        try {
//            pf = new PlaywrightFactory();
//            prop = pf.init_prop();
//            page = pf.initBrowserWithInputs(prop); // Initialize browser
//            browserContext = page.context();
//            loginProcess = new LoginProcess(page);
//
//            // Start tracing before creating or navigating a page
//            browserContext.tracing().start(new Tracing.StartOptions()
//                    .setScreenshots(true)
//                    .setSnapshots(true)
//                    .setSources(true));
//
//            log.info("Test Setup completed.");
//        } catch (Exception e) {
//            log.error("Error during test setup: " + e.getMessage(), e);
//        }
//    }
//
//    @AfterTest
//    public void tearDownAll(ITestResult result) {
//    	page.context().browser().close();
//    }
//    
//    
//    @AfterMethod
//    public void tearDown(ITestResult result) {  // Corrected parameter
//      String testName = ((ITestResult) result).getMethod().getMethodName(); // Get test method name
//      String testDescription = result.getMethod().getDescription(); // Get test description
//        String traceFolderPath = "D:\\eclipse-workspace\\AHS_NEW\\src\\main\\resources";
////        String traceFileName = "trace_" + context.getName().replaceAll("\\s+", "_") + ".zip";
//        String traceFileName = "trace_" + (testDescription != null ? testDescription.replaceAll("\\s+", "_") : testName) + ".zip";
//
//        Path tracePath = Paths.get(traceFolderPath, traceFileName);
//
//        try {
//            if (!Files.exists(tracePath.getParent())) {
//                Files.createDirectories(tracePath.getParent());
//            }
//
////            if (browserContext != null) {
//                browserContext.tracing().stop(new Tracing.StopOptions().setPath(tracePath));
//                log.info("Trace saved to: " + tracePath.toAbsolutePath());
////            }
//
//        } catch (Exception e) {
//            log.error("Failed to save trace: " + e.getMessage(), e);
//        }
////
////        // Ensure the browser is closed after the test
////        try {
////            if (page != null && !page.isClosed()) {
////                page.context().browser().close();
////                log.info("Browser closed successfully.");
////            } else {
////                log.warn("Page is already closed.");
////            }
////        } catch (Exception e) {
////            log.error("Error while closing browser: " + e.getMessage(), e);
////        }
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//}




//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------






//package base;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Properties;
//
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import com.microsoft.playwright.Browser;
//import com.microsoft.playwright.BrowserContext;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Playwright;
//import com.microsoft.playwright.Tracing;
//
//import factory.PlaywrightFactory;
//import pages.LoginProcess;
//
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//
//public class BaseTest {
//
//    private static final Logger log = LogManager.getLogger(BaseTest.class); // ✅ Corrected Logger
//
//    private PlaywrightFactory pf;
//    protected Playwright playwright;
//    protected Browser browser;
//    protected BrowserContext browserContext;
//
//    // 🔹 Change visibility from "protected" to "public"
//    public Page page;
//
//    protected Properties prop;
//    protected LoginProcess loginProcess;
//
//    @BeforeTest
//    public void setUp() {
//        try {
//            log.info("🔄 Initializing Playwright and Browser...");
//
//            pf = new PlaywrightFactory();
//            prop = pf.init_prop();
//            playwright = Playwright.create();
//            browser = playwright.chromium().launch();
//            browserContext = browser.newContext();
//            page = pf.initBrowserWithInputs(prop); // Now accessible in ExtentReportListener
//            loginProcess = new LoginProcess(page);
//
//            log.info("🌐 Navigating to URL: " + prop.getProperty("url").trim());
//            page.navigate(prop.getProperty("url").trim());
//            page.waitForLoadState(com.microsoft.playwright.options.LoadState.LOAD);
//
//            // Start tracing before the tests
//            if (browserContext != null) {
//                browserContext.tracing().start(new Tracing.StartOptions()
//                        .setScreenshots(true)
//                        .setSnapshots(true)
//                        .setSources(true));
//            }
//
//            log.info("✅ Playwright and browser setup completed.");
//        } catch (Exception e) {
//            log.error("❌ Error during test setup: " + e.getMessage(), e); // ✅ Fixed Logger issue
//        }
//    }
//
//    @AfterMethod
//    public void tearDown(ITestResult result) {
//        String testName = result.getMethod().getMethodName(); // Get test method name
//        String testDescription = result.getMethod().getDescription(); // Get test description
//
//        String traceFolderPath = "D:\\eclipse-workspace\\AHS_NEW\\src\\main\\resources";
//        String traceFileName = "trace_" + (testDescription != null ? testDescription.replaceAll("\\s+", "_") : testName) + ".zip";
//
//        Path tracePath = Paths.get(traceFolderPath, traceFileName);
//
//        try {
//            if (!Files.exists(tracePath.getParent())) {
//                Files.createDirectories(tracePath.getParent());
//            }
//
//            if (browserContext != null) {
//                browserContext.tracing().stop(new Tracing.StopOptions().setPath(tracePath));
//                log.info("📝 Trace saved to: " + tracePath.toAbsolutePath());
//            }
//        } catch (Exception e) {
//            log.error("⚠️ Error while saving trace: " + e.getMessage(), e); // ✅ Fixed Logger issue
//        }
//    }
//
//    @AfterTest
//    public void tearDownAll() {
//        try {
//            if (browserContext != null) {
//                browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("D:\\eclipse-workspace\\AHS_NEW\\src\\main\\resources\\trace_Final.zip")));
//                log.info("📝 Final Trace saved successfully.");
//            }
//        } catch (Exception e) {
//            log.error("⚠️ Error while stopping tracing: " + e.getMessage(), e); // ✅ Fixed Logger issue
//        } finally {
//            if (page != null && !page.isClosed()) {
//                page.context().browser().close();
//                log.info("✅ Browser closed successfully.");
//            }
//            if (playwright != null) {
//                playwright.close();
//                log.info("✅ Playwright closed successfully.");
//            }
//        }
//    }
//}




//17/02/2025 edited BaseTest
//---------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------------
//package base;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Properties;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.microsoft.playwright.Browser;
//import com.microsoft.playwright.BrowserContext;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Tracing;
//
//import factory.PlaywrightFactory;
//import listeners.ExtentReportListener;
//import pages.LoginProcess;
//
//public class BaseTest {
//
//    private static final Logger log = LogManager.getLogger(BaseTest.class); // Logger setup
//
//    protected PlaywrightFactory pf;
//    public Page page;
//    protected Browser browser;
//    protected BrowserContext browserContext;
//    protected LoginProcess loginProcess;
//    protected Properties prop;
//
//    @BeforeTest
//    public void setUp() {
//        try {
//            pf = new PlaywrightFactory();
//            prop = pf.init_prop();
//            page = pf.initBrowserWithInputs(prop); // Initialize Playwright and Browser
//            browserContext = page.context();
//            browser = browserContext.browser();
//            loginProcess = new LoginProcess(page);
//
//            // Start tracing to capture browser actions
//            if (browserContext != null) {
//                browserContext.tracing().start(new Tracing.StartOptions()
//                        .setScreenshots(true)
//                        .setSnapshots(true)
//                        .setSources(true));
//            }
//
//            log.info("✅ Test Setup completed.");
//        } catch (Exception e) {
//            log.error("❌ Error during test setup: " + e.getMessage(), e);
//        }
//    }
//
//    @AfterMethod
//    public void tearDown(ITestResult result) {
//        String testName = result.getMethod().getMethodName();
//
//        // Fix: Ensure Extent Report test is not null before using it
//        if (ExtentReportListener.test.get() != null) {
//            ExtentReportListener.test.get().getModel().setEndTime(new java.util.Date(result.getEndMillis()));
//
//            // Capture Screenshot on Failure
//            if (result.getStatus() == ITestResult.FAILURE) {
//                log.error("❌ Test Failed: " + testName, result.getThrowable());
//
//                String screenshotBase64 = captureScreenshot(testName);
//                if (!screenshotBase64.isEmpty()) {
//                    ExtentReportListener.test.get().fail("Screenshot on Failure",
//                            MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
//                }
//            }
//        } else {
//            log.warn("⚠️ ExtentReport test instance is NULL for test: " + testName);
//        }
//
//        // Save Playwright Tracing
//        String traceFolderPath = "D:\\eclipse-workspace\\AHS_NEW\\src\\main\\resources";
//        String traceFileName = "trace_" + testName + ".zip";
//        Path tracePath = Paths.get(traceFolderPath, traceFileName);
//
//        try {
//            if (!Files.exists(tracePath.getParent())) {
//                Files.createDirectories(tracePath.getParent());
//            }
//
//            if (browserContext != null) {
//                browserContext.tracing().stop(new Tracing.StopOptions().setPath(tracePath));
//                log.info("📁 Trace saved to: " + tracePath.toAbsolutePath());
//            }
//        } catch (Exception e) {
//            log.error("⚠️ Failed to save trace: " + e.getMessage(), e);
//        }
//    }
//
//    @AfterTest
//    public void tearDownAll(ITestContext context) {
//        try {
//            if (browserContext != null) {
//                browserContext.tracing().stop();
//            }
//            if (browser != null) {
//                browser.close();
//            }
//            log.info("🚀 Browser closed successfully.");
//        } catch (Exception e) {
//            log.error("❌ Error while closing browser: " + e.getMessage(), e);
//        }
//    }
//
//    /**
//     * Capture a screenshot and return it as a Base64-encoded string.
//     *
//     * @param testName Name of the test
//     * @return Base64 encoded screenshot string
//     */
//    private String captureScreenshot(String testName) {
//        try {
//            Path screenshotPath = Paths.get("Screenshots", testName + ".png");
//
//            // Ensure Screenshots directory exists
//            Files.createDirectories(screenshotPath.getParent());
//
//            // Take screenshot and save as PNG
//            page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));
//
//            log.info("📸 Screenshot saved: " + screenshotPath.toAbsolutePath());
//
//            // Convert screenshot to Base64
//            byte[] fileContent = Files.readAllBytes(screenshotPath);
//            return java.util.Base64.getEncoder().encodeToString(fileContent);
//
//        } catch (Exception e) {
//            log.error("⚠️ Failed to capture screenshot!", e);
//            return "";
//        }
//    }
//}



////using this 17/02/25 at 10.44
//package base;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Properties;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.microsoft.playwright.Browser;
//import com.microsoft.playwright.BrowserContext;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Tracing;
//
//import factory.PlaywrightFactory;
//import listeners.ExtentReportListener;
//import pages.LoginProcess;
//
//public class BaseTest {
//
//    private static final Logger log = LogManager.getLogger(BaseTest.class); // Logger setup
//
//    protected PlaywrightFactory pf;
//    public Page page;
//    protected Browser browser;
//    protected BrowserContext browserContext;
//    protected LoginProcess loginProcess;
//    protected Properties prop;
//
//    private boolean isTracingStarted = false; // ✅ Track if tracing has started
//
//    @BeforeTest
//    public void setUp() {
//        try {
//            pf = new PlaywrightFactory();
//            prop = pf.init_prop();
//            page = pf.initBrowserWithInputs(prop); // Initialize Playwright and Browser
//            browserContext = page.context();
//            browser = browserContext.browser();
//            loginProcess = new LoginProcess(page);
//
//            // ✅ Start tracing ONLY if browser context is successfully initialized
//            if (browserContext != null) {
//                browserContext.tracing().start(new Tracing.StartOptions()
//                        .setScreenshots(true)
//                        .setSnapshots(true)
//                        .setSources(true));
//                isTracingStarted = true; // ✅ Mark tracing as started
//            }
//
//            log.info("✅ Test Setup completed.");
//        } catch (Exception e) {
//            log.error("❌ Error during test setup: " + e.getMessage(), e);
//        }
//    }
//
//    @AfterMethod
//    public void tearDown(ITestResult result) {
//        String testName = result.getMethod().getMethodName();
//        String testDescription = result.getMethod().getDescription();
//
//        // ✅ Ensure Extent Report instance is available before using it
//        if (ExtentReportListener.test.get() != null) {
//            ExtentReportListener.test.get().getModel().setEndTime(new java.util.Date(result.getEndMillis()));
//
//            // ✅ Capture Screenshot on Failure
//            if (result.getStatus() == ITestResult.FAILURE) {
//                log.error("❌ Test Failed: " + testName, result.getThrowable());
//
//                String screenshotBase64 = captureScreenshot(testName);
//                if (!screenshotBase64.isEmpty()) {
//                    ExtentReportListener.test.get().fail("Screenshot on Failure",
//                            MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
//                }
//            }
//        } else {
//            log.warn("⚠️ ExtentReport test instance is NULL for test: " + testName);
//        }
//
//        // ✅ Stop tracing ONLY if it was started
//        if (isTracingStarted && browserContext != null) {
//            String traceFolderPath = "D:\\eclipse-workspace\\AHS_NEW\\src\\main\\resources";
//            String traceFileName = "trace_" + (testDescription != null ? testDescription.replaceAll("\\s+", "_") : testName) + ".zip";
//            Path tracePath = Paths.get(traceFolderPath, traceFileName);
//
//            try {
//                if (!Files.exists(tracePath.getParent())) {
//                    Files.createDirectories(tracePath.getParent());
//                }
//
//                browserContext.tracing().stop(new Tracing.StopOptions().setPath(tracePath));
//                log.info("📁 Trace saved to: " + tracePath.toAbsolutePath());
//                isTracingStarted = false; // ✅ Mark tracing as stopped
//            } catch (Exception e) {
//                log.error("⚠️ Failed to save trace: " + e.getMessage(), e);
//            }
//        }
//    }
//
//    @AfterTest
//    public void tearDownAll(ITestContext context) {
//        try {
//            if (isTracingStarted && browserContext != null) {
//                browserContext.tracing().stop();
//                log.info("✅ Tracing stopped.");
//                isTracingStarted = false;
//            }
//            if (browser != null) {
//                browser.close();
//                log.info("🚀 Browser closed successfully.");
//            }
//        } catch (Exception e) {
//            log.error("❌ Error while closing browser: " + e.getMessage(), e);
//        }
//    }
//
//    /**
//     * Capture a screenshot and return it as a Base64-encoded string.
//     *
//     * @param testName Name of the test
//     * @return Base64 encoded screenshot string
//     */
//    private String captureScreenshot(String testName) {
//        try {
//            Path screenshotPath = Paths.get("Screenshots", testName + ".png");
//
//            // Ensure Screenshots directory exists
//            Files.createDirectories(screenshotPath.getParent());
//
//            // Take screenshot and save as PNG
//            page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));
//
//            log.info("📸 Screenshot saved: " + screenshotPath.toAbsolutePath());
//
//            // Convert screenshot to Base64
//            byte[] fileContent = Files.readAllBytes(screenshotPath);
//            return java.util.Base64.getEncoder().encodeToString(fileContent);
//
//        } catch (Exception e) {
//            log.error("⚠️ Failed to capture screenshot!", e);
//            return "";
//        }
//    }
//    
//
//}


//============================================================================================================================================================
//============================================================================================================================================================

// updated on 18/02/25 at 11.24 provides the trace for each test with time

package base;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.microsoft.playwright.*;

import factory.PlaywrightFactory;
import listeners.ExtentReportListener;
import pages.LoginProcess;

public class BaseTest {

    private static final Logger log = LogManager.getLogger(BaseTest.class); 
    protected PlaywrightFactory pf;
    public Page page;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected LoginProcess loginProcess;
    protected Properties prop;

    private boolean isTracingStarted = false;

    @BeforeTest
    public void setUp() {
        try {
            pf = new PlaywrightFactory();
            prop = pf.init_prop();
            page = pf.initBrowserWithInputs(prop);
            browserContext = page.context();
            browser = browserContext.browser();
            loginProcess = new LoginProcess(page);

            log.info("✅ Test Setup completed.");
        } catch (Exception e) {
            log.error("❌ Error during test setup: " + e.getMessage(), e);
        }
    }

    @BeforeMethod
    public void startTracing(ITestResult result) {
        try {
            if (browserContext != null) {
                String testName = result.getMethod().getMethodName();

                browserContext.tracing().start(new Tracing.StartOptions()
                        .setScreenshots(true)
                        .setSnapshots(true)
                        .setSources(true));

                isTracingStarted = true;
                log.info("📍 Started tracing for test: " + testName);
            }
        } catch (Exception e) {
            log.error("⚠️ Failed to start tracing!", e);
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String testDescription = result.getMethod().getDescription();
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        if (ExtentReportListener.test.get() != null) {
            ExtentReportListener.test.get().getModel().setEndTime(new java.util.Date(result.getEndMillis()));

            if (result.getStatus() == ITestResult.FAILURE) {
                log.error("❌ Test Failed: " + testName, result.getThrowable());

                String screenshotBase64 = captureScreenshot(testName);
                if (!screenshotBase64.isEmpty()) {
                    ExtentReportListener.test.get().fail("Screenshot on Failure",
                            MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
                }
            }
        } else {
            log.warn("⚠️ ExtentReport test instance is NULL for test: " + testName);
        }

        // ✅ Stop tracing & save trace for each test
        if (isTracingStarted && browserContext != null) {
            String traceFolderPath = "D:\\eclipse-workspace\\AHS_NEW\\src\\main\\resources";
            String traceFileName = "trace_" + testName + "_" + timestamp + ".zip";
            Path tracePath = Paths.get(traceFolderPath, traceFileName);

            try {
                if (!Files.exists(tracePath.getParent())) {
                    Files.createDirectories(tracePath.getParent());
                }

                browserContext.tracing().stop(new Tracing.StopOptions().setPath(tracePath));
                log.info("📁 Trace saved to: " + tracePath.toAbsolutePath());
                isTracingStarted = false;
            } catch (Exception e) {
                log.error("⚠️ Failed to save trace: " + e.getMessage(), e);
            }
        }
    }

    @AfterTest
    public void tearDownAll(ITestContext context) {
        try {
            if (browser != null) {
                browser.close();
                log.info("🚀 Browser closed successfully.");
            }
        } catch (Exception e) {
            log.error("❌ Error while closing browser: " + e.getMessage(), e);
        }
    }

    /**
     * Capture a screenshot and return it as a Base64-encoded string.
     *
     * @param testName Name of the test
     * @return Base64 encoded screenshot string
     */
    private String captureScreenshot(String testName) {
        try {
            Path screenshotPath = Paths.get("Screenshots", testName + ".png");
            Files.createDirectories(screenshotPath.getParent());

            page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));
            log.info("📸 Screenshot saved: " + screenshotPath.toAbsolutePath());

            byte[] fileContent = Files.readAllBytes(screenshotPath);
            return java.util.Base64.getEncoder().encodeToString(fileContent);

        } catch (Exception e) {
            log.error("⚠️ Failed to capture screenshot!", e);
            return "";
        }
    }
}
