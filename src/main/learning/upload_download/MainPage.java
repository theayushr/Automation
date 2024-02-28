package main.learning.upload_download;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class MainPage{

    WebDriver driver;

    public void setDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    public void gotoPage(){
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
    }

    public void downloadFile(){
        WebElement download = driver.findElement(By.cssSelector("#downloadButton"));
        download.click();
    }

    public void updatefile() throws IOException {
        GetExcel excel = new GetExcel();
        Assert.assertTrue(excel.updateExcel());
    }

    public void uploadFile(){
        WebElement upload = driver.findElement(By.cssSelector("#fileinput"));
        upload.sendKeys("/home/sysquare/Downloads/download.xlsx");
    }

    public void toastCheck(){
        WebElement toast = driver.findElement(By.cssSelector(".Toastify__toast-body"));
        WebElement toastMessage = driver.findElement(By.cssSelector(".Toastify__toast-body div:nth-child(2)"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOf(toast));
        Assert.assertEquals(toastMessage.getText(), "Updated Excel Data Successfully.");
        wait.until(ExpectedConditions.invisibilityOf(toast));
    }

    public void priceCheck(){
        String col = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
        WebElement apple = driver.findElement(By.xpath("//div[text()='Apple']/parent::div/parent::div/*[@id='cell-"+col+"-undefined']"));
        System.out.println("Apple Price: " +  apple.getText());
    }

    public void priceCheckLoop(){

        List<WebElement> prices = driver.findElements(By.cssSelector("#cell-4-undefined"));
        List<WebElement> items = driver.findElements(By.cssSelector("#cell-2-undefined"));

        for(int i=0; i<items.size(); i++){
            String itemName = items.get(i).getText();
            if(itemName.equals("Apple")){
                System.out.println(itemName + " costs " + prices.get(i).getText());
                Assert.assertEquals(prices.get(i).getText(), "345");
            }
        }
    }

    public void quitTest(){
        driver.quit();
    }
}
