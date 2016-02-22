package Pages;

import Utils.WebDriverHolder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by anastasiyahrytsyuk on 2/19/16.
 */
public class WishListPage extends BasePage {

    private static final String pageURL = "lists/manage-wish-list-items?id=";
    //protected String pageTitle = "Walmart Wish Lists - Walmart.com";

    @FindBy(how = How.CSS, using = ".heading-c")
    private WebElement wishListName;

    String wlName;
    String wlTheme;

    public WishListPage() {
        init();
    }

    public boolean isWishListNameDisplayed(String wlName) {
        wait.waitForElementToAppear(wishListName);
        String name=wishListName.getText().trim();
        if (wlName != null && wlName.equals(name))
            return true;
        return false;
    }


}
