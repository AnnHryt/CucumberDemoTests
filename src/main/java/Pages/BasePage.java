package Pages;

import Utils.WebDriverHolder;
import Utils.WebElementWait;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by anastasiyahrytsyuk on 2/17/16.
 */

public abstract class BasePage {


    protected static final String baseURL="http://www.walmart.com/";
    private String pageTitle =
            "Walmart.com: Save money. Live better.";

    private static final String HTTPS = "https://";
    public static final int PAGE_LOADING_TIMEOUT = 60;

    public WebElementWait wait=new WebElementWait();
    public BasePage() {
        init();
    }

    public void init() {
        PageFactory.initElements(WebDriverHolder.getDriver(), this);
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public boolean isCurrent() {
        return (this.isCurrentByURL() && this.isCurrentByTitle());
    }

    public boolean isCurrentByURL() {
        String actual = getCurrentPageUrl();
        String expected = getPageURL();
        if (actual.equals(expected))
            return true;
        return false;
    }

    public boolean isCurrentByTitle() {
        String actual = getCurrentPageTitle();
        String expected = getPageTitle();
        if (actual.equals(expected))
            return true;
        return false;
    }

    public String getCurrentPageUrl() {
        return WebDriverHolder.getDriver().getCurrentUrl();
    }
    public boolean isSecure() {
        return getCurrentPageUrl().startsWith(HTTPS);
    }

    public String getCurrentPageTitle() {
        return WebDriverHolder.getDriver().getTitle();
    }

    public void open()
    {
        WebDriverHolder.getDriver().get(getPageURL());
        WebDriverHolder.getDriver().manage().window().maximize();
    }

    public  String getPageURL() {
        return baseURL;
    }

    public void refresh() {
        WebDriverHolder.getDriver().navigate().refresh();
    }

    protected int getTimeout() {
        return PAGE_LOADING_TIMEOUT;
    }
}



