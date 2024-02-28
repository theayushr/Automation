package main.learning.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

    public static void main(String[] args){

        //System.setProperty("webdriver.chrome.driver", "/home/sysquare/Downloads/chrome-linux64/chrome");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java Basics");

        driver.findElement(By.id("nav-search-submit-button")).click();

        System.out.println("Going out byee!!");
        driver.quit();

    }
}
