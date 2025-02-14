//package pages_PHY;
//
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.options.LoadState;
//import org.testng.AssertJUnit;
//
//
//import constants.AppConstants;
//
//import java.util.Properties;
//
//public class PHY_PhysicianProfile {
//	protected Page page;
//    protected Properties prop;
//	public PHY_PhysicianProfile profile;
//	
//	//1. Locators
//	private String field_fullName = "//input[@placeholder='Full Name']";
//		private String alert_fullName = "//div[contains(text(),'Please Enter Full Name.')]";
//	private String field_mobile = "//input[@placeholder='Mobile']";
//		private String alert_mobile = "//div[contains(text(),'Please Enter Mobile.')]";
//	private String field_practiceName = "//input[@placeholder='Practice Name']";
//		private String alert_practiceName = "//div[contains(text(),'Please Enter Practice Name.')]";
//	private String field_siteURL = "//input[@placeholder='Site URL']";
//	private String field_1stStreet = "//input[@placeholder='1st Stree']";
//		private String alert_1stStreet = "//div[contains(text(),'Please Enter 1st Street.')]";
//	private String field_2ndStreet = "//input[@placeholder='2nd Street']";
//	private String field_cityTown = "//input[@placeholder='City/Town']";
//		private String alert_cityTown = "//div[contains(text(),'Please Enter city.')]";
//	private String dropdwn_OfficeState = "//select[@name='office_state']";
//	private String field_officeAdd = "//input[@placeholder='Office Address']";
//		private String alert_officeAdd = "//div[contains(text(),'Please Enter Office Address.')]";
//	private String field_zip = "//input[@placeholder='ZIP Code']";
//		private String alert_zip = "//div[contains(text(),'Please Enter Zipcode')]";
//	private String field_officePhone = "//input[@placeholder='Office Phone']";
//		private String alert_officePhone = "//div[contains(text(),'Please Enter Office Phone.')]";
//	private String field_degree = "//input[@placeholder='Degree']";
//		private String alert_degree = "//div[contains(text(),'Please Enter Degree.')]";
//	private String field_speciality = "//input[@placeholder='Speciality']";
//		private String alert_speciality = "//div[contains(text(),'Please Enter Speciality.')]";
//	private String field_subSpeciality = "//input[@placeholder='Sub Speciality']";
//		private String alert_subSpeciality = "//div[contains(text(),'Please Enter Sub Speciality.')]";
//	private String dropdwn_priState = "//select[@name='primaryState']";
//	private String field_licNoPri = "//input[@placeholder='Primary State License No.']";
//		private String alert_licNoPri = "//div[contains(text(),'Please Enter Primary State License No.')]";
//	private String dropdwn_secState = "//select[@name='secondryState']";
//	private String field_secLicNo = "//input[@placeholder='Secondary State License No.']";
//	private String btn_HomePage = "//a[normalize-space()='Home Page']";
//	private String btn_Update = "//button[normalize-space()='Update']";
//	private String alert_message = "//div[@id='swal2-html-container']";
//	private String btn_OK = "//button[normalize-space()='OK']";
//	private String btn_cancel = "//button[normalize-space()='Cancel']";
//	/*
//	 * Tabs
//	 */
//	private String tab_reviewSignedDoc = "//button[normalize-space()='Review Signed AHS Documents']";
//		private String heading_reviewSignedDoc = "//span[@class='title-text']";
//	private String tab_changeSecurityQuest = "//button[normalize-space()='Change Security Questions']";
//		private String heading_changeSecurityQuest = "//h5[normalize-space()='Update Security Questions']";
//	private String tab_changePassword = "//button[normalize-space()='Change Password']";
//		private String heading_updatePassword = "//h5[normalize-space()='Update Password']";
//	private String tab_profile = "//button[normalize-space()='Physician profile']";
//	private String tab_signDoc = "//button[normalize-space()='Sign AHS Documents']";
//	private String heading_signDoc = "//span[normalize-space()='Profile Document Page']";
//	
//	
//	//2. page constructor:
//	public PHY_PhysicianProfile(Page page, Properties prop) {
//		this.page = page;
//		this.prop = prop;
//	}
//	
//	
//	//3. page action/methods:
//	public void clickUpdate() {
//		page.click(btn_Update);
//		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
//	}
//	
//	public String noUpdateMsg() {
//		page.waitForSelector(alert_message, new Page.WaitForSelectorOptions().setTimeout(90000)); // Wait for visibility
//		System.out.println(page.innerText(alert_message));
//     return page.innerText(alert_message);
//	}
//	
//	private void clickHomePage() {
//		page.click(btn_HomePage);
//		page.waitForLoadState(LoadState.NETWORKIDLE);
//	}
//	
//	public void verifyFullName(String fullName) {
//		page.click(field_fullName);
//		page.locator(field_fullName).fill(fullName);
//	}
//	
//		public String getAlertFullName() {
//		    page.waitForSelector(alert_fullName);
//		    String blank_fullName = page.innerText(alert_fullName);
//			AssertJUnit.assertEquals(blank_fullName, AppConstants.BLANK_FULL_NAME);
//			return page.innerText(alert_fullName);
//		}
//	
//	public String verifyMobile(String mobile) {
//	    page.click(field_mobile);
//	    page.locator(field_mobile).fill(mobile);
//	    page.waitForSelector(alert_mobile);
//	    return page.innerText(alert_mobile);
//	}
//
//	public String verifyPracticeName(String practiceName) {
//	    page.click(field_practiceName);
//	    page.locator(field_practiceName).fill(practiceName);
//	    page.waitForSelector(alert_practiceName);
//	    return page.innerText(alert_practiceName);
//	}
//
//	public String verify1stStreet(String street) {
//	    page.click(field_1stStreet);
//	    page.locator(field_1stStreet).fill(street);
//	    page.waitForSelector(alert_1stStreet);
//	    return page.innerText(alert_1stStreet);
//	}
//
//	public String verifyCity(String city) {
//	    page.click(field_cityTown);
//	    page.locator(field_cityTown).fill(city);
//	    page.waitForSelector(alert_cityTown);
//	    return page.innerText(alert_cityTown);
//	}
//
//	public String verifyOfficeAddress(String officeAddress) {
//	    page.click(field_officeAdd);
//	    page.locator(field_officeAdd).fill(officeAddress);
//	    page.waitForSelector(alert_officeAdd);
//	    return page.innerText(alert_officeAdd);
//	}
//
//	public String verifyZipCode(String zip) {
//	    page.click(field_zip);
//	    page.locator(field_zip).fill(zip);
//	    page.waitForSelector(alert_zip);
//	    return page.innerText(alert_zip);
//	}
//
//	public String verifyOfficePhone(String officePhone) {
//	    page.click(field_officePhone);
//	    page.locator(field_officePhone).fill(officePhone);
//	    page.waitForSelector(alert_officePhone);
//	    return page.innerText(alert_officePhone);
//	}
//
//	public String verifyDegree(String degree) {
//	    page.click(field_degree);
//	    page.locator(field_degree).fill(degree);
//	    page.waitForSelector(alert_degree);
//	    return page.innerText(alert_degree);
//	}
//
//	public String verifySpeciality(String speciality) {
//	    page.click(field_speciality);
//	    page.locator(field_speciality).fill(speciality);
//	    page.waitForSelector(alert_speciality);
//	    return page.innerText(alert_speciality);
//	}
//
//	public String verifySubSpeciality(String subSpeciality) {
//	    page.click(field_subSpeciality);
//	    page.locator(field_subSpeciality).fill(subSpeciality);
//	    page.waitForSelector(alert_subSpeciality);
//	    return page.innerText(alert_subSpeciality);
//	}
//
//	public String verifyPrimaryLicNo(String licNo) {
//	    page.click(field_licNoPri);
//	    page.locator(field_licNoPri).fill(licNo);
//	    page.waitForSelector(alert_licNoPri);
//	    return page.innerText(alert_licNoPri);
//	}
//	
//	public void verifyFields() throws InterruptedException {
////		verifyFullName("");
//		page.locator(field_fullName).press("Control+A");
//		page.locator(field_fullName).press("Delete");
//		page.locator(field_fullName).press("Enter");
//		getAlertFullName();
//			Thread.sleep(1000);
////		verifyMobile(prop.getProperty("mobile"));
////	    page.locator(field_mobile).press("Enter");
////		Thread.sleep(1000);
////		verifyPracticeName("practiceName");
////	    page.locator(field_practiceName).press("Enter");
////		Thread.sleep(1000);
////		verify1stStreet("street");
////	    page.locator(field_1stStreet).press("Enter");
////		Thread.sleep(1000);
////		verifyCity("city");
////	    page.locator(field_cityTown).press("Enter");
////		Thread.sleep(1000);
////		verifyOfficeAddress("officeAddress");
////	    page.locator(field_officeAdd).press("Enter");
////		Thread.sleep(1000);
////		verifyZipCode("zip");
////	    page.locator(field_zip).press("Enter");
////		Thread.sleep(1000);
////		verifyOfficePhone("officePhone");
////	    page.locator(field_officePhone).press("Enter");
////		Thread.sleep(1000);
////		verifyDegree("degree");
////	    page.locator(field_degree).press("Enter");
////		Thread.sleep(1000);
////		verifySpeciality("speciality");
////	    page.locator(field_speciality).press("Enter");
////		Thread.sleep(1000);
////		verifySubSpeciality("subSpeciality");
////	    page.locator(field_subSpeciality).press("Enter");
////		Thread.sleep(1000);
////		verifyPrimaryLicNo("licNo");
////	    page.locator(field_licNoPri).press("Enter");
////		Thread.sleep(1000);
//	}
//	
//	public void updateFields() throws InterruptedException {
//		verifyFullName(prop.getProperty("fullName"));
//		 page.locator(field_fullName).press("Enter");
//		Thread.sleep(1000);
//		verifyMobile(prop.getProperty("mobile"));;
//		Thread.sleep(1000);
//		verifyPracticeName(prop.getProperty("practiceName"));
//		Thread.sleep(1000);
//		verify1stStreet(prop.getProperty("street"));
//		Thread.sleep(1000);
//		verifyCity(prop.getProperty("city"));
//		Thread.sleep(1000);
//		verifyOfficeAddress(prop.getProperty("officeAddress"));
//		Thread.sleep(1000);
//		verifyZipCode(prop.getProperty("zip"));
//		Thread.sleep(1000);
//		verifyOfficePhone(prop.getProperty("officePhone"));
//		Thread.sleep(1000);
//		verifyDegree(prop.getProperty("degree"));
//		Thread.sleep(1000);
//		verifySpeciality(prop.getProperty("speciality"));
//		Thread.sleep(1000);
//		verifySubSpeciality(prop.getProperty("subSpeciality"));
//		Thread.sleep(1000);
//		verifyPrimaryLicNo(prop.getProperty("licNo"));
//		Thread.sleep(1000);
//	}
//
//}


