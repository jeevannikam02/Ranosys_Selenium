package com.ranosys.Ranosys_Selenium;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumPractice implements Runnable {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 25; i++)
			executor.execute(new SeleniumPractice());
	}

	public static void executeLogIn() throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://fwd-qat.ap-southeast-1.elasticbeanstalk.com/CC004");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("divya@ranosys.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("password");
		System.out.println("Web Site Opened");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@type='submit' and @value='SIGN IN']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Swati Manglani")).click();
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
		System.out.println("Firefox Closed");
	}

	@Override
	public void run() {
		try {
			executeLogIn();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
