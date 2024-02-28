package main.learning.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSearch {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"autosuggest\"]")).sendKeys("ia");
        Thread.sleep(3000);

        List<WebElement> myoptions =  driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));



//        for(WebElement option : myoptions){
//
//            System.out.println(option.getText()); //also print all the names starts with keyword
//
//            /*
//            if(option.getText().equalsIgnoreCase("India")){
//                option.click();
//            }
//            */
//        }

        driver.quit();
    }
}
