package main.learning.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddToCart {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //implicit wait
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Syntex
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id('name')));

        //two types of explicit wait - WebDriverWait, FluentWait


        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

        String[] productsname = {"Tomato", "Brinjal", "Beans", "Apple", "Capsicum", "Onion", "Musk Melon", "Water Melon"};
        List<String> productList = Arrays.asList(productsname);

        //List<WebElement> items = driver.findElements(By.xpath("//*[@class='product']"));
       // List<WebElement> items = driver.findElements(By.cssSelector(".product"));

        //List<WebElement> check = driver.findElements(By.xpath("//*[@type='button']"));
        //driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();


        AddToCart obj = new AddToCart();
        obj.addItems(driver, productList);


//        for(int i=0; i <itemname.size(); i++){
//            String name = itemname.get(i).getText();
//
//            for (String s : productsname) {
//                if (name.contains(s)) {
//                    driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
//                }
//            }
//        }

        driver.findElement(By.cssSelector(".cart-icon")).click();
        driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();
        //Thread.sleep(2000);

        //using explicit wait here
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter promo code']")));

        driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

        //Thread.sleep(5000);
        //using explicit wait again
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));

        String promoInfo = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();

        //Assert.assertEquals(promoInfo, "Code applied ..!");

        if(promoInfo.equalsIgnoreCase("Code applied ..!")){
            driver.findElement(By.xpath("//button[text()= 'Place Order']")).click();

            //driver.findElement(By.xpath("//div[@class='wrapperTwo']//div//select")).click();

//            List<WebElement> countries = driver.findElements(By.xpath("//option"));
//
//            for(WebElement country : countries){
//
//                String CN = country.getAttribute("value");
//
//                if(CN.equalsIgnoreCase("INDIA")){
//                    driver.findElement(By.xpath("//*[@value='India']")).click();
//                }
//            }

            //notice that here is select used, so you can use that

            WebElement coun = driver.findElement(By.xpath("//select"));
            Select dropdown = new Select(coun);
            dropdown.selectByVisibleText("India");


            driver.findElement(By.xpath("//input[@class='chkAgree']")).click();

            driver.findElement(By.xpath("//button[text()='Proceed']")).click();


        }else{
            System.out.println("WRONG PROMOCODE!!");
        }

        //Thread.sleep(3000);
        driver.quit();


    }

    void addItems(WebDriver driver, List<String> productList){

        List<WebElement> itemname = driver.findElements(By.cssSelector(".product-name"));

        int times = 0;

        for(int i=0; i <itemname.size(); i++){

            String name = itemname.get(i).getText().split("-")[0].trim();

            if (productList.contains(name)) {
                times++;

                //driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                //Thread.sleep(5000);
                // here find element is returning the list element and we wanna access the ith Add to Cart button that's
                // why we are using get(i)

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                //note that we are finding elements and not an element

                //System.out.println(name);
            }

            if(times==productList.size()){
                break;
            }

        }

    }

}
