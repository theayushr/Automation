package main.learning.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Rccarnation {

        public static void main(String[] args) throws InterruptedException {

            WebDriver driver = new ChromeDriver();

            driver.get("https://rccarnation.net/bn-web/login");
            driver.manage().window().maximize();

            Thread.sleep(5000);

            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[1]/form/div[1]/div/input")).sendKeys("useray3338@mailinator.com");

            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[1]/form/div[2]/div/input")).sendKeys("12345678");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/div[2]/div/div/button")).click();

            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/button")).click();

            Thread.sleep(8000);

            //System.out.println(driver.getTitle());
            //System.out.println(driver.getCurrentUrl());

            System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div/div[1]/div[1]/div/div[2]/p[1]")).getText());


            //Assert is a part of testng tool
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div/div[1]/div[1]/div/div[2]/p[1]")).getText(), "Drone");

            driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[3]/button")).click();

            Thread.sleep(2000);

            driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[5]")).click();

            Thread.sleep(3000);

            // Rccarnation obj = new Rccarnation();
            // System.out.println(obj.getPassword(driver));

            driver.quit();
        }

        public String getPassword(WebDriver driver) throws InterruptedException {

            driver.get("https://rahulshettyacademy.com/locatorspractice/");

            driver.findElement(By.linkText("Forgot your password?")).click();

            Thread.sleep(1000);

            driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

            String passwordText =driver.findElement(By.cssSelector("form p")).getText();

            String[] passwordArray = passwordText.split("'");
            String password = passwordArray[1].split("'")[0];

            return password;
        }

}
