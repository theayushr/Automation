package main.learning.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Dynamic Date

public class DatingPractice {
    public static void main(String[] args) throws InterruptedException {

        String mydate = "12";
        String mymonth = "September";
        String myyear = "2028";

        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        WebElement myframe = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(myframe);
        //driver.switchTo().defaultContent();


        //inside the frame
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();


        boolean yearmonth = false;
        while(!yearmonth){
            String curYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
            String curMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();

            if(curYear.equals(myyear) && curMonth.equals(mymonth)){
                yearmonth = true;
                System.out.println("Year: " + curYear);
                System.out.println("Month: " + curMonth);
                System.out.println("Date: " + mydate);
                driver.findElement(By.xpath("//*[text()='"+mydate+"']")).click();
            }else{
                driver.findElement(By.cssSelector(".ui-icon-circle-triangle-e")).click();
            }
        }

        /*
        WebDriverWait waitforme = new WebDriverWait(driver, Duration.ofSeconds(3));
        waitforme.until(ExpectedConditions.visibilityOfElementLocated());
        */

        driver.quit();

    }
}
