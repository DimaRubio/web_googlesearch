package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverUtils {

    private static WebDriver driver;
    private static final String CHROME_BROWSER = "chrome";
    private static final String SELENIUM_BROWSER = "selenium.browser";

    public synchronized static WebDriver getCurrentDriver() {
        WebDriverUtils webDriverUtils = new WebDriverUtils();
        String seleniumBrowser = System.getProperty(SELENIUM_BROWSER);
        if (driver == null) {
            driver = webDriverUtils.getLocalDriver(seleniumBrowser);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    private WebDriver getLocalDriver(String seleniumBrowser) {
        switch (seleniumBrowser) {
            case CHROME_BROWSER:
                return createChromeDriver();
            default:
                return createFirefoxDriver();
        }
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        return new FirefoxDriver();
    }
}
