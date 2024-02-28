import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class Intro {

    public static void main(String[] args) {

        //for manually putting chrome webdriver on path
        //System.setProperty("webdriver.chrome.driver", "/home/sysquare/Downloads/chrome-linux64/chrome");

        //if we don't provide the webdriver manually, selenium manager will work for that

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sysquare.com");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        System.out.println("Going out now! byee");
        driver.quit();

        //driver.quit(); here all the windows will get closed which were opened by automation
    }
}
