package utilities;

import java.io.File;
import java.io.FileInputStream;

/*import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/

import jxl.*;

public class ExcelData {

	public static String[][] getTableArray(String xlFilePath, String sheetName, String tableName) {
		String[][] tabArray = null;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			Cell tableStart = sheet.findCell(tableName);

			int startRow, startCol, endRow, endCol, ci, cj;

			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();

			Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1, 100, 64000, false);

			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();

			System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", " + "startCol=" + startCol
					+ ", endCol=" + endCol);
			tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
			ci = 0;

			for (int i = startRow + 1; i < endRow; i++, ci++) {
				cj = 0;
				for (int j = startCol + 1; j < endCol; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
					System.out.print(tabArray[ci][cj] + " ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error in getTableArray()");

		}

		return (tabArray);
	}
/*
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static String[][] getTableArrayUsingPOI(String xlFilePath, String sheetName, String tableName)
	 {
	        String[][] tabArray=null;
	        
	        try{
	        	workbook = new XSSFWorkbook(new File(xlFilePath));
	            sheet = workbook.getSheet(sheetName);
	            
	            int startRow,startCol, endRow, endCol,ci,cj;
	            
	            int tableStart[] = findCell(tableName, true);
	            
	            startRow=tableStart[0];
	            startCol=tableStart[1];

	            int tableEnd[] = findCell(tableName, false);                

	            endRow=tableEnd[0];
	            endCol=tableEnd[1];
	            
	            System.out.println("startRow="+startRow+", endRow="+endRow+", " 
	            + "startCol="+startCol+", endCol="+endCol);
	            
	            tabArray=new String[endRow-startRow-1][endCol-startCol-1];
	            ci=0;

	            for (int i=startRow+1;i<endRow;i++,ci++){
	                cj=0;
	                for (int j=startCol+1;j<endCol;j++,cj++){
	                    tabArray[ci][cj]=sheet.getRow(3)sheet...getCell(j,i).getContents();
	                    System.out.print(tabArray[ci][cj] + " ");
	                }
	                System.out.println();
	            }
	        }
	        catch (Exception e)    {
	        	System.out.println(e.getMessage());
	        	System.out.println("error in getTableArray()");
	            
	        }

	        return(tabArray);
	 }

	public int[] findCell(String tableName, boolean flag) {

		XSSFRow row;
		XSSFCell cell;
		
		//Iterating all the rows in the sheet
		Iterator rows = sheet.rowIterator();

		while (rows.hasNext()) {
			row = (XSSFRow) rows.next();
			
			//Iterating all the cells of the current row
			Iterator cells = row.cellIterator();

			while (cells.hasNext()) {
				cell = (XSSFCell) cells.next();

				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
					System.out.print(cell.getStringCellValue() + " ");
				} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
					System.out.print(cell.getNumericCellValue() + " ");
				} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
					System.out.print(cell.getBooleanCellValue() + " ");

				} else { // //Here if require, we can also add below methods to
							// read the cell content
							// XSSFCell.CELL_TYPE_BLANK
							// XSSFCell.CELL_TYPE_FORMULA
							// XSSFCell.CELL_TYPE_ERROR
				}
			}
			System.out.println();
			try {
				XlsxFileToRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}*/

}