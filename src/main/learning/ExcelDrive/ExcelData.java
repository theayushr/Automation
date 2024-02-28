package main.learning.ExcelDrive;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelData {

    public ArrayList<String> getCell() throws IOException {
        ArrayList<String> rowValues = new ArrayList<>();

        FileInputStream fis = new FileInputStream("/home/sysquare/Downloads/poi.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int totalSheets = workbook.getNumberOfSheets();
        for(int i=0; i<totalSheets; i++){
            if(workbook.getSheetName(i).equalsIgnoreCase("First Sheet")){
                XSSFSheet sheet = workbook.getSheetAt(i);

                /**
                 * now we have the control over the sheet with the sheet object
                 */

                Iterator<Row> rows =  sheet.iterator();
                Row firstRow = rows.next();

                Iterator<Cell> ce = firstRow.cellIterator();
                int k = 0;
                int column = 0;
                while(ce.hasNext()){
                    Cell value  = ce.next();
                    if(value.getStringCellValue().equalsIgnoreCase("color")){
                        column = k;
                        break;
                    }
                    k++;
                }

                while(rows.hasNext()){
                    Row r = rows.next();
                    String colName = r.getCell(column).getStringCellValue();
                    if(colName.equalsIgnoreCase("Yellow")){
                        Iterator<Cell> cv = r.cellIterator();
                        while(cv.hasNext()){
                            Cell c = cv.next();
                            if(c.getCellType().equals(CellType.STRING)){
                                rowValues.add(c.getStringCellValue());
                            }else if(c.getCellType().equals(CellType.NUMERIC)){
                                rowValues.add(String.valueOf(c.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return rowValues;
    }


    public ArrayList<String> readFullExcel() throws IOException {

        ArrayList<String> fullExcel = new ArrayList<>();



        FileInputStream fis = new FileInputStream("/home/sysquare/Downloads/poi.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rows = sheet.rowIterator();
        fullExcel.add(String.valueOf(rows.next().getLastCellNum()));

        while(rows.hasNext()){
            Row curRow = rows.next();
            Iterator<Cell> cell = curRow.cellIterator();
            while(cell.hasNext()){
                Cell curCell = cell.next();
                if(curCell.getCellType().equals(CellType.STRING)){
                    String val = curCell.getStringCellValue();
                    fullExcel.add(val);
                }else{
                    String val = String.valueOf(curCell.getNumericCellValue());
                    fullExcel.add(val);
                }
            }
        }


        return fullExcel;
    }
}
