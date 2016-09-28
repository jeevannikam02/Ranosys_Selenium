package com.practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ranosys.constants.AppKiAppConstants;
import com.ranosys.utilities.Utilities;

public class AmazonMail {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "E:\\Jeevan\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://mail.google.com");
		Utilities.maximizeScreen(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		driver.findElement(By.id("Email")).sendKeys("test.ranosys");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.id("Passwd")).sendKeys("Password@29111991");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(500);
		driver.findElement(By.id("gbqfq")).sendKeys("amazon web services");
		driver.findElement(By.id("gbqfb")).click();
		System.out.println("gbqfb clicked");
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[2]/span/b")).click();
		System.out.println("clicked");
		
	}
}
