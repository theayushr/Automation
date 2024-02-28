package main.learning.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RealAutoSearch {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='autosuggest']")).sendKeys("ia");

        Thread.sleep(2000);

        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        String country;
        for(WebElement item:options){
            if(item.getText().equalsIgnoreCase("India")){
                country = item.getText();
                System.out.println(country);
                item.click();

                Thread.sleep(3000);
                break;
            }
        }

        driver.quit();

    }
}
