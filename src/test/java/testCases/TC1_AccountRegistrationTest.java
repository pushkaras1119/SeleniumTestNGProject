package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC1_AccountRegistrationTest extends BaseClass {

	
	@Test(groups= {"Sanity","Regression"})
	public void verify_account_registration() {
		
		//logger.info("***** Starting TC1_AccountRegistrationTest *****");
		try {
		HomePage hp = new HomePage(driver);
		
		//logger.info("***** Clicked on registration link *****");
		
		hp.clickOnRegisterlink();
		
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		
		//logger.info("***** Providing customer details *****");
		
		arp.setGender();
		//arp.setFirstname(randomString());
		arp.setFirstname("Tester");
		//arp.setLastname(randomString());
		arp.setLastname("1234");
		arp.setEmail("practice12345@gmail.com");
		//arp.setEmail(randomString()+"@gmail.com");
		arp.setPassword("abcd@1234");
		arp.setConfirmPassword("abcd@1234");
		arp.clkRegister();
		arp.getConfrmmsg();

		//logger.info("***** Validating confirmation message of registration *****");
		
		String ConfirmationMessage = arp.getConfrmmsg();
		if(ConfirmationMessage.equals("Your registration completed")) {
			AssertJUnit.assertTrue(true);
		}
		else {
			//logger.error("Test Failed");
			//logger.debug("Debug logs");
			AssertJUnit.assertTrue(false);
		}
		//Assert.assertEquals(ConfirmationMessage, "Your registration completedd");
		
	}
	catch(Exception e) {
		
		AssertJUnit.fail();
	}
		//logger.info("***** Finished TC1_AccountRegistrationTest *****");
		
	}
	
	
	
}