package pages;

import java.nio.file.Paths;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

import factory.PlaywrightFactory;

public class LoginProcess {

	protected Page page;

	
	
	//1. String Locators --- Login Page
	private String field_email = "//input[@id='email']";
	private String field_password = "//input[@id='password']";
	private String msg_InvalidCred = "//div[normalize-space()='Invalid username or password']";
	private String btn_visibleEye = "//i[@id='pass-reg']";
	private String btn_login = "//button[normalize-space()='Login']";
	private String btn_newPatientSignUp = "//a[normalize-space()='New Patient? Signup Here']";
	private String btn_newPhysicianSignUp = "//a[normalize-space()='New Physician? Signup Here']";
	private String checkBox = "//*[@id=\"recaptcha-anchor\"]";
	/*
	 * OTP Page
	 */
	private String field_otp = "//input[@id='otp']";
	private String btn_verify = "//button[normalize-space()='Verify']";
	/*
	 * Home Page
	 */
	private String logo_elemrex = "//body/app-root/app-doctor-dashboard/app-header/nav/div/div[2]";
	protected String msg_Welcome = "(//h2[contains(text(),'Welcome to the Elemrex Physician/Specialist Referr')])[1]";
	
	
	//2. page constructor:
	public LoginProcess(Page page) {
		this.page = page;
	}

	
	//3. page action/methods:
	public void openApp(String appUrl) {
		  System.out.println("Navigating to URL: " + appUrl);
		  page.navigate(appUrl);
		  page.waitForLoadState(LoadState.LOAD);
		}
	
	
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public String getHomePageURL() {
		String url = page.url();
		System.out.println("page url : " + url);
		return url;
	}
	
	
	
	/*
	 * Login
	 */
	
	public Page doLogin(String appUserName, String appPassword, String appOtp) {
	    System.out.println("App credentials: " + appUserName + " → " + appPassword);

	    // Fill in the email and password fields
	    page.locator(field_email).fill(appUserName);
	    page.locator(field_password).fill(appPassword);
	    page.click(btn_visibleEye);

	      // Captcha (Manual Intervention Required)
//	      System.out.println("Solve the Captcha manually...");
//	      page.waitForTimeout(150000); // Wait for manual captcha input
	      
	      // Click Login
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

        System.out.println("App OTP: " + appOtp);

        page.waitForSelector(field_otp);
        page.locator(field_otp).fill(appOtp);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Verify")).click();
        page.waitForLoadState(LoadState.NETWORKIDLE, new Page.WaitForLoadStateOptions().setTimeout(60000));
        
//        PlaywrightFactory.getBrowserContext().storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("ahsAppLogin.json")));
        return page;
    }

	
	public Page doInvalidLogin(String appUserName, String appPassword) {
	    System.out.println("App credentials: " + appUserName + " → " + appPassword);

	    // Fill in the email and password fields
	    page.locator(field_email).fill(appUserName);
	    page.locator(field_password).fill(appPassword);
	    page.click(btn_visibleEye);

	      // Captcha (Manual Intervention Required)
//	      System.out.println("Solve the Captcha manually...");
//	      page.waitForTimeout(150000); // Wait for manual captcha input
	      
	      // Click Login
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

        return page;
    }
	
	
	/*
	 * Home Page
	 */
	public String getElemrexLogo() {
		page.waitForSelector(logo_elemrex, new Page.WaitForSelectorOptions().setTimeout(10000));
		
		return page.innerText(logo_elemrex);
						
	}
	
	public String gePHYtWelcomMsg() {
		page.waitForSelector(msg_Welcome, new Page.WaitForSelectorOptions().setTimeout(90000)); // Wait for visibility
			System.out.println(page.innerText(msg_Welcome));
	     return page.innerText(msg_Welcome);
		
	}
	
	
	public String geInvalidCredentialMsg() {
		page.waitForSelector(msg_InvalidCred, new Page.WaitForSelectorOptions().setTimeout(90000)); // Wait for visibility
	     return page.innerText(msg_InvalidCred);
		
	}

	
	public String alert() throws InterruptedException {
		
		final String[] alertMessage = {""}; // Using array to modify inside lambda

	    page.onDialog(dialog -> {
	        System.out.println("Alert message: " + dialog.message());
	        alertMessage[0] = dialog.message();
	        dialog.accept();
	    });

	    return alertMessage[0]; 
	}


	
	public void acceptAlert() {
	    page.onDialog(dialog -> {
	        System.out.println("Alert message: " + dialog.message());
	        dialog.accept();
	    });
	}




	
}
