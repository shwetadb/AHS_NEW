package tests.pages_PHY;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.options.LoadState;

import base.BaseTest;
import constants.AppConstants;
import pages.LoginProcess;
import pages_PHY.PHY_Administration;
import pages_PHY.PHY_Dashboard;
import pages_PHY.PHY_Physician_Profile;

public class PHY_04_Administration_Edit_Test extends BaseTest {
	
	private static final Logger log = LogManager.getLogger(PHY_02_Dashboard_Nav_Test.class);
	public BaseTest base;
    public LoginProcess login;
    public PHY_Dashboard dashboard;
    public PHY_Administration adminPage; 
	 
    @BeforeMethod
    public void appLoginSetup() throws InterruptedException {
        log.info("Before method"); 
        page.navigate(prop.getProperty("url").trim());
        page.waitForLoadState(LoadState.LOAD);

        login = new LoginProcess(page);
        login.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim(), prop.getProperty("otp").trim());
 
        dashboard = new PHY_Dashboard(page);
        
        dashboard.goToAdministrator();
        adminPage = new PHY_Administration(page, prop);
    }

    
    
    @Test (priority = 1, description = "Apply Filter by User Role")
    public void VerifyUserRole_Test() throws InterruptedException {     
        // Verify if all users are "Administrative"
        boolean admin = adminPage.verifyAllUsersAreAdmins();
        page.waitForLoadState(LoadState.LOAD);
        Assert.assertTrue(admin, "Some users are not 'Administrative'");
        Thread.sleep(1000);
     // Verify if all users are "Physicians"
        boolean physician = adminPage.verifyAllUsersArePhysicians();
        page.waitForLoadState(LoadState.LOAD);
        Assert.assertTrue(physician, "Some users are not 'Physicians'");
        
        adminPage.clickReset();
        page.waitForLoadState(LoadState.LOAD);
//        Assert.assertTrue(allUser, "Some users are not all Users");
        log.info("✅ Test Passed: Apply Filter by User Role are working correctly.");

    }

    
    
    @Test (priority = 2, description = "Administration Page Button Navigation Test")
    public void VerifyButtonNav_Test() throws InterruptedException { 
    	adminPage.clickNewPhysician();
    	adminPage.getNewPhysicianHeading();
    	Thread.sleep(1000);
    	
    	adminPage.clickNewAdmin();
    	adminPage.getNewAdminHeading();
    	Thread.sleep(1000);
    	
    	adminPage.clickInvitationLog();
    	adminPage.getInvitationLogHeading();
    	Thread.sleep(1000);
    	
    	adminPage.clickPhyHomeBtn();
//    	AssertJUnit.assertEquals(dashboard.getHomePageHeading(), AppConstants.DASHBOARD_WELCOME_MSG);
        log.info("✅ Test Passed: Button Navigation are working correctly.");

    } 
    
    
    
    
    @Test (priority = 3, description = "Administration Page Search Functionality Test")
    public void VerifySearch_Test() throws InterruptedException { 
    	adminPage.searchPhy();
    	adminPage.searchAdmin();    
    	log.info("✅ Test Passed: Administration Page Search Functionality are working correctly.");
    }

    
    
    @Test (priority = 4, description = "Edit COE Functionality Test")
    public void editCOE_Test() throws InterruptedException { 
    	adminPage.searchPhy();
    	System.out.println("found Phy");
    	adminPage.clickCOEIcon();  
    	adminPage.clickOK();
    	log.info("✅ Test Passed: Edit COE Functionality are working correctly.");
    }

    
}
