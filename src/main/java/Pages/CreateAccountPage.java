package Pages;

import Utils.WebDriverHolder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by anastasiyahrytsyuk on 2/17/16.
 */
public class CreateAccountPage extends BasePage{


    private static final String pageURL = "account/signup";
    protected String pageTitle = "Walmart";

    @FindBy(how = How.ID, using = "firstname")
    private WebElement firstName;

    @FindBy(how = How.ID, using = "lastname")
    private WebElement lastName;

    @FindBy(how = How.ID, using = "email")
    private WebElement email;

    @FindBy(how = How.ID, using = "password")
    private WebElement password;

    @FindBy(how = How.ID, using = "confirm_password")
    private WebElement confirmPassword;

    @FindBy(how = How.CSS, using = ".js-sign-up")
    private WebElement buttonCreateAccount;

    @FindBy(how = How.CSS, using = ".col12")
    private WebElement emailMe;

    @FindBy(how = How.CSS, using = "input#firstname+ul")
    private WebElement firstNameValidationMsg;

    @FindBy(how = How.CSS, using = "input#lastname+ul")
    private WebElement lastNameValidationMsg;

    @FindBy(how = How.CSS, using = "input#password+ul>li")
    private WebElement passValidationMsg;

    @FindBy(how = How.CSS, using = "input#confirm_password+ul>li")
    private WebElement confirmPassValidationMsg;

    @FindBy(how = How.CSS, using = "input#email+ul>li")
    private WebElement emailValidationMsg;


    public CreateAccountPage(){
        init();
    }

    @Override
    public String getUrl() {
        return baseURL+pageURL;
    }

    @Override
    public boolean isCurrent() {
        String actual = WebDriverHolder.getDriver().getCurrentUrl();
        String expected = getUrl();
        if(actual.equals(expected))
            return true;
        else return false;
    }

    @Override
    public void init() {
        PageFactory.initElements(WebDriverHolder.getDriver(), this);
    }

    public void openCreateAccountPage() {
        WebDriverHolder.getDriver().get(baseURL + pageURL);
        WebDriverHolder.getDriver().manage().window().maximize();
    }

    public void enterFirstName(String firstName)

    {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
    }
    public void enterLastName(String lastName)
    {
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }
    public void enterPassword(String password)
    {
        this.password.clear();
        this.password.sendKeys(password);
    }
    public void confirmPassword(String password)
    {
        this.confirmPassword.clear();
        this.confirmPassword.sendKeys(password);
    }
    public void enterEmail(String email)
    {
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void submitNewAccountDetails()
    {
        buttonCreateAccount.click();
    }

    public boolean isDisplayedValidationMsgEmail()
    {
        if((emailValidationMsg.getText())!=null)
            return true;
        else return false;
    }

    public String getEmailValidationMsgText()
    {
        return emailValidationMsg.getText().trim();
    }

    public String getEmailValidationEmptyMsgText()
    {
        return emailValidationMsg.getText().trim();
    }
    public String getFirstNameValidationMsgText()
    {
        return firstNameValidationMsg.getText().trim();
    }

    public String getLasttNameValidationMsgText()
    {
        return lastNameValidationMsg.getText().trim();
    }

    public String getPasswordValidationMsgText()
    {
        return passValidationMsg.getText().trim();
    }

    public String getConfirmPasswordValidationMsgText()
    {
        return confirmPassValidationMsg.getText().trim();
    }

    public String getPasswordValue() {
        return password.getAttribute("value");
    }

    public String getConfirmPasswordValue() {
        return confirmPassword.getAttribute("value");
    }
}

