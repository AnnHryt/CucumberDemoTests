package Steps;

import Pages.CreateWishListPage;
import Pages.WishListPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by anastasiyahrytsyuk on 2/18/16.
 */
public class WishListSteps extends BaseSteps {

    CreateWishListPage createWishListPage = new CreateWishListPage();
    WishListPage wishListPage=new WishListPage();

    @Given("^I am a web site visitor$")
    public void i_am_a_web_site_visitor(){
    }

    @Given("^I want to create a wish list$")
    public void i_want_to_create_a_wish_list(){
        createWishListPage.open();
    }

    @When("^I enter a wish list name \"(.*?)\"$")
    public void i_enter_a_wish_list_name(String wishListName)   {

        createWishListPage.enterWishListName(wishListName);
    }

    @When("^I select a theme \"(.*?)\"$")
    public void i_select_a_theme(String theme)  {
        createWishListPage.selectWishListTheme(theme);
    }

    @When("^select create a wish list$")
    public void select_create_a_wish_list() {
        wishListPage=createWishListPage.clickCreateWishList();
    }

    @Then("^a new wish list \"(.*?)\" is created$")
    public void a_new_wish_list_is_created(String wishListName)  {
        assertThat(wishListPage.isWishListNameDisplayed(wishListName), is(true));
        createWishListPage.open();
        assertThat(createWishListPage.isWishListNameDisplayed(wishListName), is(true));
    }


}
