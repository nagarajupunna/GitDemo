import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFramework {

//Identify Testcases coloum by scanning the entire 1st row
//once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
//after you grab purchase testcase row = pull all the data of that row and feed into test

public ArrayList<String> getData(String testcaseName) throws IOException
{
//fileInputStream argument
ArrayList<String> a=new ArrayList<String>();

FileInputStream fis=new FileInputStream("D://TestCases.xlsx");
XSSFWorkbook workbook=new XSSFWorkbook(fis);

int sheets=workbook.getNumberOfSheets();
}
}