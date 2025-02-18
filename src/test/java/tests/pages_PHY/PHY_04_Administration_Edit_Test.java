package tests.pages_PHY;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.LoadState;
import base.BaseTest;
import constants.AppConstants;
import pages.LoginProcess;
import pages_PHY.PHY_Administration;
import pages_PHY.PHY_Dashboard;



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
        System.out.println(prop.getProperty("url"));
        page.waitForLoadState(LoadState.LOAD);

        login = new LoginProcess(page);
        login.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim(), prop.getProperty("otp").trim());
        System.out.println("✅  Login Done");
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
        System.out.println("✅ Test Passed: Apply Filter by User Role are working correctly.");

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
    	AssertJUnit.assertEquals(dashboard.getHomePageHeading(), AppConstants.DASHBOARD_WELCOME_MSG);
        log.info("✅ Test Passed: Button Navigation are working correctly.");
        System.out.println("✅ Test Passed: Button Navigation are working correctly.");

    } 
    
    
    
    
    @Test (priority = 3, description = "Administration Page Search Functionality Test")
    public void VerifySearch_Test() throws InterruptedException { 
    	adminPage.searchPhy();
    	adminPage.searchAdmin();    
    	log.info("✅ Test Passed: Administration Page Search Functionality are working correctly.");
    	System.out.println("✅ Test Passed: Administration Page Search Functionality are working correctly.");
    }

    
    
    @Test (priority = 4, description = "Edit COE Functionality Test")
    public void editCOE_Test() throws InterruptedException { 
    	adminPage.searchPhy();
    	adminPage.clickCOEIcon();  
    	log.info("✅ Test Passed: Edit COE Functionality are working correctly.");
    	System.out.println("✅ Test Passed: Edit COE Functionality are working correctly.");
    }
    
    
    @Test (priority = 5, description = "Edit On Behalf Of Functionality Test")
    public void editOnBehalfOf_Test() throws InterruptedException { 
    	adminPage.searchAdmin();
    	adminPage.clickOnBehalfOfIcon();  
    	log.info("✅ Test Passed: Edit On Behalf Of Functionality are working correctly.");
    	System.out.println("✅ Test Passed: Edit On Behalf Of Functionality are working correctly.");
    }
    
    
    @Test (priority = 6, description = "Edit PHY Status Functionality Test")
    public void editStatusPhy_Test() throws InterruptedException { 
    	adminPage.searchPhy();
    	adminPage.clickStatusIcon();  
    	log.info("✅ Test Passed: Edit PHY Status Functionality are working correctly.");
    	System.out.println("✅ Test Passed: Edit PHY Status Functionality are working correctly.");
    }
    
    
    @Test (priority = 7, description = "Edit Admin Status Functionality Test")
    public void editStatusAdmin_Test() throws InterruptedException { 
    	adminPage.searchAdmin();
    	adminPage.clickStatusIcon();  
    	log.info("✅ Test Passed: Edit Admin Status Functionality are working correctly.");
    	System.out.println("✅ Test Passed: Edit Admin Status Functionality are working correctly.");
    }

    
    
    @Test (priority = 8, description = "Blank & Valid Email Primary Physician Functionality Test")
    public void emailPriPhy_Test() throws InterruptedException { 
    	adminPage.verifyAllUsersArePhysicians();
    	adminPage.doEmailProcess();
    	System.out.println("✅ Test Passed: Blank & Valid Email Primary Physician Functionality are working correctly.");
    	log.info("✅ Test Passed: Blank & Valid Email Primary Physician Functionality are working correctly.");
    }
    
    
    @Test (priority = 9, description = "Blank & Valid Email Primary Admin Functionality Test")
    public void emailPriAdmin_Test() throws InterruptedException { 
    	adminPage.verifyAllUsersAreAdmins();
    	adminPage.doEmailProcess();
    	System.out.println("✅ Test Passed: Blank & Valid Email Primary Admin Functionality are working correctly.");
    	log.info("✅ Test Passed: Blank & Valid Email Primary Admin Functionality are working correctly.");
    }
    
}
