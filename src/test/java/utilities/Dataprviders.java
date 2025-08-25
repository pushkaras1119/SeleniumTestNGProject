package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path = "C:\\Users\\buvana.ganeshan\\Documents\\Opencart_loginData.xlsx";//taking xl from testdata
		
		ExcelUtility xlutil = new ExcelUtility(path);//creating obj for xlutility
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[totalrows][totalcols];//created for 2 dimensional array to store
		
		for(int i=1;i<=totalrows;i++) {  //1  read data from xl storing 2d array
			for(int j=0;j<totalcols;j++) {   //0   i-row j-col
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);  //1,0
			}
		}
		return logindata;//returns 2d array
	}
	
	
	//DataProvider 2
	
	
	
	//DataProvider 3
	
	
	
	//DataProvider 4
}