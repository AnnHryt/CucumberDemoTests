package Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.UnreachableBrowserException;

/**
 * Created by anastasiyahrytsyuk on 2/17/16.
 */
public class WebDriverHolder {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                driver = BrowserFactory.getDriver();
                driver.manage().deleteAllCookies();
            } finally {
                Runtime.getRuntime().addShutdownHook(
                        new Thread(new BrowserCleanup()));
            }
        }
        return driver;
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }

    }

    public static synchronized void close() {
        if (driver != null) {
            getDriver().close();
            getDriver().quit();
            driver = null;
        }
    }

}
