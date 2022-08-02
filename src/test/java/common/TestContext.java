package common;

import UtilAll.DriverManager;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private final WebDriver driver;
    private final Map<String, Object> contextList = new HashMap<>();

    public TestContext() {
        driver = new DriverManager().createInstance("chrome");
    }

    public Object getContext(String key) {
        return contextList.get(key);
    }

    public WebDriver getDriver(){
        return driver;
    }
}
