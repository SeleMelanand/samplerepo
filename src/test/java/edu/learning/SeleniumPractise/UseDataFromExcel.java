package edu.learning.SeleniumPractise;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UseDataFromExcel {
	public String excelFileName = "./testdata/sampleTestdata.xlsx" ;
	
	
	@DataProvider(name="exceldata123")
	public String[][] sendData() throws IOException {
		return ReadDataFromExcel.excelRead(excelFileName);
	}
	
	@Test(dataProvider="exceldata123")
	public void printTestdata(String un, String pwd) {
		
		//System.out.println(un +":"+pwd+"::"+fname+":::"+lname);
		
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		
		driver.findElementById("username").sendKeys(un);
		driver.findElementById("password").sendKeys(pwd);
		driver.findElementById("Isolation Ward").click();
		driver.findElementById("loginButton").click();
		
		
		
		
	
		
	}
	

}
