package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "logindata")
     public String[][] LoginData() throws IOException
     {
    	 ExcelUtility xl = new ExcelUtility(".\\testData\\logindata.xlsx");
    	 int rows = xl.getRowCount("sheet1");
    	 int cells = xl.getCellCount("sheet1", 1);
    	 String[][] logindataarray = new String[rows][cells];
    	 for(int r = 1;r<=rows;r++)
    	 {
    		 for(int c = 0;c<cells;c++) {
    			  logindataarray[r-1][c] = xl.getCellData("sheet1", r, c);
    		 }
    	 }
    	 return logindataarray;
     }
}
