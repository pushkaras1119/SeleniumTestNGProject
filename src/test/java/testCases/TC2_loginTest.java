package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.loginPage;
import testBase.BaseClass;

public class TC2_loginTest extends BaseClass {

	@Test(groups= "Sanity")
	public void verify_LoginTest() {
	
	//BaseClass.logger.info("***** Starting of TC2_loginTest *****");
	
			HomePage hp = new HomePage(driver);
			
			//logger.info("***** Clicked on login link *****");
			
			hp.clickOnLoginlink();
			
			loginPage lp = new loginPage(driver);
			
			//logger.info("***** Customer logins with valid email and password *****");
			
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			//logger.info("***** validate my account text visible after logging in *****");
			
			boolean myaccounttxt = lp.isconfrmWelcometoStorevisible();
			AssertJUnit.assertTrue(myaccounttxt);
			
			//logger.info("***** Clicked on logout link *****");
			//lp.clickLogoutBtn();
	
	
	//logger.info("***** Finished TC2_loginTest *****");
	}
}