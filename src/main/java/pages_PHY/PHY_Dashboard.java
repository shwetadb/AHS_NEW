package pages_PHY;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import pages.LoginProcess;

public class PHY_Dashboard {

	protected Page page;
	
	
	//1. String Locators
	private String btn_userGuide = "//button[normalize-space()='User Guide']";
	private String btn_helpDesk = "//button[normalize-space()='Help Desk']";
//Side Menu
	private String btn_menu = "//span[@class='navbar-toggler-icon']";
	private String btn_homePage = "//div[normalize-space()='Dashboard / Home Page']";
		protected String msg_Welcome = "(//h2[contains(text(),'Welcome to the Elemrex Physician/Specialist Referr')])[1]";
	private String btn_reviewProfile = "//div[normalize-space()='Review Profile']";
		private String heading_reviewProfile = "//b[normalize-space()='Physician Profile']"; 
	private String btn_administrator = "//div[normalize-space()='Administrators']";
		private String heading_administrator = "//h5[normalize-space()='Administrative access list']";
	private String btn_adminActivityReport = "//div[normalize-space()='Admin Activity Report']";
		private String  heading_adminActivityReport = "//div[@class='search-input-area company-lable']";
	private String btn_practiceDocuments = "//div[normalize-space()='Practice Documents']";
		private String heading_practiceDocument = "//div[@class='search-input-area company-lable']";
	private String btn_patientList = "//div[normalize-space()='Patient List + Referral']";
		private String heading_patientList = "//div[@class='search-input-area company-lable']";
	private String btn_coe = "//div[normalize-space()='Center of Excellence']";
		private String heading_coe = "(//div[@class='search-input-area company-lable'])[1]";
	private String btn_emailTransferLogs = "//div[normalize-space()='Email Logs & Transfer Logs']";
		private String heading_emailTransferLogs = "//h5[normalize-space()='Referral Log Expert']";
	private String btn_transferReport = "//div[normalize-space()='Transfer Report']";
		private String heading_transferReport = "//h5[normalize-space()='Transfer Report']";
	private String btn_AiGPT = "//div[normalize-space()='AHS AI GPT']";
		private String heading_AiGPT = "//h5[normalize-space()='AHS AI GPT']";
	private String btn_FAQ = "//div[normalize-space()='FAQ']";
	private String btn_contactUS = "//div[normalize-space()='Contact Us']";
		private String heading_contactUS = "//h5[normalize-space()='Contact Us']";
	private String btn_logOut = "//div[normalize-space()='Log Out']";
	private String btn_ok = "//button[normalize-space()='OK']";
	private String btn_cancel = "//button[normalize-space()='Cancel']";
//Referral Recived
	private String link_referralRecived = "//b[normalize-space()='Referral Received']";
//Referral Sent
	private String link_referralSent = "//b[normalize-space()='Referral Sent']";
		private String heading_referralSent = "//h5[normalize-space()='Referral Log Requesting']";
//Alerts
	private String Alink_expandTab = "//body[1]/app-root[1]/app-doctor-dashboard[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]";
	
	private String Alink_docToDoc = "//span[normalize-space()='Doctor to Doctor Email']";
		private String heading_docToDocLog = "//h5[normalize-space()='Doctor To Doctor Email']";
	private String Alink_patientOpinionReq = "//span[normalize-space()='Patient opinion requests']";
		private String heading_patientOpinionReq = "//h5[normalize-space()='Expert Physician Opinion']";
	private String Alink_referralSent = "//span[normalize-space()='Referral sent']";
	private String Alink_referralRecived = "//span[normalize-space()='Referral Received']";
	private String Alink_patientInvitation = "//span[normalize-space()='Patient Invitation']";
		private String heading_patientInvitation = "//div[@class='search-input-area company-lable col-sm-3']";
	private String Alink_patientDocumentSignedCount = "//span[normalize-space()='Practice Document Signed Count']";
//Analytics
	private String link_analytics = "//b[normalize-space()='Analytics']";
	
	
	
	//2. page constructor:
	public PHY_Dashboard(Page page) {
		this.page = page;
	}

	
	//3. page action/methods:	
/*
 * Side Menu
 */
	public void clickMenu() {
		page.click(btn_menu);
		try {
    	    page.waitForLoadState(LoadState.NETWORKIDLE);
            Thread.sleep(5000); // Wai
			System.out.println("Menu Clicked");
		}catch (InterruptedException e) {
            e.printStackTrace();
		}
	}
	
