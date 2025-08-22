package week6.marathonxl;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Integration 
{
	public static String[][] readData() 
			throws IOException
	{
		FileInputStream file= new FileInputStream("./data/INT.xls");
		HSSFWorkbook work= new HSSFWorkbook(file);
		
		HSSFSheet ws=work.getSheetAt(0);
		
		/*HSSFRow row=ws.getRow(1);
		System.out.println(row);
		
		HSSFCell cell=row.getCell(1);
		System.out.println(cell);
		
		String cellvalue=cell.getStringCellValue();
		System.out.println(cellvalue);*/
		
		//String value=ws.getRow(1).getCell(1).getStringCellValue();
		//System.out.println(value);
		
		int rowcount = ws.getLastRowNum();
		int colcount = ws.getRow(0).getLastCellNum();
		
		String[][] data=new String[rowcount][colcount];
		for (int i = 1; i <=rowcount; i++)
		{
			for (int j = 0; j < colcount; j++) 
			{
			String stringCellValue = ws.getRow(i).getCell(j).getStringCellValue();
			data[i-1][j]=stringCellValue;
		}
		}
		work.close();
		return data;
		
	}
}
