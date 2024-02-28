package main.learning.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Alerts - SwitchToAlert just like switchtoframe

public class Alert {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("[id='name']")).sendKeys("Sysquare");
        driver.findElement(By.xpath("//*[@id='alertbtn']")).click();


        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[@id='confirmbtn']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();


        driver.quit();
    }
}