	public Page goToReviewProfile() {
		page.click(btn_menu);
		page.click(btn_reviewProfile);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
		
		public String getReviewProfileHeading() {
			page.waitForSelector(heading_reviewProfile, new Page.WaitForSelectorOptions().setTimeout(9000)); // Wait for visibility
		     return page.innerText(heading_reviewProfile);
		}

	
	public Page goToAdministrator() {
		page.click(btn_menu);
		page.click(btn_administrator);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
	
		public String getAdministratorHeading() {
			page.waitForSelector(heading_administrator, new Page.WaitForSelectorOptions().setTimeout(9000)); // Wait for visibility
		     return page.innerText(heading_administrator);
		}
	
	public Page goToAdminActivityReport() {
		page.click(btn_menu);
		page.click(btn_adminActivityReport);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
		
		public String getAdminActivityReportHeading() {
			page.waitForSelector(heading_adminActivityReport, new Page.WaitForSelectorOptions().setTimeout(9000)); // Wait for visibility
		     return page.innerText(heading_adminActivityReport);
		}

	
	public Page goToPracticeDocument() {
		page.click(btn_menu);
		page.click(btn_practiceDocuments);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
	
		public String getPracticeDocumentHeading() {
			page.waitForSelector(heading_practiceDocument, new Page.WaitForSelectorOptions().setTimeout(9000)); // Wait for visibility
		     return page.innerText(heading_practiceDocument);
		}

	public Page goToPatientList() {
		page.click(btn_menu);
		page.click(btn_patientList);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
	
		public String getPatientListHeading() {
			page.waitForSelector(heading_patientList, new Page.WaitForSelectorOptions().setTimeout(9000)); // Wait for visibility
		     return page.innerText(heading_patientList);
		}

	
	public Page goToCOE() {
		page.click(btn_menu);
		page.click(btn_coe);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
	
		public String getCOEHeading() {
			page.waitForSelector(heading_coe, new Page.WaitForSelectorOptions().setTimeout(9000)); // Wait for visibility
		     return page.innerText(heading_coe);
		}

	
	public Page goToEmailTransferLogs() {
		page.click(btn_menu);
		page.click(btn_emailTransferLogs);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
	
		public String getEmailTransferLogsHeading() {
			page.waitForSelector(heading_emailTransferLogs, new Page.WaitForSelectorOptions().setTimeout(9000)); // Wait for visibility
		     return page.innerText(heading_emailTransferLogs);
		}

	
	public Page goToTransferReport() {
		page.click(btn_menu);
		page.click(btn_transferReport);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
	
		public String getTransferReportHeading() {
			page.waitForSelector(heading_transferReport, new Page.WaitForSelectorOptions().setTimeout(9000)); // Wait for visibility
		     return page.innerText(heading_transferReport);
		}

	public Page goToAIGPT() {
		page.click(btn_menu);
		page.click(btn_AiGPT);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
	
		public String getAIGPTHeading() {
			page.waitForSelector(heading_AiGPT, new Page.WaitForSelectorOptions().setTimeout(9000)); // Wait for visibility
		     return page.innerText(heading_AiGPT);
		}

	
	public Page goToHomePage() {
		page.click(btn_menu);
		page.click(btn_homePage);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
	
		public String getHomePageHeading() {
			page.waitForSelector(msg_Welcome, new Page.WaitForSelectorOptions().setTimeout(90000)); // Wait for visibility
		    return page.innerText(msg_Welcome);
		}

	
		
	public Page clickReferralRecived() {
		page.click(link_referralRecived);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
	
	public Page clickReferralSent() {
		page.click(link_referralSent);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
	
		public String getReferralSentHeading() {
			page.waitForSelector(heading_referralSent, new Page.WaitForSelectorOptions().setTimeout(90000)); // Wait for visibility
		    return page.innerText(heading_referralSent);
		}
	
	public Page clickDocToDocLog() {
		page.click(Alink_docToDoc);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
	
		public String getDocToDocLogHeading() {
			page.waitForSelector(heading_docToDocLog, new Page.WaitForSelectorOptions().setTimeout(90000)); // Wait for visibility
		    return page.innerText(heading_docToDocLog);
		}
	
		
	public Page clickPatientOpinionReq() {
		page.click(Alink_patientOpinionReq);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
		
			public String getPatientOpinionReqHeading() {
				page.waitForSelector(heading_patientOpinionReq, new Page.WaitForSelectorOptions().setTimeout(90000)); // Wait for visibility
			    return page.innerText(heading_patientOpinionReq);
			}
	
	public Page goToContactUs() {
		page.click(btn_menu);
		page.click(btn_contactUS);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
		
			public String getContactUSHeading() {
				page.waitForSelector(heading_contactUS, new Page.WaitForSelectorOptions().setTimeout(90000)); // Wait for visibility
				return page.innerText(heading_contactUS);
			}
			
	public Page clickReferralSentAlink() {
		page.click(Alink_referralSent);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
			
			
	public Page clickAReferralRecived() {
		page.click(Alink_referralRecived);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
					
			
	public Page clickPatientInvitation() {
		page.click(Alink_patientInvitation);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}
					
			public String getPatientInvitationHeading() {
				page.waitForSelector(heading_patientInvitation, new Page.WaitForSelectorOptions().setTimeout(90000)); // Wait for visibility
				return page.innerText(heading_patientInvitation);
			}
	
	
	public Page clickPracticeDocSigned() {
		page.click(Alink_patientDocumentSignedCount);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page;
	}

			
//	public Page goToFAQ() {
//		page.click(btn_menu);
//		page.click(btn_FAQ);
//		page.waitForLoadState(LoadState.NETWORKIDLE);
//		page.close();
//		return page;
//	}
	
	public Page goToFAQ() throws InterruptedException {
	    page.click(btn_menu);
//	    page.click(btn_FAQ);

	    // Wait for a new tab to open after clicking the FAQ button
	    Page newTab = page.context().waitForPage(() -> {
	        page.click(btn_FAQ);
	    });

	    // Wait for the new tab to fully load
	    newTab.waitForLoadState(LoadState.NETWORKIDLE);
	    System.out.println("FAQ page loaded successfully.");
	    Thread.sleep(2000);
	    // Close the new tab instead of closing the main page
	    newTab.close();
	    System.out.println("FAQ page closed successfully.");

	    // Ensure focus returns to the original page
	    page.bringToFront();
	    page.waitForLoadState(LoadState.NETWORKIDLE);
	    page.click(btn_menu);

	    return page; // Return the main page, which remains open
	}

	
	public Page clickLogout() {
		page.click(btn_menu);
		page.click(btn_logOut);
		page.waitForLoadState();
		page.click(btn_ok);
		return page;
	}
	
}
