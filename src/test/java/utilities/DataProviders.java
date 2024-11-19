package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException

	{
		String path =".\\testData\\Opencart_LoginData.xlsx"; //taking XL file from testdata
		
		ExcelUtility xlutil=new ExcelUtility(path);  //creating an object for XL utility
		
		int totalrows =xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String logindata [][]= new String[totalrows][totalcols];  //created for 2 dimensional array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //read the data from xl storing in two dimensional array
		{
			for(int j=0; j<totalcols; j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);
			}
		}
		return logindata; ////returning two dimension array
	}
	

}
