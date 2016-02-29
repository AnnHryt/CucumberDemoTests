package Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * Created by anastasiyahrytsyuk on 2/17/16.
 */
public class BrowserFactory {

    private BrowserFactory() {
    }

    private static String readConfigBrowser() {

        Properties properties = new Properties();
        InputStream inputStream =
                BrowserFactory.class.getClassLoader().getResourceAsStream("config.properties");

        try {
            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("browser");
    }

    public static WebDriver getDriver() {

        String browserName = readConfigBrowser();
        switch (browserName) {
            case "CHROME": {
                URL url = BrowserFactory.class.getClassLoader().getResource("chromedriver");
                System.setProperty("webdriver.chrome.driver", url.getPath());
                return new ChromeDriver();

            }
            case "FF": {
                return new FirefoxDriver();
            }

            default:
                return new FirefoxDriver();
        }
    }
}