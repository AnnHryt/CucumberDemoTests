package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by anastasiyahrytsyuk on 2/17/16.
 */
public class Search extends BasePage{

    @FindBy(how = How.ID, using = "search")
    private WebElement searchField;

    @FindBy(how = How.CSS, using = ".searchbar-submit")
    private WebElement searchButton;

    Search()
    {
        init();
    }

    public SearchResults searchFor(String query)
    {
        searchField.sendKeys(query);
        searchButton.click();
        return new SearchResults(query);
    }
}
