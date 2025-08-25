package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends BasePage {

	public loginPage(WebDriver driver) {
			
			super(driver);
		}
	
	//Locator
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Password")
	WebElement txtpswd;
	
	@FindBy(xpath="//input[@type='submit' and @value='Log in']")
	WebElement btnlogin;
	
	@FindBy(xpath="//h2[contains(text(),'Welcome to our store')]")
	WebElement confrmWelcometoStore;
	
	@FindBy(xpath="//a[@href='/logout']")
	WebElement lnkLogout;
	
	//add to cart
	@FindBy(xpath="(//a[@href='/computers'])[1]")
	WebElement lnkComputer;
	//locators for general use
	@FindBy(xpath="(//a[@href='/desktops'])[1]")
	WebElement lnkDesktop;
	
	

	
	//Action
	public void setEmail(String email) {
		txtEmail.sendKeys(email);;
	}
	
	public void setPassword(String pswd) {
		txtpswd.sendKeys(pswd);
	}
	
	public void clickLogin() {
		btnlogin.click();
	}
	
	public boolean isconfrmWelcometoStorevisible() {
		try{
			return confrmWelcometoStore.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
		
	}
	
	public void clickLogoutBtn() {
		lnkLogout.click();
	}
	
	public void clickLinkComputerandDesktop() {
		Actions act = new Actions(driver);
		act.moveToElement(lnkComputer).moveToElement(lnkDesktop).click().build().perform();
	}
	//by locator for explicit wait
    By lnkElectronics =By.xpath("(//a[@href='/electronics'])[1]");
	
    By lnkCellphones =By.xpath("(//a[@href='/cell-phones'])[1]");
	
	public void clickLinkElectronicsandCellphone() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		//wait for Electronics link
		WebElement electronicsele = wait.until(ExpectedConditions.visibilityOfElementLocated(lnkElectronics));
		wait.until(ExpectedConditions.elementToBeClickable(electronicsele));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(electronicsele).perform();
		//wait for cellphone link
		WebElement cellphoneele = wait.until(ExpectedConditions.visibilityOfElementLocated((By) lnkCellphones));
		wait.until(ExpectedConditions.elementToBeClickable(cellphoneele));
		
		act.moveToElement(cellphoneele).click().build().perform();
	}
	
	
}