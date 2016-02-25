package Fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static Utils.WebDriverHolder.getDriver;

/**
 * Created by anastasiyahrytsyuk on 2/18/16.
 */
public class WishListFragment extends BaseFragment {

   @FindBy(how = How.XPATH, using = "//div[contains(@data-zone,'zone1')]//iframe")
   private WebElement rootElement;

   private By elementRootInput=By.xpath("//div[contains(@data-zone,'zone1')]//iframe");
   private By elementNameInput = By.cssSelector(".FloatLabel-control.form-control.parsley-validated");
   private By elementThemeInput = By.cssSelector(".chooser-option-list");
   private By wishListThemesInput = By.tagName("button");
   private By createButton = By.cssSelector(".btn.lr-create-a-list-btn.btn-block");
   private By createdWishLists=By.cssSelector(".lr-short-list>ul>li>a");

    public WishListFragment()
    {
        initFragment();
    }

    private WebElement getElementWishListName() {
        return getDriver().findElement(elementNameInput);
    }
    public void enterWishListName(String wlName)
    {
        utils.switchToIFrame(rootElement);
        WebElement wishListName =getElementWishListName();
        wishListName.sendKeys(wlName);
        utils.switchToDefaultContent();
    }
    private WebElement getElementWishListTheme() {
        return getDriver().findElement(elementThemeInput);
    }

    public void selectWishListTheme(String wlTheme)
    {

       utils.switchToIFrame(rootElement);
        WebElement wishListTheme=getElementWishListTheme();
        wishListTheme.click();
        List<WebElement> options= wishListTheme.findElements(wishListThemesInput);
        for (WebElement el : options)
            if (wlTheme != null && wlTheme.equals(el.getText())) {
                el.click();
                utils.switchToDefaultContent();
                return;
            }

    }

    public void clickCreateWishList()
    {
        utils.switchToIFrame(rootElement);
        getDriver().findElement(createButton).click();
      utils.switchToDefaultContent();
    }

    private List<WebElement> getExistingWishLists()
    {
        List<WebElement> existingWishLists = getDriver().findElements(createdWishLists);
        return existingWishLists;
    }

    private List<String> getExistingWishListsNames()
    {
        utils.switchToIFrame(rootElement);
        List<WebElement> wlList = getExistingWishLists();
        List<String> wlNames=new ArrayList<String>();
        for(WebElement el: wlList)
        {
            wlNames.add(el.getText().trim());
        }
        utils.switchToDefaultContent();
        return wlNames;
    }

    public boolean isWishListPresent(String wlName)
    {
        List<String> wlNames=getExistingWishListsNames();
        if(wlNames.contains(wlName))
            return true;

        return false;
    }

    public void waitForShown() {
        wait.waitForAWhile(3000);
    }

}
