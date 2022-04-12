package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//Below generic method to drive the Data-driven tests. No hard coding of data in the scripts//
//Hence, this framework is also a 'Data-driven framework' as well//

public class Excel {
public static String getCellValue(String path, String sheet, int r, int c){
String V="";
try{
FileInputStream fis=new FileInputStream(path);
Workbook wb=WorkbookFactory.create(fis);
wb.getSheet(sheet).getRow(r).getCell(c);
V=wb.getSheet(sheet).getRow(r).getCell(c).toString();
						}
catch(Exception e){
		}
	return V;
}

public static int getRowCount(String path, String sheet){
int rc=0;
try{
FileInputStream fis=new FileInputStream(path);
Workbook wb=WorkbookFactory.create(fis);
rc=wb.getSheet(sheet).getLastRowNum();
}

catch(Exception e){
		}
return rc;
		}
		}



