package main.learning.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RccSettings {
    public static void main(String[] args) throws InterruptedException {

        //login to logout

        WebDriver driver = new ChromeDriver();

        driver.get("https://rccarnation.net/bn-web/login");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        //Email
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[1]/form/div[1]/div/input")).sendKeys("useray3338@mailinator.com");

        //Password
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[1]/form/div[2]/div/input")).sendKeys("12345678");
        Thread.sleep(1000);

        //Sign-in Button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/button")).click();


        Thread.sleep(8000);

        //click on profile icom in order to open the settings list
        //driver.findElement(By.xpath("(//*[@data-testid='ArrowDropDownIcon'])[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[3]/button/div/div/img")).click();
        Thread.sleep(1000);

        List<WebElement> mymenu = driver.findElements(By.xpath("//li[@role='menuitem']"));

        for(WebElement items:mymenu){
            System.out.println(items.getText());

            if(items.getText().equalsIgnoreCase("Logout")){
                items.click();
            }
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
