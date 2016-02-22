package Pages;

import Fragments.WishListFragment;
import Utils.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by anastasiyahrytsyuk on 2/18/16.
 */
public class CreateWishListPage extends BasePage {

    private static final String pageURL = "cp/1230541";
    protected String pageTitle = "Walmart Wish Lists - Walmart.com";

    WishListFragment wishListFragment =new WishListFragment();

    public CreateWishListPage(){
        init();
    }

    @Override
    public String getPageTitle() {
        return pageTitle;
    }

    @Override
    public String getPageURL() {
        return baseURL+pageURL;
    }

    public void enterWishListName(String wlName)
    {
        wishListFragment.enterWishListName(wlName);

    }

    public void selectWishListTheme(String wlTheme)
    {
        wishListFragment.selectWishListTheme(wlTheme);
    }

    public WishListPage clickCreateWishList()
    {
        wishListFragment.clickCreateWishList();
        return new WishListPage();
    }

    public boolean isWishListNameDisplayed(String wlName) {
        if (wishListFragment.isWishListPresent(wlName))
            return true;
        return false;
    }

}
