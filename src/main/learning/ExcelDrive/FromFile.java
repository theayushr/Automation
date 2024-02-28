package main.learning.ExcelDrive;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FromFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/home/sysquare/Documents/fis");

        int val = fis.read();

        while(val!=-1){
            System.out.print((char)val);
            val++;
        }
        fis.close();

    }
}
