package tests.pages_PHY;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.options.LoadState;

import base.BaseTest;
import pages.LoginProcess;
import pages_PHY.PHY_Administration;
import pages_PHY.PHY_Dashboard;
import pages_PHY.PHY_Invitation_Log;
import pages_PHY.PHY_Invite_Physician;

public class PHY_05_Invite_Physician_Test extends BaseTest {
	
	private static final Logger log = LogManager.getLogger(PHY_02_Dashboard_Nav_Test.class);
	public BaseTest base;
    public LoginProcess login;
    public PHY_Dashboard dashboard;
    public PHY_Administration adminPage; 
    public PHY_Invite_Physician invitePhy;
    public PHY_Invitation_Log inviteLog; 
	
    @BeforeMethod
    public void appLoginSetup() throws InterruptedException {
        log.info("Before method"); 
        page.navigate(prop.getProperty("url").trim());
        page.waitForLoadState(LoadState.LOAD);

        login = new LoginProcess(page);
        login.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim(), prop.getProperty("otp").trim());

        System.out.println("Navigated to: Dashboard- " + login.gePHYtWelcomMsg());

        dashboard = new PHY_Dashboard(page);
        dashboard.goToAdministrator();

        adminPage = new PHY_Administration(page, prop);
        adminPage.clickNewPhysician();
        invitePhy = new PHY_Invite_Physician(page, prop);

    }
    
    
    @Test (priority = 1, description = "Invite PHY- Validate Blank Input")
    public void PhysicianInvite_BlankInput_Test() throws InterruptedException {    
//        page.navigate(prop.getProperty("url").trim());
//        page.waitForLoadState(LoadState.LOAD);
//
//        login = new LoginProcess(page);
//        login.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim(), prop.getProperty("otp").trim());
//
//        System.out.println("Navigated to: Dashboard- " + login.gePHYtWelcomMsg());
//
//        dashboard = new PHY_Dashboard(page);
//        dashboard.goToAdministrator();
//
//        adminPage = new PHY_Administration(page, prop);
//        adminPage.clickNewPhysician();
//        invitePhy = new PHY_Invite_Physician(page, prop);
        
        //actual test
    	invitePhy.clickInvite();
    	invitePhy.verifyFullName();
    	invitePhy.verifyMobile();
    	invitePhy.verifyEmail();
        log.info("✅ Test Passed: All blank input validations are working correctly.");
        System.out.println("✅ Test Passed: All blank input validations are working correctly.");
    }
    
    
    @Test (priority = 2, description = "Invite PHY- Valid Input")
    public void PhysicianInvite_ValidInput_Test() throws InterruptedException {    
    	invitePhy.InviteNewPhy();
    	adminPage.clickInvitationLog();
    	inviteLog.searchInvitePhy();
        page.waitForLoadState(LoadState.LOAD);
        Assert.assertEquals(invitePhy.getCreatedPhy(), prop.getProperty("newPhyName"));
    	
        log.info("✅ Test Passed: Invite PHY- Valid Input.");
        System.out.println("✅ Test Passed: Invite PHY- Valid Input.");
        
    }

    


}
