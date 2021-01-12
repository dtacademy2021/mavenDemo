package tests;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DemoTest {
	
	WebDriver driver;
	
	@Test
	public void test1() {
		
		System.out.println("Testing Maven");
		

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
//      
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("tes");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        assertFalse(driver.getTitle().equals("Login"));
//
	}
	
	
//	@AfterMethod (alwaysRun = true)
//	public void teardownMethod() throws IOException {
//		// Based on the test result (pass, fail, skipped) you can put logic to take a screenshot
//		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
//		FileUtils.copyFile(screenshot, new File("screenshots/screenshot"+ System.currentTimeMillis() +".png"));
//		
//		driver.quit();
//	}
	
	
	@Test
	public void test2() {
		List<Integer> list = new ArrayList<>(); // To test Java version compatibility
		
		Faker f = new Faker();
		
		System.out.println(f.internet().emailAddress());
		
	}
	


}
