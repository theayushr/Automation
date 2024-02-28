package main.learning.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"divpaxinfo\"]")).click();
        Thread.sleep(2000);

        int times = 3;
        while(times>0){
            driver.findElement(By.xpath("//*[@id=\"hrefIncAdt\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"hrefIncInf\"]")).click();
            times--;
        }

        for(int i=0; i<4; i++){
            driver.findElement(By.xpath("//*[@id=\"hrefIncChd\"]")).click();
        }

        driver.findElement(By.xpath("//*[@id=\"btnclosepaxoption\"]")).click();

        System.out.println(driver.findElement(By.xpath("//*[@id=\"divpaxinfo\"]")).getText());

        Thread.sleep(2000);
        driver.quit();
    }
}
