package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by anastasiyahrytsyuk on 2/19/16.
 */
public class WishListPage extends BasePage {

    private String pageURL = "lists/manage-wish-list-items?id=";
    protected String pageTitle = "See what I want most from Walmart!";

    @FindBy(how = How.CSS, using = ".heading-c")
    private WebElement wishListName;

    String wlName;
    String wlTheme;

    public WishListPage() {
        init();
    }
   // @Override
//    public String getPageURL() {
//        //TBD:  pageURL depends on id of the created wish list
//        return baseURL+pageURL;
//    }

    @Override
    public String getPageTitle() {
        return pageTitle;
    }

    public boolean isWishListNameDisplayed(String wlName) {
        wait.waitForElementToAppear(wishListName);
        String name=wishListName.getText().trim();
        if (wlName != null && wlName.equals(name))
            return true;
        return false;
    }


}
