package tests;


import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class DemoTest {
	
	WebDriver driver;
	
	@Test
	public void test1() {
		
		System.out.println("Testing Maven");
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
//      
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("tes");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        assertTrue(driver.getTitle().equals("Login"));
//
	}
	
	
	@AfterMethod (alwaysRun = true)
	public void teardownMethod() throws IOException {
		// Based on the test result (pass, fail, skipped) you can put logic to take a screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		FileUtils.copyFile(screenshot, new File("screenshots/screenshot"+ System.currentTimeMillis() +".png"));
		
		driver.quit();
	}


}
