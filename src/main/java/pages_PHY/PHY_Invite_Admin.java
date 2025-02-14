package pages_PHY;

import java.util.Properties;
import java.util.Random;

import org.testng.Assert;

import com.microsoft.playwright.Page;

import constants.AppConstants;

public class PHY_Invite_Admin {
	private Page page;
	private Properties prop;
	
	//Locators
	private String field_fullName = "//input[@placeholder='Full Name']";
	private String field_mobile = "//input[@placeholder='Mobile']";
	private String field_email = "//input[@placeholder='Email']";
	private String dropDwn_designation ="//select[@name='designation']";
	private String btn_cancel = "//a[normalize-space()='Cancel']";
	private String btn_add = "//button[normalize-space()='Add']";
	private String alert_fullName = "//div[contains(text(),'Please Enter Full Name.')]";
	private String alert_mobile = "//div[contains(text(),'Please Enter Mobile.')]";
	private String alert_email = "//div[contains(text(),'Please Enter Email.')]";
	private String alert_designation = "//div[contains(text(),'Please Select a Designation')]";
	private String btn_Ok = "//button[normalize-space()='OK']";
	private String msg_confirm = "//div[@id='swal2-html-container']";
    private String userTypeColumn1 = "//table[@id='DataTables_Table_1']//tbody//td[1]";

	
	
	
	// Page constructor
    public PHY_Invite_Admin (Page page, Properties prop) {
        this.page = page;
        this.prop = prop;
    }
    
    
    //methods
    public void clickAddAdmin() {
    	page.click(btn_add);
    }
    
    
    public String verifyFullName() throws InterruptedException {
		page.waitForSelector(alert_fullName);
		String fullName = page.innerText(alert_fullName);
		Assert.assertEquals(fullName, AppConstants.BLANK_FULL_NAME);
        return page.innerText(alert_fullName);
    }
    
    public String verifyMobile() throws InterruptedException {
		page.waitForSelector(alert_mobile);
		String mobile = page.innerText(alert_mobile);
		Assert.assertEquals(mobile, AppConstants.BLANK_MOBILE);
        return page.innerText(alert_mobile);
    }
    
    public String verifyEmail() throws InterruptedException {
		page.waitForSelector(alert_email);
		String email = page.innerText(alert_email);
		Assert.assertEquals(email, AppConstants.BLANK_EMAIL);
        return page.innerText(alert_email);
    }
    
    
    public String verifyDesignation() throws InterruptedException {
		page.waitForSelector(alert_designation);
		String designation = page.innerText(alert_designation);
		Assert.assertEquals(designation, AppConstants.BLANK_DESIGNATION);
        return page.innerText(alert_designation);
    }
    
    
    public void clickCancel() {
    	page.click(btn_cancel);
    }
    
    
    
    public Page InviteNewAdmin() {
        String mobile = "9" + (new Random().nextInt(900000000) + 100000000);  // Generates a 10-digit number

        // Print for debugging
        System.out.println("Generated Mobile: " + mobile);
        
        page.fill(field_fullName, prop.getProperty("newAdminName"));
        page.fill(field_mobile, mobile);
        page.fill(field_email, prop.getProperty("newAdminEmail"));
        page.selectOption(dropDwn_designation, "4");
        
        this.clickAddAdmin();
        // Get and return confirmation text
        String confirmationMessage = page.innerText(msg_confirm);
        System.out.println("Confirmation: " + confirmationMessage);
        page.click(btn_Ok);
        
        return page;
    }
     

    // Method to generate a random string of given length
    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('A' + random.nextInt(26)); // Generate random uppercase letters
            sb.append(randomChar);
        }
        return sb.toString();
    }
    
    
    public String getCreatedAdmin() {
    	String getAdmin = page.innerText(userTypeColumn1);
    	return getAdmin;
    }
    
    
    
    
}
