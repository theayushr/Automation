package main.learning.upload_download;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GetExcel{

    public ArrayList<Integer> getRowAndCols() throws IOException {
        ArrayList<Integer> vals = new ArrayList<>();

        FileInputStream fis = new FileInputStream("/home/sysquare/Downloads/download.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rows = sheet.rowIterator();

        //In the first row check where is price section mentioned
        Row firstRow = rows.next();
        int totalcols = firstRow.getLastCellNum();
        int fruitcols = 0;
        for(int i=0; i<totalcols; i++){
            String attribute = String.valueOf(firstRow.getCell(i));
            if(attribute.equalsIgnoreCase("price")){
                vals.add(i);
            }
            if(attribute.equalsIgnoreCase("Fruit_Name")){
                fruitcols = i;
            }
        }

        int twinkleRow = 1;
        while(rows.hasNext()){
            Row curRow = rows.next();
            if(curRow.getCell(fruitcols).getStringCellValue().equalsIgnoreCase("Apple")){
                vals.add(twinkleRow);
            }
            twinkleRow++;
        }
        return vals;
    }

    public boolean updateExcel() throws IOException {

        GetExcel excel = new GetExcel();

        int row = excel.getRowAndCols().get(1);
        int col = excel.getRowAndCols().get(0);

        FileInputStream fis = new FileInputStream("/home/sysquare/Downloads/download.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row myRow = sheet.getRow(row);
        Cell myCell = myRow.getCell(col);
        myCell.setCellValue(456);

        FileOutputStream fos = new FileOutputStream("/home/sysquare/Downloads/download.xlsx");
        workbook.write(fos);
        workbook.close();
        fis.close();
        return true;
    }

    public static void main(String[] args) throws IOException {
        GetExcel obj = new GetExcel();

        System.out.println(obj.updateExcel());
    }

}


