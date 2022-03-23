package com.facebook.genaric;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Workbook;

public class Filelib {
	String pathOfFile;

	public Filelib(String pathOfFile) {
		this.pathOfFile = pathOfFile;
	}

	public String getPropertyData(String key) throws IOException {
		FileInputStream fis = new FileInputStream(pathOfFile);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}

	public String getExcelData(String SheetName, int Row, int Cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(pathOfFile);
		return WorkbookFactory.create(fis).getSheet(SheetName).getRow(Row).getCell(Cell).getStringCellValue();

	}

	public void setExcelData(String SheetName, int Row, int Cell, String Value)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(pathOfFile);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(SheetName).getRow(Row).getCell(Cell).setCellValue(Value);
		FileOutputStream fos = new FileOutputStream(pathOfFile);
		wb.write(fos);
		wb.close();

	}

}
