package Pages;

import Utils.WebDriverHolder;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertTrue;

/**
 * Created by anastasiyahrytsyuk on 2/17/16.
 */
public class HomePage extends BasePage {

    protected static final String title="Walmart.com: Save money. Live better.";

    @FindBy(how = How.ID, using = "search")
    private WebElement searchField;

    public HomePage()
    {
        init();
    }
    @Override
    public void init() {
        PageFactory.initElements(WebDriverHolder.getDriver(), this);
    }

    public void isLoaded() {
        assertTrue(WebDriverHolder.getDriver().getTitle().equals(title));
    }

    public void openHomePage() {
        WebDriverHolder.getDriver().get(baseURL);
        WebDriverHolder.getDriver().manage().window().maximize();
    }

    public Search Search() {
        Search search = new Search();
        return search;
    }

}
