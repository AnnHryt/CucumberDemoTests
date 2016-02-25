package Pages;
import Utils.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by anastasiyahrytsyuk on 2/17/16.
 */
public class SearchResults extends BasePage{

    private String query;
    private By productListInput=By.xpath(".//*[@id='tile-container']/div/div/div/h4/a");

    public SearchResults(String query) {
        init();

    }

    public List<String> getProducts() {
        List<String> products = new ArrayList<String>();
        List<WebElement> productList = WebDriverHolder.getDriver().findElements(productListInput);
        for(int i=1; i<=productList.size(); i++)
            products.add(WebDriverHolder.getDriver().findElement(By.xpath(".//*[@id='tile-container']/div["+i+"]/div/div/h4/a")).getText().trim());
        return products;
    }

}