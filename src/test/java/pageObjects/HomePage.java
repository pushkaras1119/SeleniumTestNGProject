package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


	
	public HomePage(WebDriver driver) {
		
		super(driver);
	}
	
	//Locator
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[@href='/login']")
	WebElement lnkLogin;
	
	//Action methods
	
	public void clickOnRegisterlink() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		lnkRegister.click();
	}
	
	public void clickOnLoginlink() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		lnkLogin.click();
	}
}