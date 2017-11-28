package pages;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title=\"Log In\"]")
    public WebElement logInButton;

    @FindBy(xpath = "//a[@title=\"Sign Up\"]")
    public WebElement signUpButton;

    public String getTextColor(WebElement el){
        String color = el.getCssValue("color");
        return convertRGBtoHEX(color);
    }

    public String getBackGroundColor(WebElement el){
        String color = el.getCssValue("background-color");
        return convertRGBtoHEX(color);
    }

    private String convertRGBtoHEX(String color) {
        //  RGB to HEX
        String arrayRGBColor[];
        arrayRGBColor = color.replace("rgba(", "").split(",");
        String colorHex = String.format("#%02x%02x%02x", Integer.parseInt(arrayRGBColor[0].trim()), Integer.parseInt(arrayRGBColor[1].trim()), Integer.parseInt(arrayRGBColor[2].trim()));
        return colorHex;
    }

}
