package main.learning.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Date {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rccarnation.net/bn-web/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[1]/form/div[1]/div/input")).sendKeys("useray3338@mailinator.com");
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[1]/form/div[2]/div/input")).sendKeys("12345678");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/button")).click();
        Thread.sleep(8000);


        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[3]/div[1]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div/div[2]/div[1]/table/tbody/tr[4]/td[5]/div/h6")).click();
        Thread.sleep(3000);

        driver.quit();

    }
}
