package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	//public  org.apache.logging.log4j.Logger logger;
	public Properties p;
	
	@Parameters({"os","browser"})
	@BeforeClass(groups= {"Sanity"})	
	public void setup(String os, String br) throws IOException {
		
		
		//Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		//logger log4j2
		//logger = LogManager.getLogger(this.getClass());
	
		switch(br.toLowerCase()) {
		//case "chrome" : driver = new ChromeDriver();break;
		case "chrome" : driver = new ChromeDriver();break;
		default : System.out.println("invalid browser");return;
		}
		
	    //driver = new EdgeDriver();
		//driver.get("https://demowebshop.tricentis.com/");
	    
	    driver.get(p.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity"})
	public void teardown() {
	    driver.quit();	
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(8);
		return generatedNumber;
		}
	
	public String randomAlphaNumeric() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String generatedNumber = RandomStringUtils.randomNumeric(4);
		return generatedString+"$"+generatedNumber;
		}
	
	public String captureScreen(String tname) {
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		TakesScreenshot takeScreenshot =  (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" +tname +"_" +timestamp+".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
		
	}
}