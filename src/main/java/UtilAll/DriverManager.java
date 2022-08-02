package UtilAll;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private WebDriver driver;

    public WebDriver createInstance(String browserName) {
        browserName = (browserName != null) ? browserName : "chrome";
        switch (Browser.valueOf(browserName.toUpperCase())) {
            case CHROME:
                System.out.println("Launching " + browserName + " browser...");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
                break;
            case FIREFOX:
                System.out.println("Launching " + browserName + " browser...");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
                break;
            case OPERA:
                System.out.println("Launching " + browserName + " browser...");
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
                break;
            case EDGE:
                System.out.println("Launching " + browserName + " browser...");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
                break;
        }

        return driver;
    }

    private enum Browser {
        CHROME,
        EDGE,
        FIREFOX,
        OPERA
    }
}
