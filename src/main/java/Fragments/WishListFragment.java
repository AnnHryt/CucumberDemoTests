package Fragments;

import Utils.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anastasiyahrytsyuk on 2/18/16.
 */
public class WishListFragment extends BaseFragment {

   @FindBy(how = How.XPATH, using = "//div[contains(@data-zone,'zone1')]//iframe")
   private WebElement rootElement;

   private By elementNameInput = By.cssSelector(".FloatLabel-control.form-control.parsley-validated");
   private By elementThemeInput = By.cssSelector(".chooser-option-list");
   private By wishListThemesInput = By.tagName("button");
   private By createButton = By.cssSelector(".btn.lr-create-a-list-btn.btn-block");
   //private By createdWishLists=By.partialLinkText("/lists/manage-wish-list-items?id");
   private By createdWishLists=By.cssSelector(".lr-short-list>ul>li>a");

    public WishListFragment()
    {
        initFragment();

    }

    public WebElement getElementWishListName() {
        return  WebDriverHolder.getDriver().findElement(elementNameInput);
    }
    public void enterWishListName(String wlName)
    {
        WebDriverHolder.getDriver().switchTo().frame(rootElement);
        WebElement wishListName =getElementWishListName();
        wishListName.sendKeys(wlName);
        WebDriverHolder.getDriver().switchTo().defaultContent();
    }
    public WebElement getElementWishListTheme() {
        return WebDriverHolder.getDriver().findElement(elementThemeInput);
    }

    public void selectWishListTheme(String wlTheme)
    {

        WebDriverHolder.getDriver().switchTo().frame(rootElement);
        WebElement wishListTheme=getElementWishListTheme();
        wishListTheme.click();
        List<WebElement> options= wishListTheme.findElements(wishListThemesInput);
        for (WebElement el : options)
            if (wlTheme != null && wlTheme.equals(el.getText())) {
                el.click();
                WebDriverHolder.getDriver().switchTo().defaultContent();
                return;
            }

    }

    public void clickCreateWishList()
    {
        WebDriverHolder.getDriver().switchTo().frame(rootElement);
        WebDriverHolder.getDriver().findElement(createButton).click();
        WebDriverHolder.getDriver().switchTo().defaultContent();
    }

    private List<WebElement> getExistingWishLists()
    {
        List<WebElement> existingWishLists = WebDriverHolder.getDriver().findElements(createdWishLists);
        return existingWishLists;
    }

    private List<String> getExistingWishListsNames()
    {
        WebDriverHolder.getDriver().switchTo().frame(rootElement);
        List<WebElement> wlList = getExistingWishLists();
        List<String> wlNames=new ArrayList<String>();
        for(WebElement el: wlList)
        {
            wlNames.add(el.getText().trim());
        }
        WebDriverHolder.getDriver().switchTo().defaultContent();
        return wlNames;
    }

    public boolean isWishListPresent(String wlName)
    {
        List<String> wlNames=getExistingWishListsNames();
        if(wlNames.contains(wlName))
            return true;

        return false;
    }
}
