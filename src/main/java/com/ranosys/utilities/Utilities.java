package com.ranosys.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.GetTimeStamp;

public class Utilities {

	public static void maximizeScreen(WebDriver driver) {
		try {
			driver.manage().window().maximize();
			System.out.println("Screen Maximized");
		} catch (Exception e) {
			System.out.println("Maximize screen not Found");
		}

	}

	public static void explicitWait(WebDriver driver, String Fieldname) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(Fieldname)));
	}

	public static void explicitWaitXpath(WebDriver driver, String Fieldname) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Fieldname)));
	}

	public static void explicitWaitCss(WebDriver driver, String Fieldname) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Fieldname)));
	}

	public static String getRandomEmail() {
		Random rnd = new Random();
		final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final String number = "1234567890";

		StringBuilder alphabat = new StringBuilder();
		StringBuilder num = new StringBuilder();

		for (int i = 0; i < 2; i++)
			alphabat.append(AB.charAt(rnd.nextInt(AB.length())));

		for (int i = 0; i < 2; i++)
			num.append(number.charAt(rnd.nextInt(number.length())));
		String CIDRANDOM = alphabat + num.toString();
		// return alphabat + num.toString();
		return CIDRANDOM.toString();
	}

	public static void writeXlsEmail(String MyMail) {

		HSSFWorkbook myBook = null;

		try {
			File file = new File("E:\\SeleniumTestData\\AapKiApp\\AppKiAppTestData.xls");

			FileInputStream inputStream = new FileInputStream(file);

			myBook = new HSSFWorkbook(inputStream);

			HSSFSheet mySheet = myBook.getSheet("Sheet1");

			// Writing Test Data Sheet
			Row row = mySheet.getRow(1);
			Cell cell = row.getCell(0);
			System.out.println("User name :" + MyMail);
			cell.setCellValue(MyMail);

			FileOutputStream outputStream = new FileOutputStream(file);

			myBook.write(outputStream);

			inputStream.close();

			outputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("END OF TEST CASES");
	}

	public static String getMail(int RowNum, int ColNum) throws Exception {
		FileInputStream file1 = null;
		try {
			file1 = new FileInputStream("E:\\SeleniumTestData\\AapKiApp\\AppKiAppTestData.xls");

			new WorkbookFactory();
			org.apache.poi.ss.usermodel.Workbook workbook1 = WorkbookFactory.create(file1);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook1.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Cell cell = sheet.getRow(RowNum).getCell(ColNum);
			String CellData = cell.getStringCellValue();
			workbook1.close();
			file1.close();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static void writeStatusFile(String fileName, String execu_Status, int row) {

		HSSFWorkbook myBook = null;

		try {
			File file = new File(fileName);
			FileInputStream inputStream = new FileInputStream(file);
			myBook = new HSSFWorkbook(inputStream);
			HSSFSheet mySheet = myBook.getSheet("Sheet1");

			// Writing Status File
			Row row1 = mySheet.getRow(row);
			Cell cell = row1.getCell(7);
			System.out.println("Execution Status :" + execu_Status);

			if (cell == null) {
				mySheet.getRow(row).createCell(7).setCellValue(execu_Status);
			} else {
				cell.setCellValue(execu_Status);
			}

			FileOutputStream outputStream = new FileOutputStream(file);
			myBook.write(outputStream);
			inputStream.close();
			outputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("END OF TEST CASES");
	}

	public static void dynamicEmail(String MyMail, int rowNum, int cellNum) {

		HSSFWorkbook myBook = null;

		try {
			File file = new File("E:\\SeleniumTestData\\AapKiApp\\AppKiAppTestData.xls");

			FileInputStream inputStream = new FileInputStream(file);

			myBook = new HSSFWorkbook(inputStream);

			HSSFSheet mySheet = myBook.getSheet("Sheet1");

			// Writing Test Data Sheet
			Row row = mySheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			System.out.println("User name :" + MyMail);
			cell.setCellValue(MyMail);

			FileOutputStream outputStream = new FileOutputStream(file);

			myBook.write(outputStream);

			inputStream.close();

			outputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("END OF TEST CASES");
	}

	public static void takeScrShot(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("E:\\SeleniumTestData\\ScreenShots\\SCR_" + GetTimeStamp.SysDate() + ".png");
		FileUtils.copyFile(scrFile, dest);
	}
	
	public static void takeScrShotOnAsserssion(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("E:\\SeleniumTestData\\ScreenShots\\SCR_Asserssion\\SCR_" + GetTimeStamp.SysDate() + ".png");
		FileUtils.copyFile(scrFile, dest);
	}

}
