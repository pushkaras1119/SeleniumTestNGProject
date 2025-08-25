package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext) {
		
		//time stamp with date
		/*SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");//date format
		Date dt = new Date();
		String currentdatetimestamp = df.format(dt);//return the date in string format
		*/
		//or
		//time stamp with date
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		
		repName = "Test-Report-"+timestamp+".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName);//specify location of the reports folder
		
		sparkReporter.config().setReportName("opencart functional testing");//name of the report
		sparkReporter.config().setDocumentTitle("opencart automation report");//title of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new  ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));//fetching details dynamically
		extent.setSystemInfo("Environment", "QA");
		
		String os = testContext.getCurrentXmlTest().getParameter("os");//fetching details from xml file as we have given parameter
		extent.setSystemInfo("Operating System", os);
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");//fetching details from xml file as we have given parameter
		extent.setSystemInfo("Browser", browser);
		
		//if running grouping.xml file-->we wud have included feww grps 
		//it will return those groups name
		
		List<String> includedgroups = testContext.getCurrentXmlTest().getIncludedGroups();
			if(!includedgroups.isEmpty()) {
				extent.setSystemInfo("Groups", includedgroups.toString());
			}
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());//this will get the tc class name and also method name
		test.assignCategory(result.getMethod().getGroups());//to display groups in reports
		test.log(Status.PASS, result.getName()+"got successfully executed");
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());//this will get the tc class name and also method name
		test.assignCategory(result.getMethod().getGroups());//to display groups in reports
		test.log(Status.FAIL, result.getName()+"got failed!");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {//if file path not found correctly then try catch block gives exception
			
			String imgPath = new BaseClass().captureScreen(result.getName());//creating baseclass obj and calling method capturescreenshot
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(Exception e2) {
			
			e2.printStackTrace();
		}
	
	}
	
	public void onTestSkipped(ITestResult result) {
		
		test = extent.createTest(result.getTestClass().getName());//this will get the tc class name and also method name
		test.assignCategory(result.getMethod().getGroups());//to display groups in reports
		test.log(Status.SKIP, result.getName()+"got Skipped!");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
		
		String PathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport = new File(PathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());//opens report on browser automatically
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * //if need to send report automatically to team after execution try { URL url
		 * = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
		 * 
		 * //create email message ImageHtmlEmail email = new ImageHtmlEmail();
		 * email.setDataSourceResolver(new DataSourceUrlResolver(url));
		 * email.setHostName("stmp.googleemail.com"); email.setSmtpPort(465);
		 * email.setAuthenticator(new DefaultAuthenticator("ganeshanp555@gmail.com",
		 * "password")); email.setSSLOnConnect(true);
		 * email.setFrom("ganeshanp555@gmail.com");//sender
		 * email.setSubject("Test Results");
		 * email.setMsg("Please find attached report");
		 * email.addTo("chandhana712@gmail.com");//reciever email.attach(url,
		 * "extent report", "please check report..."); email.send();//send the email }
		 * catch(Exception e){ e.printStackTrace(); }
		 */
	}
	
}