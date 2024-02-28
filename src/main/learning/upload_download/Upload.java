package main.learning.upload_download;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Upload {

    /**
     * In this example this is the process we are going to follow in the next few sections;
     * Download the file; just a matter of clicking the download button
     * Update the excel file; We are updating the excel file that is there with some new values
     * Upload the file; using sendKeys(file) we are going to upload the excel file
     * Check the updated file. We can use assert or just sout the updated section
     */

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

        WebElement download = driver.findElement(By.cssSelector("#downloadButton"));
        download.click();

        GetExcel excel = new GetExcel();
        Assert.assertTrue(excel.updateExcel());

        WebElement upload = driver.findElement(By.cssSelector("#fileinput"));
        upload.sendKeys("/home/sysquare/Downloads/download.xlsx");

        WebElement toast = driver.findElement(By.cssSelector(".Toastify__toast-body"));
        WebElement toastMessage = driver.findElement(By.cssSelector(".Toastify__toast-body div:nth-child(2)"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOf(toast));
        Assert.assertEquals(toastMessage.getText(), "Updated Excel Data Successfully.");
        wait.until(ExpectedConditions.invisibilityOf(toast));

        String col = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
        WebElement apple = driver.findElement(By.xpath("//div[text()='Apple']/parent::div/parent::div/*[@id='cell-"+col+"-undefined']"));
        System.out.println("Apple Price: " +  apple.getText());

        driver.quit();
    }
}
