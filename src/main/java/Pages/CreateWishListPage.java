package Pages;

import Fragments.WishListFragment;
import Utils.WebDriverHolder;

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

    @Override
    public void open() {
        WebDriverHolder.getDriver().get(getPageURL());
        WebDriverHolder.getDriver().manage().window().maximize();
        wishListFragment.waitForShown();
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
