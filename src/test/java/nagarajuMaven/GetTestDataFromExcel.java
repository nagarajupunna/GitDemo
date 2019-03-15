package nagarajuMaven;
import nagarajuMaven.ReadTestDataFromExcel;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class GetTestDataFromExcel extends ReadTestDataFromExcel {
	
@Test
public void getTestData() throws IOException
{
	ArrayList<String> a=getData("TC1");	
}

}
