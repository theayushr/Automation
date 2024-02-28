package main.learning.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class RCJoinNewNetwork {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rccarnation.net/bn-web/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[1]/form/div[1]/div/input")).sendKeys("useray3338@mailinator.com");
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[1]/form/div[2]/div/input")).sendKeys("12345678");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/button")).click();
        Thread.sleep(8000);


        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div/div[1]/div[3]/div/div")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("(//div[@role='button'])[2]")).click();

        List<WebElement> types = driver.findElements(By.xpath("//li[@role='option']"));
        //note that we are using findElements and not findElement

        Thread.sleep(2000);
        for(WebElement type:types){
            System.out.println(type.getAttribute("data-value"));

            if(type.getText().equalsIgnoreCase("HOBBY")){
                type.click();
                //break;
            }
            //Assert.assertEquals(type.getText(), "HOBBY");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-testid='LoginIcon']")).click();

        Thread.sleep(3000);
        driver.quit();

    }
}