package pages_PHY;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;

import org.testng.AssertJUnit;

import constants.AppConstants;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Properties;

public class PHY_Physician_Profile {
    protected Page page;
    protected Properties prop;

	//1. Locators
	private String field_fullName = "//input[@placeholder='Full Name']";
		private String alert_fullName = "//div[contains(text(),'Please Enter Full Name.')]";
	private String field_mobile = "//input[@placeholder='Mobile']";
		private String alert_mobile = "//div[contains(text(),'Please Enter Mobile.')]";
	private String field_practiceName = "//input[@placeholder='Practice Name']";
		private String alert_practiceName = "//div[contains(text(),'Please Enter Practice Name.')]";
	private String field_siteURL = "//input[@placeholder='Site URL']";
	private String field_1stStreet = "//input[@placeholder='1st Stree']";
		private String alert_1stStreet = "//div[contains(text(),'Please Enter 1st Street.')]";
	private String field_2ndStreet = "//input[@placeholder='2nd Street']";
	private String field_cityTown = "//input[@placeholder='City/Town']";
		private String alert_cityTown = "//div[contains(text(),'Please Enter city.')]";
	private String dropdwn_OfficeState = "//select[@name='office_state']";
	private String field_officeAdd = "//input[@placeholder='Office Address']";
		private String alert_officeAdd = "//div[contains(text(),'Please Enter Office Address.')]";
	private String field_zip = "//input[@placeholder='ZIP Code']";
		private String alert_zip = "//div[contains(text(),'Please Enter Zipcode')]";
	private String field_officePhone = "//input[@placeholder='Office Phone']";
		private String alert_officePhone = "//div[contains(text(),'Please Enter Office Phone.')]";
	private String field_degree = "//input[@placeholder='Degree']";
		private String alert_degree = "//div[contains(text(),'Please Enter Degree.')]";
	private String field_speciality = "//input[@placeholder='Speciality']";
		private String alert_speciality = "//div[contains(text(),'Please Enter Speciality.')]";
	private String field_subSpeciality = "//input[@placeholder='Sub Speciality']";
		private String alert_subSpeciality = "//div[contains(text(),'Please Enter Sub Speciality.')]";
	private String dropdwn_priState = "//select[@name='primaryState']";
	private String field_licNoPri = "//input[@placeholder='Primary State License No.']";
		private String alert_licNoPri = "//div[contains(text(),'Please Enter Primary State License No.')]";
	private String dropdwn_secState = "//select[@name='secondryState']";
	private String field_secLicNo = "//input[@placeholder='Secondary State License No.']";
	private String btn_HomePage = "//a[normalize-space()='Home Page']";
	private String btn_Update = "//button[normalize-space()='Update']";
	private String alert_message = "//div[@id='swal2-html-container']";
	private String confirm_message = "(//div[@id='swal2-html-container'])[1]";
	private String PleaseConfirm_msg = "(//div[@id='swal2-html-container'])[1]";
	private String btn_OK = "//button[normalize-space()='OK']";
	private String btn_cancel = "//button[normalize-space()='Cancel']";
	/*
	 * Tabs
	 */
	private String tab_reviewSignedDoc = "//button[normalize-space()='Review Signed AHS Documents']";
		private String heading_reviewSignedDoc = "//span[@class='title-text']";
	private String tab_changeSecurityQuest = "//button[normalize-space()='Change Security Questions']";
		private String heading_changeSecurityQuest = "//h5[normalize-space()='Update Security Questions']";
	private String tab_changePassword = "//button[normalize-space()='Change Password']";
		private String heading_updatePassword = "//h5[normalize-space()='Update Password']";
	private String tab_profile = "//button[normalize-space()='Physician profile']";
	/*
	 * Sign Document
	 */
	private String tab_signDoc = "//button[normalize-space()='Sign AHS Documents']";
		private String heading_signDoc = "//span[normalize-space()='Profile Document Page']";
	private String check_selectAllDoc = "//input[@id='selectAll']";
	private String check_1stDoc = "//input[@id='hipaaAccepted0']";
	private String check_2ndDoc = "(//input[@id='hipaaAccepted1'])[1]";
	private String btn_ClearPreview = "//button[normalize-space()='Clear Preview']";									   
	private String btn_reject = "//input[@value='Reject']";
	private String btn_IAccept = "//input[@value='I Accept']";
	private String heading_SignPage = "//span[normalize-space()='Signature Page']";
	private String signCanvas = "//canvas";
	private String btn_signClear = "//div[@class='btn-group bottom-btn']//a[@class='btn btn-default'][normalize-space()='Clear']";
	private String btn_signCancel = "//a[normalize-space()='Cancel']";
	private String btn_signDone = "//div[@class='btn-group bottom-btn']//a[@class='btn btn-primary save-form1'][normalize-space()='Done']";
	private String heading_DocumentReview ="//span[normalize-space()='Document Review']";
	private String doc_1 = "//div[@class='document-list']//div[1]//a[1]//img[1]";
	private String btn_reviewDocCancel ="//input[@value='Cancel']";
	private String btn_updateSign = "//input[@value='Update Signature']";
	private String btn_submit ="//input[@value='Submit']";
	/*
	 * Signed Document
	 */
	private String signedDoc_1 = "//label[@for='hipaaAccepted0']//img";
	private String signedDoc_2 = "//label[@for='hipaaAccepted1']//img";
	private String signedDoc_3 = "//label[@for='hipaaAccepted2']//img";
	/*
	 * Sequerity Questions
	 */
	private String dropDwn_que1 = "(//select[@name='queId_01'])[1]";
	private String field_ans1 = "//input[@placeholder='Answer 01']";
	private String dropDwn_que2 = "//select[@name='queId_02']";
	private String field_ans2 = "//input[@placeholder='Answer 02']";
	private String btn_update = "//button[normalize-space()='Update']";
	private String alert_ans1 = "//div[contains(text(),'Please Enter Answer 01.')]";
	private String alert_ans2 = "//div[contains(text(),'Please Enter Answer 02.')]";
	/*
	 * Change password
	 */
	private String field_oldPass = "//input[@placeholder='Old Password']";
	private String field_newPass = "//input[@placeholder='New Password']";
	private String field_confNewPass = "//input[@placeholder='Confirm New Password']";
	private String alert_oldPass = "//div[contains(text(),'Please Enter old Password.')]";
	private String alert_newPass = "//div[contains(text(),'Please Enter Password.')]";
	private String alert_confNewPass = "//div[contains(text(),'Please Enter Confirm Password.')]";
	
	
	
    
    // Page constructor
    public PHY_Physician_Profile(Page page, Properties prop) {
        this.page = page;
        this.prop = prop;
    }

    
    
    
    // Generic verification method
    public String verifyField(String fieldLocator, String alertLocator) throws InterruptedException {
        // Clear input field
        page.locator(fieldLocator).press("Control+A");
        page.locator(fieldLocator).press("Delete");
        page.locator(fieldLocator).press("Enter");

        // Wait for the validation alert to appear
        page.waitForSelector(alertLocator);

        // Return the validation message
        return page.innerText(alertLocator);
    }

