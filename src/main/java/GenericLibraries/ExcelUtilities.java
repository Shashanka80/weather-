package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
 private Workbook wb;
 /**
  * 
  */
 public void exceIinitialization(String excelPath) {
	 FileInputStream fil=null;
	 
	 try {
		fil=new FileInputStream(excelPath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 try {
		wb=WorkbookFactory.create(fil);
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 /**
  * 
  */
 public String fetchDataFromExcel(String sheetName,int rowNum,int cellNum) {
	 return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
 }
 /*
  * 
  * 
  */
 public List<String> fetchDataFromExcel(String sheetName){
	 
	 List<String> dataList = new ArrayList();
	 Sheet sheet = wb.getSheet(sheetName);
	 for (int i = 0; i < 4; i++) {
		 String data = sheet.getRow(i).getCell(1).getStringCellValue();
		 dataList.add(data);
		
	}
	 
	return dataList;
 }
 /**
  * 
  */
  public void closeExcel() {
	  
	  try {
		wb.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}
