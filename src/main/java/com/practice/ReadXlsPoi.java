package com.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXlsPoi {

	public static List<TestData> readExcelData(String fileName) {
		List<TestData> testDataList = new ArrayList<TestData>();

		try {
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

					String Test_Step = "";
					String Fieldname = "";
					String Value = "";
					String TypofInput = "";
					String Compare_Lable = "";

					// Get the row object
					Row row = rowIterator.next();

					// Every row has columns, get the column iterator and iterate over them
					Iterator<Cell> cellIterator = row.cellIterator();

					while (cellIterator.hasNext()) {
						// Get the Cell object
						Cell cell = cellIterator.next();

						// check the cell type and process accordingly
						switch (cell.getCellType()) {

						case Cell.CELL_TYPE_STRING:

							if (Test_Step.equalsIgnoreCase("")) {
								// 1st column
								Test_Step = cell.getStringCellValue().trim();

							}

							else if (Fieldname.equalsIgnoreCase("")) {
								// 2nd column
								Fieldname = cell.getStringCellValue().trim();

							}

							else if (Value.equalsIgnoreCase("")) {
								// 3rd column
								Value = cell.getStringCellValue().trim();

							}

							else if (TypofInput.equalsIgnoreCase("")) {
								// 4th column
								TypofInput = cell.getStringCellValue().trim();

							}

							else if (Compare_Lable.equalsIgnoreCase("")) {
								// 5th column
								Compare_Lable = cell.getStringCellValue().trim();

							} else {

								// random data, leave it
								System.out.println("Random data::" + cell.getStringCellValue());
							}
							break;

						//case Cell.CELL_TYPE_NUMERIC:

							//System.out.println("Random data::" + cell.getNumericCellValue());
						}
					}

					TestData data = new TestData(Test_Step, Fieldname, Value, TypofInput, Compare_Lable);
					testDataList.add(data);
				} // end of rows iterator

			} // end of sheets for loop

			// close file input stream
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return testDataList;
	}

	public static void main(String args[]) {
		List<TestData> list = readExcelData("E:\\SeleniumTestData\\AapKiApp\\AapKiAppRegistration.xls");
		System.out.println(list);
		System.out.println("Test Data List ----> \n" + list);
	}

}