    // Specific field verification methods
    public String verifyFullName() throws InterruptedException {
        return verifyField(field_fullName, alert_fullName);
    }
    
    public String verifyMobile() throws InterruptedException {
        return verifyField(field_mobile, alert_mobile);
    }
    
    public String verifyPracticeName() throws InterruptedException {
        return verifyField(field_practiceName, alert_practiceName);
    }
    
    public String verify1stStreet() throws InterruptedException {
        return verifyField(field_1stStreet, alert_1stStreet);
    }
    
    public String verifyCity() throws InterruptedException {
        return verifyField(field_cityTown, alert_cityTown);
    }
    
    public String verifyOfficeAddress() throws InterruptedException {
        return verifyField(field_officeAdd, alert_officeAdd);
    }
    
    public String verifyZipCode() throws InterruptedException {
        return verifyField(field_zip, alert_zip);
    }
    
    public String verifyOfficePhone() throws InterruptedException {
        return verifyField(field_officePhone, alert_officePhone);
    }
    
    public String verifyDegree() throws InterruptedException {
        return verifyField(field_degree, alert_degree);
    }
    
    public String verifySpeciality() throws InterruptedException {
        return verifyField(field_speciality, alert_speciality);
    }
    
    public String verifySubSpeciality() throws InterruptedException {
        return verifyField(field_subSpeciality, alert_subSpeciality);
    }
    
