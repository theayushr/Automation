package main.learning.actionsweb;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Links in a page
//Limiting webdriver
//Open link in a new tab ()
//Window handles

public class PlayAround {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        Actions act = new Actions(driver);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();


        // 1. number of links in the whole page
        int numberofLinks = 0;
        numberofLinks = driver.findElements(By.tagName("a")).size();
        //System.out.println(numberofLinks);


        //2. limiting webdriver scope, links in the footer only
        WebElement footerDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
        //webelement can act like a driver maybe driver is also a webelement who knows
        int footerLinks = 0;
        footerLinks = footerDriver.findElements(By.tagName("a")).size();
        //System.out.println(footerLinks);


        //3. limiting webdriver scope even more

        WebElement footerFirstSec = driver.findElement(By.xpath("//body/div/table/tbody/tr/td[1]/ul"));
        int footerFirstseclen = 0;
        footerFirstseclen = footerFirstSec.findElements(By.tagName("a")).size();
        //System.out.println(footerFirstseclen);



        //4. click all the links from the footer
        List<WebElement> ftlinks = footerFirstSec.findElements(By.tagName("a"));
        for(WebElement link : ftlinks){
            if (link.getText().equalsIgnoreCase("Discount Coupons")){
                //we don't need the first page
            }else{
                String clickonlinktab = Keys.chord(Keys.CONTROL, Keys.ENTER);
                link.sendKeys(clickonlinktab);
            }
        }


        //this also works as taught by the mentor
//        for(int i=1; i<footerFirstseclen; i++){
//
//            String clickonlinktab = Keys.chord(Keys.CONTROL, Keys.ENTER);
//            footerFirstSec.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
//
//        }


        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> it = tabs.iterator();

        while(it.hasNext()){

            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

        driver.quit();

    }
}
