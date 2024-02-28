package main.learning.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
/*
        try {
            Thread.sleep(3000); // Pauses for 1 second (1000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/

        //driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();


        driver.findElement(By.id("ap_email")).sendKeys("articulativeman@gmail.com");
        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("ap_password")).sendKeys("Amazon@3338");
        driver.findElement(By.id("signInSubmit")).click();


        try {
            Thread.sleep(5000); // Pauses for 1 second (1000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Going to close it now.");
        driver.quit();

    }
}
