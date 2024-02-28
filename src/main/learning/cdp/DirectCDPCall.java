package main.learning.cdp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DirectCDPCall {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String,Object> deviceMatrics = new HashMap<>();
        deviceMatrics.put("width",600);
        deviceMatrics.put("height",1000);
        deviceMatrics.put("deviceScaleFactor",50);
        deviceMatrics.put("mobile",true);

        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",deviceMatrics);

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        WebElement btn = driver.findElement(By.cssSelector("button[data-target='#navbarSupportedContent']"));
        btn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        WebElement library = driver.findElement(By.cssSelector("a[routerlink='/library']"));
        wait.until(ExpectedConditions.visibilityOf(library));
        library.click();
        driver.quit();

    }
}
