package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccountRegistrationPage extends BasePage{

	
	public AccountRegistrationPage(WebDriver driver) {
		
		super(driver);
	}
	
	//Locator
	
	@FindBy(id="gender-female")
	WebElement rbtngender;
	
	@FindBy(id="FirstName")
	WebElement txtFirstName;
	
	@FindBy(id="LastName")
	WebElement txtLastName;
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Password")
	WebElement  txtPassword;
	
	@FindBy(id="ConfirmPassword")
	WebElement txtcnfrmpswd;
	
	@FindBy(xpath="//div[contains(text(),'Your registration completed')]")
	WebElement confrmmsg;
	
	@FindBy(id="register-button")
	WebElement btnregister;
	
	
	//Action Method
	public void setGender() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		rbtngender.click();
	}
	
	public void setFirstname(String fname) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pswd) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		txtPassword.sendKeys(pswd);
	}
	
	public void setConfirmPassword(String cnfrmpswd) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		txtcnfrmpswd.sendKeys(cnfrmpswd);
	}
	
	public void clkRegister() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		btnregister.click();
	}
	
	public String getConfrmmsg() {
		try {
		return (confrmmsg.getText());
		}
		catch(Exception e){
			return (e.getMessage());
		}
		
		
	}
}