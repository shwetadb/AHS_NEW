package tests.pages_PHY;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import base.BaseTest;
import constants.AppConstants;
import pages.LoginProcess;
import pages_PHY.PHY_Dashboard;
import pages_PHY.PHY_Physician_Profile;

public class PHY_02_Dashboard_Nav_Test extends BaseTest {
	
	private static final Logger log = LogManager.getLogger(PHY_02_Dashboard_Nav_Test.class);
	public BaseTest base;
    public LoginProcess login;
    public PHY_Dashboard dashboard;
    

	
    @BeforeMethod
    public void appLoginSetup() throws InterruptedException {
    	log.info("Before method"); 
    	page.navigate(prop.getProperty("url").trim());
    	login = new LoginProcess(page);
    	login.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim(), prop.getProperty("otp").trim());
        System.out.println("Navigated to: Dashboard- " + login.gePHYtWelcomMsg());
        dashboard = new PHY_Dashboard(page);

    }


    @Test(priority = 1, description = "Verify successful navigattion between side-menu")
    public void SideMenuNavigationTest() throws InterruptedException {
   	
        log.info("Dashboard initialized successfully.");

    	log.info("Starting SideMenuNavigationTest");
    	Thread.sleep(1000);
    	
    	dashboard.goToReviewProfile();
    	String reviewProfileHeading = dashboard.getReviewProfileHeading();
    	System.out.println("Navigated to: " + reviewProfileHeading);
    	AssertJUnit.assertEquals(reviewProfileHeading, AppConstants.HEADING_PHYSICIAN_PROFILE);
    	Thread.sleep(1000);
    	
    	dashboard.goToAdministrator();
    	String reviewAdministratorHeading = dashboard.getAdministratorHeading();
    	System.out.println("Navigated to: " + reviewAdministratorHeading);
    	AssertJUnit.assertEquals(reviewAdministratorHeading, AppConstants.HEADING_ADMINISTRATOR);
    	Thread.sleep(1000);
    	
    	dashboard.goToAdminActivityReport();
    	String adminActivityHeading = dashboard.getAdminActivityReportHeading();
    	System.out.println("Navigated to: " + adminActivityHeading);
    	AssertJUnit.assertEquals(adminActivityHeading, AppConstants.HEADING_ADMIN_ACTIVITY_REPORT);
    	Thread.sleep(1000);
    	
    	dashboard.goToPracticeDocument();
    	String practiceDocumentHeading = dashboard.getPracticeDocumentHeading();
    	System.out.println("Navigated to: " + practiceDocumentHeading);
    	AssertJUnit.assertEquals(practiceDocumentHeading, AppConstants.HEADING_PRACTICE_DOCUMENT);
    	Thread.sleep(1000);
    	
    	dashboard.goToPatientList();
    	String patientListHeading = dashboard.getPatientListHeading();
    	System.out.println("Navigated to: " + patientListHeading);
    	AssertJUnit.assertEquals(patientListHeading, AppConstants.HEADING_PATIENT_LIST);
    	Thread.sleep(1000);
    	
    	dashboard.goToCOE();
    	String coeHeading = dashboard.getCOEHeading();
    	System.out.println("Navigated to: " + coeHeading);
    	AssertJUnit.assertEquals(coeHeading, AppConstants.HEADING_COE);
    	Thread.sleep(1000);
	
    	dashboard.goToEmailTransferLogs();
    	String emailTransferLogHeading = dashboard.getEmailTransferLogsHeading();
    	System.out.println("Navigated to: " + emailTransferLogHeading);
    	AssertJUnit.assertEquals(emailTransferLogHeading, AppConstants.HEADING_REFERRAL_RECIVED);
    	Thread.sleep(1000);
    	
    	dashboard.goToTransferReport();
    	String transferReportHeading = dashboard.getTransferReportHeading();
    	System.out.println("Navigated to: " + transferReportHeading);
    	AssertJUnit.assertEquals(transferReportHeading, AppConstants.HEADING_TRANSFER_REPORT);
    	Thread.sleep(1000);
    	
    	dashboard.goToContactUs();
    	String contactUsHeading = dashboard.getContactUSHeading();
    	System.out.println("Navigated to: " + contactUsHeading);
    	AssertJUnit.assertEquals(contactUsHeading, AppConstants.HEADING_CONTACT_US);
    	Thread.sleep(1000);
    	
    	dashboard.goToHomePage();
    	String dashboardHeading = dashboard.getHomePageHeading();
    	System.out.println("Navigated to: Dashboard- " + dashboardHeading);
    	AssertJUnit.assertEquals(dashboardHeading, AppConstants.DASHBOARD_WELCOME_MSG);
    	Thread.sleep(1000);
    	
    	dashboard.goToFAQ();
    	Thread.sleep(1000);
    	
    	dashboard.clickLogout();
    	Thread.sleep(1000);
    	
    	
    }
    
    
    
    @Test(priority = 2, description = "Verify successful navigattion between Links")
    public void linksNavigationTest() throws InterruptedException {
        
        // Now initialize the dashboard object
        log.info("Dashboard initialized successfully.");
    	log.info("Starting linksNavigationTest");
    	Thread.sleep(1000);
    	
    	/*
    	 * Actual Test
    	 */
    	dashboard.clickReferralRecived();
	    	String emailTransferLogHeading = dashboard.getEmailTransferLogsHeading();
	    	System.out.println("Navigated to: " + emailTransferLogHeading);
	    	AssertJUnit.assertEquals(emailTransferLogHeading, AppConstants.HEADING_REFERRAL_RECIVED);
	    	Thread.sleep(1000);
    	dashboard.goToHomePage();
    	
    	dashboard.clickReferralSent();
	    	String referralSentHeading = dashboard.getReferralSentHeading();
	    	System.out.println("Navigated to: " + referralSentHeading);
	    	AssertJUnit.assertEquals(referralSentHeading, AppConstants.HEADING_REFERRAL_SENT);
	    	Thread.sleep(1000);
    	dashboard.goToHomePage();
    	
    	dashboard.clickDocToDocLog();
	    	String docToDocHeading = dashboard.getDocToDocLogHeading();
	    	System.out.println("Navigated to: " + docToDocHeading);
	    	AssertJUnit.assertEquals(docToDocHeading, AppConstants.HEADING_DOCTODOC_EMAIL);
	    	Thread.sleep(1000);
    	dashboard.goToHomePage();
    	
    	dashboard.clickPatientOpinionReq();
	    	String patOpinionHeading = dashboard.getPatientOpinionReqHeading();
	    	System.out.println("Navigated to: " + patOpinionHeading);
	    	AssertJUnit.assertEquals(patOpinionHeading, AppConstants.HEADING_PATIENT_OPINION_REQ);
	    	Thread.sleep(1000);
    	dashboard.goToHomePage();
    	
    	dashboard.clickReferralSentAlink();
	    	System.out.println("Navigated to: " + referralSentHeading);
	    	AssertJUnit.assertEquals(referralSentHeading, AppConstants.HEADING_REFERRAL_SENT);
	    	Thread.sleep(1000);
    	dashboard.goToHomePage();
    	
    	dashboard.clickAReferralRecived();
	    	System.out.println("Navigated to: " + emailTransferLogHeading);
	    	AssertJUnit.assertEquals(emailTransferLogHeading, AppConstants.HEADING_REFERRAL_RECIVED);
	    	Thread.sleep(1000);
    	dashboard.goToHomePage();
    	
    	dashboard.clickPatientInvitation();
	    	String patInviteHeading = dashboard.getPatientInvitationHeading();
	    	System.out.println("Navigated to: " + patInviteHeading);
	    	AssertJUnit.assertEquals(patInviteHeading, AppConstants.HEADING_PATIENT_INVITATION);
	    	Thread.sleep(1000);
    	dashboard.goToHomePage();
    	
    	dashboard.clickPracticeDocSigned();
	    	String patientListHeading = dashboard.getPatientListHeading();
	    	System.out.println("Navigated to: " + patientListHeading);
	    	AssertJUnit.assertEquals(patientListHeading, AppConstants.HEADING_PATIENT_LIST);
	    	Thread.sleep(1000);
    	dashboard.goToHomePage();
    	
    }

    
}