    public String verifyPrimaryLicNo() throws InterruptedException {
        return verifyField(field_licNoPri, alert_licNoPri);
    }
    
    
    public String getSignDocumentsHeading() {
    	page.waitForSelector(heading_signDoc, new Page.WaitForSelectorOptions().setTimeout(9000)); // Wait for visibility
    	String signDocumentsHeading = page.innerText(heading_signDoc);
    	System.out.println("Navigated to: " + signDocumentsHeading);
    	
	     return page.innerText(heading_signDoc);
    }
    
    
    
    // Generic update method
    public void updateField(String fieldLocator, String propertyKey) {
        String value = prop.getProperty(propertyKey, "");
        page.locator(fieldLocator).fill(value);
        page.locator(fieldLocator).press("Tab");  // Ensures blur event is triggered
    }

    
    public Page updateProcess() throws InterruptedException {
        page.waitForTimeout(1000);
        page.click(btn_Update);
        page.waitForSelector(alert_message);
        
        String message = page.innerText(alert_message);
        System.out.println("Message: " + message);

        if (page.locator(btn_OK).isVisible()) {
            page.click(btn_OK);
            page.waitForSelector(confirm_message);

            String confirmMsg = page.innerText(confirm_message);
            System.out.println("Confirmation Message: " + confirmMsg);

                page.click(btn_OK);
                String finalMsg = page.innerText(PleaseConfirm_msg);
                System.out.println("Final Confirmation: " + finalMsg);
                page.click(btn_OK);
                System.out.println("Done");
        }

        AssertJUnit.assertEquals(this.getSignDocumentsHeading(), AppConstants.HEADING_SIGN_DOCUMENTS);
        return page;
    }

    

