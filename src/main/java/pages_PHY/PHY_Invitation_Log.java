package pages_PHY;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class PHY_Invitation_Log {
	private Page page;
	private Properties prop;
	
	//locators
	private String dropDwn_userRole = "//select[@name='userRoleVal']";
	private String btn_reset = "//a[normalize-space()='Reset']";
	private String field_search = "//input[@type='search']";
    private String userTypeColumn = "//table[class='dataTables_wrapper no-footer']//td[4]";
//    private String userTypePhy = "//table[@id='DataTables_Table_1']//tbody//td[1]";
    private String userTypePhy = "(//table[@id='DataTables_Table_1']//tbody//td[1])[1]";
    private String userTypeAdmin = "(//table[@id='DataTables_Table_1']//tbody//td[1])[1]";
    private String link_Resend = "(//a[contains(text(),'Resend')])";
	private String msg_confirm = "//div[@id='swal2-html-container']";
	private String btn_Ok = "//button[normalize-space()='OK']";

	 
	// Page constructor
    public PHY_Invitation_Log(Page page, Properties prop) {
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
    
    
    // Search for invited Physician
    public void searchInvitePhy() {
        page.fill(field_search, prop.getProperty("newPhyName"));
        page.waitForLoadState(LoadState.LOAD);
        String searchResult = page.innerText(userTypePhy).trim();
        page.waitForSelector(userTypePhy, new Page.WaitForSelectorOptions().setTimeout(5000));
        assertEquals(searchResult, prop.getProperty("newPhyName"), "❌ Test Failed: Invited Physician not found");
        System.out.println("Searched for Phy: " + searchResult);
    }
    
     
    public void clearSearchField() {
    	page.locator(field_search).selectText();
//    	  page.locator(field_search).press("Control+A");
          page.locator(field_search).press("Delete");
          page.waitForLoadState(LoadState.LOAD);
    }

    // Search for invited Admin
    public void searchInviteAdmin() {
        page.fill(field_search, prop.getProperty("newAdminName"));
        page.waitForLoadState(LoadState.LOAD);
        String searchResult = page.innerText(userTypeAdmin).trim();
        page.waitForSelector(userTypeAdmin, new Page.WaitForSelectorOptions().setTimeout(5000));
        assertEquals(searchResult, prop.getProperty("newAdminName"), "❌ Test Failed: Invited Admin not found");
        System.out.println("Searched for Admin: " + searchResult);
        System.out.println("Searched for Admin: ");
    }
    
    
    public void clickResend() {
        page.waitForSelector(link_Resend, new Page.WaitForSelectorOptions().setTimeout(5000));
        page.click(link_Resend);
        
    }

    
    public Page clickConfirm() throws InterruptedException {
    	page.waitForSelector(msg_confirm, new Page.WaitForSelectorOptions().setTimeout(5000));

        String confirmationMessage = page.innerText(msg_confirm);
        System.out.println("Confirmation: " + confirmationMessage);

        page.waitForSelector(btn_Ok, new Page.WaitForSelectorOptions().setTimeout(5000));
        page.click(btn_Ok);
        System.out.println("clicked ok btn");

        page.waitForLoadState(LoadState.LOAD);
        Thread.sleep(1000);
        return page;
    }
    
  

    
}
