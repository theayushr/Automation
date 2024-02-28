package main.learning.actionsweb;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

//Scrolling JS
//Scrolling using Actions ; scrolltoelement(webelement) or movetoelement(webelement)

public class ScrollJS {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();


        //scrolling using actions
        Actions act = new Actions(driver);
        WebElement to = driver.findElement(By.cssSelector(".tableFixHead"));
        //act.scrollToElement(to).build().perform();
        act.moveToElement(to).build().perform();
        Thread.sleep(3000);


        //scrolling using javascript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)");

        //window.scrollBy(x,y) - Scroll in the window

        //Scroll in the webelement

        //js.executeScript("document.querySelector(\".tableFixHead\").scrollBy(0,70)");



        
        List<WebElement> cols = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
        int sum = 0;
        for(WebElement value : cols){
            String numStr = value.getText();
            int num = Integer.parseInt(numStr);
            sum += num;
        }

        //System.out.println("The sum of cols is: " + sum);

        String text = driver.findElement(By.cssSelector(".totalAmount")).getText();
        String trimtext = text.split(":")[1].trim();

        Assert.assertEquals(sum, Integer.parseInt(trimtext));


        //Assignment

        List<WebElement> newcols = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[3]"));
        int newsum =0;
        for(WebElement value: newcols){

            String numStr = value.getText();
            int num = Integer.parseInt(numStr);
            newsum+= num;
        }

        System.out.println(newsum);

        driver.quit();

    }
}
