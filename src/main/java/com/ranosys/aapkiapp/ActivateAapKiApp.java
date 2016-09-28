package com.ranosys.aapkiapp;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ranosys.constants.AppKiAppConstants;
import com.ranosys.utilities.ObjectStatus;
import com.ranosys.utilities.Utilities;

public class ActivateAapKiApp {

	public static WebDriver driver = null;
	public static List<ObjectStatus> status = new ArrayList<ObjectStatus>();
	public static String MyMail;
	static String popupWindow = "";
	static String fileName = "E:\\SeleniumTestData\\AapKiAppStatus\\ActivateAapKiAppStatus.xls";

	@BeforeMethod
	public static void beforeMethod() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\Jeevan\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		Thread.sleep(3000);
		driver.navigate().to(AppKiAppConstants.EmailLink);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Utilities.maximizeScreen(driver);
	}

	@Test
	public static void executeActivateAapKiApp() throws BiffException, IOException {
		Sheet s;
		FileInputStream fi = new FileInputStream("E:\\SeleniumTestData\\AapKiApp\\ActivateAapKiApp.xls");
		System.out.println("Reading Excel sheet Sucessfull:");
		System.out.println("Reading Excel sheet Sucessfull");

		Workbook w = Workbook.getWorkbook(fi);
		s = w.getSheet(0);
		int rowNumbers = s.getRows();

		System.out.println("Total Number of ROWS>" + rowNumbers);

		String Fieldname = "";
		String Value = "";
		String TypofInput = "";
		String Compare_Lable = "";

		for (int column = 4; column <= 4; column++) {
			for (int row = 1; row < rowNumbers; row++) {

				ObjectStatus obj = new ObjectStatus();
				String execu_Status = "Pass";
				obj.setColumn(column);
				obj.setRow(row);

				System.out.println("Getting for row no : " + row + " and column no : " + column);
				System.out.println("Reading Excel sheet started");

				Fieldname = s.getCell(2, row).getContents();
				Value = s.getCell(column, row).getContents();
				TypofInput = s.getCell(1, row).getContents();
				Compare_Lable = s.getCell(3, row).getContents();

				System.out.println("Objecte Identified :" + Fieldname);
				System.out.println("Value Placed in Field :" + Value);
				System.out.println("Type of input is :" + TypofInput.trim());
				// System.out.println("Compare_Lable of input is :>>>>>>>>"+
				// Compare_Lable.trim());

				String[] fieldNames = null;

				TypofInput = TypofInput.trim();
				Value = Value.trim();
				Fieldname = Fieldname.trim();
				try {
					if (TypofInput.equalsIgnoreCase("Text_Box")) {
						if (driver.findElement(By.id(Fieldname)).isEnabled()) {
							driver.findElement(By.id(Fieldname)).clear();
							driver.findElement(By.id(Fieldname)).sendKeys(Value);
						}

						else {
							Utilities.explicitWait(driver, Fieldname);
							driver.findElement(By.id(Fieldname)).clear();
							driver.findElement(By.id(Fieldname)).sendKeys(Value);
						}
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Text_Box_Xpath")) {
						Thread.sleep(500);
						driver.findElement(By.xpath(Fieldname)).clear();
						driver.findElement(By.xpath(Fieldname)).sendKeys(Value);
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Send_User_Mail")) {
						MyMail = AppKiAppConstants.MyMail + Utilities.getRandomEmail() + "@ranosys.com";
						System.out.println(MyMail);
						driver.findElement(By.xpath(Fieldname)).clear();
						driver.findElement(By.xpath(Fieldname)).sendKeys(MyMail);
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Assert_Mail")) {
						boolean mail = driver.findElement(By.xpath(Fieldname)).isEnabled();
						Utilities.takeScrShotOnAsserssion(driver);
						Assert.assertEquals(mail, true);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Title_Link_Text")) {
						driver.findElement(By.linkText(Fieldname)).click();
						continue;
					} 
					
					else if (TypofInput.equalsIgnoreCase("Partial_Link_Text")) {
						driver.findElement(By.partialLinkText(Fieldname)).click();
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Click_By_Class")) {
						driver.findElement(By.className(Fieldname)).click();
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Click")) {
						driver.findElement(By.id(Fieldname)).click();
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Delete_Mail1")) {
						driver.findElement(By.cssSelector(Fieldname)).click();
						Robot r = new Robot();
						for (int i = 1; i <= 7; i++) {
							r.keyPress(KeyEvent.VK_DOWN);
							r.keyRelease(KeyEvent.VK_DOWN);
							System.out.println("Tabbed " + i + " time.");
						}
						r.keyPress(KeyEvent.VK_DELETE);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Delete_Mail")) {
						driver.findElement(By.cssSelector(Fieldname)).click();
						for (int i = 0; i < 7; i++) {
							driver.findElement(By.cssSelector(Fieldname)).sendKeys(Keys.ARROW_DOWN);
							if (i == 6) {
								driver.findElement(By.cssSelector(Fieldname)).sendKeys(Keys.ENTER);
							}
						}
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Delete_Mail")) {
						driver.findElement(By.cssSelector(Fieldname)).click();
						for (int i = 0; i < 7; i++) {
							driver.findElement(By.cssSelector(Fieldname)).sendKeys(Keys.ARROW_DOWN);
							if (i == 6) {
								driver.findElement(By.cssSelector(Fieldname)).sendKeys(Keys.ENTER);
							}
						}
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("ClickByXpath")) {
						if (driver.findElement(By.xpath(Fieldname)).isEnabled()) {
							System.out.println("Element Visible");
							driver.findElement(By.xpath(Fieldname)).click();
						} else {
							System.out.println("Need To wait for Sometime");
							Utilities.explicitWaitXpath(driver, Fieldname);
							driver.findElement(By.xpath(Fieldname)).click();
						}
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("ClickByAction")) {
						if (driver.findElement(By.xpath(Fieldname)).isEnabled()) {
							String act = driver.findElement(By.xpath(Fieldname)).getAttribute("act");

							List<WebElement> delete = new ArrayList<WebElement>();
							delete = driver.findElements(By.xpath(Fieldname));
							int size = delete.size();
							System.out.println("Sizeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee :" + size);

							for (WebElement i : delete) {
								System.out.println("Elements :" + i.toString());
							}
							System.out.println(act);
							System.out.println("Element Visible");
							WebDriverWait wait = new WebDriverWait(driver, 30);
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Fieldname)));
							driver.findElement(By.xpath(Fieldname)).click();
							/*
							 * WebElement element = driver.findElement(By.xpath(Fieldname)); Actions action = new Actions(driver); action.moveToElement(element).click().perform();
							 */
						} else {
							System.out.println("Need To wait for Sometime");
							Utilities.explicitWaitXpath(driver, Fieldname);
							WebElement element = driver.findElement(By.xpath(Fieldname));
							Actions action = new Actions(driver);
							action.moveToElement(element).click().perform();
						}
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("ClickByCss")) {

						if (driver.findElement(By.cssSelector(Fieldname)).isEnabled()) {
							driver.findElement(By.cssSelector(Fieldname)).click();
						} else {
							Utilities.explicitWaitCss(driver, Fieldname);
							driver.findElement(By.cssSelector(Fieldname)).click();
						}
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("ClickByAction")) {
						Thread.sleep(500);
						WebElement element = driver.findElement(By.xpath(Fieldname));
						Actions action = new Actions(driver);
						action.moveToElement(element).click().perform();
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("WAIT_TIME_1")) {
						Thread.sleep(2000);
					}

					else if (TypofInput.equalsIgnoreCase("WaitForPopUp")) {
						popupWindow = driver.getWindowHandle();
						System.out.println("Pop Up  String IS ;" + popupWindow);
						Set<String> windows = driver.getWindowHandles();
						System.out.println("How many windows open ;" + windows.size());
						for (String popup : driver.getWindowHandles()) {
							driver.switchTo().window(popup);
							System.out.println("After Switching Popo up Handler Is" + popup);
						}
						System.out.println(driver.getCurrentUrl());
						driver.manage().window().maximize();
						driver.close();
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Switch_Pop_MainWindow")) {
						Thread.sleep(500);
						driver.switchTo().window(popupWindow);
						System.out.println(driver.getCurrentUrl());
						System.out.println("Switching Completed");
					}

					else if (TypofInput.equalsIgnoreCase("Switch_Frame")) {
						System.out.println(Fieldname);
						driver.switchTo().frame(Fieldname);
						Thread.sleep(500);
					}

					else if (TypofInput.equalsIgnoreCase("Close_driver")) {
						Thread.sleep(1000);
						driver.quit();
						continue;
					}

				} catch (Exception e) {
					execu_Status = "Fail";
					Utilities.writeStatusFile(fileName, execu_Status, row);
					System.out.println("Exception  occured in writereport method"+e);
					Utilities.takeScrShot(driver);
					System.out.println("Screenshot taken.....");
				} finally {
					obj.setStatus(execu_Status);
					Utilities.writeStatusFile(fileName, execu_Status, row);
					status.add(obj);
				}
			}
		}

		w.close();
		fi.close();
	}

	@AfterMethod
	public static void writereport() {
		System.out.println("writing report");
	}
}
