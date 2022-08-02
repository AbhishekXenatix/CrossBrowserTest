package UtilAll;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.TimeUnit;

public class CrossBrowser {

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            
        }else {
            throw new Exception("Browser is not correct");
        }

    }

    @Test
    public void testPass(){
        driver.get("https://www.epam.com/");
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.xpath("//a[@class='top-navigation__item-link'][normalize-space()='Careers']"))).build().perform();

        WebElement ele = driver.findElement(By.xpath("//a[@class='top-navigation__main-link'][normalize-space()='Join our Team']"));
        actions.moveToElement(ele).build().perform();
        ele.click();
    }

    @Test
    public void testPass1(){
        driver.get("https://www.epam.com/");
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.xpath("//a[@class='top-navigation__item-link'][normalize-space()='Careers']"))).build().perform();

        WebElement ele = driver.findElement(By.xpath("//a[@class='top-navigation__main-link'][normalize-space()='Join our Team']"));
        actions.moveToElement(ele).build().perform();
        ele.click();
    }


}
