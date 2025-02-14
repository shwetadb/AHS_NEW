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
import pages_PHY.PHY_Invite_Admin;



public class PHY_06_Invite_Admin_Test extends BaseTest{
	
	private static final Logger log = LogManager.getLogger(PHY_02_Dashboard_Nav_Test.class);
	public BaseTest base;
    public LoginProcess login;
    public PHY_Dashboard dashboard;
    public PHY_Administration adminPage; 
    public PHY_Invite_Admin inviteAdmin;
    public PHY_Invitation_Log inviteLog; 

    
    @BeforeMethod
    public void appLoginSetup() throws InterruptedException {
        log.info("Before method"); 

    }
    
    
    
    @Test (priority = 1, description = "Invite Admin- Validate Blank Input")
    public void PhysicianInvite_BlankInput_Test() throws InterruptedException {    
        page.navigate(prop.getProperty("url").trim());
        page.waitForLoadState(LoadState.LOAD);

        login = new LoginProcess(page);
        login.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim(), prop.getProperty("otp").trim());

        System.out.println("Navigated to: Dashboard- " + login.gePHYtWelcomMsg());

        dashboard = new PHY_Dashboard(page);
        dashboard.goToAdministrator();

        adminPage = new PHY_Administration(page, prop);
        adminPage.clickNewAdmin();
        inviteAdmin = new PHY_Invite_Admin(page, prop);
        inviteLog = new PHY_Invitation_Log(page, prop);
        
        //actual test
        inviteAdmin.clickAddAdmin();
        inviteAdmin.verifyFullName();
        inviteAdmin.verifyMobile();
        inviteAdmin.verifyEmail();
        inviteAdmin.verifyDesignation();
        log.info("✅ Test Passed: All blank input validations are working correctly for Invite Admin.");
        System.out.println("✅ Test Passed: All blank input validations are working correctly for Invite Admin.");
    }
    
    
    @Test (priority = 2, description = "Invite Admin- Valid Input")
    public void PhysicianInvite_ValidInput_Test() throws InterruptedException {    
    	inviteAdmin.InviteNewAdmin();
    	adminPage.clickInvitationLog();
    	inviteLog.searchInviteAdmin();
        Assert.assertEquals(inviteAdmin.getCreatedAdmin(), prop.getProperty("newAdminName"));

    	
        log.info("✅ Test Passed: Invite Admin- Valid Input.");
        System.out.println("✅ Test Passed: Invite Admin- Valid Input.");
        
    }

}
