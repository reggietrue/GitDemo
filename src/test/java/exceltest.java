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

public class exceltest {

	@SuppressWarnings("deprecation")
	public ArrayList<String> getData(String testcaseName) throws IOException
	{
	ArrayList<String> a=new ArrayList<String>();
	
	FileInputStream fin=new FileInputStream("//Users//rtruesdale//Downloads//book2.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fin);
	int sheets= workbook.getNumberOfSheets();
	
	for (int i=0; i<sheets;i++)
		
	{
		if (workbook.getSheetName(i).equalsIgnoreCase("loop1"))
			
			
		{
			System.out.println("I am in the first if");
			XSSFSheet sheet=workbook.getSheetAt(i); //sheet is collection of rows
			  Iterator<Row> rows=sheet.iterator();//get the entire row
			  Row firstrow=rows.next();
			Iterator<Cell> ce = firstrow.cellIterator();
			int l=0;
			int column=0;
			while (ce.hasNext())
			{
				 Cell value=ce.next();
				 System.out.println("get value of the cell-->"+value.getStringCellValue());
				 System.out.println("This is l-->"+l);
				 if (value.getStringCellValue().equalsIgnoreCase("data3"))
				 {
					 column=l;
					 System.out.println("column--->"+column); 
						 
				 }
				 l++;
			}//while close
			System.out.println(column);
			
			while (rows.hasNext())
			{
				Row value1=rows.next();
			  if( value1.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
			  {
				  Iterator<Cell>  r=value1.cellIterator();
				  
				  while (r.hasNext())
				  {
				      Cell c=r.next();
					  if (c.getCellTypeEnum()==CellType.STRING)
					  
					   a.add(c.getStringCellValue());
					  else
						  
						 a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
					   
					   
				    
					 //System.out.println(r.next().getStringCellValue());
				  }//while loop  
				  return a;
			  }//if loop
			}//While loop
			 
		}//if loop
	}//for loop
	return a;
	
	}//Methore
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
	}//main
	
}//class
					
		
					
				
				 
				 
				
			
			
		
		


	


