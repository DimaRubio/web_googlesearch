package pages;

import common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;

public class GooglePage extends AbstractPage {
    public GooglePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    public void search(String request){
        searchField.sendKeys(request);
        searchField.sendKeys(Keys.ENTER);
    }

    public void itemContainsLink(String link){
        driver.findElement(By.xpath("//a[@href=\""+link+"\"]")).click();
    }

}
