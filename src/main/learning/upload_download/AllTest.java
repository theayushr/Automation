package main.learning.upload_download;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class AllTest {

    MainPage mp = new MainPage();

    @BeforeTest
    public void gotoPage(){
        mp.setDriver();
        mp.gotoPage();
    }

    @Test
    public void process() throws IOException {
        mp.downloadFile();
        mp.updatefile();
        mp.uploadFile();
        mp.toastCheck();
        mp.priceCheck();
        mp.quitTest();
    }
}
