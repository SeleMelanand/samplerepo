package edu.learning.SeleniumPractise;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class DiffernetWebElements extends BrowserLaunch {
	static ExtentSparkReporter htmlreporter;
	static ExtentReports report;
	static ExtentTest test;
	
	protected static Logger log = LogManager.getLogger();
	
	@BeforeClass
	public void startReport() {
		htmlreporter= new ExtentSparkReporter("./executionResults/testResults.html");
		report = new ExtentReports();
		report.attachReporter(htmlreporter);
			
		report.setSystemInfo("Project Name", "Testing CRM Project");
		report.setSystemInfo("Tester Name", "Test001");
		report.setSystemInfo("Module Name", "CRM Sales module");

		
	}
		
	@BeforeMethod
	public void gotoUrl() {
		launchurl("http://leafground.com/");

	}

	@Test
	public void workOnEditElements() throws  InterruptedException {
		
		driver.findElementByXPath("//img[@alt='Edit / Text Fields']").click();
		driver.findElementById("email").sendKeys("email@gemail.com");

		driver.findElementByXPath("//input[@value='Append ']").sendKeys("newValue",Keys.TAB);
		
		WebElement abc = driver.findElementById("email");
		
		String textvalue = driver.findElementByXPath("//label[text()='Get default text entered']/..//input").getAttribute("value");
		log.info("retrieved text value :: "+ textvalue);
		
		log.warn("retrieved text value :: "+ textvalue);

		System.out.println("prit statmenent :: "+textvalue);
		
		Thread.sleep(3000);
			
		
		driver.findElementByXPath("//label[text()='Clear the text']/..//input").clear();
		
		String fieldStatus = driver.findElementByXPath("//label[text()='Confirm that edit field is disabled']/..//input").getAttribute("disabled");
		System.out.println(fieldStatus);

		test = report.createTest("editbutton");

		test.log(Status.PASS,"Edit Button "+test.addScreenCaptureFromPath(captureScreenshot()));
	}
	
	@Test
	public void workonHyperLInk() throws InterruptedException, IOException {
		test = report.createTest("Linkbutton");

		driver.findElementByXPath("//img[@alt='Link']").click();
		Thread.sleep(3000);

		String title = driver.getTitle();
		log.info(title);
		
		if(title.contains("Interact with HyperLinks")) {
			test.addScreenCaptureFromPath(captureScreenshot());
			test.log(Status.PASS,"Hyper Link :: ");

		}else {
			test.addScreenCaptureFromPath(captureScreenshot());
			test.log(Status.PASS,"Hyper Link :: " );

		}
	}
	
	
	@Test
	public void workingonFrames() throws InterruptedException {
		
		test = report.createTest("On Frames");
		
		driver.findElementByXPath("//img[@alt='Frame']").click();
		
		driver.switchTo().frame(0);

		driver.findElementById("Click").click();
		
		Thread.sleep(2000);
		
		String textVal = driver.findElementById("Click").getText();
		System.out.println("Looger added successfully :::"+textVal);
		log.info("Looger added successfully :::"+textVal);
		
		log.error("Looger added successfully :::"+textVal);

		log.debug("Looger added successfully :::"+textVal);

		
	}
	
	
	@Test
	public void workingonAlerts() throws InterruptedException {
		
		test = report.createTest("On Frames");
		
		driver.findElementByXPath("//img[@alt='Alert']").click();
		
		
		driver.findElementByXPath("//button[text()='Alert Box']").click();
		
		Alert alert = driver.switchTo().alert();
		
		Thread.sleep(3000);
		
		String val = alert.getText();
		
		log.info(val);
		
		alert.accept();
		
		
		
		
	}
	
	
	public String captureScreenshot() {
		//Taking screenshot 
				File source = driver.getScreenshotAs(OutputType.FILE);
				File destination2 = new File("./snaps/snap"+System.currentTimeMillis()+".jpg");
				String dest = destination2.getAbsolutePath();
				try {
					FileUtils.copyFile(source, destination2);
				} catch (IOException e) {
					log.error("Exception occured :: "+e);
				}
				return dest;
	}
	
	@AfterTest
	public void endReport(){
		report.flush();
    }

}
