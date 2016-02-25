package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by anastasiyahrytsyuk on 2/17/16.
 */
public class HomePage extends BasePage {

    protected static final String pageTitle="Walmart.com: Save money. Live better.";

    public HomePage()
    {
        init();
    }

    @Override
    public String getPageTitle() {
        return pageTitle;
    }

    public Search Search() {
        Search search = new Search();
        return search;
    }

}
