package actions;

import pages.BracAdminPage;
import pages.BracHomePage;
import pages.BracInformationPage;
import pages.BracLoginPage;


public class BracAdminActions {
	
	public BracHomePage userEnterEmailAndPasswordForLogin(BracLoginPage signInPage, String email, String password) throws InterruptedException{
		return signInPage.adminCanLogin(email, password);
	}
	
	public BracAdminPage adminClickOnAdminAndSwitchTab(BracHomePage homepage) throws InterruptedException {
		
		return homepage.clickOnAdminAndSwitchTheTab();
	}
	
	public void adminCanClickOnStakeHolderManagement(BracAdminPage adminPage) throws InterruptedException {
		adminPage.clickOnStakeholderManegement();
	}
	
	public BracInformationPage adminCanClickOnStakeHolderInformation (BracAdminPage adminPage) {
		
		return adminPage.clickOnStakeHolderInformation();
	}
	
	public void adminCanCreateStakeHolder(BracInformationPage infoPage, String name) throws InterruptedException {
		
		infoPage.createAnStakeHolder(name);
	}
	
	public void adminCanSearchStakeholder(BracInformationPage infoPage, String name) {
		infoPage.searchStakeholder(name);
	}

}
