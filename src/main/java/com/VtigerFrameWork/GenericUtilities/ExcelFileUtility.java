package com.VtigerFrameWork.GenericUtilities;

/**
 * @author Ajay Kumar
 * This class consist of excel file data manipulation methods.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	/**
	 * This method is to fetch the data from the excel file and return the value as string format.
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream(IConstantUtility.excelFilePath);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetName);
		return sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
	
	/**
	 * This method is to write the data in the excel file in string format.
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param cellValue
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeIntoExcelFile(String sheetName, int rowNum, int cellNum, String cellValue) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileIn= new FileInputStream(IConstantUtility.excelFilePath);
		Workbook book = WorkbookFactory.create(fileIn);
		Sheet sheet = book.createSheet(sheetName);
		sheet.createRow(rowNum).createCell(cellNum).setCellValue(cellValue);
		
		FileOutputStream fileOut= new FileOutputStream(IConstantUtility.excelFilePath);
		book.write(fileOut);
		book.close();
	}

}
