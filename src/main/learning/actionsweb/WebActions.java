package main.learning.actionsweb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Actions - movetoelement
//DoubleClick
//RightClick - ContextClick

public class WebActions {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();


        Actions act = new Actions(driver);

        WebElement signin = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));


        //mouse hover over signin
        act.moveToElement(signin).build().perform();
        //driver.findElement(By.cssSelector("div[id='nav-flyout-ya-signin'] span[class='nav-action-inner']")).click();
        //driver.findElement(By.xpath("//span[@class='nav-action-inner']")).click();



        //seach something in capital letters
        act.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("Jordab B Peterson").build().perform();
        act.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys(" book").doubleClick().build().perform();
        //driver.findElement(By.xpath(" //*[@id='nav-search-submit-button']")).click();


        //right click
        act.moveToElement(signin).contextClick().build().perform();



        //driver.quit();
    }
}
