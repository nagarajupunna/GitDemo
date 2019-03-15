package nagarajuMaven;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadTestDataFromExcel {

	@Test
	public ArrayList<String> getData(String testcaseName) throws IOException
	{
	//String testcaseName="TC2";
		//System.out.println("hello");

		ArrayList<String> a=new ArrayList<String>();
		
	FileInputStream fis=new FileInputStream("D:\\TestCases.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);

	int sheetsCount=workbook.getNumberOfSheets();
	
	//System.out.println(sheetsCount);
	
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	
	
	Iterator <Row> rows= sheet.iterator();
	Row firstRow=rows.next();
	
	/*int rowsCount=0;
	while(rows.hasNext())
	{
		rows.next();
		rowsCount++;
	}
	*/	

	//System.out.println("rowsCount"+rowsCount);

	Iterator <Cell> ce=firstRow.cellIterator();
	int k=0;
	int column=0;
	while(ce.hasNext())
	{
		Cell value=ce.next();
		
		if(value.getStringCellValue().equalsIgnoreCase("TestCaseName"))
		{
			column=k;
			break;
		}
		k++;
	}
	
	//System.out.println(firstRow.getCell(column).getStringCellValue());
	
	while(rows.hasNext())
	{
	
		//System.out.println("I am in while loop");
		
		Row r=rows.next();
		
		if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
		{
			
			Iterator <Cell>  cv=r.cellIterator();
			while(cv.hasNext())
			{
			
				Cell c=cv.next();
				
				if(c.getCellTypeEnum()==CellType.STRING)
				{

				a.add(c.getStringCellValue());
				}
				else
				{

				a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
				}
			
		}
			
			System.out.println(a.get(0).toString());
			System.out.println(a.get(1).toString());
			System.out.println(a.get(2).toString());
			break;
		}	
		
		
	}
	
	return a;
	
	//System.out.println(value.getStringCellValue());

	//System.out.println("value in the first row first column"+firstRow.ce(k).getStringCellValue());

		
	
	
	}
}