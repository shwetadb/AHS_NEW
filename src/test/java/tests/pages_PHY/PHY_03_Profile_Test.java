package tests.pages_PHY;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.LoadState;

import base.BaseTest;
import constants.AppConstants;
import pages.LoginProcess;
import pages_PHY.PHY_Dashboard;
import pages_PHY.PHY_Physician_Profile;

public class PHY_03_Profile_Test extends BaseTest {
	
	private static final Logger log = LogManager.getLogger(PHY_02_Dashboard_Nav_Test.class);
	public BaseTest base;
    public LoginProcess login;
    public PHY_Dashboard dashboard;
    public PHY_Physician_Profile profile;
	
    @BeforeMethod
    public void appLoginSetup() throws InterruptedException {
        // ✅ Start tracing ONLY if browser context is successfully initialized
        log.info("Before method"); 
        page.navigate(prop.getProperty("url").trim()); 
        page.waitForLoadState(LoadState.LOAD);

        login = new LoginProcess(page);
        login.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim(), prop.getProperty("otp").trim());

        System.out.println("Navigated to: Dashboard- " + login.gePHYtWelcomMsg());

        dashboard = new PHY_Dashboard(page);
        dashboard.goToReviewProfile();

        // ✅ Fix: Pass `prop` from BaseTest to PHY_PhysicianProfile
        profile = new PHY_Physician_Profile(page, prop); 
    }


    
    @Test (priority = 1, description = "Without updating click on Update button")
    public void PhysicianProfileNoChanges_Test() throws InterruptedException {
    	profile.clickUpdate();
        log.info("✅ Test Passed: Without updating click on Update button validations are working correctly.");

    }
    
    

    @Test (priority = 2, description = "Profile- Validate Blank Input")
    public void PhysicianProfile_BlankInput_Test() throws InterruptedException {
        assertEquals(profile.verifyFullName(), AppConstants.BLANK_FULL_NAME);
        assertEquals(profile.verifyMobile(), AppConstants.BLANK_MOBILE);
        assertEquals(profile.verifyPracticeName(), AppConstants.BLANK_PRACTICE_NAME);
        assertEquals(profile.verify1stStreet(), AppConstants.BLANK_1ST_STREET);
        assertEquals(profile.verifyCity(), AppConstants.BLANK_CITY);
        assertEquals(profile.verifyOfficeAddress(), AppConstants.BLANK_OFFICE_ADDRESS);
        assertEquals(profile.verifyZipCode(), AppConstants.BLANK_ZIP);
        assertEquals(profile.verifyOfficePhone(), AppConstants.BLANK_OFFICE_PHONE);
        assertEquals(profile.verifyDegree(), AppConstants.BLANK_DEGREE);
        assertEquals(profile.verifySpeciality(), AppConstants.BLANK_SPECIALITY);
        assertEquals(profile.verifySubSpeciality(), AppConstants.BLANK_SUB_SPECIALITY);
        assertEquals(profile.verifyPrimaryLicNo(), AppConstants.BLANK_LIC_NO);
        log.info("✅ Test Passed: Profile- Validate Blank Input are working correctly.");

    }
    
    
    
    @Test(priority = 3, description = "Update Fields with Valid Data and Click Update")
    public void PhysicianProfile_Update_Test() throws InterruptedException {
        profile.updateFullName();
        profile.updateMobile();
        profile.updatePracticeName();
        profile.update1stStreet();
        profile.updateCity();
        profile.updateOfficeAddress();
        profile.updateZipCode();
        profile.updateOfficePhone();
        profile.updateDegree();
        profile.updateSpeciality();
        profile.updateSubSpeciality();
        profile.updatePrimaryLicNo();
        
        profile.updateProcess();  // Clicks update and handles confirmation
        log.info("✅ Test Passed: Update Fields with Valid Data and Click Update are working correctly.");

    }

    

   @Test(priority = 4, description = "Sign Documents after Update")
    public void SignDocumentsAfterUpdate_Test() throws InterruptedException {
	  profile.selectDocumentsToSign();
	  profile.signDigitally();
	  profile.reviewSignedDocuments();
	  Thread.sleep(1000);
	    	  
  	  AssertJUnit.assertEquals(dashboard.getHomePageHeading(), AppConstants.DASHBOARD_WELCOME_MSG);
  	  System.out.println("Navigated to: Dashboard- " + dashboard.getHomePageHeading());
      log.info("✅ Test Passed: Sign Documents after Update are working correctly.");

	}

    
    
   @Test(priority = 5, description = "Sign Documents Tab Document Verification")
    public void signedDocumentsTab_Test() throws InterruptedException {
	  profile.signedDocumentsTab();
      log.info("✅ Test Passed: Sign Documents Tab Document Verification are working correctly.");

    }
  
   
   
  @Test(priority = 6, description = "Blank Answer Field Validation")
  	public void updateSecurityQuestionsNav_Test() throws InterruptedException {
	  profile.updateSecurityQuestionsTabNav();
	  assertEquals(profile.verifyAns1(), AppConstants.BLANK_ANSWER_01);
	  assertEquals(profile.verifyAns2(), AppConstants.BLANK_ANSWER_02);
      log.info("✅ Test Passed: Blank Answer Field Validations are working correctly.");

  }
  
  @Test(priority = 7, description = "Update Security Answer")
  	public void updateSecurityQuestionsTab_Test() throws InterruptedException {
	  profile.updateSecurityQuestionsTab();
      log.info("✅ Test Passed: Update Security Answer are working correctly.");

  	}
  
  
  @Test(priority = 8, description = "Validate Blank Input Password Fields")
  	public void updateBlankPassword_Test() throws InterruptedException {
	  profile.updatePasswordTabNav();
    assertEquals(profile.verifyOldPassword(), AppConstants.BLANK_OLD_PASSWORD);
    assertEquals(profile.verifyNewPassword(), AppConstants.BLANK_NEW_PASSWORD);
    assertEquals(profile.verifyConfirmNewPassword(), AppConstants.BLANK_CONFIRM_NEW_PASSWORD);
    log.info("✅ Test Passed: Validate Blank Input Password Fields validations are working correctly.");

  	}
  
  
  
  @Test(priority = 9, description = "Update Password Valid")
  	public void updatePasswordTab_Test() throws InterruptedException {
	  profile.updatePasswordTabNav();
      log.info("✅ Test Passed: Update Password  validations are working correctly.");

  	}
  
  
}
