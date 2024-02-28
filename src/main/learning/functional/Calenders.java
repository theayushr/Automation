package main.learning.functional;

import main.learning.actionsweb.WindowHandles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Calenders {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href='#/offers']")).click();

        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> it = tabs.iterator();

        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='month']")));


        driver.findElement(By.cssSelector("input[name='month']")).sendKeys("09");
        driver.findElement(By.cssSelector("input[name='day']")).sendKeys("11");
        driver.findElement(By.cssSelector("input[name='year']")).sendKeys("2050");



    }
}
