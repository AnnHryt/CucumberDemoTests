package Fragments;

import Utils.WebDriverHolder;
import Utils.WebElementWait;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by anastasiyahrytsyuk on 2/18/16.
 */
public abstract class BaseFragment {

    public BaseFragment() {
        initFragment();

    }
    public WebElementWait wait=new WebElementWait();
    public void initFragment() {
        PageFactory.initElements(WebDriverHolder.getDriver(), this);
    }

}