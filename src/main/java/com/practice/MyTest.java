package com.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ranosys.aapkiapp.AapKiAppRegistration;
import com.ranosys.constants.AppKiAppConstants;
import com.ranosys.utilities.ObjectStatus;
import com.ranosys.utilities.Utilities;

public class MyTest {

	public static WebDriver driver = null;
	public static List<ObjectStatus> status = new ArrayList<ObjectStatus>();
	public static String MyMail;
	static String fileName = "E:\\SeleniumTestData\\AapKiAppStatus\\AapKiAppRegistrationStatus.xls";
	final static Logger logger = Logger.getLogger(AapKiAppRegistration.class);

	@BeforeMethod
	public static void beforeMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Jeevan\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		Thread.sleep(3000);
		driver.get(AppKiAppConstants.UAT_APP_KI_APP);
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Utilities.maximizeScreen(driver);
	}

	@Test
	public static void executeAapKiAppRegistration() throws IOException {
		/*
		 * Sheet s; FileInputStream fi = new FileInputStream("E:\\SeleniumTestData\\AapKiApp\\AapKiAppRegistration.xls"); System.out.println("Reading Excel sheet Sucessfull:"); System.out.println("Reading Excel sheet Sucessfull");
		 * 
		 * Workbook w = Workbook.getWorkbook(fi); s = w.getSheet(0); int rowNumbers = s.getRows(); String fileName = "E:\\SeleniumTestData\\AapKiAppStatus\\AapKiAppRegistrationStatus.xls";
		 * 
		 * System.out.println("Total Number of ROWS>" + rowNumbers);
		 */
		// ///
		FileInputStream fis = new FileInputStream(fileName);

		Workbook workbook = null;
		if (fileName.toLowerCase().endsWith("xlsx")) {
			workbook = new XSSFWorkbook(fis);
		} else if (fileName.toLowerCase().endsWith("xls")) {
			workbook = new HSSFWorkbook(fis);
		}

		int numberOfSheets = workbook.getNumberOfSheets();

		for (int i = 0; i < numberOfSheets; i++) {

			Sheet sheet = workbook.getSheetAt(i);

			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				// ///
				String Fieldname = "";
				String Value = "";
				String TypofInput = "";
				String Compare_Lable = "";

				/*
				 * for (int column = 4; column <= 4; column++) { for (int row = 1; row < rowNumbers; row++) {
				 */

/*				ObjectStatus obj = new ObjectStatus();
				String execu_Status = "Pass";
				obj.setColumn(column);
				obj.setRow(row);*/

				//System.out.println("Getting for row no : " + row + " and column no : " + column);
				System.out.println("Reading Excel sheet started");
				logger.info("This is info : ");

/*				Fieldname = s.getCell(2, row).getContents();
				Value = s.getCell(column, row).getContents();
				TypofInput = s.getCell(1, row).getContents();
				Compare_Lable = s.getCell(3, row).getContents();*/

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
						Thread.sleep(500);
						driver.findElement(By.id(Fieldname)).clear();
						driver.findElement(By.id(Fieldname)).sendKeys(Value);
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

					else if (TypofInput.equalsIgnoreCase("Send_User_Mail")) {
						MyMail = AppKiAppConstants.MyMail + Utilities.getRandomEmail() + "@gmail.com";
						System.out.println(MyMail);
						driver.findElement(By.xpath(Fieldname)).clear();
						driver.findElement(By.xpath(Fieldname)).sendKeys(MyMail);
						Thread.sleep(500);
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("Title_Link_Text")) {
						driver.findElement(By.linkText(Fieldname)).click();
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("ClickByXpath")) {
						driver.findElement(By.xpath(Fieldname)).click();
						continue;
					}

					else if (TypofInput.equalsIgnoreCase("WAIT_TIME_1")) {
						Thread.sleep(5000);
					}

					else if (TypofInput.equalsIgnoreCase("Close_driver")) {
						Thread.sleep(1000);
						driver.quit();
						continue;
					}

				} catch (Exception e) {
					System.out.println(e);
				} finally {
					logger.info("This is info : ");
				}
			}
		}

		/*
		 * w.close(); fi.close();
		 */
		fis.close();

	}

	@AfterMethod
	public static void writereport() {
		System.out.println("writing report");
		Utilities.writeXlsEmail(MyMail);
		System.out.println("XLS Writeen Successfully");
	}
}
