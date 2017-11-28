package common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class AbstractTest {
    static protected WebDriver driver;

    @BeforeTest
    public static void before() {
        driver = WebDriverUtils.getCurrentDriver();
    }

    @AfterTest
    public static void after() {
        driver.quit();
    }
}
