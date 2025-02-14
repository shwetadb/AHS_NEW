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
//            if (browserContext != null) {
//                browserContext.tracing().stop(new Tracing.StopOptions().setPath(tracePath));
//                log.info("Trace saved to: " + tracePath.toAbsolutePath());
//            }
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






package base;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

import factory.PlaywrightFactory;
import pages.LoginProcess;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseTest {

    private static final Logger log = LogManager.getLogger(BaseTest.class); // ✅ Corrected Logger

    private PlaywrightFactory pf;
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;

    // 🔹 Change visibility from "protected" to "public"
    public Page page;

    protected Properties prop;
    protected LoginProcess loginProcess;

    @BeforeTest
    public void setUp() {
        try {
            log.info("🔄 Initializing Playwright and Browser...");

            pf = new PlaywrightFactory();
            prop = pf.init_prop();
            playwright = Playwright.create();
            browser = playwright.chromium().launch();
            browserContext = browser.newContext();
            page = pf.initBrowserWithInputs(prop); // Now accessible in ExtentReportListener
            loginProcess = new LoginProcess(page);

            log.info("🌐 Navigating to URL: " + prop.getProperty("url").trim());
            page.navigate(prop.getProperty("url").trim());
            page.waitForLoadState(com.microsoft.playwright.options.LoadState.LOAD);

            // Start tracing before the tests
            if (browserContext != null) {
                browserContext.tracing().start(new Tracing.StartOptions()
                        .setScreenshots(true)
                        .setSnapshots(true)
                        .setSources(true));
            }

            log.info("✅ Playwright and browser setup completed.");
        } catch (Exception e) {
            log.error("❌ Error during test setup: " + e.getMessage(), e); // ✅ Fixed Logger issue
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String testName = result.getMethod().getMethodName(); // Get test method name
        String testDescription = result.getMethod().getDescription(); // Get test description

        String traceFolderPath = "D:\\eclipse-workspace\\AHS_NEW\\src\\main\\resources";
        String traceFileName = "trace_" + (testDescription != null ? testDescription.replaceAll("\\s+", "_") : testName) + ".zip";

        Path tracePath = Paths.get(traceFolderPath, traceFileName);

        try {
            if (!Files.exists(tracePath.getParent())) {
                Files.createDirectories(tracePath.getParent());
            }

            if (browserContext != null) {
                browserContext.tracing().stop(new Tracing.StopOptions().setPath(tracePath));
                log.info("📝 Trace saved to: " + tracePath.toAbsolutePath());
            }
        } catch (Exception e) {
            log.error("⚠️ Error while saving trace: " + e.getMessage(), e); // ✅ Fixed Logger issue
        }
    }

    @AfterTest
    public void tearDownAll() {
        try {
            if (browserContext != null) {
                browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("D:\\eclipse-workspace\\AHS_NEW\\src\\main\\resources\\trace_Final.zip")));
                log.info("📝 Final Trace saved successfully.");
            }
        } catch (Exception e) {
            log.error("⚠️ Error while stopping tracing: " + e.getMessage(), e); // ✅ Fixed Logger issue
        } finally {
            if (page != null && !page.isClosed()) {
                page.context().browser().close();
                log.info("✅ Browser closed successfully.");
            }
            if (playwright != null) {
                playwright.close();
                log.info("✅ Playwright closed successfully.");
            }
        }
    }
}