    // Specific field update methods
    public void updateFullName() throws InterruptedException {
        updateField(field_fullName, "fullName");
    }
    
    public void updateMobile() throws InterruptedException {
        updateField(field_mobile, "mobile");
    }
    
    public void updatePracticeName() throws InterruptedException {
        updateField(field_practiceName, "practiceName");
    }
    
    public void update1stStreet() throws InterruptedException {
        updateField(field_1stStreet, "1ststreet");
    }
    
    public void updateCity() throws InterruptedException {
        updateField(field_cityTown, "city");
    }
    
    public void updateOfficeAddress() throws InterruptedException {
        updateField(field_officeAdd, "officeAddress");
    }
    
    public void updateZipCode() throws InterruptedException {
        updateField(field_zip, "zip");
    }
    
    public void updateOfficePhone() throws InterruptedException {
        updateField(field_officePhone, "officePhone");
    }
    
    public void updateDegree() throws InterruptedException {
        updateField(field_degree, "degree");
    }
    
    public void updateSpeciality() throws InterruptedException {
        updateField(field_speciality, "speciality");
    }
    
    public void updateSubSpeciality() throws InterruptedException {
        updateField(field_subSpeciality, "subSpeciality");
    }
    
    public void updatePrimaryLicNo() throws InterruptedException {
        updateField(field_licNoPri, "licNo");
    }

