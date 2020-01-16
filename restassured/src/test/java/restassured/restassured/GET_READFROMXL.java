





package restassured.restassured;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import java.io.*;
import java.util.Iterator;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.testng.annotations.*;

import CONFIGFILEREADER.Config_file;

public class GET_READFROMXL {

	@Test
	public void teststatus()
	{
		Response res=RestAssured.get("https://reqres.in/api/users/2");
		int code =res.getStatusCode();
		//System.out.print("code is "+code);
		Assert.assertEquals(code,200);
		
		
	}
	@Test
	public void readXLSXFile() throws IOException 
	{
		String path = Config_file.getConfigValue("url");
    FileInputStream file = new FileInputStream(new File(path));
	 
    //Create Workbook instance holding reference to .xlsx file
    XSSFWorkbook workbook = new XSSFWorkbook(file);

    //Get first/desired sheet from the workbook
    XSSFSheet sheet = workbook.getSheetAt(2);


    for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
    { // For each Row.
    	
    	String data;
    	Row row = sheet.getRow(rowIndex);
        XSSFCell cell = (XSSFCell) row.getCell(1); // Get the Cell at the Index / Column you want.
        XSSFCell expect = (XSSFCell) row.getCell(2);
        System.out.println("url  is "+cell);
        String val= cell.getStringCellValue();
        DataFormatter formatter = new DataFormatter();
        data = formatter.formatCellValue(cell);
        Response res=RestAssured.get(val);  
        int code =res.getStatusCode();
		System.out.println("code is "+code);
		Assert.assertEquals(code,Integer.parseInt(data));
        
    }   
	 
	}
   }
}

