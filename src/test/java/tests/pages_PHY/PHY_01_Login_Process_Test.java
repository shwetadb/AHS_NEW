package tests.pages_PHY;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.options.LoadState;

import base.BaseTest;
import constants.AppConstants;
import pages.LoginProcess;


public class PHY_01_Login_Process_Test extends BaseTest {
	private static final Logger log = LogManager.getLogger(PHY_01_Login_Process_Test.class);
    public LoginProcess login;

	
    @BeforeMethod
    public void appLoginSetup() throws InterruptedException {
		login = new LoginProcess(page);
    	log.info("Before method"); 
    	
    }


    @Test(priority = 1, description = "Verify login with correct credentials")
    public void TestValidLogin() {
    	page.navigate(prop.getProperty("url").trim());
    	page.waitForLoadState(LoadState.LOAD);
        login.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim(), prop.getProperty("otp").trim());

       // Verify that the "Elemrex" logo or heading is present on the homepage
        String heading = loginProcess.getElemrexLogo();
        	System.out.println("Heading: " + heading);
        String msgWelcome = loginProcess.gePHYtWelcomMsg();
        	System.out.println("Message: " + msgWelcome);
        AssertJUnit.assertEquals(msgWelcome, AppConstants.DASHBOARD_WELCOME_MSG);
		log.info("✅ Test Passed: Verify login with correct credentials");
        System.out.println("✅ Test Passed: Verify login with correct credentials");
    }
    
    
    @Test(priority = 2, description = "Verify Unsuccessful login with Incorrect credentials")
	public void TestUnsuccessfullogin() throws InterruptedException {
    	page.navigate(prop.getProperty("url").trim());
    	page.waitForLoadState(LoadState.LOAD);
    	login.doInvalidLogin(prop.getProperty("invalidUsername").trim(), prop.getProperty("invalidPassword").trim());
    	
//    	String actual=login.alert();
//		login.acceptAlert();
//		log.info(actual);
		String msgInvalidCred = loginProcess.geInvalidCredentialMsg();
			System.out.println("Message: " + msgInvalidCred);
		AssertJUnit.assertEquals(msgInvalidCred, AppConstants.INVALID_CREDENTIAL_MSG);
		log.info("✅ Test Passed: Verify Unsuccessful login with Incorrect credentials");
        System.out.println("✅ Test Passed: Verify Unsuccessful login with Incorrect credentials");

    }
    
    

}