	public void clickUpdate() {
		// TODO Auto-generated method stub
		page.click(btn_Update);
		page.waitForLoadState();
		page.click(btn_OK);
		System.out.println("clicked ok");
		String confirmMsg = page.innerText(confirm_message);
        System.out.println("Confirmation Message: " + confirmMsg);
        assertEquals(confirmMsg, AppConstants.PROFILE_NO_UPDATE_MSG);
//    	assertEquals(this.clickUpdate(), AppConstants.PROFILE_NO_UPDATE_MSG);
//        return page.innerText(confirmMsg);

	}

/*
 * Update Profile Process
 */
	public String selectDocumentsToSign() {
		page.click(btn_Update);
		page.click(check_1stDoc);
			page.click(btn_ClearPreview);
			page.click(btn_OK);
		page.click(check_2ndDoc);
			page.click(btn_ClearPreview);
			page.click(btn_OK);
		page.click(check_selectAllDoc);
		page.waitForSelector(confirm_message);
			String confirmMsg = page.innerText(confirm_message);
	        System.out.println("Confirmation Message: " + confirmMsg);
        page.click(btn_OK);
		page.click(btn_IAccept);
		page.waitForSelector(confirm_message);
	        String IAgree_confirmMsg = page.innerText(confirm_message);
	        System.out.println("Confirmation Message: " + IAgree_confirmMsg);
        page.click(btn_OK);
        
        return page.innerText(heading_SignPage);
	}
	
	
	public String signDigitally() {
		page.innerText(heading_SignPage);
			System.out.println(page.innerText(heading_SignPage));
		page.dblclick(signCanvas);
		page.click(btn_signDone);
			String IAgree_confirmMsg = page.innerText(confirm_message);
	        System.out.println("Confirmation Message: " + IAgree_confirmMsg);
	    page.click(btn_OK);
	    
	    return page.innerText(heading_DocumentReview);
	}
	
	public Page reviewSignedDocuments() {
		page.innerText(heading_DocumentReview);
			System.out.println(page.innerText(heading_DocumentReview));
		page.click(doc_1);
		page.click(btn_ClearPreview);
		page.click(btn_OK);
		page.click(btn_submit);
			String submit_confirmMsg = page.innerText(confirm_message);
	        System.out.println("Confirmation Message: " + submit_confirmMsg);
		page.click(btn_OK);
		
	    return page;
	}
	
/*
 * Review Signed Documents	
 */
	public Page signedDocumentsTab() {
		page.click(tab_reviewSignedDoc);
		page.waitForSelector(heading_reviewSignedDoc);
			System.out.println(page.innerText(heading_reviewSignedDoc));
		
		page.click(signedDoc_1);
		page.waitForLoadState();
		page.click(btn_ClearPreview);
			String confirmMsg = page.innerText(confirm_message);
	        System.out.println("Confirmation Message: " + confirmMsg);
		page.click(btn_OK);
		
		page.click(signedDoc_2);
		page.waitForLoadState();
		page.click(btn_ClearPreview);
			 System.out.println("Confirmation Message: " + confirmMsg);
		page.click(btn_OK);
		
		page.click(signedDoc_2);
		page.waitForLoadState();
		page.click(btn_ClearPreview);
			 System.out.println("Confirmation Message: " + confirmMsg);
		page.click(btn_OK);
		
		return page;
	}
	
/*
 * Update Security Questions
 */
	public String verifyAns1() throws InterruptedException {
        return verifyField(field_ans1, alert_ans1);
    }
	
