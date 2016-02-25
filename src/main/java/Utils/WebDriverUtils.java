package Utils;

import org.openqa.selenium.WebElement;

/**
 * Created by anastasiyahrytsyuk on 2/24/16.
 */
public class WebDriverUtils {

    public void switchToIFrame(WebElement iFrame) {
        WebDriverHolder.getDriver().switchTo().frame(iFrame);
    }

    public void switchToDefaultContent() {
        WebDriverHolder.getDriver().switchTo().defaultContent();
    }
}
