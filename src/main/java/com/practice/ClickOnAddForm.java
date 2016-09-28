package com.practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ranosys.constants.AppKiAppConstants;
import com.ranosys.utilities.Utilities;

public class ClickOnAddForm {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "E:\\Jeevan\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(AppKiAppConstants.UAT_APP_KI_APP);
		Utilities.maximizeScreen(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign In")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//input[@id='Users_email'])[2]")).sendKeys("test.ranosys+XB64@gmail.com");
		driver.findElement(By.xpath("(//input[@id='Users_password'])[2]")).sendKeys("password");
		driver.findElement(By.xpath("//button[@onclick='return send()']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='content_step']/div/span")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Send us Email")).click();
		System.out.println("Waiting.......");
		Thread.sleep(20000);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		System.out.println("Switching completed");
		boolean status = driver.findElement(By.xpath(".//*[@id='new_form_pop' and @class='btn btn-success']")).isDisplayed();
		System.out.println("Status--->" + status);
		boolean clickable = driver.findElement(By.xpath(".//*[@id='new_form_pop' and @class='btn btn-success']")).isEnabled();
		if (clickable == true) {
			driver.findElement(By.xpath(".//*[@id='new_form_pop' and @class='btn btn-success']")).click();
		} else {
			WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='new_form_pop' and @class='btn btn-success']")));
			myDynamicElement.click();
		}
		System.out.println("Clicking.....");
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='form_name_1']")).sendKeys("Jeevan");
		driver.findElement(By.xpath(".//*[@id='submit_new_btn']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[1]/div/div/div[4]/span[2]/button[2]")).click();// Single line
		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[1]/div/div/div[4]/span[2]/button[2]")).click();// Single line
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[1]/div/div/div[4]/span[1]/button[2]")).click();// Multi Choice
		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[1]/div/div/div[4]/span[3]/button[1]")).click();// Date Picker
		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[1]/div/div/div[4]/span[2]/button[3]")).click();// Multi-line
		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[1]/div/div/div[4]/span[1]/button[2]")).click();// Check Box
		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[1]/div/div/div[4]/span[3]/button[2]")).click();// Time Picker
		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[1]/div/div/div[4]/span[2]/button[4]")).click();// Dropdown
		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[1]/div/div/div[4]/span[2]/button[1]")).click();// Email
		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[1]/div/div/div[4]/span[3]/button[3]")).click();// File Upload
		System.out.println("Clicking Completed........");

		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// Click on You Tube
		/*boolean YouTube = driver.findElement(By.linkText("YouTube")).isEnabled();
		System.out.println("You Tube Is :" +YouTube);
		driver.findElement(By.linkText("YouTube")).click();*/
		
		int size = driver.findElements(By.tagName("iframe")).size();
		Thread.sleep(20000);
		System.out.println("Size is --------->"+ size);
		driver.switchTo().frame(0);
		//driver.switchTo().frame(0);
		
		System.out.println("Swiching completed");
		//driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		// driver.findElement(By.cssSelector("span.cap2.")).click();
		//boolean SubmitButton = driver.findElement(By.xpath(".//*[@class='submit_button nform_btn boots']")).isEnabled();
		//System.out.println("Submit Button Enabled:" +SubmitButton);
		//driver.findElement(By.xpath(".//*[@class='submit_button nform_btn boots']")).click();
		
		// First Name
		driver.findElements(By.xpath(".//*[@class='field_class' and @type='text']")).get(0).click();
		Thread.sleep(200);
		boolean FirstName = driver.findElement(By.xpath(".//*[@id='cpm1' and @class='ng-pristine ng-valid']")).isEnabled();
		System.out.println("Submit Button Enabled:" +FirstName);
		
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='cpm1' and @class='ng-pristine ng-valid']")).clear();
		driver.findElement(By.xpath(".//*[@id='cpm1' and @class='ng-pristine ng-valid']")).sendKeys("First Name");
		
		
		// Last Name
		Thread.sleep(200);
		int size1 = driver.findElements(By.xpath(".//*[@class='field_class' and @type='text']")).size();
		System.out.println("Size is :" +size1);
		boolean LastName =driver.findElements(By.xpath(".//*[@class='field_class' and @type='text']")).get(1).isEnabled();
		System.out.println("Last Name is Enabled (True/False):" + LastName);
		driver.findElements(By.xpath(".//*[@class='field_class' and @type='text']")).get(1).click();
		System.out.println("Clicked");
		Thread.sleep(2000);
		int size2 = driver.findElements(By.xpath(".//*[@class='ng-valid ng-dirty' and @type='text']")).size();
		System.out.println("Size2 is :" +size2);
		boolean LastName1 =driver.findElement(By.xpath(".//*[@class='ng-valid ng-dirty' and @type='text']")).isEnabled();
		System.out.println("Last Name1 is Enabled (True/False):" + LastName1);
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='cpm2' and @type='text']")).sendKeys("Last Name");
		driver.findElement(By.xpath(".//*[@id='cpm2' and @type='text']")).clear();
		driver.findElement(By.xpath(".//*[@id='cpm2' and @type='text']")).sendKeys("Last Name");
		System.out.println("Last Name Changed....");
		
		// Gender
		Thread.sleep(200);
		int size3 = driver.findElements(By.name("Profession_radio__0___field3")).size();
		System.out.println("Size3 is :" +size3);
		Thread.sleep(10000);
		boolean visible = driver.findElements(By.name("Profession_radio__0___field3")).get(0).isEnabled();
		System.out.println("Is Element Visible:" +visible);
		driver.findElement(By.xpath("//li[4]/div")).click();
		
		
		driver.findElement(By.xpath(".//*[@id='pcpm3' and @type='text']")).clear();
		driver.findElement(By.xpath(".//*[@id='pcpm3' and @type='text']")).sendKeys("Gender");
		
		driver.findElement(By.xpath(".//*[@id='pcps3' and @type='text']")).clear();
		driver.findElement(By.xpath(".//*[@id='pcps3' and @type='text']")).sendKeys("Select Gender");
		
		int size4 = driver.findElements(By.xpath(".//*[@class='del-inp ng-valid ng-dirty' and @type='text']")).size();
		System.out.println("Size4 is:" +size4);
		driver.findElement(By.xpath("//div[@id='collapse3']/div/div[2]/span[2]/input")).clear();
		driver.findElement(By.xpath("//div[@id='collapse3']/div/div[2]/span[2]/input")).sendKeys("Male");
		
		driver.findElement(By.xpath("//div[@id='collapse3']/div/div[2]/span[3]/input")).clear();
		driver.findElement(By.xpath("//div[@id='collapse3']/div/div[2]/span[3]/input")).sendKeys("Female");
		
		driver.findElement(By.xpath("//div[@id='collapse3']/div/div[2]/span[4]/button")).click();
		driver.findElement(By.xpath("//div[@id='collapse3']/div/div[2]/span[4]/button")).click();
		driver.findElement(By.xpath("//div[@id='collapse3']/div/div[2]/span[4]/button")).click();
		
		// Select Date
		Thread.sleep(5000);
		driver.findElement(By.id("date_input_4")).click();
		System.out.println("Select Date.....");
		driver.findElement(By.id("date_input_4")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("pcpm4")).clear();
		driver.findElement(By.id("pcpm4")).sendKeys("DOB");
		driver.findElement(By.id("pcps4")).clear();
		driver.findElement(By.id("pcps4")).sendKeys("Birth Date");
		driver.findElement(By.xpath(".//*[@id='4' and @title='Minimize']")).click();
		
		// Select Text Area
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[2]/textarea")).click();
		System.out.println("Select Text Area.....");
		driver.findElement(By.id("pcpm5")).clear();
		driver.findElement(By.id("pcpm5")).sendKeys("Address");
		driver.findElement(By.id("pcps5")).clear();
		driver.findElement(By.id("pcps5")).sendKeys("Enter Your Complete Address");
		
		// Select Hobbies
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[7]/div")).click();
		System.out.println("Select Hobbies.....");
		driver.findElement(By.id("pcps6")).clear();
		driver.findElement(By.id("pcps6")).sendKeys("Select Your Hobbies");
		driver.findElement(By.xpath("//div[@id='collapse6']/div/div[2]/span[2]/input")).clear();
		driver.findElement(By.xpath("//div[@id='collapse6']/div/div[2]/span[2]/input")).sendKeys("Cricket");
		driver.findElement(By.xpath("//div[@id='collapse6']/div/div[2]/span[3]/input")).clear();
		driver.findElement(By.xpath("//div[@id='collapse6']/div/div[2]/span[3]/input")).sendKeys("Football");
		driver.findElement(By.xpath("//div[@id='collapse6']/div/div[2]/span[4]/input")).clear();
		driver.findElement(By.xpath("//div[@id='collapse6']/div/div[2]/span[4]/input")).sendKeys("Hokey");
		driver.findElement(By.xpath("//div[@id='collapse6']/div/div[2]/span[5]/input")).clear();
		driver.findElement(By.xpath("//div[@id='collapse6']/div/div[2]/span[5]/input")).sendKeys("Tennis");
		driver.findElement(By.xpath("//div[@id='collapse6']/div/div[2]/span[6]/input")).clear();
		driver.findElement(By.xpath("//div[@id='collapse6']/div/div[2]/span[6]/input")).sendKeys("Kabbadi");
		
		
		//Select Country
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[9]/div/span/span")).click();
		System.out.println("Select Country.....");
		driver.findElement(By.xpath("//div[@id='collapse8']/div/div[2]/span[3]/input")).clear();
		driver.findElement(By.xpath("//div[@id='collapse8']/div/div[2]/span[3]/input")).sendKeys("IND");
		driver.findElement(By.xpath("//div[@id='collapse8']/div/div[2]/span[4]/input")).clear();
		driver.findElement(By.xpath("//div[@id='collapse8']/div/div[2]/span[4]/input")).sendKeys("PAK");
		driver.findElement(By.xpath("//div[@id='collapse8']/div/div[2]/span[5]/input")).clear();
		driver.findElement(By.xpath("//div[@id='collapse8']/div/div[2]/span[5]/input")).sendKeys("NZ");
		driver.findElement(By.xpath("//div[@id='collapse8']/div/div[2]/span[6]/input")).clear();
		driver.findElement(By.xpath("//div[@id='collapse8']/div/div[2]/span[6]/input")).sendKeys("AUS");
		
		// Send Email
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[10]/div/span/span")).click();
		System.out.println("Send Email.....");
		driver.findElement(By.id("cps9")).clear();
		driver.findElement(By.id("cps9")).sendKeys("Enter Your Email ID");
		
		// RESUME Upload
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[11]/div/span/span")).click();
		System.out.println("RESUME Upload.....");
		driver.findElement(By.id("cpm10")).clear();
		driver.findElement(By.id("cpm10")).sendKeys("RESUME");
		driver.findElement(By.id("cps10")).clear();
		driver.findElement(By.id("cps10")).sendKeys("upload your RESUME");
		
		driver.switchTo().defaultContent();
		// Scroll Up
		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		System.out.println("Scroll Up.....");
		
		driver.switchTo().frame(0);
		// Click on Live Preview
		Thread.sleep(5000);
		driver.findElement(By.linkText("Live Preview")).click();
		System.out.println("Live Preview.....");
		
		//Click on Back Button
		Thread.sleep(5000);
		driver.findElement(By.linkText("Back")).click();
		System.out.println("Back Button.....");
		
		// Scroll Up
		driver.switchTo().defaultContent();
		jse.executeScript("window.scrollBy(0,-500)", "");
		System.out.println("Scroll Up.....");
		
		//Click on Submit Button
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Submit Button.....");
		
		System.out.println("Cliked YO man ");
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.findElement(By.linkText("YouTube")).click();
		System.out.println("Clicked On You Tube");
		Utilities.takeScrShot(driver);
		System.out.println("Haha Screenshot taken......");
		Utilities.takeScrShotOnAsserssion(driver);
		
	}
}
