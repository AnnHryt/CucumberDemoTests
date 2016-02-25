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

    private static final int DEFAULT_TIMEOUT_SECONDS = 30;
    private static final int POLLING_TIME_SECONDS=5;

    public void waitForElementToBeClickable(WebElement element) {

       FluentWait<WebDriver> wait= getFluentWait();
       wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeClickable(By locator) {

        FluentWait<WebDriver> wait= getFluentWait();
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForFrameToBeAvailableAndSwitchToIt(By frameLocator) {

        FluentWait<WebDriver> wait= getFluentWait();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public void waitForElementToAppear(WebElement element) {

        FluentWait<WebDriver> wait= getFluentWait();
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitForElementToAppear(By locator) {

        FluentWait<WebDriver> wait= getFluentWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return WebDriverHolder.getDriver().findElement(locator);
    }

    public void waitForPageToLoad() {

        FluentWait<WebDriver> wait= getFluentWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("html")));
    }

    private FluentWait getFluentWait() {
        return new FluentWait<WebDriver>(WebDriverHolder.getDriver())
                .withTimeout(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .pollingEvery(POLLING_TIME_SECONDS, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public void waitForAWhile(int timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}