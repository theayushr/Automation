package main.learning.cdp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v122.emulation.Emulation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

public class DevTools {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        org.openqa.selenium.devtools.DevTools devTools = driver.getDevTools();

        devTools.createSession();

        devTools.send(Emulation.setDeviceMetricsOverride(414, 896, 50, true, Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        WebElement btn = driver.findElement(By.cssSelector("button[data-target='#navbarSupportedContent']"));
        btn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        WebElement library = driver.findElement(By.cssSelector("a[routerlink='/library']"));
        wait.until(ExpectedConditions.visibilityOf(library));
        library.click();
    }
}
