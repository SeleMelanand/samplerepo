package edu.learning.SeleniumPractise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {
	RemoteWebDriver driver;
	
	public void launchurl(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	//@AfterMethod
	public void browsercloser() {
		driver.close();
	}
}
