package main.learning.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CalenderTutorial {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        String dd = "21";
        String mm = "10";
        String yy = "2089";

        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();

        boolean found = false;
        while(!found){
            List<WebElement> decade = driver.findElements(By.cssSelector(".react-calendar__decade-view__years__year"));

            for(WebElement checkyear : decade){
                if(checkyear.getText().equalsIgnoreCase(yy)){
                    checkyear.click();
                    found = true;
                    break;
                }
            }
            if(!found){
                driver.findElement(By.cssSelector(".react-calendar__navigation__next-button")).click();
            }
        }

        //normal year
        //driver.findElement(By.xpath("//button[text()='"+yy+"']")).click();

/*
        List<WebElement> months = driver.findElements(By.cssSelector(".react-calendar__tile"));
        for(int i=1; i<=12; i++){
            if(i==mm){
                months.get(i-1).click();
                break;
            }
        }
*/
        String mymonth = driver.findElements(By.cssSelector(".react-calendar__tile")).get(Integer.parseInt(mm)-1).getText();
        driver.findElements(By.cssSelector(".react-calendar__tile")).get(Integer.parseInt(mm)-1).click();

        driver.findElement(By.xpath("//abbr[text()='"+dd+"']")).click();


        //Check
        String choosenMonth = driver.findElement(By.xpath("//input[@name='month']")).getAttribute("value");
        String choosenDay = driver.findElement(By.xpath("//input[@name='day']")).getAttribute("value");
        String choosenYear = driver.findElement(By.xpath("//input[@name='year']")).getAttribute("value");



        System.out.println("Date: " + choosenDay);
        System.out.println("Month: " +mymonth);
        System.out.println("Year: "+ choosenYear);


        Assert.assertEquals(choosenDay, dd);
        Assert.assertEquals(choosenMonth, mm);
        Assert.assertEquals(choosenYear, yy);

        driver.quit();
    }
}
