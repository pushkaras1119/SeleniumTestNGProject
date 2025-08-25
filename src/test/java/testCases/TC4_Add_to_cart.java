package testCases;

import java.time.Duration;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.desktopPage;
import pageObjects.electronicsPage;
import pageObjects.loginPage;
import testBase.BaseClass;

public class TC4_Add_to_cart extends BaseClass {

	@Test
	public void test_addToCartDesktop() {
		
		//logger.info("***** Starting TC4_Add_to_cart *****");
		loginPage lp = new loginPage(driver);
		lp.clickLinkComputerandDesktop();
		
		desktopPage dp = new desktopPage(driver);
		//logger.info("***** Applying filters accordingly *****");
		dp.clickdsksortBy();
		dp.clickdskDisplayBy();
		dp.clickdskViewAs();
		//logger.info("***** selected the product and clicking add to cart *****");
		dp.addCompToCart();
		String prodname = dp.confirmProdDetails();
		if(prodname.equalsIgnoreCase("Build your own expensive computer")) {
			AssertJUnit.assertTrue(true);
		}
		else {
			AssertJUnit.assertTrue(false);
		}
		System.out.println("done 0");
		//add to cart selct other required additonal details
		dp.selectradiobtnfast();
		System.out.println("done 0.1");
		dp.selectramradiobtn();
		dp.selecthddradiobtn();
		dp.selectOfficeSuiteCkbx();
		System.out.println("done 1");
		dp.clickAddtocartbtn();
		System.out.println("done 2");
		//logger.info("***** Finishing TC4_Add_to_cart *****");
	}
	
	@Test
	public void test_addToCartElectronics()  {
		
		//logger.info("***** Starting TC4_Add_to_cart *****");
		loginPage lp = new loginPage(driver);
		lp.clickLinkElectronicsandCellphone();
		
		electronicsPage ep = new electronicsPage(driver);
		ep.clickelcsortBy();
		ep.clickelcDisplayBy();
		ep.clickelcViewAs();
		ep.addcellphonesToCart();
		
		String deviceName = ep.confirmdeviceDetails();;
		if(deviceName.equalsIgnoreCase("Smartphone")) {
			AssertJUnit.assertTrue(true);
		}
		else {
			AssertJUnit.assertTrue(false);
		}
		
		
	}	
	
}