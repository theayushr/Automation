package main.learning.cdp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.fetch.model.AuthChallengeResponse;
import org.openqa.selenium.devtools.v122.network.Network;
import org.openqa.selenium.devtools.v122.network.model.Request;
import org.openqa.selenium.devtools.v122.network.model.Response;

import java.time.Duration;
import java.util.Optional;

public class NetworkLogActivity {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), request ->{
            Request req = request.getRequest();
            System.out.println(req.getUrl());
        });


        devTools.addListener(Network.responseReceived(), response -> {
            Response res = response.getResponse();
//            System.out.println(res.getUrl());
            System.out.println(res.getStatus());
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo");
        WebElement library = driver.findElement(By.cssSelector("button[routerlink='/library']"));
        Thread.sleep(3000);
        library.click();
        Thread.sleep(3000);

        driver.quit();



    }
}
