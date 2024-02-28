package main.learning.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownDynamic {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        driver.manage().window().maximize();


        //ask mentor for this one; how to select the xpaths for different values
        //input[@value='Chennai (MAA)']


        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
        WebElement from = driver.findElement(By.cssSelector("a[value='MAA']"));
        from.click();


        //System.out.println("From: ");
        // System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).getText());
        //System.out.println(from.getText());


        Thread.sleep(1000);
        //WebElement to = driver.findElement(By.xpath("(//*[@text='Dehradun (DED)'])[2]"));
        WebElement to = driver.findElement(By.xpath("(//a[@value='IXG'][normalize-space()='Belagavi (IXG)'])[2]"));
        to.click();



        WebElement from2 = driver.findElement(By.xpath("//input[@selectedvalue = 'MAA']"));
        WebElement to2 = driver.findElement(By.xpath("//input[@selectedvalue = 'IXG']"));

       // System.out.println("To: ");
       // System.out.println(to.getText());

        System.out.println(from2.getAttribute("selectedtext"));
        System.out.println(to2.getAttribute("selectedtext"));


        Thread.sleep(2000);

        driver.quit();
    }
}
