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
import pages_PHY.PHY_Invite_Physician;

public class PHY_07_Invitation_Log_Test extends BaseTest {
	
	private static final Logger log = LogManager.getLogger(PHY_02_Dashboard_Nav_Test.class);
	public BaseTest base;
    public LoginProcess login;
    public PHY_Dashboard dashboard;
    public PHY_Administration adminPage; 
    public PHY_Invite_Physician invitePhy;
    public PHY_Invite_Admin inviteAdmin;
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
        adminPage.clickInvitationLog();

        inviteLog = new PHY_Invitation_Log(page, prop);
        
    }

    
    
//    @Test (priority = 1, description = "Apply Filter by User Role")
//    public void VerifyUserRole_Test() throws InterruptedException {  
//
//        // Verify if all users are "Administrative"
//        boolean admin = inviteLog.verifyAllUsersAreAdmins();
//        page.waitForLoadState(LoadState.LOAD);
//        Assert.assertTrue(admin, "Some users are not 'Administrative'");
//        Thread.sleep(1000);
//     // Verify if all users are "Physicians"
//        boolean physician = inviteLog.verifyAllUsersArePhysicians();
//        page.waitForLoadState(LoadState.LOAD);
//        Assert.assertTrue(physician, "Some users are not 'Physicians'");
//        
//        inviteLog.clickReset();
//        page.waitForLoadState(LoadState.LOAD);
//        log.info("✅ Test Passed: Apply Filter by User Role are working correctly.");
//
//    }
    
    
    
    @Test (priority = 2, description = "Search the invited Physician or Admin")
    public void searchInvite_Test() {
    	inviteLog.searchInvitePhy();
        page.waitForLoadState(LoadState.LOAD);
        Assert.assertEquals(invitePhy.getCreatedPhy(), prop.getProperty("newPhyName"));     
        
        inviteLog.clearSearchField();
        inviteLog.searchInviteAdmin();
        inviteAdmin = new PHY_Invite_Admin(page, prop);
        Assert.assertEquals(inviteAdmin.getCreatedAdmin(), prop.getProperty("newAdminName"));

        System.out.println("✅ Test Passed: Invited Admin/Physician found.");
    }
    
    
    
    @Test (priority = 3, description = "Resend the invited Physician")
    public void resendInvitePhy_Test() throws InterruptedException {
    	inviteLog.searchInvitePhy();
        page.waitForLoadState(LoadState.LOAD);
        invitePhy = new PHY_Invite_Physician(page, prop);
        Assert.assertEquals(invitePhy.getCreatedPhy(), prop.getProperty("newPhyName"));
        inviteLog.clickResend();
        inviteLog.clickConfirm();
        Thread.sleep(2000);

        System.out.println("✅ Test Passed: Presend Invited Physician Passed.");
    }
    
    
    @Test (priority = 4, description = "Resend the invited Admin")
    public void resendInviteAdmin_Test() throws InterruptedException {
        inviteLog.searchInviteAdmin();
        page.waitForLoadState(LoadState.LOAD);
        Assert.assertEquals(inviteAdmin.getCreatedAdmin(), prop.getProperty("newAdminName"));
        inviteLog.clickResend();
        inviteLog.clickConfirm();

        System.out.println("✅ Test Passed: Presend Invited Admin Passed.");
    }

    
    
   

}
