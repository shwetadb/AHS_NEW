	package pages_PHY;
	
	import java.util.Properties;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
	import com.microsoft.playwright.Page;

import constants.AppConstants;
	
	public class PHY_Administration {
		private Page page;
		private Properties prop;
	    public PHY_Invite_Physician invitePhy;

	
		
		// Locators
		private String btn_newPhysician = "//a[normalize-space()='New Physician']";
		private String btn_newAdmin = "//a[normalize-space()='New Admin']";
		private String btn_PhyHomePage = "//a[normalize-space()='Physician Home Page']";
		private String btn_invitationLog = "//a[normalize-space()='Invitation Log']";
		private String dropDwn_userRole = "//select[@name='userRoleVal']";
		private String btn_reset = "//a[normalize-space()='Reset']";
		private String icon_email = "//td[normalize-space()='STQFL@yopmail.com']//img";
		private String field_search = "//input[@type='search']";
		private String icon_coe = "//button[@class='btn btn-sm btn-success']";
		private String icon_edit = "//button[@class='btn btn-sm btn-warning']";
		private String icon_onBehalfOf = "//button[@class='btn btn-sm btn-default']";
		private String icon_status = "//span[@aria-label='Basic example']//button[@class='btn btn-sm btn-primary']";
//	    private String userTypeColumn = "//table[@id='DataTables_Table_1']//td[4]";
		
	    private String userTypeColumn = "//table[class='dataTables_wrapper no-footer']//td[4]";
	    private String heading_newPhy = "//div[@class='search-input-area company-lable']";
	    private String heading_newAdmin = "//div[@class='search-input-area company-lable']";
	    private String heading_invitationLog = "//h5[normalize-space()='Invitation Log']";
	    private String btn_cancel = "//a[normalize-space()='Cancel']";
	    private String btn_back = "//a[normalize-space()='Back']";
	    
	    
		
		// Page constructor
	    public PHY_Administration(Page page, Properties prop) {
	        this.page = page;
	        this.prop = prop;
	    }
	    
	    

	    // Method to select "All Admins" from the dropdown and verify "User Type"
	    public boolean verifyAllUsersAreAdmins() {
	        // Select "All Admins" from the dropdown
	        page.selectOption(dropDwn_userRole, "1");
	        page.waitForTimeout(3000);

	        Locator userTypeCells = page.locator(userTypeColumn);
	        int rowCount = userTypeCells.count();
	
	        // Validate all values are "Administrative"
	        boolean allAreAdmins = true;
	        for (int i = 0; i < rowCount; i++) {
	            String userType = userTypeCells.nth(i).textContent().trim();
	            System.out.println("Row " + (i + 1) + " - User Type: " + userType);
	            if (!userType.equalsIgnoreCase("Administrative") && !userType.equalsIgnoreCase("Primary Administrative")) {
	                allAreAdmins = false;
	                break;
	            }
	        }	
	        // Print final result
	        if (allAreAdmins) {
	            System.out.println("✅ Test Passed: All users are 'Administrative'");
	        } else {
	            System.out.println("❌ Test Failed: Some users are not 'Administrative'");
	        }
	        return allAreAdmins;
	    }
	    
	    
	 // Method to select "All Physician" from the dropdown and verify "User Type"
	    public boolean verifyAllUsersArePhysicians() {
	        // Select "All Admins" from the dropdown
	        page.selectOption(dropDwn_userRole, "4");
	        page.waitForTimeout(3000);

	        Locator userTypeCells = page.locator(userTypeColumn);
	        int rowCount = userTypeCells.count();
	
	        // Validate all values are "Administrative"
	        boolean allArePhysicians = true;
	        for (int i = 0; i < rowCount; i++) {
	            String userType = userTypeCells.nth(i).textContent().trim();
	            System.out.println("Row " + (i + 1) + " - User Type: " + userType);
	            if (!userType.equalsIgnoreCase("Physician") && !userType.equalsIgnoreCase("Primary Physician")) {
	                allArePhysicians = false;
	                break;
	            }
	        }
	        if (allArePhysicians) {
	            System.out.println("✅ Test Passed: All users are 'Physician'");
	        } else {
	            System.out.println("❌ Test Failed: Some users are not 'Physician'");
	        }
	        return allArePhysicians;
	    }
	
	    
	    
	    public void clickReset() {     
	        page.click(btn_reset);
	        page.waitForLoadState();

	        // Get the default selected value in dropdown
	        String selectedValue = page.locator(dropDwn_userRole).inputValue();
	        if (selectedValue.equals("0")) { 
	            System.out.println("✅ Test Passed: Displaying All users");
	        } else {
	            System.out.println("❌ Test Failed: Dropdown did not reset correctly");
	        }
	    }

	    
	    
	    public Page clickNewPhysician() {
	    	page.click(btn_newPhysician);
	    	page.waitForLoadState();
	    	System.out.println("clicked: New Phy");
	    	return page;
	    }
	    
	    
	    public void getNewPhysicianHeading() {
	    	String newPhysicianHeading = page.innerText(heading_newPhy);
	    	Assert.assertEquals(newPhysicianHeading, AppConstants.HEADING_INVITE_PHYSICIAN);
	    	invitePhy.clickCancel();
	    	page.waitForLoadState();
	    }
	    
	    public Page clickNewAdmin() {
	    	page.click(btn_newAdmin);
	    	page.waitForLoadState();
	    	System.out.println("clicked: New Admin");
	    	return page;
	    }
	    
	    public void getNewAdminHeading() {
	    	String newAdminHeading = page.innerText(heading_newPhy);
	    	Assert.assertEquals(newAdminHeading, AppConstants.HEADING_ADD_ADMIN);
	    	invitePhy.clickCancel();
	    	page.waitForLoadState();
	    }
	    
	    public Page clickInvitationLog() {
	    	page.click(btn_invitationLog);
	    	page.waitForLoadState();
	    	System.out.println("clicked invite log");
	    	return page;
	    }
	    
	    public void getInvitationLogHeading() {
	    	String invitationLogHeading = page.innerText(heading_invitationLog);
	    	System.out.println(invitationLogHeading);
	    	Assert.assertEquals(invitationLogHeading, AppConstants.HEADING_INVITATION_LOG);

	    	invitePhy.clickCancel();
	    	page.waitForLoadState();
	    }
	    
	    
	    public Page clickPhyHomeBtn() {
	    	page.click(btn_PhyHomePage);
	    	page.waitForLoadState();
	    	System.out.println("clicked: Home Page");
	    	return page;
	    }
	    
	    
	    
	    
	}
	
	
