package GenericUtilities;
/**
 * This class Generic Methods related to excel file
 * @author Sneha
 */
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	/**
	 * this method will read data from XcelFile file based on sheet name, row number, cell  number
	 * and return the value to caller
	 * @param sheetname
	 * @return rowNo
	 * @return CellNo
	 * @return value
	 * @throws IOException
	 * @
	 */	
	public String readDatafromExcelFile(String sheetname, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
	
	Workbook wb = WorkbookFactory.create(fis);
	
	String value =  wb.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getStringCellValue();
    
	return value;
}
	
	/**
	 * This Method will read multiple data from excel and helps to provide data to Dataprovider
	 * @param sheetname
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public Object[][] readMultipleDataFromExcel(String sheetname) throws EncryptedDocumentException, IOException{
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	int lastRow = sh.getLastRowNum();
	int lastCell= sh.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[lastRow][lastCell];
	
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return data;
}


}




