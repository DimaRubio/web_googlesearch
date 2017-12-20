import common.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GooglePage;
import pages.HomePage;

public class SearchIdeals extends AbstractTest {
    HomePage homePage;
    GooglePage googlePage;

    @BeforeClass
    public void beforeTest() {
        homePage = new HomePage(driver);
        googlePage = new GooglePage(driver);
    }

    @Test
    public void searchIDealsTest() {
        googlePage.open("https://www.google.com.ua/");
        googlePage.search("iDeals");
        googlePage.itemContainsLink("https://www.idealsvdr.com/");
        Assert.assertEquals("#70a429", homePage.getTextColor(homePage.logInButton));
        Assert.assertEquals("#ffffff", homePage.getTextColor(homePage.signUpButton));
        Assert.assertEquals("#70a429", homePage.getBackGroundColor(homePage.signUpButton));
        Assert.assertTrue(homePage.getTitle().contains("Virtual Data Rooms | Secure Data Room Provider"));

    }
}
