package main.learning.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealSpaceJet {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://corporate.spicejet.com/default.aspx");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        driver.findElement(By.cssSelector("a[value='IXR']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@value='IXL'])[2]")).click();
        //driver.findElement(By.cssSelector("li[class='city_selected '] a[value='IXL']")).click();


        WebElement from = driver.findElement(By.xpath("//input[@value='Ranchi (IXR)']"));
        WebElement to  = driver.findElement(By.xpath("//input[@value='Leh (IXL)']"));


        System.out.println("FROM : ");
        System.out.println(from.getAttribute("selectedtext"));

        System.out.println("TO : ");
        System.out.println(to.getAttribute("selectedtext"));

        Thread.sleep(2000);
        driver.quit();
    }
}
