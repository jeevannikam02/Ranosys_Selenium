package com.ranosys.aapkiapp;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ranosys.constants.AppKiAppConstants;
import com.ranosys.utilities.ObjectStatus;
import com.ranosys.utilities.Utilities;

public class AapKiAppCreateApp {

	public static WebDriver driver = null;
	public static List<ObjectStatus> status = new ArrayList<ObjectStatus>();
	public static int rowCount = 0;
	static String fileName = "E:\\SeleniumTestData\\AapKiAppStatus\\AapKiAppCreateAppStatus.xls";

	@BeforeMethod
	public static void beforeMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Jeevan\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		Thread.sleep(3000);
		driver.get(AppKiAppConstants.UAT_APP_KI_APP);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Utilities.maximizeScreen(driver);
	}

	@Test
	public static void executeAapKiAppCreateApp() throws BiffException, IOException {
		Sheet s;
		FileInputStream fi = new FileInputStream("E:\\SeleniumTestData\\AapKiApp\\AapKiAppCreateApp.xls");
		System.out.println("Reading Excel sheet Sucessfull:");
		System.out.println("Reading Excel sheet Sucessfull");

		Workbook w = Workbook.getWorkbook(fi);
		s = w.getSheet(0);
		int rowNumbers = s.getRows();

		System.out.println("Total Number of ROWS>" + rowNumbers);

		String Test_Step = "";
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

				Test_Step = s.getCell(0, row).getContents();
				Fieldname = s.getCell(2, row).getContents();
				Value = s.getCell(column, row).getContents();
				TypofInput = s.getCell(1, row).getContents();
				Compare_Lable = s.getCell(3, row).getContents();

				System.out.println("Test step Identified :" + Test_Step);
				System.out.println("Objecte Identified :" + Fieldname);
				System.out.println("Value Placed in Field :" + Value);
				System.out.println("Type of input is :" + TypofInput.trim());
				System.out.println("Compare_Lable of input is :>>>>>>>>" + Compare_Lable.trim());

				String[] fieldNames = null;

				TypofInput = TypofInput.trim();
				Value = Value.trim();
				Fieldname = Fieldname.trim();
				try {
					if (TypofInput.equalsIgnoreCase("Text_Box")) {
						Thread.sleep(500);
						driver.findElement(By.id(Fieldname)).clear();
						driver.findElement(By.id(Fieldname)).sendKeys(Value);
						Thread.sleep(500);
						continue;
					}

					if (TypofInput.equalsIgnoreCase("Text_Box_Color")) {
						Thread.sleep(500);
						driver.findElement(By.id(Fieldname)).clear();
						driver.findElement(By.id(Fieldname)).sendKeys(Value, Keys.ARROW_DOWN);
						Thread.sleep(500);
						continue;
					}

					if (TypofInput.equalsIgnoreCase("Select_Color")) {
						Thread.sleep(500);
						String sampleJS = "document.getElementById('AppConfig_global_section_bar_text_color').value='#2ce315'";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript(sampleJS);
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Text_Box_Xpath")) {
						Thread.sleep(500);
						driver.findElement(By.xpath(Fieldname)).clear();
						driver.findElement(By.xpath(Fieldname)).sendKeys(Value);
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Text_Area")) {
						Thread.sleep(500);
						Thread.sleep(5000);
						Robot rb = new Robot();
						driver.findElement(By.xpath(Fieldname)).sendKeys("");
						rb.keyPress(KeyEvent.VK_TAB); 
						rb.keyPress(KeyEvent.VK_O); 
						rb.keyRelease(KeyEvent.VK_O);
						rb.keyPress(KeyEvent.VK_K); 
						rb.keyRelease(KeyEvent.VK_K);
						//driver.findElement(By.xpath(Fieldname)).sendKeys(Keys.TAB, Value);
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Send_App_Name")) {
						Thread.sleep(500);
						driver.findElement(By.xpath(Fieldname)).clear();
						driver.findElement(By.xpath(Fieldname)).sendKeys(Utilities.getRandomEmail());
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Scroll_Down")) {
						JavascriptExecutor jse = (JavascriptExecutor) driver;
						jse.executeScript("window.scrollBy(0,250)", "");
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Scroll_Up")) {
						JavascriptExecutor jse = (JavascriptExecutor) driver;
						jse.executeScript("window.scrollBy(0,-250)", "");
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Dynamic_Mail")) {
						driver.findElement(By.xpath(Fieldname)).clear();
						driver.findElement(By.xpath(Fieldname)).sendKeys(Utilities.getMail(1, 0));
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Send_User_Mail")) {
						String NewMail = AppKiAppConstants.MyMail + Utilities.getRandomEmail() + "@gmail.com";
						System.out.println(NewMail);
						driver.findElement(By.xpath(Fieldname)).clear();
						driver.findElement(By.xpath(Fieldname)).sendKeys(NewMail);
						Thread.sleep(500);
						continue;
					}
					
					else if (TypofInput.equalsIgnoreCase("Send_Vendor_Mail")) {
						String NewMail = AppKiAppConstants.VendorMail + Utilities.getRandomEmail() + "@gmail.com";
						System.out.println(NewMail);
						driver.findElement(By.xpath(Fieldname)).clear();
						driver.findElement(By.xpath(Fieldname)).sendKeys(NewMail);
						Utilities.dynamicEmail(NewMail, 2, 0);
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Date")) {
						((JavascriptExecutor) driver).executeScript("document.getElementById('Events_event_date').removeAttribute('readonly',0);");
						WebElement toDateBox = driver.findElement(By.id(Fieldname));
						toDateBox.clear();
						toDateBox.sendKeys(Value); // Enter date in required format
						toDateBox.sendKeys(Keys.RETURN);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Check_Active_Deactive")) {
						if (driver.findElement(By.xpath(Fieldname)).isEnabled()) {
							String status = driver.findElement(By.xpath(Fieldname)).getAttribute("data-original-title");
							Utilities.takeScrShotOnAsserssion(driver);
							Assert.assertEquals(status, "Activate");
							System.out.println("Asserssion passed........");
						} else {
							Utilities.explicitWaitXpath(driver, Fieldname);
							String status = driver.findElement(By.xpath(Fieldname)).getAttribute("data-original-title");
							Utilities.takeScrShotOnAsserssion(driver);
							Assert.assertEquals(status, "Activate");
							System.out.println("Asserssion passed........");
						}
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Check_Feature_Available")) {
						boolean status = driver.findElement(By.xpath(Fieldname)).isDisplayed();
						Utilities.takeScrShotOnAsserssion(driver);
						Assert.assertEquals(status, false);
						System.out.println("Asserssion passed........");
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Assert_Album_Name")) {
						boolean status = driver.findElement(By.cssSelector(Fieldname)).isDisplayed();
						Utilities.takeScrShotOnAsserssion(driver);
						Assert.assertEquals(status, true);
						System.out.println("Asserssion passed........");
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Get_Status")) {
						String Status = driver.findElement(By.xpath(Fieldname)).getAttribute("data-original-title");
						System.out.println(Status);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("uploadFile")) {
						driver.findElement(By.id(Fieldname)).sendKeys(Value);
					}

					else if (TypofInput.equalsIgnoreCase("Table_Size")) {
						rowCount = driver.findElements(By.xpath(Fieldname)).size();
						System.out.println("RowCount is:" + rowCount);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Assert_Table_Size")) {
						Utilities.takeScrShotOnAsserssion(driver);
						Assert.assertEquals(Integer.toString(rowCount), Value);
						System.out.println("Asserssion passed........");
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Table_Size_Operators")) {
						int rowCount = driver.findElements(By.xpath(Fieldname)).size();
						System.out.println("RowCount is:" + rowCount);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Check_Global_Header_Background_Color")) {
						String color = driver.findElement(By.xpath(Fieldname)).getAttribute("style");
						String[] splitArray = color.split(":");
						for (int i = 0; i < splitArray.length; i++) {
							System.out.println(splitArray[i]);
						}
						System.out.println("Hi:" + splitArray[2]);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Check_Color")) {
						String color = driver.findElement(By.xpath(Fieldname)).getAttribute("style");
						String[] splitArray = color.split(":");
						for (int i = 0; i < splitArray.length; i++) {
							System.out.println(splitArray[i]);
						}
						System.out.println("Hi:" + splitArray[2]);
						continue;
					}
					
					else if (TypofInput.equalsIgnoreCase("Check_Color1")) {
						String color = driver.findElement(By.xpath(Fieldname)).getAttribute("style");
						String[] splitArray = color.split(":");
						for (int i = 0; i < splitArray.length; i++) {
							System.out.println(splitArray[i]);
						}
						System.out.println("Hi:" + splitArray[1]);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Check_Global_Header_Text_Color")) {
						String color = driver.findElement(By.xpath(Fieldname)).getAttribute("style");
						String[] splitArray = color.split(":");
						for (int i = 0; i < splitArray.length; i++) {
							System.out.println(splitArray[i]);
						}
						System.out.println("Hi:" + splitArray[1]);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Check_Bottom_Tab_Text_Color")) {
						String color = driver.findElement(By.xpath(Fieldname)).getAttribute("style");
						String[] splitArray = color.split(":");
						for (int i = 0; i < splitArray.length; i++) {
							System.out.println(splitArray[i]);
						}
						System.out.println("Hi:" + splitArray[1]);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Background_Even")) {
						String color = driver.findElement(By.xpath(Fieldname)).getAttribute("style");
						System.out.println(color);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Button")) {
						Thread.sleep(500);
						driver.findElement(By.id(Fieldname)).click();
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("ButtonCss")) {
						Thread.sleep(500);
						driver.findElement(By.cssSelector(Fieldname)).click();
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Switch_Frame")) {
						System.out.println(Fieldname);
						driver.switchTo().frame(Fieldname);
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("uploadFile")) {
						driver.findElement(By.id(Fieldname)).sendKeys(Value);
					}

					else if (TypofInput.equalsIgnoreCase("alert")) {
						Alert alert = driver.switchTo().alert();
						alert.accept();
					}

					else if (TypofInput.equalsIgnoreCase("Button_Sub")) {
						Thread.sleep(500);
						driver.findElement(By.id(Fieldname)).click();
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Drop_down")) {
						driver.findElement(By.id(Fieldname)).sendKeys(Value);
						driver.findElement(By.id(Fieldname)).sendKeys(Keys.RETURN);
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Radio_Button")) {
						System.out.println("Xpath is " + Fieldname);
						driver.findElement(By.xpath(Fieldname)).click();
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Click")) {
						driver.findElement(By.id(Fieldname)).click();
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Save")) {
						driver.findElement(By.name(Fieldname)).click();
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Text_By_Name")) {
						driver.findElement(By.name(Fieldname)).clear();
						driver.findElement(By.name(Fieldname)).sendKeys(Value);
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Title_Link_Text")) {
						driver.findElement(By.linkText(Fieldname)).click();
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("ClickByXpath")) {
						Thread.sleep(500);
						driver.findElement(By.xpath(Fieldname)).click();
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("ClickByAction")) {
						Thread.sleep(500);
						WebElement element = driver.findElement(By.xpath(Fieldname));
						Actions action = new Actions(driver);
						action.moveToElement(element).click().perform();
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Click_Tab_Css")) {
						driver.findElement(By.cssSelector(Fieldname)).click();
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("WAIT_TIME_1")) {
						Thread.sleep(2000);
					}

					else if (TypofInput.equalsIgnoreCase("Select_Item")) {
						new Select(driver.findElement(By.id(Fieldname))).selectByVisibleText(Value.trim());
						Thread.sleep(800);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Close_driver")) {
						Thread.sleep(1000);
						driver.quit();
						continue;
					}

				} catch (Exception e) {
					execu_Status = "Fail";
					Utilities.writeStatusFile(fileName, execu_Status, row);
					System.out.println("Exception  occured in writereport method");
					Utilities.takeScrShot(driver);
					System.out.println("Screenshot taken.....");
					System.out.println(e);
					
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
