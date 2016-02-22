package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by anastasiyahrytsyuk on 2/21/16.
 */
public final class WebElementWait {

    private static final int DEFAULT_WAIT_MILLISECONDS = 30000;
    private static final int DEFAULT_SLEEP_MILLISECOND = 500;
    private static final int DEFAULT_TIMEOUT_SECONDS = 500;

    public void waitForElementToBeClickable(WebElement element) {

       FluentWait<WebDriver> wait= getFluentWait();
       wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToAppear(WebElement element) {

        FluentWait<WebDriver> wait= getFluentWait();
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitPageToLoad() {

        FluentWait<WebDriver> wait= getFluentWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("html")));
    }

    private FluentWait getFluentWait() {
        return new FluentWait<WebDriver>(WebDriverHolder.getDriver()).withTimeout(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
    }

    public void waitForAWhile(int timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    private WebDriverWait getWait() {
//        return new WebDriverWait(WebDriverHolder.getDriver(), DEFAULT_WAIT_MILLISECONDS);
//    }
//
//    private WebDriverWait getWait(int milliseconds) {
//        return new WebDriverWait(WebDriverHolder.getDriver(), milliseconds);
//    }
}