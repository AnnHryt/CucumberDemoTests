package Pages;

import Utils.WebDriverHolder;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by anastasiyahrytsyuk on 2/17/16.
 */

    public abstract class BasePage {


        protected static final String baseURL ="https://www.walmart.com/";
        protected String pageTitle=
                "Walmart.com: Save money. Live better.";

        public BasePage() {
            init();

        }

        public void init() {
            PageFactory.initElements(WebDriverHolder.getDriver(), this);
        }

        public boolean isCurrent() {
            String actual = getCurrentPageUrl();
            String expected = getUrl();
            if(actual.equals(expected))
                return true;
            else return false;
        }

        public String getCurrentPageUrl() {
            return WebDriverHolder.getDriver().getCurrentUrl();
        }

        public String getTitle() {
            return pageTitle;
        }

        public String getUrl() {
            return baseURL;
        }

        public void refresh() {
            WebDriverHolder.getDriver().navigate().refresh();
        }
    }



