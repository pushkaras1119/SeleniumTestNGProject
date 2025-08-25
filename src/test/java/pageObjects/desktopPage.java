package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class desktopPage extends BasePage {

	public desktopPage(WebDriver driver) {
		
		super(driver);
	}

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
	//add to cart
	//select sort by Name: A to Z
	@FindBy(xpath="//select[@id='products-orderby']//option[2]")
	WebElement dsksortBy;
	
	//display 12 per page
	@FindBy(xpath="//select[@id='products-pagesize']//option[3]")
	WebElement dskDisplayBy;
	
	@FindBy(xpath="//select[@id='products-viewmode']//option[2]")
	WebElement dskViewAs;
	
	@FindBy(xpath="(//input[@type='button'])[4]")
	WebElement addComputerToCart;
	
	@FindBy(xpath="//a[contains(text(),'Build your own expensive computer')]")
	WebElement checkCompName;
	
	@FindBy(xpath= "//input[@type='radio' and @id='product_attribute_74_5_26_82']")
	WebElement radiobtnfast;
	
	@FindBy(xpath="//input[@type='radio' and @id='product_attribute_74_6_27_85']")
	WebElement radiobtn8gbRAM;
	
	@FindBy(xpath="//input[@type='radio' and @id='product_attribute_74_3_28_87']")
	WebElement radiobtnhdd400GB;
	
	@FindBy(xpath="//input[@type='checkbox' and @id='product_attribute_74_8_29_89']")
	WebElement chkboxsoftwareOfficeSuite;
	
	@FindBy(xpath="//input[@type='button' and @id='add-to-cart-button-74']")
	WebElement btnaddtocart;
	
	public void clickdsksortBy() {
		dsksortBy.click();
	}
	public void clickdskDisplayBy() {
		dskDisplayBy.click();
	}
	public void clickdskViewAs() {
		dskViewAs.click();
	}
	public void addCompToCart() {
		addComputerToCart.click();
	}
	public String confirmProdDetails() {
		try {
			return (checkCompName.getText());
			}
			catch(Exception e){
				return (e.getMessage());
			}
	}
	
	public void selectradiobtnfast() {
		
		//wait for Electronics link
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(radiobtnfast));
		wait.until(ExpectedConditions.elementToBeClickable(radiobtnfast));
		
	}
	
	public void selectramradiobtn() {
		   // wait.until(ExpectedConditions.visibilityOfElementLocated(radiobtn8gbRAM));
			wait.until(ExpectedConditions.elementToBeClickable(radiobtn8gbRAM));
			
	}
	
	public void selecthddradiobtn() {
		wait.until(ExpectedConditions.elementToBeClickable(radiobtnhdd400GB));
		
	}
	
	public void selectOfficeSuiteCkbx() {
		wait.until(ExpectedConditions.elementToBeClickable(chkboxsoftwareOfficeSuite));
		
	}
	public void clickAddtocartbtn() {
		wait.until(ExpectedConditions.elementToBeClickable(btnaddtocart));
		
	}
	
}