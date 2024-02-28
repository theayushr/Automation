package main.learning.javaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

//pagination
//filter
//streams - MapToInt


public class GreenKartStreams {
    public static void main(String[] args) throws NoSuchElementException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");


        String[] productsname = {"Tomato", "Brinjal", "Beans","Cashews", "Almonds", "Apple", "Capsicum", "Onion", "Musk Melon", "Water Melon"};
        List<String> productList = Arrays.asList(productsname);

        GreenKartStreams obj = new GreenKartStreams();
        obj.addItems(driver, productList);

        driver.findElement(By.cssSelector(".cart-icon")).click();
        driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();

        WebDriverWait waitObj = new WebDriverWait(driver, Duration.ofSeconds(3));
        waitObj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='products']/table/tbody/tr/td[2]")));
        //waitObj.wait(5000);



        List<WebElement> choosedItems = driver.findElements(By.xpath("//*[@class='products']/table/tbody/tr/td[2]"));
/*
        choosedItems.stream().filter(item-> {
            item.getText().split("-")[0].trim();
            return true;
        }).sorted().forEach(item -> System.out.println(item));


        List<String> choosedItemsStr = new ArrayList<>();
        for(WebElement item : choosedItems){
            String realName = item.getText().split("-")[0].trim();
            choosedItemsStr.add(realName);
        }

        //choosedItemsStr.forEach(item -> System.out.println(item));
 */
        //choosedItems.stream().map(item -> item.getText().split("-")[0].trim()).sorted().forEach(item -> System.out.println(item));

        //List<String> prices = choosedItems.stream().filter(item -> item.getText().contains("apple")).map(item -> findPrice(item)).toList();

        //add the prices of all the items choosed
        List<String> prices = choosedItems.stream().map(price-> findPrice(price)).toList();
        //List<String> prices = choosedItems.stream().map(GreenKartStreams::findPrice).toList();

        OptionalInt ts = prices.stream().mapToInt(i -> Integer.parseInt(i)).max();

        //as the return type of max() method is optionalInt which can be an integer or not.
        //if it's an integer then we can get that by getAsInt() method
        //we can check it's type using isPresent() which checks if an integer is present in the optional int or not

        OptionalInt val = OptionalInt.of(23);

        int sumofall = prices.stream().mapToInt(i->Integer.parseInt(i)).sum();

        int findingSum = prices.parallelStream().mapToInt(i->Integer.parseInt(i)).sum();

        if(ts.isPresent()){
            System.out.println(ts.getAsInt());
            Assert.assertEquals(ts.getAsInt(), 650);
        }

        //prices.forEach(price -> System.out.println(price));

        List<Integer> pricesI = prices.stream().map(Integer::parseInt).toList();
        //we don't need to convert this to integet list as we can simply do that by using MapToInt method ;)

        //int totalsum = pricesI.stream().mapToInt(i->i).sum();

        //System.out.println(totalsum);

    /**
        for(int i : pricesI){
            //System.out.println(i);
            sum += i;
        }
    */
  //  System.out.println("SUM: " +sum);
        driver.quit();
    }
    void addItems(WebDriver driver, List<String> productList){
        List<WebElement> itemname = driver.findElements(By.cssSelector(".product-name"));
        int times = 0;
        for(int i=0; i <itemname.size(); i++){
            String name = itemname.get(i).getText().split("-")[0].trim();
            if (productList.contains(name)) {
                times++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
            }
            if(times==productList.size()){
                break;
            }
        }
    }
    static String findPrice(WebElement item){
        String pr = item.findElement(By.xpath("following-sibling::td[2]")).getText();
        return pr;
    }
}
