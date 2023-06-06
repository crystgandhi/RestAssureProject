package apiUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public CellStyle style;
	String path;
	
	public XLUtils(String path) {
		this.path=path;
		
	}
	
	public static int getRowCount(String xlFile, String xlSheet) throws IOException{
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		}
	public static int getCellCount(String xlFile, String xlSheet, int rownum) throws IOException{
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
		}
	public static String getCellData(String xlFile, String xlSheet, int rownum, int colnum) throws IOException{
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String value=cell.getStringCellValue();
		wb.close();
		fi.close();
		return value;
		}


}
