package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.loginPage;
import testBase.BaseClass;
import utilities.Dataprviders;
/*
data is valid--> login success-->test passed-->logout
data is valid-->login fail-->test failed

data is invalid-->login success-->test fail-->logout
data is invalid-->login fail-->test passed
*/
public class TC3_LoginDDTTest extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass = Dataprviders.class, groups = "Regression")
	//dataProviderClass = Dataprviders.class--getting dataprovider from different class and import it
	public void verify_LoginDDTTest(String email, String password, String expres) throws InterruptedException {

		
	//logger.info("***** Starting of TC3_LoginDDTTest*");
	try {	
	
		//login
	HomePage hp = new HomePage(driver);
	
	//logger.info("***** Clicked on login link *****");
	hp.clickOnLoginlink();
	
	loginPage lp = new loginPage(driver);
	
	//logger.info("***** Customer logins with valid email and password *****");
	
	lp.setEmail(email);
	lp.setPassword(password);
	lp.clickLogin();
	
	//logger.info("***** validate my account text visible after logging in *****");
	
	boolean myaccounttxt = lp.isconfrmWelcometoStorevisible();
	//Assert.assertTrue(myaccounttxt);
	
	/*
	data is valid--> login success-->test passed-->logout
	data is valid-->login fail-->test failed

	data is invalid-->login success-->test fail-->logout
	data is invalid-->login fail-->test passed
	*/
	
	if(expres.equalsIgnoreCase("Valid")) {
		if(myaccounttxt==true) 
		{
			lp.clickLogoutBtn();
			System.out.println("test case passed-->data is valid--> login success-->test passed-->logout");
			AssertJUnit.assertTrue(true);
	   }
		else {
			System.out.println("test case failed--> data is valid-->login fail-->test failed");
			AssertJUnit.assertTrue(false);
			
		}
	}
	if(expres.equalsIgnoreCase("inValid")) {
		if(myaccounttxt==true)
		{
			lp.clickLogoutBtn();
			System.out.println("test case passed data is invalid-->login fail-->test passed");
			AssertJUnit.assertTrue(false);
	   }
		else {
			
			System.out.println("test case failed not executed-->data is invalid-->login success-->test fail-->logout");
			AssertJUnit.assertTrue(true);
		}
	}
	}
	catch(Exception e){
		AssertJUnit.fail();
	}
	Thread.sleep(3000);
	//logger.info("***** finished of TC3_LoginDDTTest*");
	
	}
}