	public String verifyAns2() throws InterruptedException {
        return verifyField(field_ans2, alert_ans1);
    }
	
	public Page updateSecurityQuestionsTabNav() throws InterruptedException {
        // Navigate to the security questions tab
        page.click(tab_changeSecurityQuest);
        page.waitForSelector(heading_changeSecurityQuest);
        System.out.println(page.innerText(heading_changeSecurityQuest));
        Thread.sleep(1000);
 
        return page;
    }
	
	
	public Page updateSecurityQuestionsTab() throws InterruptedException {
        // Navigate to the security questions tab
        page.click(tab_changeSecurityQuest);
        page.waitForSelector(heading_changeSecurityQuest);
        System.out.println(page.innerText(heading_changeSecurityQuest));
        Thread.sleep(1000);
              
//      String selectedOption = page.innerText(dropDwn_que1);
        String selectedOption = page.locator(dropDwn_que1).inputValue(); 
        System.out.println("Currently selected option: " + selectedOption);
        
        String options = page.innerText(dropDwn_que1);
        System.out.println("Available Options: " + options);
                
        page.locator(dropDwn_que1).selectOption(new SelectOption().setValue("3"));
        String OptionSelected = page.locator(dropDwn_que1).inputValue(); 
        System.out.println("Currently set value: " + OptionSelected);
        
        page.fill(field_ans1, prop.getProperty("ans1"));

        
        //      String selectedOption = page.innerText(dropDwn_que1);
        String selectedOption2 = page.locator(dropDwn_que2).inputValue(); 
        System.out.println("Currently selected option 2: " + selectedOption);
        
        String options2 = page.innerText(dropDwn_que2);
        System.out.println("Available Options2: " + options);
        
        page.locator(dropDwn_que1).selectOption(new SelectOption().setValue("3"));
        String OptionSelected2 = page.locator(dropDwn_que2).inputValue(); 
        System.out.println("Currently set value 2: " + OptionSelected);
        
        page.fill(field_ans2, prop.getProperty("ans2"));

        page.click(btn_update);
	        String submit_confirmMsg = page.innerText(confirm_message);
	        System.out.println("Confirmation Message: " + submit_confirmMsg);
        page.click(btn_OK);
        
        return page;
    }
	
/*
 * Update Password
 */

    public String verifyPasswordField(String fieldLocator, String alertLocator) throws InterruptedException {
        // Clear input field
        page.locator(fieldLocator).press("Tab");
       // Wait for the validation alert to appear
        page.waitForSelector(alertLocator);
        // Return the validation message
        return page.innerText(alertLocator);
    }
    
	public String verifyOldPassword() throws InterruptedException {
        return verifyPasswordField(field_oldPass, alert_oldPass);
    }
	
	public String verifyNewPassword() throws InterruptedException {
        return verifyPasswordField(field_newPass, alert_newPass);
    }
	
	public String verifyConfirmNewPassword() throws InterruptedException {
        return verifyField(field_confNewPass, alert_confNewPass);
    }
	
	
	public Page updatePasswordTabNav() throws InterruptedException {
        // Navigate to the security questions tab
        page.click(tab_changePassword);
        page.waitForSelector(heading_updatePassword);
        System.out.println(page.innerText(heading_updatePassword));
        Thread.sleep(1000);
               return page;
    }
	
	public Page updatePasswordTab() throws InterruptedException {
        // Navigate to the security questions tab
        page.fill(field_oldPass, prop.getProperty("password"));
        page.fill(field_newPass, prop.getProperty("newPassword"));
        page.fill(field_confNewPass, prop.getProperty("newPassword"));
        page.click(btn_update);
	        String submit_confirmMsg = page.innerText(confirm_message);
	        System.out.println("Confirmation Message: " + submit_confirmMsg);
        page.click(btn_OK);
        return page;
    }
}

