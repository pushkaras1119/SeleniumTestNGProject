package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class electronicsPage extends BasePage {

	public electronicsPage(WebDriver driver) {
		
		super(driver);
	}

	
    //Locators
	//add to cart
		//select sort by Name: A to Z
		@FindBy(xpath="//select[@id='products-orderby']//option[2]")
		WebElement ectsortBy;
		
		//display 12 per page
		@FindBy(xpath="//select[@id='products-pagesize']//option[3]")
		WebElement ectDisplayBy;
		
		@FindBy(xpath="//select[@id='products-viewmode']//option[2]")
		WebElement ectViewAs;
		
		@FindBy(xpath="(//input[@value='Add to cart'])[1]")
		WebElement addCellphoneToCart;
		
		@FindBy(xpath="//a[contains(text(),'Smartphone')]")
		WebElement checkDeviceName;
		
		
		public void clickelcsortBy() {
			ectsortBy.click();
		}
		public void clickelcDisplayBy() {
			ectDisplayBy.click();
		}
		public void clickelcViewAs() {
			ectViewAs.click();
		}
		public void addcellphonesToCart() {
			addCellphoneToCart.click();
		}
		public String confirmdeviceDetails() {
			try {
				return (checkDeviceName.getText());
				}
				catch(Exception e){
					return (e.getMessage());
				}
		}
}