package main.learning.actionsweb;

import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().window().maximize();

        //driver.findElement(By.xpath("//*[@class='blinkingText']")).click();
        driver.findElement(By.cssSelector(".blinkingText")).click();


        //get windows handles
        //switch tabs

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        String parent = it.next();
        String child = it.next();

        driver.switchTo().window(child);



        String text = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();

        //get the mail id out of whole text

        String email = text.split("at")[1].split("with")[0].trim();

        driver.switchTo().window(parent);

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);






    }
}
