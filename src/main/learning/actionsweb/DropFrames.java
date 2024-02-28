package main.learning.actionsweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//frame change - SwitchTo
//drag and drop - Actions

public class DropFrames {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        //switch to the frame
        WebElement myFrame = driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
        driver.switchTo().frame(myFrame);

        driver.findElement(By.xpath("//div[@id='draggable']")).click();
        //driver.findElement(By.id("draggable")).click();

        Actions act = new Actions(driver);

        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement destination = driver.findElement(By.xpath("//div[@id='droppable']"));

        act.dragAndDrop(source, destination).build().perform();

        //come back from the frame
        driver.switchTo().defaultContent();

    }
}
