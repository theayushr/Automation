package main.learning.cdp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GeoLocation {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--deny-permission-prompts");
        options.addArguments("--disable-geolocation");
        options.setExperimentalOption("prefs",
                Map.of("profile.default_content_setting_values.geolocation", 2));

        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        driver.manage().deleteAllCookies();

        Map<String, Object> values = new HashMap<>();
        values.put("latitude", 40);
        values.put("longitude", 3);
        values.put("accuracy", 1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride", values);

//        devTools.send(Emulation.setGeolocationOverride(Optional.of(59), Optional.of(10), Optional.of(43)));

        driver.manage().window().maximize();

        driver.get("https://my-location.org/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        WebElement search = driver.findElement(By.cssSelector("[name='q']"));
//        search.sendKeys("restaurants near me", Keys.ENTER);

        driver.quit();
    }
}
