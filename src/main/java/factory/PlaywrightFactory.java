package factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.LoadState;

public class PlaywrightFactory extends ExtentReports {

    private static final Logger log = LogManager.getLogger(PlaywrightFactory.class);  // Logger setup

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;

    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public static Playwright getPlaywright() {
        return tlPlaywright.get();
    }

    public static Browser getBrowser() {
        return tlBrowser.get();
    }

    public static BrowserContext getBrowserContext() {
        return tlBrowserContext.get();
    }

    public static Page getPage() {
        return tlPage.get();
    }

    public Page initBrowserWithInputs(Properties prop) {
        String browserName = prop.getProperty("browser").trim();
        log.info("Browser name is : " + browserName);  // Logging the browser name

        tlPlaywright.set(Playwright.create());

        switch (browserName.toLowerCase()) {
            case "chromium":
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "firefox":
                tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "safari":
                tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "chrome":
                tlBrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false)));
                break;
            case "edge":
                tlBrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false)));
                break;
            default:
                log.error("Please pass the right browser name...");  // Logging the error for wrong browser name
                break;
        }

        tlBrowserContext.set(getBrowser().newContext());
        tlPage.set(getBrowserContext().newPage());
//        getPage().navigate(prop.getProperty("url").trim());
        return getPage();
    }

    public Properties init_prop() {
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (FileNotFoundException e) {
            log.error("Properties file not found: " + e.getMessage(), e);  // Logging the error if file not found
        } catch (IOException e) {
            log.error("Error loading properties file: " + e.getMessage(), e);  // Logging the error if IO exception occurs
        }

        return prop;
    }

    private String captureScreenshot(Page page, String testName) {
        try {
            Path screenshotPath = Paths.get("Screenshots", testName + ".png");

            // Ensure Screenshots directory exists
            Files.createDirectories(screenshotPath.getParent());

            // Take screenshot and save as PNG
            page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));

            log.info("Screenshot saved: " + screenshotPath.toAbsolutePath());  // Logging screenshot save

            // Convert screenshot to Base64
            byte[] fileContent = Files.readAllBytes(screenshotPath);
            return java.util.Base64.getEncoder().encodeToString(fileContent);

        } catch (Exception e) {
            log.error("Failed to capture screenshot!", e);  // Logging the error if screenshot capture fails
            return "";
        }
    }
}
