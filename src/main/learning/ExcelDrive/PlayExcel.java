package main.learning.ExcelDrive;

import java.io.IOException;
import java.util.ArrayList;

public class PlayExcel {
    public static void main(String[] args) throws IOException {

        ExcelData ed = new ExcelData();

        ArrayList<String> excel = ed.readFullExcel();

        int cols = Integer.parseInt(excel.get(0));
        int k = 1;
        for(int i=1; i<excel.size(); i++){
            if(k==cols){
                k=1;
                System.out.println(excel.get(i));
            }else{
                System.out.print(excel.get(i));
                System.out.print(" | ");
                k++;
            }
        }

    }
}
