package Steps;

import Pages.CreateAccountPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by anastasiyahrytsyuk on 2/17/16.
 */
public class CreateAccountSteps {

    CreateAccountPage createAccountPage= new CreateAccountPage();


    @Given("^I want to create a new user account$")
    public void i_want_to_create_a_new_user_account()  {
        createAccountPage.openCreateAccountPage();
        assertThat(createAccountPage.isCurrent(), is(true));
    }

    @Given("^I enter \"(.*?)\" as my first name$")
    public void i_enter_as_my_first_name(String firstName) {
        createAccountPage.enterFirstName(firstName);
    }

    @Given("^I enter \"(.*?)\" as my last name$")
    public void i_enter_as_my_last_name(String lastName) throws Throwable {
        createAccountPage.enterLastName(lastName);
    }

    @Given("^I enter \"(.*?)\" as my password$")
    public void i_enter_as_my_password(String password) {
        createAccountPage.enterPassword(password);
    }

    @Given("^I enter \"(.*?)\" to confirm my password$")
    public void i_enter_to_confirm_my_password(String password) {
        createAccountPage.confirmPassword(password);
    }

    @Given("^I enter \"(.*?)\" as my email$")
    public void i_enter_as_my_email(String email) {
        createAccountPage.enterEmail(email);
    }

    @Then("^I see a message \"(.*?)\" informing me to enter a correct email$")
    public void i_see_a_message_informing_me_to_enter_a_correct_email(String msgEmail) {
        assertThat(createAccountPage.isDisplayedValidationMsgEmail(), is(true));
        assertThat(createAccountPage.getEmailValidationMsgText(), is(msgEmail));
    }

    @Then("^user account is not created$")
    public void user_account_is_not_created() {
        assertThat(true, is(createAccountPage.isCurrent()));
    }

    @Then("^I see a message \"(.*?)\" informing me to enter the correct first name$")
    public void i_see_a_message_informing_me_to_enter_the_correct_first_name(String msgFirstName) {
        assertThat(createAccountPage.getFirstNameValidationMsgText(), is(msgFirstName));
    }

    @Then("^I see a message \"(.*?)\" informing me to enter the correct last name$")
    public void i_see_a_message_informing_me_to_enter_the_correct_last_name(String msgLastName){
        assertThat(createAccountPage.getLasttNameValidationMsgText(), is(msgLastName));
    }

    @When("^I select create account option$")
    public void i_select_create_account_option() {
        createAccountPage.submitNewAccountDetails();
    }

    @Then("^I see the message informing me to enter a valid password \"(.*?)\"$")
    public void i_see_the_message_informing_me_to_enter_a_valid_password(String msgPassword) {
        assertThat(createAccountPage.getPasswordValidationMsgText(), is(msgPassword));
    }

    @Given("^the passwords entered do not match$")
    public void the_passwords_entered_do_not_match()  {
        assertNotEquals(createAccountPage.getPasswordValue(), createAccountPage.getConfirmPasswordValue());
    }

    @Then("^I see the message informing me that passwords do not match \"(.*?)\"$")
    public void i_see_the_message_informing_me_that_passwords_do_not_match(String msgPassDoNotMatch)   {
        assertThat(createAccountPage.getConfirmPasswordValidationMsgText(), is(msgPassDoNotMatch));
    }

    @Given("^I do not enter a first name$")
    public void i_do_not_enter_a_first_name() {
        createAccountPage.enterFirstName("");
    }

    @Given("^I do not enter a last name$")
    public void i_do_not_enter_a_last_name()  {
        createAccountPage.enterLastName("");
    }

    @Given("^I do not enter an email$")
    public void i_do_not_enter_an_email() {
        createAccountPage.enterEmail("");
    }

    @Given("^I do not enter a password$")
    public void i_do_not_enter_a_password() {
        createAccountPage.enterPassword("");
    }

    @Given("^I do not confirm password$")
    public void i_do_not_confirm_password()  {
        createAccountPage.confirmPassword("");
    }

    @Then("^I see a message \"(.*?)\" informing me to enter each required detail$")
    public void i_see_a_message_informing_me_to_enter_each_required_detail(String msgRequiredDetails)  {
        assertThat(createAccountPage.getFirstNameValidationMsgText(), is(msgRequiredDetails));
        assertThat(createAccountPage.getLasttNameValidationMsgText(), is(msgRequiredDetails));
        assertThat(createAccountPage.getPasswordValidationMsgText(), is(msgRequiredDetails));
        assertThat(createAccountPage.getConfirmPasswordValidationMsgText(), is(msgRequiredDetails));
        assertThat(createAccountPage.getEmailValidationEmptyMsgText(), is(msgRequiredDetails));
    }

}
